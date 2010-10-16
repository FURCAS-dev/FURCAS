package com.sap.furcas.parsergenerator.tcs.generator.errorhandling;

import org.antlr.tool.Message;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;


/**
 * handles occuring errors by adding eclipse marker to the grammar file.
 */
public class GenerationErrorHandler {

	
	/** The file. */
	private final IFile file;

	/**
	 * Instantiates a new grammar generation error handler.
	 * 
	 * @param file the file
	 */
	public GenerationErrorHandler(IFile file) {
		this.file = file;
	}

	/**
	 * Adds the marker.
	 * 
	 * @param e the e
	 * @param severity the severity
	 */
	private void addMarker(LocalisedSyntaxParsingException e, int severity) {
		EclipseMarkerUtil.addMarker(file, e.getMessage(), e.getLineNumber(), severity);
	}

	/**
	 * Error.
	 * 
	 * @param exception the exception
	 */
	public void error(LocalisedSyntaxParsingException exception)  {
		addMarker(exception, IMarker.SEVERITY_ERROR);
	}

	/**
	 * Fatal error.
	 * 
	 * @param exception the exception
	 */
	public void fatalError(LocalisedSyntaxParsingException exception) {
		addMarker(exception, IMarker.SEVERITY_ERROR);
	}

	/**
	 * Warning.
	 * 
	 * @param exception the exception
	 */
	public void warning(LocalisedSyntaxParsingException exception) {
		addMarker(exception, IMarker.SEVERITY_WARNING);
	}
	



    /**
     * for antlr errors
     * @param arg0
     */
    public void error(Message err) {
    	EclipseMarkerUtil.addMarker(file, err.toString(), err.line,  IMarker.SEVERITY_ERROR);
    }

    /**
     * @param arg0
     */
    public void warn(Message warn) {
    	EclipseMarkerUtil.addMarker(file, warn.toString(), warn.line,  IMarker.SEVERITY_WARNING);
    }

    /**
     * @param arg0
     */
    public void info(String info) {
    
    	EclipseMarkerUtil.addMarker(file, info, 0, IMarker.SEVERITY_INFO);
    }
}

