package com.sap.tc.moin.repository.core.xmi.reader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.xmi.reader.parser.ParserResult;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

/**
 * This implementation of the RepositoryService interface is used when model
 * partitions that already exist in the repository are <em>loaded</em> into the
 * workspace. This is a fundamentally different scenario than <em>importing</em>
 * some XMI documents (for the import scenario, see
 * {@link com.sap.tc.moin.repository.core.xmi.reader.ImportingRepositoryService}
 * ).
 * <p>
 * When a model partition is loaded, the contained model elements and links are
 * merely instantiated and populated with the data found in the model partition.
 * Instantiation of model elements does <em>not</em> make use of regular JMI
 * calls, but rather uses a special mechanism provided by the workspace's
 * {@link com.sap.tc.moin.repository.core.JmiInstantiator}. This mechanism in
 * particular bypasses constraint checks and model change eventing, which must
 * not be performed during loading.
 */
class LoadingRepositoryService implements RepositoryService {

    /**
     * The workspace the enclosing XmiReader is working on.
     */
    private Workspace workspace;

    /**
     * The partition we have to load.
     */
    private CoreModelPartition partition;

    /**
     * This map stores all model elements instantiated in
     * {@link #loadInstance(InstanceInfo)}. The information is needed later in
     * {@link #loadLink(LinkInfo)}.
     */
    private Map<InstanceInfo, RefObject> instantiatedRefObjects;

    private CoreConnection connection;

    LoadingRepositoryService( CoreConnection connection, Workspace ws, CoreModelPartition mp ) {

        this.connection = connection;
        workspace = ws;
        partition = mp;
        instantiatedRefObjects = new HashMap<InstanceInfo, RefObject>( );
    }

    /**
     * Perform all necessary updates based on what is contained in the
     * {@link ParserResult}. The collection of composition roots found in the
     * XMI document(s) is returned.
     */
    public Collection<RefObject> updateRepository( ParserResult parserResult ) {

        Collection<RefObject> outermostObjects = new LinkedHashSet<RefObject>( );
        for ( InstanceInfo instance : parserResult.getModelElements( ) ) {
            RefObject refObj = loadInstance( instance );
            if ( instance.getParentElement( ) == null ) {
                outermostObjects.add( refObj );
            }
        }
        for ( Entry<AssociationInternal, Set<LinkInfo>> resultEntry : parserResult.getLinks( ).entrySet( ) ) {
            for ( LinkInfo link : resultEntry.getValue( ) ) {
                loadLink( link );
            }
        }
        return outermostObjects;
    }

    /**
     * Performs a rollback of all repository modifications made by this
     * RepositoryService instance since its construction. To enable this,
     * concrete implementations need to keep track of all their modifications.
     */
    public void rollbackChanges( ) {

        // Something went wrong during the repository update. Evict the
        // partition again.
        try {
            workspace.getPartitionManager( ).evictPartition( partition );
        } catch ( Exception ex ) {
            throw new RepositoryUpdateException( XMI.PARTITIONEVICITONFAILED, ex );
        }
    }

    /**
     * Instantiates a model element from the given {@link InstanceInfo}.
     */
    private RefObject loadInstance( InstanceInfo instanceInfo ) {

        RefObject result = null;
        try {
            MofClass type = instanceInfo.getType( );
            RefClass refClass = getRefClass( type );
            RefPackage immediatePackage = refClass.refImmediatePackage( );
            result = workspace.getJmiInstantiator( ).createRefObject( connection, instanceInfo.getMofId( ), immediatePackage, type, refClass, partition );
            Map<String, Object> attributeValues = instanceInfo.getAttributeValuesByName( );
            for ( Entry<String, Object> entry : attributeValues.entrySet( ) ) {
                Object value = entry.getValue( );
                if ( value != null ) {
                    Object resolvedValue = resolveAttributeValue( value );
                    ( (RefObjectExtension) result ).set___Value( connection.getSession( ), entry.getKey( ), resolvedValue );
                }
            }
        } catch ( Exception ex ) {
            throw new RepositoryUpdateException( XMI.INSTANCELOADFAILED, ex );
        }
        instantiatedRefObjects.put( instanceInfo, result );
        return result;
    }

    /**
     * The given attribute value might be of type InstanceInfo, or might be a
     * collection of InstanceInfo instances. In both cases, the corresponding
     * RefObject instances are already contained in the
     * {@link #instantiatedRefObjects} collection, and this method returns a new
     * (InstanceInfo-less) replacement attribute value. All other attribute
     * values are returned unchanged.
     */
    @SuppressWarnings( "unchecked" )
    private Object resolveAttributeValue( Object value ) {

        if ( value instanceof InstanceInfo ) {
            // Object-valued attribute with multiplicity.upper <= 1. The
            // corresponding RefObject must already be
            // contained in the instantiatedRefObjects collection.
            return instantiatedRefObjects.get( value );
        } else if ( value instanceof Collection ) {
            // Attribute with multiplicity.upper > 1. Check whether it contain
            // instances of InstanceInfo.
            Collection col = (Collection) value;
            if ( !col.isEmpty( ) && col.iterator( ).next( ) instanceof InstanceInfo ) {
                // The collection contains instances of InstanceInfo, i.e. the
                // attribute is object-valued. Return a
                // replacement collection.
                List<RefObject> newValue = new ArrayList<RefObject>( col.size( ) );
                for ( Iterator it = col.iterator( ); it.hasNext( ); ) {
                    newValue.add( instantiatedRefObjects.get( it.next( ) ) );
                }
                return newValue;
            }
        }
        return value;
    }

    /**
     * Instantiates a link from the given {@link LinkInfo}.
     */
    private void loadLink( LinkInfo linkInfo ) {

        boolean firstEndIsInstance = linkInfo.getFirstEnd( ) instanceof InstanceInfo;
        boolean secondEndIsInstance = linkInfo.getSecondEnd( ) instanceof InstanceInfo;
        AssociationInternal association = linkInfo.getAssociation( );
        if ( firstEndIsInstance && secondEndIsInstance ) {
            // Both ends are instances, i.e. a logical link can be established.
            // A logical link consists either of one or
            // two physical links, depending on where the storage is.
            workspace.getLinkManager( ).loadLink( connection.getSession( ), (SpiPartitionable) instantiatedRefObjects.get( linkInfo.getFirstEnd( ) ), (SpiPartitionable) instantiatedRefObjects.get( linkInfo.getSecondEnd( ) ), (Association) association );
        } else if ( firstEndIsInstance && !secondEndIsInstance ) {
            // Since not both ends are instances, it must be a cross-partition
            // link. If the second end is not an
            // instance, it must be a cross-partition reference. Otherwise it is
            // an illegal state -> exception will be
            // thrown.
            assertCrossPartitionReference( linkInfo.getSecondEnd( ) );
            workspace.getLinkManager( ).loadLink( connection.getSession( ), (SpiPartitionable) instantiatedRefObjects.get( linkInfo.getFirstEnd( ) ), getLri( (CrossPartitionReference) linkInfo.getSecondEnd( ) ), (Association) association );
        } else if ( !firstEndIsInstance && secondEndIsInstance ) {
            // Since not both ends are instances, it must be a cross-partition
            // link. If the first end is not an
            // instance, it must be a cross-partition reference. Otherwise it is
            // an illegal state -> exception will be
            // thrown.
            assertCrossPartitionReference( linkInfo.getFirstEnd( ) );
            workspace.getLinkManager( ).loadLink( connection.getSession( ), getLri( (CrossPartitionReference) linkInfo.getFirstEnd( ) ), (SpiPartitionable) instantiatedRefObjects.get( linkInfo.getSecondEnd( ) ), (Association) association );
        }
    }

    /**
     * Makes sure that the given LinkEnd is an instance of
     * CrossPartitionReference. If not, an exception is thrown.
     * 
     * @param linkEnd the LinkEnd which has to be an instance of
     * CrossPartitionReference
     */
    private void assertCrossPartitionReference( LinkEnd linkEnd ) {

        if ( !( linkEnd instanceof CrossPartitionReference ) ) {
            throw new RepositoryUpdateException( XMI.MOIN_XMI_1071, new Object[] { linkEnd.getClass( ).getName( ) } );
        }
    }

    /**
     * Returns a {@link LRI} for the given {@link CrossPartitionReference}.
     */
    private LRI getLri( CrossPartitionReference xref ) {

        String href = xref.getHref( );
        String mofId = href.substring( href.lastIndexOf( ':' ) + 1 );
        if ( href.startsWith( "local:" ) ) { //$NON-NLS-1$
            LRI result = partition.getPri( ).createMri( mofId ).getLri( );
            return result;
        }
        return workspace.getWorkspaceSet( ).getMoin( ).createLri( href );
    }

    /**
     * Returns the class extent for the given MofClass.
     */
    private RefClass getRefClass( MofClass mofClass ) {

        return (RefClass) workspace.getWorkspaceSet( ).getMoin( ).getExtentManager( ).getDefaultExtentForMetaObject( mofClass );
    }
}
