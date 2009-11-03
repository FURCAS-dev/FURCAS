package com.sap.mi.gfw.eclipse.platform;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.IFilter;

import com.sap.mi.gfw.mm.links.LinksPackage;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.links.PictogramLinkReferencesBusinessObjects;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PackageUtil;

abstract public class AbstractPropertySectionFilter implements IFilter {

	final public boolean select(Object object) {
		if (object instanceof EditPart) {
			EditPart editPart = (EditPart) object;
			Object model = editPart.getModel();
			if (model instanceof PictogramElement) {
				PictogramElement pictogramElement = (PictogramElement) model;
				return accept(pictogramElement);
			}
		} else if (object instanceof RefObject) {
			if (object instanceof PictogramElement)
				return accept((PictogramElement) object);
			else
				return acceptBusinessObject((RefObject) object);
		} else if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			if (adaptable.getAdapter(EditPart.class) instanceof EditPart) {
				return select(adaptable.getAdapter(EditPart.class));
			}
			if (adaptable.getAdapter(RefObject.class) instanceof RefObject) {
				return select(adaptable.getAdapter(RefObject.class));
			}
		}
		return false;
	}

	abstract protected boolean accept(PictogramElement pictogramElement);

	protected boolean acceptBusinessObject(RefObject businessObject) {
		LinksPackage lp = PackageUtil.getLinksPackage(businessObject);
		PictogramLinkReferencesBusinessObjects assoc = lp.getPictogramLinkReferencesBusinessObjects();
		Collection<PictogramLink> links = assoc.getPictogramLink(businessObject);
		if (links != null && links.size() != 0) {
			boolean accept = true;
			for (PictogramLink link : links) {
				accept &= accept(link.getPictogramElement());
			}
			return accept;
		}
		return false;
	}
}
