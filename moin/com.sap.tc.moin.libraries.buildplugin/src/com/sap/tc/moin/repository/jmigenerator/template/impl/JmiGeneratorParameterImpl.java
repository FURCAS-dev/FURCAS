package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;

public class JmiGeneratorParameterImpl implements JmiGeneratorParameter {

    String name = null;

    String type = null;

    String typeParameter = null;

    boolean isArray = false;

    boolean needsUnwrapping = true;

    private JmiGeneratorClassOperation operation;

    private boolean isPartitionParameter;

    private boolean isMultiple;

    private boolean isObjectTyped;

    public JmiGeneratorParameterImpl( String aName, String aType, String aTypeParameter ) {

        name = aName;
        type = aType;
        typeParameter = aTypeParameter;
        isArray = false;
        isPartitionParameter = ( aType.equals( ModelPartition.class.getName( ) ) );
    }

    public JmiGeneratorParameterImpl( JmiGeneratorClassOperation operation, String aName, String aType, String aTypeParameter, boolean isMultiple, boolean isObjectTyped ) {

        this( aName, aType, aTypeParameter );
        this.operation = operation;
        this.isMultiple = isMultiple;
        this.isObjectTyped = isObjectTyped;
    }

    public JmiGeneratorClassOperation getOperation( ) {

        return operation;
    }

    public void setArray( boolean anIsArray ) {

        isArray = anIsArray;
    }

    public String getName( ) {

        return name;
    }

    public String getType( ) {

        return type;
    }

    public String getJavaType( ) {

        return getJavaType( type );
    }

    public String getTypeParameter( ) {

        return typeParameter;
    }

    public boolean isArray( ) {

        return isArray;
    }

    public void setNeedsToBeUnwrapped( boolean needsUnwrapping ) {

        this.needsUnwrapping = needsUnwrapping;
    }

    public boolean isNeedsToBeUnwrapped( ) {

        return needsUnwrapping;
    }

    public static String getJavaType( String type ) {

        if ( type.equals( "boolean" ) ) { //$NON-NLS-1$
            return Boolean.class.getName( );
        }
        if ( type.equals( "int" ) ) { //$NON-NLS-1$
            return Integer.class.getName( );
        }
        if ( type.equals( "double" ) ) { //$NON-NLS-1$
            return Double.class.getName( );
        }
        if ( type.equals( "long" ) ) { //$NON-NLS-1$
            return Long.class.getName( );
        }
        if ( type.equals( "float" ) ) { //$NON-NLS-1$
            return Float.class.getName( );
        }
        return type;
    }

    @Override
    public String toString( ) {

        return getName( );
    }

    public boolean isPartitionParameter( ) {

        return isPartitionParameter;
    }

    public boolean isMultiple( ) {

        return isMultiple;
    }

    public boolean isObjectTyped( ) {

        return isObjectTyped;
    }
}