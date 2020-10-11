/**
 */
package hu.bme.mit.ltl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Proposition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ltl.AtomicProposition#getProposition <em>Proposition</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ltl.LtlPackage#getAtomicProposition()
 * @model
 * @generated
 */
public interface AtomicProposition extends BooleanExpression, NullaryExpression {
	/**
	 * Returns the value of the '<em><b>Proposition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposition</em>' attribute.
	 * @see #setProposition(String)
	 * @see hu.bme.mit.ltl.LtlPackage#getAtomicProposition_Proposition()
	 * @model
	 * @generated
	 */
	String getProposition();

	/**
	 * Sets the value of the '{@link hu.bme.mit.ltl.AtomicProposition#getProposition <em>Proposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proposition</em>' attribute.
	 * @see #getProposition()
	 * @generated
	 */
	void setProposition(String value);

} // AtomicProposition
