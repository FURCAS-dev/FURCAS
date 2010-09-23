/**
 * 
 */
package com.sap.tc.moin.textual.emfadapter.adapter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EDataType;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;

/**
 * This class serves to cache creation data for MOF Structure types. While
 * Structure Types when being created are created as immutable Objects, the
 * contract of IModelAdapter of the parsing is that Modelelements
 */
public class StructureTypeMockObject {
	EDataType structureType;
	Map<String, Object> structureFields;

	public StructureTypeMockObject(EDataType strucType) {
		structureType = strucType;
		structureFields = new HashMap<String, Object>(structureType
				.eContents().size());
	}

	public void setField(String fieldName, Object value)
			throws ModelAdapterException {
//		List<EModelElement> fields = structureType.getContents();
//		boolean fieldFound = false;
//		for (Iterator<EModelElement> iterator = fields.iterator(); iterator
//				.hasNext();) {
//			EModelElement contentElement = iterator.next();
//			if (contentElement instanceof StructureField) {
//				StructureField strucField = (StructureField) contentElement;
//				if (fieldName.equals(strucField.getName())) {
//					structureFields.put(fieldName, value);
//					fieldFound = true;
//					break;
//				}
//			} else {
//				// don't care, as StructureTypes should never
//				// contain anything else than fields.
//			}
//		}
//		if (!fieldFound) {
//			throw new ModelAdapterException("EDataType "
//					+ structureType
//					+ " has no such StructureField "
//					+ fieldName);
//		}
	}

	/**
	 * @return the structureType
	 */
	public EDataType getStructureType() {
		return structureType;
	}

	/**
	 * @return the structureFields
	 */
	public Object getStructureField(String fieldname) {
		return structureFields.get(fieldname);
	}

	public void unsetField(String fieldName) throws ModelAdapterException {
//		List<EObject> fields = structureType.eContents();
//		boolean fieldFound = false;
//		for (Iterator<EObject> iterator = fields.iterator(); iterator
//				.hasNext();) {
//			EModelElement contentElement = iterator.next();
//			if (contentElement instanceof StructureField) {
//				StructureField strucField = (StructureField) contentElement;
//				if (fieldName.equals(strucField.getName())) {
//					structureFields.remove(fieldName);
//					fieldFound = true;
//					break;
//				}
//			} else {
//				// don't care, as StructureTypes should never
//				// contain anything else than fields.
//			}
//		}
//		if (!fieldFound) {
//			throw new ModelAdapterException("EDataType "
//					+ structureType
//					+ " has no such StructureField "
//					+ fieldName);
//		}
	}

}
