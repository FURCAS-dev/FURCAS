package com.sap.ide.cts.editor.ocliatests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import ngpm.NgpmPackage;

import org.junit.Before;
import org.junit.Test;

import tcs.ConcreteSyntax;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.ide.cts.editor.test.util.StandaloneConnectionBasedTest;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.TypeAdapter;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.literals.ObjectLiteral;
import dataaccess.expressions.literals.StringLiteral;

public class OclIaTest extends StandaloneConnectionBasedTest {

    @Before
    public void initParsingHandlerAndSetupInstanceScopeAnalysis() {
	// create tcs Syntax
	ConcreteSyntax tcsSyntax = TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
	assertNotNull(tcsSyntax);
    }
    
    /**
     * self.ownerTypedElement.oclAsType(MethodCallExpression).methodSignature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(MethodCallExpression).object.getType().lowerMultiplicity
     */
    @Test
    public void testLowerMultiplicityPropagationForMethodCall() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testLowerMultiplicityPropagationForMethodCall",
		"self.ownerTypedElement.oclAsType(MethodCallExpression).methodSignature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(MethodCallExpression).object.getType().lowerMultiplicity", ClassTypeDefinition.CLASS_DESCRIPTOR);
	// construct something like "abc".length(), then change multiplicity of "abc" from 1..1 to 0..1
	MethodSignature length = connection.createElement(MethodSignature.CLASS_DESCRIPTOR);
	length.setName("length");
	SapClass numberClass = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	numberClass.setName("Number");
	ClassTypeDefinition msOutput = MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, numberClass);
	length.setOutput(msOutput);
	final ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinition(connection, numberClass, 1, 1);
	final MethodCallExpression mce = connection.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	mce.setOwnedTypeDefinition(ctd);
	mce.setMethodSignature(length);
	StringLiteral sl = connection.createElement(StringLiteral.CLASS_DESCRIPTOR);
	sl.setLiteral("abc");
	SapClass stringClass = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	sl.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, stringClass));
	mce.setObject(sl);
	EventFilter eventFilter = registration.getEventFilter(/* notifyNewContextElement */ false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1 && affectedElements.contains(ctd.get___Mri());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    sl.getOwnedTypeDefinition().setLowerMultiplicity(0);
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    /**
     * data::classes::SapClass.allInstances()->select(c | c.name = 'something'
     */
    @Test
    public void testAnalysisOfRecursiveOperationWithSelf() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testAnalysisOfRecursiveOperationWithSelf",
		"self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = '__TEXT___')", MethodCallExpression.CLASS_DESCRIPTOR);

	// construct something like "new HumbaClass1().m()"
	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	final ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinition(connection, cl1, 1, 1);
	ctd.setClazz(null); // do that again later to cause the appropriate event
	final MethodCallExpression mce = connection.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	final ObjectCreationExpression oce = connection.createElement(ObjectCreationExpression.CLASS_DESCRIPTOR);
	oce.setClassToInstantiate(cl1);
	oce.setOwnedTypeDefinition(ctd);
	mce.setObject(oce);
	EventFilter eventFilter = registration.getEventFilter(/* notifyNewContextElement */ false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1 && affectedElements.contains(mce.get___Mri()) &&
			!affectedElements.contains(ctd.get___Mri());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    ctd.setClazz(cl1);
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    /**
     * data::classes::SapClass.allInstances()->select(c | c.name = 'something'
     */
    @Test
    public void testAllInstancesSelectClassName() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testAllInstancesSelectClassName",
		"data::classes::SapClass.allInstances()->select(c | c.name = 'HumbaClass2')", ClassTypeDefinition.CLASS_DESCRIPTOR);

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	final ClassTypeDefinition ctd = connection.createElement(ClassTypeDefinition.CLASS_DESCRIPTOR);
	EventFilter eventFilter = registration.getEventFilter(/* notifyNewContextElement */ false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() > 0 && affectedElements.contains(ctd.get___Mri()) &&
			!affectedElements.contains(cl1.get___Mri());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    cl1.setName("HumbaClass2");
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    @Test
    public void testVerySimpleTracerBasedInstanceScopeAnalysisWithNewClassScopeAnalysis() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(
		connection,
		"testVerySimpleTracerBasedInstanceScopeAnalysisWithNewClassScopeAnalysis",
		"self.oclAsType(data::classes::SapClass).name", SapClass.CLASS_DESCRIPTOR);

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter(false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1
			&& affectedElements.iterator().next().getMofId().equals(cl1.refMofId());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    cl1.setName("ChangedHumba1");
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    @Test
    public void testInstanceScopeAnalysisForRecursiveOperation() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testInstanceScopeAnalysisForRecursiveOperation",
		"self.adapters->forAll(a | self.conformsTo(a.to))", SapClass.CLASS_DESCRIPTOR);
	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	SapClass cl2 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl2.setName("HumbaClass2");
	TypeAdapter adapter = connection.createElement(TypeAdapter.CLASS_DESCRIPTOR);
	adapter.setName("HumbaClass1_to_HumbaClass2_Adapter");
	EventFilter eventFilter = registration.getEventFilter(false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1 && affectedElements.iterator().next().getMofId().equals(cl1.refMofId());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    adapter.setAdapted(cl1);
	    adapter.setTo(cl2);
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    @Test
    public void testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf",
		"Tuple{cls=self}.cls.name", SapClass.CLASS_DESCRIPTOR);

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter(false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1
			&& affectedElements.iterator().next().getMofId().equals(cl1.refMofId());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    cl1.setName("ChangedHumba1");
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    @Test
    public void testVerySimpleInstanceScopeAnalysisWithTuple() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testVerySimpleInstanceScopeAnalysisWithTuple",
		"Tuple{name=self.name}.name", SapClass.CLASS_DESCRIPTOR);

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter(false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1
			&& affectedElements.iterator().next().getMofId().equals(cl1.refMofId());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    cl1.setName("ChangedHumba1");
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    @Test
    public void testVerySimpleTracerBasedInstanceScopeAnalysis() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testVerySimpleTracerBasedInstanceScopeAnalysis",
		"self.oclAsType(data::classes::SapClass).name", SapClass.CLASS_DESCRIPTOR);

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter(false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		ok[0] = affectedElements.size() == 1
			&& affectedElements.iterator().next().getMofId().equals(cl1.refMofId());
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    cl1.setName("ChangedHumba1");
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }

    @Test
    public void testGetFloorTokenNull() throws OclManagerException {
	ObjectLiteral ol = connection.createElement(ObjectLiteral.CLASS_DESCRIPTOR);
	SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	cl1.setValueType(true);
	ol.setValueClass(cl1);
	Association a = connection.createElement(Association.CLASS_DESCRIPTOR);
	a.setName("Assoc");
	AssociationEnd ae1 = connection.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	ae1.setName("Humba1");
	ae1.setType(MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, cl1));
	a.getEnds().add(ae1);
	AssociationEnd ae2 = connection.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	ae2.setName("Humba2");
	SapClass cl2 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl2.setName("HumbaClass2");
	ae2.setType(MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, cl2));
	a.getEnds().add(ae2);
	OclRegistryService oclRegistry = connection.getOclRegistryService();
	final OclExpressionRegistration registration = oclRegistry.getFreestyleRegistry().createExpressionRegistration(
		"testForIA2",
		"self.oclAsType(dataaccess::expressions::literals::ObjectLiteral).valueClass.getAssociationEnds().otherEnd()"
			+ "->select(ae|ae.name='Humba')", OclRegistrationSeverity.Info, new String[] { "TestOclIA" },
		connection.getClass(ObjectLiteral.CLASS_DESCRIPTOR),
		new RefPackage[] { connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR) });
	EventFilter eventFilter = registration.getEventFilter(/* notifyNewContextElement */ true);
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		Set<RefBaseObject> elements = new HashSet<RefBaseObject>();
		for (MRI affectedElementMri : affectedElements) {
		    elements.add(connection.getElement(affectedElementMri));
		}
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	try {
	    ae1.setName("ChangedHumba1");
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }
}
