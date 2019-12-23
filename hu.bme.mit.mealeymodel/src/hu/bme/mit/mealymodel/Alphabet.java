/**
 */
package hu.bme.mit.mealymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alphabet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.mealymodel.Alphabet#getCharacters <em>Characters</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.mealymodel.MealymodelPackage#getAlphabet()
 * @model
 * @generated
 */
public interface Alphabet extends EObject {
	/**
	 * Returns the value of the '<em><b>Characters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characters</em>' attribute list.
	 * @see hu.bme.mit.mealymodel.MealymodelPackage#getAlphabet_Characters()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getCharacters();

} // Alphabet
