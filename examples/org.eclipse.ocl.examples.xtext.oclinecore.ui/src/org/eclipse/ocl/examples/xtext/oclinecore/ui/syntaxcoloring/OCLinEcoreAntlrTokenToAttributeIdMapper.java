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
 * $Id: OCLinEcoreAntlrTokenToAttributeIdMapper.java,v 1.2 2010/05/03 05:54:42 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.syntaxcoloring;

import org.eclipse.ocl.examples.xtext.oclinecore.formatting.OCLinEcoreFormatter;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.DefaultAntlrTokenToAttributeIdMapper;

import com.google.inject.Inject;

public class OCLinEcoreAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper
{
	@Inject
	private IFormatter formatter;

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (tokenName.startsWith("'") && tokenName.endsWith("'")) {
			String keyword = tokenName.substring(1, tokenName.length()-1);
			OCLinEcoreGrammarAccess grammarAccess = ((OCLinEcoreFormatter) formatter).getGrammarAccess();
			ParserRule rule = grammarAccess.getRestrictedKeywordsRule();
			AbstractElement alternatives = rule.getAlternatives();
			if (alternatives instanceof Alternatives) {
				for (AbstractElement element : ((Alternatives)alternatives).getElements()) {
					if (element instanceof Keyword) {
						if (keyword.equals(((Keyword)element).getValue())) {
							return OCLinEcoreHighlightingConfiguration.RESTRICTED_KEYWORD_ID;
						}
					}
				}				
			}
		}
		return super.calculateId(tokenName, tokenType);
	}
}
