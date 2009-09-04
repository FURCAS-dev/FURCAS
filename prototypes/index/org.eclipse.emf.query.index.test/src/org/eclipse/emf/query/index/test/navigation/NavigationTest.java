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
package org.eclipse.emf.query.index.test.navigation;

import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query.index.query.EObjectQuery;
import org.eclipse.emf.query.index.query.EReferenceQuery;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommand;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class NavigationTest extends Assert {

	protected static final int NUM_MODELS = 3000;
	protected static final int REPS = 20;
	private static Index index;

	@Test
	public void testBuildUp() throws Exception {

		index = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);

		final Resource r = new XMIResourceImpl();
		r.getContents().add(EcorePackage.eINSTANCE);
		long begin = System.currentTimeMillis();
		index.executeUpdateCommand(new UpdateCommand() {

			@Override
			public void execute(IndexUpdater updater, QueryExecutor queryExecutor) {
				ResourceIndexer ourResourceIndexer = new ResourceIndexer();
				for (int i = 0; i < NUM_MODELS; i++) {
					URI resourceURI = URI.createURI(Integer.toHexString(i) + ".ecore");
					r.setURI(resourceURI);
					ourResourceIndexer.resourceChanged(updater, r);
//					System.out.println(i);
				}

			}
		});
		long end = System.currentTimeMillis();
		System.out.println("Total indexing time: " + (end - begin) + "ms.");

		long timeUsed = 0;
		for (int i = 0; i < REPS; i++) {
			begin = System.currentTimeMillis();
			index.executeQueryCommand(new QueryCommand() {
				@Override
				public void execute(QueryExecutor queryExecutor) {
					EObjectQuery<EObjectDescriptor> createEObjectQuery = IndexQueryFactory.createEObjectQuery();
					EReferenceQuery<EReferenceDescriptor> createEReferenceQuery = IndexQueryFactory.createEReferenceQuery();
					System.out.println("#EObjectDescriptors " + size(queryExecutor.execute(createEObjectQuery)));
					System.out.println("#EReferenceDescriptors " + size(queryExecutor.execute(createEReferenceQuery)));
				}
			});
			end = System.currentTimeMillis();
			timeUsed += end - begin;
		}
		System.out.println("Total query iteration time: " + timeUsed/(float)REPS + "ms.");
	}

	@Test
	public void testGetResourceDescriptorFromEObject() throws Exception {
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
				QueryResult<EObjectDescriptor> execute = queryExecutor.execute(eObjectQuery);

				EObjectDescriptor next = execute.iterator().next();

				// load classes
				{
					ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
					resourceQuery.uri(next.getResourceURI());
					queryExecutor.execute(resourceQuery).iterator().next();
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
					resourceQuery.uri(next.getResourceURI());
					ResourceDescriptor result = queryExecutor.execute(resourceQuery).iterator().next();
					timeUsed += System.nanoTime() - time;
//					System.out.println(result.getURI());
				}
				System.out.println("eobjectDesc.getResourceDescriptor() : " + (timeUsed) / (float) REPS);
			}

		});
	}

	@Test
	public void testGetEObjectDescriptorsFromResource() throws Exception {
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
				QueryResult<ResourceDescriptor> execute = queryExecutor.execute(resourceQuery);

				ResourceDescriptor next = null;
				Iterator<ResourceDescriptor> it = execute.iterator();
				while (it.hasNext() && (next = it.next()) != null && next.getURI().length() == 0) {
				}

				// load classes
				{
					EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
					eObjectQuery.resource().uri(next.getURI());
					queryExecutor.execute(eObjectQuery).iterator().next();
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
					eObjectQuery.resource().uri(next.getURI());
					Iterator<EObjectDescriptor> iterator = queryExecutor.execute(eObjectQuery).iterator();
					while (iterator.hasNext()) {
						iterator.next();
					}
					timeUsed += System.nanoTime() - time;
				}
				System.out.println("eResourceDesc.getEObjectDescriptor() : " + (timeUsed) / (float) REPS);
			}
		});
	}

	@Test
	public void testGetEReferenceDescriptorsFromResource() throws Exception {
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
				QueryResult<ResourceDescriptor> execute = queryExecutor.execute(resourceQuery);

				ResourceDescriptor next = null;
				Iterator<ResourceDescriptor> it = execute.iterator();
				while (it.hasNext() && (next = it.next()) != null && next.getURI().length() == 0) {
				}

				// load classes
				{
					EReferenceQuery<EReferenceDescriptor> referenceQuery = IndexQueryFactory.createEReferenceQuery();
					referenceQuery.sourceEObject().resource().uri(next.getURI());
					queryExecutor.execute(referenceQuery).iterator().next();
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EReferenceQuery<EReferenceDescriptor> referenceQuery = IndexQueryFactory.createEReferenceQuery();
					referenceQuery.sourceEObject().resource().uri(next.getURI());
					Iterator<EReferenceDescriptor> iterator = queryExecutor.execute(referenceQuery).iterator();
					while (iterator.hasNext()) {
						iterator.next();
					}
					timeUsed += System.nanoTime() - time;
				}
				System.out.println("eResourceDesc.getEReferenceDescriptor() : " + (timeUsed) / (float) REPS);
			}
		});
	}

	@Test
	public void testEObjectDescriptorFromEReference() throws Exception {
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
				QueryResult<ResourceDescriptor> execute = queryExecutor.execute(resourceQuery);

				ResourceDescriptor next = null;
				Iterator<ResourceDescriptor> it = execute.iterator();
				while (it.hasNext() && (next = it.next()) != null && next.getURI().length() == 0) {
				}

				EReferenceQuery<EReferenceDescriptor> referenceQuery = IndexQueryFactory.createEReferenceQuery();
				referenceQuery.sourceEObject().resource().uri(next.getURI());
				EReferenceDescriptor referenceDescriptor = queryExecutor.execute(referenceQuery).iterator().next();

				// load classes
				{
					EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
					eObjectQuery.resource().uri(referenceDescriptor.getTargetResourceURI());
					eObjectQuery.fragment(referenceDescriptor.getTargetFragment());
					queryExecutor.execute(eObjectQuery).iterator().next();
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
					eObjectQuery.resource().uri(referenceDescriptor.getTargetResourceURI());
					eObjectQuery.fragment(referenceDescriptor.getTargetFragment());
					Iterator<EObjectDescriptor> iterator = queryExecutor.execute(eObjectQuery).iterator();
					while (iterator.hasNext()) {
						iterator.next();
					}
					timeUsed += System.nanoTime() - time;
				}
				System.out.println("eReferenceDesc.getEObjectDescriptor() : " + (timeUsed) / (float) REPS);
			}
		});
	}

	@Test
	public void testGetAllReferringReferences() throws Exception {
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
				QueryResult<ResourceDescriptor> execute = queryExecutor.execute(resourceQuery);

				ResourceDescriptor next = null;
				Iterator<ResourceDescriptor> it = execute.iterator();
				while (it.hasNext() && (next = it.next()) != null && next.getURI().length() == 0) {
				}

				// class loading
				EReferenceQuery<EReferenceDescriptor> referenceQueryCL = IndexQueryFactory.createEReferenceQuery();
				referenceQueryCL.targetEObject().resource().uri(next.getURI());
				queryExecutor.execute(referenceQueryCL).iterator().next();

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EReferenceQuery<EReferenceDescriptor> referenceQuery = IndexQueryFactory.createEReferenceQuery();
					referenceQuery.targetEObject().resource().uri(next.getURI());

					HashSet<EReferenceDescriptor> map = new HashSet<EReferenceDescriptor>();
					int size = size(queryExecutor.execute(referenceQuery));

					timeUsed += System.nanoTime() - time;
					System.out.println(size);
				}
				System.out.println("getAllReferringReferences : " + (timeUsed) / (float) REPS);
			}

		});
	}

	@Test
	public void testTypeQueryForEClass() throws Exception {
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {

				// class loading
				{
					EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
					eObjectQuery.eClassURI(EcoreUtil.getURI(EcorePackage.Literals.ECLASS).fragment());
					queryExecutor.execute(eObjectQuery).iterator().next();
				}

				long timeUsed = 0;
				for (int i = 0; i < REPS; i++) {
					long time = System.nanoTime();
					EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
					eObjectQuery.eClassURI(EcoreUtil.getURI(EcorePackage.Literals.ECLASS).fragment());
					int size = size(queryExecutor.execute(eObjectQuery));
					timeUsed += System.nanoTime() - time;
					System.out.println(size);
				}
				System.out.println("getInstancesOfEClass : " + (timeUsed) / (float) REPS);
			}
		});
	}

	@Test
	public void testSaveLoad() throws Exception {
		long timeUsed = 0;
		for (int i = 0; i < REPS; i++) {
			this.testBuildUp();
			long time = System.currentTimeMillis();
			index.save();
			time = System.currentTimeMillis() - time;
			System.out.println("index save time: " + time);
			timeUsed += time;
		}
		System.out.println(timeUsed / (float) REPS);
	}

	int size(Iterable<?> queryIt) {
		int count = 0;
		Iterator<?> query = queryIt.iterator();
		while (query.hasNext()) {
			query.next();
			++count;
		}
		return count;
	}

	protected void deleteResources(final Collection<URI> uris, Index index) {
		index.executeUpdateCommand(new UpdateCommand() {

			@Override
			public void execute(IndexUpdater updater, QueryExecutor queryExecutor) {
				for (URI uri : uris) {
					updater.deleteResource(uri.toString());
				}
			}

		});
	}

	private static final class OurResourceIndexer extends ResourceIndexer {

		/**
		 * This method is introduce to allow a test that renames the Ecore
		 * resource. Since ecore is a self-referenced metamodel the URIs of
		 * types change to the new name.
		 * 
		 * @param updater
		 * @param resources
		 */
		public void resourceChanged2(IndexUpdater updater, final Resource... resources) {
			ResourceSet resourceSet = resources[0].getResourceSet();
			URIConverter uriConverter = (resourceSet != null) ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
			Map<EClass, String> typeMap = new IdentityHashMap<EClass, String>();
			for (Resource resource : resources) {
				String resourceUri = resource.getURI().toString();

				updater.insertResource(resourceUri, resource.getTimeStamp(), getResourceUserData(resource));

				for (Iterator<EObject> i = EcoreUtil.getAllProperContents(resource, false); i.hasNext();) {
					EObject element = i.next();
					if (isIndexElement(element)) {

						String fragment = resource.getURIFragment(element);
						EClass type = element.eClass();
						String typeUri;
						if ((typeUri = typeMap.get(type)) == null) {
							typeMap.put(type, typeUri = EcoreUtil.getURI(type).fragment());
						}

						updater.insertEObject(resourceUri, fragment, typeUri, getEObjectName(element), getEObjectUserData(element));

						for (EReference eReference : element.eClass().getEAllReferences()) {
							if (isIndexReference(eReference, element)) {
								String refString = EcoreUtil.getURI(eReference).toString();

								if (eReference.isMany()) {
									List<?> targets = (List<?>) element.eGet(eReference, false);
									for (int idx = 0; idx < targets.size(); ++idx) {
										Object target = targets.get(idx);
										createEReferenceDescriptor(updater, uriConverter, resourceUri, fragment, refString, target);
									}
								} else {
									Object target = element.eGet(eReference, false);
									createEReferenceDescriptor(updater, uriConverter, resourceUri, fragment, refString, target);
								}
							}
						}
					}
				}
			}
		}

		private void createEReferenceDescriptor(IndexUpdater updater, URIConverter uriConverter, String srcResourceUri,
				String sourceFragment, String reference, Object target) {
			if (target instanceof EObject) {
				URI targetURI = uriConverter.normalize(EcoreUtil.getURI((EObject) target));
				if (targetURI != null) {
					updater.insertEReference(srcResourceUri, sourceFragment, reference, targetURI.trimFragment().toString(), targetURI
							.fragment());
				}
			}
		}

	}
}
