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
 * $Id: SaveAsOCLinEcoreHandler.java,v 1.3 2011/01/24 21:56:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.commands;

import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;

public class SaveAsOCLinEcoreHandler extends AbstractSaveAsHandler
{
	public SaveAsOCLinEcoreHandler() {
		super(OCLinEcoreDocumentProvider.PERSIST_AS_OCLINECORE);
	}
}
