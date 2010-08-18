package com.sap.runlet.interpreter.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import behavioral.actions.AddLink;
import behavioral.actions.Assignment;
import behavioral.actions.Block;
import behavioral.actions.Constant;
import behavioral.actions.ExpressionStatement;
import behavioral.actions.Foreach;
import behavioral.actions.IfElse;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.Return;
import behavioral.actions.Statement;
import behavioral.actions.Variable;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;


import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.LinkAddition;
import data.classes.LinkRemoval;
import data.classes.LinkSetting;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.NamedValue;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeAdapter;
import data.classes.TypeDefinition;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;
import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.Expression;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.This;
import dataaccess.expressions.VariableExpression;
import dataaccess.expressions.collectionexpressions.Excluding;
import dataaccess.expressions.collectionexpressions.ExcludingAt;
import dataaccess.expressions.collectionexpressions.Including;
import dataaccess.expressions.collectionexpressions.Iterate;
import dataaccess.expressions.fp.FunctionFromMethodExpr;
import dataaccess.expressions.literals.NumberLiteral;
import dataaccess.expressions.literals.StringLiteral;

/**
 * Simple tests for the River interpreter. Generally, each test builds up a little
 * River "program" as a model in the MOIN NullPartition using JMI calls. The outermost
 * part of this program is an expression which can then be evaluated by a call to the
 * {@link RunletInterpreter}.
 * 
 * @author Axel Uhl (D043530)
 */
public class TestBasicExpressions extends TestCase {
    private enum Accessors { GETTER, SETTER, ADDER, REMOVER };
    
    public void testStringLiteral() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    StringLiteral nl = conn.createElement(StringLiteral.CLASS_DESCRIPTOR);
	    nl.setLiteral("Humba");
	    SapClass stringClass = MetamodelUtils.findClass(conn, "String");
    	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    stringClass);
    	    nl.setOwnedTypeDefinition(ctd);
    	    NativeObject result = (NativeObject) new RunletInterpreter(conn,
    		    new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(nl);
    	    assertEquals("Humba", result.getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public void testNumberLiterals() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    NumberLiteral nl = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
    	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass);
    	    nl.setOwnedTypeDefinition(ctd);
    	    NativeObject result = (NativeObject) new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(nl);
    	    assertEquals(new Fraction("123.450"), result.getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    public void testNumberAdd() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    NumberLiteral nl = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    nl.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass));
	    NumberLiteral nl2 = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl2.setLiteral("123.450");
	    nl2.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass));
	    MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    MethodSignature sig = MetamodelUtils.findMethod(conn, "Number", "plus");
	    mce.setMethodSignature(sig);
	    mce.setObject(nl);
	    mce.getParameters().add(nl2);
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(mce);
	    assertEquals(new Fraction("246.900"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Tests something like the following code:
     * 
     * <pre>
     * {
     *   var a=123.45;
     *   return a;
     * }.invoke();
     * </pre>
     */
    public void testSimpleVariableAssignmentInBlock() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    NumberLiteral nl = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass);
	    nl.setOwnedTypeDefinition(ctd);

	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);
	    NamedValueDeclaration varDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable a = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    a.setName("a");
	    a.setInitExpression(nl);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    
	    VariableExpression aExp = createVariableExpression(conn, a);
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    ret.setArgument(aExp);
	    block.getStatements().add(ret);
	    
	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    funcSig.setOutput(ret.getArgument().getType()); // use type of return as signature's output
	    funcSig.setImplementation(block);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(fce);
	    assertEquals(new Fraction("123.450"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Tests that for something like the following code:
     * 
     * <pre>
     * {
     *   return a;
     * }.invoke();
     * </pre>
     * 
     * an exception is thrown because the variable a is not in scope
     */
    public void testUseOfVariableBeforeDeclaration() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    NumberLiteral nl = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass);
	    nl.setOwnedTypeDefinition(ctd);

	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);
	    Variable a = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    a.setName("a");
	    a.setInitExpression(nl);
	    
	    VariableExpression aExp = createVariableExpression(conn, a);
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    ret.setArgument(aExp);
	    block.getStatements().add(ret);
	    
	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    funcSig.setOutput(ret.getArgument().getType()); // use type of return as signature's output
	    funcSig.setImplementation(block);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    interpreter.evaluate(fce);
	} catch (RuntimeException e) {
	    assertEquals("No value defined for a", e.getMessage());
	    return;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	fail("Expected RuntimeException(\"No value defined for a\") to be thrown");
    }

    /**
     * Tests that for this kind of recursion the parameter passing works and that
     * the parameter is used from the local frame
     * 
     * <pre>
     * { Integer i -> Integer |
     *   if (i>0) {
     *     return i.plus(invoke(i-1));
     *   } else {
     *     return 0;
     *   }
     * }.invoke();
     * </pre>
     * 
     */
    public void testRecursiveFunctionCall() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);

	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    Parameter i = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	    i.setName("i");
	    i.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass));
	    funcSig.getInput().add(i);
	    funcSig.setOutput(i.getType());
	    funcSig.setImplementation(block);
	    VariableExpression iExp = createVariableExpression(conn, i);
	    IfElse ifElse = conn.createElement(IfElse.CLASS_DESCRIPTOR);
	    MethodCallExpression iGreaterZero = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    iGreaterZero.setObject(iExp);
	    MethodSignature greaterThan = MetamodelUtils.findMethod(conn, "Number", "greaterThan");
	    iGreaterZero.setMethodSignature(greaterThan);
	    iGreaterZero.setObject(iExp);
	    iGreaterZero.getParameters().add(MetamodelUtils.createNumberLiteral(conn, "0"));
	    ifElse.setCondition(iGreaterZero);
	    Block ifBranch = conn.createElement(Block.CLASS_DESCRIPTOR);
	    MethodCallExpression iMinusOne = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(conn, i);
	    iMinusOne.setObject(iExp);
	    MethodSignature minus = MetamodelUtils.findMethod(conn, "Number", "minus");
	    iMinusOne.setMethodSignature(minus);
	    iMinusOne.getParameters().add(MetamodelUtils.createNumberLiteral(conn, "1"));
	    FunctionCallExpression recursion = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    recursion.getParameters().add(iMinusOne);
	    
	    MethodCallExpression iPlusRecursion = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(conn, i);
	    iPlusRecursion.setObject(iExp);
	    MethodSignature plus = MetamodelUtils.findMethod(conn, "Number", "plus");
	    iPlusRecursion.setMethodSignature(plus);
	    iPlusRecursion.getParameters().add(recursion);
	    
	    Return retIf = conn.createElement(Return.CLASS_DESCRIPTOR);
	    retIf.setArgument(iPlusRecursion);
	    ifBranch.getStatements().add(retIf);
	    
	    Block elseBranch = conn.createElement(Block.CLASS_DESCRIPTOR);
	    Return retElse = conn.createElement(Return.CLASS_DESCRIPTOR);
	    retElse.setArgument(MetamodelUtils.createNumberLiteral(conn, "0"));
	    elseBranch.getStatements().add(retElse);

	    ifElse.getNestedBlocks().add(ifBranch);
	    ifElse.getNestedBlocks().add(elseBranch);
	    
	    block.getStatements().add(ifElse);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    fce.getParameters().add(MetamodelUtils.createNumberLiteral(conn, "10"));
	    
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(fce);
	    assertEquals(new Fraction("55"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Tests that the variable <tt>a</tt> 
     * 
     * <pre>
     * { Integer i -> Integer |
     *   var a=0;
     *   if (i>0) {
     *     var a=1; // introduces a new variable in the nested scope
     *     var b=i; // introduces a new variable in the nested scope
     *     return b.plus(invoke(i-a));
     *   } else {
     *     return a;
     *   }
     * }.invoke();
     * </pre>
     * 
     */
    public void testVariableScoping() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);
	    NamedValueDeclaration varDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable a = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    a.setName("a");
	    a.setInitExpression(MetamodelUtils.createNumberLiteral(conn, "0"));
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);

	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    Parameter i = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	    i.setName("i");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    i.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass));
	    funcSig.getInput().add(i);
	    funcSig.setOutput(i.getType());
	    funcSig.setImplementation(block);
	    VariableExpression iExp = createVariableExpression(conn, i);
	    IfElse ifElse = conn.createElement(IfElse.CLASS_DESCRIPTOR);
	    MethodCallExpression iGreaterZero = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    iGreaterZero.setObject(iExp);
	    MethodSignature greaterThan = MetamodelUtils.findMethod(conn, "Number", "greaterThan");
	    iGreaterZero.setMethodSignature(greaterThan);
	    iGreaterZero.setObject(iExp);
	    iGreaterZero.getParameters().add(MetamodelUtils.createNumberLiteral(conn, "0"));
	    ifElse.setCondition(iGreaterZero);

	    Block ifBranch = conn.createElement(Block.CLASS_DESCRIPTOR);
	    NamedValueDeclaration innerVarDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable innerA = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    innerA.setName("a");
	    innerA.setInitExpression(MetamodelUtils.createNumberLiteral(conn, "1"));
	    innerVarDecl.setNamedValue(innerA);
	    ifBranch.getStatements().add(innerVarDecl);
	    NamedValueDeclaration bDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable b = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    b.setName("b");
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(conn, i);
	    b.setInitExpression(iExp);
	    bDecl.setNamedValue(b);
	    ifBranch.getStatements().add(bDecl);
	    
	    MethodCallExpression iMinusA = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(conn, i);
	    iMinusA.setObject(iExp);
	    MethodSignature minus = MetamodelUtils.findMethod(conn, "Number", "minus");
	    iMinusA.setMethodSignature(minus);
	    VariableExpression innerAExp = createVariableExpression(conn, innerA);
	    iMinusA.getParameters().add(innerAExp);
	    FunctionCallExpression recursion = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    recursion.getParameters().add(iMinusA);
	    
	    MethodCallExpression bPlusRecursion = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    VariableExpression bExp = createVariableExpression(conn, b);
	    bPlusRecursion.setObject(bExp);
	    MethodSignature plus = MetamodelUtils.findMethod(conn, "Number", "plus");
	    bPlusRecursion.setMethodSignature(plus);
	    bPlusRecursion.getParameters().add(recursion);
	    
	    Return retIf = conn.createElement(Return.CLASS_DESCRIPTOR);
	    retIf.setArgument(bPlusRecursion);
	    ifBranch.getStatements().add(retIf);
	    
	    Block elseBranch = conn.createElement(Block.CLASS_DESCRIPTOR);
	    Return retElse = conn.createElement(Return.CLASS_DESCRIPTOR);
	    VariableExpression aExp = createVariableExpression(conn, a);
	    retElse.setArgument(aExp);
	    elseBranch.getStatements().add(retElse);

	    ifElse.getNestedBlocks().add(ifBranch);
	    ifElse.getNestedBlocks().add(elseBranch);
	    
	    block.getStatements().add(ifElse);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    fce.getParameters().add(MetamodelUtils.createNumberLiteral(conn, "10"));
	    
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(fce);
	    assertEquals(new Fraction("55"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public void testPolymorphicMethodInvocation() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    SapClass c1 = createClass(conn, "C1");
	    MethodSignature s1 = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
	    s1.setName("s1");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    ClassTypeDefinition numberTD = MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass);
	    s1.setOutput(numberTD);
	    Block s1Impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	    s1Impl.setImplements(s1);
	    Return s1ImplReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	    s1ImplReturn.setArgument(MetamodelUtils.createNumberLiteral(conn, "12345"));
	    s1Impl.getStatements().add(s1ImplReturn);
	    c1.getOwnedSignatures().add(s1);
	    SapClass c2 = createClass(conn, "C2");
	    MethodSignature s2 = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
	    s2.setName("s2");
	    s2.setOutput(numberTD);
	    c2.getOwnedSignatures().add(s2);
	    TypeAdapter adapter = conn.createElement(TypeAdapter.CLASS_DESCRIPTOR);
	    adapter.setName("FromC1ToC2");
	    adapter.setAdapted(c1);
	    adapter.setTo(c2);
	    MethodSignature adapterSig = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
	    adapterSig.setName("s2");
	    Block impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	    Return c1ToC2AdapterImplReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	    MethodCallExpression c1ToC2Mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    c1ToC2Mce.setObject(conn.createElement(This.CLASS_DESCRIPTOR));
	    c1ToC2Mce.setMethodSignature(s1);
	    c1ToC2AdapterImplReturn.setArgument(c1ToC2Mce);
	    impl.getStatements().add(c1ToC2AdapterImplReturn);
	    
	    impl.setImplements(adapterSig);
	    adapterSig.setOutput(numberTD);
	    adapter.getOwnedSignatures().add(adapterSig);

	    SapClass c3 = createClass(conn, "C3");
	    MethodSignature s3 = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
	    s3.setName("s3");
	    s3.setOutput(numberTD);
	    c3.getOwnedSignatures().add(s3);
	    TypeAdapter adapter2 = conn.createElement(TypeAdapter.CLASS_DESCRIPTOR);
	    adapter2.setName("FromC2ToC3");
	    adapter2.setAdapted(c2);
	    adapter2.setTo(c3);
	    MethodSignature adapter2Sig = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
	    adapter2Sig.setName("s3");
	    adapter2Sig.setOutput(numberTD);
	    Block impl2 = conn.createElement(Block.CLASS_DESCRIPTOR);
	    Return c2ToC3AdapterImplReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	    MethodCallExpression c2ToC3Mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    c2ToC3Mce.setObject(conn.createElement(This.CLASS_DESCRIPTOR));
	    c2ToC3Mce.setMethodSignature(s2);
	    c2ToC3AdapterImplReturn.setArgument(c2ToC3Mce);
	    impl2.getStatements().add(c2ToC3AdapterImplReturn);
	    impl2.setImplements(adapter2Sig);
	    adapter2.getOwnedSignatures().add(adapter2Sig);
	    Collection<JmiException> exceptions = adapter
		    .refVerifyConstraints(/* deepVerify */false);
	    assertTrue("Adapter should be valid but has "
		    + ((exceptions == null) ? 0 : exceptions.size()) + " violated constraints",
		    exceptions == null || exceptions.size() == 0);
	    Collection<JmiException> exceptions2 = adapter2
		    .refVerifyConstraints(/* deepVerify */false);
	    assertTrue("Adapter should be valid but has "
		    + ((exceptions2 == null) ? 0 : exceptions2.size()) + " violated constraints",
		    exceptions2 == null || exceptions2.size() == 0);
	    assertTrue("Classes with no signatures and an adapter between them should conform", c1
		    .conformsTo(c3));
	    
	    // evaluate: new C1().s3()
	    ObjectCreationExpression oce = conn.createElement(ObjectCreationExpression.CLASS_DESCRIPTOR);
	    oce.setClassToInstantiate(c1);
	    ClassTypeDefinition c1td = MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, c1);
	    oce.setOwnedTypeDefinition(c1td);
	    MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    mce.setObject(oce);
	    mce.setMethodSignature(s3);
	    mce.setOwnedTypeDefinition(numberTD);
	    Collection<JmiException> exceptions3 = mce.refVerifyConstraints(/* deepVerify */false);
	    assertTrue("Method call on new C1().s3() should be valid but has "
		    + ((exceptions3 == null) ? 0 : exceptions3.size()) + " violated constraints",
		    exceptions3 == null || exceptions3.size() == 0);
	    assertEquals(new Fraction(12345),
		    ((NativeObject) new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(mce)).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    public void testSimpleLinks() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    SapClass c1 = createClass(conn, "C1");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    Association c1ToNumber = MetamodelUtils.createAssociation(conn, c1, 0, -1,
		    				       /* navigable */ false, numberClass, 0, 1, /* navigable */ true);
	    
	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);
	    NamedValueDeclaration varDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable a = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    a.setName("a");
	    ObjectCreationExpression oce = conn.createElement(ObjectCreationExpression.CLASS_DESCRIPTOR);
	    oce.setClassToInstantiate(c1);
	    oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, c1));
	    a.setInitExpression(oce);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    AddLink addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	    addLink.setAssociation(c1ToNumber);
	    VariableExpression aRef = createVariableExpression(conn, a);
	    addLink.getObjects().add(aRef);
	    addLink.getObjects().add(MetamodelUtils.createNumberLiteral(conn, "42"));
	    block.getStatements().add(addLink);
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    AssociationEndNavigationExpression aene = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	    aene.setToEnd(c1ToNumber.getEnds().get(1));
	    VariableExpression aRef2 = createVariableExpression(conn, a);
	    aene.setObject(aRef2);
	    ret.setArgument(aene);
	    block.getStatements().add(ret);

	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    funcSig.setOutput(c1ToNumber.getEnds().get(1).getType());
	    funcSig.setImplementation(block);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(fce);
	    
	    assertEquals(new Fraction(42), ((NativeObject) result).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
	
    public void testTwoLinks() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    SapClass c1 = createClass(conn, "C1");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    Association c1ToNumber = conn.createElement(Association.CLASS_DESCRIPTOR);
	    AssociationEnd c1End = conn.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	    c1End.setComposite(true);
	    AssociationEnd numberEnd = conn.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	    numberEnd.setNavigable(true);
	    c1ToNumber.getEnds().add(c1End);
	    c1ToNumber.getEnds().add(numberEnd);
	    ClassTypeDefinition c1TD = MetamodelUtils.createClassTypeDefinition(conn, c1, 0, -1);
	    c1End.setType(c1TD);
	    ClassTypeDefinition numberTD = MetamodelUtils.createClassTypeDefinition(conn, numberClass, 0, -1);
	    numberTD.setOrdered(true);
	    numberEnd.setType(numberTD);
	    
	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);
	    NamedValueDeclaration varDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable a = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    a.setName("a");
	    ObjectCreationExpression oce = conn.createElement(ObjectCreationExpression.CLASS_DESCRIPTOR);
	    oce.setClassToInstantiate(c1);
	    oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, c1));
	    a.setInitExpression(oce);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    AddLink addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	    addLink.setAssociation(c1ToNumber);
	    VariableExpression aRef = createVariableExpression(conn, a);
	    addLink.getObjects().add(aRef);
	    addLink.getObjects().add(MetamodelUtils.createNumberLiteral(conn, "42"));
	    block.getStatements().add(addLink);
	    AddLink addLink2 = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	    addLink2.setAssociation(c1ToNumber);
	    VariableExpression aRef2 = createVariableExpression(conn, a);
	    addLink2.getObjects().add(aRef2);
	    addLink2.getObjects().add(MetamodelUtils.createNumberLiteral(conn, "43"));
	    block.getStatements().add(addLink2);
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    AssociationEndNavigationExpression aene = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	    aene.setToEnd(numberEnd);
	    VariableExpression aRef3 = createVariableExpression(conn, a);
	    aene.setObject(aRef3);
	    ret.setArgument(aene);
	    block.getStatements().add(ret);

	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    funcSig.setOutput(numberTD);
	    funcSig.setImplementation(block);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(fce);
	    
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultIterator = result.flatten().iterator();
	    assertEquals(new Fraction(42), ((NativeObject) resultIterator.next()).getNativeObject());
	    assertEquals(new Fraction(43), ((NativeObject) resultIterator.next()).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
	
    public void testSimpleFunctionFromMethod() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    NumberLiteral nl = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    nl.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass));
	    NumberLiteral nl2 = conn.createElement(NumberLiteral.CLASS_DESCRIPTOR);
	    nl2.setLiteral("123.450");
	    nl2.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn,
		    numberClass));
	    
	    FunctionFromMethodExpr ffme = conn.createElement(FunctionFromMethodExpr.CLASS_DESCRIPTOR);
	    MethodSignature sig = MetamodelUtils.findMethod(conn, "Number", "plus");
	    ffme.setMethod(sig);
	    ffme.setObject(nl);

	    FunctionSignatureTypeDefinition fstd = conn.createElement(
		    FunctionSignatureTypeDefinition.CLASS_DESCRIPTOR);
	    fstd.setLowerMultiplicity(1);
	    fstd.setUpperMultiplicity(1);
	    fstd.setSignature(sig);
	    ffme.setOwnedTypeDefinition(fstd);
	    
	    FunctionCallExpression fce = conn.createElement(FunctionCallExpression.CLASS_DESCRIPTOR);
	    fce.setCalledBlock(ffme);
	    fce.getParameters().add(nl2);
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(fce);
	    assertEquals(new Fraction("246.900"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public void testMultiObjectMethodInvocation() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    SapClass c1 = createClass(conn, "C1");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    Association c1ToNumber = conn.createElement(Association.CLASS_DESCRIPTOR);
	    AssociationEnd c1End = conn.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	    c1End.setComposite(true);
	    AssociationEnd numberEnd = conn.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	    numberEnd.setNavigable(true);
	    c1ToNumber.getEnds().add(c1End);
	    c1ToNumber.getEnds().add(numberEnd);
	    ClassTypeDefinition c1TD = MetamodelUtils.createClassTypeDefinition(conn, c1, 0, -1);
	    c1End.setType(c1TD);
	    ClassTypeDefinition numberTD = MetamodelUtils.createClassTypeDefinition(conn, numberClass, 0, -1);
	    numberTD.setOrdered(true);
	    numberEnd.setType(numberTD);
	    
	    Block block = conn.createElement(Block.CLASS_DESCRIPTOR);
	    NamedValueDeclaration varDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable a = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    a.setName("a");
	    ObjectCreationExpression oce = conn.createElement(ObjectCreationExpression.CLASS_DESCRIPTOR);
	    oce.setClassToInstantiate(c1);
	    oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, c1));
	    a.setInitExpression(oce);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    AddLink addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	    addLink.setAssociation(c1ToNumber);
	    VariableExpression aRef = createVariableExpression(conn, a);
	    addLink.getObjects().add(aRef);
	    addLink.getObjects().add(MetamodelUtils.createNumberLiteral(conn, "42"));
	    block.getStatements().add(addLink);
	    AddLink addLink2 = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	    addLink2.setAssociation(c1ToNumber);
	    VariableExpression aRef2 = createVariableExpression(conn, a);
	    addLink2.getObjects().add(aRef2);
	    addLink2.getObjects().add(MetamodelUtils.createNumberLiteral(conn, "43"));
	    block.getStatements().add(addLink2);
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    AssociationEndNavigationExpression aene = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	    aene.setToEnd(numberEnd);
	    VariableExpression aRef3 = createVariableExpression(conn, a);
	    aene.setObject(aRef3);
	    ret.setArgument(aene);
	    block.getStatements().add(ret);

	    FunctionSignature funcSig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    funcSig.setOutput(numberTD);
	    funcSig.setImplementation(block);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, funcSig);
	    
	    // now call a method on the resulting multi-object and check multi-object result
	    
	    MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    mce.setObject(fce);
	    mce.setMethodSignature(MetamodelUtils.findMethod(conn, "Number", "negate"));
	    
	    RunletInterpreter interpreter = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(mce);
	    
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultIterator = result.iterator();
	    assertEquals(new Fraction(-42), ((NativeObject) resultIterator.next()).getNativeObject());
	    assertEquals(new Fraction(-43), ((NativeObject) resultIterator.next()).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    private SapClass createClass(ResourceSet conn, String name) {
	SapClass c1 = conn.createElement(SapClass.CLASS_DESCRIPTOR);
	c1.setName(name);
	return c1;
    }
    
    /**
     * Creates the accessor method signatures requested and exposes them in the class that
     * is the type of <tt>end</tt>'s opposite end by adding them to that class's owned
     * signatures.
     */
    private Map<Accessors, MethodSignature> exposeAssociationEnd(ResourceSet conn, AssociationEnd end,
	    Accessors[] accessorsToExpose) {
	Map<Accessors, MethodSignature> result = new HashMap<Accessors, MethodSignature>();
	SapClass otherEndClass = end.otherEnd().getType().getClazz();
	for (Accessors accessorToExpose : accessorsToExpose) {
	    MethodSignature sig = null;
	    Parameter param;
	    switch (accessorToExpose) {
	    case GETTER:
		sig = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
		sig.setName("get" + firstUp(end.getName()));
		sig.setOutput(end.getType());
		LinkTraversal getterImpl = conn.createElement(LinkTraversal.CLASS_DESCRIPTOR);
		getterImpl.setEnd(end);
		getterImpl.setImplements(sig);
		break;
	    case SETTER:
		sig = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
		sig.setName("set" + firstUp(end.getName()));
		param = conn.createElement(Parameter.CLASS_DESCRIPTOR);
		param.setName("value");
		sig.getInput().add(param);
		LinkSetting setterImpl = conn.createElement(LinkSetting.CLASS_DESCRIPTOR);
		setterImpl.setEnd(end);
		setterImpl.setImplements(sig);
		break;
	    case ADDER:
		sig = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
		sig.setName("addTo" + firstUp(end.getName()));
		param = conn.createElement(Parameter.CLASS_DESCRIPTOR);
		param.setName("value");
		sig.getInput().add(param);
		LinkAddition adderImpl = conn.createElement(LinkAddition.CLASS_DESCRIPTOR);
		adderImpl.setEnd(end);
		adderImpl.setImplements(sig);
		break;
	    case REMOVER:
		sig = conn.createElement(MethodSignature.CLASS_DESCRIPTOR);
		sig.setName("removeFrom" + firstUp(end.getName()));
		param = conn.createElement(Parameter.CLASS_DESCRIPTOR);
		param.setName("value");
		sig.getInput().add(param);
		LinkRemoval removerImpl = conn.createElement(LinkRemoval.CLASS_DESCRIPTOR);
		removerImpl.setEnd(end);
		removerImpl.setImplements(sig);
		break;
	    }
	    otherEndClass.getOwnedSignatures().add(sig);
	    result.put(accessorToExpose, sig);
	}
	return result;
    }
    
    private String firstUp(String name) {
	return name.substring(0, 1).toUpperCase()+name.substring(1);
    }

    /**
     * This test constructs a simple class graph with <tt>SalesOrderItem</tt> as the common "fact
     * table" with a <tt>getPrice()</tt> signature that returns the key figure for the item,
     * backed by an association to the <tt>Number</tt> class. Associated is the
     * <tt>SalesOrder</tt> class to which a <tt>Customer</tt> is associated. The customer has an
     * attribute for <tt>region</tt>. Furthermore, the <tt>SalesOrderItem</tt> has an
     * association to <tt>Product</tt> which has an attribute <tt>category</tt>.
     */
    public void testSimpleCellSetExpression() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    
	    // set up data structures
	    SapClass salesOrderItem = createClass(conn, "SalesOrderItem");
	    SapClass numberClass = MetamodelUtils.findClass(conn, "Number");
	    Association salesOrderItemToPrice = MetamodelUtils.createAssociation(conn, salesOrderItem, "salesOrderItemsWithPrice", 0,
		    -1, /* nav */ false, /* comp */ false, /* ordered */ false,
		    /* unique */ false, numberClass, "price", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> priceAccessors = exposeAssociationEnd(conn,
		    salesOrderItemToPrice.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    SapClass product = createClass(conn, "Product");
	    Association salesOrderItemToProduct = MetamodelUtils.createAssociation(conn, salesOrderItem, "salesOrderItems", 0,
		    -1, /* nav */ false, /* comp */ false, /* ordered */ false,
		    /* unique */ false, product, "product", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> productAccessors = exposeAssociationEnd(conn,
		    salesOrderItemToProduct.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    SapClass salesOrder = createClass(conn, "SalesOrder");
	    Association salesOrderToSalesOrderItems = MetamodelUtils.createAssociation(conn, salesOrder, "salesOrder",
		    1, 1, /* nav */ true, /* comp */ true, /* ordered */ false, /* unique */ false,
		    salesOrderItem, "items", 0, -1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> itemsAccessors = exposeAssociationEnd(conn,
		    salesOrderToSalesOrderItems.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.ADDER, Accessors.REMOVER });
	     */
	    SapClass customer = createClass(conn, "Customer");
	    Association salesOrderToCustomer = MetamodelUtils.createAssociation(conn, salesOrder, "salesOrders",
		    0, -1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false,
		    customer, "customer", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> customerAccessors = exposeAssociationEnd(conn,
		    salesOrderToCustomer.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    SapClass string = MetamodelUtils.findClass(conn, "String");
	    Association customerToRegion = MetamodelUtils.createAssociation(conn, customer, "customerWithRegion",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "region", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> regionAccessors = exposeAssociationEnd(conn,
		    customerToRegion.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	    */
	    // TODO what would happen if the category multiplicity was 0..*?
	    Association productToCategory = MetamodelUtils.createAssociation(conn, product, "productWithCategory",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "category", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> categoryAccessors = exposeAssociationEnd(conn,
		    productToCategory.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    CellSet cellSet = createCellSet(conn, salesOrderItem, salesOrderItemToPrice,
		    salesOrderItemToProduct, salesOrderToSalesOrderItems, salesOrderToCustomer,
		    productToCategory, customerToRegion);
	    
	    FunctionSignature sig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    sig.setImplementation(cellSet);
	    /* Note: connecting a CellSet with its FunctionSignature triggers an event handler
	       which creates all input arguments for the signature because in the grammar/mapping
	       for the concrete syntax this currently cannot be described. 
	    Parameter factsParam = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	    factsParam.setName("facts");
	    sig.getInput().add(factsParam);
	    Parameter sigDimensionParam1 = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	    sigDimensionParam1.setName("productCategory"); // parameter type inferred by TypedElement.getType()
	    sig.getInput().add(sigDimensionParam1);
	    Parameter sigDimensionParam2 = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	    sigDimensionParam1.setName("customerRegion"); // parameter type inferred by TypedElement.getType()
	    sig.getInput().add(sigDimensionParam2);
	    */
	    sig.setOutput(cellSet.getAggregationFunction().getOutput());
	    
	    // evaluate a cell set expression
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, sig);

	    fce.getParameters().add(createFacts(conn, salesOrder, salesOrderItem, product, customer,
		    productToCategory, salesOrderItemToPrice, salesOrderItemToProduct,
		    customerToRegion, salesOrderToCustomer, salesOrderToSalesOrderItems));
	    fce.getParameters().add(MetamodelUtils.createStringLiteral(conn, "Toys"));     // productCategory parameter
	    fce.getParameters().add(MetamodelUtils.createStringLiteral(conn, "Americas")); // customerRegion parameter
	    
	    Collection<JmiException> cellExpressionExceptions = fce.refVerifyConstraints(/* deepVerify */true);
	    assertTrue("CellSet function call expression has "
		    + ((cellExpressionExceptions == null) ? 0 : cellExpressionExceptions.size()) + " violated constraints",
		    cellExpressionExceptions == null || cellExpressionExceptions.size() == 0);
	    assertEquals(new Fraction(12345+12345+45678),
		    ((NativeObject) new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce)).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Assembles a {@link FunctionCallExpression} that calls a function assembled here that,
     * when executed, constructs a multi-valued SalesOrderItem object.
     */
    private Expression createFacts(ResourceSet conn, SapClass salesOrder, SapClass salesOrderItem,
	    SapClass product, SapClass customer, Association productToCategory,
	    Association salesOrderItemToPrice, Association salesOrderItemToProduct,
	    Association customerToRegion, Association salesOrderToCustomer, Association salesOrderToSalesOrderItems) {
	// sig = function():SalesOrderItem[] {
	FunctionSignature sig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	sig.setOutput(MetamodelUtils.createClassTypeDefinition(conn, salesOrderItem, 0, -1));
	Block impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	sig.setImplementation(impl);
	
	// -------------- variable declarations -------------------
	//     SalesOrderItem[] result;
	NamedValueDeclaration resultDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	Variable result = conn.createElement(Variable.CLASS_DESCRIPTOR);
	result.setName("result");
	result.setOwnedTypeDefinition(sig.getOutput());
	resultDecl.setNamedValue(result);
	impl.getStatements().add(resultDecl);

	//     SalesOrder so;
	NamedValueDeclaration soDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	Variable so = conn.createElement(Variable.CLASS_DESCRIPTOR);
	so.setName("so");
	so.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, salesOrder));
	soDecl.setNamedValue(so);
	impl.getStatements().add(soDecl);
	
	//     SalesOrderItem soi;
	NamedValueDeclaration soiDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	Variable soi = conn.createElement(Variable.CLASS_DESCRIPTOR);
	soi.setName("soi");
	soi.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, salesOrderItem));
	soiDecl.setNamedValue(soi);
	impl.getStatements().add(soiDecl);
	
	//     Customer c;
	NamedValueDeclaration cDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	Variable c = conn.createElement(Variable.CLASS_DESCRIPTOR);
	c.setName("c");
	c.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, customer));
	cDecl.setNamedValue(c);
	impl.getStatements().add(cDecl);
	
	//     Product p;
	NamedValueDeclaration pDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	Variable p = conn.createElement(Variable.CLASS_DESCRIPTOR);
	p.setName("p");
	p.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, product));
	pDecl.setNamedValue(p);
	impl.getStatements().add(pDecl);

	// -------------- first Sales Order -------------------
	createCodeToCreateSalesOrder(conn, salesOrder, customer, customerToRegion,
		salesOrderToCustomer, impl, so, c, /* customerRegion */ "Americas");
	
	// -------------- first SOI -------------------
	createCodeToCreateSalesOrderItem(conn, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "12345", /* productCategory */ "Toys");
	//     result = soi;
	Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	assignment.setAssignTo(result);
	VariableExpression soiAccess = createVariableExpression(conn, soi);
	assignment.setArgument(soiAccess);
	impl.getStatements().add(assignment);
	
	// -------------- second SOI -------------------
	createCodeToCreateSalesOrderItem(conn, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "12345", /* productCategory */ "Toys");
	createCodeToAddSalesOrderItemToResult(conn, impl, result, soi);
	
	// -------------- third SOI -------------------
	createCodeToCreateSalesOrderItem(conn, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "23456", /* productCategory */ "Appliances");
	createCodeToAddSalesOrderItemToResult(conn, impl, result, soi);
	
	// -------------- second Sales Order -------------------
	createCodeToCreateSalesOrder(conn, salesOrder, customer, customerToRegion,
		salesOrderToCustomer, impl, so, c, /* customerRegion */ "EMEA");

	// -------------- fourth SOI -------------------
	createCodeToCreateSalesOrderItem(conn, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "34567", /* productCategory */ "Toys");
	createCodeToAddSalesOrderItemToResult(conn, impl, result, soi);
	
	// -------------- third Sales Order -------------------
	createCodeToCreateSalesOrder(conn, salesOrder, customer, customerToRegion,
		salesOrderToCustomer, impl, so, c, /* customerRegion */ "Americas");

	// -------------- fifth SOI -------------------
	createCodeToCreateSalesOrderItem(conn, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "45678", /* productCategory */ "Toys");
	createCodeToAddSalesOrderItemToResult(conn, impl, result, soi);
	
	//     return result;
	VariableExpression resultAccess = createVariableExpression(conn, result);
	Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	ret.setArgument(resultAccess);
	impl.getStatements().add(ret);
	// }
	
	return MetamodelUtils.createFunctionCallExpression(conn, sig);
    }

    /**
     * Creates the code that creates a sales order and an associated customer. The code
     * is added to the <tt>impl</tt> block.
     * @param salesOrder identifies the sales order class to instantiate
     * @param customer identified the customer class to instantiate
     * @param so the variable to bind the sales order to
     * @param c the variable to bind the customer to
     * @param customerRegion 
     */
    private void createCodeToCreateSalesOrder(ResourceSet conn, SapClass salesOrder,
	    SapClass customer, Association customerToRegion, Association salesOrderToCustomer,
	    Block impl, Variable so, Variable c, String customerRegion) {
	//     so = new SalesOrder();
	impl.getStatements().add(assignNewToVariable(conn, salesOrder, so));
	
	//     c = new Customer();
	impl.getStatements().add(assignNewToVariable(conn, customer, c));
	
	//     c.setRegion("Americas");
	AddLink addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	addLink.setAssociation(customerToRegion);
	VariableExpression cAccess = createVariableExpression(conn, c);
	addLink.getObjects().add(cAccess);
	addLink.getObjects().add(MetamodelUtils.createStringLiteral(conn, customerRegion));
	impl.getStatements().add(addLink);
	
	//     so.setCustomer(c);
	addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	addLink.setAssociation(salesOrderToCustomer);
	VariableExpression soAccess = createVariableExpression(conn, so);
	addLink.getObjects().add(soAccess);
	cAccess = createVariableExpression(conn, c);
	addLink.getObjects().add(cAccess);
	impl.getStatements().add(addLink);
    }

    /**
     * Create the code that adds the sales order item bound to the variable identified by
     * <tt>soi</tt> to the multi-valued object bound to the variable identified by <tt>result</tt>.
     * The code created is added to the block <tt>impl</tt>.
     */
    private void createCodeToAddSalesOrderItemToResult(ResourceSet conn, Block impl,
	    Variable result, Variable soi) {
	Assignment assignment;
	VariableExpression soiAccess;
	assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	assignment.setAssignTo(result);
	Including including = conn.createElement(Including.CLASS_DESCRIPTOR);
	VariableExpression resultAccess = createVariableExpression(conn, result);
	including.setSource(resultAccess);
	soiAccess = createVariableExpression(conn, soi);
	including.setArgument(soiAccess);
	assignment.setArgument(including);
	impl.getStatements().add(assignment);
    }

    /**
     * Creates statements and adds them to <tt>blockToAddStatementsTo</tt> that, when executed,
     * create an instance of the class identified by <tt>salesOrderItem</tt>. The item is linked
     * to a product that is created as instance of the class specified by <tt>product</tt>.
     * The product instance is bound to the variable identified by <tt>p</tt>. The sales order item
     * is added to the sales order that is expected to be bound to the variable identified by
     * <tt>so</tt>.
     * 
     * @param blockToAddStatementsTo the block to which the statements generated are added to
     * @param so the variable that holds the sales order to which to add the item
     * @param soi variable to bind the sales order item to that is created
     * @param p variable to bind the product to that is created
     * @param price the price to set for the item that will be created
     * @param productCategory the name of the product category for the product that will be created
     */
    private void createCodeToCreateSalesOrderItem(ResourceSet conn, SapClass salesOrderItem,
	    SapClass product, Association productToCategory, Association salesOrderItemToPrice,
	    Association salesOrderItemToProduct, Association salesOrderToSalesOrderItems,
	    Block blockToAddStatementsTo, Variable so, Variable soi, Variable p, String price,
	    String productCategory) {
	AddLink addLink;
	VariableExpression soAccess;
	//     soi = new SalesOrderItem();
	blockToAddStatementsTo.getStatements().add(assignNewToVariable(conn, salesOrderItem, soi));
	
	//     soi.setPrice(12345);
	addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	addLink.setAssociation(salesOrderItemToPrice);
	VariableExpression soiAccess = createVariableExpression(conn, soi);
	addLink.getObjects().add(soiAccess);
	addLink.getObjects().add(MetamodelUtils.createNumberLiteral(conn, price));
	blockToAddStatementsTo.getStatements().add(addLink);
	
	//     p = new Product();
	blockToAddStatementsTo.getStatements().add(assignNewToVariable(conn, product, p));
	
	//     p.setCategory("Toys");
	addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	addLink.setAssociation(productToCategory);
	VariableExpression pAccess = createVariableExpression(conn, p);
	addLink.getObjects().add(pAccess);
	addLink.getObjects().add(MetamodelUtils.createStringLiteral(conn, productCategory));
	blockToAddStatementsTo.getStatements().add(addLink);
	
	//     soi.setProduct(p);
	addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	addLink.setAssociation(salesOrderItemToProduct);
	soiAccess = createVariableExpression(conn, soi);
	addLink.getObjects().add(soiAccess);
	pAccess = createVariableExpression(conn, p);
	addLink.getObjects().add(pAccess);
	blockToAddStatementsTo.getStatements().add(addLink);
	
	//     soi.setSalesOrder(so);
	addLink = conn.createElement(AddLink.CLASS_DESCRIPTOR);
	addLink.setAssociation(salesOrderToSalesOrderItems);
	soAccess = createVariableExpression(conn, so);
	addLink.getObjects().add(soAccess);
	soiAccess = createVariableExpression(conn, soi);
	addLink.getObjects().add(soiAccess);
	blockToAddStatementsTo.getStatements().add(addLink);
    }

    private Statement assignNewToVariable(ResourceSet conn, SapClass clazz, Variable variable) {
	ObjectCreationExpression oce = conn.createElement(ObjectCreationExpression.CLASS_DESCRIPTOR);
	oce.setClassToInstantiate(clazz);
	oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, clazz));
	Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	assignment.setAssignTo(variable);
	assignment.setArgument(oce);
	return assignment;
    }

    private CellSet createCellSet(ResourceSet conn, SapClass salesOrderItem,
	    Association salesOrderItemToPrice, Association salesOrderItemToProduct,
	    Association salesOrderToSalesOrderItems, Association salesOrderToCustomer,
	    Association productToCategory, Association customerToRegion) {
	// The value function determines the price from a sales order item
	FunctionSignature valueFunctionSignature = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	Block valueFunction = conn.createElement(Block.CLASS_DESCRIPTOR);
	Parameter valueFunctionParam = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	valueFunctionParam.setName("item");
	valueFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, salesOrderItem, 1, 1));
	valueFunctionSignature.getInput().add(valueFunctionParam);
	valueFunctionSignature.setOutput(salesOrderItemToPrice.getEnds().get(1).getType());
	valueFunctionSignature.setImplementation(valueFunction);
	AssociationEndNavigationExpression navigateToPrice =
	conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	VariableExpression itemParameterValue = createVariableExpression(conn, valueFunctionParam);
	navigateToPrice.setObject(itemParameterValue);
	navigateToPrice.setToEnd(salesOrderItemToPrice.getEnds().get(1));
	Return valueFunctionReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	valueFunctionReturn.setArgument(navigateToPrice);
	valueFunction.getStatements().add(valueFunctionReturn);
	
	// The aggregation function sums up all input values which are expected to be of type Number
	FunctionSignature aggregationFunctionSignature = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	Block aggregationFunction = conn.createElement(Block.CLASS_DESCRIPTOR);
	Parameter aggregationFunctionParam = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	aggregationFunctionParam.setName("prices");
	aggregationFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn,
	    salesOrderItemToPrice.getEnds().get(1).getType().getClazz(), 0, -1));
	aggregationFunctionParam.setOwnedTypeDefinition(aggregationFunctionParam.getType());
	aggregationFunctionSignature.getInput().add(aggregationFunctionParam);
	aggregationFunctionSignature.setOutput(salesOrderItemToPrice.getEnds().get(1).getType());
	aggregationFunctionSignature.setImplementation(aggregationFunction);
	Iterate iterate = conn.createElement(Iterate.CLASS_DESCRIPTOR);
	behavioral.actions.Iterator iterator = conn.createElement(behavioral.actions.Iterator.CLASS_DESCRIPTOR);
	iterator.setName("i");
	iterator.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	iterate.getIterators().add(iterator);
	VariableExpression paramReference = createVariableExpression(conn, aggregationFunctionParam);
	iterate.setSource(paramReference);
	Constant accumulator = conn.createElement(Constant.CLASS_DESCRIPTOR);
	accumulator.setName("acc");
	accumulator.setInitExpression(MetamodelUtils.createNumberLiteral(conn, "0"));
	iterate.setAccumulator(accumulator);
	MethodCallExpression add = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	VariableExpression accAccess = createVariableExpression(conn, accumulator);
	add.setObject(accAccess);
	VariableExpression iteratorAccess = createVariableExpression(conn, iterator);
	add.getParameters().add(iteratorAccess);
	add.setMethodSignature(MetamodelUtils.findMethod(conn, "Number", "plus"));
	iterate.setIteratorExpression(add);
	Return aggregationFunctionReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	aggregationFunctionReturn.setArgument(iterate);
	aggregationFunction.getStatements().add(aggregationFunctionReturn);

	// set up the cell set
	CellSet cellSet = conn.createElement(CellSet.CLASS_DESCRIPTOR);
	cellSet.setFactsType(MetamodelUtils.createClassTypeDefinition(conn, salesOrderItem, 0, -1));
	cellSet.setAggregationFunction(aggregationFunctionSignature);
	cellSet.setValueFunction(valueFunctionSignature);
	// product category dimension
	FunctionSignature categoryDimensionSignature = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	Block categoryDimensionFunction = conn.createElement(Block.CLASS_DESCRIPTOR);
	Parameter categoryDimensionFunctionParam = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	categoryDimensionFunctionParam.setName("salesOrderItem");
	categoryDimensionFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn,
	    salesOrderItemToPrice.getEnds().get(0).getType().getClazz(), 1, 1));
	categoryDimensionFunctionParam.setOwnedTypeDefinition(categoryDimensionFunctionParam.getType());
	categoryDimensionSignature.getInput().add(categoryDimensionFunctionParam);
	categoryDimensionSignature.setOutput(productToCategory.getEnds().get(1).getType());
	categoryDimensionSignature.setImplementation(categoryDimensionFunction);
	VariableExpression categoryDimensionFunctionParamAccess = createVariableExpression(conn,
		categoryDimensionFunctionParam);
	AssociationEndNavigationExpression getProduct = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	getProduct.setObject(categoryDimensionFunctionParamAccess);
	getProduct.setToEnd(salesOrderItemToProduct.getEnds().get(1));
	AssociationEndNavigationExpression getCategory = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	getCategory.setObject(getProduct);
	getCategory.setToEnd(productToCategory.getEnds().get(1));
	Return categoryDimensionFunctionReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	categoryDimensionFunctionReturn.setArgument(getCategory);
	categoryDimensionFunction.getStatements().add(categoryDimensionFunctionReturn);
	Dimension categoryDimension = conn.createElement(Dimension.CLASS_DESCRIPTOR);
	categoryDimension.setName("productCategory");
	categoryDimension.setCharacteristicFunction(categoryDimensionSignature);
	cellSet.getDimensions().add(categoryDimension);
	// customer region dimension
	FunctionSignature regionDimensionSignature = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	Block regionDimensionFunction = conn.createElement(Block.CLASS_DESCRIPTOR);
	Parameter regionDimensionFunctionParam = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	regionDimensionFunctionParam.setName("salesOrderItem");
	regionDimensionFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn,
	    salesOrderItemToPrice.getEnds().get(0).getType().getClazz(), 1, 1));
	regionDimensionFunctionParam.setOwnedTypeDefinition(regionDimensionFunctionParam.getType());
	regionDimensionSignature.getInput().add(regionDimensionFunctionParam);
	regionDimensionSignature.setOutput(customerToRegion.getEnds().get(1).getType());
	regionDimensionSignature.setImplementation(regionDimensionFunction);
	VariableExpression regionDimensionFunctionParamAccess = createVariableExpression(conn,
		regionDimensionFunctionParam);
	AssociationEndNavigationExpression getSalesOrder = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	getSalesOrder.setObject(regionDimensionFunctionParamAccess);
	getSalesOrder.setToEnd(salesOrderToSalesOrderItems.getEnds().get(0));
	AssociationEndNavigationExpression getCustomer = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	getCustomer.setObject(getSalesOrder);
	getCustomer.setToEnd(salesOrderToCustomer.getEnds().get(1));
	AssociationEndNavigationExpression getRegion = conn.createElement(AssociationEndNavigationExpression.CLASS_DESCRIPTOR);
	getRegion.setObject(getCustomer);
	getRegion.setToEnd(customerToRegion.getEnds().get(1));
	Return regionDimensionFunctionReturn = conn.createElement(Return.CLASS_DESCRIPTOR);
	regionDimensionFunctionReturn.setArgument(getRegion);
	regionDimensionFunction.getStatements().add(regionDimensionFunctionReturn);
	Dimension regionDimension = conn.createElement(Dimension.CLASS_DESCRIPTOR);
	regionDimension.setName("customerRegion");
	regionDimension.setCharacteristicFunction(regionDimensionSignature);
	cellSet.getDimensions().add(regionDimension);
	return cellSet;
    }

    private VariableExpression createVariableExpression(ResourceSet conn,
	    NamedValue variable) {
	VariableExpression itemParameterValue = conn.createElement(VariableExpression.CLASS_DESCRIPTOR);
	itemParameterValue.setVariable(variable);
	return itemParameterValue;
    }
    
    public void testAssociationEndSignatureImplementations() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    
	    // set up data structures
	    SapClass salesOrderItem = createClass(conn, "SalesOrderItem");
	    SapClass product = createClass(conn, "Product");
	    Association salesOrderItemToProduct = MetamodelUtils.createAssociation(conn, salesOrderItem, "salesOrderItems", 0,
		    -1, /* nav */ false, /* comp */ true, /* ordered */ false,
		    /* unique */ false, product, "product", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false);
	    Map<Accessors, MethodSignature> productAccessors = exposeAssociationEnd(conn,
		    salesOrderItemToProduct.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	    SapClass salesOrder = createClass(conn, "SalesOrder");
	    Association salesOrderToSalesOrderItems = MetamodelUtils.createAssociation(conn, salesOrder, "salesOrder",
		    1, 1, /* nav */ true, /* comp */ true, /* ordered */ false, /* unique */ false,
		    salesOrderItem, "items", 0, -1, /* nav */ true, /* comp */ false, /* ordered */ true,
		    /* unique */ false);
	    Map<Accessors, MethodSignature> itemsAccessors = exposeAssociationEnd(conn,
		    salesOrderToSalesOrderItems.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.ADDER, Accessors.REMOVER });
	    SapClass customer = createClass(conn, "Customer");
	    Association salesOrderToCustomer = MetamodelUtils.createAssociation(conn, salesOrder, "salesOrders",
		    0, -1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false,
		    customer, "customer", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    SapClass string = MetamodelUtils.findClass(conn, "String");
	    Association customerToRegion = MetamodelUtils.createAssociation(conn, customer, "customerWithRegion",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "region", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    Association productToCategory = MetamodelUtils.createAssociation(conn, product, "productWithCategory",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "category", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    Map<Accessors, MethodSignature> categoryAccessors = exposeAssociationEnd(conn,
		    productToCategory.getEnds().get(1), new Accessors[] { Accessors.GETTER,
			    Accessors.SETTER });

	    // define a function that uses setter/getter/adder/remover to establish an
	    // object graph when executed, and from that determines a value
	    FunctionSignature sig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinition(conn, salesOrderItem, 0, -1));
	    Block impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	    sig.setImplementation(impl);

	    // -------------- variable declarations -------------------
	    // SalesOrderItem[] result;
	    NamedValueDeclaration resultDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable result = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    result.setName("result");
	    result.setOwnedTypeDefinition(sig.getOutput());
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);

	    // SalesOrder so;
	    NamedValueDeclaration soDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable so = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    so.setName("so");
	    so.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, salesOrder));
	    soDecl.setNamedValue(so);
	    impl.getStatements().add(soDecl);

	    // SalesOrderItem soi;
	    NamedValueDeclaration soiDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable soi = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    soi.setName("soi");
	    soi.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, salesOrderItem));
	    soiDecl.setNamedValue(soi);
	    impl.getStatements().add(soiDecl);

	    // Customer c;
	    NamedValueDeclaration cDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable c = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    c.setName("c");
	    c.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, customer));
	    cDecl.setNamedValue(c);
	    impl.getStatements().add(cDecl);

	    // Product p;
	    NamedValueDeclaration pDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable p = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    p.setName("p");
	    p.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, product));
	    pDecl.setNamedValue(p);
	    impl.getStatements().add(pDecl);

	    createCodeToCreateSalesOrder(conn, salesOrder, customer, customerToRegion,
		    salesOrderToCustomer, impl, so, c, "EMEA");
	    // item #1
	    impl.getStatements().add(assignNewToVariable(conn, salesOrderItem, soi));
	    createCodeToInvokeMethod(conn, itemsAccessors.get(Accessors.ADDER), so, soi, impl);
	    impl.getStatements().add(assignNewToVariable(conn, product, p));
	    createCodeToInvokeMethod(conn, productAccessors.get(Accessors.SETTER), soi, p, impl);
	    createCodeToInvokeMethod(conn, categoryAccessors.get(Accessors.SETTER),
		    createVariableExpression(conn, p),
		    MetamodelUtils.createStringLiteral(conn, "TheCategory1"), impl);

	    // item #2
	    impl.getStatements().add(assignNewToVariable(conn, salesOrderItem, soi));
	    createCodeToInvokeMethod(conn, itemsAccessors.get(Accessors.ADDER), so, soi, impl);
	    impl.getStatements().add(assignNewToVariable(conn, product, p));
	    createCodeToInvokeMethod(conn, productAccessors.get(Accessors.SETTER), soi, p, impl);
	    createCodeToInvokeMethod(conn, categoryAccessors.get(Accessors.SETTER),
		    createVariableExpression(conn, p),
		    MetamodelUtils.createStringLiteral(conn, "TheCategory2"), impl);

	    // item #3
	    impl.getStatements().add(assignNewToVariable(conn, salesOrderItem, soi));
	    createCodeToInvokeMethod(conn, itemsAccessors.get(Accessors.ADDER), so, soi, impl);
	    impl.getStatements().add(assignNewToVariable(conn, product, p));
	    createCodeToInvokeMethod(conn, productAccessors.get(Accessors.SETTER), soi, p, impl);
	    createCodeToInvokeMethod(conn, categoryAccessors.get(Accessors.SETTER),
		    createVariableExpression(conn, p),
		    MetamodelUtils.createStringLiteral(conn, "TheCategory3"), impl);
	    
	    // remove item #3 again
	    createCodeToInvokeMethod(conn, itemsAccessors.get(Accessors.REMOVER), so, soi, impl);
	    
	    // now assemble the return expression that uses getters to navigate throughout the graph
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    ret.setArgument(createMethodCallExpression(conn, categoryAccessors.get(Accessors.GETTER),
		    createMethodCallExpression(conn, productAccessors.get(Accessors.GETTER),
		    createMethodCallExpression(conn, itemsAccessors.get(Accessors.GETTER),
			    createVariableExpression(conn, so)))));
	    impl.getStatements().add(ret);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce); // multi-valued because
	    // SalesOrder-->SalesOrderItem is multi-valued
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> iter = evalResult.flatten().iterator();
	    // order is reliable because salesOrderToSalesOrderItem is ordered on the item end
	    assertEquals("TheCategory1", ((NativeObject) iter.next()).getNativeObject());
	    assertEquals("TheCategory2", ((NativeObject) iter.next()).getNativeObject());
	    assertFalse(iter.hasNext()); // should be exactly two results; item #3 was removed again
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Creates a statement that invokes a single-argument method on the value bound to the variable identified
     * by <tt>on</tt>, passing the value bound to the variable identified by <tt>arg</tt>. The
     * resulting statement is appended to <tt>impl</tt>'s statement sequence.
     */
    private void createCodeToInvokeMethod(ResourceSet conn,
	    MethodSignature method, Variable on, Variable arg, Block impl) {
	Expression onExp = createVariableExpression(conn, on);
	Expression argExp = createVariableExpression(conn, arg);
	createCodeToInvokeMethod(conn, method, onExp, argExp, impl);
    }

    /**
     * Creates a statement that invokes a single-argument method on the value to which <tt>onExp</tt>
     * evaluates, passing the value to which <tt>argExp</tt> evaluates. The
     * resulting statement is appended to <tt>impl</tt>'s statement sequence.
     */
    private void createCodeToInvokeMethod(ResourceSet conn, MethodSignature method,
	    Expression onExp, Expression argExp, Block impl) {
	MethodCallExpression mce = createMethodCallExpression(conn, method, onExp, argExp);
	ExpressionStatement es = conn.createElement(ExpressionStatement.CLASS_DESCRIPTOR);
	es.setExpression(mce);
	impl.getStatements().add(es);
    }

    /**
     * Creates and returns a method call expression. If argument expressions (<tt>argExp</tt>)
     * are provided, they are added to the expression's parameter list.
     */
    private MethodCallExpression createMethodCallExpression(ResourceSet conn,
	    MethodSignature method, Expression onExp, Expression... argExps) {
	MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	mce.setObject(onExp);
	mce.setMethodSignature(method);
	for (Expression argExp:argExps) {
	    mce.getParameters().add(argExp);
	}
	return mce;
    }
    
    public void testForeach() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    // sig = function() {
	    FunctionSignature sig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    Block impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	    sig.setImplementation(impl);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	    sig.setOwnedTypeDefinitions(sig.getOutput());
	    //   Number[] arr;
	    NamedValueDeclaration arrDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable arr = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    arr.setName("arr");
	    arr.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    arrDecl.setNamedValue(arr);
	    impl.getStatements().add(arrDecl);
	    //   Number result = 0;
	    NamedValueDeclaration resultDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable result = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    result.setName("result");
	    result.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    result.setInitExpression(MetamodelUtils.createNumberLiteral(conn, "0"));
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);
	    int count = 3;
	    //    arr = arr->including(1);
	    //    arr = arr->including(2);
	    //    arr = arr->including(3);
	    for (int i=1; i<=count; i++) {
		Including incl = conn.createElement(Including.CLASS_DESCRIPTOR);
		incl.setSource(createVariableExpression(conn, arr));
		incl.setArgument(MetamodelUtils.createNumberLiteral(conn, ""+i));
		Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
		assignment.setArgument(incl);
		assignment.setAssignTo(arr);
		impl.getStatements().add(assignment);
	    }
	    //   foreach (Number i:arr) {
	    Foreach foreach = conn.createElement(Foreach.CLASS_DESCRIPTOR);
	    impl.getStatements().add(foreach);
	    foreach.setCollection(createVariableExpression(conn, arr));
	    behavioral.actions.Iterator iter = conn.createElement(behavioral.actions.Iterator.CLASS_DESCRIPTOR);
	    iter.setName("i");
	    iter.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	    foreach.setForVariable(iter);
	    Block foreachBlock = conn.createElement(Block.CLASS_DESCRIPTOR);
	    foreach.getNestedBlocks().add(foreachBlock);
	    //     result = result.plus(i);
	    MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    mce.setObject(createVariableExpression(conn, result));
	    mce.setMethodSignature(MetamodelUtils.findMethod(conn, "Number", "plus"));
	    mce.getParameters().add(createVariableExpression(conn, iter));
	    Assignment assignmentToResult = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	    assignmentToResult.setArgument(mce);
	    assignmentToResult.setAssignTo(result);
	    foreachBlock.getStatements().add(assignmentToResult);
	    //   }
	    //   return result;
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    ret.setArgument(createVariableExpression(conn, result));
	    impl.getStatements().add(ret);
	    // }
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce);
	    assertEquals(new Fraction(count*(count+1)/2), ((NativeObject) evalResult).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public void testExcluding() {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    // sig = function() {
	    FunctionSignature sig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    Block impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	    sig.setImplementation(impl);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	    sig.setOwnedTypeDefinitions(sig.getOutput());
	    //   Number[] arr;
	    NamedValueDeclaration arrDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable arr = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    arr.setName("arr");
	    arr.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    arrDecl.setNamedValue(arr);
	    impl.getStatements().add(arrDecl);
	    //   Number result = 0;
	    NamedValueDeclaration resultDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable result = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    result.setName("result");
	    result.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    result.setInitExpression(MetamodelUtils.createNumberLiteral(conn, "0"));
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);
	    int count = 3;
	    //    arr = arr->including(1);
	    //    arr = arr->including(2);
	    //    arr = arr->including(3);
	    for (int i=1; i<=count; i++) {
		Including incl = conn.createElement(Including.CLASS_DESCRIPTOR);
		incl.setSource(createVariableExpression(conn, arr));
		incl.setArgument(MetamodelUtils.createNumberLiteral(conn, ""+i));
		Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
		assignment.setArgument(incl);
		assignment.setAssignTo(arr);
		impl.getStatements().add(assignment);
	    }
	    //   arr = arr->excluding(2);
	    Excluding excl = conn.createElement(Excluding.CLASS_DESCRIPTOR);
	    excl.setSource(createVariableExpression(conn, arr));
	    excl.setArgument(MetamodelUtils.createNumberLiteral(conn, "2"));
	    Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	    assignment.setArgument(excl);
	    assignment.setAssignTo(arr);
	    impl.getStatements().add(assignment);

	    //   foreach (Number i:arr) {
	    Foreach foreach = conn.createElement(Foreach.CLASS_DESCRIPTOR);
	    impl.getStatements().add(foreach);
	    foreach.setCollection(createVariableExpression(conn, arr));
	    behavioral.actions.Iterator iter = conn.createElement(behavioral.actions.Iterator.CLASS_DESCRIPTOR);
	    iter.setName("i");
	    iter.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	    foreach.setForVariable(iter);
	    Block foreachBlock = conn.createElement(Block.CLASS_DESCRIPTOR);
	    foreach.getNestedBlocks().add(foreachBlock);
	    //     result = result.plus(i);
	    MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    mce.setObject(createVariableExpression(conn, result));
	    mce.setMethodSignature(MetamodelUtils.findMethod(conn, "Number", "plus"));
	    mce.getParameters().add(createVariableExpression(conn, iter));
	    Assignment assignmentToResult = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	    assignmentToResult.setArgument(mce);
	    assignmentToResult.setAssignTo(result);
	    foreachBlock.getStatements().add(assignmentToResult);
	    //   }
	    //   return result;
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    ret.setArgument(createVariableExpression(conn, result));
	    impl.getStatements().add(ret);
	    // }
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce);
	    assertEquals(new Fraction(count*(count+1)/2-2), ((NativeObject) evalResult).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Computes the sum of the numbers from <tt>0..count</tt> where each number gets inserted
     * <tt>times</tt> times in a row, excluding those specified in <tt>toExclude</tt>. The
     * collection of numbers to exclude is unique if <tt>unique==true</tt>. The exclusion starts
     * at position <tt>at</tt>.
     */
    public int sumWithExcludingAt(int count, int times, int[] toExclude, int at, boolean unique) {
	IProject project = Activator.getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    ResourceSet conn = Activator.createConnection(project);
	    // sig = function() {
	    FunctionSignature sig = conn.createElement(FunctionSignature.CLASS_DESCRIPTOR);
	    Block impl = conn.createElement(Block.CLASS_DESCRIPTOR);
	    sig.setImplementation(impl);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	    sig.setOwnedTypeDefinitions(sig.getOutput());
	    //   Number[] arr;
	    NamedValueDeclaration arrDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable arr = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    arr.setName("arr");
	    arr.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ true, unique));
	    arrDecl.setNamedValue(arr);
	    impl.getStatements().add(arrDecl);
	    //   Number result = 0;
	    NamedValueDeclaration resultDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable result = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    result.setName("result");
	    result.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ true, unique));
	    result.setInitExpression(MetamodelUtils.createNumberLiteral(conn, "0"));
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);
	    //    arr = arr->including(0);
	    //    ... (times times)
	    //    arr = arr->including(0);
	    //    ...
	    //    arr = arr->including(count-1);
	    //    ... (times times)
	    //    arr = arr->including(count-1);
	    for (int i=0; i<count; i++) {
		for (int t = 0; t < times; t++) {
		    Including incl = conn.createElement(Including.CLASS_DESCRIPTOR);
		    incl.setSource(createVariableExpression(conn, arr));
		    incl.setArgument(MetamodelUtils.createNumberLiteral(conn, "" + i));
		    Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
		    assignment.setArgument(incl);
		    assignment.setAssignTo(arr);
		    impl.getStatements().add(assignment);
		}
	    }
	    //   Number[] toExclude;
	    NamedValueDeclaration toExcludeDecl = conn.createElement(NamedValueDeclaration.CLASS_DESCRIPTOR);
	    Variable toExcludeVar = conn.createElement(Variable.CLASS_DESCRIPTOR);
	    toExcludeVar.setName("toExclude");
	    toExcludeVar.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(conn, MetamodelUtils.findClass(conn, "Number"), 0, -1,
		    /* ordered */ true, unique));
	    toExcludeDecl.setNamedValue(toExcludeVar);
	    impl.getStatements().add(toExcludeDecl);
	    
	    //    toExclude = toExclude->including(toExclude[0]);
	    //    ...
	    //    toExclude = toExclude->including(toExclude[toExclude.length-1]);
	    for (int excl:toExclude) {
		Including incl = conn.createElement(Including.CLASS_DESCRIPTOR);
		incl.setSource(createVariableExpression(conn, toExcludeVar));
		incl.setArgument(MetamodelUtils.createNumberLiteral(conn, ""+excl));
		Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
		assignment.setArgument(incl);
		assignment.setAssignTo(toExcludeVar);
		impl.getStatements().add(assignment);
	    }
	    
	    //   arr = arr->excludingAt(toExclude, at);
	    ExcludingAt excl = conn.createElement(ExcludingAt.CLASS_DESCRIPTOR);
	    excl.setSource(createVariableExpression(conn, arr));
	    excl.setArgument(createVariableExpression(conn, toExcludeVar));
	    excl.setAt(at);
	    Assignment assignment = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	    assignment.setArgument(excl);
	    assignment.setAssignTo(arr);
	    impl.getStatements().add(assignment);

	    //   foreach (Number i:arr) {
	    Foreach foreach = conn.createElement(Foreach.CLASS_DESCRIPTOR);
	    impl.getStatements().add(foreach);
	    foreach.setCollection(createVariableExpression(conn, arr));
	    behavioral.actions.Iterator iter = conn.createElement(behavioral.actions.Iterator.CLASS_DESCRIPTOR);
	    iter.setName("i");
	    iter.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(conn, MetamodelUtils.findClass(conn, "Number")));
	    foreach.setForVariable(iter);
	    Block foreachBlock = conn.createElement(Block.CLASS_DESCRIPTOR);
	    foreach.getNestedBlocks().add(foreachBlock);
	    //     result = result.plus(i);
	    MethodCallExpression mce = conn.createElement(MethodCallExpression.CLASS_DESCRIPTOR);
	    mce.setObject(createVariableExpression(conn, result));
	    mce.setMethodSignature(MetamodelUtils.findMethod(conn, "Number", "plus"));
	    mce.getParameters().add(createVariableExpression(conn, iter));
	    Assignment assignmentToResult = conn.createElement(Assignment.CLASS_DESCRIPTOR);
	    assignmentToResult.setArgument(mce);
	    assignmentToResult.setAssignTo(result);
	    foreachBlock.getStatements().add(assignmentToResult);
	    //   }
	    //   return result;
	    Return ret = conn.createElement(Return.CLASS_DESCRIPTOR);
	    ret.setArgument(createVariableExpression(conn, result));
	    impl.getStatements().add(ret);
	    // }
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(conn, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(conn, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce);
	    return ((Fraction) ((NativeObject) evalResult).getNativeObject()).intValue();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    public void testExcludingAt() {
	assertEquals( 4, sumWithExcludingAt(/* up to */ 4, /* times */ 1, new int[] { 2 }, 2, /* unique */ false));
	assertEquals( 6, sumWithExcludingAt(/* up to */ 4, /* times */ 1, new int[] { 2 }, 3, /* unique */ false));
	assertEquals(10, sumWithExcludingAt(/* up to */ 4, /* times */ 2, new int[] { 2 }, 4, /* unique */ false));
	assertEquals(10, sumWithExcludingAt(/* up to */ 4, /* times */ 2, new int[] { 2 }, 5, /* unique */ false));
	assertEquals( 8, sumWithExcludingAt(/* up to */ 4, /* times */ 2, new int[] { 2, 2 }, 4, /* unique */ false));
	assertEquals(10, sumWithExcludingAt(/* up to */ 4, /* times */ 2, new int[] { 2, 2 }, 5, /* unique */ false));
	assertEquals( 7, sumWithExcludingAt(/* up to */ 4, /* times */ 2, new int[] { 2, 3 }, 5, /* unique */ false));
    }

}
