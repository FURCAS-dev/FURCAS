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
package com.sap.furcas.metamodel.texteditor.editor; 

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.ide.dslproject.builder.SyntaxGenerationNature;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.ide.editor.document.ModelEditorInput;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;
import com.sap.furcas.metamodel.texteditor.Activator;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public class TCSEditor extends AbstractFurcasEditor { 

    public TCSEditor() {
        super(new TCSParserFactory());
    }
    
    @Override
    protected IncrementalParserFacade createParserFacade(ModelEditorInput modelEditorInput, PartitionAssignmentHandler partitionHandler) {
        parserFactory.getAdditionalQueryScope().addAll(getReferencedMetamodels(modelEditorInput));
        return super.createParserFacade(modelEditorInput, partitionHandler);
    }

    private Set<URI>  getReferencedMetamodels(ModelEditorInput modelEditorInput) {
        URI uri = EcoreUtil.getURI(modelEditorInput.getRootObject());
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
        
        SyntaxGenerationNature nature = SyntaxGenerationNature.getNatureFromProject(project);
        IProjectMetaRefConf conf = nature.getMetaModelReferenceConf();
        try {
            return conf.getMetaLookUpForProject().getReferenceScope();
        } catch (CoreException e) {
            Activator.getDefault().getLogger().logError("Failed to load referenced metamodels of Syntax", e);
            return Collections.emptySet();
        }
    }
}
