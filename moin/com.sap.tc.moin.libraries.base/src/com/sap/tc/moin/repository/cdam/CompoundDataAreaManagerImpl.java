/**
 * 
 */
package com.sap.tc.moin.repository.cdam;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;


/**
 * Basic implementation of the {@link CompoundDataAreaManager} and
 * {@link SpiCompoundDataAreaManager} interfaces.
 * <p>
 * This class provides the platform-independent implementation parts of the
 * CDAM. It can be used as is for simple scenarios (build, standalone) or
 * extended by platform-specific CDAM implementations which add convenience
 * functionality. The current implementation has limitations with respect to
 * multi-client support.
 * 
 * @author d026715
 * @author d032434
 */
public class CompoundDataAreaManagerImpl implements SpiCompoundDataAreaManager {

    private Map<String, CompoundDataArea> compoundDataAreas = new HashMap<String, CompoundDataArea>( );

    private Map<String /* compoundclientspecid */, CompoundClientSpec> compoundClientSpecs = new HashMap<String, CompoundClientSpec>( );

    private Map<CompoundDataArea, Set<String/* compoundclientspecid */>> compoundClientSpecIds = new HashMap<CompoundDataArea, Set<String>>( );

    private DataArea metaModelDataArea;

    private ClientSpec transientClientSpec;

    public void initializeMetamodelDataAreas( Collection<Facility> facilities ) {

        // initialize meta model data areas
        SpiFacility spiFacility = null;
        if ( this.metaModelDataArea == null ) {
            for ( Facility facility : facilities ) {
                spiFacility = (SpiFacility) facility;
                DataArea foundMetaModelDataArea = spiFacility.getMetamodelDataArea( );
                if ( foundMetaModelDataArea != null ) {
                    if ( this.metaModelDataArea == null ) {
                        this.metaModelDataArea = foundMetaModelDataArea;
                    } else {
                        throw new MoinIllegalStateException( RepositoryCdamMessages.MORETHANONEMETAMODELFACILITYFOUND );
                    }
                }
                ClientSpec foundTransientClientSpec = spiFacility.getTransientClientSpec( );
                if ( foundTransientClientSpec != null ) {
                    if ( this.transientClientSpec == null ) {
                        this.transientClientSpec = foundTransientClientSpec;
                    } else {
                        throw new MoinIllegalStateException( RepositoryCdamMessages.MORETHANONEMETAMODELFACILITYFOUND );
                    }
                }
            }
        }
    }

    protected void addCompoundDataArea( CompoundDataArea cda ) {

        this.compoundDataAreas.put( cda.getName( ), cda );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.cdam.build.BuildCompoundDataAreaManager#
     * getDefaultCompoundClientSpec(com.sap.tc.moin.repository.ClientSpec)
     */
    public CompoundClientSpec getDefaultCompoundClientSpec( ClientSpec clientSpec ) {

        // Precondition checks for API method:
        if ( clientSpec == null ) {
            throw new MoinIllegalNullArgumentException( "clientSpec" ); //$NON-NLS-1$
        }

        if ( clientSpec.getDataArea( ).getDescriptor( ).isMetamodelDataArea( ) ) {
            throw new MoinIllegalArgumentException( RepositoryCdamMessages.CLIENTSPECMUSTNOTBELONGTOMETAMODELDATAAREA );
        }

        // TODO: CompoundClientSpec is always newly created - check cache usage (verify that invalidation is correct)
        // create and initialize compound data area
        CompoundDataAreaImpl newCompoundDataArea = new CompoundDataAreaImpl( this, clientSpec.getDataArea( ).getName( ), this.metaModelDataArea );
        newCompoundDataArea.addDataArea( clientSpec.getDataArea( ) );
        addCompoundDataArea( newCompoundDataArea );

        // create compound client spec
        CompoundClientSpec newCompoundClientSpec = new CompoundClientSpecImpl( newCompoundDataArea, clientSpec );

        // TODO: compound client-spec ID is equal to single client-spec ID; can cause clashes in multi-facility scenarios
        this.addCompoundClientSpec( newCompoundDataArea, newCompoundClientSpec );

        return newCompoundClientSpec;
    }

    public Collection<String> getCompoundDataAreaNames( ) {

        return this.compoundDataAreas.keySet( );
    }

    public CompoundDataArea getCompoundDataArea( String compoundDataAreaName ) {

        return this.compoundDataAreas.get( compoundDataAreaName );
    }

    public Collection<String> getCompoundClientNames( CompoundDataArea dataArea ) {

        Set<String> clientSpecIdsPerDataArea = this.compoundClientSpecIds.get( dataArea );
        if ( clientSpecIdsPerDataArea != null ) {
            return clientSpecIdsPerDataArea;
        }
        return null;
    }

    public CompoundClientSpec getCompoundClientSpec( String id ) {

        return this.compoundClientSpecs.get( id );
    }

    /**
     * @see com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager#reset()
     * TODO: this is never called - check the purpose!
     */
    public void reset( ) {

        compoundDataAreas.clear( );
        compoundClientSpecs.clear( );
        compoundClientSpecIds.clear( );
    }

    /**
     * @see com.sap.tc.moin.repository.cdam.CompoundDataAreaManager#getCompoundClientSpecTransientOnly()
     */
    public CompoundClientSpec getCompoundClientSpecTransientOnly( ) {

        return this.getDefaultCompoundClientSpec( this.transientClientSpec );
    }

    protected void addCompoundClientSpec( CompoundDataArea compoundDataArea, CompoundClientSpec compoundClientSpec ) {

        this.compoundClientSpecs.put( compoundClientSpec.getId( ), compoundClientSpec );

        Set<String> compoundClientSpecIdsPerDataArea = this.compoundClientSpecIds.get( compoundDataArea );
        if ( compoundClientSpecIdsPerDataArea == null ) {
            compoundClientSpecIdsPerDataArea = new HashSet<String>( );
            this.compoundClientSpecIds.put( compoundDataArea, compoundClientSpecIdsPerDataArea );
            compoundClientSpecIdsPerDataArea.add( compoundClientSpec.getId( ) );
        }
    }

    protected DataArea getMetaModelDataArea( ) {

        return metaModelDataArea;
    }
}
