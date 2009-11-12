package com.sap.ide.moftool.editor.graphics.clazz;

import java.util.ArrayList;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfClasses;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class ShowInCommonNavigatorFeature extends AbstractCustomFeature {

	public ShowInCommonNavigatorFeature(IFeatureProvider fp) {
		super(fp);
	}

	public void execute(ICustomContext context) {
		IViewReference[] viewReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getViewReferences();
		for (IViewReference viewReference : viewReferences) {
			IWorkbenchPart aViewPart = viewReference.getPart(false);
			if (aViewPart instanceof ISetSelectionTarget) {
				ISetSelectionTarget selTarget = (ISetSelectionTarget) aViewPart;
				selTarget.selectReveal(getBoFor(context));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private ISelection getBoFor(ICustomContext ctx) {
		PictogramElement[] elements = ctx.getPictogramElements();
		ArrayList<ITreeNode> l = new ArrayList<ITreeNode>();
		for (PictogramElement pictogramElement : elements) {
			Object bOForPE = getFeatureProvider().getBusinessObjectForPictogramElement(pictogramElement);
			if (bOForPE instanceof MofClass) {
				l.add(new NodeCnfClasses(((MofClass) bOForPE)));

			}
		}
		return new StructuredSelection(l);
	}
	
	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		for (PictogramElement pictogramElement : pictogramElements) {
			if(!(getFeatureProvider().getBusinessObjectForPictogramElement(pictogramElement) instanceof MofClass)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String getName() {
		return Messages.ShowInCommonNavigatorFeature_0_xbut;
	}
	
}