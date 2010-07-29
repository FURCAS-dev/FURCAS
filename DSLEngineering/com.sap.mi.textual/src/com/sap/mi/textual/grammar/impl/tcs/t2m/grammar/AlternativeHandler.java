/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-10-13 10:41:07 +0200 (Di, 13 Okt 2009) $
 * @version $Revision: 8285 $
 * @author: $Author: d043530 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import java.util.Collection;
import java.util.Iterator;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.SequenceInAlternative;
import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;

/**
 * The Class AlternativeHandler.
 */
public class AlternativeHandler {


	/**
	 * Adds the element.
	 * 
	 * @param alternativeSeqEl the element
	 * @param buffer the buffer
	 * 
	 * @throws SyntaxParsingException the syntax parsing exception
	 * @throws MetaModelLookupException the meta model lookup exception
	 */
	public void addElement(Alternative alternativeSeqEl, RuleBodyStringBuffer buffer)
            throws MetaModelLookupException {

		Collection<SequenceInAlternative> seqs = alternativeSeqEl.getSequences();
		if (seqs == null || seqs.size() == 0) {
			return;
		}
//		if (alternativeSeqEl.isMulti()) {
//		    throw new SyntaxElementException("Multi-Alternatives not supported yet", alternativeSeqEl);
//		}
		
		int alternative = 0;
		buffer.append('(');
		for (Iterator<SequenceInAlternative> iterator = seqs.iterator(); iterator.hasNext();) {
			SequenceInAlternative sequence = iterator.next();
			if(sequence.getDisambiguate() != null) {
				//append disambiguation as syntactic predicate
				 buffer.append("(");
				 buffer.append(sequence.getDisambiguate());
				 buffer.append(") => ");
			}
			ObservationDirectivesHelper.appendEnterAlternativeNotification(buffer, alternative);
			buffer.addToRuleFragment(sequence);
			ObservationDirectivesHelper.appendExitAlternativeNotification(buffer);
			
			if (iterator.hasNext()) {
			    buffer.append("\n  |");
			}
			alternative++;
		}		
		buffer.append(')');
		if (alternativeSeqEl.isIsMulti()) {
		    buffer.append('*');
		}
	}
}
