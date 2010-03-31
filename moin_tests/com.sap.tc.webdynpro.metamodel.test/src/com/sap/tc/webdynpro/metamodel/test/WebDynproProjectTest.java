package com.sap.tc.webdynpro.metamodel.test;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.tc.moin.repository.PRI;

/**
 * Convenience test base class for tests that work on Web Dynpro test data stored in a project.  
 * Automatically imports Web Dynpro metamodel.
 * 
 * @author d031150
 */
public abstract class WebDynproProjectTest extends ProjectBasedTest {
	
	/**
	 * The container name ("id") of the Web Dynpro metamodel.  Should only be used by related tests.
	 * 
	 * @see ModelManager#getContainerName(RefBaseObject)
	 */
	public static final String CONTAINER_NAME_WEBDYNPRO = "sap.com/tc/moin/webdynpro/webdynpro"; //$NON-NLS-1$
	/**
	 * The qualified <code>WebDynpro</code> package name.  Should only be used by related tests.
	 */
	public static final String PACKAGE_NAME_WEBDYNPRO = "WebDynpro"; //$NON-NLS-1$
	/**
	 * The qualified <code>component</code> package name
	 */
	protected static final String[] PACKAGE_NAME_COMPONENT = {PACKAGE_NAME_WEBDYNPRO, "component"}; //$NON-NLS-1$
	/**
	 * The qualified <code>view</code> package name 
	 */
	protected static final String[] PACKAGE_NAME_VIEW = {PACKAGE_NAME_WEBDYNPRO, "component", "view"}; //$NON-NLS-1$ $NON-NLS-2$
	/**
	 * The qualified name of the Web Dynpro <code>Component</code>.  Should only be used by related tests.
	 */
	public static final String[] TYPE_NAME_COMPONENT = {PACKAGE_NAME_WEBDYNPRO, "component", "Component"}; //$NON-NLS-1$ $NON-NLS-2$
	/**
	 * The qualified name of the Web Dynpro <code>View</code>.  Should only be used by related tests.
	 */
	public static final String[] TYPE_NAME_VIEW = {PACKAGE_NAME_WEBDYNPRO, "component", "view", "View"}; //$NON-NLS-1$ $NON-NLS-2$ $NON-NLS-3$
	/**
	 * The source folder of Web Dynpro projects 
	 */
	protected static final IPath SOURCE_FOLDER_WEBDYNPRO = new Path("src"); //$NON-NLS-1$
	/**
	 * The extension for all-purpose Web Dynpro partitions
	 */
	protected static final String PARTITION_EXTENSION_WEBDYNPRO = "xmi"; //$NON-NLS-1$

	/**
	 * @see TestCase#TestCase(String)
	 */
	public WebDynproProjectTest(String name) {
		super(name);
	}
	
	/**
	 * Answers with {@link #CONTAINER_NAME_WEBDYNPRO}
	 */
	@Override
	protected String[] getMetamodels() {
		return new String[] { CONTAINER_NAME_WEBDYNPRO };
	}
	
	protected static final PRI getPri(IProject project, final IPath packageWithName) {
		IPath path = packageWithName;
		if (path.matchingFirstSegments(SOURCE_FOLDER_WEBDYNPRO) == 0)
			path = SOURCE_FOLDER_WEBDYNPRO.append(path);
		path = path.removeFileExtension().addFileExtension(PARTITION_EXTENSION_WEBDYNPRO);
        PRI pri = ModelManager.getPartitionService().getPRI(project, path);
		return pri;
	}

}
