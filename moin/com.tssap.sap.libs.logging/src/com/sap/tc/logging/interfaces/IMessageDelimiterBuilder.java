package com.sap.tc.logging.interfaces;

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

public interface IMessageDelimiterBuilder {

	public void setParent(IMessageBuilder parent);
	
	public void setDelimiter(byte value);
	public byte getDelimiter(); 
	
	public void saveNextPosition(byte value, int pos);
	public void savePreviousPosition(byte value, int pos);
	public void demask();
	
	public boolean isComplete();
	public boolean isDelimited();
	
	public void addDynamicCounter(int pos, boolean isFixed);
	public int getDelimiterPos(int index);
	public int size();
	
	public void reset();

}
