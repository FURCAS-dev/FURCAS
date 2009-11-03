package com.sap.tc.moin.repository.mmi.descriptors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

/**
 * Represents a {@link StructureField} of a {@link StructureType}.
 */
public class StructureFieldDescriptor<MOF_TYPE extends StructureField, CONTAINER_TYPE extends RefStruct, VALUE_TYPE> extends MetamodelElementDescriptor<MOF_TYPE> {

    public StructureFieldDescriptor( String mofId, String modelContainerName, String[] qualifiedName ) {

        super( mofId, modelContainerName, qualifiedName );
    }

    /**
     * Returns the {@link StructureFieldDescriptor structure field descriptor}
     * of the field with the given name of the given structure.
     * 
     * @param refStruct the structure that contains the field with the given
     * name
     * @param fieldName the name of the field for which the descriptor should be
     * returned
     * @return the {@link StructureFieldDescriptor structure field descriptor}
     * for the given field name and structure or <code>null</code> if the field
     * with the given name does not exist in the structure.
     */
    @SuppressWarnings( "unchecked" )
    public static <MOF_TYPE extends StructureField, T extends RefStruct, VALUE_TYPE> StructureFieldDescriptor<MOF_TYPE, ? super T, VALUE_TYPE> getDescriptor( T refStruct, String fieldName ) {

        try {
            Object descriptor = refStruct.getClass( ).getField( "DESCRIPTORS" ).get( null ); //$NON-NLS-1$

            Method[] methods = descriptor.getClass( ).getDeclaredMethods( );
            for ( Method method : methods ) {
                // Check for methods that return a "StructureFieldDescriptor" and have 0 parameters
                if ( method.getReturnType( ).equals( StructureFieldDescriptor.class ) && method.getParameterTypes( ).length == 0 ) {
                    StructureFieldDescriptor<MOF_TYPE, ? super T, VALUE_TYPE> sfd = (StructureFieldDescriptor<MOF_TYPE, ? super T, VALUE_TYPE>) method.invoke( descriptor );
                    if ( sfd.getName( ).equals( fieldName ) ) {
                        return sfd;
                    }
                }
            }
        } catch ( NoSuchFieldException e ) {
            return null;
        } catch ( IllegalAccessException e ) {
            return null;
        } catch ( InvocationTargetException e ) {
            return null;
        }

        return null;
    }
}
