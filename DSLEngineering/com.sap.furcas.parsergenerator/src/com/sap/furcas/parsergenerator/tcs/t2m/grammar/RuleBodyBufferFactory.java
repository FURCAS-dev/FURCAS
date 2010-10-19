/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * convenience class to keep the Handler Creation in this class, while
 * allowing others to create RuleBodies.
 * 
 * @author C5107456
 */
public class RuleBodyBufferFactory {

    private final AlternativeHandler alternativeHandler;
    private final BlockTypeHandler blockHandler;
    private final ConditionalElementHandler<?> conElHandler;
    private final SyntaxLookup syntaxLookup;
    private final PropertyTypeHandler<?> propertyHandler;
    private final TemplateNamingHelper<?> namingHelper;
    private final SemanticErrorBucket errorBucket;
    private final InjectorActionsHandler<?> actionsHandler;

    
    
    public RuleBodyBufferFactory(AlternativeHandler alternativeHandler,
            BlockTypeHandler blockHandler,
            ConditionalElementHandler<?> conElHandler, SyntaxLookup syntaxLookup,
            PropertyTypeHandler<?> propertyHandler, TemplateNamingHelper<?> namingHelper,
            InjectorActionsHandler<?> actionsHandler, SemanticErrorBucket errorBucket) {
        super();
        this.alternativeHandler = alternativeHandler;
        this.blockHandler = blockHandler;
        this.conElHandler = conElHandler;
        this.syntaxLookup = syntaxLookup;
        this.propertyHandler = propertyHandler;
        this.namingHelper = namingHelper;
        this.actionsHandler = actionsHandler;
        this.errorBucket = errorBucket;
    }



    /**
     * creates a new factory using the Handler created in the wrapping
     * class.
     * 
     * @param element
     *            the element
     * 
     * @return the new rule body fragment
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     */
    protected String getNewRuleBodyFragment(Sequence element)
            throws MetaModelLookupException {
        RuleBodyStringBuffer buffer = new RuleBodyStringBuffer(
                alternativeHandler, blockHandler, conElHandler,
                propertyHandler, syntaxLookup, namingHelper, actionsHandler, errorBucket);
        
        buffer.addToRuleFragment(element);
        return buffer.getResult();
    }
    
    /**
     * creates a new factory using the Handler created in the wrapping
     * class.
     * 
     * @param element
     *            the element
     * 
     * @return the new rule body fragment
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     */
    protected String getNewRuleBodyFragment(SequenceElement element)
            throws MetaModelLookupException {
        RuleBodyStringBuffer buffer = new RuleBodyStringBuffer(
                alternativeHandler, blockHandler, conElHandler,
                propertyHandler, syntaxLookup, namingHelper, actionsHandler, errorBucket);
        
        buffer.addToRuleFragment(element);
        return buffer.getResult();
    }

}