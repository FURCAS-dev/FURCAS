package org.eclipse.emf.query2.internal.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query2.ColumnType;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class QueryResultView extends ViewPart {

	public class QueryResultLabelProvider extends StyledCellLabelProvider {

		private final int i;
		private Color systemColor;
		private String searchText;

		public QueryResultLabelProvider(int i) {
			this.i = i;
			systemColor = Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
		}

		public void setSearchText(String searchText) {
			this.searchText = searchText;
		}

		public void update(ViewerCell cell) {
			String columnText = ((Row) cell.getElement()).get(i).toString();
			cell.setText(columnText);
			if (searchText != null && searchText.length() > 0) {
				int intRangesCorrectSize[] = SearchUtil.getSearchTermOccurrences(searchText, columnText);
				List<StyleRange> styleRange = new ArrayList<StyleRange>();
				for (int i = 0; i < intRangesCorrectSize.length / 2; i++) {
					StyleRange myStyleRange = new StyleRange(0, 0, null, systemColor);
					myStyleRange.start = intRangesCorrectSize[i];
					myStyleRange.length = intRangesCorrectSize[++i];
					styleRange.add(myStyleRange);
				}
				StyleRange[] array = styleRange.toArray(new StyleRange[styleRange.size()]);
				cell.setStyleRanges(array);
			} else {
				cell.setStyleRanges(new StyleRange[0]);
			}

		}

	}

	public static class SearchUtil {
		public static int[] getSearchTermOccurrences(String searchTerm, String content) {
			List<StyleRange> styleRange;
			List<Integer> ranges;
			Display disp = Display.getCurrent();
			StyleRange myStyleRange = new StyleRange(0, 0, null, disp.getSystemColor(SWT.COLOR_YELLOW));

			styleRange = new ArrayList<StyleRange>(); // reset the
			// StyleRange-Array
			// for each new field
			ranges = new ArrayList<Integer>(); // reset the ranges-array
			// empty search term ==> return an empty StyleRange array
			if (searchTerm.equals("")) {
				return new int[] {};
			}

			// determine all occurrences of the searchText and write the
			// beginning
			// and length of each occurrence into an array
			for (int i = 0; i < content.length(); i++) {
				if (i + searchTerm.length() <= content.length() && content.substring(i, i + searchTerm.length()).equalsIgnoreCase(searchTerm)) {
					// ranges format: n->start of the range, n+1->length of the
					// range
					ranges.add(i);
					ranges.add(searchTerm.length());
				}
			}
			// convert the list into an int[] and make sure that overlapping
			// search term occurrences are are merged
			int[] intRanges = new int[ranges.size()];
			int arrayIndexCounter = 0;
			for (int listIndexCounter = 0; listIndexCounter < ranges.size(); listIndexCounter++) {
				if (listIndexCounter % 2 == 0) {
					if (searchTerm.length() > 1 && listIndexCounter != 0 && ranges.get(listIndexCounter - 2) + ranges.get(listIndexCounter - 1) >= ranges.get(listIndexCounter)) {
						intRanges[arrayIndexCounter - 1] = 0 - ranges.get(listIndexCounter - 2) + ranges.get(listIndexCounter) + ranges.get(++listIndexCounter);
					} else {
						intRanges[arrayIndexCounter++] = ranges.get(listIndexCounter);
					}
				} else {
					intRanges[arrayIndexCounter++] = ranges.get(listIndexCounter);
					styleRange.add(myStyleRange);
				}
			}
			// if there have been any overlappings we need to reduce the size of
			// the array to avoid conflicts in the setStyleRanges method
			int[] intRangesCorrectSize = new int[arrayIndexCounter];
			System.arraycopy(intRanges, 0, intRangesCorrectSize, 0, arrayIndexCounter);

			return intRangesCorrectSize;
		}
	}

	private static class Row {
		private final List<Object> elements = new ArrayList<Object>();

		public void add(Object o) {
			elements.add(o);
		}

		public Object get(int pos) {
			return elements.get(pos);
		}

		public List<Object> getElements() {
			return elements;
		}
	}

	private class Filter extends ViewerFilter {

		private String searchString;

		public void setSearchText(String s) {
			this.searchString = ".*" + s + ".*";
		}

		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (searchString == null || searchString.length() == 0) {
				return true;
			}
			Row p = (Row) element;
			for (Object o : p.getElements()) {
				if (o.toString().matches(searchString)) {
					return true;
				}
			}

			return false;
		}
	}

	private static class QueryResultContentProvider implements IStructuredContentProvider {

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement == null) {
				return new Object[0];
			}
			ResultSet rs = (ResultSet) inputElement;
			List<Row> result = new ArrayList<Row>(rs.getSize());
			ColumnType[] queryColumnTypes = rs.getQueryColumnTypes();
			for (int index = 0; index < rs.getSize(); index++) {
				Row r = new Row();
				result.add(r);
				for (ColumnType columnType : queryColumnTypes) {
					if (columnType.attribute == null) {
						r.add(rs.getUri(index, columnType.alias));
					} else {
						r.add(rs.getAttribute(index, columnType.alias, columnType.attribute));
					}
				}
			}

			return result.toArray(new Row[0]);
		}

	}

	private static abstract class ColumnViewerSorter extends ViewerComparator {
		public static final int ASC = 1;

		public static final int NONE = 0;

		public static final int DESC = -1;

		private int direction = 0;

		private TableViewerColumn column;

		private ColumnViewer viewer;

		private final int pos;

		public ColumnViewerSorter(ColumnViewer viewer, TableViewerColumn column, int pos) {
			this.column = column;
			this.viewer = viewer;
			this.pos = pos;
			this.column.getColumn().addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					if (ColumnViewerSorter.this.viewer.getComparator() != null) {
						if (ColumnViewerSorter.this.viewer.getComparator() == ColumnViewerSorter.this) {
							int tdirection = ColumnViewerSorter.this.direction;

							if (tdirection == ASC) {
								setSorter(ColumnViewerSorter.this, DESC);
							} else if (tdirection == DESC) {
								setSorter(ColumnViewerSorter.this, NONE);
							}
						} else {
							setSorter(ColumnViewerSorter.this, ASC);
						}
					} else {
						setSorter(ColumnViewerSorter.this, ASC);
					}
				}
			});
		}

		public void setSorter(ColumnViewerSorter sorter, int direction) {
			if (direction == NONE) {
				column.getColumn().getParent().setSortColumn(null);
				column.getColumn().getParent().setSortDirection(SWT.NONE);
				viewer.setComparator(null);
			} else {
				column.getColumn().getParent().setSortColumn(column.getColumn());
				sorter.direction = direction;

				if (direction == ASC) {
					column.getColumn().getParent().setSortDirection(SWT.DOWN);
				} else {
					column.getColumn().getParent().setSortDirection(SWT.UP);
				}

				if (viewer.getComparator() == sorter) {
					viewer.refresh();
				} else {
					viewer.setComparator(sorter);
				}

			}
		}

		public int compare(Viewer viewer, Object e1, Object e2) {
			return direction * doCompare(viewer, e1, e2, pos);
		}

		protected abstract int doCompare(Viewer viewer, Object e1, Object e2, int pos);
	}

	private static final CellLabelProvider EMPTY_LABEL_PROVIDER = new CellLabelProvider() {

		public void update(ViewerCell cell) {

		}
	};

	private TableViewer tv;

	private ResourceSet resSet = new ResourceSetImpl();

	private Label statusLabel;

	private Filter filter;

	public QueryResultView() {
	}

	public void createPartControl(Composite parent) {

		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		parent.setLayout(layout);

		Label searchLabel = new Label(parent, SWT.NONE);
		searchLabel.setText("Search: ");
		searchLabel.setLayoutData(new GridData());
		final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
		searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		searchText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(searchText.getText());
				for (QueryResultLabelProvider provider : labelProviders) {
					provider.setSearchText(searchText.getText());
				}
				tv.refresh();
			}

		});

		tv = new TableViewer(parent, SWT.VIRTUAL | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.horizontalSpan = 2;
		tv.getTable().setLayoutData(layoutData);

		Table table = tv.getTable();
		tv.setUseHashlookup(true);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tv.setContentProvider(new QueryResultContentProvider());
		filter = new Filter();
		tv.addFilter(filter);

		statusLabel = new Label(parent, SWT.LEFT | SWT.BORDER);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		statusLabel.setLayoutData(layoutData);
	}

	public void dispose() {
	}

	List<TableViewerColumn> cols = new ArrayList<TableViewerColumn>();

	private List<QueryResultLabelProvider> labelProviders = new ArrayList<QueryResultLabelProvider>();

	public void setInput(final ResultSet rs, long duration) {
		for (TableViewerColumn col : cols) {
			col.getColumn().setText("");
			col.setLabelProvider(EMPTY_LABEL_PROVIDER);
		}
		labelProviders.clear();
		statusLabel.setText("");
		tv.setInput(null);
		if (rs != null) {
			Table table = tv.getTable();
			ColumnType[] queryColumnTypes = rs.getQueryColumnTypes();
			for (int i = 0; i < queryColumnTypes.length; i++) {
				ColumnType colType = queryColumnTypes[i];
				TableViewerColumn treeColumn;
				if (cols.size() == i) {
					treeColumn = new TableViewerColumn(tv, SWT.LEFT);
					cols.add(treeColumn);
				} else {
					treeColumn = cols.get(i);
				}
				QueryResultLabelProvider labelProvider = new QueryResultLabelProvider(i);
				labelProviders.add(labelProvider);
				treeColumn.setLabelProvider(labelProvider);
				String typeUri = colType.typeName;
				EObject eObject;
				if (typeUri.equals("STRING")) {
					eObject = EcorePackage.Literals.ESTRING;
				} else if (typeUri.equals("BOOLEAN")) {
					eObject = EcorePackage.Literals.EBOOLEAN;
				} else if (typeUri.equals("INTEGER")) {
					eObject = EcorePackage.Literals.EINT;
				} else if (typeUri.equals("LONG")) {
					eObject = EcorePackage.Literals.ELONG;
				} else if (typeUri.equals("DOUBLE")) {
					eObject = EcorePackage.Literals.EDOUBLE;
				} else if (typeUri.equals("FLOAT")) {
					eObject = EcorePackage.Literals.EFLOAT;
				} else {
					eObject = resSet.getEObject(URI.createURI(typeUri), true);
				}
				String string = colType.alias;
				if (colType.attribute != null) {
					string += "." + colType.attribute;
				}
				if (eObject instanceof EClassifier) {
					EClassifier classifier = (EClassifier) eObject;
					string += " (" + classifier.getEPackage().getName() + "::" + classifier.getName() + ")";
				}
				treeColumn.getColumn().setText(string);

				ColumnViewerSorter cSorter = new ColumnViewerSorter(tv, treeColumn, i) {

					protected int doCompare(Viewer viewer, Object e1, Object e2, int pos) {
						Row r1 = (Row) e1;
						Row r2 = (Row) e2;

						return r1.get(pos).toString().compareToIgnoreCase(r2.get(pos).toString());
					}

				};

				if (i == 0) {
					cSorter.setSorter(cSorter, ColumnViewerSorter.ASC);
				}

			}

			tv.setInput(rs);
			tv.setItemCount(rs.getSize());

			for (int i = 0, n = table.getColumnCount(); i < n; i++) {
				TableColumn column = table.getColumn(i);
				if (column.getText().equals("")) {
					column.setWidth(0);
				} else {
					column.pack();
				}
			}
			statusLabel.setText("Result size: " + rs.getSize() + " - query time: " + duration + "ms");
		}

	}
	
	public void setFocus() {
		tv.getTable().setFocus();
	}
}
