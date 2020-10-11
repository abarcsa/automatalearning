/**
 */
package hu.bme.mit.ltl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ltl.UnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ltl.LtlPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(LTLExpression)
	 * @see hu.bme.mit.ltl.LtlPackage#getUnaryExpression_Operand()
	 * @model containment="true"
	 * @generated
	 */
	LTLExpression getOperand();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ltl.UnaryExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(LTLExpression value);

} // UnaryExpression
