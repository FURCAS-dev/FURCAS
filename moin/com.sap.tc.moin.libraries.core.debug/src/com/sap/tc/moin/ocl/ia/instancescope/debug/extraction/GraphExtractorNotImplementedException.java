package com.sap.tc.moin.ocl.ia.instancescope.debug.extraction;

public class GraphExtractorNotImplementedException extends RuntimeException{
    private static final long serialVersionUID = 1803592272690878386L;

    public GraphExtractorNotImplementedException(String type) {
	super("Extractor for NavigationStep of Type " + type + "not implemented");
    }
}
