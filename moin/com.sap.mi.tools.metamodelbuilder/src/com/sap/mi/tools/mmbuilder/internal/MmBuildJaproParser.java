package com.sap.mi.tools.mmbuilder.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;

public class MmBuildJaproParser {

	private static final String MATCHING_PATTERN_STRING = "^\\s*[a-zA-Z]*MoinM.*\\((.*)\\)"; //$NON-NLS-1$

	private static Pattern MATCHING_PATTERN = Pattern.compile(MATCHING_PATTERN_STRING);

	public static Properties getMetamodelProperties(File mmBuildJaproFile) {

		if (mmBuildJaproFile == null) {

			return null;
		}

		BufferedReader brd = null;
		try {

			// Create the reader
			brd = new BufferedReader(new FileReader(mmBuildJaproFile));
			Matcher matcher = MATCHING_PATTERN.matcher(""); //$NON-NLS-1$

			// Retrieve all lines that match pattern
			String line = null;
			boolean disableClassProxies = false; // TODO remove by christmas eve
			while ((line = brd.readLine()) != null) {
				if (line.contains("DisableClassProxies")) { //$NON-NLS-1$
					disableClassProxies = true; // TODO remove by christmas eve
				}

				matcher.reset(line);
				if (matcher.find()) {

					// Get the matching string
					String match = matcher.group(1);
					String delimiter = ","; //$NON-NLS-1$
					String[] fields = match.split(delimiter, -1);

					String vendor = trim(fields[0]);
					// String sc = fields[1];
					String dc = trim(fields[2]);
					String label = trimLeading(fields[3]);
					String facility = fields.length > 4 ? trim(fields[4]) : "PF"; //$NON-NLS-1$
					String version = fields.length > 5 ? trim( fields[5] ) : ""; //$NON-NLS-1$
					Properties result = new Properties();
					result.put(MmGenerator.CONTAINER, vendor + "/" + dc); //$NON-NLS-1$
					result.put(MmGenerator.DC_DESCRIPTION, label);
					result.put(MmGenerator.DC_NAME, dc);
					result.put(MmGenerator.DC_VENDOR, vendor);
					result.put( MmGenerator.DC_VERSION, version );
					if (facility != null) {
						result.put(MmGenerator.FACILITY_NAME, facility);
					}

					if (disableClassProxies) { // TODO remove by christmas eve
						result.put("DisableClassProxies", "true"); //$NON-NLS-1$
					}

					return result;
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (brd != null) {
				try {
					brd.close();
				} catch (IOException e) {
					// $JL-EXC$
				}
			}
		}

		return null;
	}

	private static String trim(String inputStr) {

		if (inputStr != null) {
			return inputStr.trim();
		}

		return null;
	}

	/* remove leading whitespace */
	private static String trimLeading(String source) {
		if (source != null) {
			return source.replaceAll("^\\s+", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

		return null;
	}

}
