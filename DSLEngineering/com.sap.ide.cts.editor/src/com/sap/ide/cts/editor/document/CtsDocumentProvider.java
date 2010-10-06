package com.sap.ide.cts.editor.document;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.TextBlock;
=======
import textblocks.TextBlock;
import textblocks.VersionEnum;

import com.sap.furcas.textual.textblocks.TbChangeUtil;
import com.sap.furcas.textual.textblocks.TbVersionUtil;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698
import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.CtsAnnotationModel;
import com.sap.ide.cts.editor.FurcasDocumentSetupParticpant;
import com.sap.ide.cts.editor.commands.CleanUpTextBlocksCommand;
<<<<<<< HEAD
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbVersionUtil;
import com.sun.corba.se.pept.transport.Connection;
=======
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class CtsDocumentProvider extends AbstractDocumentProvider {

	private final FurcasDocumentSetupParticpant fDocumentSetupParticipant;

	public CtsDocumentProvider(FurcasDocumentSetupParticpant documentSetupParticipant) {
		super();
		fDocumentSetupParticipant = documentSetupParticipant;
	}

	@Override
	public boolean canSaveDocument(Object element) {
		if (element instanceof ModelEditorInput) {
			ElementInfo info = getElementInfo(element);
			if(info != null) {
				CtsDocument ctsDocument = ((CtsDocument) info.fDocument);
				if(ctsDocument.isCompletelyItitialized()) {
					return ((EObject) ctsDocument.getRootBlock())
						.get___Connection().isDirty();
				}
			}
		}
		return false;
	}

	/*
	 * @see IDocumentProviderExtension#isModifiable(Object)
	 * @since 2.0
	 */
	@Override
	public boolean isModifiable(Object element) {
		return true;
	}

	@Override
	public boolean isReadOnly(Object element) {
        return false;
    }
	
	// @Override
	// public IDocument getDocument(Object element) {
	// if (element instanceof ModelEditorInput) {
	// ModelEditorInput mei = (ModelEditorInput) element;
	// ElementInfo info = handledElements.get(mei);
	// return info.fDocument;
	// }
	// return null;
	// }

	@Override
	public void doSaveDocument(IProgressMonitor monitor, Object element,
			IDocument document, boolean overwrite) throws CoreException {
		// textDocumentProvider.saveDocument(monitor, element, document,
		// overwrite);
		if (element instanceof ModelEditorInput) {
			ModelEditorInput mei = (ModelEditorInput) element;
			ElementInfo info = getElementInfo(element);
			try {
				IProject project = (IProject) mei.getAdapter(IProject.class);
				CtsDocument ctsDocument = ((CtsDocument) info.fDocument);
				Connection co = ModelAdapterUI.getInstance().getConnection(
						ctsDocument.getRootObject());
				if(TbVersionUtil.getOtherVersion(ctsDocument.getRootBlock(), VersionEnum.CURRENT) != null) {
					//only clean up if a current version exists, as this is only the case if
					//the rootBlock was at least lexable
				        monitor.beginTask("Cleaning up textblocks.", 100);
					CleanUpTextBlocksCommand cleanUpCommand = new CleanUpTextBlocksCommand(ctsDocument.getRootBlock());
					co.getCommandStack().execute(cleanUpCommand);
					TextBlock newRoot = cleanUpCommand.getNewRootBlock();
					ctsDocument.setRootBlock(newRoot);
					monitor.worked(50);
					ctsDocument.reduceToMinimalState();
					monitor.worked(50);
				}
				monitor.beginTask("Saving connection.", 100);
				ModelManagerUI.getConnectionManagerUI().save(co, project,
						monitor);
				monitor.worked(100);
			} catch (NullPartitionNotEmptyException e) {
				throw new CoreException(new Status(Status.ERROR,
						CtsActivator.PLUGIN_ID, e.getLocalizedMessage(), e));
			} catch (ReferencedTransientElementsException e) {
				throw new CoreException(new Status(Status.ERROR,
						CtsActivator.PLUGIN_ID, e.getLocalizedMessage(), e));
			}
		}
	}

	// /**
	// * Used to count clients that use a document for a specific Element. Also
	// * used to Cache the corresponding root textblock.
	// *
	// * @author C5106462
	// *
	// */
	// protected class CtsElementInfo extends ElementInfo {
	// public CtsElementInfo(IDocument document, IAnnotationModel model) {
	// super(document, model);
	// // TODO Auto-generated constructor stub
	// }
	//
	// public RefBaseObject fRefObject;
	// public TextBlock fTextBlock;
	// }

	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if (element instanceof ModelEditorInput) {
			CtsDocument ctsDocument = ((CtsDocument) info.fDocument);
			TextBlock newRoot = (TextBlock) TbChangeUtil.cleanUp(ctsDocument.getRootBlock());
			ctsDocument.setRootBlock(newRoot);
			Connection co = ModelAdapterUI.getInstance().getConnection(
					ctsDocument.getRootObject());
			co.revert();
		}
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) {
		if(element instanceof ModelEditorInput) {
			ModelEditorInput modelEditorInput = (ModelEditorInput)element;
			return new CtsAnnotationModel(modelEditorInput.getRefObject());
		}
		return null;
	}

	@Override
	protected IDocument createDocument(Object element) {
		CtsDocument document = createDocumentFactoryMethod(element);
		if (document != null) {
			IDocumentExtension3 extension= document;
			if (extension.getDocumentPartitioner(FurcasDocumentSetupParticpant.PARTITIONING) == null) {
			    fDocumentSetupParticipant.setup(document);
			}
		}
		return document;
	}
	
	/**
	 * Factory method to be used in subclasses (specially in tests)
	 */
	protected CtsDocument createDocumentFactoryMethod(Object element) {
		CtsDocument document = new CtsDocument(((ModelEditorInput) element));
		return document;
	}

	@Override
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
