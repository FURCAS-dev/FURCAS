package com.sap.tc.moin.repository.mmi.reflect;

import java.util.Collection;

import com.sap.tc.moin.repository.Partitionable;

/**
 * The interface extended by all other reflective interfaces. It provides common
 * operations for testing for object identity, returning an object's metaobject,
 * and returning its facility container as required for implementing structural
 * constraints such as the MOF's type closure rule and composition restrictions.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @see RefObject
 */
public interface RefBaseObject extends Partitionable {

    /**
     * Returns the {@link RefObject} object that describes this object in its
     * metamodel specification.
     * 
     * @return the {@link RefObject} object that describes this object in its
     * metamodel specification. May be <code>null</code> if the object's
     * metaobject is unavailable.
     */
    public RefObject refMetaObject( );

    /**
     * Returns the package object for the package that most immediately contains
     * or aggregates this object. The return value may be <code>null</code> if
     * this object has no containing or aggregating package (i.e. it is the
     * {@link RefPackage} object for an outermost package).
     * 
     * @return the package object for the package that most immediately contains
     * or aggregates this object. May be <code>null</code> if this object has no
     * containing or aggregating package.
     * @throws java.lang.UnsupportedOperationException if the
     * <code>ignoreLifecycle</code> tag (attached to the package containing the
     * metamodel) is set to true.
     */
    public RefPackage refImmediatePackage( );

    /**
     * Returns the package object for the package that ultimately contains this
     * object. If this object is the {@link RefPackage} object for an outermost
     * package then the return value is this object.
     * 
     * @return the package object for the package that ultimately contains this
     * object.
     * @throws java.lang.UnsupportedOperationException if the
     * <code>ignoreLifecycle</code> tag (attached to the package containing the
     * metamodel) is set to true.
     */
    public RefPackage refOutermostPackage( );

    /**
     * Returns this object�s permanent unique identifier string.
     * 
     * @return the permanent unique identifier string of this object
     */
    public String refMofId( );

    /**
     * Verifies that an object and its properties satisfy all constraints
     * defined on it.
     * <p>
     * If <code>deepVerify</code> equals <code>false</code> (i.e., a
     * shallowVerify), this method checks all constraints on that object and its
     * properties. If <code>true</code>, carries out a shallowVerify on that
     * object and a deep verify through its containment hierarchy. If the object
     * is an extent object (i.e., class proxy, package, or association object),
     * the containment hierarchy includes all objects in its extent.
     * <p>
     * The return value is <code>null</code> if no constraint is violated;
     * otherwise, a list of {@link com.sap.tc.moin.repository.mmi.reflect.JmiException} objects (each
     * representing a constraint violation) is returned. The Collection returned
     * from this operation has copy semantics. That is, it does not reflect any
     * changes to the source after the operation is executed, and it cannot be
     * used to update the source.
     * 
     * @param deepVerify if false, performs a constraint verify on the object
     * and its properties; otherwise, checks the object and all objects in its
     * containment hierarchy.
     * @return <code>null</code> if no constraint is violated; otherwise, a list
     * of {@link com.sap.tc.moin.repository.mmi.reflect.JmiException} objects (each representing a
     * constraint violation).
     */
    public Collection<JmiException> refVerifyConstraints( boolean deepVerify );

    public int hashCode( );
}
