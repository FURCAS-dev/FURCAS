package com.sap.tc.moin.standalone.example;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.standalone.impl.BaseStandaloneMoinlet;

/**
 * Executes a simple query on company meta-model instances.
 * 
 * @author D046220
 */
public class ExecuteQueryExampleMoinlet extends BaseStandaloneMoinlet {

    @Override
    public void executeFunctionality(String[] arguments, Moin moin, Connection conn, String dataArea) {
        MQLResultSet rs = conn.getMQLProcessor().execute("select el from Company::Employee as el");

        System.out.println("Found: " + rs.getSize() + " employees.");
    }

}
