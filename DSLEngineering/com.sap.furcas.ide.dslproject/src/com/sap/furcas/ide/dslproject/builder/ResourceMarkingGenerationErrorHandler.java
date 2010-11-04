package com.sap.furcas.ide.dslproject.builder;

import org.antlr.tool.Message;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.ParsingError;

/**
 * Handles occuring errors by adding eclipse marker to the grammar file.
 */
public class ResourceMarkingGenerationErrorHandler implements GenerationErrorHandler {

    /** The file. */
    private final IFile file;

    /**
     * Instantiates a new grammar generation error handler.
     * 
     * @param file
     *            the file
     */
    public ResourceMarkingGenerationErrorHandler(IFile file) {
        this.file = file;
    }

    @Override
    public void error(ParsingError exception) {
        EclipseMarkerUtil.addMarker(file, exception, IMarker.SEVERITY_ERROR);
    }

    @Override
    public void fatalError(ParsingError exception) {
        EclipseMarkerUtil.addMarker(file, exception, IMarker.SEVERITY_ERROR);
    }

    @Override
    public void warning(ParsingError exception) {
        EclipseMarkerUtil.addMarker(file, exception, IMarker.SEVERITY_WARNING);
    }

    @Override
    public void error(Message err) {
        EclipseMarkerUtil.addMarker(file, err.toString(), err.line, IMarker.SEVERITY_ERROR);
    }

    @Override
    public void warn(Message warn) {
        EclipseMarkerUtil.addMarker(file, warn.toString(), warn.line, IMarker.SEVERITY_WARNING);
    }

    @Override
    public void info(String info) {
        EclipseMarkerUtil.addMarker(file, info, 0, IMarker.SEVERITY_INFO);
    }
}
