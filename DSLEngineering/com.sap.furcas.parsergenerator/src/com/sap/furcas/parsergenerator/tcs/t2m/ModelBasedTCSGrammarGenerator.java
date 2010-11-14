package com.sap.furcas.parsergenerator.tcs.t2m;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;

public class ModelBasedTCSGrammarGenerator extends AbstractTCSGrammarGenerator {

    private TCSSyntaxContainerBean syntaxBean;

    public ModelBasedTCSGrammarGenerator(OutputStream out, IMetaModelLookup<?> lookup, String targetPackage,
            TCSSyntaxContainerBean syntaxBean) {
        super(out, lookup, targetPackage);
        this.syntaxBean = syntaxBean;
    }

    @Override
    protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet, Set<URI> metamodelURIs)
            throws SyntaxParsingException, IOException, ModelAdapterException, ParserInvokationException {
        return this.syntaxBean;
    }

    @Override
    protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet, Set<URI> metamodelURIs, String languageId)
            throws SyntaxParsingException, IOException, ModelAdapterException, ParserInvokationException {
        return this.syntaxBean;
    }
}
