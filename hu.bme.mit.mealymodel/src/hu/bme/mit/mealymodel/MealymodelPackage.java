/**
 */
package hu.bme.mit.mealymodel;

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
 * @see hu.bme.mit.mealymodel.MealymodelFactory
 * @model kind="package"
 * @generated
 */
public interface MealymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mealymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "hu.bme.mit.mealymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mealymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MealymodelPackage eINSTANCE = hu.bme.mit.mealymodel.impl.MealymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl <em>Mealy Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.mealymodel.impl.MealyMachineImpl
	 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getMealyMachine()
	 * @generated
	 */
	int MEALY_MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE__INITIAL_STATE = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE__STATES = 1;

	/**
	 * The feature id for the '<em><b>Input Alphabet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE__INPUT_ALPHABET = 2;

	/**
	 * The feature id for the '<em><b>Output Alphabet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE__OUTPUT_ALPHABET = 3;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE__TRANSITIONS = 4;

	/**
	 * The number of structural features of the '<em>Mealy Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Mealy Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEALY_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.mealymodel.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.mealymodel.impl.StateImpl
	 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.mealymodel.impl.AlphabetImpl <em>Alphabet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.mealymodel.impl.AlphabetImpl
	 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getAlphabet()
	 * @generated
	 */
	int ALPHABET = 2;

	/**
	 * The feature id for the '<em><b>Characters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHABET__CHARACTERS = 0;

	/**
	 * The number of structural features of the '<em>Alphabet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHABET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Alphabet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHABET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.mealymodel.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.mealymodel.impl.TransitionImpl
	 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Source State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET_STATE = 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__INPUT = 2;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OUTPUT = 3;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.mealymodel.MealyMachine <em>Mealy Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mealy Machine</em>'.
	 * @see hu.bme.mit.mealymodel.MealyMachine
	 * @generated
	 */
	EClass getMealyMachine();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.mealymodel.MealyMachine#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial State</em>'.
	 * @see hu.bme.mit.mealymodel.MealyMachine#getInitialState()
	 * @see #getMealyMachine()
	 * @generated
	 */
	EReference getMealyMachine_InitialState();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.mealymodel.MealyMachine#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see hu.bme.mit.mealymodel.MealyMachine#getStates()
	 * @see #getMealyMachine()
	 * @generated
	 */
	EReference getMealyMachine_States();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.mealymodel.MealyMachine#getInputAlphabet <em>Input Alphabet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Alphabet</em>'.
	 * @see hu.bme.mit.mealymodel.MealyMachine#getInputAlphabet()
	 * @see #getMealyMachine()
	 * @generated
	 */
	EReference getMealyMachine_InputAlphabet();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.mealymodel.MealyMachine#getOutputAlphabet <em>Output Alphabet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Alphabet</em>'.
	 * @see hu.bme.mit.mealymodel.MealyMachine#getOutputAlphabet()
	 * @see #getMealyMachine()
	 * @generated
	 */
	EReference getMealyMachine_OutputAlphabet();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.mealymodel.MealyMachine#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see hu.bme.mit.mealymodel.MealyMachine#getTransitions()
	 * @see #getMealyMachine()
	 * @generated
	 */
	EReference getMealyMachine_Transitions();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.mealymodel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see hu.bme.mit.mealymodel.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.mealymodel.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.mealymodel.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.mealymodel.Alphabet <em>Alphabet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alphabet</em>'.
	 * @see hu.bme.mit.mealymodel.Alphabet
	 * @generated
	 */
	EClass getAlphabet();

	/**
	 * Returns the meta object for the attribute list '{@link hu.bme.mit.mealymodel.Alphabet#getCharacters <em>Characters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Characters</em>'.
	 * @see hu.bme.mit.mealymodel.Alphabet#getCharacters()
	 * @see #getAlphabet()
	 * @generated
	 */
	EAttribute getAlphabet_Characters();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.mealymodel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see hu.bme.mit.mealymodel.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.mealymodel.Transition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source State</em>'.
	 * @see hu.bme.mit.mealymodel.Transition#getSourceState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_SourceState();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.mealymodel.Transition#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see hu.bme.mit.mealymodel.Transition#getTargetState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_TargetState();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.mealymodel.Transition#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see hu.bme.mit.mealymodel.Transition#getInput()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Input();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.mealymodel.Transition#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see hu.bme.mit.mealymodel.Transition#getOutput()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Output();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MealymodelFactory getMealymodelFactory();

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
		 * The meta object literal for the '{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl <em>Mealy Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.mealymodel.impl.MealyMachineImpl
		 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getMealyMachine()
		 * @generated
		 */
		EClass MEALY_MACHINE = eINSTANCE.getMealyMachine();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEALY_MACHINE__INITIAL_STATE = eINSTANCE.getMealyMachine_InitialState();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEALY_MACHINE__STATES = eINSTANCE.getMealyMachine_States();

		/**
		 * The meta object literal for the '<em><b>Input Alphabet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEALY_MACHINE__INPUT_ALPHABET = eINSTANCE.getMealyMachine_InputAlphabet();

		/**
		 * The meta object literal for the '<em><b>Output Alphabet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEALY_MACHINE__OUTPUT_ALPHABET = eINSTANCE.getMealyMachine_OutputAlphabet();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEALY_MACHINE__TRANSITIONS = eINSTANCE.getMealyMachine_Transitions();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.mealymodel.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.mealymodel.impl.StateImpl
		 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.mealymodel.impl.AlphabetImpl <em>Alphabet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.mealymodel.impl.AlphabetImpl
		 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getAlphabet()
		 * @generated
		 */
		EClass ALPHABET = eINSTANCE.getAlphabet();

		/**
		 * The meta object literal for the '<em><b>Characters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHABET__CHARACTERS = eINSTANCE.getAlphabet_Characters();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.mealymodel.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.mealymodel.impl.TransitionImpl
		 * @see hu.bme.mit.mealymodel.impl.MealymodelPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Source State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE_STATE = eINSTANCE.getTransition_SourceState();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET_STATE = eINSTANCE.getTransition_TargetState();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__INPUT = eINSTANCE.getTransition_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__OUTPUT = eINSTANCE.getTransition_Output();

	}

} //MealymodelPackage
