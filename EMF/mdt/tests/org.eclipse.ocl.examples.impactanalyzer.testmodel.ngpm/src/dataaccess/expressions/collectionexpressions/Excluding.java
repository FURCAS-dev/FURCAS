/**
 * <copyright>
 * </copyright>
 *
 * $Id: Excluding.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excluding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Produces a new value which includes one less occurrence of the *argument* object than *source* or no occurrence if *source* did not contain an occurrence.
 * 
 * If the *source* expression had multiplicity a..b, the resulting expression's multiplicity is Max(a-1, 0)..b, regardless of whether an object actually gets removed.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getExcluding()
 * @model
 * @generated
 */
public interface Excluding extends CollectionExpressionWithArgument {
} // Excluding
