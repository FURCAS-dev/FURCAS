package com.sap.mi.gfw.eclipse.platform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.mm.links.LinksPackage;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.links.PictogramLinkReferencesBusinessObjects;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PackageUtil;

public abstract class GFPropertySection extends AbstractPropertySection implements PropertyChangeListener {

	protected PictogramElement getSelectedPictogramElement() {
		if (getSelection() instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection) getSelection();

			Object firstElement = structuredSelection.getFirstElement();

			if (firstElement instanceof EditPart) {
				EditPart editPart = (EditPart) firstElement;
				if (editPart.getModel() instanceof PictogramElement) {
					return (PictogramElement) editPart.getModel();
				}
			} else {
				if (firstElement instanceof IAdaptable && !(firstElement instanceof RefObject)) {
					firstElement = ((IAdaptable) firstElement).getAdapter(RefObject.class);
				}
				if (firstElement instanceof RefObject) {
					RefObject refObject = (RefObject) firstElement;
					LinksPackage lp = PackageUtil.getLinksPackage(refObject);
					PictogramLinkReferencesBusinessObjects assoc = lp.getPictogramLinkReferencesBusinessObjects();
					Collection<PictogramLink> links = assoc.getPictogramLink(refObject);
					if (links != null) {
						for (PictogramLink link : links) {
							return link.getPictogramElement();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * executes the feature and adds it to the command stack
	 * 
	 * @param feature
	 */
	public void execute(IFeature feature, IContext context) {
		GenericFeatureCommandWithContext c = new GenericFeatureCommandWithContext(feature, context);
		c.execute();
	}

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		refresh();
	}

	protected DiagramEditor getDiagramEditor() {
		IWorkbenchPart part = getPart();
		if (part instanceof DiagramEditor) {
			return (DiagramEditor) part;
		}
		return null;
	}

	protected Diagram getDiagram() {
		IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
		if (diagramTypeProvider == null) {
			return null;
		}
		return diagramTypeProvider.getDiagram();
	}

	protected IDiagramTypeProvider getDiagramTypeProvider() {
		DiagramEditor diagramEditor = getDiagramEditor();
		if (diagramEditor == null) {
			return null;
		}
		return diagramEditor.getDiagramTypeProvider();
	}
}
