/**
 * Copyright (c) 2008 by SAP AG, Walldorf. http://www.sap.com All rights
 * reserved.
 * 
 * This software is the confidential and proprietary information of SAP AG,
 * Walldorf. You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered
 * into with SAP.
 * 
 */
package com.sap.mi.fwk;

import java.util.Set;

import com.sap.tc.moin.repository.PRI;

/**
 * PRELIMINRAY API - ONLY TO BE USED BY GALAXY
 * (c) 2000 - 2009 SAP AG
 * 
 * @author d024127
 * 
 */
public interface IOCLCategoryProvider {

	/**
	 * Returns a set of categories which should be checked for the current pri.
	 * If an empty set is handed over, all categories will be analyzed.
	 * 
	 * @param pri
	 *            the current PRI
	 * @return A set of categories to be checked, may be empty
	 */
	public Set<String> getCategories(PRI pri);
}
