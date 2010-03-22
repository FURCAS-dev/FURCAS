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
 * $Id: OCLTestFile.java,v 1.2 2010/03/22 01:27:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ui.IFileEditorInput;

public interface OCLTestFile
{
	 void createInvariant(EClass eClass, String name, String expression);

	 IFileEditorInput getEditorInput() throws IOException, CoreException;
}
