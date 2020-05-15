/**
 */
package hu.bme.mit.lpt.impl;

import hu.bme.mit.lpt.*;

import java.util.Map;
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
public class LptFactoryImpl extends EFactoryImpl implements LptFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LptFactory init() {
		try {
			LptFactory theLptFactory = (LptFactory) EPackage.Registry.INSTANCE.getEFactory(LptPackage.eNS_URI);
			if (theLptFactory != null) {
				return theLptFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LptFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LptFactoryImpl() {
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
		case LptPackage.LPT_ROOT_NODE:
			return createLPTRootNode();
		case LptPackage.LPT_UNLOOPED_NODE:
			return createLPTUnloopedNode();
		case LptPackage.LPT_LOOPED_NODE:
			return createLPTLoopedNode();
		case LptPackage.ESTRING_TO_LPT_ROOT_NODE_MAP:
			return (EObject) createEStringToLPTRootNodeMap();
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
	public LPTRootNode createLPTRootNode() {
		LPTRootNodeImpl lptRootNode = new LPTRootNodeImpl();
		return lptRootNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LPTUnloopedNode createLPTUnloopedNode() {
		LPTUnloopedNodeImpl lptUnloopedNode = new LPTUnloopedNodeImpl();
		return lptUnloopedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LPTLoopedNode createLPTLoopedNode() {
		LPTLoopedNodeImpl lptLoopedNode = new LPTLoopedNodeImpl();
		return lptLoopedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, LPTRootNode> createEStringToLPTRootNodeMap() {
		EStringToLPTRootNodeMapImpl eStringToLPTRootNodeMap = new EStringToLPTRootNodeMapImpl();
		return eStringToLPTRootNodeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LptPackage getLptPackage() {
		return (LptPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LptPackage getPackage() {
		return LptPackage.eINSTANCE;
	}

} //LptFactoryImpl
