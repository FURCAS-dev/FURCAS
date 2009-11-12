package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.graphics.serviceLayer.Messages;

public class StructureTypeUtil {

	public static String getNextStructureFieldName(StructureType structureType) {
		String fieldName = Messages.StructureTypeUtil_0_xmsg;
		List<String> allFieldNames = getAllFieldsName(structureType);
		int count = 1;
		while (true) {
			if (allFieldNames.contains(fieldName + Integer.toString(count))) {
				count++;
			} else {
				break;
			}
		}

		fieldName += Integer.toString(count);
		return fieldName;
	}

	public static List<String> getAllFieldsName(StructureType structureType) {
		List<String> names = new ArrayList<String>();
		List<ModelElement> contents = structureType.getContents();
		for (Object obj : contents) {
			if (obj instanceof StructureField) {
				StructureField field = (StructureField) obj;
				names.add(field.getName());
			}
		}
		return names;

	}

	public static boolean existStructureField(String fieldName, StructureType structureType) {

		List<ModelElement> contents = structureType.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof StructureField) {
				StructureField field = (StructureField)obj;
				if (field.getName().equals(fieldName))
					return true;
			}
		}
		return false;
	}

	public static void deleteField(StructureField toBeDeletedfield, StructureType structureType) {
		List<ModelElement> contents = structureType.getContents();
		for (ModelElement element : contents) {
			if (element instanceof StructureField) {
				StructureField field = (StructureField) element;
				if (field.getName().equals(toBeDeletedfield.getName())) {
					contents.remove(field);
					field.refDelete();
					break;
				}
			}
		}
	}

	public static String getInformationOfFieldAsString(StructureField structureField) {

		StringBuffer result = new StringBuffer();
		result.append(structureField.getName() + " : " + structureField.getType().getName()); //$NON-NLS-1$
		return result.toString();
	}

	public static int calculateASuitableWidth(StructureType type) {
		int ret = 0;
		List<ModelElement> contents = type.getContents();
		for (Object obj:contents) {
			if (obj instanceof StructureField) {
				StructureField field = (StructureField)obj;
				String str = getInformationOfFieldAsString(field);
				ret = Math.max(ret, str.length());
			}
		}
		return ret*7;
	}
}
