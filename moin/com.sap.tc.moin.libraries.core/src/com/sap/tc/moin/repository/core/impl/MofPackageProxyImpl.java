package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

public class MofPackageProxyImpl implements MofPackageProxy, MofPackageProvider {

    // logging
    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, MofPackageProxyImpl.class );

    private MofPackage _mofPackage;

    private MRI _mofPackageMri;

    private String _mofPackageName;

    private MetamodelWorkspace _metamodelWorkspace;

    /**
     * Constructs a MOF package proxy for the package identified by the specifed
     * MRI. The MRI is always resolved in the context of the
     * <em>active workspacey</em>.
     */
    public MofPackageProxyImpl( MRI mofPackageMri, String mofPackageName, MetamodelWorkspace metamodelWorkspace ) {

        super( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "NwdiMofPackageProxyImpl<init>, {0}, {1}", mofPackageMri, mofPackageName ); //$NON-NLS-1$
        }
        _metamodelWorkspace = metamodelWorkspace;
        _mofPackageMri = mofPackageMri;
        _mofPackageName = mofPackageName;

    }

    /**
     * Resolve into a MofPackage
     * 
     * @return the MofPackage to be resolved
     */
    public MofPackage resolveMofPackage( ) {

        // get the active workspace and resolve the MRI manually; the
        // resolveElementMri() tries to resolve it in the
        // current client context, but we have to ensure that this works without
        // a current connection
        // TODO: Be will not support working with MOIN without Connection
        // therefore use current connection
        // and resolveLri
        //NwdiFacilityImpl nwdiFacility = (NwdiFacilityImpl) _nwdiDataArea.getFacility();
        // ORG String metaModelWorkspaceID =
        // nwdiFacility.getMetaModelWorkspaceID();
        // ORG SpiWorkspace metaModelWs = nwdiFacility.getWorkspace(
        // _nwdiDataArea.getName(), metaModelWorkspaceID );
        SpiPartitionable element = null;
        try {
            // make sure the partition is loaded
            // ORG metaModelWs.getPartition( _mofPackageMri.getPri(), true );
            // ORG element = metaModelWs.getInstanceManager().getInstance(
            // _mofPackageMri.getLri() );
            element = _metamodelWorkspace.resolveElementMri( _mofPackageMri );
            if ( element == null ) {
                throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.CANNOTRESOLVEMOFPACKAGEMRI, _mofPackageMri );
            }
            _mofPackage = (MofPackage) element;
        } catch ( ClassCastException e ) {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.CANNOTRESOLVEMOFPACKAGEMRIRESOLVEDELEMENTNOTINSTANCEOF, _mofPackageMri, element, MofPackage.class );
        }

        finally {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "NwdiMofPackageProxyImpl.resolveMofPackage() {0}", _mofPackage ); //$NON-NLS-1$
            }
        }
        return _mofPackage;
    }

    /**
     * @see com.sap.tc.moin.repository.spi.MofPackageProxy#getPackage()
     */
    public MofPackage getPackage( ) {

        try {
            if ( _mofPackage == null ) {
                if ( _mofPackageName == null ) {
                    throw new RuntimeException( );//_mofPackage = resolveMofPackage( );
                } else {
                    _mofPackage = new MofPackageProxyFactory( ).create( _mofPackageName, _mofPackageMri, this );
                }
            }
        } finally {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "NwdiMofPackageProxyImpl.getPackage()" + " [" + this + "] {0}", _mofPackage ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }

        return _mofPackage;
    }

//    /**
//     * @see com.sap.tc.moin.repository.spi.MetaModelContainer#getTopLevelPackages()
//     */
//    public Collection getTopLevelPackages( ) throws FacilityException {
//
//        // does not make sense for package proxies
//        throw new UnsupportedOperationException( "Method getUsedContainers is not supported for MofPackageProxy instances." );
//    }

    public MRI getMofPackageMri( ) {

        return _mofPackageMri;
    }

    /**
     * @see com.sap.tc.moin.repository.spi.ModelContentContainer#getName()
     */
    public String getName( ) {

        // the MRI is unique within the DA (for now)
        // TODO: shall we use something more speaking here? Check spec of
        // ModelElement.getName()/QualifiedName()
        //return _mofPackageName != null ? _mofPackageName : getPackage( ).getName( );
        return _mofPackageName;
    }

//    /**
//     * @see com.sap.tc.moin.repository.spi.ModelContentContainer#getUsedContainers()
//     */
//    public Collection getUsedContainers( ) throws FacilityException {
//
//        // does not make sense for package proxies
//        throw new UnsupportedOperationException( "Method getUsedContainers is not supported for MofPackageProxy instances." );
//    }

    @Override
    public String toString( ) {

        StringBuffer sb = new StringBuffer( 200 );
        sb.append( "Name: " ).append( this.getName( ) ); //$NON-NLS-1$
        sb.append( " MRI: " ).append( _mofPackageMri ); //$NON-NLS-1$
        sb.append( " Package: " ).append( _mofPackage ); //$NON-NLS-1$

        return sb.toString( );
    }
}
