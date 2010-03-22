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
 * $Id: OCLInEcoreTreeModelBuilder.java,v 1.1 2010/03/22 01:21:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import org.eclipse.ocl.examples.editor.ocl.ui.imp.OCLTreeModelBuilder;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseResult;


public class OCLInEcoreTreeModelBuilder extends OCLTreeModelBuilder
{
	public OCLInEcoreTreeModelBuilder() {
		this(true);
	}

	public OCLInEcoreTreeModelBuilder(boolean showAST) {
		super(OCLInEcoreCreationFactory.INSTANCE, showAST);
	}

	@Override
	public void visitTree(Object root) {
		if (showAST && (root instanceof ICommonParseResult))
			root = ((ICommonParseResult) root).getAST().getResourceSet();
		super.visitTree(root);
	}
}