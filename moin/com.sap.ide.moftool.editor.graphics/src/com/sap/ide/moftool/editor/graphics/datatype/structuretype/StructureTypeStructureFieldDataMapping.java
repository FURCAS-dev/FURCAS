package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import com.sap.tc.moin.repository.mmi.model.StructureField;

import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.StructureTypeUtil;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.LabelDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;

public class StructureTypeStructureFieldDataMapping extends LabelDataMapping {

	public StructureTypeStructureFieldDataMapping(IMappingProvider mp) {
		super(mp);
	}

	@Override
	public String getText(PictogramLink link) {
		StringBuffer result = new StringBuffer();
		Object refObject = getBusinessObject(link);

		if (refObject instanceof StructureField) {
			StructureField structureType = (StructureField)refObject;
			result.append(StructureTypeUtil.getInformationOfFieldAsString(structureType));
		}
		return result.toString();
	}

	@Override
	public String getImageId(PictogramLink link) {
		return IImageConstants.IMG_EMPTY;
	}
}
