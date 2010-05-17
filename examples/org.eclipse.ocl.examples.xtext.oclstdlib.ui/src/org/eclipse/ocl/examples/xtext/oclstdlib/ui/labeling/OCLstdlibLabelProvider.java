/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLstdlibLabelProvider.java,v 1.2 2010/05/17 09:18:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for OCLstdlibCST objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class OCLstdlibLabelProvider extends BaseLabelProvider {

	@Inject
	public OCLstdlibLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
}
