package de.hpi.sam.emfindex.actions;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfindex.*;
import org.eclipse.emf.emfindex.query.*;
import org.eclipse.emf.emfindex.store.*;
import org.eclipse.emf.emfindex.ui.EmfIndexUIPlugin;
import org.eclipse.emf.emfindex.ui.builder.EmfIndexNature;
import org.eclipse.emf.emfindex.ui.builder.EmfIndexProjectBuilder;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.internal.UIPlugin;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
			MessageDialog.openInformation(window.getShell(), "Emfindex", "EMF Index executed");
			System.out.println("EMF Index started");
			//setup		

			MemoryIndexImpl index = new MemoryIndexImpl();
			IndexUpdater indexUpdater = new IndexUpdaterImpl(index);

			index.setIndexUpdater(indexUpdater);			
			QueryExecutorImpl queryExecutor = new QueryExecutorImpl(index);
			queryExecutor.addQueryExecutorStrategy(
					new ResourceQueryExecutorStrategyImpl(), 0);
			queryExecutor.addQueryExecutorStrategy(
					new EObjectQueryExecutorStrategyImpl(), 0);
			queryExecutor.addQueryExecutorStrategy(
					new EReferenceQueryExecutorStrategyImpl(), 0);
			index.setQueryExecutor(queryExecutor);
			
			//Zeit für Indizierung beginnt
			long begin = System.currentTimeMillis();
			//Datei zum Indizieren laden und diese indizieren
			
//			index.executeUpdateCommand(new UpdateCommand<Boolean>() {
//				public Boolean execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
//					
//					return true;
//				}
//			});

			
			ResourceIndexer resourceIndexer = new ResourceIndexer();
			URI resourceURI = URI.createPlatformResourceURI("/de.hpi.sam.vortrag/model/vortrag.ecore", true);
//			URI resourceURI = URI.createPlatformResourceURI("vortrag.ecore", true);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(resourceURI);
//			Resource copy = resourceSet.createResource(resourceURI);
//			
//			Resource ecoreResource = EcorePackage.eINSTANCE.eResource();
//			copy.getContents().add(EcorePackage.eINSTANCE);
//			try {
//				copy.save(null);
//			} catch (IOException e3) {
//				// TODO Auto-generated catch block
//				e3.printStackTrace();
//			}
//			ecoreResource.getContents().add(EcorePackage.eINSTANCE);
//			copy.unload();
//			try {
//				copy.load(null);
//			} catch (IOException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//			Resource resource = new ResourceImpl();
//			resource.getContents().addAll(copy.getContents());
//			try {
//				copy.delete(null);
//			} catch (IOException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
			
			UpdateableIndex index2 = EmfIndexUIPlugin.getDefault().getIndex();
			
			try {
				index2.save();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

//			resourceIndexer.createResourceDescriptor(resource, indexUpdater,
//					resourceURI, resourceSet.getURIConverter());
//			resourceIndexer.createEObjectDescriptors(resource, indexUpdater,
//					resourceURI, resourceSet.getURIConverter());
//			resourceIndexer.createEReferenceDescriptors(resource, indexUpdater,
//					resourceURI, resourceSet.getURIConverter());
//			

//			index.getQueryExecutor().getIndex();
//			try {
//				resourceIndexer.resourceChanged(resourceURI, indexUpdater);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

			//Indizierung abgeschlossen
			long end = System.currentTimeMillis();
			System.out.println("Total indexing time: " + (end - begin) + "ms.");

			//Index speichern
//			try {
//				index.save();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			System.out.println("EMF Index finished");
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}