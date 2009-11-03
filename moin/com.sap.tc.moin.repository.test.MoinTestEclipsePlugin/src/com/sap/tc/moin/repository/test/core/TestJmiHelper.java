/*
 * Created on 01.03.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import org.junit.Test;

import com.sap.tc.moin.repository.JmiHelper;


public class TestJmiHelper extends CoreMoinTest {

    @Test
    public void testGetReferences( ) throws Exception {

        JmiHelper jmiHelper = getMOINConnection( ).getJmiHelper( );
        MofClass mofClass = getMOINConnection( ).getClass( MofClass.CLASS_DESCRIPTOR ).refMetaObject( );
        List<Reference> references = jmiHelper.getReferences( mofClass, AggregationKindEnum.COMPOSITE, true );
        assertEquals( 1, references.size( ) );
        assertEquals( "contents", references.get( 0 ).getName( ) );
    }

}
