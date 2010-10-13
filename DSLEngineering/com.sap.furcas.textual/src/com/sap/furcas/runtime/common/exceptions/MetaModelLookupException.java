package com.sap.furcas.runtime.common.exceptions;


/**
 * The Class MetaModelLookupException.
 */
public class MetaModelLookupException extends GrammarGenerationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -358116960046570586L;

	/**
	 * Instantiates a new meta model lookup exception.
	 * 
	 * @param message the message
	 */
	public MetaModelLookupException(String message) {
		super(message);
	}

    /**
     * @param string
     * @param rte
     */
    public MetaModelLookupException(String message, Exception rte) {
        super(message, rte);
    }

}
