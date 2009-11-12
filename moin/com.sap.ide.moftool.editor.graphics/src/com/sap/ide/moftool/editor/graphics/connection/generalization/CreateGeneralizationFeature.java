package com.sap.ide.moftool.editor.graphics.connection.generalization;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.core.commands.AddSuperStructureTypeCommand;
import com.sap.ide.moftool.editor.core.commands.AddSuperclassCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.features.jam.AbstractCreateConnectionFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.util.PeUtil;

public class CreateGeneralizationFeature extends AbstractCreateConnectionFeature {

	public CreateGeneralizationFeature(IFeatureProvider fp) {
		super(fp, Messages.CreateGeneralizationFeature_0_xbut, Messages.CreateGeneralizationFeature_1_xmsg);
	}

	public boolean canCreate(ICreateConnectionContext context) {

		Anchor sourceAnchor = getAnchor(context.getSourceAnchor(), context.getSourcePictogramElement());
		Anchor targetAnchor = getAnchor(context.getTargetAnchor(), context.getTargetPictogramElement());

		if (sourceAnchor != null && targetAnchor != null) {
			PictogramElement sourceContainer = sourceAnchor.getParent();
			PictogramElement targetContainer = targetAnchor.getParent();

			MofClass sourceMofClass = null;
			StructureType sourceStructureType = null;
			Object object = getBusinessObjectForPictogramElement(sourceContainer);
			if (object instanceof MofClass) {
				sourceMofClass = (MofClass) object;
			} else if (object instanceof StructureType) {
				sourceStructureType = (StructureType) object;
			} else {
				return false;
			}

			MofClass targetMofClass = null;
			StructureType targetStructureType = null;
			object = getBusinessObjectForPictogramElement(targetContainer);
			if (object instanceof MofClass) {
				targetMofClass = (MofClass) object;
			} else if (object instanceof StructureType) {
				targetStructureType = (StructureType) object;
			} else {
				return false;
			}

			if (sourceMofClass != null && targetMofClass != null && sourceMofClass != targetMofClass) {
				if (ConnectionUtil.existDirectGeneralize(getFeatureProvider().getConnection(), sourceMofClass, targetMofClass)
				// || ClassUtil.isASuperClassOfB(target, source)
						|| ClassUtil.isASuperClassOfB(sourceMofClass, targetMofClass)) {
					// || ClassUtil.hasAOneSuperClassOfB(source, target)
					// || ConnectionUtil.existDirectGeneralize(getFeatureProvider().getConnection(), source, target)) {
					// || ClassUtil.isASuperClassOfB(source, target)
					// || ConnectionUtil.existGeneralize(getFeatureProvider().getConnection(), source, target)) {
					return false;
				} else {
					return !ModelElementService.isForeignObject(getDiagram(), sourceMofClass);
				}
			} else if (sourceStructureType != null && targetStructureType != null && sourceStructureType != targetStructureType){
				if (ClassUtil.isASuperStructureOfB(sourceStructureType, targetStructureType)) {
							return false;
				} else {
					return !ModelElementService.isForeignObject(getDiagram(), sourceStructureType);
				}				
			}

		}
		return false;
	}

	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor sourceAnchor = getAnchor(context.getSourceAnchor(), context.getSourcePictogramElement());
		if (sourceAnchor != null) {
			PictogramElement sourceContainer = sourceAnchor.getParent();
			Object bo = getBusinessObjectForPictogramElement(sourceContainer);
			if (bo instanceof MofClass || bo instanceof StructureType) {
				return true;
			}
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {

		Connection newConnection = null;

		Anchor sourceAnchor = getAnchor(context.getSourceAnchor(), context.getSourcePictogramElement());
		Anchor targetAnchor = getAnchor(context.getTargetAnchor(), context.getTargetPictogramElement());

		if (sourceAnchor == null || targetAnchor == null) {
			return null;
		}

		PictogramElement sourceContainer = sourceAnchor.getParent();
		PictogramElement targetContainer = targetAnchor.getParent();
		// get mof classes which should be connected
		MofClass sourceMofClass = null;
		StructureType sourceStructureType = null; 
		Object object = getBusinessObjectForPictogramElement(sourceContainer);
		if (object instanceof MofClass) {
			sourceMofClass = (MofClass) object;
		} else if (object instanceof StructureType) {
			sourceStructureType = (StructureType) object;
		} else {
			return null;
		}
		
		MofClass targetMofClass = null;
		StructureType targetStructureType = null;
		object = getBusinessObjectForPictogramElement(targetContainer);
		if (object instanceof MofClass) {
			targetMofClass = (MofClass) object;
		} else if (object instanceof StructureType) {
			targetStructureType = (StructureType) object;
		} else {
			return null;
		}

		if (sourceMofClass != null && targetMofClass != null) {

			// create business object for the new connection
			AddSuperclassCommand command = new AddSuperclassCommand(sourceMofClass, targetMofClass, getFeatureProvider().getConnection());
			command.execute();

			// use existing add feature for the creation of the graphical representation
			AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
			addContext.setNewObject(command.getGeneralizes());
			PictogramElement pe = getFeatureProvider().addIfPossible(addContext);
			if (pe instanceof Connection) {
				newConnection = (Connection) pe;
			}
		} else if (sourceStructureType != null && targetStructureType != null) { 
			// create business object for the new connection
			AddSuperStructureTypeCommand command = new AddSuperStructureTypeCommand(sourceStructureType, targetStructureType, getFeatureProvider().getConnection());
			command.execute();

			// use existing add feature for the creation of the graphical representation
			AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
			addContext.setNewObject(command.getGeneralizes());
			PictogramElement pe = getFeatureProvider().addIfPossible(addContext);
			if (pe instanceof Connection) {
				newConnection = (Connection) pe;
			}		    
		}
		
		return newConnection;
	}

	@Override
	public String getCreateImageId() {
		return IImageConstants.IMG_GENERALIZATION;
	}

	private Anchor getAnchor(Anchor anchor, PictogramElement pe) {
		Anchor ret = anchor;
		if (ret == null) {
			// get mof compartment pattern
			IFeatureProvider featureProvider = getFeatureProvider();
			AbstractMofCompartmentPattern mofPattern = null;
			if ((featureProvider != null) && (featureProvider instanceof ClassDiagramFeatureProvider)) {
				IPattern pattern = ((ClassDiagramFeatureProvider) featureProvider).getPatternForPictogramElement(pe);
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
