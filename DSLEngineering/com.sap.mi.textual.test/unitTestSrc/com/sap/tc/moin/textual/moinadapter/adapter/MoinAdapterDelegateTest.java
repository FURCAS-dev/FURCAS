/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import static com.sap.furcas.parsergenerator.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.test.stubs.MofAnyStub;
import com.sap.mi.textual.parsing.MofStructureTypeStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.ConnectionStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.JmiHelperStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.MQLProcessorStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.RefPackageStub;

/**
 *
 */
public class MoinAdapterDelegateTest {

 
    @Test
    public void testCreate() throws ModelAdapterException {

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        Object expected = new Object();
        adapterHelperStub.createdObject = expected ;
        
        Object result = delegate.createElement(list("package","typename"));
        
        assertEquals(expected, result);
        assertFalse(delegate.hasDeferredActions());
    }
    
    @Test
    public void testCreateEnumLit() throws ModelAdapterException {

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        RefEnum expected = new MofAnyStub();
        adapterHelperStub.createdEnumObject = expected ;
        
        Object result = delegate.getEnumLiteral(list("package","typename"), "literal");
        
        assertEquals(expected, result);
        assertFalse(delegate.hasDeferredActions());
    }
    
    @Test
    public void testCreateStructureMock() throws ModelAdapterException {
        // tests for Structure types, which are created as mocks first and for real later

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        Object expected = new StructureTypeMockObject(new MofStructureTypeStub());
        adapterHelperStub.createdObject = expected ;
        
        Object result = delegate.createElement(list("package","typename"));
        
        assertEquals(expected, result);
        assertTrue(delegate.hasDeferredActions());
    }
    
    @Test
    public void testGet() throws ModelAdapterException {

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        Object expected = new Object();
        MofAnyStub modelElement = new MofAnyStub();
        modelElement.propertyValue = expected;
        
        jmihelper.reference = new MofAnyStub();
        
        Object result = delegate.get(modelElement, "property");
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetSimpleAttribute() throws ModelAdapterException {
        // tests for Structure types, which are created as mocks fisrt and for real later

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        AttributeStub attribute = new AttributeStub();
        jmihelper.attribute = attribute;
        
        MofAnyStub multiType = new MofAnyStub();
        multiType.upper = 1;
        attribute.multiplicityType = multiType ;

        
        Object value = new Object();
        MofAnyStub modelElement = new MofAnyStub();
        
        delegate.set(modelElement, "property", value);
        assertEquals(value, modelElement.propertyValue);
        
    }
    
    @Test
    public void testSetManyValuedAttribute() throws ModelAdapterException {
        // tests for Structure types, which are created as mocks fisrt and for real later

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        AttributeStub attribute = new AttributeStub();
        jmihelper.attribute = attribute;
        
        MofAnyStub multiType = new MofAnyStub();
        multiType.upper = -1;
        attribute.multiplicityType = multiType ;

        
        Object value = new Object();
        MofAnyStub modelElement = new MofAnyStub();
        modelElement.propertyValue = new ArrayList<Object>();
        
        delegate.set(modelElement, "property", value);
        ArrayList<Object> expected = new ArrayList<Object>();
        expected.add(value);
        
        assertEquals(expected, modelElement.propertyValue);
        
    }
    
    @Test
    public void testInstanceOf() throws ModelAdapterException {
        // tests for Structure types, which are created as mocks fisrt and for real later

        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        JmiHelperStub jmihelper = new JmiHelperStub();
        AdapterJMIHelperStub adapterHelperStub = new AdapterJMIHelperStub(root, connection, jmihelper);
        MoinModelAdapterDelegate delegate = new MoinModelAdapterDelegate(adapterHelperStub, jmihelper);
        
        Object expected = new Object();


        MofAnyStub modelElement = new MofAnyStub() {
            /* (non-Javadoc)
             * @see com.sap.mi.textual.parsing.MofAnyStub#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
             */
            @Override
            public boolean refIsInstanceOf(RefObject objType,
                    boolean considerSubtypes) {
                return true;
            }
        };
        RefObject metatype = delegate.getMetaType(list("package","type"));
        boolean result = delegate.instanceOf(modelElement, metatype);

        assertTrue(result);

        modelElement = new MofAnyStub() {
            /* (non-Javadoc)
             * @see com.sap.mi.textual.parsing.MofAnyStub#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
             */
            @Override
            public boolean refIsInstanceOf(RefObject objType,
                    boolean considerSubtypes) {
                return false;
            }
        };
        result = delegate.instanceOf(modelElement, metatype);

        assertFalse(result);
    }

    class AttributeStub extends MofAnyStub implements Attribute {

    }
}
