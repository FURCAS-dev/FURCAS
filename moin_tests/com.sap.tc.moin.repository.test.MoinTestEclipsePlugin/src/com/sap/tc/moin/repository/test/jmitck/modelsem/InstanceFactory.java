package com.sap.tc.moin.repository.test.jmitck.modelsem;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * Factory for creating datatype values and instances of RefBaseObject.
 * <p>
 * The original intention was to factor out all instance creation, so that tests
 * of implementations that did not support lifecycle operations could provide an
 * alternate means of creating objects. It bacame clear that this would create a
 * great deal of developemnt overhead, and it was not clear that such support
 * was needed. At present, the single implementation provides convenience
 * methods for value and object creation, without compilation depedencies on
 * generated code.
 * <p>
 * Because every RefObject and constructed datatype instance must be created
 * within an extent, each InstanceFactory holds a reference to a RefPackage
 * defining this extent.
 */
public interface InstanceFactory {

    /**
     * Returns a new instance of the specified datatype. For primitive types,
     * simple names may be used (int, String, etc.). For constructed types
     * (structure types and enumeration types) the fully-qualified java type
     * must be specified.
     * <p>
     * For structure types, the value string is parsed and converted using the
     * types of the parameters of the corresponding factory method
     * (create&lt;Structure&gt;). Values are separated by commas. Values of a
     * collection type are specified as
     * <code>&lt;Type&gt;(&lt;value&gt;[|&lt;value&gt;]*)</code>, such as
     * <code>Integer(4|5|9)</code>.
     * 
     * @param type the datatype of the desired value.
     * @param value a string used to create an instance.
     * @return a new instance of the requested type.
     */
    public Object makeValue( Class<?> type, String value );

    /**
     * Returns a new instance of the specified RefObject.
     * <p>
     * The value string is parsed and converted using the types of the
     * parameters of the corresponding factory method (create&lt;Class&gt;).
     * Values are separated by commas. Values of a collection type are specified
     * as <code>&lt;Type&gt;(&lt;value&gt;[|&lt;value&gt;]*)</code>, such as
     * <code>Integer(4|5|9)</code>. If null is passed in for the value, the
     * no-args factory method will be used
     * 
     * @param type the fully-qualified name of the java class of the desired
     * type.
     * @param value a string used to create an instance, or null, to use the
     * no-args factory method
     * @return a new instance of the requested RefObject type.
     */
    public Object makeRefObject( Class<?> type, String value );

    /**
     * Returns the extent that this InstanceFactory uses to create instances.
     * 
     * @return a <code>RefPackage</code> that defines an extent (outer
     * RefPackage)
     */
    public RefPackage getRepRoot( );

    /**
     * Initializes an InstanceFactory, before use.
     * 
     * @param rp the extent that will be used to create instances
     * @param prefix the prefix that was used to generated the code for this
     * extent, such as "com.sap.tc.moin.repository.test.jmitck.tst"
     */
    public void init( RefPackage rp );

    /**
     * Returns the requested RefAssociation subtype instance, within this
     * InstanceFactory's extent.
     * 
     * @param assocName the java type name of the requested association
     * @return the corresponding <code>RefAssociation</code> instance
     */
    public RefAssociation getAssociation( String assocName );
}
