/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.logger;

/**
 * Definition (name and description) of logical MOIN Categories.
 * <p>
 * The MOIN Logging and Tracing solution defines the logical-organized
 * Categories which are defined in the
 * com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum class.
 * 
 * @author d029324
 */
public enum CategoryEnum {
	/**
	 * The MOIN parent Category /Applications/Moin. This Category is the
	 * entry-point to the Modeling Infrastructure solution.
	 */
	MOIN("/Applications/Moin", "Modeling Infrastructure"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for MOIN-specific administration purposes, for example
	 * configuration, logging, meta-model deployment, etc. The Category name -
	 * /Applications/Moin/RuntimeHost
	 */
	MOIN_RUNTIME_HOST(MOIN + "/RuntimeHost", "RuntimeHost"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for MOIN core functionality. The Category name -
	 * /Applications/Moin/Core
	 */
	MOIN_CORE(MOIN + "/Core", "Core"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for the MOIN facility functionality. The Category name
	 * - /Applications/Moin/Facility
	 */
	MOIN_FACILITY(MOIN + "/Facility", "Facility"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for the MOIN primary functionality functionality. The
	 * Category name - /Applications/Moin/Facility/PF
	 */
	MOIN_PRIMARY_FACILITY(MOIN_FACILITY + "/PF", "Primary Facility"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for the MOIN transformation functionality, for example
	 * model-to-model or model-to-text transformation. The Category name -
	 * /Applications/Moin/Transformations
	 */
	MOIN_MTI(MOIN + "/MTI", "Transformations"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for the MOIN XML Mapping. The Category name -
	 * /Applications/Moin/Xm
	 */
	MOIN_XM(MOIN + "/Xm", "XML Mapping"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Category used for the MOIN tests (e.g. unit tests). The Category name
	 * - /Applications/Moin/Test
	 */
	MOIN_TEST(MOIN + "/Test", "Test"); //$NON-NLS-1$ //$NON-NLS-2$

	private String categoryName;

	private String categoryDescription;

	private CategoryEnum(String categoryName, String categoryDescription) {

		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryName() {

		return this.categoryName;
	}

	public String getCategoryDescription() {

		return this.categoryDescription;
	}

	@Override
	public String toString() {

		return this.categoryName;
	}

}
