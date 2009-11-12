package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.LabelDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.util.LinkUtil;

public class EnumStructuralDataMapping extends LabelDataMapping {

	public EnumStructuralDataMapping(IMappingProvider mp) {
		super(mp);
	}

	@Override
	public String getText(PictogramLink link) {
		StringBuffer result = new StringBuffer();
		Object refObject = getBusinessObject(link);

		if (refObject instanceof EnumerationType) {
			EnumerationType enumType = (EnumerationType)refObject;
			List<String> labels = enumType.getLabels();
			Property property = LinkUtil.getLinkProperty(link
					.getPictogramElement());
			int index = Integer.valueOf(property.getValue()).intValue();
			result.append(labels.get(index));
		}
		return result.toString();
	}

	@Override
	public String getImageId(PictogramLink link) {
		return IImageConstants.IMG_EMPTY;
	}
}
