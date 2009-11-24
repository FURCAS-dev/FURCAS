package com.sap.finex.metamodel.utils;

import structure.FinexClass;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * Some utility / helper methods for the FINEX metamodel
 * 
 * @author Axel Uhl D043530
 *
 */
public class MetamodelUtils {
    public static FinexClass findClass(Connection conn, String classname) {
	MQLProcessor mql = conn.getMQLProcessor();
	MQLResultSet queryResult = mql
		.execute(
	    "select c from structure::FinexClass as c where for c(name='"+classname+"')",
	    mql.getQueryScopeProvider(/* scopeInclusive */false, /* partitionScope */
		    null, (String[]) null));
	FinexClass clazz = (FinexClass) queryResult.getRefObjects("c")[0];
	return clazz;
    }
}
