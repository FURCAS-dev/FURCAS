package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

public class EnumTypeNameDirectEditingFeature extends AbstractDirectEditingFeature {

	private String mInitialName = null;

	public EnumTypeNameDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {      
		mInitialName = null;
		EnumerationType enumType = getEnumType(context);
		if (enumType != null) {
			mInitialName = enumType.getName();
		}
		return mInitialName;
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		EnumerationType enumType = getEnumType(context);
		if (enumType != null) {
//			if (mInitialName.equals(value)) {
//				// Name has not been changed
//				return null;
//			}
// <pg290108> new name validation	
			IStatus status = null;
			String oldName = enumType.getName();
			if (value == null) {
				return null;
			}
			if (value.equals(oldName)) {
				status = NamespaceService.validate(enumType, "");	 //$NON-NLS-1$
			} else {
				status = NamespaceService.checkForNewSubobject(enumType.getContainer(), value);	
			}
			if ((status != null) && status.getSeverity() == IStatus.ERROR) {
				return status.getMessage();
			}
			else {				
				return null;
			}		
		}
		// Not a enum Type at all -> error
		return "Internal error: context does not refer to a EnumerationType"; //$NON-NLS-1$
	}
	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		EnumerationType enumType = getEnumType(context);
		if (enumType != null && (ModelElementService.checkNewName(value).getSeverity() != IStatus.ERROR)) {
			enumType.setName(value);
			if (pe instanceof Shape) {
				updatePictogramElement(((Shape) pe).getContainer());
			}
		}
	}

	private EnumerationType getEnumType(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof EnumerationType) {
			return (EnumerationType) bo;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		boolean ret = super.canDirectEdit(context);
		if (!ret) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof EnumerationType) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (EnumerationType)bo);
			}
		}
		return ret;
	}
}
