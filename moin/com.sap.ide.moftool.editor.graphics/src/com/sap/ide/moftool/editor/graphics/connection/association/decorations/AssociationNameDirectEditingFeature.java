package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.tc.moin.repository.mmi.model.Association;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.LinkUtil;

public class AssociationNameDirectEditingFeature extends AbstractConnectionDecoratorDirectEditingFeature{

  
    public AssociationNameDirectEditingFeature(IFeatureProvider fp) {
        super(fp);
    }

    public int getEditingType() {
        return TYPE_TEXT;
    }
    
    public String getInitialValue(IDirectEditingContext context) {
        StringBuffer ret = new StringBuffer();
        
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       
        if (bo instanceof Association && LinkUtil.hasLinkProperty(pictogramElement, MOFToolConstants.ASSOCIATION_NAME)) {
            Association assoc = (Association) bo;
            ret.append(assoc.getName());
        }
        return ret.toString();
    }

    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);

        if (bo instanceof Association && LinkUtil.hasLinkProperty(pictogramElement, MOFToolConstants.ASSOCIATION_NAME) && checkValueValid(value, context)== null) {
            Association assoc = (Association) bo;
            assoc.setName(value);
            updatePictogramElement(pictogramElement);
        }
    }
    
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) { 
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Association) {
			Association assoc = (Association)bo;
// <pg290108> new name validation			
			IStatus status = null;
			String oldName = assoc.getName();
			if (value != null) {
				if (value.equals(oldName)) {
					status = NamespaceService.validate(assoc, ""); //$NON-NLS-1$
				} else {
					status = NamespaceService.checkForNewSubobject(assoc.getContainer(), value);		
				}
				if ((status != null) && status.getSeverity() == IStatus.ERROR) {
					return status.getMessage();
				}
			}	
		}      
        return null;
    }

    @Override
    public boolean stretchTextfieldToFitText() {       
        return true;
    }

}
