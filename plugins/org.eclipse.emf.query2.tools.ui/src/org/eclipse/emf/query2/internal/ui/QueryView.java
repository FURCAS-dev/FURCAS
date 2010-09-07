package org.eclipse.emf.query2.internal.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.emf.query2.syntax.query.FromEntry;
import org.eclipse.emf.query2.syntax.query.MQLquery;
import org.eclipse.emf.query2.syntax.query.QueryFactory;
import org.eclipse.emf.query2.syntax.query.QueryPackage;
import org.eclipse.emf.query2.syntax.query.SelectEntry;
import org.eclipse.emf.query2.syntax.transformation.QueryTransformer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class QueryView extends ViewPart implements ISelectionProvider {

	private TreeViewer tv;
	private Image queryImage;
	private Image fileImage;
	private MQLquery query;

	private static abstract class QueryElement {
		private String name;

		public QueryElement(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	private static class QueryContainer extends QueryElement {


		private URI resourceUri;

		public QueryContainer(String name, URI uri) {
			super(name);
			this.resourceUri = uri;
		}

		List<QueryItem> items = new ArrayList<QueryItem>();

		public void addChild(QueryItem item) {
			item.container = this;
			items.add(item);
		}

		public QueryItem[] items() {
			return items.toArray(new QueryItem[0]);
		}
	}

	public static class QueryItem extends QueryElement {
		private final URI uri;

		public QueryItem(String name, URI uri) {
			super(name);
			this.uri = uri;
		}

		QueryContainer container;

		public QueryContainer getContainer() {
			return container;
		}
		
		public URI getUri() {
			return uri;
		}
	}

	public class QueryViewContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((QueryContainer) parentElement).items();
		}

		@Override
		public Object getParent(Object element) {
			return ((QueryItem) element).getContainer();
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof QueryContainer;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return ((Collection<QueryContainer>) inputElement).toArray(new QueryContainer[0]);
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	public class QueryViewLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			return ((QueryElement) element).getName();
		}
		
		@Override
		public Image getImage(Object element) {
			if (element instanceof QueryItem) {
				return queryImage;
				
			}
			return fileImage;
		}
	}

	public QueryView() {
		queryImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/magnifying-glass.gif").createImage();
		fileImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/file.gif").createImage();
		query = QueryFactory.eINSTANCE.createMQLquery();
		FromEntry fromEntry = QueryFactory.eINSTANCE.createFromEntry();
		query.getFromEntries().add(fromEntry);
		fromEntry.setAlias("query");
		fromEntry.setType(QueryPackage.Literals.NAMED_QUERY);
		SelectEntry selectEntry = QueryFactory.eINSTANCE.createSelectEntry();
		selectEntry.setSelect(fromEntry);
		query.getSelectEntries().add(selectEntry);
		selectEntry = QueryFactory.eINSTANCE.createSelectEntry();
		selectEntry.setSelect(fromEntry);
		selectEntry.setAttribute(QueryPackage.Literals.NAMED_QUERY__NAME);
		query.getSelectEntries().add(selectEntry);
	}

	@Override
	public void createPartControl(Composite parent) {
		tv = new TreeViewer(parent);
		tv.setLabelProvider(new QueryViewLabelProvider());
		tv.setContentProvider(new QueryViewContentProvider());
		tv.setInput(doQuery(false));
		
		// This is new code
		// First we create a menu Manager
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(tv.getTree());
		// Set the MenuManager
		tv.getTree().setMenu(menu);
		getSite().registerContextMenu(menuManager, tv);
		// Make the selection available
		getSite().setSelectionProvider(this);

	}

	private Collection<QueryContainer> doQuery(boolean includeDirty) {
		final ResourceSet[] rs = new ResourceSet[1];
		if (!includeDirty){
		rs[0] = new ResourceSetImpl();
		}else {
			IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if (activeEditor instanceof XtextEditor) {
				XtextEditor xtextEditor = (XtextEditor) activeEditor;
				xtextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {

					@Override
					public void process(XtextResource state) throws Exception {
						rs[0] = state.getResourceSet();
					}
					
				});
				
			}
		}
		Query transform = QueryTransformer.transform(query);
		Map<URI, QueryContainer> result = new HashMap<URI, QueryContainer>();
		final ResultSet resultSet = new QueryProcessorImpl(IndexFactory.getInstance()).execute(transform,
				getQueryContext(rs[0]));
		
		for (int i = 0; i < resultSet.getSize(); i++) {
			QueryContainer container;
			URI uri = resultSet.getUri(i, "query");
			URI trimFragment = uri.trimFragment();
			if ((container =result.get(trimFragment))==null){
				container = new QueryContainer(uri.lastSegment(), trimFragment);
				result.put(trimFragment, container);
			}
			String name = (String) resultSet.getAttribute(i, "query", "name");
			container.addChild(new QueryItem(name, uri));
		}
		
		return result.values();
	}
	
	public void refresh(boolean includeDirty) {
		tv.setInput(doQuery(includeDirty));
		tv.expandAll();
	}
	
	private QueryContext getQueryContext(final ResourceSet rs) {
		return new QueryContext() {

			@Override
			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {

					@Override
					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
							result.add(desc.getURI());
						}
					}

				});
				return result.toArray(new URI[0]);
			}

			@Override
			public ResourceSet getResourceSet() {
				return rs;
			}

		};
	}

	@Override
	public void setFocus() {
		tv.getTree().setFocus();
	}
	
	@Override
	public void dispose() {
		queryImage.dispose();
		fileImage.dispose();
		super.dispose();
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		tv.addSelectionChangedListener(listener);
	}

	@Override
	public ISelection getSelection() {
		QueryElement element = (QueryElement) ((IStructuredSelection) tv.getSelection()).getFirstElement();
			if (element instanceof QueryItem) {
				QueryItem item = (QueryItem) element;
				return new StructuredSelection(item.uri);
			}
		return new StructuredSelection();
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		tv.removeSelectionChangedListener(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		
	}

}
