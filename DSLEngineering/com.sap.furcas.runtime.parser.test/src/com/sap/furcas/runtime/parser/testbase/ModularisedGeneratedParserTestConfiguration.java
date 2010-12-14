package com.sap.furcas.runtime.parser.testbase;

import java.io.File;
import java.util.List;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

public class ModularisedGeneratedParserTestConfiguration extends
		GeneratedParserTestConfiguration {
	private List<File> syntaxDefFiles;

	/**
     * A more advanced configuration that allows to alter the generation target.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param generationDir a relative path to the directory where all generated files (grammar, lexer, parser) shall be written to
     * @param packageName the Java interpretation generationDir in form of the package name.
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * @param syntaxDefFiles the list of the (imported) tcs file.
     * 
     * @throws MetaModelLookupException
     */
	public ModularisedGeneratedParserTestConfiguration(String languageName,
			File syntaxDefFile, String generationDir, String packageName,
			File[] metamodels, List<File> syntaxDefFiles) throws MetaModelLookupException {
		super(languageName, syntaxDefFile, generationDir, packageName, metamodels);
		this.syntaxDefFiles = syntaxDefFiles;
		
	}

	public List<File> getSyntaxDefFiles() {
		return syntaxDefFiles;
	}
	


	
}
