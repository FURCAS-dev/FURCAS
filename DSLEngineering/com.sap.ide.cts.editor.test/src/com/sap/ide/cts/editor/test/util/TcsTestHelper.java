package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import generated.TCSParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import tcs.ConcreteSyntax;

import com.sap.mi.textual.epi.util.ProjectSyntaxHelper;
import com.sap.mi.textual.grammar.ParserFacade;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

public class TcsTestHelper {

	public static String getStreamContents(InputStream in) {
		assertNotNull(in);

		try {
			StringBuffer out = new StringBuffer();
			byte[] b = new byte[4096];
			for (int n; (n = in.read(b)) != -1;) {
				out.append(new String(b, 0, n));
			}
			return out.toString();
		} catch (IOException e) {
			e.printStackTrace();
			fail("error reading fixture");
			return null;
		}
	}

	public static ConcreteSyntax getSyntaxFromStream(InputStream in,
			Connection connection, List<String> metaModelContainerNames,
			ParserFacade tcsParserFacade) {
		String content = getStreamContents(in);

		try {
			return (ConcreteSyntax) ProjectSyntaxHelper.createMapping(content,
					connection, metaModelContainerNames, tcsParserFacade);
		} catch (Exception e) {
			e.printStackTrace();
			fail("error creating syntax");
			return null;
		}
	}
	
	public static ConcreteSyntax getSyntaxFromStream(InputStream in,
			Connection connection, Set<PRI> referencePRIs,
			ParserFacade tcsParserFacade) {
		String content = getStreamContents(in);

		try {
			return (ConcreteSyntax) ProjectSyntaxHelper.createMapping(content,
					connection, referencePRIs, tcsParserFacade);
		} catch (Exception e) {
			e.printStackTrace();
			fail("error creating syntax");
			return null;
		}
	}

	public static void assertByLines(String output, String referenceOutput) {
		BufferedReader actualOutputStream = new BufferedReader(
				new StringReader(output));

		BufferedReader referenceOutputStream = new BufferedReader(
				new StringReader(referenceOutput));

		String refLine;
		String actualLine;
		int line = 0;
		try {
			refLine = referenceOutputStream.readLine();
			actualLine = actualOutputStream.readLine();

			while (refLine != null) {
				assertEquals("error in line " + line
						+ ":\n actual output was \n" + output
						+ "\n reference output was \n " + referenceOutput
						+ "\n", refLine, actualLine);
				refLine = referenceOutputStream.readLine();
				actualLine = actualOutputStream.readLine();
				line++;
			}

			if (actualLine != null) {
				fail("error in line " + line + ":\n actual output was \n"
						+ output + "\n reference output was \n "
						+ referenceOutput + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
			fail("error comparing streams");
		}
	}

	public static ConcreteSyntax createTcsSyntaxMappingOnConnection(
			Connection connection) {
		List<String> allMetaModelContainerNames = new ArrayList<String>();
		allMetaModelContainerNames.add("demo.sap.com/tcsmeta");
		return getSyntaxFromStream(TCSParser.class
				.getResourceAsStream("TCS.tcs"), connection,
				allMetaModelContainerNames, null);
	}
}
