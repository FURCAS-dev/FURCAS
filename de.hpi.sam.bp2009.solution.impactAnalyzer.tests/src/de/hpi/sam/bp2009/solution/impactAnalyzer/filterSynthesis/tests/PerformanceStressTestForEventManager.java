package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.Collection;

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
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;


public class PerformanceStressTestForEventManager extends TestCase implements Adapter {
    private EventManager eventManager;
    private ResourceSet rs;
    private Notifier target;
    private int notificationCount;

    @Override
    @Before
    public void setUp() {
        rs = new ResourceSetImpl();
        Collection<OCLExpressionWithContext> expressions = BenchmarkOCLPreparer.prepareAll();
        eventManager = new EventManagerTableBased(rs);
//        eventManager = new EventManagerNaive(rs);
        for (OCLExpressionWithContext expression : expressions) {
            OCLExpression e = expression.getExpression();
            Statistics.getInstance().begin("filtercreation", e);
            EventFilter filter = new ImpactAnalyzerImpl(e, expression.getContext()).createFilterForExpression(/* notifyNewContextElements */ false);
            Statistics.getInstance().end("filtercreation", e);
            Statistics.getInstance().begin("filtersubscription", e);
            eventManager.subscribe(filter, this);
            Statistics.getInstance().end("filtersubscription", e);
        }
    }

    @Test
    public void testSingleAttributeValueChange() {
        // first some attributes:
        
        // name has 290 entries in TableForAttributeFilter
        InternalEObject notifier = (InternalEObject) ClassesFactory.eINSTANCE.createSapClass();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ModelmanagementPackage.eINSTANCE.getNamedElement_Name(), "humba", "trala");
            Statistics.getInstance().begin("Notify_Attribute_Name_290", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Attribute_Name_290", ""+i);
        }
        // upperMultiplicity has 487 entries in TableForAttributeFilter
        notifier = (InternalEObject) ClassesFactory.eINSTANCE.createClassTypeDefinition();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ClassesPackage.eINSTANCE.getMultiplicity_UpperMultiplicity(), 1, -1);
            Statistics.getInstance().begin("Notify_Attribute_UpperMultiplicity_487", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Attribute_UpperMultiplicity_487", ""+i);
        }
        // snapshot has 1 entry in TableForAttributeFilter
        notifier = (InternalEObject) ExpressionsFactory.eINSTANCE.createAll();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ExpressionsPackage.eINSTANCE.getAll_Snapshot(), 1, -1);
            Statistics.getInstance().begin("Notify_Attribute_Snapshot_1", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Attribute_Snapshot_1", ""+i);
        }
        
        // now some references:
        
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
        
        // initExpression has 478 entries in TableForAssociationFilter
        notifier = (InternalEObject) ActionsFactory.eINSTANCE.createNamedValueDeclaration();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ActionsPackage.eINSTANCE.getNamedValueWithOptionalInitExpression_InitExpression(), null, s);
            Statistics.getInstance().begin("Notify_Reference_InitExpression_478", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Reference_InitExpression_478", ""+i);
        }
        
        // ownerSignatures has 41 entries in TableForAssociationFilter and is composite
        notifier = (InternalEObject) ClassesFactory.eINSTANCE.createSapClass();
        MethodSignature m = ClassesFactory.eINSTANCE.createMethodSignature();
        for (int i = 0; i < 1000; i++) {
            Notification n = new ENotificationImpl(notifier, Notification.SET,
                    ClassesPackage.eINSTANCE.getSignatureOwner_OwnedSignatures(), null, m);
            Statistics.getInstance().begin("Notify_Reference_ownedSignatures_41", ""+i);
            eventManager.handleEMFEvent(n);
            Statistics.getInstance().end("Notify_Reference_ownedSignatures_41", ""+i);
        }
        

        System.out.println("Notification count: "+notificationCount);
        System.out.println(Statistics.getInstance().averageTimeAsSV("\t"));
    }

    @Override
    public void notifyChanged(Notification notification) {
        notificationCount++;
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