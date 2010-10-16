/*******************************************************************************

 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-08-01 03:19:11 +0200 (Fr, 01 Aug 2008) $
 * Revision: $Revision: 1357 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.antlr3;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;


/**
 * The Class ANTLR3LocationToken.
 */
public class ANTLR3LocationTokenImpl extends CommonToken implements ANTLR3LocationToken{



	/**
     * 
     */
    private static final long serialVersionUID = 3622215961878287834L;

    /**
	 * Instantiates a new ANTLR3 location token.
	 * 
	 * @param input the input
	 * @param type the type
	 * @param channel the channel
	 * @param start the start
	 * @param stop the stop
	 */
	public ANTLR3LocationTokenImpl(CharStream input, int type, int channel, int start, int stop) {
		super(input, type, channel, start, stop);
	}

	/**
     * Instantiates a new ANTLR3 location token.
     * 
     */
    public ANTLR3LocationTokenImpl(int type, String text) {
        super(type, text);
    }

    /**
	 * Sets the end line.
	 * 
	 * @param endLine the new end line
	 */
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	/**
	 * Gets the end line.
	 * 
	 * @return the end line
	 */
	public int getEndLine() {
		return endLine;
	}

	/**
	 * Sets the end column.
	 * 
	 * @param endColumn the new end column
	 */
	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	/**
	 * Gets the end column.
	 * 
	 * @return the end column
	 */
	public int getEndColumn() {
		return endColumn;
	}

	/** The end line. */
	private int endLine;
	
	/** The end column. */
	private int endColumn;

}
