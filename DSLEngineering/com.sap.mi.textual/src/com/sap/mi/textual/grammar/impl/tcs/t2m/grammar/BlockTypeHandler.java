/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import java.util.Collection;
import java.util.Iterator;

import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.LocatedElement;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;


/**
 * The Class BlockTypeHandler.
 */
public class BlockTypeHandler {

    /**
     * Adds the element.
     * 
     * @param element
     *            the element
     * @param buffer
     *            the buffer
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     */
    public void addElement(LocatedElement element, RuleBodyStringBuffer buffer)
            throws MetaModelLookupException {
        buffer.append('(');
        if (element instanceof Sequence) {
            Sequence sequence = (Sequence) element;

            Collection<SequenceElement> elements = sequence.getElements();
            for (Iterator<SequenceElement> iterator = elements.iterator(); iterator.hasNext();) {
                SequenceElement sequenceElement = iterator.next();
                buffer.addToRuleFragment(sequenceElement);
            }
        } else if (element instanceof Block) {
            Block block = (Block) element;
            buffer.addToRuleFragment(block.getBlockSequence());
        } else {
            throw new RuntimeException(element.getClass()
                    + " handling not implemented yet");
        }
        buffer.append(')');
    }
}
