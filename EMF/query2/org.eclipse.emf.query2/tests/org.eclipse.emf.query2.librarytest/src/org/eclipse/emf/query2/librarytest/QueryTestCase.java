package org.eclipse.emf.query2.librarytest;

/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/

import java.util.Iterator;

import library.LibraryPackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class QueryTestCase extends Assert {

	private static final Index DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);

	private static class Counter {
		int i = 0;

		void inc() {
			i++;
		}

		int getCount() {
			return i;
		}
	}

	static {

		System.out.println("Start indexing");
		final Counter c = new Counter();
		DEFAULT_INDEX.executeUpdateCommand(new UpdateCommandAdapter() {

			public void execute(final IndexUpdater updater) {
				final ResourceIndexer indexer = new ResourceIndexer();
				indexer.resourceChanged(updater, EcorePackage.eINSTANCE.eResource());
				indexer.resourceChanged(updater, LibraryPackage.eINSTANCE.eResource());
				final ResourceSet rs = new ResourceSetImpl();
				Parser parser = new Parser();
				// load the resources
				parser.loadResources(rs);
				EList<Resource> resources = rs.getResources();
				indexer.resourceChanged(updater, resources.toArray(new Resource[0]));

				// unload the resources
				for (Iterator iterator = resources.iterator(); iterator.hasNext();) {
					Resource resource = (Resource) iterator.next();
					resource.unload();
				}
			}
		});

		System.out.println("\nIndexing finished. Indexed " + c.getCount() + " files");
	}

	public static Index getDefaultIndexStore() {
		return DEFAULT_INDEX;
	}

	@Before
	public void beforeTestMethod() throws Exception {

	}

	@After
	public void afterTestMethod() throws Exception {

	}
}
