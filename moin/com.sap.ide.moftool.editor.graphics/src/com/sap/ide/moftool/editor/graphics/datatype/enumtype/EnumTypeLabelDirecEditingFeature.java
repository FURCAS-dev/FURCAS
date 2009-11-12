package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.commands.EditEnumerationTypeLabelCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

public class EnumTypeLabelDirecEditingFeature extends AbstractDirectEditingFeature{

	public EnumTypeLabelDirecEditingFeature(IFeatureProvider fp) {
		super(fp);      
	}

	public int getEditingType() {     
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {
		EnumerationType enumType = getEnumType(context);       
		List<String> labels = enumType.getLabels();
		Property property = LinkUtil.getLinkProperty(context.getPictogramElement());
		int index = Integer.valueOf(property.getValue()).intValue();
		if (index != -1) {
			return labels.get(index);
		}
		return null;
	}


	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		EnumerationType enumType = getEnumType(context);    
		List<String> labels = enumType.getLabels();

		Property property = LinkUtil.getLinkProperty(context.getPictogramElement());
		int index = Integer.valueOf(property.getValue()).intValue();
		
		if (value.equals("")) { //$NON-NLS-1$
			return Messages.EnumTypeLabelDirecEditingFeature_0_xmsg;
		}

		IStatus status = NamespaceService.checkForNewSubobject(enumType, value);
		if (status.getSeverity() == IStatus.ERROR) {
			return status.getMessage();
		} 
		else if (labels.contains(value) && !labels.get(index).equals(value)) {
			return Messages.EnumTypeLabelDirecEditingFeature_1_xmsg;
		}
		else {
			// Everything ok
			return null;
		}
	}

	public void setValue(String value, IDirectEditingContext context) {
		EnumerationType enumType = getEnumType(context);       
		Property property = LinkUtil.getLinkProperty(context.getPictogramElement());
		int index = Integer.valueOf(property.getValue()).intValue();
		if (index != -1) {
			if (enumType != null && (ModelElementService.checkNewName(value).getSeverity() != IStatus.ERROR)) {
				EditEnumerationTypeLabelCommand command = new EditEnumerationTypeLabelCommand(enumType,
						index, value, getConnection());
		        CommandHandle handle = null;
		        try {
		        	handle = command.execute();
		        }
		        catch (ExecutionCancelledException ecEx) {
		            return;
		        } 
		        catch (Exception e) {
		            throw new InternalErrorException(e);
		        }
		        if (handle == null) {
		        	throw new InternalErrorException("Error while executing " + command.getDescription()); //$NON-NLS-1$
		        }
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
