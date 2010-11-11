package com.sap.ide.cts.editor.allsuites;

import org.junit.runner.RunWith;

import com.sap.furcas.test.util.ExtSuite;
import com.sap.ide.cts.editor.document.TestCtsDocument;
import com.sap.ide.cts.editor.test.TestNgpmEditingActions;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses( { TestNgpmEditingActions.class, TestCtsDocument.class})
@ExtSuite.SuitePackages( {})
public class CtsEditorTestSuite {
	// need this to hold annotations
}
