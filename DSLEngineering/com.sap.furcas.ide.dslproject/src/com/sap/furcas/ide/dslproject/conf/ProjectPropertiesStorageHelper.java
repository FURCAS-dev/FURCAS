package com.sap.furcas.ide.dslproject.conf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;


/**
 * wraps the approach this plugin uses to persist properties (i.e. eclipse property, DC property, xml file).
 * 
 * @author C5107456
 */
public class ProjectPropertiesStorageHelper {

    private final static String PROPERTIES_FILENAME = "dslEngineering.properties";
    
	/**
	 * Sets the property.
	 * 
	 * @param project the project
	 * @param key the key
	 * @param value the value
	 * 
	 * @throws CoreException the core exception
	 */
	public static void setProperty( IProject project, String key, String value) throws CoreException {

	    // previous implementation
//			project.setPersistentProperty(getQualifiedName(key), value);
	    
	    IFile propFile = project.getFile(PROPERTIES_FILENAME);
	   
	    
	    Properties prop = new Properties();
	    try {
	        if ( propFile.exists()) {
	            prop.load(propFile.getContents());
	        }
            prop.setProperty(key, value);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(out);
            prop.store(writer, "Created by DSL Engineering Nature, best edited in project properties.");
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            if ( propFile.exists()) {
                propFile.setContents(in, IFile.FORCE, new NullProgressMonitor());
            } else {
                propFile.create(in, IFile.FORCE, new NullProgressMonitor());
            }
            
        } catch (IOException e) {
            // TODO: add error marker, here or up in call hierarchy?
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e.getMessage(), Activator.PLUGIN_ID));
        }
	}
	
	/**
	 * Gets the property.
	 * 
	 * @param project the project
	 * @param key the key
	 * 
	 * @return the property
	 * 
	 * @throws CoreException the core exception
	 */
	public static String getProperty(IProject project, String key) throws CoreException {
	    
	       // previous implementation
//		String value = project.getPersistentProperty(getQualifiedName(key));
	    
        IFile propFile = project.getFile(PROPERTIES_FILENAME);
        if ( ! propFile.exists()) {
            return null;
        }
        Properties prop = new Properties();
        try {
            prop.load(propFile.getContents());
        } catch (IOException e) {
            // TODO: add error marker, here or up in call hierarchy?
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e.getMessage(), Activator.PLUGIN_ID));
        }
		return prop.getProperty(key);
	}

	/**
	 * Removes the storage of the properties
	 * 
	 * @param project the project
	 * @param key the key
	 * 
	 * @throws CoreException the core exception
	 */
	public static void removeProperties(IProject project, String key) throws CoreException {
//		project.setPersistentProperty(getQualifiedName(key), null);
	    IFile propFile = project.getFile(PROPERTIES_FILENAME);
	    if (propFile != null && propFile.exists()) {
	        propFile.delete(true, new NullProgressMonitor());
	    }
	}
	
//	/**
//	 * Gets the qualified name.
//	 * 
//	 * @param key the key
//	 * 
//	 * @return the qualified name
//	 */
//	private static QualifiedName getQualifiedName(String key) {
//		return new QualifiedName(Constants.METAMODEL_PERSISTENT_PROPERTY_QUALIFIER, key);
//	}
}
