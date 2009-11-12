package com.sap.ide.moftool.editor.graphics.clazz.mapping;

import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Operation;

import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.LabelDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;

public class BehavioralStructureDataMapping extends LabelDataMapping {

	public BehavioralStructureDataMapping(IMappingProvider mp) {
		super(mp);
	}

	@Override
	public String getText(PictogramLink link) {
		StringBuffer result = new StringBuffer();
		Object refObject = getBusinessObject(link);
		if (refObject instanceof Operation) {
			Operation op = (Operation)refObject;
			result.append(ClassUtil.getInformationOfOperationAsString(op));
		} else if (refObject instanceof MofException) {
			MofException mofExec = (MofException)refObject;
			result.append(ClassUtil.getInformationOfExceptionAsString(mofExec));
		}
		return result.toString();
	}

	@Override
	public String getImageId(PictogramLink link) {
		return IImageConstants.IMG_EMPTY;
	}
}
