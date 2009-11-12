package com.sap.ide.moftool.editor.graphics.connection.datatype;

import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddConnectionContext;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.jam.AbstractAddShapeFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class AddDataTypeConnectionFeature extends AbstractAddShapeFeature {

    public AddDataTypeConnectionFeature(IFeatureProvider fp) {
        super(fp);
    }

    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConnectionContext = (IAddConnectionContext) context;

        Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
        Anchor targetAnchor = addConnectionContext.getTargetAnchor();
       
        // create graphical connection 
        Connection connection = ConnectionUtil.createInnerTypeConnection(getDiagram(), sourceAnchor, targetAnchor);

        updatePictogramElement(connection);
        updatePictogramElement(targetAnchor.getParent());
        updatePictogramElement(sourceAnchor.getParent());
       
        return connection;
    }

    public boolean canAdd(IAddContext context) {
        if (context instanceof IAddConnectionContext && context.getNewObject() == null) {
            return true;
        }
        return false;
    }

   
}
