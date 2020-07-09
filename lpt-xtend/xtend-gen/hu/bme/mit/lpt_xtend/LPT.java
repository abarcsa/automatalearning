package hu.bme.mit.lpt_xtend;

import hu.bme.mit.lpt.LPTLoopedNode;
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.lpt.LPTUnloopedNode;
import hu.bme.mit.lpt.LptFactory;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class LPT {
  protected LPTRootNode root;
  
  protected Set<String> inputAlphabet;
  
  public LPT(final LPTRootNode node) {
    this.root = node;
    this.inputAlphabet = this.getInputAlphabetBFS();
  }
  
  public String getOutput(final List<? extends String> input) {
    try {
      LPTRootNode node = this.root;
      for (final String in : input) {
        node = this.traverse(node, in);
      }
      if ((!(node instanceof LPTUnloopedNode))) {
        throw new Exception("Tree is not valid!");
      }
      return ((LPTUnloopedNode) node).getOutput();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Set<String> getInputAlphabet() {
    return this.inputAlphabet;
  }
  
  public LPTRootNode getRoot() {
    return this.root;
  }
  
  public LPTRootNode addSequence(final List<? extends String> input, final String output) {
    try {
      LPTRootNode _xblockexpression = null;
      {
        LPTRootNode node = this.root;
        for (int i = 0; (i < (input.size() - 1)); i++) {
          node = this.traverse(node, input.get(i));
        }
        int _size = input.size();
        int _minus = (_size - 1);
        boolean _containsKey = node.getChildren().containsKey(input.get(_minus));
        if (_containsKey) {
          throw new Exception("Sequence already exists!");
        }
        LPTUnloopedNode newNode = LptFactory.eINSTANCE.createLPTUnloopedNode();
        newNode.setOutput(output);
        int _size_1 = input.size();
        int _minus_1 = (_size_1 - 1);
        _xblockexpression = node.getChildren().put(input.get(_minus_1), newNode);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private LPTRootNode _traverse(final LPTRootNode node, final String character) {
    try {
      boolean _containsKey = node.getChildren().containsKey(character);
      boolean _not = (!_containsKey);
      if (_not) {
        throw new Exception("Invalid input character!");
      }
      return node.getChildren().get(character);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private LPTRootNode _traverse(final LPTLoopedNode node, final String character) {
    try {
      final LPTRootNode actNode = node.getLoop();
      boolean _containsKey = actNode.getChildren().containsKey(character);
      boolean _not = (!_containsKey);
      if (_not) {
        throw new Exception("Invalid input character!");
      }
      return actNode.getChildren().get(character);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private HashSet<String> getInputAlphabetBFS() {
    Deque<LPTRootNode> queue = new LinkedList<LPTRootNode>();
    HashSet<String> inputAlphabet = new HashSet<String>();
    HashSet<Map.Entry<String, LPTRootNode>> visited = new HashSet<Map.Entry<String, LPTRootNode>>();
    queue.add(this.root);
    while ((!queue.isEmpty())) {
      {
        LPTRootNode curr = queue.poll();
        Set<Map.Entry<String, LPTRootNode>> _entrySet = curr.getChildren().entrySet();
        for (final Map.Entry<String, LPTRootNode> n : _entrySet) {
          {
            inputAlphabet.add(n.getKey());
            boolean _contains = visited.contains(n);
            if (_contains) {
              throw new IllegalStateException("LPT should be a DAG!");
            } else {
              queue.add(n.getValue());
              visited.add(n);
            }
          }
        }
      }
    }
    return inputAlphabet;
  }
  
  private LPTRootNode traverse(final LPTRootNode node, final String character) {
    if (node instanceof LPTLoopedNode) {
      return _traverse((LPTLoopedNode)node, character);
    } else if (node != null) {
      return _traverse(node, character);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(node, character).toString());
    }
  }
}
