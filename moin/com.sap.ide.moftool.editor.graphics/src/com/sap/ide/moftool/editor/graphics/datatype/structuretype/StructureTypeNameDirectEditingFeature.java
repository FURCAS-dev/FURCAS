package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import com.sap.tc.moin.repository.mmi.model.StructureType;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

public class StructureTypeNameDirectEditingFeature extends AbstractDirectEditingFeature{

	private String mInitialName = null;
	public StructureTypeNameDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {      
		mInitialName = null;
		StructureType structureType = getStructureType(context);
		if (structureType != null) {
			mInitialName = structureType.getName();
		}
		return mInitialName;
	}
	
	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		StructureType structureType = getStructureType(context);
		if (structureType != null) {
//			if (mInitialName.equals(value)) {
//				// Name has not been changed
//				return null;
//			}
// <pg290108> new name validation	
			IStatus status = null;
			String oldName = structureType.getName();
			if (value == null) {
				return null;
			}
			if (value.equals(oldName)) {
				status = NamespaceService.validate(structureType, "");	 //$NON-NLS-1$
			} else {
				status = NamespaceService.checkForNewSubobject(structureType.getContainer(), value);	
			}
			if ((status != null) && status.getSeverity() == IStatus.ERROR) {
				return status.getMessage();
			}
			else {				
				return null;
			}		
		}
		// Not a structure Type at all -> error
		return "Internal error: context does not refer to a Structure Type"; //$NON-NLS-1$
	}

	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		StructureType structureType = getStructureType(context);
		if (structureType != null && (ModelElementService.checkNewName(value).getSeverity() != IStatus.ERROR)) {
			structureType.setName(value);
			if (pe instanceof Shape) {
				updatePictogramElement(((Shape) pe).getContainer());
			}
		}
	}

	private StructureType getStructureType(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof StructureType) {
			return (StructureType) bo;
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
			if (bo instanceof StructureType) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (StructureType)bo);
			}
		}
		return ret;
	}
}
