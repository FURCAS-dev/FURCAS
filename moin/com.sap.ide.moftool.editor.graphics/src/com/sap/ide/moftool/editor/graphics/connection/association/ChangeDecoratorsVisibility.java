package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.Association;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;

public class ChangeDecoratorsVisibility extends AbstractCustomFeature{

    private String mName = Messages.ChangeDecoratorsVisibility_0_xbut;
    private String mDescription = Messages.ChangeDecoratorsVisibility_1_xmsg;

    public ChangeDecoratorsVisibility(IFeatureProvider fp) {
        super(fp);
    }

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1 && firstPE instanceof Connection) {
			Connection connection = (Connection)firstPE;
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof Association) {
				// Set the visibility property for decorators of the connection               
				if (MOFToolConstants.VALUE_YES.equals(PeUtil.getPropertyValue(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE))) {                   
					PeUtil.setPropertyValue(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE, MOFToolConstants.VALUE_NO);
				}
				else { 
					PeUtil.setPropertyValue(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE, MOFToolConstants.VALUE_YES);
				}                
				getFeatureProvider().updateIfPossible(new UpdateContext(connection));
			}
		}
	}

    @Override
    public boolean canExecute(ICustomContext context) {
        //
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        PictogramElement firstPE = pes[0];
        if (pes != null && pes.length == 1 && firstPE instanceof Connection) {
            Connection connection = (Connection) firstPE;
            Object bo = getBusinessObjectForPictogramElement(firstPE);
            if (bo instanceof Association) {
               if(PeUtil.getProperty(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE)!= null){
                   ret = true;
               }
            }
        }
        return ret;
    }
    
	@Override
	public boolean isAvailable(IContext context) {     
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext)context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				PictogramElement pe = pes[0];
				if (pe instanceof Connection) {
					Connection connection = (Connection)pe;
					Object bo = getBusinessObjectForPictogramElement(connection);
					if (bo instanceof Association) {
						if (MOFToolConstants.VALUE_YES.equals(PeUtil.getPropertyValue(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE))) {
							// Decorators are currently visible -> Option to hide them
							mName = Messages.ChangeDecoratorsVisibility_2_xbut;
							mDescription = Messages.ChangeDecoratorsVisibility_3_xmsg;
						}
						else {
							// Decorators are currently invisible -> Option to show them
							mName = Messages.ChangeDecoratorsVisibility_4_xbut;
							mDescription = Messages.ChangeDecoratorsVisibility_5_xmsg;
						}
						return true;
					}
				}
			}
		}
		return ret;
	}

	public String getName() {
		return mName;
	}

	@Override
	public String getDescription() {
		return mDescription;
	}
}
