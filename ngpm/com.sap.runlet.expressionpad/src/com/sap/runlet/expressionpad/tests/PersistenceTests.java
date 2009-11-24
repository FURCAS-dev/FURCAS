package com.sap.runlet.expressionpad.tests;


import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.ChangeSet;
import com.sap.runlet.abstractinterpreter.repository.ChangeSetImpl;
import com.sap.runlet.abstractinterpreter.repository.FixedSnapshot;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.expressionpad.RunletEvaluator;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.Activator;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class PersistenceTests extends RunletTestCase {
    
    @Override
    protected Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> createRepository() {
	return new TestInMemoryRepository(Activator.getDefault().getModelAdapter());
    }
    
    public void testSimpleCommit() throws Exception {
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
        	"var o = new Organization",
        	"store o",
        	"commit",
        	"all Organization->iterate(Boolean contains=false; i|contains.or(i==o))",
        	"o = new Organization",
        	"all Organization->iterate(Boolean contains=false; i|contains.or(i==o))").getResult();
        assertEquals(6, result.length);
        assertTrue(result[3] instanceof NativeObject);
        assertEquals(true, ((NativeObject) result[3]).getNativeObject());
        assertTrue(result[5] instanceof NativeObject);
        assertEquals(false, ((NativeObject) result[5]).getNativeObject());
    }
        
    public void testCommitAcrossSessions() throws Exception {
        main.execute(
        	"var o = new Organization",
        	"store o",
        	"var p = new Person",
        	"p.name=\"Hercules\"",
        	"o.persons += p",
        	"commit");
        Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository = main.getRepository();
        RunletEvaluator main2 = new RunletEvaluator(main.getConnection(), repository);
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main2.execute(
        	"all Organization.persons->iterate(p|p.name)").getResult();
        assertEquals(1, result.length);
        assertTrue(result[0] instanceof NativeObject);
        assertEquals("Hercules", ((NativeObject) result[0]).getNativeObject());
    }

    
    public void testSnapshotRetrieval() throws Exception {
        main.execute(
        	"var o = new Organization",
        	"var p1 = new Person",
        	"p1.name=\"Jan\"",
        	"var p2 = new Person",
        	"p2.name=\"Axel\"",
        	"o.persons += p1",
        	"store o",
        	"var s1 = commit");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = main.execute(
        	"o.persons += p2", // p2 should become persistent through composition
        	"commit",
        	"o.persons.count",
        	"all[s1] Organization.persons.count",
        	"all[s1] Organization.persons->iterate(Boolean contains=false; p|contains.or(p.name==\"Axel\"))",
        	"all[s1] Organization.persons->iterate(Boolean contains=false; p|contains.or(p.name==\"Jan\"))",
        	"all Organization.persons.count",
        	"all Organization.persons->iterate(Boolean contains=false; p|contains.or(p.name==\"Axel\"))",
        	"all Organization.persons->iterate(Boolean contains=false; p|contains.or(p.name==\"Jan\"))"
        	).getResult();
        assertEquals(9, result2.length);
        assertTrue(result2[3] instanceof NativeObject);
        assertEquals(new Fraction(1), ((NativeObject) result2[3]).getNativeObject());
        assertTrue(result2[4] instanceof NativeObject);
        assertEquals(false, ((NativeObject) result2[4]).getNativeObject());
        assertTrue(result2[5] instanceof NativeObject);
        assertEquals(true, ((NativeObject) result2[5]).getNativeObject());
        assertTrue(result2[6] instanceof NativeObject);
        assertEquals(new Fraction(2), ((NativeObject) result2[6]).getNativeObject());
        assertTrue(result2[7] instanceof NativeObject);
        assertEquals(true, ((NativeObject) result2[7]).getNativeObject());
        assertTrue(result2[8] instanceof NativeObject);
        assertEquals(true, ((NativeObject) result2[8]).getNativeObject());
    }
    
    public void testDeleteOfPersistentInstanceWithInBetweenCommit() throws Exception {
        main.execute(
        	"var p1 = new Person",
        	"p1.name=\"Jan\"",
        	"store p1",
        	"var s1 = commit");
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
    		"delete p1",
    		"commit",
    		"p1.name == \"Jan\"",
    		"all[s1] Person->iterate(Boolean contains=false; p|contains.or(p.name==\"Jan\"))");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = executeResult.getResult();
        assertEquals(4, result2.length);
        assertTrue(result2[2] instanceof NativeObject);
        assertEquals(true, ((NativeObject) result2[2]).getNativeObject());
        assertTrue(result2[3] instanceof NativeObject);
        assertEquals(true, ((NativeObject) result2[3]).getNativeObject());
    }
    
    public void testAllChanged() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
			"var p = new Person",
			"p.name = \"Frank\"",
			"store p",
			"var snapshot1=commit",
			"var p2=new Person",
			"p2.name=\"Axel\"",
			"store p2",
			"var snapshot2=commit",
			"delete p",
			"commit",
			"p.name=\"Frank Mittag\"",
			"commit",
			"all[changed] Person.name").getResult();
	// one Multivalue object
	assertEquals(13, result.length);
	assertTrue(result[12] instanceof MultiValuedObject);
	assertEquals(2, result[12].size());
	assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Axel", "Frank" }, result[12]);
    }
    
    public void testDateAndSnapshot() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
			"var o = new Organization",
			"store o",
			"var s1 = commit",
			"o.persons += new Person",
        		"var s2 = commit",
        		"s1.precedes(s2)",
        		"s1.when().before(s2.when())").getResult();
	// one Multivalue object
	assertEquals(7, result.length);
	assertTrue(result[5] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[5]).getNativeObject());
	assertTrue(result[6] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[6]).getNativeObject());
    }
    
    public void testRetrievalOfLatestByTime() throws Exception {
	main.execute("var o = new Organization", 
		"store o", 
		"commit", 
		"var p = new Person",
		"p.name=\"Jan\"", 
		"o.persons += p", 
		"var s1 = commit");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = main.execute("all[s1.when()] Organization.persons.count")
		.getResult();
	assertEquals(1, result2.length);
	assertTrue(result2[0] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result2[0]).getNativeObject());
    }

    public void testRetrievalOfAllCityEntitiesInAllSnapshots() throws Exception {
	main.execute(
		"var c = new City", 
		"c.name = \"Frankfurt\"", 
		"store c", 
		"commit",
		"c.name = \"Berlin\"", 
		"commit");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("all[all] City.name").getResult();
	// one Multivalue object
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof MultiValuedObject);
	assertEquals(2, result[0].size());
	assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Frankfurt", "Berlin" }, result[0]);
    }

    public void testRetrievalOfAllChangedCityEntities() throws Exception {
	main.execute(
		"var c = new City", 
		"c.name = \"Frankfurt\"", 
		"store c", 
		"commit");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("all[changed] City.name").getResult();
	// one Multivalue object
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof MultiValuedObject);
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> mvo = (MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) result[0];
	assertEquals(1, mvo.size());

	assertEquals("Frankfurt", ((NativeObject) mvo.iterator().next()).getNativeObject());
    }

    public void testRetrievalOfAllChangedCityEntities2() throws Exception {
	main.execute(
		"var c = new City", 
		"c.name = \"Frankfurt\"", 
		"store c", 
		"commit",
		"c.name = \"Berlin\"", 
		"commit", 
		"var p = new Person", // here we
		"store p", // create a
		"commit"); // new snapshot without any change to City
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("all[changed] City.name").getResult();
	// one Multivalue object
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof MultiValuedObject);
	assertEquals(2, result[0].size());
	assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Frankfurt", "Berlin" }, result[0]);
    }

    public void testRetrievalOfAllChangedCityEntities3() throws Exception {
	main.execute(
		"var c = new City", 
		"c.name = \"Frankfurt\"", 
		"store c", 
		"commit",
		"var p = new Person", // here we
		"store p", // create a
		"commit", // new snapshot without any change to City
		"c.name = \"Berlin\"", 
		"commit");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("all[changed] City.name").getResult();
	// one Multivalue object
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof MultiValuedObject);
	assertEquals(2, result[0].size());
	assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Frankfurt", "Berlin" }, result[0]);
    }

    public void testRetrievalOfAllChangedOrganizationEntities() throws Exception {
	main.execute(
		"var o = new Organization", 
		"store o", "commit", 
		"o.persons += new Person",
		"commit");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("all[changed] Organization").getResult();
	// one Multivalue object
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof MultiValuedObject);
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> mvo = (MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) result[0];
	assertEquals(2, mvo.size());
    }
    
    public void testNoSnapshot() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"\"just a string\"->snapshot()").getResult();
	assertEquals(1, result.length);
	assertEquals(0, result[0].size());
    }

    public void testSnapshotExpression() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var c = new City",
		"store c",
		"var s1 = commit",
		"c.name = \"Home\"",
		"var s2 = commit",
		"s1.precedes(s2)",
		"all[s1] City->snapshot()->iterate(si|si.precedes(s2))").getResult();
	assertEquals(7, result.length);
	assertNOEquals(Boolean.TRUE, result[5]);
	assertNOEquals(Boolean.TRUE, result[6]);
    }
    
    public void testCommitEvalutesToSnapshotInAllStatement() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
		"var c = new City",
		"c.name = \"test\"",
		"store c",
		"all[commit] City");
	assertEquals(0, executeResult.getErrors().length);
	assertEquals(4, executeResult.getResult().length);
    }

    public void testEmptyCommit() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var s = commit");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
    }
    
    public void testEmptyAllQueries() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "all City",
            "all City.count",
            "all City.name.count");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        
        assertTrue(result[0] instanceof MultiValuedObject);
        assertNOEquals(new Fraction(0), result[1]);
        assertNOEquals(new Fraction(0), result[2]);
    }

    /**
     * Tests reading in an entity from an old snapshot, then navigating across a link to
     * an entity object which was modified in a newer snapshot and asserts that the old copy
     * was not modified, meaning the navigation remains within the old snapshot.
     */
    public void testChangingInCurrentSnapshotOnly() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=new Organization",
            "var p=new Person",
            "p.name=\"Daniel\"",
            "o.persons+=p",
            "store o",
            "var snapshot1=commit",
            "var p2=new Person",
            "p2.name=\"Axel\"",
            "o.persons+=p2",
            "var snapshot2=commit",
            "var o_old=all[snapshot1] Organization->iterate(o|o)",
            "var o_new=all[snapshot2] Organization->iterate(o|o)",
            "var o_current=all Organization->iterate(o|o)",
            "o_current.persons.name=\"AllEqual\"",
            "commit",
            "o_old.persons.name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(16, result.length);
        assertEquals(3, errors.length); // expecting four OutputMultiplicities issues right now
        assertTrue(result[15] instanceof MultiValuedObject);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Daniel" }, result[15]);
    }
    
    public void testStoreThroughValueWithEntity() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var p1=new Person",
            "var c1=new City",
            "c1.name=\"Mannheim\"",
            "p1.addresses+=value Address(city: c1, street: \"C1,17\")",
            "p1.addresses.city.name",
            "store p1",
            "commit",
            "all City.count",
            "all City.name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(9, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(1), result[7]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Mannheim" }, result[8]);
    }

    public void testModifyTransitivelyStoredEntities() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var p=new Person",
            "var c=new City",
            "c.name=\"Mannheim\"",
            "p.addresses+=value Address(city:c, street: \"C1,19\")",
            "store p",
            "var s1=commit",
            "c.name=\"Monnem\"",
            "var s2=commit",
            "all Person.addresses.city.name",
            "all[s1] Person.addresses.city.name",
            "all[s1] City.name",
            "all[s2] City.name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(12, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Monnem" }, result[8]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Mannheim" }, result[9]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Mannheim" }, result[10]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Monnem" }, result[11]);
    }

    public void testAsymmetricLinkLoading() throws Exception {
	Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> rep =
	    new RunletInMemoryRepository(Activator.getDefault().getModelAdapter());
	RunletEvaluator main1 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult1 = main1.execute(
            "var c1=new City",
            "var p=new Person",
            "c1.name=\"Mannheim\"",
            "p.addresses+=value Address(city:c1, street: \"C1,19\")",
            "store p",
            "var s1=commit");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result1 = executeResult1.getResult();
        assertEquals(6, result1.length);
        RunletEvaluator main2 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult2 = main2.execute(
        	"var p=all Person->iterate(p|p)",
                "var c2=new City",
                "c2.name=\"Heidelberg\"",
                "p.addresses = p.addresses->replace(city=c2)",
        	"p.addresses.city.name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = executeResult2.getResult();
        assertEquals(5, result2.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Heidelberg" }, result2[4]);
    }

    public void testDeleteFromCurrentSnapshot() throws Exception {
	Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> rep =
	    new RunletInMemoryRepository(Activator.getDefault().getModelAdapter());
	RunletEvaluator main1 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult1 = main1.execute(
                "var q = new Quotation",
                "var p = new Person",
                "q.responsibleEmployee = p",
                "store q",
                "commit");
            RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result1 = executeResult1.getResult();
            assertEquals(5, result1.length);
    	RunletEvaluator main2 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult2 = main2.execute(
            "all Quotation.count",
            "delete all Quotation",
            "all Quotation.count",
            "commit",
            "all Quotation.count");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = executeResult2.getResult();
        assertEquals(5, result2.length);
        assertNOEquals(new Fraction(1), result2[0]);
        assertNOEquals(new Fraction(0), result2[2]);
        assertNOEquals(new Fraction(0), result2[4]);
    }

    public void testReSetting0To1EndBetweenEntities() throws Exception {
	Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> rep = new RunletInMemoryRepository(Activator.getDefault().getModelAdapter());
	RunletEvaluator main1 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult1 = main1.execute(
            "var q=new Quotation",
            "var p=new Person",
            "p.name=\"Axel\"",
            "q.responsibleEmployee=p",
            "store q",
            "store p",
            "commit");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result1 = executeResult1.getResult();
        assertEquals(7, result1.length);
        RunletEvaluator main2 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult2 = main2.execute(
        	"var p2=new Person",
                "p2.name=\"Jan\"",
                "store p2",
                "Quotation q=all Quotation->iterate(q|q)",
                "q.responsibleEmployee=p2",
                "q.responsibleEmployee.count",
                "q.responsibleEmployee.name.count",
                "q.responsibleEmployee.name",
        	"commit",
        	"q.responsibleEmployee.name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = executeResult2.getResult();
        assertEquals(10, result2.length);
        assertNOEquals(new Fraction(1), result2[5]);
        assertNOEquals(new Fraction(1), result2[6]);
        assertNOEquals("Jan", result2[7]);
        assertNOEquals("Jan", result2[9]);
        RunletEvaluator main3 = new RunletEvaluator("ngpm.stdlib", rep);
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult3 = main3.execute(
                "Quotation q=all Quotation->iterate(q|q)",
                "q.responsibleEmployee.name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result3 = executeResult3.getResult();
        assertEquals(2, result3.length);
        assertNOEquals("Jan", result3[1]);
    }

    public void testSimpleBranching() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var p=new Person",
            "p.name=\"Axel\"",
            "store p",
            "var ss1=commit",
            "p.name=\"Axel Uhl\"",
            "var ss2=commit",
            "var q=all[ss1] Person->iterate(i|i)",
            "q.name=\"Uhl, Axel\"",
            "var ss3=commit",
            "ss2.precedes(ss3)",
            "ss3.precedes(ss2)",
            "ss1.precedes(ss2)",
            "ss1.precedes(ss3)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(13, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(false, result[9]);
        assertNOEquals(false, result[10]);
        assertNOEquals(true, result[11]);
        assertNOEquals(true, result[12]);
    }
    
    public void testSnapshotAncestorDetermination() {
	Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> r = main.getInterpreter().getRepository();
	SnapshotIdentifier base = main.getInterpreter().getDefaultSnapshot();
	ChangeSet<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> cs1 = new ChangeSetImpl<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(main.getInterpreter().getModelAdapter());
	Snapshot ss1 = r.apply(cs1, base);
	ChangeSet<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> cs2 = new ChangeSetImpl<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(main.getInterpreter().getModelAdapter());
	Snapshot ss2 = r.apply(cs2, base);
	assertEquals(base.getSnapshot(), r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2 }).get(0).get(0));
	assertEquals(base.getSnapshot(), r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2 }).get(1).get(0));
	ChangeSet<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> cs3 = new ChangeSetImpl<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(main.getInterpreter().getModelAdapter());
	Snapshot ss3 = r.apply(cs3, new FixedSnapshot(ss2));
	assertEquals(base.getSnapshot(), r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(0).get(0));
	assertEquals(ss1, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(0).get(1));
	assertEquals(base.getSnapshot(), r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(1).get(0));
	assertEquals(ss2, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(1).get(1));
	assertEquals(base.getSnapshot(), r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(2).get(0));
	assertEquals(ss2, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(2).get(1));
	assertEquals(ss3, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss1, ss2, ss3 }).get(2).get(2));
	assertEquals(ss2, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss2, ss3 }).get(0).get(0));
	assertEquals(ss2, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss2, ss3 }).get(1).get(0));
	assertEquals(ss3, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss2, ss3 }).get(1).get(1));
	assertEquals(ss2, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss3, ss2 }).get(0).get(0));
	assertEquals(ss3, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss3, ss2 }).get(0).get(1));
	assertEquals(ss2, r.getPathsFromLastCommonAncestor(new Snapshot[] { ss3, ss2 }).get(1).get(0));
    }
    
    public void testAddingLinkToExistingButNotYetLoadedLinkCollection() throws Exception {
        main.execute(
        	"var o = new Organization",
        	"store o",
        	"var p = new Person",
        	"p.name=\"Hercules\"",
        	"o.persons += p",
        	"commit");
        Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository = main.getRepository();
        RunletEvaluator main2 = new RunletEvaluator(main.getConnection(), repository);
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = main2.execute(
            	"var o = all Organization",
            	"var p2 = new Person",
            	"p2.name=\"The Other\"",
            	"o.persons += p2",
            	"o.persons.name.count",
            	"o.persons.name",
            	"commit").getResult();
        assertEquals(7, result2.length);
        assertTrue(result2[4] instanceof NativeObject);
        assertNOEquals(new Fraction(2), result2[4]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Hercules", "The Other" }, result2[5]);
        RunletEvaluator main3 = new RunletEvaluator(main.getConnection(), repository);
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result3 = main3.execute(
            	"var o = all Organization",
            	"o.persons.name.count",
            	"o.persons.name").getResult();
        assertEquals(3, result3.length);
        assertTrue(result3[1] instanceof NativeObject);
        assertNOEquals(new Fraction(2), result3[1]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Hercules", "The Other" }, result3[2]);
    }
    
    public void testSnapshotMerge() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=new OrderedAssocTest",
            "store o",
            "var ss1=commit",			
            "o.orderedStrings+=\"a\"",
            "var ss2=commit",
            "var oo=all[ss1] OrderedAssocTest",
            "oo.orderedStrings+=\"b\"",  // this statement causes a constraint violation - strange..
            "var ss3=commit",
            "ss1.precedes(ss2)",
            "ss1.precedes(ss3)",
            "ss2.precedes(ss3)",
            "ss3.precedes(ss2)",
            "var ss4=ss3.resolve(ss2)",
            "var ooo=all[ss4] OrderedAssocTest",
            "ooo.orderedStrings",
            "var ss5=ss2.resolve(ss3)",
            "var oooo=all[ss5] OrderedAssocTest",
            "oooo.orderedStrings",
            "ss3.precedes(ss4)",
            "ss2.precedes(ss4)",
            "ss1.precedes(ss4)",
            "ss4.equals(ss5)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        assertEquals(22, result.length);
        
        assertNOEquals(true,  result[8]);	// "ss1.precedes(ss2)"
        assertNOEquals(true,  result[9]);  	// "ss1.precedes(ss3)"
        assertNOEquals(false, result[10]);	// "ss2.precedes(ss3)"
        assertNOEquals(false, result[11]);	// "ss3.precedes(ss2)"
        
        assertNOEquals(true,  result[18]);	// "ss3.precedes(ss4)"
        assertNOEquals(true,  result[19]);	// "ss2.precedes(ss4)"
        assertNOEquals(true,  result[20]);	// "ss1.precedes(ss4)"
        assertNOEquals(true,  result[21]);	// "ss4.equals(ss5)"
    }

    public void testEqualityOfSnapshotsUsingTwoMergeChangeSets() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=new OrderedAssocTest",
            "store o",
            "var ss1=commit",			
            "o.orderedStrings+=\"a\"",
            "var ss2=commit",
            "var oo=all[ss1] OrderedAssocTest",
            "oo.orderedStrings+=\"b\"",  // this statement causes a constraint violation - strange..
            "var ss3=commit",
            "ss1.precedes(ss2)",
            "ss1.precedes(ss3)",
            "ss2.precedes(ss3)",
            "ss3.precedes(ss2)",
            "var ss4=ss3.resolve(ss2)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        assertEquals(13, result.length);
        
        assertNOEquals(true,  result[8]);	// "ss1.precedes(ss2)"
        assertNOEquals(true,  result[9]);  	// "ss1.precedes(ss3)"
        assertNOEquals(false, result[10]);	// "ss2.precedes(ss3)"
        assertNOEquals(false, result[11]);	// "ss3.precedes(ss2)"
        
        TestInMemoryRepository rep = (TestInMemoryRepository) main.getInterpreter().getRepository();
        Snapshot ss3 = (Snapshot) ((NativeObject) main.getStackFrame().getAllVisibleVariableValues().get(
		"ss3")).getNativeObject();
        Snapshot ss4 = (Snapshot) ((NativeObject) main.getStackFrame().getAllVisibleVariableValues().get(
		"ss4")).getNativeObject();
        rep.doesChangeSetProduceEqualResults(ss3, ss4);
    }
}
