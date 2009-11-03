package com.sap.tc.moin.repository.mmi.reflect;

import java.io.Serializable;
import java.util.List;

import com.sap.tc.moin.repository.MRI;

/**
 * The reflective interface for struct data types. Provides generic operations
 * for querying structs.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefStruct extends Serializable {

    /**
     * Returns the {@link MRI} of the {@link RefObject} object that describes
     * this object in its metamodel specification.
     * 
     * @return the {@link MRI} of the {@link RefObject} object that describes
     * this object in its metamodel specification. May be <code>null</code> if
     * the object's metaobject is unavailable.
     */
    public MRI refMetaObjectMri( );

    /**
     * Tests whether this {@link RefStruct} is an instance of the class
     * described by the metaobject with the MRI <code>objTypeMri</code>. If the
     * <code>considerSubtypes</code> argument is true, an object whose structure
     * is a substructure of the class described by <code>objTypeMri</code> will
     * be considered as an instance of the structure.
     * 
     * @param objTypeMri the {@link MRI} of the the metaobject that describes
     * the type for which it is tested whether this object is an instance
     * @param considerSubtypes if true, an object whose structure is is a
     * substructure of the class described by <code>objTypeMri</code> will be
     * considered as an instance of the structure.
     * @return true if this {@link RefStruct} is an instance of the structure
     * described by the <code>objTypeMri</code> metaobject
     */
    public boolean refIsInstanceOf( MRI objTypeMri, boolean considerSubtypes );

    /**
     * Returns the list of (String) field names contained in this struct.
     * 
     * @return the list of field names in this struct.
     */
    public List<String> refFieldNames( );

    /**
     * This operation returns the value of the specified field.
     * 
     * @param fieldName the name of the field for which the value is to be
     * returned.
     * @return the value of the specified field.
     */
    public Object refGetValue( String fieldName );

    /**
     * This operation returns the fully qualified name of the struct object�s
     * metaobject.
     * <p>
     * The List returned from this operation has copy semantics. That is, it
     * does not reflect any changes to the source after the operation is
     * executed, and it cannot be used to update the source.
     * 
     * @return the fully qualified name of the structs metaobject.
     */
    public List<String> refTypeName( );

    /**
     * Compares the struct object with another object. The comparison for
     * structs is based on attribute values. If two structs are of the same type
     * and all attributes have the same value, then they are equal.
     * 
     * @param other the other struct
     * @return true if this object and <code>other</code> are of the same type
     * and all attributes have the same value.
     */
    public boolean equals( Object other );
}
