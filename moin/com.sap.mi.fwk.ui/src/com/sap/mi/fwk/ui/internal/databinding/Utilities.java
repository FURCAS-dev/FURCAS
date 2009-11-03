package com.sap.mi.fwk.ui.internal.databinding;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.descriptors.MetamodelElementDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.StructuralFeatureDescriptor;

public class Utilities {
	// do not instantiate
	private Utilities() {

	}

	/**
	 * Retrieves the corresponding feature from the given RefObject instance
	 * 
	 * @param mofClass
	 *            the instance for which the feature with
	 *            <code>featureName</code> has been defined
	 * @param featureDescriptor
	 *            the {@link MetamodelElementDescriptor} of the feature - either
	 *            of an <code>Attribute</code> or a <code>Reference</code>
	 * @return the corresponding feature defined on the given class
	 * @exception IllegalArgumentException
	 *                in case there is no feature was found
	 */
	public static StructuralFeature getStructuralFeature(
			MofClass mofClass,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		Assert.isLegal(mofClass != null, "MofClass must not be null"); //$NON-NLS-1$
		Assert.isLegal(featureDescriptor != null, "Feature descriptor must not be null"); //$NON-NLS-1$

		Connection connection = ModelAdapter.getInstance().getConnection(mofClass);
		StructuralFeature structuralFeature = connection.getMetamodelElement(featureDescriptor);

		if (structuralFeature == null) {
			throw new IllegalArgumentException(
					"Attribute or Reference with name <" + featureDescriptor.getQualifiedName() //$NON-NLS-1$
							+ "> not defined for metamodel entity <" + mofClass.toString() + ">"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return structuralFeature;
	}
}
