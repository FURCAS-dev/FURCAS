/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.dialogs.SelectEObjectDialog;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

/**
 * Helper class that transforms a {@link IEditorInput} into a {@link ModelEditorInput}
 * by selecting and loading the correct root object and its corresponding root textblock.
 * 
 * @author Stephan Erb
 *
 */
public class ModelEditorInputLoader {

    private final ResourceSet resourceSet;
    private final OppositeEndFinder oppositeEndFinder;
    private final ConcreteSyntax syntax;
    private final AdapterFactory adapterFactory;

    public ModelEditorInputLoader(ConcreteSyntax syntax, ResourceSet resourceSet, AdapterFactory adapterFactory) {
        this.syntax = syntax;
        this.resourceSet = resourceSet;
        this.adapterFactory = adapterFactory;
        
        // create an opposite end finder that knows about the static resources in the workspace
        // It is required to find potential textblocks
        this.oppositeEndFinder = Query2OppositeEndFinder.getInstance();
    }

    /**
     * Transform the given editor input to a {@link ModelEditorInput}.
     */
    public ModelEditorInput loadEditorInput(IEditorInput input) throws PartInitException {
        EObject rootElement = null;
        if (input instanceof FileEditorInput) {
            // user clicked on a resource within the workspace. Need to find a element
            // matching the syntax of the editor within this resource
            
            IFile file = ((FileEditorInput) input).getFile();
            URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), /*encode*/ true);
            Resource resource = resourceSet.getResource(uri, /*load*/ true);
            validateResource(resource);
            
            rootElement = findElementWithinResource(resource);
            
        } else if (input instanceof URIEditorInput){
            // editor is auto-restored on IDE startup. See ModelEditorInput transformes input
            // into URIEditorInput and that one has factory for restore.
            
            URI uri = ((URIEditorInput) input).getURI();
            rootElement = resourceSet.getEObject(uri, /*load*/ true);
            
        } else {
            throw new PartInitException("Cannot load editor input " + input.getName() + ". Unsupported input format "
                    + input.getClass().getCanonicalName() + ".");
        }
        if (rootElement == null) {
            throw new PartInitException("Editor input is empty.");
        }

        TextBlock rootBlock = findRootBlockForRootObject(rootElement);
        return new ModelEditorInput(rootElement, rootBlock);
    }

    private EObject findElementWithinResource(Resource resource) {
        Class<?> classOfRootObject = TcsUtil.getMainClassTemplate(syntax).getMetaReference().getInstanceClass();
        
        if (resource.getContents().size() == 0) {
            return null;
            
        } else if (resource.getContents().size() == 1 && classOfRootObject != null &&  classOfRootObject.isAssignableFrom(
                resource.getContents().iterator().next().getClass())) {
            // resource root element is what we are looking for.
            return resource.getContents().iterator().next();
            
        } else {
            // open dialog and let the user select the desired element.
            // only show elements which match the main template of the syntax
            // or show all elements if instance class of main template could not be found
            ArrayList<Class<?>> filterList = new ArrayList<Class<?>>();
            if (classOfRootObject == null) {
                filterList.add(EcoreFactory.eINSTANCE.createEObject().getClass());  
            } else {
                filterList.add(classOfRootObject);   
            }

            SelectEObjectDialog diag = new SelectEObjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    resource, filterList, adapterFactory);
            diag.open();
            
            return diag.getResult();
        }
        
    }

    private void validateResource(Resource resource) throws PartInitException {
        if (resource.getErrors().size() > 0) {
            StringBuilder message = new StringBuilder();
            message.append("Could not load resource: " + resource.getURI().toFileString());
            for (Diagnostic diagnostic : resource.getErrors()) {
                message.append("\n").append(diagnostic.getMessage());
            }
            throw new PartInitException(message.toString());
        }
    }

    private TextBlock findRootBlockForRootObject(EObject rootObject) throws PartInitException {
        Collection<EObject> nodes = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                TextblocksPackage.eINSTANCE.getTextBlock_CorrespondingModelElements(), rootObject);

        if (nodes == null) {
            return null;
        }
        ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);
        // find all potential, existing roots.
        Collection<TextBlock> rootBlocks = new HashSet<TextBlock>();
        Collection<TextBlock> rootBlocksWithBrokenMapping = new HashSet<TextBlock>();

        for (EObject object : nodes) {
            if (object instanceof TextBlock) {
                TextBlock block = (TextBlock) object;
                if (!TbNavigationUtil.isUltraRoot(block)) {
                    continue;
                }
                if (block.getVersion() != Version.REFERENCE) {
                    continue;
                }
                // type can only be checked if mapping is not broken
                if (TbUtil.isTextBlockOfType(rootTemplate, block)) {
                    rootBlocks.add(block);
                } else if (block.getType() == null) {
                    rootBlocksWithBrokenMapping.add(block);
                }
            }
        }
        return selectBlockFromResults(rootObject, rootBlocks, rootBlocksWithBrokenMapping);
    }

    /**
     * TODO: We can relax this in the future.  For now we want to crash early
     * in order to find as many bugs as possible.
     */
    private TextBlock selectBlockFromResults(EObject rootObject, Collection<TextBlock> rootBlocks, Collection<TextBlock> rootBlocksWithBrokenMapping) throws PartInitException {
        if (rootBlocks.size() == 0 && rootBlocksWithBrokenMapping.size() == 0) {
            return null;
        }
        if (rootBlocks.size() == 1 && rootBlocksWithBrokenMapping.size() == 0) {
            return rootBlocks.iterator().next();
        }
        if (rootBlocks.size() == 0 && rootBlocksWithBrokenMapping.size() == 1) {
            return rootBlocksWithBrokenMapping.iterator().next();
        }
        IStatus status = new Status(IStatus.WARNING, CtsActivator.PLUGIN_ID, "Unable to open editor without user intervention: "
                + "Found several TextBlocks for " + rootObject + " . Cannot defer which one is the desired one.");
        throw new PartInitException(status);
    }

}
