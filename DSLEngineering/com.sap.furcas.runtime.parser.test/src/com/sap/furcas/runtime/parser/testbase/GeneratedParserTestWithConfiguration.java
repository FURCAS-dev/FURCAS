package com.sap.furcas.runtime.parser.testbase;

import java.io.File;
import java.util.List;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

public class GeneratedParserTestWithConfiguration extends GeneratedParserTestConfiguration {
	private List<File> syntaxDefFiles;
	public GeneratedParserTestWithConfiguration(String languageName,
			File configurationFile, String generationDir, String packageName,
			File[] metamodels, List<File> syntaxDefFiles )
			throws MetaModelLookupException {
		super(languageName, configurationFile, generationDir, packageName, metamodels);
		this.syntaxDefFiles = syntaxDefFiles;
	}
	
	public List<File> getSyntaxDefFiles() {
		return syntaxDefFiles;
	}
	public void setSyntaxDefFiles(List<File> syntaxDefFiles) {
		this.syntaxDefFiles = syntaxDefFiles;
	}

	  
}
