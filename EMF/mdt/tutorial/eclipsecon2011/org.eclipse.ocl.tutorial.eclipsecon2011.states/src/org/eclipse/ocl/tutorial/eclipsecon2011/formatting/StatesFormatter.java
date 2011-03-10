/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: StatesFormatter.java,v 1.1 2011/03/10 09:21:27 ewillink Exp $
 */
package org.eclipse.ocl.tutorial.eclipsecon2011.formatting;

import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess;
import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess.CompoundStateElements;
import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess.SimpleStateElements;
import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess.StatemachineElements;
import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess.TransitionElements;
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
public class StatesFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {

	    c.setAutoLinewrap(120);

	    StatesGrammarAccess f = (StatesGrammarAccess) getGrammarAccess();
	    
	    {
	    	CompoundStateElements a = f.getCompoundStateAccess();
		    c.setLinewrap(2).before(a.getRule());
			setBraces(c, a.getLeftCurlyBracketKeyword_6(), a.getRightCurlyBracketKeyword_8());
	    }
	    {
	    	SimpleStateElements a = f.getSimpleStateAccess();
		    c.setLinewrap(2).before(a.getRule());
			setBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_6());
	    }
	    {
	    	StatemachineElements a = f.getStatemachineAccess();
		    c.setLinewrap(2).before(a.getRule());
		    c.setLinewrap(1).before(a.getEventsKeyword_5());
		    c.setNoSpace().before(a.getSemicolonKeyword_7());
			setBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_9());
	    }
	    {
	    	TransitionElements a = f.getTransitionAccess();
		    c.setLinewrap(1).before(a.getRule());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}

	public void setBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}
}
