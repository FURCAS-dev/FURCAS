/**
 * 
 */
package com.sap.tc.moin.facility.componentmodel;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;

public abstract class CMDataArea implements CMAbstractContainer {

    private static final String SERIALIZATION_NAME = "DataArea"; //$NON-NLS-1$

    private final boolean readonly;

    private final Facility facility;

    protected HashSet<CRI> containers = new HashSet<CRI>( );

    private DataAreaDescriptor descriptor;

    protected CMManager cmManager;

    public CMDataArea( DataAreaDescriptor descriptor, boolean readonly, Facility facility ) {

        this.descriptor = descriptor;
        this.readonly = readonly;
        this.facility = facility;
    }

    public boolean containsContainer( CRI cri ) {

        return containers.contains( cri );
    }

    public boolean containsContainer( CMContainer container ) {

        return container != null ? containers.contains( container.getCri( ) ) : false;
    }

    public Collection<CRI> getContainers( ) {

        return Collections.unmodifiableCollection( containers );
    }

    void addContainer( CMContainer container ) {

        containers.add( container.getCri( ) );
        container.setCMDataArea( this );
    }

    public boolean isReadonly( ) {

        return readonly;
    }

    public Facility getFacility( ) {

        return facility;
    }

    public CRI createCri( String containerName ) {

        return getFacility( ).getRIFactory( ).createCri( getDataAreaDescriptor( ).getDataAreaName( ), containerName );
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return descriptor;
    }

    public DataArea getDataArea( ) {

        return getFacility( ).getDataAreaByName( descriptor.getDataAreaName( ) );
    }

    void setCMManager( CMManager manager ) {

        this.cmManager = manager;

    }

    public CMManager getCMManager( ) {

        return cmManager;
    }

    protected void remove( ) {

        cmManager.removeContainers( containers );
        cmManager.removeDataArea( this );
    }

    private static final String NAME_facilityID = "facilityId"; //$NON-NLS-1$

    protected static final String NAME_dataAreaName = "dataAreaName"; //$NON-NLS-1$

    private static final String NAME_readonly = "readonly"; //$NON-NLS-1$

    // (De-)Serialization
    public void serializeElement( Element parent ) {

        Element el = parent.getOwnerDocument( ).createElement( SERIALIZATION_NAME );
        serializeData( el );
        parent.appendChild( el );
    }

    protected void serializeData( Element element ) {

        element.setAttribute( NAME_dataAreaName, descriptor.getDataAreaName( ) );
        element.setAttribute( NAME_facilityID, descriptor.getFacilityId( ) );
        element.setAttribute( NAME_readonly, Boolean.toString( readonly ) );

        CMName type = getClass( ).getAnnotation( CMName.class );
        element.setAttribute( "type", type.value( ) ); //$NON-NLS-1$

        for ( CRI criChildren : containers ) {
            CMContainer cmContainer = cmManager.getContainer( criChildren );
            if ( cmContainer != null ) {
                cmContainer.serializeElement( element );
            }
        }
    }

    public CMDataArea( CMServices.CMRestoreInfo ri ) {

        this.facility = ri.moin.getFacilityById( CMServices.getAttribute( ri.element, NAME_facilityID ) );

        this.descriptor = grantDescriptor( CMServices.getAttribute( ri.element, NAME_dataAreaName, null ) );
        this.readonly = Boolean.parseBoolean( CMServices.getAttribute( ri.element, NAME_readonly, Boolean.FALSE.toString( ) ) );
        this.cmManager = ri.cmManager;

        cmManager.putDataArea( this );

        NodeList nl = ri.element.getElementsByTagName( CMContainer.SERIALIZATION_NAME );
        for ( int i = 0; i < nl.getLength( ); ++i ) {
            Element node = (Element) nl.item( i );
            cmManager.putContainer( CMContainer.deserializeElement( ri.spawn( node, this ) ) );
        }

    }

    static void deserializeElements( Moin moin, Element root, CMManager manager ) {

        NodeList nl = root.getElementsByTagName( CMDataArea.SERIALIZATION_NAME );
        for ( int i = 0; i < nl.getLength( ); ++i ) {
            Element node = (Element) nl.item( i );

            String typeName = CMServices.getAttribute( node, "type" ); //$NON-NLS-1$
            CMServices.createDataAreaByName( typeName, new CMServices.CMRestoreInfo( moin, node, null, manager ) );
        }
    }

    protected abstract DataAreaDescriptor grantDescriptor( String name );

    public abstract void updateDataArea( );
}