package com.sap.furcas.ide.dslproject.builder;

import org.antlr.tool.Message;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.ParsingError;

/**
 * Handles occuring errors by adding eclipse marker to the grammar file.
 */
public class ResourceMarkingGenerationErrorHandler implements GenerationErrorHandler {

    private final IResource resource;

    public ResourceMarkingGenerationErrorHandler(IResource resource) {
        this.resource = resource;
    }

    @Override
    public void error(ParsingError exception) {
        EclipseMarkerUtil.addMarker(resource, exception, IMarker.SEVERITY_ERROR);
    }

    @Override
    public void fatalError(ParsingError exception) {
        EclipseMarkerUtil.addMarker(resource, exception, IMarker.SEVERITY_ERROR);
    }

    @Override
    public void warning(ParsingError exception) {
        EclipseMarkerUtil.addMarker(resource, exception, IMarker.SEVERITY_WARNING);
    }

    @Override
    public void error(Message err) {
        EclipseMarkerUtil.addMarker(resource, err.toString(), err.line, IMarker.SEVERITY_ERROR);
    }

    @Override
    public void warn(Message warn) {
        EclipseMarkerUtil.addMarker(resource, warn.toString(), warn.line, IMarker.SEVERITY_WARNING);
    }

    @Override
    public void info(String info) {
        EclipseMarkerUtil.addMarker(resource, info, 0, IMarker.SEVERITY_INFO);
    }
}
