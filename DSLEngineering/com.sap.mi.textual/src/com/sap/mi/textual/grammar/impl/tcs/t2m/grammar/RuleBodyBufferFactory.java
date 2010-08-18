/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import tcs.Sequence;
import tcs.SequenceElement;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.tcs.util.SyntaxLookup;

/**
 * convenience class to keep the Handler Creation in this class, while
 * allowing others to create RuleBodies.
 * 
 * @author C5107456
 */
public class RuleBodyBufferFactory {

    private AlternativeHandler alternativeHandler;
    private BlockTypeHandler blockHandler;
    private ConditionalElementHandler<?> conElHandler;
    private SyntaxLookup syntaxLookup;
    private PropertyTypeHandler<?> propertyHandler;
    private TemplateNamingHelper<?> namingHelper;
    private SemanticErrorBucket errorBucket;
    private InjectorActionsHandler<?> actionsHandler;

    
    
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
     * @param semanticRef
     *            This is the label of the ocl which points to a literal. This will
     *            be exchanged with a real value in the delayed reference
     * 
     * @return the new rule body prefix for a semantic predicated rule
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     */
    protected String getNewRuleBodyForSemDisambiguate(Sequence element, String semanticRef)
            throws MetaModelLookupException {
    	propertyHandler.setSkipDelayedReferences(true);
        SemanticRuleBodyStringBuffer buffer = new SemanticRuleBodyStringBuffer(
                alternativeHandler, blockHandler, conElHandler,
                propertyHandler, syntaxLookup, namingHelper, actionsHandler, errorBucket, semanticRef);
        
        buffer.addToRuleFragment(element);
        propertyHandler.setSkipDelayedReferences(false);
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