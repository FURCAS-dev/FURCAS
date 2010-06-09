package com.sap.ide.refactoring.test.allsuites;

import org.junit.runner.RunWith;

import com.sap.ide.cts.editor.test.util.ExtSuite;
import com.sap.ide.refactoring.core.TestCommandUndoRedoHelper;
import com.sap.ide.refactoring.core.TestTextBlockAwareRefactoringCommandExecutor;
import com.sap.ide.refactoring.core.model.validation.TestValidationCommands;
import com.sap.ide.refactoring.core.textual.TestTextBlockInChangeCalculator;
import com.sap.ide.refactoring.op.rename.TestRename;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses( {
    	TestTextBlockAwareRefactoringCommandExecutor.class,
    	TestValidationCommands.class,
    	TestCommandUndoRedoHelper.class,
    	TestRename.class,
    	TestTextBlockInChangeCalculator.class
    })
@ExtSuite.SuitePackages( {})
public class RefactoringSuite {
    // needed to  hold annotation
}
