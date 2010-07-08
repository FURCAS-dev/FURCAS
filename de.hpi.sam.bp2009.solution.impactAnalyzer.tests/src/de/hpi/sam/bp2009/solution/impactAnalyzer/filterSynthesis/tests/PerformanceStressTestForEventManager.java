package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import data.classes.ClassesFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;


public class PerformanceStressTestForEventManager extends TestCase implements Adapter {
    private EventManager eventManager;
    private ResourceSet rs;
    private Notifier target;
    private int notificationCount;
    
    @Before
    public void setUp() {
        rs = new ResourceSetImpl();
        ArrayList<OCLExpressionWithContext> expressions = BenchmarkOCLPreparer.prepareAll();
        eventManager = new EventManagerTableBased(rs);
        for (OCLExpressionWithContext expression : expressions) {
            eventManager.subscribe(new ImpactAnalyzerImpl(expression.getExpression(), expression.getContext())
                    .createFilterForExpression(/* notifyNewContextElements */ false), this);
        }
    }
    
    @Test
    public void testSingleAttributeValueChange() {
        Notification n = new ENotificationImpl((InternalEObject) ClassesFactory.eINSTANCE.createSapClass(),
                Notification.SET, ModelmanagementPackage.eINSTANCE.getNamedElement_Name(),
                "humba", "trala");
        eventManager.handleEMFEvent(n);
        System.out.println("Notification count: "+notificationCount);
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