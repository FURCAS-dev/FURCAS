package com.sap.ide.moftool.editor.graphics.diagram;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.gfw.IReadOnly;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class ShowPropertiesFeature extends AbstractCustomFeature implements IReadOnly {

	private static final String NAME = Messages.ShowPropertiesFeature_0_xbut;
	private static final String DESCRIPTION = Messages.ShowPropertiesFeature_1_xmsg;

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	public String getName() {
		return NAME;
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		PictogramElement pe = null;
		PictogramElement[] pes = null;
		if (context instanceof ICustomContext) {
			pes = ((ICustomContext)context).getPictogramElements();
			if (pes.length == 1) {
				pe = pes[0];
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof Classifier || bo instanceof Feature || bo instanceof AssociationEnd) {
					ret = true;
				}
			}
		}
		return ret;
	}

	public ShowPropertiesFeature(IFeatureProvider fp) {
		super(fp);
	}

	public void execute(ICustomContext context) {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().showView(IPageLayout.ID_PROP_SHEET);
		} catch (PartInitException e) {
			MOFToolEditorPlugin.logError(e);
		}
	}
}
