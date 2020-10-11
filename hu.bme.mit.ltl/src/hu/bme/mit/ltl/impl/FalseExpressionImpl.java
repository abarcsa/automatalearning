/**
 */
package hu.bme.mit.ltl.impl;

import hu.bme.mit.ltl.FalseExpression;
import hu.bme.mit.ltl.LtlPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>False Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class FalseExpressionImpl extends BooleanExpressionImpl implements FalseExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FalseExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LtlPackage.Literals.FALSE_EXPRESSION;
	}

} //FalseExpressionImpl
