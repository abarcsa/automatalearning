/**
 */
package hu.bme.mit.mealymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mealy Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.mealymodel.MealyMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.MealyMachine#getStates <em>States</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.MealyMachine#getInputAlphabet <em>Input Alphabet</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.MealyMachine#getOutputAlphabet <em>Output Alphabet</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.MealyMachine#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.mealymodel.MealymodelPackage#getMealyMachine()
 * @model
 * @generated
 */
public interface MealyMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' containment reference.
	 * @see #setInitialState(State)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getMealyMachine_InitialState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.MealyMachine#getInitialState <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' containment reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.mealymodel.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getMealyMachine_States()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Input Alphabet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Alphabet</em>' containment reference.
	 * @see #setInputAlphabet(Alphabet)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getMealyMachine_InputAlphabet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Alphabet getInputAlphabet();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.MealyMachine#getInputAlphabet <em>Input Alphabet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Alphabet</em>' containment reference.
	 * @see #getInputAlphabet()
	 * @generated
	 */
	void setInputAlphabet(Alphabet value);

	/**
	 * Returns the value of the '<em><b>Output Alphabet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Alphabet</em>' containment reference.
	 * @see #setOutputAlphabet(Alphabet)
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getMealyMachine_OutputAlphabet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Alphabet getOutputAlphabet();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mealymodel.MealyMachine#getOutputAlphabet <em>Output Alphabet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Alphabet</em>' containment reference.
	 * @see #getOutputAlphabet()
	 * @generated
	 */
	void setOutputAlphabet(Alphabet value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.mealymodel.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getMealyMachine_Transitions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // MealyMachine
