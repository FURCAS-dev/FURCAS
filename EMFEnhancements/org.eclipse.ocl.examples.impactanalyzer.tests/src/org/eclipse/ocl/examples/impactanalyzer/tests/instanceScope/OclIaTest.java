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
package org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope;

import java.util.Collection;

import modelmanagement.ModelmanagementFactory;
import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationHelper;
import org.eclipse.ocl.examples.impactanalyzer.configuration.OptimizationActivation;
import org.eclipse.ocl.examples.impactanalyzer.impl.OCLFactoryImpl;
import org.eclipse.ocl.examples.impactanalyzer.testutils.BaseDepartmentTest;
import org.junit.Test;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeAdapter;
import dataaccess.expressions.ExpressionsFactory;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.VariableExpression;
import dataaccess.expressions.literals.LiteralsFactory;
import dataaccess.expressions.literals.LiteralsPackage;
import dataaccess.expressions.literals.ObjectLiteral;
import dataaccess.expressions.literals.StringLiteral;

public class OclIaTest extends BaseDepartmentTest {

    private static final String testAnalysisOfRecursiveOperationWithSelf = "context dataaccess::expressions::MethodCallExpression \n"
            + "inv testAnalysisOfRecursiveOperationWithSelf: \n"
            + "self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures() \n"
            + "->select(s | s.name = 'testMethod')";

    private static final String testAllInstancesSelectClassName = "context data::classes::ClassTypeDefinition \n"
            + "inv testAllInstancesSelectClassName:\n" + "data::classes::SapClass.allInstances()->select(c | c.name = 'Bob')";

    private static final String testVerySimpleTracerBasedInstanceScopeAnalysisWithNewClassScopeAnalysis = "context data::classes::SapClass \n"
            + "inv testVerySimpleTracerBasedInstanceScopeAnalysisWithNewClassScopeAnalysis: \n"
            + "self.oclAsType(data::classes::SapClass).name";

    private static final String testLongRunningNavigationPathExpression = "context data::classes::AssociationEnd inv LongRunningNavigationPath: \n "
            + "'.'.concat(self.oclAsType(data::classes::AssociationEnd).name)";

    private static final String testLowerMultiplicityPropagationForMethodCall = "context data::classes::ClassTypeDefinition \n"
            + "inv testLowerMultiplicityPropagationForMethodCallOnParameterUsage: \n"
            + "self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.lowerMultiplicity * \n"
            + "self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().lowerMultiplicity";

    private static final String testInstanceScopeAnalysisForRecursiveOperation = "context data::classes::SapClass \n"
            + "inv testInstanceScopeAnalysisForRecursiveOperation: \n" + "self.adapters->forAll(a | self.conformsTo(a.to))";

    private static final String testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf = "context data::classes::SapClass \n"
            + "inv testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf: \n" + "Tuple{cls=self}.cls.name";

    private static final String testVerySimpleInstanceScopeAnalysisWithTuple = "context data::classes::SapClass \n"
            + "inv testVerySimpleInstanceScopeAnalysisWithTuple: \n" + "Tuple{name=self.name}.name";

    private static final String testForIA2 = "context dataaccess::expressions::literals::ObjectLiteral \n" + "inv testForIA2: \n"
            + "self.oclAsType(dataaccess::expressions::literals::ObjectLiteral).valueClass.getAssociationEnds().otherEnd()"
            + "->select(ae|ae.name='Assoc_to_Bob_changed')";

    private EPackage cp;
    private ResourceSetImpl rs;

    @Override
    public void setUp() {
        this.cp = ClassesPackage.eINSTANCE;
        this.rs = new ResourceSetImpl();
        this.rs.eAdapters().add(new ECrossReferenceAdapter());
        this.rs.getResources().add(this.cp.eResource());
    }

    @Override
    public void tearDown() {
        this.rs = null;
        this.cp = null;
    }
    

    @Test
    public void testResultUseInIterate() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testMoveWithoutImpact:\n" +
                "Sequence{1, 2, 3}->iterate(i; result:Set(data::classes::SapClass)=Set{self} | result.ownedSignatures.output.oclAsType(data::classes::ClassTypeDefinition).clazz)",
                this.cp).iterator().next().getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
        c1.setName("c1");
        SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
        c2.setName("c2");
        SapClass c3 = ClassesFactory.eINSTANCE.createSapClass();
        c3.setName("c3");
        SapClass c4 = ClassesFactory.eINSTANCE.createSapClass();
        c4.setName("c4");
        SapClass c5 = ClassesFactory.eINSTANCE.createSapClass();
        c5.setName("c5");
        SapClass c6 = ClassesFactory.eINSTANCE.createSapClass();
        c6.setName("c6");

        connectWithMethodOutput(c1, c2);
        connectWithMethodOutput(c2, c3);
        connectWithMethodOutput(c3, c4);
        connectWithMethodOutput(c4, c5);

        this.cp.eResource().getContents().add(c1);
        this.cp.eResource().getContents().add(c2);
        this.cp.eResource().getContents().add(c3);
        this.cp.eResource().getContents().add(c4);
        this.cp.eResource().getContents().add(c5);
        final Notification[] noti = new Notification[1];
        Adapter adapter = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                noti[0] = msg;
            }
        };
        c5.eAdapters().add(adapter);
        connectWithMethodOutput(c5, c6);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti[0]);
        assertEquals(5, impact.size()); // expecting all c1..c6 to be impacted
        assertFalse(impact.contains(c6));
    }

    private void connectWithMethodOutput(SapClass c1, SapClass c2) {
        MethodSignature m1 = ClassesFactory.eINSTANCE.createMethodSignature();
        m1.setName("m1");
        ClassTypeDefinition ctd1 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctd1.setClazz(c2);
        m1.setOutput(ctd1);
        c1.getOwnedSignatures().add(m1);
    }

    @Test
    public void testMoveWithoutImpact() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testMoveWithoutImpact:\n" + "self.ownedSignatures->at(3).name = 'm3'",
                this.cp).iterator().next().getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        MethodSignature m1 = ClassesFactory.eINSTANCE.createMethodSignature();
        m1.setName("m1");
        c.getOwnedSignatures().add(m1);
        MethodSignature m2 = ClassesFactory.eINSTANCE.createMethodSignature();
        m2.setName("m2");
        c.getOwnedSignatures().add(m2);
        MethodSignature m3 = ClassesFactory.eINSTANCE.createMethodSignature();
        m1.setName("m3");
        c.getOwnedSignatures().add(m3);
        this.cp.eResource().getContents().add(c);
        c.setName("C");
        final Notification[] noti = new Notification[1];
        Adapter adapter = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                noti[0] = msg;
            }
        };
        c.eAdapters().add(adapter);
        c.getOwnedSignatures().move(0, 1); // swap first two signatures
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti[0]);
        assertEquals(0, impact.size());
        c.getOwnedSignatures().move(1, 2); // not the name of the element at position 3 should have changed
        Collection<EObject> impact2 = ia.getContextObjects(noti[0]);
        assertEquals(1, impact2.size());
        assertTrue(impact2.contains(c));
    }

    @Test
    public void testTupleLiteralUsedTwice() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testTupleLiteralUsedTwice:\n"
                        + "let t:Tuple(c:data::classes::SapClass, d:data::classes::SapClass) = Tuple{c=self, d=self.adapters.to->first()} in\n"
                        + "Set{t.c.name, t.d.name}", this.cp).iterator().next().getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        SapClass d = ClassesFactory.eINSTANCE.createSapClass();
        d.setName("D");
        this.cp.eResource().getContents().add(c);
        c.setName("oldName");
        TypeAdapter ta = ClassesFactory.eINSTANCE.createTypeAdapter();
        ta.setAdapted(c);
        ta.setTo(d);
        EAttribute att = (EAttribute) c.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(c, att, "oldName", "newName");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(c));
        Notification noti2 = NotificationHelper.createAttributeChangeNotification(d, att, "D", "newD");
        Collection<EObject> impact2 = ia.getContextObjects(noti2);
        assertTrue(impact2.size() == 2 && impact2.contains(c) && impact2.contains(d));
    }

    @Test
    public void testTupleLiteralWithImmediatePropertyCall() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testTupleLiteralWithImmediatePropertyCall:\n" + "Tuple{c=self}.c.name",
                this.cp).iterator().next().getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        this.cp.eResource().getContents().add(c);
        c.setName("oldName");
        EAttribute att = (EAttribute) c.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(c, att, "oldName", "newName");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(c));
    }

    @Test
    public void testTupleLiteralPassedThroughLetVariable() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testTupleLiteralPassedThroughLetVariable:\n"
                        + "let t:Tuple(c:data::classes::SapClass) = Tuple{c=self} in\n" + "t.c.name", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        this.cp.eResource().getContents().add(c);
        c.setName("oldName");
        EAttribute att = (EAttribute) c.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(c, att, "oldName", "newName");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(c));
    }

    @Test
    public void testTupleLiteralPassedThroughTwoLetVariables() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testTupleLiteralPassedThroughLetVariable:\n"
                        + "let t1:Tuple(c:data::classes::SapClass) = Tuple{c=self} in\n"
                        + "let t2:Tuple(c:data::classes::SapClass) = t1 in\n" + "t2.c.name", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        this.cp.eResource().getContents().add(c);
        c.setName("oldName");
        EAttribute att = (EAttribute) c.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(c, att, "oldName", "newName");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(c));
    }

    @Test
    public void testNestedTupleLiteral() {
        OCLExpression expression = (OCLExpression) parse(
                "context data::classes::SapClass inv testNestedTupleLiteral:\n"
                        + "Tuple{c:Tuple(d:data::classes::SapClass)=Tuple{d=self}}.c.d.name", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        this.cp.eResource().getContents().add(c);
        c.setName("oldName");
        EAttribute att = (EAttribute) c.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(c, att, "oldName", "newName");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(c));
    }

    @Test
    public void testLongRunningNavigationPathConstruction() {
        OCLExpression expression = (OCLExpression) parse(testLongRunningNavigationPathExpression, this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(expression);
        AssociationEnd ae = ClassesFactory.eINSTANCE.createAssociationEnd();
        this.cp.eResource().getContents().add(ae);
        EAttribute att = (EAttribute) ae.eClass().getEStructuralFeature(ClassesPackage.ASSOCIATION_END__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(ae, att, "oldName", "newName");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, ClassesPackage.eINSTANCE
                .getAssociationEnd(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertTrue(impact.size() == 1 && impact.contains(ae));
    }

    /**
     * self.ownerTypedElement.oclAsType(MethodCallExpression).methodSignature.output.lowerMultiplicity *
     * self.ownerTypedElement.oclAsType(MethodCallExpression).object.getType().lowerMultiplicity
     */

    @Test
    public void testLowerMultiplicityPropagationForMethodCallOnParameterUsage() {
        OCLExpression exp = (OCLExpression) parse(testLowerMultiplicityPropagationForMethodCall, this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        Resource r = this.cp.eResource();
        r.eAdapters().add(new ECrossReferenceAdapter());
        r.getContents().add(exp);
        // construct something like "abc".length(), then change multiplicity of "abc" from 1..1 to 0..1
        MethodSignature length = ClassesFactory.eINSTANCE.createMethodSignature();
        r.getContents().add(length);
        length.setName("length");
        SapClass numberClass = ClassesFactory.eINSTANCE.createSapClass();
        r.getContents().add(numberClass);
        numberClass.setName("Number");
        ClassTypeDefinition msOutput = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        msOutput.setClazz(numberClass);
        msOutput.setLowerMultiplicity(1);
        msOutput.setUpperMultiplicity(1);
        length.setOutput(msOutput);
        ClassTypeDefinition ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctd.setClazz(numberClass);
        ctd.setLowerMultiplicity(1);
        ctd.setUpperMultiplicity(1);
        MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
        r.getContents().add(mce);
        mce.setOwnedTypeDefinition(ctd);
        mce.setMethodSignature(length);
        Parameter p = ClassesFactory.eINSTANCE.createParameter();
        r.getContents().add(p);
        p.setName("p");
        SapClass stringClass = ClassesFactory.eINSTANCE.createSapClass();
        r.getContents().add(stringClass);
        stringClass.setName("String");
        ClassTypeDefinition otDef = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        otDef.setClazz(stringClass);
        otDef.setUpperMultiplicity(1);
        otDef.setLowerMultiplicity(1);
        p.setOwnedTypeDefinition(otDef);
        VariableExpression ve = ExpressionsFactory.eINSTANCE.createVariableExpression();
        ve.setVariable(p); // this should infer the variable expression's multiplicity to that of p
        mce.setObject(ve);

        assertEquals(1, ve.getType().getLowerMultiplicity());

        OCL ocl = com.sap.emf.ocl.util.OCL.newInstance();
        Object oldResult = ocl.evaluate(ctd, exp);
        Notification noti = NotificationHelper.createChangeLowerMultiplicityNotification(p.getOwnedTypeDefinition(), 0);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE
                .getClassTypeDefinition(), /* notifyOnNewContextElements */ false,
                new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        Object newResult = ocl.evaluate(ctd, exp);

        assertEquals(0, p.getOwnedTypeDefinition().getLowerMultiplicity());
        assertFalse("expected " + oldResult + " and " + newResult + " to be different but were equal", oldResult
                .equals(newResult));
        assertEquals(1, impact.size());
        assertTrue(impact.contains(ctd));

    }

    /**
     * self.ownerTypedElement.oclAsType(MethodCallExpression).methodSignature.output.lowerMultiplicity *
     * self.ownerTypedElement.oclAsType(MethodCallExpression).object.getType().lowerMultiplicity
     */
    @Test
    public void testLowerMultiplicityPropagationForMethodCall() {
        OCLExpression exp = (OCLExpression) parse(testLowerMultiplicityPropagationForMethodCall, this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        Resource r = this.cp.eResource();
        r.getContents().add(exp);
        // construct something like "abc".length(), then change multiplicity of "abc" from 1..1 to 0..1
        MethodSignature length = ClassesFactory.eINSTANCE.createMethodSignature();
        length.setName("length");
        SapClass numberClass = ClassesFactory.eINSTANCE.createSapClass();
        numberClass.setName("Number");
        ClassTypeDefinition msOutput = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        msOutput.setClazz(numberClass);
        msOutput.setLowerMultiplicity(1);
        msOutput.setUpperMultiplicity(1);
        length.setOutput(msOutput);
        ClassTypeDefinition ctd1 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctd1.setClazz(numberClass);
        ctd1.setLowerMultiplicity(1);
        ctd1.setUpperMultiplicity(1);
        MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
        mce.setOwnedTypeDefinition(ctd1);
        mce.setMethodSignature(length);
        StringLiteral sl = LiteralsFactory.eINSTANCE.createStringLiteral();
        sl.setLiteral("abc");
        SapClass stringClass = ClassesFactory.eINSTANCE.createSapClass();
        ClassTypeDefinition ctd2 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctd2.setClazz(stringClass);
        ctd2.setLowerMultiplicity(1);
        ctd2.setUpperMultiplicity(1);
        sl.setOwnedTypeDefinition(ctd2);
        mce.setObject(sl);

        r.getContents().add(mce);
        r.getContents().add(length);
        r.getContents().add(numberClass);
        r.getContents().add(stringClass);

        assertEquals(1, sl.getOwnedTypeDefinition().getLowerMultiplicity());

        Notification noti = NotificationHelper.createChangeLowerMultiplicityNotification(sl.getOwnedTypeDefinition(), 0);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE
                .getClassTypeDefinition(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);

        assertEquals(0, sl.getOwnedTypeDefinition().getLowerMultiplicity());
        assertEquals(1, impact.size());
        assertTrue(impact.contains(ctd1));

    }

    /**
     * data::classes::SapClass.allInstances()->select(c | c.name = 'something'
     */
    @Test
    public void testAnalysisOfRecursiveOperationWithSelf() {
        OCLExpression exp = (OCLExpression) parse(testAnalysisOfRecursiveOperationWithSelf, this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        Resource r = this.cp.eResource();

        r.eAdapters().add(new ECrossReferenceAdapter());
        r.getContents().add(exp);

        // construct something like "new HumbaClass1().m()"
        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Alice");
        MethodSignature ms = ClassesFactory.eINSTANCE.createMethodSignature();
        ms.setName("testMethod");
        cl1.getOwnedSignatures().add(ms);
        final ClassTypeDefinition ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctd.setLowerMultiplicity(1);
        ctd.setUpperMultiplicity(1);
        ctd.setClazz(null);
        final MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
        final ObjectCreationExpression oce = ExpressionsFactory.eINSTANCE.createObjectCreationExpression();
        oce.setClassToInstantiate(cl1);
        oce.setOwnedTypeDefinition(ctd);
        mce.setObject(oce);

        r.getContents().add(cl1);
        r.getContents().add(mce);

        Notification noti = NotificationHelper.createChangeClazzNotification(ctd, cl1);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ExpressionsPackage.eINSTANCE
                .getMethodCallExpression(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);

        assertEquals(1, impact.size());
        assertTrue(impact.contains(mce) && !impact.contains(ctd));

    }

    /**
     * data::classes::SapClass.allInstances()->select(c | c.name = 'something'
     */
    @Test
    public void testAllInstancesSelectClassName() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testAllInstancesSelectClassName, this.cp).iterator().next().getSpecification()
                .getBodyExpression();
        r.getContents().add(exp);
        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Alice");
        r.getContents().add(cl1);
        final ClassTypeDefinition ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctd.setClazz(cl1);
        r.getContents().add(ctd);

        EAttribute att = (EAttribute) cl1.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(cl1, att, "Alice", "Bob");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp,
                ClassesPackage.eINSTANCE.getClassTypeDefinition(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        // The expression has as its context ClassTypeDefinition. Therefore, the SapClass must not be returned
        // as impacted object. However, the change affects the ->select clause after allInstances(), so
        // all context objects of type ClassTypeDefinition are affected. That's what we want to assert now:
        assertTrue(impact.size() > 0 && impact.contains(ctd) && !impact.contains(cl1));
    }

    /**
     * data::classes::SapClass.allInstances()->select(c | c.name = 'something'
     */
    @Test
    public void testTriggeringAllInstancesByDirectResourceContainment() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testAllInstancesSelectClassName, this.cp).iterator().next().getSpecification()
                .getBodyExpression();
        r.getContents().add(exp);
        final ClassTypeDefinition ctd = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        r.getContents().add(ctd);
        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Bob");
        final Notification[] notifications = new Notification[1];
        Adapter a = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                if (n.getEventType() != Notification.REMOVING_ADAPTER) {
                    if (notifications[0] != null) {
                        fail("didn't expect to receive two notifications");
                    }
                    notifications[0] = n;
                }
            }
        };
        r.eAdapters().add(a);
        cl1.eAdapters().add(a);
        r.getContents().add(cl1);
        assertNotNull("Expected to receive one notification", notifications[0]);
        r.eAdapters().remove(a);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getClassTypeDefinition(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(notifications[0]);
        // The expression has as its context ClassTypeDefinition. Therefore, the SapClass must not be returned
        // as impacted object. However, the change affects the ->select clause after allInstances(), so
        // all context objects of type ClassTypeDefinition are affected. That's what we want to assert now:
        assertTrue(impact.size() > 0 && impact.contains(ctd) && !impact.contains(cl1));
    }

    @Test
    public void testVerySimpleTracerBasedInstanceScopeAnalysisWithNewClassScopeAnalysis() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testVerySimpleTracerBasedInstanceScopeAnalysisWithNewClassScopeAnalysis,
                this.cp).iterator().next().getSpecification().getBodyExpression();
        r.getContents().add(exp);

        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Alice");
        r.getContents().add(cl1);

        EAttribute att = (EAttribute) cl1.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(cl1, att, "Alice", "Bob");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);

        assertTrue(impact.size() == 1 && impact.contains(cl1));
    }

    @Test
    public void testInstanceScopeAnalysisForRecursiveOperation() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testInstanceScopeAnalysisForRecursiveOperation, this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        r.getContents().add(exp);

        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Alice");
        r.getContents().add(cl1);
        SapClass cl2 = ClassesFactory.eINSTANCE.createSapClass();
        ;
        cl2.setName("Bob");
        r.getContents().add(cl2);
        TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
        adapter.setName("Alice_to_Bob_Adapter");
        adapter.setAdapted(cl1);
        // the adapted reference already is a container
        // r.getContents().add(adapter);

        EReference ref1 = (EReference) adapter.eClass().getEStructuralFeature(ClassesPackage.TYPE_ADAPTER__TO);
        Notification noti1 = NotificationHelper.createReferenceChangeNotification(adapter, ref1, null, cl2);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact1 = ia.getContextObjects(noti1);

        assertTrue(impact1.size() == 1 && impact1.contains(cl1));
    }

    @Test
    public void testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf, this.cp).iterator()
                .next().getSpecification().getBodyExpression();
        r.getContents().add(exp);

        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Alice");
        r.getContents().add(cl1);

        EAttribute att = (EAttribute) cl1.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(cl1, att, "Alice", "Bob");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(cl1));
    }

    @Test
    public void testVerySimpleInstanceScopeAnalysisWithTuple() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testVerySimpleInstanceScopeAnalysisWithTuple, this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        r.getContents().add(exp);

        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setName("Alice");
        r.getContents().add(cl1);

        EAttribute att = (EAttribute) cl1.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(cl1, att, "Alice", "Bob");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);

        assertTrue(impact.size() == 1 && impact.contains(cl1));
    }

    @Test
    public void testGetFloorTokenNull() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse(testForIA2, this.cp).iterator().next().getSpecification().getBodyExpression();

        SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        r.getContents().add(cl1);
        cl1.setName("Alice");
        cl1.setValueType(true);

        ClassTypeDefinition ctd1 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        r.getContents().add(ctd1);
        ctd1.setClazz(cl1);
        ctd1.setLowerMultiplicity(1);
        ctd1.setUpperMultiplicity(1);
        ctd1.setOrdered(false);
        ctd1.setUnique(false);

        SapClass cl2 = ClassesFactory.eINSTANCE.createSapClass();
        r.getContents().add(cl2);
        cl2.setName("Bob");

        ClassTypeDefinition ctd2 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        r.getContents().add(ctd2);
        ctd2.setClazz(cl2);
        ctd2.setLowerMultiplicity(1);
        ctd2.setUpperMultiplicity(1);
        ctd2.setOrdered(false);
        ctd2.setUnique(false);

        ObjectLiteral ol1 = LiteralsFactory.eINSTANCE.createObjectLiteral();
        r.getContents().add(ol1);
        ol1.setValueClass(cl1);

        AssociationEnd ae1 = ClassesFactory.eINSTANCE.createAssociationEnd();
        r.getContents().add(ae1);
        ae1.setName("Assoc_to_Alice");
        ae1.setType(ctd1);

        AssociationEnd ae2 = ClassesFactory.eINSTANCE.createAssociationEnd();
        r.getContents().add(ae2);
        ae2.setName("Assoc_to_Bob");
        ae2.setType(ctd2);

        Association a = ClassesFactory.eINSTANCE.createAssociation();
        r.getContents().add(a);
        a.setName("Assoc");
        a.getEnds().add(ae1);
        a.getEnds().add(ae2);

        EAttribute att = (EAttribute) ae1.eClass().getEStructuralFeature(ClassesPackage.ASSOCIATION_END__NAME);
        Notification noti = NotificationHelper.createAttributeChangeNotification(ae2, att, "Assoc_to_Bob",
                "Assoc_to_Bob_changed");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE
                .createImpactAnalyzer(exp, LiteralsPackage.eINSTANCE.getObjectLiteral(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(ol1));
    }

    @Test
    public void testPredicateEvaluation() {
        OCLExpression exp = (OCLExpression) parse(
                "context data::classes::SapClass inv testPredicateEvaluation:\n"
                        + "self.ownedSignatures->select(s|s.sideEffectFree)->size() > 1", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(exp);
        SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
        c1.setName("c1");
        SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
        c2.setName("c2");
        SapClass c3 = ClassesFactory.eINSTANCE.createSapClass();
        c3.setName("c3");
        MethodSignature m1 = ClassesFactory.eINSTANCE.createMethodSignature();
        m1.setName("Signature 1");
        m1.setSideEffectFree(true);
        MethodSignature m2 = ClassesFactory.eINSTANCE.createMethodSignature();
        m2.setName("Signature 2");
        m2.setSideEffectFree(false);
        MethodSignature m3 = ClassesFactory.eINSTANCE.createMethodSignature();
        m3.setName("Signature 3");
        m3.setSideEffectFree(true);

        c1.getOwnedSignatures().add(m1);
        c2.getOwnedSignatures().add(m2);
        c3.getOwnedSignatures().add(m3);

        EAttribute att = (EAttribute) m3.eClass().getEStructuralFeature(ClassesPackage.METHOD_SIGNATURE__SIDE_EFFECT_FREE);
        Notification noti = NotificationHelper.createAttributeChangeNotification(m3, att, true, false);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertTrue(impact.size() == 1 && impact.contains(c3));

        noti = NotificationHelper.createAttributeChangeNotification(m3, att, false, true);
        impact = ia.getContextObjects(noti);
        assertTrue(impact.size() == 1 && impact.contains(c3));

        noti = NotificationHelper.createAttributeChangeNotification(m3, att, false, false);
        impact = ia.getContextObjects(noti);
        assertTrue(impact.size() == 0);

        noti = NotificationHelper.createAttributeChangeNotification(m3, att, true, true);
        impact = ia.getContextObjects(noti);
        assertTrue(impact.size() == 0);
    }

    @Test
    public void testDeltaPropagationForAllInstances() {
        OCLExpression exp = (OCLExpression) parse(
                "context data::classes::SapClass inv testDeltaPropagationForAllInstances:\n"
                        + "data::classes::SapClass.allInstances()->select(name='Humba')->size() = 0", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(exp);
        SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
        c1.setName("Trala");
        SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
        c2.setName("Humba");
        modelmanagement.Package pkg = ModelmanagementFactory.eINSTANCE.createPackage();
        pkg.setName("Pkg");
        this.cp.eResource().getContents().add(pkg);
        Notification noti = NotificationHelper.createReferenceAddNotification(pkg, ModelmanagementPackage.eINSTANCE
                .getPackage_Classes(), c1);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(0, impact.size());

        noti = NotificationHelper.createReferenceAddNotification(pkg, ModelmanagementPackage.eINSTANCE.getPackage_Classes(), c2);
        impact = ia.getContextObjects(noti);
        assertTrue(impact.size() >= 2); // we don't know the exact size because of all the other test elements created for fixture
        assertTrue(impact.contains(c1) && impact.contains(c2));
    }

    @Test
    public void testSimpleUnusedCheckWithIfConditionAlwaysFalse() {
        Resource r = this.cp.eResource();
        OCLExpression exp = (OCLExpression) parse("context data::classes::SapClass inv testSimpleUnusedCheckWithIfClause:\n"+
                "if false then self.valueType else true endif", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        r.getContents().add(exp);

        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setValueType(false);
        r.getContents().add(cl1);

        EAttribute att = (EAttribute) cl1.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__VALUE_TYPE);
        Notification noti = NotificationHelper.createAttributeChangeNotification(cl1, att, false, true);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);

        if (OptimizationActivation.getOption().isTracebackStepISAActive() && OptimizationActivation.getOption().isUnusedDetectionActive()) {
            // expecting no impact because the then clause affected by the change is unused
            assertEquals(0, impact.size());
        } else {
            assertEquals(1, impact.size());
            assertEquals(cl1, impact.iterator().next());
        }
    }

    @Test
    public void testSimpleUnusedCheckWithIteratorSourceAlwaysEmpty() {
        Resource r = this.cp.eResource();
        // the idea: while self.valueType changes for cl1, self.adapters is always empty for the changed object
        OCLExpression exp = (OCLExpression) parse("context data::classes::SapClass inv testSimpleUnusedCheckWithIfClause:\n"+
                "self.adapters->select(a | a.to.valueType = self.valueType)", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        r.getContents().add(exp);

        final SapClass cl1 = ClassesFactory.eINSTANCE.createSapClass();
        cl1.setValueType(false);
        r.getContents().add(cl1);

        EAttribute att = (EAttribute) cl1.eClass().getEStructuralFeature(ClassesPackage.SAP_CLASS__VALUE_TYPE);
        Notification noti = NotificationHelper.createAttributeChangeNotification(cl1, att, false, true);
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass(), /* notifyOnNewContextElements */ false, new OCLFactoryImpl());
        Collection<EObject> impact = ia.getContextObjects(noti);

        if (OptimizationActivation.getOption().isUnusedDetectionActive()) {
            // expecting no impact because the then clause affected by the change is unused
            assertEquals(0, impact.size());
        } else {
            assertEquals(1, impact.size());
            assertEquals(cl1, impact.iterator().next());
        }
    }

}
