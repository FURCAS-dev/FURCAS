package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.ILinkCreationInfo;
import com.sap.mi.gfw.mapping.LinkCreationInfo;
import com.sap.mi.gfw.mapping.StructureMappingMulti;

public class EnumStructuralMapping extends StructureMappingMulti{

	public EnumStructuralMapping(IMappingProvider mp){
		super(new EnumStructuralDataMapping(mp), mp);
	}

	public List<ILinkCreationInfo> getLinkCreationInfos(Object mainBusinessObject) {
		List<ILinkCreationInfo> ret = new ArrayList<ILinkCreationInfo>();
		if (mainBusinessObject instanceof EnumerationType) {
			EnumerationType enumType = (EnumerationType) mainBusinessObject;
			RefObject[] bo = {enumType};          
			List<String> contents = enumType.getLabels();
			for (Iterator<String> iter = contents.iterator();iter.hasNext();) {                 
				int lableIndex = contents.indexOf(iter.next());
				ret.add(new LinkCreationInfo(bo, Integer.toString(lableIndex)));             
			}
		}
		return ret;
	}
}
