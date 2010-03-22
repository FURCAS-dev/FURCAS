/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AbstractOCLInEcoreEditorTestCase.java,v 1.3 2010/03/22 01:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl.ecore;

import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreCreationFactory;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreEditor;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.test.editor.AbstractEditorTestCase;
import org.eclipse.ocl.examples.test.editor.OCLInEcoreTestFile;

public abstract class AbstractOCLInEcoreEditorTestCase extends AbstractEditorTestCase<OCLInEcoreEditor, OCLInEcoreTestFile, OCLInEcoreTestFile>
{	
	@Override
	protected ICreationFactory getCreationFactory() {
		return OCLInEcoreCreationFactory.INSTANCE;
	}

	@Override
	protected String getEditorId() {
		return OCLInEcoreCreationFactory.EDITOR_ID;
	}
}
