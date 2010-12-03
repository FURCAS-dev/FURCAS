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
            int success = Main
                    .compile(new String[] { "../com.sap.furcas.ide.projectwizard.test/generationTemp/generated/MydslMapper.java",
                            "-cp", requiredBundles });
            if (success != 0) {
                fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
            }
        } finally {
            restoreOldSystemErr(systemErrOld);
            cleanGenerationFolder();
        }
    }

    private String getRequiredBundles() {
        StringBuffer requiredBundles = new StringBuffer("../org.antlr/bin" + File.pathSeparator + "../com.sap.ide.cts.editor");
        String[] bundles = new String[] { "org.eclipse.jface.text", "org.eclipse.swt"};
        for (int i = 0; i < bundles.length; i++) {
            Bundle bundle = Platform.getBundle(bundles[i]);
            requiredBundles.append(File.pathSeparator + bundle.getLocation());
        }
        return requiredBundles.toString();
    }

    private void cleanGenerationFolder() {
        File file = new File("../com.sap.furcas.ide.projectwizard.test/generationTemp/generated/MydslMapper.java");
        file.delete();

    }

    private void generateClasses(SourceCodeFactory codeFactory, ProjectInfo pi) {
        String thisPath = "../com.sap.furcas.ide.projectwizard.test";
        try {
            InputStream is = null;
            String mapper = codeFactory.createMapperCode(pi);
            File file = new File(thisPath + "/generationTemp/generated/MydslMapper.java");
            try {
                is = new ByteArrayInputStream(mapper.getBytes("UTF-8"));
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
        } catch (CodeGenerationException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

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
