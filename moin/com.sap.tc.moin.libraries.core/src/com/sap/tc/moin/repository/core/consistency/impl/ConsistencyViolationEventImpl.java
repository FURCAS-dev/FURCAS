package com.sap.tc.moin.repository.core.consistency.impl;

import com.sap.tc.moin.repository.core.ConsistencyViolationEvent;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;

public abstract class ConsistencyViolationEventImpl implements ConsistencyViolationEvent {

    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CONSISTENCY, ConsistencyViolationEventImpl.class );

    protected ConsistencyViolationRegistryImpl registry;

    public ConsistencyViolationEventImpl( ConsistencyViolationRegistryImpl registry ) {

        this.registry = registry;
    }

    public abstract void notifyExternalListeners( );

    public CoreSession getSession( ) {

        return this.registry.getSession( );
    }

    public ConsistencyViolationRegistryImpl getRegistry( ) {

        return this.registry;
    }

}
