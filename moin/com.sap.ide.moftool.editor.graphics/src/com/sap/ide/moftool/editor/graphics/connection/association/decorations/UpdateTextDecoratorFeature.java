package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.tc.moin.repository.mmi.model.ModelElement;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.impl.AbstractUpdateFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;

public abstract class UpdateTextDecoratorFeature extends AbstractUpdateFeature {

    public UpdateTextDecoratorFeature(IFeatureProvider fp) {
        super(fp);
    }

	public boolean canUpdate(IUpdateContext context) {
		boolean ret = false;
		PictogramElement pe = context.getPictogramElement();
		String value = getLinkPropertyValue();
		if (pe instanceof ConnectionDecorator && LinkUtil.hasLinkProperty(pe, value)) {          
			ret = true;
		}        
		return ret;
	}

	public IReason updateNeeded(IUpdateContext context) {
		IReason ret = Reason.createFalseReason();

		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof ConnectionDecorator) {
			ConnectionDecorator decorator = (ConnectionDecorator)pe;
			Object businessObject = getBusinessObjectForPictogramElement(pe);
			if (businessObject instanceof ModelElement) {
				ModelElement element = (ModelElement)businessObject;
				String newName = getText(element);
				GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
				String visibility = PeUtil.getPropertyValue(decorator.getConnection(), MOFToolConstants.PROPERTY_DECORATORS_VISIBLE);

				if (ga != null) {
					// Decorator is visualized
					if (!MOFToolConstants.VALUE_YES.equals(visibility)) {
						// Should not be shown
						ret = new Reason(true, "Needs to be removed"); //$NON-NLS-1$
					}
					else if (ga instanceof Text) {
						// Check if up to date
						Text text = (Text)ga;
						String oldName = text.getValue();
						if (!oldName.equals(newName)) {
							ret = new Reason(true, "Name out of date"); //$NON-NLS-1$
						}
					}
				}
				else {
					// Decorator is not visualized
					if (MOFToolConstants.VALUE_YES.equals(visibility)) {
						// Should be shown
						ret = new Reason(true, "Needs to be added"); //$NON-NLS-1$
					}
				}
			}
		}
		return ret;
	}

	public boolean update(IUpdateContext context) {
		boolean ret = false;

		ConnectionDecorator decorator = (ConnectionDecorator)context.getPictogramElement();
		Object object = getBusinessObjectForPictogramElement(decorator);
		if (object instanceof ModelElement) {
			ModelElement element = (ModelElement)object;

			String name = getText(element);
			if (name != null && name.length() > 0) {
				GraphicsAlgorithm graphicsAlgorithm = decorator.getGraphicsAlgorithm();
				Text text = null;
				if (graphicsAlgorithm == null) {
					// Is not displayed but should be (according to updateNeeded)
			        text = GaUtil.createText(decorator);
			        GaUtil.ignoreAll(text);
			        text.setStyle(StyleService.getConnectionDecoratorStyle(PeUtil.getDiagramForPictogramElement(decorator)));
			        
			        // Connect to rest of the world
			        decorator.setGraphicsAlgorithm(text);
				}
				else if (graphicsAlgorithm instanceof Text) {
					text = (Text)graphicsAlgorithm;
				}
				// Set the new name
				text.setValue(name);			

				
				ret = true;
			}
		}
		return ret;
	}
	

	
	protected String getText(ModelElement element) {
		return element.getName();
	}

	protected abstract String getLinkPropertyValue();
}
