/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.services.base;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.services.IHoverHelper;

/**

 * 
 * @author 	suttons@us.ibm.com
 * Updates:
 * SMS 12 Aug 2007:  
 */
public abstract class HoverHelperBase implements IHoverHelper
{
	
	protected UniversalEditor fEditor = null;
	
	protected Language fLanguage = null;
	
	public void setEditor(UniversalEditor editor) {
		fEditor = editor;
	}
	
	public void setLanguage(Language language) {
		fLanguage = language;
	}
}
