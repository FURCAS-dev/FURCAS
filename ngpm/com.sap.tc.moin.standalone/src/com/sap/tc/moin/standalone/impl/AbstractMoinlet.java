package com.sap.tc.moin.standalone.impl;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.standalone.Moinlet;
import com.sap.tc.moin.standalone.util.MoinArgumentsToolkit;

/**
 * Contains methods common to most moinlets. Mostly for parameters parsing.
 * 
 * @author D046220
 */
public abstract class AbstractMoinlet implements Moinlet {

    protected String getSourcePath(String[] args) {

        return MoinArgumentsToolkit.getArgumentValue("-sourcePath", args, "-sourcePath has to provide the path to the source of the model component.");
    }

    protected String getDcName(String[] args) {

        return MoinArgumentsToolkit.getArgumentValue("-dcName", args, "-dcName has to tell a DC, e.g. \"tc/moin/testcases_1.0_source/testcases\"");
    }

    protected String[] getReferencedModelJars(String[] args) {

        String argumentValue = MoinArgumentsToolkit.getArgumentValue("-referencedModels", args, "-referencedModels argument has to provide a semicolon separated list of model xmi-zip pathes.", false);
        return argumentValue == null ? null : argumentValue.split(";");
    }

    /**
     * Convinience method for fast connection creation.
     * 
     * @param moin initialized moin instance.
     * @param clientSpec client spec created by the moin starter.
     * @return connection retreived from a newly created session.
     */
    protected Connection createConnection(Moin moin, CompoundClientSpec clientSpec) {

        Connection conn = moin.createSession(clientSpec).createConnection();
        return conn;
    }

}
