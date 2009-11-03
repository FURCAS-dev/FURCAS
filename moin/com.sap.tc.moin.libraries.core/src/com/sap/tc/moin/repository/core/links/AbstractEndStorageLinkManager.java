package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkManager;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.MriReferenceImpl;
import com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Common base class for link managers.
 */
public abstract class AbstractEndStorageLinkManager implements EndStorageLinkManager {

    /**
     * The workspace this link manager is associated to.
     */
    private final Workspace workspace;

    /**
     * Common instance of the {@link JmiHelperImpl} for subclasses.
     */
    protected final SpiJmiHelper jmiHelper;

    public AbstractEndStorageLinkManager( Workspace workspace ) {

        this.workspace = workspace;
        this.jmiHelper = workspace.getWorkspaceSet( ).getMoin( ).getJmiHelper( );
    }

    public final JmiList<CorePartitionable> getElementsForEndAndMetaobject( CoreConnection connection, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        //FIXME use session at signature
        CoreSession session = connection != null ? connection.getSession( ) : null;
        return this.getOrCreateJmiList( session, endAndMetaObject, elementAtEnd );
    }

    /**
     * Gets the workspace this link manager is associated to.
     */
    public Workspace getWorkspace( ) {

        return this.workspace;
    }

    public final CorePartitionable getSingleElementForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        EndStorageLink link = this.getSingleLinkForEndAndMetaObject( session, endAndMetaObject, elementAtEnd );
        if ( link == null ) {
            return null;
        }
        return getElementAtEndFromLink( session, endAndMetaObject.getToEnd( ), link );
    }

    protected abstract JmiList<CorePartitionable> getOrCreateJmiList( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable fromEnd );

    protected abstract EndStorageLink getSingleLinkForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    protected final MriReference createMriReference( CorePartitionable fromEnd ) {

        Workspace workspaceOfFromEnd = fromEnd.get___Workspace( );
        if ( workspaceOfFromEnd != this.workspace ) {
            if ( !workspaceOfFromEnd.isShared( ) ) {
                return new MriReferenceImpl( fromEnd, fromEnd.get___Mri( ), false /* cacheable */, workspaceOfFromEnd.getWorkspaceSet( ).getMoin( ) );
            }
        }
        return createCachedMriReference( fromEnd );
    }

    protected final MriReference createCachedMriReference( CorePartitionable element ) {

        ReferenceManager referenceManager = this.getWorkspace( ).getWorkspaceSet( ).getReferenceManager( );
        return referenceManager.getMriReference( element, this.getWorkspace( ) );
    }

    private CorePartitionable getElementAtEndFromLink( CoreSession session, byte end, EndStorageLink link ) {

        CorePartitionable result = null;
        MoinReference reference = link.getEnd( end );
        result = reference.getWithoutException( session );
        if ( result == null && session != null ) {
            session.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( reference.getLri( ), link );
        }
        return result;
    }
}