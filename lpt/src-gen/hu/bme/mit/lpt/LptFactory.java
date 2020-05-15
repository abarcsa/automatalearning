/**
 */
package hu.bme.mit.lpt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.lpt.LptPackage
 * @generated
 */
public interface LptFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LptFactory eINSTANCE = hu.bme.mit.lpt.impl.LptFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>LPT Root Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LPT Root Node</em>'.
	 * @generated
	 */
	LPTRootNode createLPTRootNode();

	/**
	 * Returns a new object of class '<em>LPT Unlooped Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LPT Unlooped Node</em>'.
	 * @generated
	 */
	LPTUnloopedNode createLPTUnloopedNode();

	/**
	 * Returns a new object of class '<em>LPT Looped Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LPT Looped Node</em>'.
	 * @generated
	 */
	LPTLoopedNode createLPTLoopedNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LptPackage getLptPackage();

} //LptFactory
