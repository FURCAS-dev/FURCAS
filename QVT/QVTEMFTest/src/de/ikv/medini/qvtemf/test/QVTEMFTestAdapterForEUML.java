/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvtemf.test;

import de.ikv.medini.qvt.test.QVTEMFTestAdapter;

public class QVTEMFTestAdapterForEUML extends QVTEMFTestAdapter {

	@Override
	public void initRepository() {
		for (String metaModelID : this.metamodelIDs) {
			this.buildMetaModelFromEcoreFile(this.getProperty("metamodel.ecore.dir") + metaModelID + ".ecore");
		}
		super.initRepository();
	}

}
