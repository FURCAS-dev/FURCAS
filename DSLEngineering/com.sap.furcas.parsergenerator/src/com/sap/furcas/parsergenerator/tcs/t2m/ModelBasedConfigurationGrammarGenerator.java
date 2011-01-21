package com.sap.furcas.parsergenerator.tcs.t2m;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLRGrammarGenerator;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.GenerationReport;
import com.sap.furcas.parsergenerator.tcs.t2m.validation.SyntaxDefinitionValidation;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

public class ModelBasedConfigurationGrammarGenerator extends AbstractTCSGrammarGenerator{
	private TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfig;

	
	public ModelBasedConfigurationGrammarGenerator(OutputStream out,
			IMetaModelLookup<?> lookup, String targetPackage,
			TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfig) {
		super(out, lookup, targetPackage);
		this.syntaxBeanWithConfig = syntaxBeanWithConfig;
	}
	
	@Override
	protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet,
			Set<URI> metamodelURIs) throws SyntaxParsingException, IOException,
			ModelAdapterException, ParserInvokationException {
		return this.syntaxBeanWithConfig;
	}

	@Override
	protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet,
			Set<URI> metamodelURIs, String languageId)
			throws SyntaxParsingException, IOException, ModelAdapterException,
			ParserInvokationException {
		return this.syntaxBeanWithConfig;
	}


}
