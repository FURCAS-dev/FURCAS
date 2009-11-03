package com.sap.tc.moin.repository.test.ocl;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;

import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclBoolean operations.
 */
public class TestReparseExpression extends BaseOclEvaluationTest {

    /**
     * First parse a bad expression, then a good one; the good one should always
     * parse
     */

    @Test
    public void testReparseExpression( ) {

        String goodMessage = "context Message inv: let test:Message = self.triggers->asSequence()->at(1) in test->notEmpty() = true";
        String bad_Message = "context Message inv: let test:Message = self.triggers2->asSequence()->at(1) in test->notEmpty() = true";

        this.parseFail( bad_Message, this.svcIntPkg.getMessage( coreConnection ).refMetaObject( ), new RefPackage[] { this.svcIntPkg } );

        this.parse( goodMessage, this.svcIntPkg.getMessage( coreConnection ).refMetaObject( ), new RefPackage[] { this.svcIntPkg } );

    }

}
