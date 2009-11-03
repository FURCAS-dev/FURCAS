package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.jmi.extension.RefStructExtension;
import com.sap.tc.moin.repository.shared.util.ObjectMethodsHelper;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;

public abstract class RefStructImpl implements RefStruct, RefStructExtension, SpiStructuredValue {

    /***************************************************************************
     * mandatory attributes which need to be set
     **************************************************************************/

    protected RefObject ___metaObject;

    /***************************************************************************
     * constructors
     **************************************************************************/

    public RefStructImpl( ) {

    }

    public RefStructImpl( Object workspace, RefObject metaObject ) {

        /*
         * The following sequence of calls is absolutely crucial for the
         * initialization process to work. Be careful with changes here!
         */
        set___MetaObject( metaObject );
    }

    /***************************************************************************
     * getters and setters
     **************************************************************************/

    protected abstract List<String> ___getTypeName( );

    protected abstract List<String> ___getFieldNames( );

    public final RefObject get___MetaObject( ) {

        return this.___metaObject;
    }

    public final void set___MetaObject( RefObject metaObject ) {

        ___metaObject = metaObject;
    }

    /***************************************************************************
     * ref methods
     **************************************************************************/

    public MRI refMetaObjectMri( ) {

        return ___metaObject.get___Mri( );
    }

    public boolean refIsInstanceOf( MRI objTypeMri, boolean considerSubtypes ) {

        boolean result = false;
        StructureTypeImpl refMetaObject = (StructureTypeImpl) get___MetaObject( );
        MRI mriRefMetaObject = refMetaObject.get___Mri( );
        result = mriRefMetaObject.equals( objTypeMri );
        if ( !result && considerSubtypes ) {
            List<GeneralizableElement> allSupertypes = refMetaObject.allSupertypes( null );
            for ( int i = 0; !result && i < allSupertypes.size( ); i++ ) {
                result = allSupertypes.get( i ).get___Mri( ).equals( objTypeMri );
            }
        }
        return result;
    }

    public final List<String> refFieldNames( ) {

        return ___getFieldNames( );
    }

    public final List<String> refTypeName( ) {

        return ___getTypeName( );
    }

    /*
     * has to be overwritten
     */
    public abstract Object refGetValue( String fieldName );

    /***************************************************************************
     * java.lang.Object level methods
     **************************************************************************/

    @Override
    public final int hashCode( ) {

        int result = 17;
        List<String> typeName = ___getTypeName( );
        if ( typeName != null ) {
            for ( int i = 0, n = typeName.size( ); i < n; i++ ) {
                String namePart = typeName.get( i );
                result = 37 * result + ( namePart != null ? namePart.hashCode( ) : 0 );
            }
        }
        List<String> fieldNames = ___getFieldNames( );
        if ( fieldNames != null ) {
            for ( int i = 0, n = fieldNames.size( ); i < n; i++ ) {
                Object value = refGetValue( fieldNames.get( i ) );
                result = 37 * result + ( value != null ? value.hashCode( ) : 0 );
            }
        }
        return result;
    }

    @Override
    public final boolean equals( Object o ) {

        if ( o == this ) {
            return true;
        }
        boolean result = false;
        if ( o instanceof RefStructImpl ) {
            RefStructImpl other = (RefStructImpl) o;
            if ( ObjectMethodsHelper.equals( get___MetaObject( ), other.get___MetaObject( ) ) && ObjectMethodsHelper.equals( refFieldNames( ), other.refFieldNames( ) ) && ObjectMethodsHelper.equals( get___FieldValues( ), other.get___FieldValues( ) ) ) {
                result = true;
            }
        } else if ( o instanceof RefStruct ) {
            RefStruct refStruct = (RefStruct) o;
            if ( ObjectMethodsHelper.equals( refTypeName( ), refStruct.refTypeName( ) ) && ObjectMethodsHelper.equals( refFieldNames( ), refStruct.refFieldNames( ) ) ) {
                for ( Iterator i = refFieldNames( ).iterator( ); i.hasNext( ); ) {
                    String fieldName = (String) i.next( );
                    if ( refGetValue( fieldName ).equals( refStruct.refGetValue( fieldName ) ) ) {
                        if ( !i.hasNext( ) ) {
                            result = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( "(RefStruct" ); //$NON-NLS-1$
        result.append( " " ); //$NON-NLS-1$
        if ( this.___metaObject != null ) {
            result.append( "\"" ); //$NON-NLS-1$
            for ( Iterator i = refTypeName( ).iterator( ); i.hasNext( ); ) {
                String name = (String) i.next( );
                result.append( name + ( i.hasNext( ) ? "::" : "" ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            result.append( "\"" ); //$NON-NLS-1$
        } else {
            result.append( "\"<?>\"" ); //$NON-NLS-1$
        }
        result.append( " " ); //$NON-NLS-1$
        result.append( ObjectMethodsHelper.toString( "", "", get___FieldValues( ), 30, 120, ",", "=" ) ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        result.append( ")" ); //$NON-NLS-1$
        return result.toString( );
    }

    /***************************************************************************
     * private methods
     **************************************************************************/

    private Map get___FieldValues( ) {

        List<String> fieldNames = ___getFieldNames( );
        Map<String, Object> fieldValues = new HashMap<String, Object>( Utilities.calcInitialCapacity( fieldNames.size( ) ) );
        for ( int i = 0, n = fieldNames.size( ); i < n; i++ ) {
            String fieldName = fieldNames.get( i );
            fieldValues.put( fieldName, refGetValue( fieldName ) );
        }
        return fieldValues;
    }

    public void initialize___Values( CoreConnection connection ) {

        // meaningful implementation in subclasses
    }

    //
    // Custom Parser / Serializer methods
    //

    public Collection<String> get___FieldNames( ) {

        return ___getFieldNames( );
    }

    public Object get___FieldValue( String fieldName ) {

        Object value = refGetValue( fieldName );
        if ( value != null ) {
            if ( value instanceof SpiStructuredValue ) {
                return value;
            }
            return value.toString( );
        }
        return null;
    }

    public SpiStructureType get___Type( ) {

        return (SpiStructureType) ( (CorePartitionable) ___metaObject ).get___Workspace( ).getWorkspaceSet( ).getMoin( ).getCore( ).getMetamodelService( ).getSpiType( (Classifier) this.___metaObject );
    }
}