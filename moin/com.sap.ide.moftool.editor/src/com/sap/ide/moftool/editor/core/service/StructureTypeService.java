package com.sap.ide.moftool.editor.core.service;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

public abstract class StructureTypeService {

	public static List<StructureField> getStructureFields(StructureType type) {
		List<StructureField> fields = new ArrayList<StructureField>();

		List<ModelElement> contents = type.getContents();
		for (Object obj : contents) {
			if (obj instanceof StructureField) {
				StructureField field = (StructureField)obj;
				fields.add(field);
			}
		}
		return fields;
	}
}
