package com.sap.ide.moftool.editor.graphics.connection.association;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class AddAllAssociationCustomFeature extends AbstractAddAssociationCustomFeature{


	private static final String NAME = Messages.AddAllAssociationCustomFeature_0_xbut;
	private static final String DESCRIPTION = Messages.AddAllAssociationCustomFeature_1_xmsg;

	public AddAllAssociationCustomFeature(IFeatureProvider fp) {
		super(fp);
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
				if(!ClassUtil.hasMofClassAnyAssociation(mofClass)){
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
				List<Association> assocs = ClassService.getAllAssociations(mofClass);
				if (!assocs.isEmpty()) {
					int classCount = 1;
					for (Iterator<Association> iter = assocs.iterator(); iter.hasNext();) {
						Association association = iter.next();
						AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
						if (aes[0].getType().equals(mofClass)) {
							addAssociationToDiagram(association, (MofClass) aes[1].getType(), classShape, classCount);
						} else if(aes[1].getType().equals(mofClass)){
							addAssociationToDiagram(association, (MofClass) aes[0].getType(), classShape, classCount);
						}
					}                  
				}
			}
		}
	}

	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
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
					MofClass mofClass = (MofClass) bo ;
					if (ClassUtil.hasMofClassAnyAssociation(mofClass) && !DiagramUtil.existAllAssociationOfMofClassInDiagram(getDiagram(),mofClass) ){
						return true;
					}
				}
			}
		}
		return ret;
	}


	protected void addClassToDiagram(MofClass mofClass, ContainerShape cs, int classCount) { 
		GraphicsAlgorithm ga = cs.getGraphicsAlgorithm();
		int deltaX = classCount*50;
		int deltaY = 600;
		int newWidth = ClassUtil.calculateASuitableWidth(mofClass);
		AddContext addContext = new AddContext();
		addContext.setNewObject(mofClass);
		addContext.setTargetContainer(getDiagram());
		addContext.setLocation(ga.getX()- deltaX, ga.getY()- deltaY);
		addContext.setWidth(newWidth);

		getFeatureProvider().addIfPossible(addContext);       
	}

}
