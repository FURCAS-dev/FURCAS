package com.sap.tc.moin.repository.mmi.reflect;

/**
 * Provides the metaobject description of an instance object, and a range of
 * operations for accessing and updating the object's features.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefObject extends RefFeatured {

    /**
     * Tests whether this {@link RefObject} is an instance of the class
     * described by the <code>objType</code> metaobject. If the
     * <code>considerSubtypes</code> argument is true, an object whose class is
     * a subclass of the class described by <code>objType</code> will be
     * considered as an instance of the class.
     * 
     * @param objType the metaobject that describes the type for which it is
     * tested whether this object is an instance
     * @param considerSubtypes if true, an object whose class is is a subclass
     * of the class described by <code>objType</code> will be considered as an
     * instance of the class.
     * @return true if this {@link RefObject} is an instance of the class
     * described by the <code>objType</code> metaobject
     */
    public boolean refIsInstanceOf( RefObject objType, boolean considerSubtypes );

    /**
     * Returns the RefObject's class proxy object.
     * 
     * @return the RefObject's class proxy object.
     * @throws java.lang.UnsupportedOperationException if the
     * <code>ignoreLifecycle</code> tag (attached to the package containing the
     * metamodel) is set to true.
     */
    public RefClass refClass( );

    /**
     * Returns the immediate composite object for this instance as specified
     * below. The immediate composite object C returned by this operation is an
     * instance object such that:
     * <ul>
     * <li> C is related to this object via a relation R defined by an attribute
     * or association. <li> The aggregation semantics of the relation R are
     * <code>composite</code>. <li> This object fills the role of <code>
     * component</code> in its relationship with C.
     * </ul>
     * If the immediate object C does not exist, or if <code>this</code> object
     * is a class proxy object rather than an instance object, a Java null
     * object reference is returned.
     * <p>
     * Note � If the composite relationship R corresponds to a
     * <code>classifier-level</code> scoped attribute, the immediate composite
     * object C will be the class proxy object that holds the attribute value.
     * 
     * @return the immediate composite object for this instance as specified
     * below.
     */
    public RefFeatured refImmediateComposite( );

    /**
     * Returns the <code>outermost composite</code> for this object as defined
     * below. The outermost composite object C returned by this operation is an
     * instance object such that:
     * <ul>
     * <li> There is a chain of zero or more immediate composite relationships
     * (as described for "refInvokeOperation" above) connecting <code>this
     * </code> object to C, and <li> C does not have an immediate composite.
     * </ul>
     * The above definition is such that if "this" object is not a component of
     * any other object, it will be returned.
     * 
     * @return the <code>outermost composite</code> for this object as defined
     * below.
     */
    public RefFeatured refOutermostComposite( );

    /**
     * Destroys this object, including the objects it contains directly or
     * transitively. Deletion of an instance object deletes it and its component
     * closure.
     * 
     * @throws java.lang.UnsupportedOperationException if the
     * <code>ignoreLifecycle</code> tag (attached to the package containing the
     * metamodel) is set to true.
     */
    public void refDelete( );
}
