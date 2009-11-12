package com.sap.tc.emf.test.query.setup;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;

public class IndexerForTest {

	public static void index(Index index, final Resource... resources) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			@Override
			public void execute(IndexUpdater updater, QueryExecutor queryExecutor) {
				ResourceIndexer.INSTANCE.resourceChanged(updater, resources);
			}
		});
	}

	public static void delete(Index index, final URI... resources) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			@Override
			public void execute(IndexUpdater updater, QueryExecutor queryExecutor) {
				for (URI resource : resources) {
					updater.deleteResource(resource);
				}
			}
		});
	}
}
