package org.eclipse.emf.query.index;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;

import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;

/**
 * A Singleton factory for {@link Index}. It assumes that index are located
 * Activator.getDefault().getStateLocation() and tries to load it. While the IDE
 * is closing, users needs to dump the indexes using dumpIndexes()
 */
public class IndexFactory {

	private static final Index index;

	static {
		// This option enables Paging and Dump. So that it can be used while IDE
		// starts and indexes would not be built all the time.
		Options options = getOptions();
		index = new PageableIndexImpl(options);
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			public void execute(final IndexUpdater updater) {
				final ResourceIndexer resourceIndexer = new ResourceIndexer();
				ResourceIndexer indexer = resourceIndexer.getInstance();
				List<String> uris = new ArrayList<String>();
				for (String packUri : EPackage.Registry.INSTANCE.keySet()) {
					uris.add(packUri);
				}
				for (String packUri : uris) {
					try {
						indexer.resourceChanged(updater, EPackage.Registry.INSTANCE.getEPackage(packUri).eResource());
					} catch (Exception e) {
						System.err.println(Messages.getString(Messages.QueryIndexUI_IndexFactory_ErrorIndexingURI, new String[] { packUri }));

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

	/**
	 * @return Options required for paging and dumping the Indexes built.
	 */
	private static Options getOptions() {
		String directoryToDumpIndices = getDirectoryToDumpIndices();
		if (directoryToDumpIndices != null) {
			return new Options(directoryToDumpIndices, Options.DISABLED, Options.DISABLED);
		}

		return Options.PAGING_AND_DUMPING_DISABLED;
	}

	/**
	 * @return The directory for dumping the indexes.
	 */
	private static String getDirectoryToDumpIndices() {
		Activator activatorInstance = Activator.getDefault();
		String indexDirectoryAsString = null;
		if (activatorInstance != null) {
			IPath baseDirectory = activatorInstance.getStateLocation().addTrailingSeparator();

			Path indexDirectoryPath = new Path(baseDirectory.toString() + Path.SEPARATOR + "index" + Path.SEPARATOR); //$NON-NLS-1$
			File indexDir = new File(indexDirectoryPath.toString());
			if (!indexDir.exists()) {
				indexDir.mkdir();
			}
			indexDirectoryAsString = indexDirectoryPath.toString();
		}
		return indexDirectoryAsString;
	}

	/**
	 * Dumps the indices into memory.
	 */
	public static void dumpIndexes() {
		long currentTimeMillis = System.currentTimeMillis();
		index.save();
		long timeTakenToDumpIndices = System.currentTimeMillis() - currentTimeMillis;
		System.out.println(Messages.getString(Messages.QueryIndexUI_IndexFactory_TimeTakenToDump, new String[] { Long.toString(timeTakenToDumpIndices) }));
	}

	/**
	 * Loads the dumped indices from memory.
	 */
	public static Index loadIndexes() {
		long currentTimeMillis = System.currentTimeMillis();
		index.load();
		long timeTakenToLoadIndices = System.currentTimeMillis() - currentTimeMillis;
		System.out.println(Messages.getString(Messages.QueryIndexUI_IndexFactory_TimeTakenToLoad, new String[] { Long.toString(timeTakenToLoadIndices) }));
		return index;
	}
}
