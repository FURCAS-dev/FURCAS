package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.ILinkCreationInfo;
import com.sap.mi.gfw.mapping.LinkCreationInfo;
import com.sap.mi.gfw.mapping.StructureMappingMulti;

public class StructureTypeStructureFieldMapping extends StructureMappingMulti{

	public StructureTypeStructureFieldMapping(IMappingProvider mp) {
		super(new StructureTypeStructureFieldDataMapping(mp), mp);   
	}

	public List<ILinkCreationInfo> getLinkCreationInfos(Object mainBusinessObject) {
		List<ILinkCreationInfo> ret = new ArrayList<ILinkCreationInfo>();
		if (mainBusinessObject instanceof StructureType) {
			StructureType structureType = (StructureType) mainBusinessObject;
			List<ModelElement> contents = structureType.getContents();
			for (Iterator<ModelElement> iter = contents.iterator(); iter.hasNext();) {
				ModelElement obj = iter.next();
				if (obj instanceof StructureField) {
					StructureField strucField = (StructureField) obj;
					ret.add(new LinkCreationInfo(strucField));
				}
			}
		}
		return ret;
	}
}
