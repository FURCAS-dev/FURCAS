/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TestPrettyPrinter.java,v 1.5 2011/05/13 19:16:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintNameVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintTypeVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

public class TestPrettyPrinter extends XtextTestCase
{
	public void testDeclarations() throws Exception {
		URI libraryURI = getProjectFileURI("OCL-2.3.oclstdlib");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
		adapter.refreshPivotMappings(null);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
		for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof NamedElement) {
				String s = PrettyPrintNameVisitor.prettyPrint((Element) eObject, null);
				System.out.println(eObject.eClass().getName() + " : " + s);
			}
		}
	}
	
	public void testSignatures() throws Exception {
		URI libraryURI = getProjectFileURI("OCL-2.3.oclstdlib");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
		adapter.refreshPivotMappings(null);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
		for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof NamedElement) {
				String s = PrettyPrintTypeVisitor.prettyPrint((Element) eObject, null);
				System.out.println(eObject.eClass().getName() + " : " + s);
			}
		}
	}
}
