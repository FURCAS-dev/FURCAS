package com.sap.runlet.interpreter.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommand;
import org.junit.BeforeClass;
import org.junit.Test;

import behavioral.actions.ActionsFactory;
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

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
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
import data.classes.util.ClassesValidator;
import dataaccess.analytics.AnalyticsFactory;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;
import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsFactory;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.VariableExpression;
import dataaccess.expressions.collectionexpressions.CollectionexpressionsFactory;
import dataaccess.expressions.collectionexpressions.Excluding;
import dataaccess.expressions.collectionexpressions.ExcludingAt;
import dataaccess.expressions.collectionexpressions.Including;
import dataaccess.expressions.collectionexpressions.Iterate;
import dataaccess.expressions.fp.FpFactory;
import dataaccess.expressions.fp.FunctionFromMethodExpr;
import dataaccess.expressions.literals.LiteralsFactory;
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
    private static boolean indexCreated = false;
    private ResourceSet resourceSet;

    @BeforeClass
    public void setUp() throws CoreException {
        resourceSet = new ResourceSetImpl();
        if (!indexCreated) {
            updateIndex(resourceSet);
            indexCreated = true;
        }
    }

    private void updateIndex(final ResourceSet resourceSet) {
        IndexFactory.getInstance().executeUpdateCommand(new UpdateCommand() {
            public void preCommitAction(IndexUpdater updater) {
            }
            public void postCommitAction() {
            }

            public void execute(IndexUpdater updater) {
                final ResourceIndexer indexer = new ResourceIndexer();
                List<String> uris = new ArrayList<String>();
                for (String packUri : EPackage.Registry.INSTANCE.keySet()) {
                    uris.add(packUri);
                }
                for (String packUri : uris) {
                    try {
                        indexer.resourceChanged(updater, EPackage.Registry.INSTANCE.getEPackage(packUri).eResource());
                    } catch (Exception e) {
                        System.err.println("Error indexing uri: " + packUri); //$NON-NLS-1$
                        e.printStackTrace();
                    }
                }
                indexer.resourceChanged(updater, resourceSet.getResource(URI.createURI(
                        "platform:/plugin/com.sap.runlet.interpreter.test/src/com/sap/runlet/interpreter/test/NgpmModel.xmi"),
                        /* loadOnDemand */ true));
            }
        });
    }
     
    @Test
    public void testStringLiteral() {
	try {
	    StringLiteral nl = LiteralsFactory.eINSTANCE.createStringLiteral();
	    nl.setLiteral("Humba");
	    SapClass stringClass = MetamodelUtils.findClass(resourceSet, "String");
    	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    stringClass);
    	    nl.setOwnedTypeDefinition(ctd);
    	    NativeObject result = (NativeObject) new RunletInterpreter(resourceSet,
    		    new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(nl);
    	    assertEquals("Humba", result.getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Test
    public void testNumberLiterals() {
	try {
	    NumberLiteral nl = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
    	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass);
    	    nl.setOwnedTypeDefinition(ctd);
    	    NativeObject result = (NativeObject) new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(nl);
    	    assertEquals(new Fraction("123.450"), result.getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    @Test
    public void testNumberAdd() {
	try {
	    NumberLiteral nl = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    nl.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass));
	    NumberLiteral nl2 = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl2.setLiteral("123.450");
	    nl2.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass));
	    MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    MethodSignature sig = MetamodelUtils.findMethod(resourceSet, "Number", "plus");
	    mce.setMethodSignature(sig);
	    mce.setObject(nl);
	    mce.getParameters().add(nl2);
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
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
    @Test
    public void testSimpleVariableAssignmentInBlock() {
	try {
	    NumberLiteral nl = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass);
	    nl.setOwnedTypeDefinition(ctd);

	    Block block = ActionsFactory.eINSTANCE.createBlock();
	    NamedValueDeclaration varDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable a = ActionsFactory.eINSTANCE.createVariable();
	    a.setName("a");
	    a.setInitExpression(nl);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    
	    VariableExpression aExp = createVariableExpression(a);
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    ret.setArgument(aExp);
	    block.getStatements().add(ret);
	    
	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    funcSig.setOutput(ret.getArgument().getType()); // use type of return as signature's output
	    funcSig.setImplementation(block);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
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
    @Test
    public void testUseOfVariableBeforeDeclaration() {
	try {
	    NumberLiteral nl = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass);
	    nl.setOwnedTypeDefinition(ctd);

	    Block block = ActionsFactory.eINSTANCE.createBlock();
	    Variable a = ActionsFactory.eINSTANCE.createVariable();
	    a.setName("a");
	    a.setInitExpression(nl);
	    
	    VariableExpression aExp = createVariableExpression(a);
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    ret.setArgument(aExp);
	    block.getStatements().add(ret);
	    
	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    funcSig.setOutput(ret.getArgument().getType()); // use type of return as signature's output
	    funcSig.setImplementation(block);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
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
    @Test
    public void testRecursiveFunctionCall() {
	try {
	    Block block = ActionsFactory.eINSTANCE.createBlock();

	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    Parameter i = ClassesFactory.eINSTANCE.createParameter();
	    i.setName("i");
	    i.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass));
	    funcSig.getInput().add(i);
	    funcSig.setOutput(i.getType());
	    funcSig.setImplementation(block);
	    VariableExpression iExp = createVariableExpression(i);
	    IfElse ifElse = ActionsFactory.eINSTANCE.createIfElse();
	    MethodCallExpression iGreaterZero = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    iGreaterZero.setObject(iExp);
	    MethodSignature greaterThan = MetamodelUtils.findMethod(resourceSet, "Number", "greaterThan");
	    iGreaterZero.setMethodSignature(greaterThan);
	    iGreaterZero.setObject(iExp);
	    iGreaterZero.getParameters().add(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	    ifElse.setCondition(iGreaterZero);
	    Block ifBranch = ActionsFactory.eINSTANCE.createBlock();
	    MethodCallExpression iMinusOne = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(i);
	    iMinusOne.setObject(iExp);
	    MethodSignature minus = MetamodelUtils.findMethod(resourceSet, "Number", "minus");
	    iMinusOne.setMethodSignature(minus);
	    iMinusOne.getParameters().add(MetamodelUtils.createNumberLiteral(resourceSet, "1"));
	    FunctionCallExpression recursion = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    recursion.getParameters().add(iMinusOne);
	    
	    MethodCallExpression iPlusRecursion = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(i);
	    iPlusRecursion.setObject(iExp);
	    MethodSignature plus = MetamodelUtils.findMethod(resourceSet, "Number", "plus");
	    iPlusRecursion.setMethodSignature(plus);
	    iPlusRecursion.getParameters().add(recursion);
	    
	    Return retIf = ActionsFactory.eINSTANCE.createReturn();
	    retIf.setArgument(iPlusRecursion);
	    ifBranch.getStatements().add(retIf);
	    
	    Block elseBranch = ActionsFactory.eINSTANCE.createBlock();
	    Return retElse = ActionsFactory.eINSTANCE.createReturn();
	    retElse.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	    elseBranch.getStatements().add(retElse);

	    ifElse.getNestedBlocks().add(ifBranch);
	    ifElse.getNestedBlocks().add(elseBranch);
	    
	    block.getStatements().add(ifElse);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    fce.getParameters().add(MetamodelUtils.createNumberLiteral(resourceSet, "10"));
	    
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
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
    @Test
    public void testVariableScoping() {
	try {
	    Block block = ActionsFactory.eINSTANCE.createBlock();
	    NamedValueDeclaration varDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable a = ActionsFactory.eINSTANCE.createVariable();
	    a.setName("a");
	    a.setInitExpression(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);

	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    Parameter i = ClassesFactory.eINSTANCE.createParameter();
	    i.setName("i");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    i.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass));
	    funcSig.getInput().add(i);
	    funcSig.setOutput(i.getType());
	    funcSig.setImplementation(block);
	    VariableExpression iExp = createVariableExpression(i);
	    IfElse ifElse = ActionsFactory.eINSTANCE.createIfElse();
	    MethodCallExpression iGreaterZero = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    iGreaterZero.setObject(iExp);
	    MethodSignature greaterThan = MetamodelUtils.findMethod(resourceSet, "Number", "greaterThan");
	    iGreaterZero.setMethodSignature(greaterThan);
	    iGreaterZero.setObject(iExp);
	    iGreaterZero.getParameters().add(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	    ifElse.setCondition(iGreaterZero);

	    Block ifBranch = ActionsFactory.eINSTANCE.createBlock();
	    NamedValueDeclaration innerVarDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable innerA = ActionsFactory.eINSTANCE.createVariable();
	    innerA.setName("a");
	    innerA.setInitExpression(MetamodelUtils.createNumberLiteral(resourceSet, "1"));
	    innerVarDecl.setNamedValue(innerA);
	    ifBranch.getStatements().add(innerVarDecl);
	    NamedValueDeclaration bDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable b = ActionsFactory.eINSTANCE.createVariable();
	    b.setName("b");
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(i);
	    b.setInitExpression(iExp);
	    bDecl.setNamedValue(b);
	    ifBranch.getStatements().add(bDecl);
	    
	    MethodCallExpression iMinusA = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    // need to create another copy of iExp because ObjectBasedExpressions own their reference object
	    iExp = createVariableExpression(i);
	    iMinusA.setObject(iExp);
	    MethodSignature minus = MetamodelUtils.findMethod(resourceSet, "Number", "minus");
	    iMinusA.setMethodSignature(minus);
	    VariableExpression innerAExp = createVariableExpression(innerA);
	    iMinusA.getParameters().add(innerAExp);
	    FunctionCallExpression recursion = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    recursion.getParameters().add(iMinusA);
	    
	    MethodCallExpression bPlusRecursion = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    VariableExpression bExp = createVariableExpression(b);
	    bPlusRecursion.setObject(bExp);
	    MethodSignature plus = MetamodelUtils.findMethod(resourceSet, "Number", "plus");
	    bPlusRecursion.setMethodSignature(plus);
	    bPlusRecursion.getParameters().add(recursion);
	    
	    Return retIf = ActionsFactory.eINSTANCE.createReturn();
	    retIf.setArgument(bPlusRecursion);
	    ifBranch.getStatements().add(retIf);
	    
	    Block elseBranch = ActionsFactory.eINSTANCE.createBlock();
	    Return retElse = ActionsFactory.eINSTANCE.createReturn();
	    VariableExpression aExp = createVariableExpression(a);
	    retElse.setArgument(aExp);
	    elseBranch.getStatements().add(retElse);

	    ifElse.getNestedBlocks().add(ifBranch);
	    ifElse.getNestedBlocks().add(elseBranch);
	    
	    block.getStatements().add(ifElse);
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    fce.getParameters().add(MetamodelUtils.createNumberLiteral(resourceSet, "10"));
	    
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(fce);
	    assertEquals(new Fraction("55"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Test
    public void testPolymorphicMethodInvocation() {
	try {
	    SapClass c1 = createClass("C1");
	    MethodSignature s1 = ClassesFactory.eINSTANCE.createMethodSignature();
	    s1.setName("s1");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    ClassTypeDefinition numberTD = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass);
	    s1.setOutput(numberTD);
	    Block s1Impl = ActionsFactory.eINSTANCE.createBlock();
	    s1Impl.setImplements_(s1);
	    Return s1ImplReturn = ActionsFactory.eINSTANCE.createReturn();
	    s1ImplReturn.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, "12345"));
	    s1Impl.getStatements().add(s1ImplReturn);
	    c1.getOwnedSignatures().add(s1);
	    SapClass c2 = createClass("C2");
	    MethodSignature s2 = ClassesFactory.eINSTANCE.createMethodSignature();
	    s2.setName("s2");
	    s2.setOutput(numberTD);
	    c2.getOwnedSignatures().add(s2);
	    TypeAdapter adapter = ClassesFactory.eINSTANCE.createTypeAdapter();
	    adapter.setName("FromC1ToC2");
	    adapter.setAdapted(c1);
	    adapter.setTo(c2);
	    MethodSignature adapterSig = ClassesFactory.eINSTANCE.createMethodSignature();
	    adapterSig.setName("s2");
	    Block impl = ActionsFactory.eINSTANCE.createBlock();
	    Return c1ToC2AdapterImplReturn = ActionsFactory.eINSTANCE.createReturn();
	    MethodCallExpression c1ToC2Mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    c1ToC2Mce.setObject(ExpressionsFactory.eINSTANCE.createThis());
	    c1ToC2Mce.setMethodSignature(s1);
	    c1ToC2AdapterImplReturn.setArgument(c1ToC2Mce);
	    impl.getStatements().add(c1ToC2AdapterImplReturn);
	    
	    impl.setImplements_(adapterSig);
	    adapterSig.setOutput(numberTD);
	    adapter.getOwnedSignatures().add(adapterSig);

	    SapClass c3 = createClass("C3");
	    MethodSignature s3 = ClassesFactory.eINSTANCE.createMethodSignature();
	    s3.setName("s3");
	    s3.setOutput(numberTD);
	    c3.getOwnedSignatures().add(s3);
	    TypeAdapter adapter2 = ClassesFactory.eINSTANCE.createTypeAdapter();
	    adapter2.setName("FromC2ToC3");
	    adapter2.setAdapted(c2);
	    adapter2.setTo(c3);
	    MethodSignature adapter2Sig = ClassesFactory.eINSTANCE.createMethodSignature();
	    adapter2Sig.setName("s3");
	    adapter2Sig.setOutput(numberTD);
	    Block impl2 = ActionsFactory.eINSTANCE.createBlock();
	    Return c2ToC3AdapterImplReturn = ActionsFactory.eINSTANCE.createReturn();
	    MethodCallExpression c2ToC3Mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    c2ToC3Mce.setObject(ExpressionsFactory.eINSTANCE.createThis());
	    c2ToC3Mce.setMethodSignature(s2);
	    c2ToC3AdapterImplReturn.setArgument(c2ToC3Mce);
	    impl2.getStatements().add(c2ToC3AdapterImplReturn);
	    impl2.setImplements_(adapter2Sig);
	    adapter2.getOwnedSignatures().add(adapter2Sig);
	    BasicDiagnostic diagnostics = new BasicDiagnostic();
	    ClassesValidator.INSTANCE.validate(adapter, diagnostics, new HashMap<Object, Object>());
	    assertTrue("Adapter should be valid", diagnostics.getSeverity() == Diagnostic.OK);
            diagnostics = new BasicDiagnostic();
            ClassesValidator.INSTANCE.validate(adapter2, diagnostics, new HashMap<Object, Object>());
            assertTrue("Adapter should be valid", diagnostics.getSeverity() == Diagnostic.OK);
	    assertTrue("Classes with no signatures and an adapter between them should conform", c1
		    .conformsTo(c3));
	    
	    // evaluate: new C1().s3()
	    ObjectCreationExpression oce = ExpressionsFactory.eINSTANCE.createObjectCreationExpression();
	    oce.setClassToInstantiate(c1);
	    ClassTypeDefinition c1td = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, c1);
	    oce.setOwnedTypeDefinition(c1td);
	    MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    mce.setObject(oce);
	    mce.setMethodSignature(s3);
	    mce.setOwnedTypeDefinition(numberTD);
            diagnostics = new BasicDiagnostic();
            ClassesValidator.INSTANCE.validate(mce, diagnostics, new HashMap<Object, Object>());
            assertTrue("Method call on new C1().s3() should be valid", diagnostics.getSeverity() == Diagnostic.OK);
	    assertEquals(new Fraction(12345),
		    ((NativeObject) new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(mce)).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    @Test
    public void testSimpleLinks() {
	try {
	    SapClass c1 = createClass("C1");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    Association c1ToNumber = MetamodelUtils.createAssociation(resourceSet, c1, 0, -1,
		    				       /* navigable */ false, numberClass, 0, 1, /* navigable */ true);
	    
	    Block block = ActionsFactory.eINSTANCE.createBlock();
	    NamedValueDeclaration varDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable a = ActionsFactory.eINSTANCE.createVariable();
	    a.setName("a");
	    ObjectCreationExpression oce = ExpressionsFactory.eINSTANCE.createObjectCreationExpression();
	    oce.setClassToInstantiate(c1);
	    oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, c1));
	    a.setInitExpression(oce);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    AddLink addLink = ActionsFactory.eINSTANCE.createAddLink();
	    addLink.setAssociation(c1ToNumber);
	    addLink.setAt(-1);
	    VariableExpression aRef = createVariableExpression(a);
	    addLink.getObjects().add(aRef);
	    addLink.getObjects().add(MetamodelUtils.createNumberLiteral(resourceSet, "42"));
	    block.getStatements().add(addLink);
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    AssociationEndNavigationExpression aene = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	    aene.setToEnd(c1ToNumber.getEnds().get(1));
	    VariableExpression aRef2 = createVariableExpression(a);
	    aene.setObject(aRef2);
	    ret.setArgument(aene);
	    block.getStatements().add(ret);

	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    funcSig.setOutput(c1ToNumber.getEnds().get(1).getType());
	    funcSig.setImplementation(block);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(fce);
	    
	    assertEquals(new Fraction(42), ((NativeObject) result).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
	
    @Test
    public void testTwoLinks() {
	try {
	    SapClass c1 = createClass("C1");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    Association c1ToNumber = ClassesFactory.eINSTANCE.createAssociation();
	    AssociationEnd c1End = ClassesFactory.eINSTANCE.createAssociationEnd();
	    c1End.setComposite(true);
	    AssociationEnd numberEnd = ClassesFactory.eINSTANCE.createAssociationEnd();
	    numberEnd.setNavigable(true);
	    c1ToNumber.getEnds().add(c1End);
	    c1ToNumber.getEnds().add(numberEnd);
	    ClassTypeDefinition c1TD = MetamodelUtils.createClassTypeDefinition(resourceSet, c1, 0, -1);
	    c1End.setType(c1TD);
	    ClassTypeDefinition numberTD = MetamodelUtils.createClassTypeDefinition(resourceSet, numberClass, 0, -1);
	    numberTD.setOrdered(true);
	    numberEnd.setType(numberTD);
	    
	    Block block = ActionsFactory.eINSTANCE.createBlock();
	    NamedValueDeclaration varDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable a = ActionsFactory.eINSTANCE.createVariable();
	    a.setName("a");
	    ObjectCreationExpression oce = ExpressionsFactory.eINSTANCE.createObjectCreationExpression();
	    oce.setClassToInstantiate(c1);
	    oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, c1));
	    a.setInitExpression(oce);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    AddLink addLink = ActionsFactory.eINSTANCE.createAddLink();
	    addLink.setAssociation(c1ToNumber);
	    addLink.setAt(-1);
	    VariableExpression aRef = createVariableExpression(a);
	    addLink.getObjects().add(aRef);
	    addLink.getObjects().add(MetamodelUtils.createNumberLiteral(resourceSet, "42"));
	    block.getStatements().add(addLink);
	    AddLink addLink2 = ActionsFactory.eINSTANCE.createAddLink();
	    addLink2.setAssociation(c1ToNumber);
	    addLink2.setAt(-1);
	    VariableExpression aRef2 = createVariableExpression(a);
	    addLink2.getObjects().add(aRef2);
	    addLink2.getObjects().add(MetamodelUtils.createNumberLiteral(resourceSet, "43"));
	    block.getStatements().add(addLink2);
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    AssociationEndNavigationExpression aene = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	    aene.setToEnd(numberEnd);
	    VariableExpression aRef3 = createVariableExpression(a);
	    aene.setObject(aRef3);
	    ret.setArgument(aene);
	    block.getStatements().add(ret);

	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    funcSig.setOutput(numberTD);
	    funcSig.setImplementation(block);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(fce);
	    
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultIterator = result.flatten().iterator();
	    assertEquals(new Fraction(42), ((NativeObject) resultIterator.next()).getNativeObject());
	    assertEquals(new Fraction(43), ((NativeObject) resultIterator.next()).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
	
    @Test
    public void testSimpleFunctionFromMethod() {
	try {
	    NumberLiteral nl = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl.setLiteral("123.450");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    nl.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass));
	    NumberLiteral nl2 = LiteralsFactory.eINSTANCE.createNumberLiteral();
	    nl2.setLiteral("123.450");
	    nl2.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet,
		    numberClass));
	    
	    FunctionFromMethodExpr ffme = FpFactory.eINSTANCE.createFunctionFromMethodExpr();
	    MethodSignature sig = MetamodelUtils.findMethod(resourceSet, "Number", "plus");
	    ffme.setMethod(sig);
	    ffme.setObject(nl);

	    FunctionSignatureTypeDefinition fstd = ClassesFactory.eINSTANCE.createFunctionSignatureTypeDefinition();
	    fstd.setLowerMultiplicity(1);
	    fstd.setUpperMultiplicity(1);
	    fstd.setSignature(sig);
	    ffme.setOwnedTypeDefinition(fstd);
	    
	    FunctionCallExpression fce = ExpressionsFactory.eINSTANCE.createFunctionCallExpression();
	    fce.setCalledBlock(ffme);
	    fce.getParameters().add(nl2);
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    NativeObject result = (NativeObject) interpreter.evaluate(fce);
	    assertEquals(new Fraction("246.900"), result.getNativeObject());
	    assertEquals(0, interpreter.getCallstack().size());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Test
    public void testMultiObjectMethodInvocation() {
	try {
	    SapClass c1 = createClass("C1");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    Association c1ToNumber = ClassesFactory.eINSTANCE.createAssociation();
	    AssociationEnd c1End = ClassesFactory.eINSTANCE.createAssociationEnd();
	    c1End.setComposite(true);
	    AssociationEnd numberEnd = ClassesFactory.eINSTANCE.createAssociationEnd();
	    numberEnd.setNavigable(true);
	    c1ToNumber.getEnds().add(c1End);
	    c1ToNumber.getEnds().add(numberEnd);
	    ClassTypeDefinition c1TD = MetamodelUtils.createClassTypeDefinition(resourceSet, c1, 0, -1);
	    c1End.setType(c1TD);
	    ClassTypeDefinition numberTD = MetamodelUtils.createClassTypeDefinition(resourceSet, numberClass, 0, -1);
	    numberTD.setOrdered(true);
	    numberEnd.setType(numberTD);
	    
	    Block block = ActionsFactory.eINSTANCE.createBlock();
	    NamedValueDeclaration varDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable a = ActionsFactory.eINSTANCE.createVariable();
	    a.setName("a");
	    ObjectCreationExpression oce = ExpressionsFactory.eINSTANCE.createObjectCreationExpression();
	    oce.setClassToInstantiate(c1);
	    oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, c1));
	    a.setInitExpression(oce);
	    varDecl.setNamedValue(a);
	    block.getStatements().add(varDecl);
	    AddLink addLink = ActionsFactory.eINSTANCE.createAddLink();
	    addLink.setAssociation(c1ToNumber);
	    addLink.setAt(-1);
	    VariableExpression aRef = createVariableExpression(a);
	    addLink.getObjects().add(aRef);
	    addLink.getObjects().add(MetamodelUtils.createNumberLiteral(resourceSet, "42"));
	    block.getStatements().add(addLink);
	    AddLink addLink2 = ActionsFactory.eINSTANCE.createAddLink();
	    addLink2.setAssociation(c1ToNumber);
	    addLink2.setAt(-1);
	    VariableExpression aRef2 = createVariableExpression(a);
	    addLink2.getObjects().add(aRef2);
	    addLink2.getObjects().add(MetamodelUtils.createNumberLiteral(resourceSet, "43"));
	    block.getStatements().add(addLink2);
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    AssociationEndNavigationExpression aene = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	    aene.setToEnd(numberEnd);
	    VariableExpression aRef3 = createVariableExpression(a);
	    aene.setObject(aRef3);
	    ret.setArgument(aene);
	    block.getStatements().add(ret);

	    FunctionSignature funcSig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    funcSig.setOutput(numberTD);
	    funcSig.setImplementation(block);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, funcSig);
	    
	    // now call a method on the resulting multi-object and check multi-object result
	    
	    MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    mce.setObject(fce);
	    mce.setMethodSignature(MetamodelUtils.findMethod(resourceSet, "Number", "negate"));
	    
	    RunletInterpreter interpreter = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter()));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(mce);
	    
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultIterator = result.iterator();
	    assertEquals(new Fraction(-42), ((NativeObject) resultIterator.next()).getNativeObject());
	    assertEquals(new Fraction(-43), ((NativeObject) resultIterator.next()).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    private SapClass createClass(String name) {
	SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
	c1.setName(name);
	return c1;
    }
    
    /**
     * Creates the accessor method signatures requested and exposes them in the class that
     * is the type of <tt>end</tt>'s opposite end by adding them to that class's owned
     * signatures.
     */
    private Map<Accessors, MethodSignature> exposeAssociationEnd(ResourceSet resourceSet, AssociationEnd end,
	    Accessors[] accessorsToExpose) {
	Map<Accessors, MethodSignature> result = new HashMap<Accessors, MethodSignature>();
	SapClass otherEndClass = end.otherEnd().getType().getClazz();
	for (Accessors accessorToExpose : accessorsToExpose) {
	    MethodSignature sig = null;
	    Parameter param;
	    switch (accessorToExpose) {
	    case GETTER:
		sig = ClassesFactory.eINSTANCE.createMethodSignature();
		sig.setName("get" + firstUp(end.getName()));
		sig.setOutput(end.getType());
		LinkTraversal getterImpl = ClassesFactory.eINSTANCE.createLinkTraversal();
		getterImpl.setEnd(end);
		getterImpl.setImplements_(sig);
		break;
	    case SETTER:
		sig = ClassesFactory.eINSTANCE.createMethodSignature();
		sig.setName("set" + firstUp(end.getName()));
		param = ClassesFactory.eINSTANCE.createParameter();
		param.setName("value");
		sig.getInput().add(param);
		LinkSetting setterImpl = ClassesFactory.eINSTANCE.createLinkSetting();
		setterImpl.setEnd(end);
		setterImpl.setImplements_(sig);
		break;
	    case ADDER:
		sig = ClassesFactory.eINSTANCE.createMethodSignature();
		sig.setName("addTo" + firstUp(end.getName()));
		param = ClassesFactory.eINSTANCE.createParameter();
		param.setName("value");
		sig.getInput().add(param);
		LinkAddition adderImpl = ClassesFactory.eINSTANCE.createLinkAddition();
		adderImpl.setAt(-1);
		adderImpl.setEnd(end);
		adderImpl.setImplements_(sig);
		break;
	    case REMOVER:
		sig = ClassesFactory.eINSTANCE.createMethodSignature();
		sig.setName("removeFrom" + firstUp(end.getName()));
		param = ClassesFactory.eINSTANCE.createParameter();
		param.setName("value");
		sig.getInput().add(param);
		LinkRemoval removerImpl = ClassesFactory.eINSTANCE.createLinkRemoval();
		removerImpl.setAt(-1);
		removerImpl.setEnd(end);
		removerImpl.setImplements_(sig);
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
    @Test
    public void testSimpleCellSetExpression() {
	try {
	    // set up data structures
	    SapClass salesOrderItem = createClass("SalesOrderItem");
	    SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	    Association salesOrderItemToPrice = MetamodelUtils.createAssociation(resourceSet, salesOrderItem, "salesOrderItemsWithPrice", 0,
		    -1, /* nav */ false, /* comp */ false, /* ordered */ false,
		    /* unique */ false, numberClass, "price", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> priceAccessors = exposeAssociationEnd(resourceSet,
		    salesOrderItemToPrice.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    SapClass product = createClass("Product");
	    Association salesOrderItemToProduct = MetamodelUtils.createAssociation(resourceSet, salesOrderItem, "salesOrderItems", 0,
		    -1, /* nav */ false, /* comp */ false, /* ordered */ false,
		    /* unique */ false, product, "product", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> productAccessors = exposeAssociationEnd(resourceSet,
		    salesOrderItemToProduct.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    SapClass salesOrder = createClass("SalesOrder");
	    Association salesOrderToSalesOrderItems = MetamodelUtils.createAssociation(resourceSet, salesOrder, "salesOrder",
		    1, 1, /* nav */ true, /* comp */ true, /* ordered */ false, /* unique */ false,
		    salesOrderItem, "items", 0, -1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> itemsAccessors = exposeAssociationEnd(resourceSet,
		    salesOrderToSalesOrderItems.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.ADDER, Accessors.REMOVER });
	     */
	    SapClass customer = createClass("Customer");
	    Association salesOrderToCustomer = MetamodelUtils.createAssociation(resourceSet, salesOrder, "salesOrders",
		    0, -1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false,
		    customer, "customer", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> customerAccessors = exposeAssociationEnd(resourceSet,
		    salesOrderToCustomer.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    SapClass string = MetamodelUtils.findClass(resourceSet, "String");
	    Association customerToRegion = MetamodelUtils.createAssociation(resourceSet, customer, "customerWithRegion",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "region", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> regionAccessors = exposeAssociationEnd(resourceSet,
		    customerToRegion.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	    */
	    // TODO what would happen if the category multiplicity was 0..*?
	    Association productToCategory = MetamodelUtils.createAssociation(resourceSet, product, "productWithCategory",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "category", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    /*
	    Map<Accessors, MethodSignature> categoryAccessors = exposeAssociationEnd(resourceSet,
		    productToCategory.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	     */
	    CellSet cellSet = createCellSet(resourceSet, salesOrderItem, salesOrderItemToPrice,
		    salesOrderItemToProduct, salesOrderToSalesOrderItems, salesOrderToCustomer,
		    productToCategory, customerToRegion);
	    
	    FunctionSignature sig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    sig.setImplementation(cellSet);
	    /* TODO: connecting a CellSet with its FunctionSignature in the MOIN version triggers an event handler
	       which creates all input arguments for the signature because in the grammar/mapping
	       for the concrete syntax this currently cannot be described. For EMF, this event handler hasn't
	       yet been activated. If this should be required again in the EMF version, comment out the following
	       block:
	     */
            {
                Parameter factsParam = ClassesFactory.eINSTANCE.createParameter();
                factsParam.setName("facts");
                sig.getInput().add(factsParam);
                Parameter sigDimensionParam1 = ClassesFactory.eINSTANCE.createParameter();
                sigDimensionParam1.setName("productCategory"); // parameter type inferred by TypedElement.getType()
                sig.getInput().add(sigDimensionParam1);
                Parameter sigDimensionParam2 = ClassesFactory.eINSTANCE.createParameter();
                sigDimensionParam2.setName("customerRegion"); // parameter type inferred by TypedElement.getType()
                sig.getInput().add(sigDimensionParam2);
            }
	    sig.setOutput(cellSet.getAggregationFunction().getOutput());
	    
	    // evaluate a cell set expression
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, sig);

	    fce.getParameters().add(createFacts(resourceSet, salesOrder, salesOrderItem, product, customer,
		    productToCategory, salesOrderItemToPrice, salesOrderItemToProduct,
		    customerToRegion, salesOrderToCustomer, salesOrderToSalesOrderItems));
	    fce.getParameters().add(MetamodelUtils.createStringLiteral(resourceSet, "Toys"));     // productCategory parameter
	    fce.getParameters().add(MetamodelUtils.createStringLiteral(resourceSet, "Americas")); // customerRegion parameter
	    
            BasicDiagnostic diagnostics = new BasicDiagnostic();
            ClassesValidator.INSTANCE.validate(fce, diagnostics, new HashMap<Object, Object>());
            assertTrue("CellSet function call expression should be valid", diagnostics.getSeverity() == Diagnostic.OK);
	    assertEquals(new Fraction(12345+12345+45678),
		    ((NativeObject) new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce)).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * Assembles a {@link FunctionCallExpression} that calls a function assembled here that,
     * when executed, constructs a multi-valued SalesOrderItem object.
     */
    private Expression createFacts(ResourceSet resourceSet, SapClass salesOrder, SapClass salesOrderItem,
	    SapClass product, SapClass customer, Association productToCategory,
	    Association salesOrderItemToPrice, Association salesOrderItemToProduct,
	    Association customerToRegion, Association salesOrderToCustomer, Association salesOrderToSalesOrderItems) {
	// sig = function():SalesOrderItem[] {
	FunctionSignature sig = ClassesFactory.eINSTANCE.createFunctionSignature();
	sig.setOutput(MetamodelUtils.createClassTypeDefinition(resourceSet, salesOrderItem, 0, -1));
	Block impl = ActionsFactory.eINSTANCE.createBlock();
	sig.setImplementation(impl);
	
	// -------------- variable declarations -------------------
	//     SalesOrderItem[] result;
	NamedValueDeclaration resultDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	Variable result = ActionsFactory.eINSTANCE.createVariable();
	result.setName("result");
	result.setOwnedTypeDefinition(sig.getOutput());
	resultDecl.setNamedValue(result);
	impl.getStatements().add(resultDecl);

	//     SalesOrder so;
	NamedValueDeclaration soDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	Variable so = ActionsFactory.eINSTANCE.createVariable();
	so.setName("so");
	so.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, salesOrder));
	soDecl.setNamedValue(so);
	impl.getStatements().add(soDecl);
	
	//     SalesOrderItem soi;
	NamedValueDeclaration soiDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	Variable soi = ActionsFactory.eINSTANCE.createVariable();
	soi.setName("soi");
	soi.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, salesOrderItem));
	soiDecl.setNamedValue(soi);
	impl.getStatements().add(soiDecl);
	
	//     Customer c;
	NamedValueDeclaration cDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	Variable c = ActionsFactory.eINSTANCE.createVariable();
	c.setName("c");
	c.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, customer));
	cDecl.setNamedValue(c);
	impl.getStatements().add(cDecl);
	
	//     Product p;
	NamedValueDeclaration pDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	Variable p = ActionsFactory.eINSTANCE.createVariable();
	p.setName("p");
	p.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, product));
	pDecl.setNamedValue(p);
	impl.getStatements().add(pDecl);

	// -------------- first Sales Order -------------------
	createCodeToCreateSalesOrder(resourceSet, salesOrder, customer, customerToRegion,
		salesOrderToCustomer, impl, so, c, /* customerRegion */ "Americas");
	
	// -------------- first SOI -------------------
	createCodeToCreateSalesOrderItem(resourceSet, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "12345", /* productCategory */ "Toys");
	//     result = soi;
	Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
	assignment.setAssignTo(result);
	VariableExpression soiAccess = createVariableExpression(soi);
	assignment.setArgument(soiAccess);
	impl.getStatements().add(assignment);
	
	// -------------- second SOI -------------------
	createCodeToCreateSalesOrderItem(resourceSet, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "12345", /* productCategory */ "Toys");
	createCodeToAddSalesOrderItemToResult(resourceSet, impl, result, soi);
	
	// -------------- third SOI -------------------
	createCodeToCreateSalesOrderItem(resourceSet, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "23456", /* productCategory */ "Appliances");
	createCodeToAddSalesOrderItemToResult(resourceSet, impl, result, soi);
	
	// -------------- second Sales Order -------------------
	createCodeToCreateSalesOrder(resourceSet, salesOrder, customer, customerToRegion,
		salesOrderToCustomer, impl, so, c, /* customerRegion */ "EMEA");

	// -------------- fourth SOI -------------------
	createCodeToCreateSalesOrderItem(resourceSet, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "34567", /* productCategory */ "Toys");
	createCodeToAddSalesOrderItemToResult(resourceSet, impl, result, soi);
	
	// -------------- third Sales Order -------------------
	createCodeToCreateSalesOrder(resourceSet, salesOrder, customer, customerToRegion,
		salesOrderToCustomer, impl, so, c, /* customerRegion */ "Americas");

	// -------------- fifth SOI -------------------
	createCodeToCreateSalesOrderItem(resourceSet, salesOrderItem, product, productToCategory,
		salesOrderItemToPrice, salesOrderItemToProduct, salesOrderToSalesOrderItems, impl,
		so, soi, p, /* price */ "45678", /* productCategory */ "Toys");
	createCodeToAddSalesOrderItemToResult(resourceSet, impl, result, soi);
	
	//     return result;
	VariableExpression resultAccess = createVariableExpression(result);
	Return ret = ActionsFactory.eINSTANCE.createReturn();
	ret.setArgument(resultAccess);
	impl.getStatements().add(ret);
	// }
	
	return MetamodelUtils.createFunctionCallExpression(resourceSet, sig);
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
    private void createCodeToCreateSalesOrder(ResourceSet resourceSet, SapClass salesOrder,
	    SapClass customer, Association customerToRegion, Association salesOrderToCustomer,
	    Block impl, Variable so, Variable c, String customerRegion) {
	//     so = new SalesOrder();
	impl.getStatements().add(assignNewToVariable(resourceSet, salesOrder, so));
	
	//     c = new Customer();
	impl.getStatements().add(assignNewToVariable(resourceSet, customer, c));
	
	//     c.setRegion("Americas");
	AddLink addLink = ActionsFactory.eINSTANCE.createAddLink();
	addLink.setAssociation(customerToRegion);
	addLink.setAt(-1);
	VariableExpression cAccess = createVariableExpression(c);
	addLink.getObjects().add(cAccess);
	addLink.getObjects().add(MetamodelUtils.createStringLiteral(resourceSet, customerRegion));
	impl.getStatements().add(addLink);
	
	//     so.setCustomer(c);
	addLink = ActionsFactory.eINSTANCE.createAddLink();
	addLink.setAssociation(salesOrderToCustomer);
	addLink.setAt(-1);
	VariableExpression soAccess = createVariableExpression(so);
	addLink.getObjects().add(soAccess);
	cAccess = createVariableExpression(c);
	addLink.getObjects().add(cAccess);
	impl.getStatements().add(addLink);
    }

    /**
     * Create the code that adds the sales order item bound to the variable identified by
     * <tt>soi</tt> to the multi-valued object bound to the variable identified by <tt>result</tt>.
     * The code created is added to the block <tt>impl</tt>.
     */
    private void createCodeToAddSalesOrderItemToResult(ResourceSet resourceSet, Block impl,
	    Variable result, Variable soi) {
	Assignment assignment;
	VariableExpression soiAccess;
	assignment = ActionsFactory.eINSTANCE.createAssignment();
	assignment.setAssignTo(result);
	Including including = CollectionexpressionsFactory.eINSTANCE.createIncluding();
	VariableExpression resultAccess = createVariableExpression(result);
	including.setSource(resultAccess);
	soiAccess = createVariableExpression(soi);
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
    private void createCodeToCreateSalesOrderItem(ResourceSet resourceSet, SapClass salesOrderItem,
	    SapClass product, Association productToCategory, Association salesOrderItemToPrice,
	    Association salesOrderItemToProduct, Association salesOrderToSalesOrderItems,
	    Block blockToAddStatementsTo, Variable so, Variable soi, Variable p, String price,
	    String productCategory) {
	AddLink addLink;
	VariableExpression soAccess;
	//     soi = new SalesOrderItem();
	blockToAddStatementsTo.getStatements().add(assignNewToVariable(resourceSet, salesOrderItem, soi));
	
	//     soi.setPrice(12345);
	addLink = ActionsFactory.eINSTANCE.createAddLink();
	addLink.setAssociation(salesOrderItemToPrice);
	addLink.setAt(-1);
	VariableExpression soiAccess = createVariableExpression(soi);
	addLink.getObjects().add(soiAccess);
	addLink.getObjects().add(MetamodelUtils.createNumberLiteral(resourceSet, price));
	blockToAddStatementsTo.getStatements().add(addLink);
	
	//     p = new Product();
	blockToAddStatementsTo.getStatements().add(assignNewToVariable(resourceSet, product, p));
	
	//     p.setCategory("Toys");
	addLink = ActionsFactory.eINSTANCE.createAddLink();
	addLink.setAssociation(productToCategory);
	addLink.setAt(-1);
	VariableExpression pAccess = createVariableExpression(p);
	addLink.getObjects().add(pAccess);
	addLink.getObjects().add(MetamodelUtils.createStringLiteral(resourceSet, productCategory));
	blockToAddStatementsTo.getStatements().add(addLink);
	
	//     soi.setProduct(p);
	addLink = ActionsFactory.eINSTANCE.createAddLink();
	addLink.setAssociation(salesOrderItemToProduct);
	addLink.setAt(-1);
	soiAccess = createVariableExpression(soi);
	addLink.getObjects().add(soiAccess);
	pAccess = createVariableExpression(p);
	addLink.getObjects().add(pAccess);
	blockToAddStatementsTo.getStatements().add(addLink);
	
	//     soi.setSalesOrder(so);
	addLink = ActionsFactory.eINSTANCE.createAddLink();
	addLink.setAssociation(salesOrderToSalesOrderItems);
	addLink.setAt(-1);
	soAccess = createVariableExpression(so);
	addLink.getObjects().add(soAccess);
	soiAccess = createVariableExpression(soi);
	addLink.getObjects().add(soiAccess);
	blockToAddStatementsTo.getStatements().add(addLink);
    }

    private Statement assignNewToVariable(ResourceSet resourceSet, SapClass clazz, Variable variable) {
	ObjectCreationExpression oce = ExpressionsFactory.eINSTANCE.createObjectCreationExpression();
	oce.setClassToInstantiate(clazz);
	oce.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, clazz));
	Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
	assignment.setAssignTo(variable);
	assignment.setArgument(oce);
	return assignment;
    }

    private CellSet createCellSet(ResourceSet resourceSet, SapClass salesOrderItem,
	    Association salesOrderItemToPrice, Association salesOrderItemToProduct,
	    Association salesOrderToSalesOrderItems, Association salesOrderToCustomer,
	    Association productToCategory, Association customerToRegion) {
	// The value function determines the price from a sales order item
	FunctionSignature valueFunctionSignature = ClassesFactory.eINSTANCE.createFunctionSignature();
	Block valueFunction = ActionsFactory.eINSTANCE.createBlock();
	Parameter valueFunctionParam = ClassesFactory.eINSTANCE.createParameter();
	valueFunctionParam.setName("item");
	valueFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, salesOrderItem, 1, 1));
	valueFunctionSignature.getInput().add(valueFunctionParam);
	valueFunctionSignature.setOutput(salesOrderItemToPrice.getEnds().get(1).getType());
	valueFunctionSignature.setImplementation(valueFunction);
	AssociationEndNavigationExpression navigateToPrice =
	ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	VariableExpression itemParameterValue = createVariableExpression(valueFunctionParam);
	navigateToPrice.setObject(itemParameterValue);
	navigateToPrice.setToEnd(salesOrderItemToPrice.getEnds().get(1));
	Return valueFunctionReturn = ActionsFactory.eINSTANCE.createReturn();
	valueFunctionReturn.setArgument(navigateToPrice);
	valueFunction.getStatements().add(valueFunctionReturn);
	
	// The aggregation function sums up all input values which are expected to be of type Number
	FunctionSignature aggregationFunctionSignature = ClassesFactory.eINSTANCE.createFunctionSignature();
	Block aggregationFunction = ActionsFactory.eINSTANCE.createBlock();
	Parameter aggregationFunctionParam = ClassesFactory.eINSTANCE.createParameter();
	aggregationFunctionParam.setName("prices");
	aggregationFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet,
	    salesOrderItemToPrice.getEnds().get(1).getType().getClazz(), 0, -1));
	aggregationFunctionParam.setOwnedTypeDefinition(aggregationFunctionParam.getType());
	aggregationFunctionSignature.getInput().add(aggregationFunctionParam);
	aggregationFunctionSignature.setOutput(salesOrderItemToPrice.getEnds().get(1).getType());
	aggregationFunctionSignature.setImplementation(aggregationFunction);
	Iterate iterate = CollectionexpressionsFactory.eINSTANCE.createIterate();
	behavioral.actions.Iterator iterator = ActionsFactory.eINSTANCE.createIterator();
	iterator.setName("i");
	iterator.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	iterate.getIterators().add(iterator);
	VariableExpression paramReference = createVariableExpression(aggregationFunctionParam);
	iterate.setSource(paramReference);
	Constant accumulator = ActionsFactory.eINSTANCE.createConstant();
	accumulator.setName("acc");
	accumulator.setInitExpression(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	iterate.setAccumulator(accumulator);
	MethodCallExpression add = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	VariableExpression accAccess = createVariableExpression(accumulator);
	add.setObject(accAccess);
	VariableExpression iteratorAccess = createVariableExpression(iterator);
	add.getParameters().add(iteratorAccess);
	add.setMethodSignature(MetamodelUtils.findMethod(resourceSet, "Number", "plus"));
	iterate.setIteratorExpression(add);
	Return aggregationFunctionReturn = ActionsFactory.eINSTANCE.createReturn();
	aggregationFunctionReturn.setArgument(iterate);
	aggregationFunction.getStatements().add(aggregationFunctionReturn);

	// set up the cell set
	CellSet cellSet = AnalyticsFactory.eINSTANCE.createCellSet();
	cellSet.setFactsType(MetamodelUtils.createClassTypeDefinition(resourceSet, salesOrderItem, 0, -1));
	cellSet.setAggregationFunction(aggregationFunctionSignature);
	cellSet.setValueFunction(valueFunctionSignature);
	// product category dimension
	FunctionSignature categoryDimensionSignature = ClassesFactory.eINSTANCE.createFunctionSignature();
	Block categoryDimensionFunction = ActionsFactory.eINSTANCE.createBlock();
	Parameter categoryDimensionFunctionParam = ClassesFactory.eINSTANCE.createParameter();
	categoryDimensionFunctionParam.setName("salesOrderItem");
	categoryDimensionFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet,
	    salesOrderItemToPrice.getEnds().get(0).getType().getClazz(), 1, 1));
	categoryDimensionFunctionParam.setOwnedTypeDefinition(categoryDimensionFunctionParam.getType());
	categoryDimensionSignature.getInput().add(categoryDimensionFunctionParam);
	categoryDimensionSignature.setOutput(productToCategory.getEnds().get(1).getType());
	categoryDimensionSignature.setImplementation(categoryDimensionFunction);
	VariableExpression categoryDimensionFunctionParamAccess = createVariableExpression(categoryDimensionFunctionParam);
	AssociationEndNavigationExpression getProduct = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	getProduct.setObject(categoryDimensionFunctionParamAccess);
	getProduct.setToEnd(salesOrderItemToProduct.getEnds().get(1));
	AssociationEndNavigationExpression getCategory = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	getCategory.setObject(getProduct);
	getCategory.setToEnd(productToCategory.getEnds().get(1));
	Return categoryDimensionFunctionReturn = ActionsFactory.eINSTANCE.createReturn();
	categoryDimensionFunctionReturn.setArgument(getCategory);
	categoryDimensionFunction.getStatements().add(categoryDimensionFunctionReturn);
	Dimension categoryDimension = AnalyticsFactory.eINSTANCE.createDimension();
	categoryDimension.setName("productCategory");
	categoryDimension.setCharacteristicFunction(categoryDimensionSignature);
	cellSet.getDimensions().add(categoryDimension);
	// customer region dimension
	FunctionSignature regionDimensionSignature = ClassesFactory.eINSTANCE.createFunctionSignature();
	Block regionDimensionFunction = ActionsFactory.eINSTANCE.createBlock();
	Parameter regionDimensionFunctionParam = ClassesFactory.eINSTANCE.createParameter();
	regionDimensionFunctionParam.setName("salesOrderItem");
	regionDimensionFunctionParam.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet,
	    salesOrderItemToPrice.getEnds().get(0).getType().getClazz(), 1, 1));
	regionDimensionFunctionParam.setOwnedTypeDefinition(regionDimensionFunctionParam.getType());
	regionDimensionSignature.getInput().add(regionDimensionFunctionParam);
	regionDimensionSignature.setOutput(customerToRegion.getEnds().get(1).getType());
	regionDimensionSignature.setImplementation(regionDimensionFunction);
	VariableExpression regionDimensionFunctionParamAccess = createVariableExpression(regionDimensionFunctionParam);
	AssociationEndNavigationExpression getSalesOrder = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	getSalesOrder.setObject(regionDimensionFunctionParamAccess);
	getSalesOrder.setToEnd(salesOrderToSalesOrderItems.getEnds().get(0));
	AssociationEndNavigationExpression getCustomer = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	getCustomer.setObject(getSalesOrder);
	getCustomer.setToEnd(salesOrderToCustomer.getEnds().get(1));
	AssociationEndNavigationExpression getRegion = ExpressionsFactory.eINSTANCE.createAssociationEndNavigationExpression();
	getRegion.setObject(getCustomer);
	getRegion.setToEnd(customerToRegion.getEnds().get(1));
	Return regionDimensionFunctionReturn = ActionsFactory.eINSTANCE.createReturn();
	regionDimensionFunctionReturn.setArgument(getRegion);
	regionDimensionFunction.getStatements().add(regionDimensionFunctionReturn);
	Dimension regionDimension = AnalyticsFactory.eINSTANCE.createDimension();
	regionDimension.setName("customerRegion");
	regionDimension.setCharacteristicFunction(regionDimensionSignature);
	cellSet.getDimensions().add(regionDimension);
	return cellSet;
    }

    private VariableExpression createVariableExpression(NamedValue variable) {
	VariableExpression itemParameterValue = ExpressionsFactory.eINSTANCE.createVariableExpression();
	itemParameterValue.setVariable(variable);
	return itemParameterValue;
    }
    
    @Test
    public void testAssociationEndSignatureImplementations() {
	try {
	    Resource resource = resourceSet.createResource(URI.createURI("http://testAssociationEndSignatureImplementations"));
	    
	    // set up data structures
	    SapClass salesOrderItem = createClass("SalesOrderItem");
	    resource.getContents().add(salesOrderItem);
	    SapClass product = createClass("Product");
            resource.getContents().add(product);
	    Association salesOrderItemToProduct = MetamodelUtils.createAssociation(resourceSet, salesOrderItem, "salesOrderItems", 0,
		    -1, /* nav */ false, /* comp */ true, /* ordered */ false,
		    /* unique */ false, product, "product", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false);
	    Map<Accessors, MethodSignature> productAccessors = exposeAssociationEnd(resourceSet,
		    salesOrderItemToProduct.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.SETTER });
	    SapClass salesOrder = createClass("SalesOrder");
            resource.getContents().add(salesOrder);
	    Association salesOrderToSalesOrderItems = MetamodelUtils.createAssociation(resourceSet, salesOrder, "salesOrder",
		    1, 1, /* nav */ true, /* comp */ true, /* ordered */ false, /* unique */ false,
		    salesOrderItem, "items", 0, -1, /* nav */ true, /* comp */ false, /* ordered */ true,
		    /* unique */ false);
	    Map<Accessors, MethodSignature> itemsAccessors = exposeAssociationEnd(resourceSet,
		    salesOrderToSalesOrderItems.getEnds().get(1),
		    new Accessors[] { Accessors.GETTER, Accessors.ADDER, Accessors.REMOVER });
	    SapClass customer = createClass("Customer");
            resource.getContents().add(customer);
	    Association salesOrderToCustomer = MetamodelUtils.createAssociation(resourceSet, salesOrder, "salesOrders",
		    0, -1, /* nav */ true, /* comp */ false, /* ordered */ false, /* unique */ false,
		    customer, "customer", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    SapClass string = MetamodelUtils.findClass(resourceSet, "String");
	    Association customerToRegion = MetamodelUtils.createAssociation(resourceSet, customer, "customerWithRegion",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "region", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    Association productToCategory = MetamodelUtils.createAssociation(resourceSet, product, "productWithCategory",
		    0, -1, /* nav */ false, /* comp */ false, /* ordered */ false, /* unique */ false,
		    string, "category", 1, 1, /* nav */ true, /* comp */ false, /* ordered */ false,
		    /* unique */ false);
	    Map<Accessors, MethodSignature> categoryAccessors = exposeAssociationEnd(resourceSet,
		    productToCategory.getEnds().get(1), new Accessors[] { Accessors.GETTER,
			    Accessors.SETTER });

	    // define a function that uses setter/getter/adder/remover to establish an
	    // object graph when executed, and from that determines a value
	    FunctionSignature sig = ClassesFactory.eINSTANCE.createFunctionSignature();
            resource.getContents().add(sig);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinition(resourceSet, salesOrderItem, 0, -1));
	    Block impl = ActionsFactory.eINSTANCE.createBlock();
	    sig.setImplementation(impl);

	    // -------------- variable declarations -------------------
	    // SalesOrderItem[] result;
	    NamedValueDeclaration resultDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable result = ActionsFactory.eINSTANCE.createVariable();
	    result.setName("result");
	    result.setOwnedTypeDefinition(sig.getOutput());
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);

	    // SalesOrder so;
	    NamedValueDeclaration soDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable so = ActionsFactory.eINSTANCE.createVariable();
	    so.setName("so");
	    so.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, salesOrder));
	    soDecl.setNamedValue(so);
	    impl.getStatements().add(soDecl);

	    // SalesOrderItem soi;
	    NamedValueDeclaration soiDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable soi = ActionsFactory.eINSTANCE.createVariable();
	    soi.setName("soi");
	    soi.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, salesOrderItem));
	    soiDecl.setNamedValue(soi);
	    impl.getStatements().add(soiDecl);

	    // Customer c;
	    NamedValueDeclaration cDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable c = ActionsFactory.eINSTANCE.createVariable();
	    c.setName("c");
	    c.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, customer));
	    cDecl.setNamedValue(c);
	    impl.getStatements().add(cDecl);

	    // Product p;
	    NamedValueDeclaration pDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable p = ActionsFactory.eINSTANCE.createVariable();
	    p.setName("p");
	    p.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, product));
	    pDecl.setNamedValue(p);
	    impl.getStatements().add(pDecl);

	    createCodeToCreateSalesOrder(resourceSet, salesOrder, customer, customerToRegion,
		    salesOrderToCustomer, impl, so, c, "EMEA");
	    // item #1
	    impl.getStatements().add(assignNewToVariable(resourceSet, salesOrderItem, soi));
	    createCodeToInvokeMethod(itemsAccessors.get(Accessors.ADDER), so, soi, impl);
	    impl.getStatements().add(assignNewToVariable(resourceSet, product, p));
	    createCodeToInvokeMethod(productAccessors.get(Accessors.SETTER), soi, p, impl);
	    createCodeToInvokeMethod(categoryAccessors.get(Accessors.SETTER), createVariableExpression(p),
		    MetamodelUtils.createStringLiteral(resourceSet, "TheCategory1"),
		    impl);

	    // item #2
	    impl.getStatements().add(assignNewToVariable(resourceSet, salesOrderItem, soi));
	    createCodeToInvokeMethod(itemsAccessors.get(Accessors.ADDER), so, soi, impl);
	    impl.getStatements().add(assignNewToVariable(resourceSet, product, p));
	    createCodeToInvokeMethod(productAccessors.get(Accessors.SETTER), soi, p, impl);
	    createCodeToInvokeMethod(categoryAccessors.get(Accessors.SETTER), createVariableExpression(p),
		    MetamodelUtils.createStringLiteral(resourceSet, "TheCategory2"),
		    impl);

	    // item #3
	    impl.getStatements().add(assignNewToVariable(resourceSet, salesOrderItem, soi));
	    createCodeToInvokeMethod(itemsAccessors.get(Accessors.ADDER), so, soi, impl);
	    impl.getStatements().add(assignNewToVariable(resourceSet, product, p));
	    createCodeToInvokeMethod(productAccessors.get(Accessors.SETTER), soi, p, impl);
	    createCodeToInvokeMethod(categoryAccessors.get(Accessors.SETTER), createVariableExpression(p),
		    MetamodelUtils.createStringLiteral(resourceSet, "TheCategory3"),
		    impl);
	    
	    // remove item #3 again
	    createCodeToInvokeMethod(itemsAccessors.get(Accessors.REMOVER), so, soi, impl);
	    
	    // now assemble the return expression that uses getters to navigate throughout the graph
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    ret.setArgument(createMethodCallExpression(categoryAccessors.get(Accessors.GETTER), createMethodCallExpression(productAccessors.get(Accessors.GETTER), createMethodCallExpression(itemsAccessors.get(Accessors.GETTER), createVariableExpression(so)))));
	    impl.getStatements().add(ret);
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce); // multi-valued because
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
    private void createCodeToInvokeMethod(MethodSignature method,
	    Variable on, Variable arg, Block impl) {
	Expression onExp = createVariableExpression(on);
	Expression argExp = createVariableExpression(arg);
	createCodeToInvokeMethod(method, onExp, argExp, impl);
    }

    /**
     * Creates a statement that invokes a single-argument method on the value to which <tt>onExp</tt>
     * evaluates, passing the value to which <tt>argExp</tt> evaluates. The
     * resulting statement is appended to <tt>impl</tt>'s statement sequence.
     */
    private void createCodeToInvokeMethod(MethodSignature method, Expression onExp,
	    Expression argExp, Block impl) {
	MethodCallExpression mce = createMethodCallExpression(method, onExp, argExp);
	ExpressionStatement es = ActionsFactory.eINSTANCE.createExpressionStatement();
	es.setExpression(mce);
	impl.getStatements().add(es);
    }

    /**
     * Creates and returns a method call expression. If argument expressions (<tt>argExp</tt>)
     * are provided, they are added to the expression's parameter list.
     */
    private MethodCallExpression createMethodCallExpression(MethodSignature method,
	    Expression onExp, Expression... argExps) {
	MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	mce.setObject(onExp);
	mce.setMethodSignature(method);
	for (Expression argExp:argExps) {
	    mce.getParameters().add(argExp);
	}
	return mce;
    }
    
    @Test
    public void testForeach() {
	try {
	    // sig = function() {
	    FunctionSignature sig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    Block impl = ActionsFactory.eINSTANCE.createBlock();
	    sig.setImplementation(impl);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	    sig.setOwnedTypeDefinitions(sig.getOutput());
	    //   Number[] arr;
	    NamedValueDeclaration arrDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable arr = ActionsFactory.eINSTANCE.createVariable();
	    arr.setName("arr");
	    arr.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    arrDecl.setNamedValue(arr);
	    impl.getStatements().add(arrDecl);
	    //   Number result = 0;
	    NamedValueDeclaration resultDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable result = ActionsFactory.eINSTANCE.createVariable();
	    result.setName("result");
	    result.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    result.setInitExpression(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);
	    int count = 3;
	    //    arr = arr->including(1);
	    //    arr = arr->including(2);
	    //    arr = arr->including(3);
	    for (int i=1; i<=count; i++) {
		Including incl = CollectionexpressionsFactory.eINSTANCE.createIncluding();
		incl.setSource(createVariableExpression(arr));
		incl.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, ""+i));
		Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
		assignment.setArgument(incl);
		assignment.setAssignTo(arr);
		impl.getStatements().add(assignment);
	    }
	    //   foreach (Number i:arr) {
	    Foreach foreach = ActionsFactory.eINSTANCE.createForeach();
	    impl.getStatements().add(foreach);
	    foreach.setCollection(createVariableExpression(arr));
	    behavioral.actions.Iterator iter = ActionsFactory.eINSTANCE.createIterator();
	    iter.setName("i");
	    iter.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	    foreach.setForVariable(iter);
	    Block foreachBlock = ActionsFactory.eINSTANCE.createBlock();
	    foreach.getNestedBlocks().add(foreachBlock);
	    //     result = result.plus(i);
	    MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    mce.setObject(createVariableExpression(result));
	    mce.setMethodSignature(MetamodelUtils.findMethod(resourceSet, "Number", "plus"));
	    mce.getParameters().add(createVariableExpression(iter));
	    Assignment assignmentToResult = ActionsFactory.eINSTANCE.createAssignment();
	    assignmentToResult.setArgument(mce);
	    assignmentToResult.setAssignTo(result);
	    foreachBlock.getStatements().add(assignmentToResult);
	    //   }
	    //   return result;
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    ret.setArgument(createVariableExpression(result));
	    impl.getStatements().add(ret);
	    // }
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce);
	    assertEquals(new Fraction(count*(count+1)/2), ((NativeObject) evalResult).getNativeObject());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Test
    public void testExcluding() {
	try {
	    // sig = function() {
	    FunctionSignature sig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    Block impl = ActionsFactory.eINSTANCE.createBlock();
	    sig.setImplementation(impl);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	    sig.setOwnedTypeDefinitions(sig.getOutput());
	    //   Number[] arr;
	    NamedValueDeclaration arrDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable arr = ActionsFactory.eINSTANCE.createVariable();
	    arr.setName("arr");
	    arr.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    arrDecl.setNamedValue(arr);
	    impl.getStatements().add(arrDecl);
	    //   Number result = 0;
	    NamedValueDeclaration resultDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable result = ActionsFactory.eINSTANCE.createVariable();
	    result.setName("result");
	    result.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ false, /* unique */ false));
	    result.setInitExpression(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
	    resultDecl.setNamedValue(result);
	    impl.getStatements().add(resultDecl);
	    int count = 3;
	    //    arr = arr->including(1);
	    //    arr = arr->including(2);
	    //    arr = arr->including(3);
	    for (int i=1; i<=count; i++) {
		Including incl = CollectionexpressionsFactory.eINSTANCE.createIncluding();
		incl.setSource(createVariableExpression(arr));
		incl.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, ""+i));
		Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
		assignment.setArgument(incl);
		assignment.setAssignTo(arr);
		impl.getStatements().add(assignment);
	    }
	    //   arr = arr->excluding(2);
	    Excluding excl = CollectionexpressionsFactory.eINSTANCE.createExcluding();
	    excl.setSource(createVariableExpression(arr));
	    excl.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, "2"));
	    Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
	    assignment.setArgument(excl);
	    assignment.setAssignTo(arr);
	    impl.getStatements().add(assignment);

	    //   foreach (Number i:arr) {
	    Foreach foreach = ActionsFactory.eINSTANCE.createForeach();
	    impl.getStatements().add(foreach);
	    foreach.setCollection(createVariableExpression(arr));
	    behavioral.actions.Iterator iter = ActionsFactory.eINSTANCE.createIterator();
	    iter.setName("i");
	    iter.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	    foreach.setForVariable(iter);
	    Block foreachBlock = ActionsFactory.eINSTANCE.createBlock();
	    foreach.getNestedBlocks().add(foreachBlock);
	    //     result = result.plus(i);
	    MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    mce.setObject(createVariableExpression(result));
	    mce.setMethodSignature(MetamodelUtils.findMethod(resourceSet, "Number", "plus"));
	    mce.getParameters().add(createVariableExpression(iter));
	    Assignment assignmentToResult = ActionsFactory.eINSTANCE.createAssignment();
	    assignmentToResult.setArgument(mce);
	    assignmentToResult.setAssignTo(result);
	    foreachBlock.getStatements().add(assignmentToResult);
	    //   }
	    //   return result;
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    ret.setArgument(createVariableExpression(result));
	    impl.getStatements().add(ret);
	    // }
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce);
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
	try {
	    // sig = function() {
	    FunctionSignature sig = ClassesFactory.eINSTANCE.createFunctionSignature();
	    Block impl = ActionsFactory.eINSTANCE.createBlock();
	    sig.setImplementation(impl);
	    sig.setOutput(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	    sig.setOwnedTypeDefinitions(sig.getOutput());
	    //   Number[] arr;
	    NamedValueDeclaration arrDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable arr = ActionsFactory.eINSTANCE.createVariable();
	    arr.setName("arr");
	    arr.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ true, unique));
	    arrDecl.setNamedValue(arr);
	    impl.getStatements().add(arrDecl);
	    //   Number result = 0;
	    NamedValueDeclaration resultDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable result = ActionsFactory.eINSTANCE.createVariable();
	    result.setName("result");
	    result.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ true, unique));
	    result.setInitExpression(MetamodelUtils.createNumberLiteral(resourceSet, "0"));
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
		    Including incl = CollectionexpressionsFactory.eINSTANCE.createIncluding();
		    incl.setSource(createVariableExpression(arr));
		    incl.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, "" + i));
		    Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
		    assignment.setArgument(incl);
		    assignment.setAssignTo(arr);
		    impl.getStatements().add(assignment);
		}
	    }
	    //   Number[] toExclude;
	    NamedValueDeclaration toExcludeDecl = ActionsFactory.eINSTANCE.createNamedValueDeclaration();
	    Variable toExcludeVar = ActionsFactory.eINSTANCE.createVariable();
	    toExcludeVar.setName("toExclude");
	    toExcludeVar.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinition(resourceSet, MetamodelUtils.findClass(resourceSet, "Number"), 0, -1,
		    /* ordered */ true, unique));
	    toExcludeDecl.setNamedValue(toExcludeVar);
	    impl.getStatements().add(toExcludeDecl);
	    
	    //    toExclude = toExclude->including(toExclude[0]);
	    //    ...
	    //    toExclude = toExclude->including(toExclude[toExclude.length-1]);
	    for (int excl:toExclude) {
		Including incl = CollectionexpressionsFactory.eINSTANCE.createIncluding();
		incl.setSource(createVariableExpression(toExcludeVar));
		incl.setArgument(MetamodelUtils.createNumberLiteral(resourceSet, ""+excl));
		Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
		assignment.setArgument(incl);
		assignment.setAssignTo(toExcludeVar);
		impl.getStatements().add(assignment);
	    }
	    
	    //   arr = arr->excludingAt(toExclude, at);
	    ExcludingAt excl = CollectionexpressionsFactory.eINSTANCE.createExcludingAt();
	    excl.setSource(createVariableExpression(arr));
	    excl.setArgument(createVariableExpression(toExcludeVar));
	    excl.setAt(at);
	    Assignment assignment = ActionsFactory.eINSTANCE.createAssignment();
	    assignment.setArgument(excl);
	    assignment.setAssignTo(arr);
	    impl.getStatements().add(assignment);

	    //   foreach (Number i:arr) {
	    Foreach foreach = ActionsFactory.eINSTANCE.createForeach();
	    impl.getStatements().add(foreach);
	    foreach.setCollection(createVariableExpression(arr));
	    behavioral.actions.Iterator iter = ActionsFactory.eINSTANCE.createIterator();
	    iter.setName("i");
	    iter.setOwnedTypeDefinition(MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, MetamodelUtils.findClass(resourceSet, "Number")));
	    foreach.setForVariable(iter);
	    Block foreachBlock = ActionsFactory.eINSTANCE.createBlock();
	    foreach.getNestedBlocks().add(foreachBlock);
	    //     result = result.plus(i);
	    MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	    mce.setObject(createVariableExpression(result));
	    mce.setMethodSignature(MetamodelUtils.findMethod(resourceSet, "Number", "plus"));
	    mce.getParameters().add(createVariableExpression(iter));
	    Assignment assignmentToResult = ActionsFactory.eINSTANCE.createAssignment();
	    assignmentToResult.setArgument(mce);
	    assignmentToResult.setAssignTo(result);
	    foreachBlock.getStatements().add(assignmentToResult);
	    //   }
	    //   return result;
	    Return ret = ActionsFactory.eINSTANCE.createReturn();
	    ret.setArgument(createVariableExpression(result));
	    impl.getStatements().add(ret);
	    // }
	    
	    FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(resourceSet, sig);
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evalResult = new RunletInterpreter(resourceSet, new RunletInMemoryRepository(com.sap.runlet.interpreter.Activator.getDefault().getModelAdapter())).evaluate(fce);
	    return ((Fraction) ((NativeObject) evalResult).getNativeObject()).intValue();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    @Test
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
