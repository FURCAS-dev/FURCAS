package com.sap.finex.editor.tests;

import structure.FinexClass;

import com.sap.ide.cts.editor.test.CtsEditorTest;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

public class FinexEditorTest extends CtsEditorTest {
    protected FinexClass findClass(String classname) {
    	MQLProcessor mql = connection.getMQLProcessor();
    	MQLResultSet queryResult = mql.execute(
    		"select c from structure::FinexClass as c where for c(name='"
    				+ classname + "')", mql.getQueryScopeProvider(
    		/* scopeInclusive */false, /* partitionScope */
    		null, (String[]) null));
    	FinexClass clazz = (FinexClass) queryResult.getRefObjects("c")[0];
    	return clazz;
    }


}
