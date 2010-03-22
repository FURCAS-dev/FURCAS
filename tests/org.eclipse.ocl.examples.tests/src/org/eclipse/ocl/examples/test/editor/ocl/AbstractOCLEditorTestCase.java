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
 * $Id: AbstractOCLEditorTestCase.java,v 1.2 2010/03/22 01:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;
import org.eclipse.ocl.examples.test.editor.AbstractEditorTestCase;
import org.eclipse.ocl.examples.test.editor.EcoreTestFileBase;
import org.eclipse.ocl.examples.test.editor.OCLForEcoreTestFile;
import org.eclipse.ocl.examples.editor.ocl.ui.OCLCreationFactory;
import org.eclipse.ocl.examples.editor.ocl.ui.OCLTextEditor;

public abstract class AbstractOCLEditorTestCase extends AbstractEditorTestCase<OCLTextEditor, EcoreTestFileBase, OCLForEcoreTestFile>
{
	protected IFile createModelRegistryFile() throws CoreException {
		final String contents = 
			"<?xml version='1.0' encoding='ASCII'?>\n" +
			"<mreg:ModelRegistrySettings xmi:version='2.0' xmlns:xmi='http://www.omg.org/XMI' xmlns:mreg='http://www.eclipse.org/ocl/1.0/ModelRegistry'>\n" +
			"  <resource name='.'>\n" +
			"    <entry accessor='ecore' kind='Model Name' uri='platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore'/>\n" +
			"  </resource>\n" +
			"</mreg:ModelRegistrySettings>\n";
		final String testFileName = ProjectHandle.DEFAULT_MODEL_REGISTRY_PATH;
		IFile file = createFile(testFileName, contents);
		return file;
	}

	protected IFile createMinimalTestFile() throws CoreException {
		final String contents = "context ecore::EClass\ninv: true\n";
		final String testFileName = getName() + " .ocl";
		IFile file = createFile(testFileName, contents);
		return file;
	}

	@Override
	protected ICreationFactory getCreationFactory() {
		return OCLCreationFactory.INSTANCE;
	}

	@Override
	protected String getEditorId() {
		return OCLCreationFactory.EDITOR_ID;
	}
}
