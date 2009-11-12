package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;

import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;

public class CreateCompositionFeature extends CreateAbstractAssociationFeature{

    public CreateCompositionFeature(IFeatureProvider fp) {
        super(fp, Messages.CreateCompositionFeature_0_xbut, Messages.CreateCompositionFeature_1_xmsg);
    }

    @Override
    protected AggregationKindEnum getAssociationType() {
        return AggregationKindEnum.COMPOSITE;
    }
    @Override
    public String getCreateImageId() {
        return IImageConstants.IMG_COMPOSITION;
    }
}
