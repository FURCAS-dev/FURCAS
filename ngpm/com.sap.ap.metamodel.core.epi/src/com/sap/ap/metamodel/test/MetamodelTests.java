package com.sap.ap.metamodel.test;

import java.util.Collection;

import junit.framework.TestCase;
import modelmanagement.Package;
import behavioral.BehavioralPackage;
import behavioral.actions.Block;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.ConstraintViolationException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.DataPackage;
import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassesPackage;
import data.classes.LinkSetting;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeAdapter;

public class MetamodelTests extends TestCase {
    private Moin moin;
    private Connection conn;

    public void setUp() {
	moin = MoinFactory.getMoinInstance();
	conn = createConnection();
    }
    
    public void tearDown() {
	createConnection().close();
    }
    
    public void testMetamodelAvailability() {
	MofClass typeAdapter = getClassesPackage().getTypeAdapter().refMetaObject();
	assertEquals("TypeAdapter", typeAdapter.getName());
    }

    public void testLinkRemoveEventUponElementDelete() {
	final boolean[] ok = new boolean[1];
	
	final SapClass clazz = (SapClass) conn.getClass(SapClass.CLASS_DESCRIPTOR).refCreateInstance();
	final TypeAdapter ta = (TypeAdapter) conn.getClass(TypeAdapter.CLASS_DESCRIPTOR).refCreateInstance();
	conn.getSession().getEventRegistry().registerPreChangeListener(
		new PreChangeListener() {
		    @Override
		    public void prepare(ChangeEvent event) {
			if (event instanceof LinkRemoveEvent) {
			    LinkRemoveEvent e = (LinkRemoveEvent) event;
			    ok[0] = ok[0] || e.getFirstLinkEnd(conn).equals(clazz) &&
			    	             e.getSecondLinkEnd(conn).equals(ta);
			}
		    }
		}, new AssociationFilter(
			getClassesPackage().getAdaptedTo().refMetaObject()));
	ta.setTo(clazz);
	ta.refDelete();
	// If this test fails, check if in the target IDE there is an editor or the Runlet console open;
	// this may turn off events during creating a deep copy / snapshot of the object under edit
	// which temporarily disables the event handling required / tested here
	assertTrue(ok[0]);
    }

    /**
     * Asserts that two types don't just conform based on their signature structures
     */
    public void testNoStructuralConformance() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	assertFalse("Two classes that don't have an adapter between them must not conform",
		c1.conformsTo(c2));
    }

    /**
     * Asserts that two types conform if there is one adapter between them
     */
    public void testConformanceWithOneAdapter() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	TypeAdapter adapter = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c2));
    }
    
    /**
     * Asserts that two types conform if there is one adapter between them
     */
    public void testConformanceWithSignaturesAndOneAdapter() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	MethodSignature s1 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s1.setName("someSignature");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	MethodSignature s2 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s2.setName("someSignature");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	Collection<JmiException> exceptions = adapter.refVerifyConstraints(/*deepVerify*/false);
	assertTrue("Adapter should be valid but has "+
		((exceptions==null)?0:exceptions.size())+" violated constraints",
		exceptions == null || exceptions.size() == 0);
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c2));
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testAdapterInvariantsEnforcement() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	MethodSignature s1 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	MethodSignature s2 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	Collection<JmiException> exceptions = adapter.refVerifyConstraints(/*deepVerify*/false);
	assertTrue("Adapter should be considered invalid and should violate the IsFullAdaptationToTo constraint",
		exceptions.size() == 1 && ((ConstraintViolationException) exceptions.iterator().next()).getMessage().equals(
			"[data, classes, TypeAdapter, IsFullAdaptationToTo]"));
    }
    
    /**
     * Check that the constraint works that requires an association between two value classes to
     * have at least one non-equality-relevant end
     */
    public void testDoubleEqualityRelevantValueClassAssociation() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	c1.setValueType(true);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	c2.setValueType(true);
	Association a = MetamodelUtils.createAssociation(conn, c1, "c1", 0, 1, true, false, false, false, c2, "c2", 0, 1, true, false, false, false);
	a.setName("a");
	modelmanagement.Package p = (Package) conn.getClass(modelmanagement.Package.CLASS_DESCRIPTOR).refCreateInstance();
	p.setName("p");
	c1.setPackage(p);
	c2.setPackage(p);
	a.setPackage(p);
	for (AssociationEnd ae:a.getEnds()) {
	    ae.setContributesToEquality(true);
	}
	Collection<JmiException> exceptions = a.refVerifyConstraints(/*deepVerify*/false);
	assertEquals("Expected exactly one constraint violation", 1, exceptions.size());
	assertEquals("Associations between two value types that affect equality of both types are currently not supported. It would lead to a recursive equality definition and therefore to recursive value constructors.",
		((ConstraintViolationException) exceptions.iterator().next()).getMessage());
    }
    
    /**
     * Check that no modifying feature of an association end can be exposed if that
     * would modify a value
     */
    public void testValueImmutability() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1Value");
	c1.setValueType(true);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2Entity");
	c2.setValueType(false);
	Association a = MetamodelUtils.createAssociation(conn, c1, "c1", 0, 1, true, false, false, false, c2, "c2", 0, 1, true, false, false, false);
	a.setName("a");
	modelmanagement.Package p = (Package) conn.getClass(modelmanagement.Package.CLASS_DESCRIPTOR).refCreateInstance();
	p.setName("p");
	c1.setPackage(p);
	c2.setPackage(p);
	a.setPackage(p);
	assertEquals("c1", a.getEnds().get(0).getName());
	a.getEnds().get(0).setContributesToEquality(true);
	
	// expose eqality-relevant association as getter (required!)
	MethodSignature getter = (MethodSignature) conn.getClass(MethodSignature.CLASS_DESCRIPTOR).refCreateInstance();
	getter.setName("getC2");
	getter.setOutput(a.getEnds().get(1).getType());
	LinkTraversal linkTraversal = (LinkTraversal) conn.getClass(LinkTraversal.CLASS_DESCRIPTOR).refCreateInstance();
	linkTraversal.setEnd(a.getEnds().get(1));
	getter.setImplementation(linkTraversal);
	c1.getOwnedSignatures().add(getter);
	
	Collection<JmiException> exceptions = a.refVerifyConstraints(/*deepVerify*/true);
	assertNull(exceptions);
	Collection<JmiException> exceptions2 = c1.refVerifyConstraints(/*deepVerify*/true);
	assertNull(exceptions2);
	Collection<JmiException> exceptions3 = c2.refVerifyConstraints(/*deepVerify*/true);
	assertNull(exceptions3);
	
	// expose equality-relevant association as setter (illegal!)
	MethodSignature setter = (MethodSignature) conn.getClass(MethodSignature.CLASS_DESCRIPTOR).refCreateInstance();
	setter.setName("setC2");
	LinkSetting linkSetting = (LinkSetting) conn.getClass(LinkSetting.CLASS_DESCRIPTOR).refCreateInstance();
	linkSetting.setEnd(a.getEnds().get(1));
	setter.setImplementation(linkSetting);
	Parameter setterParam = (Parameter) conn.getClass(Parameter.CLASS_DESCRIPTOR).refCreateInstance();
	setterParam.setName("c2Param");
	setter.getInput().add(setterParam);
	c1.getOwnedSignatures().add(setter);
	
	Collection<JmiException> exceptions4 = c1.refVerifyConstraints(/*deepVerify*/true);
	assertEquals("Expected exactly one constraint violation", 1, exceptions4.size());
	assertEquals("[data, classes, ExtentModifyingAssociationEndSignatureImplementation, MustNotModifyExtentIfEqualityRelevantForValueClass]",
		((ConstraintViolationException) exceptions4.iterator().next()).getMessage());
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testEnforcementNoAbstractSignaturesInAdapter() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	MethodSignature s1 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	MethodSignature s2 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	MethodSignature adapterSig = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	adapterSig.setName("s2");
	adapter.getOwnedSignatures().add(adapterSig);
	Collection<JmiException> exceptions = adapter.refVerifyConstraints(/*deepVerify*/false);
	assertTrue("Adapter should be considered invalid and should violate the SignatureCannotBeAbstract constraint",
		exceptions.size() == 1 && ((ConstraintViolationException) exceptions.iterator().next()).getMessage().equals(
			"Signatures can not be abstract"));
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testConformanceWithoutSignatureAdaptation() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	MethodSignature s1 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	MethodSignature s2 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	MethodSignature adapterSig = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	adapterSig.setName("s2");
	Block impl = (Block) ((BehavioralPackage) conn.getPackage(/*containerName*/ null, "behavioral")).getActions().
			getBlock().refCreateInstance();
	adapterSig.setImplementation(impl);
	adapter.getOwnedSignatures().add(adapterSig);
	Collection<JmiException> exceptions = adapter.refVerifyConstraints(/*deepVerify*/false);
	assertTrue("Adapter should be valid but has "+
		((exceptions==null)?0:exceptions.size())+" violated constraints",
		exceptions == null || exceptions.size() == 0);
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c2));
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testConformanceAlongAdapterChain() {
	ClassesPackage classesPackage = getClassesPackage();
	SapClass c1 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c1.setName("C1");
	MethodSignature s1 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C2");
	MethodSignature s2 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	MethodSignature adapterSig = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	adapterSig.setName("s2");
	Block impl = (Block) ((BehavioralPackage) conn.getPackage(/*containerName*/ null, "behavioral")).getActions().
			getBlock().refCreateInstance();
	adapterSig.setImplementation(impl);
	adapter.getOwnedSignatures().add(adapterSig);
	SapClass c3 = (SapClass) classesPackage.getSapClass().refCreateInstance();
	c2.setName("C3");
	MethodSignature s3 = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	s2.setName("s3");
	c3.getOwnedSignatures().add(s3);
	TypeAdapter adapter2 = (TypeAdapter) classesPackage.getTypeAdapter().refCreateInstance();
	adapter2.setName("FromC2ToC3");
	adapter2.setAdapted(c2);
	adapter2.setTo(c3);
	MethodSignature adapter2Sig = (MethodSignature) classesPackage.getMethodSignature().refCreateInstance();
	adapterSig.setName("s3");
	Block impl2 = (Block) ((BehavioralPackage) conn.getPackage(/*containerName*/ null, "behavioral")).getActions().
			getBlock().refCreateInstance();
	adapter2Sig.setImplementation(impl2);
	adapter2.getOwnedSignatures().add(adapter2Sig);
	Collection<JmiException> exceptions = adapter.refVerifyConstraints(/*deepVerify*/false);
	assertTrue("Adapter should be valid but has "+
		((exceptions==null)?0:exceptions.size())+" violated constraints",
		exceptions == null || exceptions.size() == 0);
	Collection<JmiException> exceptions2 = adapter2.refVerifyConstraints(/*deepVerify*/false);
	assertTrue("Adapter should be valid but has "+
		((exceptions2==null)?0:exceptions2.size())+" violated constraints",
		exceptions2 == null || exceptions2.size() == 0);
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c3));
    }
    
    /**
     * Obtains a connection that is good only for reading from this facility and
     * in particular from all metamodels. It is obtained by setting up a new session
     * with a compound client spec containing only one client spec for a "transient"
     * data area for this facility and then obtaining a connection to that session.
     */
    private Connection createConnection() {
	return getMoin().createSession(getMoin().getCompoundDataAreaManager().
		getCompoundClientSpecTransientOnly()).createConnection();
    }

    private Moin getMoin() {
	return moin;
    }

    private ClassesPackage getClassesPackage() {
	return conn.getPackage(DataPackage.PACKAGE_DESCRIPTOR).getClasses();
    }
    
}
