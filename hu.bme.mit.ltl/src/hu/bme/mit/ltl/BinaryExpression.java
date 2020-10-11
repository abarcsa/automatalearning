/**
 */
package hu.bme.mit.ltl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ltl.BinaryExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link hu.bme.mit.ltl.BinaryExpression#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ltl.LtlPackage#getBinaryExpression()
 * @model
 * @generated
 */
public interface BinaryExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(LTLExpression)
	 * @see hu.bme.mit.ltl.LtlPackage#getBinaryExpression_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	LTLExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ltl.BinaryExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(LTLExpression value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(LTLExpression)
	 * @see hu.bme.mit.ltl.LtlPackage#getBinaryExpression_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	LTLExpression getRightOperand();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ltl.BinaryExpression#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(LTLExpression value);

} // BinaryExpression
