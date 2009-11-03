package com.sap.mi.fwk;

import java.util.Comparator;

import com.sap.tc.moin.repository.mmi.model.ModelElement;

/**
 * Compares {@link ModelElement MOF model elements} by their
 * {@link ModelElement#getName() name}
 * 
 * @author d031150
 */
public final class ModelElementNameComparator implements Comparator<ModelElement> {

	/**
	 * A comparator comparing case-sensitively
	 */
	public static final Comparator<ModelElement> INSTANCE = new ModelElementNameComparator(false);

	/**
	 * A comparator comparing case-insensitively, i.e. ignoring case
	 */
	public static final Comparator<ModelElement> INSTANCE_IGNORING_CASE = new ModelElementNameComparator(true);

	private final boolean mIgnoringCase;

	/**
	 * @see Comparator#compare(Object, Object)
	 */
	public int compare(ModelElement o1, ModelElement o2) {
		if (o1 == o2)
			return 0;
		else if (o1 == null)
			return -1;
		else if (o2 == null)
			return 1;

		if (mIgnoringCase)
			return o1.getName().compareToIgnoreCase(o2.getName());
		else
			return o1.getName().compareTo(o2.getName());
	}

	/**
	 * Creates a comparator which compares case-sensitively or insensitve
	 * depending on the given flag
	 * 
	 * @param compareIgnoringCase
	 *            <code>true</code> if case should be ignored,
	 *            <code>false</code> otherwise
	 * 
	 * @see #INSTANCE
	 * @see #INSTANCE_IGNORING_CASE
	 */
	private ModelElementNameComparator(boolean compareIgnoringCase) {
		mIgnoringCase = compareIgnoringCase;
	}

	@Override
	public String toString() {
		return mIgnoringCase ? "NOT case-sensitive" : "Case-sensitive"; //$NON-NLS-1$ //$NON-NLS-2$
	}

}
