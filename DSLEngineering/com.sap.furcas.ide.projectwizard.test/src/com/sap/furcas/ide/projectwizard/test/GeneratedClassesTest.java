package com.sap.furcas.ide.projectwizard.test;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.Platform;
import org.junit.Test;
import org.osgi.framework.Bundle;

import com.sap.furcas.ide.projectwizard.util.CodeGenerationException;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;
import com.sap.furcas.ide.projectwizard.util.SourceCodeFactory;
import com.sun.tools.javac.Main;

public class GeneratedClassesTest {

    @Test
    public void compileGeneratedClasses() {
        ProjectInfo pi = new ProjectInfo();
        configureProjectInfo(pi);
        SourceCodeFactory codeFactory = new SourceCodeFactory();
        generateClasses(codeFactory, pi);
        ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();
        PrintStream systemErrOld = redirectSystemErrTo(errByteStream);
        String requiredBundles = getRequiredBundles();
        try {
            int success = Main.compile(new String[] { "./generationTemp/generated/MydslTokenMapper.java",
                    "./generationTemp/generated/MydslParserFactory.java", "./generationTemp/generated/MydslEditor.java",
                    "./generationTemp/generated/Activator.java", "-cp", requiredBundles });
            if (success != 0) {
                fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
            }
        } finally {
            restoreOldSystemErr(systemErrOld);
            cleanGenerationFolder();
        }
    }

    private String getRequiredBundles() {
        String eclipsePath = System.getProperty("target.location");
        StringBuffer requiredBundles = new StringBuffer("../com.sap.furcas.ide.editor/bin" + File.pathSeparator
                + "../org.antlr/bin" + File.pathSeparator + "../com.sap.furcas.runtime.parser.incremental/bin"
                + File.pathSeparator + "../com.sap.ide.treeprovider/bin" + File.pathSeparator
                + "../com.sap.ap.cts.refactoring/bin" + File.pathSeparator + "../com.sap.furcas.metamodel/bin"
                + File.pathSeparator + "../de.hpi.sam.bp2009.ngpm/bin" + File.pathSeparator + "../com.sap.furcas.runtime.tcs/bin"
                + File.pathSeparator + "../com.sap.furcas.ide.parserfactory/bin" + File.pathSeparator
                + "../com.sap.furcas.runtime.common/bin" + File.pathSeparator + "../com.sap.furcas.runtime.parser/bin"
                + File.pathSeparator + "../com.sap.furcas.ide.projectwizard.test/lib/static" + File.pathSeparator
                + "./lib/org.eclipse.swt.gtk.linux.x86_64_3.6.1.v3655c.jar" + File.pathSeparator + eclipsePath);

        String[] bundles = new String[] { "org.eclipse.jface.text", "org.eclipse.ui", "org.eclipse.core.runtime",
                "org.eclipse.ui.editors", "org.eclipse.core.resources", "org.eclipse.emf.ecore", "org.eclipse.emf.common",
                "org.eclipse.ui.workbench", "org.eclipse.osgi" };
        for (int i = 0; i < bundles.length; i++) {
            String bundlePath = null;
            Bundle bundle = Platform.getBundle(bundles[i]);
            String bundleJarName = bundle.toString().split(" ")[0] + ".jar";
            if (eclipsePath.contains("/"))
                bundlePath = eclipsePath+"/plugins/"+bundleJarName;
            else
                bundlePath = eclipsePath+"\\plugins\\"+bundleJarName;
                

            requiredBundles.append(File.pathSeparator + bundlePath);
        }

        return requiredBundles.toString();
    }

    private void cleanGenerationFolder() {
        File file = new File("./generationTemp/generated/MydslTokenMapper.java");
        file.delete();
        file = new File("./generationTemp/generated/MydslEditor.java");
        file.delete();
        file = new File("./generationTemp/generated/MydslParserFactory.java");
        file.delete();
        file = new File("./generationTemp/generated/Activator.java");
        file.delete();
        file = new File("./generationTemp/generated/MydslTokenMapper.class");
        file.delete();
        file = new File("./generationTemp/generated/MydslEditor.class");
        file.delete();
        file = new File("./generationTemp/generated/MydslParserFactory.class");
        file.delete();
        file = new File("./generationTemp/generated/Activator.class");
        file.delete();

    }

    private void generateClasses(SourceCodeFactory codeFactory, ProjectInfo pi) {
        String contents = null;

        String thisPath = "../com.sap.furcas.ide.projectwizard.test/generationTemp/generated/";
        String filename = "MydslTokenMapper.java";
        try {
            contents = codeFactory.createMapperCode(pi);
            generateClass(codeFactory, thisPath, filename, contents);
        } catch (CodeGenerationException e1) {
            e1.printStackTrace();
        }

        filename = "MydslEditor.java";
        try {
            contents = codeFactory.createEditorCode(pi);
            generateClass(codeFactory, thisPath, filename, contents);
        } catch (CodeGenerationException e1) {
            e1.printStackTrace();
        }

        filename = "Activator.java";
        try {
            contents = codeFactory.createActivator(pi);
            generateClass(codeFactory, thisPath, filename, contents);
        } catch (CodeGenerationException e1) {
            e1.printStackTrace();
        }

        filename = "MydslParserFactory.java";
        try {
            contents = codeFactory.createParserFactory(pi);
            generateClass(codeFactory, thisPath, filename, contents);
        } catch (CodeGenerationException e1) {
            e1.printStackTrace();
        }

    }

    /**
     * @param codeFactory
     * @param thisPath
     * @param filename
     * @param contents
     */
    private void generateClass(SourceCodeFactory codeFactory, String thisPath, String filename, String contents) {
        InputStream is = null;
        File file = new File(thisPath + filename);
        try {

            is = new ByteArrayInputStream(contents.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        codeFactory.writeToFile(is, file);
    }

    private static void configureProjectInfo(ProjectInfo pi) {
        pi.setLoadMetamodel(false);
        pi.setClassName("ExampleClass");
        pi.setFileExtension("dsl");
        pi.setFromWorkspace(true);
        pi.setLanguageName("Mydsl");
        pi.setModelPath("new");
        pi.setNsURI("http://www.example.com/mydsl");
        pi.setProjectName("my.dsl");

    }

    private static PrintStream redirectSystemErrTo(ByteArrayOutputStream errByteStream) {
        PrintStream originalSystemErr = System.err;
        System.setErr(new PrintStream(errByteStream));
        return originalSystemErr;
    }

    private static void restoreOldSystemErr(PrintStream systemErr) {
        System.setErr(systemErr);
    }

}
