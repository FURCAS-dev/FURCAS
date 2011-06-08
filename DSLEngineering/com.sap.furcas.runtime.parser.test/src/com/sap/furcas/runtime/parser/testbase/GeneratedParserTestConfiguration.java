package com.sap.furcas.runtime.parser.testbase;

import static com.sap.furcas.runtime.common.util.FileResourceHelper.getResourceSetAsScope;
import static com.sap.furcas.runtime.common.util.FileResourceHelper.loadResourceSet;

import java.io.File;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.test.testutils.ResourceTestHelper;

/**
 * This class serves as a configuration for the {@link GeneratedParserBasedTest}.
 * It configures where to generate the grammar, the parser and the lexer.
 * 
 * @author Stephan Erb
 * 
 */
public class GeneratedParserTestConfiguration {

    protected static final String DEFAULT_GENERATIONDIR_SOURCEROOT = "./generationTemp";
    protected static final String DEFAULT_PACKAGE = "generated";
    protected static final String DEFAULT_GENERATIONDIR = DEFAULT_GENERATIONDIR_SOURCEROOT + "/" + DEFAULT_PACKAGE + "/";
    
    protected static final String ANTLR_GRAMMAR_SUFFIX = ".g";
    
    protected final ResourceSet resourceSet;
    protected final Set<URI> referenceScope;
    protected final String languageName;
    protected final File syntaxDefFile;
    protected final String packageName;
    protected final String generationDir;
    protected final File grammarFile;
    

    /**
     * A default configuration that dumps everything into the "generated" package in the
     * "generationTemp" source folder.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * 
     * @throws MetaModelLookupException
     */
    public GeneratedParserTestConfiguration(String languageName, File syntaxDefFile, File... metamodels) throws MetaModelLookupException {
        this.languageName = languageName;
        this.syntaxDefFile = syntaxDefFile;
        this.generationDir = DEFAULT_GENERATIONDIR;
        this.packageName = DEFAULT_PACKAGE;
        
        grammarFile = createGrammarFile(languageName);
        resourceSet = loadResourceSet(metamodels);
        referenceScope = ResourceTestHelper.createEcoreReferenceScope();
        referenceScope.addAll(getResourceSetAsScope(resourceSet));
    }

    /**
     * A more advanced configuration that allows to alter the generation target.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param generationDir a relative path to the directoy where all generated files (grammar, lexer, parser) shall be written to
     * @param packageName the Java interpretation generationDir in form of the package name.
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * 
     * @throws MetaModelLookupException
     */
    public GeneratedParserTestConfiguration(String languageName, File syntaxDefFile, String generationDir, String packageName, Set<URI> metamodels) throws MetaModelLookupException {
        this.languageName = languageName;
        this.syntaxDefFile = syntaxDefFile;
        this.generationDir = generationDir;
        this.packageName = packageName;
        
        grammarFile = createGrammarFile(languageName);
        resourceSet = ResourceTestHelper.createResourceSet();
        referenceScope = ResourceTestHelper.createEcoreReferenceScope();
        referenceScope.addAll(metamodels);
    }
    
    private File createGrammarFile(String language) {
        return new File(generationDir + language + ANTLR_GRAMMAR_SUFFIX);
    }
        
    public GrammarGenerationTargetConfiguration getTargetConfiguration() {
        return new GrammarGenerationTargetConfiguration(packageName, grammarFile);
    }
    
    public GrammarGenerationSourceConfiguration getSourceConfiguration() {
        return new GrammarGenerationSourceConfiguration(resourceSet, referenceScope);
    }
    
    public String getRelativePathToGeneratedParserClass() {
        return generationDir + languageName + "Parser.java";
    }
    
    public String getRelativePathToGeneratedLexerClass() {
        return generationDir + languageName + "Lexer.java";
    }
    
    public String getLanguageName(){
        return languageName;
    }
    
    public String getRelativePathToGeneratedFiles(){
        return generationDir;
    }
    
    public String getParserName(){
        return languageName + "Parser";
    }
    
    public String getLexerName(){
        return languageName + "Lexer";
    }
    
    public String getClassNameOfCompiledLexer() {
        return packageName + "." + getLexerName();
    }
    
    public String getClassNameOfCompiledParser() {
        return packageName + "." + getParserName();
    }
    
    public File getSyntaxDefinitionFile(){
        return syntaxDefFile;
    }
}
