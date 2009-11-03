package com.sap.tc.moin.standalone.xmiconverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.standalone.impl.BaseMetaModelMoinlet;
import com.sap.tc.moin.standalone.util.MoinArgumentsToolkit;
import com.sap.tc.moin.xmi.XmiConverter;

/**
 * JMI generator invocation
 */
public class XmiConverterMoinlet extends BaseMetaModelMoinlet {

	@Override
	public void executeFunctionality(String[] arguments, Moin moin,
			Connection conn, String dataArea, String dcName) {
		boolean verbose = ("true".equals(MoinArgumentsToolkit.getArgumentValue(
				"-verbose", arguments))) ? true : false;
		boolean patchDisabled = ("true".equals(MoinArgumentsToolkit
				.getArgumentValue("-patchDisabled", arguments))) ? true : false;
		boolean doGenerateMof = ("true".equals(MoinArgumentsToolkit
				.getArgumentValue("-generateMof", arguments))) ? true : false;

		try {
			XmiConverter xmiConverter = new XmiConverter(moin, conn,
					getSourcePath(arguments), verbose, patchDisabled,
					doGenerateMof);
			xmiConverter.run();
		} catch (Exception e) {
			System.out.println("Exception during the XmiConverter run: "
					+ e.getMessage());
			throw new RuntimeException(e);
		}
		System.out.println("XMI Conversion finished for project "+getProject(arguments));
	}

	/**
	 * Determines the .properties file from the mmr/meta folder of the imported
	 * metamodel project of the Eclipse metamodel plugin project referred by the
	 * -project option If no such properties file is found there, <tt>null</tt>
	 * is returned.
	 * 
	 * @throws IOException
	 */
	private File getPropertiesFile(String[] args) throws IOException {
		File propertiesFile = null;
		String metamodelProject = getMetamodelProject(getProject(args));
		if (metamodelProject != null) {
			File mmrMeta = new File(metamodelProject, "mmr/meta");
			File[] propertyFiles = mmrMeta.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.getName().endsWith(".properties");
				}
			});
			if (propertyFiles != null && propertyFiles.length > 0) {
				propertiesFile = propertyFiles[0];
			}
		}
		return propertiesFile;
	}

	/**
	 * From the project's .properties file in the mmr/meta folder determines the DC name
	 */
	protected String getDcName(String[] args) {
		try {
			File propertiesFile = getPropertiesFile(args);
			String dcName = findDcNameInPropertiesFile(propertiesFile);
			return dcName;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * From the given .properties file determines the DC name from the first entry that
	 * holds a model partition to be imported (one with "true" at the end of the line). If
	 * no such line is found in the properties file, <tt>null</tt> is returned.
	 */
	private String findDcNameInPropertiesFile(File propertiesFile)
			throws FileNotFoundException, IOException {
		String result = null;
		Pattern p = Pattern
				.compile(".*\\.xml *= *(.*):DCs/sap.com/(.*)/_comp/.* *, *true$");
		BufferedReader r = new BufferedReader(
				new FileReader(propertiesFile));
		String line = r.readLine();
		while (line != null && result == null) {
			Matcher matcher = p.matcher(line);
			if (matcher.matches()) {
				result = matcher.group(2);
			}
			line = r.readLine();
		}
		r.close();
		return result;
	}

	private String getProject(String[] args) {
		String projectPath = MoinArgumentsToolkit
				.getArgumentValue(
						"-project",
						args,
						"-project tells the absolute path to the Eclipse metamodel plugin project. Use ${resource_loc} to make it portable.");
		return projectPath;
	}

	private String getMetamodelProject(String projectPath) throws IOException {
		File subprojectSrcDir = new File(projectPath).getParentFile();
		File importList = new File(new File(subprojectSrcDir, "cfg"),
				"import.lst");
		String metamodelProject = null;
		if (importList.exists()) {
			String subprojectName = null;
			BufferedReader r = new BufferedReader(new FileReader(importList));
			String line = r.readLine();
			while (line != null) {
				if (line.lastIndexOf(':') >= 0) {
					subprojectName = line.substring(line.lastIndexOf(':') + 2);
				}
				line = r.readLine();
			}
			r.close();
			if (subprojectName != null) {
				metamodelProject = new File(subprojectSrcDir.getParentFile(),
						subprojectName).getPath();
			}
		}
		if (metamodelProject == null && projectPath.endsWith(".epi")) {
			// try to guess metamodel project name by removing ".epi" suffix
			metamodelProject = projectPath.substring(0, projectPath.length()
					- ".epi".length());
		}
		return metamodelProject;
	}

	protected String getSourcePath(String[] args) {
		String projectPath = getProject(args);
		String metamodelProject;
		try {
			metamodelProject = getMetamodelProject(projectPath);
			return metamodelProject;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
