package com.sap.tc.logging.interfaces;

/*
 *  Copyright:   Copyright (c) 2003
 *
 *  Company:     SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @version $Id:#19 $
 */

import java.util.List;

/**
 * General result set for objects used in Logging. Usually used when making a request, expecting
 * multiple number of results returned.
 */
public interface ILoggingResultSet
{
	/**
	 * Return a list of result nodes in this Result Set
	 */
	public List getResults();

	//potential status:
	//VALID
	//INVALID
	/**
	 * Return general status if result is either valid(true) or invalid(false)
	 */
	public boolean isValid();

	/**
	 * Return true if result set is empty (no result node)
	 */
	public boolean isEmpty();

	/**
	 * Return the number of result nodes in this Result Set
	 */
	public int getSize();

	/**
	 * Return the specific error occurred for invalid operation(if any). Null if none.
	 */
	public Exception getException();

}
