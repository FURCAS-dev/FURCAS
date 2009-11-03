package com.sap.mi.textual.parsing.textblocks.observer;

import static com.sap.mi.textual.parsing.textblocks.TbUtil.getNewestVersion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.SequenceElement;
import tcs.Template;
import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.DocumentNodeReferencesCorrespondingModelElement;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.IParsingObserver;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;
import com.sap.mi.textual.parsing.textblocks.ParsingTextblocksActivator;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

/**
 * This class handles the connection between the parser and the textblocks
 * model.
 * 
 * IMPORTANT NOTE: The current assumption is that the smallest unit of re-use is
 * a whole textblock. This means that whenever {@link #notifyEnterRule(List)} is
 * called and the contents of the block are not consistent to the parse rule
 * anymore, the whole textblock is deleted and re-constructed according to the
 * called rules.
 * 
 * @author C5106462
 * 
 */
public class ParserTextBlocksHandler implements IParsingObserver {

	private static final int EOF = -1;

	/*
	 * TODO: use TextBlocksModel whenever adding anything to the root tree
	 * (relocate and add new textBlock to Parent)
	 */
//	protected TextBlocksModel textBlocksModel;
	/*
	 * used to track current context in virtual tree in parallel to existing
	 * tree
	 */
	protected TextBlockTraverser traverser;

	private ITextBlocksTokenStream input;

	// flag to indicate whether root rule has been entered yet or not. 
	private int ruleDepth = -1; // -1 initial value means outside root context

	private final Connection connection;

	private Map<String, Template> templateCache  = new HashMap<String, Template>();

	private QueryScopeProvider metamodelContainerQueryScope;

	private final Collection<PRI> mappingDefinitionPartitions;

	private final Collection<CRI> additionalCRIScope;

	/**
	 * Constructs a new Handler which will read from the TextBlocksTokenStream
	 * on Parser events, and build up a textBlocks model
	 * 	 
	 * @param input
	 * @param moinConnection
	 * @param metamodelCri 
	 * @param mappingDefinitionPartitions
	 * @param additionalScope Additional PRIS from where to lookup elements.
	 * @param additionalCRIScope Additional CRIS from where to lookup elements.
	 */
	public ParserTextBlocksHandler(ITextBlocksTokenStream input,
			Connection moinConnection, CRI metamodelCri,
			Collection<PRI> mappingDefinitionPartitions,
			Collection<PRI> additionalScope, Collection<CRI> additionalCRIScope) {
		this.connection = moinConnection;
		this.mappingDefinitionPartitions = mappingDefinitionPartitions;
		this.additionalCRIScope = new ArrayList<CRI>();
		if (additionalCRIScope != null) {
			this.additionalCRIScope.addAll(additionalCRIScope);
		}
		this.additionalCRIScope.add(metamodelCri);
		this.metamodelContainerQueryScope = connection.getMQLProcessor()
				.getInclusiveQueryScopeProvider(
						additionalScope != null ? additionalScope
								.toArray(new PRI[] {}) : null,
						this.additionalCRIScope.toArray(new CRI[] {}));
		this.input = input;
	}
	
	/**
	 * returns the current TextBlockProxy of the TextBlockTraverser.
	 * @return
	 */
	public TextBlockProxy getCurrentTbProxy() {
		return traverser.getCurrent();
	}

	/**
	 * This method is called at the start of a parse rule.
	 * 
	 * NOTE: It is assumed that currently the relationship between a parse
	 * rule/a template to the structure of the textblocks is one-to-one.
	 * Furthermore re-use of textblocks is done only using their ordering. An
	 * incremental parsing technique will be employed instead of this once it
	 * becomes available.
	 */
	@Override
	public void notifyEnterRule(List<String> createdElement, String mode) {
//		if (textBlocksModel == null) {
//			throw new RuntimeException(
//					"TextBlocksHandler not initialized correctly (rootBlock == null),"
//							+ " use setRootBlock to set the root Textblock");
//		}

		// ruleDepth == -1 means we are outside root context of traverser
		// ruleDepth == 0 means we are in root context of traverser
		if (ruleDepth > -1) {
			traverser.enterNextChild();
		}
		traverser.getCurrent().setTemplate(findTemplate(createdElement, mode));
		ruleDepth++;

		// all the relocating and adding to parents happens in onExitRule

		// // if there are still some tokens to be re-located for the former
		// rule
		// // do that here
		// if (currentTextBlock != null && relocationCandidates.size() > 0) {
		// relocateTokens(relocationCandidates, currentTextBlock);
		//			
		// saveAddToParentBlock(currentTextBlock, parentTextBlock);
		// }
		//
		// if (currentTextBlock == null) {
		// // call of initial rule
		// currentTextBlock = parentTextBlock;
		// } else if (currentTextBlock == parentTextBlock) {
		// // no textblock exists yet, or entered ANY subrule of root
		// if (parentTextBlock.getSubBlocks().size() == 0) {
		// currentTextBlock = createTextBlock(textblocksPackage);
		// } else { // need to select "next" subrule
		// throw new IllegalStateException("Bug: replacing under root not
		// implemented yet.");
		// }
		// } else {
		// parentTextBlock = currentTextBlock;
		// currentTextBlock =
		// TbNavigationUtil.nextBlockInSubTree(currentTextBlock);
		// if (currentTextBlock == null) {
		// // no further textblocks exist
		// currentTextBlock = createTextBlock(textblocksPackage);
		// }
		// }
		// tbContextStack.add(currentTextBlock);
	}

	private Template findTemplate(List<String> createdElement, String mode) {
		if(createdElement == null) {
			return null;
		}
		String queryClass = "select class \n" + 
        	"from \"sap.com/tc/moin/mof_1.4\"#" + "Model::Classifier as class \n"+
        	"where class.name = '" + createdElement.get(createdElement.size()-1) + "'";
		//get clazz by name
		//TODO query fully qualified name!
		MQLResultSet result = connection.getMQLProcessor().execute(queryClass, metamodelContainerQueryScope);
		RefObject[] refObjects = result.getRefObjects("class");
		Classifier clazz = null;
		if(refObjects.length > 1) {
			//throw new RuntimeException("Ambigous templates found for: "  + createdElement + " mode=" + mode);
			clazz = (Classifier) refObjects[1];
		} else if (refObjects.length == 1){
			clazz = (Classifier) refObjects[0];
		}
		//TODO search only in the mapping partition!
		Template template = null;
			if(clazz != null) {
			String query = "select template \n" + 
			        "from \"demo.sap.com/tcsmeta\"#" + "TCS::ClassTemplate as template, \n" +
			        "\"" + ( (Partitionable) clazz ).get___Mri( ) + "\" as class " +
			        " where template.metaReference = class where template.mode = ";
			if(mode != null) {
				query += "'" + mode + "'";
			}else {
				query += "null";
			}
			String templateKey = createdElement.toString() + (mode == null ? "" : ("#" + mode));
			template = templateCache.get(templateKey);
			if(template == null) {
				QueryScopeProvider mappingQueryScope = connection.getMQLProcessor()
        				.getInclusiveQueryScopeProvider(
        					mappingDefinitionPartitions
        						.toArray(new PRI[] {}),
        						metamodelContainerQueryScope
        						.getContainerScope());
				result = connection.getMQLProcessor().execute(query,
						mappingQueryScope);
				refObjects = result.getRefObjects("template");
				if(refObjects.length > 1) {
					//throw new RuntimeException("Ambigous templates found for: "  + createdElement + " mode=" + mode);
					template = (Template) refObjects[1];
				} else if (refObjects.length == 1){
					template = (Template) refObjects[0];
				}
				if(template == null) {
					//maybe operatorTemplate?
					query = "select template \n" + 
				        "from \"demo.sap.com/tcsmeta\"#" + "TCS::OperatorTemplate as template, \n" +
				        "\"" + ( (Partitionable) clazz ).get___Mri( ) + "\" as class " +
				        " where template.metaReference = class";
			
					result = connection.getMQLProcessor().execute(query);
					refObjects = result.getRefObjects("template");
					
					if(refObjects.length > 1) {
						//throw new RuntimeException("Ambigous templates found for: "  + createdElement + " mode=" + mode);
						template = (Template) refObjects[1];
					} else if (refObjects.length == 1){
						template = (Template) refObjects[0];
					} 
				}
				if(template != null) {
					templateCache.put(templateKey, template);
				} else {
					ParsingTextblocksActivator
							.logWarning("No template model element found for template:"
									+ createdElement
									+ " with mode = "
									+ mode
									+ "! Check if mapping model is available,"
									+ " otherwise incremental parsing will not work!");
				}
			}
		}
		return template;
	}

	/**
	 * It navigates to the textblock that belongs to the given context within
	 * the {@link #currentTextBlock} which is then used during parsing to add
	 * all matched token elements and subblocks to it.
	 */
	@Override
	public void notifyEnterSequenceAlternative(int choice) {
		traverser.enterAlternative(choice);
	}

	@Override
	public void notifyExitSequenceAlternative() {
		traverser.exitAlternative();
	}

	/**
	 * Marks the current textblock as incomplete. This is to be set by the
	 * parser when it cannot match the a rule to the tokens in its token stream.
	 */
	@Override
	public void notifyErrorInRule(RecognitionException re) {
		TextBlockProxy currentBlock = traverser.getCurrent();
		if (currentBlock != null) {
			currentBlock.setComplete(false);
		}

	}

	/**
	 * Exits the current textblock context by setting the parent textblock of
	 * the current textblock as new current textblock.
	 */
	@Override
	public void notifyExitRule(List<String> createdElementType) {
		if (ruleDepth < 0) { // cannot leave root context depth
			throw new IllegalStateException(
					"Attempt to leave root context more than once");
		}

		try {
			/*
			 * complete filling and setting of textblock that was started on
			 * enterRule
			 */
			TextBlockProxy currentTextBlock = traverser.getCurrent();			
			
			// ruleDepth == -1 means we are outside root context of traverser
			// ruleDepth == 0 means we are in root context of traverser
			/*
			 * do not leave root even if new depth will be == 0, because
			 * some tokens may still be consumed, those will be added on EOF
			 * no need to leave child, as there is no parent in traverser,
			 * no need to save to parent
			 */
			if(ruleDepth > 0) {
				/* Now leave the current context with all the required side effects */
				traverser.leaveChild();

				TextBlockProxy contextTextBlock = traverser.getCurrent();
				if (currentTextBlock.getSubNodes().size() == 0) {
					//textblock has no tokens and was only used to
					//instanciate additional model elements so add them to the elements of this block
					//and remove empty block;
					contextTextBlock.addAdditionalTemplate(currentTextBlock.getTemplate());
					contextTextBlock.addCorrespondingModelElements(currentTextBlock.getCorrespondingModelElements());
					contextTextBlock.addAdditionalTemplates(currentTextBlock.getAdditionalTemplates());
					contextTextBlock.removeSubNode(currentTextBlock);
				} else {
					// we have no textblock to add, so ignore
				}
			}			
		} catch (RuntimeException jmie) {
			// should never happen, but happens.
			// Exceptions get swallowed in the call trace else, due to
			// consequent Exceptions
			jmie.printStackTrace();
			throw jmie;
		} finally {
		 // (-1 is still allowed, we assign tokens to rootblock then)
            ruleDepth--; // needs to be called even on exceptions to prevent trying to leave root.
		}

		// // set the parent's parent as parent context and remove tb from
		// context
		// // stack
		// tbContextStack.remove(tbContextStack.size() - 1);
		// if (tbContextStack.size() > 1) {
		// TextBlock parentsParentBlock = tbContextStack.get(tbContextStack
		// .size() - 2);
		// parentTextBlock = parentsParentBlock;
		// }
	}

	@Override
	public void notifyTokenConsume(Token token) {
		consumeToken(token);
	}

	@Override
	public void notifyTokenConsumeWithError(Token token) {
		consumeToken(token);
	}

	/**
	 * add all omitted tokens that were skipped so far to the text block as well
	 * TODO check this behaviour, it might be necessary to make this
	 * configurable because there might be different expectations on where
	 * omitted tokens get stored (before, behind, in current textblock etc.)
	 * 
	 * @param token
	 */
	private void consumeToken(Token token) {
		if (token.getType() != EOF) {
			AbstractToken tokenToRelocate = input
					.consumeTokenModelElementForParserToken(token);
			Collection<? extends AbstractToken> offChannelTokens = input
					.consumeOffChannelTokensUpTo(tokenToRelocate);

			// add the tokenToRelocate after adding all skipped tokens
			for (AbstractToken offChannelToken : offChannelTokens) {
				traverser.addSubNode(offChannelToken);
			}
			traverser.addSubNode(tokenToRelocate);

		} else {
			// consume all left tokens
			List<? extends AbstractToken> offChannelTokens = input
					.consumeOffChannelTokensUpTo(null);
			traverser.addSubNodes(offChannelTokens);
		}
	}

	@Override
	public void notifyEnterSequenceElement() {
		// for subclasses or delegation
	}
	
	@Override
	public void notifyEnterSequenceElement(String mofid) {
		SequenceElement sequenceElement = null;
		for (PRI mappingDefinitionPartition : mappingDefinitionPartitions) {
			sequenceElement =(SequenceElement) connection
				.getElement(connection.getSession().getMoin().createMri(
						mappingDefinitionPartition.getDataAreaDescriptor().getFacilityId(),
						mappingDefinitionPartition.getDataAreaDescriptor().getDataAreaName(),
						mappingDefinitionPartition.getContainerName(),
						mappingDefinitionPartition.getPartitionName(),
						mofid
						));
			if(sequenceElement != null) {
				break;
			}
		}
		if(sequenceElement != null) {
		    traverser.setCurrentSequenceElement(sequenceElement);
		}
	}
	
	 @Override
	    public void notifyEnterInjectorAction() {
		SequenceElement sequenceElement = traverser.getCurrentSequenceElement();
		if(sequenceElement instanceof InjectorActionsBlock) {
		    InjectorAction oldAction = traverser.getCurrent().getInjectorAction();
		    InjectorAction currentAction = null;
		    if(oldAction == null) {
			currentAction = ((InjectorActionsBlock)sequenceElement).getInjectorActions().iterator().next();
		    } else {
			boolean next = false;
			for (InjectorAction action : ((InjectorActionsBlock)sequenceElement).getInjectorActions()) {
			    if(action.equals(oldAction)) {
				next = true;
				continue;
			    }
			    if(next) {
				currentAction = action;
				break;
			    }
			}
		    }
		    traverser.getCurrent().setInjectorAction(currentAction);
		}
	    }

	    @Override
	    public void notifyExitInjectorAction() {
		// TODO Auto-generated method stub
		
	    }
		

	@Override
	public void notifyExitSequenceElement() {
		// for subclasses or delegation
	}

	/**
	 * The given <code>newModelElement</code> is added to the
	 * {@link DocumentNode#getCorrespondingModelElements()} of the
	 * {@link #currentTextBlock}.
	 */
	@Override
	public void notifyCommittedModelElementCreation(Object newModelElement) {
		if (newModelElement == null) {
			throw new IllegalArgumentException("Notified with null");
		}
		if (newModelElement instanceof IModelElementProxy) {
			TextBlockProxy currentTextBlock = traverser.getCurrent();
			currentTextBlock.addCorrespondingModelElement(
					(IModelElementProxy) newModelElement);
		} else {
			throw new RuntimeException("Expected IModelElementProxy but got: "
					+ newModelElement.getClass().getCanonicalName());
		}
	}

	/**
	 * The given <code>modelElement</code> is added to the
	 * {@link DocumentNode#getReferencedElements()} of the
	 * corresponding {@link AbstractToken} of the <code>referenceLocation</code>
	 * {@link Token}.
	 */
	@Override
	public void notifyModelElementResolvedOutOfContext(Object modelElement,
			Object contextModelElement, Token referenceLocation) {
		TextBlock contextBlock = getTextBlockForElementAt((RefObject) contextModelElement, (ANTLR3LocationToken) referenceLocation);
		if(contextBlock != null && modelElement instanceof RefObject) {
			AbstractToken referenceToken = navigateToToken(contextBlock, referenceLocation);
			if (referenceToken == null) {
				//reference location doesn't correspond to a token. Add to block
				contextBlock.getReferencedElements().add((RefObject) modelElement);
			} else {
				referenceToken.getReferencedElements().add(
					(RefObject) modelElement);
			}
		}
	}
	
	/**
	 * Attaches the current {@link SequenceElement} or {@link InjectorAction} to the given
	 * {@link DelayedReference}.
	 */
	@Override
    	public void notifyDelayedReferenceCreated(DelayedReference ref) {
	    if(traverser.getCurrent().getSequenceElement() instanceof InjectorActionsBlock) {
    		ref.setQueryElement(traverser.getCurrent().getInjectorAction());
	    } else {
		ref.setQueryElement(traverser.getCurrent().getSequenceElement());
	    }
	    	
        }
	
	@Override
        public void notifyElementAddedToContext(Object element) {
	    traverser.addToContext(element);
        }

	/**
	 * Navigates to the corresponding AbstractToken of the given
	 * referenceLocation within the <code>contextBlock</code>.
	 * 
	 * @param contextBlock
	 *            Block from where to start navigation, has to be the direct
	 *            owner of the token that is searched for.
	 * @param referenceLocation
	 *            The ANLTR token that denotes the position of the corresponind
	 *            modelelement token.
	 * @return the model element token that corresponds to the given
	 *         referenceLocation
	 */
	private AbstractToken navigateToToken(TextBlock contextBlock,
			Token referenceLocation) {
		int absoluteLocation = ((ANTLR3LocationToken)referenceLocation).getStartIndex();
		int relativeLocation = absoluteLocation - TbUtil.getAbsoluteOffset(contextBlock);
		for (AbstractToken tok : contextBlock.getTokens()) {
			if (tok.getOffset() == relativeLocation) {
				return tok;
			}
		}
		return null;
	}

	// /**
	// * Adds the given <code>subBlock</code> to the <code>parentBlock</code>
	// * including the re-computation of its offset.
	// *
	// * @param parentBlock
	// * @param subBlock
	// *
	// */
	// private void connectSubBlock(TextBlock parentBlock, TextBlock subBlock) {
	// parentBlock.getSubBlocks().add(subBlock);
	// // make offset relative to root
	// subBlock.setOffset(subBlock.getOffset() - parentBlock.getOffset());
	// subBlock.setOffsetRelative(true);
	// }

	/**
	 * Uses {@link DocumentNodeReferencesCorrespondingModelElement} to find a
	 * corresponding {@link TextBlock} for the given <code>element</code>.
	 * 
	 * @param element
	 *            the element to get the {@link TextBlock} for
	 * @param i 
	 * @return the corresponding {@link TextBlock} for the given element
	 */
	private TextBlock getTextBlockForElementAt(RefObject element, ANTLR3LocationToken referenceToken) {
		TextBlock tb = null;
		DocumentNodeReferencesCorrespondingModelElement assoc = ((Partitionable) element)
				.get___Connection().getPackage(
						TextblocksPackage.PACKAGE_DESCRIPTOR)
				.getDocumentNodeReferencesCorrespondingModelElement();
		Collection<DocumentNode> nodes = assoc
		.getDocumentNode(element);

		for (Iterator<DocumentNode> iterator = nodes.iterator(); iterator.hasNext();) {
		    DocumentNode node = iterator.next();
		    int candidateOffset = TbUtil.getAbsoluteOffset(node);

		    if ( (candidateOffset > referenceToken.getStartIndex() ) || (candidateOffset+node.getLength() < referenceToken.getStopIndex()) ) {
		        continue;
		    }

		    if (node instanceof TextBlock) {
		        tb = (TextBlock) node;
		        tb = (TextBlock) getNewestVersion(tb);    
		    } else {
		        AbstractToken tempToken = (AbstractToken) node;
		        tb = tempToken.getParentBlock();
		    }
		}


		return tb;
	}

	/**
	 * This setter can be used to define the parent context on which the class
	 * is going to work
	 * 
	 * @param root
	 */
	public void setRootBlock(TextBlock root) {
		this.traverser = new TextBlockTraverser();
		//textBlocksModel = new TextBlocksModel(root);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyModelElementResolutionFailed()
	 */
	@Override
	public void notifyCommitModelElementFailed() {
		// TODO set some flag maybe?
		System.out
				.println("TODO implement ParserTextBlocksHandler.notifyModelElementResolutionFailed");
	}

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatoredBrackettedSequence()
     */
    @Override
    public void notifyEnterOperatoredBrackettedSequence() {
        // ignore
        
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSeparatorSequence()
     */
    @Override
    public void notifyEnterSeparatorSequence() {
        // ignore
        
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatoredBrackettedSequence()
     */
    @Override
    public void notifyExitOperatoredBrackettedSequence() {
        //ignore
        
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSeparatorSequence()
     */
    @Override
    public void notifyExitSeparatorSequence() {
        // ignore
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatorSequence(java.lang.String, int, boolean)
     */
    @Override
    public void notifyEnterOperatorSequence(String operator, int arity,
            boolean isUnaryPostfix) {
     // ignore
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatorSequence()
     */
    @Override
    public void notifyExitOperatorSequence() {
     // ignore
    }

   

    



}
