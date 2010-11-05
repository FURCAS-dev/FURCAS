package com.sap.furcas.parsergenerator;

import java.io.File;

/**
 * Configuration bean for the {@link TCSParserGenerator}. It is basically
 * used to configure where generated grammars and parsers shall be stored.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class GrammarGenerationTargetConfiguration {

    private final String parserPackageName;
    private final File grammarFile;

    
    /**
     * 
     * @param parserPackageName
     *          the name of the Java package where the generate parser/lexer class
     *          shall later be used in (e.g. "generated" or "com.sap.furcas.parser.tcs.unstable").
     * @param grammarFile
     *          the ANTLR grammar File (e.g. Foo.g)
     */
    public GrammarGenerationTargetConfiguration(String parserPackageName, File grammarFile) {
        this.parserPackageName = parserPackageName;
        this.grammarFile = grammarFile;
    }
        
    public File getGrammarTargetFile() {
        return grammarFile;
    }

    public String getParserTargetPackageName() {
        return parserPackageName;
    }

}
