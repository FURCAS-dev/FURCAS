package org.eclipse.emf.query2.globalization.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Note - BUNDLE_NAME of corresponding Messages.java file needs to be public for
 * this test to run
 */
public class MessagePropertiesTest {

	String BUNDLE_NAME = "BUNDLE_NAME"; //$NON-NLS-1$
	PropertyResourceBundle query2Core_ResourceBundle = null;
	Class<?> query2Core_MessagesClass = null;
	PropertyResourceBundle query2Index_ResourceBundle = null;
	Class<?> query2Index_MessagesClass = null;
	PropertyResourceBundle query2IndexUI_ResourceBundle = null;
	Class<?> query2IndexUI_MessagesClass = null;
	PropertyResourceBundle query2StringSyntaxUITools_ResourceBundle = null;
	Class<?> query2StringSyntaxUITools_MessagesClass = null;
	PropertyResourceBundle query2StringSyntax_ResourceBundle = null;
	Class<?> query2StringSyntax_MessagesClass = null;

	/**
	 * Initialize the messages class and resource bundle for each plugin
	 * 
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@Before
	public void setUp() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

		query2Core_MessagesClass = org.eclipse.emf.query2.Messages.class;
		String resourceBundleName = getResourceBundleName(query2Core_MessagesClass);
		query2Core_ResourceBundle = (PropertyResourceBundle) ResourceBundle.getBundle(resourceBundleName);

		query2Index_MessagesClass = org.eclipse.emf.query.index.Messages.class;
		resourceBundleName = getResourceBundleName(query2Index_MessagesClass);
		query2Index_ResourceBundle = (PropertyResourceBundle) ResourceBundle.getBundle(resourceBundleName);

		query2IndexUI_MessagesClass = org.eclipse.emf.query.index.ui.Messages.class;
		resourceBundleName = getResourceBundleName(query2IndexUI_MessagesClass);
		query2IndexUI_ResourceBundle = (PropertyResourceBundle) ResourceBundle.getBundle(resourceBundleName);

		query2StringSyntaxUITools_MessagesClass = org.eclipse.emf.query2.internal.ui.Messages.class;
		resourceBundleName = getResourceBundleName(query2StringSyntaxUITools_MessagesClass);
		query2StringSyntaxUITools_ResourceBundle = (PropertyResourceBundle) ResourceBundle.getBundle(resourceBundleName);
		
		query2StringSyntax_MessagesClass = org.eclipse.emf.query2.syntax.Messages.class;
		resourceBundleName = getResourceBundleName(query2StringSyntax_MessagesClass);
		query2StringSyntax_ResourceBundle = (PropertyResourceBundle) ResourceBundle.getBundle(resourceBundleName);

	}

	private String getResourceBundleName(Class MessagesClass) throws NoSuchFieldException, IllegalAccessException {
		Field bundleName = MessagesClass.getDeclaredField(BUNDLE_NAME);
		String resourceBundleName = (String) bundleName.get(MessagesClass);
		return resourceBundleName;
	}

	@Test
	public void testforNullorEmptyMessageProperties_Query2Core() {

		Set<String> propertyKeys = query2Core_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(query2Core_ResourceBundle.getObject(key));
			Assert.assertFalse(query2Core_ResourceBundle.getObject(key).equals("")); //$NON-NLS-1$
		}
	}

	@Test
	public void testforNullorEmptyMessageProperties_Query2Index() {

		Set<String> propertyKeys = query2Index_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(query2Index_ResourceBundle.getObject(key));
			Assert.assertFalse(query2Index_ResourceBundle.getObject(key).equals("")); //$NON-NLS-1$
		}
	}

	@Test
	public void testforNullorEmptyMessageProperties_Query2IndexUI() {

		Set<String> propertyKeys = query2IndexUI_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(query2IndexUI_ResourceBundle.getObject(key));
			Assert.assertFalse(query2IndexUI_ResourceBundle.getObject(key).equals("")); //$NON-NLS-1$
		}
	}

	@Test
	public void testforNullorEmptyMessageProperties_Query2StringSyntaxUITools() {

		Set<String> propertyKeys = query2StringSyntaxUITools_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(query2StringSyntaxUITools_ResourceBundle.getObject(key));
			Assert.assertFalse(query2StringSyntaxUITools_ResourceBundle.getObject(key).equals("")); //$NON-NLS-1$
		}
	}
	
	@Test
	public void testforNullorEmptyMessageProperties_Query2StringSyntax() {

		Set<String> propertyKeys = query2StringSyntax_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			String key = (String) propItr.next();
			Assert.assertNotNull(query2StringSyntax_ResourceBundle.getObject(key));
			Assert.assertFalse(query2StringSyntax_ResourceBundle.getObject(key).equals("")); //$NON-NLS-1$
		}
	}

	@Test
	/**
	 * Checks if the placeholders for parameters are replaced by the parameters
	 * Dummy paramters are created, according to the number of parameters in the given string
	 */
	public void testQuery2CoreProperConversionFromParameterToString() throws SecurityException, IllegalArgumentException, NoSuchMethodException, NoSuchFieldException,
			IllegalAccessException {

		String key = null;
		String expectedMessage = null;
		String keyValue = null;
		Set<String> propertyKeys = query2Core_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			key = (String) propItr.next();
			keyValue = query2Core_ResourceBundle.getString(key);
			if (keyValue.indexOf("{") != -1) { //$NON-NLS-1$
				// For each key in properties file, if the key contains
				// parameters, get dummy strings to substitute for parameters
				String[] dummyParams = getDummyStringstoSubstitute(keyValue);
				if (query2Core_MessagesClass != null) {
					keyValue = getKeyValueFromPropertiesFile(key, query2Core_MessagesClass, dummyParams);
					expectedMessage = getSubstitutedMessage(query2Core_ResourceBundle.getString(key), dummyParams);
					Assert.assertEquals(expectedMessage, keyValue);

				}
			}
		}
	}

	@Test
	public void testQuery2IndexProperConversionFromParameterToString() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException,
			NoSuchFieldException, InstantiationException, NoSuchMethodException {

		String key = null;
		String expectedMessage = null;
		String keyValue = null;

		Set<String> propertyKeys = query2Index_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			key = (String) propItr.next();
			keyValue = query2Index_ResourceBundle.getString(key);
			if (keyValue.indexOf("{") != -1) { //$NON-NLS-1$
				// For each key in properties file, if the key contains
				// parameters, get dummy strings to substitute for parameters
				String[] dummyParams = getDummyStringstoSubstitute(keyValue);
				if (query2Index_MessagesClass != null) {
					keyValue = getKeyValueFromPropertiesFile(key, query2Index_MessagesClass, dummyParams);
					expectedMessage = getSubstitutedMessage(query2Index_ResourceBundle.getString(key), dummyParams);
					Assert.assertEquals(expectedMessage, keyValue);

				}
			}
		}
	}

	@Test
	public void testQuery2IndexUIProperConversionFromParameterToString() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException,
			NoSuchFieldException, InstantiationException, NoSuchMethodException {

		String key = null;
		String expectedMessage = null;
		String keyValue = null;
		Set<String> propertyKeys = query2IndexUI_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			key = (String) propItr.next();
			keyValue = query2IndexUI_ResourceBundle.getString(key);
			if (keyValue.indexOf("{") != -1) { //$NON-NLS-1$
				// For each key in properties file, if the key contains
				// parameters, get dummy strings to substitute for parameters
				String[] dummyParams = getDummyStringstoSubstitute(keyValue);
				if (query2IndexUI_MessagesClass != null) {
					keyValue = getKeyValueFromPropertiesFile(key, query2IndexUI_MessagesClass, dummyParams);
					expectedMessage = getSubstitutedMessage(query2IndexUI_ResourceBundle.getString(key), dummyParams);
					Assert.assertEquals(expectedMessage, keyValue);

				}
			}
		}
	}

	@Test
	public void testQuery2StringSyntaxUIToolsProperConversionFromParameterToString() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchFieldException, InstantiationException, NoSuchMethodException {

		String key = null;
		String expectedMessage = null;
		String keyValue = null;
		Set<String> propertyKeys = query2StringSyntaxUITools_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			key = (String) propItr.next();
			keyValue = query2StringSyntaxUITools_ResourceBundle.getString(key);
			if (keyValue.indexOf("{") != -1) { //$NON-NLS-1$
				// For each key in properties file, if the key contains
				// parameters, get dummy strings to substitute for parameters
				String[] dummyParams = getDummyStringstoSubstitute(keyValue);
				if (query2StringSyntaxUITools_MessagesClass != null) {
					keyValue = getKeyValueFromPropertiesFile(key, query2StringSyntaxUITools_MessagesClass, dummyParams);
					expectedMessage = getSubstitutedMessage(query2StringSyntaxUITools_ResourceBundle.getString(key), dummyParams);
					Assert.assertEquals(expectedMessage, keyValue);

				}
			}
		}
	}
	
	@Test
	public void testQuery2StringSyntaxProperConversionFromParameterToString() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchFieldException, InstantiationException, NoSuchMethodException {

		String key = null;
		String expectedMessage = null;
		String keyValue = null;
		Set<String> propertyKeys = query2StringSyntax_ResourceBundle.keySet();
		Iterator itr = propertyKeys.iterator();
		for (Iterator propItr = itr; itr.hasNext();) {
			key = (String) propItr.next();
			keyValue = query2StringSyntax_ResourceBundle.getString(key);
			if (keyValue.indexOf("{") != -1) { //$NON-NLS-1$
				// For each key in properties file, if the key contains
				// parameters, get dummy strings to substitute for parameters
				String[] dummyParams = getDummyStringstoSubstitute(keyValue);
				if (query2StringSyntax_MessagesClass != null) {
					keyValue = getKeyValueFromPropertiesFile(key, query2StringSyntax_MessagesClass, dummyParams);
					expectedMessage = getSubstitutedMessage(query2StringSyntax_ResourceBundle.getString(key), dummyParams);
					Assert.assertEquals(expectedMessage, keyValue);

				}
			}
		}
	}

	private String getKeyValueFromPropertiesFile(String key, Class messagesClass, String[] dummyParams) throws SecurityException, NoSuchMethodException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Method getString = getStringMethodFromMessages(messagesClass);
		String keyValue = null;
		Field field = messagesClass.getDeclaredField(key);
		String fieldValue = (String) field.get(messagesClass);
		try {
			keyValue = (String) getString.invoke(messagesClass, fieldValue, dummyParams);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keyValue;
	}

	/**
	 * Finds the number of parameters in the given string, constructs dummy
	 * strings accordingly, which will be the placeholders for parameters in
	 * actual string actual string
	 * 
	 * @param stringWithParameters
	 * @return
	 */
	private String[] getDummyStringstoSubstitute(String stringWithParameters) {
		int index = 0;
		int noParams = 0;
		int paramIndex = 0;
		String[] sub_values = null;
		String subValue = stringWithParameters;
		while (index < stringWithParameters.length()) {
			paramIndex = subValue.indexOf("{"); //$NON-NLS-1$
			if (paramIndex != -1) {
				noParams++;
				index = paramIndex + 1;
				subValue = subValue.substring(paramIndex + 1, subValue.length());
			} else if (paramIndex == -1)
				break;
		}
		sub_values = new String[noParams];
		// creating dummy parameters accordingly
		for (int i = 0; i < noParams; i++) {
			sub_values[i] = "Test" + i; //$NON-NLS-1$
		}
		return sub_values;

	}

	/**
	 * Replaces the arguments with dummy strings provided in the actual string
	 * 
	 * @param stringWithParameters
	 * @param dummyParameters
	 *            created above
	 * @return
	 */
	private String getSubstitutedMessage(String stringWithParameters, String[] param) {
		int index = 0;
		int length = param.length;
		for (int i = 0; i < length; i++) {
			String tobeSubstituted = "{" + i + "}"; //$NON-NLS-1$ //$NON-NLS-2$
			stringWithParameters = stringWithParameters.replaceAll("''","'"); //$NON-NLS-1$ //$NON-NLS-2$
//			String substitutionApostrophe = "''" + tobeSubstituted + "''"; //$NON-NLS-1$ //$NON-NLS-2$
//			if (stringWithParameters.contains(substitutionApostrophe)) {
//				tobeSubstituted = substitutionApostrophe;
//				param[i] = "'" + param[i] + "'"; //$NON-NLS-1$ //$NON-NLS-2$
//			}
			stringWithParameters = stringWithParameters.replace(tobeSubstituted, param[i]);
		}
		return stringWithParameters;

	}

	/**
	 * Gets the getString() from Messages file reflectively, as messages class
	 * cannot be instantiated directly
	 * 
	 * @param messagesClass
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	private Method getStringMethodFromMessages(Class messagesClass) throws SecurityException, NoSuchMethodException {
		// arguement types of required method
		Class[] args = new Class[2];
		args[0] = String.class;
		args[1] = String[].class;
		Method getString = messagesClass.getDeclaredMethod("getString", args); //$NON-NLS-1$
		return getString;

	}

}
