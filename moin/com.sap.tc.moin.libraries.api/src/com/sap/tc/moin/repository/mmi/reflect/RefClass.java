package com.sap.tc.moin.repository.mmi.reflect;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.ModelPartition;

/**
 * Provides the metaobject description of a class proxy object, and a range of
 * operations for accessing and updating an object's classifier scoped features.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefClass extends RefFeatured {

    /**
     * Creates a new instance of the class for the class proxy's most derived
     * interface. The <code>args</code> list gives the initial values for the
     * new instance object's instance scoped, non-derived attributes.
     * <p>
     * The value of the <code>args</code> parameter must be either null, or a
     * list such that the list of arguments correspond 1-to-1 to the parameters
     * for the specific create operation. If <code>args</code> is null, then the
     * operation corresponds to the default constructor that takes no arguments.
     * 
     * @param args the initial values for the new instance object's instance
     * scoped, non-derived attributes.
     * @return a new instance of the class for the class proxy's most derived
     * interface.
     */
    @Deprecated
    public RefObject refCreateInstance( List<? extends Object> args );

    /**
     * Creates a new instance of the class for the class proxy's most derived
     * interface.
     * <p>
     * 
     * @return a new instance of the class for the class proxy's most derived
     * interface.
     */
    public RefObject refCreateInstance( );

    /**
     * Creates a new instance of the class for the class proxy's most derived
     * interface. The <code>args</code> list gives the initial values for the
     * new instance object's instance scoped, non-derived attributes.
     * <p>
     * The value of the <code>args</code> parameter must be either null, or a
     * list such that the list of arguments correspond 1-to-1 to the parameters
     * for the specific create operation. If <code>args</code> is null, then the
     * operation corresponds to the default constructor that takes no arguments.
     * 
     * @param args the initial values for the new instance object's instance
     * scoped, non-derived attributes.
     * @param partition the partition that the element is assigned to.
     * @return a new instance of the class for the class proxy's most derived
     * interface.
     */
    @Deprecated
    public RefObject refCreateInstanceInPartition( List<? extends Object> args, ModelPartition partition );

    /**
     * Creates a new instance of the class for the class proxy's most derived
     * interface.
     * 
     * @param partition the partition that the element is assigned to.
     * @return a new instance of the class for the class proxy's most derived
     * interface.
     */
    public RefObject refCreateInstanceInPartition( ModelPartition partition );

    /**
     * Returns the set of all instances in the current extent whose type is
     * given by this object's class or one of its sub-classes.
     * <p>
     * The Collection returned from this operation is an immutable live
     * collection. This is, the collection will reflect any changes to the
     * source, however, the operations in the Collection interface cannot be
     * used to update the source.
     * 
     * @return the set of all instances in the current extent whose type is
     * given by this object's class or one of its sub-classes.
     */
    public Collection<RefObject> refAllOfType( );

    /**
     * Returns the set of all instances in the current extent whose type is
     * given by this object's class (instances of sub classes are not included).
     * <p>
     * The Collection returned from this operation is an immutable live
     * collection. This is, the collection will reflect any changes to the
     * source, however, the operations in the Collection interface cannot be
     * used to update the source.
     * 
     * @return the set of all instances in the current extent whose type is
     * given by this object's class (instances of sub classes are not included).
     */
    public Collection<RefObject> refAllOfClass( );

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

    public MofClass refMetaObject( );
}