package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.parsergenerator.emf.tcs.inject.ModelInjectionResult;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * The SyntaxParser parses a TCS file and returns a TCSSyntaxContainerBean that
 * contains the ConcreteSyntax. It is used by the {@link TCSParsergenerator}.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */
public class SyntaxParser {

	public static TCSSyntaxContainerBean parse(
			GrammarGenerationSourceConfiguration sourceConfiguration,
			File syntaxDefFile) throws ParserInvokationException {

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(syntaxDefFile);

			// By choosing this injector, we establish the dependency to EMF.
			ModelInjectionResult result = TCSSpecificEMFModelInjector
					.parseSyntaxDefinition(inputStream,
							sourceConfiguration.getResourceSet(),
							sourceConfiguration.getReferenceScope(), /* observer */
							null);

			List<ParsingError> errors = result.getResult().getErrors();
			if (errors != null && errors.size() > 0) {
				if (result.getSyntax() != null) {
					// also clean up unfinished syntax
					EcoreUtil.delete(result.getSyntax(), /* recursive */true);
				}
				throw new ParserInvokationException(new SyntaxParsingException(
						errors));
			}

			TCSSyntaxContainerBean returnBean = new TCSSyntaxContainerBean();
			returnBean.setSyntax((ConcreteSyntax) result.getResult()
					.getParsedModelElement());
			returnBean.setKeywords(result.getKeywords());
			returnBean.setElementToLocationMap(result.getResult()
					.getLocationMap());

			return returnBean;

		} catch (FileNotFoundException e) {
			throw new ParserInvokationException(e);
		} catch (InvalidParserImplementationException e) {
			throw new ParserInvokationException(e);
		} catch (IOException e) {
			throw new ParserInvokationException(e);
		} catch (UnknownProductionRuleException e) {
			throw new ParserInvokationException(e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				throw new ParserInvokationException(e);
			}
		}

	}

	public static TCSSyntaxContainerBeanWithConfig parseWithConfig(
			GrammarGenerationSourceConfiguration sourceConfiguration,
			File configurationData, Collection<File> syntaxDefFiles)
			throws ParserInvokationException {
		TCSSyntaxContainerBeanWithConfig returnBean = new TCSSyntaxContainerBeanWithConfig();
		InputStream configurationDataStream = null;
		InputStream filesInputStream = null;
		try {

		// By choosing this injector, we establish the dependency to EMF.
		for (File file : syntaxDefFiles) {
				filesInputStream = new FileInputStream(file);
				//parse all the syntaxes used in an configuration with the correspodent parser (TCSParser)
				ModelInjectionResult resultOfList = TCSSpecificEMFModelInjector
						.parseSyntaxDefinition(filesInputStream,
								sourceConfiguration.getResourceSet(),
								sourceConfiguration.getReferenceScope(), /* observer */
								null);
				// to add the active syntax as the main syntax
				// TODO explicitly defined in the configuration?
				if (((ConcreteSyntax) resultOfList.getResult()
						.getParsedModelElement()).getRequiredTemplates() != null
						&& !((ConcreteSyntax) resultOfList.getResult()
								.getParsedModelElement())
								.getRequiredTemplates().isEmpty()) {
					returnBean.setSyntax((ConcreteSyntax) resultOfList
							.getResult().getParsedModelElement());
					returnBean.setKeywords(resultOfList.getKeywords());
					returnBean.setElementToLocationMap(resultOfList.getResult()
							.getLocationMap());
				}

				List<ParsingError> errors = resultOfList.getResult()
						.getErrors();
				if (errors != null && errors.size() > 0) {
					if (resultOfList.getSyntax() != null) {
						// also clean up unfinished syntax
						EcoreUtil.delete(resultOfList.getSyntax(), /* recursive */
						true);
					}
					throw new ParserInvokationException(
							new SyntaxParsingException(errors));
				}
				if (filesInputStream != null) {
					filesInputStream.close();
				}
		}

				// Parse the configuration data with the correspondent
				// parser(SyntaxConfiguration)
				configurationDataStream = new FileInputStream(configurationData);
				ModelInjectionResult result = TCSSpecificEMFModelInjector
						.parseSyntaxDefinitionForConfiguration(
								configurationDataStream,
								sourceConfiguration.getResourceSet(),
								sourceConfiguration.getReferenceScope(), /* observer */
								null);

				// setting the configuration
				returnBean.setConfiguration((Configuration) result.getResult()
						.getParsedModelElement());

				List<ParsingError> errorsOfConfiguration = result.getResult()
						.getErrors();
				if (errorsOfConfiguration != null
						&& errorsOfConfiguration.size() > 0) {
					if (result.getSyntax() != null) {
						// also clean up unfinished syntax
						EcoreUtil
								.delete(result.getSyntax(), /* recursive */true);
					}
					throw new ParserInvokationException(
							new SyntaxParsingException(errorsOfConfiguration));
				}

			} catch (FileNotFoundException e) {
				throw new ParserInvokationException(e);
			} catch (InvalidParserImplementationException e) {
				throw new ParserInvokationException(e);
			} catch (IOException e) {
				throw new ParserInvokationException(e);
			} catch (UnknownProductionRuleException e) {
				throw new ParserInvokationException(e);
			} finally {
				try {
					if (configurationDataStream != null) {
						configurationDataStream.close();
					}
				} catch (IOException e) {
					throw new ParserInvokationException(e);
				}
			}
		return returnBean;
	}
}
