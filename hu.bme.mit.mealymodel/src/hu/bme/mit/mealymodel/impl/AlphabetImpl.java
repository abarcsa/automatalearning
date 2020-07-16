/**
 */
package hu.bme.mit.mealymodel.impl;

import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealymodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alphabet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.mealymodel.impl.AlphabetImpl#getCharacters <em>Characters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlphabetImpl extends MinimalEObjectImpl.Container implements Alphabet {
	/**
	 * The cached value of the '{@link #getCharacters() <em>Characters</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacters()
	 * @generated
	 * @ordered
	 */
	protected EList<String> characters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlphabetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MealymodelPackage.Literals.ALPHABET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getCharacters() {
		if (characters == null) {
			characters = new EDataTypeUniqueEList<String>(String.class, this, MealymodelPackage.ALPHABET__CHARACTERS);
		}
		return characters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MealymodelPackage.ALPHABET__CHARACTERS:
				return getCharacters();
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
			case MealymodelPackage.ALPHABET__CHARACTERS:
				getCharacters().clear();
				getCharacters().addAll((Collection<? extends String>)newValue);
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
			case MealymodelPackage.ALPHABET__CHARACTERS:
				getCharacters().clear();
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
			case MealymodelPackage.ALPHABET__CHARACTERS:
				return characters != null && !characters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (characters: ");
		result.append(characters);
		result.append(')');
		return result.toString();
	}

} //AlphabetImpl
