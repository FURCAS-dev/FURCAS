package com.sap.ide.refactoring.test.allsuites;

import org.junit.runner.RunWith;

import com.sap.ide.cts.editor.test.util.ExtSuite;
import com.sap.ide.refactoring.core.reference.TestGlobalDelayedReferenceResolverIntegration;
import com.sap.ide.refactoring.core.textual.TestSourcePositionModelLocator;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses({
    	TestSourcePositionModelLocator.class,
    	TestGlobalDelayedReferenceResolverIntegration.class
})
@ExtSuite.SuitePackages( {})
public class RefactoringIntegrationSuite {
    // needed to  hold annotation
}
