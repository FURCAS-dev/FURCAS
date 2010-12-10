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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.SapClass;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.MethodCallExpression;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model.ModelCloner;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OCLFactoryImpl;

public class NgpmModelBasedOclIaTest extends TestCase {
    Resource ngpmModel = null;
    List<RawNotification> modifyElementaryTypesTrace = null;

    @Override
    public void setUp(){
	ngpmModel = NotificationResourceLoader.loadModel("NgpmModel.xmi");
	modifyElementaryTypesTrace = NotificationResourceLoader.loadTrace("modifyElementaryTypesEventTrace.trace");
    }

    @Test
    public void testRenameStringAppendToAppend2() {
        final OCLExpression exp = (OCLExpression) OclIaTest
                .parse("context dataaccess::expressions::MethodCallExpression inv: "
                        + "self.object.getType().getInnermost().oclAsType(classes::ClassTypeDefinition).clazz.allSignatures()->select(s : MethodSignature | s.name='.'.concat('xxx'))",
                        ClassesPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        final MethodSignature append = (MethodSignature) ngpmModel.getEObject("E01F04667A9220905D0911DFA13BFF380A1CE22F");
        assertEquals("append", append.getName());
        final ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(
                exp, /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        final boolean[] result = new boolean[1];
        append.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                Collection<EObject> impact = ia.getContextObjects(msg);
                if (OptimizationActivation.getOption().isOperationCallSelectionActive()) {
                    result[0] = impact.size() > 5 && impact.size() < 10;
                    if (!result[0]) {
                        System.err
                                .println("Expected between 5 and 10 impacted MethodCallExpressions only for calls on string but found "
                                        + impact.size());
                    }
                } else {
                    result[0] = impact.size() > 50 && impact.size() < 100;
                    if (!result[0]) {
                        System.err.println("Expected between 50 and 100 impacted MethodCallExpressions but found only "
                                + impact.size());
                    }
                }
            }
        });
        append.setName("append2");
        assertTrue(result[0]);
    }

    @Test
    public void testVariableExpressionWithCollectionType() {
	OCLExpression exp = (OCLExpression) OclIaTest.parse("context NestedTypeDefinition inv: self.getNamedValuesInScope()", ClassesPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();

	RawNotification rawNotification = modifyElementaryTypesTrace.get(1);
	Notification notification = rawNotification.convertToNotification(ModelCloner.cloneResource(ngpmModel,"1"));

	ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp,
	        data.classes.ClassesPackage.eINSTANCE.getNestedTypeDefinition(),
	        /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
	Collection<EObject> impact = ia.getContextObjects(notification);
	assertEquals(impact.size(), 0);
    }

    public void testExpressionWithLargeNavigationStepGraph(){
	OCLExpressionWithContext expr = new OCLExpressionFromClassTcsPicker().pickUpExpression(44);

	Notification notification = getNotification(10, ngpmModel);

	ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expr.getExpression(), expr.getContext(),/* notifyOnNewContextElements */ false, new OCLFactoryImpl());
	Collection<EObject> impact = ia.getContextObjects(notification);
	assertNotNull(impact);
    }
    
    @Test
    public void testSuperExpensiveChange() {
        final OCLExpression exp = (OCLExpression) OclIaTest
                .parse("context dataaccess::expressions::MethodCallExpression inv: "
                        + "self.object.getType().getInnermost().oclAsType(classes::ClassTypeDefinition).clazz.allSignatures()->select(s : MethodSignature | s.name='.'.concat('xxx'))",
                        ClassesPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        final SapClass string = (SapClass) ngpmModel.getEObject("E0B91841F0303550560511DECC310019D29902CC");
        final MethodSignature append = (MethodSignature) ngpmModel.getEObject("E01F04667A9220905D0911DFA13BFF380A1CE22F");
        final ClassTypeDefinition appendParamCTD = (ClassTypeDefinition) append.getInput().get(0).getOwnedTypeDefinition();
        assertEquals(string, appendParamCTD.getClazz());
        assertEquals("append", append.getName());
        final ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        final boolean[] result = new boolean[1];
        appendParamCTD.setClazz(null);
        appendParamCTD.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                Collection<EObject> impact = ia.getContextObjects(msg);
                result[0] = impact.size() == 0;
                if (!result[0]) {
                    System.err.println("Expected unused check to find out that change has no impact but IA said " + impact.size()
                            + " objects were impacted");
                }
            }
        });
        appendParamCTD.setClazz(null);
        assertTrue(result[0]);
    }

    @Test
    public void testAllSignaturesDependencyOnChangingSomethingOnStringClass() {
        final OCLExpression exp = (OCLExpression) OclIaTest
                .parse("context SapClass inv: " + "self.allSignatures()",
                        ClassesPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        final SapClass string = (SapClass) ngpmModel.getEObject("E0B91841F0303550560511DECC310019D29902CC");
        final ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, data.classes.ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        final boolean[] result = new boolean[1];
        string.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                Collection<EObject> impact = ia.getContextObjects(msg);
                result[0] = impact.size() == 2 && impact.contains(string);
            }
        });
        string.getOwnedSignatures().add(ClassesFactory.eINSTANCE.createMethodSignature());
        assertTrue(result[0]);
    }

    @Test
    public void testExpensiveAllSignaturesExpressionAddingMethodSignatureToString() {
        final OCLExpression exp = (OCLExpression) OclIaTest
                .parse("context MethodCallExpression inv: " +
                        "self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()",
                        ExpressionsPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        final SapClass string = (SapClass) ngpmModel.getEObject("E0B91841F0303550560511DECC310019D29902CC");
        final MethodCallExpression callOnStringTypedExpression = (MethodCallExpression) ngpmModel.getEObject("E02C978BFD3F74805D0811DF8A6AFF380A1CE22F");
        final EList<MethodSignature> oldValue = ((ClassTypeDefinition) callOnStringTypedExpression.getObject().getType().getInnermost()).getClazz().allSignatures();
        final ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        final boolean[] result = new boolean[1];
        string.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                Collection<EObject> impact = ia.getContextObjects(msg);
                result[0] = impact.contains(callOnStringTypedExpression);
                if (!result[0]) {
                    System.err
                            .println("Expecting a method call on a string-typed expression to be impacted by adding a signature to String");
                } else {
                    if (OptimizationActivation.getOption().isOperationCallSelectionActive()) {
                        result[0] = impact.size() > 5 && impact.size() < 10;
                        if (!result[0]) {
                            System.err
                                    .println("Expected between 5 and 10 impacted MethodCallExpressions only for calls on string but found "
                                            + impact.size());
                        }
                    } else {
                        result[0] = impact.size() > 50 && impact.size() < 100;
                        if (!result[0]) {
                            System.err.println("Expected between 50 and 100 impacted MethodCallExpressions but found only "
                                    + impact.size());
                        }
                    }
                    Iterator<EObject> ii = impact.iterator();
                    while (result[0] && ii.hasNext()) {
                        EObject n = ii.next();
                        result[0] = result[0] && (n instanceof MethodCallExpression);
                        if (!result[0]) {
                            System.err
                                    .println("Found an impacted object that was not, as expected, a MethodCallExpression: " + n);
                        }
                        if (OptimizationActivation.getOption().isOperationCallSelectionActive()) {
                            // can enforce result type only if selective operation call traceback is active
                            // because traceback visits OperationCallExp of getType() that are
                            // not actually used and therefore returns a true superset; activate the following check if crisp
                            // operation call
                            // checking is performed
                            result[0] = result[0]
                                    && (((ClassTypeDefinition) (((MethodCallExpression) n).getObject().getType().getInnermost()))
                                            .getClazz().conformsTo(string));
                            if (!result[0]) {
                                System.err
                                        .println("Found an impacted MethodCallExpression that is not called on an object of type String but on "
                                                + (((ClassTypeDefinition) (((MethodCallExpression) n).getObject().getType()
                                                        .getInnermost())).getClazz().getName())
                                                + ": "
                                                + ((MethodCallExpression) n).getMethodSignature().getName());
                            }
                        }
                    }
                }
            }
        });
        string.getOwnedSignatures().add(ClassesFactory.eINSTANCE.createMethodSignature());
        EList<MethodSignature> newValue = ((ClassTypeDefinition) callOnStringTypedExpression.getObject().getType().getInnermost()).getClazz().allSignatures();
        assertFalse("Expecting a method call on a string-typed expression to be impacted by adding a signature to String",
                newValue.equals(oldValue));
        assertTrue(result[0]);
    }

    @Test
    public void testUnusedForAdaptedSignaturesExpressionNullingClazzReferenceOnCTD() {
        final OCLExpression exp = (OCLExpression) OclIaTest
                .parse("context SapClass inv: " +
                        "self.adaptedSignatures()",
                        ClassesPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        final SapClass string = (SapClass) ngpmModel.getEObject("E0B91841F0303550560511DECC310019D29902CC");
        final MethodSignature append = (MethodSignature) ngpmModel.getEObject("E01F04667A9220905D0911DFA13BFF380A1CE22F");
        final ClassTypeDefinition appendOutputCTD = (ClassTypeDefinition) append.getOutput();
        assertEquals(string, appendOutputCTD.getClazz());
        assertEquals("append", append.getName());
        final ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, data.classes.ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        final boolean[] result = new boolean[1];
        appendOutputCTD.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                Collection<EObject> impact = ia.getContextObjects(msg);
                if (OptimizationActivation.getOption().isTracebackStepISAActive() && OptimizationActivation.getOption().isUnusedDetectionActive()) {
                    result[0] = impact.size() == 0;
                    if (!result[0]) {
                        System.err.println("Expected unused check to find out that change has no impact but IA said "+impact.size()+
                                " objects were impacted");
                    }
                } else {
                    result[0] = impact.size() == 2; // String and the formal type parameter "T extends String" in the generics test
                    if (!result[0]) {
                        System.err.println("Expected two impacted classes (String and T) but found "+impact.size());
                    }
                }
            }
        });
        appendOutputCTD.setClazz(null);
        assertTrue(result[0]);
    }

    @Test
    public void testUnusedForAllSignaturesExpressionNullingClazzReferenceOnCTD() {
        final OCLExpression exp = (OCLExpression) OclIaTest
                .parse("context MethodCallExpression inv: " +
                        "self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()",
                        ExpressionsPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        final SapClass string = (SapClass) ngpmModel.getEObject("E0B91841F0303550560511DECC310019D29902CC");
        // would have to be a call on the output of append()
        final MethodCallExpression callOnAppendCallResult = (MethodCallExpression) ngpmModel.getEObject("E012BF1E3D01FCF05D0E11DF9483DFF10A1CE22F");
        callOnAppendCallResult.getObject().setOwnedTypeDefinition(null); // force append's output type definition to be used in call's getType()
        final Object oldValue = com.sap.emf.ocl.util.OCL.newInstance().evaluate(callOnAppendCallResult, exp);
        final MethodSignature append = (MethodSignature) ngpmModel.getEObject("E01F04667A9220905D0911DFA13BFF380A1CE22F");
        final ClassTypeDefinition appendOutputCTD = (ClassTypeDefinition) append.getOutput();
        assertEquals(string, appendOutputCTD.getClazz());
        assertEquals("append", append.getName());
        final ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        final boolean[] result = new boolean[1];
        appendOutputCTD.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                Collection<EObject> impact = ia.getContextObjects(msg);
                if (!impact.contains(callOnAppendCallResult)) {
                    System.err.println("Expecting a method call on a string-typed expression to be impacted by adding a signature to String");
                    result[0] = false;
                } else {
                    if (OptimizationActivation.getOption().isTracebackStepISAActive()) {
                        result[0] = impact.size() > 5 && impact.size() < 10;
                        if (!result[0]) {
                            System.err.println("Expected unused check to find between 5 and 10 changed but IA said "
                                    + impact.size() + " objects were impacted");
                        }
                    } else {
                        result[0] = impact.size() > 50;
                        if (!result[0]) {
                            System.err
                                    .println("Expected more than 50 method calls to be impacted without unused check but found only "
                                            + impact.size());
                        }
                    }
                }
            }
        });
        appendOutputCTD.setClazz(null);
        assertFalse(oldValue instanceof DynamicEObjectImpl);
        assertNull("Expecting a method call on the result of String.append() with no ownedTypeDefinition on that call to me impacted "+
                "by setting String.append()'s output type definition's clazz to null",
                ((ClassTypeDefinition) callOnAppendCallResult.getObject().getType().getInnermost()).getClazz());
        Object invalid = OCL.newInstance().evaluate(callOnAppendCallResult, exp);
        assertFalse(invalid.equals(oldValue));
        assertTrue(result[0]);
    }

    private Notification getNotification(int id, Resource model){
         Resource clonedModel = ModelCloner.cloneResource(model, String.valueOf(Math.random()));

        for(int i = 0; i < (id - 1); i++) {
                changeModel(i, clonedModel);
        }
        return changeModel(id - 1, clonedModel);
    }

        private Notification changeModel(int id, Resource clonedModel) {
                RawNotification raw = modifyElementaryTypesTrace.get(id);

        System.out.println(raw.getEventType());
        if(raw.isSplitCandidate()){
                System.out.println("candidate");
                raw.split().get(0).convertToNotification(clonedModel);
                return raw.split().get(1).convertToNotification(clonedModel);
        } else
	    return raw.convertToNotification(clonedModel);
        }

}
