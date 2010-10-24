/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import static com.sap.furcas.parsergenerator.testutils.StringListHelper.list;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.test.stubs.MofAnyStub;
import com.sap.mi.textual.parsing.EnumerationTypeStub;
import com.sap.mi.textual.parsing.MofStructureFieldStub;
import com.sap.mi.textual.parsing.MofStructureTypeStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.ConnectionStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.JmiHelperStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.MQLProcessorStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.MQLResultSetStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.OCLRegistryServiceStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.OclExpressionRegistrationStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.OclFreestyleRegistryStub;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.RefPackageStub;

/**
 *
 */
public class AdapterJMIHelperTest {

 
    /**
     * Test method for {@link com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper#createRefObject(java.lang.String)}.
     * @throws ModelAdapterException 
     */
    @Test
    public void testCreateRefObject() throws ModelAdapterException {

        JmiHelperStub jmihelper = new JmiHelperStub();
        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        
        // just making sure this is not null
        jmihelper.foundModelElement = new MofAnyStub();
        // element to be returned when helper tries to resolve name 
        MofAnyStub refMofClass = new MofAnyStub();
        jmihelper.refMofClass = refMofClass;
        
        // instance to be created using refCreateInstance
        MofAnyStub createdInstance = new MofAnyStub();
        refMofClass.createdInstance = createdInstance;
        
        // this tests attempts to force the helper to use the created instance above
        AdapterJMIHelper helper = new AdapterJMIHelper(root, connection, jmihelper, new HashSet<PRI>(), new HashSet<CRI>());
        
        assertEquals(createdInstance, helper.createObject(list("test","Test")));
    }
    
    /**
     * StructureTypes should not be created on create, but later when all fields have been set.
     */
    @Test
    public void testCreateRefObjectStructureTypeMock() throws ModelAdapterException {

        JmiHelperStub jmihelper = new JmiHelperStub();
        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        
        MofAnyStub result = new MofAnyStub();
        root.createdStructureType = result;
        
        MofStructureTypeStub structureTypeMock = new MofStructureTypeStub();
        MofStructureFieldStub strucField1 = new MofStructureFieldStub();
        structureTypeMock.contents.add(strucField1);
        MofStructureFieldStub strucField2 = new MofStructureFieldStub();
        structureTypeMock.contents.add(strucField2 );
        
        MofAnyStub type = new MofAnyStub();
        type.name = "String";
        strucField1.type = type;
        strucField2.type = type;
        
        jmihelper.refPackage = root;
        
        // just making sure this is not null
        jmihelper.foundModelElement = structureTypeMock;
        
        
        AdapterJMIHelper helper = new AdapterJMIHelper(root, connection, jmihelper, new HashSet<PRI>(),  new HashSet<CRI>());

        Object mockObject = helper.createObject(list("test","Test"));
        
        // check that helper merely returns a mock object
        assertTrue(mockObject instanceof StructureTypeMockObject);

        StructureTypeMockObject mock = (StructureTypeMockObject) mockObject;
        
        Object real = helper.actualCreateFromMock(mock);
    
        assertEquals(result, real);
    }

    @Test
    public void testGetElementsOfType() {
        JmiHelperStub jmihelper = new JmiHelperStub();
        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        MQLResultSetStub resultSetStub = new MQLResultSetStub();
        
        RefObject[] expected = new  RefObject[] {new MofAnyStub(), new MofAnyStub()};
        resultSetStub.refObjects = expected;
        ((MQLProcessorStub)connection.mqlProcessor).resultSet = resultSetStub ;
        
        RefPackageStub root = new RefPackageStub();
        
        AdapterJMIHelper helper = new AdapterJMIHelper(root, connection, jmihelper, new HashSet<PRI>(),  new HashSet<CRI>());
     
        RefObject[] result = helper.getElementsOfType("hello::world");
        assertArrayEquals(expected, result);
    }
    
   

    @Test
    public void testGetEnumLiteral() throws ModelAdapterException {
        JmiHelperStub jmihelper = new JmiHelperStub();
        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        RefPackageStub root = new RefPackageStub();
        
        EnumerationTypeStub enumStub = new EnumerationTypeStub();
        List<RefEnum> literalList = new ArrayList<RefEnum>();
        MofAnyStub literalStub = new MofAnyStub();
        literalStub.name = "literalName";
        literalList.add(new MofAnyStub());
        literalList.add(literalStub);
        literalList.add(new MofAnyStub());
        
        enumStub.literals = literalList;
        jmihelper.foundModelElement = enumStub ;
        
        AdapterJMIHelper helper = new AdapterJMIHelper(root, connection, jmihelper, new HashSet<PRI>(),  new HashSet<CRI>());
        assertEquals(literalStub, helper.getEnumLiteral(list("EnumName"), "literalName"));
        
    }
    
    @Test
    public void testOCLQuery() throws ModelAdapterException {
        JmiHelperStub jmihelper = new JmiHelperStub();
        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        OclExpressionRegistrationStub oclExpressionRegistrationStub = new OclExpressionRegistrationStub();
        
        oclExpressionRegistrationStub.result = new MofAnyStub("result");
        OclFreestyleRegistryStub oclFreestyleRegistryStub = new OclFreestyleRegistryStub();
        
		oclFreestyleRegistryStub.expresssionReg = oclExpressionRegistrationStub;
        OCLRegistryServiceStub registryServiceStub = new OCLRegistryServiceStub();
		registryServiceStub.freeStyleRegistry = oclFreestyleRegistryStub;
		connection.oclRegistry = registryServiceStub;
        RefPackageStub root = new RefPackageStub();
        
        MofAnyStub source = new MofAnyStub("source");
        MofAnyStub refClassStub = new MofAnyStub("RefClass");
        refClassStub.metaObject = new MofAnyStub("MetaObject");
        source.refClass = refClassStub;
       
        oclFreestyleRegistryStub.expectedQuery = "self.property = 'test'";

        
        AdapterJMIHelper helper = new AdapterJMIHelper(root, connection, jmihelper, new HashSet<PRI>(),  new HashSet<CRI>());
        assertEquals(oclExpressionRegistrationStub.result, helper.findElementWithOCLQuery(source, "property", "test", "self.property = $property", null, null));
    }
    @Test
    public void testOCLQueryWithContext() throws ModelAdapterException {
    	JmiHelperStub jmihelper = new JmiHelperStub();
        ConnectionStub connection = new ConnectionStub();
        connection.mqlProcessor = new MQLProcessorStub();
        OclExpressionRegistrationStub oclExpressionRegistrationStub = new OclExpressionRegistrationStub();
        
        oclExpressionRegistrationStub.result = new MofAnyStub();
        OclFreestyleRegistryStub oclFreestyleRegistryStub = new OclFreestyleRegistryStub();
        
		oclFreestyleRegistryStub.expresssionReg = oclExpressionRegistrationStub;
        OCLRegistryServiceStub registryServiceStub = new OCLRegistryServiceStub();
		registryServiceStub.freeStyleRegistry = oclFreestyleRegistryStub;
		connection.oclRegistry = registryServiceStub;
        RefPackageStub root = new RefPackageStub();
        
        MofAnyStub source = new MofAnyStub("source");
        MofAnyStub context = new MofAnyStub();        
        MofAnyStub refClass = new MofAnyStub("RefClass");
        refClass.metaObject = new MofAnyStub("metaObject");
        context.refClass = refClass;
        
        

        oclFreestyleRegistryStub.expectedQuery = "#context.property = 'test'";

        
        AdapterJMIHelper helper = new AdapterJMIHelper(root, connection, jmihelper, new HashSet<PRI>(),  new HashSet<CRI>());
        assertEquals(oclExpressionRegistrationStub.result, helper.findElementWithOCLQuery(source, "property", "test", "#context.property = $property", context, null));
    }
    
    
    
}
