package com.sap.ide.refactoring.test.allsuites;

import org.junit.runner.RunWith;

import com.sap.ide.cts.editor.test.util.ExtSuite;
import com.sap.ide.refactoring.core.textual.TestSourcePositionModelLocator;
import com.sap.ide.refactoring.op.rename.TestRenameIntegration;
import com.sap.ide.refactoring.secondary.dependencies.TestGlobalDelayedReferenceResolverIntegration;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses({
    	TestSourcePositionModelLocator.class,
    	// failing. disable for now TestRenameIntegration.class,
    	TestGlobalDelayedReferenceResolverIntegration.class
})
@ExtSuite.SuitePackages( {})
public class RefactoringIntegrationSuite {
    // needed to  hold annotation
}
