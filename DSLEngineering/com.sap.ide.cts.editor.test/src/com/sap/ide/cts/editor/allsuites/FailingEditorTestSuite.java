package com.sap.ide.cts.editor.allsuites;

import org.junit.runner.RunWith;

import com.sap.furcas.test.util.ExtSuite;
import com.sap.ide.cts.editor.test.FailingEditingActions;

@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses( { FailingEditingActions.class})
@ExtSuite.SuitePackages( {})
public class FailingEditorTestSuite {
    // need this to hold annotations
}

