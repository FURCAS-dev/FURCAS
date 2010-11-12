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
 * $Id: AbstractBaseFormatter.java,v 1.1 2010/05/23 10:27:37 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public abstract class AbstractBaseFormatter extends AbstractDeclarativeFormatter {

	public void setBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}

	public void setNoSpaceLineWrap(FormattingConfig c, Keyword semicolon) {
		c.setNoSpace().before(semicolon);
	    c.setLinewrap().after(semicolon);
	}
}
