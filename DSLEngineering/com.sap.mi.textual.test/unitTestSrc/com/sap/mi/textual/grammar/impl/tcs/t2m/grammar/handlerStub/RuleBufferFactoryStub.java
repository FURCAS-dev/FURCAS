/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import tcs.Alternative;
import tcs.Sequence;
import tcs.SequenceElement;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyBufferFactory;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.SequenceElementStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.SequenceStub;

/**
 *
 */
public class RuleBufferFactoryStub extends RuleBodyBufferFactory {

    /**
     * @param writer
     * @param lookup
     * @param syntax
     * @param keywordSet
     */
    public RuleBufferFactoryStub() {
        super(null, null, null, null, null, null, null, null);
    }
    public List<Alternative> elements = new ArrayList<Alternative>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
  
    @Override
    protected String getNewRuleBodyFragment(Sequence element)
            throws MetaModelLookupException {
        if (element != null) {
            return ((SequenceStub) element).representation;
        } else {
            return "";
        }
    }
    @Override
    protected String getNewRuleBodyFragment(SequenceElement element)
            throws MetaModelLookupException {
        if (element != null) {
            return ((SequenceElementStub) element).representation;
        } else {
            return "";
        }
    }


}
