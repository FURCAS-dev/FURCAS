package com.sap.tc.moin.repository.core.links;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkFactory;
import com.sap.tc.moin.repository.core.EndStorageLinkManager;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.impl.MriReferenceImpl;
import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;

@SuppressWarnings("unchecked")
public final class QueryLinkManagerImpl extends AbstractEndStorageLinkManager
		implements QueryLinkManager {

	private static final Comparator<EndStorageLink> STORAGE_END_COMPARATOR = new Comparator<EndStorageLink>() {

		public int compare(EndStorageLink link1, EndStorageLink link2) {

			int result = link1.getStorageEnd().getMofId().compareTo(
					link2.getStorageEnd().getMofId());
			if (result == 0) {
				// Same MOF-ID, we need to compare the PRIs.
				return link1.getStorageEnd().getPri().toString().compareTo(
						link2.getStorageEnd().getPri().toString());
			}
			return result;
		}
	};

	Map<MRI, WeakMriReference> mriReferences;

	/**
	 * Structure for hosting {@link JmiList}s so that they can be reused. They
	 * are only weakly referenced so that garbage collection is not prevented.
	 */
	private Map<EndAndMetaObject, Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>> jmiListsForEndAndMetaObject;

	public QueryLinkManagerImpl(Workspace workspace) {

		super(workspace);
		this.jmiListsForEndAndMetaObject = new IdentityHashMap<EndAndMetaObject, Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>>();
		this.mriReferences = new HashMap<MRI, WeakMriReference>(512);
	}

	private ReferenceQueue getReferenceQueue() {

		return this.getWorkspaceSet().getMoin().getReferenceQueue();
	}

	// Don't remove synchronized because of Housekeeping thread!
	private synchronized final void registerJmiList(JmiList jmiList,
			EndAndMetaObject endAndMetaObject, MRI fromEnd) {

		Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>> jmiListForLri = this.jmiListsForEndAndMetaObject
				.get(endAndMetaObject);
		if (jmiListForLri == null) {
			jmiListForLri = new HashMap<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>();
			this.jmiListsForEndAndMetaObject.put(endAndMetaObject,
					jmiListForLri);
		}
		AmbiguousLriMap<WeakReferenceForJmiList> existingJmiList = jmiListForLri
				.get(fromEnd.getLri());

		WeakReferenceForJmiList<JmiList> weakReferenceForJmiList = new WeakReferenceForJmiList<JmiList>(
				jmiList, new CleanupInfo(jmiListForLri, fromEnd,
						this.jmiListsForEndAndMetaObject, endAndMetaObject,
						this), this.getReferenceQueue());

		if (existingJmiList == null) {
			existingJmiList = new AmbiguousLriMap<WeakReferenceForJmiList>(
					fromEnd, weakReferenceForJmiList);
			jmiListForLri.put(fromEnd.getLri(), existingJmiList);
		} else {// there is already a mapping from LRI to JmiList, that must be
			// an inconsistency
			existingJmiList.put(fromEnd.getPri(), weakReferenceForJmiList);
		}
	}

	// Don't remove synchronized because of Housekeeping thread!
	private synchronized final JmiList findJmiList(
			EndAndMetaObject endAndMetaObject, MRI fromEndMri) {

		List<JmiListForDistributedEndStorage> jmiListsForLri = this
				.findJmiLists(endAndMetaObject, fromEndMri.getLri());
		for (int i = 0, n = jmiListsForLri.size(); i < n; i++) {
			JmiList list = jmiListsForLri.get(i);
			if (fromEndMri.equals(list.getFromEnd())) {
				return list;
			}
		}
		return null;
	}

	@Override
	// Don't remove synchronized because of Housekeeping thread!
	protected synchronized final JmiList getOrCreateJmiList(
			CoreSession session, EndAndMetaObject endAndMetaObject,
			CorePartitionable fromEnd) {

		JmiList result = this
				.findJmiList(endAndMetaObject, fromEnd.get___Mri());
		if (result == null) {
			MriReference fromEndReference = createMriReference(session, fromEnd
					.get___Mri());
			result = this.createJmiList(session, endAndMetaObject,
					fromEndReference);
			this.registerJmiList(result, endAndMetaObject, fromEnd.get___Mri());
		   }
		return result;
	}

	private JmiList createJmiList(CoreSession session,
			EndAndMetaObject endAndMetaObject, MriReference fromEnd) {

		return new JmiListForDistributedEndStorage(session, endAndMetaObject,
				fromEnd, this.getWorkspace());
	}

	// Don't remove synchronized because of Housekeeping thread!
	private synchronized final List<JmiListForDistributedEndStorage> findJmiLists(
			EndAndMetaObject endAndMetaObject, LRI fromEndLri) {

		List<JmiListForDistributedEndStorage> result = null;
		Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>> jmiListsForLri = this.jmiListsForEndAndMetaObject
				.get(endAndMetaObject);
		if (jmiListsForLri != null) {
			AmbiguousLriMap<WeakReferenceForJmiList> jmiListsForLriEntry = jmiListsForLri
					.get(fromEndLri);
			if (jmiListsForLriEntry != null) {
				if (jmiListsForLriEntry.isAmbiguous()) {
					Collection<PRI> pris = jmiListsForLriEntry.getPris();
					result = new ArrayList<JmiListForDistributedEndStorage>(
							pris.size());
					for (PRI pri : pris) {
						WeakReferenceForJmiList weakReferenceForJmiList = jmiListsForLriEntry
								.get(pri);
						if (weakReferenceForJmiList != null) {
							JmiListForDistributedEndStorage jmiList = (JmiListForDistributedEndStorage) weakReferenceForJmiList
									.get();
							if (jmiList != null) {
								result.add(jmiList);
							}
						}
					}
				} else { // not ambiguous
					PRI pri = jmiListsForLriEntry.getStandardPri();
					WeakReferenceForJmiList weakReferenceForJmiList = jmiListsForLriEntry
							.get(pri);
					if (weakReferenceForJmiList != null) {
						JmiListForDistributedEndStorage jmiList = (JmiListForDistributedEndStorage) weakReferenceForJmiList
								.get();
						if (jmiList != null) {
							result = Collections.singletonList(jmiList);
						}
					}
				}
			}
		}
		if (result == null) {
			result = Collections.emptyList();
		}
		return result;
	}

	@Override
	protected final EndStorageLink getSingleLinkForEndAndMetaObject(
			CoreSession session, EndAndMetaObject endAndMetaObject,
			CorePartitionable elementAtEnd) {

		Collection<MRI> mrisForEndAndMetaObject = this
				.getMrisForEndAndMetaObject(session, endAndMetaObject,
						elementAtEnd, false);
		int size = mrisForEndAndMetaObject.size();
		if (size == 1) {
			MRI mri = mrisForEndAndMetaObject.iterator().next();
			return this
					.createLink(session, endAndMetaObject, elementAtEnd, mri);
		} else if (size == 0) {
			return null;
		} else { // size > 1, inconsistency: too many links
			MRI previousMri = null;
			for (MRI mri : mrisForEndAndMetaObject) {
				if (previousMri != null) {
					if (!previousMri.getLri().equals(mri.getLri())) {
						// TODO notify multiplicity violation
						return this.createLink(session, endAndMetaObject,
								elementAtEnd, previousMri);
					}
				}
				previousMri = mri;
			}
			// notify new duplicate element inconsistency - in case the elements
			// that have been found have not been instantiated
			MRI usedMri = session.getConsistencyViolationRegistry()
					.notifyDuplicateElementInconsistency(
							new ArrayList<MRI>(mrisForEndAndMetaObject));
			return this.createLink(session, endAndMetaObject, elementAtEnd,
					usedMri);
		}
	}

	private EndStorageLink createLink(CoreSession session,
			EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd,
			MRI elementAtTargetEndMri) {

		WorkspaceSet workspaceSet = this.getWorkspace().getWorkspaceSet();
		EndStorageLinkFactory linkFactory = workspaceSet.getLinkFactory();
		return linkFactory.createEndStorageLink(session, endAndMetaObject
				.getToEnd(), (Association) endAndMetaObject.getMetaObject(
				workspaceSet.getMoin()).get(session), this.createMriReference(
				session, elementAtTargetEndMri), this.getWorkspace()
				.getMemoryLinkManager().createMoinReferenceForOtherEnd(
						elementAtTargetEndMri.getPri(), elementAtEnd));
	}

	public void updateCaches(LRI lriOfOtherEnd,
			EndAndMetaObject endAndMetaObject, Iterator iterator) {

		if (lriOfOtherEnd == null) {
			// If the element is not there, there can't be a JmiList for it.
			return;
		}
		// There is the possibility that there are JmiLists for distributed end
		// storage at the other end.
		EndAndMetaObject relevantEndAndMetaObject = this.getWorkspace()
				.getWorkspaceSet().getEndAndMetaObjectPool()
				.getEndAndMetaObject(endAndMetaObject.getToEnd(),
						endAndMetaObject.getMetaObjectMofId());
		// Update the JmiListForDistributedEndStorage.
		this.invalidateJmiList(lriOfOtherEnd, relevantEndAndMetaObject,
				iterator);
	}

	void invalidateJmiList(LRI lriOfFromEnd,
			EndAndMetaObject relevantEndAndMetaObject, Iterator iterator) {

		List<JmiListForDistributedEndStorage> jmiLists = this.findJmiLists(
				relevantEndAndMetaObject, lriOfFromEnd);
		for (int i = 0, n = jmiLists.size(); i < n; i++) {
			jmiLists.get(i).invalidate(iterator);
		}
	}

	public int getNumberOfElementsForEndAndMetaObjectIncludingOverflows(
			CoreSession session, EndAndMetaObject endAndMetaObject,
			CorePartitionable elementAtEnd) {

		return getLinksForEndAndMetaObject(session, endAndMetaObject,
				elementAtEnd).size();
	}

	public Collection<EndStorageLink> getLinksForEndAndMetaObject(
			CoreSession session, EndAndMetaObject endAndMetaObject,
			CorePartitionable elementAtEnd) {

		return this.getLinksForEndAndMetaObject(session, endAndMetaObject,
				elementAtEnd, false);
	}

	public Collection<EndStorageLink> getLinksForEndAndMetaObject(
			CoreSession session, EndAndMetaObject endAndMetaObject,
			CorePartitionable elementAtEnd, boolean ignorePersistence) {

		WorkspaceSet workspaceSet = getWorkspaceSet();
		assert jmiHelper.isEndStored(session, endAndMetaObject.getToEnd(),
				(RefObject) endAndMetaObject.getMetaObject(
						workspaceSet.getMoin()).get(session)) : "Expected that 'toEnd' of EndAndMetaObject used for distributed link navigation is stored"; //$NON-NLS-1$
		Collection<MRI> mrisForEndAndMetaObject = this
				.getMrisForEndAndMetaObject(session, endAndMetaObject,
						elementAtEnd, ignorePersistence);
		int size = mrisForEndAndMetaObject.size();
		if (size > 0) {
			EndStorageLinkFactory linkFactory = this.getWorkspace()
					.getWorkspaceSet().getLinkFactory();
			RefObject metaObject = (RefObject) endAndMetaObject.getMetaObject(
					workspaceSet.getMoin()).get(session);
			boolean isAssociation = (metaObject instanceof Association);
			EndStorageLink[] result = new EndStorageLink[size];
			int index = 0;
			for (MRI mri : mrisForEndAndMetaObject) {
				EndStorageLink link;
				if (isAssociation) {
					link = linkFactory.createEndStorageLink(session,
							endAndMetaObject.getToEnd(),
							(Association) metaObject, this.createMriReference(
									session, mri), this.getWorkspace()
									.getMemoryLinkManager()
									.createMoinReferenceForOtherEnd(
											mri.getPri(), elementAtEnd));
				} else {
					link = linkFactory.createEndStorageLink(session,
							endAndMetaObject.getToEnd(),
							(Attribute) metaObject, this.createMriReference(
									session, mri), this.getWorkspace()
									.getMemoryLinkManager()
									.createMoinReferenceForOtherEnd(
											mri.getPri(), elementAtEnd));
				}
				result[index++] = link;
			}
			if (size > 1) {
				Arrays.sort(result, STORAGE_END_COMPARATOR);
			}
			return Arrays.asList(result);
		}
		return Collections.emptyList();
	}

	private Collection<MRI> getMrisForEndAndMetaObject(CoreSession session,
			EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd,
			boolean ignorePersistence) {

		Collection<MRI> persistedMris;
		if (ignorePersistence
				|| elementAtEnd.get___Partition().isExtentPartition()) {
			persistedMris = null;
		} else {
			persistedMris = this.getPersistedElementsMrisForEndAndMetaObject(
					session, endAndMetaObject, elementAtEnd.get___Mri());
		}
		Collection<MRI> inMemoryMris = this.mergeWithCurrentMemoryState(
				session, endAndMetaObject, elementAtEnd, persistedMris);
		if (persistedMris == null && inMemoryMris == null) {
			return Collections.emptyList();
		} else if (persistedMris != null && inMemoryMris == null) {
			return persistedMris;
		} else if (persistedMris == null && inMemoryMris != null) {
			return inMemoryMris;
		} else {
			persistedMris.addAll(inMemoryMris);
			return persistedMris;
		}
	}

	private Collection<MRI> getPersistedElementsMrisForEndAndMetaObject(
			CoreSession session, EndAndMetaObject endAndMetaObject,
			MRI elementAtEnd) {

		Set<MRI> result = null;
		SpiCompoundClientSpec compoundClientSpec = this
				.getCompoundClientSpec(session);
		for (Facility facility : this.getWorkspace().getWorkspaceSet()
				.getMoin().getFacilities()) {
			SpiCoreQueryService query = ((SpiFacility) facility)
					.getCoreQueryService();
			if (query != null) {
				Collection<ClientSpec> clientSpecs = compoundClientSpec
						.getClientSpecsLive(facility);
				if (clientSpecs != null && (!clientSpecs.isEmpty())) {
					Collection<MRI> queryResult = query
							.getReferringElementsForEndAndMetaobject(
									clientSpecs
											.toArray(new ClientSpec[clientSpecs
													.size()]),
									endAndMetaObject.getMetaObject(
											getWorkspaceSet().getMoin())
											.getMri(session), elementAtEnd,
									endAndMetaObject.getFromEnd());
					if (queryResult != null && !queryResult.isEmpty()) {
						if (result == null) {
							result = new HashSet<MRI>();
						}
						result.addAll(queryResult);
					}
				}
			}
		}
		return result;
	}

	private Collection<MRI> mergeWithCurrentMemoryState(CoreSession session,
			EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd,
			Collection<MRI> persistedElementMris) {

		Collection<MRI> result = null;

		// TODO This is only done because during MM deployment there is no
		// target data area set which is used during
		// Connection.getNullPartition(),
		// therefore we must not merge in the client specific dirty state.
		// if ( connection != null ) {
		// DataArea targetDataArea = connection.getTargetDataArea( );
		// if ( targetDataArea == null ) {
		// return null;
		// }
		// }

		// The element's partition has to be considered as the persistence might
		// only return elements in other
		// partitions ("cross-links").
		CoreModelPartition mp = elementAtEnd.get___Partition();
		if (mp.isExtentPartition()) {
			result = mergePartition(mp, endAndMetaObject, elementAtEnd,
					null /* persistedElementMris */, result);
		} else if (!mp.getPri().isVolatilePartition() && !mp.isDirty()) {
			result = mergePartition(mp, endAndMetaObject, elementAtEnd,
					persistedElementMris, result);
		}

		if (session != null) {
			for (CoreModelPartition partition : session
					.getPartitionsToConsiderMemoryState()) {
				result = mergePartition(partition, endAndMetaObject,
						elementAtEnd, persistedElementMris, result);
			}
		}
		return result;
	}

	private Collection<MRI> mergePartition(ModelPartition partition,
			EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd,
			Collection<MRI> persistedElementMris, Collection<MRI> previousResult) {

		Collection<MRI> result = previousResult;
		PRI partitionToConsiderMemoryStatePri = partition.getPri();
		if (persistedElementMris != null) {
			boolean isMetaModelPartition = partitionToConsiderMemoryStatePri
					.isMetaModelPartition();
			boolean isVolatilePartition = partitionToConsiderMemoryStatePri
					.isVolatilePartition();
			// persistedElementMris can't be in transient or null partition as
			// these are never persisted
			// and those which are in a metamodel partition must and need not be
			// removed because
			// there can't be a changed state in memory compared to persistence.
			if ((!isMetaModelPartition) && (!isVolatilePartition)) {
				// remove all elements from persistedElements which reside in
				// potentially changed
				// partitions and the partition of the element itself as the
				// persistence might have
				// only returned elements which are in other partitions
				for (Iterator<MRI> it = persistedElementMris.iterator(); it
						.hasNext();) {
					MRI persistedElementMri = it.next();
					if (persistedElementMri.getPri().equals(
							partitionToConsiderMemoryStatePri)) {
						it.remove();
					}
				}
			}
		}
		// add all elements which are currently in memory from client specific
		// workspace which reside in
		// partitions which might contain changes in memory
		List<EndStorageLink> distributedLinksForEndAndMetaObject = ((CoreModelPartition) partition)
				.getDistributedLinkContainer().getLinksForMetaObject(
						endAndMetaObject.getMetaObjectMofId(), elementAtEnd);
		if (distributedLinksForEndAndMetaObject != null) {
			for (int i = 0, n = distributedLinksForEndAndMetaObject.size(); i < n; i++) {
				EndStorageLink link = distributedLinksForEndAndMetaObject
						.get(i);
				if (result == null) {
					result = new HashSet<MRI>();
				}
				result.add(link.getStorageEnd().getMri());
			}
		}
		return result;
	}

	public Collection<PRI> getReferringPartitions(CoreSession session,
			MRI element) {

		SpiCompoundClientSpec compoundClientSpec = this
				.getCompoundClientSpec(session);
		Collection<PRI> result = new ArrayList<PRI>();
		for (Facility facility : this.getWorkspace().getWorkspaceSet()
				.getMoin().getFacilities()) {
			SpiCoreQueryService query = ((SpiFacility) facility)
					.getCoreQueryService();
			if (query != null) {
				Collection<ClientSpec> clientSpecs = compoundClientSpec
						.getClientSpecsLive(facility);
				if (clientSpecs != null && (!clientSpecs.isEmpty())) {
					Collection<PRI> queryResult = null;
					queryResult = query.getReferringPartitions(clientSpecs
							.toArray(new ClientSpec[clientSpecs.size()]),
							element);
					if (queryResult != null) {
						result.addAll(queryResult);
					}
				}
			}
		}
		return result;
	}

	public void elementRelocated(MRI oldMri, CoreModelPartition newPartition) {

		synchronized (mriReferences) {
			WeakMriReference weakRef = mriReferences.get(oldMri);
			if (weakRef != null) {
				weakRef.elementRelocated(newPartition);
				mriReferences.remove(oldMri);
				mriReferences.put(weakRef.mri, weakRef);
			}
		}
	}

	private SpiCompoundClientSpec getCompoundClientSpec(CoreSession session) {

		if (session != null) {
			return session.getCompoundClientSpec();
		}

		Workspace workspace = getWorkspace();
		if (workspace instanceof SessionWorkspace) {
			return ((SessionWorkspace) workspace).getSession()
					.getCompoundClientSpec();
		}

		// TODO also enable for shared workspaces
		// FIXME HACK !!!
		return new SpiCompoundClientSpec() {

			public Collection<ClientSpec> getClientSpecsLive(Facility facility) {

				ClientSpec clientSpec = getWorkspaceSet().getMoin()
						.getMetamodelClientSpec();
				if (facility.equals(clientSpec.getDataArea().getFacility())) {
					ArrayList<ClientSpec> result = new ArrayList<ClientSpec>(1);
					result.add(clientSpec);
					return result;
				}

				return Collections.emptyList();
			}

			public SpiResourceInfo getResourceInfo(LRI lri) {

				return null;
			}

			public SpiResourceInfo getResourceInfo(PRI pri) {

				return null;
			}

			public ClientSpec getClientSpec(DataAreaDescriptor dataArea) {

				return null;
			}

			public Collection<ClientSpec> getClientSpecs() {

				return null;
			}

			public Collection<ClientSpec> getClientSpecs(Facility facility) {

				return null;
			}

			public CompoundDataArea getCompoundDataArea() {

				return null;
			}

			public String getId() {

				return null;
			}
		};
	}

	private MriReference createMriReference(CoreSession session, MRI mri) {

		MriReference result = null;
		WorkspaceSet workspaceSet = this.getWorkspace().getWorkspaceSet();
		ReferenceManager referenceManager = workspaceSet.getReferenceManager();
		if (mri.getDataAreaDescriptor().isMetamodelDataArea()) {
			// we don't need a session if mri is in metamodel data area
			CorePartitionable element = workspaceSet.resolveMri(
					null /* session */, mri);
			result = referenceManager.getMetamodelMriReference(element);
		} else {
			if (session != null) {
				result = getMriReference(mri);
			} else {
				throw new IllegalStateException(
						"Attempt to create a MriReference for a non-metamodel MRI without session context"); //$NON-NLS-1$
			}
		}
		return result;
	}

	private MriReference getMriReference(MRI mri) {

		MriReference result = null;
		synchronized (mriReferences) {
			WeakMriReference weakRef = mriReferences.get(mri);
			result = weakRef != null ? weakRef.get() : null;
			if (result == null) {
				result = new MriReferenceImpl(null /* partitionable */, mri,
						false /* cacheable */, this.getWorkspaceSet().getMoin());
				mriReferences.put(mri, new WeakMriReference(result, this
						.getReferenceQueue()));
			}
		}
		return result;
	}

	public WorkspaceSet getWorkspaceSet() {

		return super.getWorkspace().getWorkspaceSet();
	}

	/**
	 * Specialized weak reference to wrap JMI lists. It extends
	 * {@link WeakReference} in order to be able to store cleanup information
	 * (which is the maps and corresponding keys as well as the responsible
	 * LinkManager as synchronization object) which will then be used when the
	 * referenced JMI list was garbage collected. The cleanup is done within
	 * {@link #actionOnBeingGarbageCollected(Reference)}.
	 * 
	 * @author d044711
	 */
	private static final class WeakReferenceForJmiList<T extends JmiList>
			extends WeakReference<JmiList> implements
			ActionOnBeingGarbageCollectedProvider {

		private final CleanupInfo cleanupInfo;

		public WeakReferenceForJmiList(T jmiList,
				CleanupInfo cleanupInformation,
				ReferenceQueue<? super JmiList> q) {

			super(jmiList, q);
			this.cleanupInfo = cleanupInformation;
		}

		public CleanupInfo getCleanupInfo() {

			return this.cleanupInfo;
		}

		public void actionOnBeingGarbageCollected(
				Reference referenceToObjectWhichHasBeenGarbageCollected) {

			if (referenceToObjectWhichHasBeenGarbageCollected instanceof WeakReferenceForJmiList) {
				WeakReferenceForJmiList jmiListReference = (WeakReferenceForJmiList) referenceToObjectWhichHasBeenGarbageCollected;
				CleanupInfo info = jmiListReference.getCleanupInfo();

				Map<EndAndMetaObject, Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>> jmiListsForEndAndMetaObject = info
						.getJmiListsForEndAndMetaObject();
				MRI mriOfFromEnd = info.getFromEnd();
				Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>> jmiListForLri = info
						.getJmiListForLri();
				EndAndMetaObject endAndMetaObject = info.getEndAndMetaObject();

				// the link manager is needed as synchronization object
				EndStorageLinkManager linkManager = info.getManager();

				info.clear();

				synchronized (linkManager) {
					// do the cleanup
					AmbiguousLriMap<WeakReferenceForJmiList> weakJmiList = jmiListForLri
							.get(mriOfFromEnd.getLri());
					if (weakJmiList != null) {
						weakJmiList.remove(mriOfFromEnd.getPri());
						if (weakJmiList.isEmpty()) {
							jmiListForLri.remove(mriOfFromEnd.getLri());
							if (jmiListForLri.isEmpty()) {
								jmiListsForEndAndMetaObject
										.remove(endAndMetaObject);
							}
						}
					}
				}

			}
		}
	}

	private static final class CleanupInfo {

		private Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>> jmiListForLri;

		private MRI fromEnd;

		private Map<EndAndMetaObject, Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>> jmiListsForEndAndMetaObject;

		private EndAndMetaObject endAndMetaObject;

		private AbstractEndStorageLinkManager manager;

		public CleanupInfo(
				Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>> jmiListForLri,
				MRI fromEnd,
				Map<EndAndMetaObject, Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>> jmiListsForEndAndMetaObject,
				EndAndMetaObject endAndMetaObject,
				AbstractEndStorageLinkManager manager) {

			this.jmiListForLri = jmiListForLri;
			this.fromEnd = fromEnd;
			this.jmiListsForEndAndMetaObject = jmiListsForEndAndMetaObject;
			this.endAndMetaObject = endAndMetaObject;
			this.manager = manager;

		}

		public EndAndMetaObject getEndAndMetaObject() {

			return endAndMetaObject;
		}

		public MRI getFromEnd() {

			return fromEnd;
		}

		public Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>> getJmiListForLri() {

			return jmiListForLri;
		}

		public Map<EndAndMetaObject, Map<LRI, AmbiguousLriMap<WeakReferenceForJmiList>>> getJmiListsForEndAndMetaObject() {

			return jmiListsForEndAndMetaObject;
		}

		public AbstractEndStorageLinkManager getManager() {

			return manager;
		}

		public void clear() {

			this.jmiListForLri = null;
			this.fromEnd = null;
			this.jmiListsForEndAndMetaObject = null;
			this.endAndMetaObject = null;
			this.manager = null;
		}
	}

	private final class WeakMriReference extends WeakReference<MriReference>
			implements ActionOnBeingGarbageCollectedProvider {

		MRI mri;

		public WeakMriReference(MriReference referent, ReferenceQueue refQueue) {

			super(referent, refQueue);
			this.mri = referent.getMri();
		}

		public void actionOnBeingGarbageCollected(
				Reference referenceToObjectWhichHasBeenGarbageCollected) {

			synchronized (mriReferences) {
				WeakMriReference weakMri = mriReferences.get(mri);
				if (weakMri != null) {
					if (weakMri.get() == null) {
						// to make sure that not another weak mri reference was
						// requested in time span between garbage collection
						// and this call, we have to check that the referent is
						// really null. Only if there is no more referent
						// the weak reference can be removed from the map.
						mriReferences.remove(mri);
					}
				}
			}
		}

		public void elementRelocated(CoreModelPartition newPartition) {

			if (!mri.getPri().equals(newPartition.getPri())) {
				mri = newPartition.getPri().createMri(mri.getMofId());
				MriReference mriReference = this.get();
				if (mriReference != null) {
					mriReference.elementRelocated(newPartition);
				}
			}
		}
	}
}