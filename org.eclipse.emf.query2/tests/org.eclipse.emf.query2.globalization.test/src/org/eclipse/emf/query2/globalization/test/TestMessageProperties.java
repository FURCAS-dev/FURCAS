package org.eclipse.emf.query2.globalization.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.PropertyResourceBundle;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

public class TestMessageProperties {

	PropertyResourceBundle RESOURCE_BUNDLE = null;

	@Before
	public void setUp() throws IOException {
		FileInputStream fis = null;
		// get the plugin bundle
		Bundle bundle = Platform.getBundle("org.eclipse.emf.query2.stringsyntax"); //$NON-NLS-1$
		// get the messages.properties file in the plugin
		String path = bundle.getEntry("org\\eclipse\\emf\\query2\\syntax\\messages.properties").getPath(); //$NON-NLS-1$
		try {
			fis = new FileInputStream(path);
			RESOURCE_BUNDLE = new PropertyResourceBundle(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(fis !=null) {
				fis.close();
			}
		}

	}

	@Test
	/**
	 * Test to ensure key values are not null or not empty
	 */
	public void testKeyValueNotNull() {
		Set<String> propertyKeys = RESOURCE_BUNDLE.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(RESOURCE_BUNDLE.getObject(key));
			Assert.assertFalse(RESOURCE_BUNDLE.getObject(key).equals("")); //$NON-NLS-1$
		}
	}

	@Test
	/**
	 * Checks if the placeholders for parameters are replaced by the parameters
	 * Dummy paramters are created, according to the number of parameters in the given string
	 */
	public void testProperParameterToStringConversion() {
		int index = 0;
		int noParams = 0;
		int paramIndex = 0;
		boolean withParams = false;
		String[] sub_values = null;
		Set<String> propertyKeys = RESOURCE_BUNDLE.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(RESOURCE_BUNDLE.getObject(key));
			String value = RESOURCE_BUNDLE.getString(key);

			String subValue = value;
			while (index < value.length()) {
				paramIndex = subValue.indexOf("{"); //$NON-NLS-1$
				if (paramIndex != -1) {
					noParams++;
					index = paramIndex + 1;
					withParams = true;
					subValue = subValue.substring(paramIndex + 1, subValue.length());
				} else if (paramIndex == -1)
					break;
			}
			sub_values = new String[noParams];
			// creating dummy parameters accordingly
			for (int i = 0; i < noParams; i++) {
				sub_values[i] = "Test" + i; //$NON-NLS-1$
			}
			if (withParams) {
				testForCorrectParam(key, sub_values);
				withParams = false;
				index = 0;
				noParams = 0;
			}
		}
	}

	private void testForCorrectParam(String key, String[] param) {
		String value = RESOURCE_BUNDLE.getString(key);
		if (value != null)
			value = NLS.bind(value, param);
		String expectedMessage = getSubstitutedMessage(RESOURCE_BUNDLE.getString(key), param);
		Assert.assertEquals(expectedMessage, value);

	}

	private String getSubstitutedMessage(String key, String[] param) {
		int index = 0;
		int length = param.length;
		for (int i = 0; i < length; i++) {
			String tobeSubstituted = "{" + i + "}"; //$NON-NLS-1$ //$NON-NLS-2$
			String substitutionApostrophe = "''" + tobeSubstituted + "''"; //$NON-NLS-1$ //$NON-NLS-2$
			if (key.contains(substitutionApostrophe)) {
				tobeSubstituted = substitutionApostrophe;
				param[i] = "'" + param[i] + "'"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			key = key.replace(tobeSubstituted, param[i]);
		}
		return key;

	}
}
