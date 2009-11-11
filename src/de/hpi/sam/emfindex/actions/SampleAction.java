package de.hpi.sam.emfindex.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.emf.emfindex.*;
import org.eclipse.emf.emfindex.query.*;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.IndexUpdaterImpl;
import org.eclipse.emf.emfindex.store.ResourceIndexer;
import org.eclipse.emf.emfindex.store.UpdateCommand;
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
		MessageDialog.openInformation(
			window.getShell(),
			"Emfindex",
			"EMF Index executed");
	System.out.println("EMF Index started");
	//setup
	MemoryIndexImpl index = new MemoryIndexImpl();
	IndexUpdater indexUpdater = new IndexUpdaterImpl(index);
	index.setIndexUpdater(indexUpdater);
	QueryExecutor queryExecutor = new QueryExecutorImpl(index);
	((QueryExecutorImpl) queryExecutor).addQueryExecutorStrategy(new ResourceQueryExecutorStrategyImpl(), 0);
	((QueryExecutorImpl) queryExecutor).addQueryExecutorStrategy(new EObjectQueryExecutorStrategyImpl(), 0);
	((QueryExecutorImpl) queryExecutor).addQueryExecutorStrategy(new EReferenceQueryExecutorStrategyImpl(), 0);
	index.setQueryExecutor(queryExecutor);

	final ResourceIndexer rIn = new ResourceIndexer();
	
	//Zeit für Indizierung beginnt
	long begin = System.currentTimeMillis();
	//Datei zum Indizieren laden und diese indizieren
	final ResourceSet rs=new ResourceSetImpl();
	index.executeUpdateCommand(new UpdateCommand<Boolean>() {
		public Boolean execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
			// erstellt Resource im Resourcenset 
			
			Resource r = rs.createResource(URI.createPlatformResourceURI("/test/My1.vortrag", true));
			try {
				r.load(Collections.emptyMap());//laden der Plattform von My1.vortrag, wenn Map leer -> exception
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			//die neue Resource mitteilen
			try {
				
				indexUpdater.createOrUpdateResource("Container", URI.createPlatformResourceURI("/test/My1.vortrag", true), 8, null);
				rIn.resourceChanged(r, indexUpdater);
				

				//resourceIndexer.resourceChanged(r, indexUpdater);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			return true;
		}
	});
	

//	index.getQueryExecutor().execute(allEClasses);

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
		this.window = window;
	}
}