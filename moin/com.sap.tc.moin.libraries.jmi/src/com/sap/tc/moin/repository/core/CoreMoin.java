package com.sap.tc.moin.repository.core;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Comparator;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.mmi.descriptors.ExtentDescriptor;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.transactionables.TransactionableFactory;

/**
 * Moin represents a single instance of the Modeling Infrastructure.
 * <p>
 * This interface is not intended to be implemented by clients.
 * 
 * @author d024227
 */
public interface CoreMoin extends SpiMoin {

    public CoreConnection getCurrentConnection( );

    /**
     * @return Returns the {@link JmiClassResolver}instance responsible for this
     * workspace. It provides methods for retrieving the {@link Class}of JMI
     * entities like packages, class proxies, associations, etc.
     */
    public JmiClassResolver getJmiClassResolver( );

    /**
     * Returns this Moin instance's wrapper.
     */
    public MoinWrapper getWrapper( );

    /**
     * Returns a comparator which compares the elements via their mof ids.
     * 
     * @return a comparator which compares the elements via their mof ids.
     */
    public Comparator<Partitionable> getByMofIdComparator( );

    public WorkspaceSet getWorkspaceSet( CompoundDataArea compoundDataArea );

    public SpiCompoundDataAreaManager getCompoundDataAreaManager( );

    /**
     * Returns the collection of all WorkspaceSet instances of this moin
     * instance. This is the original Collection, therefore DO NOT change it
     * (add or remove a value).
     * 
     * @return the collection of all WorkspaceSet instances of this moin
     * instance.
     */
    public Collection<WorkspaceSet> getWorkspaceSets( );

    /**
     * Returns the consistency notification thread for this MOIN instance.
     */
    public ConsistencyThread getConsistencyThread( );

    /**
     * Returns the eviction thread for this MOIN instance.
     */
    public EvictionThread getEvictionThread( );


    /**
     * Provides access to MOIN Core functionality.
     */
    public Core getCore( );

    // FIXME: new methods
    public MetamodelWorkspace getMetamodelWorkspace( );

    public SpiDataArea getMetamodelDataArea( );

    public ExtentManager getExtentManager( );

    public Extent getExtent( ExtentDescriptor extentDescriptor );

    public SpiClientSpec getMetamodelClientSpec( );

    public TransactionableFactory getTransactionableFactory( );

    public MicroTransactionableFactory getMicroTransactionableFactory( );

    public CoreEventFactory getEventFactory( );

    public CorePartitionable resolveMri( CoreSession session, MRI mri );

    public CoreModelPartition resolvePri( CoreSession session, PRI pri );

    public LogicalLinkManager getLogicalLinkManager( );

    public SpiJmiHelper getJmiHelper( );

    public SpiMetamodelRegistry getMetaModelRegistry( );

    public SpiPartitionSerializationManager getPartitionSerializationManager( );

    public void injectMofRomIntoFacility( );

    /**
     * The reference queue of the housekeeping thread.
     * 
     * @param <T>
     * @return
     */
    public <T> ReferenceQueue<T> getReferenceQueue( );

    /**
     * Returns all Sessions of all WorkspaceSets.
     * 
     * @return all Sessions
     */
    public Collection<SpiSession> getSessions( );

}
