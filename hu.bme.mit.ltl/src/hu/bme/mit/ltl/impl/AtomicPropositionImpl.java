/**
 */
package hu.bme.mit.ltl.impl;

import hu.bme.mit.ltl.AtomicProposition;
import hu.bme.mit.ltl.LtlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Proposition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ltl.impl.AtomicPropositionImpl#getProposition <em>Proposition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AtomicPropositionImpl extends BooleanExpressionImpl implements AtomicProposition {
	/**
	 * The default value of the '{@link #getProposition() <em>Proposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProposition()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPOSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProposition() <em>Proposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProposition()
	 * @generated
	 * @ordered
	 */
	protected String proposition = PROPOSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicPropositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LtlPackage.Literals.ATOMIC_PROPOSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProposition() {
		return proposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProposition(String newProposition) {
		String oldProposition = proposition;
		proposition = newProposition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LtlPackage.ATOMIC_PROPOSITION__PROPOSITION, oldProposition, proposition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LtlPackage.ATOMIC_PROPOSITION__PROPOSITION:
				return getProposition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LtlPackage.ATOMIC_PROPOSITION__PROPOSITION:
				setProposition((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LtlPackage.ATOMIC_PROPOSITION__PROPOSITION:
				setProposition(PROPOSITION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LtlPackage.ATOMIC_PROPOSITION__PROPOSITION:
				return PROPOSITION_EDEFAULT == null ? proposition != null : !PROPOSITION_EDEFAULT.equals(proposition);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (proposition: ");
		result.append(proposition);
		result.append(')');
		return result.toString();
	}

} //AtomicPropositionImpl
