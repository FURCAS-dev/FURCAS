package com.sap.tc.moin.repository.mmi.descriptors;

import java.util.Arrays;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * This is the abstract base class for all descriptors of metamodel elements
 * (like attributes or references of a {@link MofClass}).
 */
public abstract class MetamodelElementDescriptor<T extends RefBaseObject> {

    private final String mofId;

    private final String[] qualifiedName;

    private final String modelContainerName;

    public MetamodelElementDescriptor( String mofId, String modelContainerName, String... qualifiedName ) {

        this.mofId = mofId;
        this.modelContainerName = modelContainerName;
        this.qualifiedName = qualifiedName;
    }

    /**
     * Returns the MOF id of the metamodel element.
     * 
     * @return the MOF id of the metamodel element
     */
    public String getMofId( ) {

        return mofId;
    }

    /**
     * Returns the qualified name of the metamodel element.
     * 
     * @return the qualified name of the metamodel element
     */
    public String[] getQualifiedName( ) {

        return qualifiedName;
    }

    /**
     * Returns the name of the metamodel element.
     * 
     * @return the name of the metamodel element
     */
    public String getName( ) {

        return qualifiedName[qualifiedName.length - 1];
    }

    /**
     * Returns the metamodel container name of the metamodel element.
     * 
     * @return the metamodel container name of the metamodel element
     */
    public String getModelContainerName( ) {

        return modelContainerName;
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( modelContainerName == null ) ? 0 : modelContainerName.hashCode( ) );
        result = prime * result + ( ( mofId == null ) ? 0 : mofId.hashCode( ) );
        result = prime * result + Arrays.hashCode( qualifiedName );
        return result;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final MetamodelElementDescriptor other = (MetamodelElementDescriptor) obj;
        if ( modelContainerName == null ) {
            if ( other.modelContainerName != null ) {
                return false;
            }
        } else if ( !modelContainerName.equals( other.modelContainerName ) ) {
            return false;
        }
        if ( mofId == null ) {
            if ( other.mofId != null ) {
                return false;
            }
        } else if ( !mofId.equals( other.mofId ) ) {
            return false;
        }
        if ( !Arrays.equals( qualifiedName, other.qualifiedName ) ) {
            return false;
        }
        return true;
    }
}