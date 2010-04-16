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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLinEcoreHighlightingConfiguration.java,v 1.1 2010/04/16 18:09:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class OCLinEcoreHighlightingConfiguration extends DefaultHighlightingConfiguration
{
	public static final String RESTRICTED_KEYWORD_ID = "restricted_keyword";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(RESTRICTED_KEYWORD_ID, "RestrictedKeyword", restrictedKeywordTextStyle());
		super.configure(acceptor);
	}

	public TextStyle restrictedKeywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.ITALIC | SWT.BOLD);
		return textStyle;
	}

}
