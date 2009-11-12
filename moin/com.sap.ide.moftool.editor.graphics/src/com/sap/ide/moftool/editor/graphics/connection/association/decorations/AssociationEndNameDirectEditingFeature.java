package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class AssociationEndNameDirectEditingFeature extends AbstractConnectionDecoratorDirectEditingFeature {

	public AssociationEndNameDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {
		String ret = null;
		AssociationEnd associationEnd = getAssociationEnd(context);
		if (associationEnd != null) {
			ret = associationEnd.getName();
		}
		return ret;
	}

	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();

		AssociationEnd associationEnd = getAssociationEnd(context);
		if (associationEnd != null) {
			// Update name of association end
			associationEnd.setName(value);
			
			// Update graphics
            updatePictogramElement(pe);
		}
	}

	@Override
	public boolean stretchTextfieldToFitText() {
		return true;
	}

	private AssociationEnd getAssociationEnd(IDirectEditingContext directEditingContext) {
		AssociationEnd assocEnd = null;
		PictogramElement pe = directEditingContext.getPictogramElement();
		Object object = getBusinessObjectForPictogramElement(pe);
		if (object instanceof AssociationEnd) {
			assocEnd = (AssociationEnd)object;
		}
		return assocEnd;
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object object = getBusinessObjectForPictogramElement(pe);
		if (object instanceof AssociationEnd) {
			AssociationEnd assocEnd = (AssociationEnd)object;
// <pg290108> new name validation			
			IStatus status = null;
			String oldName = assocEnd.getName();
			if (value != null) {
				if (value.equals(oldName)) {
					status = NamespaceService.validate(assocEnd, ""); //$NON-NLS-1$
				} else {
					status = NamespaceService.checkForNewSubobject(assocEnd.getContainer(), value);		
				}
				if ((status != null) && status.getSeverity() == IStatus.ERROR) {
					return status.getMessage();
				}
			}
// </pg290108>
		}
		return null;
	}
}