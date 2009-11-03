package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyPolicy;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * This class "unwraps" a DeepCopyPolicyHandler in a way so that the elements
 * that are passed to the handler in the callback are wrapped first, the
 * returned elements unwrapped. Also, a wrapped copy Mapped is created that
 * returns wrapped elements.
 * 
 * @author d046918
 */
public class DeepCopyPolicyHandlerWrapper implements Wrapper<DeepCopyPolicyHandler> {

    private DeepCopyPolicyHandler handler;

    private WorkspaceSet wsSet;

    private WrapperManager manager;

    private CoreConnection coreConnection;

    private DeepCopyMapWrapper wrappedMap;

    /**
     * Creates an "unwrapper" for a DeepCopyPolicyHandler
     * 
     * @param handler The handler that is to be unwrapped
     * @param coreConn The Connectino for the operation
     */

    public DeepCopyPolicyHandlerWrapper( DeepCopyPolicyHandler handler, CoreConnection coreConn ) {

        this.handler = handler;
        this.coreConnection = coreConn;
        this.wsSet = coreConn.getSession( ).getWorkspaceSet( );
        this.manager = wsSet.getWrapperManager( );
        this.wrappedMap = new DeepCopyMapWrapper( null, coreConnection );
    }

    /*
     * delegates to client DeepCopyPolicyHandler including wrapping and
     * de-wrapping of elements.
     */
    public DeepCopyPolicy getDeepCopyingPolicy( CoreConnection sourceConnection, RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

        RefObject sourceWrappedElement = (RefObject) manager.wrapObject( sourceConnection, sourceElement );
        wrappedMap.setMap( copyMap );
        DeepCopyPolicy policy = handler.getDeepCopyingPolicy( sourceWrappedElement, defaultPolicy, wrappedMap );
        return policy;
    }

    public DeepCopyPolicyHandler unwrap( ) {

        return handler;
    }

}
