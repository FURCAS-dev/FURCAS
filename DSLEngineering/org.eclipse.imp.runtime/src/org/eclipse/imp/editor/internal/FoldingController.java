/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 *******************************************************************************/

package org.eclipse.imp.editor.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.parser.IModelListener;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.IFoldingUpdater;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;

public class FoldingController implements IModelListener {
    private final ProjectionAnnotationModel fAnnotationModel;
    private final IFoldingUpdater fFoldingUpdater;

    public FoldingController(ProjectionAnnotationModel annotationModel, IFoldingUpdater foldingUpdater) {
        super();
        this.fAnnotationModel= annotationModel;
        this.fFoldingUpdater= foldingUpdater;
    }

    public AnalysisRequired getAnalysisRequired() {
        return AnalysisRequired.SYNTACTIC_ANALYSIS;
    }

    public void update(IParseController parseController, IProgressMonitor monitor) {
        if (fAnnotationModel != null) { // can be null if file is outside workspace
            try {
                fFoldingUpdater.updateFoldingStructure(parseController, fAnnotationModel);
            } catch (Exception e) {
                RuntimePlugin.getInstance().logException("Error while updating folding annotations for " + parseController.getPath(), e);
            }
        }
    }
}
