package com.sap.mi.tools.cockpit.mql.ui.search;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.MODE;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.mql.MQLColumnType;

/**
 * @author d003456
 * 
 */
public class MQLCellData {

	private final MQLColumnType colummnType;

	private String cellText;

	private MRI mri;

	private int index;

	private int rowIndex;

	private MODE queryMode;

	private boolean isResolved;

	/**
	 * Creates {@link MQLCellData}.
	 * 
	 * @param colummnType
	 *            {@link MQLColumnType} type
	 */
	public MQLCellData(MQLColumnType colummnType) {

		Assert.isNotNull(colummnType);
		this.colummnType = colummnType;
		this.setResolved(true);
	}

	/**
	 * @return the rowIndex
	 */
	public final int getRowIndex() {

		return this.rowIndex;
	}

	/**
	 * @param rowIndex
	 *            the rowIndex to set
	 */
	public final void setRowIndex(int rowIndex) {

		this.rowIndex = rowIndex;
	}

	/**
	 * @return the index
	 */
	public final int getIndex() {

		return this.index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public final void setIndex(int index) {

		this.index = index;
	}

	/**
	 * @return the cellText
	 */
	public final String getCellText() {

		return this.cellText;
	}

	/**
	 * @param cellText
	 *            the cellText to set
	 */
	public final void setCellText(String cellText) {

		this.cellText = cellText;
	}

	public final String getAlias() {

		return this.colummnType.alias;
	}

	/**
	 * @return the colummnType
	 */
	public final MQLColumnType getColummnType() {

		return this.colummnType;
	}

	public boolean isMRI() {

		return this.colummnType.attribute == null;
	}

	public boolean isAttribute() {

		return this.colummnType.attribute != null;
	}

	public boolean isMultiValued() {

		return this.colummnType.multiValued;
	}

	public boolean isOrdered() {

		return this.colummnType.isOrdered;
	}

	public boolean isUnique() {

		return this.colummnType.isUnique;
	}

	/**
	 * @param mri
	 *            the {@link MRI} to set
	 */
	public void setMri(MRI mri) {

		this.mri = mri;
	}

	/**
	 * @return the {@link MRI} mri
	 */
	public MRI getMri() {

		return this.mri;
	}

	/**
	 * @return the queryMode
	 */
	public final MODE getQueryMode() {

		return this.queryMode;
	}

	public boolean isRemote() {

		return this.queryMode == MODE.REMOTE;
	}

	public boolean isLocal() {

		return this.queryMode == MODE.LOCAL;
	}

	/**
	 * @param queryMode
	 *            the queryMode to set
	 */
	public final void setQueryMode(MODE queryMode) {

		this.queryMode = queryMode;
	}

	/**
	 * @param isResolved
	 *            the isResolved to set
	 */
	public void setResolved(boolean isResolved) {

		this.isResolved = isResolved;
	}

	/**
	 * @return the isResolved
	 */
	public boolean isResolved() {

		return this.isResolved;
	}
}
