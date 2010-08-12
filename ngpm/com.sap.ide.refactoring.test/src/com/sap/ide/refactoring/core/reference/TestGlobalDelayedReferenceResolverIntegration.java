package com.sap.ide.refactoring.core.reference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import ngpm.NgpmPackage;

import org.junit.After;
import org.junit.Test;

import behavioral.actions.Block;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.Return;
import behavioral.actions.Variable;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.refactoring.core.reference.CompressingReEvaluationLog;
import com.sap.ide.refactoring.core.reference.ReEvaluationInfo;
import com.sap.ide.refactoring.core.reference.ReEvaluationLogger;
import com.sap.ide.refactoring.core.reference.ReEvaluationType;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.mi.textual.parsing.textblocks.reference.GlobalDelayedReferenceResolver;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.ConnectionFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NamedValue;
import data.classes.SapClass;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.VariableExpression;

public class TestGlobalDelayedReferenceResolverIntegration extends RefactoringBaseTest {
    
    
    private ChangeListener moinListener;
    private ReEvaluationLogger reevaluationListener;

    public TestGlobalDelayedReferenceResolverIntegration() {
	isIntegrationTest = true;
    }
    
    
    private void registerChangeListener(final Collection<ChangeEvent> events) {
	moinListener = new ChangeListener() {
	    @Override
	    public void notify(final ChangeEvent event) {
		events.add(event);
	    }
	};
	final EventFilter filter = new ConnectionFilter(connection);
	connection.getEventRegistry().registerListener(moinListener, filter);
    }
    
    /**
     * Setups the global delayed reference resolver and returns a live-log which 
     * collects all re-evaluated references. 
     */
    private CompressingReEvaluationLog registerReferencesForReevaluation(SapClass clazz) {
	// quick'n'dirty: just open the editor. It will do the registration
	AbstractGrammarBasedEditor editor = openEditor(clazz);
	getDocument(editor); // finish initialization
	close(editor);
	
	CompressingReEvaluationLog log = new CompressingReEvaluationLog();
	reevaluationListener = new ReEvaluationLogger(log);
	GlobalDelayedReferenceResolver.getInstance().addReferenceResolvingListener(reevaluationListener);
	return log;
    }
    
    @After
    public void tearDownRegisteredListeners() {
	if (moinListener != null) {
	    connection.getEventRegistry().deregister(moinListener);
	}
	if (reevaluationListener != null) {
	    GlobalDelayedReferenceResolver.getInstance().removeReferenceResolvingListener(reevaluationListener);
	}
    }
    
    /**
     * Rename a class that is not referenced from anywhere.
     * It is assumed, that the delayed reference resolver stays calm...
     * 
     * @throws Exception
     */
    @Test
    public void testRenamRefactoringEventTriggering() throws Exception {
	SapClass clazz = findRunletClass("ClassWithAbstractMethod");
	registerReferencesForReevaluation(clazz);
	// Change the name twice: Makes sure that we do not log
	// side effects (other reevaluations) that happen just because
	// there is A change.
	clazz.setName("NewName");
	
	ArrayList<ChangeEvent> eventQueue = new ArrayList<ChangeEvent>();
	registerChangeListener(eventQueue);
	
	clazz.setName("NewName2");
	
	assertEquals(1, eventQueue.size());
	assertTrue(eventQueue.iterator().next() instanceof AttributeValueChangeEvent);
    }

    @Test
    public void testRenameDoesNotBreakExistingReference() {
        SapClass clazz = findRunletClass("RedefineParameterTst2");
	
	MethodSignature method = clazz.getOwnedSignatures().iterator().next(); 
	Block block = (Block) method.getImplementation();
	NamedValue variable = block.getVariables().iterator().next();
	Return statement = (Return) block.getStatements().get(1);
	
	NamedValue returnedVariable = ((VariableExpression) statement.getArgument()).getVariable();
	assertEquals("Should bind to the variable (not the method parameter)",
		variable, returnedVariable);
	
	registerReferencesForReevaluation(clazz);
	ArrayList<ChangeEvent> eventQueue = new ArrayList<ChangeEvent>();
	registerChangeListener(eventQueue);
	
	variable.setName("someStrangeNewName");

	// We do not expect a re-evaluation. Just an attribute change event for the rename.
	assertEquals(1, eventQueue.size());
	assertTrue(eventQueue.iterator().next() instanceof AttributeValueChangeEvent);
	assertEquals("someStrangeNewName", ((VariableExpression) statement.getArgument()).getVariable().getName());
    }
    
    /**
     * We remove a variable declaration from a block. We expect that all variable usages
     * now use the other variable declaration of the same name in the current scope.
     */
    @Test
    public void testVariableDeleteTriggersReBind() {
        SapClass clazz = findRunletClass("RedefineParameterTst2");
        CompressingReEvaluationLog log = registerReferencesForReevaluation(clazz);
	
	MethodSignature method = clazz.getOwnedSignatures().iterator().next(); 
	NamedValue parameter = method.getInput().iterator().next();
	Block block = (Block) method.getImplementation();
	NamedValueDeclaration variableDeclaration = (NamedValueDeclaration) block.getStatements().get(0);
	Return returnStatement = (Return) block.getStatements().get(1);
	NamedValue variable = variableDeclaration.getNamedValue();
	
	NamedValue oldReturnedVariable = ((VariableExpression) returnStatement.getArgument()).getVariable();
	assertEquals("Should bind to the variable (not the method parameter)",
		variable, oldReturnedVariable);
	
	variableDeclaration.refDelete();
	
	// Assert new model state
	NamedValue newReturnedVariable = ((VariableExpression) returnStatement.getArgument()).getVariable();
	assertEquals("Should rebind to the method parameter)",
		parameter, newReturnedVariable);
	
	// Assert re-evalutaion change log
	assertEquals("Only the actual variable rebind should have happend", 1, log.getLoggedReEvaluations().size());
	ReEvaluationInfo reEvalInfo = log.getLoggedReEvaluations().iterator().next();
	assertEquals(ReEvaluationType.REBOUND_TO_OTHER, reEvalInfo.type);
	assertEquals(oldReturnedVariable, reEvalInfo.originalValue);
	assertEquals(newReturnedVariable, reEvalInfo.currentValue);
    }
    
    
    
    /**
     * We create a new variable declaration, shadowing the existing ones.
     * We expect that all variable usages now bind to the new variable.
     */
    @Test
    public void testVariableCreationTriggersReBind() {
        SapClass clazz = findRunletClass("RedefineParameterTst2");
        CompressingReEvaluationLog log = registerReferencesForReevaluation(clazz);
        
	MethodSignature method = clazz.getOwnedSignatures().iterator().next(); 
	Block block = (Block) method.getImplementation();
	NamedValue variable = block.getVariables().iterator().next();
	Return returnStatement = (Return) block.getStatements().get(block.getStatements().size() -1);
	
	NamedValue oldReturnedVariable = ((VariableExpression) returnStatement.getArgument()).getVariable();
	assertEquals("Should bind to the variable (not the method parameter)",
		variable, oldReturnedVariable);
	
	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	Variable newVariable = (Variable) rootPkg.getBehavioral().getActions().getVariable().refCreateInstance();
	newVariable.setName(variable.getName()); // give the name of the currently bound variable
	NamedValueDeclaration newVariableDeclaration = (NamedValueDeclaration) rootPkg.getBehavioral().getActions().getNamedValueDeclaration().refCreateInstance();
	newVariableDeclaration.setNamedValue(newVariable);
		
	// finally, put the variable into scope
	block.getStatements().add(1, newVariableDeclaration);
	
	// Assert the model
	NamedValue newReturnedVariable = ((VariableExpression) returnStatement.getArgument()).getVariable();
	assertEquals("Should rebind to the newly created variable)",
		newVariable, newReturnedVariable);
	
	// Assert re-evalutaion change log
	assertEquals("Only the actual variable rebind should have happend", 1, log.getLoggedReEvaluations().size());
	ReEvaluationInfo reEvalInfo = log.getLoggedReEvaluations().iterator().next();
	assertEquals(ReEvaluationType.REBOUND_TO_OTHER, reEvalInfo.type);
	assertEquals(oldReturnedVariable, reEvalInfo.originalValue);
	assertEquals(newReturnedVariable, reEvalInfo.currentValue);
    }
    
    /**
     * We remove a variable declaration from a block and later move it back
     * We expect that the log detects that we rebind to the same. 
     */
    @Test
    public void testMoveVariableOutOfScopeAndBackAgain() {
	SapClass clazz = findRunletClass("RedefineParameterTst2");
	CompressingReEvaluationLog log = registerReferencesForReevaluation(clazz);
	
	MethodSignature method = clazz.getOwnedSignatures().iterator().next(); 
	Block block = (Block) method.getImplementation();
	NamedValueDeclaration oldVariableDeclaration = (NamedValueDeclaration) block.getStatements().get(0);
	Return returnStatement = (Return) block.getStatements().get(1);
	NamedValue variable = oldVariableDeclaration.getNamedValue();
	
	NamedValue oldReturnedVariable = ((VariableExpression) returnStatement.getArgument()).getVariable();
	assertEquals("Should bind to the variable (not the method parameter)",
		variable, oldReturnedVariable);
	
	// kill the old variableDecl and then add a new; both using the same attribute
	oldVariableDeclaration.refDelete();
	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	NamedValueDeclaration newVariableDeclaration = (NamedValueDeclaration) rootPkg.getBehavioral().getActions().getNamedValueDeclaration().refCreateInstance();
	newVariableDeclaration.setNamedValue((Variable) variable);
	block.getStatements().add(0, newVariableDeclaration);
	
	// Assert new model state
	NamedValue newReturnedVariable = ((VariableExpression) returnStatement.getArgument()).getVariable();
	assertEquals("Should still rebind to the old known variable)",
		variable, newReturnedVariable);
	
	// Assert re-evalutaion change log
	assertEquals("Only the actual variable rebind should have happend", 1, log.getLoggedReEvaluations().size());
	ReEvaluationInfo reEvalInfo = log.getLoggedReEvaluations().iterator().next();
	assertEquals(ReEvaluationType.REBOUND_TO_SAME, reEvalInfo.type);
	assertEquals(reEvalInfo.currentValue, reEvalInfo.originalValue);
    }
    
    /**
     * Replace the parameter type String with Number. Number doesn't has a length() method.
     * The existing length() call should therefore no longer be bound.
     */
    @Test
    public void testParameterTypeChangesUnboundsMethodCall() {
        SapClass clazz = findRunletClass("MethodCallOutputMultiplicityTest");
        CompressingReEvaluationLog log = registerReferencesForReevaluation(clazz);

        MethodSignature method = clazz.getOwnedSignatures().iterator().next();
        NamedValue parameter = method.getInput().iterator().next();
        ClassTypeDefinition typeDefinition = (ClassTypeDefinition) parameter.getType();

	Return returnStatement = (Return) ((Block) method.getImplementation()).getStatements().get(0);
	MethodCallExpression methodCall = (MethodCallExpression) returnStatement.getArgument();
		
	assertEquals("At first, the method of String should be called",
		findRunletClass("String"), methodCall.getMethodSignature().getOwningClass());
	
	typeDefinition.setClazz(findRunletClass("Number"));
		
	// Assert new model state
	assertTrue("Number does not have such a method. Method should no longer be bound.",
		methodCall.getMethodSignature() == null);
	
	// Assert re-evalutaion change log
	assertEquals("Only the actual method unsetting should have happend", 1, log.getLoggedReEvaluations().size());
	ReEvaluationInfo reEvalInfo = log.getLoggedReEvaluations().iterator().next();
	assertEquals(ReEvaluationType.FROM_BOUND_TO_FREE, reEvalInfo.type);
    }
    
    /**
     * Replace the parameter type String with Binary. Binary has a length() method.
     * The existing length() call should therefore no longer be bound to the method
     * on String, but to the respective Method on binary.
     */
    @Test
    public void testParameterTypeChangesReBindsMethodCall() {
        SapClass clazz = findRunletClass("MethodCallOutputMultiplicityTest");
        CompressingReEvaluationLog log = registerReferencesForReevaluation(clazz);
        
        MethodSignature method = clazz.getOwnedSignatures().iterator().next();
        NamedValue parameter = method.getInput().iterator().next();
        ClassTypeDefinition typeDefinition = (ClassTypeDefinition) parameter.getType();

	Return returnStatement = (Return) ((Block) method.getImplementation()).getStatements().get(0);
	MethodCallExpression methodCall = (MethodCallExpression) returnStatement.getArgument();
	
	assertEquals("At first, the method of String should be called",
		findRunletClass("String"), methodCall.getMethodSignature().getOwningClass());
	
	typeDefinition.setClazz(findRunletClass("Binary"));
	
	// Assert new model state
	assertEquals("Method should now be bound to Binary.",
		findRunletClass("Binary"), methodCall.getMethodSignature().getOwningClass());
	
	// Assert re-evalutaion change log
	assertEquals("Only the actual method rebind should have happend", 1, log.getLoggedReEvaluations().size());
	ReEvaluationInfo reEvalInfo = log.getLoggedReEvaluations().iterator().next();
	assertEquals(ReEvaluationType.REBOUND_TO_OTHER, reEvalInfo.type);
    }
    
}
