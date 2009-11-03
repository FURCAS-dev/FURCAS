package com.sap.mi.fwk.ui.dnd;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.MRI;

/**
 * Data class used by {@link MriTransfer} to store a list of {@link MRI} strings
 * and additional lookup metadata
 * 
 * @author d031150
 */
public final class MriTransferData {

	private final List<String> mMriStrings;
	
	static final String LINE_SEP = System.getProperty("line.separator"); //$NON-NLS-1$

	MriTransferData(List<String> mriStrings) {
		mMriStrings = mriStrings;
	}

	/**
	 * @return the mriStrings
	 */
	public List<String> getMriStrings() {
		return mMriStrings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mMriStrings == null) ? 0 : mMriStrings.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MriTransferData other = (MriTransferData) obj;
		if (mMriStrings == null) {
			if (other.mMriStrings != null)
				return false;
		} else if (!mMriStrings.equals(other.mMriStrings))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (mMriStrings != null && !mMriStrings.isEmpty()) {
			s.append("\n"); //$NON-NLS-1$
			for (Iterator<String> iter = mMriStrings.iterator(); iter.hasNext();) {
				String mri = iter.next();
				s.append(mri);
				if (iter.hasNext())
					s.append("\n"); //$NON-NLS-1$
			}
		}
		return s.toString();
	}

}
