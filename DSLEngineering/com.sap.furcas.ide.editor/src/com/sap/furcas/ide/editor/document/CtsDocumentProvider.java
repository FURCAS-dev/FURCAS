package com.sap.furcas.ide.editor.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.imp.services.FurcasSourcePositionLocator;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
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

    /**
     * EMF Validation adds error markes to resources. These markers don't have a valid
     * position. This class reads these markers and sets a valid possition according
     * to the content of the document attached to the annotation model.
     * 
     * @author Stephan Erb
     *
     */
    private final class TextAwareResourceMarkerAnnotationModel extends ResourceMarkerAnnotationModel {

        private TextAwareResourceMarkerAnnotationModel(IResource resource) {
            super(resource);
        }

        @Override
        protected Position createPositionFromMarker(IMarker marker) {
            Position position = super.createPositionFromMarker(marker);
            if (position != null) {
                return position;
            }
            try {
                if (!marker.getType().equals(EValidator.MARKER)) {
                    return null; // not a marker we do care about.
                }
            } catch (CoreException e) {
                // happens if the marker we try to receive is invalid
                return null;
            }
            
            final Position[] positions = new Position[1];
            final FurcasSourcePositionLocator locator = new FurcasSourcePositionLocator();
            final String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
            
            if (uriAttribute != null) {
                try {
                    editingDomain.runExclusive(new Runnable() {
                        @Override
                        public void run() {
                            EObject modelElementWithMarker = editingDomain.getResourceSet().getEObject(URI.createURI(uriAttribute), true);
                            if (modelElementWithMarker != null) {
                                TextBlock rootBlock = ((CtsDocument) fDocument).getRootBlock();
                                TextBlock tb = locator.findTextBlockOf(rootBlock, modelElementWithMarker,
                                        editingDomain.getResourceSet());
                                if (tb != null) {
                                    int offset = locator.getStartOffset(tb);
                                    int length = locator.getLength(tb);
                                    positions[0] = new Position(offset, length);
                                } else {
                                    // element not represented in this view
                                }
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    return null;
                }
            } 
            return positions[0]; // the one calculated or null
        }
    }

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
        } catch (Exception e) {
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
        
        return new TextAwareResourceMarkerAnnotationModel(WorkspaceSynchronizer.getFile(
                editorInput.getRootObject().eResource()));
    }
    
    @Override
    protected ISchedulingRule getResetRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : getWorkspaceResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
            }
        }
        return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
    }

    @Override
    protected ISchedulingRule getSynchronizeRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : getWorkspaceResources()) {
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
        for (Resource resource : getWorkspaceResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(file);
            }
        }
        return ResourcesPlugin.getWorkspace().getRuleFactory().validateEditRule(rules.toArray(new IFile[rules.size()]));
    }
    
    @Override
    protected ISchedulingRule getSaveRule(Object element) {
        Collection<ISchedulingRule> rules = new ArrayList<ISchedulingRule>();
        for (Resource resource : getWorkspaceResources()) {
            IFile file = WorkspaceSynchronizer.getFile(resource);
            if (file != null) {
                rules.add(computeSchedulingRule(file));
            }
        }
        return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
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
    
    /**
     * Filter plugin resources. Those cannot be changed and thus don't need and synchronization.
     */
    private Collection<Resource> getWorkspaceResources() {
        ArrayList<Resource> resources = new ArrayList<Resource>();
        for (Resource r : editingDomain.getResourceSet().getResources()) {
            if (!r.getURI().isPlatformPlugin()) {
                resources.add(r);
            }
        }
        return resources;
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
    
    /**
     * @see ModelEditorInput
     */
    public void consumeModelEditorInput() {
        editorInput.consume();
    }
    
}
