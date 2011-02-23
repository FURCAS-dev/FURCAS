/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExcludingAt.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excluding At</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Like Excluding, but useful if multiple occurrences of the *argument* value exist. This expression removes the occurrence at the position specified by *at*. For this purpose, the argument value must have ordered=true, and so will the resulting value. If at position *at* there is no object that equals *argument* or the *at* position is outside the valid bounds, the resulting expression equals the *source* expression.
 * 
 * If the argument is a multi-object (cardinality > 1), it needs to be ordered, and the argument's object sequence needs to exist at the position specified by *at*. If only a subsequence prefix is matched at position *at*, only that subsequence prefix will be excluded.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getExcludingAt()
 * @model
 * @generated
 */
public interface ExcludingAt extends Excluding, WithPosition {
} // ExcludingAt
