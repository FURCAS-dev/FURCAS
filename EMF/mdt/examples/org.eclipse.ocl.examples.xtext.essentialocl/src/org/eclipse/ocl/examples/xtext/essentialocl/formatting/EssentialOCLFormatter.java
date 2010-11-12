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
 * $Id: EssentialOCLFormatter.java,v 1.3 2010/05/23 10:27:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.formatting;

import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class EssentialOCLFormatter extends AbstractEssentialOCLFormatter
{
	@Override
	protected void configureFormatting(FormattingConfig c) {

	    c.setAutoLinewrap(120);

		EssentialOCLGrammarAccess f = (EssentialOCLGrammarAccess)getGrammarAccess();	
		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
	    configureNavigationExpCS(c, f.getNavigationExpCSAccess());
	    configureNavigatingExpCS(c, f.getNavigatingExpCSAccess());
		configurePathNameExpCS(c, f.getPathNameExpCSAccess());
		configurePreExpCS(c, f.getPreExpCSAccess());
	    configureRoundBracketExpCS(c, f.getRoundBracketExpCSAccess());
	    configureSquareBracketExpCS(c, f.getSquareBracketExpCSAccess());
		configureSubNavigationExpCS(c, f.getSubNavigationExpCSAccess());
	    configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
	    configureTupleTypeCS(c, f.getTupleTypeCSAccess());
	}
}
