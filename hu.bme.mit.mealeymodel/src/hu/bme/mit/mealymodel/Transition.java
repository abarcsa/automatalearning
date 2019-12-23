/**
 */
package hu.bme.mit.mealymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.mealymodel.Transition#getSourceState <em>Source State</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.Transition#getTargetState <em>Target State</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.Transition#getInput <em>Input</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.Transition#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.mealymodel.MealymodelPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Source State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source State</em>' reference.
	 * @see #setSourceState(State)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getTransition_SourceState()
	 * @model required="true"
	 * @generated
	 */
	State getSourceState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.Transition#getSourceState <em>Source State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source State</em>' reference.
	 * @see #getSourceState()
	 * @generated
	 */
	void setSourceState(State value);

	/**
	 * Returns the value of the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target State</em>' reference.
	 * @see #setTargetState(State)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getTransition_TargetState()
	 * @model required="true"
	 * @generated
	 */
	State getTargetState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.Transition#getTargetState <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target State</em>' reference.
	 * @see #getTargetState()
	 * @generated
	 */
	void setTargetState(State value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(String)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getTransition_Input()
	 * @model required="true"
	 * @generated
	 */
	String getInput();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.Transition#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(String value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getTransition_Output()
	 * @model required="true"
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.Transition#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

} // Transition
