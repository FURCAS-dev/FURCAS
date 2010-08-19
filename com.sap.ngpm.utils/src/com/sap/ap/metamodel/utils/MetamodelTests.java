package com.sap.ap.metamodel.utils;

import java.util.HashMap;

import junit.framework.TestCase;
import modelmanagement.ModelmanagementFactory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import behavioral.actions.ActionsFactory;
import behavioral.actions.Block;
import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.LinkSetting;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeAdapter;
import data.classes.util.ClassesValidator;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AssociationFilter;

public class MetamodelTests extends TestCase {
    private ResourceSet resourceSet;
    private Resource resource;

    public void setUp() {
	resourceSet = new ResourceSetImpl();
	resource = resourceSet.createResource(URI.createURI("http://some_uri.xmi"));
	resourceSet.getResources().add(resource);
    }
    
    public void tearDown() {
    }
    
    public void testMetamodelAvailability() {
	EClass typeAdapter = ClassesPackage.eINSTANCE.getTypeAdapter();
	assertEquals("TypeAdapter", typeAdapter.getName());
    }

    public void testLinkRemoveEventUponElementDelete() {
	final boolean[] ok = new boolean[1];
	
	final SapClass clazz = ClassesFactory.eINSTANCE.createSapClass();
	final TypeAdapter ta = ClassesFactory.eINSTANCE.createTypeAdapter();
	resource.getContents().add(clazz);
	resource.getContents().add(ta);
	EventManager em = EventManagerFactory.eINSTANCE.getEventManagerFor(resourceSet);
	AssociationFilter filter = EventManagerFactory.eINSTANCE.createAssociationFilter(ClassesPackage.eINSTANCE.getTypeAdapter_To());
	em.subscribe(filter, new AdapterImpl() {
	    public void notifyChanged(Notification event) {
			if (event.getEventType() == Notification.SET && event.getNewValue() == null) {
			    ok[0] = ok[0] || event.getNotifier().equals(ta) &&
			    	             event.getOldValue().equals(clazz);
			}
		    }
	});
	ta.setTo(clazz);
	ta.setTo(null);
	// If this test fails, check if in the target IDE there is an editor or the Runlet console open;
	// this may turn off events during creating a deep copy / snapshot of the object under edit
	// which temporarily disables the event handling required / tested here
	assertTrue(ok[0]);
    }

    /**
     * Asserts that two types don't just conform based on their signature structures
     */
    public void testNoStructuralConformance() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();;
	c1.setName("C1");
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	assertFalse("Two classes that don't have an adapter between them must not conform",
		c1.conformsTo(c2));
    }

    /**
     * Asserts that two types conform if there is one adapter between them
     */
    public void testConformanceWithOneAdapter() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c2));
    }
    
    /**
     * Asserts that two types conform if there is one adapter between them
     */
    public void testConformanceWithSignaturesAndOneAdapter() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	MethodSignature s1 = ClassesFactory.eINSTANCE.createMethodSignature();
	s1.setName("someSignature");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	MethodSignature s2 = ClassesFactory.eINSTANCE.createMethodSignature();
	s2.setName("someSignature");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	BasicDiagnostic diagnostics = new BasicDiagnostic();
	ClassesValidator.INSTANCE.validate(adapter, diagnostics, new HashMap<Object, Object>());
	assertTrue("Adapter should be valid", diagnostics.getSeverity() == Diagnostic.OK);
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c2));
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testAdapterInvariantsEnforcement() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	MethodSignature s1 = ClassesFactory.eINSTANCE.createMethodSignature();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	MethodSignature s2 = ClassesFactory.eINSTANCE.createMethodSignature();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
        BasicDiagnostic diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(adapter, diagnostics, new HashMap<Object, Object>());
	assertTrue("Adapter should be considered invalid and should violate the IsFullAdaptationToTo constraint",
		diagnostics.getSeverity() != Diagnostic.OK &&
		diagnostics.getChildren().iterator().next().getMessage().startsWith(
		        "The 'IsFullAdaptationToTo' constraint is violated")
		);
    }
    
    /**
     * Check that the constraint works that requires an association between two value classes to
     * have at least one non-equality-relevant end
     */
    public void testDoubleEqualityRelevantValueClassAssociation() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	c1.setValueType(true);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	c2.setValueType(true);
	Association a = MetamodelUtils.createAssociation(resourceSet, c1, "c1", 0, 1, true, false, false, false, c2, "c2", 0, 1, true, false, false, false);
	a.setName("a");
	modelmanagement.Package p = ModelmanagementFactory.eINSTANCE.createPackage();
	p.setName("p");
	c1.setPackage_(p);
	c2.setPackage_(p);
	p.getAssociations().add(a);
	for (AssociationEnd ae:a.getEnds()) {
	    ae.setContributesToEquality(true);
	}
        BasicDiagnostic diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(a, diagnostics, new HashMap<Object, Object>());
	assertEquals("Expected exactly one constraint violation", 1, diagnostics.getChildren().size());
	assertTrue(diagnostics.getChildren().iterator().next().getMessage().startsWith(
	        "The 'AtMostOneEqualityContributionForTwoValueClasses' constraint is violated"));
    }
    
    /**
     * Check that no modifying feature of an association end can be exposed if that
     * would modify a value
     */
    public void testValueImmutability() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1Value");
	c1.setValueType(true);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2Entity");
	c2.setValueType(false);
	Association a = MetamodelUtils.createAssociation(resourceSet, c1, "c1", 0, 1, true, false, false, false, c2, "c2", 0, 1, true, false, false, false);
	a.setName("a");
	modelmanagement.Package p = ModelmanagementFactory.eINSTANCE.createPackage();
	p.setName("p");
	c1.setPackage_(p);
	c2.setPackage_(p);
	p.getAssociations().add(a);
	assertEquals("c1", a.getEnds().get(0).getName());
	a.getEnds().get(0).setContributesToEquality(true);
	
	// expose eqality-relevant association as getter (required!)
	MethodSignature getter = ClassesFactory.eINSTANCE.createMethodSignature();
	getter.setName("getC2");
	getter.setOutput(a.getEnds().get(1).getType());
	LinkTraversal linkTraversal = ClassesFactory.eINSTANCE.createLinkTraversal();
	linkTraversal.setEnd(a.getEnds().get(1));
	linkTraversal.setImplements_(getter);
	
	
	c1.getOwnedSignatures().add(getter);
	
        BasicDiagnostic diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(a, diagnostics, new HashMap<Object, Object>());
	assertEquals(Diagnostic.OK, diagnostics.getSeverity());
        diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(c1, diagnostics, new HashMap<Object, Object>());
        assertEquals(Diagnostic.OK, diagnostics.getSeverity());
        diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(c2, diagnostics, new HashMap<Object, Object>());
        assertEquals(Diagnostic.OK, diagnostics.getSeverity());
	
	// expose equality-relevant association as setter (illegal!)
	MethodSignature setter = ClassesFactory.eINSTANCE.createMethodSignature();
	setter.setName("setC2");
	LinkSetting linkSetting = ClassesFactory.eINSTANCE.createLinkSetting();
	linkSetting.setEnd(a.getEnds().get(1));
	linkSetting.setImplements_(setter);
	Parameter setterParam = ClassesFactory.eINSTANCE.createParameter();
	setterParam.setName("c2Param");
	setter.getInput().add(setterParam);
	c1.getOwnedSignatures().add(setter);
	
        diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(c1, diagnostics, new HashMap<Object, Object>());
        assertEquals(1, diagnostics.getChildren().size());
	assertEquals("[data, classes, ExtentModifyingAssociationEndSignatureImplementation, MustNotModifyExtentIfEqualityRelevantForValueClass]",
		diagnostics.getChildren().iterator().next().getMessage());
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testEnforcementNoAbstractSignaturesInAdapter() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	MethodSignature s1 = ClassesFactory.eINSTANCE.createMethodSignature();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	MethodSignature s2 = ClassesFactory.eINSTANCE.createMethodSignature();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	MethodSignature adapterSig = ClassesFactory.eINSTANCE.createMethodSignature();
	adapterSig.setName("s2");
	adapter.getOwnedSignatures().add(adapterSig);
        BasicDiagnostic diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(adapter, diagnostics, new HashMap<Object, Object>());
	assertTrue("Adapter should be considered invalid and should violate the SignatureCannotBeAbstract constraint",
		diagnostics.getChildren().size() == 1 && diagnostics.getChildren().iterator().next().getMessage().equals(
			"Signatures can not be abstract"));
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testConformanceWithoutSignatureAdaptation() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	MethodSignature s1 = ClassesFactory.eINSTANCE.createMethodSignature();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	MethodSignature s2 = ClassesFactory.eINSTANCE.createMethodSignature();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	MethodSignature adapterSig = ClassesFactory.eINSTANCE.createMethodSignature();
	adapterSig.setName("s2");
	Block impl = ActionsFactory.eINSTANCE.createBlock();
	impl.setImplements_(adapterSig);
	
	adapter.getOwnedSignatures().add(adapterSig);
        BasicDiagnostic diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(adapter, diagnostics, new HashMap<Object, Object>());
	assertEquals("Adapter should be valid", Diagnostic.OK, diagnostics.getSeverity());
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c2));
    }
    
    /**
     * Check that adapter invariants are really enforced
     */
    public void testConformanceAlongAdapterChain() {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName("C1");
	MethodSignature s1 = ClassesFactory.eINSTANCE.createMethodSignature();
	s1.setName("s1");
	c1.getOwnedSignatures().add(s1);
	SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C2");
	MethodSignature s2 = ClassesFactory.eINSTANCE.createMethodSignature();
	s2.setName("s2");
	c2.getOwnedSignatures().add(s2);
	TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter.setName("FromC1ToC2");
	adapter.setAdapted(c1);
	adapter.setTo(c2);
	MethodSignature adapterSig = ClassesFactory.eINSTANCE.createMethodSignature();
	adapterSig.setName("s2");
	Block impl = ActionsFactory.eINSTANCE.createBlock();
	
	impl.setImplements_(adapterSig);
		
	adapter.getOwnedSignatures().add(adapterSig);
	SapClass c3 = ClassesFactory.eINSTANCE.createSapClass();
	c2.setName("C3");
	MethodSignature s3 = ClassesFactory.eINSTANCE.createMethodSignature();
	s2.setName("s3");
	c3.getOwnedSignatures().add(s3);
	TypeAdapter adapter2 = ClassesFactory.eINSTANCE.createTypeAdapter();
	adapter2.setName("FromC2ToC3");
	adapter2.setAdapted(c2);
	adapter2.setTo(c3);
	MethodSignature adapter2Sig = ClassesFactory.eINSTANCE.createMethodSignature();
	adapterSig.setName("s3");
	Block impl2 = ActionsFactory.eINSTANCE.createBlock();
	
	impl2.setImplements_(adapter2Sig);
	
	
	adapter2.getOwnedSignatures().add(adapter2Sig);
        BasicDiagnostic diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(adapter, diagnostics, new HashMap<Object, Object>());
        assertEquals("Adapter should be valid", Diagnostic.OK, diagnostics.getSeverity());
        diagnostics = new BasicDiagnostic();
        ClassesValidator.INSTANCE.validate(adapter2, diagnostics, new HashMap<Object, Object>());
        assertEquals("Adapter should be valid", Diagnostic.OK, diagnostics.getSeverity());
	assertTrue("Classes with no signatures and an adapter between them should conform",
		c1.conformsTo(c3));
    }
    
}
