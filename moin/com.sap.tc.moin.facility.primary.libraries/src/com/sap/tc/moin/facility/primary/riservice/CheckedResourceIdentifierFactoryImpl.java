package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.facility.SpiResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 * A validation proxy for {@link ResourceIdentifierFactory} implementations
 * which performs certain dynmic checks to prevent the creation of 'illegal'
 * resource identifiers.
 * <p>
 * Facility external users should always obtain a checked
 * {@link ResourceIdentifierFactory} variant. Facility internal components can
 * use an unchecked version in most cases to avoid unnecessary checks.
 * 
 * @author d047015
 * @see ResourceIdentifierVerifier
 */
public class CheckedResourceIdentifierFactoryImpl implements SpiResourceIdentifierFactory, IpiFacilityComponent {

    /**
     * Wrapped {@link ResourceIdentifierFactory} instance which produces
     * unchecked RI products.
     */
    private SpiResourceIdentifierFactory riFactory;

    private ResourceIdentifierVerifier riVerifier;

    private IpiFsResourceManagement fsResourceHandler;

    private SpiPartitionNameVerifier partitionSerializationManager;

    public CheckedResourceIdentifierFactoryImpl( ) {

    }

    public void bind( IpiFsResourceManagement fsResourceHandler ) {

        this.fsResourceHandler = fsResourceHandler;
    }

    public void bind( SpiPartitionNameVerifier serializationManager ) {

        this.partitionSerializationManager = serializationManager;
    }

    public void bind( SpiResourceIdentifierFactory riFactory ) {

        this.riFactory = riFactory;
    }

    public void initialize( ) {

        this.riVerifier = new DiResourceIdentifierVerifierImpl( this.fsResourceHandler, this.partitionSerializationManager );
    }

    public void tearDown( ) {

        this.riVerifier = null;
    }

    public void finalizeStartup( ) {

    }

    public LRI createLri( String lri ) throws InvalidResourceIdentifierException {

        // just delegate - no dynamic checks to be performed on LRIs    
        return this.riFactory.createLri( lri );
    }

    public LRI createLri( String dataAreaName, String mofId ) {

        // just delegate - no dynamic checks to be performed on LRIs
        return this.riFactory.createLri( dataAreaName, mofId );
    }

    public MRI createMri( String mriString ) throws InvalidResourceIdentifierException {

        // delegate PRI creation
        MRI createdMri = this.riFactory.createMri( mriString );
        // perform dynamic checks on created PRI
        this.riVerifier.performDynamicValidation( createdMri.getPri( ) );

        return createdMri;
    }

    public MRI createMri( String dataAreaName, String containerName, String partitionName, String mofId ) {

        // delegate PRI creation
        MRI createdMri = this.riFactory.createMri( dataAreaName, containerName, partitionName, mofId );
        // perform dynamic checks on created PRI
        this.riVerifier.performDynamicValidation( createdMri.getPri( ) );

        return createdMri;
    }

    public PRI createPri( String priString ) throws InvalidResourceIdentifierException {

        // delegate PRI creation
        PRI createdPri = this.riFactory.createPri( priString );
        // perform dynamic checks on created PRI
        this.riVerifier.performDynamicValidation( createdPri );

        return createdPri;
    }

    public PRI createPri( String dataAreaName, String containerName, String partitionName ) {

        // delegate PRI creation
        PRI createdPri = this.riFactory.createPri( dataAreaName, containerName, partitionName );
        // perform dynamic checks on created PRI
        this.riVerifier.performDynamicValidation( createdPri );

        return createdPri;
    }

    public PRI createNullPri( DataAreaDescriptor descriptor, String partitionName ) {

        // just delegate - no dynamic checks to be performed on null partitions
        return this.riFactory.createNullPri( descriptor, partitionName );
    }

    public PRI createVolatilePri( DataAreaDescriptor descriptor, String partitionName ) {

        // just delegate - no dynamic checks to be performed on volatile partitions
        return this.riFactory.createVolatilePri( descriptor, partitionName );
    }

    public CRI createCri( String cri ) throws InvalidResourceIdentifierException {

        // just delegate - no dynamic checks to be performed on CRIs
        return this.riFactory.createCri( cri );
    }

    public CRI createCri( String dataAreaName, String containerName ) {

        // just delegate - no dynamic checks to be performed on CRIs
        return this.riFactory.createCri( dataAreaName, containerName );
    }

}
