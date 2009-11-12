package com.sap.ide.moftool.editor.graphics.connection.generalization;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.jam.DefaultReconnectionFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.util.PeUtil;

public class ReconnectGeneralizationFeature extends DefaultReconnectionFeature {

    public ReconnectGeneralizationFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canReconnect(IReconnectionContext context) {
        Connection connection = context.getConnection();
        if (super.canReconnect(context)
            && PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {

            Anchor newAnchor = getNewAnchor(context);
            Anchor oldAnchor = context.getOldAnchor();
            MofClass newMofClass = (MofClass)getBusinessObjectForPictogramElement(newAnchor.getParent());
            MofClass oldMofClass = (MofClass)getBusinessObjectForPictogramElement(oldAnchor.getParent());

            if (!oldAnchor.getParent().equals(newAnchor.getParent())
                && !newAnchor.getParent().equals(connection.getEnd().getParent())
                && !newAnchor.getParent().equals(connection.getStart().getParent())) {

                Anchor oldStart = connection.getStart();
                Anchor oldEnd = connection.getEnd();
                MofClass oldStartClass = (MofClass)getBusinessObjectForPictogramElement(oldStart.getParent());
                MofClass oldEndClass = (MofClass)getBusinessObjectForPictogramElement(oldEnd.getParent());

                // determine which end of generalization is not moved
                MofClass notChangedClass = oldMofClass.equals(oldStartClass) ? oldEndClass : oldStartClass;

                if (ConnectionUtil.existDirectGeneralize(getFeatureProvider().getConnection(), newMofClass,
                    notChangedClass)
                    || ConnectionUtil.existDirectGeneralize(getFeatureProvider().getConnection(), notChangedClass,
                        newMofClass)
//                    || ConnectionUtil.existGeneralize(getFeatureProvider().getConnection(), newMofClass,
//                        notChangedClass) 
                    || ClassUtil.isASuperClassOfB(notChangedClass, newMofClass)) {

                    return false;
                } else
                    return !ModelElementService.isForeignObject(getDiagram(), oldStartClass);
            }
        }

        return false;
    }

    @Override
    public void execute(IContext context) {
        IReconnectionContext reContext = (IReconnectionContext) context;
        Connection connection = reContext.getConnection();

        // delete old generalization from bussines model
        Anchor oldStart = connection.getStart();
        Anchor oldEnd = connection.getEnd();
        MofClass oldSource = (MofClass)getBusinessObjectForPictogramElement(oldStart.getParent());
        MofClass oldTarget = (MofClass)getBusinessObjectForPictogramElement(oldEnd.getParent());

        if (ConnectionUtil.existDirectGeneralize(getFeatureProvider().getConnection(), oldSource, oldTarget)) {
            ConnectionUtil.deleteGeneralize(getFeatureProvider().getConnection(), oldSource, oldTarget);
        }

        // create business object for the new connection
        Anchor oldAnchor = reContext.getOldAnchor();
        Anchor newAnchor = getNewAnchor(reContext);
        MofClass target = (MofClass)getBusinessObjectForPictogramElement(newAnchor.getParent());

        if (oldAnchor.equals(oldEnd)) {
            ConnectionUtil.createGeneralization(getFeatureProvider().getConnection(), oldSource, target);
            connection.setEnd(newAnchor);
        } else if (oldAnchor.equals(oldStart)) {
            ConnectionUtil.createGeneralization(getFeatureProvider().getConnection(), target, oldTarget);
            connection.setStart(newAnchor);
        }

    }

    @Override
    protected Anchor getNewAnchor(IReconnectionContext context) {
        Anchor ret = context.getNewAnchor();
        if (ret == null) {
            PictogramElement pe = context.getTargetPictogramElement();
            // get mof compartment pattern
        	IFeatureProvider featureProvider = getFeatureProvider();
            AbstractMofCompartmentPattern mofPattern = null;
            if ((featureProvider != null) && (featureProvider instanceof ClassDiagramFeatureProvider)) {
                IPattern pattern = ((ClassDiagramFeatureProvider) featureProvider)
                    .getPatternForPictogramElement(pe);
                if ((pattern != null) && (pattern instanceof AbstractMofCompartmentPattern)) {
                    mofPattern = (AbstractMofCompartmentPattern) pattern;
                } else {
                    return null;
                }
            } else {
                return null;
            }
            // get outer shape
            Shape outerShape = mofPattern.getPatternRoot(pe);
            if (outerShape == null) {
                return null;
            } 
            // get anchor
            ret = PeUtil.getChopboxAnchor(outerShape);
        }
        return ret;
    }
}
