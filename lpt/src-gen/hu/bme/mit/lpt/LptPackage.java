/**
 */
package hu.bme.mit.lpt;

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
 * <!-- begin-model-doc -->
 * Model representing a Loopable Prefix Tree (LPT). 
 * 
 * Root nodes only store their children.
 * 
 * UnloopedNodes store their children and the specified input/output pairs.
 * 
 * LoopedNodes store their specified input/output pairs, plus the loop through which traversal should return to a previous node.
 * <!-- end-model-doc -->
 * @see hu.bme.mit.lpt.LptFactory
 * @model kind="package"
 * @generated
 */
public interface LptPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lpt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.github.com/aronbsz/automatalearning";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lpt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LptPackage eINSTANCE = hu.bme.mit.lpt.impl.LptPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.lpt.impl.LPTRootNodeImpl <em>LPT Root Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.lpt.impl.LPTRootNodeImpl
	 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getLPTRootNode()
	 * @generated
	 */
	int LPT_ROOT_NODE = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_ROOT_NODE__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>LPT Root Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_ROOT_NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>LPT Root Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_ROOT_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.lpt.impl.LPTUnloopedNodeImpl <em>LPT Unlooped Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.lpt.impl.LPTUnloopedNodeImpl
	 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getLPTUnloopedNode()
	 * @generated
	 */
	int LPT_UNLOOPED_NODE = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_UNLOOPED_NODE__CHILDREN = LPT_ROOT_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_UNLOOPED_NODE__OUTPUT = LPT_ROOT_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>LPT Unlooped Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_UNLOOPED_NODE_FEATURE_COUNT = LPT_ROOT_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>LPT Unlooped Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_UNLOOPED_NODE_OPERATION_COUNT = LPT_ROOT_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.lpt.impl.LPTLoopedNodeImpl <em>LPT Looped Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.lpt.impl.LPTLoopedNodeImpl
	 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getLPTLoopedNode()
	 * @generated
	 */
	int LPT_LOOPED_NODE = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_LOOPED_NODE__CHILDREN = LPT_UNLOOPED_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_LOOPED_NODE__OUTPUT = LPT_UNLOOPED_NODE__OUTPUT;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_LOOPED_NODE__LOOP = LPT_UNLOOPED_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>LPT Looped Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_LOOPED_NODE_FEATURE_COUNT = LPT_UNLOOPED_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>LPT Looped Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LPT_LOOPED_NODE_OPERATION_COUNT = LPT_UNLOOPED_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.lpt.impl.EStringToLPTRootNodeMapImpl <em>EString To LPT Root Node Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.lpt.impl.EStringToLPTRootNodeMapImpl
	 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getEStringToLPTRootNodeMap()
	 * @generated
	 */
	int ESTRING_TO_LPT_ROOT_NODE_MAP = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LPT_ROOT_NODE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LPT_ROOT_NODE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To LPT Root Node Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LPT_ROOT_NODE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To LPT Root Node Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LPT_ROOT_NODE_MAP_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.lpt.LPTRootNode <em>LPT Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LPT Root Node</em>'.
	 * @see hu.bme.mit.lpt.LPTRootNode
	 * @generated
	 */
	EClass getLPTRootNode();

	/**
	 * Returns the meta object for the map '{@link hu.bme.mit.lpt.LPTRootNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Children</em>'.
	 * @see hu.bme.mit.lpt.LPTRootNode#getChildren()
	 * @see #getLPTRootNode()
	 * @generated
	 */
	EReference getLPTRootNode_Children();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.lpt.LPTUnloopedNode <em>LPT Unlooped Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LPT Unlooped Node</em>'.
	 * @see hu.bme.mit.lpt.LPTUnloopedNode
	 * @generated
	 */
	EClass getLPTUnloopedNode();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.lpt.LPTUnloopedNode#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see hu.bme.mit.lpt.LPTUnloopedNode#getOutput()
	 * @see #getLPTUnloopedNode()
	 * @generated
	 */
	EAttribute getLPTUnloopedNode_Output();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.lpt.LPTLoopedNode <em>LPT Looped Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LPT Looped Node</em>'.
	 * @see hu.bme.mit.lpt.LPTLoopedNode
	 * @generated
	 */
	EClass getLPTLoopedNode();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.lpt.LPTLoopedNode#getLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop</em>'.
	 * @see hu.bme.mit.lpt.LPTLoopedNode#getLoop()
	 * @see #getLPTLoopedNode()
	 * @generated
	 */
	EReference getLPTLoopedNode_Loop();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To LPT Root Node Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To LPT Root Node Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyUnique="false" keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="hu.bme.mit.lpt.LPTRootNode" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToLPTRootNodeMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToLPTRootNodeMap()
	 * @generated
	 */
	EAttribute getEStringToLPTRootNodeMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToLPTRootNodeMap()
	 * @generated
	 */
	EReference getEStringToLPTRootNodeMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LptFactory getLptFactory();

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
		 * The meta object literal for the '{@link hu.bme.mit.lpt.impl.LPTRootNodeImpl <em>LPT Root Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.lpt.impl.LPTRootNodeImpl
		 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getLPTRootNode()
		 * @generated
		 */
		EClass LPT_ROOT_NODE = eINSTANCE.getLPTRootNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LPT_ROOT_NODE__CHILDREN = eINSTANCE.getLPTRootNode_Children();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.lpt.impl.LPTUnloopedNodeImpl <em>LPT Unlooped Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.lpt.impl.LPTUnloopedNodeImpl
		 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getLPTUnloopedNode()
		 * @generated
		 */
		EClass LPT_UNLOOPED_NODE = eINSTANCE.getLPTUnloopedNode();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LPT_UNLOOPED_NODE__OUTPUT = eINSTANCE.getLPTUnloopedNode_Output();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.lpt.impl.LPTLoopedNodeImpl <em>LPT Looped Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.lpt.impl.LPTLoopedNodeImpl
		 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getLPTLoopedNode()
		 * @generated
		 */
		EClass LPT_LOOPED_NODE = eINSTANCE.getLPTLoopedNode();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LPT_LOOPED_NODE__LOOP = eINSTANCE.getLPTLoopedNode_Loop();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.lpt.impl.EStringToLPTRootNodeMapImpl <em>EString To LPT Root Node Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.lpt.impl.EStringToLPTRootNodeMapImpl
		 * @see hu.bme.mit.lpt.impl.LptPackageImpl#getEStringToLPTRootNodeMap()
		 * @generated
		 */
		EClass ESTRING_TO_LPT_ROOT_NODE_MAP = eINSTANCE.getEStringToLPTRootNodeMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_LPT_ROOT_NODE_MAP__KEY = eINSTANCE.getEStringToLPTRootNodeMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_LPT_ROOT_NODE_MAP__VALUE = eINSTANCE.getEStringToLPTRootNodeMap_Value();

	}

} //LptPackage
