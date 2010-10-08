package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ParsingError;
import com.sap.ide.cts.editor.test.util.GeneratedParserBasedTest;
import com.sap.mi.textual.test.util.StubModelAdapter;

/**
 * Abstract test superclass dealing with invocation of interfaces. File is
 * abstract superclass to tests so that BeforeClass and AfterClass methods get
 * executed.
 */
public abstract class ExtendedGeneratedParserBasedTest extends
		GeneratedParserBasedTest {

	protected ModelParsingResult parseString(String sample, String language,
			IModelAdapter modelAdapter) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, IOException, NoSuchFieldException,
			UnknownProductionRuleException,
			InvalidParserImplementationException {

		InputStream charStream = new ByteArrayInputStream(sample.getBytes());
		ModelParsingResult result = generationHelper.parseStream(language,
				charStream, modelAdapter);
		return result;
	}

	protected StubModelAdapter parseString(String sample, String language,
			int expectedErrors) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, IOException, NoSuchFieldException,
			UnknownProductionRuleException,
			InvalidParserImplementationException {
		StubModelAdapter stubModelHandler = new StubModelAdapter();

		InputStream charStream = new ByteArrayInputStream(sample.getBytes());
		doParseFromStream(language, expectedErrors, charStream,
				stubModelHandler);
		return stubModelHandler;
	}

	protected StubModelAdapter parseFile(String dslSampleFile, String LANGUAGE,
			String DSLSAMPLEDIR) throws Exception {
		return parseFile(dslSampleFile, LANGUAGE, DSLSAMPLEDIR, 0);
	}

	protected StubModelAdapter parseFile(String dslSampleFile, String LANGUAGE,
			String DSLSAMPLEDIR, int expectedErrors) throws Exception {

		StubModelAdapter stubModelHandler = new StubModelAdapter();
		parseFile(dslSampleFile, LANGUAGE, DSLSAMPLEDIR, expectedErrors,
				stubModelHandler);
		return stubModelHandler;
	}

	protected void parseFile(String dslSampleFile, String LANGUAGE,
			String DSLSAMPLEDIR, int expectedErrors, IModelAdapter adapter)
			throws Exception {
		InputStream charStream = new FileInputStream(DSLSAMPLEDIR
				+ dslSampleFile);
		doParseFromStream(LANGUAGE, expectedErrors, charStream, adapter);
	}

	/**
	 * @return
	 * @throws InvalidParserImplementationException
	 * @throws IOException
	 */
	protected ParserFacade getParserFacade(String language) throws IOException,
			InvalidParserImplementationException {
		return generationHelper.getFacade(language);
	}

	protected void doParseFromStream(String LANGUAGE, int expectedErrors,
			InputStream in, IModelAdapter modelAdapter) throws IOException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			NoSuchFieldException, UnknownProductionRuleException,
			InvalidParserImplementationException {

		ModelParsingResult result = generationHelper.parseStream(LANGUAGE, in,
				modelAdapter);
		checkModelErrors(expectedErrors, result);
	}

	private void checkModelErrors(int expectedErrors, ModelParsingResult result) {
		// check for parsing errors
		List<ParsingError> errors = result.getErrors();

		if (errors != null && errors.size() > 0) {
			if (expectedErrors != errors.size()) {
				StringBuffer messages = new StringBuffer();
				for (Iterator<ParsingError> iterator = errors.iterator(); iterator
						.hasNext();) {
					ParsingError parsingError = iterator.next();
					messages.append(parsingError.getMessage()).append(
							" in line ").append(parsingError.getLine()).append(
							'\n');
				}
				if (expectedErrors == 0) {
					fail(messages.toString());
				} else { // fail special message if more than 0 errors were
					// expected, so that it is obvious this test indeed
					// intended some errors
					assertEquals("Bad number of errors after parsing\n"
							+ messages.toString(), expectedErrors, errors
							.size());
				}
			}
		} else {
			// fail if expected errors are more than 0
			assertEquals("No errors occured, but errors were expected. ",
					expectedErrors, 0);
		}
	}
}
