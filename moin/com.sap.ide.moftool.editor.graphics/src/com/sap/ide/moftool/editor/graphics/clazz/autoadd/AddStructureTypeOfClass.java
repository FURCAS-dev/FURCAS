package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class AddStructureTypeOfClass extends AbstractAddDataTypesFeature{

	public AddStructureTypeOfClass(IFeatureProvider fp) {
		super(fp, Messages.AddStructureTypeOfClass_0_xbut,Messages.AddStructureTypeOfClass_1_xmsg);
	}

	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];
		ContainerShape cs = (ContainerShape) pe;  
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof MofClass) {
			MofClass mofClass = (MofClass) bo;
			int delta = 0;
			Collection<StructureType> structTypes = ClassUtil.getStructureTypes(getConnection(), mofClass);
			for (StructureType obj : structTypes) {
				delta +=50;
				addDataTypeToDiagramm(obj,cs.getGraphicsAlgorithm().getX(),cs.getGraphicsAlgorithm().getY()+delta);
			}
		}

	}
	
	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = super.canExecute(context);
		if (ret) {
			PictogramElement pe = context.getPictogramElements()[0];
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof MofClass) {
				MofClass mofClass = (MofClass) bo;
				Collection<StructureType> structTypes = ClassUtil.getStructureTypes(getConnection(), mofClass);
				ret = ret && (! structTypes.isEmpty() );
			} else {
				ret = false;
			}
		}
		return ret;
	}
}
