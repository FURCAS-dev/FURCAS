package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.Text;

public class UpdateAssociationNameFeature extends UpdateTextDecoratorFeature {

    public UpdateAssociationNameFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	protected String getLinkPropertyValue() {
		return MOFToolConstants.ASSOCIATION_NAME;
	}


	public static int calculateOffsetX(ConnectionDecorator decorator, Text text) {
		int textLength = text.getValue().length();
		
		int offsetX = 0;
		if (textLength != 0 && GaUtilInternal.getFont(text, true).getSize() != 0) {
			offsetX = 0 - GaUtilInternal.getFont(text, true).getSize() * textLength / 2;
		}
		return offsetX;
	}
	
	public static int calculateOffsetY(ConnectionDecorator decorator, Text text) {
		return 0;
	}
}
