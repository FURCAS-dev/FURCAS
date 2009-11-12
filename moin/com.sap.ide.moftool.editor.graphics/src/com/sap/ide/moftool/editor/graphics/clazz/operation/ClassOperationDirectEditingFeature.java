package com.sap.ide.moftool.editor.graphics.clazz.operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.commands.CreateParameterCommand;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.graphics.clazz.ClassDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.ParserUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.tc.moin.repository.Connection;

public class ClassOperationDirectEditingFeature extends ClassDirectEditingFeature {

	LinkedHashMap<String, String> oldParameters = new LinkedHashMap<String, String>();

	LinkedHashMap<String, String> newParameters = new LinkedHashMap<String, String>();

	public ClassOperationDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		StringBuffer ret = new StringBuffer();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof Operation) {
			Operation operation = (Operation) bo;
			Classifier type = ClassUtil.getReturnType(operation);
			oldParameters = ParserUtil.getParametersAsHash(ClassUtil.getParametersAsString(operation));
			String allParameters = ClassUtil.getParametersAsStringWithParenthesis(operation);
			String typeName = null;
			if (type != null) {
				typeName = type.getName();
			}
			else{
				typeName = MOFToolConstants.VOID_RETURN_TYPE;
			}
			ret.append(operation.getName() + allParameters + " : " + typeName); //$NON-NLS-1$
		}
		return ret.toString();
	}

	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);

		if (bo instanceof Operation && checkValueValid(value, context) == null) {
			Operation operation = (Operation) bo;

			// set the operation name
			String opName = ParserUtil.getOperationNameFromValue(value);
			operation.setName(opName);

			// set the return type 
			ClassUtil.setOperationReturnType(operation, ParserUtil.getTypeFromValue(value), getConnection());

			// set all parameters
			String parameters = ParserUtil.getParametersFromValueAsString(value);
			newParameters = ParserUtil.getParametersAsHash(parameters);
			Set<String> newParameterNames = newParameters.keySet();
			List newParameterNameList = ParserUtil.getParametersAsList(parameters); 
			List<ModelElement> contents = operation.getContents();
			LinkedHashMap<String, Parameter> oldParameterMap = new LinkedHashMap<String, Parameter>();
			// remove all (non-return) parameters from content, delete unwanted parameters
			ListIterator<ModelElement> contentIter = contents.listIterator(contents.size());
			while (contentIter.hasPrevious()) {
				ModelElement obj = contentIter.previous();
				if (obj instanceof Parameter) {
					Parameter par = (Parameter) obj;
					if (!DirectionKindEnum.RETURN_DIR.equals(par.getDirection())) {
						if (newParameterNames.contains(par.getName())) {
							contents.remove(par);
							// store old parameter in map
							oldParameterMap.put(par.getName(), par);
						} else {
							contents.remove(par);
							par.refDelete();
						}
					}
				}
			}
			// add the new and existing parameters in the right sequence
			Classifier newClassifier = null;
			Parameter newParameter = null;
			ListIterator<String> newParameterNameIterator = newParameterNameList.listIterator();
			while (newParameterNameIterator.hasNext()) {
				String newParameterName = newParameterNameIterator.next();
				if (oldParameterMap.containsKey(newParameterName)) {
					// parameter already exists: add it to content
					newParameter = oldParameterMap.get(newParameterName);
					contents.add(newParameter);					
				} else {
					// parameter does not yet exist: create it and add it to content 
					CreateParameterCommand command = new CreateParameterCommand(newParameterName,
							DirectionKindEnum.IN_DIR, operation, getConnection());
					command.execute();
					newParameter = command.getParameter();
				}
				// set type of parameter
				if (newParameter != null) {
					String newParameterTypeName = (String)newParameters.get(newParameterName);
					if (newParameterTypeName != null && newParameterTypeName.lastIndexOf('.') != -1) {
						// type name is qualified:
						// get type by qualified name
						newClassifier = MofService.getClassifierByQualifiedName(getConnection(), newParameterTypeName);
						newParameter.setType(newClassifier);
					} else {
						newClassifier = MofService.getClassifier(getConnection(), newParameterTypeName);
						newParameter.setType(newClassifier);
					}						
				}
				
			}

			// the parameters have been changed via direct editing and need to be updated 
//			if (oldParameters.size() == newParameters.size()) {
//				ClassUtil.updateParameter(operation, newParameters, getConnection());
//				// new parameters have been added to the operation via direct editing
//			} else if (oldParameters.size() < newParameters.size()) {
//				addNewParametersToOperation(operation, getConnection());
//				ClassUtil.updateParameter(operation, newParameters, getConnection());
//				// some parameters have been deleted from operation via direct editing
//			} else if (oldParameters.size() > newParameters.size()) {
//				deleteParametersfromOperation(operation);
//				ClassUtil.updateParameter(operation, newParameters, getConnection());
//			}
			updatePictogramElement(pe);
		}
	}

	private void deleteParametersfromOperation(Operation operation) {
		int numberToDelete = oldParameters.size() - newParameters.size();
		ClassUtil.deleteParametersFromOperation(operation, numberToDelete);

	}

	private void addNewParametersToOperation(Operation operation, Connection connection) {
		int numberToAdd = newParameters.size() - oldParameters.size();
		ClassUtil.addNewParametersToOperation(operation, numberToAdd, connection);
	}

	public String checkValueValid(String value, IDirectEditingContext context) {

		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);

		if (bo instanceof Operation) {
			Operation op = (Operation) bo;

			// check the correctness of name and return type of Operation, which have entered by user
			String name = ParserUtil.getNameFromValue(value,'(');
			String type = ParserUtil.getTypeFromValue(value);
			if(name == null){
				return Messages.ClassOperationDirectEditingFeature_0_xmsg;
			}
// <pg290108> new name validation			
			IStatus status = null;
			String oldName = op.getName();
			if (name != null) {
				if (name.equals(oldName)) {
					status = NamespaceService.validate(op, ""); //$NON-NLS-1$
				} else {
					status = NamespaceService.checkForNewSubobject(op.getContainer(), name);		
				}
				if ((status != null) && status.getSeverity() == IStatus.ERROR) {
					return status.getMessage();
				}
			}

// </pg290108>		

			// <pg250208> check the correctness of the type 
			String isReturnTypeValid = null;

			if (type != null && type.lastIndexOf('.') != -1) {
				// type name is qualified:
				// check against qualified names (existence only)
				isReturnTypeValid = ParserUtil.checkQualifiedTypeName(type, getAllQualifiedClassifiers());
			} else {
				String oldTypeName = null;
				Classifier oldClassifier = ClassUtil.getReturnType(op);
				if (oldClassifier != null) {
					oldTypeName = oldClassifier.getName();
				}
				// if type name has changed: check unqualified type name for existence and uniqueness
				if (!MOFToolConstants.VOID_RETURN_TYPE.equals(type)) {
					if ((oldTypeName == null) || (!oldTypeName.equals(type))) {
						isReturnTypeValid = ParserUtil.checkUnqualifiedTypeName(type, getAllClassifiers());
					}
				}
			}
			if(isReturnTypeValid != null) {
				return isReturnTypeValid;
			}

			// check the parameters of the operation			
			String parameterValue = ParserUtil.getParametersFromValueAsString(value);
			if (parameterValue != null) {
//				return ParserUtil.checkAllParameters(parameterValue, getAllClassifiers());
				return ParserUtil.checkOperationParameters(parameterValue, op, getAllClassifiers(), getAllQualifiedClassifiers());
			}
		}
		return null;
	}


	@Override
	public String[] getValueProposals(String value, int caretPos, IDirectEditingContext context) {

		int colonIndex = value.indexOf(':');

		//caretPos = caretPos == 0 ? caretPos : caretPos - 1;
		if(caretPos <= 0)
			return EMPTY_STRING_ARRAY;

		char lastEnteredChar = value.charAt(caretPos - 1);

		if (lastEnteredChar == ':' || ParserUtil.isTypeEntered(value, caretPos) ) {
			if (colonIndex != -1) {
				List<String> ret = new ArrayList<String>();
				String typeStartsWith = ParserUtil.getfirstCharsOfType(value, caretPos);
				typeStartsWith = typeStartsWith.trim();
				for (String type : ALL_CLASSIFIERS_WITH_COMMENT) {
					if (type != null && type.toLowerCase(Locale.ENGLISH).startsWith(typeStartsWith.toLowerCase(Locale.ENGLISH))) {
						ret.add(type);
					}
				}
				return ret.toArray(new String[0]);
			}
		}
		return EMPTY_STRING_ARRAY;
	}
	
	
    public static String adaptTextAfterCaret(String value) {
        int firstColonIndex = value.indexOf(':');
        int firstCommaIndex = value.indexOf(',');
        int firstOpenIndex = value.indexOf('(');
        int firstCloseIndex = value.indexOf(')');
        int firstEndOfTypeIndex = -1;
        // calculate end of type index (either comma or close)
        if ((firstCommaIndex >= 0) && (firstCloseIndex >= 0)) {
        	if (firstCommaIndex < firstCloseIndex) {
        		firstEndOfTypeIndex = firstCommaIndex;
        	} else {
        		firstEndOfTypeIndex = firstCloseIndex;
        	}
        } else if ((firstCommaIndex >= 0) && (firstCloseIndex < 0)) {
        	firstEndOfTypeIndex = firstCommaIndex;
        } else if ((firstCommaIndex < 0) && (firstCloseIndex >= 0)) {
        	firstEndOfTypeIndex = firstCloseIndex;
        } else {
        	firstEndOfTypeIndex = -1;
        }
        // check caret position
        if (((firstOpenIndex < 0) && !(firstCloseIndex < 0))) {
        	// we are in the parameters area between "(" and ")"
	        if ((!(firstColonIndex < 0)) && (firstColonIndex < firstCloseIndex)) {
	        	// there is a colon before the ")"
	        	if ((firstCommaIndex < 0) || (firstColonIndex < firstCommaIndex)) {
	        		// there is no comma before the colon: text after caret starts with a parameter, add a comma to separate it from
	        		// newly added parameter in text before caret
	        		value = ", " + value; //$NON-NLS-1$
	        		return value;
	        	}
	        }
	        if ((!(firstEndOfTypeIndex < 0))) {
	        	if ((firstColonIndex < 0) || (firstEndOfTypeIndex < firstColonIndex)) {
	        		return value.substring(firstEndOfTypeIndex);
	        	}
	        }
        } else if (((firstOpenIndex < 0) && (firstCloseIndex < 0))) {
        	// we are behind the parameters area: nothing to return behind operation return type
        	return ""; //$NON-NLS-1$
        	
        }
        return value;
    }



	public String completeValue(String value, int caretPos, String choosenValue, IDirectEditingContext context) {

		StringBuffer ret = new StringBuffer();

		String textBeforeCaret = value.substring(0, caretPos);
		String textAfterCaret = value.substring(caretPos);

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

		ret.append(ParserUtil.getTextbeforeLastColon(textBeforeCaret));
		ret.append(":"); //$NON-NLS-1$
		ret.append(type);
		ret.append(adaptTextAfterCaret(textAfterCaret));

		return ret.toString();
	}


}
