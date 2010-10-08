/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.ui.internal.keys.model.ModelElement;
import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.parsing.MofStructureFieldStub;
import com.sap.mi.textual.parsing.MofStructureTypeStub;

/**
 * Tests the mock object that is created by the MOIN adapter to defer the creation until all fields are known.
 */
public class StructureTypeMockTest {

    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject#StructureTypeMockObject(com.sap.tc.moin.repository.mmi.model.StructureType)}.
     */
    @Test
    public void testStructureTypeMockObject() {
        MofStructureTypeStub strucType = new MofStructureTypeStub();
        StructureTypeMockObject mock = new StructureTypeMockObject(strucType );
        // white box testing
        assertEquals(strucType, mock.structureType);
    }
    
    @Test
    public void testGetStructureType() {
      MofStructureTypeStub strucType = new MofStructureTypeStub();
      StructureTypeMockObject mock = new StructureTypeMockObject(strucType );
      // black box testing
      assertEquals(strucType, mock.getStructureType());
      
      // white box testing
      strucType = new MofStructureTypeStub();
      mock.structureType = strucType;
      assertEquals(strucType, mock.getStructureType());
    }

    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject#setField(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testSetFieldUnknownFieldname() {
        MofStructureTypeStub strucType = new MofStructureTypeStub();
        ModelElement field1 = new MofStructureFieldStub();
        ModelElement field2 = new MofStructureFieldStub();
        strucType.contents.add(field1 );
        strucType.contents.add(field2 );

        StructureTypeMockObject mock = new StructureTypeMockObject(strucType );

        boolean exceptionCaught = false;
        try {
            mock.setField("Test", null);
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
    }
    
    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject#setField(java.lang.String, java.lang.Object)}.
     * @throws Exception 
     */
    @Test
    public void testSetField() throws Exception {
        MofStructureTypeStub strucType = new MofStructureTypeStub();
        MofStructureFieldStub field1 = new MofStructureFieldStub();
        field1.name = "Test";
        MofStructureFieldStub field2 = new MofStructureFieldStub();
        strucType.contents.add(field1 );
        strucType.contents.add(field2 );

        StructureTypeMockObject mock = new StructureTypeMockObject(strucType );
        Object value = new Object();
        mock.setField("Test", value);
        
        // white box test
        assertEquals(value, mock.structureFields.get("Test"));
    }

    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject#getStructureField(java.lang.String)}.
     */
    @Test
    public void testGetStructureField() {
        MofStructureTypeStub strucType = new MofStructureTypeStub();
        StructureTypeMockObject mock = new StructureTypeMockObject(strucType );
//      white box test
        Object value = new Object();
        mock.structureFields.put("Test", value);

        assertEquals(value, mock.getStructureField("Test"));
    }

    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject#getStructureField(java.lang.String)}.
     */
    @Test
    public void testGetStructureFieldNull() {
        MofStructureTypeStub strucType = new MofStructureTypeStub();
        MofStructureFieldStub field1 = new MofStructureFieldStub();
        field1.name = "Test";
        MofStructureFieldStub field2 = new MofStructureFieldStub();
        strucType.contents.add(field1 );
        strucType.contents.add(field2 );
        
        StructureTypeMockObject mock = new StructureTypeMockObject(strucType );
//      white box test
        Object value = new Object();
        mock.structureFields.put("Test", value);

        assertEquals(value, mock.getStructureField("Test"));
    }

    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject#getStructureField(java.lang.String)}.
     */
    @Test
    public void testSetGetStructureField() {
        MofStructureTypeStub strucType = new MofStructureTypeStub();
        StructureTypeMockObject mock = new StructureTypeMockObject(strucType );
//      white box test
        Object value = new Object();
        mock.structureFields.put("Test", value);

        assertEquals(value, mock.getStructureField("Test"));
    }
}
