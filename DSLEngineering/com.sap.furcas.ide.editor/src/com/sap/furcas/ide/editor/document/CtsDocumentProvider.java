package com.sap.furcas.ide.editor.document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.CtsAnnotationModel;
import com.sap.furcas.ide.editor.commands.CleanUpTextBlocksCommand;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;

public class CtsDocumentProvider extends AbstractDocumentProvider {

    private final EditingDomain editingDomain;

    public CtsDocumentProvider(EditingDomain editingDomain) {
        super();
        this.editingDomain = editingDomain;
    }

    @Override
    public boolean canSaveDocument(Object element) {
        ElementInfo info = getElementInfo(element);
        if (info != null) {
            CtsDocument ctsDocument = ((CtsDocument) info.fDocument);
            if (ctsDocument.isCompletelyItitialized()) {
                return ctsDocument.getRootBlock().eResource().isModified();
            }
        }
        return false;
    }


    @Override
    public boolean isModifiable(Object element) {
        return true;
    }

    @Override
    public boolean isReadOnly(Object element) {
        return false;
    }

    @Override
    public void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
        try {
            CtsDocument ctsDocument = (CtsDocument) document;
            if (TbVersionUtil.getOtherVersion(ctsDocument.getRootBlock(), Version.CURRENT) != null) {
                // only clean up if a current version exists, as this is
                // only the case if the rootBlock was at least lexable
                monitor.beginTask("Cleaning up textblocks.", 100);
                CleanUpTextBlocksCommand cleanUpCommand = new CleanUpTextBlocksCommand(ctsDocument.getRootBlock());
                getEditingDomain().getCommandStack().execute(cleanUpCommand);
                TextBlock newRoot = cleanUpCommand.getNewRootBlock();
                ctsDocument.setRootBlock(newRoot);
                monitor.worked(50);
                ctsDocument.reduceToMinimalState();
                monitor.worked(50);
            }
            monitor.beginTask("Saving connection.", 100);

            //inform about the upcoming content change
            fireElementStateChanging(element);

            // Save only resources that have actually changed.
            //
            final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
            saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
            ctsDocument.getPartitionHandler().saveAllPartitions(saveOptions);
            ((BasicCommandStack) getEditingDomain().getCommandStack()).saveIsDone();

            fireElementDirtyStateChanged(element, false);
            monitor.done();
        } catch (IOException e) {
            throw new CoreException(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, e.getMessage(), e));
        }
    }

    @Override
    protected void disposeElementInfo(Object element, ElementInfo info) {
        CtsDocument ctsDocument = ((CtsDocument) info.fDocument);
        TextBlock newRoot = (TextBlock) TbChangeUtil.cleanUp(ctsDocument.getRootBlock());
        ctsDocument.setRootBlock(newRoot);
        // FIXME revert changes to resource
    }

    @Override
    protected IAnnotationModel createAnnotationModel(Object element) {
        ModelEditorInput modelEditorInput = (ModelEditorInput) element;
        return new CtsAnnotationModel(modelEditorInput.getEObject());
    }

    @Override
    protected IDocument createDocument(Object element) {
        return new CtsDocument(((ModelEditorInput) element),getEditingDomain());
    }

    @Override
    protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
        return null;
    }

    public EditingDomain getEditingDomain() {
        return editingDomain;
    }
    
    @Override
    public CtsDocument getDocument(Object element) {
        return (CtsDocument) super.getDocument(element);
    }

}
