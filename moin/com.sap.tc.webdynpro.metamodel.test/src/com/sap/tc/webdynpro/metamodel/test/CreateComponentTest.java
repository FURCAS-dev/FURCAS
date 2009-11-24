package com.sap.tc.webdynpro.metamodel.test;

import org.eclipse.core.runtime.IPath;

import com.sap.ide.metamodel.webdynpro.WebDynproPackage;
import com.sap.ide.metamodel.webdynpro.application.Application;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.LocalComponentInterface;
import com.sap.ide.metamodel.webdynpro.component.MessagePool;
import com.sap.ide.metamodel.webdynpro.component.Window;
import com.sap.ide.metamodel.webdynpro.component.controller.Controller;
import com.sap.ide.metamodel.webdynpro.component.view.InterfaceView;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.ide.metamodel.webdynpro.enums.ControllerTypeEnumEnum;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

public class CreateComponentTest extends WebDynproProjectTest {
    
	private static final String DC_NAME = "TESTPROJECT-WebDynproMetamodel";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/wd");
	
	private Connection connection;
    
    public CreateComponentTest() {
        this("Create Component In Project");
    }
    
    public CreateComponentTest(String name) {
		super(name);
	}

	@Override
    protected void setUp() throws Exception {
        super.setUp();
        connection = createConnection();
    }
	
	@Override
	protected void tearDown() throws Exception {
		connection = null;
		
		super.tearDown();
	}
	
	protected Connection getConnection() {
		return connection;
	}
    
    protected PRI getComponentPri() throws Exception {
        return getPri(getProject(), PARTITION_FOLDER.append("Component"));
    }
    
    @Override
    protected String getDcName() {
    	return DC_NAME;
    }
    
	@Override
    protected void runTest() throws Throwable {
        // delete previous partition
        PRI compPartitionMri = getComponentPri();
        ModelPartition partition = connection.getPartition(compPartitionMri);
        if (partition != null) {
            partition.delete();
        }
        
        // create new partition
        partition = connection.createPartition(compPartitionMri);
        assertNotNull("Partition creation failed", partition);
        
        // WD package
        WebDynproPackage wdPackage = (WebDynproPackage) connection.getPackage(
            CONTAINER_NAME_WEBDYNPRO, PACKAGE_NAME_WEBDYNPRO);
        assertNotNull("WebDynpro extent not found", wdPackage);
        
        // Component
        ComponentPackage componentPackage = wdPackage.getComponent();
        RefClass componentClass = componentPackage.getComponent();
        Component component = (Component) componentClass.refCreateInstance();
        assertNotNull("Component creation failed", component);
        component.setName("TheVeryFirstComponent");
        Partitionable compPartitionable = ((Partitionable) component);
        compPartitionable.assign___Partition(partition);
        
        // LocalComponentInterface
        RefClass ciClass = componentPackage.getLocalComponentInterface();
        LocalComponentInterface ci = (LocalComponentInterface) ciClass.refCreateInstance();
        Partitionable ciPartitionable = ((Partitionable) ci);
        ciPartitionable.assign___Partition(partition);
        ci.setName(component.getName() + "Interface");
        component.setLocalInterface(ci);
        ci.setComponent(component);
        
        // interface controller
        Controller interfaceController = (Controller) componentPackage.getController().getController().refCreateInstance();
        ci.getControllers().add(interfaceController);
        interfaceController.setName(ci.getName() + "InterfaceController");
        interfaceController.setType(ControllerTypeEnumEnum.COMPONENT_INTERFACE);
        ci.setInterfaceController(interfaceController);
        
        // component controller
        Controller componentController = (Controller) componentPackage.getController().getController().refCreateInstance();
        component.getControllers().add(componentController);
        componentController.setName(component.getName());
        componentController.setType(ControllerTypeEnumEnum.COMPONENT);
        component.setComponentController(componentController);

        // MessagePool
        MessagePool msgPool = (MessagePool) componentPackage.getMessagePool().refCreateInstance();
        msgPool.setName(component.getName() + "MessagePool");
        component.setMessagePool(msgPool);

        // a custom controller
        Controller customController = (Controller) componentPackage.getController().getController().refCreateInstance();
        component.getControllers().add(customController);
        customController.setName(component.getName() + "Custom1");
        customController.setType(ControllerTypeEnumEnum.CUSTOM);

        // a View
        View view = (View) componentPackage.getView().getView().refCreateInstance();
        component.getViews().add(view);
        view.setName(component.getName() + "View1");
        
        // view controller
        Controller viewController = (Controller) componentPackage.getController().getController().refCreateInstance();
        component.getControllers().add(viewController);
        viewController.setName(view.getName());
        viewController.setType(ControllerTypeEnumEnum.VIEW);
        view.setViewController(viewController);
        
        // RootUIElementContainer
        UielementPackage uielementPackage = componentPackage.getView().getUielement();
        RefClass uielementContainerClass = uielementPackage.getTransparentContainer();
        TransparentContainer rootContainer = (TransparentContainer) uielementContainerClass.refCreateInstance();
        rootContainer.setName("RootElement");
        view.setRootUielementContainer(rootContainer);

        // a Window
        RefClass windowClass = componentPackage.getWindow();
        Window window = (Window) windowClass.refCreateInstance();
        component.getWindows().add(window);
        window.setName(component.getName() + "Window1");
        
        // window controller
        Controller windowController = (Controller) componentPackage.getController().getController().refCreateInstance();
        component.getControllers().add(windowController);
        windowController.setName(window.getName());
        windowController.setType(ControllerTypeEnumEnum.WINDOW);
        
        // an InterfaceView
        InterfaceView interfaceView = (InterfaceView) componentPackage.getView().getInterfaceView().refCreateInstance();
        ci.getInterfaceViews().add(interfaceView);
        interfaceView.setName(ci.getName() + "InterfaceView1");

        // InterfaceView controller
        Controller interfaceViewController = (Controller) componentPackage.getController().getController().refCreateInstance();
        component.getControllers().add(interfaceViewController);
        interfaceViewController.setName(interfaceView.getName() + "Controller");
        interfaceViewController.setType(ControllerTypeEnumEnum.INTERFACE_VIEW);
        
        // let Window implement InterfaceView
        window.getImplementedInterfaceViews().add(interfaceView);
        
        // Application
        Application application = (Application) wdPackage.getApplication().getApplication().refCreateInstance();
        Partitionable applicationPartitionable = ((Partitionable) application);
        applicationPartitionable.assign___Partition(partition);
        application.setName("FirstApplication");
        
        connection.save();
    }

}
