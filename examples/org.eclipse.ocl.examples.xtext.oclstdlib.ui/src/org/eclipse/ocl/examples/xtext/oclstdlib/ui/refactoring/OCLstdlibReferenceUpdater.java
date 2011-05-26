/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: OCLstdlibReferenceUpdater.java,v 1.1 2011/05/15 20:23:13 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.refactoring;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;


@SuppressWarnings("restriction")
public class OCLstdlibReferenceUpdater extends DefaultReferenceUpdater
{
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	/*	@Override
	protected void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Updating EMF References", resource2references.keySet()
				.size());
		for (URI referringResourceURI : resource2references.keySet()) {
			try {
				if (progress.isCanceled())
					break;
				Resource referringResource = resourceSet.getResource(referringResourceURI, false);

//				Resource targetResource = resourceSet.getResource(targetElementOriginalURI.trimFragment(), false);
//				IRefactoringDocument document = updateAcceptor.getDocument(targetResource.getURI());
//				updateAcceptor.accept(targetElementOriginalURI, new ReplaceEdit(0, document.getOriginalContents().length(),
//					newName));
				
				
				//				changeUtil.addSaveAsUpdate(referringResource, updateAcceptor);
				progress.worked(1);
			} catch (Exception exc) {
				throw new WrappedException(exc);
			}
		}
	} */

	@Override
	protected void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Creating reference updates", resource2references.keySet().size());
		for (URI referringResourceURI : resource2references.keySet()) {
			if (progress.isCanceled())
				return;
//			Resource referringResource = resourceSet.getResource(referringResourceURI, false);
//			if (!(referringResource instanceof XtextResource)) {
//				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI)
//						+ " is not an XtextResource", true);
//			}
//			((XtextResource) referringResource).getCache().clear(referringResource);
			for (IReferenceDescription referenceDescription : resource2references.get(referringResourceURI)) {
				createReferenceUpdate(referenceDescription, referringResourceURI, elementRenameArguments, resourceSet, updateAcceptor);
			}
			progress.worked(1);
		}
	}

	@Override
	protected void createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
//		if (!transientValueService.isTransient(referringElement, reference, indexInList)) {
			ITextRegion referenceTextRegion = locationInFileProvider.getSignificantTextRegion(referringElement, reference, indexInList);
//			CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
//			if (crossReference != null) {
//				String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement, crossReference,
//						newTargetElement, null);
				// TODO: add import hook
				TextEdit referenceEdit = new ReplaceEdit(referenceTextRegion.getOffset(),
						referenceTextRegion.getLength(), ((NamedElement)newTargetElement).getName());
				updateAcceptor.accept(referringResourceURI, referenceEdit);
//			}
//		}
	}

}
