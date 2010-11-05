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
package org.eclipse.emf.query.index.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query.index.query.EObjectQuery;
import org.eclipse.emf.query.index.query.EReferenceQuery;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.Query;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class TestIndexNotSufficient extends Assert {

	private final class QueryCmd<C, D, T extends Query<C, D>> implements QueryCommand {
		private final T refQuery;
		private final int returnSize;

		public QueryCmd(T refQuery, int returnSize) {
			this.refQuery = refQuery;
			this.returnSize = returnSize;
		}

		public QueryCmd(T refQuery) {
			this(refQuery, 1);
		}

		@Override
		public void execute(QueryExecutor queryExecutor) {
			long time = System.nanoTime();
			QueryResult<C> result = queryExecutor.execute(refQuery);
			Iterator<C> iterator = result.iterator();
			if (returnSize == 0) {
				assertFalse(iterator.hasNext());
			} else {
				for (int i = 0; i < returnSize; i++) {
					assertTrue(iterator.hasNext());
					assertNotNull(iterator.next());
				}
			}
			time = System.nanoTime() - time;
			System.out.println(time);
		}
	}

	private static final int RESOURCE_COUNT = 1000;

	private static final int ELEMENT_COUNT = 1000;

	private Options getOptions() {
		return new Options(getTempDir(), Options.DISABLED, Options.DISABLED);
	}

	@Test
	public void testNonExistingBackwardLink() throws Exception {
		PageableIndexImpl index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.println("Creating resources");
		long time = System.currentTimeMillis();

		Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/dump_1.xmi"));
		Resource r2 = rs.createResource(URI.createFileURI(getTempDir() + "/dump_2.xmi"));

		resourceURIs.add(r.getURI());
		resourceURIs.add(r2.getURI());

		EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
		eClass1.setName("EClass1");
		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("EClass2");
		r.getContents().add(eClass1);
		r2.getContents().add(eClass2);
		eClass1.getESuperTypes().add(eClass2);

		EClass eClass1_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass1_2.setName("EClass1_2");
		EClass eClass2_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2_2.setName("EClass2_2");
		r.getContents().add(eClass1_2);
		r2.getContents().add(eClass2_2);

		URI class1Uri = EcoreUtil.getURI(eClass1);
		URI class2Uri = EcoreUtil.getURI(eClass2);

		r.save(null);
		r2.save(null);
		this.resourceChanged(index, r, r2);

		final EReferenceQuery<EReferenceDescriptor> query = IndexQueryFactory.createEReferenceQuery();
		query.targetEObject().resource().uri(class2Uri.trimFragment().toString());
		query.targetEObject().fragment(class2Uri.fragment());
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				QueryResult<EReferenceDescriptor> result = queryExecutor.execute(query);
				int size = 0;
				for (EReferenceDescriptor eob : result) {
					System.out.println(eob.getSourceResourceURI() + "#" + eob.getSourceFragment());
					size++;
				}
				assertEquals(2, size);
			}

		});

		System.out.println("----");
		query.targetEObject().resource().uri("find_ich_nich");
		query.targetEObject().fragment(class2Uri.fragment());
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				QueryResult<EReferenceDescriptor> result = queryExecutor.execute(query);
				int size = 0;
				for (EReferenceDescriptor eob : result) {
					System.out.println(eob.getSourceResourceURI() + "#" + eob.getSourceFragment());
					size++;
				}
				assertEquals(0, size);
			}

		});

		this.deleteResources(Arrays.asList(r.getURI(), r2.getURI()), index);

		r.delete(null);
		r2.delete(null);
	}

	@Test
	public void testDump() throws Exception {
		PageableIndexImpl index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources");
		long time = System.currentTimeMillis();

		Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/dump_1.xmi"));
		Resource r2 = rs.createResource(URI.createFileURI(getTempDir() + "/dump_2.xmi"));

		resourceURIs.add(r.getURI());
		resourceURIs.add(r2.getURI());

		EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
		eClass1.setName("EClass1");
		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("EClass2");
		r.getContents().add(eClass1);
		r2.getContents().add(eClass2);
		eClass1.getESuperTypes().add(eClass2);

		EClass eClass1_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass1_2.setName("EClass1_2");
		EClass eClass2_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2_2.setName("EClass2_2");
		r.getContents().add(eClass1_2);
		r2.getContents().add(eClass2_2);

		r.save(null);
		r2.save(null);
		this.resourceChanged(index, r, r2);
		System.out.print(".");
		r.unload();
		r2.unload();

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		index.save();

		index = new PageableIndexImpl(getOptions());
		index.load();

		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				EObjectQuery<EObjectDescriptor> query = IndexQueryFactory.createEObjectQuery();
				QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
				int size = 0;
				for (EObjectDescriptor eob : result) {
					System.out.println(eob.getResourceURI() + "#" + eob.getFragment());
					size++;
				}
				assertEquals(5, size);
			}

		});

		this.deleteResources(Arrays.asList(r.getURI(), r2.getURI()), index);

		r.delete(null);
		r2.delete(null);
	}

	@Test
	public void testEReferenceQuery() throws Exception {
		PageableIndexImpl index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources");
		long time = System.currentTimeMillis();

		getTempDir();

		Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/resERefQuery_1.xmi"));
		Resource r2 = rs.createResource(URI.createFileURI(getTempDir() + "/resERefQuery_2.xmi"));

		resourceURIs.add(r.getURI());
		resourceURIs.add(r2.getURI());

		EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
		eClass1.setName("EClass1");
		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("EClass2");
		r.getContents().add(eClass1);
		r2.getContents().add(eClass2);
		eClass1.getESuperTypes().add(eClass2);

		EClass eClass1_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass1_2.setName("EClass1_2");
		EClass eClass2_2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2_2.setName("EClass2_2");
		r.getContents().add(eClass1_2);
		r2.getContents().add(eClass2_2);

		r.save(null);
		r2.save(null);
		this.resourceChanged(index, r, r2);
		System.out.print(".");
		r.unload();
		r2.unload();

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		EReferenceQuery<EReferenceDescriptor> refQuery;

		// forward Query
		refQuery = IndexQueryFactory.createEReferenceQuery();
		refQuery.sourceEObject().name("*s1");

		index
				.executeQueryCommand(new QueryCmd<EReferenceDescriptor, EReferenceDescriptor, EReferenceQuery<EReferenceDescriptor>>(
						refQuery));

		// backward Query
		refQuery = IndexQueryFactory.createEReferenceQuery();
		refQuery.targetEObject().name("*s2");

		index
				.executeQueryCommand(new QueryCmd<EReferenceDescriptor, EReferenceDescriptor, EReferenceQuery<EReferenceDescriptor>>(
						refQuery));

		// clean up
		r.delete(null);
		r2.delete(null);
	}

	private static String getTempDir() {
		return System.getProperty("java.io.tmpdir") + File.pathSeparator + "index";
	}

	@Test
	public void testIntraEReferenceQuery() throws Exception {
		PageableIndexImpl index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources");
		long time = System.currentTimeMillis();

		Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/resIntraERefQuery_1.xmi"));

		resourceURIs.add(r.getURI());

		EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
		eClass1.setName("EClass1");
		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("EClass2");
		r.getContents().add(eClass1);
		r.getContents().add(eClass2);
		eClass1.getESuperTypes().add(eClass2);

		r.save(null);
		this.resourceChanged(index, r);
		System.out.print(".");
		r.unload();

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		EReferenceQuery<EReferenceDescriptor> refQuery;

		// forward Query
		refQuery = IndexQueryFactory.createEReferenceQuery();
		refQuery.sourceEObject().name("*s1");

		index
				.executeQueryCommand(new QueryCmd<EReferenceDescriptor, EReferenceDescriptor, EReferenceQuery<EReferenceDescriptor>>(
						refQuery));

		// backward Query
		refQuery = IndexQueryFactory.createEReferenceQuery();
		refQuery.targetEObject().name("*s2");

		index
				.executeQueryCommand(new QueryCmd<EReferenceDescriptor, EReferenceDescriptor, EReferenceQuery<EReferenceDescriptor>>(
						refQuery));

		// clean up
		r.delete(null);
	}

	@Test
	public void testEResourceQuery() throws Exception {
		PageableIndexImpl index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources");
		long time = System.currentTimeMillis();

		Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/resQueryEResource.xmi"));

		resourceURIs.add(r.getURI());

		for (int i = 0; i < ELEMENT_COUNT; i++) {
			EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
			eClass1.setName("EClass1" + i);
			r.getContents().add(eClass1);
		}

		r.save(null);
		this.resourceChanged(index, r);
		System.out.print(".");
		r.unload();

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		// query resource
		ResourceQuery<ResourceDescriptor> resQuery = IndexQueryFactory.createResourceQuery();
		resQuery.uri(r.getURI().toString());

		index.executeQueryCommand(new QueryCmd<ResourceDescriptor, ResourceDescriptor, ResourceQuery<ResourceDescriptor>>(resQuery));

		resQuery.userData("key", "abc*");

		index.executeQueryCommand(new QueryCmd<ResourceDescriptor, ResourceDescriptor, ResourceQuery<ResourceDescriptor>>(resQuery));

		// negative
		resQuery.userData("key", "abce");

		index.executeQueryCommand(new QueryCmd<ResourceDescriptor, ResourceDescriptor, ResourceQuery<ResourceDescriptor>>(resQuery, 0));

		// clean up
		r.delete(null);
	}

	@Test
	public void testEObjectQuery() throws Exception {
		PageableIndexImpl index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources");
		long time = System.currentTimeMillis();

		Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/resQueryEObject.xmi"));

		resourceURIs.add(r.getURI());

		for (int i = 0; i < ELEMENT_COUNT; i++) {
			EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
			eClass1.setName("EClass1" + i);
			r.getContents().add(eClass1);
		}

		r.save(null);
		this.resourceChanged(index, r);
		System.out.print(".");
		r.unload();

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		// query eobjects
		EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
		eObjectQuery.eClassURI(EcoreUtil.getURI(EcorePackage.Literals.ECLASS));
		eObjectQuery.fragment("/1*");

		index.executeQueryCommand(new QueryCmd<EObjectDescriptor, EObjectDescriptor, EObjectQuery<EObjectDescriptor>>(eObjectQuery));

		eObjectQuery = IndexQueryFactory.createEObjectQuery();
		eObjectQuery.userData("key", "wxy*");

		index.executeQueryCommand(new QueryCmd<EObjectDescriptor, EObjectDescriptor, EObjectQuery<EObjectDescriptor>>(eObjectQuery));

		eObjectQuery = IndexQueryFactory.createEObjectQuery();
		eObjectQuery.userData("key", "wxyaasd");

		index.executeQueryCommand(new QueryCmd<EObjectDescriptor, EObjectDescriptor, EObjectQuery<EObjectDescriptor>>(eObjectQuery, 0));

		// query eobjects with resource query
		eObjectQuery = IndexQueryFactory.createEObjectQuery();
		eObjectQuery.resource().uri(r.getURI().toString());
		index.executeQueryCommand(new QueryCmd<EObjectDescriptor, EObjectDescriptor, EObjectQuery<EObjectDescriptor>>(eObjectQuery));

		eObjectQuery.resource().uri(r.getURI().toString() + "_invalid");
		index.executeQueryCommand(new QueryCmd<EObjectDescriptor, EObjectDescriptor, EObjectQuery<EObjectDescriptor>>(eObjectQuery, 0));

		System.out.println();
		r.delete(null);
	}

	@Test
	public void testOneMillionNewIndex() throws Exception {
		Index index = new PageableIndexImpl(getOptions());

		ResourceSet rs = new ResourceSetImpl();

		List<URI> resourceURIs = new ArrayList<URI>();

		System.out.print("Creating resources");
		long time = System.currentTimeMillis();

		for (int i = 0; i < (RESOURCE_COUNT / 2); i++) {
			Resource r = rs.createResource(URI.createFileURI(getTempDir() + "/res" + i + "_1.xmi"));
			Resource r2 = rs.createResource(URI.createFileURI(getTempDir() + "/res" + i + "_2.xmi"));

			resourceURIs.add(r.getURI());
			resourceURIs.add(r2.getURI());

			for (int j = 0; j < ELEMENT_COUNT; j++) {
				EClass eClass1 = EcoreFactory.eINSTANCE.createEClass();
				eClass1.setName("EClass1_" + i + "_" + j);
				EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
				eClass2.setName("EClass2_" + i + "_" + j);
				r.getContents().add(eClass1);
				r2.getContents().add(eClass2);
				if (j % 5 == 0) {
					if (j % 10 == 0) {
						eClass1.getESuperTypes().add(eClass2);
					} else {
						eClass2.getESuperTypes().add(eClass1);
					}
				}
			}

			r.save(null);
			r2.save(null);
			this.resourceChanged(index, r, r2);
			System.out.print(".");
			r.unload();
			r2.unload();
		}

		time = System.currentTimeMillis() - time;
		System.out.println(time);

		time = System.currentTimeMillis();
		index.save();
		time = System.currentTimeMillis() - time;
		System.out.println("Index save time: " + time);

		index = new PageableIndexImpl(getOptions());
		time = System.currentTimeMillis();
		index.load();
		time = System.currentTimeMillis() - time;
		System.out.println("Index load time: " + time);

		time = System.currentTimeMillis();
		this.deleteResources(resourceURIs, index);
		for (URI uri : resourceURIs) {
			rs.getResource(uri, false).delete(null);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}

	private void resourceChanged(Index index, final Resource... r) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			@Override
			public void execute(IndexUpdater updater) {
				new ResourceIndexer() {

					@Override
					protected Map<String, String> getResourceUserData(Resource res) {
						Map<String, String> result = new HashMap<String, String>();
						result.put("key", "abcd");
						return result;
					}

					@Override
					protected Map<String, String> getEObjectUserData(EObject element) {
						Map<String, String> result = new HashMap<String, String>();
						result.put("key", "wxyz");
						return result;
					}
				}.resourceChanged(updater, r);
			}

		});
	}

	protected void deleteResources(final Collection<URI> uris, Index index) {
		index.executeUpdateCommand(new UpdateCommandAdapter() {

			@Override
			public void execute(IndexUpdater updater) {
				for (URI uri : uris) {
					updater.deleteResource(uri);
				}
			}

		});
	}

	@AfterClass
	public static void deleteTempDir() {
		new File(getTempDir()).deleteOnExit();
	}

}
