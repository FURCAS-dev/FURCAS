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
 * $Id: ASTOutlinePage.java,v 1.2 2010/03/22 01:15:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.cst;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTextEditor;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseResult;

public class ASTOutlinePage extends CommonOutlinePage
{
	public ASTOutlinePage(CommonTextEditor editor) {
		super(editor, editor.getCreationFactory().createTreeModelBuilder(true));
	}

	@Override
	public void setSelection(ISelection selection) {
		ICommonParseResult currentResult = editor.getParseController().getCurrentResult();
		if (currentResult != null)
			selection = editor.getASTSelection(selection, currentResult);
		super.setSelection(selection);
	}
}
