package com.sap.mi.tools.cockpit.mql.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.sap.mi.tools.cockpit.mql.search.MQLSearchResult;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * @author d003456
 * 
 */
public class MQLSearchResultPageContentProvider implements IStructuredContentProvider {

	private final Object[] EMPTY_ARRAY = new Object[0];

	private final MQLSearchResultPage page;

	/**
	 * Creates {@link MQLSearchResultPageContentProvider}.
	 * 
	 * @param page
	 *            the {@link MQLSearchResultPage} hosting the viewer
	 */
	public MQLSearchResultPageContentProvider(MQLSearchResultPage page) {

		super();
		Assert.isNotNull(page);
		this.page = page;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof MQLSearchResult) {
			final MQLResultSet resultSet = ((MQLSearchResult) inputElement).getResult();
			if (resultSet != null && !resultSet.isEmpty()) {
				final MQLColumnType[] queryColumnTypes = resultSet.getQueryColumnTypes();
				int shownElements = resultSet.getSize();
				if (getElementLimit() != -1) {// limit enabled
					shownElements = resultSet.getSize() > getElementLimit() ? getElementLimit() : resultSet.getSize();
				}
				final List<List<MQLCellData>> result = new ArrayList<List<MQLCellData>>(shownElements);

				for (int i = 0; i < shownElements; i++) {

					final List<MQLCellData> rowData = new ArrayList<MQLCellData>(queryColumnTypes.length);

					for (int j = 0; j < queryColumnTypes.length; j++) {

						final MQLCellData cellData = new MQLCellData(queryColumnTypes[j]);
						cellData.setRowIndex(i);
						cellData.setIndex(j);

						if (queryColumnTypes[j].attribute == null) {// is MRI
							cellData.setCellText(resultSet.getMri(i, queryColumnTypes[j].alias).toString());
							cellData.setMri(resultSet.getMri(i, queryColumnTypes[j].alias));//relevant for remote mode
							rowData.add(cellData);
							MQLSearchResult searchResult = (MQLSearchResult) inputElement;
							cellData.setQueryMode(searchResult.getQueryMode());
							
						} else {
							final Object value = resultSet.getAttribute(i, queryColumnTypes[j].alias, queryColumnTypes[j].attribute);
							if (value instanceof Object[]) {
								final Object[] values = (Object[]) value;
								final StringBuilder data = new StringBuilder("["); //$NON-NLS-1$
								for (int k = 0; k < values.length; k++) {
									data.append(String.valueOf(values[k]));
									if (k < values.length - 1) {
										data.append(',');
									}
								}
								data.append(']');
								cellData.setCellText(data.toString());
								rowData.add(cellData);
							} else {
								cellData.setCellText(String.valueOf(value));
								rowData.add(cellData);
							}
						}
					}
					result.add(rowData);
				}
				return result.toArray(new Object[shownElements]);
			}
		}
		return this.EMPTY_ARRAY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {

		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		// nothing to do
	}

	private int getElementLimit() {

		return this.page.getElementLimit().intValue();

	}
}
