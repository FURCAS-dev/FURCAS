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
 * $Id: CommonActionContributor.java,v 1.1 2010/03/11 14:51:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.actions;

import java.util.ResourceBundle;

import org.eclipse.imp.services.base.DefaultLanguageActionsContributor;

public class CommonActionContributor extends DefaultLanguageActionsContributor
{
	public CommonActionContributor() {
		super();
	}

	public static ResourceBundle ResBundle = ResourceBundle.getBundle("org.eclipse.ocl.examples.editor.ui.actions.ActionMessages");
}
