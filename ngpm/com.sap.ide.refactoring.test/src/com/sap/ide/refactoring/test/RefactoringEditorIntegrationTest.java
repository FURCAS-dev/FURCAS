package com.sap.ide.refactoring.test;

import com.sap.ide.cts.editor.test.CtsEditorTest;

public class RefactoringEditorIntegrationTest extends CtsEditorTest {

    protected SapClass findRunletClass(String classname) {
    	MQLProcessor mql = connection.getMQLProcessor();
    	MQLResultSet queryResult = mql.execute(
    		"select c from data::classes::SapClass as c where for c(name='"
    				+ classname + "')", mql.getQueryScopeProvider(
    		/* scopeInclusive */false, /* partitionScope */
    		null, (String[]) null));
    	SapClass clazz = (SapClass) queryResult.getRefObjects("c")[0];
    	return clazz;
    }
    
}
