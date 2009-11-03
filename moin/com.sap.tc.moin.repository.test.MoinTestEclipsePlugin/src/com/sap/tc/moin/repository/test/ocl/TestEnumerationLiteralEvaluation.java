package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.serviceinteractions.CommunicationModeEnum;
import com.sap.serviceinteractions.TwoWayInteraction;
import com.sap.serviceinteractions.__impl.TwoWayInteractionImpl;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on the evaluation of EnumerationLiteral
 * expressions.
 */
public class TestEnumerationLiteralEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */

    @Test
    public void testEnumLiteral( ) {

        RefClassImpl twoWayInteractionClass = (RefClassImpl) super.svcIntPkg.getTwoWayInteraction( coreConnection );

        Collection<OclStatement> stmts = parse( "context TwoWayInteraction inv: " + "self.mode = CommunicationMode::Synchronous", twoWayInteractionClass.refMetaObject( ), this.types );

        synchronized ( this.syncObjectForWrite ) {
            TwoWayInteraction wrappedElement = coreConnection.getWrapper( ).createElementInPartition( TwoWayInteraction.class, null );
            TwoWayInteractionImpl interaction = (TwoWayInteractionImpl) getTestHelper( ).getCorePartitionable( wrappedElement );
            interaction.setMode( coreConnection, CommunicationModeEnum.SYNCHRONOUS );
            verify( evaluate( interaction, stmts ), "Communication mode should be synchronous" );
            interaction.setMode( coreConnection, CommunicationModeEnum.ASYNCHRONOUS );
            verify( !evaluate( interaction, stmts ), "Communication mode should not be synchronous" );
        }
    }
}
