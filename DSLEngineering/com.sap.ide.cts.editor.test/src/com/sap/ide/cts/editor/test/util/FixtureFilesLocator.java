package com.sap.ide.cts.editor.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.sap.ide.cts.editor.Activator;

public class FixtureFilesLocator {
	public static List<String> getFixtureFilePaths() {
		List<String> results = new ArrayList<String>();

		// getEntryPaths only lists direkt children
		List<String> fixtureFolders = enumerationToList(Activator.getDefault()
				.getBundle().getEntryPaths("bin/fixtures/"));

		for (String fixtureFolder : fixtureFolders) {
			results.addAll(enumerationToList(Activator.getDefault().getBundle()
					.getEntryPaths(fixtureFolder + "/")));
		}

		return results;
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

	public static InputStream getFixtureFileStream(String fixtureFilePath) {
		try {
			return Activator.getDefault().getBundle().getResource(
					fixtureFilePath).openStream();
		} catch (IOException e) {
			return null;
		}
	}

}
