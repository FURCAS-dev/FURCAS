package com.sap.ide.moftool.editor.graphics.clazz.attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.graphics.clazz.ClassDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.ParserUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class ClassAttributeDirectEditingFeature extends ClassDirectEditingFeature {

	public ClassAttributeDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		StringBuffer ret = new StringBuffer();
		if (bo instanceof Attribute) {
			Attribute attribute = (Attribute) bo;
			Classifier type = attribute.getType();
			String typeName = null;
			if (type != null) {
				typeName = type.getName();
			}
			ret.append(attribute.getName() + " : " + typeName + ClassUtil.getAttributeMultiplicityAsString(attribute)); //$NON-NLS-1$
		}
		return ret.toString();
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof Attribute) {
			Attribute attribute = (Attribute) bo;
			attribute.setName(ParserUtil.getNameFromValue(value, ':'));
			String type = ParserUtil.getAttributeTypeFromValue(value);
			Classifier newClassifier = null;
			Classifier oldClassifier = null;
			if (type != null && type.lastIndexOf('.') != -1) {
				// type name is qualified:
				// get type by qualified name
				newClassifier = MofService.getClassifierByQualifiedName(getConnection(), type);
				attribute.setType(newClassifier);
			} else {
				String oldTypeName = null;
				oldClassifier = attribute.getType();
				if (oldClassifier != null) {
					oldTypeName = oldClassifier.getName();
				}
				if ((oldTypeName == null) || (!oldTypeName.equals(type))) {
					newClassifier = MofService.getClassifier(getConnection(), type);
					attribute.setType(newClassifier);
				}
			}

			int[] calculatedMultiplicity = ParserUtil.calculateMultiplicityFromValue(ParserUtil.getMultiplicityFromValue(value));
			int lower = calculatedMultiplicity[0];
			int upper = calculatedMultiplicity[1];
			ModelPackage modelPackage = MofService.getModelPackage(getConnection());
			MultiplicityType multiplicity = MofService.createMultiplicityType(modelPackage, lower, upper, attribute.getMultiplicity()
					.isOrdered(), attribute.getMultiplicity().isUnique());

			attribute.setMultiplicity(multiplicity);
			updatePictogramElement(pe);
		}

	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);

		if (bo instanceof Attribute) {
			Attribute att = (Attribute) bo;

			String name = ParserUtil.getNameFromValue(value, ':');
			String type = ParserUtil.getAttributeTypeFromValue(value);
			// <pg290108> new name validation
			IStatus status = null;
			String oldName = att.getName();
			if (name != null) {
				if (name.equals(oldName)) {
					status = NamespaceService.validate(att, ""); //$NON-NLS-1$
				} else {
					status = NamespaceService.checkForNewSubobject(att.getContainer(), name);
				}
				if ((status != null) && status.getSeverity() == IStatus.ERROR) {
					return status.getMessage();
				}
			}
			// </pg290108>
			int openBracketIndex = value.indexOf('[');
			int closeBracketIndex = value.indexOf(']');

			String multiplicity = null;

			if (openBracketIndex != -1 && closeBracketIndex != -1) {
				// filter multiplicity from value
				multiplicity = value.substring(openBracketIndex + 1, closeBracketIndex);
			} else if (openBracketIndex == -1 && closeBracketIndex == -1) {
				// nameAndtype = value;
			} else {
				return Messages.ClassAttributeDirectEditingFeature_0_xmsg;
			}

			// <pg250208> check the correctness of the type
			String isAttributeValid = null;

			if (type != null && type.lastIndexOf('.') != -1) {
				// type name is qualified:
				// check against qualified names (existence only)
				isAttributeValid = ParserUtil.checkQualifiedTypeName(type, getAllQualifiedClassifiers());
			} else {
				String oldTypeName = null;
				Classifier oldClassifier = att.getType();
				if (oldClassifier != null) {
					oldTypeName = oldClassifier.getName();
				}
				// if type name has changed: check unqualified type name for existence and uniqueness
				if ((oldTypeName == null) || (!oldTypeName.equals(type))) {
					isAttributeValid = ParserUtil.checkUnqualifiedTypeName(type, getAllClassifiers());
				}
			}
			// check the correctness of multiplicity
			String isMultiplicityValid = multiplicity == null ? multiplicity : ParserUtil.checkMultiplicity(multiplicity);

			if (isAttributeValid != null) {
				return isAttributeValid;
			}
			if (isMultiplicityValid != null) {
				return isMultiplicityValid;
			}

		}

		return null;
	}

	@Override
	public String completeValue(String value, int caretPos, String choosenValue, IDirectEditingContext context) {

		String name = ParserUtil.getNameFromValue(value, ':');

		String type = null;
		String comment = null;
		String packageString = null;
		int commentStartIndex = choosenValue.lastIndexOf('(');
		int commentEndIndex = choosenValue.lastIndexOf(')');
		if (commentStartIndex != -1) {
			type = choosenValue.substring(0, commentStartIndex).trim();
			comment = choosenValue.substring(commentStartIndex + 1, commentEndIndex);
			int spaceIndex = comment.lastIndexOf(' ');
			packageString = comment.substring(spaceIndex + 1);
			type = packageString + "." + type; //$NON-NLS-1$
		} else {
			type = choosenValue;
		}
		String multiplicity = ParserUtil.getMultiplicityFromValue(value);

		return createAttributeText(name, type, multiplicity);
	}

	@Override
	public String[] getValueProposals(String value, int caretPos, IDirectEditingContext context) {
		List<String> ret = new ArrayList<String>();
		int colonIndex = value.indexOf(':');
		int braketIndex = value.indexOf('[');
		String typeStartsWith;
		if (colonIndex != -1 && colonIndex < caretPos) {
			if (braketIndex != -1 && caretPos < braketIndex) {
				// typeStartsWith = value.substring(colonIndex + 1, braketIndex);
				value = value.substring(0, braketIndex);
				typeStartsWith = ParserUtil.getfirstCharsOfType(value, caretPos);
			} else {
				// typeStartsWith = value.substring(colonIndex + 1);
				typeStartsWith = ParserUtil.getfirstCharsOfType(value, caretPos);
			}

			typeStartsWith = typeStartsWith.trim();
			for (String type : ALL_CLASSIFIERS_WITH_COMMENT) {
				if (type != null && type.toLowerCase(Locale.ENGLISH).startsWith(typeStartsWith.toLowerCase(Locale.ENGLISH))) {
					ret.add(type);
				}
			}
			return ret.toArray(new String[0]);
		}
		return EMPTY_STRING_ARRAY;
	}

	private String createAttributeText(String name, String type, String multiplicity) {
		if (multiplicity != null)
			return name + " : " + type + "[" + multiplicity + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		else
			return name + " : " + type; //$NON-NLS-1$
	}
}
