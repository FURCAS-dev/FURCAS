/**
 * 
 */
package org.eclipse.ocl.examples.modelregistry.ui.registrations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.ocl.examples.modelregistry.model.AccessorRegistry;
import org.eclipse.ocl.examples.modelregistry.model.Registration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class RegistrationsLabelProvider extends LabelProvider implements ITableLabelProvider
{
	public Image getColumnImage(Object obj, int index) {
		if (index > 0)
			return null;
		return getImage(obj);
	}

	public String getColumnText(Object obj, int index) {
		if (index > 0) {
			if (obj instanceof Registration<?>) {
				Registration<?> registration = (Registration<?>)obj;
				if (index == 1)
					return registration.getURIString();
			}
			return "";
		}
		return getText(obj);
	}
	
	@Override
	public Image getImage(Object obj) {
		String img = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof EclipseFileHandle) {
			IResource resource = ((EclipseFileHandle)obj).getResource();
			if (resource instanceof IFile) {
				img = ISharedImages.IMG_OBJ_FILE;
			}
			else if (resource instanceof IFolder) {
				img = ISharedImages.IMG_OBJ_FOLDER;
			}
			else if (resource instanceof IProject) {
				img = org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT;
			}
		}
		if (img != null)
			return PlatformUI.getWorkbench().getSharedImages().getImage(img);
		else
			return super.getImage(obj);

	}

	@Override
	public String getText(Object element) {
		if (element instanceof EclipseFileHandle) {
			IResource resource = ((EclipseFileHandle)element).getResource();
			return resource.getName();
		}
		if (element instanceof AccessorRegistry<?>) {
			AccessorRegistry<?> accessorRegistry = (AccessorRegistry<?>)element;
			return accessorRegistry.getNamespace().getName();
		}
		if (element instanceof Registration<?>) {
			Registration<?> registration = (Registration<?>)element;
			return registration.getAccessorName();
		}
		return super.getText(element);
	}
}