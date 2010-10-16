package com.sap.furcas.runtime.common.exceptions;


/**
 * The Class MetaModelLookupException.
 */
public class NameResolutionFailedException extends GrammarGenerationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -358116960046570586L;

	/**
	 * Instantiates a new meta model lookup exception.
	 * 
	 * @param message the message
	 */
	public NameResolutionFailedException(String message) {
		super(message);
	}

    /**
     * @param string
     * @param rte
     */
    public NameResolutionFailedException(String message, Exception rte) {
        super(message, rte);
    }

    /**
     * @param e
     */
    public NameResolutionFailedException(MetaModelLookupException e) {
        super(e.getMessage(), e);
    }

}
