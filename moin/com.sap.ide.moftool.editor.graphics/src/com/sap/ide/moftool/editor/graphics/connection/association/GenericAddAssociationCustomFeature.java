package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class GenericAddAssociationCustomFeature extends AbstractAddAssociationCustomFeature {

    private static final String DESCRIPTION = Messages.GenericAddAssociationCustomFeature_0_xmsg;
    private Association association;

    public GenericAddAssociationCustomFeature(IFeatureProvider fp, Association association) {
        super(fp);
        this.association = association;
        
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        //
        boolean ret = true;
        PictogramElement[] pes = context.getPictogramElements();
        PictogramElement firstPE = pes[0];
        if (pes != null && pes.length == 1 && firstPE instanceof ContainerShape) {
            Object bo = getBusinessObjectForPictogramElement(firstPE);
            if (bo instanceof MofClass) {
                MofClass mofClass = (MofClass) bo;
                // return false, if the mofClass contains the association, otherwise true.
                if (!ClassUtil.hasMofClassAssociationA(mofClass, association) && DiagramUtil.existAssocitionInDiagram(getDiagram(), association)) {
                    return false;
                }
            }
        }
        return ret;
    }

    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        PictogramElement firstPE = pes[0];
        if (pes != null && pes.length == 1 && firstPE instanceof ContainerShape) {
            ContainerShape classShape = (ContainerShape) firstPE;
            Object bo = getBusinessObjectForPictogramElement(firstPE);
            if (bo instanceof MofClass) {
                MofClass mofClass = (MofClass) bo;
                // retrieve the Association ends and add the association to diagram.
                AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
                if (aes[0].getType().equals(mofClass)) {
                    addAssociationToDiagram(association, (MofClass) aes[1].getType(), classShape, 1);
                } else if (aes[1].getType().equals(mofClass)) {
                    addAssociationToDiagram(association, (MofClass) aes[0].getType(), classShape, 1);
                }
            }
        }
    }

    @Override
    public boolean isAvailable(IContext context) {
        boolean ret = false;
        if (context instanceof ICustomContext) {
            PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
            if (pes != null && pes.length == 1) {
                PictogramElement pe = pes[0];
                Object bo = getBusinessObjectForPictogramElement(pe);
                if (bo instanceof MofClass) {
                    MofClass mofClass = (MofClass) bo;
                    // return true, if the mofClass has any association und this does not exist in Diagram.
                    if (ClassUtil.hasMofClassAssociationA(mofClass, association) && !DiagramUtil.existAssocitionInDiagram(getDiagram(), association)) {
                        return true;
                    }
                }
            }
        }
        return ret;
    }

    public String getName() {
        return association.getName();
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
