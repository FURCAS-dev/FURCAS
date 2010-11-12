/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ui.PlatformUI;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

/**
 * Validates a specific constraint on one or more of the context elements that are instance of the constaint's context class or a
 * subclass thereof.
 * <p>
 * 
 * There are {@link Diagnostic} objects maintained as {@link Resource#getErrors() errors} and {@link Resource#getWarnings()
 * warnings} of an EMF resource, and {@link IMarker} objects managed by {@link IResource}s and stored persistently in the
 * workspace, representing validation errors. {@link MarkerHelper} and its subclasses can turn {@link Diagnostic} objects into
 * {@link IMarker}s which form the basis for the problem view display. A {@link MarkerHelper} is used to create {@link IMarker
 * markers} from {@link Diagnostic} objects. Specializations of {@link MarkerHelper} can annotate the markers with additional
 * information stored, e.g., in {@link Diagnostic#getData()} and storing them in {@link IMarker#getAttribute(String) attributes}
 * of the marker. By default, this process is triggered in the <code>updateProblemIndication</code> method of a generated EMF
 * sample editor, where first all markers for the entire {@link ResourceSet} (this seems too broad a scope) are deleted and then
 * created again based on the {@link Diagnostic}s returned from {@link Resource#getErrors()} and {@link Resource#getWarnings()}
 * for the resources contained by the editing domain's resource set.
 * <p>
 * 
 * EMF resources, upon loading, don't perform any constraint validation. Therefore, their errors and warnings list turns out empty
 * by default. Filling those has to happen by explicitly performing a {@link ValidateAction} on selected resources or individual
 * elements. Only then will a {@link Diagnostician} be used to fetch the {@link EValidator} from the validator registry with which
 * a validation is performed on a single {@link EObject}. Such a validation run will produce {@link Diagnostic} objects which the
 * {@link ValidateAction} then converts into {@link IMarker}s again. Note that these {@link Diagnostic} objects are <em>not</em>
 * entered into the errors/warnings of the {@link Resource} on which the validation happened.
 * <p>
 * 
 * When a change {@link Notification} triggers this revalidation action, the constraint is re-evaluated on the context objects
 * determined by the {@link ImpactAnalyzer OCL Impact Analysis}. For any constraint which now evaluates to <code>true</code>, any
 * existing {@link Diagnostic} needs to be removed. FOr any constraint evaluating to <code>false</code> a {@link Diagnostic}
 * object needs to be created, and an {@link IMarker} needs to be created and displayed in the problem view.
 * <p>
 * 
 * During re-validation, the resources of other objects on which to evaluate the constraint may be loaded into the surrounding
 * editing domain's resource set. Markers are managed by a <code>MarkerManager</code> which persistently stores markers in the
 * workspace, keyed by the resources to which they belong.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class RevalidateAction extends ValidateAction {
    private static final String MARKER_TYPE = "org.eclipse.core.resources.problemmarker";
    private static final String ELEMENT_URI = "elementuri";
    private static final String CONSTRAINT_NAME = "constraintname";
    private final Collection<EObject> contextObjects;
    private final String constraintName;
    private final OCLExpression invariant;
    private final OppositeEndFinder oppositeEndFinder;

    public RevalidateAction(String constraintName, Collection<EObject> contextObjects, OCLExpression invariant, OppositeEndFinder oppositeEndFinder) {
        super();
        this.contextObjects = contextObjects;
        this.constraintName = constraintName;
        this.invariant = invariant;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    public void run() {
        IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() {
            public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
                try {
                    validateConstraints(progressMonitor);
                } catch (CoreException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        if (eclipseResourcesUtil != null) {
            runnableWithProgress = eclipseResourcesUtil.getWorkspaceModifyOperation(runnableWithProgress);
        }

        try {
            // This runs the operation, and shows progress.
            // (It appears to be a bad thing to fork this onto another thread.)
            //
            PlatformUI.getWorkbench().getProgressService().run(/* fork */ true, /* cancelable */ true, runnableWithProgress);
        } catch (Exception exception) {
            EMFEditUIPlugin.INSTANCE.log(exception);
        }
    }

    /**
     * This simply execute the command.
     */
    private void validateConstraints(IProgressMonitor progressMonitor) throws CoreException {
        int selectionSize = contextObjects.size();
        progressMonitor.beginTask("", selectionSize);
        OCL ocl = OCL.newInstance(oppositeEndFinder);
        for (EObject eObject : contextObjects) {
            System.out.println("Re-validating "+constraintName+" on "+EcoreUtil.getURI(eObject));
            IFile fileForContext = getFile(eObject);
            URI eObjectURI = EcoreUtil.getURI(eObject);
            removeMarker(eObjectURI, fileForContext);
            boolean valid = (Boolean) ocl.evaluate(eObject, invariant);
            if (!valid) {
                if (fileForContext != null) {
                    IMarker marker = fileForContext.createMarker(MARKER_TYPE);
                    // TODO here's the place to talk about severities of constraint violations
                    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
                    marker.setAttribute(IMarker.MESSAGE, "Constraint "+constraintName+" violated on "+eObject);
                    marker.setAttribute(CONSTRAINT_NAME, constraintName);
                    marker.setAttribute(ELEMENT_URI, eObjectURI.toString());
                }
            }
        }
    }

    private void removeMarker(URI eObjectURI, IFile fileForContext) throws CoreException {
        IMarker[] markers = fileForContext.findMarkers(MARKER_TYPE, /* includeSubtypes */ false, IResource.DEPTH_ZERO);
        if (markers != null) {
            for (IMarker marker : markers) {
                if (marker.getAttribute(CONSTRAINT_NAME, "").equals(constraintName) &&
                        marker.getAttribute(ELEMENT_URI, "").equals(eObjectURI.toString())) {
                    marker.delete();
                }
            }
        }
    }

    private IFile getFile(EObject eObject) {
        URI uri = EcoreUtil.getURI(eObject);
        String platformResourceString = uri.toPlatformString(true);
        return platformResourceString != null ? ResourcesPlugin.getWorkspace().getRoot()
                .getFile(new Path(platformResourceString)) : null;
    }

    protected String composeMessage(Diagnostic diagnostic, Diagnostic parentDiagnostic) {
        String message = diagnostic.getMessage();
        if (parentDiagnostic != null) {
            String parentMessage = parentDiagnostic.getMessage();
            if (parentMessage != null) {
                message = message != null ? parentMessage + ". " + message : parentMessage;
            }
        }
        return message;
    }

    protected void createMarkers(IResource resource, Diagnostic diagnostic, Diagnostic parentDiagnostic) throws CoreException {
        if (resource != null && resource.exists()) {
            IMarker marker = resource.createMarker(MARKER_TYPE);
            int severity = diagnostic.getSeverity();
            if (severity < Diagnostic.WARNING) {
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
            } else if (severity < Diagnostic.ERROR) {
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
            } else {
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
            }

            String message = composeMessage(diagnostic, parentDiagnostic);
            if (message != null) {
                marker.setAttribute(IMarker.MESSAGE, message);
            }
        }
    }
    
}
