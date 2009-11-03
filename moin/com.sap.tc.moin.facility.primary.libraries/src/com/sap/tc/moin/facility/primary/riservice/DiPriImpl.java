package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierFactoryImpl.DiResourceIdentifierFactoryImplWrapper;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;

/**
 * TODO update javadoc according to current syntax !! Extended MRI for NWDI
 * enabled facilities.
 * <p>
 * In addition to the elements of {@link MRI}the NwdiMRI has the following
 * elements
 * <ul>
 * <li>A development component which is build from a vendor id and name (refered
 * to as dcVendor and dcName below)</li>
 * </ul>
 * <a name="URIformat">The URI format of an NwdiMRI looks as follows: </a> <br>
 * MRI identifying an object in the same software component:
 * 
 * <pre>
 *         &lt;facility id for NWDI facility&gt;.&lt;id of the data area&gt;:DCs/&lt;dcVendor&gt;/&lt;dcName-Part1&gt;/.../&lt;dcName-Part-n&gt;/_comp/&lt;path&gt;#&lt;mofId&gt;
 * </pre>
 * <a name="examples">
 * <h3>Examples</h3> </a>
 * <ol>
 * <li>
 * 
 * <pre>
 *   
 *      NWDI.DefaultDataArea:DCs/com.sap/tc/moin/_comp/example/model/partitions/partition1
 * </pre>
 * </li>
 * <li>
 * 
 * <pre>
 *      NWDI.DefaultDataArea:DCs/com.sap/tc/moin/_comp/example/new_model/old_partitions/partition1#CCE171AF-0F27-155B-B32D-66DE8504
 * </pre>
 * </li>
 * </ol>
 * 
 * @author d026715
 */
public final class DiPriImpl implements PRI {

    private static final int INITIAL_CAPACITY = 128;

    private final DiResourceIdentifierFactoryImplWrapper riFactoryWrapper;

    private final CRI container;

    private final String partitionName;

    /**
     * Cache for toString().
     */
    private String cachedString = null;

    private PartitionNature nature;

    enum PartitionNature {
        METAMODEL_PARTITION, VOLATILE_PARTITION, NULL_PARTITION, NORMAL_PARTITION
    }

    /**
     * General constructor that can be used to set certain partition
     * characteristics (like volatile).
     */
    protected DiPriImpl( DiResourceIdentifierFactoryImplWrapper riFactory, CRI container, String partitionName, PartitionNature nature ) {

        this.riFactoryWrapper = riFactory;
        this.container = container;
        this.partitionName = partitionName;
        this.nature = nature;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return this.container.getDataAreaDescriptor( );
    }

    @Override
    public String toString( ) {

        if ( this.cachedString == null ) {
            StringBuilder result = new StringBuilder( INITIAL_CAPACITY );
            result.append( this.container.getDataAreaDescriptor( ).getFacilityId( ) );
            result.append( DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
            result.append( this.container.getDataAreaDescriptor( ).getDataAreaName( ) );
            result.append( DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
            // DC
            result.append( DiResourceIdentifierConstants.DC_NAME_PART_PREFIX );
            result.append( this.container.getContainerName( ) );
            // partition name
            result.append( DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX );
            result.append( this.partitionName );
            this.cachedString = result.toString( ).intern( );
        }
        return this.cachedString;
    }

    public MRI createMri( String mofId ) {

        DiResourceIdentifierFactoryImpl riFactoryImpl = this.riFactoryWrapper.getRiFactory( );

        if ( riFactoryImpl == null ) {
            throw new MoinIllegalStateException( RiServiceMessages.CREATION_FAILED_FACILITY_NOT_ALIVE, "MRI" ); //$NON-NLS-1$
        }

        return riFactoryImpl.createMri( this, mofId );
    }

    public CRI getCri( ) {

        return this.container;
    }

    public boolean isMetaModelPartition( ) {

        return this.nature == PartitionNature.METAMODEL_PARTITION;
    }

    public boolean isNullPartition( ) {

        return this.nature == PartitionNature.NULL_PARTITION;
    }

    public boolean isVolatilePartition( ) {

        return ( this.nature == PartitionNature.VOLATILE_PARTITION || this.nature == PartitionNature.NULL_PARTITION );
    }

    public String getContainerName( ) {

        return this.container.getContainerName( );
    }

    public String getPartitionName( ) {

        return this.partitionName;
    }
}
