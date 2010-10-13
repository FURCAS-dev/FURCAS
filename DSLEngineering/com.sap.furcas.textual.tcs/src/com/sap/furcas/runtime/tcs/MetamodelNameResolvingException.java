/**
 * 
 */
package com.sap.furcas.runtime.tcs;

import com.sap.furcas.runtime.common.exceptions.AbstractToolGenerationException;


/**
 * To be thrown when a qualified name could not be resolved to a metamodel element.
 * Ideally this should be cuaght soon and changed into a Syntaxparsing exception pointing
 * to the "offending" element of the syntax.
 */
public class MetamodelNameResolvingException extends AbstractToolGenerationException {


    /**
     * 
     */
    private static final long serialVersionUID = -3152865933640355121L;

    /**
     * @param message
     */
    public MetamodelNameResolvingException(String message) {
        super(message);
    }

}
