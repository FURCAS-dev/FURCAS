package com.sap.furcas.ide.editor.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;

/**
 * A factory for {@link CtsDocument CtsDocuments}.
 * It is furthermore responsible to save the content of documents to disk.
 * Such workspace access are secured using the correct set of 
 * {@link ISchedulingRule scheduling rules}.
 * 
 * @author Stephan Erb
 *
 */
@SuppressWarnings("restriction")
public class CtsDocumentProvider extends AbstractDocumentProvider {

    private final IRunnableContext operationRunner = new WorkspaceOperationRunner();
    private final TransactionalEditingDomain editingDomain;
    private final PartitionAssignmentHandler partitionHandler;
    private final ModelEditorInput editorInput;

    public CtsDocumentProvider(ModelEditorInput editorInput, TransactionalEditingDomain editingDomain, PartitionAssignmentHandler partitionHandler) {
        super();
        this.editorInput = editorInput;
        this.editingDomain = editingDomain;
        this.partitionHandler = partitionHandler;
    }

    @Override
    public boolean canSaveDocument(Object element) {
        ElementInfo info = getElementInfo(element);
        if (info == null) {
            return false;
        }
        return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
    }

    @Override
    public void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
        try {
            //inform about the upcoming content change
            fireElementStateChanging(element);

            editingDomain.runExclusive(new Runnable() {
                @Override
                public void run() {
                    try {
                        saveResourcesIfDirty();
                    } catch (IOException e) {
                        CtsActivator.logger.logError("Failed to save resources", e);
                        throw new RuntimeException(e);
                    }
                }
            });
            ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();

            fireElementDirtyStateChanged(element, /*isDirty*/false);
        } catch (Exception e) {
            fireElementStateChangeFailed(element);
            throw new CoreException(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, e.getMessage(), e));
        }
    }

    private void saveResourcesIfDirty() throws IOException {
        final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
        saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
        partitionHandler.saveAllPartitions(saveOptions);
    }

    @Override
    protected IDocument createDocument(Object element) {
        assert element.equals(editorInput.asLightWeightEditorInput());
        
        return new CtsDocument(editorInput);
    }

    @Override
    public CtsDocument getDocument(Object element) {
        return (CtsDocument) super.getDocument(element);
    }

    @Override
    protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
        assert element.equals(editorInput.asLightWeightEditorInput());
        
        return new ResourceMarkerAnnotationModel(WorkspaceSynchronizer.getFile(
                editorInput.getRootObject().eResource()));
    }
    
    @Override
    protected ISchedulingRule getResetRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : editingDomain.getResourceSet().getResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
            }
        }
        return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
    }

    @Override
    protected ISchedulingRule getSaveRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : editingDomain.getResourceSet().getResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(computeSchedulingRule(file));
            }
        }
        return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
    }

    @Override
    protected ISchedulingRule getSynchronizeRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : editingDomain.getResourceSet().getResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().refreshRule(file));
            }
        }
        return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
    }

    @Override
    protected ISchedulingRule getValidateStateRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : editingDomain.getResourceSet().getResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(file);
            }
        }
        return ResourcesPlugin.getWorkspace().getRuleFactory().validateEditRule(rules.toArray(new IFile[rules.size()]));
    }

    private ISchedulingRule computeSchedulingRule(IResource toCreateOrModify) {
        if (toCreateOrModify.exists()) {
            return ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(toCreateOrModify);
        }
        IResource parent = toCreateOrModify;
        do {
            toCreateOrModify = parent;
            parent = toCreateOrModify.getParent();
        } while (parent != null && !parent.exists());

        return ResourcesPlugin.getWorkspace().getRuleFactory().createRule(toCreateOrModify);
    }
    
    @Override
    protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
        return operationRunner;
    }
    
    @Override
    public boolean isReadOnly(Object element) {
        return false;
    }
    
    @Override
    public boolean isModifiable(Object element) {
        return true;
    }
    
}
