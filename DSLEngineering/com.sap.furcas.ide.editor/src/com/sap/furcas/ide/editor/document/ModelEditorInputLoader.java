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

import java.util.Collection;
import java.util.HashSet;

import org.antlr.runtime.Lexer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;

/**
 * @author Stephan Erb
 *
 */
public class ModelEditorInputLoader {

    private final EditingDomain editingDomain;
    private final ConcreteSyntax syntax;
    private final OppositeEndFinder oppositeEndFinder;
    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;

    public ModelEditorInputLoader(ConcreteSyntax syntax, EditingDomain editingDomain, OppositeEndFinder oppositeEndFinder, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        this.syntax = syntax;
        this.editingDomain = editingDomain;
        this.oppositeEndFinder = oppositeEndFinder;
        this.parserFactory = parserFactory;
    }

    /**
     * Transform the given editor input to a {@link ModelEditorInput}.
     * Resources are loaded directly into the {@link EditingDomain}.   
     */
    public ModelEditorInput loadEditorInput(IEditorInput input) throws PartInitException {
        if (!(input instanceof FileEditorInput)) {
            throw new PartInitException("Cannot load editor input " + input.getName() + ". Unsupported input format "
                    + input.getClass().getCanonicalName() + ".");
        }

        IFile file = ((FileEditorInput) input).getFile();
        IPath path = ((FileEditorInput) input).getPath();

        Resource resource = editingDomain.loadResource(URI.createFileURI(path.toOSString()).toString());
        validateResource(resource);

        ModelEditorInput modelInput;
        EObject root = resource.getContents().iterator().next();
        if (root instanceof TextBlock) {
            modelInput = createFromRootBlock(file, root);
        } else {
            modelInput = createFromRootObject(file, root);
        }
        
        assert modelInput.getRootBlock() != null;
        assert modelInput.getRootObject() != null;
        
        return modelInput;
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

    private ModelEditorInput createFromRootBlock(IFile file, EObject root) throws PartInitException {
        TextBlock rootBlock = (TextBlock) root;
        EObject rootObject = rootBlock.getCorrespondingModelElements().iterator().next();
        if (rootObject == null) {
            throw new PartInitException(
                    "The given TextBlocks Model is invalid. The root blocks has no corresponding model element.");
        }
        return new ModelEditorInput(file, rootObject, rootBlock);
    }

    private ModelEditorInput createFromRootObject(IFile file, EObject rootObject) throws PartInitException {
        TextBlock rootBlock = findOrCreateRootBlockForRootObject(rootObject);
        return new ModelEditorInput(file, rootObject, rootBlock);
    }

    /**
     * Get a corresponding root TextBlock for the given rootObject.
     * If no TextBlock does exist yet, a new one is created.
     */
    private TextBlock findOrCreateRootBlockForRootObject(EObject rootObject) throws PartInitException {
        ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);

        TextBlock rootBlock = findRootBlockForRootObject(rootObject, rootTemplate);
        if (rootBlock == null) {
            // no suitable node found, so create a new one
            rootBlock = TbModelInitializationUtil.initilizeTextBlocksFromModel(rootObject, syntax, editingDomain, parserFactory);
        }
        return rootBlock;
    }

    private TextBlock findRootBlockForRootObject(EObject rootObject, ClassTemplate rootTemplate) throws PartInitException {
        Collection<EObject> nodes = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), rootObject);

        if (nodes == null) {
            return null;
        }
        // find all potential, existing roots.
        Collection<TextBlock> rootBlocks = new HashSet<TextBlock>();
        Collection<TextBlock> rootBlocksWithBrokenMapping = new HashSet<TextBlock>();

        for (EObject object : nodes) {
            if (object instanceof TextBlock) {
                TextBlock block = (TextBlock) object;
                if (!TbNavigationUtil.isUltraRoot(block)) {
                    continue;
                }
                block = (TextBlock) TbUtil.getNewestVersion(block);
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
     * TODO: We can relax this in the future. 
     * For now we want to crash early in order to find as many bugs as possible.
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
                + "Found several TextBlocks for " + rootObject + " . Cannot defer which one is the desired one."
                + "You have to manually open the editor on the desired TextBlocks model.");
        throw new PartInitException(status);
    }


}
