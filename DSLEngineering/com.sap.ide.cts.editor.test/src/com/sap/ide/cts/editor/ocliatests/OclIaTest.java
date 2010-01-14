package com.sap.ide.cts.editor.ocliatests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import ngpm.NgpmPackage;

import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.expressions.OclExpression;

import tcs.ConcreteSyntax;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.ide.cts.editor.test.util.StandaloneConnectionBasedTest;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.tc.moin.ocl.ia.analysis.ClassScopeAnalysis;
import com.sap.tc.moin.ocl.ia.cache.EventCache;
import com.sap.tc.moin.ocl.ia.events.InternalEventFactory;
import com.sap.tc.moin.ocl.ia.expressions.SubExpression;
import com.sap.tc.moin.ocl.ia.instancescope.InstanceScopeAnalysis;
import com.sap.tc.moin.ocl.ia.relevance.Relevance;
import com.sap.tc.moin.ocl.ia.tag.NodeTagFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.OclExpressionRegistrationWrapper;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclExpressionRegistrationImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclRegistrationImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.SapClass;
import data.classes.TypeAdapter;
import dataaccess.expressions.literals.ObjectLiteral;

public class OclIaTest extends StandaloneConnectionBasedTest {

    private JmiCreator myJmiCreator;
    private NodeTagFactory tagFactory;
    private EventCache cache;
    private InternalEventFactory eventFactory;

    @Before
    public void initParsingHandlerAndSetupInstanceScopeAnalysis() throws OclManagerException {
	// create tcs Syntax
	ConcreteSyntax tcsSyntax = TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
	assertNotNull(tcsSyntax);
	CoreModelPartition tp = ((ConnectionWrapper) connection).getCoreConnection()
		.getOrCreateTransientPartitionNonTransactional("OclIaTestTransientPartition");
	myJmiCreator = new JmiCreator(((ConnectionWrapper) connection).getCoreConnection(), true, tp);
	this.tagFactory = new NodeTagFactory();
	this.cache = new EventCache();
	this.eventFactory = new InternalEventFactory();
    }
    
    private OclExpressionRegistration createOclExpression(String registrationName, String oclExpression, ClassDescriptor<?, ?> forClass) throws OclManagerException {
	OclRegistryService oclRegistry = connection.getOclRegistryService();
	final OclExpressionRegistration registration = oclRegistry.getFreestyleRegistry().createExpressionRegistration(
		registrationName,
		oclExpression, OclRegistrationSeverity.Info, new String[] { "TestOclIA" },
		connection.getClass(forClass),
		new RefPackage[] { connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR) });
	return registration;
    }
    
    @Test
    public void testInstanceScopeAnalysisForRecursiveOperation() throws OclManagerException, NoSuchFieldException,
	    IllegalAccessException {
	OclExpressionRegistration registration = createOclExpression("testInstanceScopeAnalysisForRecursiveOperation",
		"self.adapters->forAll(a | self.conformsTo(a.to))",
		SapClass.CLASS_DESCRIPTOR);
	final OclExpression expression = getOclExpression(registration);
	final InstanceScopeAnalysis isa = new InstanceScopeAnalysis(((ConnectionWrapper) connection).unwrap());

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	SapClass cl2 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl2.setName("HumbaClass2");
	TypeAdapter adapter = connection.createElement(TypeAdapter.CLASS_DESCRIPTOR);
	adapter.setName("HumbaClass1_to_HumbaClass2_Adapter");
	EventFilter eventFilter = registration.getEventFilter();
	final boolean[] ok = new boolean[1];
	connection.getEventRegistry().registerListener(new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		int size = expression.get___Partition().getElements().size();
		System.out.println("Extent partition contains "+size+" elements");
		Set<RefObjectImpl> affectedElements = isa.getAffectedExpressionsForElements(expression, (ModelChangeEvent) event);
		ok[0] = affectedElements.size() == 1 && affectedElements.iterator().next().refMofId().equals(cl1.refMofId());
	    }
	}, eventFilter);
	adapter.setAdapted(cl1);
	adapter.setTo(cl2);
	assertTrue(ok[0]);
    }

    @Test
    public void testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf() throws OclManagerException, NoSuchFieldException,
	    IllegalAccessException {
	OclExpressionRegistration registration = createOclExpression("testVerySimpleInstanceScopeAnalysisWithTupleUsingSelf",
		"Tuple{cls=self}.cls.name",
		SapClass.CLASS_DESCRIPTOR);
	final OclExpression expression = getOclExpression(registration);
	final InstanceScopeAnalysis isa = new InstanceScopeAnalysis(((ConnectionWrapper) connection).unwrap());

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter();
	final boolean[] ok = new boolean[1];
	connection.getEventRegistry().registerListener(new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<RefObjectImpl> affectedElements = isa.getAffectedExpressionsForElements(expression, (ModelChangeEvent) event);
		ok[0] = affectedElements.size() == 1 && affectedElements.iterator().next().refMofId().equals(cl1.refMofId());
	    }
	}, eventFilter);
	cl1.setName("ChangedHumba1");
	assertTrue(ok[0]);
    }

    @Test
    public void testVerySimpleInstanceScopeAnalysisWithTuple() throws OclManagerException, NoSuchFieldException,
	    IllegalAccessException {
	OclExpressionRegistration registration = createOclExpression("testVerySimpleInstanceScopeAnalysisWithTuple",
		"Tuple{name=self.name}.name",
		SapClass.CLASS_DESCRIPTOR);
	final OclExpression expression = getOclExpression(registration);
	final InstanceScopeAnalysis isa = new InstanceScopeAnalysis(((ConnectionWrapper) connection).unwrap());

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter();
	final boolean[] ok = new boolean[1];
	connection.getEventRegistry().registerListener(new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<RefObjectImpl> affectedElements = isa.getAffectedExpressionsForElements(expression, (ModelChangeEvent) event);
		ok[0] = affectedElements.size() == 1 && affectedElements.iterator().next().refMofId().equals(cl1.refMofId());
	    }
	}, eventFilter);
	cl1.setName("ChangedHumba1");
	assertTrue(ok[0]);
    }

    @Test
    public void testVerySimpleTracerBasedInstanceScopeAnalysis() throws OclManagerException, NoSuchFieldException,
	    IllegalAccessException {
	OclExpressionRegistration registration = createOclExpression("testVerySimpleTracerBasedInstanceScopeAnalysis",
		"self.oclAsType(data::classes::SapClass).name",
		SapClass.CLASS_DESCRIPTOR);
	final OclExpression expression = getOclExpression(registration);
	final InstanceScopeAnalysis isa = new InstanceScopeAnalysis(((ConnectionWrapper) connection).unwrap());

	final SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	cl1.setName("HumbaClass1");
	EventFilter eventFilter = registration.getEventFilter();
	final boolean[] ok = new boolean[1];
	connection.getEventRegistry().registerListener(new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<RefObjectImpl> affectedElements = isa.getAffectedExpressionsForElements(expression, (ModelChangeEvent) event);
		ok[0] = affectedElements.size() == 1 && affectedElements.iterator().next().refMofId().equals(cl1.refMofId());
	    }
	}, eventFilter);
	cl1.setName("ChangedHumba1");
	assertTrue(ok[0]);
    }

    private OclExpression getOclExpression(OclExpressionRegistration registration) throws NoSuchFieldException,
	    IllegalAccessException {
	OclStatement stmt = getOclStatement(registration);
	OclExpression expression = stmt.getExpression();
	return expression;
    }
    
    @Test
    public void testReversePathAnalysis() throws OclManagerException, SecurityException, NoSuchFieldException,
	    IllegalArgumentException, IllegalAccessException {
	OclExpressionRegistration registration = createOclExpression("testForIA", "self.oclAsType(dataaccess::expressions::literals::ObjectLiteral).valueClass.getAssociationEnds().otherEnd()->select(ae|ae.name='Humba')", ObjectLiteral.CLASS_DESCRIPTOR);
	OclStatement stmt = getOclStatement(registration);
	Set<OclExpression> singleExpression = new HashSet<OclExpression>();
	singleExpression.add(stmt.getExpression());
	ClassScopeAnalysis csa = new ClassScopeAnalysis(((ConnectionWrapper) connection).getCoreConnection(),
		eventFactory, tagFactory, new HashSet<OclExpression>());
	com.sap.tc.moin.ocl.ia.analysis.InstanceScopeAnalysis isa = new com.sap.tc.moin.ocl.ia.analysis.InstanceScopeAnalysis(tagFactory, cache, myJmiCreator);
        // start the algorithm and get the relevant events
        csa.analyze(stmt.getExpression());
	isa.analyze(stmt, myJmiCreator);
	Set<Relevance> relevances = isa.testingGetRelevances();
	Set<SubExpression> subExprs = isa.testingGetSubExpressions();
	assertEquals("Expected to find 12 relevances", 12, relevances.size());
	assertEquals("Expected to find 2 sub-expressions", 2, subExprs.size());
    }

    private OclStatement getOclStatement(OclExpressionRegistration registration) throws NoSuchFieldException,
	    IllegalAccessException {
	OclExpressionRegistrationImpl registrationImpl = (OclExpressionRegistrationImpl) ((OclExpressionRegistrationWrapper) registration)
		.unwrap();
	OclStatement stmt;
	Field statement = OclRegistrationImpl.class.getDeclaredField("statement");
	statement.setAccessible(true);
	stmt = (OclStatement) statement.get(registrationImpl);
	return stmt;
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
	EventFilter eventFilter = registration.getEventFilter();
	connection.getEventRegistry().registerListener(new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		Set<RefBaseObject> elements = new HashSet<RefBaseObject>();
		for (MRI affectedElementMri : affectedElements) {
		    elements.add(connection.getElement(affectedElementMri));
		}
		System.out.println("Elements: " + elements);
	    }
	}, eventFilter);
	ae1.setName("ChangedHumba1");
    }


}
