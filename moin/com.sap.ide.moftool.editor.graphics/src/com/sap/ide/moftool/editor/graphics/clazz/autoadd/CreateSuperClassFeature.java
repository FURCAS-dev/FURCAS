package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class CreateSuperClassFeature extends AbstractCreateRelatedClassesFeature{

	private static final String NAME = Messages.CreateSuperClassFeature_0_xbut;
	private static final String DESCRIPTION = Messages.CreateSuperClassFeature_1_xmsg;

	private MofClass mNewClass = null;

	public CreateSuperClassFeature(IFeatureProvider fp) {
		super(fp);
	}

	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];

		int x = context.getX();
		int y = context.getY();

		if (x == -1)
			x = pe.getGraphicsAlgorithm().getX();

		if (y == -1)
			y = pe.getGraphicsAlgorithm().getY() - 200;

		mNewClass = createClass(pe, x, y, true);
	}

	public String getName() {
		return NAME;
	}

	public String getDescription() {
		return DESCRIPTION;
	}

	public MofClass getNewClass() {
		return mNewClass;
	}

	/* (non-Javadoc)
	 * @see com.sap.ide.moftool.editor.graphics.clazz.autoadd.AbstractCreateRelatedClassesFeature#canExecute(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = super.canExecute(context);
		if (!ret) {
			return false;
		}
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (MofClass)bo);
			}
		}
		return ret;
	}
}
