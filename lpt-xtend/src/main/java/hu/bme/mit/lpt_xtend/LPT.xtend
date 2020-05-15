package hu.bme.mit.lpt_xtend

import hu.bme.mit.lpt.LPTRootNode
import hu.bme.mit.lpt.LPTUnloopedNode
import hu.bme.mit.lpt.LPTLoopedNode
import java.util.List

class LPT {
	protected LPTRootNode node;
	
	new(LPTRootNode node){
		this.node = node;
	}
	
	def public String getOutput(List<? extends String> input){
		var LPTRootNode node = null;
		for(String in : input){
			node = traverse(node, in);
		}
		if(!(node instanceof LPTUnloopedNode)) throw new Exception("Tree is not valid!");
		return (node as LPTUnloopedNode).getOutput();
	}
	
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
	
}