/**
 * 
 */
package com.sap.mi.textual.parsing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.internal.keys.model.ModelElement;
import org.junit.Test;

/**
 *
 */
public class MofStubTest  {

    @Test
    public void testName() throws Exception {
       MofAnyStub stub = new MofAnyStub();
       
       stub.name = "test";
       assertEquals( "test", stub.getName());
       
       stub.setName("test2");
       assertEquals( "test2", stub.name);
       
       stub.setName("test3");
       assertEquals( "test3", stub.getName());
    }
    
    @Test
    public void testUpperLower() throws Exception {
       MofAnyStub stub = new MofAnyStub();
       assertEquals(-1, stub.getUpper());
       stub.upper = -1;
       assertEquals(-1, stub.getUpper());
       stub.upper = 0;
       assertEquals(0, stub.getUpper());
       stub.upper = 1;
       assertEquals(1, stub.getUpper());
       stub.upper = 2;
       assertEquals(2, stub.getUpper());
       
       assertEquals(1, stub.getLower());
       stub.lower = 0;
       assertEquals(0, stub.getLower());
       stub.lower = 1;
       assertEquals(1, stub.getLower());
       stub.lower = 2;
       assertEquals(2, stub.getLower());
    }
    
    @Test
    public void testType() throws Exception {
       MofAnyStub stub = new MofAnyStub();
       assertNull( stub.getType());
       MofAnyStub setType = new MofAnyStub();
       stub.type = setType;
       assertEquals( setType, stub.getType());
      
       MofAnyStub setType2 = new MofAnyStub();
       
       stub.setType(setType2);
       assertEquals( setType2, stub.type);
       
       MofAnyStub setType3 = new MofAnyStub();
       stub.setType(setType3);
       assertEquals(setType3, stub.getType());
    }
    
    @Test
    public void testLookup() throws Exception {
       MofAnyStub stub = new MofAnyStub();
       assertNull(stub.lookupElementExtended);
       assertNull(stub.lookupElementExtendedKey);
       MofAnyStub result = new MofAnyStub();
       stub.lookupElementExtended = result; 
       assertNull(stub.lookupElementExtended("") );
       stub.lookupElementExtendedKey = "feature";
       assertEquals(result, stub.lookupElementExtended("feature"));
       assertNull(stub.lookupElementExtended("no-feature"));
    }
    
    @Test
    public void testContents() throws Exception {
       MofAnyStub stub = new MofAnyStub();
       assertNotNull(stub.contents);
       
       List<ModelElement> list = new ArrayList<ModelElement>();
       MofAnyStub element = new MofAnyStub();
       list.add(element);
       stub.contents = list;
       assertEquals(list, stub.getContents());
    }
    
    @Test
    public void testSupertypes() throws Exception {
       MofAnyStub stub = new MofAnyStub();
       assertNull(stub.supertypes);
       
       List<GeneralizableElement> list = new ArrayList<GeneralizableElement>();
       MofAnyStub element = new MofAnyStub();
       list.add(element);
       stub.supertypes = list;
       assertEquals(list, stub.getSupertypes());
    }
    
    @Test
    public void testMultiplicity() throws Exception {
        MofAnyStub stub = new MofAnyStub();
        assertNull(stub.multiplicityType);
        
        MofAnyStub result = new MofAnyStub();
        stub.multiplicityType = result; // tests setting directly 
        assertEquals(result, stub.getMultiplicity());
        
        stub.multiplicityType = null; 
        assertEquals(null, stub.getMultiplicity());
        
        stub.setMultiplicity(result); // test setter
        assertEquals(result, stub.multiplicityType);
        assertEquals(result, stub.getMultiplicity());
    }
}
