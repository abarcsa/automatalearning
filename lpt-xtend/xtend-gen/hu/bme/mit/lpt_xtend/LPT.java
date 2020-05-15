package hu.bme.mit.lpt_xtend;

import hu.bme.mit.lpt.LPTLoopedNode;
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.lpt.LPTUnloopedNode;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class LPT {
  protected LPTRootNode node;
  
  public LPT(final LPTRootNode node) {
    this.node = node;
  }
  
  public String getOutput(final List<? extends String> input) {
    try {
      LPTRootNode node = null;
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
