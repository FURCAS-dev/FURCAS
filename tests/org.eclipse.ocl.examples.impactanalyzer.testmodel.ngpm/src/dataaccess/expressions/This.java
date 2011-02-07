/**
 * <copyright>
 * </copyright>
 *
 * $Id: This.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Statically, the This expression has the type that owns its occurrence. This means, in order to determine this, the getType implementation needs to ascend the composition hierarchy until it finds a Class somewhere. The problem, again, is that an OCL expression cannot manufacture the result required becauce currently TypeDefinition is still an "entity type," meaning a MOF class whose instances have ID and an explicit life cycle.
 * 
 * Therefore, currently This has to own its type definition, unfortunately.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.ExpressionsPackage#getThis()
 * @model
 * @generated
 */
public interface This extends Expression {
} // This
