package com.sap.ide.cts.editor.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import localization.TranslatableText;
import modelmanagement.Package;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap.Internal.Wrapper;
import org.junit.Test;

import com.sap.ap.cts.monet.deepcopy.RunletModelCopyStrategy;
import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.ide.cts.editor.deepcopy.DeepCopyHelper;
import com.sap.ide.cts.editor.deepcopy.GenericModelCopyStrategy;
import com.sap.ide.cts.editor.test.util.FixtureBasedTest;


import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.SapClass;

public class TestDeepCopy extends FixtureBasedTest {

    private SapClass createNewClass(String className, Resource partition) {
	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	final SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(partition);
	clazz.setName(className);
	return clazz;
    }

    private SapClass createNewClassWithPackage(String className, Resource partition) {
	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	final SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(partition);
	clazz.setName(className);

	final Package pkg = (Package) rootPkg.getModelmanagement().getPackage().refCreateInstanceInPartition(partition);
	pkg.setName(className + "Package");
	clazz.setPackage_(pkg);
	return clazz;
    }

    private Resource createNewPartition(String partitionName, ResourceSet co) {
	final Resource partition = ModelManager.getPartitionService().createPartition(co, getProject(),
		new Path("src/" + partitionName + ".types"), null);
	return partition;
    }

    private Resource getOrCreatePartition(String partitionName, ResourceSet co) {
	Resource part = ModelManager.getPartitionService().getPartition(connection, getProject(),
		new Path("src/" + partitionName + ".types"));
	if (part == null) {
	    return createNewPartition(partitionName, co);
	} else {
	    return part;
	}
    }

    @Test
    public void lookupRepartitionedElement() throws Exception {
	Resource transPartition = connection.getOrCreateTransientPartition("ReparTransTestPartition");
	Resource partition = createNewPartition("ReparTestPartition", connection);

	SapClass clazz = createNewClass("RepartitionTestClass", transPartition);
	LRI lri = clazz.get___Mri().getLri();
	assertTrue("LRI lookup", connection.elementExists(lri));

	PartitionService service = PartitionService.getInstance();
	service.moveElements(transPartition, partition);

	assertTrue("LRI lookup after move", connection.elementExists(lri));
	connection.save();
	assertTrue("LRI lookup after save", connection.elementExists(lri));
	assertNotNull("Element load after save", connection.getElement(lri));
    }

    @Test
    public void testLinkToCompositeParent() throws Exception {
	Resource transPartition = connection.getOrCreateTransientPartition("TestLinkedPartition");
	SapClass clazz = createNewClassWithPackage("TestLinkedClass", transPartition);

	RunletModelCopyStrategy strategy = new RunletModelCopyStrategy();

	// 1# Copy and link
	DeepCopyResultSet result1 = connection.deepCopy(Collections.singleton((EObject) clazz), strategy, false);

	assertEquals(1, result1.getCopiedElements().size());
	DeepCopyMappingEntry entry1 = result1.getMappingTable().get(clazz);
	SapClass copy1 = (SapClass) entry1.getMappingTarget();

	assertTrue(strategy.prepareLinkingToCompositeParent("testOne", clazz, copy1));
	DeepCopyHelper.linkToCompositeParent(connection, clazz, copy1);

	// 2# Copy and link
	DeepCopyResultSet result2 = connection.deepCopy(Collections.singleton((EObject) clazz), strategy, false);

	assertEquals(1, result2.getCopiedElements().size());
	DeepCopyMappingEntry entry2 = result2.getMappingTable().get(clazz);
	SapClass copy2 = (SapClass) entry2.getMappingTarget();

	assertTrue(strategy.prepareLinkingToCompositeParent("testTwo", clazz, copy2));
	DeepCopyHelper.linkToCompositeParent(connection, clazz, copy2);

	// Get parent
	Package pkg = (Package) DeepCopyHelper.getCompositeParent(connection, clazz);
	assertNotNull(pkg);
	assertEquals(pkg, clazz.getPackage());

	// Validate
	assertEquals(pkg, copy1.getPackage());
	assertEquals(pkg, copy2.getPackage());

	assertEquals(3, pkg.getClasses().size());
	assertTrue(pkg.getClasses().containsAll(Arrays.asList(clazz, copy1, copy2)));

	// Check with the means of the DeepCopyHelper
	assertEquals(pkg, DeepCopyHelper.getCompositeParent(connection, copy1));
	assertEquals(pkg, DeepCopyHelper.getCompositeParent(connection, copy2));

	Collection<EObject> children = DeepCopyHelper.getCompositeChildrenImmediate(connection, pkg);
	assertEquals(3, children.size());
	assertTrue(children.containsAll(Arrays.asList(clazz, copy1, copy2)));

	Collection<EObject> linked2Pkg = DeepCopyHelper.getAllLinkedElements(connection, pkg);
	Collection<EObject> linked2Copy1 = DeepCopyHelper.getAllLinkedElements(connection, copy1);
	Collection<EObject> linked2Copy2 = DeepCopyHelper.getAllLinkedElements(connection, copy2);
	Collection<EObject> linked2Clazz = DeepCopyHelper.getAllLinkedElements(connection, clazz);

	assertEquals(0, linked2Pkg.size());
	assertEquals(1, linked2Copy1.size());
	assertEquals(1, linked2Copy2.size());
	assertEquals(1, linked2Clazz.size());

    }

    @Test
    public void testLinkToCompositeParentAcrossPartitionsAndConnections() throws Exception {
	// Create source
	Resource sourcePartition = createNewPartition("TestLinkedAcrossPartition", connection);
	SapClass clazz = createNewClassWithPackage("TestLinkedAcrossClass", sourcePartition);
	connection.save();

	// Simulate that the snapshotting uses a different connection
	ResourceSet targetCon = createConnection();
	EObject clazzInTarget = (EObject) targetCon.getElement(clazz.get___Mri());
	RunletModelCopyStrategy strategy = new RunletModelCopyStrategy();

	// 1# Copy, move and link
	DeepCopyResultSet result1 = targetCon.deepCopy(Collections.singleton(clazzInTarget), strategy.getDeepCopyPolicyHandler(),
		strategy.includeExternalCompositeParents());

	assertEquals(1, result1.getCopiedElements().size());
	DeepCopyMappingEntry entry1 = result1.getMappingTable().get(clazzInTarget);
	SapClass copy1 = (SapClass) entry1.getMappingTarget();

	Resource copy1Partition = createNewPartition("copy1Partition", targetCon);
	copy1.assign___Partition(copy1Partition);

	assertTrue(strategy.prepareLinkingToCompositeParent("testOne", clazzInTarget, copy1));
	DeepCopyHelper.linkToCompositeParent(targetCon, clazzInTarget, copy1);

	targetCon.save();

	// 2# Copy, link and move
	DeepCopyResultSet result2 = targetCon.deepCopy(Collections.singleton(clazzInTarget), strategy.getDeepCopyPolicyHandler(),
		strategy.includeExternalCompositeParents());

	assertEquals(1, result2.getCopiedElements().size());
	DeepCopyMappingEntry entry2 = result2.getMappingTable().get(clazzInTarget);
	SapClass copy2 = (SapClass) entry2.getMappingTarget();

	Resource copy2Partition = createNewPartition("copy2Partition", targetCon);
	copy2.assign___Partition(copy2Partition);

	assertTrue(strategy.prepareLinkingToCompositeParent("testTwo", clazzInTarget, copy2));
	DeepCopyHelper.linkToCompositeParent(targetCon, clazzInTarget, copy2);

	targetCon.save();

	// Get parent
	Package pkg = (Package) DeepCopyHelper.getCompositeParent(connection, clazz);
	assertNotNull(pkg);
	assertEquals(pkg, clazz.getPackage());

	// Validate
	assertEquals(pkg, copy1.getPackage());
	assertEquals(pkg, copy2.getPackage());

	assertEquals(3, pkg.getClasses().size());
	assertTrue(pkg.getClasses().containsAll(Arrays.asList(clazz, copy1, copy2)));

	// Check with the means of the DeepCopyHelper
	assertEquals(pkg, DeepCopyHelper.getCompositeParent(connection, copy1));
	assertEquals(pkg, DeepCopyHelper.getCompositeParent(connection, copy2));

	Collection<EObject> children = DeepCopyHelper.getCompositeChildrenImmediate(connection, pkg);
	assertEquals(3, children.size());
	assertTrue(children.containsAll(Arrays.asList(clazz, copy1, copy2)));

	Collection<EObject> linked2Pkg = DeepCopyHelper.getAllLinkedElements(connection, pkg);
	Collection<EObject> linked2Copy1 = DeepCopyHelper.getAllLinkedElements(connection, copy1);
	Collection<EObject> linked2Copy2 = DeepCopyHelper.getAllLinkedElements(connection, copy2);
	Collection<EObject> linked2Clazz = DeepCopyHelper.getAllLinkedElements(connection, clazz);

	assertEquals(0, linked2Pkg.size());
	assertEquals(1, linked2Copy1.size());
	assertEquals(1, linked2Copy2.size());
	assertEquals(1, linked2Clazz.size());
    }

    /**
     * This testcase assures that DeepCopy respects the orderdness of
     * Assocations and their respective AssociationEnds at the MOF level (not at
     * the NGPM level).
     * 
     * Warning: This test might be flaky
     * 
     */
    @Test
    public void testCopyRetainsOrder() {
	Resource transPartition = connection.getOrCreateTransientPartition("TestPartition");
	SapClass c1 = createNewClass("TestC1", transPartition);
	SapClass c2 = createNewClass("TestC2", transPartition);

	Association a = MetamodelUtils.createAssociation(connection, c1, "c1", 0, 1, true, false, false, false, c2, "c2", 0, 1,
		true, false, false, false);
	a.setName("a");

	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	final Package pkg = (Package) rootPkg.getModelmanagement().getPackage().refCreateInstanceInPartition(transPartition);
	pkg.setName("TestPakage");
	c1.setPackage(pkg);
	c2.setPackage(pkg);
	pkg.getAssociations().add(a);

	// make sure it that our assert works right
	AssociationEnd originalFirst = a.getEnds().get(0);
	AssociationEnd originalSecond = a.getEnds().get(1);
	assertFalse(originalFirst.getName().equals(originalSecond.getName()));

	// Get a policy for testing
	GenericModelCopyStrategy strategy = new GenericModelCopyStrategy() {
	    @Override
	    protected DeepCopyPolicy getMetaModelSpecificMapping(EObject sourceElement, DeepCopyMap copyMap) {
		// Move up in the composition hierarchy
		if (sourceElement instanceof Association) {
		    return new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
		} else {
		    return null;
		}
	    }
	};
	DeepCopyPolicyHandler pol = strategy.getDeepCopyPolicyHandler();

	for (int i = 0; i < 10; i++) {
	    // Run this test several times. Due to unpredictable ordering
	    // hashmaps it might pass though the implementation is wrong..
	    performDeepCopyTest(a, originalFirst, originalSecond, pol, false);

	    // Include external composite parents to ignore special handling of
	    // composite
	    // ends. Otherwise links would only be created from parent to child
	    // but not
	    // the other way round.
	    // (this is a WhiteBox Test)
	    performDeepCopyTest(a, originalFirst, originalSecond, pol, true);
	}
    }

    private void performDeepCopyTest(final Association a, final AssociationEnd originalFirst,
	    final AssociationEnd originalSecond, final DeepCopyPolicyHandler pol, final Boolean includeExternalCompositeParents) {

	// Test: Order maintained when starting on parent
	DeepCopyResultSet result1 = connection.deepCopy(Collections.singleton((EObject) a), pol,
		includeExternalCompositeParents);
	DeepCopyMappingEntry copyEntry1 = result1.getMappingTable().get(a);
	Association copyOfA = (Association) copyEntry1.getMappingTarget();

	assertEquals("First End in place", originalFirst.getName(), copyOfA.getEnds().get(0).getName());
	assertEquals("Second End in place", originalSecond.getName(), copyOfA.getEnds().get(1).getName());

	// Test: Order maintained when starting on FIRST child
	DeepCopyResultSet result2 = connection.deepCopy(Collections.singleton((EObject) originalFirst), pol,
		includeExternalCompositeParents);
	DeepCopyMappingEntry copyEntry2 = result2.getMappingTable().get(a);
	assertEquals(copyEntry2.getModifiedPolicy().getDeepCopyPolicyOption(), DeepCopyPolicyOption.FULL_COPY);
	Association AOfFirst = (Association) copyEntry2.getMappingTarget();
	assertFalse(AOfFirst.equals(a));

	assertEquals("First End in place", originalFirst.getName(), AOfFirst.getEnds().get(0).getName());
	assertEquals("Second End in place", originalSecond.getName(), AOfFirst.getEnds().get(1).getName());

	// Test: Order maintained when starting on SECOND child
	DeepCopyResultSet result3 = connection.deepCopy(Collections.singleton((EObject) originalSecond), pol,
		includeExternalCompositeParents);
	DeepCopyMappingEntry copyEntry3 = result3.getMappingTable().get(a);
	assertEquals(copyEntry3.getModifiedPolicy().getDeepCopyPolicyOption(), DeepCopyPolicyOption.FULL_COPY);
	Association AOfSecond = (Association) copyEntry3.getMappingTarget();
	assertFalse(AOfSecond.equals(a));

	assertEquals("First End in place", originalFirst.getName(), AOfSecond.getEnds().get(0).getName());
	assertEquals("Second End in place", originalSecond.getName(), AOfSecond.getEnds().get(1).getName());
    }

    /**
     * Test that the attributes has been copied correctly
     */
    @Test
    public void testIdentity() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();

	tc0.setName("TestClass0Inst0");
	tc0.setAttrInt0(0);
	tc0.setAttrDouble0(0);
	tc0.setAttrString0("TestClass0Inst0attrString0");

	List<EObject> list1 = new ArrayList<EObject>();
	list1.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(list1, null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean containsTc0 = false;

	for (EObject copy : copiedElements) {
	    assertFalse(copy.equals(tc0));
	    assertTrue(((TestClass0) copy).getAttrString0() == "TestClass0Inst0attrString0");
	    if (copy.refGetValue("name") == "TestClass0Inst0") {
		containsTc0 = true;
	    }
	}
	assertTrue(containsTc0);
    }

    /**
     * Test that elements with object valued attributes are correctly copied
     */
    @Test
    public void testObjectValuedAttributes() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();

	tc0.setName("TestClass0Inst0");

	TestClass0 tc0ov0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0ov0.setName("TestClass0Inst0attrObjValued0");
	TestClass1 tc0ov1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc0ov1.setName("TestClass0Inst0attrObjValued1");
	TestClass2 tc0ov2 = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc0ov2.setName("TestClass0Inst0attrObjValued2");

	tc0.setAttrObjectValued0(tc0ov0);
	tc0.setAttrObjectValued1(tc0ov1);
	tc0.setAttrObjectValued2(tc0ov2);

	TestClass0 tc0ov0ov0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0ov0ov0.setName("TestClass0Inst0attrObjValued0attrObjValued0");
	TestClass1 tc0ov0ov1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc0ov0ov1.setName("TestClass0Inst0attrObjValued0attrObjValued1");
	TestClass2 tc0ov0ov2 = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc0ov0ov2.setName("TestClass0Inst0attrObjValued0attrObjValued2");

	tc0ov0.setAttrObjectValued0(tc0ov0ov0);
	tc0ov0.setAttrObjectValued1(tc0ov0ov1);
	tc0ov0.setAttrObjectValued2(tc0ov0ov2);

	List<EObject> list1 = new ArrayList<EObject>();
	list1.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(list1, null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean containsTc0 = false;

	for (EObject copy : copiedElements) {
	    if (copy instanceof TestClass0 && ((TestClass0) copy).getName().equals("TestClass0Inst0")) {
		assertTrue(((TestClass0) copy).getAttrObjectValued0().getAttrObjectValued2().getName() == "TestClass0Inst0attrObjValued0attrObjValued2");
		containsTc0 = true;
		break;
	    }
	}

	assertTrue(containsTc0);
    }

    /**
     * Test that elements with object valued attributes with multiplicity n are
     * correctly copied
     */
    @Test
    public void testObjectValuedAttributesN() {

	// Test with empty attribute
	A4 a4Empty = connection.createElement(A4.CLASS_DESCRIPTOR);
	a4Empty.setOnePrimitive("a4Empty");

	// Test with 2 attributes
	A4 a4with2Attributes = connection.createElement(A4.CLASS_DESCRIPTOR);
	a4with2Attributes.setOnePrimitive("a4with2Attributes");
	Collection<B4> manyBs = a4with2Attributes.getManyBs();
	B4 b4_01 = connection.createElement(B4.CLASS_DESCRIPTOR);
	b4_01.setOnePrimitive("b4_01");
	manyBs.add(b4_01);
	B4 b4_02 = connection.createElement(B4.CLASS_DESCRIPTOR);
	b4_02.setOnePrimitive("b4_02");
	manyBs.add(b4_02);

	List<EObject> list1 = new ArrayList<EObject>();
	list1.add(a4Empty);
	list1.add(a4with2Attributes);

	DeepCopyResultSet resultSet = connection.deepCopy(list1, null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean foundA4Empty = false;
	boolean foundA4with2Attributes = false;
	boolean foundA4Attributes = false;

	assert (copiedElements.size() == 4);
	for (EObject copy : copiedElements) {
	    if (copy instanceof A4) {
		A4 copiedA4 = ((A4) copy);
		String a4Name = copiedA4.getOnePrimitive();
		if ("a4Empty".equals(a4Name)) {
		    foundA4Empty = true;
		} else if ("a4with2Attributes".equals(a4Name)) {
		    foundA4with2Attributes = true;
		    foundA4Attributes = (copiedA4.getManyBs().size() == 2);
		}
	    }
	}

	assertTrue("a4Empty not copied correctly", foundA4Empty);
	assertTrue("a4with2Attributes not copied correctly", foundA4with2Attributes);
	assertTrue("Attributes of a4with2Attributes not copied correctly", foundA4Attributes);
    }

    /**
     * Test that elements with object valued attributes that have composite
     * children are correctly copied
     */
    @SuppressWarnings("null")
    @Test
    public void testObjectValuedAttributesWithCompositeChildren() {

	TestClass0 a = connection.createElementInPartition(TestClass0.CLASS_DESCRIPTOR, getOrCreatePartition("One", connection));
	a.setName("a");
	TestClass0 b = connection.createElementInPartition(TestClass0.CLASS_DESCRIPTOR, getOrCreatePartition("One", connection));
	b.setName("b");
	TestClass0 c = connection.createElementInPartition(TestClass0.CLASS_DESCRIPTOR, getOrCreatePartition("One", connection));
	c.setName("c");
	TestClass0 d = connection.createElementInPartition(TestClass0.CLASS_DESCRIPTOR, getOrCreatePartition("One", connection));
	d.setName("d");
	TestClass1 e = connection.createElementInPartition(TestClass1.CLASS_DESCRIPTOR, getOrCreatePartition("One", connection));
	e.setName("e");
	TestClass2 f = connection.createElementInPartition(TestClass2.CLASS_DESCRIPTOR, getOrCreatePartition("One", connection));
	f.setName("f");

	a.setAttrObjectValued0(b);
	b.getReference0Composite().add(c);
	b.getReference0x1().add(e); // should not be copied (because of 0..1) !!
	c.getReference0Composite().add(d);
	f.getReference2x0().add(b); // should be copied, i.e. bCopy should also
				    // be referenced by f

	DeepCopyResultSet resultSet = connection.deepCopy(Collections.singletonList((EObject) a), null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	assertEquals(4, copiedElements.size());

	TestClass0 aCopy = null;
	for (EObject copy : copiedElements) {
	    if (copy.refGetValue("name").equals("a")) {
		aCopy = (TestClass0) copy;
		break;
	    }
	}
	assertNotNull(aCopy);

	TestClass0 bCopy = aCopy.getAttrObjectValued0();
	assertNotNull(bCopy);
	assertEquals("b", bCopy.getName());
	assertFalse(b.get___Mri().equals(bCopy.get___Mri()));

	Collection<TestClass0> compositeChildren = bCopy.getReference0Composite();
	assertEquals(1, compositeChildren.size());
	TestClass0 cCopy = compositeChildren.iterator().next();
	assertNotNull(cCopy);
	assertEquals("c", cCopy.getName());
	assertFalse(c.get___Mri().equals(cCopy.get___Mri()));

	Collection<TestClass0> compositeChildrenOfC = cCopy.getReference0Composite();
	assertEquals(1, compositeChildrenOfC.size());
	TestClass0 dCopy = compositeChildrenOfC.iterator().next();
	assertNotNull(dCopy);
	assertEquals("d", dCopy.getName());
	assertFalse(d.get___Mri().equals(dCopy.get___Mri()));

	Collection<TestClass1> reference0x1 = bCopy.getReference0x1();
	assertEquals(0, reference0x1.size());

	Collection<TestClass0> reference2x0 = f.getReference2x0();
	assertEquals(2, reference2x0.size());
	boolean bFound = false, bCopyFound = false;
	for (TestClass0 testClass0 : reference2x0) {
	    if (testClass0.equals(b)) {
		bFound = true;
	    }
	    if (testClass0.equals(bCopy)) {
		bCopyFound = true;
	    }
	}
	assertTrue(bFound);
	assertTrue(bCopyFound);
    }

    @Test
    public void testEnumerationAttributes() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();

	tc0.setName("TestClass0Inst0");

	tc0.setAttrEnum(EnumTpEnum.LABEL7);

	List<EObject> list1 = new ArrayList<EObject>();
	list1.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(list1, null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean containsTc0 = false;

	for (EObject copy : copiedElements) {
	    assertTrue(((TestClass0) copy).getAttrEnum().equals(EnumTpEnum.LABEL7));
	    if (copy.refGetValue("name") == "TestClass0Inst0") {
		containsTc0 = true;
	    }
	}

	assertTrue(containsTc0);

    }

    @Test
    public void testStructureTypedAttributes() {

	StructureFieldContainer<StructInStructTp> contStructInStructTp = new StructureFieldContainer<StructInStructTp>();
	StructureFieldContainer<StructTp> contStructTp = new StructureFieldContainer<StructTp>();

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();

	tc0.setName("TestClass0Inst0");

	contStructInStructTp.put(StructInStructTp.DESCRIPTORS.FIELD1(), 23).put(StructInStructTp.DESCRIPTORS.FIELD2(),
		"innerStructString");
	StructInStructTp innerStructAttr = gpackage1.createStructInStructTp(contStructInStructTp);
	contStructTp.put(StructTp.DESCRIPTORS.FIELD1(), 42).put(StructTp.DESCRIPTORS.FIELD2(), "structString").put(
		StructTp.DESCRIPTORS.FIELD3(), innerStructAttr);
	StructTp structureTypedAttr = gpackage1.createStructTp(contStructTp);
	tc0.setAttrStruct(structureTypedAttr);

	List<EObject> list1 = new ArrayList<EObject>();
	list1.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(list1, null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean containsTc0 = false;

	for (EObject copy : copiedElements) {
	    assertTrue(((TestClass0) copy).getAttrStruct().getField1() == 42);
	    assertTrue(((TestClass0) copy).getAttrStruct().getField3().getField1() == 23);
	    if (copy.refGetValue("name") == "TestClass0Inst0") {
		containsTc0 = true;
	    }
	}

	assertTrue(containsTc0);
    }

    @Test
    public void testMultiValuedAttributes() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();

	tc0.setName("TestClass0Inst0");

	Collection<String> mv0 = tc0.getAttrStringMultiValued0();

	mv0.add("TestClass0Inst0attrStringMv0value0");
	mv0.add("TestClass0Inst0attrStringMv0value1");
	mv0.add("TestClass0Inst0attrStringMv0value2");

	List<EObject> list1 = new ArrayList<EObject>();
	list1.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(list1, null, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean containsTc0 = false;

	for (EObject copy : copiedElements) {
	    assertTrue(((TestClass0) copy).getAttrStringMultiValued0().containsAll(mv0));
	    if (copy.refGetValue("name") == "TestClass0Inst0") {
		containsTc0 = true;
	    }
	}

	assertTrue(containsTc0);

    }

    /**
     * Test that composite children are also copied when not explicitly given as
     * seed.
     */
    @Test
    public void testCompositeChildren() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass0 tc0child1 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0child1.setName("tc0child1");
	TestClass0 tc0child2 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0child2.setName("tc0child2");

	Assoc0Composite ass0comp = gpackage1.getAssoc0Composite();
	ass0comp.add(tc0, tc0child1);
	ass0comp.add(tc0, tc0child2);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);

	boolean containsTc0 = false;

	for (EObject copy : resultSet.getCopiedElements()) {
	    if (((TestClass0) copy).getName().equals("tc0")) {
		containsTc0 = true;
		Collection<TestClass0> children = ((TestClass0) copy).getReference0Composite();
		assertTrue(children.size() == 2);
		if (children.iterator().hasNext()) {
		    assertTrue(children.iterator().next().getName().startsWith("tc0child"));
		}
	    }
	    if (((TestClass0) copy).getName().equals("tc0child1")) {
		assertFalse(copy.equals(tc0child1));
	    }
	}

	assertTrue(containsTc0);
    }

    /**
     * Test that linked elements are also linked by the copied elements
     */
    @Test
    public void testDirectLinks() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1.setName("tc1");
	TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc2.setName("tc2");
	TestClass3 tc3 = (TestClass3) gpackage1.getTestClass3().refCreateInstance();
	tc3.setName("tc3");

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc0, tc1);
	ass0xRef.add(tc0, tc2);

	Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement();
	ass1xRef.add(tc1, tc3);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);
	elementsToBeCopied.add(tc1);

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);

	boolean containsTc2 = resultSet.getMappingTable().containsKey(tc2);
	boolean containsTc3 = resultSet.getMappingTable().containsKey(tc3);

	for (EObject copiedObject : resultSet.getCopiedElements()) {
	    String name = (String) copiedObject.refGetValue("name");
	    if (name == "tc0") {
		assertTrue(((TestClass0) copiedObject).getReference0xRefElement().contains(tc2));
	    }
	}

	assertTrue(containsTc2 && containsTc3);
    }

    @Test
    public void testFalselySetReverseAssociations() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc01 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc01.setName("tc01");
	TestClass0 tc02 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc02.setName("tc02");

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc01, tc02);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc02);
	elementsToBeCopied.add(tc01);

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);

	for (EObject copiedObject : resultSet.getCopiedElements()) {
	    String name = (String) copiedObject.refGetValue("name");
	    if (name == "tc01") {
		assertTrue(resultSet.getCopiedElements().containsAll(((TestClass0) copiedObject).getReference0xRefElement()));
	    } else if (name == "tc02") {
		assertTrue(((TestClass0) copiedObject).getReference0xRefElement().isEmpty());
	    }
	}
    }

    /**
     * Test a PolicyHandler that STOPS copying a composite children
     */
    @Test
    public void testRemoveCompositeChild() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass0 tc0child1 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0child1.setName("tc0child1");
	TestClass0 tc0child2 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0child2.setName("tc0child2");

	Assoc0Composite ass0comp = gpackage1.getAssoc0Composite();
	ass0comp.add(tc0, tc0child1);
	ass0comp.add(tc0, tc0child2);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);

	/*
	 * prevent the element "tc0child2" from being mapped
	 */
	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		DeepCopyPolicy resultPolicy = null;
		if (sourceElement instanceof TestClass0) {
		    if (((TestClass0) sourceElement).getName().equals("tc0child2")) {
			resultPolicy = new DeepCopyPolicy(DeepCopyPolicyOption.STOP, null);
		    } else {
			resultPolicy = defaultPolicy;
		    }
		} else {
		    resultPolicy = defaultPolicy;
		}
		return resultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);

	for (EObject copy : resultSet.getCopiedElements()) {
	    if ((copy != null) && ((TestClass0) copy).getName().equals("tc0")) {
		Collection<TestClass0> children = ((TestClass0) copy).getReference0Composite();
		if (children.iterator().hasNext()) {
		    assertFalse(children.iterator().next().getName().equals("tc0child2"));
		}
	    }
	}
    }

    /**
     * Test a PolicyHandler that returns a wrong CUSTOM element
     */
    @Test
    public void testInvalidCustomType() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1.setName("tc1");
	TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc2.setName("tc2");
	TestClass3 tc3 = (TestClass3) gpackage1.getTestClass3().refCreateInstance();
	tc3.setName("tc3");

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);
	elementsToBeCopied.add(tc1);
	elementsToBeCopied.add(tc2);
	elementsToBeCopied.add(tc3);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		DeepCopyPolicy resultPolicy = null;
		if (sourceElement instanceof TestClass0) {
		    EPackage gpackage2 = (EPackage) (connection.getPackage(null,
			    new String[] { "generatedmetamodel" }));
		    TestClass1 tc1fault = (TestClass1) gpackage2.getTestClass1().refCreateInstance();
		    tc1fault.setName("tc0_faultyType_tc1");
		    resultPolicy = new DeepCopyPolicy(DeepCopyPolicyOption.CUSTOM, tc1fault);
		} else {
		    resultPolicy = defaultPolicy;
		}
		return resultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);
	assertFalse(resultSet.getCopyErrors().isEmpty());

	for (DeepCopyError e : resultSet.getCopyErrors()) {
	    assertTrue(e.getErrorType().equals(DeepCopyErrorType.ERR_006));
	}

    }

    /**
     * Test a PolicyHandler that uses CUSTOM mapping
     */
    @Test
    public void testCustomHandler() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1.setName("tc1");
	TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc2.setName("tc2");
	TestClass3 tc3 = (TestClass3) gpackage1.getTestClass3().refCreateInstance();
	tc3.setName("tc3");

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);
	elementsToBeCopied.add(tc1);
	elementsToBeCopied.add(tc2);
	elementsToBeCopied.add(tc3);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		EObject newObject = sourceElement.refClass().refCreateInstance();
		newObject.refSetValue("name", sourceElement.refGetValue("name") + "_copy");
		return new DeepCopyPolicy(DeepCopyPolicyOption.CUSTOM, newObject);
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);

	assertTrue(resultSet.getCopyErrors().isEmpty());
	assertTrue(resultSet.getCopiedElements().size() == 4);
    }

    @Test
    public void testInvalidMappingModification() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1.setName("tc1");
	TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc2.setName("tc2");

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc0, tc1);
	ass0xRef.add(tc0, tc2);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		if (defaultPolicy.getDeepCopyPolicyOption().equals(DeepCopyPolicyOption.FULL_COPY)) {
		    return new DeepCopyPolicy(DeepCopyPolicyOption.REF_COPY, null);
		} else {
		    return defaultPolicy;
		}
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);

	for (DeepCopyError e : resultSet.getCopyErrors()) {
	    assertTrue(e.getErrorType().equals(DeepCopyErrorType.ERR_005));
	}
    }

    @Test
    public void testWrongAssociationCardinality() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1.setName("tc1");

	Assoc0x1 ass0x1 = gpackage1.getAssoc0x1();
	ass0x1.add(tc0, tc1);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc1);

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);
	for (DeepCopyError e : resultSet.getCopyErrors()) {
	    assertTrue(e.getErrorType().equals(DeepCopyErrorType.ERR_001));
	}

    }

    @Test
    public void testSubClassWithAssociationInheritedFromSuperclass() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestSubClass0 tc0 = (TestSubClass0) gpackage1.getTestSubClass0().refCreateInstance();
	tc0.setName("tc0");
	TestSubClass1 tc1 = (TestSubClass1) gpackage1.getTestSubClass1().refCreateInstance();
	tc1.setName("tc1");

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc0, tc1);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);

	for (EObject copy : resultSet.getCopiedElements()) {
	    if (copy instanceof TestClass0) {
		assertTrue(((TestClass0) copy).getReference0xRefElement().contains(tc1));
	    }
	}
    }

    @Test
    public void testCriticalCase() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0a = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0a.setName("tc0a");
	TestClass0 tc0b = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0b.setName("tc0b");
	TestClass1 tc1c = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1c.setName("tc1c");
	TestClass1 tc1d = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1d.setName("tc1d");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc0a, tc0b);

	Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite();
	ass1Comp.add(tc1c, tc1d);

	Assoc0xRefElement ass0xRefElement = gpackage1.getAssoc0xRefElement();
	ass0xRefElement.add(tc0a, tc1d);
	ass0xRefElement.add(tc0b, tc1c);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0b);
	elementsToBeCopied.add(tc0a);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		// logger.trace(MoinSeverity.DEBUG,
		// deepCopier.printMappingTable(copyMap));

		if (sourceElement.refGetValue("name") == "tc1c") {
		    return new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
		} else {
		    return defaultPolicy;
		}
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);
	assertTrue(resultSet.getCopyErrors().isEmpty());
    }

    @Test
    public void testCompositeInSeed() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0a = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0a.setName("tc0a");
	TestClass0 tc0b = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0b.setName("tc0b");
	TestClass0 tc0c = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0c.setName("tc0c");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc0a, tc0b);
	ass0Comp.add(tc0b, tc0c);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0a);
	elementsToBeCopied.add(tc0c);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);
	assertTrue(resultSet.getCopyErrors().isEmpty());
    }

    @Test
    public void testWrongAssocEndCardinality() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc1.setName("tc1");

	Assoc0x1 ass0x1 = gpackage1.getAssoc0x1();
	ass0x1.add(tc0, tc1);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);

	for (DeepCopyError e : resultSet.getCopyErrors()) {
	    assertTrue(e.getErrorType().equals(DeepCopyErrorType.ERR_007));
	}
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testComplexExample() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");
	TestClass1 tc_C = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_C.setName("C");
	TestClass1 tc_D = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_D.setName("D");
	TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_E.setName("E");
	TestClass3 tc_F = (TestClass3) gpackage1.getTestClass3().refCreateInstance();
	tc_F.setName("F");
	TestClass2 tc_G = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc_G.setName("G");
	TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_H.setName("H");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_H, tc_B);

	Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite();
	ass1Comp.add(tc_E, tc_A);
	ass1Comp.add(tc_A, tc_C);
	ass1Comp.add(tc_C, tc_D);

	Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement();
	ass1xRef.add(tc_A, tc_D);

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc_B, tc_G);

	Assoc2xRefElement ass2xRef = gpackage1.getAssoc2xRefElement();
	ass2xRef.add(tc_G, tc_C);
	ass2xRef.add(tc_G, tc_D);

	Assoc3x1 ass3x1 = gpackage1.getAssoc3x1();
	ass3x1.add(tc_F, tc_C);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);

	assertTrue(resultSet.getMappingTable().containsKey(tc_C));
	assertTrue(resultSet.getMappingTable().containsKey(tc_D));
	assertTrue(resultSet.getMappingTable().containsKey(tc_E));
	assertTrue(resultSet.getMappingTable().containsKey(tc_F));
	assertTrue(resultSet.getMappingTable().containsKey(tc_G));
	assertTrue(resultSet.getMappingTable().containsKey(tc_H));

	assertTrue(resultSet.getMappingTable().get(tc_C).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.FULL_COPY));
	assertTrue(resultSet.getMappingTable().get(tc_D).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.FULL_COPY));
	assertTrue(resultSet.getMappingTable().get(tc_E).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.REF_COPY));
	assertTrue(resultSet.getMappingTable().get(tc_F).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.REF_COPY));
	assertTrue(resultSet.getMappingTable().get(tc_G).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.REF_COPY));
	assertTrue(resultSet.getMappingTable().get(tc_H).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.REF_COPY));

	TestClass1 tc_A_copy = (TestClass1) (resultSet.getMappingTable().get(tc_A).getMappingTarget());
	TestClass0 tc_B_copy = (TestClass0) (resultSet.getMappingTable().get(tc_B).getMappingTarget());
	TestClass1 tc_C_copy = (TestClass1) (resultSet.getMappingTable().get(tc_C).getMappingTarget());
	TestClass1 tc_D_copy = (TestClass1) (resultSet.getMappingTable().get(tc_D).getMappingTarget());

	assertTrue(((Collection<EObject>) (tc_A_copy.refGetValue("reference1xRefElement"))).contains(tc_D_copy));
	assertTrue(((Collection<EObject>) (tc_B_copy.refGetValue("reference0xRefElement"))).contains(tc_G));

	assertTrue(((Collection<EObject>) (tc_A_copy.refGetValue("reference1Composite"))).contains(tc_C_copy));
	assertTrue(((Collection<EObject>) (tc_C_copy.refGetValue("reference1Composite"))).contains(tc_D_copy));
    }

    @Test
    public void testOverrideMappingEntry() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_A);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		// logger.trace(MoinSeverity.DEBUG,
		// deepCopier.printMappingTable(copyMap));

		DeepCopyPolicy modifiedPolicy;

		if (copyMap.get(sourceElement) != null) {
		    modifiedPolicy = new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
		} else {
		    modifiedPolicy = new DeepCopyPolicy(DeepCopyPolicyOption.STOP, null);
		}

		return modifiedPolicy;
	    }
	};
	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);

	assertTrue(resultSet.getMappingTable().get(tc_A).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.STOP));

    }

    @Test
    public void testWrappers() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");
	TestClass1 tc_C = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_C.setName("C");
	TestClass1 tc_D = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_D.setName("D");
	TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_E.setName("E");
	TestClass3 tc_F = (TestClass3) gpackage1.getTestClass3().refCreateInstance();
	tc_F.setName("F");
	TestClass2 tc_G = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc_G.setName("G");
	TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_H.setName("H");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_H, tc_B);

	Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite();
	ass1Comp.add(tc_E, tc_A);
	ass1Comp.add(tc_A, tc_C);
	ass1Comp.add(tc_C, tc_D);

	Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement();
	ass1xRef.add(tc_A, tc_D);

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc_B, tc_G);

	Assoc2xRefElement ass2xRef = gpackage1.getAssoc2xRefElement();
	ass2xRef.add(tc_G, tc_C);
	ass2xRef.add(tc_G, tc_D);

	Assoc3x1 ass3x1 = gpackage1.getAssoc3x1();
	ass3x1.add(tc_F, tc_C);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		// logger.trace(MoinSeverity.DEBUG,
		// deepCopier.printMappingTable(copyMap));
		return defaultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();

	boolean containsD = false;

	for (EObject copy : copiedElements) {
	    if (copy.refGetValue("name") == "D") {
		containsD = true;
	    }
	    assertTrue(copy instanceof Wrapper);
	}
	assertTrue(containsD);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testUnWrappedElements() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add((EObject) ((Wrapper) tc_A).unwrap());
	elementsToBeCopied.add((EObject) ((Wrapper) tc_B).unwrap());

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	CoreConnection coreConn = ((ConnectionWrapper) connection).unwrap();
	synchronized (coreConn.getSession().getWorkspaceSet().getSynchronizationManager().getProhibitWriteSyncObject()) {
	    try {
		coreConn.deepCopy(elementsToBeCopied, testHandler1, true);
		fail("Expected UnsupportedOperationException");
	    } catch (UnsupportedOperationException ex) {
		// expected!
	    }
	}
    }

    @Test
    public void testWrappedCustomHandler() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		EObject newObject = sourceElement.refClass().refCreateInstance();
		newObject.refSetValue("name", sourceElement.refGetValue("name") + "_copy");
		return new DeepCopyPolicy(DeepCopyPolicyOption.CUSTOM, newObject);
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, true);
	Collection<EObject> copiedElements = resultSet.getCopiedElements();
	assertEquals(2, copiedElements.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testMultipleConnections() throws Exception {

	ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");
	TestClass1 tc_C = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_C.setName("C");
	TestClass1 tc_D = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_D.setName("D");
	TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_E.setName("E");
	TestClass3 tc_F = (TestClass3) gpackage1.getTestClass3().refCreateInstance();
	tc_F.setName("F");
	TestClass2 tc_G = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc_G.setName("G");
	TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_H.setName("H");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_H, tc_B);

	Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite();
	ass1Comp.add(tc_E, tc_A);
	ass1Comp.add(tc_A, tc_C);
	ass1Comp.add(tc_C, tc_D);

	Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement();
	ass1xRef.add(tc_A, tc_D);

	Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement();
	ass0xRef.add(tc_B, tc_G);

	Assoc2xRefElement ass2xRef = gpackage1.getAssoc2xRefElement();
	ass2xRef.add(tc_G, tc_C);
	ass2xRef.add(tc_G, tc_D);

	Assoc3x1 ass3x1 = gpackage1.getAssoc3x1();
	ass3x1.add(tc_F, tc_C);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		// logger.trace(MoinSeverity.DEBUG,
		// deepCopier.printMappingTable(copyMap));

		return defaultPolicy;
	    }
	};

	Resource mp1 = getOrCreatePartition("deepCopy1", connection);

	mp1.assignElement(tc_A);
	mp1.assignElement(tc_B);
	mp1.assignElement(tc_C);
	mp1.assignElement(tc_D);
	mp1.assignElement(tc_E);
	mp1.assignElement(tc_F);
	mp1.assignElement(tc_G);
	mp1.assignElement(tc_H);

	connection.save();

	DeepCopyResultSet resultSet = connection2.deepCopy(elementsToBeCopied, testHandler1, true);

	assertTrue(resultSet.getCopyErrors().isEmpty());

	assertTrue(resultSet.getMappingTable().containsKey(tc_C));
	assertTrue(resultSet.getMappingTable().containsKey(tc_D));

	assertTrue(resultSet.getMappingTable().get(tc_C).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.FULL_COPY));
	assertTrue(resultSet.getMappingTable().get(tc_D).getModifiedPolicy().getDeepCopyPolicyOption().equals(
		DeepCopyPolicyOption.FULL_COPY));

	TestClass1 tc_A_copy = (TestClass1) (resultSet.getMappingTable().get(tc_A).getMappingTarget());
	TestClass0 tc_B_copy = (TestClass0) (resultSet.getMappingTable().get(tc_B).getMappingTarget());
	TestClass1 tc_C_copy = (TestClass1) (resultSet.getMappingTable().get(tc_C).getMappingTarget());
	TestClass1 tc_D_copy = (TestClass1) (resultSet.getMappingTable().get(tc_D).getMappingTarget());

	// Check internal associations
	assertTrue(((Collection<EObject>) (tc_A_copy.refGetValue("reference1xRefElement"))).contains(tc_D_copy));
	assertTrue(((Collection<EObject>) (tc_B_copy.refGetValue("reference0xRefElement"))).contains(tc_G));

	assertTrue(((Collection<EObject>) (tc_A_copy.refGetValue("reference1Composite"))).contains(tc_C_copy));
	assertTrue(((Collection<EObject>) (tc_C_copy.refGetValue("reference1Composite"))).contains(tc_D_copy));

	// Check external associations
	assertTrue(tc_B.refImmediateComposite().equals(tc_H));

	connection2.revert();
	mp1.delete();
	connection.save();
    }

    @Test
    public void testExternalComposition() throws Exception {

	ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc_A = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_A, tc_B);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	Resource mp1 = getOrCreatePartition("deepCopy1", connection);

	mp1.assignElement(tc_A);
	mp1.assignElement(tc_B);

	connection.save();

	DeepCopyResultSet resultSet = connection2.deepCopy(elementsToBeCopied, testHandler1, true);

	assertTrue(resultSet.getCopyErrors().isEmpty());

	TestClass0 tc_B_copy = (TestClass0) (resultSet.getMappingTable().get(tc_B).getMappingTarget());
	assertTrue(tc_B_copy.refImmediateComposite() != null);

	connection2.revert();
	mp1.delete();
	connection.save();
    }

    @Test
    public void testExternalComposition4Mof() throws Exception {

	ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage(null, new String[] { "Model" }));
	EClass tc_A = (EClass) gpackage1.getEClass().refCreateInstance();
	tc_A.setName("A");
	Attribute tc_B = (Attribute) gpackage1.getAttribute().refCreateInstance();
	tc_B.setName("B");

	Contains ass0Comp = gpackage1.getContains();
	ass0Comp.add(tc_A, tc_B);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		return defaultPolicy;
	    }
	};

	Resource mp1 = getOrCreatePartition("deepCopy1", connection);

	mp1.assignElement(tc_A);
	mp1.assignElement(tc_B);

	connection.save();
	boolean useDeepCopy = true;
	if (useDeepCopy) {
	    DeepCopyResultSet resultSet = connection2.deepCopy(elementsToBeCopied, testHandler1, true);
	    assertEquals(0, resultSet.getCopyErrors().size());
	} else {
	    EPackage gpackage2 = (EPackage) (connection2.getPackage(null, new String[] { "Model" }));
	    Attribute tc_C = (Attribute) gpackage2.getAttribute().refCreateInstance();
	    tc_C.setName("C");
	    Contains ass0Comp2 = gpackage2.getContains();
	    EClass tc_Ax = (EClass) (connection2.getElement(((Partitionable) tc_A).get___Mri()));
	    ass0Comp2.refAddLink(tc_Ax, tc_C);
	}
	connection2.revert();
	mp1.delete();
	connection.save();
    }

    @Test
    public void testExternalComposition4Gfw() throws Exception {

	ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage("sap.com/com/sap/moin/mm/gfw",
		new String[] { "graphics" }));
	Diagram gd = (Diagram) gpackage1.getPictograms().getDiagram().refCreateInstance();
	com.sap.mi.gfw.mm.pictograms.ResourceSet gc =  (com.sap.mi.gfw.mm.pictograms.ResourceSet) gpackage1.getPictograms()
		.getEditingDomain().refCreateInstance();

	// DiagramAggregatesConnections ass0Comp = gpackage1.getPictograms(
	// ).getDiagramAggregatesConnections( );
	gd.getConnections().add(gc);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(gc);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	Resource mp1 = getOrCreatePartition("deepCopy1", connection);

	mp1.assignElement(gd);
	mp1.assignElement(gc);

	connection.save();

	DeepCopyResultSet resultSet = connection2.deepCopy(elementsToBeCopied, testHandler1, true);

	assertTrue(resultSet.getCopyErrors().isEmpty());

	Diagram gd_copy = (Diagram) (resultSet.getMappingTable().get(gd).getMappingTarget());
	com.sap.mi.gfw.mm.pictograms.ResourceSet gc_copy = (com.sap.mi.gfw.mm.pictograms.ResourceSet) (resultSet
		.getMappingTable().get(gc).getMappingTarget());
	assertNotNull(gd_copy);
	assertNotNull(gc_copy);

	connection2.revert();
	mp1.delete();
	connection.save();
    }

    @Test
    public void testWriteLockedPartition() throws Exception {

	ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));

	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");

	TestClass2 tc_B = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc_B.setName("B");

	Assoc2x1 ass2x1 = gpackage1.getAssoc2x1();
	ass2x1.add(tc_B, tc_A);

	Resource mp1 = getOrCreatePartition("deepCopy1", connection);
	Resource mp2 = getOrCreatePartition("deepCopy2", connection);

	mp1.assignElement(tc_A);
	mp2.assignElement(tc_B);

	MRI bMRI = ((Partitionable) tc_B).get___Mri();

	connection.save();

	// acquire write-lock on element A
	tc_B = (TestClass2) connection2.getElement(bMRI);
	tc_B.setName("B2");

	// copy element B; this also changes the link storage on element A, so
	// there should be an exception of some kind
	Collection<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);

	assertTrue(resultSet.getMappingTable().containsKey(tc_A));
	assertTrue(resultSet.getMappingTable().get(tc_A).getMappingTarget() != null);
	assertTrue(resultSet.getMappingTable().containsKey(tc_B));

	connection2.revert();

	mp1.delete();
	mp2.delete();

	for (EObject obj : resultSet.getCopiedElements()) {
	    obj.refDelete();
	}

	connection.save();

    }

    @Test
    public void testRefQuery() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");
	TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_H.setName("H");
	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_H, tc_B);

	// This is actually working!
	assertTrue(ass0Comp.getAssoc0CompositeEndA(tc_B).equals(tc_H));

	Collection<EObject> refRet = ass0Comp.refQuery("assoc0CompositeEndB", tc_B);
	assertSame(1, refRet.size());
	assertEquals(tc_H, refRet.iterator().next());

    }

    @Test
    public void testNonVisibleMri() throws Exception {

	ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass2 tc_B = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc_B.setName("B");

	Assoc1xRefElement ass1xR = gpackage1.getAssoc1xRefElement();

	ass1xR.add(tc_A, tc_B);

	Resource mp1 = getOrCreatePartition("deepCopy1", connection);
	Resource mp2 = getOrCreatePartition("deepCopy2", connection);

	mp1.assignElement(tc_A);
	mp1.assignElement(tc_B);

	try {
	    connection.save();
	} catch (NullPartitionNotEmptyException e) {
	} catch (ReferencedTransientElementsException e) {
	} catch (PartitionsNotSavedException e) {
	}

	Collection<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);

	DeepCopyResultSet resultSet = connection2.deepCopy(elementsToBeCopied, null, true);
	assertTrue(resultSet.getMappingTable().containsKey(tc_B));

	mp1.delete();
	mp2.delete();

	connection.save();

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testIgnoreCompositeParents() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_B.setName("B");
	TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_E.setName("E");
	TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_H.setName("H");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_H, tc_B);

	Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite();
	ass1Comp.add(tc_E, tc_A);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_B);

	DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
		return defaultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, testHandler1, false);

	assertTrue(resultSet.getMappingTable().containsKey(tc_A));
	assertTrue(resultSet.getMappingTable().containsKey(tc_B));
	assertTrue(resultSet.getMappingTable().containsKey(tc_E));
	assertTrue(resultSet.getMappingTable().containsKey(tc_H));

	TestClass1 tc_A_copy = (TestClass1) (resultSet.getMappingTable().get(tc_A).getMappingTarget());
	TestClass0 tc_B_copy = (TestClass0) (resultSet.getMappingTable().get(tc_B).getMappingTarget());

	assertFalse(((Collection<EObject>) (tc_E.refGetValue("reference1Composite"))).contains(tc_A_copy));
	assertFalse(((Collection<EObject>) (tc_H.refGetValue("reference0Composite"))).contains(tc_B_copy));
    }

    /**
     * Test copy of elements from a dirty connection (not persisted)
     */
    @Test
    public void testNonVisibleElements() throws Exception {

	final ResourceSet connectionVar = connection;
	final ResourceSet connection2 = createConnection();
	assertFalse(connection.equals(connection2));

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1().refCreateInstance();
	tc_A.setName("A");
	TestClass2 tc_B = (TestClass2) gpackage1.getTestClass2().refCreateInstance();
	tc_B.setName("B");

	Assoc1xRefElement ass1xR = gpackage1.getAssoc1xRefElement();
	ass1xR.add(tc_A, tc_B);

	TestClass0 tc_C = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_C.setName("C");
	TestClass0 tc_D = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc_D.setName("D");

	Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite();
	ass0Comp.add(tc_C, tc_D);

	Collection<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc_A);
	elementsToBeCopied.add(tc_C);

	DeepCopyPolicyHandler testHandler = new DeepCopyPolicyHandler() {

	    public DeepCopyPolicy getDeepCopyingPolicy(EObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {

		// Check that sourceElements are wrappers in the original
		// connection!
		if (!connectionVar.equals(sourceElement.get___Connection())) {
		    throw new IllegalStateException("sourceElement is not in the original connection!");
		}
		return defaultPolicy;
	    }
	};

	DeepCopyResultSet resultSet = connection2.deepCopy(elementsToBeCopied, testHandler, true);

	assertEquals(3, resultSet.getCopiedElements().size()); // tc_A, tc_C and
							       // tc_D must have
							       // been copied
	assertEquals(1, resultSet.getCopyErrors().size());
	assertSame(DeepCopyError.DeepCopyErrorType.ERR_009, resultSet.getCopyErrors().iterator().next().getErrorType());

	TestClass1 tc_A_copy = (TestClass1) (resultSet.getMappingTable().get(tc_A).getMappingTarget());
	TestClass2 tc_B_copy = (TestClass2) (resultSet.getMappingTable().get(tc_B).getMappingTarget());
	TestClass0 tc_C_copy = (TestClass0) (resultSet.getMappingTable().get(tc_C).getMappingTarget());
	TestClass0 tc_D_copy = (TestClass0) (resultSet.getMappingTable().get(tc_D).getMappingTarget());

	assertEquals("A", tc_A_copy.getName());
	assertNull(tc_B_copy);
	assertEquals("C", tc_C_copy.getName());
	assertEquals("D", tc_D_copy.getName());
	assertEquals(tc_C_copy, tc_D_copy.refImmediateComposite());
    }

    @Test
    public void testCompositeAssocs() {

	// Create a mof class and an Attribute
	EPackage modelPackage = (EPackage) (connection.getPackage(null, new String[] { "Model" }));
	EClass clss = (EClass) modelPackage.getEClass().refCreateInstance();
	clss.setName("TestClass");
	Attribute attr = (Attribute) modelPackage.getAttribute().refCreateInstance();
	attr.setName("TestAttr");

	// Ask for possible composition relationships between Class and
	// Attribute
	Collection<com.sap.tc.moin.repository.mmi.model.Association> comps = connection.getJmiHelper().getCompositeAssociations(
		(EClass) clss.refMetaObject(), (EClass) attr.refMetaObject());
	assertTrue(comps.size() == 1);

	// Use the obtained association to compose the attribute into the class
	if (comps.size() > 0) {
	    com.sap.tc.moin.repository.mmi.model.Association assoc = comps.iterator().next();
	    compose(clss, attr, assoc);
	    assertTrue(clss.getContents().contains(attr));
	}
    }

    private void compose(EObject parent, EObject child, com.sap.tc.moin.repository.mmi.model.Association assoc) {

	com.sap.tc.moin.repository.mmi.model.AssociationEnd ae = connection.getJmiHelper().getCompositeAssociationEnd(assoc);
	// Note that the composition is done using the connection of actualAssoc
	// (connection)
	RefAssociation actualAssoc = connection.getJmiHelper().getRefAssociationForAssociation(assoc);
	if (connection.getJmiHelper().isFirstAssociationEnd(assoc, ae)) {
	    actualAssoc.refAddLink(parent, child);
	} else {
	    actualAssoc.refAddLink(child, parent);
	}
    }

    @Test
    public void testDeepCopyUndo() {

	EPackage gpackage1 = (EPackage) (connection.getPackage(null,
		new String[] { "generatedmetamodel" }));
	TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0.setName("tc0");
	TestClass0 tc0child1 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0child1.setName("tc0child1");
	TestClass0 tc0child2 = (TestClass0) gpackage1.getTestClass0().refCreateInstance();
	tc0child2.setName("tc0child2");

	Assoc0Composite ass0comp = gpackage1.getAssoc0Composite();
	ass0comp.add(tc0, tc0child1);
	ass0comp.add(tc0, tc0child2);

	List<EObject> elementsToBeCopied = new ArrayList<EObject>();
	elementsToBeCopied.add(tc0);

	connection.getCommandStack().clear();
	assertTrue(connection.getCommandStack().getUndoStack().size() == 0);
	DeepCopyResultSet resultSet = connection.deepCopy(elementsToBeCopied, null, true);

	assertTrue(resultSet.getCopiedElements().size() == 3);

	connection.getCommandStack().undo();

	for (EObject ce : resultSet.getCopiedElements()) {
	    assertFalse(((Partitionable) ce).is___Alive());
	}
    }

    @Test
    public void testDeepCopyWithSave() throws Exception {

	Resource myPartition = getOrCreatePartition("One", connection);
	EClass elementToBeCopied = connection.createElementInPartition(EClass.class, myPartition);
	DeepCopyResultSet result = connection.deepCopy(Collections.singletonList((EObject) elementToBeCopied), null, false);
	Collection<EObject> copiedElements = result.getCopiedElements();
	assertEquals(1, copiedElements.size());
	EObject copiedElement = copiedElements.iterator().next();
	copiedElement.assign___Partition(myPartition);
	assertTrue(myPartition.isDirty());
	connection.save();
	DeepCopyMappingEntry deepCopyMappingEntry = result.getMappingTable().get(elementToBeCopied);
	assertEquals(copiedElement, deepCopyMappingEntry.getMappingTarget());
	// clean up
	myPartition.deleteElements();
	connection.save();
    }

    /**
     * Check whether the text field "transUnitId" differs (!) after the copy and
     * all other fields remain the same for translatable text fragments.
     */
    @Test
    public void testTranslatableTextFragmentAttributes() {
	Resource myPartition = getOrCreatePartition("One", connection);
	StructureFieldContainer<TranslatableTextFragment> cont = new StructureFieldContainer<TranslatableTextFragment>();
	TranslatableTextFragment.Descriptors desc = TranslatableTextFragment.DESCRIPTORS;
	// create a text with a given transUnitId
	cont.put(desc.MAX_WIDTH(), 100).put(desc.ORIGINAL_TEXT(), "deep copy test").put(desc.RES_TYPE(), "resType").put(
		desc.TRANSLATE(), true).put(desc.TRANS_UNIT_ID(), "transUnitId");
	A19TranslatableTextFragment text = connection.getPackage(TranslatabletextsPackage.PACKAGE_DESCRIPTOR)
		.createA19TranslatableTextFragment(cont);
	B19Serialization b19Serialization = connection.createElementInPartition(B19Serialization.class, myPartition);
	b19Serialization.setTestTranslatableTextFragment(text);
	// deep copy
	DeepCopyResultSet result = connection.deepCopy(Collections.singletonList((EObject) b19Serialization), null, false);
	Collection<EObject> copiedElements = result.getCopiedElements();
	assertEquals(1, copiedElements.size());
	EObject copiedElement = copiedElements.iterator().next();
	assertTrue(copiedElement instanceof B19Serialization);
	B19Serialization b19SerializationCopied = (B19Serialization) copiedElement;
	// check all fields for equality
	A19TranslatableTextFragment textCopied = b19SerializationCopied.getTestTranslatableTextFragment();
	assertTrue("The max width should be equal, but it isn't.", textCopied.getMaxWidth() == 100);
	assertTrue("The max width should be equal, but it isn't.", textCopied.getOriginalText().equals("deep copy test"));
	assertTrue("The max width should be equal, but it isn't.", textCopied.getResType().equals("resType"));
	assertTrue("The max width should be equal, but it isn't.", textCopied.isTranslate() == true);
	// check whether the "transUnitId" field differs
	assertFalse("The translation unit IDs should differ, but they are equal.", textCopied.getTransUnitId().equals(
		"transUnitId"));
    }

    /**
     * Check whether the text field "transUnitId" differs (!) after the copy and
     * all other fields remain the same for translatable texts.
     */
    @Test
    public void testTranslatableTextAttributes() {
	Resource myPartition = getOrCreatePartition("One", connection);
	StructureFieldContainer<TranslatableText> cont = new StructureFieldContainer<TranslatableText>();
	TranslatableText.Descriptors desc = TranslatableText.DESCRIPTORS;
	// create a text with a given transUnitId
	cont.put(desc.MAX_WIDTH(), 100).put(desc.ORIGINAL_TEXT(), "deep copy test").put(desc.RES_TYPE(), "resType").put(
		desc.TRANSLATE(), true).put(desc.TRANS_UNIT_ID(), "transUnitId").put(desc.RES_NAME(), "resName");
	TranslatableText text = connection.getPackage(TextverticalizationPackage.PACKAGE_DESCRIPTOR).createTranslatableText(cont);
	A1f a1f = connection.createElementInPartition(A1f.class, myPartition);
	a1f.setTranslatableText(text);
	// deep copy
	DeepCopyResultSet result = connection.deepCopy(Collections.singletonList((EObject) a1f), null, false);
	Collection<EObject> copiedElements = result.getCopiedElements();
	assertEquals(1, copiedElements.size());
	EObject copiedElement = copiedElements.iterator().next();
	assertTrue(copiedElement instanceof A1f);
	A1f a1fCopied = (A1f) copiedElement;
	// check all fields for equality
	TranslatableText textCopied = a1fCopied.getTranslatableText();
	assertTrue("The max width should be equal, but it isn't.", textCopied.getMaxWidth() == 100);
	assertTrue("The max width should be equal, but it isn't.", textCopied.getOriginalText().equals("deep copy test"));
	assertTrue("The max width should be equal, but it isn't.", textCopied.getResType().equals("resType"));
	assertTrue("The max width should be equal, but it isn't.", textCopied.isTranslate() == true);
	assertTrue("The max width should be equal, but it isn't.", textCopied.getResName().equals("resName"));
	// check whether the "transUnitId" field differs
	assertFalse("The translation unit IDs should differ, but they are equal.", textCopied.getTransUnitId().equals(
		"transUnitId"));
    }

    /**
     * Check whether the text field "transUnitId" differs (!) after the copy and
     * all other fields remain the same for translatable texts.
     */
    @Test
    public void testTranslatableTextAttributesMulti() {
	Resource myPartition = getOrCreatePartition("One", connection);
	StructureFieldContainer<TranslatableText> cont = new StructureFieldContainer<TranslatableText>();
	TranslatableText.Descriptors desc = TranslatableText.DESCRIPTORS;
	// create button texts with given transUnitIds
	// note that the resType is given by an initializer and is equals to
	// "button"
	cont.put(desc.MAX_WIDTH(), 100).put(desc.TRANSLATE(), true).put(desc.RES_NAME(), "resName");
	cont.put(desc.ORIGINAL_TEXT(), "deep copy test of button1");
	cont.put(desc.TRANS_UNIT_ID(), "transUnitId1");
	ButtonTextF buttonText1 = connection.getPackage(Case004fPackage.PACKAGE_DESCRIPTOR).createButtonTextF(cont);
	cont.put(desc.ORIGINAL_TEXT(), "deep copy test of button2");
	cont.put(desc.TRANS_UNIT_ID(), "transUnitId2");
	ButtonTextF buttonText2 = connection.getPackage(Case004fPackage.PACKAGE_DESCRIPTOR).createButtonTextF(cont);
	B19 b19 = connection.createElementInPartition(B19.class, myPartition);
	b19.getTranslatableButtons().add(buttonText1);
	b19.getTranslatableButtons().add(buttonText2);
	// deep copy
	DeepCopyResultSet result = connection.deepCopy(Collections.singletonList((EObject) b19), null, false);
	Collection<EObject> copiedElements = result.getCopiedElements();
	assertEquals(1, copiedElements.size());
	EObject copiedElement = copiedElements.iterator().next();
	assertTrue(copiedElement instanceof B19);
	B19 b19Copied = (B19) copiedElement;
	// check all fields for equality
	ButtonTextF buttonText1Copied = null;
	ButtonTextF buttonText2Copied = null;
	// determine the right things to compare
	Iterator<ButtonTextF> iterator = b19Copied.getTranslatableButtons().iterator();
	ButtonTextF firstButtonCopied = iterator.next();
	ButtonTextF secondButtonCopied = iterator.next();
	if (firstButtonCopied.getOriginalText().equals("deep copy test of button1")) {
	    buttonText1Copied = firstButtonCopied;
	    buttonText2Copied = secondButtonCopied;
	} else {
	    buttonText2Copied = firstButtonCopied;
	    buttonText1Copied = secondButtonCopied;
	}
	// ok, now we have the copies, compare them with the originals now
	// compare the first button text
	assertTrue("The max width should be equal, but it isn't.", buttonText1Copied.getMaxWidth() == 100);
	assertTrue("The max width should be equal, but it isn't.", buttonText1Copied.getOriginalText().equals(
		"deep copy test of button1"));
	assertTrue("The max width should be equal, but it isn't.", buttonText1Copied.getResType().equals("button"));
	assertTrue("The max width should be equal, but it isn't.", buttonText1Copied.isTranslate() == true);
	assertTrue("The max width should be equal, but it isn't.", buttonText1Copied.getResName().equals("resName"));
	// check whether the "transUnitId" field differs
	assertFalse("The translation unit IDs should differ, but they are equal.", buttonText1Copied.getTransUnitId().equals(
		"transUnitId1"));
	// compare the second button text
	assertTrue("The max width should be equal, but it isn't.", buttonText2Copied.getMaxWidth() == 100);
	assertTrue("The max width should be equal, but it isn't.", buttonText2Copied.getOriginalText().equals(
		"deep copy test of button2"));
	assertTrue("The max width should be equal, but it isn't.", buttonText2Copied.getResType().equals("button"));
	assertTrue("The max width should be equal, but it isn't.", buttonText2Copied.isTranslate() == true);
	assertTrue("The max width should be equal, but it isn't.", buttonText2Copied.getResName().equals("resName"));
	// check whether the "transUnitId" field differs
	assertFalse("The translation unit IDs should differ, but they are equal.", buttonText2Copied.getTransUnitId().equals(
		"transUnitId2"));
    }

}
