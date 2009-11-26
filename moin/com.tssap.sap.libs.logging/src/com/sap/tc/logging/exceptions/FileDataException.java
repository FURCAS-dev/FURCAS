package com.sap.tc.logging.exceptions;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 */

public class FileDataException extends DataException{

	private static final String SOURCE_NAME = "File";
	
	public FileDataException(String fileName) {
		super(SOURCE_NAME, fileName);
  }
	
  public FileDataException(String fileName, Exception ex) {
    super(SOURCE_NAME, fileName, ex);
  }

}
