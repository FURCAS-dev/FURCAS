package com.sap.ide.moftool.editor.graphics.clazz.reference;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.core.commands.CreateReferenceCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class CreateReferenceFeature extends AbstractCustomFeature {
	
	public static final int START_FROM_CLASS = 0;
	public static final int START_FROM_ASSOCIATION = 1;
	
	private AssociationEnd mExposedEnd = null;
	private AssociationEnd mRefencedEnd = null;
	private MofClass mContainingClass = null;
	private Association mForAssociation = null;
	private int mStartFrom;

	public CreateReferenceFeature(IFeatureProvider fp, AssociationEnd exposedEnd,
			AssociationEnd referencedEnd, MofClass containingClass,
			Association forAssociation, int startFrom) {
		super(fp);
		mExposedEnd = exposedEnd;
		mRefencedEnd = referencedEnd;
		mContainingClass = containingClass;
		mForAssociation = forAssociation;
		mStartFrom = startFrom;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// Allow add reference to a selected class
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (mContainingClass == null || mForAssociation == null) {
			return false;
		}
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass || bo instanceof Association) {
				ret = !ModelElementService.isForeignObject(getDiagram(), mContainingClass);
			}
		}
		return ret;
	}

	public void execute(ICustomContext context) {
		CreateReferenceCommand command = new CreateReferenceCommand(mExposedEnd,
				mRefencedEnd, mContainingClass, getConnection());
		command.execute();
		Reference reference = command.getReference();

		// Update graphical representation of class
		getFeatureProvider().updateIfPossible(
				new UpdateContext(getFeatureProvider().getPictogramElementForBusinessObject(mContainingClass)));

		// Find the according association
		Namespace namespace = reference.getReferencedEnd().getContainer();
		
		// Update the pictogram element of the according association
		if (namespace instanceof Association) {
			PictogramElement associationPe = getFeatureProvider().getPictogramElementForBusinessObject(namespace);
			if (associationPe != null) {
				getFeatureProvider().updateIfPossible(new UpdateContext(associationPe));
			}
		}
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext)context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				PictogramElement pe = pes[0];
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof MofClass || bo instanceof Association) {
					return true;
				}
			}
		}
		return ret;
	}

	public String getName() {
		String result = ""; //$NON-NLS-1$
		if (mStartFrom == START_FROM_CLASS) {
			String name = mForAssociation.getName();
//			if (mExposedEnd.getType() != null && mExposedEnd.getType().equals(mRefencedEnd.getType())) {
				result = name + " ( -> " + mRefencedEnd.getName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
//			}
		}
		else if (mStartFrom == START_FROM_ASSOCIATION) {
			String name = mContainingClass.getName();
			Classifier type = mExposedEnd.getType();
			Classifier type2 = mRefencedEnd.getType();
//			if (mExposedEnd.getType() != null && mExposedEnd.getType().equals(mRefencedEnd.getType())) {
				result = name + " ( -> " + mRefencedEnd.getName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
//			}
		}
		
		return result;
	}

	@Override
	public String getDescription() {
		return getName();
	}
	
	public int getStartFrom() {
		return mStartFrom;
	}
}
