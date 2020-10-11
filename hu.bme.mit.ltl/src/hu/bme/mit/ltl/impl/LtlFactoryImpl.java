/**
 */
package hu.bme.mit.ltl.impl;

import hu.bme.mit.ltl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LtlFactoryImpl extends EFactoryImpl implements LtlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LtlFactory init() {
		try {
			LtlFactory theLtlFactory = (LtlFactory)EPackage.Registry.INSTANCE.getEFactory(LtlPackage.eNS_URI);
			if (theLtlFactory != null) {
				return theLtlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LtlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LtlPackage.BINARY_EXPRESSION: return createBinaryExpression();
			case LtlPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case LtlPackage.NULLARY_EXPRESSION: return createNullaryExpression();
			case LtlPackage.LTL_EXPRESSION: return createLTLExpression();
			case LtlPackage.TEMPORAL_EXPRESSION: return createTemporalExpression();
			case LtlPackage.UNTIL_EXPRESSION: return createUntilExpression();
			case LtlPackage.NEXT_EXPRESSION: return createNextExpression();
			case LtlPackage.FUTURE_EXPRESSION: return createFutureExpression();
			case LtlPackage.GLOBALLY_EXPRESSION: return createGloballyExpression();
			case LtlPackage.BOOLEAN_EXPRESSION: return createBooleanExpression();
			case LtlPackage.EQUIVALENCE_EXPRESSION: return createEquivalenceExpression();
			case LtlPackage.IMPLY_EXPRESSION: return createImplyExpression();
			case LtlPackage.OR_EXPRESSION: return createOrExpression();
			case LtlPackage.AND_EXPRESSION: return createAndExpression();
			case LtlPackage.NOT_EXPRESSION: return createNotExpression();
			case LtlPackage.TRUE_EXPRESSION: return createTrueExpression();
			case LtlPackage.FALSE_EXPRESSION: return createFalseExpression();
			case LtlPackage.ATOMIC_PROPOSITION: return createAtomicProposition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BinaryExpression createBinaryExpression() {
		BinaryExpressionImpl binaryExpression = new BinaryExpressionImpl();
		return binaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NullaryExpression createNullaryExpression() {
		NullaryExpressionImpl nullaryExpression = new NullaryExpressionImpl();
		return nullaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LTLExpression createLTLExpression() {
		LTLExpressionImpl ltlExpression = new LTLExpressionImpl();
		return ltlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemporalExpression createTemporalExpression() {
		TemporalExpressionImpl temporalExpression = new TemporalExpressionImpl();
		return temporalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UntilExpression createUntilExpression() {
		UntilExpressionImpl untilExpression = new UntilExpressionImpl();
		return untilExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NextExpression createNextExpression() {
		NextExpressionImpl nextExpression = new NextExpressionImpl();
		return nextExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FutureExpression createFutureExpression() {
		FutureExpressionImpl futureExpression = new FutureExpressionImpl();
		return futureExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GloballyExpression createGloballyExpression() {
		GloballyExpressionImpl globallyExpression = new GloballyExpressionImpl();
		return globallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanExpression createBooleanExpression() {
		BooleanExpressionImpl booleanExpression = new BooleanExpressionImpl();
		return booleanExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EquivalenceExpression createEquivalenceExpression() {
		EquivalenceExpressionImpl equivalenceExpression = new EquivalenceExpressionImpl();
		return equivalenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImplyExpression createImplyExpression() {
		ImplyExpressionImpl implyExpression = new ImplyExpressionImpl();
		return implyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrExpression createOrExpression() {
		OrExpressionImpl orExpression = new OrExpressionImpl();
		return orExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AndExpression createAndExpression() {
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotExpression createNotExpression() {
		NotExpressionImpl notExpression = new NotExpressionImpl();
		return notExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TrueExpression createTrueExpression() {
		TrueExpressionImpl trueExpression = new TrueExpressionImpl();
		return trueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FalseExpression createFalseExpression() {
		FalseExpressionImpl falseExpression = new FalseExpressionImpl();
		return falseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AtomicProposition createAtomicProposition() {
		AtomicPropositionImpl atomicProposition = new AtomicPropositionImpl();
		return atomicProposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LtlPackage getLtlPackage() {
		return (LtlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LtlPackage getPackage() {
		return LtlPackage.eINSTANCE;
	}

} //LtlFactoryImpl
