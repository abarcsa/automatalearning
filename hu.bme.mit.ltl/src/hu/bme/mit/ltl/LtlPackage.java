/**
 */
package hu.bme.mit.ltl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.ltl.LtlFactory
 * @model kind="package"
 * @generated
 */
public interface LtlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ltl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "hu.bme.mit.ltl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ltl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LtlPackage eINSTANCE = hu.bme.mit.ltl.impl.LtlPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.BinaryExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEFT_OPERAND = 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__RIGHT_OPERAND = 1;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.UnaryExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERAND = 0;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.NullaryExpressionImpl <em>Nullary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.NullaryExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getNullaryExpression()
	 * @generated
	 */
	int NULLARY_EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Nullary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLARY_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Nullary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLARY_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.LTLExpressionImpl <em>LTL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.LTLExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getLTLExpression()
	 * @generated
	 */
	int LTL_EXPRESSION = 3;

	/**
	 * The number of structural features of the '<em>LTL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LTL_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>LTL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LTL_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.TemporalExpressionImpl <em>Temporal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.TemporalExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getTemporalExpression()
	 * @generated
	 */
	int TEMPORAL_EXPRESSION = 4;

	/**
	 * The number of structural features of the '<em>Temporal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_EXPRESSION_FEATURE_COUNT = LTL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Temporal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_EXPRESSION_OPERATION_COUNT = LTL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.UntilExpressionImpl <em>Until Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.UntilExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getUntilExpression()
	 * @generated
	 */
	int UNTIL_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL_EXPRESSION__LEFT_OPERAND = TEMPORAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL_EXPRESSION__RIGHT_OPERAND = TEMPORAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Until Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL_EXPRESSION_FEATURE_COUNT = TEMPORAL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Until Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL_EXPRESSION_OPERATION_COUNT = TEMPORAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.NextExpressionImpl <em>Next Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.NextExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getNextExpression()
	 * @generated
	 */
	int NEXT_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_EXPRESSION__OPERAND = TEMPORAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Next Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_EXPRESSION_FEATURE_COUNT = TEMPORAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Next Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_EXPRESSION_OPERATION_COUNT = TEMPORAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.FutureExpressionImpl <em>Future Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.FutureExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getFutureExpression()
	 * @generated
	 */
	int FUTURE_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUTURE_EXPRESSION__OPERAND = TEMPORAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Future Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUTURE_EXPRESSION_FEATURE_COUNT = TEMPORAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Future Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUTURE_EXPRESSION_OPERATION_COUNT = TEMPORAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.GloballyExpressionImpl <em>Globally Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.GloballyExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getGloballyExpression()
	 * @generated
	 */
	int GLOBALLY_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBALLY_EXPRESSION__OPERAND = TEMPORAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Globally Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBALLY_EXPRESSION_FEATURE_COUNT = TEMPORAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Globally Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBALLY_EXPRESSION_OPERATION_COUNT = TEMPORAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.BooleanExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 9;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = LTL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_OPERATION_COUNT = LTL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.EquivalenceExpressionImpl <em>Equivalence Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.EquivalenceExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getEquivalenceExpression()
	 * @generated
	 */
	int EQUIVALENCE_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE_EXPRESSION__LEFT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE_EXPRESSION__RIGHT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Equivalence Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Equivalence Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.ImplyExpressionImpl <em>Imply Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.ImplyExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getImplyExpression()
	 * @generated
	 */
	int IMPLY_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY_EXPRESSION__LEFT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY_EXPRESSION__RIGHT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Imply Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Imply Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.OrExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getOrExpression()
	 * @generated
	 */
	int OR_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__LEFT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__RIGHT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.AndExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__LEFT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__RIGHT_OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.NotExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getNotExpression()
	 * @generated
	 */
	int NOT_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__OPERAND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.TrueExpressionImpl <em>True Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.TrueExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getTrueExpression()
	 * @generated
	 */
	int TRUE_EXPRESSION = 15;

	/**
	 * The number of structural features of the '<em>True Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>True Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.FalseExpressionImpl <em>False Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.FalseExpressionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getFalseExpression()
	 * @generated
	 */
	int FALSE_EXPRESSION = 16;

	/**
	 * The number of structural features of the '<em>False Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>False Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.ltl.impl.AtomicPropositionImpl <em>Atomic Proposition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.ltl.impl.AtomicPropositionImpl
	 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getAtomicProposition()
	 * @generated
	 */
	int ATOMIC_PROPOSITION = 17;

	/**
	 * The feature id for the '<em><b>Proposition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROPOSITION__PROPOSITION = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Proposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROPOSITION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Atomic Proposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROPOSITION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see hu.bme.mit.ltl.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.ltl.BinaryExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see hu.bme.mit.ltl.BinaryExpression#getLeftOperand()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.ltl.BinaryExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see hu.bme.mit.ltl.BinaryExpression#getRightOperand()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see hu.bme.mit.ltl.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.ltl.UnaryExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see hu.bme.mit.ltl.UnaryExpression#getOperand()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Operand();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.NullaryExpression <em>Nullary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nullary Expression</em>'.
	 * @see hu.bme.mit.ltl.NullaryExpression
	 * @generated
	 */
	EClass getNullaryExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.LTLExpression <em>LTL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LTL Expression</em>'.
	 * @see hu.bme.mit.ltl.LTLExpression
	 * @generated
	 */
	EClass getLTLExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.TemporalExpression <em>Temporal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Expression</em>'.
	 * @see hu.bme.mit.ltl.TemporalExpression
	 * @generated
	 */
	EClass getTemporalExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.UntilExpression <em>Until Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Until Expression</em>'.
	 * @see hu.bme.mit.ltl.UntilExpression
	 * @generated
	 */
	EClass getUntilExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.NextExpression <em>Next Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Next Expression</em>'.
	 * @see hu.bme.mit.ltl.NextExpression
	 * @generated
	 */
	EClass getNextExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.FutureExpression <em>Future Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Future Expression</em>'.
	 * @see hu.bme.mit.ltl.FutureExpression
	 * @generated
	 */
	EClass getFutureExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.GloballyExpression <em>Globally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Globally Expression</em>'.
	 * @see hu.bme.mit.ltl.GloballyExpression
	 * @generated
	 */
	EClass getGloballyExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see hu.bme.mit.ltl.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.EquivalenceExpression <em>Equivalence Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalence Expression</em>'.
	 * @see hu.bme.mit.ltl.EquivalenceExpression
	 * @generated
	 */
	EClass getEquivalenceExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.ImplyExpression <em>Imply Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imply Expression</em>'.
	 * @see hu.bme.mit.ltl.ImplyExpression
	 * @generated
	 */
	EClass getImplyExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see hu.bme.mit.ltl.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see hu.bme.mit.ltl.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see hu.bme.mit.ltl.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.TrueExpression <em>True Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Expression</em>'.
	 * @see hu.bme.mit.ltl.TrueExpression
	 * @generated
	 */
	EClass getTrueExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.FalseExpression <em>False Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Expression</em>'.
	 * @see hu.bme.mit.ltl.FalseExpression
	 * @generated
	 */
	EClass getFalseExpression();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.ltl.AtomicProposition <em>Atomic Proposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Proposition</em>'.
	 * @see hu.bme.mit.ltl.AtomicProposition
	 * @generated
	 */
	EClass getAtomicProposition();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.ltl.AtomicProposition#getProposition <em>Proposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proposition</em>'.
	 * @see hu.bme.mit.ltl.AtomicProposition#getProposition()
	 * @see #getAtomicProposition()
	 * @generated
	 */
	EAttribute getAtomicProposition_Proposition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LtlFactory getLtlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.BinaryExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBinaryExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBinaryExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.UnaryExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.NullaryExpressionImpl <em>Nullary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.NullaryExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getNullaryExpression()
		 * @generated
		 */
		EClass NULLARY_EXPRESSION = eINSTANCE.getNullaryExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.LTLExpressionImpl <em>LTL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.LTLExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getLTLExpression()
		 * @generated
		 */
		EClass LTL_EXPRESSION = eINSTANCE.getLTLExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.TemporalExpressionImpl <em>Temporal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.TemporalExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getTemporalExpression()
		 * @generated
		 */
		EClass TEMPORAL_EXPRESSION = eINSTANCE.getTemporalExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.UntilExpressionImpl <em>Until Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.UntilExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getUntilExpression()
		 * @generated
		 */
		EClass UNTIL_EXPRESSION = eINSTANCE.getUntilExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.NextExpressionImpl <em>Next Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.NextExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getNextExpression()
		 * @generated
		 */
		EClass NEXT_EXPRESSION = eINSTANCE.getNextExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.FutureExpressionImpl <em>Future Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.FutureExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getFutureExpression()
		 * @generated
		 */
		EClass FUTURE_EXPRESSION = eINSTANCE.getFutureExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.GloballyExpressionImpl <em>Globally Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.GloballyExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getGloballyExpression()
		 * @generated
		 */
		EClass GLOBALLY_EXPRESSION = eINSTANCE.getGloballyExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.BooleanExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.EquivalenceExpressionImpl <em>Equivalence Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.EquivalenceExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getEquivalenceExpression()
		 * @generated
		 */
		EClass EQUIVALENCE_EXPRESSION = eINSTANCE.getEquivalenceExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.ImplyExpressionImpl <em>Imply Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.ImplyExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getImplyExpression()
		 * @generated
		 */
		EClass IMPLY_EXPRESSION = eINSTANCE.getImplyExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.OrExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getOrExpression()
		 * @generated
		 */
		EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.AndExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getAndExpression()
		 * @generated
		 */
		EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.NotExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getNotExpression()
		 * @generated
		 */
		EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.TrueExpressionImpl <em>True Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.TrueExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getTrueExpression()
		 * @generated
		 */
		EClass TRUE_EXPRESSION = eINSTANCE.getTrueExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.FalseExpressionImpl <em>False Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.FalseExpressionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getFalseExpression()
		 * @generated
		 */
		EClass FALSE_EXPRESSION = eINSTANCE.getFalseExpression();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.ltl.impl.AtomicPropositionImpl <em>Atomic Proposition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.ltl.impl.AtomicPropositionImpl
		 * @see hu.bme.mit.ltl.impl.LtlPackageImpl#getAtomicProposition()
		 * @generated
		 */
		EClass ATOMIC_PROPOSITION = eINSTANCE.getAtomicProposition();

		/**
		 * The meta object literal for the '<em><b>Proposition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_PROPOSITION__PROPOSITION = eINSTANCE.getAtomicProposition_Proposition();

	}

} //LtlPackage
