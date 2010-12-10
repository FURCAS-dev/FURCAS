/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.event.IndexChangeListenerRegistry;
import org.eclipse.emf.query.index.internal.IndexUpdaterInternal;
import org.eclipse.emf.query.index.internal.PageFileProvider;
import org.eclipse.emf.query.index.internal.PageableIndex;
import org.eclipse.emf.query.index.internal.PagingStrategy;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.impl.query.QueryExecutorImpl;
import org.eclipse.emf.query.index.internal.impl.update.IndexUpdaterImpl;
import org.eclipse.emf.query.index.internal.maps.LeanMap;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.update.UpdateCommand;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class PageableIndexImpl implements PageableIndex {

	public static class Options {

		public static final int DISABLED = Integer.MAX_VALUE;
		public static final Options PAGING_AND_DUMPING_DISABLED = new Options(null, DISABLED, DISABLED);

		private final String baseDirectory;
		private final int tolerance;
		private final int limit;

		public Options(String pagingDirectory, int limit, int tolerance) {
			if (limit < 0) {
				limit = DISABLED;
			}
			if (tolerance < 0) {
				tolerance = DISABLED;
			}

			this.baseDirectory = pagingDirectory;
			this.limit = limit;
			this.tolerance = tolerance;

			if (limit != DISABLED && pagingDirectory == null) {
				throw new IllegalArgumentException("Base directory must be specified");
			}
			if (limit != DISABLED && tolerance == DISABLED) {
				throw new IllegalArgumentException("Tolerance must be set");
			}
		}
	}

	private static final String DUMP_FILE_ID = "dumpfile";

	private GlobalTables globalTables;

	private ReentrantReadWriteLock rwLock;

	private PageFileProvider chProv;

	public PageableIndexImpl(Options options) {
		rwLock = new ReentrantReadWriteLock();
		globalTables = new GlobalTables();
		globalTables.elementTypeIndex = new LeanMap<String, URI>(16);
		chProv = new PageFileProviderImpl(options.baseDirectory);
		PagingStrategy<PageableResourceDescriptorImpl> pagingStrategy = new PagingStrategyImpl<PageableResourceDescriptorImpl>(chProv, options.limit, options.tolerance);
		globalTables.resourceIndex = new PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl>(PageableResourceDescriptorImpl.URI, pagingStrategy);
	}

	public void executeQueryCommand(QueryCommand command) {
		this.rwLock.readLock().lock();
		QueryExecutorInternal queryEx = new QueryExecutorImpl(this.globalTables);
		try {
			command.execute(queryEx);
		} finally {
			queryEx.invalidate();
			this.rwLock.readLock().unlock();
		}
	}

	public void executeUpdateCommand(UpdateCommand command) {
		IndexUpdaterInternal indexUpdater = new IndexUpdaterImpl(this.globalTables);
		command.execute(indexUpdater);
		this.rwLock.writeLock().lock();
		try {
			command.preCommitAction(indexUpdater);
			indexUpdater.commit();
			command.postCommitAction();
		} finally { // FIXME rollback handling?
			this.rwLock.writeLock().unlock();
		}
	}

	public IndexChangeListenerRegistry getEventListenerRegistry() {
		throw new UnsupportedOperationException("to implement");
	}

	public void save() {
		this.rwLock.writeLock().lock();
		try {
			this.globalTables.resourceIndex.flush();
			File outputFile = this.chProv.getOutputFile(DUMP_FILE_ID);
			FileOutputStream fos = new FileOutputStream(outputFile);
			SerializationStrategyFactory factory = new SerializationStrategyFactory(fos);
			this.globalTables.resourceIndex.serialize(factory.createResourceMapStrategy(this.globalTables.resourceIndex));
			this.globalTables.elementTypeIndex.serialize(factory.createGlobalTypeMapStrategy(this.globalTables.resourceIndex.getUnderlyingMap()));
			factory.finalizePaging();
			this.closeStream(fos);
		} catch (FileNotFoundException fnf) {
			throw new RuntimeException(fnf); // FIXME exception handling
		} finally {
			this.rwLock.writeLock().unlock();
		}
	}

	public void load() {
		this.rwLock.writeLock().lock();
		try {
			File inputFile = this.chProv.getInputFile(DUMP_FILE_ID);
			if (inputFile.exists()) {
				FileInputStream fis = new FileInputStream(inputFile);
				SerializationStrategyFactory factory = new SerializationStrategyFactory(fis);
				this.globalTables.resourceIndex.deserialize(factory.createResourceMapStrategy(this.globalTables.resourceIndex));
				this.globalTables.elementTypeIndex.deserialize(factory.createGlobalTypeMapStrategy(this.globalTables.resourceIndex.getUnderlyingMap()));
				factory.finalizePaging();
				this.closeStream(fis);
				inputFile.delete();
			}
		} catch (FileNotFoundException fnf) {
			throw new RuntimeException(fnf);
		} finally {
			this.rwLock.writeLock().unlock();
		}
	}

	private void closeStream(Closeable stream) {
		try {
			stream.close();
		} catch (IOException e) {
			throw new RuntimeException(e); // FIXME exception handling
		}
	}

}
