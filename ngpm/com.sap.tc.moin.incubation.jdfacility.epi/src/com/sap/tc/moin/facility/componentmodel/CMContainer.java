package com.sap.tc.moin.facility.componentmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sap.tc.moin.facility.componentmodel.CMServices.CMRestoreInfo;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.PRI;

public abstract class CMContainer implements CMAbstractContainer {

    public static final String SERIALIZATION_NAME = "Container"; //$NON-NLS-1$

    private final boolean readonly;

    private final Pattern publicVisiblePattern;

    private String originalLanguage = "en"; //$NON-NLS-1$

    private String applicationComponent = ""; //$NON-NLS-1$

    private final CRI cri;

    private CMDataArea cmDataArea = null;

    private Map<CRI, CMUsageMode> usedContainers;

    private boolean isInitialized = false;

    private Object responsible = null;

    // JD TODO: Do i have to return a copy?
    public Map<CRI, CMUsageMode> getUsedContainers( ) {

        return usedContainers;
    }

    public CRI getCri( ) {

        return cri;
    }

    public PRI createPri( String partitionName ) {

        return getFacility( ).getRIFactory( ).createPri( getDataAreaDescriptor( ).getDataAreaName( ), cri.getContainerName( ), partitionName );
    }

    public CMContainer( CRI cri, boolean readonly, Map<CRI, CMUsageMode> usedContainers, String publicNamePattern ) {

        this.cri = cri;
        this.readonly = readonly;
        this.usedContainers = ( usedContainers == null ) ? Collections.<CRI, CMUsageMode> emptyMap( ) : usedContainers;
        this.publicVisiblePattern = publicNamePattern != null ? Pattern.compile( publicNamePattern ) : null;

    }

    public CMContainer( CRI cri, boolean readonly, Set<CRI> usedContainers, String publicNamePattern ) {

        this( cri, readonly, CMServices.toUsageMap( CMUsageMode.USE, usedContainers ), publicNamePattern );

    }

    public String getOriginalLanguage( ) {

        return originalLanguage;
    }

    public String getApplicationComponent( ) {

        return applicationComponent;
    }

    public boolean isReadonly( ) {

        return readonly;
    }

    public Pattern getPublicVisiblePattern( ) {

        return publicVisiblePattern;
    }

    void setCMDataArea( CMDataArea dataArea ) {

        this.cmDataArea = dataArea;
    }

    public CMDataArea getCMDataArea( ) {

        return cmDataArea;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return cmDataArea.getDataAreaDescriptor( );
    }

    public boolean isInitialized( ) {

        return this.isInitialized;
    }

    public void setInitialized( ) {

        isInitialized = true;

    }

    protected Facility getFacility( ) {

        return cmDataArea.getFacility( );
    }

    public void setResponsible( Object responsible ) {

        this.responsible = responsible;
    }

    public Object getResponsible( ) {

        return responsible;
    }

    public abstract void updateContainer( boolean forced );

    public abstract Collection<PRI> getPartitionsInContainer( );

    boolean isContainerVisible( CRI target ) {

        if ( getUsedContainers( ).get( target ) != null ) {
            return true;
        }
        return getVisibleContainers( ).contains( target );
    }

    public Set<CRI> getVisibleContainers( ) {

        CMManager manager = getCMDataArea( ).cmManager;

        HashSet<CRI> res = new HashSet<CRI>( );
        ArrayList<CRI> containers = new ArrayList<CRI>( getUsedContainers( ).keySet( ) );

        while ( containers.size( ) > 0 ) {
            CMContainer child = manager.getContainer( containers.remove( 0 ) );
            if ( child == null || res.contains( child.getCri( ) ) ) {
                continue;
            }

            res.add( child.getCri( ) );

            int i = 0;
            for ( Entry<CRI, CMUsageMode> usageEntry : child.getUsedContainers( ).entrySet( ) ) {
                if ( CMUsageMode.REEXPORT.equals( usageEntry.getValue( ) ) && !res.contains( usageEntry.getKey( ) ) ) {
                    containers.add( i++, usageEntry.getKey( ) );
                }
            }
        }

        return res;
    }

    boolean isPublicallyVisible( String partitionName ) {

        if ( publicVisiblePattern == null ) {
            return true;
        } else {
            return publicVisiblePattern.matcher( partitionName ).find( );
        }
    }

    public void addVisiblePartitions( HashSet<PRI> res ) {

        Collection<PRI> myPartitions = getPartitionsInContainer( );

        if ( publicVisiblePattern == null ) {
            res.addAll( myPartitions );
        } else {
            for ( PRI pri : myPartitions ) {
                if ( publicVisiblePattern.matcher( pri.getPartitionName( ) ).find( ) ) {
                    res.add( pri );
                }
            }
        }
        // add forwarded public parts

        //
    }

//    @Override
//    public boolean equals( Object obj ) {
//
//        if ( obj instanceof CMContainer ) {
//            CMContainer buddy = (CMContainer) obj;
//            return CMServices.eq( cri, buddy.cri ) //
//                   && readonly == buddy.readonly //
//                   && CMServices.eq( usedContainers, buddy.usedContainers ) //
//                   && CMServices.eq( publicVisiblePattern, buddy.publicVisiblePattern ) //
//                   && CMServices.eq( originalLanguage, buddy.originalLanguage ) //
//                   && CMServices.eq( applicationComponent, applicationComponent );
//        }
//        return false;
//    }

    // (De-)Serialization
    final void serializeElement( Element parent ) {

        Element el = parent.getOwnerDocument( ).createElement( SERIALIZATION_NAME );
        CMName type = getClass( ).getAnnotation( CMName.class );
        el.setAttribute( "type", type.value( ) ); //$NON-NLS-1$
        serializeData( el );
        parent.appendChild( el );
    }

    protected void serializeData( Element element ) {

        element.setAttribute( "cri", CMServices.serializeCRI( cmDataArea.getDataAreaDescriptor( ), cri ) ); //$NON-NLS-1$
        element.setAttribute( "readonly", Boolean.toString( readonly ) ); //$NON-NLS-1$

        CMServices.setAttributeIfNotNullOrEmpty( element, "publicVisiblePattern", getPublicVisiblePattern( ) != null ? getPublicVisiblePattern( ).pattern( ) : null ); //$NON-NLS-1$
        CMServices.setAttributeIfNotNullOrEmpty( element, "originalLanguage", originalLanguage ); //$NON-NLS-1$
        CMServices.setAttributeIfNotNullOrEmpty( element, "applicationComponent", applicationComponent ); //$NON-NLS-1$

        for ( Entry<CRI, CMUsageMode> usedEntry : usedContainers.entrySet( ) ) {
            Element children = CMServices.createElement( element, "UsedContainer" ); //$NON-NLS-1$
            children.setAttribute( "cri", CMServices.serializeCRI( cmDataArea.getDataAreaDescriptor( ), usedEntry.getKey( ) ) ); //$NON-NLS-1$
            if ( CMUsageMode.REEXPORT.equals( usedEntry.getValue( ) ) ) {
                children.setAttribute( "mode", "reexport" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    protected CMContainer( CMServices.CMRestoreInfo ri ) {

        this.cri = ri.deserializeCRI( ri.getAttribute( "cri" ) ); //$NON-NLS-1$
        this.readonly = Boolean.parseBoolean( ri.getAttribute( "readonly", "false" ) ); //$NON-NLS-1$ //$NON-NLS-2$

        String publicVisiblePattern = ri.getAttribute( "publicVisiblePattern" ); //$NON-NLS-1$
        this.publicVisiblePattern = publicVisiblePattern != null ? Pattern.compile( publicVisiblePattern ) : null;
        this.originalLanguage = ri.getAttribute( "originalLanguage", "en" ); //$NON-NLS-1$ //$NON-NLS-2$
        this.applicationComponent = ri.getAttribute( "applicationComponent", "" ); //$NON-NLS-1$ //$NON-NLS-2$

        HashMap<CRI, CMUsageMode> newChildren = new HashMap<CRI, CMUsageMode>( );

        NodeList nl = ri.element.getElementsByTagName( "UsedContainer" ); //$NON-NLS-1$
        for ( int i = 0; i < nl.getLength( ); ++i ) {
            Element node = (Element) nl.item( i );

            CRI criChildren = ri.deserializeCRI( node.getAttribute( "cri" ) ); //$NON-NLS-1$
            CMUsageMode usageMode = CMServices.getUsageMode( node.getAttribute( "mode" ) ); //$NON-NLS-1$
            newChildren.put( criChildren, usageMode );
        }

        this.usedContainers = newChildren.size( ) == 0 ? Collections.<CRI, CMUsageMode> emptyMap( ) : newChildren;
    }

    final static CMContainer deserializeElement( CMRestoreInfo ri ) {

        String typeName = CMServices.getAttribute( ri.element, "type" ); //$NON-NLS-1$
        return CMServices.createContainerByName( typeName, ri );
    }
}