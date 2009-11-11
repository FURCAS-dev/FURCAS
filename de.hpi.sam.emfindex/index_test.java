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


import java.util.Iterator;

import javax.management.Query;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;

import com.sun.java.util.jar.pack.ConstantPool.Index;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class NavigationTestItemis extends Assert {

	protected static final int NUM_MODELS = 1000;
	protected static final int REPS = 20;
	private static MemoryIndexImpl index;

	private static final boolean SHOW_COUNTS = true;

	protected QueryExecutorImpl queryExecutor;
	protected DescriptorFactory descriptorFactory;

	protected void setup() throws Exception {
		MemoryIndexImpl mindex = new MemoryIndexImpl();
		mindex.setIndexUpdater(new IndexUpdaterImpl(mindex));
		queryExecutor = new QueryExecutorImpl();
		queryExecutor.addQueryExecutorStrategy(new ResourceQueryExecutorStrategyImpl(), 0);
		queryExecutor.addQueryExecutorStrategy(new EObjectQueryExecutorStrategyImpl(), 0);
		queryExecutor.addQueryExecutorStrategy(new EReferenceQueryExecutorStrategyImpl(), 0);
		mindex.setQueryExecutor(queryExecutor);
		descriptorFactory = new DescriptorFactoryImpl();
		index = mindex;
	}

	@Test
	public void testBuildUp() throws Exception {
		setup();
		final ResourceIndexerImpl resourceIndexer = new ResourceIndexerImpl();
		System.out.println("indexing " + NUM_MODELS + " times ecore");
		final Resource r = this.getEcoreCopy();
		long begin = System.currentTimeMillis();
		index.executeUpdateCommand(new UpdateCommand<Boolean>() {
			public Boolean execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor, Index indexStore) {
				for (int i = 0; i < NUM_MODELS; ++i) {
					URI resourceURI = URI.createURI(Integer.toHexString(i) + ".ecore");
					r.setURI(resourceURI);
					resourceIndexer.resourceChanged(r, indexUpdater);
					System.out.println(i);
				}
				return true;
			}
		});
		long end = System.currentTimeMillis();
		System.out.println("Total indexing time: " + (end - begin) + "ms.");

		long timeUsed = 0;
		for (int i = 0; i < REPS; i++) {
			begin = System.currentTimeMillis();
			index.executeQueryCommand(new QueryCommand<Boolean>() {
				public Boolean execute(QueryExecutor queryExecutor, Index index) {
					System.out.println("#EReferenceDescriptors " + size(queryExecutor, new EReferenceDescriptorQuery()));
					System.out.println("#EObjectDescriptors " + size(queryExecutor, new EObjectDescriptorQuery()));
					return true;
				}
			});
			end = System.currentTimeMillis();
			timeUsed += end - begin;
		}
		System.out.println("Total query iteration time: " + timeUsed / (float) REPS + "ms.");
	}

	private Resource getEcoreCopy() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource copy = rs.createResource(URI.createFileURI("C:/tmp/ecoreCopy.xmi"));
		Resource ecoreResource = EcorePackage.eINSTANCE.eResource();
		copy.getContents().add(EcorePackage.eINSTANCE);
		copy.save(null);
		ecoreResource.getContents().add(EcorePackage.eINSTANCE);
		copy.unload();
		copy.load(null);
		Resource result = new XMIResourceImpl();
		result.getContents().addAll(copy.getContents());
		copy.delete(null);
		return result;
	}

	@Test
	public void testGetAllReferringReferences() throws Exception {
		index.executeQueryCommand(new QueryCommand<Boolean>() {

			@Override
			public Boolean execute(QueryExecutor queryExecutor, Index index) {
				ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
				QueryResult<ResourceDescriptor> execute = queryExecutor.execute(resourceQuery, index);

				ResourceDescriptor next = null;
				Iterator<ResourceDescriptor> it = execute.iterator();
				while (it.hasNext() && (next = it.next()) != null && next.getURI().toString().length() == 0) {
				}

				// class loading
				{
					System.out.print("Class loading");
					EReferenceDescriptorQuery referenceQueryCL = new EReferenceDescriptorQuery();
					ResourceDescriptorQuery target = new ResourceDescriptorQuery();
					target.setURI(next.getURI());
					referenceQueryCL.setTargetResourceQuery(target);
					size(queryExecutor, referenceQueryCL);
					System.out.println("...finished");
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EReferenceDescriptorQuery referenceQueryCL = new EReferenceDescriptorQuery();
					ResourceDescriptorQuery target = new ResourceDescriptorQuery();
					target.setURI(next.getURI());
					referenceQueryCL.setTargetResourceQuery(target);

					int size = size(queryExecutor, referenceQueryCL);

					timeUsed += System.nanoTime() - time;
					if (SHOW_COUNTS)
						System.out.println(size);
				}
				System.out.println("getAllReferringReferences : " + (timeUsed) / REPS);
				return true;
			}

		});
	}

	@Test
	public void testTypeQueryForEClass() throws Exception {
		index.executeQueryCommand(new QueryCommand<Boolean>() {

			@Override
			public Boolean execute(QueryExecutor queryExecutor, Index index) {

				// class loading
				{
					EObjectDescriptorQuery eObjectQuery = new EObjectDescriptorQuery();
					eObjectQuery.setEClassEquals(EcorePackage.Literals.ECLASS);
					size(queryExecutor, eObjectQuery);
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EObjectDescriptorQuery eObjectQuery = new EObjectDescriptorQuery();
					eObjectQuery.setEClassEquals(EcorePackage.Literals.ECLASS);
					int size = size(queryExecutor, eObjectQuery);
					time = System.nanoTime() - time;
					timeUsed += time;
					if (SHOW_COUNTS)
						System.out.println(size + ", " + time);
				}
				System.out.println("getInstancesOfEClass : " + (timeUsed) / REPS);

				return true;
			}

		});
	}

	@Test
	public void testSaveLoad() throws Exception {
		long timeUsed = 0;
		for (int i = 0; i < 1; i++) {
			this.testBuildUp();
			long time = System.currentTimeMillis();
			index.save();
			time = System.currentTimeMillis() - time;
			System.out.println("index save time: " + time);
			timeUsed += time;
		}
		System.out.println(timeUsed / (float) REPS);
	}

	int size(QueryExecutor queryExecutor, Query<?> query) {
		Iterator<?> result = queryExecutor.execute(query, index).iterator();
		int count = 0;
		while (result.hasNext()) {
			result.next();
			++count;
		}
		return count;
	}

}

