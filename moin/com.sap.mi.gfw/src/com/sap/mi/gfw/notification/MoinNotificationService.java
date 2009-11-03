package com.sap.mi.gfw.notification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.links.PictogramLinkReferencesBusinessObjects;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;

/**
 * The Class MoinNotificationService.
 */
public class MoinNotificationService extends AbstractNotificationService implements INotificationService, UpdateListener {

	/**
	 * Instantiates a new moin notification service.
	 * 
	 * @param abstractDiagramTypeProvider
	 *            the abstract diagram type provider
	 */
	public MoinNotificationService(IDiagramTypeProvider abstractDiagramTypeProvider) {
		super(abstractDiagramTypeProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.notification.AbstractNotificationService#calculateLinkedPictogramElements(java.util.ArrayList)
	 */
	@Override
	protected PictogramElement[] calculateLinkedPictogramElements(ArrayList<Object> changedAndRelatedBOsList) {
		final String SIGNATURE = "calculateLinkedPictogramElements(ArrayList)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(MoinNotificationService.class, SIGNATURE, new Object[] { changedAndRelatedBOsList });
		}
		// Removed because extending with composite parents will almost always
		// produce a complete Diagram Update!!!!
		// Collection<RefObject> childrenWithParents =
		// extendWithCompositeParents(changedAndRelatedBOsList);
		// Collections.addAll((Collection) dirtyPEs,
		// PeUtil.getLinkedPictogramElements(childrenWithParents
		// .toArray(new RefObject[childrenWithParents.size()]),
		// getDiagramTypeProvider().getDiagram()));

		// Resolve dirtyPictogramElementMris
		Partitionable diag = this.getDiagramTypeProvider().getDiagram();
		Connection con = diag.get___Connection();
		ArrayList<PictogramElement> dirtyPEs = new ArrayList<PictogramElement>(dirtyPictogramElementMris.size());
		for (MRI dirtyPEMRI : dirtyPictogramElementMris) {
			PictogramLink pLink = (PictogramLink) con.getElement(dirtyPEMRI);
			if (pLink != null) {
				dirtyPEs.add(pLink.getPictogramElement());
			}
		}

		// Add the result of querying Pictogram Elements linked to the given
		// dirty BOs
		final Diagram diagram = getDiagramTypeProvider().getDiagram();

		Object[] linkedPictogramElements = PeUtil.getLinkedPictogramElements(changedAndRelatedBOsList
				.toArray(new RefObject[changedAndRelatedBOsList.size()]), diagram);
		Collections.addAll((Collection) dirtyPEs, linkedPictogramElements);

		PictogramElement[] res = dirtyPEs.toArray(new PictogramElement[dirtyPEs.size()]);

		if (info) {
			T.racer().exiting(MoinNotificationService.class, SIGNATURE, res);
		}
		return res;
	}

	// This list contains dirty Pictogram Elements that can not be determine by
	// a query because the domain element has
	// been deleted
	private ArrayList<MRI> dirtyPictogramElementMris;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.events.UpdateListener#notifyUpdate(com.sap.tc.moin.repository.events.EventChain)
	 */
	public void notifyUpdate(EventChain eventChain) {
		Partitionable diag = (this.getDiagramTypeProvider().getDiagram());
		if (!diag.is___Alive()) {
			return;
		}
		PRI diagramPri = diag.get___Partition().getPri();
		if (diagramPri.isVolatilePartition()) {
			return;
		}
		Connection con = diag.get___Connection();
		RefObject elementPLRBO = con.getAssociation(PictogramLinkReferencesBusinessObjects.ASSOCIATION_DESCRIPTOR).refMetaObject();
		MRI PLRBOMri = ((Partitionable) elementPLRBO).get___Mri();

		dirtyPictogramElementMris = new ArrayList<MRI>();
		HashSet<MRI> changedBoMRIs = new HashSet<MRI>(eventChain.getEvents().size());
		final List<ChangeEvent> events = eventChain.getEvents();
		MRI affectedElementMri;
		for (ChangeEvent changeEvent : events) {
			// TODO: Consider PartitionMembershipChangeEvent!!
			if (changeEvent instanceof ElementChangeEvent) {
				ElementChangeEvent elementChangeEvent = (ElementChangeEvent) changeEvent;
				affectedElementMri = elementChangeEvent.getAffectedElementMri();
				if (affectedElementMri != null) {
					// Do not update if there is any element from the diagram
					// This heuristic is used to avoid "double updating" when
					// the modification was performed by the
					// editor
					// itself
					if (diagramPri.equals(affectedElementMri.getPri())) {
						dirtyPictogramElementMris = null;
						return;
					}
					changedBoMRIs.add(affectedElementMri);
				}
			} else if (changeEvent instanceof LinkChangeEvent) {
				LinkChangeEvent linkChangeEvent = (LinkChangeEvent) changeEvent;
				// PictogramElementLink removed is a special case:
				// As the BO has been removed, there is now way to trace back
				// the corresponding PE via Query
				if ((changeEvent instanceof LinkRemoveEvent) && (PLRBOMri.equals(linkChangeEvent.getAffectedMetaObjectMri()))) {
					MRI linkMRI = linkChangeEvent.getSecondLinkEndMri();
					if (linkMRI != null) {
						dirtyPictogramElementMris.add(linkMRI);
					}
				} else {
					// Process First Link
					affectedElementMri = linkChangeEvent.getFirstLinkEndMri();
					if (affectedElementMri != null) {
						if (diagramPri.equals(affectedElementMri.getPri())) {
							dirtyPictogramElementMris = null;
							return;
						}
						changedBoMRIs.add(affectedElementMri);
					}

					// Process Second Link
					affectedElementMri = linkChangeEvent.getSecondLinkEndMri();
					if (affectedElementMri != null) {
						if (diagramPri.equals(affectedElementMri.getPri())) {
							dirtyPictogramElementMris = null;
							return;
						}
						changedBoMRIs.add(affectedElementMri);
					}
				}
			} else if (changeEvent instanceof PartitionMembershipChangeEvent) {

			}
		}

		// Only when not broken, resolve MRIs to Elements
		ArrayList<Object> changedBos = new ArrayList<Object>(changedBoMRIs.size());
		RefBaseObject changedBo;
		for (MRI changedBoMri : changedBoMRIs) {
			changedBo = con.getElement(changedBoMri);
			if (changedBo != null) {
				changedBos.add(changedBo);
			}
		}

		update(changedBos.toArray(new Object[changedBos.size()]));
	}

	/**
	 * The partition listener.
	 */
	UpdateListener partitionListener;

	/**
	 * Gets the partition listener.
	 * 
	 * @return the partition listener
	 */
	public UpdateListener getPartitionListener() {

		if (partitionListener == null) {
			partitionListener = new UpdateListener() {

				public void notifyUpdate(EventChain events) {

					IDiagramTypeProvider dtp = getDiagramTypeProvider();
					Partitionable diag = (dtp.getDiagram());
					if (!diag.is___Alive()) {
						return;
					}
					// Return if the event was produced by myself! (Same
					// session)
					Session mySess = diag.get___Connection().getSession();
					Session evSession = events.getEvents().get(0).getEventTriggerConnection().getSession();
					if (mySess.equals(evSession)) {
						return;
					}
					PRI diagramPri = diag.get___Partition().getPri();
					if (diagramPri.isVolatilePartition()) {
						return;
					}

					// Find all (bo-) PRIs linked to the diagram
					HashSet<PRI> linkedPrisSet = getLinkedPRIs((Diagram) diag);

					// For each partition change event...
					for (ChangeEvent event : events.getEvents()) {
						if (event instanceof PartitionChangeEvent) {
							PRI affectedPRI = ((PartitionChangeEvent) event).getAffectedPartitionPri();
							// If the affected partition is linked to the
							// diagram...
							if (linkedPrisSet.contains(affectedPRI)) {
								// update the diagram
								IDiagramEditor diagramEditor = dtp.getDiagramEditor();
								if (dtp.isAutoUpdateAtRuntime() && diagramEditor.isDirty()) {
									MoinNotificationService.this
											.updateDirtyPictogramElements(new PictogramElement[] { (PictogramElement) diag });
								} else {
									diagramEditor.refresh();
								}
								return;
							}
						}
					}
				}
			};
		}
		return partitionListener;
	}

	/**
	 * Gets the linked pr is.
	 * 
	 * @param diag
	 *            the diag
	 * @return the linked pr is
	 */
	public HashSet<PRI> getLinkedPRIs(Diagram diag) {
		HashSet<PRI> ret = new HashSet<PRI>();
		DiagramLink dl = LinkUtil.getDiagramLink(diag, false);
		if (dl != null) {
			Collection<PictogramLink> links = dl.getPictogramLinks();
			for (PictogramLink link : links) {
				for (RefObject bo : link.getBusinessObjects()) {
					ret.add(((Partitionable) bo).get___Partition().getPri());
				}
			}
		}
		return ret;
	}

}
