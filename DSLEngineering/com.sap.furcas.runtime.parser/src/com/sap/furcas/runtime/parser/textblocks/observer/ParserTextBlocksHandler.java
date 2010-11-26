package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.ResultSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.ParsingTextblocksActivator;
import com.sap.furcas.runtime.textblocks.TbUtil;

/**
 * This class handles the connection between the parser and the textblocks
 * the connection between the parser and the textblocks
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

	private final ITextBlocksTokenStream input;

	// flag to indicate whether root rule has been entered yet or not. 
	private int ruleDepth = -1; // -1 initial value means outside root context

	private ResourceSet resourceSet;

	private final Map<String, Template> templateCache  = new HashMap<String, Template>();

	private final QueryContext metamodelContainerQueryScope;

	private final Collection<URI> mappingDefinitionPartitions;

	private final Set<URI> queryScope;


	/**
	 * Constructs a new Handler which will read from the TextBlocksTokenStream
	 * on Parser events, and build up a textBlocks model
	 * 	 
	 * @param input
	 * @param moinConnection
	 * @param metamodelCri 
	 * @param mappingDefinitionPartitions
	 * @param additionalScope Additional URIS from where to lookup elements.
	 * @param additionalCRIScope Additional CRIS from where to lookup elements.
	 */
	public ParserTextBlocksHandler(ITextBlocksTokenStream input,
			ResourceSet moinConnection, URI metamodelCri,
			Collection<URI> mappingDefinitionPartitions,
			Collection<URI> additionalScope, Collection<URI> additionalCRIScope) {
		this.resourceSet = moinConnection;
		this.mappingDefinitionPartitions = mappingDefinitionPartitions;
		this.queryScope = new HashSet<URI>();
		if (additionalCRIScope != null) {
			this.queryScope.addAll(additionalCRIScope);
		}
		this.queryScope.add(metamodelCri);
		if(additionalScope != null) {
			this.queryScope.addAll(additionalScope);
		}
		this.metamodelContainerQueryScope = EcoreHelper.getQueryContext(moinConnection,
						this.queryScope);
		this.input = input;
		this.traverser = new TextBlockTraverser();
	}
	
	public void setConnection(ResourceSet conn) {
	        this.resourceSet = conn;
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
            if (createdElement == null) {
                return null;
            }
            String templateKey = createdElement.toString()
                    + (mode == null ? "" : ("#" + mode));
            Template template = templateCache.get(templateKey);
            try {
            if (template == null) {
                String queryClass = "select class \n"
                        + "from \"sap.com/tc/moin/mof_1.4\"#"
                        + "Model::Classifier as class \n" + "where class.name = '"
                        + createdElement.get(createdElement.size() - 1) + "'";
                // get clazz by name
                // TODO query fully qualified name!
                ResultSet result;
				
				result = EcoreHelper.executeQuery(queryClass, metamodelContainerQueryScope);
                URI[] eObjects = result.getUris("class");
                EClassifier clazz = null;
                if (eObjects.length > 1) {
                    // throw new RuntimeException("Ambigous templates found for: " +
                    // createdElement + " mode=" + mode);
                    clazz = (EClassifier) resourceSet.getEObject(eObjects[1], true);
                } else if (eObjects.length == 1) {
                    clazz = (EClassifier) resourceSet.getEObject(eObjects[0], true);
                }
                if (clazz != null) {
                    String query = "select template \n"
                            + "from \"demo.sap.com/tcsmeta\"#"
                            + "FURCAS::TCS::ClassTemplate as template, \n"
                            + "\""
                            + EcoreUtil.getID(clazz)
                            + "\" as class "
                            + " where template.metaReference = class where template.mode = ";
                    if (mode != null) {
                        query += "'" + mode + "'";
                    } else {
                        query += "null";
                    }
                    Set<URI> templateAndMMUris = new HashSet<URI>(this.queryScope);
                    templateAndMMUris.addAll(mappingDefinitionPartitions);
                    QueryContext templateAndMMContext = EcoreHelper.getQueryContext(resourceSet, templateAndMMUris);
                    result = EcoreHelper.executeQuery(query, templateAndMMContext);
                    eObjects = result.getUris("template");
                    if (eObjects.length > 1) {
                        // throw new
                        // RuntimeException("Ambigous templates found for: " +
                        // createdElement + " mode=" + mode);
                        template = (Template) resourceSet.getEObject(eObjects[1], true);
                    } else if (eObjects.length == 1) {
                        template = (Template) resourceSet.getEObject(eObjects[0], true);
                    }
                    if (template == null) {
                        // maybe operatorTemplate?
                        query = "select template \n"
                                + "from \"demo.sap.com/tcsmeta\"#"
                                + "FURCAS::TCS::OperatorTemplate as template, \n" + "\""
                                + EcoreUtil.getID(clazz)
                                + "\" as class "
                                + " where template.metaReference = class";
    
                        result = EcoreHelper.executeQuery(query, templateAndMMContext);
                        eObjects = result.getUris("template");
    
                        if (eObjects.length > 1) {
                            // throw new
                            // RuntimeException("Ambigous templates found for: " +
                            // createdElement + " mode=" + mode);
                            template = (Template) resourceSet.getEObject(eObjects[1], true);
                        } else if (eObjects.length == 1) {
                            template = (Template) resourceSet.getEObject(eObjects[0], true);
                        }
                    }
                    if (template != null) {
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
            } catch (MetaModelLookupException e) {
				throw new RuntimeException(e);
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
					contextTextBlock.addCorrespondingModelElementProxies(currentTextBlock.getCorrespondingModelElementProxies());
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
	}
	
	@Override
	public void notifyEnterSequenceElement(String mofid) {
		SequenceElement sequenceElement = (SequenceElement) resourceSet
				.getEObject(URI.createURI(mofid), true);
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
	    if(traverser.isOperatorToken()) {
	        //matching of operator tokenalways is surrounded with enterEqEl and exitSeqEl directly. So we need
	        //to switch operator token off here, otherwise elements from this point to to the 
	        //exitOperatorSequence will also get operatorToken set to true.
                traverser.setOperatorToken(false);
            }
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
			currentTextBlock.getCorrespondingModelElementProxies().add(0, //always add at first position as it is the "leading" element
					(IModelElementProxy) newModelElement);
			((ModelElementProxy) newModelElement).setTextBlock(currentTextBlock);
			if(currentTextBlock.getTemplate() instanceof OperatorTemplate &&
			        ((OperatorTemplate) currentTextBlock.getTemplate()).getStoreLeftSideTo() != null) {
			    //need to add left hand side textblock to current one as child to correctly represent 
			    //composition
			    String storeLeftToProperty = ((OperatorTemplate) currentTextBlock.getTemplate()).getStoreLeftSideTo().getStrucfeature().getName();
			    ModelElementProxy leftHandSide = (ModelElementProxy) ((Collection<Object>)((ModelElementProxy)newModelElement).getAttributeMap().get(storeLeftToProperty)).iterator().next();
			    TextBlockProxy leftHandSideTBProxy = (TextBlockProxy) leftHandSide.getTextBlock();
			    //add all consumed tokens and textblock starting from the lefthand side proxy to the current textblock
			    TextBlockProxy parent = leftHandSideTBProxy.getParent();
			    if(parent != null) {
			        int index = parent.getSubNodes().indexOf(leftHandSideTBProxy);
                                List<Object> elementsMoved = new ArrayList<Object>();
                                for (; index < parent.getSubNodes().size(); index++) {
                                    Object element = parent.getSubNodes().get(index);
                                    elementsMoved.add(element);
                                }
                                int position = 0;
                                for (Object object : elementsMoved) {
                                    if (!currentTextBlock.equals(object)) {
                                        // remove elements from their original parent
                                        parent.getSubNodes().remove(object);
                                        if (object instanceof TextBlockProxy) {
                                            ((TextBlockProxy) object).setParent(currentTextBlock);
                                        }
                                        // add elements to current proxy at start index
                                        currentTextBlock.addSubNodeAt(object, position++);
                                    }
                                }
			    }
			}
		} else {
			throw new RuntimeException("Expected IModelElementProxy but got: "
					+ newModelElement.getClass().getCanonicalName());
		}
	}

	/**
	 * The given <code>modelElement</code> is added to the
	 * {@link DocumentNode#getReferencedElements()} of the
	 * corresponding {@link AbstractToken} of the <code>referenceLocation</code>
	 * {@link Token}. The <code>referenceType</code> indicates what the type of the
	 * {@link DelayedReference} was that was resolved. That can be e.g., {@link DelayedReference#SEMANTIC_PREDICATE}
	 * meaning that the delayed reference was created for a things like a {@link ForeachPredicatePropertyInit}.
	 * 
	 */
	@Override
        public void notifyModelElementResolvedOutOfContext(Object modelElement,
                Object contextModelElement, Token referenceLocation,
                DelayedReference reference) {
            if (contextModelElement instanceof ResolvedModelElementProxy) {
                contextModelElement = ((ResolvedModelElementProxy) contextModelElement)
                        .getRealObject();
            }
            TextBlock contextBlock = getTextBlockForElementAt(
                    (EObject) contextModelElement,
                    (ANTLR3LocationToken) referenceLocation);
            if (contextBlock != null && modelElement instanceof EObject) {

                if (reference.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE) {
                    // this means we are in the resolving of a foreachproperty init
                    // thus we have to add the curently set template to the
                    // additionalTemplates of
                    // of the contextBlock. This will make all injectoractions
                    // associated with the template
                    // available for the GDR for the given model element
                    contextBlock.getAdditionalTemplates().add(
                            getCurrentTbProxy().getTemplate());
                    contextBlock.getCorrespondingModelElements().add((EObject) modelElement);

                } else {
                    AbstractToken referenceToken = navigateToToken(contextBlock,
                            referenceLocation);
                    if (referenceToken == null) {
                        // reference location doesn't correspond to a token. Add to
                        // block
                        contextBlock.getReferencedElements().add(
                                (EObject) modelElement);
                    } else {
                        referenceToken.getReferencedElements().add(
                                (EObject) modelElement);
                    }
                }
            }
        }
	
	

    /**
	 * Attaches the current {@link SequenceElement} or {@link InjectorAction} to the given
	 * {@link DelayedReference}.
	 */
	@Override
    	public void notifyDelayedReferenceCreated(DelayedReference ref) {
	    if(traverser.getCurrentSequenceElement() instanceof InjectorActionsBlock) {
    		ref.setQueryElement(traverser.getCurrent().getInjectorAction());
	    } else {
		ref.setQueryElement(traverser.getCurrent().getSequenceElement());
	    }
	    ref.setTextBlock(traverser.getCurrent());
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
	    if (referenceLocation != null) {
		int absoluteLocation = ((ANTLR3LocationToken)referenceLocation).getStartIndex();
		int relativeLocation = absoluteLocation - TbUtil.getAbsoluteOffset(contextBlock);
		for (AbstractToken tok : contextBlock.getTokens()) {
			if (tok.getOffset() == relativeLocation) {
				return tok;
			}
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
	private TextBlock getTextBlockForElementAt(EObject element, ANTLR3LocationToken referenceToken) {
		TextBlock tb = null;
		Collection<EObject> nodes = org.eclipse.emf.query2.EcoreHelper.getInstance()
			.reverseNavigate(element, 
				(EReference) element.eClass().getEStructuralFeature("correspondingModelElements"),
				EcoreHelper.getQueryContext(resourceSet), resourceSet, false, IndexFactory.getInstance());

		for (EObject eObject : nodes) {
		    DocumentNode node = (DocumentNode) eObject;
		    int candidateOffset = TbUtil.getAbsoluteOffset(node);

		    if (referenceToken != null && ((candidateOffset > referenceToken.getStartIndex() ) || (candidateOffset+node.getLength() < referenceToken.getStopIndex()))) {
		        continue;
		    }

		    if (node instanceof TextBlock) {
		        tb = (TextBlock) node;
		        tb = (TextBlock) TbUtil.getNewestVersion(tb);    
		    } else {
		        AbstractToken tempToken = (AbstractToken) node;
		        tb = tempToken.getParent();
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
        traverser.setOperatorToken(true);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatorSequence()
     */
    @Override
    public void notifyExitOperatorSequence() {
        //if there was a right hand side assign the textblock created for it to the textblock responsible for
        //the operator templated element.
        TextBlockProxy currentTextBlockProxy = traverser.getCurrent();
        //first get the second to the last TextBlockProxy within the parent
        int index = currentTextBlockProxy.getSubNodes().size() - 1;
        boolean countedFirstTbFromReverse = false;
        TextBlockProxy last = null;
        TextBlockProxy secondToLast = null;
        while(index > 0) {
            Object o = currentTextBlockProxy.getSubNodes().get(index--);
            if(o instanceof TextBlockProxy) {
                if(countedFirstTbFromReverse) {
                    secondToLast = (TextBlockProxy) o;
                    break;
                } else {
                    last = (TextBlockProxy) o;
                    countedFirstTbFromReverse = true;
                }
            }
        }
        if(secondToLast != null && secondToLast.getTemplate() instanceof OperatorTemplate) {
            OperatorTemplate optemplate = (OperatorTemplate)secondToLast.getTemplate();
            if(optemplate.getStoreRightSideTo() != null) {
                //this means that the right hand side proxy was added to the parent textblock instead of
                //the one for the operatortemplate, so move it to there
                last.setParent(secondToLast);
                currentTextBlockProxy.removeSubNode(last);
                secondToLast.addSubNodeAt(last, secondToLast.getSubNodes().size());
            }
        }
    }

    @Override
    public void reset() {
        this.traverser = new TextBlockTraverser();
        //ruleDepth = 0;
    }

    
   

    



}
