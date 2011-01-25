/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotResourceImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class PivotResourceImpl extends XMIResourceImpl implements PivotResource
{
	/**
	 * Creates an instance of the resource.
	 */
	public PivotResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected XMLHelper createXMLHelper() {
		// TODO Auto-generated method stub
		return super.createXMLHelper();
	}

	@Override
	protected XMLLoad createXMLLoad() {
		// TODO Auto-generated method stub
		return super.createXMLLoad();
	}

	@Override
	protected XMLSave createXMLSave() {
		return new PivotSaveImpl(createXMLHelper());
	}

	@Override
	protected boolean useIDs() {
		return true;
	}
}
