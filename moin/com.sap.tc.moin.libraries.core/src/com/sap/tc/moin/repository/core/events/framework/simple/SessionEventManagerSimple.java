package com.sap.tc.moin.repository.core.events.framework.simple;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.openmbean.TabularData;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.events.AttributeValueAddEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.ElementCreateEventImpl;
import com.sap.tc.moin.repository.core.events.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.core.events.LinkAddEventImpl;
import com.sap.tc.moin.repository.core.events.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.ListenerTypeEnum;
import com.sap.tc.moin.repository.core.events.ModelChangeEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionContentChangeEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionCreateEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionDeleteEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionMembershipChangeEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionSaveEventImpl;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.core.events.framework.SessionEventManager;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.jmx.SessionEventManagerMBean;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;

/**
 * The SessionEventManager implements 2 roles: <br>
 * It acts as a <code>EventRegistry</code> to clients and as
 * <code>EventManager</code> to the repository core which will trigger the
 * events using the {@link com.sap.tc.moin.repository.spi.core.SpiEventManager}
 * interface. After the method was called, the SessionEventManager will ask its
 * RegistrationManager for all affected listeners and notify them using the
 * associated Notifier.
 * 
 * @author Martin Kolb
 */

public class SessionEventManagerSimple implements SessionEventManager {

    public SessionEventManagerSimple( ) {

        if ( JMX_ENABLED ) {
            listenerHelper = new ListenerHelper( this );
        }
    }

    private static Logger logger = Logger.getLogger(SessionEventManager.class.getName());

    private List<NotifierSimple> preChangeListeners = new ArrayList<NotifierSimple>( );

    private List<NotifierSimple> postChangeListeners = new ArrayList<NotifierSimple>( );

    private List<NotifierSimple> preCommitListeners = new ArrayList<NotifierSimple>( );

    private List<NotifierSimple> postCommitListeners = new ArrayList<NotifierSimple>( );

    private List<NotifierSimple> updateListeners = new ArrayList<NotifierSimple>( );

    public int filtered;

    /* Methods from EventRegistry interface */

    public boolean hasListeners( ) {

        return !( updateListeners.isEmpty( ) && preChangeListeners.isEmpty( ) && postChangeListeners.isEmpty( ) && preCommitListeners.isEmpty( ) && postCommitListeners.isEmpty( ) );
    }

    /*
     * @see EventRegistry#registerListener(ChangeListener, MoinEventFilter)
     */
    public void registerListener( ChangeListener listener, EventFilter eventFilterTree ) {

        register( postChangeListeners, new PostEventNotifier( listenerHelper, listener, eventFilterTree ), ListenerTypeEnum.postChange );
    }

    /*
     * @see EventRegistry#registerPreChangeListener(PreChangeListener,
     * MoinEventFilter)
     */
    public void registerPreChangeListener( PreChangeListener listener, EventFilter eventFilterTree ) {

        register( preChangeListeners, new PreEventNotifier( listenerHelper, listener, eventFilterTree ), ListenerTypeEnum.preChange );
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerCommitListener
     * (com.sap.tc.moin.repository.events.CommitListener,
     */
    public void registerCommitListener( CommitListener listener, EventFilter eventFilterTree ) {

        register( postCommitListeners, new CommitNotifier( listenerHelper, listener, eventFilterTree ), ListenerTypeEnum.postCommit );
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerPreCommitListener
     * (com.sap.tc.moin.repository.events.PreCommitListener,
     */
    public void registerPreCommitListener( PreCommitListener listener, EventFilter eventFilterTree ) {

        register( preCommitListeners, new PreCommitNotifier( listenerHelper, listener, eventFilterTree ), ListenerTypeEnum.preCommit );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.EventRegistry#
     * registerUpdateUserInterfaceListener
     * (com.sap.tc.moin.repository.events.UpdateUserInterfaceListener,
     * com.sap.tc.moin.repository.events.filter.EventFilter)
     */
    public void registerUpdateListener( UpdateListener listener, EventFilter eventFilterTree ) {

        register( updateListeners, new UpdateNotifier( listenerHelper, listener, eventFilterTree ), ListenerTypeEnum.update );
    }

    // TODO remove again; only for statistics purposes
    public static int eventListenerRegistrations = 0;
    
    private void register( List<NotifierSimple> listeners, NotifierSimple notifier, ListenerTypeEnum listenerType ) {
	eventListenerRegistrations++;
        // first check if the listener has already been registered.
        // If yes, then combine the old filter and the new filter with "Or"
        NotifierSimple notifierInList = null;
        for ( int i = 0; i < listeners.size( ); i++ ) {
            NotifierSimple notifierLoop = listeners.get( i );
            if ( notifierLoop.getListener( ) == notifier.getListener( ) ) {
                notifierInList = notifierLoop;
                break;
            }
        }

        if ( notifierInList == null ) {
            listeners.add( notifier );
        } else {
            EventFilter filterInList = notifierInList.getFilter( );
            if ( filterInList instanceof OrFilter ) {
                ( (OrFilter) filterInList ).getOperands( ).add( notifier.getFilter( ) );
            } else {
                notifierInList._filter = new OrFilter( notifier.getFilter( ), notifierInList.getFilter( ) );
            }

            // for JMX_ENABLED (see "if" below)
            notifier = notifierInList;
        }

        if ( JMX_ENABLED && monitoringLevel > 0 ) {
            listenerHelper.add( listenerType, notifier.getListener( ), notifier.getFilter( ) );
        }

        if ( logger.isLoggable(Level.FINE) ) {
            logger.log( Level.FINE, "Event listener {0} registered with Filter:\n{1}",
        	    new Object[] { notifier.getListener( ), notifier.getFilter( ) } ); //$NON-NLS-1$
            traceListenerCount( );
        }

    }

    private void traceListenerCount( ) {

        if ( logger.isLoggable( Level.FINE ) ) {
            logger.log( Level.FINE, "Number of currently registered pre change listeners: {0}", preChangeListeners.size( ) ); //$NON-NLS-1$
            logger.log( Level.FINE, "Number of currently registered post change listeners: {0}", postChangeListeners.size( ) ); //$NON-NLS-1$
            logger.log( Level.FINE, "Number of currently registered pre commit listeners: {0}", preCommitListeners.size( ) ); //$NON-NLS-1$
            logger.log( Level.FINE, "Number of currently registered post commit listeners: {0}", postCommitListeners.size( ) ); //$NON-NLS-1$
            logger.log( Level.FINE, "Number of currently registered update listeners: {0}", updateListeners.size( ) ); //$NON-NLS-1$
        }
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#deregister(com.sap.tc
     * .moin.repository.events.MoinChangeListener)
     */
    public void deregister( EventListener listener ) {

        removeListenerFromArray( listener, preChangeListeners );
        removeListenerFromArray( listener, postChangeListeners );
        removeListenerFromArray( listener, preCommitListeners );
        removeListenerFromArray( listener, postCommitListeners );
        removeListenerFromArray( listener, updateListeners );
        if ( JMX_ENABLED && monitoringLevel > 0 ) {
            listenerHelper.remove( listener );
        }

        if ( logger.isLoggable( Level.FINE ) ) {
            logger.log( Level.FINE, "Event listener {0} deregistered", listener ); //$NON-NLS-1$
            traceListenerCount( );
        }

    }

    public static void removeListenerFromArray( EventListener listener, List<NotifierSimple> notifierList ) {

        NotifierSimple notifierInList = null;
        Iterator<NotifierSimple> iter = notifierList.iterator( );
        while ( iter.hasNext( ) ) {
            notifierInList = iter.next( );
            if ( notifierInList.getListener( ) == listener ) {
                iter.remove( );
                return;
            }
        }
    }

    // TODO remove again; used only for statistics purposes
    public static int changeEvents = 0;
    
    /*
     * @see com.sap.tc.moin.repository.events.EventManager
     */
    public void fireChangeEvent( ChangeEvent event ) {
	
        if ( !doFireEvents ) {
            return;
        }
        changeEvents++;
        fireEvent( event, postChangeListeners );
        fireEventDeferred( event, preCommitListeners );
        fireEventDeferred( event, postCommitListeners );
        fireEventDeferred( event, updateListeners );

        if ( JMX_ENABLED ) {
            if ( monitoringLevel > 1 ) {
                listenerHelper.eventFired( event );
            }
            if ( emitJmxNotifications ) {
                jmxAdapter.sendNotification( event, false /* preEvent */);
            }
        }
    }

    /*
     * @see com.sap.tc.moin.repository.events.EventManager
     */
    public void firePreChangeEvent( ChangeEvent event ) {

        if ( !doFireEvents ) {
            return;
        }

        // TODO first check if CompostionFilter is registered
        if ( ( event instanceof ElementDeleteEventImpl ) || ( event instanceof LinkRemoveEventImpl ) ) {
            ( (ModelChangeEventImpl) event ).getAffectedElementsLRIsIncludingCompositeParents( );
        }

        fireEvent( event, preChangeListeners );

        if ( JMX_ENABLED && logPreEvents ) {
            if ( monitoringLevel > 1 ) {
                listenerHelper.eventFired( event );
            }
            if ( emitJmxNotifications ) {
                jmxAdapter.sendNotification( event, true /* preEvent */);
            }
        }
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventManager#beginCommand(com.sap.tc
     * .moin.repository.commands.MoinCommand)
     */
    public void beginCommand( Connection connection ) {

        if ( !doFireEvents ) {
            return;
        }

        for ( int i = 0; i < preCommitListeners.size( ); i++ ) {
            NotifierSimple notifier = preCommitListeners.get( i );
            ( (DeferringNotifierSimple) notifier ).deferNotificationFor( connection );
        }

        for ( int i = 0; i < postCommitListeners.size( ); i++ ) {
            NotifierSimple notifier = postCommitListeners.get( i );
            ( (DeferringNotifierSimple) notifier ).deferNotificationFor( connection );
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.spi.core.EventManager#beginUpdateUserInterface
     * (com.sap.tc.moin.repository.Connection)
     */
    public void beginUpdate( Connection connection ) {

        if ( !doFireEvents ) {
            return;
        }

        for ( int i = 0; i < updateListeners.size( ); i++ ) {
            NotifierSimple notifier = updateListeners.get( i );
            ( (DeferringNotifierSimple) notifier ).deferNotificationFor( connection );
        }
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventManager#postCommitCommand(com.
     * sap.tc.moin.repository.commands.MoinCommand)
     */
    public void postCommitCommand( Connection connection ) {

        deliverEventChains( connection, postCommitListeners, false );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.spi.core.EventManager#deliverUpdateUserInterface
     * (com.sap.tc.moin.repository.Connection)
     */
    public void deliverUpdate( Connection connection ) {

        deliverEventChains( connection, updateListeners, false );

    }

    private void deliverEventChains( Connection connection, List<NotifierSimple> notifiers, boolean vetoAllowed ) {

        if ( !doFireEvents ) {
            return;
        }

        // Copy found notifiers in separate list. This enables deregistering
        // within event listeners
        EventChainSimple[] chains = new EventChainSimple[notifiers.size( )];
        int i = 0;
        for ( int j = 0; j < notifiers.size( ); j++ ) {
            NotifierSimple notifier = notifiers.get( j );
            EventChainSimple chain = ( (DeferringNotifierSimple) notifier ).prepareDeliveryOfDeferredEvents( connection );
            if ( chain != null ) {
                chains[i++] = chain;
            }
        }

        for ( int j = 0; j < i; j++ ) {
            try {
                chains[j].deliverEvents( );
            } catch ( RuntimeException e ) {
                if ( vetoAllowed && e instanceof VetoException ) {
                    if ( logger.isLoggable( Level.FINE ) ) {
                        logger.log( Level.FINE, "Listener vetoed event chain. " + chains[j], e ); //$NON-NLS-1$
                    }
                    throw e;
                }

                //unexpected exception thrown from listener code
                //show must go on anyway, therefore just trace it and continue
                if ( logger.isLoggable( Level.SEVERE ) ) {
                    logger.log( Level.SEVERE, "Listener has thrown exception. " + chains[j], e); //$NON-NLS-1$
                }
            }
        }
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventManager#preCommitCommand(com.sap
     * .tc.moin.repository.commands.MoinCommand)
     */
    public void preCommitCommand( Connection connection ) {

        deliverEventChains( connection, preCommitListeners, true );
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventManager#cancelCommand(com.sap.
     * tc.moin.repository.commands.MoinCommand)
     */
    public void cancelCommand( Connection connection ) {

        if ( !doFireEvents ) {
            return;
        }

        for ( int i = 0; i < preCommitListeners.size( ); i++ ) {
            NotifierSimple notifier = preCommitListeners.get( i );
            ( (DeferringNotifierSimple) notifier ).cancelDefermentFor( connection );
        }

        for ( int i = 0; i < postCommitListeners.size( ); i++ ) {
            NotifierSimple notifier = postCommitListeners.get( i );
            ( (DeferringNotifierSimple) notifier ).cancelDefermentFor( connection );
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.spi.core.EventManager#cancelUpdateUserInterface
     * (com.sap.tc.moin.repository.Connection)
     */
    public void cancelUpdate( Connection connection ) {

        if ( !doFireEvents ) {
            return;
        }

        for ( int i = 0; i < updateListeners.size( ); i++ ) {
            NotifierSimple notifier = updateListeners.get( i );
            ( (DeferringNotifierSimple) notifier ).cancelDefermentFor( connection );
        }
    }

    /**
     * This method notifies all interested listeners by invoking the fireEvent()
     * method on their associated Notifier.
     * 
     * @param event the event that will be delivered to clients
     */
    private void fireEvent( ChangeEvent event, List<NotifierSimple> possibleListeners ) {

        // First collect all listeners. This allows registration and de-registration in event listeners
        NotifierSimple[] notifiers = null;
        int notifierCount = 0;

        int possibleListenersCount = possibleListeners.size( );
        for ( int i = 0; i < possibleListenersCount; i++ ) {
            NotifierSimple notifier = possibleListeners.get( i );

            // Check if listener has been garbage-collected
            if ( notifier.getListener( ) == null ) {
                possibleListeners.remove( i );
                possibleListenersCount--;
                i--;
            } else {
                // Check if listener matches the event
                if ( FilterMatchesEvent.matches( event, notifier.getFilter( ) ) ) {
                    filtered++;
                    if ( notifiers == null ) {
                        notifiers = new NotifierSimple[possibleListenersCount - i];
                    }
                    notifiers[notifierCount++] = notifier;
                }
            }
        }

        // Now notify all listeners
        if ( notifiers != null ) {
            for ( int i = 0; i < notifierCount; i++ ) {
                notifiers[i].fireEvent( event );
            }
        }
    }

    // TODO remove again; this is only for statistics purposes
    public static int deliveredEvents = 0;
    public static int unsuccessfulMatches = 0;
    /**
     * This method notifies all interested listeners by invoking the fireEvent()
     * method on their associated Notifier.
     * 
     * @param event the event that will be delivered to clients
     */
    private void fireEventDeferred( ChangeEvent event, List<NotifierSimple> possibleListeners ) {

        // This method (in contrast to fireEvent) does not need to collect events first.
        // Because events are deferred, no concurrent registration can take place.

        int possibleListenersCount = possibleListeners.size( );
        for ( int i = 0; i < possibleListenersCount; i++ ) {
            NotifierSimple notifier = possibleListeners.get( i );

            // Check if listener has been garbage-collected
            if ( notifier.getListener( ) == null ) {
                possibleListeners.remove( i );
                possibleListenersCount--;
                i--;
            } else {
                // Check if listener matches the event
                if ( FilterMatchesEvent.matches( event, notifier.getFilter( ) ) ) {
                    deliveredEvents++;
                    notifier.fireEvent( event );
                } else {
                    unsuccessfulMatches++;
                }
            }
        }
    }

    public List<NotifierSimple> getChangeNotifiers( ) {

        return postChangeListeners;
    }

    public List<NotifierSimple> getCommitNotifiers( ) {

        return postCommitListeners;
    }

    public List<NotifierSimple> getPreChangeNotifiers( ) {

        return preChangeListeners;
    }

    public List<NotifierSimple> getPreCommitNotifiers( ) {

        return preCommitListeners;
    }

    public List<NotifierSimple> getUpdateNotifiers( ) {

        return updateListeners;
    }

    public void setFireEvents( boolean doFireEventsValue ) {

        doFireEvents = doFireEventsValue;
    }

    boolean doFireEvents = true;

    /*
     * J M X
     */

    /**
     * The level of detail during JMX monitoring. Four levels exist (each level
     * includes all information from smaller levels):
     * <p>
     * Level 0 : No information is collected. This level is the default. Level 1
     * : Provides basic information about registered listeners. Level 2 : Counts
     * each fired event, globally and per event listener.<br>
     * Level 3 : Measures event listener runtimes.
     */
    public int monitoringLevel = 0;

    /**
     * Whether each fired event should be translated into a corresponding JMX
     * notification.
     */
    volatile boolean emitJmxNotifications = false;

    /**
     * Whether to log pre-events via JMX or not.
     */
    boolean logPreEvents = false;

    /**
     * The name identifying this SessionEventManager in JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the translation of events to JMX notifications.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Helper class for managing information about listeners.
     */
    private ListenerHelper listenerHelper;

    /**
     * If JMX is enabled, this method is called and registers the MBean for this
     * SessionEventManager instance.
     */
    public void registerMBean( CoreSession session ) {

        try {
            objectName = new ObjectName( MOIN_DOMAIN + "type=EventManager,moin=" + session.getMoin( ).getId( ) + ",session=" + session.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
        jmxAdapter = new JmxAdapter( this, objectName, session.getMoin( ).getReferenceQueue( ) );
    }

    public ObjectName getObjectName( ) {

        return objectName;
    }

    private static final class JmxAdapter extends NotificationBroadcasterSupport implements SessionEventManagerMBean {

        private final WeakReferenceWithObjectName<SessionEventManagerSimple> eventManagerRef;

        private static final Map<Class<? extends ChangeEvent>, String /* NotificationType */> typeMap;
        static {
            typeMap = new HashMap<Class<? extends ChangeEvent>, String>( );
            typeMap.put( AttributeValueAddEventImpl.class, SessionEventManagerMBean.ATTRIBUTE_VALUE_ADD_EVENT );
            typeMap.put( AttributeValueRemoveEventImpl.class, SessionEventManagerMBean.ATTRIBUTE_VALUE_REMOVE_EVENT );
            typeMap.put( AttributeValueChangeEventImpl.class, SessionEventManagerMBean.ATTRIBUTE_VALUE_CHANGE_EVENT );
            typeMap.put( ElementCreateEventImpl.class, SessionEventManagerMBean.ELEMENT_CREATE_EVENT );
            typeMap.put( ElementDeleteEventImpl.class, SessionEventManagerMBean.ELEMENT_DELETE_EVENT );
            typeMap.put( LinkAddEventImpl.class, SessionEventManagerMBean.LINK_ADD_EVENT );
            typeMap.put( LinkRemoveEventImpl.class, SessionEventManagerMBean.LINK_REMOVE_EVENT );
            typeMap.put( PartitionContentChangeEventImpl.class, SessionEventManagerMBean.PARTITION_CONTENT_CHANGE_EVENT );
            typeMap.put( PartitionCreateEventImpl.class, SessionEventManagerMBean.PARTITION_CREATE_EVENT );
            typeMap.put( PartitionMembershipChangeEventImpl.class, SessionEventManagerMBean.PARTITION_MEMBERSHIP_CHANGE_EVENT );
            typeMap.put( PartitionDeleteEventImpl.class, SessionEventManagerMBean.PARTITION_DELETE_EVENT );
            typeMap.put( PartitionSaveEventImpl.class, SessionEventManagerMBean.PARTITION_SAVE_EVENT );
        }

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private final ObjectName objectName;

        JmxAdapter( SessionEventManagerSimple eventManager, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.eventManagerRef = new WeakReferenceWithObjectName<SessionEventManagerSimple>( eventManager, objectName, refQueue );
            registerBroadcastingMBean( this, SessionEventManagerMBean.class, objectName );
        }

        /**
         * Translates the given {@link ChangeEvent} into a JMX notification and
         * emits it.
         */
        public void sendNotification( ChangeEvent event, boolean preEvent ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                String eventType = typeMap.get( event.getClass( ) );
                if ( preEvent ) {
                    eventType = "PRE_" + eventType; //$NON-NLS-1$
                }
                String eventString = event.toString( );
                String message = eventString.substring( eventString.indexOf( '(' ) + 1, eventString.lastIndexOf( ')' ) );
                Notification notification = new Notification( eventType, objectName, seqNo.incrementAndGet( ), message );
                notification.setUserData( "Conn=" + event.getEventTriggerConnection( ).toString( ) ); //$NON-NLS-1$
                sendNotification( notification );
            }
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( SessionEventManagerMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by a SessionEventManager MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public TabularData showEventListeners( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                return eventManager.listenerHelper.getListenerInfo( );
            }
            return null;
        }

        public boolean getFireEvents( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                return eventManager.doFireEvents;
            }
            return false;
        }

        public void setFireEvents( boolean fireEvents ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                eventManager.doFireEvents = fireEvents;
            }
        }

        public int getMonitoringLevel( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                return eventManager.monitoringLevel;
            }
            return -1;
        }

        public void setMonitoringLevel( int monitoringLevel ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                if ( monitoringLevel != eventManager.monitoringLevel ) {
                    eventManager.monitoringLevel = monitoringLevel;
                    if ( monitoringLevel == 0 ) {
                        eventManager.listenerHelper.reset( );
                    }
                }
            }
        }

        public boolean getLogPreEvents( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                return eventManager.logPreEvents;
            }
            return false;
        }

        public void setLogPreEvents( boolean logPreEvents ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                eventManager.logPreEvents = logPreEvents;
            }
        }

        public int getNumAttributeValueAddEvents( ) {

            return getEventsOfType( AttributeValueAddEventImpl.class );
        }

        public int getNumPartitionCreateEvents( ) {

            return getEventsOfType( PartitionCreateEventImpl.class );
        }

        public void resetEventCounters( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                eventManager.listenerHelper.resetCounters( );
            }
        }

        public int getNumPartitionRemoveEvents( ) {

            return getEventsOfType( PartitionDeleteEventImpl.class );
        }

        public int getNumPartitionSaveEvents( ) {

            return getEventsOfType( PartitionSaveEventImpl.class );
        }

        public int getNumAttributeValueChangeEvents( ) {

            return getEventsOfType( AttributeValueChangeEventImpl.class );
        }

        public int getNumAttributeValueRemoveEvents( ) {

            return getEventsOfType( AttributeValueRemoveEventImpl.class );
        }

        public int getNumElementCreateEvents( ) {

            return getEventsOfType( ElementCreateEventImpl.class );
        }

        public int getNumElementDeleteEvents( ) {

            return getEventsOfType( ElementDeleteEventImpl.class );
        }

        public int getNumLinkAddEvents( ) {

            return getEventsOfType( LinkAddEventImpl.class );
        }

        public int getNumLinkRemoveEvents( ) {

            return getEventsOfType( LinkRemoveEventImpl.class );
        }

        public int getNumPartitionContentChangeEvents( ) {

            return getEventsOfType( PartitionContentChangeEventImpl.class );
        }

        public int getNumPartitionMembershipChangeEvents( ) {

            return getEventsOfType( PartitionMembershipChangeEventImpl.class );
        }

        public int getNumPartitionPropertyChangeEvents( ) {

            return 0;
        }

        private int getEventsOfType( Class clazz ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                Map<Class, AtomicInteger> eventsPerType = eventManager.listenerHelper.eventsPerType;
                if ( eventsPerType != null ) {
                    AtomicInteger count = eventsPerType.get( clazz );
                    if ( count != null ) {
                        return count.intValue( );
                    }
                }
            }
            return 0;
        }

        public void startNotifications( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                eventManager.emitJmxNotifications = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                return eventManager.emitJmxNotifications;
            }
            return false;
        }

        public void stopNotifications( ) {

            SessionEventManagerSimple eventManager = eventManagerRef.get( );
            if ( eventManager != null ) {
                eventManager.emitJmxNotifications = false;
            }
        }
    }

    public ListenerHelper getListenerHelper( ) {

        return listenerHelper;
    }
}
