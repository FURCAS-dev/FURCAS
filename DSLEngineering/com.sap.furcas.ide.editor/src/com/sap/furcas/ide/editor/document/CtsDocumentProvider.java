package com.sap.furcas.ide.editor.document;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl.WorkbenchHelper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.CtsAnnotationModel;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;

public class CtsDocumentProvider extends AbstractDocumentProvider {

    private final EditingDomain editingDomain;
    private final ConcreteSyntax syntax;
    private final PartitionAssignmentHandler partitionHandler;

    public CtsDocumentProvider(ConcreteSyntax syntax, EditingDomain editingDomain, PartitionAssignmentHandler partitionHandler) {
        super();
        this.syntax = syntax;
        this.editingDomain = editingDomain;
        this.partitionHandler = partitionHandler;
    }

    @Override
    public boolean canSaveDocument(Object element) {
        ElementInfo info = getElementInfo(element);
        if (info != null) {
            CtsDocument ctsDocument = ((CtsDocument) info.fDocument);
            return ctsDocument.isCompletelyItitialized() &&
                ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
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
            createBackup((CtsDocument) document);
            
            //inform about the upcoming content change
            fireElementStateChanging(element);

            // Save only resources that have actually changed.
            saveResourcesIfDirty();
            ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();

            fireElementDirtyStateChanged(element, /*isDirty*/ false);
        } catch (IOException e) {
            throw new CoreException(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, e.getMessage(), e));
        }
    }

    private void createBackup(CtsDocument ctsDocument) throws IOException {
        TextBlock rootBlock = (TextBlock) TbUtil.getNewestVersion(ctsDocument.getRootBlock());
        URI targetURI = partitionHandler.getDefaultPartition().getURI().appendFileExtension("txt");
        OutputStream stream = WorkbenchHelper.createPlatformResourceOutputStream(targetURI.toPlatformString(true), /*options*/ null);
        PrintStream backup = new PrintStream(stream);
        backup.print(rootBlock.getCachedString());
        backup.close();
    }

    private void saveResourcesIfDirty() throws IOException {
        final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
        saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
        partitionHandler.saveAllPartitions(saveOptions);
    }

    @Override
    protected void disposeElementInfo(Object element, ElementInfo info) {
        // FIXME do we have to unload resources or something like that?
    }

    @Override
    protected IAnnotationModel createAnnotationModel(Object element) {
        ModelEditorInput modelEditorInput = (ModelEditorInput) element;
        return new CtsAnnotationModel(modelEditorInput.getRootObject());
    }

    @Override
    protected IDocument createDocument(Object element) {
        return new CtsDocument(((ModelEditorInput) element), syntax, editingDomain);
    }

    @Override
    protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
        return null;
    }

    @Override
    public CtsDocument getDocument(Object element) {
        return (CtsDocument) super.getDocument(element);
    }

}
