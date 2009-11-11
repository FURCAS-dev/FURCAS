package com.sap.ide.moftool.editor.tree;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;

import com.sap.ide.moftool.editor.tree.tcnf.NodeMofRoot;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfAssocContainer;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ui.ImageProvider;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.tree.TreeNodeDecorator;

public class MOFToolNavTreeDecorator extends LabelProvider implements ILightweightLabelDecorator {

	public void decorate(Object element, IDecoration decoration) {
		switch (getMaxSeverity(element)) {
		case IMarker.SEVERITY_ERROR:
			decoration.addOverlay(ImageProvider.getImageDescriptor(ImageProvider.DECORATOR_ERROR_IMAGE));
			break;
		case IMarker.SEVERITY_WARNING:
			decoration.addOverlay(ImageProvider.getImageDescriptor(ImageProvider.DECORATOR_WARNING_IMAGE));
			break;
		default:
			decoration.addOverlay(null);
		}
	}

	private int getMaxSeverity(final Object element) {

		int maxSeverity = TreeNodeDecorator.SEVERITY_UNKNOWN;
		if (element instanceof NodeCnfAssocContainer) {
			NodeCnfAssocContainer cont = (NodeCnfAssocContainer) element;

			Object[] children = cont.getChildren();
			for (int i = 0; i < children.length && maxSeverity != IMarker.SEVERITY_ERROR; i++) {
				maxSeverity = Math.max(getMaxSeverity(children[i]), maxSeverity);
			}
			return maxSeverity;
		}

		if (element instanceof NodeMofRoot) {
			IProject project = ((NodeMofRoot) element).getValue();
			if (project != null && project.isAccessible()) {
				try {
					maxSeverity = project.findMaxProblemSeverity(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				} catch (CoreException e) {
					return TreeNodeDecorator.SEVERITY_UNKNOWN;
				}
			}
			return maxSeverity;
		}

		if (element instanceof IAdaptable) {
			RefBaseObject refBaseObject = ModelAdapterUI.getInstance().getRefBaseObject(element);
			if (refBaseObject != null) {
				maxSeverity = MarkerManager.getInstance().findMaxProblemSeverity(refBaseObject, IMarker.PROBLEM, true,
						IResource.DEPTH_INFINITE);
			}
		}

		return maxSeverity;
	}
}