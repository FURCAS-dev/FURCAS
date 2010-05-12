/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.tracker.impl;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * An implementation of the {@link IMutationTracker} to track mutation actions
 * to a comma-separated values file.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class CSVMutationTracker implements IMutationTracker {

	private List<MutationTrackerEntry> entries;

	/**
	 * Empty default constructor.
	 */
	public CSVMutationTracker() {
		this.entries = new ArrayList<MutationTrackerEntry>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void track(String mutatorId, String message, boolean successful,
			List<EObject> involvedObjects,
			List<EStructuralFeature> involvedFeatures) {
		MutationTrackerEntry entry = createEntry(mutatorId, message,
				successful, involvedObjects, involvedFeatures);
		entries.add(entry);
	}

	/**
	 * Creates a new tracker entry.
	 * 
	 * @param mutatorId
	 *            mutator id.
	 * @param message
	 *            message to track.
	 * @param successful
	 *            specifies whether mutation was successful.
	 * @param involvedObjects
	 *            list of involved eobjects.
	 * @param involvedFeatures
	 *            list of involved features.
	 * @return
	 */
	private MutationTrackerEntry createEntry(String mutatorId, String message,
			boolean successful, List<EObject> involvedObjects,
			List<EStructuralFeature> involvedFeatures) {
		MutationTrackerEntry entry = new MutationTrackerEntry(mutatorId,
				message, successful, involvedObjects, involvedFeatures);
		return entry;
	}

	/**
	 * Writes all entries to the specified <code>writer</code>.
	 * 
	 * @param writer
	 *            to write entries to.
	 * @throws IOException
	 *             if writer is not writable.
	 */
	public void write(OutputStreamWriter writer) throws IOException {
		for (MutationTrackerEntry entry : this.entries) {
			entry.writeCSVLine(writer);
		}
	}

}
