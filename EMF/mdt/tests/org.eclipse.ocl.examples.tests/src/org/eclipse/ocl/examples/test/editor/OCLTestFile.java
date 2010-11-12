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
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLTestFile.java,v 1.3 2010/04/25 06:50:09 ewillink Exp $
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
