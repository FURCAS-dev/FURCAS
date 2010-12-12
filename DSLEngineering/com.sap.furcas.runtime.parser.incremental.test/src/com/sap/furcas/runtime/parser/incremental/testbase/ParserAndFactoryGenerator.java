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

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.testbase.ClassLookup;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParserGenerator;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sun.tools.javac.Main;

/**
 * A class that allows to generate a language specific parser and parserfactory from a given TCS file.
 * Its methods must be called in the follwoing order:
 * 
 *      generateGrammar(),
 *      generateParser(),
 *      generateParserFactory()
 *      compileParser(),
 *      compileParserFactory(),
 *      loadParserFacade().
 * 
 * The class is configured (what to create, where to create it, ...) with the help
 * {@link GeneratedParserTestConfiguration}. It is used by the {@link GeneratedParserBasedTest}.
 * 
 * @author Stephan Erb
 */
public class ParserAndFactoryGenerator extends ParserGenerator {


    private final GeneratedParserAndFactoryTestConfiguration testConfig;

    public ParserAndFactoryGenerator(GeneratedParserAndFactoryTestConfiguration testConfig) {
        super(testConfig);
        this.testConfig = testConfig;
    }
    
    public void generateParserFactory() {
        try {
            File parserFactoryFile = new File(testConfig.getRelativePathToGeneratedParserFactoryClass());
            PrintStream out = new PrintStream(new FileOutputStream(parserFactoryFile));

            out.println("package " + testConfig.getTargetConfiguration().getParserTargetPackageName() + ";");

            out.println("import " + testConfig.getClassNameOfCompiledLexer() + ";");
            out.println("import " + testConfig.getClassNameOfCompiledParser() + ";");

            out.println("import com.sap.furcas.ide.parserfactory.AbstractParserFactory;");
            out.println("import org.eclipse.emf.ecore.resource.ResourceSet;");
            out.println("import org.eclipse.emf.ecore.EPackage;");

            out.println("public class " + testConfig.getParserFactoryName() + " extends AbstractParserFactory<"
                    + testConfig.getParserName() + ", " + testConfig.getLexerName() + "> { ");

            out.println("       private static final String CLASS_LANGUAGE_ID = \"" + testConfig.getLanguageName() + "\"; ");

            out.println("       @Override");
            out.println("    public String[] getHiddenChannelTokenNames() {");
            out.println("       return new String[] { \"WS\", \"NL\", \"COMMENT\" };");
            out.println("    }");

            out.println("       @Override ");
            out.println("       public Class<" + testConfig.getLexerName()
                    + "> getLexerClass() { ");
            out.println("               return " + testConfig.getLexerName() + ".class;");
            out.println("       } ");

            out.println("       @Override ");
            out.println("       public Class<" + testConfig.getParserName()
                    + "> getParserClass() { ");
            out.println("               return " + testConfig.getParserName() + ".class;");
            out.println("       } ");

            out.println("       @Override ");
            out.println("       public String getLanguageId() { ");
            out.println("               return CLASS_LANGUAGE_ID;");
            out.println("       }");

            out.println("       @Override");
            out.println("       public EPackage"
                    + " getMetamodelPackage(ResourceSet connection) {");
            out.println("           EPackage pck = EPackage.Registry.INSTANCE.getEPackage(\""
                    + testConfig.getMetamodelPackageName() + "\");");
            out.println("               return pck;");
            out.println("       } ");

            out.println("}");

            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("Failed to generate parser factory: " + e.getMessage());
        }

    }
    
    public void compileParserFactory() {
        ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();
        PrintStream systemErrOld = redirectSystemErrTo(errByteStream);
        try {
            int success = Main.compile(new String[] {
                    testConfig.getRelativePathToGeneratedParserFactoryClass(),
                    testConfig.getRelativePathToGeneratedParserClass(),
                    testConfig.getRelativePathToGeneratedLexerClass(),
                    "-cp",
                    getSourceRoot(AbstractParserFactory.class)
                    + File.pathSeparator + getSourceRoot(ResourceSet.class)
                    + File.pathSeparator + getSourceRoot(Notifier.class)
                    + File.pathSeparator + getSourceRoot(ANTLRParserFactory.class)
                    + File.pathSeparator + getSourceRoot(ITokenFactory.class)
                    + File.pathSeparator + getSourceRoot(RuleNameFinder.class)
                    + File.pathSeparator + getSourceRoot(IModelElementProxy.class)
                    + File.pathSeparator + getSourceRoot(Lexer.class) });
            if (success != 0) {
                fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
            }
        } finally {
            restoreOldSystemErr(systemErrOld);
        }
    }
    
    private static String getSourceRoot(Class<?> c) {
        try {
            String classContainerPath = URLDecoder.decode(c
                    .getProtectionDomain().getCodeSource().getLocation()
                    .getPath(), "UTF-8");
            if (!classContainerPath.endsWith(".jar")) {
                classContainerPath += "bin/";
            }

            return new File(classContainerPath).getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public IncrementalParserFacade loadIncrementalParserFacade(ClassLookup classLookup, EditingDomain editingDomain,
            OppositeEndFinder oppositeEndFinder) throws ParserGeneratorInvocationException, InstantiationException,
            IllegalAccessException {

        AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory =
            loadParserFactory(classLookup).newInstance();

        ResourceSet resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        Set<URI> referenceScope = testConfig.getSourceConfiguration().getReferenceScope();
        
        IModelAdapter modelAdapter = new TextBlocksAwareModelAdapter(new EMFModelAdapter(
            parserFactory.getMetamodelPackage(resourceSet),resourceSet, referenceScope));

        return new IncrementalParserFacade(parserFactory, modelAdapter, editingDomain, referenceScope, oppositeEndFinder);
    }

    @SuppressWarnings("unchecked")
    private Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>> loadParserFactory(
            ClassLookup classLookup) throws ParserGeneratorInvocationException {
        try {
            // try loading compiled classes
            Class<?> parserFactoryClass = classLookup.loadClass(testConfig.getClassNameOfCompiledParserFactory());
            return (Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>>) parserFactoryClass;
        } catch (ClassNotFoundException cnfe) {
            throw new ParserGeneratorInvocationException("Can't find generated class "
                    + testConfig.getClassNameOfCompiledParserFactory() + ". Try to do an Eclipse refresh on the project.", cnfe);
        }
    }

}
