package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class AddSubClassesFeature extends AbstractAddClassesFeature {

	private static final String NAME = Messages.AddSubClassesFeature_0_xbut;

	private static final String DESCRIPTION = Messages.AddSubClassesFeature_1_xmsg;

	public AddSubClassesFeature(IFeatureProvider fp) {
		super(fp);
	}

	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];
		final ContainerShape cs = (ContainerShape) pe;
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof MofClass) {
			MofClass superClass = (MofClass) bo;
			final Collection<MofClass> subclasses = ClassService.getSubClasses(superClass);
			
			// Execute in the context of a Command
			Command cmd = new Command(((Partitionable)cs).get___Connection( )) {
                public void doExecute( ) {
                    int classCount = 1;
                    for (MofClass subClass : subclasses) {
                        // add the graphical representation
                        addClassToDiagram(subClass, cs, classCount++, false);
                    }
                }
                public boolean canExecute() {return true;}
                public Collection<PartitionOperation> getAffectedPartitions() {return null;}
            };
			cmd.execute( );
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
				Collection<MofClass> subclasses = ClassService.getSubClasses(mofClass);
				for (Iterator<MofClass> iter = subclasses.iterator(); iter.hasNext();) {
					MofClass mc = (MofClass)iter.next();
					if (!DiagramUtil.existsClassInDiagram(getDiagram(), mc)) {
						return true;
					}
				}
//				ret = ret && (!subclasses.isEmpty());
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
