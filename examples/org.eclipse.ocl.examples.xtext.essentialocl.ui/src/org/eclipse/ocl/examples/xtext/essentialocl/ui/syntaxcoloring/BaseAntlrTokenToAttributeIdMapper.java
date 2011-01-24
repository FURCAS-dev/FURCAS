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
 * $Id: BaseAntlrTokenToAttributeIdMapper.java,v 1.2 2011/01/24 21:30:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

public class BaseAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper
{

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if("RULE_DOCUMENTATION".equals(tokenName)) {
			return DefaultHighlightingConfiguration.COMMENT_ID;
		}
		if("RULE_DOUBLE_QUOTED_STRING".equals(tokenName)) {
			return DefaultHighlightingConfiguration.STRING_ID;
		}
		if("RULE_SINGLE_QUOTED_STRING".equals(tokenName)) {
			return DefaultHighlightingConfiguration.STRING_ID;
		}
		return super.calculateId(tokenName, tokenType);
/*		if("RULE_STRING".equals(tokenName)) {
			return DefaultHighlightingConfiguration.STRING_ID;
		}
		if("RULE_INT".equals(tokenName)) {
			return DefaultHighlightingConfiguration.NUMBER_ID;
		}
		if("RULE_ML_COMMENT".equals(tokenName) | "RULE_SL_COMMENT".equals(tokenName)) {
			return DefaultHighlightingConfiguration.COMMENT_ID;
		}
		return DefaultHighlightingConfiguration.DEFAULT_ID;
*/	}
	
}