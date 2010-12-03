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
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.antlr.stringtemplate.StringTemplate;

import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

/**
 * 
 * Encapsulates all methods providing source code needed in the process of creating a new DSL with the {@link FurcasWizard}. All
 * information needed for the generic source code generation is retrieved from the associated {@link ProjectInfo}. It uses the
 * method <code>readFile()</code> to read the files in the resources folder. StringTemplate is now used to replace certain
 * variables in the code by the values entered in the wizard.
 * 
 * @author C5126086 Martin Kuester and D054528 Frederik Petersen
 * 
 */
public class SourceCodeFactory {

    /**
     * Reads a file from the resources folder into the returned string.
     * 
     * @param filename
     *            The name of the file located in the resource folder (e.g. tcs.txt).
     * @return The content of the file as a String.
     * @throws CodeGenerationException
     * @throws IOException
     */
    private String readFile(String filename) throws CodeGenerationException {
        String path = "/resources/" + filename;
        InputStream iS = getClass().getResourceAsStream(path);
        return convertStreamToString(iS);

    }

    /**
     * Converts the InputStream into a string.
     * 
     * @param is
     *            InputStream of the resource.
     * @return The content of the Stream in form of a String.
     * @throws CodeGenerationException
     * @throws IOException
     */
    public String convertStreamToString(InputStream is) throws CodeGenerationException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            Reader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } catch (UnsupportedEncodingException e) {
                throw new CodeGenerationException("Error due to Unsupported Encoding while reading inputStream", e.getCause());
            } catch (IOException e) {
                throw new CodeGenerationException("Error while converting stream to string.", e.getCause());
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new CodeGenerationException("Error while closing InputStream", e.getCause());
                }
            }

            return writer.toString();
        } else {
            return "";
        }
    }

    /**
     * Writes an input stream to a file
     * 
     * @param is
     *            The input stream which is written into the file.
     * @param file
     *            The file where the input stream will be written into.
     */
    public void writeToFile(InputStream is, File file) {
        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            int c;
            while ((c = is.read()) != -1) {
                out.writeByte(c);
            }
            is.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Error Writing/Reading Streams.");
        }
    }

    /**
     * Creates a manifest file from the resources/manifest.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the manifest file.
     * @throws CodeGenerationException
     */
    protected String createManifest(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("manifest.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates a build.properties file from the resources/buildprob.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the build.properties file.
     * @throws CodeGenerationException
     */
    protected String createBuildProbCode() throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("buildprob.txt");
        template = new StringTemplate(templateString);

        return template.toString();
    }

    /**
     * Creates an editor class from the resources/editor.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the editor class.
     * @throws CodeGenerationException
     */
    protected String createEditorCode(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("editor.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates a .genmodel file from the resources/genmodel.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the .genmodel file.
     * @throws CodeGenerationException
     */
    public String createGenmodelCode(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("genmodel.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates a mapper class from the resources/mapper.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the mapper class.
     * @throws CodeGenerationException
     */
    protected String createMapperCode(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("mapper.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates an activator class from the resources/activator.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the activator class.
     * @throws CodeGenerationException
     */
    protected String createActivator(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("activator.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates a plugin.xml file from the resources/pluginxml.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the plugin.xml file.
     * @throws CodeGenerationException
     */
    protected String createPluginXML(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("pluginxml.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates a generated.properties file from the resources/genprops.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the generated.properties file.
     * @throws CodeGenerationException
     */
    protected String createdPropertiesCode(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("genprops.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates a .tcs file from the resources/tcs.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the .tcs file.
     * @throws CodeGenerationException
     */
    public String createSampleTCS(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;

        templateString = readFile("tcs.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Creates an parserfactory class from the resources/parserfactory.txt file
     * 
     * @param pi
     *            User input
     * @return The content of the parserfactory class.
     * @throws CodeGenerationException 
     */
    protected String createParserFactory(ProjectInfo pi) throws CodeGenerationException {
        StringTemplate template = null;
        String templateString = null;
        templateString = readFile("parserfactory.txt");
        template = new StringTemplate(templateString);
        setTemplateAtts(template, pi);

        return template.toString();
    }

    /**
     * Sets the attributes for the StringTemplate.
     * <p>
     * Example: If you want to replace the variable $example$ in the text file with the String "Hello World":
     * <p>
     * 
     * <code>String hello = "Hello World";</code><br>
     * <code>template.setAttribute("example", hello);</code>
     * 
     * @param template
     *            The StringTemplate
     * @param pi
     *            The user input
     */
    private void setTemplateAtts(StringTemplate template, ProjectInfo pi) {
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
    }

}
