package com.sap.furcas.ide.editor;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.ide.cts.editor.document.CtsDocument;


/**
 * {@link OnMarkerChangeJob} is derived from {@link Job} to do the main work 
 * of the {@link AbstractGrammarBasedEditor#onMarkerChange(IProject)}method as an eclipse job. 
 * @author Nicola Coretti
 */
public class OnMarkerChangeJob extends Job {
	
	/**
	 * {@link AbstractGrammarBasedEditor} which will be refreshed.
	 */
	protected AbstractGrammarBasedEditor editor = null;
	
	/**
	 * A thread-safe queue for providers which will be processed in the {@link OnMarkerChangeJob#run(IProgressMonitor)} method.
	 */
	protected ConcurrentLinkedQueue<IDocumentProvider> providerTaskQueue = null;
	
	
	/**
	 * Creates a new {@link OnMarkerChangeJob} with the specified name and providerTaskQueue. 
	 * The job name is a human-readable value that is displayed to users. The name does not need to be unique, but it must not be null.
	 * @param jobName the name of the job.
	 * @param providerTaskQueue {@link #providerTaskQueue}.
	 */
	public OnMarkerChangeJob(String jobName, AbstractGrammarBasedEditor editor,
							 ConcurrentLinkedQueue<IDocumentProvider> providerTaskQueue) {
	
		super(jobName);
		this.editor  	  	   = editor;
		this.providerTaskQueue = providerTaskQueue;
	}


	/**
	 * Refreshes the model-annotations of the providers rootPartion. Overrides run(..) in {@link Job}.
	 * @param monitor the monitor to be used for reporting progress and responding to cancellation. The monitor is
	 * 			      never null.
	 * @return resulting status of the run.
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		
		// is there still work to do 
		while(!providerTaskQueue.isEmpty()) {
						
			IDocumentProvider provider = popTaskInfo();
			
			if(provider != null) {
					
				CtsDocument document = (CtsDocument)provider.getDocument(editor.getEditorInput());
						
				if(document != null) {
		        		
					if(document.isCompletelyItitialized() && EcoreHelper.isAlive(document.getRootObject())){							
						
						monitor.beginTask("Refreshing annotations ...", 0);
						
						Resource rootPartition = (document.getRootObject()).eResource();
        				editor.refreshModelAnnotations(rootPartition);
        				
        				monitor.done();
	       			}
				}
			}	
		}
		
		return Status.OK_STATUS;
	}

	
	/**
	 * Removes and returns a {@link IDocumentProvider} from the {@link #providerTaskQueue} and ensures that all other references 
	 * of this {@link IDocumentProvider} (if there are any) will be deleted from the {@link #providerTaskQueue}.
	 * @return a reference of a {@link IDocumentProvider} if the {@link #providerTaskQueue} isn't empty, otherwise <code>null</code>.
	 */
	private IDocumentProvider popTaskInfo() {
		
		IDocumentProvider provider = providerTaskQueue.poll();
		
		if (provider != null && providerTaskQueue.contains(provider)) {
			
			// remove all remaining references of the provider in the queue.
			do {
				providerTaskQueue.remove(provider);
				
			} while (providerTaskQueue.contains(provider));
		}
		
		return provider;
	}
}
