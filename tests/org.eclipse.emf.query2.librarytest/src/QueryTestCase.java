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

import library.LibraryPackage;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query.index.query.QueryExecutor;
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

			@Override
			public void execute(final IndexUpdater updater, QueryExecutor queryExecutor) {
				final ResourceIndexer indexer = new ResourceIndexer();
				indexer.resourceChanged(updater, EcorePackage.eINSTANCE.eResource());
				indexer.resourceChanged(updater, LibraryPackage.eINSTANCE.eResource());
				IResource data = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.emf.query2.librarytest").findMember(
						"data");
				final ResourceSet rs = new ResourceSetImpl();
				try {
					data.accept(new IResourceVisitor() {
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if ("xmi".equals(resource.getFileExtension())) {
								System.out.print(".");
								c.inc();
								indexer.resourceChanged(updater, rs.getResource(URI.createPlatformResourceURI(resource.getFullPath()
										.toString(), true), true));
							}

							return true;
						}
					});
				} catch (CoreException e) {
					e.printStackTrace();
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
