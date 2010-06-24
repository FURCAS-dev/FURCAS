package com.sap.ide.refactoring.op.rename;


public class TestRenameIntegration extends TestRename {

    /**
     * By running as an integration tests we make sure the whole editor environment is enabled
     * (e.g. the global delayed resolved references in the background)
     *
     *  Tests are defined in the super class.
     */
    public TestRenameIntegration() {
	isIntegrationTest = true;
    }


}
