package com.sap.mi.tools.cockpit.mql.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.tools.cockpit.mql.Messages;

/**
 * @author d003456
 * 
 */
public final class MQLSearchResultPageColumnLabelProvider extends ColumnLabelProvider implements IStyledLabelProvider {

	private int columnIndex;

	private final static String CELL_ERROR = Messages.MQLSearchResultPageColumnLabelProvider_0_xfld;

	/**
	 * Creates MQLSearchResultPageColumnLabelProvider.
	 * 
	 * @param columnIndex
	 */
	public MQLSearchResultPageColumnLabelProvider(int columnIndex) {

		super();
		this.columnIndex = columnIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		final List<MQLCellData> cells = getCells(element);
		if (cells != null) {
			if (this.columnIndex != cells.get(this.columnIndex).getIndex()) {
				return MQLSearchResultPageColumnLabelProvider.CELL_ERROR;
			}
			return cells.get(this.columnIndex).getCellText();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	private List<MQLCellData> getCells(Object element) {

		if (element != null && element instanceof ArrayList) {
			final List<?> objs = (ArrayList<?>) element;
			if (objs.size() > 0 && objs.get(0) instanceof MQLCellData) {
				final List<MQLCellData> cells = (List<MQLCellData>) objs;
				return cells;
			}
		}
		return null;
	}

	/**
	 * Set the columnIndex.
	 * 
	 * @return the columnIndex
	 */
	public final int getColumnIndex() {

		return this.columnIndex;

	}

	/**
	 * Return the columnIndex.
	 * 
	 * @param columnIndex
	 *            the columnIndex to set
	 */
	public final void setColumnIndex(int columnIndex) {

		this.columnIndex = columnIndex;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
	 */
	public StyledString getStyledText(Object element) {

		final String text = getText(element);
		final StyledString styledString = new StyledString(text);
		final List<MQLCellData> cells = getCells(element);
		if (cells != null && !cells.get(this.columnIndex).isResolved()) {
			styledString.setStyle(0, text.length(), StyledString.QUALIFIER_STYLER);
		}
		return styledString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {

		final List<MQLCellData> cells = getCells(element);
		if (cells != null && !cells.get(this.columnIndex).isResolved()) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
		}
		return null;
	}
}
