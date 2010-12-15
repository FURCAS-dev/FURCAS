package com.sap.ide.treeprovider.action;

import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;

import com.sap.ide.treeprovider.internal.Activator;


public class CreateTopLevelElementAction extends Action {

    private final EClass mClazz;
    private final IProject mProject;

    public CreateTopLevelElementAction(EClass clazz, IProject project) {
	super(clazz.getName());
	setImageDescriptor(Activator.getImageDescriptor(clazz));
	mClazz = clazz;
	mProject = project;
    }

    @Override
    public void runWithEvent(Event event) {
	// ask user for name of new element
	final String name = GUIUtil.enterText("New", "Name", "new" + mClazz.getName());
	if (name != null) {
	    ResourceSet connection = mClazz.get___Connection();
	    JmiHelper helper = connection.getJmiHelper();

	    EObject newModelElement = helper.getRefClassForMofClass(mClazz).refCreateInstance();
	    try {
		Method setName = newModelElement.getClass().getMethod("setName", String.class);
		setName.invoke(newModelElement, name);
	    } catch (NoSuchMethodException e) {
		// has no name
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }

	    IPath partitionPath = GUIUtil.createPartitionPath(name, connection, mClazz);
	    Resource partition = ModelManager.getPartitionService().createPartition(connection, mProject, partitionPath,
		    null);
	    partition.assignElementIncludingChildren(newModelElement);

	    try {
		newModelElement.get___Connection().save();
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	}
    }

}
