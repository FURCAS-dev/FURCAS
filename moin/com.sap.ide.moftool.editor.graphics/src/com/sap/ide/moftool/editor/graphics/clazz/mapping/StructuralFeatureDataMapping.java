package com.sap.ide.moftool.editor.graphics.clazz.mapping;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.LabelDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;

public class StructuralFeatureDataMapping extends LabelDataMapping {

	public StructuralFeatureDataMapping(IMappingProvider mp) {
		super(mp);
	}

	@Override
	public String getText(PictogramLink link) {
		StringBuffer result = new StringBuffer();
		Object refObject = getBusinessObject(link);
		if (refObject instanceof StructuralFeature) {
			StructuralFeature sf = (StructuralFeature)refObject;
			result.append(ClassUtil.getInformationOfAttributeAsString(sf));
		}
		return result.toString();
	}

	@Override
	public String getImageId(PictogramLink link) {
		return IImageConstants.IMG_EMPTY;
	}
}
