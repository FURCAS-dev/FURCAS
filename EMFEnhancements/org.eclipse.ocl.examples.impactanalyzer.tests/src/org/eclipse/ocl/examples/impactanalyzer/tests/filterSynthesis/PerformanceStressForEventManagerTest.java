/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.tests.filterSynthesis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.Statistics;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import org.eclipse.ocl.examples.impactanalyzer.impl.OCLFactoryImpl;
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


public class PerformanceStressForEventManagerTest extends TestCase {
    private static final String FILTERSUBSCRIPTION = "filtersubscription";
    private static final String FILTERCREATION = "filtercreation";
    private static final String NOTIFY_REFERENCE_INIT_EXPRESSION_478 = "Notify_Reference_InitExpression_478";
    private static final String NOTIFY_REFERENCE_CLAZZ_264 = "Notify_Reference_Clazz_264";
    private static final String NOTIFY_REFERENCE_OWNED_SIGNATURES_41 = "Notify_Reference_OwnedSignatures_41";
    private static final String NOTIFY_REFERENCE_FACTS_1 = "Notify_Reference_Facts_1";
    private static final String NOTIFY_ATTRIBUTE_UPPER_MULTIPLICITY_487 = "Notify_Attribute_UpperMultiplicity_487";
    private static final String NOTIFY_ATTRIBUTE_NAME_290 = "Notify_Attribute_Name_290";
    private static final String NOTIFY_ATTRIBUTE_SNAPSHOT_1 = "Notify_Attribute_Snapshot_1";
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
        expressions = BenchmarkOCLPreparer.prepareAll(/* oclId */ null /* meaning ALL OCL expressions */);
        eventManager = EventManagerFactory.eINSTANCE.getEventManagerFor(rs);
        notificationCount = 0;
        subscriptions = 0;
        // uncomment the following line in case you want to compare with the performance of the naive
        // event manager:
        // eventManager = new EventManagerNaive(rs);
    }
    
    @Test
    public void testCountRedundantFilters() throws IllegalArgumentException, SecurityException, IllegalAccessException,
            NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        registerFiltersForAllExpressions();
        Object registrationManager = getRegistrationManager();
        Method redundantFiltersMethod = registrationManager.getClass().getDeclaredMethod("redundantFilters");
        int rf = (Integer) redundantFiltersMethod.invoke(registrationManager);
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
           
           
           new Runnable() { public void run() { handle_Attribute_Snapshot_1(); printStats(NOTIFY_ATTRIBUTE_SNAPSHOT_1); } },
           new Runnable() { public void run() { handle_Attribute_Name_290(); printStats(NOTIFY_ATTRIBUTE_NAME_290); } },
           new Runnable() { public void run() { handle_Attribute_UpperMultiplicity_487(); printStats(NOTIFY_ATTRIBUTE_UPPER_MULTIPLICITY_487); } },
           new Runnable() { public void run() { handle_Reference_Facts_1(); printStats(NOTIFY_REFERENCE_FACTS_1); } },
           new Runnable() { public void run() { handle_Reference_OwnedSignatures_41(); printStats(NOTIFY_REFERENCE_OWNED_SIGNATURES_41); } },
           new Runnable() { public void run() { handle_Reference_Clazz_264(); printStats(NOTIFY_REFERENCE_CLAZZ_264); } },
           new Runnable() { public void run() { handle_Reference_InitExpression_478(); printStats(NOTIFY_REFERENCE_INIT_EXPRESSION_478); } }
        }) {
            eventManager = EventManagerFactory.eINSTANCE.getEventManagerFor(rs);
//          eventManager = new EventManagerNaive(rs);
            for (Adapter listener : listeners) {
                eventManager.unsubscribe(listener);
            }
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
        try {
            Field gidmts = getRegistrationManager().getClass().getDeclaredField("GROUP_ID_MINIMUM_TABLE_SIZE");
            gidmts.setAccessible(true);
            String minTableSizeGroupId = (String) gidmts.get(null);
            System.out.println(groupId + "\t" + subscriptions + "\t" + notificationCount + "\t"
                    + Statistics.getInstance().getAverage(minTableSizeGroupId) + "\t"
                    + Statistics.getInstance().getAverage(groupId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        Statistics.getInstance().begin(FILTERCREATION, e);
        EventFilter filter = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(e,
                expression.getContext(), /* notifyOnNewContextElements */ false,
                new OCLFactoryImpl()).createFilterForExpression();
        Statistics.getInstance().end(FILTERCREATION, e);
        Statistics.getInstance().begin(FILTERSUBSCRIPTION, e);
        NotificationReceiverWithFilter listener = new NotificationReceiverWithFilter(filter);
        listeners.add(listener); // hold on to the instance, otherwise it'll be collected due to weak reference usage
        eventManager.subscribe(filter, listener);
        subscriptions++;
        Statistics.getInstance().end(FILTERSUBSCRIPTION, e);
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
            Statistics.getInstance().begin(NOTIFY_ATTRIBUTE_NAME_290, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_ATTRIBUTE_NAME_290, ""+i);
        }
    }

    private void handle_Attribute_UpperMultiplicity_487() {
        InternalEObject notifier;
        // upperMultiplicity has 487 entries in TableForAttributeFilter
        notifier = (InternalEObject) ClassesFactory.eINSTANCE.createClassTypeDefinition();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ClassesPackage.eINSTANCE.getMultiplicity_UpperMultiplicity(), 1, -1);
            Statistics.getInstance().begin(NOTIFY_ATTRIBUTE_UPPER_MULTIPLICITY_487, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_ATTRIBUTE_UPPER_MULTIPLICITY_487, ""+i);
        }
    }

    private void handle_Attribute_Snapshot_1() {
        InternalEObject notifier;
        // snapshot has 1 entry in TableForAttributeFilter
        notifier = (InternalEObject) ExpressionsFactory.eINSTANCE.createAll();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ExpressionsPackage.eINSTANCE.getAll_Snapshot(), 1, -1);
            Statistics.getInstance().begin(NOTIFY_ATTRIBUTE_SNAPSHOT_1, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_ATTRIBUTE_SNAPSHOT_1, ""+i);
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
            Statistics.getInstance().begin(NOTIFY_REFERENCE_CLAZZ_264, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_REFERENCE_CLAZZ_264, ""+i);
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
            Statistics.getInstance().begin(NOTIFY_REFERENCE_FACTS_1, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_REFERENCE_FACTS_1, ""+i);
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
            Statistics.getInstance().begin(NOTIFY_REFERENCE_INIT_EXPRESSION_478, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_REFERENCE_INIT_EXPRESSION_478, ""+i);
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
            Statistics.getInstance().begin(NOTIFY_REFERENCE_OWNED_SIGNATURES_41, ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end(NOTIFY_REFERENCE_OWNED_SIGNATURES_41, ""+i);
        }
    }

    private class NotificationReceiverWithFilter implements Adapter {
        private final Set<Notification> received = new HashSet<Notification>();
        private final EventFilter filter;
        private Notifier target;

        public NotificationReceiverWithFilter(EventFilter filter) {
            this.filter = filter;
        }
        
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

        public Notifier getTarget() {
            return target;
        }

        public void setTarget(Notifier newTarget) {
            target = newTarget;
        }

        public boolean isAdapterForType(Object type) {
            return false;
        }
        
    }

    private Object getRegistrationManager() throws NoSuchFieldException, IllegalAccessException {
        Field registrationManagerField = eventManager.getClass().getDeclaredField("registrationManager");
        registrationManagerField.setAccessible(true);
        Object registrationManager = registrationManagerField.get(eventManager);
        return registrationManager;
    }

}
