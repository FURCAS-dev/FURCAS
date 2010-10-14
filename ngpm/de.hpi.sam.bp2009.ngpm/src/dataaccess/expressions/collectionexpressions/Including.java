/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Including</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Produces a new value which includes the *argument* object. If the *argument* object was already included in the *source* and the multiplicity of the *source* has the *unique* attribute set to *true*, the *what* object will not be added a second time and the resulting expression will be equal to the *source* expression's value.
 * 
 * If the *source* expression had multiplicity 1, the resulting expression's multiplicity is *, regardless of whether an object actually gets added.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getIncluding()
 * @model
 * @generated
 */
public interface Including extends CollectionExpressionWithArgument {
} // Including
