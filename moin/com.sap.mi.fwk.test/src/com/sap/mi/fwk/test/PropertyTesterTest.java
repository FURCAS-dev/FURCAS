package com.sap.mi.fwk.test;

import org.eclipse.core.expressions.IPropertyTester;
import org.eclipse.core.runtime.IPath;

import com.sap.ide.metamodel.webdynpro.application.Application;
import com.sap.ide.metamodel.webdynpro.application.ApplicationPackage;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.MessagePool;
import com.sap.ide.metamodel.webdynpro.enums.MessageDisplayModeEnumEnum;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.internal.testers.MoinObjectPropertyTester;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests the property testers for Moin related expressions
 * 
 * @author d031150
 */
public class PropertyTesterTest extends WebDynproProjectTest {

    private static final String DC_NAME = "test/propertytester";
    private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/proptest");

    private static final String PACKAGE_NAME_COMPONENT = "WebDynpro.component";
    private static final String CLASS_NAME_COMPONENT = PACKAGE_NAME_COMPONENT + ".Component";
    
    private ModelPartition partition;
    private Component component;
    private MessagePool messagePool;
    private Application application;

    public PropertyTesterTest() {
        super(DC_NAME);
    }
    
    @Override
    protected String getDcName() {
    	return DC_NAME;
    }
    
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	Connection connection = createConnection();
    	
        PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
    	
    	partition = connection.getPartition(partitionMRI);
    	if (partition != null) {
    		partition.delete();
    	}
    	partition = connection.createPartition(partitionMRI);
    	assertNotNull("Partition creation failed", partition);
    	
    	ComponentPackage compPackage = (ComponentPackage) connection.getPackage(
    			"sap.com/tc/moin/webdynpro/webdynpro",
    			new String[] { "WebDynpro", "component" });
    	component = (Component) compPackage.getComponent().refCreateInstance( );
    	component.setName("TestComponent");
    	assertNotNull("Component creation failed", component);
    	partition.assignElement((Partitionable) component);
    	
    	messagePool = (MessagePool) compPackage.getMessagePool().refCreateInstance( );
    	messagePool.setName("MessagePool");
    	messagePool.setComponent(component);
    	
    	ApplicationPackage applPackage = (ApplicationPackage) connection.getPackage(
    			"sap.com/tc/moin/webdynpro/webdynpro",
    			new String[] { "WebDynpro", "application" });
    	application = (Application) applPackage.getApplication().refCreateInstance( );
    	application.setName("Application");
    	application.setMessageDisplayMode(MessageDisplayModeEnumEnum.MSGCMP_ON_DEMAND);
    	partition.assignElement((Partitionable) application);
    	
    	connection.save();
    }
    
    @Override
    protected void tearDown() throws Exception {
    	if (component != null) {
    		ModelAdapter.getInstance().getConnection(component).close();
    		component = null;
    	}
    	messagePool = null;
    	application = null;
    	partition = null;
    	
    	super.tearDown();
    }
    
    public void testImmediatePackage() {
        IPropertyTester tester = new MoinObjectPropertyTester();
        boolean result = tester.test(
            component, MoinObjectPropertyTester.PROPERTY_IMMEDIATE_PACKAGE, null, PACKAGE_NAME_COMPONENT);
        assertEquals("Immediate package should be '" + PACKAGE_NAME_COMPONENT + "'", true, result);

        result = tester.test(
            component, MoinObjectPropertyTester.PROPERTY_IMMEDIATE_PACKAGE, null, PACKAGE_NAME_COMPONENT.toLowerCase());
        assertEquals("Immediate package should be case sensitive: '" + PACKAGE_NAME_COMPONENT + "'", false, result);
    }

    public void testClass() {
        IPropertyTester tester = new MoinObjectPropertyTester();
        boolean result = tester.test(
            component, MoinObjectPropertyTester.PROPERTY_MOFCLASS, null, CLASS_NAME_COMPONENT);
        assertEquals("Class name should be '"+ CLASS_NAME_COMPONENT + "'", true, result);

        result = tester.test(
            component, MoinObjectPropertyTester.PROPERTY_MOFCLASS, null, CLASS_NAME_COMPONENT.toLowerCase());
        assertEquals("Class name should be case sensitive: '"+ CLASS_NAME_COMPONENT + "'", false, result);
    }
    
    public void testFeature() {
        IPropertyTester tester = new MoinObjectPropertyTester();
        String featureName = "name";
        boolean result = tester.test(
            component, MoinObjectPropertyTester.PROPERTY_FEATURE, null, featureName);
        assertEquals(
            "Feature '" + featureName + 
            "' + does not exist for '"+ component + "'", 
            true, result);

        String featureNameAndValue = "messageDisplayMode=msgcmp_on_demand";
        result = tester.test(
            application, MoinObjectPropertyTester.PROPERTY_FEATURE, null, featureNameAndValue);
        assertEquals(
            "Feature name with value'" + featureNameAndValue + 
            "' + does not exist for '"+ application + "'", 
            true, result);

        featureNameAndValue = "messageDisplayMode=msgcmp_static";
        result = tester.test(
            application, MoinObjectPropertyTester.PROPERTY_FEATURE, null, featureNameAndValue);
        assertEquals(
            "Feature name with value'" + featureNameAndValue + 
            "' + exists for '"+ application + "'", 
            false, result);
    }

}
