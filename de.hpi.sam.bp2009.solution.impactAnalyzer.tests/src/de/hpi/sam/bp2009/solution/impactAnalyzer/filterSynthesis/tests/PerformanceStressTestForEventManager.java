package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;
import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Before;
import org.junit.Test;

import persistence.expressions.ExpressionsFactory;
import persistence.expressions.ExpressionsPackage;
import behavioral.actions.ActionsFactory;
import behavioral.actions.ActionsPackage;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.SapClass;
import dataaccess.analytics.AnalyticsFactory;
import dataaccess.analytics.AnalyticsPackage;
import dataaccess.expressions.literals.LiteralsFactory;
import dataaccess.expressions.literals.StringLiteral;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.Statistics;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased;
import de.hpi.sam.bp2009.solution.eventManager.framework.RegistrationManagerTableBased;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;


public class PerformanceStressTestForEventManager extends TestCase {
    private final int howManyMeasurements = 10;
    private EventManager eventManager;
    private ResourceSet rs;
    private int notificationCount;
    private int subscriptions;
    private Set<NotificationReceiverWithFilter> listeners = new HashSet<NotificationReceiverWithFilter>();
    private List<OCLExpressionWithContext> expressions;
    private int numberOfAlreadyRegisteredExpressions;
    
    @Override
    @Before
    public void setUp() {
        rs = new ResourceSetImpl();
        expressions = BenchmarkOCLPreparer.prepareAll();
        eventManager = new EventManagerTableBased(rs);
        notificationCount = 0;
        subscriptions = 0;
        // uncomment the following line in case you want to compare with the performance of the naive
        // event manager:
        // eventManager = new EventManagerNaive(rs);
    }
    
    @Test
    public void testCountRedundantFilters() throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
        registerFiltersForAllExpressions();
        Field registrationManagerField = eventManager.getClass().getDeclaredField("registrationManager");
        registrationManagerField.setAccessible(true);
        RegistrationManagerTableBased registrationManager = (RegistrationManagerTableBased) registrationManagerField.get(eventManager);
        int rf = registrationManager.redundantFilters();
        Field allRegistrationsField = registrationManager.getClass().getDeclaredField("allRegistrations");
        allRegistrationsField.setAccessible(true);
        Map<?, ?> allRegistrations = (Map<?, ?>) allRegistrationsField.get(registrationManager);
        int totalRegistrationCount = allRegistrations.size();
        System.out.println("Total registrations: "+totalRegistrationCount+", redundant: "+rf+", distinct: "+(totalRegistrationCount-rf));
        assertEquals("Hoping to have no redundant registrations", 0, rf);
    }

    @Test
    public void testSingleAttributeValueChange() {
        registerFiltersForAllExpressions();
        handleAllTestEvents();
        printStats();
    }

    @Test
    public void testWithGrowingFilterSet() {
        for (int i=0; i<howManyMeasurements; i++) {
            registerFiltersForANumberOfExpressions(expressions.size()/howManyMeasurements+1);
            handleAllTestEvents();
            printStats();
            Statistics.getInstance().clear();
        }
    }
    
    @Test
    public void testIndividualNotificationsWithGrowingFilterSet() {
        for (Runnable handleRoutine : new Runnable[] {
           new Runnable() { public void run() { handle_Attribute_Snapshot_1(); } },
           new Runnable() { public void run() { handle_Attribute_Name_290(); } },
           new Runnable() { public void run() { handle_Attribute_UpperMultiplicity_487(); } },
           new Runnable() { public void run() { handle_Reference_Facts_1(); } },
           new Runnable() { public void run() { handle_Reference_OwnedSignatures_41(); } },
           new Runnable() { public void run() { handle_Reference_Clazz_264(); } },
           new Runnable() { public void run() { handle_Reference_InitExpression_478(); } },
           
           
           new Runnable() { public void run() { handle_Attribute_Snapshot_1(); printStats("Notify_Attribute_Snapshot_1"); } },
           new Runnable() { public void run() { handle_Attribute_Name_290(); printStats("Notify_Attribute_Name_290"); } },
           new Runnable() { public void run() { handle_Attribute_UpperMultiplicity_487(); printStats("Notify_Attribute_UpperMultiplicity_487"); } },
           new Runnable() { public void run() { handle_Reference_Facts_1(); printStats("Notify_Reference_Facts_1"); } },
           new Runnable() { public void run() { handle_Reference_OwnedSignatures_41(); printStats("Notify_Reference_OwnedSignatures_41"); } },
           new Runnable() { public void run() { handle_Reference_Clazz_264(); printStats("Notify_Reference_Clazz_264"); } },
           new Runnable() { public void run() { handle_Reference_InitExpression_478(); printStats("Notify_Reference_InitExpression_478"); } }
        }) {
            eventManager = new EventManagerTableBased(rs);
            listeners.clear();
            notificationCount = 0;
            numberOfAlreadyRegisteredExpressions = 0;
            subscriptions = 0;
            for (int i = 0; i <= howManyMeasurements; i++) {
                // start first run with empty event manager
                handleRoutine.run();
                Statistics.getInstance().clear();
                registerFiltersForANumberOfExpressions(expressions.size() / howManyMeasurements + 1);
            }
        }
    }

    private void printStats(String groupId) {
        System.out.println(groupId + "\t" + subscriptions + "\t" + notificationCount + "\t" +
                Statistics.getInstance().getAverage(RegistrationManagerTableBased.GROUP_ID_MINIMUM_TABLE_SIZE) + "\t" +
                Statistics.getInstance().getAverage(groupId));
    }
    
    private void registerFiltersForAllExpressions() {
        registerFiltersForANumberOfExpressions(expressions.size());
    }
    
    private void registerFiltersForANumberOfExpressions(int howManyMore) {
        for (int i=0; i<howManyMore && numberOfAlreadyRegisteredExpressions < expressions.size(); i++) {
            registerFilterForExpressionWithEventManager(expressions.get(numberOfAlreadyRegisteredExpressions++));
        }
    }

    private void registerFilterForExpressionWithEventManager(OCLExpressionWithContext expression) {
        OCLExpression e = expression.getExpression();
        Statistics.getInstance().begin("filtercreation", e);
        EventFilter filter = new ImpactAnalyzerImpl(e, expression.getContext()).createFilterForExpression(/* notifyNewContextElements */ false);
        Statistics.getInstance().end("filtercreation", e);
        Statistics.getInstance().begin("filtersubscription", e);
        NotificationReceiverWithFilter listener = new NotificationReceiverWithFilter(filter);
        listeners.add(listener); // hold on to the instance, otherwise it'll be collected due to weak reference usage
        eventManager.subscribe(filter, listener);
        subscriptions++;
        Statistics.getInstance().end("filtersubscription", e);
    }

    private void printStats() {
        System.out.println("Subscription count\t"+subscriptions);
        System.out.println("Notification count\t"+notificationCount);
        Statistics s = Statistics.getInstance();
        System.out.println(s.averageAsSV("\t"));
    }
    
    private void handleAllTestEvents() {
        // first some attributes:
        handle_Attribute_Name_290();
        handle_Attribute_UpperMultiplicity_487();
        handle_Attribute_Snapshot_1();
        // now some references:
        handle_Reference_Clazz_264();
        handle_Reference_Facts_1();
        handle_Reference_InitExpression_478();
        handle_Reference_OwnedSignatures_41();
    }

    private void handle_Attribute_Name_290() {
        // name has 290 entries in TableForAttributeFilter
        InternalEObject notifier = (InternalEObject) ClassesFactory.eINSTANCE.createSapClass();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ModelmanagementPackage.eINSTANCE.getNamedElement_Name(), "humba", "trala");
            Statistics.getInstance().begin("Notify_Attribute_Name_290", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Attribute_Name_290", ""+i);
        }
    }

    private void handle_Attribute_UpperMultiplicity_487() {
        InternalEObject notifier;
        // upperMultiplicity has 487 entries in TableForAttributeFilter
        notifier = (InternalEObject) ClassesFactory.eINSTANCE.createClassTypeDefinition();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ClassesPackage.eINSTANCE.getMultiplicity_UpperMultiplicity(), 1, -1);
            Statistics.getInstance().begin("Notify_Attribute_UpperMultiplicity_487", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Attribute_UpperMultiplicity_487", ""+i);
        }
    }

    private void handle_Attribute_Snapshot_1() {
        InternalEObject notifier;
        // snapshot has 1 entry in TableForAttributeFilter
        notifier = (InternalEObject) ExpressionsFactory.eINSTANCE.createAll();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ExpressionsPackage.eINSTANCE.getAll_Snapshot(), 1, -1);
            Statistics.getInstance().begin("Notify_Attribute_Snapshot_1", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Attribute_Snapshot_1", ""+i);
        }
    }

    private void handle_Reference_Clazz_264() {
        InternalEObject notifier;
        // clazz has 264 entries in TableForAssociationFilter
        notifier = (InternalEObject) ClassesFactory.eINSTANCE.createClassTypeDefinition();
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ClassesPackage.eINSTANCE.getClassTypeDefinition_Clazz(), null, c);
            Statistics.getInstance().begin("Notify_Reference_Clazz_264", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Reference_Clazz_264", ""+i);
        }
    }

    private void handle_Reference_Facts_1() {
        InternalEObject notifier;
        // facts has 1 entry in TableForAssociationFilter
        notifier = (InternalEObject) AnalyticsFactory.eINSTANCE.createDimensionExpression();
        StringLiteral s = LiteralsFactory.eINSTANCE.createStringLiteral();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    AnalyticsPackage.eINSTANCE.getDimensionExpression_Facts(), null, s);
            Statistics.getInstance().begin("Notify_Reference_Facts_1", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Reference_Facts_1", ""+i);
        }
    }

    private void handle_Reference_InitExpression_478() {
        StringLiteral s = LiteralsFactory.eINSTANCE.createStringLiteral();
        InternalEObject notifier;
        // initExpression has 478 entries in TableForAssociationFilter
        notifier = (InternalEObject) ActionsFactory.eINSTANCE.createNamedValueDeclaration();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ActionsPackage.eINSTANCE.getNamedValueWithOptionalInitExpression_InitExpression(), null, s);
            Statistics.getInstance().begin("Notify_Reference_InitExpression_478", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Reference_InitExpression_478", ""+i);
        }
    }

    private void handle_Reference_OwnedSignatures_41() {
        InternalEObject notifier;
        // ownerSignatures has 41 entries in TableForAssociationFilter and is composite
        notifier = (InternalEObject) ClassesFactory.eINSTANCE.createSapClass();
        MethodSignature m = ClassesFactory.eINSTANCE.createMethodSignature();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ClassesPackage.eINSTANCE.getSignatureOwner_OwnedSignatures(), null, m);
            Statistics.getInstance().begin("Notify_Reference_OwnedSignatures_41", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Reference_OwnedSignatures_41", ""+i);
        }
    }

    private class NotificationReceiverWithFilter implements Adapter {
        private final Set<Notification> received = new HashSet<Notification>();
        private final EventFilter filter;
        private Notifier target;

        public NotificationReceiverWithFilter(EventFilter filter) {
            this.filter = filter;
        }
        
        @Override
        public void notifyChanged(Notification notification) {
            notificationCount++;
            if (received.contains(notification)) {
                fail("Received same notification twice with filter "+filter);
            } else {
                received.add(notification);
                // uncomment the following line in case you want to ensure that
                // all notifications are actually matched by the filter; such a test would
                // mostly be relevant for the table-based event manager to detect false positives
                // assertTrue("Filter "+filter+" doesn't match notification "+notification, filter.matchesFor(notification));
            }
        }

        @Override
        public Notifier getTarget() {
            return target;
        }

        @Override
        public void setTarget(Notifier newTarget) {
            target = newTarget;
        }

        @Override
        public boolean isAdapterForType(Object type) {
            return false;
        }
        
    }

}