package org.eclipse.emf.query.index;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
/**
 * This class keeps the instance of the dirty index.
 * Clients must add  this class as an adapter to their resources or resource set
 * when they wish to load any resource and want to make any changes to the resource.
 * Once done with the query execution clients must remove the adapter from the resource.
 * @author Saurav Sarkar
 *
 */
public class DirtyResourceFactory extends EContentAdapter {
	
	private static final Index index=new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
	private static DirtyResourceFactory instance;

	@Override
	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);
		if(notification.getNotifier() instanceof EObject){
		if(notification.getEventType()==Notification.SET||notification.getEventType()==Notification.ADD
				||notification.getEventType()==Notification.REMOVE){
		index.executeUpdateCommand(new UpdateCommandAdapter() {
			
			@Override
			public void execute(IndexUpdater updater) {
				final ResourceIndexer indexer = new ResourceIndexer();
				
				
				Resource emfResource=((EObject)notification.getNotifier()).eResource();	
				indexer.resourceChanged(updater, emfResource);
				
				
			}
		});
		}
		}if(notification.getNotifier() instanceof Resource){
			if(notification.getEventType()==Notification.SET||notification.getEventType()==Notification.ADD
					||notification.getEventType()==Notification.REMOVE){
				index.executeUpdateCommand(new UpdateCommandAdapter() {
					
					@Override
					public void execute(IndexUpdater updater) {
						final ResourceIndexer indexer = new ResourceIndexer();
						
						
						Resource emfResource=(Resource)notification.getNotifier();	
						indexer.resourceChanged(updater, emfResource);
						
						
					}
				});
			}
		}
		
	}

	/**
	 * Returns the dirty index
	 * @return
	 */
	public static Index getIndex() {
		return index;
	}
	
	private DirtyResourceFactory(){
		
	}
	
	public static DirtyResourceFactory getInstance(){
		if(instance==null){
			instance=new DirtyResourceFactory();
		}
		return instance;
	}
	}
