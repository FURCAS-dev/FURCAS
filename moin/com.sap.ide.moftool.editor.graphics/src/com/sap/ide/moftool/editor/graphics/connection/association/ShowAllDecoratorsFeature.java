package com.sap.ide.moftool.editor.graphics.connection.association;

import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Association;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;

public class ShowAllDecoratorsFeature extends AbstractCustomFeature {

    private String mName = Messages.ShowAllDecoratorsFeature_0_xbut;
    private String mDescription = Messages.ShowAllDecoratorsFeature_1_xmsg;

    public ShowAllDecoratorsFeature(IFeatureProvider fp) {
        super(fp);
    }

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			if (firstPE instanceof Diagram) {
				Iterator<Connection> it = ((Diagram)firstPE).getConnections().iterator();
				Connection connection = null;
				while (it.hasNext()) {
					connection = it.next();
					Object bo = getBusinessObjectForPictogramElement(connection);
					if (bo instanceof Association) {			                 
						PeUtil.setPropertyValue(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE, MOFToolConstants.VALUE_YES);            
						getFeatureProvider().updateIfPossible(new UpdateContext(connection));
					}
				}
				
			}
		}
	}
	
    @Override
    public boolean canExecute(ICustomContext context) {
        //
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        PictogramElement firstPE = pes[0];
        if (pes != null && pes.length == 1) {
        	if (firstPE instanceof Diagram) {
        		ret = true;
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
				if (pe instanceof Diagram) {				
					return true;
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
