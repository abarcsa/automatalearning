/**
 */
package hu.bme.mit.ltl.util;

import hu.bme.mit.ltl.*;

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
 * @see hu.bme.mit.ltl.LtlPackage
 * @generated
 */
public class LtlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LtlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlSwitch() {
		if (modelPackage == null) {
			modelPackage = LtlPackage.eINSTANCE;
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
			case LtlPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression)theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.NULLARY_EXPRESSION: {
				NullaryExpression nullaryExpression = (NullaryExpression)theEObject;
				T result = caseNullaryExpression(nullaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.LTL_EXPRESSION: {
				LTLExpression ltlExpression = (LTLExpression)theEObject;
				T result = caseLTLExpression(ltlExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.TEMPORAL_EXPRESSION: {
				TemporalExpression temporalExpression = (TemporalExpression)theEObject;
				T result = caseTemporalExpression(temporalExpression);
				if (result == null) result = caseLTLExpression(temporalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.UNTIL_EXPRESSION: {
				UntilExpression untilExpression = (UntilExpression)theEObject;
				T result = caseUntilExpression(untilExpression);
				if (result == null) result = caseTemporalExpression(untilExpression);
				if (result == null) result = caseBinaryExpression(untilExpression);
				if (result == null) result = caseLTLExpression(untilExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.NEXT_EXPRESSION: {
				NextExpression nextExpression = (NextExpression)theEObject;
				T result = caseNextExpression(nextExpression);
				if (result == null) result = caseTemporalExpression(nextExpression);
				if (result == null) result = caseUnaryExpression(nextExpression);
				if (result == null) result = caseLTLExpression(nextExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.FUTURE_EXPRESSION: {
				FutureExpression futureExpression = (FutureExpression)theEObject;
				T result = caseFutureExpression(futureExpression);
				if (result == null) result = caseTemporalExpression(futureExpression);
				if (result == null) result = caseUnaryExpression(futureExpression);
				if (result == null) result = caseLTLExpression(futureExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.GLOBALLY_EXPRESSION: {
				GloballyExpression globallyExpression = (GloballyExpression)theEObject;
				T result = caseGloballyExpression(globallyExpression);
				if (result == null) result = caseTemporalExpression(globallyExpression);
				if (result == null) result = caseUnaryExpression(globallyExpression);
				if (result == null) result = caseLTLExpression(globallyExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.BOOLEAN_EXPRESSION: {
				BooleanExpression booleanExpression = (BooleanExpression)theEObject;
				T result = caseBooleanExpression(booleanExpression);
				if (result == null) result = caseLTLExpression(booleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.EQUIVALENCE_EXPRESSION: {
				EquivalenceExpression equivalenceExpression = (EquivalenceExpression)theEObject;
				T result = caseEquivalenceExpression(equivalenceExpression);
				if (result == null) result = caseBooleanExpression(equivalenceExpression);
				if (result == null) result = caseBinaryExpression(equivalenceExpression);
				if (result == null) result = caseLTLExpression(equivalenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.IMPLY_EXPRESSION: {
				ImplyExpression implyExpression = (ImplyExpression)theEObject;
				T result = caseImplyExpression(implyExpression);
				if (result == null) result = caseBooleanExpression(implyExpression);
				if (result == null) result = caseBinaryExpression(implyExpression);
				if (result == null) result = caseLTLExpression(implyExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.OR_EXPRESSION: {
				OrExpression orExpression = (OrExpression)theEObject;
				T result = caseOrExpression(orExpression);
				if (result == null) result = caseBooleanExpression(orExpression);
				if (result == null) result = caseBinaryExpression(orExpression);
				if (result == null) result = caseLTLExpression(orExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.AND_EXPRESSION: {
				AndExpression andExpression = (AndExpression)theEObject;
				T result = caseAndExpression(andExpression);
				if (result == null) result = caseBooleanExpression(andExpression);
				if (result == null) result = caseBinaryExpression(andExpression);
				if (result == null) result = caseLTLExpression(andExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.NOT_EXPRESSION: {
				NotExpression notExpression = (NotExpression)theEObject;
				T result = caseNotExpression(notExpression);
				if (result == null) result = caseBooleanExpression(notExpression);
				if (result == null) result = caseUnaryExpression(notExpression);
				if (result == null) result = caseLTLExpression(notExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.TRUE_EXPRESSION: {
				TrueExpression trueExpression = (TrueExpression)theEObject;
				T result = caseTrueExpression(trueExpression);
				if (result == null) result = caseBooleanExpression(trueExpression);
				if (result == null) result = caseNullaryExpression(trueExpression);
				if (result == null) result = caseLTLExpression(trueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.FALSE_EXPRESSION: {
				FalseExpression falseExpression = (FalseExpression)theEObject;
				T result = caseFalseExpression(falseExpression);
				if (result == null) result = caseBooleanExpression(falseExpression);
				if (result == null) result = caseNullaryExpression(falseExpression);
				if (result == null) result = caseLTLExpression(falseExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.ATOMIC_PROPOSITION: {
				AtomicProposition atomicProposition = (AtomicProposition)theEObject;
				T result = caseAtomicProposition(atomicProposition);
				if (result == null) result = caseBooleanExpression(atomicProposition);
				if (result == null) result = caseNullaryExpression(atomicProposition);
				if (result == null) result = caseLTLExpression(atomicProposition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nullary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nullary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullaryExpression(NullaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LTL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LTL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLTLExpression(LTLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Temporal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Temporal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemporalExpression(TemporalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Until Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Until Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUntilExpression(UntilExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Next Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Next Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNextExpression(NextExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Future Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Future Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFutureExpression(FutureExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Globally Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Globally Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGloballyExpression(GloballyExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExpression(BooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalence Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalence Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquivalenceExpression(EquivalenceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imply Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imply Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplyExpression(ImplyExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrExpression(OrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndExpression(AndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotExpression(NotExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueExpression(TrueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalseExpression(FalseExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Proposition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Proposition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicProposition(AtomicProposition object) {
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

} //LtlSwitch
