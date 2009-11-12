package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.ReferenceService;
import com.sap.ide.moftool.editor.graphics.serviceLayer.ParserUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionDecoratorUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class AssociationEndMultiplicityDirectEditingFeature extends AbstractConnectionDecoratorDirectEditingFeature {

	public AssociationEndMultiplicityDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {
		String ret = null;
		AssociationEnd associationEnd = getAssociationEnd(context);
		if (associationEnd != null) {
			MultiplicityType multiplicity = associationEnd.getMultiplicity();
			if (multiplicity != null) {
				ret = ConnectionDecoratorUtil.getMultiplicityAsText(multiplicity);
			}
		}
		return ret;
	}

	public void setValue(String value, IDirectEditingContext context) {
		AssociationEnd assocEnd = getAssociationEnd(context);

		int[] calculatedMult = ConnectionDecoratorUtil.calculateMultiplicityFromString(value);
		int lower = calculatedMult[0];
		int upper = calculatedMult[1];
		MultiplicityType oldMultiplicity = assocEnd.getMultiplicity();

		if (oldMultiplicity.getLower() != lower || oldMultiplicity.getUpper() != upper) {
			ModelPackage modelPackage = MofService.getModelPackage(getConnection());
			boolean ordered = oldMultiplicity.isOrdered();
			boolean unique = oldMultiplicity.isUnique();
			if (upper == 1) {
				// [c-57] if a MultiplicityType specifies bounds of [0..1] or [1..1], the is_ordered and is_unique values must be false
				ordered = false;
				unique = false;
			} else {
				// [C-40]: The "isUnique" flag in an AssociationEnd's multiplicity must be true
				unique = true;
			}
			MultiplicityType newMultiplicity = MofService.createMultiplicityType(modelPackage, lower, upper, ordered, unique);
			// set Multiplicity
			assocEnd.setMultiplicity(newMultiplicity);
			// set corresponding reference multiplicity
			List<Reference> references = ReferenceService.findReferences(assocEnd);
			for (Iterator<Reference> iter = references.iterator(); iter.hasNext();) {
				Reference reference = iter.next();
				reference.setMultiplicity(newMultiplicity);
			}
		}
		updatePictogramElement(context.getPictogramElement());
	}

	@Override
	public String[] getPossibleValues(IDirectEditingContext context) {
		return ConnectionDecoratorUtil.getPossibleMultiplicityValues();
	}

	private AssociationEnd getAssociationEnd(IDirectEditingContext directEditingContext) {
		AssociationEnd assocEnd = null;
		PictogramElement pe = directEditingContext.getPictogramElement();
		Object object = getBusinessObjectForPictogramElement(pe);
		if (object instanceof AssociationEnd) {
			assocEnd = (AssociationEnd) object;
		}
		return assocEnd;
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		return ParserUtil.checkMultiplicity(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#stretchTextfieldToFitText()
	 */
	@Override
	public boolean stretchTextfieldToFitText() {
		return true;
	}

}
