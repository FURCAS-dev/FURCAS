package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

public abstract class AbstractAddClassesFeature extends AbstractCustomFeature {
    
    public AbstractAddClassesFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        return true;
    }
        
    @Override
    public boolean isAvailable(IContext context) {
        boolean ret = false;
        if (context instanceof ICustomContext) {
            PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
            if (pes.length == 1) {
                Object bo = getBusinessObjectForPictogramElement(pes[0]);
                if (bo instanceof MofClass) {
                    ret = canExecute(context);
                }
            }
        }
        return ret;
    }

    protected void addClassToDiagram(MofClass mofClass, ContainerShape cs, int classCount, boolean isSuper) { 
        GraphicsAlgorithm ga = cs.getGraphicsAlgorithm();
        int deltaX = classCount*50;
        int deltaY = 300;
        //int newWidth = ClassUtil.calculateASuitableWidth(mofClass);
        if(!isSuper){
            deltaX = -deltaX;
            deltaY = -deltaY;
        }
        AddContext addContext = new AddContext();
        addContext.setNewObject(mofClass);
        addContext.setTargetContainer(getDiagram());
        addContext.setLocation(ga.getX()- deltaX, ga.getY()- deltaY);
       // addContext.setWidth(newWidth);
        
        getFeatureProvider().addIfPossible(addContext);       
    }
    
   protected void autoLayout(ContainerShape shape, int x, int y) {
       MoveShapeContext moveShapeContext = new MoveShapeContext(((Shape) shape));
       moveShapeContext.setX(x);
       moveShapeContext.setY(y);
       moveShapeContext.setSourceContainer(((Shape) shape).getContainer());
       moveShapeContext.setTargetContainer(((Shape) shape).getContainer());
       IMoveShapeFeature moveShapeFeature = getFeatureProvider().getMoveShapeFeature(moveShapeContext);

       if (moveShapeFeature != null && moveShapeFeature.canMoveShape((moveShapeContext)))
           moveShapeFeature.execute(moveShapeContext);

   }

   
}
