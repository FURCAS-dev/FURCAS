package com.sap.furcas.parsergenerator.tcs.t2m;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.parsergenerator.emf.tcs.inject.ModelInjectionResult;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

public class InputStreamBasedConfigurationGrammarGenerator extends
		AbstractTCSGrammarGenerator {

	/** The syntax definition stream. */
	private final InputStream syntaxConfigurationStream;
	
	private Collection<InputStream> definitionInputStream;

	/**
	 * Instantiates a new TCS input stream grammar generator.
	 * 
	 * @param syntaxDefinitionStream
	 *            the syntax definition stream
	 * @param outputStream
	 * @param lookup
	 * @param targetPackage
	 *            the name of the java package the generated java class will be
	 *            placed into. It is required to prevent compilation errors.
	 * 
	 */
	public InputStreamBasedConfigurationGrammarGenerator(
			Collection<InputStream> definitionInputStream,
			InputStream syntaxConfigurationStream, OutputStream outputStream,
			IMetaModelLookup<?> lookup, String targetPackage) {
		super(outputStream, lookup, targetPackage);
		this.syntaxConfigurationStream = syntaxConfigurationStream;
		this.definitionInputStream = definitionInputStream;
	}

	private TCSSyntaxContainerBeanWithConfig injectTCSModel(
			InputStream syntaxConfigurationStream,
			Collection<InputStream> definitionInputStreams,
			ResourceSet resourceSet, Set<URI> referenceScope)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException, SyntaxParsingException {

		TCSSyntaxContainerBeanWithConfig returnBean = new TCSSyntaxContainerBeanWithConfig();

		// By choosing this injector, we establish the dependency to EMF.
		for (InputStream inputStream : definitionInputStreams) {
			// parse each syntax defined in the interface configuration
			ModelInjectionResult result = TCSSpecificEMFModelInjector
					.parseSyntaxDefinition(inputStream, resourceSet,
							referenceScope, /* observer */null);

			// to add the active syntax as the main syntax
			if (result.getSyntax().getRequiredTemplates() != null
					&& !result.getSyntax().getRequiredTemplates().isEmpty()) {
				returnBean.setSyntax(result.getSyntax());
				returnBean.setKeywords(result.getKeywords());
				returnBean.setElementToLocationMap(result.getResult()
						.getLocationMap());
				// setting the configuration
				returnBean.setConfiguration((Configuration) result.getResult()
						.getParsedModelElement());
			}

			List<ParsingError> errors = result.getResult().getErrors();
			if (errors != null && errors.size() > 0) {
				if (result.getSyntax() != null) {
					// also clean up unfinished syntax
					EcoreUtil.delete(result.getSyntax(), /* recursive */true);
				}
				throw new SyntaxParsingException(errors);
			}
		}

		//parse the configuration
		ModelInjectionResult result = TCSSpecificEMFModelInjector
				.parseSyntaxDefinitionForConfiguration(syntaxConfigurationStream,
						resourceSet, referenceScope, /* observer */null);

		List<ParsingError> errors = result.getResult().getErrors();
		if (errors != null && errors.size() > 0) {
			if (result.getSyntax() != null) {
				// also clean up unfinished syntax
				EcoreUtil.delete(result.getSyntax(), /* recursive */true);
			}
			throw new SyntaxParsingException(errors);
		}
		return returnBean;
	}


	@Override
	protected TCSSyntaxContainerBeanWithConfig doGetSyntaxDef(
			ResourceSet resourceSet, Set<URI> referenceScope)
			throws SyntaxParsingException, IOException, ModelAdapterException,
			ParserInvokationException {
		try {
			return injectTCSModel(syntaxConfigurationStream,definitionInputStream,
					 resourceSet, referenceScope);
		} catch (IllegalArgumentException e) {
			throw new ParserInvokationException(e);
		} catch (SecurityException e) {
			throw new ParserInvokationException(e);
		} catch (UnknownProductionRuleException e) {
			throw new ParserInvokationException(e);
		} catch (InvalidParserImplementationException e) {
			throw new ParserInvokationException(e);
		}
	}

	@Override
	protected TCSSyntaxContainerBeanWithConfig doGetSyntaxDef(
			ResourceSet connection, Set<URI> metamodelPRIs, String languageId)
			throws SyntaxParsingException, IOException, ModelAdapterException,
			ParserInvokationException {
		return doGetSyntaxDef(connection, metamodelPRIs);
	}

}
