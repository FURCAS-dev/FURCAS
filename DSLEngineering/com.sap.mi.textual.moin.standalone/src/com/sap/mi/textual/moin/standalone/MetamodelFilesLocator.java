package com.sap.mi.textual.moin.standalone;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MetamodelFilesLocator {

	public static List<String> getLinkedMetamodelFolderPaths() {
		// getEntryPaths only lists direkt children
		return enumerationToList(Activator.getDefault().getBundle()
				.getEntryPaths("bin/metamodels/"));
	}

	public static List<String> getMetamodelFilePaths(String metamodelFolderPath) {
		// getEntryPaths only lists direkt children
		return enumerationToList(Activator.getDefault().getBundle()
				.getEntryPaths(metamodelFolderPath + "/"));
	}

	@SuppressWarnings("unchecked")
	private static List<String> enumerationToList(Enumeration enumeration) {
		List<String> list = new ArrayList<String>();
		if (enumeration != null) {
			while (enumeration.hasMoreElements()) {
				list.add((String) enumeration.nextElement());
			}
		}

		return list;
	}

	public static InputStream getMetamodelFileStream(String metamodelFilePath) {
		try {
			return Activator.getDefault().getBundle().getResource(
					metamodelFilePath).openStream();
		} catch (IOException e) {
			return null;
		}
	}

}
