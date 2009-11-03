package com.sap.tc.moin.repository.mmi.descriptors;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

/**
 * This class acts as a container for fields of structures and their values.<br>
 * With the {@link #put(StructureFieldDescriptor, Object)} method values for a
 * specific field can be specified.<br>
 * The usage of this class of for creation of structured. Upon creation of the
 * structure, all fields specified via the
 * {@link #put(StructureFieldDescriptor, Object)} method will be initialized
 * with the specified values. All other fields of the new structure will receive
 * their default valued. These default valued are either the defaults of the
 * Java type (e.g. 0 for "int") or the initializer value specified in the
 * metamodel.
 * 
 * @author d024032
 * @param <T> the type of the structure for which the field valued shall be
 * specified.
 */
public class StructureFieldContainer<T extends RefStruct> {

    private Map<StructureFieldDescriptor<?, ? super T, ?>, Object> content = new LinkedHashMap<StructureFieldDescriptor<?, ? super T, ?>, Object>( );

    /**
     * Adds a new field value to the container.
     * 
     * @param <MOF_TYPE> The type of the field (provided via the "descriptor"
     * parameter)
     * @param <VALUE_TYPE> The type provided value (provided via the "value"
     * parameter)
     * @param descriptor The {@link StructureFieldDescriptor} of the field for
     * which a value shall be stored
     * @param value The value that the specified files shall have
     * @return the StructureFieldContainer itself
     */
    public <MOF_TYPE extends StructureField, VALUE_TYPE> StructureFieldContainer<T> put( StructureFieldDescriptor<MOF_TYPE, ? super T, VALUE_TYPE> descriptor, VALUE_TYPE value ) {

        content.put( descriptor, value );
        return this;
    }

    /**
     * Copies all field values of a given structure to the container.
     * 
     * @param refStruct the structure that contains the values that shall be
     * copied to the container
     * @return the container with the copied fields
     */
    public StructureFieldContainer<T> put( T refStruct ) {

        List<String> fieldNames = refStruct.refFieldNames( );
        for ( String fieldName : fieldNames ) {
            StructureFieldDescriptor<?, ? super T, ?> descriptor = StructureFieldDescriptor.getDescriptor( refStruct, fieldName );
            if ( descriptor != null ) {
                content.put( descriptor, refStruct.refGetValue( fieldName ) );
            }
        }
        return this;
    }

    /**
     * Returns a {@link Map} of all field descriptors and values that have been
     * set via the {@link #put(StructureFieldDescriptor, Object)} method.
     * 
     * @return a {@link Map} of all field descriptors and their values
     */
    public Map<StructureFieldDescriptor<?, ? super T, ?>, Object> getFields( ) {

        return content;
    }

    /**
     * Returns a {@link Map} of all fields and values.
     * 
     * @return a {@link Map} of all fields and their values
     */
    public Map<String, Object> getNamedFields( ) {
        Map<String, Object> result = new HashMap<String, Object>( content.size( ) );
        for ( Entry<StructureFieldDescriptor<?, ? super T, ?>, Object> field : content.entrySet( ) ) {
            result.put( field.getKey( ).getName( ), field.getValue( ) );
        }
        return result;
    }
}
