package com.sap.ide.moftool.editor.graphics.connection.generalization;

import java.util.Collection;
import java.util.Iterator;
import com.sap.tc.moin.repository.mmi.model.Generalizes;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddConnectionContext;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.jam.AbstractAddShapeFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;

public class AddGeneralizationFeature extends AbstractAddShapeFeature {

    public AddGeneralizationFeature(IFeatureProvider fp) {
        super(fp);
    }

    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConnectionContext = (IAddConnectionContext) context;

        Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
        Anchor targetAnchor = addConnectionContext.getTargetAnchor();
        // create graphical connection 
        Connection connection = ConnectionUtil.createGeneralizationConnection(getDiagram(), sourceAnchor, targetAnchor);
        PeUtil.setPropertyValue(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION, null);

        // CHECK: Is it necessary to call the update association-feature here explicitly?
        // Currently it seems that the update is triggered once again afterwards by the
        // update of the class shape, but it's not fully sure that this happens in all
        // usage scenarios.
//        updatePictogramElement(connection);
//        updatePictogramElement(targetAnchor.getParent());
//        updatePictogramElement(sourceAnchor.getParent());
       
        return connection;
    }

    public boolean canAdd(IAddContext context) {
        boolean ret = false;

        if (context instanceof IAddConnectionContext && context.getNewObject() instanceof Generalizes) {

            IAddConnectionContext addConnectionContext = (IAddConnectionContext) context;
            Anchor source = addConnectionContext.getSourceAnchor();
            Anchor target = addConnectionContext.getTargetAnchor();
            if (source != null && target != null && source!= target) {
                AnchorContainer sourceContainer = source.getParent();
                AnchorContainer targetContainer = target.getParent();

                // check whether anchor-containers still have a connection of type generalization
                Collection<Connection> allConnections = getDiagram().getConnections();
                for (Iterator<Connection> iter = allConnections.iterator(); iter.hasNext();) {
                    Connection connection = iter.next();
                    if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
                        Anchor startAnchor = connection.getStart();
                        Anchor endAnchor = connection.getEnd();
                        if (startAnchor != null && endAnchor != null) {
                            AnchorContainer currentSource = startAnchor.getParent();
                            AnchorContainer currentTarget = endAnchor.getParent();
                            if ((currentSource.equals(sourceContainer) && currentTarget.equals(targetContainer))
                                || (currentSource.equals(targetContainer) && currentTarget.equals(sourceContainer))) {
                                return false;
                            }
                        }
                    }
                }
                ret = true;
            }
        }
        return ret;
    }
}
