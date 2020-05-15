/**
 */
package hu.bme.mit.lpt;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LPT Root Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.lpt.LPTRootNode#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.lpt.LptPackage#getLPTRootNode()
 * @model
 * @generated
 */
public interface LPTRootNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link hu.bme.mit.lpt.LPTRootNode},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' map.
	 * @see hu.bme.mit.lpt.LptPackage#getLPTRootNode_Children()
	 * @model mapType="hu.bme.mit.lpt.EStringToLPTRootNodeMap&lt;org.eclipse.emf.ecore.EString, hu.bme.mit.lpt.LPTRootNode&gt;" ordered="false"
	 * @generated
	 */
	EMap<String, LPTRootNode> getChildren();

} // LPTRootNode
