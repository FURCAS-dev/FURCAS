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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A data object holding all values of a mutation actions.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class MutationTrackerEntry {

	private Date timestamp;
	private String mutatorId;
	private String message;
	private boolean successful;
	private List<EObject> involvedObjects;
	private List<EStructuralFeature> involvedFeatures;

	/**
	 * The date formatter to use.
	 */
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	/**
	 * The separator.
	 */
	private final String SEPARATOR = ",";

	/**
	 * The end of line string.
	 */
	private final String EOL = "\n";

	/**
	 * The internal list separator.
	 */
	private final String LIST_SEPARATOR = " ";

	/**
	 * Constructs a new entry.
	 * 
	 * @param mutatorId
	 *            the mutator id.
	 * @param message
	 *            a message describing the mutation.
	 * @param successful
	 *            specifies whether the mutation was successful.
	 * @param involvedObjects
	 *            a list of involved objects.
	 * @param involvedFeatures
	 *            a list of involved features (might be null).
	 */
	public MutationTrackerEntry(String mutatorId, String message,
			boolean successful, List<EObject> involvedObjects,
			List<EStructuralFeature> involvedFeatures) {
		this.timestamp = new Date();
		this.mutatorId = mutatorId;
		this.message = message;
		this.successful = successful;
		this.involvedObjects = involvedObjects;
		this.involvedFeatures = involvedFeatures;
	}

	/**
	 * Writes a csv line holding all the data to the specified writer.
	 * 
	 * @param writer
	 *            to append line to.
	 * @throws IOException
	 *             if writer is not writable.
	 */
	protected void writeCSVLine(OutputStreamWriter writer) throws IOException {
		writer.append(mutatorId + SEPARATOR);
		writer.append(dateFormat.format(timestamp) + SEPARATOR);
		writer.append(successful + SEPARATOR);
		writer.append(message + SEPARATOR);

		for (int i = 0; i < this.involvedObjects.size(); i++) {
			// out object
			EObject eObject = involvedObjects.get(i);
			String id = EcoreUtil.getID(eObject);
			if (id != null) {
				writer.append(id);
			} else {
				writer.append(eObject.toString());
			}
			// out internal list separator if not at the end
			if (i + 1 < this.involvedObjects.size()) {
				writer.append(LIST_SEPARATOR);
			}
		}

		for (int i = 0; i < this.involvedFeatures.size(); i++) {
			// out object
			EStructuralFeature feature = involvedFeatures.get(i);
			writer.append(feature.getName());
			// out internal list separator if not at the end
			if (i + 1 < this.involvedFeatures.size()) {
				writer.append(LIST_SEPARATOR);
			}
		}

		writer.append(EOL);
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	protected void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @param mutatorId
	 *            the mutatorId to set
	 */
	protected void setMutatorId(String mutatorId) {
		this.mutatorId = mutatorId;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	protected void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param successful
	 *            the successful to set
	 */
	protected void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	/**
	 * @param involvedObjects
	 *            the involvedObjects to set
	 */
	protected void setInvolvedObjects(EList<EObject> involvedObjects) {
		this.involvedObjects = involvedObjects;
	}

	/**
	 * @param involvedFeatures
	 *            the involvedFeatures to set
	 */
	protected void setInvolvedFeatures(
			EList<EStructuralFeature> involvedFeatures) {
		this.involvedFeatures = involvedFeatures;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the mutatorId
	 */
	public String getMutatorId() {
		return mutatorId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the successful
	 */
	public boolean isSuccessful() {
		return successful;
	}

	/**
	 * @return the involvedObjects
	 */
	public List<EObject> getInvolvedObjects() {
		return involvedObjects;
	}

	/**
	 * @return the involvedFeatures
	 */
	public List<EStructuralFeature> getInvolvedFeatures() {
		return involvedFeatures;
	}

}
