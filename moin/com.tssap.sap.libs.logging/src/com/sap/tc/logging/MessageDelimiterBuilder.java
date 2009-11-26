package com.sap.tc.logging;

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

import java.util.Arrays;
import com.sap.tc.logging.interfaces.IMessageDelimiterBuilder;
import com.sap.tc.logging.interfaces.IMessageBuilder;

public class MessageDelimiterBuilder implements IMessageDelimiterBuilder {
	
	//================================================ declaration > ====
	private static final int DYNAMIC_COUNTER_MAX_SIZE = 5; 
	
	private int[]  	delimiters;
	private int[]	 	delimiterEmpty;
	private int[][] delimiterDynamicCounters;
	private int 	 	delimiterSize;
	private int 	 	delimiterDynamicCounterSize;
	private int 	 	delimiterMinSize;
	private int 		delimiterLatestPos;
	private byte	 	delimiter;
	private boolean delimiterEnabled;
	private boolean isDelSorted;
	private boolean isLatestCharMask;
	private boolean isLatestCharDelimiter;
	
	private IMessageBuilder parent;
	
  //==== < declaration ============================ constructors > ====
	
	public MessageDelimiterBuilder() {}
	
	protected MessageDelimiterBuilder(byte delimiter, 
												 		 int 	delimiterMinSize) 
	{
		this.delimiter				= delimiter;
		this.delimiterMinSize = delimiterMinSize;
		
		if (delimiterMinSize > 0) {
			delimiterEnabled = true;
			this.delimiters								= new int[150];
			this.delimiterEmpty						= new int[150];
			this.delimiterDynamicCounters = new int[DYNAMIC_COUNTER_MAX_SIZE][2];
		}
	}
	
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
	
	public void setParent(IMessageBuilder parent){
		this.parent = parent;
	}
	
	public void addDynamicCounter(int pos, boolean isFixed ) {
		if (delimiterDynamicCounterSize == DYNAMIC_COUNTER_MAX_SIZE) {
			throw new IllegalArgumentException("The maximum number (" + DYNAMIC_COUNTER_MAX_SIZE + ") of dynamic counters has been is reached!");
		}
		if (isFixed) {
			delimiterDynamicCounters[delimiterDynamicCounterSize][0] = pos;
			delimiterDynamicCounters[delimiterDynamicCounterSize][1] = 0;
		}
		else {
			delimiterDynamicCounters[delimiterDynamicCounterSize][0] = pos;
			delimiterDynamicCounters[delimiterDynamicCounterSize][1] = 1;
		}
		delimiterDynamicCounterSize++;
	}
	
	public void setDelimiter(byte value) 
	{
		this.delimiter = value;
	}
	
	public byte getDelimiter() 
	{
		return this.delimiter;
	}
	
	public void saveNextPosition(byte value, int pos) 
	{
		if (delimiterEnabled) {
			if (value == '\\') {
				isLatestCharMask = !isLatestCharMask;
			}
			else if(value == delimiter) {
				delimiterLatestPos = (getMessageSize() + pos);
				if (!isLatestCharMask) {
					delimiters[delimiterSize++] = delimiterLatestPos;
				}
				isLatestCharMask = false;
			}
			else {
				isLatestCharMask = false;
			}
		}
	}
	
	public void savePreviousPosition(byte value, int pos) 
	{
		if (delimiterEnabled) {
			isDelSorted = false;
			if(value == delimiter) {
				delimiters[delimiterSize++] = (getMessageSize() + (pos - 1)) * (-1);
				isLatestCharDelimiter = true;				
				isLatestCharMask = false;
			}
			else if (value == '\\') {
				if (isLatestCharMask) {
					if (isLatestCharDelimiter) {
						delimiterSize++;
						isLatestCharDelimiter = false;
					}
				}
				else if (isLatestCharDelimiter) {
					delimiterSize--;
				}
				isLatestCharMask = true;
			}
			else {
				isLatestCharMask 	= false;
				isLatestCharDelimiter = false;
			}
		}
	}
	
	public void demask() 
	{
		isLatestCharMask = false;
	}
	
	public int getDelimiterPos(int index) {
		// Guardian
		if (index < 0 || index >= delimiterSize) return 0;
		if (delimiterSize >= delimiterMinSize) sortingDelimiters();
		return delimiters[index];
	}
	
	public boolean isComplete() {
		
		if (!isDelimited()) return true; // GUARDIAN
		
		// Check for the Dynamic Counters
		int dynamicPos 			= 0;
		int dynamicPosIndex = 0;
		int dynamicSize 		= 0;
		int dynamicSumSize 	= 0;
		
		for (int i = 0; i < delimiterDynamicCounterSize; i++) {
			dynamicPos 			= dynamicSize + delimiterDynamicCounters[i][0];
			dynamicSize			= getFieldInt(dynamicPos);
			dynamicPosIndex = (dynamicSize > 0) ? delimiterDynamicCounters[i][1] : 0;
			dynamicSumSize += dynamicSize;
			if (dynamicSumSize > 0 && ((delimiterSize - (dynamicSumSize + dynamicPosIndex)) < delimiterMinSize)) return false;
		}
		return (delimiterSize >= delimiterMinSize);
	}
	
	public boolean isDelimited() {
		return (delimiterMinSize > 0);
	}
	
	public int size() {
		return delimiterSize;
	}
	
	public void reset() 
	{
		if (delimiterEnabled) {
			System.arraycopy(delimiterEmpty, 0 , delimiters, 0 , delimiterEmpty.length);
		}	
		delimiterSize = 0;
		isDelSorted 	= true;
	}
	
  //==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
	
	private int getMessageSize() {
		if (parent == null) return 0; // Guardian
		return parent.size();
	}
	
	private int getFieldInt(int pos) {
		if (parent == null) return 0; // Guardian
		return parent.getFieldInt(pos);
	}
	
	private void sortingDelimiters() {
		if (isDelSorted) return;
		
		for(int i = 0; i < delimiterSize; i++) {
			if (delimiters[i] < 0) {
				delimiters[i] =  getMessageSize() - (delimiters[i] * (-1));
			}
		}
		Arrays.sort(delimiters);
		System.arraycopy(delimiters, (delimiters.length - delimiterSize), delimiters, 0 , delimiterSize);
		isDelSorted = true;
	}
	
  //==== < private ================================== deprecated > ====
	
}
