package hu.bme.mit.automatalearning.datastructures;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import hu.bme.mit.automatalearning.util.Utils.BFSHelper;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTRootNode;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTUnloopedNode;

import java.util.Set;

public class LPT<I, O> {
	protected LPTRootNode<I, O> root;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
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
		LPT other = (LPT) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} 
		LPTRootNode<I, O> otherRoot = ((LPT<I, O>) obj).root;
		Deque<BFSHelper<I, O>> queue = new LinkedList<>();
		Deque<BFSHelper<I, O>> queue2 = new LinkedList<>();
		for(Entry<I, LPTRootNode<I, O>> entry : root.getChildren().entrySet()) {
			List<I> ins = new ArrayList<>();
			ins.add(entry.getKey());
			queue.add(new BFSHelper<I, O>(ins, (LPTUnloopedNode<I, O>) entry.getValue()));
			boolean found = false;
			for(Entry<I, LPTRootNode<I, O>> entry2 : otherRoot.getChildren().entrySet()) {
				if(entry.getKey().equals(entry2.getKey())) {
					found = true;
					List<I> ins2 = new ArrayList<>();
					ins2.add(entry2.getKey());
					queue2.add(new BFSHelper<I, O>(ins2, (LPTUnloopedNode<I, O>) entry2.getValue()));
				}
			}
			if(!found) return false;
		}
		while(!queue.isEmpty()) {
			BFSHelper<I, O> currElement = queue.poll();
			BFSHelper<I, O> currElement2 = queue2.poll();
			for(Entry<I, LPTRootNode<I, O>> entry : currElement.node.getChildren().entrySet()) {
				List<I> ins = currElement.currSequence;
				ins.add(entry.getKey());
				queue.add(new BFSHelper<I, O>(ins, (LPTUnloopedNode<I, O>) entry.getValue()));
				boolean found = false;
				for(Entry<I, LPTRootNode<I, O>> entry2 : currElement2.node.getChildren().entrySet()) {
					if(entry.getKey().equals(entry2.getKey())) {
						List<I> ins2 = currElement2.currSequence;
						ins2.add(entry2.getKey());
						queue2.add(new BFSHelper<I, O>(ins2, (LPTUnloopedNode<I, O>) entry2.getValue()));
						found = true;
					}
				}
				if(!found) return false;
			}
		}
		return true;
	}

	public LPT(LPTRootNode<I, O> root){
		this.root = root;
	}
	
	public O getOutput(List<? extends I> input){
		LPTRootNode<I, O> node = root;
		for(I in : input){
			node = traverse(node, in);
		}
		if(!(node instanceof LPTUnloopedNode)) throw new IllegalStateException("Tree is not valid!");
		if(((LPTUnloopedNode<I, O>)node).getData() == null) throw new RuntimeException("Output not yet provided!");
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
		LinkedList<? extends I> list = new LinkedList<>(input);
		//Traverse the already added nodes
		while(list.size() != 1) {
			if(!node.getChildren().containsKey(list.peekFirst())) {
				break;
			}
			node = traverse(node, list.pollFirst());
		}//Add new nodes
		while(!list.isEmpty()) {
			LPTUnloopedNode<I, O> newNode = new LPTUnloopedNode<I, O>(null);
			if(list.size() == 1) { //Add output
				newNode.setData(output);
			}
			node.children.put(list.pollFirst(), newNode);
			node = newNode;
		}
	}
	
	private LPTRootNode<I,O> traverse(LPTRootNode<I, O> node, I character){
		LPTRootNode<I, O> actNode;
		if(node instanceof LPTLoopedNode) {
			actNode = ((LPTLoopedNode<I, O>) node).getRef();
		}else {
			actNode = node;
		}
		if(!actNode.getChildren().containsKey(character)) throw new IllegalStateException("Invalid input character!");
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
		Map<I, LPTRootNode<I, O>> children;
		private BigInteger label;
		
		public LPTRootNode() {
			label = cnt;
			cnt.add(BigInteger.ONE);
			children = new HashMap<>();
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
