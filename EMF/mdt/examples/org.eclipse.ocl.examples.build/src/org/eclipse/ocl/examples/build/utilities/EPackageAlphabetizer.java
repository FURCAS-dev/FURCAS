/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EPackageAlphabetizer.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Alphabeticizes a designated <tt>modelSlot</tt> so that primitive types
 * appear before enumerations before classes before associations, each
 * in alphabetical order.
 */
public class EPackageAlphabetizer extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());	

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Alphabeticizing '" + resource.getURI() + "'");
		List<List<? extends ENamedElement>> listOfLists = new ArrayList<List<? extends ENamedElement>>();
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof EPackage) {
				EPackage package_ = (EPackage) eObject;
				listOfLists.add(package_.getESubpackages());
				listOfLists.add(package_.getEClassifiers());
			}
		}
		for (List<? extends ENamedElement> list : listOfLists) {
			sortList(list);
		}
	}

	protected <T extends ENamedElement> void sortList(List<T> list) {
		List<T> newList = new ArrayList<T>(list);
		Collections.sort(newList, new Comparator<T>()
		{
			public int compare(T o1, T o2) {
				EClass e1 = o1.eClass();
				EClass e2 = o2.eClass();
				if (e1 != e2) {
					if (EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(e2)) {
						return 1;
					}
					if (EcorePackage.Literals.EENUM.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (EcorePackage.Literals.EENUM.isSuperTypeOf(e2)) {
						return 1;
					}
					if (EcorePackage.Literals.ECLASS.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (EcorePackage.Literals.ECLASS.isSuperTypeOf(e2)) {
						return 1;
					}
				}
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		list.clear();
		list.addAll(newList);
	}
}
