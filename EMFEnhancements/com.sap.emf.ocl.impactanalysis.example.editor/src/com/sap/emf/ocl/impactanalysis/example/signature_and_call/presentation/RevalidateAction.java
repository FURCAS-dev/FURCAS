package com.sap.emf.ocl.impactanalysis.example.signature_and_call.presentation;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ui.PlatformUI;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

/**
 * Validates a specific constraint on one or more of the context elements that are instance of the constaint's context class
 * or a subclass thereof.
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
        OCL ocl = OCLWithHiddenOpposites.newInstance(oppositeEndFinder);
        for (EObject eObject : contextObjects) {
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
