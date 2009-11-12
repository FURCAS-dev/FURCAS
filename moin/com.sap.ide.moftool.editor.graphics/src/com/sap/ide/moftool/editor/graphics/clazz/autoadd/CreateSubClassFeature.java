package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class CreateSubClassFeature extends AbstractCreateRelatedClassesFeature{

	private static final String NAME = Messages.CreateSubClassFeature_0_xbut;
	private static final String DESCRIPTION = Messages.CreateSubClassFeature_1_xmsg;

	private MofClass mNewClass = null;

	public CreateSubClassFeature(IFeatureProvider fp) {
		super(fp);
	}

	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];

		int x = context.getX();
		int y = context.getY();

		if (x == -1)
			x = pe.getGraphicsAlgorithm().getX();

		if (y == -1)
			y = pe.getGraphicsAlgorithm().getY() + 200;

		mNewClass = createClass(pe, x, y, false);
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
}
