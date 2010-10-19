package com.sap.emf.ocl.trigger.tests;

import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Before;
import org.junit.Test;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.AbstractTriggerable;
import com.sap.emf.ocl.trigger.AdapterForExpression;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.TriggerManagerFactory;
import com.sap.emf.ocl.trigger.Triggerable;
import com.sap.emf.ocl.trigger.Triggerable.ExpressionWithContext;
import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

public class SimpleTests extends TestCase {
    private ResourceSet resourceSet;
    private Resource resource;
    private TriggerManager triggerManager;
    
    @Before
    public void setUp() {
        resourceSet = new ResourceSetImpl();
        resourceSet.eAdapters().add(new ECrossReferenceAdapter());
        resource = resourceSet.createResource(URI.createURI("http://com.sap.emf.ocl.trigger.tests/Resource.xmi"));
        triggerManager = TriggerManagerFactory.INSTANCE.createTriggerManager();
        triggerManager.addToObservedResourceSets(resourceSet);
    }
    
    @Test
    public void testTrivialTrigger() throws ParserException {
        final Department d = CompanyFactory.eINSTANCE.createDepartment();
        resource.getContents().add(d);
        Helper helper = OCLWithHiddenOpposites.newInstance().createOCLHelper();
        helper.setContext(CompanyPackage.eINSTANCE.getDepartment());
        final OCLExpression trivialExpression = helper.createQuery("self.name");
        final boolean[] result = new boolean[1];
        Triggerable t = new AbstractTriggerable(Collections.singleton(new ExpressionWithContext(trivialExpression,
                /* context is implicit because self is used */ null, /* notifyNewContextElements */ false))) {
            @Override
            public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder) {
                result[0] = expression == trivialExpression && affectedContextObjects.size() == 1 &&
                            affectedContextObjects.contains(d);
            }

            @Override
            public Collection<AdapterForExpression> getAdapters(OppositeEndFinder oppositeEndFinder,
                    ActivationOption impactAnalysisConfiguration) throws ParserException {
                return Collections.singleton(new AdapterForExpression(this, trivialExpression, CompanyPackage.eINSTANCE
                        .getDepartment(), /* notifyNewContextElements */false, oppositeEndFinder, impactAnalysisConfiguration));
            }
        };
        triggerManager.register(t);
        d.setName("Humba");
        assertTrue(result[0]);
    }

    @Test
    public void testTrivialTriggerWithTwoObjects() throws ParserException {
        final Department d1 = CompanyFactory.eINSTANCE.createDepartment();
        resource.getContents().add(d1);
        final Department d2 = CompanyFactory.eINSTANCE.createDepartment();
        resource.getContents().add(d2);
        Helper helper = OCLWithHiddenOpposites.newInstance().createOCLHelper();
        helper.setContext(CompanyPackage.eINSTANCE.getDepartment());
        final OCLExpression trivialExpression = helper.createQuery("self.name");
        final boolean[] result = new boolean[1];
        Triggerable t = new AbstractTriggerable(Collections.singleton(new ExpressionWithContext(trivialExpression,
                /* context is implicit because self is used */ null, /* notifyNewContextElements */ false))) {
            @Override
            public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder) {
                result[0] = expression == trivialExpression && affectedContextObjects.size() == 1 &&
                            affectedContextObjects.contains(d1);
            }

            @Override
            public Collection<AdapterForExpression> getAdapters(OppositeEndFinder oppositeEndFinder,
                    ActivationOption impactAnalysisConfiguration) throws ParserException {
                return Collections.singleton(new AdapterForExpression(this, trivialExpression, CompanyPackage.eINSTANCE
                        .getDepartment(), /* notifyNewContextElements */false, oppositeEndFinder, impactAnalysisConfiguration));
            }
        };
        triggerManager.register(t);
        d1.setName("Humba");
        assertTrue(result[0]);
    }
}
