/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser.incremental.testbase;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;

/**
 * This class serves as a configuration for the {@link GeneratedParserAndFactoryBasedTest}.
 * It configures where to generate the grammar, the parser, the lexer and the parser factory.
 * 
 * @author Stephan Erb
 * 
 */
public class GeneratedParserAndFactoryTestConfiguration extends GeneratedParserTestConfiguration {

    private final Set<URI> additionalQueryScope;

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
    public GeneratedParserAndFactoryTestConfiguration(String languageName, File syntaxDefFile, File... metamodels)
           throws MetaModelLookupException {
        
        super(languageName, syntaxDefFile, metamodels);
        this.additionalQueryScope = Collections.emptySet();
    }
    
    /**
     * A default configuration that dumps everything into the "generated" package in the
     * "generationTemp" source folder.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * @param additionalQueryScope resources which shall explicitly be added to the lookup scope of the parser.  
     * 
     * @throws MetaModelLookupException
     */
    public GeneratedParserAndFactoryTestConfiguration(String languageName, File syntaxDefFile, Set<URI> metamodels,
            Set<URI> additionalQueryScope) throws MetaModelLookupException {
        
        this(languageName, syntaxDefFile, DEFAULT_GENERATIONDIR, DEFAULT_PACKAGE, metamodels, additionalQueryScope);
    }

    /**
     * A more advanced configuration that allows to alter the generation target.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param generationDir a relative path to the directoy where all generated files (grammar, lexer, parser) shall be written to
     * @param packageName the Java interpretation generationDir in form of the package name.
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * @param additionalQueryScope resources which shall explicitly be added to the lookup scope of the parser.  
     * 
     * @throws MetaModelLookupException
     */
    public GeneratedParserAndFactoryTestConfiguration(String languageName, File syntaxDefFile, String generationDir,
            String packageName, Set<URI> metamodels, Set<URI> additionalQueryScope) throws MetaModelLookupException {
        
        super(languageName, syntaxDefFile, generationDir, packageName, metamodels);
        this.additionalQueryScope = additionalQueryScope;
    }
        
    public String getRelativePathToGeneratedParserFactoryClass() {
        return generationDir + languageName + "ParserFactory.java";
    }
    
    public String getParserFactoryName(){
        return languageName + "ParserFactory";
    }
    
    public String getClassNameOfCompiledParserFactory() {
        return packageName + "." + getParserFactoryName();
    }
    
    public Collection<URI> getAdditionalQueryScope() {
        return additionalQueryScope;
    }

}
