package com.sap.tc.webdynpro.metamodel.test;

import java.util.List;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;


public class ModifyComponentTest extends CreateComponentTest {
    
    public ModifyComponentTest() {
        super("Modify Component In Project");
    }
    
    @Override
    protected void runTest() throws Throwable {
        
        List<Component> components = ModelManager.getQueryService().queryInstances(
        		getProject(), getConnection(), 
        		CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
        assertFalse("No components found", components.isEmpty());
        
        boolean componentFound = false;
        PRI componentPri = getComponentPri();
        for (Component component : components) {
            assertNotNull("Component could not be resolved", component);
            ModelPartition partition = ((Partitionable) component).get___Partition();
			// only modify the component our creation test has created
            if (componentPri.equals(partition.getPri())) {
                componentFound = true;
                component.setName(component.getName() + "_Changed");
                break;
            }
        }
        
        if (!componentFound)
            fail("No component found to modify among: " + components);

        getConnection().save();
    }

}
