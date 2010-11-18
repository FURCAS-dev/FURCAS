package com.sap.furcas.ide.projectwizard.wizards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.antlr.stringtemplate.StringTemplate;

/**
 * 
 * Encapsulates all methods providing source code needed in the process of creating a new DSL with the {@link FurcasWizard}.
 * All information needed for the generic source code generation is retrieved from the associated {@link ProjectInfo}.
 * It uses the method readFile() to read the files in the resources folder. StringTemplate is now used to
 * replace certain variables in the code by the values entered in the wizard.
 * 
 * @author C5126086 Martin Kuester and D054528 Frederik Petersen
 * 
 */
public class SourceCodeFactory {

    /*Reads a file from the resources folder into the returned string.*/
    private String readFile(String filename) throws IOException {
        String path = "/resources/" + filename;
        InputStream iS = getClass().getResourceAsStream(path);
        return convertStreamToString(iS);
    }
    /*Converts the InputStream into a string.*/
    private String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
    
    /* All the following methods, import the contents of the sample text files in the resources folder into
     * a StringTeamplate. The keywords in the Strings are then replaced by the data entered in the wizard. */

    public String createManifest(String projectname) {
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("manifest.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("ProjectName", projectname);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    public String createBuildProbCode() {
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("buildprob.txt");
            tcsTemp = new StringTemplate(templateString);
            // add StringTemplate Attributes here
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createEditorCode(ProjectInfo pi) {
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("editor.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("CapLangName", capLangName);
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }
    
    public String createGenmodelCode(ProjectInfo pi) {
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("genmodel.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("CapLangName", capLangName);
            tcsTemp.setAttribute("LangName", pi.getLanguageName());
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createMapperCode(ProjectInfo pi) {
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("mapper.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("CapLangName", capLangName);
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createActivator(ProjectInfo pi) {
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("activator.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createPluginXML(ProjectInfo pi) {
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("pluginxml.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("CapLangName", capLangName);
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createdPropertiesCode(ProjectInfo pi) {
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("genprops.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
            tcsTemp.setAttribute("LangName", pi.getLanguageName());
            tcsTemp.setAttribute("URI", pi.getNsURI());
            tcsTemp.setAttribute("Ext", pi.getFileExtension());
            tcsTemp.setAttribute("Path", pi.getBasePath());
            tcsTemp.setAttribute("TCSPath", pi.getBasePath() + "/" + pi.getLanguageName() + ".tcs");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createSampleTCS(ProjectInfo pi) {
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("tcs.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("dslname", pi.getLanguageName());
            tcsTemp.setAttribute("FirstClass", "ReplacerMe"); //TODO
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }

    protected String createParserFactory(ProjectInfo pi) {
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        StringTemplate tcsTemp = null;
        String templateString = null;
        try {
            templateString = readFile("parserfactory.txt");
            tcsTemp = new StringTemplate(templateString);
            tcsTemp.setAttribute("CapLangName", capLangName);
            tcsTemp.setAttribute("ProjectName", pi.getProjectName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tcsTemp.toString();
    }
}
