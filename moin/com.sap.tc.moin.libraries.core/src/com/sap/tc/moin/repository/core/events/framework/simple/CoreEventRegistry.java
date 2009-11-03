package com.sap.tc.moin.repository.core.events.framework.simple;

import java.util.List;

import com.sap.tc.moin.repository.events.EventRegistry;

public interface CoreEventRegistry extends EventRegistry {

    public List<NotifierSimple> getPreChangeNotifiers( );

    public List<NotifierSimple> getChangeNotifiers( );

    public List<NotifierSimple> getPreCommitNotifiers( );

    public List<NotifierSimple> getCommitNotifiers( );

    public List<NotifierSimple> getUpdateNotifiers( );

    public ListenerHelper getListenerHelper( );
}
