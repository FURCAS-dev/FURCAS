package com.sap.ide.cts.editor.document;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.PartitionHandling;
import tcs.Template;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.FurcasDocumentSetupParticpant;
import com.sap.ide.cts.editor.recovery.ModelEditorInputRecoveryStrategy;
import com.sap.ide.cts.parser.incremental.DefaultPartitionAssignmentHandlerImpl;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;
import com.sap.ide.cts.parser.incremental.PartitionHandlingWithRefObject;
import com.sap.ide.cts.parser.incremental.TextBlockMappingBrokenException;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.observer.GlobalDelayedReferenceResolver;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;
import com.sap.tc.moin.textual.moinadapter.adapter.MoinHelper;

/**
 * A document implementation that is responsible for presenting a text blocks
 * model as an eclipse document to work on.
 * 
 * @author C5106462
 * 
 */
public class CtsDocument extends AbstractDocument {

	private static final String DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED = "Document was not completely initialized. Call completeInit() to finish the initialization";
	private RefBaseObject rootObject;
	private TextBlock rootBlock;
	protected final ModelEditorInput modelEditorInput;

	private boolean completelyItitialized = false;
	private FurcasDocumentSetupParticpant furcasDocumentSetupParticpant;
	private ConcreteSyntax syntax;

	/**
	 * Creates a new empty document.
	 */
	public CtsDocument(ModelEditorInput modelEditorInput) {
		super();
		this.modelEditorInput = modelEditorInput;
		completeInitialization();
	}

	/**
	 * The document will be usable and completely initialized after this method
	 * was called. A precondition for a call to this method is that
	 * {@link #modelEditorInput} can resolve the contained model element, which
	 * itself requires a completely initialized connection.
	 * 
	 * @param concreteSyntax
	 * @param rootTemplate
	 * @param parserFactory
	 * @param recoveryStrategy
	 * @param observableInjectingParser
	 * @param monitor
	 * 
	 * @param grammarBasedEditor
	 */
	public void completeInit(
			ConcreteSyntax concreteSyntax,
			ClassTemplate rootTemplate,
			ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			ModelEditorInputRecoveryStrategy recoveryStrategy,
			ObservableInjectingParser observableInjectingParser,
			IProgressMonitor monitor) {

		syntax = concreteSyntax;
		GlobalDelayedReferenceResolver.getInstance();
		GlobalDelayedReferenceResolver.getInstance()
				.registerReferenceForIncrementalEvaluation(
						syntax,
						syntax.get___Connection(),
						MoinHelper.getOutermostPackageThroughClusteredImports(
								syntax.get___Connection(), modelEditorInput
										.getRefObject()),
						observableInjectingParser,
						parserFactory.getRuleNameFinder(), monitor);

		RefObject inputObject = (RefObject) modelEditorInput.getRefObject();
		if (inputObject instanceof TextBlock) {
			if (TbUtil.isTextBlockOfType(rootTemplate, (TextBlock) inputObject)) {
				rootBlock = (TextBlock) inputObject;
				if (rootBlock.getCorrespondingModelElements().size() > 0) {
					rootObject = rootBlock.getCorrespondingModelElements()
							.iterator().next();
				}
			}
		} else {
			rootObject = inputObject;
			rootBlock = determineRootBlockForRootObject(concreteSyntax,
					rootTemplate, parserFactory, recoveryStrategy, inputObject);
		}

		if (rootBlock == null) {
			MessageDialog
					.openError(CtsActivator.getDefault().getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
							"Initialization Failed",
							"Failed to initialize document. Consult the error log for further information!");
			return;
		}

		Connection con = rootBlock.get___Connection();
		RefPackage metamodelPackage = parserFactory.getMetamodelPackage(con);
		TextBlocksModelStore textBlocksModelStore = new TextBlocksModelStore(
				rootBlock, new MOINModelAdapter(metamodelPackage, con, null,
						null));
		setTextStore(textBlocksModelStore);
		setLineTracker(new DefaultLineTracker());

		// set initialized to true before the call to the document setup
		// participant as it will probably do operations on the initialized
		// document
		completelyItitialized = true;
		furcasDocumentSetupParticpant.setupCallback(this);

		// synchronize all tokens with values from model
		textBlocksModelStore.expandToEditableVersion();
		getTracker().set(rootBlock.getCachedString());

		// enable usage of cached string for get() operations as it is faster.
		((TextBlocksModelStore) getStore()).getModel().setUsecache(true);
	}

	/**
	 * Get a corresponding root TextBlock for the given rootObject. If no
	 * TextBlock does exist yet, a new one is created.
	 * 
	 * @param concreteSyntax
	 * @param rootTemplate
	 * @param parserFactory
	 * @param recoveryStrategy
	 * @param inputObject
	 * @return
	 */
	private TextBlock determineRootBlockForRootObject(
			ConcreteSyntax concreteSyntax,
			ClassTemplate rootTemplate,
			ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			ModelEditorInputRecoveryStrategy recoveryStrategy,
			RefObject inputObject) {

		Connection con = rootObject.get___Connection();
		TextblocksPackage tbPackage = con
				.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
		TextBlock rootBlock = null;
		try {
			rootBlock = TbModelInitializationUtil.getRootBlockForRootObject(
					inputObject, tbPackage, rootTemplate);
		} catch (TextBlockMappingBrokenException e) {
			TextBlock blockInError = e.getBlock();
			rootBlock = recoveryStrategy.recoverBrokenTextBlockMapping(
					inputObject, blockInError, rootTemplate);
		}

		if (rootBlock == null) {
			// no root node found, so create a new one
			rootBlock = TbModelInitializationUtil.initilizeTextBlocksFromModel(
					inputObject, tbPackage, concreteSyntax, con, parserFactory);

			if (completelyItitialized) {

			}
			
			DefaultPartitionAssignmentHandlerImpl partitionHandler = new DefaultPartitionAssignmentHandlerImpl();
			partitionHandler.SetMainPartition_And_MainContent(concreteSyntax,
					con, inputObject.get___Partition());
			PartitionHandlingWithRefObject partWithRefObject =  new PartitionHandlingWithRefObject(null, (RefObject) rootBlock);

			if (rootBlock instanceof TextBlock) {
				if (rootTemplate instanceof ClassTemplate
						&& rootTemplate.getPartitionHandling().getContent() != null) {
					if (rootTemplate.getPartitionHandling().getContent()
							.toString().equalsIgnoreCase("textblocks")
							|| rootTemplate.getPartitionHandling().getContent()
									.toString().equalsIgnoreCase("all")) {

						System.out.println("The element " + rootBlock
								+ "in CtsDocument has been stored in .....");

						partitionHandler.assignToPartition(inputObject
								.get___Partition(), (RefObject) rootBlock,rootBlock,rootBlock.getParentBlock(),partWithRefObject,
								rootTemplate);
					}

				} else {
					PartitionHandlingWithRefObject parentPartitionHandling = partitionHandler.takeParentPartitionHandling(rootBlock, rootBlock.getParentBlock());
					if(parentPartitionHandling.getPartitionHandling() != null){

						if (parentPartitionHandling.getPartitionHandling().getContent().toString()
								.equalsIgnoreCase("all")
								|| parentPartitionHandling.getPartitionHandling().getContent().toString().equals(
										"textblocks")) {

							System.out.println("The element " + rootBlock
									+ "in CtsDocument has been stored in .....");

							partitionHandler.assignToPartition(inputObject
									.get___Partition(), (RefObject) rootBlock,rootBlock,rootBlock.getParentBlock(),parentPartitionHandling,
									rootTemplate);
						}
					}else if (partitionHandler.getMainPartitionContent()
							.equalsIgnoreCase("all")
							|| partitionHandler.getMainPartition().equals(
									"textblocks")) {

						System.out.println("The element " + rootBlock
								+ "in CtsDocument has been stored in .....");

						partitionHandler.assignToPartition(inputObject
								.get___Partition(), (RefObject) rootBlock,rootBlock,rootBlock.getParentBlock(),parentPartitionHandling,
								rootTemplate);
					}

				}
			} else {
				PartitionHandlingWithRefObject partitionHandlingWithRefObject1 =  new PartitionHandlingWithRefObject(null, (RefObject) rootBlock);

				if (rootTemplate instanceof ClassTemplate
						&& rootTemplate.getPartitionHandling().getContent() != null) {
					if (rootTemplate.getPartitionHandling().getContent()
							.toString().equalsIgnoreCase("model")
							|| rootTemplate.getPartitionHandling().getContent()
									.toString().equalsIgnoreCase("all")) {

						System.out.println("The element " + rootBlock
								+ "in CtsDocument has been stored in .....");

						partitionHandler.assignToPartition(inputObject
								.get___Partition(), (RefObject) inputObject,rootBlock,rootBlock.getParentBlock(),partitionHandlingWithRefObject1,
								rootTemplate);
					}

				} else {
					PartitionHandling parentPartitionHandling1 = takeParentPartitionHandling( rootBlock);
					if (parentPartitionHandling1 != null) {
						if (parentPartitionHandling1.getContent().toString()
								.equalsIgnoreCase("all")
								|| parentPartitionHandling1.getContent().toString().equals(
										"model")) {

							System.out.println("The element " + rootBlock
									+ "in CtsDocument has been stored in .....");

							partitionHandler.assignToPartition(inputObject
									.get___Partition(), (RefObject) inputObject,rootBlock,rootBlock.getParentBlock(),partitionHandlingWithRefObject1,
									rootTemplate);
						}
					}else if (partitionHandler.getMainPartitionContent()
							.equalsIgnoreCase("all")
							|| partitionHandler.getMainPartition().equals(
									"model")) {

						System.out.println("The element " + rootBlock
								+ "in CtsDocument has been stored in .....");

						partitionHandler.assignToPartition(inputObject
								.get___Partition(), (RefObject) inputObject,rootBlock,rootBlock.getParentBlock(),partitionHandlingWithRefObject1,
								rootTemplate);
					}

				}
			}

		}

		if (rootBlock == null) {
			// pretty printer failed, just create a new TB Model
			rootBlock = TbModelInitializationUtil
					.createNewTextBlockForModel(inputObject);
		}
		return rootBlock;
	}

	private PartitionHandling takeParentPartitionHandling(
			TextBlock rootBlock) {
		PartitionHandling partHand = null ;
		TextBlock block = null;
		if (rootBlock == null) {
			return partHand;
		}
		ClassTemplate temp = (ClassTemplate) rootBlock.getType().getParseRule();
		if (temp == null) {
			return partHand;
		}else{
		partHand = temp.getPartitionHandling();
		}
		if (partHand == null) {
			block = rootBlock.getParentBlock();
			return takeParentPartitionHandling( block);
		}

		return partHand;
	
	}

	@Override
	public synchronized void replace(int pos, int length, String text)
			throws BadLocationException {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		// TODO remove synchronization once a better solution has been found
		super.replace(pos, length, text);
	}

	@Override
	public synchronized String get(int pos, int length)
			throws BadLocationException {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		// TODO remove synchronization once a better solution has been found
		String result = super.get(pos, length);
		return result;
	}

	public RefBaseObject getRootObject() {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		return rootObject;
	}

	public void setRootObject(RefBaseObject rootObject) {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		this.rootObject = rootObject;
	}

	public TextBlock getRootBlock() {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		return rootBlock;
	}

	public void setRootBlock(TextBlock rootBlock) {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		this.rootBlock = rootBlock;
		((TextBlocksModelStore) getStore()).setRootTextBlock(rootBlock);
	}

	public TextBlocksModelStore getTextBlocksModelStore() {
		if (!completelyItitialized) {
			throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
		}
		return (TextBlocksModelStore) getStore();
	}

	/**
	 * If {@link #completeInitialization()} was not called after the document
	 * was created the method will return <code>false</code>.
	 * 
	 * @return <code>true</code> if the Document was already completely
	 *         initialized, <code>false</code> else.
	 */
	public boolean isCompletelyItitialized() {
		return completelyItitialized;
	}

	public void setSetupParticipant(
			FurcasDocumentSetupParticpant furcasDocumentSetupParticpant) {
		this.furcasDocumentSetupParticpant = furcasDocumentSetupParticpant;
	}

	public ConcreteSyntax getSyntax() {
		return syntax;
	}

	public void reduceToMinimalState() {
		((TextBlocksModelStore) getStore()).reduceToMinimalState();
	}

}
