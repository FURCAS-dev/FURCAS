/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-09-22 12:36:22 +0200 (Di, 22 Sep 2009) $
 * @version $Revision: 7950 $
 * @author: $Author: c5126871 $
 *******************************************************************************/
package com.sap.mi.textual.epi.filedefinition;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.mi.textual.common.exceptions.GrammarGenerationException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.exceptions.ParserInvokationException;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.GenerationReport;
import com.sap.mi.textual.util.FileReadHelper;







/**
 * provides a method allowing build tools to write a java.io.File only if a grammar has changed.
 */
public class GrammarWritingHelper {

	/**
	 * Write grammar if changed.
	 * 
	 * @param lookup the lookup
	 * @param syntaxDefFile the syntax def file
	 * @param grammarFile the grammar file
	 * @param qualifiedNamesSeparator 
	 * @param targetPackage 
	 * @param metamodelPRIs 
	 * 
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SyntaxParsingException the syntax parsing exception
	 * @throws ModelAdapterException the model handler exception
	 * @throws GrammarGenerationException the grammar generation exception
	 */
	public static Collection<String> writeGrammarIfChanged( IMetaModelLookup<?> lookup, File syntaxDefFile, File grammarFile, String qualifiedNamesSeparator, String targetPackage, ResourceSet connection, Set<URI> metamodelPRIs) throws FileNotFoundException,
	IOException, ModelAdapterException, GrammarGenerationException {
	    ArrayList<String> warnings = new ArrayList<String>();
		// byte array target for grammar file
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		InputStream in = new FileInputStream(syntaxDefFile);

		// target file for grammar
		byte[] oldBytes = FileReadHelper.readBytesFromFile(grammarFile);

		TCSInputStreamGrammarGenerator generator = new TCSInputStreamGrammarGenerator( in, out, lookup, targetPackage);
		
		GenerationReport report = null;
		try {
			report = generator.generateGrammar(connection, metamodelPRIs, null);
			if (report != null && report.getErrors() != null
					&& report.getErrors().size() > 0) {
				throw new GrammarGenerationException(
						"Errors generating grammar for "
								+ syntaxDefFile.getName() + ":\n"
								+ report.getErrors());
			}
			Set<ParsingError> warningErrors = report.getWarnings();
			for (Iterator<ParsingError> iterator = warningErrors.iterator(); iterator
					.hasNext();) {
				ParsingError parsingError = iterator.next();
				warnings.add("Warning: " + parsingError.getMessage()
						+ " in line " + parsingError.getLine());
			}
		} catch (ParserInvokationException e) {
			throw new GrammarGenerationException("Generated Parser problem.", e);
		} catch (SyntaxParsingException e) {
			throw new GrammarGenerationException("Syntax errors parsing "
					+ syntaxDefFile.getName(), e);
		} finally {
			if (report != null) {
				if (report.getSyntax() != null) {
					EcoreUtil.delete(report.getSyntax(), true);
				}
			}
			out.flush();
			out.close();
		}
		// compare old bytes with new bytes (to avoid overwriting 
		//file with same contents, as this is annoying in Eclipse)
		byte[] newBytes = out.toByteArray();
		if (oldBytes == null  || ! Arrays.equals(oldBytes, newBytes)) { // grammar has changed or is new
//			FileOutputStream grammarFileOut = new FileOutputStream(GENERATIONDIR+LANGUAGE+".g");
			FileWriter writer = new FileWriter(grammarFile);
			writer.write(out.toString());
			writer.flush();
			writer.close();

		}
        return warnings;

	}

   

	
}