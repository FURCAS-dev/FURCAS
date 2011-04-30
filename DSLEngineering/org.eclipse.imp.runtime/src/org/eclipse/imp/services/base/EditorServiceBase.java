/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Stan Sutton (suttons@us.ibm.com) - initial API and implementation

*******************************************************************************/


package org.eclipse.imp.services.base;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IEditorService;

public abstract class EditorServiceBase implements IEditorService {

	protected String name = null;
	
	protected UniversalEditor editor = null;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public void setEditor(UniversalEditor editor) {
		this.editor = editor;
	}
	
	public UniversalEditor getEditor() {
		return editor;
	}
	

	/**
	 * @return	A value from the enumeration IModelListener.AnalysisREquired,
	 * 			reflecting the dependence of the implementation of this
	 * 			service on other analyses that need to be performed
	 * 			before this one can be executed correctly
	 */
	public abstract AnalysisRequired getAnalysisRequired();

	
	/**
	 * This method will be called when the AST maintained by the parseController
	 * has been updated (subject to the completion of analyses on which this
	 * service depends and on the apparent availability of time in which to
	 * perform this analysis)
	 */
	public abstract void update(IParseController parseController, IProgressMonitor monitor);

}
