/**
 * 
 */
package com.sap.tc.moin.repository.core.events.framework.simple;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.getExceptionAsString;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.openmbean.ArrayType;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import com.sap.tc.moin.repository.core.events.ListenerTypeEnum;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;

public final class ListenerHelper {

    private static final CompositeType compositeTypeForEventListenerLevel1;

    private static final TabularType tabularTypeForEventListenerLevel1;

    private static final CompositeType compositeTypeForEventListenerLevel2;

    private static final TabularType tabularTypeForEventListenerLevel2;

    private static final CompositeType compositeTypeForEventListenerLevel3;

    private static final TabularType tabularTypeForEventListenerLevel3;

    static {
        try {
            ArrayType stringArray = new ArrayType( 1, SimpleType.STRING );
            compositeTypeForEventListenerLevel1 = new CompositeType( "EventListenerInfo1", "EventListenerInfo", new String[] { "1: Id", "2: Type", "3: Filter", "4: Registered At", "5: Exceptions" }, new String[] { "1: Id", "2: Type", "3: Filter", "4: Registered At", "5: Exceptions" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
                                                                     new OpenType[] { SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, stringArray } );
            tabularTypeForEventListenerLevel1 = new TabularType( "EventListenerInfos1", "Event listeners", compositeTypeForEventListenerLevel1, new String[] { "1: Id" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            compositeTypeForEventListenerLevel2 = new CompositeType( "EventListenerInfo2", "EventListenerInfo", new String[] { "1: Id", "2: Type", "3: Filter", "4: Registered At", "5: Exceptions", "6: Consumed events", "7: Vetoed events" }, new String[] { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
                                                                     "1: Id", "2: Type", "3: Filter", "4: Registered At", "5: Exceptions", "6: Consumed events", "7: Vetoed events" }, new OpenType[] { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
                                                                     SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, stringArray, SimpleType.INTEGER, stringArray } );
            tabularTypeForEventListenerLevel2 = new TabularType( "EventListenerInfos2", "Event listeners", compositeTypeForEventListenerLevel2, new String[] { "1: Id" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            compositeTypeForEventListenerLevel3 = new CompositeType( "EventListenerInfo3", "ExtendedEventListenerInfo", new String[] { "1: Id", "2: Type", "3: Filter", "4: Registered At", "5: Exceptions", "6: Consumed events", "7: Vetoed events", "8: Total prepare time", "9: Total notify time" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
                                                                     new String[] { "1: Id", "2: Type", "3: Filter", "4: Registered At", "5: Exceptions", "6: Consumed events", "7: Vetoed events", "8: Total prepare time", "9: Total notify time" }, new OpenType[] { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
                                                                     SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, stringArray, SimpleType.INTEGER, stringArray, SimpleType.FLOAT, SimpleType.FLOAT } );
            tabularTypeForEventListenerLevel3 = new TabularType( "EventListenerInfos3", "Event listeners", compositeTypeForEventListenerLevel3, new String[] { "1: Id" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        } catch ( OpenDataException e ) {
            throw new RuntimeException( e ); // not expected to occur
        }
    }

    Map<Integer, ListenerHelper.ListenerInfo> listenerInfos = null;

    Map<Class, AtomicInteger> eventsPerType = null;

    private final SessionEventManagerSimple eventManager;

    ListenerHelper( SessionEventManagerSimple eventManager ) {

        this.eventManager = eventManager;
    }

    private Map<Integer, ListenerHelper.ListenerInfo> getOrCreateListenerInfos( ) {

        if ( listenerInfos == null ) {
            listenerInfos = new LinkedHashMap<Integer, ListenerHelper.ListenerInfo>( );
        }
        return listenerInfos;
    }

    private Map<Class, AtomicInteger> getOrCreateEventsPerType( ) {

        if ( eventsPerType == null ) {
            eventsPerType = new IdentityHashMap<Class, AtomicInteger>( );
        }
        return eventsPerType;
    }

    public void add( ListenerTypeEnum listenerType, EventListener listener, EventFilter filter ) {

        getOrCreateListenerInfos( ).put( System.identityHashCode( listener ), new ListenerInfo( listenerType, listener, filter, Thread.currentThread( ).getStackTrace( ) ) );
    }

    void reset( ) {

        listenerInfos = null;
        eventsPerType = null;
    }

    @SuppressWarnings( "unchecked" )
    TabularData getListenerInfo( ) {

        int monitoringLevel = eventManager.monitoringLevel;
        TabularData result = null;
        if ( monitoringLevel > 2 ) {
            result = new TabularDataSupport( tabularTypeForEventListenerLevel3 );
        } else if ( monitoringLevel > 1 ) {
            result = new TabularDataSupport( tabularTypeForEventListenerLevel2 );
        } else if ( monitoringLevel > 0 ) {
            result = new TabularDataSupport( tabularTypeForEventListenerLevel1 );
        } else {
            return result;
        }
        if ( listenerInfos == null ) {
            return result;
        }
        for ( ListenerHelper.ListenerInfo info : listenerInfos.values( ) ) {
            EventListener listener = info.listenerRef.get( );
            if ( listener != null ) {
                Map map = new HashMap( );
                map.put( "1: Id", listener.toString( ) ); //$NON-NLS-1$
                map.put( "2: Type", info.listenerType.toString( ) ); //$NON-NLS-1$
                map.put( "3: Filter", info.filter.toString( ) ); //$NON-NLS-1$
                map.put( "4: Registered At", SpiJmxHelper.getStackTraceAsString( info.allocationStackTrace ) ); //$NON-NLS-1$
                String[] exceptionStackTraces = new String[info.thrownExceptions.size( )];
                int i = 0;
                for ( Exception ex : info.thrownExceptions ) {
                    exceptionStackTraces[i++] = getExceptionAsString( ex );
                }
                map.put( "5: Exceptions", exceptionStackTraces ); //$NON-NLS-1$
                if ( monitoringLevel > 1 ) {
                    map.put( "6: Consumed events", info.consumedEvents.intValue( ) ); //$NON-NLS-1$
                    String[] vetoStackTraces = new String[info.vetoedEvents.size( )];
                    int j = 0;
                    for ( Exception ex : info.vetoedEvents ) {
                        vetoStackTraces[j++] = getExceptionAsString( ex );
                    }
                    map.put( "7: Vetoed events", vetoStackTraces ); //$NON-NLS-1$
                }
                if ( monitoringLevel > 2 ) {
                    map.put( "8: Total prepare time", info.totalPrepareTime.floatValue( ) / ( (float) 1e6 ) ); //$NON-NLS-1$
                    map.put( "9: Total notify time", info.totalNotifyTime.floatValue( ) / ( (float) 1e6 ) ); //$NON-NLS-1$
                }
                try {
                    if ( monitoringLevel > 2 ) {
                        result.put( new CompositeDataSupport( compositeTypeForEventListenerLevel3, map ) );
                    } else if ( eventManager.monitoringLevel > 1 ) {
                        result.put( new CompositeDataSupport( compositeTypeForEventListenerLevel2, map ) );
                    } else {
                        result.put( new CompositeDataSupport( compositeTypeForEventListenerLevel1, map ) );
                    }
                } catch ( OpenDataException e ) {
                    throw new RuntimeException( e );
                }
            }
        }
        return result;
    }

    void resetCounters( ) {

        if ( eventsPerType != null ) {
            for ( AtomicInteger counter : eventsPerType.values( ) ) {
                counter.set( 0 );
            }
        }
    }

    void eventFired( Object event ) {

        Class clazz = event.getClass( );
        AtomicInteger count = getOrCreateEventsPerType( ).get( clazz );
        if ( count != null ) {
            count.incrementAndGet( );
        } else {
            getOrCreateEventsPerType( ).put( clazz, new AtomicInteger( 1 ) );
        }
    }

    void remove( EventListener listener ) {

        getOrCreateListenerInfos( ).remove( System.identityHashCode( listener ) );
    }

    int getMonitoringLevel( ) {

        return eventManager.monitoringLevel;
    }

    void exceptionThrown( EventListener listener, Exception e ) {

        ListenerHelper.ListenerInfo info = getOrCreateListenerInfos( ).get( System.identityHashCode( listener ) );
        if ( info != null ) {
            info.thrownExceptions.add( e );
        }
    }

    void eventConsumed( EventListener listener ) {

        ListenerHelper.ListenerInfo info = getOrCreateListenerInfos( ).get( System.identityHashCode( listener ) );
        if ( info != null ) {
            info.consumedEvents.incrementAndGet( );
        }
    }

    void eventVetoed( EventListener listener, ChangeEvent event, VetoException e ) {

        ListenerHelper.ListenerInfo info = getOrCreateListenerInfos( ).get( System.identityHashCode( listener ) );
        if ( info != null ) {
            info.vetoedEvents.add( e );
        }
    }

    void timeConsumedByNotify( EventListener listener, long timeConsumed ) {

        ListenerHelper.ListenerInfo info = getOrCreateListenerInfos( ).get( System.identityHashCode( listener ) );
        if ( info != null ) {
            info.totalNotifyTime.addAndGet( timeConsumed );
        }
    }

    void timeConsumedByPrepare( PreChangeListener listener, long timeConsumed ) {

        ListenerHelper.ListenerInfo info = getOrCreateListenerInfos( ).get( System.identityHashCode( listener ) );
        if ( info != null ) {
            info.totalPrepareTime.addAndGet( timeConsumed );
        }
    }

    /**
     * Stores information about a single listener.
     */
    private static final class ListenerInfo {

        final WeakReference<EventListener> listenerRef;

        final EventFilter filter;

        final StackTraceElement[] allocationStackTrace;

        final ListenerTypeEnum listenerType;

        final ConcurrentLinkedQueue<Exception> thrownExceptions;

        final AtomicInteger consumedEvents;

        final ConcurrentLinkedQueue<VetoException> vetoedEvents;

        final AtomicLong totalPrepareTime;

        final AtomicLong totalNotifyTime;

        ListenerInfo( ListenerTypeEnum listenerType, EventListener listener, EventFilter filter, StackTraceElement[] allocationStackTrace ) {

            this.listenerType = listenerType;
            this.listenerRef = new WeakReference<EventListener>( listener );
            this.filter = filter;
            this.allocationStackTrace = allocationStackTrace;
            this.thrownExceptions = new ConcurrentLinkedQueue<Exception>( );
            this.consumedEvents = new AtomicInteger( 0 );
            this.vetoedEvents = new ConcurrentLinkedQueue<VetoException>( );
            this.totalPrepareTime = new AtomicLong( 0 );
            this.totalNotifyTime = new AtomicLong( 0 );
        }
    }
}
