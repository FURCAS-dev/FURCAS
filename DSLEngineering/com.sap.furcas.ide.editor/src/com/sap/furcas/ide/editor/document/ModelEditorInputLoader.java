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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;

/**
 * Helper class that transforms a {@link IEditorInput} into a {@link ModelEditorInput}
 * 
 * @author Stephan Erb
 *
 */
public class ModelEditorInputLoader {

    private final ResourceSet resourceSet;
    private final OppositeEndFinder oppositeEndFinder;
    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private final ConcreteSyntax syntax;

    public ModelEditorInputLoader(ConcreteSyntax syntax, ResourceSet resourceSet, OppositeEndFinder oppositeEndFinder, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        this.syntax = syntax;
        this.resourceSet = resourceSet;
        this.oppositeEndFinder = oppositeEndFinder;
        this.parserFactory = parserFactory;
    }

    /**
     * Transform the given editor input to a {@link ModelEditorInput}.
     */
    public ModelEditorInput loadEditorInput(IEditorInput input) throws PartInitException {
        if (!(input instanceof FileEditorInput)) {
            throw new PartInitException("Cannot load editor input " + input.getName() + ". Unsupported input format "
                    + input.getClass().getCanonicalName() + ".");
        }

        IFile file = ((FileEditorInput) input).getFile();
        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), /*encode*/ true);
        
        Resource resource = resourceSet.getResource(uri, /*load*/ true);
        validateResource(resource);

        EObject root = resource.getContents().iterator().next();
        TextBlock rootBlock = findOrCreateRootBlockForRootObject(root);
        ModelEditorInput modelInput = new ModelEditorInput(file, root, rootBlock);
                
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

    /**
     * Get a corresponding root TextBlock for the given rootObject.
     * If no TextBlock does exist yet, a new one is created.
     */
    private TextBlock findOrCreateRootBlockForRootObject(EObject rootObject) throws PartInitException {
        ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);

        TextBlock rootBlock = findRootBlockForRootObject(rootObject, rootTemplate);
        if (rootBlock == null) {
            // no suitable node found, so create a new one
            try {
                TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(parserFactory);
                IMetaModelLookup<EObject> metamodelLookup = new QueryBasedEcoreMetaModelLookUp(resourceSet, parserFactory.getMetamodelURIs());
                PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, metamodelLookup);
                prettyPrinter.prettyPrint(rootObject, target);
                return target.getPrintedResultRootBlock();
           } catch (SyntaxAndModelMismatchException e) {
                throw new PartInitException("Model does not (fully) conform to syntax " + syntax.getName() + ": \n\n" + e.getCause().getMessage(), e);
            }
        }
        return rootBlock;
    }

    private TextBlock findRootBlockForRootObject(EObject rootObject, ClassTemplate rootTemplate) throws PartInitException {
        Collection<EObject> nodes = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                TextblocksPackage.eINSTANCE.getTextBlock_CorrespondingModelElements(), rootObject);

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
