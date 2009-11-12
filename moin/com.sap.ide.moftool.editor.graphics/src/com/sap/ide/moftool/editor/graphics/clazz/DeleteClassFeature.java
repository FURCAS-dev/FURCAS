package com.sap.ide.moftool.editor.graphics.clazz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.commands.DeleteClassCommand;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class DeleteClassFeature extends DefaultDeleteFeature{
    private static final String NAME = Messages.DeleteClassFeature_0_xbut; 
    private List<String>  allAffectedPEs = new ArrayList<String>();
    private static String className;
	private boolean mAskUser = true;
   
    public DeleteClassFeature(IFeatureProvider fp) {
        super(fp);      
    }
  
    @Override
    public boolean canDelete(IDeleteContext context) {
    	boolean ret = super.canDelete(context);
    	if (!ret) {
    		return false;
    	}
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof MofClass ){
            MofClass mofClass = (MofClass)bo ;
            className = mofClass.getName();
            ret = !ModelElementService.isForeignObject(getDiagram(), mofClass);
        }
            
        return ret;
    }

    @Override
    public void delete(IDeleteContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof MofClass && getUserDecision()) {
            preDelete(context);
            
            MofClass mofClass = (MofClass) bo;
            // delete the Class
            DeleteClassCommand command = new DeleteClassCommand(mofClass, getConnection());
            command.execute();
            // Remove pictogram element from diagram
            IRemoveContext rc = new RemoveContext(pe);
            IFeatureProvider featureProvider = getFeatureProvider();
            IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
            if (removeFeature != null) {
                removeFeature.remove(rc);
            }
            
            postDelete(context);
        }
     
    }

    @Override
    public boolean isAvailable(IContext context) {
        boolean ret = false;
        if (context instanceof IDeleteContext) {
            PictogramElement pe = ((IDeleteContext) context).getPictogramElement();
            if (pe != null) {
                Object bo = getBusinessObjectForPictogramElement(pe);
                if (bo instanceof MofClass) {
                    ret = true;
                }
            }
        }
        return ret;
    }
    
    
    public String getName(){
        return NAME;
    }

	public void setAskUser(boolean ask) {
		mAskUser = ask;
	}

	@Override
	protected String getQuestionToUser() {
		if (mAskUser) {
//			return "Do you really want to delete " + className +"?";
			return MessageFormat.format(Messages.DeleteClassFeature_1_xmsg, new Object[]{className}); 

		}
		else {
			return null;
		}
	}

    @Override
    public void preDelete(IDeleteContext context) {      
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof MofClass) {
            MofClass mofClass = (MofClass) bo;
            List<Association> assocs = ClassService.getAllAssociations(mofClass);
            for (Iterator<Association> iter = assocs.iterator(); iter.hasNext();){
                Association assoc = (Association) iter.next();
                AssociationEnd[] aes = AssociationService.getAssociationEnds(assoc);
                if(aes[0].getType() != null && aes[0].getType().getName().equals(mofClass.getName())){
                	if(aes[1].getType() != null) {
                		allAffectedPEs.add(aes[1].getType().getName());
                	}
                } else if(aes[1].getType() != null && aes[1].getType().getName().equals(mofClass.getName())){
                	if(aes[0].getType() != null) {
                		allAffectedPEs.add(aes[0].getType().getName());
                	}
                }
//    			DeleteAssociationCommand command = new DeleteAssociationCommand(assoc, getConnection());
//    	        command.execute();
            }
        }
    }

    @Override
    public void postDelete(IDeleteContext context) { 
       for(Iterator<String> iter = allAffectedPEs.iterator();iter.hasNext();){
           PictogramElement pe = DiagramUtil.getPictogramElementByName(iter.next(),getDiagram());
           if(pe != null){
               updatePictogramElement(pe);
           }
       }
       
    }
    

}
