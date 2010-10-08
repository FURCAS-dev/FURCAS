/*******************************************************************************

 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.antlr3;

import org.antlr.runtime.Token;


/**
 * The Class ANTLR3LocationToken.
 */
public interface ANTLR3LocationToken extends Token {


    public int getStartIndex() ;


    public int getStopIndex();


    public void setStartIndex(int arg0);


    public void setStopIndex(int arg0);


    /**
	 * Sets the end line.
	 * 
	 * @param endLine the new end line
	 */
	public void setEndLine(int endLine);

	/**
	 * Gets the end line.
	 * 
	 * @return the end line
	 */
	public int getEndLine();

	/**
	 * Sets the end column.
	 * 
	 * @param endColumn the new end column
	 */
	public void setEndColumn(int endColumn);

	/**
	 * Gets the end column.
	 * 
	 * @return the end column
	 */
	public int getEndColumn();

}
