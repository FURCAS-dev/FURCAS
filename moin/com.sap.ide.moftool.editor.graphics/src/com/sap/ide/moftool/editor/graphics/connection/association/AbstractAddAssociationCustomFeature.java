package com.sap.ide.moftool.editor.graphics.connection.association;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.AnchorUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

public abstract class AbstractAddAssociationCustomFeature extends AbstractCustomFeature{

    
    public AbstractAddAssociationCustomFeature(IFeatureProvider fp) {
        super(fp);
    }

    protected void addAssociationToDiagram(Association association, MofClass mofClass, ContainerShape cs, int classCount) {
        
        // if the associated class does not exists in diagram, the class will be added to diagram and after that the association
        if (!DiagramService.isContainedInDiagram(getDiagram(), mofClass)) {
            GraphicsAlgorithm ga = cs.getGraphicsAlgorithm();
            int deltaX = -500;
            int deltaY = classCount * 50;
            int newWidth = ClassUtil.calculateASuitableWidth(mofClass);
            
            // add graphical representation to diagram
            AddContext addContext = new AddContext();
            addContext.setNewObject(mofClass);
            addContext.setTargetContainer(getDiagram());
            addContext.setLocation(ga.getX() - deltaX, ga.getY() - deltaY);
            addContext.setWidth(newWidth);

            getFeatureProvider().addIfPossible(addContext);
            // if the class exist, only the association will be added to diagram
        } 
        else if(!DiagramUtil.existAssocitionInDiagram(getDiagram(), association)){
            ChopboxAnchor sourceAnchor = null;
            ChopboxAnchor targetAnchor = null;
            
            ContainerShape existingClassShape = DiagramUtil.getExistingMofClassShapeFromDiagram(getDiagram(), mofClass);
            AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
            Collection<Anchor> sAnchors = cs.getAnchors();
            Collection<Anchor> tAnchors = existingClassShape.getAnchors();
            
            if (aes[0].getType().equals(mofClass)) {                
                 sourceAnchor = AnchorUtil.getChopboxAnchor(sAnchors);
                 targetAnchor = AnchorUtil.getChopboxAnchor(tAnchors);
            }else if(aes[1].getType().equals(mofClass)){
                sourceAnchor = AnchorUtil.getChopboxAnchor(tAnchors);
                targetAnchor = AnchorUtil.getChopboxAnchor(sAnchors);
            }
            
            // add graphical representation to diagram
            AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
            addContext.setNewObject(association);
            getFeatureProvider().addIfPossible(addContext);
        }
    }
}
