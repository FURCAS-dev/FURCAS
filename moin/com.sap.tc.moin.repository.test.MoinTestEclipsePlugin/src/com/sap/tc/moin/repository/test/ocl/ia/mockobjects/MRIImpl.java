package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * Dummy implementation of MRI
 */
public class MRIImpl implements MRI {

    private RefFeatured object;

    /**
     * @param object
     */
    public MRIImpl( RefFeatured object ) {

        super( );
        this.object = object;
    }

    /**
     * @return Returns the object.
     */
    public RefFeatured resolve( ) {

        return this.object;
    }

    public String getMofId( ) {

        return this.object.refMofId( );
    }

    @Override
    public boolean equals( Object arg0 ) {

        if ( arg0 instanceof MRIImpl ) {
            return getMofId( ).equals( ( (MRIImpl) arg0 ).getMofId( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return getMofId( ).hashCode( );
    }

    @Override
    public String toString( ) {

        return this.object.toString( );
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return new DataAreaDescriptor( ) {

            public String getFacilityId( ) {

                return "Dummy";
            }

            public String getDataAreaName( ) {

                return "Dummy";
            }

            public boolean isMetamodelDataArea( ) {

                return false;
            }

        };
    }

    public LRI getLri( ) {

        // TODO Auto-generated method stub
        return null;
    }

    public String getPartitionName( ) {

        return "Dummy";
    }

    public String getContainerName( ) {

        return "Dummy";
    }

    public PRI getPri( ) {

        // TODO Auto-generated method stub
        return null;
    }

    public CRI getCri( ) {

        // TODO Auto-generated method stub
        return null;
    }
}
