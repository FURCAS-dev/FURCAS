package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;

public class CreateAssociationFeature extends CreateAbstractAssociationFeature {

    public CreateAssociationFeature(IFeatureProvider fp) {
        super(fp, Messages.CreateAssociationFeature_0_xbut, Messages.CreateAssociationFeature_1_xmsg);
    }
    
    @Override
    public String getCreateImageId() {
        return IImageConstants.IMG_ASSOCIATION;
    }

    @Override
    protected AggregationKindEnum getAssociationType() {
        return AggregationKindEnum.NONE;
    }

}
