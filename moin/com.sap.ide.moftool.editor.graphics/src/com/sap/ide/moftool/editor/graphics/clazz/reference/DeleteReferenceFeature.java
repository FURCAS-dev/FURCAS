package com.sap.ide.moftool.editor.graphics.clazz.reference;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.core.commands.DeleteModelElementCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.pattern.IPattern;

public class DeleteReferenceFeature extends DefaultDeleteFeature {

	private static final String NAME = Messages.DeleteReferenceFeature_0_xbut;
	private static final String DESCRIPTION = Messages.DeleteReferenceFeature_1_xmsg;
	private static String mRefName;
	private boolean mAskUser = true;

	public DeleteReferenceFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean isAvailable(IContext context) {
		if (context instanceof IDeleteContext) {
			Reference reference = getReferenceFromContext((IDeleteContext)context);
			if (reference != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		Reference reference = getReferenceFromContext(context);
		if (reference != null) {
			mRefName = reference.getName();
			return !ModelElementService.isForeignObject(getDiagram(), reference);
		}
		return false;
	}

	public void delete(IDeleteContext context) {
		Reference reference = getReferenceFromContext(context);
		if (reference != null) {
			// Find the according association
			Namespace namespace = reference.getReferencedEnd().getContainer();
			
			// Delete the reference from class
			DeleteModelElementCommand command = new DeleteModelElementCommand(reference, getConnection());
			command.execute();
			PictogramElement pe = context.getPictogramElement();
			if (pe != null) {
				// Update the pictogram element of the pattern root
				IFeatureProvider featureProvider = getFeatureProvider();
				if (featureProvider instanceof ClassDiagramFeatureProvider) {
					IPattern pattern = ((ClassDiagramFeatureProvider)featureProvider).getPatternForPictogramElement(pe);
					if (pattern instanceof AbstractMofCompartmentPattern) {
						AbstractMofCompartmentPattern mofPattern = (AbstractMofCompartmentPattern)pattern;
						getFeatureProvider().updateIfPossible(new UpdateContext(mofPattern.getPatternRoot(pe)));
					}
				}

				// Update the pictogram element of the according association
				if (namespace instanceof Association) {
					PictogramElement associationPe = getFeatureProvider().getPictogramElementForBusinessObject(namespace);
					if (associationPe != null) {
						getFeatureProvider().updateIfPossible(new UpdateContext(associationPe));
					}
				}
			}
		}
	}

	@Override
	public String getName(){
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	public void setAskUser(boolean ask) {
		mAskUser = ask;
	}

	@Override
	protected String getQuestionToUser() {
		if (mAskUser) {
//			return "Do you really want to delete " + mRefName +"?";
			return MessageFormat.format(Messages.DeleteReferenceFeature_2_xmsg, new Object[]{mRefName});
		}
		else {
			return null;
		}
	}
	
	private Reference getReferenceFromContext(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof Reference) {
				return (Reference)bo;
			}
		}
		return null;
	}
}
