/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import tcs.ConditionalElement;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ConditionalElementHandler;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;

/**
 *
 */
public class ConditionalElementHandlerStub extends ConditionalElementHandler {

    
    public ConditionalElementHandlerStub() {
        super(new MetaLookupStub(), null, null, null, null);
    }


    public List<ConditionalElement> elements = new ArrayList<ConditionalElement>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    
    
    @Override
    public void addElement(ConditionalElement element,
            RuleBodyStringBuffer buffer) throws SyntaxElementException,
            MetaModelLookupException {
        elements.add(element);
        buffers.add(buffer);
    }

}
