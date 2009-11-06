package com.sap.mi.tools.cockpit.editor.model.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * @author d003456
 * 
 */
public class PropertyHelper {

	/*
	 * Boolean (as object, can be null) or boolean: It depends on the cardinality, if a Java Wrapper class or a Java primitive type is used
	 * in JMI. Only if the multiplicity is defined as lower = 1 and upper = 1 then a Java primitive type is used in JMI, otherwise it is a
	 * Java Wrapper class (Boolean).
	 */

	public final static String[] EMPTY_STRING_ARRAY = new String[0];

	/**
	 * Java primitive type boolean.
	 */
	private final static String[] defaultBooleanTypeLabels = { Boolean.TRUE.toString(), Boolean.FALSE.toString() };

	/**
	 * Java Wrapper class with Boolean object with empty string as null.
	 */
	private final static String[] defaultBooleanClassLabels = { "", Boolean.TRUE.toString(), Boolean.FALSE.toString() }; //$NON-NLS-1$

	// private static final String EMPTY_VALUE = "<Empty>";
	// private final Map<String, String[]> attrNameToLabels = new
	// HashMap<String, String[]>();

	public PropertyHelper() {

	}

	/**
	 * Returns all labels for a given attribute name for the current refObject. To represent the value null an empty entry is added at the
	 * head of the list.
	 * 
	 * @param attrName
	 *            The attribute name
	 * @return The label list (might be empty)
	 */
	@SuppressWarnings("nls")
	public String[] getLabelsForEnumerationOrBoolean(String attrName, RefObject refObj) {

		String[] result = null;

		final RefObject metaObject = refObj.refMetaObject();
		final Connection con = ((Partitionable) refObj).get___Connection();
		final JmiHelper jmiHelper = con.getJmiHelper();
		final Attribute attr = jmiHelper.getAttributeByName((MofClass) metaObject, attrName, true);
		final Classifier type = jmiHelper.getNonAliasType(attr.getType());

		if (type instanceof EnumerationType) {
			final List<String> labelList = new ArrayList<String>(((EnumerationType) type).getLabels());
			Collections.sort(labelList);
			labelList.add(0, "");
			result = labelList.toArray(new String[labelList.size()]);

		} else if (type.getName().equals("Boolean")) {
			final Class<?> typeClass = jmiHelper.getJavaPrimitiveOrWrapperType(attr);
			if (typeClass.equals(Boolean.class)) {
				result = PropertyHelper.defaultBooleanClassLabels;
			} else {
				result = PropertyHelper.defaultBooleanTypeLabels;
			}
		} else {
			result = PropertyHelper.EMPTY_STRING_ARRAY;
		}
		return result;
	}

	public int findLabelPos(String[] labels, Object value) {

		if (labels == PropertyHelper.defaultBooleanClassLabels) {
			if (value.equals(Boolean.TRUE)) {
				return 1; // index for "true"
			}
			if (value.equals(Boolean.FALSE)) {
				return 2; // index for "false"
			}
			return 0; // index for empty string
		}

		if (labels == PropertyHelper.defaultBooleanTypeLabels) {
			if (value.equals(Boolean.TRUE)) {
				return 0; // index for "true"
			}
			return 1; // index for "false"
		}

		return Arrays.binarySearch(labels, value.toString());

	}

	@SuppressWarnings("nls")
	public String tryGetUsefulName(RefObject refObj) {

		String res = "";
		final Connection conn = ((Partitionable) refObj).get___Connection();
		final JmiHelper jmiHelper = conn.getJmiHelper();
		final Map<Attribute, Object> attributesAndValues = jmiHelper.getAttributesWithValues(refObj, true);

		String partName = null;
		for (final Map.Entry<Attribute, Object> e : attributesAndValues.entrySet()) {
			if (e.getKey().getMultiplicity().getUpper() == 1) {
				if (e.getKey().getType() instanceof PrimitiveType) {
					if ((e.getKey().getName().equalsIgnoreCase("name") || e.getKey().getName().equalsIgnoreCase(
							"id"))
							&& e.getValue() != null) {
						res = ": " + (String) attributesAndValues.get(e.getKey());
						return res;
					} else if ((partName == null)
							&& (e.getKey().getName().contains("name") || e.getKey().getName().contains("id"))
							&& (e.getValue() != null)) {

						partName = e.getValue().toString();
					}
				}
			}
		}
		if (partName != null) {
			res = ": " + partName;
			return res;
		}
		return res;

	}

	@SuppressWarnings("nls")
	public String getQualifiedName(RefObject element) {

		final List<String> qualifiedName = ((ModelElement) element.refMetaObject()).getQualifiedName();
		String finalName = "";
		for (final String name : qualifiedName) {
			finalName = finalName + name;
			finalName = finalName + ".";
		}

		// Omit last "."
		finalName = finalName.substring(0, finalName.lastIndexOf("."));

		return finalName;

	}

	public String getName(RefObject element) {

		return ((ModelElement) element.refMetaObject()).getName();

	}

	public String getContainerName(RefObject element) {

		return ((Partitionable) element).get___Partition().getPri().getContainerName();

	}

	public String getPartitionName(RefObject element) {

		return ((Partitionable) element).get___Partition().getPri().getPartitionName();

	}

	public PRI getPRI(RefObject element) {

		return ((Partitionable) element).get___Partition().getPri();

	}
	public String getMetaModelName(RefObject element) {

		final ModelElement mEl = getMetaClass(element);
		return ((Partitionable) mEl).get___Partition().getPri().getContainerName();
	}

	@SuppressWarnings("nls")
	public String getPackage(RefObject element) {

		String result = "";
		RefPackage child = ((RefBaseObject) element).refImmediatePackage();
		while (child != null) {
			result = ((ModelElement) child.refMetaObject()).getName() + "/" + result;
			child = child.refImmediatePackage();
		}
		if (result.endsWith("/")) {
			result = result.substring(0, result.length() - 1);
		}
		return result;

	}

	public ModelElement getMetaClass(RefBaseObject o) {

		final Object mo = o.refMetaObject();
		if (mo instanceof ModelElement)
			return (ModelElement) mo;
		return null;
	}
}
