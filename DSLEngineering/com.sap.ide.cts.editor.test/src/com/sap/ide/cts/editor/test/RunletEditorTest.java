package com.sap.ide.cts.editor.test;

import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

import data.classes.SapClass;

public class RunletEditorTest extends CtsEditorTest {

    protected SapClass findClass(String classname) {
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
