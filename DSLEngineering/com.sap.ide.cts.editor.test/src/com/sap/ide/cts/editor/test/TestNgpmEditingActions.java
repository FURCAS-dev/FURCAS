package com.sap.ide.cts.editor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import modelmanagement.Package;
import ngpm.NgpmPackage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.PartInitException;
import org.junit.Test;

import textblocks.TextBlock;
import behavioral.actions.Block;
import behavioral.actions.Return;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.TcsPrettyPrinterTestHelper;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NamedValue;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeDefinition;
import dataaccess.expressions.Equals;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.This;
import dataaccess.expressions.VariableExpression;

public class TestNgpmEditingActions extends RunletEditorTest {

    /**
     * The outcommenting doesn't seem to be honored by the incremental parser.
     */
    @Test
    public void testCommentOutVariableDeclaration() throws PartInitException, BadLocationException, CoreException {
        final RefObject refObject = findClass("RedefineParameterTst2");
        assertNotNull(refObject); 
        assertTrue(refObject.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(refObject);
        CtsDocument document = getDocument(editor);
        document.replace(61, 0, "/");
        document.replace(62, 0, "/");
        document.replace(63, 0, " ");
        saveAll(editor);
        //failOnError(editor);
        assertTrue(refObject.is___Alive());
        // Your assertions on refObject here 
        SapClass c = (SapClass) refObject;
        MethodSignature ms = c.getOwnedSignatures().iterator().next();
        Block b = (Block) ms.getImplementation();
        Collection<NamedValue> variables = b.getVariables();
        assertEquals("Expect to find no declared variables in block because the variable declaration was commented out",
        	0, variables.size());
        close(editor);
    };
   

    /**
     * Takes an abstract method and makes it concrete by changing its return
     * type from "void" to "Number" and replacing the ";" by a block that
     * returns 123. The expected result is that the method <tt>m</tt> is
     * concrete with one statement in its implementation block.
     * 
     * @throws CoreException
     * @throws BadLocationException
     */
    @Test
    public void testMakeAbstractMethodConcrete() throws NullPartitionNotEmptyException, ReferencedTransientElementsException,
            BadLocationException, CoreException {

        final SapClass clazz = findClass("ClassWithAbstractMethod");
        assertEquals(1, clazz.getOwnedSignatures().size());
        assertTrue(clazz.getOwnedSignatures().iterator().next().isAbstract());

        AbstractGrammarBasedEditor editor = openEditor(clazz);

        CtsDocument document = getDocument(editor);
        String contents = document.get();
        String abstractDeclaration = "void n();";
        int bodyStart = contents.indexOf(abstractDeclaration);
        document.replace(bodyStart, "void".length(), "Number");
        document.replace(document.get().indexOf(';'), 1, " {\n" + "        return 123;\n" + "    }\n");
        assertTrue(document.get().indexOf("Number n() {\n        return 123;\n    }\n") >= 0);

        saveAll(editor);
        failOnError(editor);

        assertEquals(1, clazz.getOwnedSignatures().size());
        assertFalse(clazz.getOwnedSignatures().iterator().next().isAbstract());
        assertEquals(1, ((Block) clazz.getOwnedSignatures().iterator().next().getImplementation()).getStatements().size());

        close(editor);
    }

    

    @Test
    public void testPrettyPrintAssoc() throws NullPartitionNotEmptyException, ReferencedTransientElementsException,
            PartitionsNotSavedException, BadLocationException, CoreException, SyntaxAndModelMismatchException {

    	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
        final SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(
                ModelManager.getPartitionService().getPartition(connection, getProject(),
                        new Path("src/Package1235568260162.types")));
        clazz.setName("Humba");
        Association assoc = (Association) rootPkg.getData().getClasses().getAssociation().refCreateInstanceInPartition(
                ModelManager.getPartitionService().getPartition(connection, getProject(),
                        new Path("src/Package1235568260162.types")));
        AssociationEnd a1 = (AssociationEnd) rootPkg.getData().getClasses().getAssociationEnd().refCreateInstance();
        AssociationEnd a2 = (AssociationEnd) rootPkg.getData().getClasses().getAssociationEnd().refCreateInstance();
        a1.setName("a1");
        a1.setNavigable(true); // complemented for test purpose
        //a2.setName("a2");
        a2.setNavigable(true);
        ClassTypeDefinition a1ctd = (ClassTypeDefinition) rootPkg.getData().getClasses().getClassTypeDefinition()
                .refCreateInstance();
        a1ctd.setLowerMultiplicity(0);
        a1ctd.setUpperMultiplicity(1);
        a1ctd.setClazz(findClass("Class1"));
        ClassTypeDefinition a2ctd = (ClassTypeDefinition) rootPkg.getData().getClasses().getClassTypeDefinition()
                .refCreateInstance();
        a2ctd.setLowerMultiplicity(0);
        a2ctd.setUpperMultiplicity(1);
        a2ctd.setClazz(clazz);
        a1.setType(a1ctd);
        a2.setType(a2ctd);
        assoc.getEnds().add(a1);
        assoc.getEnds().add(a2);
        connection.save();
        TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(clazz, TcsUtil.getSyntaxByName(connection, "Class"));
		System.out.println(output.getCachedString());
        AbstractGrammarBasedEditor editor = openEditor(clazz);

        CtsDocument document = getDocument(editor);
        String contents = document.get();
        int bodyStart = contents.indexOf('{');
        document.replace(bodyStart + 1, 0, "String bla();Number asf();String bla2();");

        saveAll(editor);
        failOnError(editor);

        assertEquals(1, clazz.getAssociationEnds().size());

        close(editor);
    }

    @Test
    public void testDeleteOptionalElement() throws NullPartitionNotEmptyException, ReferencedTransientElementsException,
            BadLocationException, CoreException {

        final SapClass clazz = findClass("ClassWithEmptyMethod");
        assertNotNull(clazz);

        AbstractGrammarBasedEditor editor = openEditor(clazz);

        CtsDocument document = getDocument(editor);

        String content = document.get();
        int bodyStart = content.indexOf("m() {");
        document.replace(bodyStart + "m() {".length(), 0, "return 1;");

        saveAll(editor);
        // failOnError(editor);

        assertTrue(clazz.is___Alive());
        assertTrue(clazz.getOwnedSignatures().size() > 0);

        Block implementation = (Block) clazz.getOwnedSignatures().iterator().next().getImplementation();
        assertNotNull(implementation);

        assertEquals(1, implementation.getStatements().size());

        Return ret = (Return) implementation.getStatements().iterator().next();
        assertNotNull(ret);

        assertNotNull(ret.getArgument());
        
        content = document.get();
        bodyStart = content.indexOf("return 1;");
        document.replace(bodyStart, "return 1;".length(), "");

        saveAll(editor);

        assertTrue(clazz.is___Alive());
        assertTrue(clazz.getOwnedSignatures().size() > 0);

        Block implementation2 = (Block) clazz.getOwnedSignatures().iterator().next().getImplementation();
        assertEquals(implementation, implementation2);

        assertEquals(0, implementation2.getStatements().size());

        close(editor);
    }
    
    /**
     * I tried to change a "return 1" into a "return a" where "a" is an object parameter of the enclosing class. What I got was a
     * variable expression as argument of the return statement that had "null" assigned as variable.
     */
    @Test
    public void testChangingFromNumberLiteralToObjectParameter() throws PartInitException, BadLocationException, CoreException {
        // Source / Copy of: PF.IDE:E0367719FC65A530BE2911DECE29005056C00001
        final SapClass clazz = findClass("Humba");
        assertNotNull(clazz); 
        assertTrue(clazz.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(clazz);
        CtsDocument document = getDocument(editor);
        document.replace(63, 1, "");
        document.replace(63, 0, "a");
        saveAll(editor);
        failOnError(editor);
        assertTrue(clazz.is___Alive());
        VariableExpression a = (VariableExpression) ((Return) ((Block) clazz.getOwnedSignatures().iterator().next()
                .getImplementation()).getStatements().iterator().next()).getArgument();
        assertNotNull(a.getVariable());
        close(editor);
    };
    
    @Test
    public void testThisTypingInOPC() throws NullPartitionNotEmptyException,
	    ReferencedTransientElementsException, BadLocationException,
	    CoreException {
	final SapClass clazz = findClass("Humba");
	assertNotNull(clazz);
	AbstractGrammarBasedEditor editor = openEditor(clazz);
	CtsDocument document = getDocument(editor);
	document.replace(30, 0, "    Humba|a| getThis() {\n" +
		                "        return this;\n" +
		                "    }\n\n");
	saveAll(editor);
	failOnError(editor);

	assertTrue(clazz.is___Alive());
	MethodSignature getThis = null;
	for (MethodSignature ms : clazz.getOwnedSignatures()) {
	    if (ms.getName().equals("getThis")) {
		getThis = ms;
	    }
	}
	Return ret = (Return) ((Block) getThis.getImplementation()).getStatements().iterator().next();
	This thiz = (This) ret.getArgument();
	assertTrue("type of This expression should conform to getThis return type",
		thiz.getType().conformsTo(getThis.getOutput()));
	assertNotNull(getThis);
	close(editor);
    }
    
	    @Test
	    public void testTurnEntityIntoValue() throws PartInitException, BadLocationException, CoreException {
	        final RefObject refObject = findClass("Class1");
	        assertNotNull(refObject); 
	        assertTrue(refObject.is___Alive()); 
	        AbstractGrammarBasedEditor editor = openEditor(refObject);
	        CtsDocument document = getDocument(editor);
	        document.replace(0, 0, "v");
	        document.replace(1, 0, "a");
	        document.replace(2, 0, "l");
	        document.replace(3, 0, "u");
	        document.replace(4, 0, "e");
	        document.replace(5, 0, " ");
	        saveAll(editor);
	        //failOnError(editor);
	        assertTrue(refObject.is___Alive());
	        // Your assertions on refObject here 

	        close(editor);
	        assertTrue(((SapClass) refObject).isValueType());
	    };
	    
	    @Test
	    public void testRemoveAndReAddOutputType() throws NullPartitionNotEmptyException, ReferencedTransientElementsException,
		    PartitionsNotSavedException, BadLocationException, CoreException {

		NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(
			ModelManager.getPartitionService().getPartition(connection, getProject(),
				new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "String la();");
		assertEquals("class Humba {String la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());

		contents = document.get();
		bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, "String".length(), "");
		document.replace(bodyStart + 1, 0, "Boolean");
		// this will cause the second part to go to the token right
		// of the "I"
		assertEquals("class Humba {Boolean la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());
		TypeDefinition output = clazz.getOwnedSignatures().iterator().next().getOutput();
		assertEquals(true, output instanceof ClassTypeDefinition);
		assertEquals("Boolean", ((ClassTypeDefinition) output).getClazz().getName());

		close(editor);
	    }
	 /**
	 * This is a regression. Creation of more than one association used to work fine. For some
	 * reason, now I can't create more than one association per class anymore.
	 */
	@Test
	public void testCreationOfAnotherAssociation() throws PartInitException,
			BadLocationException, CoreException {
		String lriString = "PF.IDE:E0BACD53733F3860B84911DE8E850019D29902CC";
		LRI lri = connection.getSession().getMoin().createLri(lriString);
		final RefObject refObject = (RefObject) connection.getElement(lri);
		assertNotNull(refObject);
		assertTrue(refObject.is___Alive());
		AbstractGrammarBasedEditor editor = openEditor(refObject);
		CtsDocument document = getDocument(editor);
		document.replace(25, 0, "S");
		document.replace(26, 0, "t");
		document.replace(27, 0, "r");
		document.replace(28, 0, "i");
		document.replace(29, 0, "n");
		document.replace(30, 0, "g");
		document.replace(31, 0, "[]");
		document.replace(32, 0, "p");
		document.replace(33, 0, "]");
		document.replace(33, 1, "");
		document.replace(32, 1, "");
		document.replace(32, 0, "]");
		document.replace(33, 0, " ");
		document.replace(34, 1, "");
		document.replace(34, 0, "o");
		document.replace(35, 0, "d");
		document.replace(35, 1, "");
		document.replace(35, 0, "r");
		document.replace(36, 0, "d");
		document.replace(37, 0, "e");
		document.replace(38, 0, "r");
		document.replace(39, 0, "e");
		document.replace(40, 0, "d");
		document.replace(41, 0, "S");
		document.replace(42, 0, "t");
		document.replace(43, 0, "r");
		document.replace(44, 0, "i");
		document.replace(45, 0, "n");
		document.replace(46, 0, "g");
		document.replace(47, 0, "s");
		document.replace(48, 0, " ");
		document.replace(49, 0, "{");
		document.replace(50, 0, ".");
		document.replace(51, 0, ",");
		document.replace(52, 0, " ");
		document.replace(53, 0, "=");
		document.replace(54, 0, ",");
		document.replace(55, 0, " ");
		document.replace(56, 0, "+");
		document.replace(57, 0, "=");
		document.replace(58, 0, ",");
		document.replace(59, 0, " ");
		document.replace(60, 0, "-");
		document.replace(61, 0, "=");
		document.replace(62, 0, "}");
		document.replace(63, 0, "\n");
		document.replace(64, 0, " ");
		document.replace(65, 0, " ");
		assertEquals(
				"Unexpected document content",
				"class OrdrdStrgsTest {\r\n"
						+ "\tString[] orderedStrings {., =, +=, -=}\n"
						+ "  \tNumber[] orderedNumbersInOrderedStringsTest {., =, +=, -=}\r\n"
						+ "}", document.get());
		saveAll(editor);
		// failOnError(editor);
		assertTrue(refObject.is___Alive());
		// Your assertions on refObject here

		SapClass c = (SapClass) refObject;
		String[] methodSignatureNamesToFind = new String[] { ".orderedStrings",
				"orderedStrings=", "orderedStrings+=", "orderedStrings-=" };
		boolean[] found = new boolean[methodSignatureNamesToFind.length];
		for (MethodSignature ms : c.getOwnedSignatures()) {
			for (int i = 0; i < methodSignatureNamesToFind.length; i++) {
				if (ms.getName().equals(methodSignatureNamesToFind[i])) {
					found[i] = true;
				}
			}
		}
		for (int i = 0; i < found.length; i++) {
			assertTrue("Expected to find method signature "
					+ methodSignatureNamesToFind[i], found[i]);
		}
		close(editor);
	};
	    
    @Test
    public void testSeparatorRecognizedForElementReuse() throws NullPartitionNotEmptyException,
	    ReferencedTransientElementsException, BadLocationException,
	    CoreException {

	final SapClass clazz = findClass("Class1");
	assertNotNull(clazz);

	AbstractGrammarBasedEditor editor = openEditor(clazz);

	CtsDocument document = getDocument(editor);
	
	String content = document.get();
	int bodyStart = content.indexOf("{");
	document.replace(bodyStart , 0, " |String a| ");

	saveAll(editor);
	failOnError(editor);

	assertTrue(clazz.is___Alive());
	assertEquals(1, clazz.getFormalObjectParameters().size());
	Parameter a = clazz.getFormalObjectParameters().iterator().next();
	assertEquals("a", a.getName());
	
	content = document.get();
	bodyStart = content.indexOf("|");
	document.replace(bodyStart +1  , 0, "String b, ");

	saveAll(editor);
	failOnError(editor);
	
	assertTrue(clazz.is___Alive());
	assertEquals(2, clazz.getFormalObjectParameters().size());
	Parameter a2 = clazz.getFormalObjectParameters().get(1);
	assertEquals(a, a2);

    }
       
    @Test
    public void testAddTokenAtBeginningCausingTBMerge() throws NullPartitionNotEmptyException,
	    ReferencedTransientElementsException, BadLocationException,
	    CoreException {

	final SapClass clazz = findClass("Class1");
	assertNotNull(clazz);

	AbstractGrammarBasedEditor editor = openEditor(clazz);

	CtsDocument document = getDocument(editor);

	assertTrue(clazz.is___Alive());
	assertEquals(1, clazz.getElementsOfType().size());
	assertEquals(false, clazz.getElementsOfType().iterator().next().getAssociationEnd().isComposite());
	
	String content = document.get();
	int bodyStart = content.indexOf("{");
	document.replace(bodyStart + 1, 0, "owns ");

	saveAll(editor);
	failOnError(editor);

	assertTrue(clazz.is___Alive());
	assertEquals(1, clazz.getElementsOfType().size());
	assertEquals(true, clazz.getElementsOfType().iterator().next().getAssociationEnd().isComposite());
	
	close(editor);
    }
       
    @Test
    public void testRenameLexingBug() throws NullPartitionNotEmptyException,
	    ReferencedTransientElementsException, BadLocationException,
	    CoreException {

	final SapClass clazz = findClass("Class2");
	final SapClass clazz1 = findClass("Class1");
	assertNotNull(clazz);

	AbstractGrammarBasedEditor editor = openEditor(clazz);

	CtsDocument document = getDocument(editor);

	String content = document.get();
	int bodyStart = content.indexOf("{");
	document.replace(bodyStart, 0, "implements Class1");

	saveAll(editor);
	// failOnError(editor);

	assertTrue(clazz.is___Alive());
	
	content = document.get();
	bodyStart = content.indexOf("1");
	document.replace(bodyStart, 1, "");
	document.replace(bodyStart, 0, "1");

	saveAll(editor);
	failOnError(editor);

	assertTrue(clazz.is___Alive());
	assertTrue(clazz.getAdapters().size() == 1);
	assertTrue(clazz.getAdapters().iterator().next().getTo().equals(clazz1));
	
	close(editor);
    }
    
    
    @Test
	public void testProxyInstantiationThroughOperatorTemplate() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String content = document.get();
		int bodyStart = content.indexOf('{');
		document.replace(bodyStart +1 , 0, "Boolean starts(TimePeriod other) {\n"+
		"return (this == other).and(this == other);\n"+
		"}");

		saveAll(editor);
		//failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getOwnedSignatures().size() > 0);
		
		Block implementation = (Block) clazz.getOwnedSignatures().iterator().next().getImplementation();
		assertNotNull(implementation);

		assertEquals(1, implementation.getStatements().size());
		
		Return ret = (Return) implementation.getStatements().iterator().next();
		assertNotNull(ret);
		
		MethodCallExpression andCall = (MethodCallExpression) ret.getArgument();
		assertNotNull(andCall);
		
		Equals equals = (Equals) andCall.getObject();
		assertNotNull(equals);
		
		assertEquals(1, andCall.getParameters().size());
		
		Equals equals2 = (Equals) andCall.getParameters().iterator().next();
		assertNotNull(equals2);
		
		close(editor);
	}
    
    @Test
	public void testIncrementalContextLookup() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String content = document.get();
		int bodyStart = content.indexOf('{');
		document.replace(bodyStart+1, 0, "Class2 test(Class1 p) { return this; }");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getOwnedSignatures().size() > 0);
		
		content = document.get();
		bodyStart = content.indexOf("this");
		document.replace(bodyStart, "this".length(), "p");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		MethodSignature sig = clazz.getOwnedSignatures().iterator().next();
		assertEquals(1, sig.getInput().size());
		
		Parameter p = sig.getInput().iterator().next();
		Block impl = (Block)sig.getImplementation();
		assertEquals(p, ((VariableExpression)((Return)impl.getStatements().get(0)).getArgument()).getVariable());
		
		close(editor);
	}
    
    @Test
	public void testChangeMultiplicity2() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String content = document.get();
		int bodyStart = content.indexOf('{');
		document.replace(bodyStart+1, 0, "const Class2* getAllOpportunities() {}");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getOwnedSignatures().size() > 0);
		assertEquals(-1, clazz.getOwnedSignatures().iterator().next().getOutput().getUpperMultiplicity());
		assertEquals(false, clazz.getOwnedSignatures().iterator().next().getOutput().isUnique());
		
		content = document.get();
		bodyStart = content.indexOf("*");
		document.replace(bodyStart, 1, "{}");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertEquals(-1, clazz.getOwnedSignatures().iterator().next().getOutput().getUpperMultiplicity());
		assertEquals(true, clazz.getOwnedSignatures().iterator().next().getOutput().isUnique());
		
		close(editor);
	}
    
    @Test
	public void testChangeMultiplicity() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String content = document.get();
		int bodyStart = content.indexOf('{');
		document.replace(bodyStart+1, 0, "Number test() {return 42;}");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getOwnedSignatures().size() > 0);
		
		content = document.get();
		bodyStart = content.indexOf("test");
		document.replace(bodyStart, 0, "1..3 ");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getOwnedSignatures().iterator().next().getOutput().getLowerMultiplicity() == 1);
		assertTrue(clazz.getOwnedSignatures().iterator().next().getOutput().getUpperMultiplicity() == 3);
		
		content = document.get();
		bodyStart = content.indexOf(" 1..3");
		document.replace(bodyStart, " 1..3".length(), "");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getOwnedSignatures().iterator().next().getOutput().getLowerMultiplicity() == 0);
		assertTrue(clazz.getOwnedSignatures().iterator().next().getOutput().getUpperMultiplicity() == 1);

		close(editor);
	}
	@Test
	public void testChangeToOPC() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class1");
		assertNotNull(clazz);

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String content = document.get();
		int bodyStart = content.indexOf('{');
		document.replace(bodyStart, 0, "|Class1 p=value Class1()|");
		
		document.replace(0, 0, "value ");

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.getFormalObjectParameters().size() > 0);

		close(editor);
	}

	@Test
	public void testChangeToValueClass() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class1");
		assertNotNull(clazz);

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		document.replace(0, 0, "value ");
		assertTrue(document.get().indexOf("value class") >= 0);

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertTrue(clazz.isValueType());

		document.replace(0, "value ".length(), "");
		assertTrue(document.get().indexOf("value class") < 0);

		saveAll(editor);
		failOnError(editor);

		assertTrue(clazz.is___Alive());
		assertFalse(clazz.isValueType());

		close(editor);
	}

	@Test
	public void testResolveDelayedReferenceHandlerWithForwardRef()
			throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);

		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("C1");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		String newBody = "C2 c2 {.}";
		document.replace(bodyStart + 1, 0, newBody);
		assertEquals("class C1 {" + newBody + "\n  \n}", document.get());

		saveAll(editor);

		close(editor);

		final SapClass clazz2 = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz2.setName("test");
		connection.save();

		editor = openEditor(clazz2);
		document = getDocument(editor);

		contents = document.get();
		int indexofName = contents.indexOf("test");
		String newName = "C2";
		document.replace(indexofName, "test".length(), newName);

		saveAll(editor);

		assertEquals(1, clazz.getElementsOfType().size());
		ClassTypeDefinition ctd = clazz.getElementsOfType().iterator().next();
		assertNotNull(ctd);
		assertEquals(clazz2, ctd.getAssociationEnd().otherEnd().getType()
				.getClazz());

		close(editor);
	}

	@Test
	public void testDeleteProperty() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("Class1");

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		assertEquals(1, clazz.getOwnedSignatures().size());
		assertEquals(1, clazz.getAssociationEnds().size());
		AssociationEnd ae = clazz.getAssociationEnds().iterator().next();
		Association a = ae.getAssociation();
		assertEquals("Class2", ae.otherEnd().getType().getClazz().getName());
		assertEquals(clazz.getPackage(), ae.getAssociation().getPackage());

		CtsDocument document = getDocument(editor);

		String contents = document.get();
		int propDeclStart = contents.indexOf("Class2");
		int propDeclEnd = contents.indexOf("}", propDeclStart);
		document.replace(propDeclStart, propDeclEnd - propDeclStart + 1, "");
		assertTrue(document.get().indexOf("Class2 c2 {.}") < 0);

		saveAll(editor);
		failOnError(editor);

		assertEquals(0, clazz.getAssociationEnds().size());
		assertFalse(ae.is___Alive());
		assertFalse(a.is___Alive());

		close(editor);
	}

	@Test
	public void testRetypeVariable() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("VariableTypeRebind");

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		assertEquals(1, clazz.getOwnedSignatures().size());
		assertEquals("t", clazz.getOwnedSignatures().iterator().next()
				.getName());
		Block impl = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		NamedValue variable = impl.getVariables().iterator().next();
		ClassTypeDefinition vctd = (ClassTypeDefinition) variable.getType();
		assertEquals("VariableTypeRebind", vctd.getClazz().getName());

		CtsDocument document = getDocument(editor);

		String contents = document.get();
		int methodDeclStart = contents.indexOf("VariableTypeRebind v;");
		document.replace(methodDeclStart + "VariableTypeRebind".length() - 1,
				1, ""); // delete trailing "d"
		saveAll(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());
		assertEquals("t", clazz.getOwnedSignatures().iterator().next()
				.getName());
		Block implAfter = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		NamedValue variableAfter = implAfter.getVariables().iterator().next();
		ClassTypeDefinition vctdAfter = (ClassTypeDefinition) variableAfter
				.getType();
		assertNull(vctdAfter.getClazz());

		contents = document.get();
		methodDeclStart = contents.indexOf("VariableTypeRebin v;");
		document
				.replace(methodDeclStart + "VariableTypeRebin".length(), 0, "d"); // complete
		// name
		// again

		saveAll(editor);

		assertEquals("t", clazz.getOwnedSignatures().iterator().next()
				.getName());
		Block implYetAfter = (Block) clazz.getOwnedSignatures().iterator()
				.next().getImplementation();
		NamedValue variableYetAfter = implYetAfter.getVariables().iterator()
				.next();
		ClassTypeDefinition vctdYetAfter = (ClassTypeDefinition) variableYetAfter
				.getType();
		assertEquals("VariableTypeRebind", vctdYetAfter.getClazz().getName());

		// Now replace with "String"
		contents = document.get();
		methodDeclStart = contents.indexOf("VariableTypeRebind v;");
		document.replace(methodDeclStart, "VariableTypeRebind".length(), "");
		document.replace(methodDeclStart, 0, "String");

		saveAll(editor);
		failOnError(editor);

		assertEquals("t", clazz.getOwnedSignatures().iterator().next()
				.getName());
		Block implString = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		NamedValue variableString = implString.getVariables().iterator().next();
		ClassTypeDefinition vctdString = (ClassTypeDefinition) variableString
				.getType();
		assertEquals("String", vctdString.getClazz().getName());

		close(editor);
	}

	@Test
	public void testResolveDelayedReferenceHandler()
			throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("C1");
		SapClass clazz2 = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz2.setName("C2");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		String newBody = "C2 c2 {.}";
		document.replace(bodyStart + 1, 0, newBody);
		assertEquals("class C1 {" + newBody + "\n  \n}", document.get());

		saveAll(editor);

		assertEquals(1, clazz.getElementsOfType().size());
		ClassTypeDefinition ctd = clazz.getElementsOfType().iterator().next();
		assertNotNull(ctd);
		assertEquals(clazz2, ctd.getAssociationEnd().otherEnd().getType()
				.getClazz());
		((RefObject) editor.getWorkingConnection().getElement(
				((Partitionable) clazz2).get___Mri())).refDelete();
		editor.getWorkingConnection().save();
		assertEquals(null, ctd.getAssociationEnd().otherEnd().getType()
				.getClazz());
		clazz2 = (SapClass) rootPkg.getData().getClasses().getSapClass()
				.refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz2.setName("test");
		connection.save();

		close(editor);

		editor = openEditor(clazz2);
		document = getDocument(editor);

		contents = document.get();
		int indexofName = contents.indexOf("test");
		String newName = "C2";
		document.replace(indexofName, "test".length(), newName);

		saveAll(editor);

		assertEquals(clazz2, ctd.getAssociationEnd().otherEnd().getType()
				.getClazz());

		close(editor);
	}

	@Test
	public void testAddAssocToPackage() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("ClassWithEmptyMethod");
		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int methodDeclStart = contents.indexOf("void");
		int methodDeclEnd = contents.indexOf("}", methodDeclStart);
		document.replace(methodDeclEnd + 1, 0, "\n" + "    String s {.}\n");
		assertTrue(document.get().indexOf("String s {.}") >= 0);

		saveAll(editor);
		failOnError(editor);

		// expecting that the method will have been removed from the model
		assertEquals(1, clazz.getAssociationEnds().size());
		assertEquals("String", clazz.getAssociationEnds().iterator().next()
				.otherEnd().getType().getClazz().getName());
		assertEquals(clazz.getPackage(), clazz.getAssociationEnds().iterator()
				.next().getAssociation().getPackage());

		close(editor);
	}

	@Test
	public void testAddAssocToPackageWithNewline() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("ClassWithEmptyMethod");
		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);

		String contents = document.get();
		int methodDeclStart = contents.indexOf("void");
		int methodDeclEnd = contents.indexOf("}", methodDeclStart);
		document.replace(methodDeclEnd + 1, 0, "\n\n" + "    String s {.}\n\n");
		assertTrue(document.get().indexOf("String s {.}") >= 0);

		saveAll(editor);
		failOnError(editor);

		// expecting that the method will have been removed from the model
		assertEquals(1, clazz.getAssociationEnds().size());
		assertEquals("String", clazz.getAssociationEnds().iterator().next()
				.otherEnd().getType().getClazz().getName());
		assertEquals(clazz.getPackage(), clazz.getAssociationEnds().iterator()
				.next().getAssociation().getPackage());

		close(editor);
	}

	@Test
	public void testDeleteMethod() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, BadLocationException,
			CoreException {

		final SapClass clazz = findClass("ClassWithEmptyMethod");
		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int methodDeclStart = contents.indexOf("void");
		int methodDeclEnd = contents.indexOf("}", methodDeclStart);
		document.replace(methodDeclStart, methodDeclEnd - methodDeclStart + 1,
				"");

		saveAll(editor);
		failOnError(editor);

		// expecting that the method will have been removed from the model
		assertEquals(0, clazz.getOwnedSignatures().size());

		close(editor);
	}

	@Test
	public void testSimpleEditorAction() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		// close the welcome screen
		// IWorkbenchWindow[] windows =
		// Workbench.getInstance().getWorkbenchWindows();
		// for (int i = 0; i < windows.length; i++) {
		// IWorkbenchWindow workbenchWindow = windows[i];
		// IWorkbenchPart part = (IWorkbenchPart)
		// workbenchWindow.getPartService().getActivePart();
		// if(part.getClass().getName().equals("org.eclipse.ui.internal.ViewIntroAdapterPart")){
		// part.dispose();
		// }
		// }

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		// //TODO this overwriting can be reomved as soon as pretty printing
		// //correctly sets the types of the tokens and the textblocks
		// runEditAction(editor, new EditorRunnable(){
		//
		// @Override
		// public void runEditAction(IDocument document) throws
		// BadLocationException{
		// String contents = document.get();
		// document.replace(0, contents.length(), "class Humba{}");
		// }
		// });
		// clazz = ((ModelEeditor[0].getEditorInput()
		// end TODO

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "String s();");

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());

		close(editor);
	}

	@Test
	public void testReplaceImplWithSemicolon() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "String la(){return \"2\";}");
		assertEquals("class Humba {String la(){return \"2\";}\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());
		MethodSignature sig1 = clazz.getOwnedSignatures().iterator().next();
		assertEquals("la", sig1.getName());
		assertNotNull(sig1.getImplementation());

		contents = document.get();
		bodyStart = contents.lastIndexOf('{');
		int bodyStop = contents.indexOf('}');
		document.replace(bodyStart, bodyStop - bodyStart + 1, ";");
		assertEquals("class Humba {String la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());
		MethodSignature sig2 = clazz.getOwnedSignatures().iterator().next();
		assertEquals("la", sig2.getName());
		// TODO for future incremental parsing: assertEquals(sig1, sig2);
		assertEquals(null, sig2.getImplementation());

		close(editor);
	}

	@Test
	public void testAddOperationBefore() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "String la();");
		assertEquals("class Humba {String la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());

		contents = document.get();
		bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "String bla();");
		assertEquals("class Humba {String bla();String la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(2, clazz.getOwnedSignatures().size());

		close(editor);
	}

	@Test
	public void testDeleteOperation() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0,
				"String bla();Number asf();String bla2();");
		assertEquals("class Humba {String bla();Number asf();String bla2();\n  \n}",
				document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(3, clazz.getOwnedSignatures().size());

		contents = document.get();
		String contentToReplace = "Number asf();";
		bodyStart = contents.indexOf(contentToReplace);
		document.replace(bodyStart, contentToReplace.length(), "");
		assertEquals("class Humba {String bla();String bla2();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(2, clazz.getOwnedSignatures().size());

		close(editor);
	}

	@Test
	public void testRenameClass() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('H');
		document.replace(bodyStart, "Humba".length(), "Bla");
		assertEquals("class Bla {\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(true, ((Partitionable) clazz).is___Alive());
		assertEquals("Bla", clazz.getName());

		close(editor);
	}

	@Test
	public void testRenameClassWithSubStringName() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('H');
		document.replace(bodyStart, "Humba".length(), "a");
		assertEquals("class a {\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(true, ((Partitionable) clazz).is___Alive());
		assertEquals("a", clazz.getName());

		close(editor);
	}

	@Test
	public void testRenameSpanningOverTextblocksLonger()
			throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "String la();");
		assertEquals("class Humba {String la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());

		contents = document.get();
		bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, "String".length(), "B");
		document.replace(bodyStart + 2, 0, "oolean");
		// this will cause the second part to go to the token right
		// of the "I"
		assertEquals("class Humba {Boolean la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());
		TypeDefinition output = clazz.getOwnedSignatures().iterator().next()
				.getOutput();
		assertEquals(true, output instanceof ClassTypeDefinition);
		assertEquals("Boolean", ((ClassTypeDefinition) output).getClazz()
				.getName());

		close(editor);
	}

	@Test
	public void testRenameSpanningOverTextblocksShorter()
			throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, 0, "Boolean la();");
		assertEquals("class Humba {Boolean la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());

		contents = document.get();
		bodyStart = contents.indexOf('{');
		document.replace(bodyStart + 1, "Boolean".length(), "S");
		document.replace(bodyStart + 2, 0, "tring");
		// this will cause the second part to go to the token right
		// of the "I"
		assertEquals("class Humba {String la();\n  \n}", document.get());

		saveAll(editor);
		failOnError(editor);

		assertEquals(1, clazz.getOwnedSignatures().size());
		TypeDefinition output = clazz.getOwnedSignatures().iterator().next()
				.getOutput();
		assertEquals(true, output instanceof ClassTypeDefinition);
		assertEquals("String", ((ClassTypeDefinition) output).getClazz()
				.getName());

		close(editor);
	}

	@Test
	public void testDeleteStatementFromMethod() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		final Package pack = (Package) rootPkg.getModelmanagement()
				.getPackage().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setPackage(pack);
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		String newBody = "Boolean playWithPersistence() {"
				+ "store this;"
				+ "commit;"
				+ "var repositoryContainsThis = all Organization->iterate(contains=false; i|contains.or(i==this));"
				+ "return repositoryContainsThis;" + "}"
				+ "owns Person* persons {.,+=,-=}";
		document.replace(bodyStart + 1, 0, newBody);
		assertEquals("class Humba {" + newBody + "\n  \n}", document.get());

		saveAll(editor);

		assertEquals(4, clazz.getOwnedSignatures().size());
		Block body = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		assertEquals(4, body.getStatements().size());

		contents = document.get();
		String commitString = "commit;";
		int commitStatmentIndex = contents.indexOf(commitString);
		document.replace(commitStatmentIndex, commitString.length(), "");
		assertEquals(
				"class Humba {Boolean playWithPersistence() {"
						+ "store this;"
						+ "var repositoryContainsThis = all Organization->iterate(contains=false; i|contains.or(i==this));"
						+ "return repositoryContainsThis;" + "}"
						+ "owns Person* persons {.,+=,-=}\n  \n}", document.get());

		saveAll(editor);

		assertEquals(4, clazz.getOwnedSignatures().size());
		body = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		assertEquals(3, body.getStatements().size());

		close(editor);
	}
	
    @Test
    public void testIncrementalPropertyInitEvaluation() throws NullPartitionNotEmptyException,
	    ReferencedTransientElementsException, BadLocationException,
	    CoreException {

	final SapClass clazz = findClass("Class1");
	assertNotNull(clazz);

	AbstractGrammarBasedEditor editor = openEditor(clazz);

	CtsDocument document = getDocument(editor);
	
	String content = document.get();
	int bodyStart = content.indexOf("{");
	document.replace(bodyStart , 0, " implements Class2 ");

	saveAll(editor);
	failOnError(editor);

	assertTrue(clazz.is___Alive());
	assertEquals(1, clazz.getAdapters().size());
	assertEquals("From_Class1_to_Class2", clazz.getAdapters().iterator().next().getName());
	
	content = document.get();
	bodyStart = content.indexOf("1");
	document.replace(bodyStart , 1, "3");

	saveAll(editor);
	failOnError(editor);
	
	assertTrue(clazz.is___Alive());
	assertEquals("Class3", clazz.getName());
	assertEquals(1, clazz.getAdapters().size());
	assertEquals("From_Class3_to_Class2", clazz.getAdapters().iterator().next().getName());
	
	close(editor);
    }
    
    /**
     * When I add the object parameters, the editor presents an error dialog and suggests to close all editors.
     */
    @Test
    public void testAddingObjectParametersToValueClass() throws PartInitException, BadLocationException, CoreException {
        // Copy of: PF.IDE:E03677197CCEEE80B83411DE85060019D29902CC
        String lriString = "PF.IDE:E01F0466B2FBA520B83411DEA84F0019D29902CC";
        LRI lri = connection.getSession().getMoin().createLri(lriString);
        final RefObject refObject = (RefObject) connection.getElement(lri);
        assertNotNull(refObject); 
        assertTrue(refObject.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(refObject);
        CtsDocument document = getDocument(editor);
        document.replace(27, 0, "|Number* precision=0.minus(1), Number roundingRule=0| ");
        document.replace(81, 1, "");
        saveAll(editor);
        //failOnError(editor);
        assertTrue(refObject.is___Alive());
        // Your assertions on refObject here 

        close(editor);
    };

}
