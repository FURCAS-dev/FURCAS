package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofDataMapping;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.links.PictogramLink;

public class EnumDataMapping extends AbstractMofDataMapping {

	public EnumDataMapping(IMappingProvider mp) {
		super(mp);
	}

	@Override
	public String getText(PictogramLink link) {
		// TODO: Replace with icon and remove
		StringBuffer result = new StringBuffer();      
		Object refObject = getBusinessObject(link);       
		if (refObject instanceof EnumerationType) {
			EnumerationType enumtype = (EnumerationType)refObject;
			result.append(getHeaderInformation(enumtype));
		}
		return result.toString();
	}

	private String getHeaderInformation(EnumerationType enumtype) {
		return MessageFormat.format(Messages.EnumDataMapping_0_xmsg, new Object[]{enumtype.getName()});
	}
}
