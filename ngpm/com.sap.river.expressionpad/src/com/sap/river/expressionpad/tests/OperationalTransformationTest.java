package com.sap.river.expressionpad.tests;

import java.util.Iterator;

import junit.framework.TestCase;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.river.expressionpad.Main;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.Link;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;
import com.sap.river.interpreter.operationaltransformation.Change;
import com.sap.river.interpreter.operationaltransformation.Transformer;
import com.sap.river.interpreter.repository.ChangeSetImpl;
import com.sap.river.interpreter.repository.EntityCreation;
import com.sap.river.interpreter.repository.EntityDeletion;
import com.sap.river.interpreter.repository.LinkChange;
import com.sap.river.interpreter.repository.LinkCreation;
import com.sap.river.interpreter.repository.LinkDeletion;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.RepositoryChange;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.shared.util.Tuple.Triple;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;

public class OperationalTransformationTest extends TestCase {
    
    protected Main main1;
    protected Main main2;
    private ClassTypeDefinition stringClassTypeDefinitionExactlyOneForMain1;
    private ClassTypeDefinition stringClassTypeDefinitionExactlyOneForMain2;
    private ClassTypeDefinition numberClassTypeDefinitionExactlyOneForMain1;
    private ClassTypeDefinition numberClassTypeDefinitionExactlyOneForMain2;

    protected void setUp() throws Exception {
	super.setUp();
	Repository r = new InMemoryRepository();
	main1 = new Main("ngpm.stdlib", r);
	main2 = new Main("ngpm.stdlib", r);
	stringClassTypeDefinitionExactlyOneForMain1 = MetamodelUtils.createClassTypeDefinitionExactlyOne(main1.getConnection(),
		MetamodelUtils.findClass(main1.getConnection(), "String"));
	stringClassTypeDefinitionExactlyOneForMain1.assign___PartitionIncludingChildren(getTransientPartition(main1
		.getConnection()));
	stringClassTypeDefinitionExactlyOneForMain2 = MetamodelUtils.createClassTypeDefinitionExactlyOne(main2.getConnection(),
		MetamodelUtils.findClass(main1.getConnection(), "String"));
	stringClassTypeDefinitionExactlyOneForMain2.assign___PartitionIncludingChildren(getTransientPartition(main2
		.getConnection()));
	numberClassTypeDefinitionExactlyOneForMain1 = MetamodelUtils.createClassTypeDefinitionExactlyOne(main1.getConnection(), 
		MetamodelUtils.findClass(main1.getConnection(), "Number"));
	numberClassTypeDefinitionExactlyOneForMain1.assign___PartitionIncludingChildren(getTransientPartition(main1.getConnection()));
	numberClassTypeDefinitionExactlyOneForMain2 = MetamodelUtils.createClassTypeDefinitionExactlyOne(main2.getConnection(), 
		MetamodelUtils.findClass(main2.getConnection(), "Number"));
	numberClassTypeDefinitionExactlyOneForMain2.assign___PartitionIncludingChildren(getTransientPartition(main2.getConnection()));
    }
    
    public void testNoChangesFromServerOrClient() {
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	assertEquals(p.getA().totalSize(), 0);
	assertEquals(p.getB().totalSize(), 0);
    }
    
    public void testRedundantEntityDelete() throws Exception {
	RiverObject[] result1 = main1.execute("var p=new Person", "store p", "commit").getResult();
	assertEquals(3, result1.length);
	
	// delete person
 	result1 = main1.execute("delete p").getResult();
 	assertEquals(1, result1.length);
 	
 	// redundant delete
 	RiverObject[] result2 = main2.execute("var p = all Person", "delete p").getResult();
	assertEquals(2, result2.length);
	
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	// both change lists should be empty as the delete is redundant
	assertEquals(p.getA().totalSize(), 0);
	assertEquals(p.getB().totalSize(), 0);
    }

    @SuppressWarnings("unchecked")
    public void testCreateTwoEntities() throws Exception {
 	RiverObject[] result1 = main1.execute("var p=new Person", "store p").getResult();
	RiverObject[] result2 = main2.execute("var p=new Person", "store p").getResult();
	assertEquals(2, result1.length);
	assertEquals(2, result2.length);
	
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null)
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null)
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }
    
    @SuppressWarnings("unchecked")
    public void testCreateLinkDeleteEntity() throws Exception {
	// create, store and commit a Person entity
	RiverObject[] result1 = main1.execute("var p=new Person", "store p", "commit").getResult();
	assertEquals(3, result1.length);
	
	// delete but do not commit Person entity
 	result1 = main1.execute("delete p").getResult();
 	assertEquals(1, result1.length);
 	
 	// Create and store Organization Entity with new link created to Person entity
	RiverObject[] result2 = main2.execute("var o=new Organization", "o.persons += all Person", "store o").getResult();
	assertEquals(3, result2.length);
	
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, null, null),
		new Triple<Class<?>, Integer, String>(EntityDeletion.class, null, null)
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null)
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }

    /**
     * In two separate change sets creates a link each to be added to an ordered association on the
     * same entity object on the unordered end. We expect that for client and server we get the same
     * ordering of links eventually. The server link should precede the client link consistently.
     */
    @SuppressWarnings("unchecked")
    public void testCreateCompetingOrderedLinks() throws Exception {
	RiverObject[] result1 = main1.execute("var o=new OrderedAssocTest", "store o", "commit").getResult();
	assertEquals(3, result1.length);
	
 	result1 = main1.execute("var p=new Person", "p.name=\"name1\"", "store p",
 				"all OrderedAssocTest.orderedPersons += p").getResult();
 	assertEquals(4, result1.length);
 	
 	// Create and store Organization Entity with new link created to Person entity
 	// TODO: I assume that I see the changes commited by main1 (the Person). Not sure if this is the case.
 	// The resulting changeSet for main2 only contains an Entity Creation but no link creation. Time is running out
 	// need to check this after vacation ;)
	RiverObject[] result2 = main2.execute("var p=new Person", "p.name=\"name2\"", "store p",
		"all OrderedAssocTest.orderedPersons += p").getResult();
	assertEquals(4, result2.length);
	
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, null, null),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, null)
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, null, null),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 0, null)
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }

    @SuppressWarnings("unchecked")
    public void testDeleteEntityAndAddOrderedLinks() throws Exception {
	// create, store and commit a Person and an OrderedAssocTest entity with ordered link between
	RiverObject[] result1 = main1.execute("var o=new OrderedAssocTest", "store o", "var p=new Person",
		"p.name=\"name1\"", "store p", "o.orderedPersons += p", "commit").getResult();
	assertEquals(7, result1.length);
	
 	result1 = main1.execute("delete p").getResult();
 	assertEquals(1, result1.length);
 	
 	// Create and store a second OrderedAssocTest and add a link to the first person being
 	// deleted by the second change set on main1 (above). Then add a link to another new person p2.
 	// This link creation should initially be recorded to be at second position (index 1)
 	// but should then get re-numbered because the first link creation will be canceled.
	RiverObject[] result2 = main2.execute("var o=all OrderedAssocTest->iterate(i|i)",
		"var p=o.orderedPersons->iterate(j|j)",
		"var o2=new OrderedAssocTest",
		"store o2",
		"o2.orderedPersons += p",
		"var p2=new Person", "p2.name=\"name2\"", "store p2",
		"o2.orderedPersons += p2").getResult();
	assertEquals(9, result2.length);
	
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, null, null), // p.name
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 0, null), // o.orderedPersons += p
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 0, null), // o2.orderedPersons += p
		new Triple<Class<?>, Integer, String>(EntityDeletion.class, null, null)
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null), // o2
		new Triple<Class<?>, Integer, String>(EntityCreation.class, null, null), // p2
		new Triple<Class<?>, Integer, String>(LinkCreation.class, null, null), // name2
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 0, null) // += p2
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }

    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testSpecificConcurrentChangesToOrderedAssociation() throws Exception {
	// create, store and commit a Person and an OrderedAssocTest entity with ordered link between
	RiverObject[] result1 = main1.execute("var o=new OrderedAssocTest", "store o", "o.orderedStrings += \"a\"",
		"o.orderedStrings += \"b\"", "o.orderedStrings += \"c\"",
		"commit").getResult();
	assertEquals(6, result1.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject o = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("o");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 1, "d");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 1, "e");
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 3, "b");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 4, "f");
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 3, "g");
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "c");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "h");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 1, "i");

	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 2, "d"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 2, "e"),
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 4, "b"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 6, "f")
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 4, "g"),
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 3, "c"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 3, "h"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, "i")
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }

    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testOrderedLinkCreationAndDeletion() throws Exception {
	// create, store and commit a Person and an OrderedAssocTest entity with ordered link between
	RiverObject[] result1 = main1.execute("var o=new OrderedAssocTest", "store o", "o.orderedStrings += \"a\"",
		"o.orderedStrings += \"b\"", "o.orderedStrings += \"c\"",
		"commit").getResult();
	assertEquals(6, result1.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject o = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("o");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 0, "a");
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 0, "b");
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 0, "c");
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 0, "h");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "o");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "l");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "l");

	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 1, "a"),
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 4, "b"),
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 4, "c")
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 0, "h"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, "o"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, "l"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, "l")
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }
    
    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testOrderedLinkCreationAndDeletion2() throws Exception {
	// create, store and commit a Person and an OrderedAssocTest entity with ordered link between
	RiverObject[] result1 = main1.execute("var o=new OrderedAssocTest", "store o", "o.orderedStrings += \"a\"",
		"commit").getResult();
	assertEquals(4, result1.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject o = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("o");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 0, "b");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 1, "c");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 3, "d");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 4, "e");
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 0, "a");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 0, "f");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 1, "g");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "h");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 3, "i");

	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 4, "b"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 5, "c"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 6, "d"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 7, "e")
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 2, "a"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 0, "f"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, "g"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 2, "h"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 3, "i")
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }

    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testOrderedLinkCreationAndDeletion3() throws Exception {
	// create, store and commit a Person and an OrderedAssocTest entity with ordered link between
	RiverObject[] result1 = main1.execute("var o=new OrderedAssocTest", "store o", "o.orderedStrings += \"a\"",
		"commit").getResult();
	assertEquals(4, result1.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject o = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("o");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 0, "b");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 1, "c");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 3, "d");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, clientChanges, o, 4, "e");
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 0, "f");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 1, "g");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 3, "h");
	addOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 4, "i");
	deleteOrderedLinkToString(i, stringClassTypeDefinitionExactlyOneForMain1, serverChanges, o, 2, "a");

	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 2, "b"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 3, "c"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 6, "d"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 7, "e")
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 0, "f"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 1, "g"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 5, "h"),
		new Triple<Class<?>, Integer, String>(LinkCreation.class, 6, "i"),
		new Triple<Class<?>, Integer, String>(LinkDeletion.class, 4, "a")
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }
    
    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testUniqueLinkCreation() throws Exception {
	// create, store and commit a Person and an UniquenessTest entity with ordered link between
	RiverObject[] result = main1.execute("var u=new UniquenessTest", "store u", "u.numbers += 1",
		"u.numbers += 2", "u.numbers += 3",
		"commit").getResult();
	assertEquals(6, result.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject u = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("u");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(4));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(5));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(6));
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(7));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(8));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(9));
	
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(4)),
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(5)),
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(6))
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(7)),
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(8)),
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(9))
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }
    
    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testRedundantUniqueLinkCreation() throws Exception {
	// create, store and commit a Person and an UniquenessTest entity with ordered link between
	RiverObject[] result = main1.execute("var u=new UniquenessTest", "store u", "u.numbers += 1",
		"u.numbers += 2", "u.numbers += 3",
		"commit").getResult();
	assertEquals(6, result.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject u = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("u");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(4));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(5));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(6));
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(4));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(8));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(9));
	
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(5)),
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(6))
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(8)),
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(9))
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }
    
    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testRedundantUniqueLinkDeletion() throws Exception {
	// create, store and commit a Person and an UniquenessTest entity with ordered link between
	RiverObject[] result = main1.execute("var u=new UniquenessTest", "store u", "u.numbers += 1",
		"u.numbers += 2", "u.numbers += 3",
		"commit").getResult();
	assertEquals(6, result.length);
	
	RiverInterpreter i = main1.getInterpreter();
	ClassTypedObject u = (ClassTypedObject) main1.getStackFrame().getAllVisibleVariableValues().get("u");
	ChangeSetImpl clientChanges = new ChangeSetImpl();
	deleteUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(3));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain1, clientChanges, u, new Fraction(4));
	ChangeSetImpl serverChanges = new ChangeSetImpl();
	deleteUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(3));
	addUniqueLinkToNumber(i, numberClassTypeDefinitionExactlyOneForMain2, serverChanges, u, new Fraction(5));
	
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(clientChanges, serverChanges);
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(4))
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Fraction, Fraction>(LinkCreation.class, null, new Fraction(5))
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }

    @SuppressWarnings("unchecked") // need array of generic Triple class
    public void testRedundantLinkDeletion() throws Exception {
	// create, store and commit a Person and an OrderedAssocTest entity with ordered link between
	RiverObject[] result1 = main1.execute("var o=new Organization", "store o", "o.persons += new Person",
		"commit").getResult();
	assertEquals(4, result1.length);
	
 	result1 = main1.execute("var p=all Person->iterate(i|i)",
		"delete p").getResult();
 	assertEquals(2, result1.length);
 	
 	// Create and store a second OrderedAssocTest and add a link to the first person being
 	// deleted by the second change set on main1 (above). Then add a link to another new person p2.
 	// This link creation should initially be recorded to be at second position (index 1)
 	// but should then get re-numbered because the first link creation will be canceled.
	RiverObject[] result2 = main2.execute("var o=all Organization->iterate(i|i)",
		"delete o").getResult();
	assertEquals(2, result2.length);
	
	ChangeSetImpl cs1 = main1.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	ChangeSetImpl cs2 = main2.getInterpreter().getTransactionBuffer().getChangeSetImpl();
	Transformer t = new Transformer();
	Pair<Change, Change> p = t.transform(cs1, cs2);
	
	Change serverResult = p.getB();
	Triple<Class<?>, Integer, String>[] expectedServerResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityDeletion.class, null, null)
	};
	assertChanges(expectedServerResult, serverResult, Side.LEFT);
	Change clientResult = p.getA();
	Triple<Class<?>, Integer, String>[] expectedClientResult = new Triple[] {
		new Triple<Class<?>, Integer, String>(EntityDeletion.class, null, null)
	};
	assertChanges(expectedClientResult, clientResult, Side.LEFT);
    }
    
    public void testSnapshortMerge() throws Exception {
	RiverObject[] serverResult = null;
	RiverObject[] clientResult = null;
	
	// create a Person entity in server session and commit creation
	serverResult = main1.execute("var p1=new Person", "store p1", "commit").getResult();
	assertEquals(3, serverResult.length);
	
	// create a 2nd Person entity in server session, no commit yet
	serverResult = main1.execute("var p2=new Person", "store p2").getResult();
	assertEquals(2, serverResult.length);
	
	// create a 3rd Person entity in client session, no commit yet
	clientResult = main2.execute("var p3=new Person", "store p3").getResult();
	assertEquals(2, clientResult.length);
	
	// commit server session
	serverResult = main1.execute("commit").getResult();
	assertEquals(1, serverResult.length);
	
	// commit client session
	clientResult = main2.execute("commit").getResult();
	assertEquals(1, clientResult.length);
	
	// server session should see three person entities
	serverResult = main1.execute("all Person.count").getResult();
	assertEquals(1, serverResult.length);
	
	// client session should see three person entities
	clientResult = main2.execute("all Person.count").getResult();
	assertEquals(1, clientResult.length);
    }

    /**
     * If a link change is expected and a non-<tt>null</tt> String is provided in the expected
     * results, that string is compared with the value on the ordered end of the link.
     */
    private void assertChanges(Triple<Class<?>, Integer, String>[] expectedClientResult, Change changeSetToCheck, Side side) {
	Iterator<RepositoryChange> iter = changeSetToCheck.iterator();
	for (int i=0; i<expectedClientResult.length; i++) {
	    if (!iter.hasNext()) {
		fail("change set "+changeSetToCheck+" contains fewer (only "+i+") than the expected "+
			expectedClientResult.length+" changes");
	    }
	    RepositoryChange change = iter.next();
	    assertEquals("Class " + change.getClass().getName() + " for " + (i + 1) + getOrdinalSuffix(i + 1)
		    + " change does not match expected class " + expectedClientResult[i].getA().getName(),
		    expectedClientResult[i].getA(),
		    change.getClass());

	    // further checks for link creation
	    if (change instanceof LinkCreation) {
		// do check for value
		if (expectedClientResult[i].getC() != null) {
		    Object objectOnLink = ((NativeObject) ((LinkChange) change).getObject().get(side)).getNativeObject();
		    assertEquals("value mismatch for " + (i + 1) + getOrdinalSuffix(i + 1) + " change", expectedClientResult[i].getC(),
			    objectOnLink);
		}
		// do check for position
		if (expectedClientResult[i].getB() != null) {
		    assertEquals("position mismatch for " + (i + 1) + getOrdinalSuffix(i + 1) + " change", expectedClientResult[i].getB(),
			    ((LinkChange) change).getPosition());
		}
	    }
	}
    }

    private String getOrdinalSuffix(int i) {
	if (i==1) {
	    return "st";
	} else if (i==2) {
	    return "nd";
	} else if (i==3) {
	    return "rd";
	} else {
	    return "th";
	}
    }

    private void deleteOrderedLinkToString(RiverInterpreter interpreter, ClassTypeDefinition stringClassTypeDefinition,
	    ChangeSetImpl clientChanges, ClassTypedObject o, int at, String string) {
	ValueObject stringAsValueObject = new NativeObject(stringClassTypeDefinition, string,
		interpreter.getDefaultSnapshot(), interpreter);
	SapClass oat = MetamodelUtils.findClass(interpreter.getConnection(), "OrderedAssocTest");
	Association a = null;
	for (AssociationEnd ae : oat.getAssociationEnds()) {
	    if (ae.otherEnd().getName().equals("orderedStrings")) {
		a = ae.getAssociation();
	    }
	}
	if (a == null) {
	    throw new RuntimeException("Couldn't find association for association end \"orderedStrings\" on class OrderedAssocTest");
	}
	Link l = new Link(stringAsValueObject, o, a, interpreter.getDefaultSnapshot());
	clientChanges.linkDeleted(l, at);
    }

    private void addOrderedLinkToString(RiverInterpreter interpreter, ClassTypeDefinition stringClassTypeDefinition,
	    ChangeSetImpl clientChanges, ClassTypedObject o, int at, String string) {
	ValueObject stringAsValueObject = new NativeObject(stringClassTypeDefinition, string,
		interpreter.getDefaultSnapshot(), interpreter);
	SapClass oat = MetamodelUtils.findClass(interpreter.getConnection(), "OrderedAssocTest");
	Association a = null;
	for (AssociationEnd ae : oat.getAssociationEnds()) {
	    if (ae.otherEnd().getName().equals("orderedStrings")) {
		a = ae.getAssociation();
	    }
	}
	if (a == null) {
	    throw new RuntimeException("Couldn't find association for association end \"orderedStrings\" on class OrderedAssocTest");
	}
	Link l = new Link(stringAsValueObject, o, a, interpreter.getDefaultSnapshot());
	clientChanges.linkCreated(l, at);
    }
    
    private void addUniqueLinkToNumber(RiverInterpreter interpreter, ClassTypeDefinition numberClassTypeDefinition,
	    ChangeSetImpl clientChanges, ClassTypedObject o, Fraction number) {
	ValueObject numberAsValueObject = new NativeObject(numberClassTypeDefinition, number, interpreter.getDefaultSnapshot(), interpreter);
	SapClass ut = MetamodelUtils.findClass(interpreter.getConnection(), "UniquenessTest");
	Association a = null;
	for (AssociationEnd ae : ut.getAssociationEnds()) {
	    if (ae.otherEnd().getName().equals("numbers")) {
		a = ae.getAssociation();
	    }
	}
	if (a == null) {
	    throw new RuntimeException("Couldn't find association for association end \"numbers\" on class UniquenessTest");
	}
	Link l = new Link(numberAsValueObject, o, a, interpreter.getDefaultSnapshot());
	clientChanges.linkCreated(l, null);
    }
    
    private void deleteUniqueLinkToNumber(RiverInterpreter interpreter, ClassTypeDefinition numberClassTypeDefinition,
	    ChangeSetImpl clientChanges, ClassTypedObject o, Fraction n) {
	ValueObject numberAsValueObject = new NativeObject(numberClassTypeDefinition, n,
		interpreter.getDefaultSnapshot(), interpreter);
	SapClass oat = MetamodelUtils.findClass(interpreter.getConnection(), "UniquenessTest");
	Association a = null;
	for (AssociationEnd ae : oat.getAssociationEnds()) {
	    if (ae.otherEnd().getName().equals("numbers")) {
		a = ae.getAssociation();
	    }
	}
	if (a == null) {
	    throw new RuntimeException("Couldn't find association for association end \"numbers\" on class UniquenessTest");
	}
	Link l = new Link(numberAsValueObject, o, a, interpreter.getDefaultSnapshot());
	clientChanges.linkDeleted(l, null);
    }

    private ModelPartition getTransientPartition(Connection conn) {
	return conn.getOrCreateTransientPartition("OperationalTransformationTest_"+Thread.currentThread().getId());
    }
}
