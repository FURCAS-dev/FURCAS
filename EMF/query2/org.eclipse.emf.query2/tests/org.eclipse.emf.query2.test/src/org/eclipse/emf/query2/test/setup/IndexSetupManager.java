package org.eclipse.emf.query2.test.setup;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;

public class IndexSetupManager {

	public static void index(Index index, final Resource... resources) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			public void execute(IndexUpdater updater) {
				ResourceIndexer.INSTANCE.resourceChanged(updater, resources);
			}
		});
	}

	public static void delete(Index index, final URI... resources) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			public void execute(IndexUpdater updater) {
				for (URI resource : resources) {
					updater.deleteResource(resource);
				}
			}
		});
	}
}
