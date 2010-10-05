/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.textual.tcs.SyntaxLookup;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;

/**
 * Bean to reduce the coupling of the constructors.
 */
public class SyntaxElementHandlerConfigurationBean<Type extends Object> {

    private ANTLR3GrammarWriter writer;
    private IMetaModelLookup<Type> metaLookup;
    private TemplateNamingHelper<Type> namingHelper;
    private SyntaxLookup syntaxLookup;
    private SemanticErrorBucket errorBucket;
    private MetaModelElementResolutionHelper<Type> resolutionHelper;


    /**
     * @param writer
     * @param operatorHandler
     * @param metaLookup
     * @param syntaxLookup
     * @param namingHelper
     * @param errorBucket
     * @param resolutionHelper
     */
    public SyntaxElementHandlerConfigurationBean(ANTLR3GrammarWriter writer,
            OperatorHandler operatorHandler, IMetaModelLookup<Type> metaLookup,
            SyntaxLookup syntaxLookup, TemplateNamingHelper<Type> namingHelper,
            SemanticErrorBucket errorBucket,
            MetaModelElementResolutionHelper<Type> resolutionHelper) {
        this.writer = writer;
        this.metaLookup = metaLookup;
        this.namingHelper = namingHelper;
        this.syntaxLookup = syntaxLookup;
        this.errorBucket = errorBucket;
        this.resolutionHelper = resolutionHelper;
    }


    public ANTLR3GrammarWriter getWriter() {
        return writer;
    }





    public IMetaModelLookup<Type> getMetaLookup() {
        return metaLookup;
    }


    public TemplateNamingHelper<Type> getNamingHelper() {
        return namingHelper;
    }


    public SyntaxLookup getSyntaxLookup() {
        return syntaxLookup;
    }


    public SemanticErrorBucket getErrorBucket() {
        return errorBucket;
    }


    public MetaModelElementResolutionHelper<Type> getResolutionHelper() {
        return resolutionHelper;
    }

    
}
