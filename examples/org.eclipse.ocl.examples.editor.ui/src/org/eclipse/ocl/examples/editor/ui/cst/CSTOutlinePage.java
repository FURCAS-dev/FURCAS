/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: CSTOutlinePage.java,v 1.2 2010/03/22 01:15:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.cst;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTextEditor;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseResult;

public class CSTOutlinePage extends CommonOutlinePage implements ICSTOutlinePage
{
	public CSTOutlinePage(CommonTextEditor editor) {
		super(editor, editor.getCreationFactory().createTreeModelBuilder(false));
	}

	@Override
	public void setSelection(ISelection selection) {
		ICommonParseResult currentResult = editor.getParseController().getCurrentResult();
		if (currentResult != null)
			selection = editor.getCSTSelection(selection, currentResult);
		super.setSelection(selection);
	}
}
