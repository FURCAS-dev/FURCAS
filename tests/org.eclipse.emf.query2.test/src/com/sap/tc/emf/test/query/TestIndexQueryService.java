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
package com.sap.tc.emf.test.query;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommand;
import org.eclipse.emf.query2.internal.index.IndexQueryService;
import org.eclipse.emf.query2.test.mm.testcases.case002.B2;
import org.eclipse.emf.query2.test.mm.testcases.case002.C2;
import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Factory;
import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Package;
import org.eclipse.emf.query2.test.mm.testcases.case002.E2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.emf.test.query.setup.DefaultTestClientImpl;
import com.sap.tc.emf.test.query.setup.TestClient;

public class TestIndexQueryService extends QueryTestCase {

	private TestClient testClient1;
	private Index index;

	@Override
	@Before
	public void beforeTestMethod() throws Exception {

		super.beforeTestMethod();
		this.testClient1 = new DefaultTestClientImpl();
		this.index = getDefaultIndexStore();
	}

	@Override
	@After
	public void afterTestMethod() throws Exception {

		if (this.testClient1 != null) {
			this.testClient1.clear();
			this.testClient1 = null;
		}
		this.index = null;
		super.afterTestMethod();
	}

	@Test
	public void testGetAllSubtypes() {

		EClass eClass = EcorePackage.eINSTANCE.getENamedElement();
		Collection<EClass> allSubtypes = IndexQueryService.getAllSubtypes(this.index, eClass);

		// just a spot check
		assertTrue(allSubtypes.contains(EcorePackage.eINSTANCE.getETypedElement()));
		assertTrue(allSubtypes.contains(EcorePackage.eINSTANCE.getEClassifier()));
		assertTrue(allSubtypes.contains(EcorePackage.eINSTANCE.getEClass()));
		assertTrue(allSubtypes.contains(EcorePackage.eINSTANCE.getEAttribute()));
		assertTrue(allSubtypes.contains(EcorePackage.eINSTANCE.getEParameter()));
		assertFalse(allSubtypes.contains(EcorePackage.eINSTANCE.getEModelElement()));
		assertFalse(allSubtypes.contains(EcorePackage.eINSTANCE.getEAnnotation()));
	}

	@Test
	public void testGetLinkedPartitions() {

		final Resource notLinkedResource = this.testClient1.getOrCreateResourceStable(this.getClass().getName()
				+ ".testGetLinkedPartitions_notLinked.xmi");
		final Resource linkTargetResource = this.testClient1.getOrCreateResourceStable(this.getClass().getName()
				+ ".testGetLinkedPartitions_target.xmi");
		final Resource invalidLinkTargetResource = this.testClient1.getOrCreateResourceStable(this.getClass().getName()
				+ ".testGetLinkedPartitions_invalidTarget.xmi");
		final Resource linkSourceResource = this.testClient1.getOrCreateResourceStable(this.getClass().getName()
				+ ".testGetLinkedPartitions_source.xmi");

		B2 b1 = Case002Factory.eINSTANCE.createB2();
		B2 b2 = Case002Factory.eINSTANCE.createB2();
		B2 b3 = Case002Factory.eINSTANCE.createB2();
		C2 c = Case002Factory.eINSTANCE.createC2();
		E2 e = Case002Factory.eINSTANCE.createE2();
		c.setB(b2);
		e.setB(b3);

		notLinkedResource.getContents().add(b1);
		linkTargetResource.getContents().add(b2);
		invalidLinkTargetResource.getContents().add(b3);
		linkSourceResource.getContents().add(c);
		linkSourceResource.getContents().add(e);

		getDefaultIndexStore().executeUpdateCommand(new UpdateCommand() {

			@Override
			public void execute(IndexUpdater updater, QueryExecutor queryExecutor) {
				ResourceIndexer indexer = new ResourceIndexer();
				indexer.resourceChanged(updater, notLinkedResource);
				indexer.resourceChanged(updater, linkTargetResource);
				indexer.resourceChanged(updater, invalidLinkTargetResource);
				indexer.resourceChanged(updater, linkSourceResource);
			}
		});

		// we are looking for C2->B2 but not E2->B
		URI referenceURI = EcoreUtil.getURI(Case002Package.Literals.C2__B);

		Set<URI> result1 = IndexQueryService.getLinkedPartitions(this.index, null, linkSourceResource.getURI(), referenceURI);
		assertFalse(result1.contains(notLinkedResource.getURI()));
		assertFalse(result1.contains(invalidLinkTargetResource.getURI()));
		assertTrue(result1.contains(linkTargetResource.getURI()));
		result1 = null;

		Set<URI> result2 = IndexQueryService.getLinkedPartitions(this.index, null, linkTargetResource.getURI(), referenceURI);
		assertFalse(result2.contains(notLinkedResource.getURI()));
		assertFalse(result2.contains(invalidLinkTargetResource.getURI()));
		assertFalse(result2.contains(linkSourceResource.getURI()));
		result2 = null;

		Set<URI> result3 = IndexQueryService.getLinkedPartitions(this.index, null, notLinkedResource.getURI(), referenceURI);
		assertFalse(result3.contains(linkSourceResource.getURI()));
		assertFalse(result3.contains(invalidLinkTargetResource.getURI()));
		assertFalse(result3.contains(linkTargetResource.getURI()));
		result3 = null;

		Set<URI> result4 = IndexQueryService.getLinkedPartitions(this.index, null, invalidLinkTargetResource.getURI(), referenceURI);
		assertFalse(result4.contains(notLinkedResource.getURI()));
		assertFalse(result4.contains(linkSourceResource.getURI()));
		assertFalse(result4.contains(linkTargetResource.getURI()));
		result4 = null;
	}
}
