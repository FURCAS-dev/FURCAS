package com.sap.ide.treeprovider.action;

import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;

import com.sap.ide.treeprovider.internal.Activator;
import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class CreateTopLevelElementAction extends Action {

    private final MofClass mClazz;
    private final IProject mProject;

    public CreateTopLevelElementAction(MofClass clazz, IProject project) {
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
	    Connection connection = mClazz.get___Connection();
	    JmiHelper helper = connection.getJmiHelper();

	    RefObject newModelElement = helper.getRefClassForMofClass(mClazz).refCreateInstance();
	    try {
		Method setName = newModelElement.getClass().getMethod("setName", String.class);
		setName.invoke(newModelElement, name);
	    } catch (NoSuchMethodException e) {
		// has no name
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }

	    IPath partitionPath = GUIUtil.createPartitionPath(name, connection, mClazz);
	    ModelPartition partition = ModelManager.getPartitionService().createPartition(connection, mProject, partitionPath,
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
