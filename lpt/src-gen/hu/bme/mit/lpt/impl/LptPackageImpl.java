/**
 */
package hu.bme.mit.lpt.impl;

import hu.bme.mit.lpt.LPTLoopedNode;
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.lpt.LPTUnloopedNode;
import hu.bme.mit.lpt.LptFactory;
import hu.bme.mit.lpt.LptPackage;

import java.util.Map;
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
public class LptPackageImpl extends EPackageImpl implements LptPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lptRootNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lptUnloopedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lptLoopedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToLPTRootNodeMapEClass = null;

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
	 * @see hu.bme.mit.lpt.LptPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LptPackageImpl() {
		super(eNS_URI, LptFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LptPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LptPackage init() {
		if (isInited)
			return (LptPackage) EPackage.Registry.INSTANCE.getEPackage(LptPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredLptPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		LptPackageImpl theLptPackage = registeredLptPackage instanceof LptPackageImpl
				? (LptPackageImpl) registeredLptPackage
				: new LptPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theLptPackage.createPackageContents();

		// Initialize created meta-data
		theLptPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLptPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LptPackage.eNS_URI, theLptPackage);
		return theLptPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLPTRootNode() {
		return lptRootNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLPTRootNode_Children() {
		return (EReference) lptRootNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLPTUnloopedNode() {
		return lptUnloopedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLPTUnloopedNode_Output() {
		return (EAttribute) lptUnloopedNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLPTLoopedNode() {
		return lptLoopedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLPTLoopedNode_Loop() {
		return (EReference) lptLoopedNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEStringToLPTRootNodeMap() {
		return eStringToLPTRootNodeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToLPTRootNodeMap_Key() {
		return (EAttribute) eStringToLPTRootNodeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEStringToLPTRootNodeMap_Value() {
		return (EReference) eStringToLPTRootNodeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LptFactory getLptFactory() {
		return (LptFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		lptRootNodeEClass = createEClass(LPT_ROOT_NODE);
		createEReference(lptRootNodeEClass, LPT_ROOT_NODE__CHILDREN);

		lptUnloopedNodeEClass = createEClass(LPT_UNLOOPED_NODE);
		createEAttribute(lptUnloopedNodeEClass, LPT_UNLOOPED_NODE__OUTPUT);

		lptLoopedNodeEClass = createEClass(LPT_LOOPED_NODE);
		createEReference(lptLoopedNodeEClass, LPT_LOOPED_NODE__LOOP);

		eStringToLPTRootNodeMapEClass = createEClass(ESTRING_TO_LPT_ROOT_NODE_MAP);
		createEAttribute(eStringToLPTRootNodeMapEClass, ESTRING_TO_LPT_ROOT_NODE_MAP__KEY);
		createEReference(eStringToLPTRootNodeMapEClass, ESTRING_TO_LPT_ROOT_NODE_MAP__VALUE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		lptUnloopedNodeEClass.getESuperTypes().add(this.getLPTRootNode());
		lptLoopedNodeEClass.getESuperTypes().add(this.getLPTUnloopedNode());

		// Initialize classes, features, and operations; add parameters
		initEClass(lptRootNodeEClass, LPTRootNode.class, "LPTRootNode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLPTRootNode_Children(), this.getEStringToLPTRootNodeMap(), null, "children", null, 0, -1,
				LPTRootNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(lptUnloopedNodeEClass, LPTUnloopedNode.class, "LPTUnloopedNode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLPTUnloopedNode_Output(), ecorePackage.getEString(), "output", null, 0, 1,
				LPTUnloopedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(lptLoopedNodeEClass, LPTLoopedNode.class, "LPTLoopedNode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLPTLoopedNode_Loop(), this.getLPTRootNode(), null, "loop", null, 1, 1, LPTLoopedNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToLPTRootNodeMapEClass, Map.Entry.class, "EStringToLPTRootNodeMap", !IS_ABSTRACT,
				!IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToLPTRootNodeMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEStringToLPTRootNodeMap_Value(), this.getLPTRootNode(), null, "value", null, 1, 1,
				Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LptPackageImpl
