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

package org.eclipse.imp.services;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.parser.IModelListener;

public interface IEditorService
	extends IModelListener
{
	
	public String getName();
	
	public void setEditor(UniversalEditor editor);

}
