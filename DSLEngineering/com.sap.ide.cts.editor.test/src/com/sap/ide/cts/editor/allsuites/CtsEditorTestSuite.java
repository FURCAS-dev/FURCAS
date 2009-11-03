package com.sap.ide.cts.editor.allsuites;

import org.junit.runner.RunWith;

import com.sap.ide.cts.editor.document.TestCtsDocument;
import com.sap.ide.cts.editor.document.TestCtsHistoryDocument;
import com.sap.ide.cts.editor.test.TestNgpmEditingActions;
import com.sap.ide.cts.editor.test.util.ExtSuite;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses( { TestNgpmEditingActions.class, TestCtsDocument.class,
	TestCtsHistoryDocument.class})
@ExtSuite.SuitePackages( {})
public class CtsEditorTestSuite {
	// need this to hold annotations
}
