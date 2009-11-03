package com.sap.tc.moin.facility.componentmodel;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.w3c.dom.Element;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.jmx.Description;
import com.sap.tc.moin.repository.jmx.ParameterName;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.util.SpiDelegator;


public class CMManager {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock( false );

    private Map<DataAreaDescriptor, CMDataArea> dataAreas = new HashMap<DataAreaDescriptor, CMDataArea>( );

    private Map<CRI, CMContainer> containers = new HashMap<CRI, CMContainer>( );

    private ObjectName jmxObjectName;

    public CMManager( ) {

    }

    public CMDataArea putDataArea( CMDataArea definition ) {

        leaseComponentModel( );
        try {
            definition.setCMManager( this );
            dataAreas.put( definition.getDataAreaDescriptor( ), definition );
            return definition;
        } finally {
            releaseComponentModel( );
        }
    }

    public CMContainer putContainer( CMContainer container ) {

        leaseComponentModel( );
        try {
            CMDataArea dataArea = dataAreas.get( container.getCri( ).getDataAreaDescriptor( ) );
            dataArea.addContainer( container );
            containers.put( container.getCri( ), container );
        } finally {
            releaseComponentModel( );
        }
        return container;
    }

    public CMDataArea getDataArea( DataAreaDescriptor descriptor ) {

        return dataAreas.get( descriptor );
    }

    public CMContainer getContainer( CRI cri ) {

        return containers.get( cri );
    }

    public boolean isDataArea_and_ContainerModifiable( CRI cri ) {

        if ( cri.isVolatileContainer( ) ) {
            return true;
        }
        leaseComponentModel( );
        try {
            CMContainer container = containers.get( cri );
            if ( container == null ) {
                // TODO propper error handling
                return false;
            }
            if ( container.isReadonly( ) ) {
                return false;
            }

            CMDataArea dataArea = dataAreas.get( cri.getDataAreaDescriptor( ) );
            if ( dataArea == null ) {
                // TODO propper error handling
                return false;
            }
            return !dataArea.isReadonly( );
        } finally {
            releaseComponentModel( );
        }
    }

    public boolean isLinkAllowed( PRI usingPri, PRI usedPri ) {

        leaseComponentModel( );
        try {

            CMContainer cmUsing = getContainer( usingPri.getCri( ) );
            if ( cmUsing == null ) {
                return false;
            }
            CMContainer cmUsed = getContainer( usedPri.getCri( ) );
            if ( cmUsed == null ) {
                return false;
            }

            if ( !cmUsing.isContainerVisible( usedPri.getCri( ) ) ) {
                return false;
            }

            if ( !cmUsed.isPublicallyVisible( usedPri.getPartitionName( ) ) ) {
                return false;
            }

            return true;

        } finally {
            releaseComponentModel( );
        }
    }

    public void removeConfiguration( ) {

        leaseComponentModel( );
        try {
            for ( CMDataArea dataArea : new ArrayList<CMDataArea>( dataAreas.values( ) ) ) {
                dataArea.remove( );
            }
        } finally {
            releaseComponentModel( );
        }
    }

    public final void leaseComponentModel( ) {

        lock.readLock( ).lock( );
    }

    public final void releaseComponentModel( ) {

        lock.readLock( ).unlock( );
    }


    // (De-)Serialization
    public Element serializeElement( Element parent ) {

        for ( CMDataArea da : dataAreas.values( ) ) {
            da.serializeElement( parent );
        }
        return parent;
    }

    public void deserialize( Moin moin, Element root ) {

        CMDataArea.deserializeElements( moin, root, this );

    }

    // JMX support
    public void removeJMX( ) {

        if ( JMX_ENABLED && this.jmxObjectName != null ) {
            SpiJmxHelper.unregisterMBean( this.jmxObjectName );
        }
    }

    @SuppressWarnings( "unchecked" )
    public void addJMX( String moinId, String facilityId, ReferenceQueue refQueue ) {

        if ( JMX_ENABLED && this.jmxObjectName == null ) {
            try {
                this.jmxObjectName = new ObjectName( MOIN_DOMAIN + "type=CMManager,moin=" + moinId + "-" + facilityId ); //$NON-NLS-1$ //$NON-NLS-2$
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            } catch ( NullPointerException e ) {
                throw new RuntimeException( e );
            }
            new JmxAdapter( this, jmxObjectName, refQueue );
        }
    }

    public static interface CMManagerMBean {

        @Description( "The currently active configuration model" )
        public String[] getConfiguration( );

        @Description( "Saves the current configuration model to the file system. (Only for Debugging environments - Not for Productive usage!!)" )
        public void saveConfiguration( @ParameterName( "fileName" ) String fileName );

    }

    private static final class JmxAdapter implements CMManagerMBean {

        private final WeakReferenceWithObjectName<CMManager> meRef;

        private JmxAdapter( CMManager me, ObjectName jmxObjectName, ReferenceQueue<CMManager> refQueue ) {

            this.meRef = new WeakReferenceWithObjectName<CMManager>( me, jmxObjectName, refQueue );
            SpiJmxHelper.registerStandardMBean( this, CMManagerMBean.class, jmxObjectName );
        }

        public String[] getConfiguration( ) {

            CMManager me = meRef.get( );
            return me != null ? CMServices.serializeManagerData_Quiet( me ).split( "\n" ) : new String[] {}; //$NON-NLS-1$
        }

        public void saveConfiguration( String fileName ) {

            CMManager me = meRef.get( );
            if ( me != null ) {
                CMServices.saveStringToFile_Quiet( fileName, CMServices.serializeManagerData_Quiet( me ) );
            }
        }
    }

    @Override
    public boolean equals( Object obj ) {

        return super.equals( SpiDelegator.dismantle( obj ) );
    }

    @Override
    public int hashCode( ) {

        return super.hashCode( );
    }

    void removeContainers( HashSet<CRI> containers ) {

        for ( CRI cri : containers ) {
            this.containers.remove( cri );
        }
    }

    void removeDataArea( CMDataArea dataArea ) {

        dataAreas.remove( dataArea.getDataAreaDescriptor( ) );
    }

}
