/**
 * 
 */
package org.eclipse.ocl.examples.modelregistry.ui.registrations;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.model.Accessor;
import org.eclipse.ocl.examples.modelregistry.model.AccessorRegistry;
import org.eclipse.ocl.examples.modelregistry.model.FileHandleRegistry;
import org.eclipse.ocl.examples.modelregistry.model.ProjectRegistry;
import org.eclipse.ocl.examples.modelregistry.model.Registration;

public class RegistrationsContentProvider implements ITreeContentProvider
{
	/**
	 * The projectHandle is null whenever there is no selection.
	 */
	protected IProject project = null;
	private EclipseProjectHandle projectHandle = null;
	protected ProjectRegistry projectRegistry = null;

	public void dispose() {
	}

	public Object[] getElements(Object selection) {
		System.out.println("getElements of " + selection);
		if ((project == null) || !(selection instanceof IResource))
			return new Object[0];
		IResource resource = (IResource) selection;
		int depth = 0;
		for (IResource res = resource; res != null; res = res.getParent()) {
			depth++;
			if (res instanceof IProject)
				break;
		}
		Object[] objects = new Object[depth];
		depth = 0;
		for (IResource res = resource; res != null; res = res.getParent()) {
			if (res instanceof IProject) {
				objects[depth++] = projectHandle;
				break;
			}
			else {
				EclipseFileHandle fileHandle = projectHandle.getFileHandle(res);
				objects[depth++] = fileHandle;
			}
		}
		return objects;
	}
	
	public Object[] getChildren(Object element) {
		if (element instanceof FileHandle) {
			FileHandleRegistry fileHandleRegistry = projectRegistry.get((FileHandle)element);
			Collection<AccessorRegistry<? extends Accessor<?>>> accessorRegistries = fileHandleRegistry.getRegistries();
			AccessorRegistry<?>[] entries = new AccessorRegistry[accessorRegistries.size()];
			int i = 0;
			for (AccessorRegistry<?> accessorRegistry : accessorRegistries){
				entries[i++] = accessorRegistry;
			}
			return entries;
		}
		if (element instanceof AccessorRegistry<?>) {
			return getAccessorChildren((AccessorRegistry<?>)element);
		}
		return new String[] { "A", "B" };
	}

	protected <A extends Accessor<A>> Object[] getAccessorChildren(AccessorRegistry<A> accessorRegistry) {
		Collection<Registration<A>> registrations = accessorRegistry.getRegistrations();
		Registration<?>[] entries = new Registration[registrations.size()];
		int i = 0;
		for (Registration<?> registration : registrations){
			entries[i++] = registration;
		}
		return entries;
	}
	
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean hasChildren(Object element) {
		if (project == null)
			return false;
		if (element instanceof FileHandle) {
			FileHandleRegistry fileHandleRegistry = projectRegistry.get((FileHandle)element);
			if (fileHandleRegistry == null)
				return false;
			Collection<AccessorRegistry<? extends Accessor<?>>> accessorRegistries = fileHandleRegistry.getRegistries();
			return accessorRegistries.size() > 0;
		}
		if (element instanceof AccessorRegistry<?>) {
			AccessorRegistry<?> accessorRegistry = (AccessorRegistry<?>)element;
			return accessorRegistry.getRegistrations().size() > 0;
		}
		return false;
	}
	
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		System.out.println("inputChanged to " + newInput);
		IResource resource = null;
		if (newInput instanceof IResource) {
			resource = (IResource) newInput;
		}
		else if (newInput instanceof IAdaptable) {
			resource = (IResource) ((IAdaptable)newInput).getAdapter(IResource.class);
		}
		if (resource == null) {
			project = null;
			return;
		}
		project = resource.getProject();
		if ((projectHandle != null) && (project == projectHandle.getProjectResource()))
			return;
		projectHandle = new EclipseProjectHandle(project);
		projectRegistry  = new ProjectRegistry(projectHandle);
		projectRegistry.loadModel();
	}
}