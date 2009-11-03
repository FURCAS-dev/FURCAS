package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierFactoryImpl.DiResourceIdentifierFactoryImplWrapper;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
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
 *             &lt;facility id for NWDI facility&gt;.&lt;id of the data area&gt;:DCs/&lt;dcVendor&gt;/&lt;dcName-Part1&gt;/.../&lt;dcName-Part-n&gt;/_comp/&lt;path&gt;#&lt;mofId&gt;
 * </pre>
 * <a name="examples">
 * <h3>Examples</h3> </a>
 * <ol>
 * <li>
 * 
 * <pre>
 *       
 *          NWDI.DefaultDataArea:DCs/com.sap/tc/moin/_comp/example/model/partitions/partition1
 * </pre>
 * </li>
 * <li>
 * 
 * <pre>
 *          NWDI.DefaultDataArea:DCs/com.sap/tc/moin/_comp/example/new_model/old_partitions/partition1#CCE171AF-0F27-155B-B32D-66DE8504
 * </pre>
 * </li>
 * </ol>
 * 
 * @author d026715
 */
public final class DiMriImpl implements MRI {

    private static final int INITIAL_CAPACITY = 128;

    private final PRI partition;

    private final DiResourceIdentifierFactoryImplWrapper riFactoryWrapper;

    private final String mofId;

    /**
     * Cache for toString().
     */
    private String cachedString = null;

    /**
     * Cache for getLri().
     */
    private LRI cachedLri = null;

    /**
     * @param riFactoryWrapper
     * @param partition
     * @param mofId INTERNED!!! MOF-Id
     */
    protected DiMriImpl( DiResourceIdentifierFactoryImplWrapper riFactoryWrapper, PRI partition, String mofId ) {

        this.riFactoryWrapper = riFactoryWrapper;
        this.partition = partition;
        this.mofId = mofId;
    }

    /**
     * @see com.sap.tc.moin.repository.MRI#getContainerName()
     */
    public String getContainerName( ) {

        // in NWDI, this is the full DC name
        return this.partition.getContainerName( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.facilities.nwdi.NwdiMri#getPartitionName()
     */
    public String getPartitionName( ) {

        return this.partition.getPartitionName( );
    }

    /**
     * Returns the MOF id.
     * <p>
     * Examples (see <a href="#examples">above </a>)
     * <ol>
     * <li><i>null </i></li>
     * <li>CCE171AF-0F27-155B-B32D-66DE8504</li>
     * </ol>
     * 
     * @return MOF id.
     */
    public String getMofId( ) {

        return this.mofId;
    }

    @Override
    public String toString( ) {

        if ( this.cachedString == null ) {
            StringBuilder result = new StringBuilder( INITIAL_CAPACITY );

            result.append( this.partition.toString( ) );

            // mof id
            if ( this.mofId != null ) {
                result.append( DiResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR );
                result.append( this.mofId );
            }

            this.cachedString = result.toString( );
        }
        return this.cachedString;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return this.partition.getDataAreaDescriptor( );
    }

    public PRI getPri( ) {

        return this.partition;
    }

    public CRI getCri( ) {

        return this.partition.getCri( );
    }

    public LRI getLri( ) {

        if ( this.cachedLri == null ) {
            DiResourceIdentifierFactoryImpl riFactoryImpl = this.riFactoryWrapper.getRiFactory( );

            if ( riFactoryImpl == null ) {
                throw new MoinIllegalStateException( RiServiceMessages.CREATION_FAILED_FACILITY_NOT_ALIVE, "LRI" ); //$NON-NLS-1$
            }

            this.cachedLri = riFactoryImpl.createLri( this.partition.getDataAreaDescriptor( ), this.mofId );
        }
        return this.cachedLri;
    }
}