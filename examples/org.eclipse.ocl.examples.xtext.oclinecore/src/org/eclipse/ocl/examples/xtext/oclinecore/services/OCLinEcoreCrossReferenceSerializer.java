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
 * $Id: OCLinEcoreCrossReferenceSerializer.java,v 1.1 2010/04/13 06:44:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCrossReferenceSerializer;

public class OCLinEcoreCrossReferenceSerializer extends DefaultCrossReferenceSerializer
{
//	private final SimpleAttributeResolver<EObject, String> aliasResolver;

	public OCLinEcoreCrossReferenceSerializer() {
		super();
//		aliasResolver = SimpleAttributeResolver.newResolver(String.class, "alias");
	}

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if ((reference == OCLinEcoreCSTPackage.Literals.IMPORT_CS__EPACKAGE) && (context instanceof ImportCS))
			return ((EPackage) object).getNsURI();
		if ((reference == OCLinEcoreCSTPackage.Literals.ECLASSIFIER_CS_REF__REF) && (context instanceof EClassifierCSRef))
			return ((EClassifier) object).getName();
		if ((reference == OCLinEcoreCSTPackage.Literals.REFERENCE_CS_REF__REF) && (context instanceof ReferenceCSRef))
			return ((ReferenceCS) object).getName();
		return super.getUnconvertedLinkText(object, reference, context);
	}

}
