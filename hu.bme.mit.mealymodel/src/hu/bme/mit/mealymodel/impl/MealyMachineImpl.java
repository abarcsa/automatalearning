/**
 */
package hu.bme.mit.mealymodel.impl;

import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelPackage;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mealy Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl#getInputAlphabet <em>Input Alphabet</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl#getOutputAlphabet <em>Output Alphabet</em>}</li>
 *   <li>{@link hu.bme.mit.mealymodel.impl.MealyMachineImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MealyMachineImpl extends MinimalEObjectImpl.Container implements MealyMachine {
	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getInputAlphabet() <em>Input Alphabet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputAlphabet()
	 * @generated
	 * @ordered
	 */
	protected Alphabet inputAlphabet;

	/**
	 * The cached value of the '{@link #getOutputAlphabet() <em>Output Alphabet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputAlphabet()
	 * @generated
	 * @ordered
	 */
	protected Alphabet outputAlphabet;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MealyMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MealymodelPackage.Literals.MEALY_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State getInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialState(State newInitialState, NotificationChain msgs) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MealymodelPackage.MEALY_MACHINE__INITIAL_STATE, oldInitialState, newInitialState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialState(State newInitialState) {
		if (newInitialState != initialState) {
			NotificationChain msgs = null;
			if (initialState != null)
				msgs = ((InternalEObject)initialState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MealymodelPackage.MEALY_MACHINE__INITIAL_STATE, null, msgs);
			if (newInitialState != null)
				msgs = ((InternalEObject)newInitialState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MealymodelPackage.MEALY_MACHINE__INITIAL_STATE, null, msgs);
			msgs = basicSetInitialState(newInitialState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealymodelPackage.MEALY_MACHINE__INITIAL_STATE, newInitialState, newInitialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, MealymodelPackage.MEALY_MACHINE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Alphabet getInputAlphabet() {
		return inputAlphabet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputAlphabet(Alphabet newInputAlphabet, NotificationChain msgs) {
		Alphabet oldInputAlphabet = inputAlphabet;
		inputAlphabet = newInputAlphabet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET, oldInputAlphabet, newInputAlphabet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputAlphabet(Alphabet newInputAlphabet) {
		if (newInputAlphabet != inputAlphabet) {
			NotificationChain msgs = null;
			if (inputAlphabet != null)
				msgs = ((InternalEObject)inputAlphabet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET, null, msgs);
			if (newInputAlphabet != null)
				msgs = ((InternalEObject)newInputAlphabet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET, null, msgs);
			msgs = basicSetInputAlphabet(newInputAlphabet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET, newInputAlphabet, newInputAlphabet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Alphabet getOutputAlphabet() {
		return outputAlphabet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputAlphabet(Alphabet newOutputAlphabet, NotificationChain msgs) {
		Alphabet oldOutputAlphabet = outputAlphabet;
		outputAlphabet = newOutputAlphabet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET, oldOutputAlphabet, newOutputAlphabet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutputAlphabet(Alphabet newOutputAlphabet) {
		if (newOutputAlphabet != outputAlphabet) {
			NotificationChain msgs = null;
			if (outputAlphabet != null)
				msgs = ((InternalEObject)outputAlphabet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET, null, msgs);
			if (newOutputAlphabet != null)
				msgs = ((InternalEObject)newOutputAlphabet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET, null, msgs);
			msgs = basicSetOutputAlphabet(newOutputAlphabet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET, newOutputAlphabet, newOutputAlphabet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<Transition>(Transition.class, this, MealymodelPackage.MEALY_MACHINE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MealymodelPackage.MEALY_MACHINE__INITIAL_STATE:
				return basicSetInitialState(null, msgs);
			case MealymodelPackage.MEALY_MACHINE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET:
				return basicSetInputAlphabet(null, msgs);
			case MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET:
				return basicSetOutputAlphabet(null, msgs);
			case MealymodelPackage.MEALY_MACHINE__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MealymodelPackage.MEALY_MACHINE__INITIAL_STATE:
				return getInitialState();
			case MealymodelPackage.MEALY_MACHINE__STATES:
				return getStates();
			case MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET:
				return getInputAlphabet();
			case MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET:
				return getOutputAlphabet();
			case MealymodelPackage.MEALY_MACHINE__TRANSITIONS:
				return getTransitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MealymodelPackage.MEALY_MACHINE__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case MealymodelPackage.MEALY_MACHINE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET:
				setInputAlphabet((Alphabet)newValue);
				return;
			case MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET:
				setOutputAlphabet((Alphabet)newValue);
				return;
			case MealymodelPackage.MEALY_MACHINE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MealymodelPackage.MEALY_MACHINE__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case MealymodelPackage.MEALY_MACHINE__STATES:
				getStates().clear();
				return;
			case MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET:
				setInputAlphabet((Alphabet)null);
				return;
			case MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET:
				setOutputAlphabet((Alphabet)null);
				return;
			case MealymodelPackage.MEALY_MACHINE__TRANSITIONS:
				getTransitions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MealymodelPackage.MEALY_MACHINE__INITIAL_STATE:
				return initialState != null;
			case MealymodelPackage.MEALY_MACHINE__STATES:
				return states != null && !states.isEmpty();
			case MealymodelPackage.MEALY_MACHINE__INPUT_ALPHABET:
				return inputAlphabet != null;
			case MealymodelPackage.MEALY_MACHINE__OUTPUT_ALPHABET:
				return outputAlphabet != null;
			case MealymodelPackage.MEALY_MACHINE__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MealyMachineImpl
