package com.sap.mi.fwk.internal.testers;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.core.expressions.PropertyTester;

import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Property tester for various Moin/JMI-related expressions. See the constants
 * defined in this class for details as well as expression framework in plugin
 * <code>org.eclipse.core.expressions</code>.
 * 
 * @author d031150
 */
public class MoinObjectPropertyTester extends PropertyTester {

	private static final TracerI sTracer = TracingManager.getTracer(MoinObjectPropertyTester.class);

	/**
	 * A property indicating the immediate package of a {@link RefBaseObject}.
	 * Value is <code>immediatePackage</code> with namespace
	 * <code>com.sap.mi.fwk.properties.moin</code>.
	 */
	public static final String PROPERTY_IMMEDIATE_PACKAGE = "immediatePackage"; //$NON-NLS-1$

	/**
	 * A property indicating the Java(!) class [JMI-Interface] of a
	 * {@link RefObject}. Value is <code>mofClass</code> with namespace
	 * <code>com.sap.mi.fwk.properties.moin</code>.
	 */
	public static final String PROPERTY_JMICLASS = "jmiClass"; //$NON-NLS-1$

	/**
	 * A property indicating the class of a {@link RefObject}. Value is
	 * <code>mofClass</code> with namespace
	 * <code>com.sap.mi.fwk.properties.moin</code>.
	 */
	public static final String PROPERTY_MOFCLASS = "mofClass"; //$NON-NLS-1$

	/**
	 * A property indicating the feature name of a {@link RefFeatured}.
	 * Additionally the corresponding feature value is evaluated if it's given
	 * using <code>name=value</code> notation. Value is <code>feature</code>
	 * with namespace <code>com.sap.mi.fwk.properties.moin</code>.
	 */
	public static final String PROPERTY_FEATURE = "feature"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (PROPERTY_IMMEDIATE_PACKAGE.equals(property)) {
			if (receiver instanceof RefBaseObject) {
				RefBaseObject baseObject = (RefBaseObject) receiver;
				boolean result = testImmediatePackage(baseObject, expectedValue);
				return result;
			}
		} else if (PROPERTY_MOFCLASS.equals(property)) {
			if (receiver instanceof RefObject) {
				RefObject object = (RefObject) receiver;
				boolean result = testClass(object, expectedValue);
				return result;
			}
		} else if (PROPERTY_FEATURE.equals(property)) {
			if (receiver instanceof RefFeatured) {
				RefFeatured featured = (RefFeatured) receiver;
				boolean result = testFeature(featured, expectedValue);
				return result;
			}
		} else if (PROPERTY_JMICLASS.equals(property)) {
			if (receiver instanceof RefBaseObject) {
				RefBaseObject baseObject = (RefBaseObject) receiver;
				boolean result = testJmiClass(baseObject, expectedValue);
				return result;
			}
		}
		return false;
	}

	private boolean testImmediatePackage(RefBaseObject baseObject, Object expectedValue) {
		RefPackage immPackage = baseObject.refImmediatePackage();
		ModelElement metaObject = immPackage.refMetaObject();
		List qualifiedName = metaObject.getQualifiedName();
		String dotSeparatedName = toDotNotation(qualifiedName);
		if (dotSeparatedName.equals(expectedValue))
			return true;
		return false;
	}

	private boolean testClass(RefObject object, Object expectedValue) {
		RefClass refClass = object.refClass();
		ModelElement metaObject = refClass.refMetaObject();
		List qualifiedName = metaObject.getQualifiedName();
		String dotSeparatedName = toDotNotation(qualifiedName);
		if (dotSeparatedName.equals(expectedValue))
			return true;

		// inspect super types
		if (metaObject instanceof GeneralizableElement) {
			GeneralizableElement ge = (GeneralizableElement) metaObject;
			List superTypes = ge.allSupertypes();
			for (Iterator iter = superTypes.iterator(); iter.hasNext();) {
				GeneralizableElement superClass = (GeneralizableElement) iter.next();
				qualifiedName = superClass.getQualifiedName();
				dotSeparatedName = toDotNotation(qualifiedName);
				if (dotSeparatedName.equals(expectedValue))
					return true;
			}
		}
		return false;
	}

	/**
	 * Test for a JMI Class (java classname part of interface collection of
	 * class and/or superclass
	 * 
	 * @param object
	 * @param expectedValue
	 * @return
	 */
	private boolean testJmiClass(RefBaseObject object, Object expectedValue) {
		return containsInterface((String) expectedValue, object.getClass());
	}

	private static boolean containsInterface(String className, Class class1) {
		if (class1 == null)
			return false;
		Class[] ifs = class1.getInterfaces();
		for (Class interf : ifs) {
			if (!(interf == class1)) {
				if (interf.getName().equals(className)) {
					return true;
				}
				if (containsInterface(className, interf))
					return true;
			}
		}
		return containsInterface(className, class1.getSuperclass());
	}

	/**
	 * @param expectedValue
	 *            a feature specification: either a {@link RefObject} or a
	 *            string with <code>featureName[=featureValue]</code>
	 */
	private boolean testFeature(RefFeatured featured, Object expectedValue) {
		if (expectedValue instanceof String) {
			String featureString = (String) expectedValue;
			String[] nameAndValue = getFeatureNameAndValue(featureString);
			if (nameAndValue.length > 0) {
				String name = nameAndValue[0];
				try {
					Object value = featured.refGetValue(name);
					// if value was supplied, check it as well
					if (nameAndValue.length > 1) {
						if (nameAndValue[1].equals(String.valueOf(value)))
							return true;
					}
					// no value given
					else {
						return true;
					}
				}
				// exception for an unknown feature
				catch (RuntimeException e) { // $JL-EXC$
					sTracer.debug("Feature retrieval of '" + name + //$NON-NLS-1$
							"' for object '" + featured + //$NON-NLS-1$
							"' failed: " + e.getMessage()); //$NON-NLS-1$
				}
			}
		} else if (expectedValue instanceof RefObject) {
			RefObject feature = (RefObject) expectedValue;
			try {
				// We can just check the existence of the feature, no way so far
				// to specify an expected feature value.
				featured.refGetValue(feature);
				return true;
			}
			// exception for an unknown feature
			catch (RuntimeException e) { // $JL-EXC$
				sTracer.debug("Feature retrieval of '" + feature + //$NON-NLS-1$
						"' for object '" + featured + //$NON-NLS-1$
						"' failed: " + e.getMessage()); //$NON-NLS-1$
			}
		}
		return false;
	}

	private String toDotNotation(List qualifiedName) {
		StringBuilder dotSeparatedName = new StringBuilder();
		for (Iterator iter = qualifiedName.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			dotSeparatedName.append(name);
			if (iter.hasNext())
				dotSeparatedName.append('.');
		}
		return dotSeparatedName.toString();
	}

	private String[] getFeatureNameAndValue(String featureString) {
		String[] strings = featureString.split("="); //$NON-NLS-1$
		return strings;
	}

}
