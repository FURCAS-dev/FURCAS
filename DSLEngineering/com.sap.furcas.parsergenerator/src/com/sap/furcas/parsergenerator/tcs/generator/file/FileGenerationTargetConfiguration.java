package com.sap.furcas.parsergenerator.tcs.generator.file;

import org.eclipse.core.resources.IFile;

public class FileGenerationTargetConfiguration {

    private final String parserPackageName;
    private final IFile grammarFile;
    private final IFile mappingFile;

    public FileGenerationTargetConfiguration(String parserPackageName, IFile grammarFile, IFile mappingFile) {
        this.parserPackageName = parserPackageName;
        this.grammarFile = grammarFile;
        this.mappingFile = mappingFile;
    }
    
    public IFile getGrammarTargetFile() {
        return grammarFile;
    }

    public String getParserTargetPackageName() {
        return parserPackageName;
    }

    public IFile getMappingTargetFile() {
        return mappingFile;
    }

}
