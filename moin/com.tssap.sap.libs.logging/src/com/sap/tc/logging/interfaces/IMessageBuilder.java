package com.sap.tc.logging.interfaces;

import java.util.Arrays;

import com.sap.tc.logging.MessageDelimiterBuilder;
import com.sap.tc.logging.exceptions.UnsupportedFormatException;

/*
 *  Copyright:   Copyright (c) 2003
 *
 *  Company:     SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @author 			 Robert Boban
 */

public interface IMessageBuilder {

	public static final int  DIRECTION_NEXT 		= 1;
	public static final int  DIRECTION_PREVIOUS = -1;
	public static final int  DIRECTION_NONE 		= -2;
	
	public byte[] message();
	
	public int size();
	
	public void reset();

	public void savePreviousLine(byte[] lineChunk, int lineSize);
	public void saveNextLine		(byte[] lineChunk, int lineSize);

	public String	getEncoding();
	public void		setEncoding		(String charsetName);
	public int 		getFieldInt		(int pos);
	public byte[] getFieldByte	(int pos);
	public String getFieldString(int pos);
	
	public long getBookMarkBOL();
	public long getBookMarkEOL();
	
	public boolean isComplete(int direction) throws UnsupportedFormatException;
	
	public IMessageDelimiterBuilder getDelimiter();
}
