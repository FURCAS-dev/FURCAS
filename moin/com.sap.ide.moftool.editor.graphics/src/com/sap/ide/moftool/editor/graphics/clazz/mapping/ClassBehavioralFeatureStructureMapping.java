package com.sap.ide.moftool.editor.graphics.clazz.mapping;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.ILinkCreationInfo;
import com.sap.mi.gfw.mapping.StructureMappingMulti;

public class ClassBehavioralFeatureStructureMapping extends StructureMappingMulti{

	public ClassBehavioralFeatureStructureMapping(IMappingProvider mp) {
		super(new BehavioralStructureDataMapping(mp), mp);
	}

	@Override
    public List<ILinkCreationInfo> getLinkCreationInfos(Object mainBusinessObject) {
        List<ILinkCreationInfo> ret = new ArrayList<ILinkCreationInfo>();
        MofClass mofClass = (MofClass) mainBusinessObject;
        ret.addAll(ClassUtil.getOperations(mofClass));
        ret.addAll(ClassUtil.getExceptions(mofClass));
        return ret;
    }
}
