/**
 */
package hu.bme.mit.lpt.impl;

import hu.bme.mit.lpt.LPTLoopedNode;
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.lpt.LptPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LPT Looped Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.lpt.impl.LPTLoopedNodeImpl#getLoop <em>Loop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LPTLoopedNodeImpl extends LPTUnloopedNodeImpl implements LPTLoopedNode {
	/**
	 * The cached value of the '{@link #getLoop() <em>Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoop()
	 * @generated
	 * @ordered
	 */
	protected LPTRootNode loop;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LPTLoopedNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LptPackage.Literals.LPT_LOOPED_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LPTRootNode getLoop() {
		if (loop != null && loop.eIsProxy()) {
			InternalEObject oldLoop = (InternalEObject) loop;
			loop = (LPTRootNode) eResolveProxy(oldLoop);
			if (loop != oldLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LptPackage.LPT_LOOPED_NODE__LOOP, oldLoop,
							loop));
			}
		}
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LPTRootNode basicGetLoop() {
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoop(LPTRootNode newLoop) {
		LPTRootNode oldLoop = loop;
		loop = newLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LptPackage.LPT_LOOPED_NODE__LOOP, oldLoop, loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LptPackage.LPT_LOOPED_NODE__LOOP:
			if (resolve)
				return getLoop();
			return basicGetLoop();
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
		case LptPackage.LPT_LOOPED_NODE__LOOP:
			setLoop((LPTRootNode) newValue);
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
		case LptPackage.LPT_LOOPED_NODE__LOOP:
			setLoop((LPTRootNode) null);
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
		case LptPackage.LPT_LOOPED_NODE__LOOP:
			return loop != null;
		}
		return super.eIsSet(featureID);
	}

} //LPTLoopedNodeImpl
