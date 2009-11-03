package com.sap.tc.moin.repository.test.performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.core.events.framework.SessionEventManager;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.filter.PackageFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.test.core.EventFrameworkTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class TestEventFrameworkStressTest extends EventFrameworkTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // init client specs
        mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( null, new String[] { "Model" } );
        mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        //create basic elements
        mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );

        eventRegistry = getMOINConnection( ).getSession( ).getEventRegistry( );
        listenersByElements = new HashMap<MofClass, Collection<EventListener>>( );


    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );

        //deregister all pending registrations (should be 0)
        if ( listenersByElements.size( ) > 0 ) {
            for ( Collection<EventListener> listeners : listenersByElements.values( ) ) {
                for ( EventListener listener : listeners ) {
                    eventRegistry.deregister( listener );
                }
            }
        }

        eventRegistry = null;
        mofPackage = null; //refDelete throws NPE, why?
    }

    public int notifications = 0;

    /**
     * ChangeListener
     */
    private class MyChangeListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            notifications++;
        }
    }


    @Test
    public void testESMPScenario( ) {

        int[] elementCounts = { 2000 };
        //        int[] listenerCounts = {1,2,3,4,5,6,7,8,9,10};
        int[] listenerCounts = { 3, 6, 12 };
        int differentListenersCount = 50;
        final int repetitions = 1000;
        //        final int createOrDeleteElementEveryNTimes = 3;
        List<ChangeListener> dListeners = null;

        for ( int cycleNr = 0; cycleNr < 3; cycleNr++ ) { //once with, once without events

            boolean doFireEvents = ( cycleNr == 1 || cycleNr == 2 );

            ( (SessionEventManager) eventRegistry ).setFireEvents( doFireEvents );

            if ( cycleNr == 2 ) { // test the same again with many different listeners
                dListeners = createDifferentListeners( differentListenersCount );
            }
            for ( int i = 0; i < elementCounts.length; i++ ) {

                for ( int u = 0; u < listenerCounts.length; u++ ) {
                    long time = System.currentTimeMillis( );
                    List<MofClass> allElements = createElementsWithInstanceListeners( elementCounts[i], listenerCounts[u] );
                    time = System.currentTimeMillis( ) - time;

                    if ( u == 0 ) {
                        //                        System.out.println(elementCounts[i] + " Elements | " + (elementCounts[i] * listenerCounts[u])
                        //                            + " Listeners  (fireEvents = "+(fireEvents==1)+"): ");
                        System.out.println( listenerCounts[u] + " listeners per element:  (fireEvents = " + doFireEvents + ", cycleNr=" + cycleNr + "): " );
                        if ( cycleNr == 2 ) {
                            System.out.println( "Additionally registered " + differentListenersCount * 6 + " different listeners (also negated listeners)" );
                        }

                        System.out.println( "elementCount\tlistenerCount\tcreate elements \tStressTestChange (" + repetitions + "rep.) \tStressTestCreateDelete \tdeleteElements \tderegister Listeners" );
                    }
                    System.out.print( elementCounts[i] + "\t" + ( elementCounts[i] * listenerCounts[u] + "\t" ) );
                    System.out.print( time + "\t" );

                    time = System.currentTimeMillis( );
                    for ( int o = 0; o < repetitions; o++ ) {
                        MofClass randomElement = allElements.get( (int) ( allElements.size( ) * Math.random( ) ) );
                        randomElement.setName( "bla" );
                        randomElement.setName( "fasel" );
                    }

                    System.out.print( ( System.currentTimeMillis( ) - time ) + "\t" );

                    boolean createdElementLastTime = false;
                    //                    System.out.print("|NotBefore:"+notifications+"|");
                    time = System.currentTimeMillis( );
                    for ( int o = 0; o < repetitions; o++ ) {
                        if ( createdElementLastTime ) {
                            MofClass newClass = createElement( listenerCounts[u] );
                            allElements.add( newClass );
                            createdElementLastTime = false;
                        } else {
                            MofClass randomElement = allElements.get( (int) ( allElements.size( ) * Math.random( ) ) );
                            allElements.remove( randomElement );
                            deleteElement( randomElement );
                            createdElementLastTime = true;
                        }
                    }
                    System.out.print( ( System.currentTimeMillis( ) - time ) + "\t" );
                    //                    System.out.print("|NotAfter:"+notifications+"|");

                    long[] timeForDelete = deleteAllElements( );
                    System.out.println( timeForDelete[0] + "\t" + timeForDelete[1] );
                    //                    System.out.println();

                    int eventsExpected = repetitions * 2 * listenerCounts[u]; // setName()
                    eventsExpected += ( repetitions / 2 ) * listenerCounts[u]; // refDelete() of stressTest
                    eventsExpected += elementCounts[i] * listenerCounts[u]; //refDelete of all Elements at the end
                    if ( cycleNr == 0 ) {
                        eventsExpected = 0;
                    }

                    assertEquals( eventsExpected, notifications );
                    System.out.println( notifications );
                    notifications = 0;
                }

            }

            if ( cycleNr == 2 ) { //deregister different listeners
                for ( ChangeListener l : dListeners ) {
                    eventRegistry.deregister( l );
                }
            }
        }
    }



    /* 
     * 
     */
    /*
     * @Test public void testESMPScenario() { final int elementCount=5000; final
     * int listenersPerElement = 1; final int repetitions = 100; final int
     * createOrDeleteElementEveryNTimes = 3; long time =
     * System.currentTimeMillis(); List<MofClass> allElements =
     * createElementsWithInstanceListeners(elementCount,listenersPerElement);
     * System.out.println("Time needed for creation of "+ elementCount +"
     * elements having each "+ listenersPerElement + " listeners:
     * "+(System.currentTimeMillis()-time) +" ms"); boolean
     * createdElementLastTime = false; time=System.currentTimeMillis(); for (int
     * i = 0; i < repetitions ; i++){ MofClass randomElement =
     * allElements.get((int)(allElements.size()*Math.random()));
     * randomElement.setName("bla"); randomElement.setName("fasel"); if
     * (i%createOrDeleteElementEveryNTimes==0){ if (createdElementLastTime){
     * MofClass newClass = createElement(listenersPerElement);
     * allElements.add(newClass); createdElementLastTime=false; }else{
     * allElements.remove(randomElement); deleteElement(randomElement);
     * createdElementLastTime=true; } } } System.out.println("Time needed for
     * StressTest: "+(System.currentTimeMillis()-time)+" ms");
     * System.out.println("Time for registration / deregistration only: "+
     * registrationAndDeregistrationTimeNeeded + "ms"); System.out.println("Time
     * for notification only:" + elementChangeIncludingNotificationTimeNeeded+"
     * ms"); System.out.println("Parameters:"); System.out.println(notifications +"
     * notifications about AttributeValueChangeEvents (expected
     * "+(repetitions*listenersPerElement*2)+")");
     * System.out.println((repetitions/createOrDeleteElementEveryNTimes)+
     * "creations / deletions of new elements with each having " +
     * listenersPerElement +" listeners"); time = System.currentTimeMillis();
     * int elementsLeft = listenersByElements.size(); deleteAllElements(); long
     * timeNeeded = System.currentTimeMillis()-time; System.out.println("Time
     * needed for deletion of "+ elementsLeft +" elements having each "+
     * listenersPerElement + " listeners: "+ timeNeeded +" ms");
     * System.out.println();
     * System.out.println("=========================================================================================================================================");
     * System.out.println("Average time per 1000 actions when elements are "+
     * createOrDeleteElementEveryNTimes +" times more changed than created:");
     * System.out.println((timeNeeded*1000) / ((repetitions*2)+
     * (repetitions/createOrDeleteElementEveryNTimes))+" ms");
     * //checkReceivedEvents(); }
     */

    private class NonCountingListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

        }

    }

    private List<ChangeListener> createDifferentListeners( int count ) {

        List<ChangeListener> result = new ArrayList<ChangeListener>( count * 6 );


        for ( int i = 0; i < count; i++ ) {

            boolean negated = i % 3 == 0;
            //package = mofModelPackage && EventType != ModelChangeEvent
            ChangeListener listener = new NonCountingListener( );
            EventFilter negatedFilter = new EventTypeFilter( ModelChangeEvent.class );
            negatedFilter.setNegated( negated );
            EventFilter filter = new OrFilter( new PackageFilter( mofModelPackage ), negatedFilter );
            eventRegistry.registerListener( listener, filter );
            result.add( listener );

            MofClass clazz = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
            listener = new NonCountingListener( );
            ClassFilter cf1 = new ClassFilter( clazz, !negated );
            cf1.setNegated( negated );
            ClassFilter cf2 = new ClassFilter( clazz, false );
            cf2.setNegated( negated );
            filter = new OrFilter( cf1, cf2 );
            eventRegistry.registerListener( listener, filter );
            result.add( listener );

            listener = new NonCountingListener( );
            EventTypeFilter etf = new EventTypeFilter( PartitionChangeEvent.class );
            etf.setNegated( negated );
            filter = new OrFilter( new CompositionHierarchyFilter( clazz ), etf );
            eventRegistry.registerListener( listener, filter );
            result.add( listener );

            listener = new NonCountingListener( );
            AttributeFilter af = new AttributeFilter( (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( ) );
            af.setNegated( negated );
            etf = new EventTypeFilter( ModelChangeEvent.class );
            etf.setNegated( negated );
            filter = new OrFilter( af, etf );
            eventRegistry.registerListener( listener, filter );
            result.add( listener );

            Association a = (Association) mofModelPackage.getAssociation( ).refCreateInstance( );
            listener = new NonCountingListener( );
            AssociationFilter assocFilter = new AssociationFilter( a );
            assocFilter.setNegated( negated );
            filter = new OrFilter( assocFilter, new InstanceFilter( new DummyMri( "bla" ) ) );
            eventRegistry.registerListener( listener, filter );
            result.add( listener );

            listener = new NonCountingListener( );
            PartitionFilter pmf = new PartitionFilter( new DummyPri( "bla" ) );
            pmf.setNegated( negated );
            PartitionFilter pf = new PartitionFilter( new DummyPri( "fasel" ) );
            pf.setNegated( negated );
            filter = new OrFilter( pf, pmf );
            eventRegistry.registerListener( listener, filter );
            result.add( listener );

        }

        return result;

    }

    private List<MofClass> createElementsWithInstanceListeners( int elementCount, int listenerCountPerElement ) {

        RefClass classProxy = mofModelPackage.getMofClass( );
        MofClass clazz = null;
        List<MofClass> result = new ArrayList<MofClass>( );

        for ( int elementNr = 0; elementNr < elementCount; elementNr++ ) {
            clazz = (MofClass) classProxy.refCreateInstance( );
            result.add( clazz );

            Collection<EventListener> listenersForCurrentClass = new LinkedList<EventListener>( );
            ChangeListener listener = null;
            //create listener and register it
            for ( int listenerNr = 0; listenerNr < listenerCountPerElement; listenerNr++ ) {
                listener = new MyChangeListener( );
                InstanceFilter filter = new InstanceFilter( clazz );
                listenersForCurrentClass.add( listener );

                eventRegistry.registerListener( listener, filter );
            }

            listenersByElements.put( clazz, listenersForCurrentClass );
        }
        return result;
    }

    private void deleteElement( MofClass element ) {

        //deregister listeners
        //take a random element
        //        int elementNr = (int) Math.abs(Math.random() * listenersByElements.size());
        //        MofClass element = (MofClass) listenersByElements.keySet().toArray()[elementNr];
        Collection<EventListener> listeners = listenersByElements.get( element );

        long time = System.currentTimeMillis( );
        element.refDelete( );
        elementChangeIncludingNotificationTimeNeeded += ( System.currentTimeMillis( ) - time );

        time = System.currentTimeMillis( );
        for ( EventListener listener : listeners ) {
            eventRegistry.deregister( listener );
        }
        registrationAndDeregistrationTimeNeeded += ( System.currentTimeMillis( ) - time );


        listenersByElements.remove( element );
    }

    private MofClass createElement( int listenerCount ) {

        RefClass classProxy = mofModelPackage.getMofClass( );
        long time = System.currentTimeMillis( );
        MofClass clazz = (MofClass) classProxy.refCreateInstance( );
        elementChangeIncludingNotificationTimeNeeded += ( System.currentTimeMillis( ) - time );
        Collection<EventListener> listeners = new LinkedList<EventListener>( );

        time = System.currentTimeMillis( );
        for ( int i = 0; i < listenerCount; i++ ) {
            ChangeListener listener = new MyChangeListener( );
            InstanceFilter filter = new InstanceFilter( clazz );
            eventRegistry.registerListener( listener, filter );
            listeners.add( listener );
        }
        registrationAndDeregistrationTimeNeeded += ( System.currentTimeMillis( ) - time );

        listenersByElements.put( clazz, listeners );

        return clazz;
    }

    /*
     * returns an array of 2 longs: long[0]= time for refDelete, long[1]=time
     * for deregister
     */
    private long[] deleteAllElements( ) {

        long[] result = new long[2];
        long time = System.currentTimeMillis( );

        //      refDelete
        time = System.currentTimeMillis( );
        for ( MofClass element : listenersByElements.keySet( ) ) {
            element.refDelete( );
        }
        result[0] = System.currentTimeMillis( ) - time;

        //deregister
        for ( MofClass element : listenersByElements.keySet( ) ) {
            Collection<EventListener> listeners = listenersByElements.get( element );

            for ( EventListener listener : listeners ) {
                eventRegistry.deregister( listener );
            }
        }
        result[1] = System.currentTimeMillis( ) - time;

        listenersByElements.clear( );
        return result;
    }

    // Housekeeping
    private ModelPackage mofModelPackage;

    private EventRegistry eventRegistry = null;

    private HashMap<MofClass, Collection<EventListener>> listenersByElements = null;

    MofPackage mofPackage = null;

    private long registrationAndDeregistrationTimeNeeded = 0;

    private long elementChangeIncludingNotificationTimeNeeded = 0;

}
