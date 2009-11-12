package de.hpi.sam.emfindex.actions;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.query.EObjectQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.query.EReferenceQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.query.QueryExecutorImpl;
import org.eclipse.emf.emfindex.query.ResourceQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.IndexUpdaterImpl;
import org.eclipse.emf.emfindex.store.ResourceIndexer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

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

			//	index.executeUpdateCommand(new UpdateCommand<Boolean>() {
			//		public Boolean execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
			//
			//			return true;
			//		}
			//	});

			ResourceIndexer resourceIndexer = new ResourceIndexer();
			URI resourceURI = URI.createPlatformResourceURI(
					"/test/My1.vortrag", true);
			//	System.out.println("Stelle1");
			//	resourceIndexer.resourceChanged(resourceURI, indexUpdater);
			//	System.out.println("Stelle2");
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(resourceURI);

			resourceIndexer.createResourceDescriptor(resource, indexUpdater,
					resourceURI, resourceSet.getURIConverter());
			resourceIndexer.createEObjectDescriptors(resource, indexUpdater,
					resourceURI, resourceSet.getURIConverter());
			resourceIndexer.createEReferenceDescriptors(resource, indexUpdater,
					resourceURI, resourceSet.getURIConverter());

			//Indizierung abgeschlossen
			long end = System.currentTimeMillis();
			System.out.println("Total indexing time: " + (end - begin) + "ms.");

			//Index speichern
			try {
				index.save();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	}
}