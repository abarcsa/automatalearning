/**
 */
package hu.bme.mit.ltl.impl;

import hu.bme.mit.ltl.AndExpression;
import hu.bme.mit.ltl.AtomicProposition;
import hu.bme.mit.ltl.BinaryExpression;
import hu.bme.mit.ltl.BooleanExpression;
import hu.bme.mit.ltl.EquivalenceExpression;
import hu.bme.mit.ltl.FalseExpression;
import hu.bme.mit.ltl.FutureExpression;
import hu.bme.mit.ltl.GloballyExpression;
import hu.bme.mit.ltl.ImplyExpression;
import hu.bme.mit.ltl.LTLExpression;
import hu.bme.mit.ltl.LtlFactory;
import hu.bme.mit.ltl.LtlPackage;
import hu.bme.mit.ltl.NextExpression;
import hu.bme.mit.ltl.NotExpression;
import hu.bme.mit.ltl.NullaryExpression;
import hu.bme.mit.ltl.OrExpression;
import hu.bme.mit.ltl.TemporalExpression;
import hu.bme.mit.ltl.TrueExpression;
import hu.bme.mit.ltl.UnaryExpression;
import hu.bme.mit.ltl.UntilExpression;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LtlPackageImpl extends EPackageImpl implements LtlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ltlExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temporalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass untilExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nextExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass futureExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globallyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalenceExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicPropositionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hu.bme.mit.ltl.LtlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LtlPackageImpl() {
		super(eNS_URI, LtlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link LtlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LtlPackage init() {
		if (isInited) return (LtlPackage)EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredLtlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		LtlPackageImpl theLtlPackage = registeredLtlPackage instanceof LtlPackageImpl ? (LtlPackageImpl)registeredLtlPackage : new LtlPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theLtlPackage.createPackageContents();

		// Initialize created meta-data
		theLtlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLtlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LtlPackage.eNS_URI, theLtlPackage);
		return theLtlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryExpression_LeftOperand() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryExpression_RightOperand() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnaryExpression_Operand() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNullaryExpression() {
		return nullaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLTLExpression() {
		return ltlExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemporalExpression() {
		return temporalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUntilExpression() {
		return untilExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNextExpression() {
		return nextExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFutureExpression() {
		return futureExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGloballyExpression() {
		return globallyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanExpression() {
		return booleanExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEquivalenceExpression() {
		return equivalenceExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImplyExpression() {
		return implyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOrExpression() {
		return orExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAndExpression() {
		return andExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNotExpression() {
		return notExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTrueExpression() {
		return trueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFalseExpression() {
		return falseExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAtomicProposition() {
		return atomicPropositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAtomicProposition_Proposition() {
		return (EAttribute)atomicPropositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LtlFactory getLtlFactory() {
		return (LtlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT_OPERAND);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT_OPERAND);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);

		nullaryExpressionEClass = createEClass(NULLARY_EXPRESSION);

		ltlExpressionEClass = createEClass(LTL_EXPRESSION);

		temporalExpressionEClass = createEClass(TEMPORAL_EXPRESSION);

		untilExpressionEClass = createEClass(UNTIL_EXPRESSION);

		nextExpressionEClass = createEClass(NEXT_EXPRESSION);

		futureExpressionEClass = createEClass(FUTURE_EXPRESSION);

		globallyExpressionEClass = createEClass(GLOBALLY_EXPRESSION);

		booleanExpressionEClass = createEClass(BOOLEAN_EXPRESSION);

		equivalenceExpressionEClass = createEClass(EQUIVALENCE_EXPRESSION);

		implyExpressionEClass = createEClass(IMPLY_EXPRESSION);

		orExpressionEClass = createEClass(OR_EXPRESSION);

		andExpressionEClass = createEClass(AND_EXPRESSION);

		notExpressionEClass = createEClass(NOT_EXPRESSION);

		trueExpressionEClass = createEClass(TRUE_EXPRESSION);

		falseExpressionEClass = createEClass(FALSE_EXPRESSION);

		atomicPropositionEClass = createEClass(ATOMIC_PROPOSITION);
		createEAttribute(atomicPropositionEClass, ATOMIC_PROPOSITION__PROPOSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		temporalExpressionEClass.getESuperTypes().add(this.getLTLExpression());
		untilExpressionEClass.getESuperTypes().add(this.getTemporalExpression());
		untilExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		nextExpressionEClass.getESuperTypes().add(this.getTemporalExpression());
		nextExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		futureExpressionEClass.getESuperTypes().add(this.getTemporalExpression());
		futureExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		globallyExpressionEClass.getESuperTypes().add(this.getTemporalExpression());
		globallyExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		booleanExpressionEClass.getESuperTypes().add(this.getLTLExpression());
		equivalenceExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		equivalenceExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		implyExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		implyExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		orExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		orExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		andExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		andExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		notExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		notExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		trueExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		trueExpressionEClass.getESuperTypes().add(this.getNullaryExpression());
		falseExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		falseExpressionEClass.getESuperTypes().add(this.getNullaryExpression());
		atomicPropositionEClass.getESuperTypes().add(this.getBooleanExpression());
		atomicPropositionEClass.getESuperTypes().add(this.getNullaryExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpression_LeftOperand(), this.getLTLExpression(), null, "leftOperand", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_RightOperand(), this.getLTLExpression(), null, "rightOperand", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryExpression_Operand(), this.getLTLExpression(), null, "operand", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nullaryExpressionEClass, NullaryExpression.class, "NullaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ltlExpressionEClass, LTLExpression.class, "LTLExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(temporalExpressionEClass, TemporalExpression.class, "TemporalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(untilExpressionEClass, UntilExpression.class, "UntilExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nextExpressionEClass, NextExpression.class, "NextExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(futureExpressionEClass, FutureExpression.class, "FutureExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globallyExpressionEClass, GloballyExpression.class, "GloballyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanExpressionEClass, BooleanExpression.class, "BooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equivalenceExpressionEClass, EquivalenceExpression.class, "EquivalenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implyExpressionEClass, ImplyExpression.class, "ImplyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notExpressionEClass, NotExpression.class, "NotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trueExpressionEClass, TrueExpression.class, "TrueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseExpressionEClass, FalseExpression.class, "FalseExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(atomicPropositionEClass, AtomicProposition.class, "AtomicProposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtomicProposition_Proposition(), ecorePackage.getEString(), "proposition", null, 0, 1, AtomicProposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LtlPackageImpl
