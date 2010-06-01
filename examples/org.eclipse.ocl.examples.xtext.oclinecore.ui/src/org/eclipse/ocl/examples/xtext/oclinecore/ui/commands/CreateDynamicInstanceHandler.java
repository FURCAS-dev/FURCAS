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
 * $Id: CreateDynamicInstanceHandler.java,v 1.2 2010/06/01 19:45:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.DynamicModelWizard;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Create a dynamic instance of an {@link EClass}.
 */
public class CreateDynamicInstanceHandler extends AbstractHandler
// Based on org.eclipse.emf.ecore.action.CreateDynamicInstanceAction
{

	protected static final URI PLATFORM_RESOURCE = URI
		.createPlatformResourceURI("/", false);


	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection)) {
			return null;
		}
		Object element = ((IStructuredSelection) currentSelection).getFirstElement();
		if (!(element instanceof ContentOutlineNode)) {
			return null;
		}
		IEObjectHandle<EObject> handle = ((ContentOutlineNode) element).getEObjectHandle();
		handle.readOnly(new IUnitOfWork.Void<EObject>() {
			@Override
			public void process(EObject oclInEcoreObject) {
				OCLinEcoreClassCS oclInEcoreClass = (OCLinEcoreClassCS) oclInEcoreObject;
				URI resourceURI = oclInEcoreClass.eResource().getURI().trimFragment();
				ResourceSet localResourceSet = new ResourceSetImpl();
				Resource ecoreResource = localResourceSet.getResource(resourceURI, true);
				EClassifier eClassifier = findClassifier(ecoreResource, oclInEcoreClass);
				if (!(eClassifier instanceof EClass)) {
					return;
				}
				EClass eClass = (EClass) eClassifier;
				URI uri = eClass.eResource().getURI();
				IStructuredSelection selection = StructuredSelection.EMPTY;
				if (uri.isHierarchical()) {
					if (uri.isRelative()
						|| (uri = uri.deresolve(PLATFORM_RESOURCE)).isRelative()) {
						IFile file = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new Path(uri.toString()));
						if (file.exists()) {
							selection = new StructuredSelection(file);
						}
					}
				}
				DynamicModelWizard dynamicModelWizard = new DynamicModelWizard(eClass);
				dynamicModelWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog wizardDialog = new WizardDialog(PlatformUI
					.getWorkbench().getActiveWorkbenchWindow().getShell(),
					dynamicModelWizard);
				wizardDialog.open();
			}
		});
		return null;
	}


	private EClassifier findClassifier(Resource resource, ClassifierCS csClass) {
		EPackage ePackage = findPackage(resource, (PackageCS)csClass.eContainer());
		return ePackage != null? ePackage.getEClassifier(csClass.getName()) : null;
	}


	private EPackage findPackage(Resource resource, PackageCS csPackage) {
		String name = csPackage.getName();
		EObject eContainer = csPackage.eContainer();
		if (eContainer instanceof DocumentCS) {
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage)eObject;
					if (name.equals(ePackage.getName())) {
						return ePackage;
					}
				}
			}
			return null;
		}
		else if (eContainer instanceof PackageCS) {
			EPackage ePackage = findPackage(resource, (PackageCS)eContainer);
			if (ePackage == null) {
				return null;
			}
			return EcoreUtils.getNamedElement(ePackage.getESubpackages(), name);
		}
		return null;
	}
}
