/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;

/**
 * This class serves to cache creation data for MOF Structure types. While
 * Structure Types when being created are created as immutable Objects, the
 * contract of IModelAdapter of the parsing is that Modelelements
 */
public class StructureTypeMockObject {
	StructureType structureType;
	Map<String, Object> structureFields;

	public StructureTypeMockObject(StructureType strucType) {
		structureType = strucType;
		structureFields = new HashMap<String, Object>(structureType
				.getContents().size());
	}

	public void setField(String fieldName, Object value)
			throws ModelAdapterException {
		List<ModelElement> fields = structureType.getContents();
		boolean fieldFound = false;
		for (Iterator<ModelElement> iterator = fields.iterator(); iterator
				.hasNext();) {
			ModelElement contentElement = iterator.next();
			if (contentElement instanceof StructureField) {
				StructureField strucField = (StructureField) contentElement;
				if (fieldName.equals(strucField.getName())) {
					structureFields.put(fieldName, value);
					fieldFound = true;
					break;
				}
			} else {
				// don't care, as StructureTypes should never
				// contain anything else than fields.
			}
		}
		if (!fieldFound) {
			throw new ModelAdapterException("StructureType "
					+ structureType
					+ " has no such StructureField "
					+ fieldName);
		}
	}

	/**
	 * @return the structureType
	 */
	public StructureType getStructureType() {
		return structureType;
	}

	/**
	 * @return the structureFields
	 */
	public Object getStructureField(String fieldname) {
		return structureFields.get(fieldname);
	}

	public void unsetField(String fieldName) throws ModelAdapterException {
		List<ModelElement> fields = structureType.getContents();
		boolean fieldFound = false;
		for (Iterator<ModelElement> iterator = fields.iterator(); iterator
				.hasNext();) {
			ModelElement contentElement = iterator.next();
			if (contentElement instanceof StructureField) {
				StructureField strucField = (StructureField) contentElement;
				if (fieldName.equals(strucField.getName())) {
					structureFields.remove(fieldName);
					fieldFound = true;
					break;
				}
			} else {
				// don't care, as StructureTypes should never
				// contain anything else than fields.
			}
		}
		if (!fieldFound) {
			throw new ModelAdapterException("StructureType "
					+ structureType
					+ " has no such StructureField "
					+ fieldName);
		}
	}

}
