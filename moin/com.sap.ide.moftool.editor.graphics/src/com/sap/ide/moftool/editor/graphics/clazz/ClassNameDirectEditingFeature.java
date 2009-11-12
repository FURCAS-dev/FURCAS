package com.sap.ide.moftool.editor.graphics.clazz;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

public class ClassNameDirectEditingFeature extends AbstractDirectEditingFeature {

	private String mInitialName = null;

	public ClassNameDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
		return TYPE_TEXT;
	}

	public String getInitialValue(IDirectEditingContext context) {
		mInitialName = null;
		MofClass mofClass = getMofClass(context);
		if (mofClass != null) {
			mInitialName = mofClass.getName();
		}
		return mInitialName;
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		MofClass mofClass = getMofClass(context);
		if (mofClass != null) {
			// if (mInitialName.equals(value)) {
			// // Name has not been changed
			// return null;
			// }
			// <pg290108> new name validation
			IStatus status = null;
			String oldName = mofClass.getName();
			if (value == null) {
				return null;
			}
			if (value.equals(oldName)) {
				status = NamespaceService.validate(mofClass, ""); //$NON-NLS-1$
			} else {
				status = NamespaceService.checkForNewSubobject(mofClass.getContainer(), value, mofClass);
			}
			if ((status != null) && status.getSeverity() == IStatus.ERROR) {
				return status.getMessage();
			} else {
				return null;
			}
		}
		// Not a mof class at all -> error
		return Messages.ClassNameDirectEditingFeature_0_xmsg;
	}

	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		MofClass mofClass = getMofClass(context);
		if (mofClass != null && (ModelElementService.checkNewName(value).getSeverity() != IStatus.ERROR)) {
			mofClass.setName(value);
			if (pe instanceof Shape) {
				updatePictogramElement(((Shape) pe).getContainer());

				// find the association and update the related Classes in Diagram
				Collection<Connection> connections = getDiagram().getConnections();
				for (Iterator<Connection> iter = connections.iterator(); iter.hasNext();) {
					Object element = iter.next();
					if (element instanceof Connection) {
						Connection con = (Connection) element;
						Object obj = getBusinessObjectForPictogramElement(con);
						if (obj instanceof Association) {
							Association assoc = (Association) obj;
							AssociationEnd[] assocEnds = AssociationService.getAssociationEnds(assoc);
							if (assocEnds[0].getType().equals(mofClass)) {
								ContainerShape otherRelatedClassShape = DiagramUtil.getExistingMofClassShapeFromDiagram(getDiagram(),
										(MofClass) assocEnds[0].otherEnd().getType());
								updatePictogramElement(otherRelatedClassShape);
							} else if (assocEnds[1].getType().equals(mofClass)) {
								ContainerShape otherRelatedClassShape = DiagramUtil.getExistingMofClassShapeFromDiagram(getDiagram(),
										(MofClass) assocEnds[1].otherEnd().getType());
								updatePictogramElement(otherRelatedClassShape);
							}
						} else if (obj == null) {
							updatePictogramElement(con.getStart().getParent());
						}
					}
				}
			}
		}
	}

	private MofClass getMofClass(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof MofClass) {
			return (MofClass) bo;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		boolean ret = super.canDirectEdit(context);
		if (!ret) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof MofClass) {
				ret = !ModelElementService.isForeignObject(getDiagram(), (MofClass) bo);
			}
		}
		return ret;
	}
}
