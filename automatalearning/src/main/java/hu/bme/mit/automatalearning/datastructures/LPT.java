package hu.bme.mit.automatalearning.datastructures;

import java.math.BigInteger;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LPT<I, O> {
	protected LPTRootNode<I, O> root;
	
	public LPT(LPTRootNode<I, O> root){
		this.root = root;
	}
	
	public O getOutput(List<? extends I> input){
		LPTRootNode<I, O> node = root;
		for(I in : input){
			node = traverse(node, in);
		}
		if(!(node instanceof LPTUnloopedNode)) throw new IllegalStateException("Tree is not valid!");
		return ((LPTUnloopedNode<I, O>)node).getData();
	}
	
	public LPTRootNode<I, O> getNode(List<? extends I> input){
		LPTRootNode<I, O> node = root;
		for(I in : input){
			node = traverse(node, in);
		}
		if(!(node instanceof LPTUnloopedNode)) throw new IllegalStateException("Tree is not valid!");
		return node;
	}
	
	public Set<I> getInputAlphabet(){ return getInputAlphabetBFS(); }
	
	public LPTRootNode<I, O> getRoot(){
		return root;
	}
	
	public void addSequence(List<? extends I> input, O output){
		LPTRootNode<I, O> node = root;
		for(int i = 0; i < input.size(); i++){
			if(node.getChildren().containsKey(input.get(i))) {
				node = traverse(node, input.get(i));
			} else if (i == input.size() - 1){
				node = new LPTUnloopedNode<I, O>(output);
			} else {
				node = new LPTUnloopedNode<I, O>(null);
			}
		}
	}
	
	private LPTRootNode<I,O> traverse(LPTRootNode<I, O> node, I character){
		LPTRootNode<I, O> actNode;
		if(node instanceof LPTLoopedNode) {
			actNode = ((LPTLoopedNode<I, O>) node).getRef();
		}else {
			actNode = node;
		}
		if(!actNode.getChildren().containsKey(character)) return null;
		return actNode.getChildren().get(character);
	}

	private Set<I> getInputAlphabetBFS(){
		Deque<LPTRootNode<I, O>> queue = new LinkedList<LPTRootNode<I, O>>();
		Set<I> inputAlphabet = new HashSet<>();
		Set<LPTRootNode<I, O>> visited = new HashSet<>(); //just to make sure no infinite cycles arise
		queue.add(root); //from root
		while(!queue.isEmpty()){
			LPTRootNode<I, O> curr = queue.poll();
			for(Entry<I, LPTRootNode<I, O>> n : curr.children.entrySet()){
				inputAlphabet.add(n.getKey());
				if(visited.contains(n)) throw new IllegalStateException("LPT should be a DAG!");
				else{
					queue.add(n.getValue());
					visited.add(n.getValue());
				}
			}
		}
		return inputAlphabet;
	}
	private static BigInteger cnt = BigInteger.ZERO;
	public static class LPTRootNode<I, O>{
		Map<I, LPTRootNode<I, O>> children = new HashMap<>();
		private BigInteger label;
		
		public LPTRootNode() {
			label = cnt;
			cnt.add(BigInteger.ONE);
		}
		
		public Map<I, LPTRootNode<I, O>> getChildren() {
			return children;
		}

		public void setChildren(Map<I, LPTRootNode<I, O>> children) {
			this.children = children;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LPTRootNode other = (LPTRootNode) obj;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
		}
		
	}
	
	public static class LPTUnloopedNode<I, O> extends LPTRootNode<I, O>{
		O data;
		public LPTUnloopedNode(O data) {
			super();
			this.data = data;
		}
		public O getData() {
			return data;
		}

		public void setData(O data) {
			this.data = data;
		}
	}
	
	public static class LPTLoopedNode<I, O> extends LPTUnloopedNode<I, O>{
		LPTRootNode<I, O> ref;
		public LPTLoopedNode(LPTRootNode<I, O> ref, O data) {
			super(data);
			this.ref = ref;
		}
		public LPTRootNode<I, O> getRef() {
			return ref;
		}
		public void setRef(LPTRootNode<I, O> ref) {
			this.ref = ref;
		}
	}

}
