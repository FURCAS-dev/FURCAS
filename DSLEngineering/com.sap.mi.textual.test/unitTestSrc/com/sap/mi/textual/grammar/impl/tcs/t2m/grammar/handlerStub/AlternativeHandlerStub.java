/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import tcs.Alternative;

import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.AlternativeHandler;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;

/**
 *
 */
public class AlternativeHandlerStub extends AlternativeHandler {

    public List<Alternative> elements = new ArrayList<Alternative>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    
    @Override
    public void addElement(Alternative element, RuleBodyStringBuffer buffer) {
        elements.add(element);
        buffers.add(buffer);
    }

}