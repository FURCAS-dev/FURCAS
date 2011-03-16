package org.eclipse.emf.query2.tools.ui.internal.handlers;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.syntax.query.NamedQuery;
import org.eclipse.emf.query2.syntax.transformation.QueryTransformer;
import org.eclipse.emf.query2.tools.ui.Messages;
import org.eclipse.emf.query2.tools.ui.QueryResultView;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class RunQuery extends org.eclipse.core.commands.AbstractHandler {

	public Object execute(final ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection == null) {
			return null;
		}
		if (selection instanceof ITextSelection) {
			XtextEditor editor = (XtextEditor) HandlerUtil.getActiveEditor(event);
			final ITextSelection textSel = (ITextSelection) editor.getSelectionProvider().getSelection();

			editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {

				public void process(XtextResource res) throws Exception {
					IParseResult parseResult = res.getParseResult();
					if (parseResult != null) {
						CompositeNode rootNode = parseResult.getRootNode();
						AbstractNode currentNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, textSel.getOffset());
						EObject astElementForRootNode = NodeUtil.getNearestSemanticObject(currentNode);
						NamedQuery nq = null;
						while (astElementForRootNode != null) {
							if (astElementForRootNode instanceof NamedQuery) {
								nq = (NamedQuery) astElementForRootNode;
								break;
							}
							astElementForRootNode = astElementForRootNode.eContainer();
						}
						if (nq != null) {
							doQuery(event, new ResourceSetImpl(), nq);
						}
					}
				}
			});
		}

		else if (selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object element = strucSelection.getFirstElement();
			final URI uri = (URI) element;
			ResourceSet rs = new ResourceSetImpl();
			String parameter = event.getParameter("runDirty"); //$NON-NLS-1$
			if (Boolean.valueOf(parameter)) {
				IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
				if (editorReferences != null) {
					for (int i = 0; i < editorReferences.length; i++) {
						IEditorPart editor = editorReferences[i].getEditor(false);
						if (editor instanceof IEditingDomainProvider) {
							IEditingDomainProvider provider = (IEditingDomainProvider) editor;
							rs = provider.getEditingDomain().getResourceSet();
						}
					}
				}
			}
			if (element instanceof URI) {
				final NamedQuery query = (NamedQuery) rs.getEObject(uri, true);
				doQuery(event, rs, query);

			}
		}
		return null;
	}

	private void doQuery(ExecutionEvent event, final ResourceSet rs, final NamedQuery query) {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(HandlerUtil.getActiveShell(event).getShell());
		try {
			//Clears the previous result table view synchronously before executing the next query.
			if(query!=null){
				class ResetTable implements Runnable {
					public void run() {
						QueryResultView queryResultView;
						try {
							queryResultView = (QueryResultView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
									"org.eclipse.emf.query2.syntax.tools.ui.queryresultview"); //$NON-NLS-1$
							queryResultView.resetTableView();
						} catch (PartInitException e) {
							e.printStackTrace();
						}
					}
				}
				ResetTable reset = new ResetTable();
				Display.getDefault().syncExec(reset);
			}
			dialog.run(true, true, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.beginTask(Messages.Query2StringSyntaxToolsUI_RunQuery_RunningQuery, IProgressMonitor.UNKNOWN);
					// converts the XText Query into AST
					Query transform = QueryTransformer.transform(query.getQuery());
					long start = System.currentTimeMillis();
					Index indexFactory = IndexFactory.getInstance();
					QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(indexFactory);
					QueryContext queryContext = getQueryContext(rs);
					final ResultSet result = queryProcessor.execute(transform, queryContext);
					final long duration = System.currentTimeMillis() - start;
					monitor.done();
					setInputToView(result, duration, rs);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setInputToView(final ResultSet result, final long duration, ResourceSet rs) {
		UIJob uiJob = new UIJob(Messages.Query2StringSyntaxToolsUI_RunQuery_UpdateQueryView) {

			public IStatus runInUIThread(IProgressMonitor monitor) {
				monitor.beginTask(Messages.Query2StringSyntaxToolsUI_RunQuery_OpeningResultView, IProgressMonitor.UNKNOWN);
				QueryResultView queryResultView;
				try {
					queryResultView = (QueryResultView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
							"org.eclipse.emf.query2.syntax.tools.ui.queryresultview"); //$NON-NLS-1$
					queryResultView.setInput(result, duration);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		uiJob.setUser(true);
		uiJob.schedule();
	}

	private QueryContext getQueryContext(final ResourceSet rs) {
		return new QueryContext() {

			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {

					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
							result.add(desc.getURI());
						}
					}

				});
				return result.toArray(new URI[0]);
			}

			public ResourceSet getResourceSet() {
				return rs;
			}

		};
	}

}
