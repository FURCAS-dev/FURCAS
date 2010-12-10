package org.eclipse.emf.query.index.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;

public class IndexFactory {

	private static final Index index;

	static {
		index = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			public void execute(final IndexUpdater updater) {
				final ResourceIndexer indexer = new ResourceIndexer();
				List<String> uris = new ArrayList<String>();
				for (String packUri : EPackage.Registry.INSTANCE.keySet()) {
					uris.add(packUri);
				}
				for (String packUri : uris) {
					try {
						indexer.resourceChanged(updater, EPackage.Registry.INSTANCE.getEPackage(packUri).eResource());
					} catch (Exception e) {
						System.err.println("Error indexing uri: " + packUri);
						e.printStackTrace();
					}
				}

			}
		});
	}

	private IndexFactory() {
	}

	public static Index getInstance() {
		return index;
	}
}
