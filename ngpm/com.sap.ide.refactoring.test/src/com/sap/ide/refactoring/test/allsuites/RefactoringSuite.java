package com.sap.ide.refactoring.test.allsuites;

import org.junit.runner.RunWith;

import com.sap.ide.cts.editor.test.util.ExtSuite;
import com.sap.ide.refactoring.core.constraints.TestMetaModelConstraintViolationHandling;
import com.sap.ide.refactoring.core.execution.TestCommandUndoRedoHelper;
import com.sap.ide.refactoring.core.execution.TestRefactoringCommandExecutor;
import com.sap.ide.refactoring.core.textual.TestCommandExecutionPrettyPrintInteraction;
import com.sap.ide.refactoring.core.textual.TestTextBlockInChangeCalculator;
import com.sap.ide.refactoring.core.textual.TestTextBlockSynchronizationCommand;
import com.sap.ide.refactoring.core.validation.TestValidationCommands;
import com.sap.ide.refactoring.dependencies.TestMoinCommandStack;
import com.sap.ide.refactoring.op.move.TestMove;
import com.sap.ide.refactoring.op.rename.TestRename;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses( {
    	TestRefactoringCommandExecutor.class,
    	TestCommandExecutionPrettyPrintInteraction.class,
    	TestValidationCommands.class,
    	TestCommandUndoRedoHelper.class,
    	TestRename.class,
    	TestTextBlockInChangeCalculator.class,
    	TestMoinCommandStack.class,
    	TestMove.class,
    	TestTextBlockSynchronizationCommand.class,
    	TestMetaModelConstraintViolationHandling.class
    })
@ExtSuite.SuitePackages( {})
public class RefactoringSuite {
    // needed to  hold annotation
}
