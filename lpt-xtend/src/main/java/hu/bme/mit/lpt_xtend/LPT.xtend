package hu.bme.mit.lpt_xtend

import hu.bme.mit.lpt.LPTRootNode
import hu.bme.mit.lpt.LPTUnloopedNode
import hu.bme.mit.lpt.LPTLoopedNode
import java.util.List
import java.util.Set
import java.util.HashSet
import java.util.Deque
import java.util.LinkedList
import java.util.Map.Entry

class LPT {
	protected LPTRootNode node;
	protected Set<String> inputAlphabet;
	
	new(LPTRootNode node){
		this.node = node;
		inputAlphabet = getInputAlphabetBFS();
	}
	
	def public String getOutput(List<? extends String> input){
		var LPTRootNode node = node;
		for(String in : input){
			node = traverse(node, in);
		}
		if(!(node instanceof LPTUnloopedNode)) throw new Exception("Tree is not valid!");
		return (node as LPTUnloopedNode).getOutput();
	}
	
	def public Set<String> getInputAlphabet(){ return this.inputAlphabet }
	
	//Default case for Root and Unlooped nodes
	def private dispatch traverse(LPTRootNode node, String character){
		if(!node.getChildren().containsKey(character)) throw new Exception("Invalid input character!");
		return node.getChildren().get(character);
	}
	//Looped case
	def private dispatch traverse(LPTLoopedNode node, String character){
		val actNode = node.getLoop();
		if(!actNode.getChildren().containsKey(character)) throw new Exception("Invalid input character!");
		return actNode.getChildren().get(character);
	}
	def private getInputAlphabetBFS(){
		var Deque<LPTRootNode> queue = new LinkedList
		var inputAlphabet = new HashSet
		var visited = new HashSet //just to make sure no infinite cycles arise
		queue.add(node); //from root
		while(!queue.isEmpty){
			var curr = queue.poll
			for(Entry<String, LPTRootNode> n : curr.children.entrySet){
				inputAlphabet.add(n.key);
				if(visited.contains(n)) throw new IllegalStateException("LPT should be a DAG!")
				else{
					queue.add(n.value)
					visited.add(n)
				}
			}
		}
		return inputAlphabet;
	}
	
}