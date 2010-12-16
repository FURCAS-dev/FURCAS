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

import org.eclipse.emf.ecore.resource.ResourceSet;

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

    private final String metamodelPackageName;

    /**
     * A default configuration that dumps everything into the "generated" package in the
     * "generationTemp" source folder.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param metamodelPackageName the name of the top-level package within the main metamodel file
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * 
     * @throws MetaModelLookupException
     */
    public GeneratedParserAndFactoryTestConfiguration(String languageName, File syntaxDefFile, String metamodelPackageName, File... metamodels) throws MetaModelLookupException {
        this(languageName, syntaxDefFile, DEFAULT_GENERATIONDIR, DEFAULT_PACKAGE, metamodelPackageName, metamodels);
    }

    /**
     * A more advanced configuration that allows to alter the generation target.
     * 
     * @param languageName the name of the language as specified in the tcs-File
     * @param syntaxDefFile the tcs-File
     * @param generationDir a relative path to the directoy where all generated files (grammar, lexer, parser) shall be written to
     * @param packageName the Java interpretation generationDir in form of the package name.
     * @param metamodelPackageName the name of the top-level package within the main metamodel file
     * @param metamodels the metamodels which are referenced/used within the tcs file.
     * 
     * @throws MetaModelLookupException
     */
    public GeneratedParserAndFactoryTestConfiguration(String languageName, File syntaxDefFile, String generationDir, String packageName, String metamodelPackageName, File... metamodels) throws MetaModelLookupException {
        super(languageName, syntaxDefFile, generationDir, packageName, metamodels);
        this.metamodelPackageName = metamodelPackageName;
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

    public String getMetamodelPackageName() {
        return metamodelPackageName;
    }
    
    public ResourceSet getResourceSet() {
        return resourceSet;
    }
    
}
