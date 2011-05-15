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
 * $Id: OCLstdlibRenameStrategy.java,v 1.1 2011/05/15 20:23:13 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringStatusException;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * Encapsulates the model changes of a rename refactoring.
 */
@SuppressWarnings("restriction")
public class OCLstdlibRenameStrategy extends AbstractRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider
	{		
		@Inject
		private ILocationInFileProvider locationProvider;
 
		public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) {
			if (targetEObject instanceof NamedElement)
				return new OCLstdlibRenameStrategy(renameElementContext, (NamedElement) targetEObject, locationProvider);
			else 
				return null;
		}
	}

	private XtextEditor editor;
	private URI contextResourceURI;
	private ILocationInFileProvider locationProvider;

	protected OCLstdlibRenameStrategy(IRenameElementContext renameElementContext, NamedElement targetEObject, ILocationInFileProvider locationProvider) {
		super(targetEObject);
		this.contextResourceURI = renameElementContext.getContextResourceURI();
		this.editor = (XtextEditor) renameElementContext.getTriggeringEditor();
		this.locationProvider = locationProvider;
	}
	public void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor) {
		applyDeclarationChange(newName, resourceSet);
		Resource targetResource = resourceSet.getResource(targetElementOriginalURI.trimFragment(), false);
		EObject targetElement = resourceSet.getEObject(targetElementOriginalURI, false);
		IXtextDocument document = editor.getDocument();
		ITextRegion textRegion = locationProvider.getSignificantTextRegion(targetElement);
		ReplaceEdit textEdit = new ReplaceEdit(textRegion.getOffset(), textRegion.getLength(), newName);
		updateAcceptor.accept(contextResourceURI, textEdit);
	}

	@Override
	protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
		EObject targetElement = resourceSet.getEObject(targetElementURI, false);
		if (targetElement == null) {
			throw new RefactoringStatusException("Target element not loaded.", true);
		}
		if (targetElement instanceof NamedElement) {
			((NamedElement) targetElement).setName(newName);
			return targetElement;
		}
		EAttribute nameAttribute = getNameAttribute(targetElement);
		targetElement.eSet(nameAttribute, newName);
		return targetElement;
	}

	@Override
	protected EAttribute getNameAttribute(EObject eObject) {
		if (eObject instanceof NamedElement) {
			return PivotPackage.Literals.NAMED_ELEMENT__NAME;
		}
		return super.getNameAttribute(eObject);
	}
}
