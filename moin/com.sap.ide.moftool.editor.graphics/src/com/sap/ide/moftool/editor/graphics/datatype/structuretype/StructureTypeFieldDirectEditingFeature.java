package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.graphics.serviceLayer.ParserUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class StructureTypeFieldDirectEditingFeature extends AbstractDirectEditingFeature{

	protected  List<String> ALL_QUALIFIED_CLASSIFIERS = new ArrayList<String>();
	protected  List<String> ALL_CLASSIFIERS = new ArrayList<String>();
	protected  List<String> ALL_CLASSIFIERS_WITH_PACKAGEINFO = new ArrayList<String>();
	public StructureTypeFieldDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
		Collection<Classifier> col = MofService.getAvailableClassifiers(getConnection());
		for (Classifier classifier : col) {
			if ((classifier instanceof PrimitiveType) || (classifier instanceof EnumerationType) || (classifier instanceof StructureType)) {
				ALL_CLASSIFIERS.add(classifier.getName());
	        	String concatVal = null;
	        	String concatValWithoutLastSegment = null; 
				String packageInfo = " ()"; //$NON-NLS-1$
				if (classifier.getQualifiedName().size() > 1) {
	            	List<String> qualifiedName = classifier.getQualifiedName();
	            	concatVal = MofService.getQualifiedNameAsString(qualifiedName);
	            	int lastSegmentIndex = concatVal.lastIndexOf('.');
	            	if (lastSegmentIndex != -1) {
	            		concatValWithoutLastSegment = concatVal.substring(0, lastSegmentIndex);
	            	} else {
	            		concatValWithoutLastSegment = concatVal; 
	            	}
					packageInfo = " (" + concatValWithoutLastSegment + ")"; //$NON-NLS-1$ //$NON-NLS-2$
				}
				String str = classifier.getName() + packageInfo;
				ALL_CLASSIFIERS_WITH_PACKAGEINFO.add(str);
				ALL_QUALIFIED_CLASSIFIERS.add(concatVal);
			}
		}

		Collections.sort(ALL_CLASSIFIERS); 
		Collections.sort(ALL_CLASSIFIERS_WITH_PACKAGEINFO); 
		Collections.sort(ALL_QUALIFIED_CLASSIFIERS); 
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		StringBuffer ret = new StringBuffer();        
		if (bo instanceof StructureField) {
			StructureField field = (StructureField) bo;
			Classifier type = field.getType();
			String typeName = null;
			if (type != null) {
				typeName = type.getName();
			}
			ret.append(field.getName() + " : " + typeName); //$NON-NLS-1$
		}
		return ret.toString();
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);

		if (bo instanceof StructureField) {
			StructureField field = (StructureField) bo;

			String name = ParserUtil.getNameFromValue(value, ':');
			String type = ParserUtil.getTypeFromValue(value);
			
// <pg290108> new name validation
			IStatus status = null;
			String oldName = field.getName();
			if (name != null) {
				if (name.equals(oldName)) {
					status = NamespaceService.validate(field, ""); //$NON-NLS-1$
				} else {
					status = NamespaceService.checkForNewSubobject(field.getContainer(), name);		
				}
				if ((status != null) && status.getSeverity() == IStatus.ERROR) {
					return status.getMessage();
				}
			}
// </pg290108>		
			// <pg250208> check the correctness of the type 
			String isFieldValid = null;

			if (type != null && type.lastIndexOf('.') != -1) {
				// type name is qualified:
				// check against qualified names (existence only)
				isFieldValid = ParserUtil.checkQualifiedTypeName(type, ALL_QUALIFIED_CLASSIFIERS);
			} else {
				String oldTypeName = null;
				Classifier oldClassifier = field.getType();
				if (oldClassifier != null) {
					oldTypeName = oldClassifier.getName();
				}
				// if type name has changed: check unqualified type name for existence and uniqueness 
				if ((oldTypeName == null) || (!oldTypeName.equals(type))) {
					isFieldValid = ParserUtil.checkUnqualifiedTypeName(type, ALL_CLASSIFIERS);
				}
			}
			
			if (isFieldValid != null) {
				return isFieldValid;
			}

		}

		return null;
	}

	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof StructureField ) {
			StructureField field = (StructureField) bo;
			field.setName(ParserUtil.getNameFromValue(value,':'));
//			Classifier newClassifier = ClassUtil.getClassifier(getConnection(), ParserUtil.getTypeFromValue(value));
//			field.setType(newClassifier);
			String type = ParserUtil.getAttributeTypeFromValue(value);
			Classifier newClassifier = null;
			Classifier oldClassifier = null;
			if (type != null && type.lastIndexOf('.') != -1) {
				// type name is qualified:
				// get type by qualified name
				newClassifier = MofService.getClassifierByQualifiedName(getConnection(), type);
				field.setType(newClassifier);
			} else {
				String oldTypeName = null;
				oldClassifier = field.getType();
				if (oldClassifier != null) {
					oldTypeName = oldClassifier.getName();
				}
				if ((oldTypeName == null) || (!oldTypeName.equals(type))) {
					newClassifier = MofService.getClassifier(getConnection(), type);
					field.setType(newClassifier);
				}
			}						
			updatePictogramElement(pe);
		}

	}

	@Override
	public String completeValue(String value, int caretPos, String choosenValue, IDirectEditingContext context) {

		String name = ParserUtil.getNameFromValue(value,':');

//		String type;
//		int commentIndex = choosenValue.lastIndexOf('(');
//		if (commentIndex != -1) {
//			type = choosenValue.substring(0, commentIndex).trim();
//		} else {
//			type = choosenValue;
//		}
		String type = null;
		String comment = null;
		String packageString = null;		
		int commentStartIndex = choosenValue.lastIndexOf('(');
		int commentEndIndex = choosenValue.lastIndexOf(')');
		if (commentStartIndex != -1) {
			type = choosenValue.substring(0, commentStartIndex).trim();
			comment = choosenValue.substring(commentStartIndex+1, commentEndIndex);
			int spaceIndex = comment.lastIndexOf(' ');
			packageString = comment.substring(spaceIndex+1);
			type = packageString + "." + type; //$NON-NLS-1$
		} else {
			type = choosenValue;
		}

		return name +" : " + type; //$NON-NLS-1$
	}

	@Override
	public String[] getValueProposals(String value, int caretPos, IDirectEditingContext context) {
		int colonIndex = value.indexOf(':');
		if (colonIndex != -1 && caretPos > colonIndex) {
			List<String> ret = new ArrayList<String>();
			String typeStartsWith = value.substring(colonIndex + 1);
			typeStartsWith = typeStartsWith.trim();
			for (String type : ALL_CLASSIFIERS_WITH_PACKAGEINFO) {
				if (type != null && type.toLowerCase(Locale.ENGLISH).startsWith(typeStartsWith.toLowerCase(Locale.ENGLISH))) {
					ret.add(type);
				}
			}
			return ret.toArray(new String[0]);
		}
		return EMPTY_STRING_ARRAY;
	}
	@Override
	public boolean isCompletionAvailable() {
		return true;
	}

	@Override
	public boolean isAutoCompletionEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		boolean ret = super.canDirectEdit(context);
		if (!ret) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof StructureField) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (StructureField)bo);
			}
		}
		return ret;
	}
}
