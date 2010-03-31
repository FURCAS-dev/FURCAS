package com.sap.mi.tools.metamodelbuilder.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.mi.tools.mmbuilder.internal.MmBuildJaproParser;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;

public class JaproParserTest extends ExtendedTestCase {

	public void testGetMetamodelProperties() throws URISyntaxException, CoreException, IOException {

		assertNull(MmBuildJaproParser.getMetamodelProperties(null));

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("dummy");
		if (project.exists()) {
			project.delete(true, null);
		}
		project.create(null);
		project.open(null);

		IFile dummyFile = project.getFile("build.japro.test");
		if (dummyFile.exists()) {
			dummyFile.delete(true, null);
		}
		InputStream is = getClass().getResourceAsStream("build.japro.test");
		dummyFile.create(is, true, null);
		is.close();
		File f = new File(dummyFile.getRawLocationURI());

		Properties metamodelProperties = MmBuildJaproParser.getMetamodelProperties(f);

		assertNotNull(metamodelProperties);
		assertEquals("tc/moin/metamodel/testcases", metamodelProperties.getProperty(MmGenerator.DC_NAME));

		project.delete(true, null);
	}
}