package com.sap.ide.treeprovider.action;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;



import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.INodeExplorer;
import com.sap.ide.treeprovider.internal.Activator;


/**
 * Generic create action that allows creation of composite child elements.
 * 
 * @author D046040
 * 
 */
public class CreateElementAction extends Action {

    private final EClass mClazz;
    private final EReference mAe;
    private final INodeExplorer mNode;
    private final EObject mCompositeParent;
    private final IProject mProject;

    public CreateElementAction(EClass clazz, EReference ae, INodeExplorer node, IProject project) {
	super(clazz.getName());
	setImageDescriptor(Activator.getImageDescriptor(clazz));
	mClazz = clazz;
	mAe = ae;
	mNode = node;
	mCompositeParent = ((GenericRefObjectNode) mNode).getValue();
	mProject = project;
    }

    @Override
    public void runWithEvent(Event event) {
	ResourceSet connection = mCompositeParent.get___Connection();
	JmiHelper helper = connection.getJmiHelper();

	// get name from user
	final String name = GUIUtil.enterText("New", "Name", "new" + mClazz.getName());
	if (name != null) {
	    // create new model element
	    EObject newModelElement = helper.getRefClassForMofClass(mClazz).refCreateInstance();
	    if (newModelElement != null) {
		// add link between mCompositeParent and newModelElement
		EReference assoc = (EReference) mAe.eContainer();
		EReference refAssoc = helper.getRefAssociationForAssociation(assoc);
		if (helper.isFirstAssociationEnd(assoc, mAe)) {
		    refAssoc.refAddLink(newModelElement, mCompositeParent);
		} else {
		    refAssoc.refAddLink(mCompositeParent, newModelElement);
		}

		try {
		    Method setName = newModelElement.getClass().getMethod("setName", String.class);
		    setName.invoke(newModelElement, name);
		} catch (NoSuchMethodException e) {
		    // has no name
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}

		// determine or create partition
		Resource partition = null;
		AttachesTo attachesToAssoc = connection.getAssociation(AttachesTo.ASSOCIATION_DESCRIPTOR);
		Collection<Tag> tags = attachesToAssoc.getTag(mClazz);
		for (Tag tag : tags) {
		    if (tag.getTagId().equals("org.omg.sap2mof.requiresPartition")) {
			List<String> values = tag.getValues();
			if (values.size() == 1 && Boolean.parseBoolean(values.get(0))) {
			    // create new partition
			    EClass outermostParent = (EClass) mCompositeParent.refOutermostComposite().refMetaObject();
			    IPath partitionPath = GUIUtil.createPartitionPath(name, connection, outermostParent);
			    partition = ModelManager.getPartitionService().createPartition(connection, mProject, partitionPath,
				    null);
			}
			break;
		    }
		}
		if (partition == null) {
		 // store in partition of composite parent
		    partition = mCompositeParent.eResource();
		}
		// assign partition
		newModelElement.assign___PartitionIncludingChildren(partition);
		try {
		    newModelElement.get___Connection().save();
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}
	    }
	}
    }

}
