package com.sap.mi.tools.diagnostics.internal.properties;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.tc.moin.repository.jmx.MoinMBean;

/**
 * Source for attributes as properties of a partitionable
 * 
 * @author d031150
 */
public final class MoinVersionPropertySource implements IPropertySource2 {

	static final String PROPERTY_VERSION_NO = "versionNo"; //$NON-NLS-1$
	static final String PROPERTY_VERSION_NO_LABEL = DiagnosticsMessages.MoinVersionPropertySource_number_label;
	static final String PROPERTY_VERSION_COMMENT = "versionComment"; //$NON-NLS-1$
	static final String PROPERTY_VERSION_COMMENT_LABEL = DiagnosticsMessages.MoinVersionPropertySource_comment_label;
	static final String PROPERTY_VERSION_DATE = "versionDate"; //$NON-NLS-1$
	static final String PROPERTY_VERSION_DATE_LABEL = DiagnosticsMessages.MoinVersionPropertySource_date_label;

	private final MoinMBean mMoin;

	public MoinVersionPropertySource(MoinMBean moin) {
		mMoin = moin;
	}

	public Object getEditableValue() {
		return null;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		IPropertyDescriptor[] descs = new PropertyDescriptor[3];
		descs[0] = new MoinPropertyDescriptor(PROPERTY_VERSION_NO, PROPERTY_VERSION_NO_LABEL);
		descs[1] = new MoinPropertyDescriptor(PROPERTY_VERSION_COMMENT, PROPERTY_VERSION_COMMENT_LABEL);
		descs[2] = new MoinPropertyDescriptor(PROPERTY_VERSION_DATE, PROPERTY_VERSION_DATE_LABEL);
		return descs;
	}

	public Object getPropertyValue(Object id) {
		if (PROPERTY_VERSION_NO.equals(id))
			return mMoin.getMoinVersionNumber();
		if (PROPERTY_VERSION_COMMENT.equals(id))
			return mMoin.getMoinVersionComment();
		if (PROPERTY_VERSION_DATE.equals(id))
			return mMoin.getMoinVersionDate();
		return null;
	}

	public boolean isPropertyResettable(Object id) {
		return false;
	}

	public boolean isPropertySet(Object id) {
		return true;
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
	}

}
