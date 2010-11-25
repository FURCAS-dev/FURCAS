package com.sap.furcas.ide.projectwizard.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.antlr.stringtemplate.StringTemplate;

import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;


/**
 * 
 * Encapsulates all methods providing source code needed in the process of creating a new DSL with the {@link FurcasWizard}. All
 * information needed for the generic source code generation is retrieved from the associated {@link ProjectInfo}. It uses the
 * method readFile() to read the files in the resources folder. StringTemplate is now used to replace certain variables in the
 * code by the values entered in the wizard.
 * 
 * @author C5126086 Martin Kuester and D054528 Frederik Petersen
 * 
 */
public class SourceCodeFactory {

    /* Reads a file from the resources folder into the returned string. */
    private String readFile(String filename) throws IOException {
        String path = "/resources/" + filename;
        InputStream iS = getClass().getResourceAsStream(path);
        return convertStreamToString(iS);
    }

    /* Converts the InputStream into a string. */
    public String convertStreamToString(InputStream is) throws IOException {
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
    
    public void writeToFile(InputStream is, File file) {
        try {
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                int c;
                while((c = is.read()) != -1) {
                        out.writeByte(c);
                }
                is.close();
                out.close();
        }
        catch(IOException e) {
                System.err.println("Error Writing/Reading Streams.");
        }
}

    /*
     * All the following methods, import the contents of the sample text files in the resources folder into a StringTeamplate. The
     * keywords in the Strings are then replaced by the data entered in the wizard.
     */

    protected String createManifest(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("manifest.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createBuildProbCode() {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("buildprob.txt");
            template = new StringTemplate(templateString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createEditorCode(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("editor.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template.toString();
    }

    public String createGenmodelCode(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("genmodel.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createMapperCode(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("mapper.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createActivator(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("activator.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createPluginXML(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("pluginxml.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createdPropertiesCode(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("genprops.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return template.toString();
    }

    public String createSampleTCS(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("tcs.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return template.toString();
    }

    protected String createParserFactory(ProjectInfo pi) {
        StringTemplate template = null;
        String templateString = null;
        try {
            templateString = readFile("parserfactory.txt");
            template = new StringTemplate(templateString);
            setTemplateAtts(template, pi);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return template.toString();
    }

    private void setTemplateAtts(StringTemplate template, ProjectInfo pi) {
        String mmRef = ",\n " + pi.getProjectName() + ".metamodel;bundle-version=\"1.0.0\"";
        String wsRef = ",\n " + pi.getMmProject();
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        template.setAttribute("LangName", pi.getLanguageName());
        template.setAttribute("FirstClass", pi.getClassName());
        template.setAttribute("Dollar", "$");
        template.setAttribute("CapLangName", capLangName);
        template.setAttribute("ProjectName", pi.getProjectName());
        template.setAttribute("URI", pi.getNsURI());
        template.setAttribute("Ext", pi.getFileExtension());
        template.setAttribute("Path", pi.getBasePath());
        template.setAttribute("TCSPath", "generated/generated/" + pi.getLanguageName() + ".tcs");
        if (pi.isLoadMetamodel()){
            if (pi.isFromWorkspace())
                template.setAttribute("MMRef", wsRef);                                
        }
        else
            template.setAttribute("MMRef", mmRef);
    }

}
