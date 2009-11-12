package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKind;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.commands.CreateParameterCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.exec.ExecMOFToolDefaultImpl;
import com.sap.mi.gfw.mapping.ILinkCreationInfo;
import com.sap.mi.gfw.mapping.LinkCreationInfo;
import com.sap.tc.moin.repository.Connection;

public class ClassUtil {

	public static String getParametersAsString(Operation operation) {

		StringBuffer result = new StringBuffer();
		StringBuffer parameters = new StringBuffer();

		List<Parameter> paraList = getParameters(operation);
		for (ListIterator<Parameter> iter = paraList.listIterator(); iter.hasNext();) {
			Parameter par = iter.next();
			DirectionKind direction = par.getDirection();
			if (DirectionKindEnum.IN_DIR.equals(direction)
					|| DirectionKindEnum.OUT_DIR.equals(direction)
					|| DirectionKindEnum.INOUT_DIR.equals(direction)) {
				String parType = "void"; //$NON-NLS-1$
				if (par.getType() != null) {
					parType = par.getType().getName();
				}
				parameters.append(par.getName() + ": " //$NON-NLS-1$
						+ parType + ", "); //$NON-NLS-1$
			}
		}
		// delete the last comma
		int len = parameters.toString().length();
		if (len > 1) {
			parameters.delete(len - 2, len - 1);
		}
		result.append(parameters.toString().trim());
		return result.toString();
	}	

	public static String getParametersAsStringWithParenthesis(
			Operation operation) {
		StringBuffer result = new StringBuffer();
		String AllParameters = getParametersAsString(operation);
		result.append("(" + AllParameters.toString() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		return result.toString();
	}

	public static String getReturnTypeAsString(Operation operation) {
		Classifier retType = getReturnType(operation);
		if (retType != null)
			return retType.getName();
		else
			return MOFToolConstants.VOID_RETURN_TYPE;
	}

	public static List<Parameter> getParameters(Operation operation) {
		List<Parameter> parameters = new ArrayList<Parameter>();
		List<ModelElement> contents = operation.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Parameter) {
				Parameter par = (Parameter) obj;
				parameters.add(par);
			}
		}
		return parameters;
	}

	public static Classifier getReturnType(Operation operation) {
		List<ModelElement> contents = operation.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Parameter) {
				Parameter par = (Parameter) obj;
				DirectionKind direction = par.getDirection();
				if (DirectionKindEnum.RETURN_DIR.equals(direction)) {
					return par.getType();
				}
			}
		}
		return null;
	}

	/**
	 * @deprecated	 
	 */
	public static void setReturnType(Operation operation,
			Classifier newClassifier, Connection connection) {
		List<ModelElement> contents = operation.getContents();

		// Search for the return parameter
		Parameter returnParameter = null;
		for (Object obj : contents) {
			if (obj instanceof Parameter) {
				Parameter par = (Parameter) obj;
				if (DirectionKindEnum.RETURN_DIR.equals(par.getDirection())) {
					returnParameter = par;
				}
			}
		}

		// Set new return type
		if (returnParameter != null) {
			// Old return type was not void -> parameter exists
			if (newClassifier != null) {
				// New return type is not void -> simply replace type
				returnParameter.setType(newClassifier);
			} else {
				// New return type is void -> delete parameter
				returnParameter.refDelete();
			}
		} 
		else if (newClassifier != null) {
			// Old return type was void -> no parameter exists
			// and new return type is not void -> create parameter
			String parameterName = NamespaceService.getValidNameForNewSubobject(operation,
					ExecMOFToolDefaultImpl.NEW_PARAMETER_NAME);
			CreateParameterCommand command = new CreateParameterCommand(parameterName,
					DirectionKindEnum.RETURN_DIR, operation, connection);
			command.execute();
			Parameter newParameter = command.getParameter();
			newParameter.setType(newClassifier);
		}
		else {
			// Old and new return type is void -> do nothing
		}
	}
	
	public static void setOperationReturnType(Operation operation,
			String type, Connection connection) {
		
		List<ModelElement> contents = operation.getContents();
		Classifier newClassifier = null;
		Classifier oldClassifier = null;
		Boolean changed = false;

		// Search for the return parameter
		Parameter returnParameter = null;
		for (Object obj : contents) {
			if (obj instanceof Parameter) {
				Parameter par = (Parameter) obj;
				if (DirectionKindEnum.RETURN_DIR.equals(par.getDirection())) {
					returnParameter = par;
				}
			}
		}
		// Get new classifier and set changed flag
		if (type != null && type.lastIndexOf('.') != -1) {
			// type name is qualified:
			// get type by qualified name
			newClassifier = MofService.getClassifierByQualifiedName(connection, type);
			changed = true;
		} else {
			String oldTypeName = null;
			if (returnParameter != null) {	
				oldClassifier = returnParameter.getType();
				if (oldClassifier != null) {
					oldTypeName = oldClassifier.getName();
				}
				if ((oldTypeName == null) || (!oldTypeName.equals(type))) {
					newClassifier = MofService.getClassifier(connection, type);
					changed = true;
				}
			} else {
				newClassifier = MofService.getClassifier(connection, type);
				changed = true;				
			}
		}	

		// Set new return type if type name was changed
		if (returnParameter != null) {			
			if (changed) {
				if (newClassifier != null) {
					returnParameter.setType(newClassifier);
				} else {
					// New return type is void -> delete parameter
					returnParameter.refDelete();
				}
			}		
		} 
		else if (newClassifier != null) {
			// Old return type was void -> no parameter exists
			// and new return type is not void -> create parameter
			String parameterName = NamespaceService.getValidNameForNewSubobject(operation,
					ExecMOFToolDefaultImpl.NEW_PARAMETER_NAME);
			CreateParameterCommand command = new CreateParameterCommand(parameterName,
					DirectionKindEnum.RETURN_DIR, operation, connection);
			command.execute();
			Parameter newParameter = command.getParameter();
			newParameter.setType(newClassifier);
		}
		else {
			// Old and new return type is void -> do nothing
		}
	}

	public static String getInformationOfOperationAsString(Operation operation) {
		StringBuffer result = new StringBuffer();

		result.append(operation.getName());
		result.append(getParametersAsStringWithParenthesis(operation) + " : "); //$NON-NLS-1$
		result.append(getReturnTypeAsString(operation));

		return result.toString();
	}

	public static List<ILinkCreationInfo> getOperations(MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		List<ILinkCreationInfo> linkInfo = new ArrayList<ILinkCreationInfo>();
		for (ModelElement obj : contents) {
			if (obj instanceof Operation) {
				Operation op = (Operation) obj;
				linkInfo.add(new LinkCreationInfo(op));
			}
		}
		return linkInfo;
	}

	public static List<ILinkCreationInfo> getAttributes(MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		List<ILinkCreationInfo> linkInfo = new ArrayList<ILinkCreationInfo>();
		for (Object obj : contents) {
			if (obj instanceof Attribute) {
				Attribute att = (Attribute) obj;
				linkInfo.add(new LinkCreationInfo(att));
			}
		}
		return linkInfo;

	}

	public static String getInformationOfAttributeAsString(
			StructuralFeature structuralFeature) {
		StringBuffer result = new StringBuffer();
		result.append(structuralFeature.getName() + " : " //$NON-NLS-1$
				+ getAttributeType(structuralFeature)+getAttributeMultiplicityAsString(structuralFeature));
		return result.toString();
	}

	public static String getAttributeType(StructuralFeature structuralFeature) {
		if (structuralFeature.getType() != null) {
			return structuralFeature.getType().getName();
		}
		else {
			return "<ERROR - no type defined>"; //$NON-NLS-1$
		}
	}

	public static String getAttributeMultiplicityAsString(StructuralFeature structuralFeature){
		StringBuffer ret = new StringBuffer();
		MultiplicityType mult = structuralFeature.getMultiplicity();
		int lower = mult.getLower();
		int upper = mult.getUpper();             

		if(lower == 1 && upper == 1){
			return ret.toString();   
		}
		String lowerBound = Integer.toString(lower);
		String upperBound =  upper  == -1 ? "*"  : Integer.toString(upper) ; //$NON-NLS-1$

		ret.append(" ["  + lowerBound + ".." + upperBound + "]");  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		return ret.toString();

	}

	public static List<Association> getAssociationsBetween(
			MofClass firstClass, MofClass secondClass) {
		// Prepare result list
		List<Association> AssocList = new ArrayList<Association>();

		// Get all associations the first class is involved in and loop over them
		List<Association> asList = ClassService.getAllAssociations(firstClass);
		for (ListIterator<Association> asIter = asList.listIterator(); asIter.hasNext();) {
			Association association = asIter.next();

			// Get association ends
			AssociationEnd[] aes = AssociationService.getAssociationEnds(association);

			// Check at which end the first class is
			MofClass otherMofClass = null;
			if (firstClass.equals(aes[0].getType())) {
				// First class is at first end -> second class must be at second end
				otherMofClass = (MofClass)aes[1].getType();
			}
			else if (firstClass.equals(aes[1].getType())) {
				// First class is at second end -> second class must be at first end
				otherMofClass = (MofClass)aes[0].getType();
			}
			else {
				throw new InternalErrorException(" Both association ends do not match current class"); //$NON-NLS-1$
			}

			// Now: we have an association between first and second class if otherMofClass is the second class 
			if (otherMofClass.equals(secondClass)) {
				AssocList.add(association);
			}
		}
		return AssocList;
	}

	public static boolean isASuperClassOfB(MofClass a, MofClass b) {
		List<MofClass> allClasses = new ArrayList<MofClass>();
		if (a.equals(b))
			return true;
		while (b != null) {
			if (a.equals(b))
				return true;
			b = getSuperClass(b);
			if (allClasses.contains(b)) {
				break;
			} else {
				allClasses.add(b);
			}
		}
		return false;
	}

	public static boolean isASuperStructureOfB(StructureType a, StructureType b) {
		List<StructureType> stList = new ArrayList<StructureType>();
		if (a.equals(b))
			return true;
		while (b != null) {
			if (a.equals(b))
				return true;
			b = getSuperStructure(b);
			if (stList.contains(b)) {
				break;
			} else {
				stList.add(b);
			}
		}
		return false;
	}
	
	private static MofClass getSuperClass(MofClass m) {
		List<GeneralizableElement> l = m.getSupertypes();
		if (l.size() == 0)
			return null;
		if (l.size() > 1) {
			return (MofClass) l.get(0);
			// throw new IllegalStateException("Expected one superclass"); //
			// for the Data Dictionary, multiple inheritance is used
		}
		if (!(l.get(0) instanceof MofClass))
			throw new IllegalStateException("Expected a mofclass , got " //$NON-NLS-1$
					+ l.get(0));
		return (MofClass) l.get(0);
	}

	private static StructureType getSuperStructure(StructureType structureType) {
		List<GeneralizableElement> l = structureType.getSupertypes();
		if (l.size() == 0)
			return null;
		if (l.size() > 1) {
			return (StructureType) l.get(0);
			// throw new IllegalStateException("Expected one superclass"); //
			// for the Data Dictionary, multiple inheritance is used
		}
		if (!(l.get(0) instanceof StructureType))
			throw new IllegalStateException("Expected a StructureType , got " //$NON-NLS-1$
					+ l.get(0));
		return (StructureType) l.get(0);
	}
	
	public static Collection<GeneralizableElement> getSuperTypes(com.sap.tc.moin.repository.Connection connection,
			MofClass newAddedMofClass) {
		Generalizes generalizes = MofService.getModelPackage(connection).getGeneralizes();
		Collection<GeneralizableElement> superTypes = generalizes.getSupertype(newAddedMofClass);
		return superTypes;
	}

	public static void addNewParametersToOperation(Operation operation,
			int numberToAdd, Connection connection) {
		for (int i = 0; i < numberToAdd; i++) {
			String parameterName = NamespaceService.getValidNameForNewSubobject(operation,
					ExecMOFToolDefaultImpl.NEW_PARAMETER_NAME);
			CreateParameterCommand command = new CreateParameterCommand(parameterName,
					DirectionKindEnum.IN_DIR, operation, connection);
			command.execute();
		}

	}

	public static Classifier getClassifier(Connection connection,
			String type) {
		return MofService.getClassifier(connection, type);
	}


	public static void updateParameter(Operation operation,
			HashMap<String, String> parametersAsHash, Connection connection) {
		List<ModelElement> contents = operation.getContents();
		ListIterator<ModelElement> contentIter = contents.listIterator();
		for (Iterator<String> parIter = parametersAsHash.keySet().iterator(); parIter.hasNext();) {
			Object obj = contentIter.next();
			if (obj instanceof Parameter) {
				Parameter par = (Parameter) obj;
				if (!DirectionKindEnum.RETURN_DIR.equals(par.getDirection())) {
					String newName = (String)parIter.next();
					String newType = (String)parametersAsHash.get(newName);
					par.setName(newName);
//					par.setType(getClassifier(connection, newType));
					// <pg260208> use qualified type name if possible
					Classifier newClassifier = null;
					Classifier oldClassifier = null;
					if (newType != null && newType.lastIndexOf('.') != -1) {
						// type name is qualified:
						// get type by qualified name
						newClassifier = MofService.getClassifierByQualifiedName(connection, newType);
						par.setType(newClassifier);
					} else {
						String oldTypeName = null;
						oldClassifier = par.getType();
						if (oldClassifier != null) {
							oldTypeName = oldClassifier.getName();
						}
						if ((oldTypeName == null) || (!oldTypeName.equals(newType))) {
							newClassifier = MofService.getClassifier(connection, newType);
							par.setType(newClassifier);
						}
					}						

				}
			}
		}

	}

	public static void deleteParametersFromOperation(Operation operation,
			int numberToDelete) {
		List<ModelElement> contents = operation.getContents();
		ListIterator<ModelElement> contentIter = contents.listIterator();
		int i = 0;
		// delete numberToDelete Elements from Operation
		while (i < numberToDelete) {
			ModelElement obj = contentIter.next();
			if (obj instanceof Parameter) {
				Parameter par = (Parameter) obj;
				if (DirectionKindEnum.IN_DIR.equals(par.getDirection())) {
					par.refDelete();
					i++;
				}
			}
		}

	}

	public static boolean existOperation(String opName, MofClass mofClass) {
		List<String> allNames = getAllOperationsName(mofClass);
		if (allNames.contains(opName)) {
			return true;
		}
		return false;
	}

	public static boolean existAttribute(String attName, MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Attribute) {
				Attribute att = (Attribute) obj;
				if (att.getName().equals(attName))
					return true;
			}
		}
		return false;
	}

	public static void deleteAttribute(String name, MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Attribute) {
				Attribute att = (Attribute) obj;
				if (att.getName().equals(name)) {
					contents.remove(att);
					att.refDelete();
					break;
				}
			}
		}
	}

	public static void deleteOperation(String name, MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Operation) {
				Operation op = (Operation) obj;
				if (op.getName().equals(name)) {
					contents.remove(op);
					op.refDelete();
					break;
				}
			}
		}
	}

	public static List<String> getAllOperationsName(MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		List<String> names = new ArrayList<String>();
		for (ModelElement obj : contents) {
			if (obj instanceof Operation) {
				Operation op = (Operation)obj;
				names.add(new String(op.getName()));
			}
		}
		return names;

	}

	public static boolean hasAOneSuperClassOfB(MofClass source, MofClass target) {
		if (source != null && target != null) {
			Collection<GeneralizableElement> sourceSuperTypes = source.allSupertypes();
			Collection<GeneralizableElement> targetSuperTypes = target.allSupertypes();

			if (!sourceSuperTypes.isEmpty() || !targetSuperTypes.isEmpty()) {
				for (Iterator<GeneralizableElement> iter = sourceSuperTypes.iterator(); iter.hasNext();) {
					if (targetSuperTypes.contains(iter.next())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static int calculateASuitableWidth(MofClass newAddedMofClass) {		
		// TODO: move constants to central place
		int averageCharacterWidth = 7;
		int maximumWidth = 500;
		//
		int ret = 0;
		List<ModelElement> contents = newAddedMofClass.getContents();
		for(ModelElement obj : contents) {
			if (obj instanceof Operation) {
				Operation bf = (Operation)obj;
				String str = getInformationOfOperationAsString(bf);
				ret = Math.max(ret,str.length());
				// break;
			}
			else if (obj instanceof StructuralFeature) {
				StructuralFeature sf = (StructuralFeature)obj;
				String str = getInformationOfAttributeAsString(sf);
				ret = Math.max(ret,str.length());
				//break;
			}
		}
		// 
		ret = ret*averageCharacterWidth;
		if (ret > maximumWidth) {
			ret = maximumWidth;
		}
		return ret;
	}

	public static boolean hasMofClassAnyAssociation(MofClass mofClass) {
		List<Association> allAssoc = ClassService.getAllAssociations(mofClass);
		if (allAssoc != null && !allAssoc.isEmpty()) {
			return true;
		}

		return false;
	}

	public static boolean hasMofClassAssociationA(MofClass mofClass,
			Association association) {
		List<Association> allAssoc = ClassService.getAllAssociations(mofClass);
		if (allAssoc != null && !allAssoc.isEmpty()
				&& allAssoc.contains(association)) {
			return true;
		}

		return false;
	}

	public static List<ILinkCreationInfo> getReferences(MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		List<ILinkCreationInfo> linkInfo = new ArrayList<ILinkCreationInfo>();
		for (ModelElement obj : contents) {
			if (obj instanceof Reference) {
				Reference ref = (Reference) obj;
				linkInfo.add(new LinkCreationInfo(ref));
			}
		}
		return linkInfo;

	}

	public static Collection<ILinkCreationInfo> getExceptions(MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		List<ILinkCreationInfo> linkInfo = new ArrayList<ILinkCreationInfo>();
		for (ModelElement obj : contents) {
			if (obj instanceof MofException) {
				MofException excep = (MofException) obj;
				linkInfo.add(new LinkCreationInfo(excep));
			}
		}
		return linkInfo;
	}

	public static String getInformationOfExceptionAsString(MofException mofExec) {
		StringBuffer result = new StringBuffer();

		result.append(mofExec.getName());
		// result.append(getParametersAsStringWithParenthesis(operation) + " :
		// ");
		// result.append(getReturnTypeAsString(operation));

		return result.toString();
	}

	public static Collection<EnumerationType> getEnumTypes(Connection connection, MofClass mofClass) {
		Collection<EnumerationType> ret = new ArrayList<EnumerationType>();
		List<ModelElement> contents = mofClass.getContents();
		for (ModelElement obj : contents) {           
			if (obj instanceof EnumerationType) {
				ret.add((EnumerationType) obj);
			}
		}
		return ret;
	}

	public static Collection<StructureType> getStructureTypes(Connection connection, MofClass mofClass) {
		Collection<StructureType> ret = new ArrayList<StructureType>();
		List<ModelElement> contents = mofClass.getContents();
		for (ModelElement obj : contents) {           
			if (obj instanceof StructureType) {
				ret.add((StructureType) obj);
			}
		}
		return ret;
	}
}
