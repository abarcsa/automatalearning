/**
 */
package hu.bme.mit.lpt.util;

import hu.bme.mit.lpt.*;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.lpt.LptPackage
 * @generated
 */
public class LptSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LptPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LptSwitch() {
		if (modelPackage == null) {
			modelPackage = LptPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case LptPackage.LPT_ROOT_NODE: {
			LPTRootNode lptRootNode = (LPTRootNode) theEObject;
			T result = caseLPTRootNode(lptRootNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LptPackage.LPT_UNLOOPED_NODE: {
			LPTUnloopedNode lptUnloopedNode = (LPTUnloopedNode) theEObject;
			T result = caseLPTUnloopedNode(lptUnloopedNode);
			if (result == null)
				result = caseLPTRootNode(lptUnloopedNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LptPackage.LPT_LOOPED_NODE: {
			LPTLoopedNode lptLoopedNode = (LPTLoopedNode) theEObject;
			T result = caseLPTLoopedNode(lptLoopedNode);
			if (result == null)
				result = caseLPTUnloopedNode(lptLoopedNode);
			if (result == null)
				result = caseLPTRootNode(lptLoopedNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LptPackage.ESTRING_TO_LPT_ROOT_NODE_MAP: {
			@SuppressWarnings("unchecked")
			Map.Entry<String, LPTRootNode> eStringToLPTRootNodeMap = (Map.Entry<String, LPTRootNode>) theEObject;
			T result = caseEStringToLPTRootNodeMap(eStringToLPTRootNodeMap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LPT Root Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LPT Root Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLPTRootNode(LPTRootNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LPT Unlooped Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LPT Unlooped Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLPTUnloopedNode(LPTUnloopedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LPT Looped Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LPT Looped Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLPTLoopedNode(LPTLoopedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To LPT Root Node Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To LPT Root Node Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringToLPTRootNodeMap(Map.Entry<String, LPTRootNode> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //LptSwitch
