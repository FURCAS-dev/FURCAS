/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.SequenceElementStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.SequenceStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyBufferFactory;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

/**
 *
 */
public class RuleBufferFactoryStub extends RuleBodyBufferFactory {

    public RuleBufferFactoryStub() {
        super(new AlternativeHandlerStub(),
                new BlockTypeHandlerStub(),
                new ConditionalElementHandlerStub(),
                new SyntaxLookupStub(),
                new PropertyHandlerStub(),
                new TemplateNamingHelperStub<Object>(),
                null,
                new SemanticErrorBucket()); 
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
