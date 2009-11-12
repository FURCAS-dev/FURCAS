package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class AddSuperClassesFeature extends AbstractAddClassesFeature{

	private static final String NAME = Messages.AddSuperClassesFeature_0_xbut;
	private static final String DESCRIPTION = Messages.AddSuperClassesFeature_1_xmsg;

	public AddSuperClassesFeature(IFeatureProvider fp) {   
		super(fp);
	}

	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];       
		ContainerShape cs = (ContainerShape) pe;

		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof MofClass) {
			MofClass subClass = (MofClass) bo;
			Collection<GeneralizableElement> superclasses = ClassUtil.getSuperTypes(getConnection(), subClass);
			int classCount = 1;
			for (GeneralizableElement obj : superclasses) {
				if (obj instanceof MofClass) {
					MofClass superClass = (MofClass)obj;
					// add the graphical representation
					addClassToDiagram(superClass, cs, classCount++, true);                                  }
			}
		}
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = super.canExecute(context);
		if (ret) {
			ret = false;
			PictogramElement pe = context.getPictogramElements()[0];
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof MofClass) {
				MofClass mofClass = (MofClass) bo;
				Collection<GeneralizableElement> superclasses = ClassUtil.getSuperTypes(getConnection(), mofClass);
				for (Iterator<GeneralizableElement> iter = superclasses.iterator(); iter.hasNext();) {
					GeneralizableElement ge = (GeneralizableElement)iter.next();
					if (ge instanceof MofClass) {
						MofClass mc = (MofClass)ge;
						if (!DiagramUtil.existsClassInDiagram(getDiagram(), mc)) {
							return true;
						}
					}
				}
//				ret = ret && (! superclasses.isEmpty() );
			} else {
				ret = false;
			}
		}
		return ret;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	public String getName() {
		return NAME;
	}
}
