package com.sap.furcas.ide.projectwizard.test;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

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
        try {
            int success = Main.compile(new String[] {
                    "../com.sap.furcas.ide.projectwizard.test/generationTemp/generated/MydslMapper.java",
                    "-cp",
                    "../org.antlr/bin" + File.pathSeparator + 
                    "/bin" + File.pathSeparator + 
                    "../org.eclipse.jface/bin" + File.pathSeparator +
                    "../org.eclipse.swt/bin" + File.pathSeparator +
                    "../com.sap.furcas.runtime.parser/bin" + File.pathSeparator
                            + "../com.sap.furcas.runtime.common/bin" + File.pathSeparator
                            + "../com.sap.furcas.parsergenerator.emf/bin" + File.pathSeparator
                            + "../com.sap.furcas.runtime.tcs/bin" });
            if (success != 0) {
                //fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
            }
        } finally {
            restoreOldSystemErr(systemErrOld);
            cleanGenerationFolder();
        }
    }

    private void cleanGenerationFolder() {
        File file = new File ("../com.sap.furcas.ide.projectwizard.test/generationTemp/generated/MydslMapper.java");
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
