package com.sap.furcas.ide.dslproject.builder;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.runtime.parser.impl.ParsingError;


public class EclipseMarkerUtil {

    /** used for setting and deleting error markers. */
    private static String DSL_SYNTAX_ERROR_MARKER_TYPE = Activator.class.getPackage().getName() + ".dslProblem";

    private static EclipseMarkerUtil singleton = new EclipseMarkerUtil();

    /**
     * Adds the marker.
     * 
     * @param file
     *            the file
     * @param message
     *            the message
     * @param lineNumber
     *            the line number
     * @param severity
     *            the severity
     */
    public static void addMarker(IResource file, String message, int lineNumber, int severity) {
	try {
	    IMarker marker = file.createMarker(DSL_SYNTAX_ERROR_MARKER_TYPE);
	    marker.setAttribute(IMarker.MESSAGE, message);
	    marker.setAttribute(IMarker.SEVERITY, severity);
	    if (lineNumber == -1) {
		lineNumber = 1;
	    }
	    marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
	} catch (CoreException e) {
	    Activator.logger.logError("Failed to add marker to " + file, e);
	}
    }

    /**
     * Adds the marker.
     * 
     * @param file
     *            the file
     * @param message
     *            the message
     * @param lineNumber
     *            the line number
     * @param severity
     *            the severity
     */
    public static void addMarker(IResource file, ParsingError error, int severity) {
	try {
	    IMarker marker = file.createMarker(DSL_SYNTAX_ERROR_MARKER_TYPE);
	    marker.setAttribute(IMarker.MESSAGE, error.getMessage());
	    marker.setAttribute(IMarker.SEVERITY, severity);
	    int lineNumber = error.getLine();

	    if (error.getIndex() <= -1) {
		marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		marker.setAttribute(IMarker.LOCATION, error.getLocation().toString());
	    } else {
		marker.setAttribute(IMarker.CHAR_START, error.getIndex());
		marker.setAttribute(IMarker.CHAR_END, error.getStopIndex());
	    }

	} catch (CoreException e) {
	    Activator.logger.logError("Failed to add marker to " + file, e);
	}
    }

    /**
     * Delete markers.
     * 
     * @param file
     *            the file
     */
    public static void deleteMarkers(IResource file) {
	try {
	    file.deleteMarkers(DSL_SYNTAX_ERROR_MARKER_TYPE, false, IResource.DEPTH_ZERO);
	} catch (CoreException ce) {
	    Activator.logger.logError("Failed to delete marker from " + file, ce);
	}
    }

    public static void deleteAllSyntaxMarkers(final IProject project, Shell shell) {
	try {
	    ProgressMonitorDialog monitorDialog = new ProgressMonitorDialog(shell);
	    monitorDialog.run(true, true, new IRunnableWithProgress() {
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		    try {
			project.accept(singleton.new TCSDeleteMarkersVisitor(monitor));
		    } catch (CoreException e) {
			Activator.logger.logError("Failed to delete markers in " + project, e);
		    }
		}
	    });
	} catch (InterruptedException e) {
	    Activator.logger.logError("Deleting markers was interrupted", e);
	} catch (InvocationTargetException e) {
	    Activator.logger.logError("Failed to delete markers in " + project, e);
	}
    }

    /**
     * The Class TCSProjectResourceVisitor.
     */
    class TCSDeleteMarkersVisitor implements IResourceVisitor {

	/** The mymonitor. */
	private final IProgressMonitor mymonitor;

	/**
	 * Instantiates a new tCS project resource visitor.
	 * 
	 * @param monitor
	 *            the monitor
	 */
	public TCSDeleteMarkersVisitor(IProgressMonitor monitor) {
	    mymonitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core
	 * .resources.IResource)
	 */
	@Override
	public boolean visit(IResource resource) {
	    deleteMarkers(resource);
	    mymonitor.worked(IProgressMonitor.UNKNOWN);
	    // return true to continue visiting children.
	    return true;
	}
    }

}
