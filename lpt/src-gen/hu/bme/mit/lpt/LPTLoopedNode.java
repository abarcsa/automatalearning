/**
 */
package hu.bme.mit.lpt;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LPT Looped Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.lpt.LPTLoopedNode#getLoop <em>Loop</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.lpt.LptPackage#getLPTLoopedNode()
 * @model
 * @generated
 */
public interface LPTLoopedNode extends LPTUnloopedNode {
	/**
	 * Returns the value of the '<em><b>Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' reference.
	 * @see #setLoop(LPTRootNode)
	 * @see hu.bme.mit.lpt.LptPackage#getLPTLoopedNode_Loop()
	 * @model required="true"
	 * @generated
	 */
	LPTRootNode getLoop();

	/**
	 * Sets the value of the '{@link hu.bme.mit.lpt.LPTLoopedNode#getLoop <em>Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' reference.
	 * @see #getLoop()
	 * @generated
	 */
	void setLoop(LPTRootNode value);

} // LPTLoopedNode
