package com.sap.tc.moin.repository.mmi.reflect;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

/**
 * An abstraction for accessing a collection of objects and their associations.
 * The interface provides an operation to access the metaobject description for
 * the package, and operations to access the package instance's class proxy
 * objects and its association objects.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefPackage extends RefBaseObject {

    /**
     * Returns the class proxy object for a given class.
     * 
     * @param type the class whose class proxy object is to be returned
     * @return the class proxy object for a given class <code>type</code>
     * @throws InvalidCallException if the <code>type</code> parameter does not
     * designate a valid class.
     * @throws InvalidNameException if the <code>className</code> does not
     * denote a valid class name.
     */
    public RefClass refClass( RefObject type );

    /**
     * Returns the class proxy object for a given class.
     * 
     * @param typeName the name of the class whose class proxy object is to be
     * returned
     * @return the class proxy object for a given class <code>typeName</code>
     * @throws InvalidCallException if the <code>type</code> parameter does not
     * designate a valid class.
     * @throws InvalidNameException if the <code>className</code> does not
     * denote a valid class name.
     */
    public RefClass refClass( String typeName );

    /**
     * Returns a package object for a nested or clustered package. The package
     * passed on with the <code>nestedPackage</code> parameter must either be
     * nested within the package for this package object, or imported with
     * <code>isCluster</code> set to true.
     * 
     * @param nestedPackage the package whose package object is to be returned.
     * @return a package object for a nested or clustered package.
     * @throws InvalidCallException if the <code>nestedPackage</code> parameter
     * does not designate a valid package.
     * @throws InvalidNameException if the <code>nestedPackageName</code> does
     * not denote a valid nested package name.
     */
    public RefPackage refPackage( RefObject nestedPackage );

    /**
     * Returns a package object for a nested or clustered package. The package
     * passed on with the <code>nestedPackageName</code> parameter must either
     * be nested within the package for this package object, or imported with
     * <code>isCluster</code> set to true.
     * 
     * @param nestedPackageName the name of the package whose package object is
     * to be returned.
     * @return a package object for a nested or clustered package.
     * @throws InvalidCallException if the <code>nestedPackage</code> parameter
     * does not designate a valid package.
     * @throws InvalidNameException if the <code>nestedPackageName</code> does
     * not denote a valid nested package name.
     */
    public RefPackage refPackage( String nestedPackageName );

    /**
     * Returns an association object for a given association.
     * 
     * @param association the (M2) association whose association object is to be
     * returned.
     * @return an association object for a given association
     * @throws InvalidCallException if the <code>association</code> parameter
     * does not designate a valid association.
     */
    public RefAssociation refAssociation( RefObject association );

    /**
     * Returns an association object for a given association.
     * 
     * @param associationName denotes the (M2) association whose association
     * object is to be returned.
     * @return an association object for a given association
     * @throws InvalidNameException if the <code>associationName</code> does not
     * denote a valid association name.
     */
    public RefAssociation refAssociation( String associationName );

    /**
     * Returns all packages directly contained or clustered by this package.
     * <p>
     * The Collection returned from this operation is an immutable live
     * collection. This is, the collection will reflect any changes to the
     * source, however, the operations in the Collection interface cannot be
     * used to update the source.
     * 
     * @return a (possible empty) collection of RefPackages directly contained
     * by this package.
     */
    public Collection<RefPackage> refAllPackages( );

    /**
     * Returns all class proxies directly contained by this package.
     * <p>
     * The Collection returned from this operation is an immutable live
     * collection. This is, the collection will reflect any changes to the
     * source, however, the operations in the Collection interface cannot be
     * used to update the source.
     * 
     * @return a (possible empty) collection of RefClasses directly contained by
     * this package.
     */
    public Collection<RefClass> refAllClasses( );

    /**
     * Returns all associations directly contained by this package.
     * <p>
     * The Collection returned from this operation is an immutable live
     * collection. This is, the collection will reflect any changes to the
     * source, however, the operations in the Collection interface cannot be
     * used to update the source.
     * 
     * @return a (possible empty) collection of RefAssociations directly
     * contained by this package.
     */
    public Collection<RefAssociation> refAllAssociations( );

    /**
     * Creates an instance of a struct data type defined by the metaobject
     * <code>structType</code> (or <code>structName</code>) whose attribute
     * values are specified by the ordered collection <code>params</code>.
     * <p>
     * The members of the <code>params</code> list correspond 1-to-1 to the
     * parameters for the specific create operation.
     * 
     * @param struct the type of which an instance is to be created.
     * @param params the list of parameters which have to correspond to the
     * parameters of the specific create operation.
     * @return a new instance of a struct data type.
     * @throws InvalidCallException is raised if the <code>structType</code>
     * parameter does not designate a struct type.
     */
    public RefStruct refCreateStruct( RefObject struct, List<? extends Object> params );

    /**
     * Creates an instance of a struct data type defined by the metaobject
     * <code>structType</code> (or <code>structName</code>) whose attribute
     * values are specified by the ordered collection <code>params</code>.
     * <p>
     * The members of the <code>params</code> list correspond 1-to-1 to the
     * parameters for the specific create operation.
     * 
     * @param structName the name of the type of which an instance is to be
     * created.
     * @param params the list of parameters which have to correspond to the
     * parameters of the specific create operation.
     * @return a new instance of a struct data type.
     * @throws InvalidNameException is raised when the <code>structName</code>
     * does not denote a valid struct name.
     */
    public RefStruct refCreateStruct( String structName, List<? extends Object> params );

    /**
     * Returns the instance of an enumeration (i.e., an enumeration literal)
     * whose value is described by the value of <code>literalName</code>. Note
     * that the type of enumeration is defined by the metaobject that owns the
     * metaLiteral object.
     * 
     * @param enumType the type of which an instance ist to be created.
     * @param name the value of the enumeration literal.
     * @return the enumeration object representing the enumeration literal.
     * @throws InvalidCallException is raised if the <code>enumType</code>
     * parameter does not designate a valid enumeration.
     */
    public RefEnum refGetEnum( RefObject enumType, String name );

    /**
     * Returns the instance of an enumeration (i.e., an enumeration literal)
     * whose value is described by the value of <code>literalName</code>. Note
     * that the type of enumeration is defined by the metaobject that owns the
     * metaLiteral object.
     * 
     * @param enumName the name of the type of which an instance is to be
     * created.
     * @param name the value of the enumeration literal.
     * @return the enumeration object representing the enumeration literal.
     * @throws InvalidNameException is raised when the <code>enumName</code>
     * does not denote a valid enum name.
     */
    public RefEnum refGetEnum( String enumName, String name );

    /**
     * Destroys this package, including the objects it contains directly or
     * transitively. Deletion of an outermost package causes all objects within
     * its extent to be deleted.
     */
    public void refDelete( );

    public MofPackage refMetaObject( );
}