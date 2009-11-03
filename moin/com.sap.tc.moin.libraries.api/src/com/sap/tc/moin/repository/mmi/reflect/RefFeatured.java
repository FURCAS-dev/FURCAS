package com.sap.tc.moin.repository.mmi.reflect;

import java.util.List;

/**
 * Provides the metaobject description of instances and class proxy objects. It
 * provides a range of operations for accessing and updating the object's
 * features in a model-independent way.
 * <p>
 * The model assumed by the interface is that an object has structural features
 * and operations. The model allows structural features to have single values or
 * collection values. In the latter case, the collection values may have
 * ordering or uniqueness semantics. There is provision for creation of new
 * object instances, and for obtaining the set of objects that exist in a
 * context.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefFeatured extends RefBaseObject {

    /**
     * Assigns a new value to an attribute or reference for an object.
     * 
     * @param feature the attribute or reference to be set
     * @param value the value to which <code>feature</code> is assigned
     * @throws InvalidCallException if one of the following conditions occur:
     * <ul>
     * <li> The <code>feature</code> does not denote an attribute or reference
     * accessible from this object. <li> The <code>feature</code> denotes a
     * multivalued attribute.
     * </ul>
     * @throws ClosureViolationException if the Composition Closure or Reference
     * Closure rule has been violated.
     * @throws CompositionCycleException occurs when the Composition Cycle rule
     * has been violated.
     */
    public void refSetValue( RefObject feature, Object value );

    /**
     * Assigns a new value to an attribute or reference for an object.
     * 
     * @param featureName the name of the attribute or reference to be set
     * @param value the value to which <code>feature</code> is assigned
     * @throws InvalidCallException if one of the following conditions occur:
     * <ul>
     * <li> The <code>featureName</code> does not denote an attribute or
     * reference accessible from this object. <li> The <code>featureName</code>
     * denotes a multivalued attribute.
     * </ul>
     * @throws InvalidNameException if <code>featureName</code> does not denote
     * a valid feature name.
     * @throws ClosureViolationException if the Composition Closure or Reference
     * Closure rule has been violated.
     * @throws CompositionCycleException occurs when the Composition Cycle rule
     * has been violated.
     */
    public void refSetValue( String featureName, Object value );

    /**
     * Fetches the current value of the attribute or reference denoted by the
     * <code>feature</code> argument. If this object is a class proxy, only
     * classifier scoped attributes can be fetched.
     * 
     * @param feature the attribute or reference for which the value is to be
     * returned
     * @return the value of the feature or attribute
     * @throws InvalidCallException if the <code>feature</code> argument does
     * not denote an attribute or reference accessible from this object
     */
    public Object refGetValue( RefObject feature );

    /**
     * Fetches the current value of the attribute or reference denoted by the
     * <code>feature</code> argument. If this object is a class proxy, only
     * classifier scoped attributes can be fetched.
     * 
     * @param featureName the name of the attribute or reference for which the
     * value is to be returned
     * @return the value of the feature or attribute
     * @throws InvalidNameException if the <code>featureName</code> does not
     * denote a valid feature name.
     */
    public Object refGetValue( String featureName );

    /**
     * Invokes a metamodel defined operation on the instance or class proxy
     * object with the arguments supplied.
     * 
     * @param requestedOperation the operation that is to be executed
     * @param args the values of all of the operation's parameters. There must
     * be a distinct parameter value (real or dummy) for every parameter.
     * @return the return value of the operation if the operation defines a
     * result; <code>null</code> otherwise
     * @throws RefException
     * @throws InvalidCallException if <code>requestedOperation</code> does not
     * designate an operation that can be invoked.
     * @throws WrongSizeException if the <code>args</code> parameter list does
     * not contain exactly the number of arguments that the operation requires
     * @throws TypeMismatchException if the parameters passed in
     * <code>args</code> do not match the type or multiplicity of the
     * operation's parameters
     */
    public Object refInvokeOperation( RefObject requestedOperation, List<? extends Object> args ) throws RefException;

    /**
     * Invokes a metamodel defined operation on the instance or class proxy
     * object with the arguments supplied.
     * 
     * @param requestedOperation the name of the operation that is to be
     * executed
     * @param args the values of all of the operation's parameters. There must
     * be a distinct parameter value (real or dummy) for every parameter.
     * @return the return value of the operation if the operation defines a
     * result; <code>null</code> otherwise
     * @throws RefException
     * @throws InvalidNameException if <code>requestedOperation</code> does not
     * denote a valid operation name
     * @throws WrongSizeException if the <code>args</code> parameter list does
     * not contain exactly the number of arguments that the operation requires
     * @throws TypeMismatchException if the parameters passed in
     * <code>args</code> do not match the type or multiplicity of the
     * operation's parameters
     */
    public Object refInvokeOperation( String requestedOperation, List<? extends Object> args ) throws RefException;
}
