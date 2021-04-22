package hu.bme.mit.automatalearning.algorithm.NStar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.xtext.util.Tuples;

import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.algorithm.NDActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.datastructures.LPT;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTRootNode;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.teacher.NDTeacher;
import hu.bme.mit.automatalearning.teacher.Teacher;

public class NStarMealy<I, O, M, S, T> extends NDActiveLearningAlgorithm<I, O, DHCHypothesis<I, O, M, S, T>>{
	List<? extends I> alphabet;
	DHCHypothesis<I, O, M, S, T> hypothesis;
	public NStarMealy(NDTeacher<I, O, DHCHypothesis<I, O, M, S, T>, ?> teacher, List<? extends I> alphabet, DHCHypothesis<I, O, M, S, T> hypothesis) {
		this.teacher = teacher;
		this.alphabet = alphabet;
		this.hypothesis = hypothesis;
	}
	
	List<TD_Row<I, O>> Sm;
    List<TD_Row_Parented<I, O>> Sm_I;
    List<List<I>> Em;
	
	@Override
	public DHCHypothesis<I, O, M, S, T> execute() {
        int phase = 0;
        boolean someChange = false;

        // initialize the observation table (Sm;Em; Tm) with the sets
        // Sm = {epsilon}; Em = Sigma_i, SD.Sigma = {Epsilon.i} for all i in Sigma;
        // ask the membership queries from (SD;ED; TD) ;
        // update (SD;ED; TD) with the results of the queries ;

        initializeObservationTable();

        //* repeat until oracle replies yes to the conjecture MD
        while (true){
            someChange = false;

            boolean isTableCLosed = true;

            // while (SD;ED; TD) is not closed, not consistent do
            while (true) {
                // if (SD;ED; TD) is not closed then
                //    find anotherRow in Sm.Sigma_i  such that anotherRow  ~(Em) input, for all input in Sm
                //    move anotherRow to Sm
                //    ask output queries for the extended table
                // end
                int nc = isClosed();

                isTableCLosed = (nc == -1);

                // if we add a counterexample and the table is closed, it means that we have some extra states!
                if (isTableCLosed) break;


                someChange = false;

                // remove from Sm.Sigma AND add to Sm
                TD_Row<I,O> t = Sm_I.get(nc);
                Sm_I.remove(nc);
                Sm.add(t);

                // add anotherRow.a for each 'a' in Sigma if they are not exist there
                for(int rowOfE = 0; rowOfE < this.alphabet.size(); rowOfE++){
                    I symb = Em.get(rowOfE).get(0);
                    Tree<O> pt = t.Em_Row.get(rowOfE);

                    for(O st : pt.getRoot().edges){

                        Pair<I,O> r1 = Pair.of(symb, st);
                        List<Pair<I,O>> rl = new ArrayList<Pair<I,O>>(t.AccessString); 
                        rl.add(r1);

                        TD_Row_Parented<I,O> tdr = new TD_Row_Parented<I,O>();
                        Sm_I.add(tdr);
                        tdr.parent = t;
                        tdr.AccessString = rl;

                        // Fill the table for all suffixes in Sm_I
                        for(List<I> symb2 : Em){
                            Tree<O> tr = findOutputTree(rl, symb2);
                            tdr.Em_Row.add(tr);
                        }
                    }
                }
            }

            // ask the equivalence query for MD
            // if oracle replies with a counterexample v then
            //   add all the prefixes of v to SD
            //   ask membership queries for the extended table
            // end

            this.hypothesis = buildConjecture();
            List<? extends I> cex = teacher.equivalenceQuery(hypothesis, alphabet);
            
            if (cex == null){
            	return this.hypothesis;
            }
            
            List<Pair<I,O>> counterexample = new ArrayList<>();
            List<I> seq = new ArrayList<>();
            for(I in : cex) {
            	seq.add(in);
            	counterexample.add(Pair.of(in, teacher.membershipQuery(seq).get(0))); //TODO fix .get(0)
            }
           

            if (!counterexampleCompatibility(counterexample))
                throw new RuntimeException("Counterexample is incompatible!");

            phase++;

            //find u.v where u is (the longest word) in Sm
			int lengthOfU = 0;
            for (int i = 0; i < Sm.size(); i++){
                int l = this.prefixLength(Sm.get(i).AccessString, counterexample);
                if (l > lengthOfU){
                    lengthOfU = l;
                }
            }
            for (int i = 0; i < Sm_I.size(); i++){
                int l = this.prefixLength(Sm_I.get(i).AccessString, counterexample);
                if (l > lengthOfU){
                    lengthOfU = l;
                }
            }

            //add all suffix of v into Em
            for (int i = lengthOfU; i < counterexample.size(); i++){
                List<Pair<I,O>> pr = suffix(counterexample, counterexample.size() - i);
                // check that the suffix is already in the Em
                List<I> ins = new ArrayList<I>();
                for (int iii = 0; iii < pr.size(); iii++)
                    ins.add(pr.get(iii).getLeft());

                boolean itContains = false;
                for(List<I> ins1 : Em) {
                	if (ins.equals(ins1)){
                        itContains = true;
                        break;
                    }
                }
                    

                if (itContains)
                    continue;
                else{
                    someChange = true;
                    Em.add(ins);
                    // Fill the table for the results of this newly added suffix
                    for(TD_Row<I,O> t1 : Sm){
                        Tree<O> myTree = findOutputTree(t1.AccessString, ins);
                        t1.Em_Row.add(myTree);
                    }
                    for(TD_Row_Parented<I,O> t1 : Sm_I){
                        Tree<O> myTree = findOutputTree(t1.AccessString, ins);
                        t1.Em_Row.add(myTree);
                    }
                }
            }


            if (!someChange){
                throw new RuntimeException("Wtf!");
            }
        }
	}
		
	DHCHypothesis<I, O, M, S, T> buildConjecture(){
		hypothesis.resetHypothesis();
        S currentState, nextState;
        T tr;

        int currentRowIndex = 0;
        TD_Row<I, O> currentRow;

        // add epsilon as the initial state
        currentState = hypothesis.addInitialState("0");
        currentRow = Sm.get(0);


        List<List<Pair<I,O>>> mealyStates = new ArrayList<List<Pair<I,O>>>();
        List<Pair<I,O>> eps = new ArrayList<Pair<I,O>>();
        mealyStates.add(eps);

        //* rows that are converted to state
        List<TD_Row<I,O>> statedRow = new ArrayList<TD_Row<I,O>>();
        statedRow.add(Sm.get(0));

        // generate states breast first order
        for (currentRowIndex = 0; currentRowIndex < statedRow.size(); currentRowIndex++){
            currentRow = statedRow.get(currentRowIndex);
            currentState = hypothesis.getState(String.valueOf(currentRowIndex));

            for (int ii = 0; ii < alphabet.size(); ii++){
                I s = alphabet.get(ii);
                Tree<O> myTree = currentRow.Em_Row.get(ii);

                // for each possible output (generated by the input in the alphabet)
                for(O ne : myTree.getRoot().edges){
                    List<Pair<I,O>> p = new ArrayList<Pair<I,O>>(currentRow.AccessString);
                    p.add(Pair.of(s, ne));

                    boolean nextRowFound = false;
                    boolean stateShoudbeGenerated = true;

                    // find next row in (Sm Until SM_I)
                    for (int i = 1; i < Sm.size(); i++){
                        if (Sm.get(i).AccessString.equals(p)){
                            // Found!
                            nextRowFound = true;

                            // check that this row exists in the generated states?
                            for (int j = 0; j < statedRow.size(); j++){
                                TD_Row<I,O> r = statedRow.get(j);
                                if (r.hasSameRow(Sm.get(i))){
                                    // generate transition to this state from current state
                                	tr = hypothesis.addTransition(currentState, hypothesis.getState(String.valueOf(j)), s, ne);
                                    stateShoudbeGenerated = false;
                                    break;
                                }
                            }

                            // target state not found! a new state should be generated.
                            if (stateShoudbeGenerated){
                                statedRow.add(Sm.get(i));
                                nextState = hypothesis.createNewState(String.valueOf(hypothesis.getHypothesisStates().size()));
                                hypothesis.addTransition(currentState, nextState, s, ne);
                            }
                            break;
                        }
                    }
                    if (nextRowFound) continue;

                    // not found in Sm? No problem. So find next row (counterexample) in Sm_I
                    for (int i = 0; i < Sm_I.size(); i++)
                    {
                        if (Sm_I.get(i).AccessString.equals(p))
                        {
                            stateShoudbeGenerated = true;
                            // find that this row exists in the generated states?
                            for (int j = 0; j < statedRow.size(); j++)
                            {
                                TD_Row<I, O> r = statedRow.get(j);
                                if (r.hasSameRow(Sm_I.get(i)))
                                {
                                    // generate transition to this state from current state
                                	tr = hypothesis.addTransition(currentState, hypothesis.getState(String.valueOf(j)), s, ne);
                                    stateShoudbeGenerated = false;
                                    break;
                                }
                            }
                            if (stateShoudbeGenerated)
                            {
                                //* Found in Sm_I! Now, find a row in Sm with similar TD_row
                                for (int k = 1; k < Sm.size(); k++)
                                {
                                    TD_Row<I, O> r = Sm.get(k);
                                    if (r.hasSameRow(Sm_I.get(i)))
                                    {
                                        statedRow.add(Sm.get(k));
                                        nextState = hypothesis.createNewState(String.valueOf(hypothesis.getHypothesisStates().size()));
                                        hypothesis.addTransition(currentState, nextState, s, ne);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        return hypothesis;
    }
	
	private int prefixLength(List<Pair<I,O>> l1, List<Pair<I,O>> l2){
        int min = Math.min(l1.size(), l2.size());
        for (int i = 0; i < min; i++)
        {
            if (!l1.get(i).equals(l2.get(i)))
                return i;
        }
        return min;
    }
	
	private boolean counterexampleCompatibility(List<Pair<I,O>> counterexample)
    {
        for(TD_Row<I,O> r : Sm){
            if (!compatibleRow(r, counterexample))
                return false;
        }
        for(TD_Row<I,O> r : Sm_I){
            if (!compatibleRow(r, counterexample))
                return false;
        }
        return true;
    }
	
	private boolean compatibleRow(TD_Row<I,O> r, List<Pair<I,O>> counterexample)
    {
        //first, check compatibility of access string
        boolean match = true;
        for (int i = 0; i < r.AccessString.size(); i++){
            if (!counterexample.get(i).equals(r.AccessString.get(i))){
                match = false;
                break;
            }
        }
        if (!match)
            return true;

        int first = r.AccessString.size();

        //then, check trees
        for (int y = 0; y < Em.size(); y++){
            int last = 0;
            for (int z = 0; z < Em.get(y).size(); z++){
                if (counterexample.size() >= first + z)
                    break;

                if (!counterexample.get(first + z).getLeft().equals(Em.get(y).get(z))){
                    last = z;
                    break;
                }
            }
            if (last == 0)
                continue;
            //now, check
            if (!compatibleCell(counterexample, r.Em_Row.get(y), first, last)){
                return false;
            }
        }
        return true;
    }
	
	private List<Pair<I,O>> suffix(List<Pair<I,O>> l, int len)
    {
        List<Pair<I,O>> p = new ArrayList<Pair<I,O>>();
        for (int i = l.size() - len; i < l.size(); i++)
            p.add(l.get(i));
        return p;
    }
	
	private boolean compatibleCell(List<Pair<I,O>> counterexample, Tree<O> tr, int first, int last)
    {
        Tree<O>.TreeNode currentNode = tr.getRoot();

        for (int i = first; i < last; i++)
        {
            O o = counterexample.get(i).getRight();
            currentNode = currentNode.childByEdge(o);
            if (currentNode == null)
                return false;
        }
        return true;
    }
	
	void initializeObservationTable(){
        // initialize
        Sm = new ArrayList<TD_Row<I,O>>();
        Sm_I = new ArrayList<TD_Row_Parented<I,O>>();
        Em = new ArrayList<List<I>>();

        // 1- Em=I
        for(I symb : this.alphabet){
            List<I> eps = new ArrayList<I>();
            eps.add(symb);
            Em.add(eps);
        }

        // 2- Sm={""}
        TD_Row<I,O> r = new TD_Row<I,O>();
        r.AccessString = new ArrayList<Pair<I,O>>();
        Sm.add(r);

        // Update table
        for(I symb : this.alphabet){
            List<I> mysuf = new ArrayList<I>();
            mysuf.add(symb);

            // find output tree
            Tree<O> pt = findOutputTree(new ArrayList<Pair<I,O>>(), mysuf);

            Sm.get(0).Em_Row.add(pt);



            for(O st : pt.getRoot().edges){
                Pair<I,O> r1 = Pair.of(symb, st);
                List<Pair<I,O>> rl = new ArrayList<Pair<I,O>>(); rl.add(r1);

                TD_Row_Parented<I,O> tdr = new TD_Row_Parented<I,O>();
                Sm_I.add(tdr);
                tdr.parent = r;
                tdr.AccessString = rl;

                //* 3- add all words of Sigma into Sm_I
                for(I symb2 : this.alphabet){
                    List<I> sf = new ArrayList<I>();
                    sf.add(symb2);
                    Tree<O> tr = findOutputTree(rl, sf);
                    tdr.Em_Row.add(tr);
                }
            }
        }
    }
	
	private Tree<O> findOutputTree(List<Pair<I,O>> prefix, List<I> suffix)
    {
        //Tree<O> pt = myOracleR.FindOutputTree(prefix, suffix);
        Tree<O> mytree = new Tree<O>();
        List<Tree<O>.TreeNode> myleaves = new ArrayList<Tree<O>.TreeNode>();
        
        myleaves.add(mytree.getRoot());
        
      // for every input in the suffix
        List<I> movingSuffix = new ArrayList<>();
        for (int i = 0; i < suffix.size(); i++){
            int leavesCount = myleaves.size();
            movingSuffix.add(suffix.get(i));
            // For every node in the set of leaves
            for (int j = 0; j < leavesCount; j++)
            {
                // leaf to be processed
                Tree<O>.TreeNode myleaf = myleaves.get(0);
                myleaves.remove(0);

                // For all possible output resulting as the input
                List<I> query = new ArrayList<>();
                for(Pair<I,O> pair : prefix) {
                	query.add(pair.getLeft());
                }
                for(I s : movingSuffix) {
                	query.add(s);
                }
                List<O> outputs = teacher.membershipQuery(query);
                for(O out : outputs) {
                	Tree<O>.TreeNode child = myleaf.addChild(out);
                    myleaves.add(child);
                }
            }
        }
        
        return mytree;
    }
	
	/* HELEPER DATA STRUCTURES */
	
	
	private static class TD_Row<I, O> {
        public List<Pair<I, O>> AccessString;

        public List<Tree<O>> Em_Row;

        public TD_Row(TD_Row<I, O> r, List<Pair<I, O>> op){
            //generatedState = -1;
            if (r == null)
            {
                AccessString = new ArrayList<Pair<I, O>>();
            }
            else
            {
                if (op == null)
                {
                    AccessString = new ArrayList<Pair<I, O>>(r.AccessString);
                }
                else
                    AccessString = new ArrayList<Pair<I, O>>(op);
            }

            Em_Row = new ArrayList<Tree<O>>();

            if (r != null) {
            	for (int i = 0; i < r.Em_Row.size(); i++) {
                    Em_Row.add(r.Em_Row.get(i));
            	}
            }
        }
        public TD_Row(){
        	this(null,null);
        }

        
        int firstDifference(TD_Row<I, O> anotherRow){
            // Assume that the length of two rows are the same
            if (anotherRow.Em_Row.size() != Em_Row.size())
                throw new IllegalStateException("Size of two rows should be equal!");
            for (int i = 0; i < Em_Row.size(); i++)
                if (!Em_Row.get(i).equals(anotherRow.Em_Row.get(i))) return i;
            return -1;
        }

        public boolean hasSameRow(TD_Row<I,O> t)
        {
            return firstDifference(t) == -1;
        }

        @Override
        public String toString()
        {
            String st = "";
            for (int i = 0; i < Em_Row.size(); i++)
                st += Em_Row.get(i).toString();
            return AccessString.toString() + st;
        }
    }
	
	private static class TD_Row_Parented<I,O> extends TD_Row<I,O>{
        public TD_Row<I, O> parent;

        public TD_Row_Parented(TD_Row<I,O> r, List<Pair<I,O>> op){
        	super(r, op);
            parent = r;
        }
        public TD_Row_Parented() {
        	this(null,null);
        }
    }
	
	void AddColumn(){
        for(TD_Row<I, O> t : Sm){
            t.Em_Row.add(new Tree<O>());//a cell for output
        }
        for(TD_Row<I,O> t : Sm_I)
        {
            t.Em_Row.add(new Tree<O>());//a cell for output
        }
    }
	
	public int getTableRowSize(){
            return Sm.size() + Sm_I.size();
    }
    public int getTableColSize(){
            return Em.size();
    }
    int isClosed()
    {
        for (int i = 0; i < Sm_I.size(); i++)
        {
            TD_Row<I,O> t = Sm_I.get(i);
            boolean found = false;
            for(TD_Row <I, O> r : Sm)
            {
                if (r.hasSameRow(t))
                {
                    found = true;
                    break;
                }
            }
            // there is no equivalent row in Sm corresponding to this Sm_I row
            if (!found)
                return i;
        }
        // the table is closed
        return -1;
    }
    
    public static class Tree<D>
    {
        public class TreeNode
        {
            List<TreeNode> childs;
            List<D> edges;
            
            public TreeNode()
            {
                childs = new ArrayList<TreeNode>();
                //this.data = data;
                edges = new ArrayList<D>();
            }

            public List<D> getEdges(){
                    return edges;
            }

            public List<TreeNode> getChilds(){
                    return childs;
            }

            public int getNumberOfChilds(){
                return childs.size();
            }

            public TreeNode addChild(D edge)
            {
                TreeNode ch = new TreeNode();
                edges.add(edge);
                childs.add(ch);
                return ch;
            }

            public TreeNode childByIndex(int indx)
            {
                if (indx >= 0 && indx < getNumberOfChilds())
                    return childs.get(indx);
                else
                    return null;
            }

            public TreeNode childByEdge(D edge)
            {
                for (int i = 0; i < edges.size(); i++)
                    if (edges.get(i).equals(edge))
                        return childs.get(i);
                return null;
            }

            public boolean equalsAsTree(Tree<D>.TreeNode node2)
            {
                if (this.getNumberOfChilds() != node2.getNumberOfChilds())
                    return false;

                for (int i = 0; i < this.getNumberOfChilds(); i++)
                {
                    D ed = edges.get(i);
                    TreeNode myNode = node2.childByEdge(ed);
                    if (myNode == null) return false;
                    if (!(myNode.equalsAsTree(childs.get(i))))
                        return false;
                }
                return true;
            }

        }

        TreeNode root;

        public Tree(){
            root = new TreeNode();
        }

        public Tree(TreeNode node){
            new Exception("Not implemented");
        }

        public TreeNode getRoot(){
            return root;
        }

        /*@Override
        public String toString()
        {
            if (root == null)
                return "NULL";

            String[] tillHere = new String[20];
            int[] tmp = new int[20];
            Tree<D>.TreeNode[] tillHereNodes = new Tree<D>.TreeNode[20];

            string str = "";
            for (int i = 0; i < 20; i++)
            {
                tillHere[i] = "";
                tmp[i] = 0;
            }
            Tree<EdgeData>.TreeNode currentNode = root;
            int currentDepth = 0;

            //* find the first leaf
            while (currentNode.Edges.Count > 0)
            {
                tillHereNodes[currentDepth] = currentNode;
                tillHere[currentDepth] = currentNode.Edges[0].ToString();
                currentNode = currentNode.Childs[0];
                currentDepth++;
                if (currentDepth > 19)
                    return "Error: Max depth is 20!";
            }


            while (true)
            {
                //* reach a leaf
                if (currentNode.Edges.Count == 0)
                {
                    //* add it to the output set
                    string tmpStr = "";
                    for (int u = 0; u < currentDepth; u++)
                        tmpStr += tillHere[u] + (u == currentDepth - 1 ? "" : ",");
                    str += tmpStr;

                    //* return up to the root
                    for (int i = currentDepth; i > 0; i--)
                    {
                        tmp[i] = 0;
                        currentDepth--;
                        currentNode = tillHereNodes[currentDepth];
                        tmp[currentDepth]++;
                        if (tmp[currentDepth] < currentNode.Edges.Count)
                        {
                            //tmp[currentDepth]++;
                            break;
                        }
                    }
                    if (currentDepth == 0 && tmp[currentDepth] >= currentNode.Edges.Count)
                        break;
                    else
                        str += " + ";
                }
                //* go down in the tree
                else
                {

                    tillHereNodes[currentDepth] = currentNode;
                    tillHere[currentDepth] = currentNode.Edges[tmp[currentDepth]].ToString();

                    currentNode = currentNode.Childs[tmp[currentDepth]];
                    currentDepth++;
                    if (currentDepth > 19)
                        return "Error: Max depth is 20!";
                }
            }
            return str;
        }*/
        
        @Override
        public boolean equals(Object obj)
        {
            if (!(obj instanceof Tree))
                return false;
            Tree<D> tr = (Tree<D>)obj;
            return this.getRoot().equalsAsTree(tr.getRoot());
        }
        
        @Override
        public int hashCode()
        {
            return super.hashCode();
        }
    }
}
