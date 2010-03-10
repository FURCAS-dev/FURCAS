package com.sap.ide.cts.parser.incremental;

import static com.sap.mi.textual.parsing.textblocks.TbChangeUtil.addToBlockAt;
import static com.sap.mi.textual.parsing.textblocks.TbMarkingUtil.isEOS;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getSubNodeAt;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getSubNodesSize;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.nextToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tcs.Alternative;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.ConditionalElement;
import tcs.FunctionTemplate;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.OperatorTemplate;
import tcs.PartitionHandling;
import tcs.PrimitivePropertyInit;
import tcs.Property;
import tcs.SequenceElement;
import tcs.Template;
import textblockdefinition.TextBlockDefinition;
import textblocks.AbstractToken;
import textblocks.Bostoken;
import textblocks.DocumentNode;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.OmittedToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;
import textblocks.VersionEnum;

import com.sap.ide.cts.parser.Activator;
import com.sap.ide.cts.parser.incremental.ITextBlockReuseStrategy.ReuseType;
import com.sap.ide.cts.parser.incremental.ITextBlockReuseStrategy.TbBean;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalTokenStream;
import com.sap.ide.cts.parser.incremental.util.ITarjanTreeContentProvider;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA.Node;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ModelElementProxy;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.TbVersionUtil;
import com.sap.mi.textual.parsing.textblocks.observer.ParserTextBlocksHandler;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.mi.textual.parsing.textblocks.observer.TokenRelocationUtil;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockComparer.TextBlockFactory;
import com.sap.mi.textual.tcs.util.MetaModelElementResolutionHelper;
import com.sap.mi.textual.tcs.util.SyntaxLookup;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject;

public class IncrementalParser extends IncrementalRecognizer implements ITextBlockCreator,
	IReferenceHandler {

	public class CompositeRefAssociationBean {

		public CompositeRefAssociationBean(RefAssociation refAssoc, boolean isParentFirstEnd) {
			compositeFeatureAssoc = refAssoc;
			this.isParentFirstEnd = isParentFirstEnd;
		}

		public RefAssociation compositeFeatureAssoc;
		public boolean isParentFirstEnd;
	}

	private final ITextBlockReuseStrategy reuseStrategy;

	private static final String MAIN_PARSE_RULE_NAME = "main";
	private final ParserFactory<?, ?> parserFactory;

	// private AdapterJMIHelper adapterJmiHelper;

	private final Collection<CRI> additionalCRIScope;

	public IncrementalParser(Connection connection, ParserFactory<?, ?> parserFactory,
		IncrementalLexer incrementalLexer, ObservableInjectingParser batchParser,
		ITextBlockReuseStrategy reuseStrategy, Collection<CRI> additionalCRIScope) {
		super(connection);
		this.parserFactory = parserFactory;
		this.additionalCRIScope = additionalCRIScope;
		if (!(batchParser.getTokenStream() instanceof ITextBlocksTokenStream)) {
			throw new IllegalArgumentException(
				"token stream of parser needs to be "
					+ "ITextBlocksTokenStream in order to be used with incremental parser");
		}
		
		tbtokenStream = (ITextBlocksTokenStream) batchParser.getTokenStream();
		this.batchParser = batchParser;
		
		this.reuseStrategy = reuseStrategy;
		this.reuseStrategy.setReferenceHandler(this);
		this.reuseStrategy.setTextBlockCreator(this);
	}

	private final Collection<TextBlock> changedBlocks = new ArrayList<TextBlock>();
	private final ObservableInjectingParser batchParser;
	private final ITextBlocksTokenStream tbtokenStream;
	private final TextBlockFactory tbFactory = new TextBlockFactory() {

		@Override
		public TextBlock createBlock() {
			return createTextBlock();
		}

	};

	private final Map<Template, TextBlockDefinition> tbDefsMap = new HashMap<Template, TextBlockDefinition>();

	private final Collection<DelayedReference> newlyResolvableReferences = new ArrayList<DelayedReference>();

	private final Collection<AbstractToken> tokensForReferenceResolving = new ArrayList<AbstractToken>();

	private ModelPartition defaultPartition = null;

	private ModelPartition mainPartition = null;

	public String mainPartitionContent = "";

	private Collection<PRI> syntaxPartitions;

	private TemplateNamingHelper<RefObject> namingHelper;

	private MetaModelElementResolutionHelper<RefObject> resolutionHelper;

	private SyntaxLookup syntaxLookup;

	private RefPackage[] packagesForLookup;

	private InteractivePartitionHandler interactivePartitionHandler;

	private ConcreteSyntax concreteSyntax;

	/**
	 * Incrementally parses the given root block. The algorithm assumes that all changed blocks
	 * and tokens are correctly marked (using {@link DocumentNode#isChildrenChanged()} and
	 * {@link DocumentNode#isRelexingNeeded()} (TODO this needs to be changed if there is
	 * something like "wasRelexed".). Based on this all regions that became invalid due to
	 * lexical changes are re-parsed and the incrementally merged with the existing text block
	 * tree and model.
	 * 
	 * @param root
	 * @return returns the (possibly newly created) root block as a result of the parsing.
	 */
	public TextBlock incrementalParse(TextBlock root) {
		reset();
		setDefaultPartitionFromRoot(root);
		TextBlock newRoot = root;
		// if there is a change
		if (!isEOS(findNextRegion(root))) {

			syntaxPartitions = TcsUtil.getSyntaxePartitions(connection, parserFactory
				.getLanguageId());
			ParserTextBlocksHandler parserTextBlocksHandler = new ParserTextBlocksHandler(
				tbtokenStream, connection, parserFactory
					.getMetamodelCri(connection), syntaxPartitions,
				parserFactory.getParserLookupScope(connection), additionalCRIScope);
			concreteSyntax = TcsUtil.getSyntaxByName(connection, parserFactory
				.getLanguageId());
			
			//to set the mainPartition content
			if ((concreteSyntax != null) &&(concreteSyntax.getPartitionHandling() != null)) {
				PRI concretSyntax_PRI = null;
				if (concreteSyntax.getPartitionHandling().isAutomaticPartition()) {
					 concretSyntax_PRI = getPRI_Of_ConcreteSyntax(concreteSyntax);
					
					if (connection.getPartition(concretSyntax_PRI) != null) {
						mainPartition = connection.getPartition(concretSyntax_PRI);
					} else {

						mainPartition = connection.createPartition(concretSyntax_PRI);
					}
				}else {
					concretSyntax_PRI = interactivePartitionHandler.getPartitionFor(concreteSyntax.getPartitionHandling(), getDefaultPartition(), concreteSyntax, connection);
					if (connection.partitionExists(concretSyntax_PRI)) {
						mainPartition = connection.getPartition(concretSyntax_PRI);
					} else {
						mainPartition = connection.createPartition(concretSyntax_PRI);
					}
				}
				mainPartitionContent = concreteSyntax.getPartitionHandling().getContent().toString();
				
			}
			
			// IParsingObserver originalObserver = batchParser.getObserver();
			batchParser.setObserver(parserTextBlocksHandler);
			// Ensure no model elements get created
			// only proxies should be created
			boolean originalResolveProxiesValue = batchParser.isResolveProxies();
			batchParser.setResolveProxies(false);

			// find the next changed region
			for (AbstractToken tok = findNextRegion(root); !isEOS(tok); tok = findNextRegion(tok)) {
				AbstractToken leftBoundary = tok;
				// left boundary has to be the element that is reachable by the
				// lookback count of
				// the first changed token
				for (int lookback = leftBoundary.getLookback(); lookback > 0; lookback--) {
					leftBoundary = TbNavigationUtil.previousToken(leftBoundary);
				}
				AbstractToken rightBoundary = tok;
				tok = nextToken(tok);
				while (!isEOS(tok)
					&& (wasReLexed(tok) || tok instanceof OmittedToken)) {
					rightBoundary = tok;
					// TODO would it be possible to track the common ancestor
					// directly in this
					// routine?
					// should be, so no further algorithm would be needed!
					tok = nextToken(tok);
				}
				DocumentNode commonAncestorNode = getCommonAncestor(root,
					leftBoundary, rightBoundary);

				TextBlock commonAncestor = null;
				if (commonAncestorNode instanceof AbstractToken) {
					// actually just update all model elements that depended
					// from
					// this value. As we do not have the knowledge on how to do
					// this right now
					// just re-parse the parent element.
					commonAncestor = ((AbstractToken) commonAncestorNode)
						.getParentBlock();
				} else {
					commonAncestor = (TextBlock) commonAncestorNode;
				}

				// DocumentNode startNode = getStartNode(leftBoundary);

				// parse the given part of the texblocktree
				commonAncestor = prepareForParsing(commonAncestor,
					parserTextBlocksHandler);
				try {
					callBatchParser(commonAncestor);
					while ((batchParser.getInjector().getErrorList().size() > 0 || !comsumedAllTokens(commonAncestor))
						&& commonAncestor.getParentBlock() != null) {
						// parsing failed, so try to parse with the parent
						// block
						// and see if it works
						commonAncestor = commonAncestor.getParentBlock();
						commonAncestor = prepareForParsing(commonAncestor,
							parserTextBlocksHandler);
						callBatchParser(commonAncestor);
					}

					TextBlockProxy tbProxy = parserTextBlocksHandler
						.getCurrentTbProxy();

					// the sequence element context should be still the same, so
					// copy it
					tbProxy.setSequenceElement(commonAncestor
						.getSequenceElement());
					TextBlock newModel = mergeTbModelFromProxies(
						commonAncestor, tbProxy);

					if (TbNavigationUtil.isUltraRoot(newModel)) {
						newRoot = newModel;
					}
					// move to the last token of the updated textblock
					// As the whole block is going to be re-parsed set tok to
					// the token after the right
					// boundary of the common ancestor block. So even if
					// there are several regions that were isolatedly changed
					// they will
					// all be handled by reparsing this ancestor block.
					if (!isEOS(tok)) {
						AbstractToken tokOfNewModel = TbNavigationUtil
							.lastToken(newModel);
						if (TbUtil.getAbsoluteOffset(tokOfNewModel) > TbUtil
							.getAbsoluteOffset(rightBoundary)) {
							tok = tokOfNewModel;
						}
						if (!isEOS(tok)) {
							tok = nextToken(tok);
						}
					}

				} catch (SyntaxElementException e) {
					throw new RuntimeException(e);
				} catch (JmiException e) {
					throw new RuntimeException(e);
				} catch (SecurityException e) {
					throw new RuntimeException(e);
				} catch (IllegalArgumentException e) {
					throw new RuntimeException(e);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				} catch (UnknownProductionRuleException e) {
					throw new RuntimeException(e);
				}

			}
			// batchParser.setObserver(originalObserver);
			batchParser.setResolveProxies(originalResolveProxiesValue);
			resolveRemainingReferences();
		}
		return newRoot;
	}

	private PRI getPRI_Of_ConcreteSyntax(ConcreteSyntax concrete_syntax) {
		PRI newPRI = null;
		 if ((concrete_syntax.getPartitionHandling().getContainer() == null)
			&& (concrete_syntax.getPartitionHandling().getName() == null)) {
			newPRI = getDefaultPartition().getPri();
			
		}else if ((concrete_syntax.getPartitionHandling() != null)
			&& (concrete_syntax.getPartitionHandling().getName() == null)) {
			newPRI = connection.getSession().getMoin().createPri(
				getDefaultPartition().getPri().getDataAreaDescriptor().getFacilityId(),
				getDefaultPartition().getPri().getDataAreaDescriptor().getDataAreaName(),
				concrete_syntax.getPartitionHandling().getContainer(),
				getDefaultPartition().getPri().getPartitionName()); 
			

		} else if ((concrete_syntax.getPartitionHandling().getContainer() == null)
			&& (concrete_syntax.getPartitionHandling().getName() != null)) {
			newPRI = connection.getSession().getMoin().createPri(
				getDefaultPartition().getPri().getDataAreaDescriptor().getFacilityId(),
				getDefaultPartition().getPri().getDataAreaDescriptor().getDataAreaName(),
				getDefaultPartition().getPri().getContainerName(),
				evaluatedOCLForProperty(concrete_syntax, concrete_syntax.getPartitionHandling()));
			
		}
		return newPRI;
	}

	private boolean comsumedAllTokens(TextBlock commonAncestor) {
		// TODO if last new token was last consumed and the parent rule does
		// match the parent block
		// we should return true
		AbstractToken tok = ((ANTLRIncrementalTokenStream) batchParser.getTokenStream())
			.getLastConsumedToken();
		if (tok == null) {
			return true;
		}
		AbstractToken nextTok = TbNavigationUtil.nextToken(tok);
		while (nextTok instanceof OmittedToken && !(nextTok instanceof Eostoken)) {
			nextTok = TbNavigationUtil.nextToken(nextTok);
		}
		if (nextTok != null) {
			if (TbVersionUtil.getOtherVersion(tok, VersionEnum.REFERENCE) == null) {
			
				if (TbVersionUtil.getOtherVersion(nextTok, VersionEnum.REFERENCE) != null) {
					// this is the edge between new and existing tokens, so TODO
					// we need to check if the parent rule
					// still matches
					// this is a clean insert
					return true;
				}

			}
		}
		boolean lastTokenOfBlockConsumed = ((ANTLRIncrementalTokenStream) batchParser
			.getTokenStream()).getLastConsumedToken().equals(
			TbNavigationUtil.lastToken(commonAncestor));
		return lastTokenOfBlockConsumed;
	}

	/**
	 * Sets the default partition that is used to assign all created model elements. In this
	 * case the same partition as the one from the root blocks corresponding model element is
	 * used. TODO:
	 * 
	 * @param root
	 */
	private void setDefaultPartitionFromRoot(TextBlock root) {
		defaultPartition = ((Partitionable) root.getCorrespondingModelElements().iterator()
			.next()).get___Partition();
//		if (root instanceof ) {
//			
//		}
	}

	/**
	 * Sets the default partition that is used to assign all created model elements. In this
	 * case the same partition as the one from the root blocks corresponding model element is
	 * used. TODO:
	 * 
	 * @param concreteSyntax
	 */
	private void setDefaultPartitionFromRoot(ConcreteSyntax concreteSyntax) {
		if ((concreteSyntax.getPartitionHandling() != null)
			&& (concreteSyntax.get___Partition() != null)) {
			defaultPartition = concreteSyntax.get___Partition();
		}
	}

	public List<ParsingError> getErrorList() {
		return batchParser.getInjector().getErrorList();
	}

	private void reset() {
		newlyResolvableReferences.clear();
		tokensForReferenceResolving.clear();
		changedBlocks.clear();
		tbDefsMap.clear();
	}

	/**
	 * Only resolve those references that were affected by this parse run. This may either by
	 * because they are contained in a new text block or the token that contains the value that
	 * was used to do the initial resolving changed.
	 */
	private void resolveRemainingReferences() {
		for (DelayedReference ref : new ArrayList<DelayedReference>(batchParser
			.getUnresolvedReferences())) {
			AbstractToken refToken = tbtokenStream
				.getTokenModelElementForParserToken(ref.getToken());
			boolean resolveNewlyFromToken = tokensForReferenceResolving
				.contains(tbtokenStream.getTokenModelElementForParserToken(ref
					.getToken()));
			boolean newlyResolve = newlyResolvableReferences.contains(ref);
			if (ref.getType() == DelayedReference.SEMANTIC_PREDICATE) {
				if (TbVersionUtil.getOtherVersion(tbtokenStream
					.getTokenModelElementForParserToken(ref.getToken())
					.getParentBlock(), VersionEnum.REFERENCE) != null) {
					batchParser.removeUnresolvedReference(ref);
				}
			} else if (!newlyResolve && !resolveNewlyFromToken) {
				batchParser.removeUnresolvedReference(ref);
			} else {
				if (ref.getModelElement() instanceof IModelElementProxy) {
					IModelElementProxy proxy = (IModelElementProxy) ref
						.getModelElement();
					if (proxy.getRealObject() == null) {
						// proxy not resolved yet, this means that
						// only the reference changed and not the containing
						// model element
						// therefore re-use the old element from the
						// textblock
						RefObject existingElement = TbUtil
							.getCreatedElement(refToken
								.getParentBlock());
						((ModelElementProxy) proxy)
							.setRealObject(existingElement);
					}
				}
				if (resolveNewlyFromToken) {
					// delete old reference first
					// TODO use reflective call on association proxy instead
					RefObject modelElement = null;
					if (ref.getModelElement() instanceof IModelElementProxy) {
						modelElement = (RefObject) ((IModelElementProxy) ref
							.getModelElement()).getRealObject();
					} else {
						modelElement = (RefObject) ref.getModelElement();
					}
					if (ref.getLookIn() != null) {
						// a lookIn means that the result was added to the
						// parent textblock.
						ModelElement me;
						boolean propertyIsAssocEnd = false;
						try {
							me = ((MofClass) modelElement
								.refMetaObject())
								.lookupElementExtended(ref
									.getPropertyName());
							if (me instanceof TypedElement) {
								TypedElement feature = (TypedElement) me;
								for (RefObject actualValue : refToken
									.getParentBlock()
									.getReferencedElements()) {
									try {
										if (actualValue
											.refIsInstanceOf(
												feature
													.getType(),
												true)) {
											batchParser
												.getInjector()
												.unset(
													modelElement,
													ref
														.getPropertyName(),
													actualValue);
										}
									} catch (Exception ex) {
										// TODO find out
										// which
										// corresponding
										// element was the
										// correct one
										// instead of trying
										// this here
									}
								}
							}
						} catch (JmiException e) {
							propertyIsAssocEnd = true;
						} catch (NameNotFoundException e) {
							propertyIsAssocEnd = true;
						}
						if (propertyIsAssocEnd) {
							// try to find the association end and check
							// there
							// if the correspondingmodelelement
							// is the correct one.
						}
					} else {
						if (refToken.getReferencedElements().size() > 0) {
							for (RefObject value : refToken
								.getReferencedElements()) {
								batchParser.getInjector().unset(
									modelElement,
									ref.getPropertyName(),
									value);
							}
						}
					}
				}
			}
		}
		List<DelayedReference> tmpUnresovedReferences = new ArrayList<DelayedReference>(
			batchParser.getUnresolvedReferences());
		batchParser.setDelayedReferencesAfterParsing();
		Iterator<DelayedReference> newRefIt = tmpUnresovedReferences.iterator();
		while (newRefIt.hasNext()) {
			DelayedReference ref = newRefIt.next();
			if (ref.getType() == DelayedReference.SEMANTIC_PREDICATE
				&& ref.getRealValue() != null
				&& ref.getRealValue() instanceof RefObject) {
				((LexedToken) tbtokenStream.getTokenModelElementForParserToken(ref
					.getToken())).getParentBlock()
					.getCorrespondingModelElements().add(
						(RefObject) ref.getRealValue());
			}
		}

		// for (DelayedReference ref : batchParser.getUnresolvedReferences()) {
		// GlobalDelayedReferenceResolver.getInstance()
		// .registerReferenceForIncrementalEvaluation(
		// ref,
		// (LexedToken) tbtokenStream
		// .getTokenModelElementForParserToken(ref
		// .getToken()), connection);
		// }
		// now all that is left to do is to resolve the proxy of the reference
		// to the previously
		// existing element!!!!
		// if(!batchParser.setDelayedReferencesAfterParsing()){
		// for (DelayedReference ref : batchParser.getUnresolvedReferences()) {
		// //
		// GlobalDelayedReferenceResolver.getInstance().registerUnresolvedReference(ref,
		// (LexedToken) tbtokenStream
		// // .getTokenModelElementForParserToken(ref.getToken()), true);
		// }
		// }
	}

	private TextBlock prepareForParsing(TextBlock commonAncestor,
		ParserTextBlocksHandler parserTextBlocksHandler) {
		parserTextBlocksHandler.setRootBlock(commonAncestor);
		batchParser.reset();
		commonAncestor = findStartableBlock(commonAncestor);
		AbstractToken startToken = TbNavigationUtil.firstTokenWithoutBOS(commonAncestor);
		tbtokenStream.seek(startToken);
		return commonAncestor;
	}

	/**
	 * Assigns the <code>newElement</code> with the given Template <code>template</code> to a
	 * partition according to the given Tag "org.omg.sap2mof.requiresPartition" in the
	 * metamodel. If the tag is false or not specified assigns the <code>newElement</code> to
	 * the partition of the <code>elementInPartition</code>.
	 * 
	 * @param elementInPartition
	 * @param newElement
	 * @param template
	 */

	private void assignToPartition(RefObject elementInPartition, RefObject newElement,
		Template template) {
		// ModelPartition partition = null;
		if (elementInPartition == null) {
			elementInPartition = (RefObject) getDefaultPartition();
		}
		// assignToPartition(elementInPartition.get___Partition(), newElement, template);
		assignToPartition(elementInPartition.get___Partition(), newElement, template);
	}

	/**
	 * Assigns the <code>newElement</code> with the given Template <code>template</code> to a
	 * partition according to the given Tag ""org.omg.sap2mof.requiresPartition" in the
	 * metamodel. If the tag is false or not specified assigns the <code>newElement</code> to
	 * the created partition <code>partition</code> or to the defaultPartition .
	 * 
	 * @param partition
	 * @param newElement
	 * @param template
	 */
	void assignToPartition(ModelPartition partition, RefObject newElement, Template template) {

		if (template != null) {

			if (template instanceof ClassTemplate) {

				ClassTemplate classTemplate = (ClassTemplate) template;
				classTemplate.getPartitionHandling();
				PRI originalPartition = partition.getPri();

				/*
				 * the automatic partition of ClassTemplate
				 */

				if (classTemplate.getPartitionHandling() == null) {
					

					// to check if the default partition has been set from the
					// concrete syntax
					if (concreteSyntax != null) {
						if(concreteSyntax.getPartitionHandling() != null){
							partition = mainPartition;
							partition.assignElementIncludingChildren(newElement);
						}
					}else {
						partition = getDefaultPartition();
						partition
							.assignElementIncludingChildren(newElement);
					}
					

				} else if (classTemplate.getPartitionHandling()
					.isAutomaticPartition()) {

					assignToPartitionAutomatic(partition, originalPartition,
						newElement, classTemplate);
					/*
					 * The manual partition of ClassTemplate
					 */

				} else if (!classTemplate.getPartitionHandling()
					.isAutomaticPartition()) {

					assignToPartitionNotAutomatic(partition, originalPartition,
						newElement, classTemplate);
				}
				/*
				 * the case without Template
				 */

			} else if (!(template instanceof ClassTemplate)) {
				PRI originalPartition = partition.getPri();
				if (mainPartition != null ) {
					assignToPartitionWithoutTemplate(mainPartition, originalPartition,
						newElement);
				} else {
					assignToPartitionWithoutTemplate(partition, originalPartition,
						newElement);

				}

				
			}

		}

	}

	/*
	 * Assign a partition for Property if needed
	 */

	private void assignToPartition(ModelPartition partition, RefObject refObject,
		PartitionHandling partitionHandling) {
		PRI originalPartition = partition.getPri();

		if (partitionHandling == null) {
			// to check if the default partition has been set from the
			// concrete syntax
			if (concreteSyntax != null) {
				if(concreteSyntax.getPartitionHandling() != null){
					partition = mainPartition;
					partition.assignElementIncludingChildren(refObject);
				}
			}else {
				partition = getDefaultPartition();
				partition
					.assignElementIncludingChildren(refObject);
			}

		} else if (partitionHandling.isAutomaticPartition()) {

			assignToPartitionAutomaticForProperty(partition, originalPartition,
				refObject, partitionHandling);
			/*
			 * The manual partition of ClassTemplate
			 */

		} else if (!partitionHandling.isAutomaticPartition()) {

			assignToPartitionNotAutomaticForProperty(partition, originalPartition,
				refObject, partitionHandling);
		}
		

	}

	// automatic partition for Properties
	private void assignToPartitionAutomaticForProperty(ModelPartition partition,
		PRI originalPartition, RefObject refObject, PartitionHandling partitionHandling) {

		if ((partitionHandling.getContainer() == null)
			&& (partitionHandling.getName() == null)) {

			if (mainPartition != null) {
				partition = mainPartition; // the partition of the main (concrete
				// syntax will be taken)
			} else {
				partition = connection.getPartition(originalPartition);// the
				// original
				// partition
				// will
				// be
				// taken

			}

		} else if ((partitionHandling != null) && (partitionHandling.getName() == null)) {
			PRI newTargetPRI = connection.getSession().getMoin().createPri(
				originalPartition.getDataAreaDescriptor().getFacilityId(),
				originalPartition.getDataAreaDescriptor().getDataAreaName(),
				partitionHandling.getContainer(),
				originalPartition.getPartitionName()); // The
			// original
			// name
			// will
			// be
			// taken
			partition = connection.createPartition(newTargetPRI);

		} else if ((partitionHandling.getContainer() == null)
			&& (partitionHandling.getName() != null)) {
//			if (refObject instanceof ConcreteSyntax) {
//				PRI newTargetPRI = connection.getSession().getMoin().createPri(
//					originalPartition.getDataAreaDescriptor().getFacilityId(),
//					originalPartition.getDataAreaDescriptor().getDataAreaName(),
//					originalPartition.getContainerName(),
//					evaluatedOCLForProperty(refObject, partitionHandling));
//				
//				if (connection.getPartition(newTargetPRI) != null) {
//					partition = connection.getPartition(newTargetPRI);
//				} else {
//
//					partition = connection.createPartition(newTargetPRI);
//				}

//			} else {
				PRI newTargetPRI = connection.getSession().getMoin().createPri(
					originalPartition.getDataAreaDescriptor().getFacilityId(),
					originalPartition.getDataAreaDescriptor().getDataAreaName(),
					originalPartition.getContainerName(),
					 evaluatedOCLForProperty(refObject, partitionHandling));
				
				if (connection.getPartition(newTargetPRI) != null) {
					partition = connection.getPartition(newTargetPRI);
				} else {

					partition = connection.createPartition(newTargetPRI);
				}


//			}
			
			
			
		}

		partition.assignElementIncludingChildren(refObject);
		
//		if ((refObject instanceof ConcreteSyntax) && (partitionHandling != null)) {
//			mainPartition = partition;
//		}

	}

	// automatic partition for classTemplate
	private void assignToPartitionAutomatic(ModelPartition partition, PRI originalPartition,
		RefObject newElement, ClassTemplate classTemplate) {

		if ((classTemplate.getPartitionHandling().getContainer() == null)
			&& (classTemplate.getPartitionHandling().getName() == null)) {
			if (mainPartition != null) {
				partition = mainPartition;
			} else {
				partition = connection.getPartition(originalPartition);// the
				// original
				// partition
				// will
				// be
				// taken

			}

		} else if ((classTemplate.getPartitionHandling() != null)
			&& (classTemplate.getPartitionHandling().getName() == null)) {
			PRI newTargetPRI = connection.getSession().getMoin().createPri(
				originalPartition.getDataAreaDescriptor().getFacilityId(),
				originalPartition.getDataAreaDescriptor().getDataAreaName(),
				classTemplate.getPartitionHandling().getContainer(),
				originalPartition.getPartitionName()); // The
			// original
			// name
			// will
			// be
			// taken
			partition = connection.createPartition(newTargetPRI);

		} else if ((classTemplate.getPartitionHandling().getContainer() == null)
			&& (classTemplate.getPartitionHandling().getName() != null)) {
			PRI newTargetPRI = connection.getSession().getMoin().createPri(
				originalPartition.getDataAreaDescriptor().getFacilityId(),
				originalPartition.getDataAreaDescriptor().getDataAreaName(),
				originalPartition.getContainerName(),
				evaluateOCL(newElement, classTemplate));

			if (connection.getPartition(newTargetPRI) != null) {
				partition = connection.getPartition(newTargetPRI);
			} else {

				partition = connection.createPartition(newTargetPRI);
			}
		}

		partition.assignElementIncludingChildren(newElement);

	}

	// to assign the partition for elements that are not ClassTemplate
	private void assignToPartitionWithoutTemplate(ModelPartition partition,
		PRI originalPartition, RefObject newElement) {
		originalPartition = partition.getPri();
		PRI targetPRI = connection.getSession().getMoin().createPri(
			originalPartition.getDataAreaDescriptor().getFacilityId(),
			originalPartition.getDataAreaDescriptor().getDataAreaName(),
			originalPartition.getContainerName(),
			getPartitionName(newElement, originalPartition.getPartitionName()));

		if (connection.partitionExists(targetPRI)) {
			partition = connection.getPartition(targetPRI);
		} else {
			partition = connection.createPartition(targetPRI);
		}
		partition.assignElementIncludingChildren(newElement);

	}

	// not automatic partition for Properties
	private void assignToPartitionNotAutomaticForProperty(ModelPartition partition,
		PRI originalPartition, RefObject refObject, PartitionHandling partitionHandling) {

		PRI targetPRI = interactivePartitionHandler.getPartitionFor(partitionHandling,
			partition, refObject, connection);

		if (targetPRI != null) {
			// to check if the partition already exists!
			if (connection.partitionExists(targetPRI)) {
				partition = connection.getPartition(targetPRI);
			} else {
				partition = connection.createPartition(targetPRI);

			}
//			if ((refObject instanceof ConcreteSyntax) && (partitionHandling != null)) {
//				mainPartition = partition;
//			}

		} else {
			/*
			 * the user don´t want a manual partition
			 */
			if (mainPartition != null) {
				partition = mainPartition;
			} else {
				partition = getDefaultPartition();
			}

		}
		partition.assignElementIncludingChildren(refObject);
		
//		if ((refObject instanceof ConcreteSyntax) && (partitionHandling != null)) {
//			mainPartition = partition;
//		}
		
		

	}

	// not automatic partition for classTemplate
	private void assignToPartitionNotAutomatic(ModelPartition partition, PRI originalPartition,
		RefObject newElement, ClassTemplate classTemplate) {

		PRI targetPRI = interactivePartitionHandler.getPartitionFor(classTemplate
			.getPartitionHandling(), partition, newElement, connection);

		if (targetPRI != null) {
			// to check if the partition already exists!
			if (connection.partitionExists(targetPRI)) {
				partition = connection.getPartition(targetPRI);
			} else {
				partition = connection.createPartition(targetPRI);

			}

		} else {
			/*
			 * the user don´t want a manual partition
			 */

			if (mainPartition != null) {
				partition = mainPartition; // The DefaultPartition is set from the
				// concretesyntax
			} else {
				partition = getDefaultPartition();
			}

		}
		partition.assignElementIncludingChildren(newElement);

	}

	public void setInteractivePartitionHandler(InteractivePartitionHandler iph) {
		this.interactivePartitionHandler = iph;

	}

	private String evaluatedOCLForProperty(RefObject inputRefObject,
		PartitionHandling partitionHandling) {

		RefObject refObject = inputRefObject;

		String evaluatedOCL = "";
		packagesForLookup = new RefPackage[1];
		packagesForLookup[0] = refObject.refOutermostPackage();

		OclExpressionRegistration reg = (OclExpressionRegistration) connection
			.getOclRegistryService().getFreestyleRegistry().getRegistration(
				refObject.get___Mri().toString());
		if (reg == null) {

			try {

				refObject.refOutermostPackage().getClass().getPackage();

				reg = connection.getOclRegistryService().getFreestyleRegistry()
					.createExpressionRegistration(
						refObject.get___Mri().toString(),
						partitionHandling.getName(),
						OclRegistrationSeverity.Warning,
						new String[] { "TCSPropertyQuery" },
						refObject.refClass(), packagesForLookup);
			} catch (JmiException e) {
				e.printStackTrace();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}
			
		}

		try {
			evaluatedOCL = reg.evaluateExpression(refObject).toString();
		} catch (OclManagerException e) {
			e.printStackTrace();
		}
	

		return evaluatedOCL;

	}

	private String evaluateOCL(RefObject inputRefObject, Template template) {
		RefObject refObject = null;

		if (inputRefObject instanceof TextBlock) {
			TextBlock tb = (TextBlock) inputRefObject;

			if (((TextBlock) inputRefObject).getCorrespondingModelElements().size() > 1) {
				for (RefObject newRefObject : ((TextBlock) inputRefObject)
					.getCorrespondingModelElements()) {
					if (newRefObject.refIsInstanceOf(template
						.getMetaReference(), true)) {
						refObject = newRefObject;
						break;

					}
				}
			} else {
				refObject = ((TextBlock) inputRefObject)
					.getCorrespondingModelElements().iterator().next();
			}

			template = null;
			if (refObject.refIsInstanceOf(tb.getType().getParseRule()
				.getMetaReference(), false)) {
				template = tb.getType().getParseRule();
			} else {
				for (Template addTemp : tb.getAdditionalTemplates()) {
					if (refObject.refIsInstanceOf(addTemp.getMetaReference(),
						false)) {
						template = addTemp;
						break;
					}
				}
			}
		} else {
			refObject = inputRefObject;
		}

		String evaluatedOCL = "";
		packagesForLookup = new RefPackage[1];
		packagesForLookup[0] = refObject.refOutermostPackage();

		ClassTemplate classTemplate = (ClassTemplate) template;
		OclExpressionRegistration reg = (OclExpressionRegistration) connection
			.getOclRegistryService().getFreestyleRegistry().getRegistration(
				refObject.get___Mri().toString());
		if (reg == null) {

			try {

				refObject.refOutermostPackage().getClass().getPackage();

				reg = connection.getOclRegistryService().getFreestyleRegistry()
					.createExpressionRegistration(
						refObject.get___Mri().toString(),
						classTemplate.getPartitionHandling().getName(),
						OclRegistrationSeverity.Warning,
						new String[] { "TCSPropertyQuery" },
						refObject.refClass(), packagesForLookup);
			} catch (JmiException e) {
				e.printStackTrace();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}

			

		}
		
		try {
			evaluatedOCL = reg.evaluateExpression(refObject).toString();
		} catch (OclManagerException e) {
			e.printStackTrace();
		}

		return evaluatedOCL;

	}

	/**
	 * Finds a suitable starting point which means that the block needs to have a
	 * {@link TextBlockDefinition type} as well as an associated template. The root block is
	 * returned if nothing below is found as it should always be startable.
	 * 
	 * @param commonAncestor
	 * @return The first block in an ascending search that fulfills the above criteria.
	 */
	private TextBlock findStartableBlock(TextBlock commonAncestor) {
		if (commonAncestor.getParentBlock() == null) {
			// root block should be always startable
			return commonAncestor;
		} else {
			if (commonAncestor.getType() != null
				&& commonAncestor.getType().getParseRule() != null &&
				// TODO check how a call to an operator template rule may be
				// done!
				!(commonAncestor.getType().getParseRule() instanceof OperatorTemplate)) {
				if (commonAncestor.getParentBlock().getTokens().size() == 0) {
					// parent has no own tokens so we need to start at this one
					return findStartableBlock(commonAncestor.getParentBlock());
				}
				return commonAncestor;
			} else {
				return findStartableBlock(commonAncestor.getParentBlock());
			}
		}
	}

	private String getPartitionName(RefObject newElement, String originalPartitionName) {
		String ts = Long.toHexString(System.currentTimeMillis());
		String name = null;
		java.lang.reflect.Method[] methods = newElement.getClass().getMethods();
		for (java.lang.reflect.Method m : methods) {
			if (m.getName().equals("getName")) {
				try {
					name = (String) m.invoke(newElement);
					break;
				} catch (Exception e) {
					// do nothing;
				}
			}
		}
		if (name == null) {
			name = (String) newElement.refMetaObject().refGetValue("name");
		}
		if (originalPartitionName != null && originalPartitionName.lastIndexOf('.') > 0) {
			return originalPartitionName.substring(0, originalPartitionName
				.lastIndexOf("/") + 1)
				+ name
				+ ts
				+ originalPartitionName.substring(originalPartitionName
					.lastIndexOf('.'));
		} else {
			return "src/" + name + ts + ".xmi";
		}
	}

	/**
	 * The root block needs some special treatment if new element is created for it. This is
	 * done here.
	 * 
	 * @param newRoot
	 * @param oldRoot
	 */
	private static void handleUltraRoot(TextBlock newRoot, TextBlock oldRoot) {
		// add BOS and EOS token as this is never copied by the algorithm
		AbstractToken bos = (AbstractToken) getSubNodeAt(oldRoot, 0);
		AbstractToken eos = (AbstractToken) getSubNodeAt(oldRoot,
			getSubNodesSize(oldRoot) - 1);
		bos.setParentBlock(null);
		eos.setParentBlock(null);
		eos.setOffset(newRoot.getLength());
		TbChangeUtil.addToBlockAt(newRoot, 0, bos);
		TbChangeUtil.addToBlockAt(newRoot, getSubNodesSize(newRoot), eos);

		newRoot.setCachedString(oldRoot.getCachedString());
	}

	/**
	 * Merges the existing tree of the old version text block with the newly created parts from
	 * the given proxy.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 * @returnncr
	 */
	private TextBlock mergeTbModelFromProxies(TextBlock oldVersion, TextBlockProxy newVersion) {
		TextBlock result = null;

		TbBean resultBean = reuseStrategy.reuseTextBlock(oldVersion, newVersion);

		TokenRelocationUtil.makeRelativeOffsetRecursively(resultBean.textBlock);
		result = resultBean.textBlock;
		
		
		
		if ((mainPartitionContent != null)
			&& ((mainPartitionContent.equalsIgnoreCase("all")) || (mainPartitionContent
				.equalsIgnoreCase("textblocks")))) {
			assignToPartition(oldVersion.get___Partition(), result, result.getType()
				.getParseRule());
		}

		if (resultBean.reuseType.equals(ITextBlockReuseStrategy.ReuseType.DELETE)) {
			// the element that was created for the new textblock has to be
			// added to the composite
			// of the old one
			// i.e., the old element has to be deleted as it is obsol2te now.
			if (TcsUtil.isStructureTypeTemplate(result.getType().getParseRule())
				|| TcsUtil.isReferenceOnly(newVersion.getTemplate())) {
				// TODO maybe also do this for non compositely referenced
				// elements??
				IModelElementProxy value = null;
				if (TcsUtil
					.isStructureTypeTemplate(result.getType().getParseRule())) {
					value = newVersion.getCorrespondingModelElements()
						.iterator().next();
				} else if (TcsUtil.isReferenceOnly(newVersion.getTemplate())) {
					value = newVersion.getReferencedElements().iterator()
						.next();
				}

				Property property = (Property) newVersion.getSequenceElement();

				// the case that there is no property

				if ((property instanceof Property) && (property != null)) {
					SetNewFeatureBean bean = new SetNewFeatureBean(oldVersion
						.getParentBlock().getCorrespondingModelElements()
						.iterator().next(), ((Property) oldVersion
						.getSequenceElement()).getPropertyReference()
						.getStrucfeature().getName(),
						value.getRealObject(), 0, property);
					setNewFeature(bean, false);
				} else {
					SetNewFeatureBean bean = new SetNewFeatureBean(oldVersion
						.getParentBlock().getCorrespondingModelElements()
						.iterator().next(), ((Property) oldVersion
						.getSequenceElement()).getPropertyReference()
						.getStrucfeature().getName(),
						value.getRealObject(), 0, property);
					setNewFeature(bean, false);
				}

			} else {
				replaceCorrespondingModelElements(oldVersion, result);
			}
			if (!result.equals(oldVersion)) {
				// a new tb was instantiated for the root node
				copyAttributes(oldVersion, result);
			}
		} else if (resultBean.reuseType.equals(ITextBlockReuseStrategy.ReuseType.INSERT)) {
			TokenRelocationUtil.makeRelativeOffsetRecursively(oldVersion);
			boolean insertBefore = oldVersion.getOffset() >= resultBean.textBlock
				.getOffset();
			SetNewFeatureBean newFeatureBean = IncrementalParsingUtil
				.insertFeatureValue(resultBean.textBlock, oldVersion, insertBefore);
			setNewFeature(newFeatureBean, true);
		} else if (resultBean.reuseType.equals(ITextBlockReuseStrategy.ReuseType.COMPLETE)) {
			// no further actions have to be done, the tb was completely re-used
			// (might not apply to
			// its subblocks,
			// however, all those changes will have been considered already
		}
		if (oldVersion.getParentBlock() != null) {
			TextBlock parentBlock = oldVersion.getParentBlock();
			int index = TbNavigationUtil.getSubNodes(parentBlock).indexOf(oldVersion);
			if (oldVersion.getOffset() < resultBean.textBlock.getOffset()) {
				index++;
			}
			// add new tb at position of old one
			TbChangeUtil.addToBlockAt(parentBlock, index, result);
			// if the result text block was not the root block
			// update its position within its parent as well
			TokenRelocationUtil.makeSubNodesRelative(parentBlock);
		}
		if (resultBean.reuseType.equals(ReuseType.DELETE) && !result.equals(oldVersion)) {
			if (TbNavigationUtil.isUltraRoot(oldVersion)) {
				handleUltraRoot(result, oldVersion);
			}
			// the old textblocks should be empty now so delete them
			oldVersion.refDelete();
		}
		return result;
	}

	// private TextBlock reuseBlockAndMoveTokens(TextBlockProxy newVersion,
	// TextBlock oldVersion) {
	// return reuseStrategy.reuseTextBlock(oldVersion, newVersion);
	// }

	/**
	 * Instantiates a new {@link TextBlock} for the {@link TextBlockProxy} while moving all
	 * tokens that were captured there into the new block. Furthermore it calls itself
	 * recursively to add new blocks for its subBlock Proxies.
	 * 
	 * @param newVersion
	 *                The Proxy to instatiate
	 * @param parent
	 *                The parent textblock
	 * @return the newly instantiated {@link TextBlock} for the given proxy.
	 */
	private TextBlock instantiateBlockAndMoveTokens(TextBlockProxy newVersion, TextBlock parent) {
		TextBlock tb = tbFactory.createBlock();
		TextBlockDefinition tbDef = getTbDef(newVersion.getTemplate());
		tb.setType(tbDef);
		tb.setSequenceElement(newVersion.getSequenceElement());
		tb.getAdditionalTemplates().addAll(newVersion.getAdditionalTemplates());
		changedBlocks.add(tb);

		int endIndex = 0;
		for (Object subNode : newVersion.getSubNodes()) {
			if (subNode instanceof TextBlockProxy) {
				if (((TextBlockProxy) subNode).getSubNodes().size() > 0) {
					// do not create textBlocks for proxies that have no content
					// this may be the case for example with rules for elements
					// that have no correspondence in the concrete syntax and
					// have been generated by rules containing only property
					// inits.
					addToBlockAt(tb, endIndex++, instantiateBlockAndMoveTokens(
						(TextBlockProxy) subNode, tb));
				}
			} else if (subNode instanceof AbstractToken) {
				TokenRelocationUtil.relocateToken((AbstractToken) subNode,
					endIndex++, tb);
				reuseStrategy.notifyTokenReuse((AbstractToken) subNode);
			}
		}
		tb.getCorrespondingModelElements().addAll(createModelElements(newVersion));
		// Add all elements in the context to the textblock
		for (Object elementInContext : newVersion.getContextElements()) {
			if (elementInContext instanceof IModelElementProxy) {
				if (((IModelElementProxy) elementInContext).getRealObject() == null) {
					throw new IncrementalParsingException(
						"Element in context was not resolved: "
							+ elementInContext);
				}
				tb.getElementsInContext().add(
					(RefObject) ((IModelElementProxy) elementInContext)
						.getRealObject());
			} else if (elementInContext instanceof RefObject) {
				tb.getElementsInContext().add((RefObject) elementInContext);
			}
		}
		// if the template has specified the addToContext property we need to
		// add the corresponding element
		// to the context
		if (newVersion.getTemplate() instanceof ClassTemplate) {
			if (((ClassTemplate) newVersion.getTemplate()).isAddToContext()) {
				// move up to the first parent textblock that has the context
				// property set
				TextBlock loopParent = parent;
				while (loopParent != null) {
					if (TcsUtil.isContext(loopParent.getType().getParseRule())) {
						loopParent.getElementsInContext().addAll(
							tb.getCorrespondingModelElements());
						break;
					}
					loopParent = loopParent.getParentBlock();
				}
			}
		}
		return tb;
	}

	/**
	 * Method implemented for interface
	 * {@link ITextBlockCreator#createNewTextBlock(TextBlockProxy)}
	 */
	@Override
	public TextBlock createNewTextBlock(TextBlockProxy proxy, TextBlock parent) {
		// createModelElements(proxy);
		return instantiateBlockAndMoveTokens(proxy, parent);
	}

	private Collection<RefObject> createModelElements(TextBlockProxy newVersion) {
		List<RefObject> elements = new ArrayList<RefObject>(newVersion
			.getCorrespondingModelElements().size());

		for (IModelElementProxy proxy : newVersion.getCorrespondingModelElements()) {

			if (proxy instanceof ModelElementProxy) {
				Template template = null;
				if (((ModelElementProxy) proxy).getType().equals(
					newVersion.getTemplate().getMetaReference()
						.getQualifiedName())) {
					template = newVersion.getTemplate();
				} else {
					for (Template addTemp : newVersion.getAdditionalTemplates()) {
						if (((ModelElementProxy) proxy).getType().equals(
							addTemp.getMetaReference()
								.getQualifiedName())) {
							template = addTemp;
							break;
						}
					}
				}

				instantiateProxy(elements, (proxy), template, getDefaultPartition());

			}
		}
		return elements;
	}

	private void instantiateProxy(List<RefObject> elements, IModelElementProxy proxy,
		Template template, ModelPartition partition) {

		// only instantiate if it was not already instantiated
		if (proxy.getRealObject() == null) {
			// if there are any unresolved proxies left in the attribute
			// list this originates from a left recursive refactored
			// operator template, so try to resolve elements on the left
			resolveUnresolvedProxies((ModelElementProxy) proxy, template, partition);

			Object result = batchParser.createOrResolve(proxy,
				(ANTLR3LocationToken) ((ModelElementProxy) proxy).getFirstToken(),
				(ANTLR3LocationToken) ((ModelElementProxy) proxy).getLastToken());
			if (result != null) {
				if (result instanceof RefObject) {
					elements.add((RefObject) result);
					batchParser.setLocationAndComment(result,
						((ModelElementProxy) proxy).getFirstToken());

					if (!proxy.isReferenceOnly()) {
						// assign to builded partition

						if (proxy.getSequenceElement() instanceof Property) {
							if ((TcsUtil
								.getPartitionHandlingParg((Property) proxy
									.getSequenceElement()) != null)
								&& (((Property) proxy
									.getSequenceElement())
									.getPropertyArgs() != null)) {
								// to lcheck

								if ((mainPartitionContent
									.equalsIgnoreCase("all"))
									|| (mainPartitionContent
										.equalsIgnoreCase("model"))
									|| (TcsUtil
										.getPartitionHandlingParg(
											(Property) proxy
												.getSequenceElement())
										.getPartitionHandling()
										.getContent()
										.toString()
										.equalsIgnoreCase("all"))
									|| (TcsUtil
										.getPartitionHandlingParg(
											(Property) proxy
												.getSequenceElement())
										.getPartitionHandling()
										.getContent()
										.toString()
										.equalsIgnoreCase("model"))) {
									
									// the model element will be
									// stored just when content
									// equals all or model
									assignToPartition(
										partition,
										(RefObject) result,
										(PartitionHandling) TcsUtil
											.getPartitionHandlingParg((Property) proxy
												.getSequenceElement()));
								}

							}
						}  else {

							if ((mainPartitionContent
								.equalsIgnoreCase("all"))
								|| (mainPartitionContent
									.equalsIgnoreCase("model"))) {
								assignToPartition(partition,
									(RefObject) result,
									template);

							} else {
								

								assignToPartition(partition,
									(RefObject) result,
									template);
							}

						}

					}

				} else if (result instanceof StructureTypeMockObject) {
					// try {
					// adapterJmiHelper.actualCreateFromMock((StructureTypeMockObject)
					// result);
					// } catch (DeferredModelElementCreationException e) {
					// throw new IncrementalParsingException(e);
					// }
				} else {
					// throw new RuntimeException(
					// "Expected to resolve element to RefObject but got: "
					// + result);
				}
			} else {
				batchParser.discardProxy(proxy);
			}
			for (DelayedReference delayedRef : batchParser.getUnresolvedReferences()) {
				if (delayedRef.getModelElement().equals(proxy.getRealObject())
					|| (proxy.getRealObject() != null && proxy.getRealObject()
						.equals(delayedRef.getContextElement()))) {
					newlyResolvableReferences.add(delayedRef);
				}
			}
		} else {
			elements.add((RefObject) proxy.getRealObject());
		}
	}

	private ModelPartition getDefaultPartition() {
		return defaultPartition;
	}

	/**
	 * Removes all unresolved proxies from the attribute list of the given proxy.
	 * 
	 * @param proxy
	 */
	private void resolveUnresolvedProxies(ModelElementProxy proxy, Template template,
		ModelPartition partition) {
		// ModelPartition partition = template.get___Partition();
		for (String key : proxy.getAttributeMap().keySet()) {
			List<Object> value = proxy.getAttributeMap().get(key);
			for (Iterator<Object> iterator = value.iterator(); iterator.hasNext();) {
				Object element = iterator.next();
				if (element instanceof IModelElementProxy) {
					if (((IModelElementProxy) element).getRealObject() == null) {
						instantiateProxy(new ArrayList<RefObject>(),
							(IModelElementProxy) element, template,
							partition);
						// iterator.remove();
					}
				}
			}
		}
	}

	/**
	 * Replaces the the elements referenced as corresponding model elements by the oldVersion
	 * {@link TextBlock} with the elements referenced by the newVersion {@link TextBlock} within
	 * the oldVersions parent.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 */
	private void replaceCorrespondingModelElements(TextBlock oldVersion, TextBlock newVersion) {
		Collection<RefObject> correspondingModelElements = oldVersion
			.getCorrespondingModelElements();
		if (!correspondingModelElements.isEmpty()) {
			// TODO if there is more than one element this seems to be
			// difficult,
			// which composite is used then?
			// some check which parent is in a deeper hierarchy than the other
			// one
			// has to be done..
			Collection<RefObject> elementsToDelete = new ArrayList<RefObject>(1);
			for (RefObject correspondingModelElement : correspondingModelElements) {

				RefObject parent = (RefObject) correspondingModelElement
					.refImmediateComposite();

				if (parent != null) {
					CompositeRefAssociationBean compositeFeatureAssocBean = findComposingFeature(
						parent, correspondingModelElement);

					if (compositeFeatureAssocBean != null
						&& compositeFeatureAssocBean.compositeFeatureAssoc != null) {
						// TODO currently only a heuristic using the index
						// within the corresponding
						// model elements
						// and the type of the corresponding model element
						// is
						// used to do a matching
						// between the old
						// and the new model element. this has to be
						// improved to
						// ensure correctness!
						Collection<RefObject> correspondingNew = new ArrayList<RefObject>(
							1);
						for (RefObject correspondingNewCandidate : newVersion
							.getCorrespondingModelElements()) {
							// TODO Change orderdness of
							// correspondingmodel
							// elements to true
							// if(newVersion.getCorrespondingModelElements().indexOf(correspondingNewCandidate)
							// ==
							// oldVersion.getCorrespondingModelElements().indexOf(correspondingModelElement)){
							AssociationEnd assignToEnd = null;
							if (compositeFeatureAssocBean.isParentFirstEnd) {
								assignToEnd = connection
									.getJmiHelper()
									.getAssociationEnds(
										compositeFeatureAssocBean.compositeFeatureAssoc
											.refMetaObject())
									.get(1);
							} else {
								assignToEnd = connection
									.getJmiHelper()
									.getAssociationEnds(
										compositeFeatureAssocBean.compositeFeatureAssoc
											.refMetaObject())
									.get(0);
							}
							if (correspondingNewCandidate
								.refIsInstanceOf(assignToEnd
									.getType(), true)) {
								correspondingNew
									.add(correspondingNewCandidate);
							}
							// }
						}
						// delete the old corresponding ModelElement
						// assuming that only those elements are in the
						// correspondingModelElements association
						// that were the textblock is responsible for the
						// life-time
						// decision meaning if the textblock is deleted its
						// corresponding model
						// elements are also deleted
						// only delete if it is not re-used
						if (!newVersion.getCorrespondingModelElements()
							.contains(correspondingModelElement)) {
							elementsToDelete
								.add(correspondingModelElement);
							// Remove from feature
							if (compositeFeatureAssocBean.isParentFirstEnd) {
								compositeFeatureAssocBean.compositeFeatureAssoc
									.refRemoveLink(parent,
										correspondingModelElement);
							} else {
								compositeFeatureAssocBean.compositeFeatureAssoc
									.refRemoveLink(
										correspondingModelElement,
										parent);
							}
						}
						for (RefObject correspondingNewElement : correspondingNew) {
							// only add if it is not contained within
							// another
							// corresponding model element.
							// boolean isOutermostComposite = true;
							// for (RefObject correspondingNewElement2 :
							// correspondingNew) {
							// if
							// (correspondingNewElement.refImmediateComposite().equals(correspondingNewElement2))
							// {
							// isOutermostComposite = false;
							// }
							// }
							if (correspondingNewElement
								.refImmediateComposite() == null) {
								if (compositeFeatureAssocBean.isParentFirstEnd) {
									compositeFeatureAssocBean.compositeFeatureAssoc
										.refAddLink(parent,
											correspondingNewElement);
								} else {
									compositeFeatureAssocBean.compositeFeatureAssoc
										.refAddLink(
											correspondingNewElement,
											parent);
								}
								boolean isInTransientPartition = isInTransientPartition(correspondingNewElement);
								if (isInTransientPartition) {

									if (((mainPartitionContent
										.equalsIgnoreCase("all")) || (mainPartitionContent
										.equalsIgnoreCase("model")))) {
										assignToPartition(
											parent,
											correspondingNewElement,
											newVersion
												.getType()
												.getParseRule());
									}

								}
							}
						}
						if (correspondingNew.size() > 0) {
							// @Christian: The old implementation

							if (((mainPartitionContent
								.equalsIgnoreCase("all")) || (mainPartitionContent
								.equalsIgnoreCase("model")))) {
								newVersion
									.assign___PartitionIncludingChildren(oldVersion
										.get___Partition());
							}

							// assignToPartition(parent, newVersion,
							// newVersion.getType().getParseRule());

						}

					} else {
						// may be a root element that is composed nowhere
						// so just delete old corresponding elements
						List<RefObject> oldElements = new ArrayList<RefObject>(
							oldVersion.getCorrespondingModelElements());
						for (RefObject refObject : oldElements) {
							elementsToDelete.add(refObject);
						}
					}
				} else {
					// may be a root element that is composed nowhere
					// so just delete old corresponding elements
					List<RefObject> oldElements = new ArrayList<RefObject>(
						oldVersion.getCorrespondingModelElements());
					for (RefObject refObject : oldElements) {
						elementsToDelete.add(refObject);
					}
					// parent is null so assign new element to partition of old
					// one
					for (RefObject correspondingNewCandidate : newVersion
						.getCorrespondingModelElements()) {

						if (((mainPartitionContent.equalsIgnoreCase("all")) || (mainPartitionContent
							.equalsIgnoreCase("model")))) {
							assignToPartition(
								correspondingModelElement,
								correspondingNewCandidate,
								newVersion.getType().getParseRule());
						}
					}
				}
			}
			for (RefObject elementToDelete : elementsToDelete) {
				elementToDelete.refDelete();
			}
		}
	}

	private boolean isInTransientPartition(RefObject correspondingNewElement) {
		boolean isInTransientPartition = false;
		for (ModelPartition part : connection.getTransientPartitions()) {
			if (correspondingNewElement.get___Partition().getPri()
				.equals(part.getPri())) {
				isInTransientPartition = true;
			}
		}
		if (correspondingNewElement.get___Partition().getPri().equals(
			connection.getNullPartition().getPri())) {
			isInTransientPartition = true;
		}
		return isInTransientPartition;
	}

	// /**
	// * Finds the element which is not contained by any of the other elements
	// in the given
	// collection.
	// *
	// * @param correspondingModelElements
	// * @return
	// */
	// private RefObject getOutermostParentCorrespondingModelElement(
	// Collection<RefObject> correspondingModelElements) {
	// Iterator<RefObject> iterator = correspondingModelElements.iterator();
	// RefObject element = iterator.next();
	// while(correspondingModelElements.contains(element.refImmediateComposite()))
	// {
	// //if this element was contents of another corresponding model element
	// //try the next one...
	// element = iterator.next();
	// }
	// return element;
	// }

	/**
	 * Finds the {@link RefAssociation} that is the containment relation between
	 * <code>parent</code> and <code>child</code>;
	 * 
	 * @param parent
	 * @param child
	 * @return
	 */
	private CompositeRefAssociationBean findComposingFeature(RefObject parent, RefObject child) {
		CompositeRefAssociationBean bean = null;
		if (parent != null && child != null) {
			Collection<Association> compositeAssociations = connection.getJmiHelper()
				.getCompositeAssociations((MofClass) parent.refMetaObject(),
					(MofClass) child.refMetaObject());
			for (Association association : compositeAssociations) {
				// as defined in the MOF Spec the immediate composite of an
				// association is always a
				// package
				RefAssociation refAssoc = connection.getJmiHelper()
					.getRefAssociationForAssociation(association);
				if (typesMatch(association, parent.refMetaObject(), child
					.refMetaObject())
					&& refAssoc.refLinkExists(parent, child)) {
					bean = new CompositeRefAssociationBean(refAssoc, true);
					break; // the first valid association is the correct one as
					// there may only be
					// one composite relationship between
					// two elements
				} else if (typesMatch(association, child.refMetaObject(), parent
					.refMetaObject())
					&& refAssoc.refLinkExists(child, parent)) {
					bean = new CompositeRefAssociationBean(refAssoc, false);
					break; // the first valid association is the correct one as
					// there may only be
					// one composite relationship between
					// two elements
				}
			}
		}
		return bean;
	}

	/**
	 * Checks whether the types of the given refObjects match the types of the association ends
	 * of the given association.
	 * 
	 * @param association
	 * @param refMetaObject
	 * @param refMetaObject2
	 * @return
	 */
	private boolean typesMatch(Association association, RefObject refMetaObject,
		RefObject refMetaObject2) {
		List<AssociationEnd> associationEnds = connection.getJmiHelper()
			.getAssociationEnds(association);
		Classifier firstEndType = associationEnds.get(0).getType();
		Classifier secondEndType = associationEnds.get(1).getType();
		if (firstEndType.equals(refMetaObject)
			|| connection.getJmiHelper().getAllSubtypes(firstEndType).contains(
				refMetaObject)) {
			// first end matches, so check second end
			if (secondEndType.equals(refMetaObject2)
				|| connection.getJmiHelper().getAllSubtypes(secondEndType)
					.contains(refMetaObject2)) {
				return true;
			}
		}
		return false;
	}

	private static void copyAttributes(TextBlock oldVersion, TextBlock result) {
		result.setLength(oldVersion.getLength());
		result.setOffsetRelative(oldVersion.isOffsetRelative());
		result.setOffset(oldVersion.getOffset());
		List<DocumentNode> otherVersions = new ArrayList<DocumentNode>(oldVersion
			.getOtherVersions());
		for (DocumentNode otherVersion : otherVersions) {
			oldVersion.getOtherVersions().remove(otherVersion);
			TbUtil.dereferenceVersions(oldVersion, otherVersion);
		}
		TbUtil.referenceVersions(result, otherVersions.get(0));
	}

	/**
	 * Get the {@link TextBlockDefinition} for the given template.
	 * 
	 * @param template
	 * @return
	 */
	private TextBlockDefinition getTbDef(Template template) {
		TextBlockDefinition tbDef = tbDefsMap.get(template);
		if (tbDef == null && template != null) {
			// check if there was already a corresponding tbdef within the
			// mapping definition
			Collection<TextBlockDefinition> tbDefs = textblocksPackage
				.getTextblockdefinition()
				.getTextblockDefinitionReferencesProduction()
				.getTextBlockDefinition(template);
			if (!tbDefs.isEmpty()) {
				if (tbDefs.size() == 1) {
					tbDef = tbDefs.iterator().next();
				} else {
					// TODO What to do if there is more than one?
					// for now this case seems strange, so throw an exception
					throw new IncrementalParsingException(
						"Cannot handle more than one TextBlocksDefinition per Template!");
				}
			} else {
				tbDef = initializeTextBlockDefinition(template);
			}
			tbDefsMap.put(template, tbDef);
		}
		return tbDef;
	}

	/**
	 * Initializes a new {@link TextBlockDefinition} for the given template TODO this should
	 * actually be done during creation of the mapping model.
	 * 
	 * @param template
	 * @return
	 */
	private TextBlockDefinition initializeTextBlockDefinition(Template template) {
		TextBlockDefinition tbDef = (TextBlockDefinition) textblocksPackage
			.getTextblockdefinition().getTextBlockDefinition().refCreateInstance();
		tbDef.setParseRule(template);
		((Partitionable) template).get___Partition().assignElementIncludingChildren(tbDef);
		return tbDef;
	}

	private TextBlock createTextBlock() {
		TextBlock textBlock = (TextBlock) textblocksPackage.getTextBlock()
			.refCreateInstance();
		// TODO: check versioning for incremental parsing and adapt
		// correspondingly here
		textBlock.setVersion(VersionEnum.CURRENT);
		textBlock.setOffsetRelative(true);
		textBlock.setComplete(true); // default
		textBlock.setOffset(0);
		return textBlock;
	}

	/**
	 * Calls the batch parser with to re-parse from the given root block.
	 * 
	 * @param root
	 * @throws SyntaxElementException
	 * @throws JmiException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws UnknownProductionRuleException
	 */
	private void callBatchParser(TextBlock root) throws SyntaxElementException, JmiException,
		SecurityException, NoSuchMethodException, IllegalArgumentException,
		IllegalAccessException, InvocationTargetException, UnknownProductionRuleException {

		// reconstruct the context
		TbUtil.constructContext(root, batchParser);

		String ruleName = null;
		if (root.getType() == null || root.getType().getParseRule() == null) {
			// ensure that the given block was the root block, otherwise
			// parsing won't work
			if (root.getParentBlock() != null) {
				throw new IncrementalParsingException(
					"Could not find a proper starting point for parsing.");
			}
			ruleName = MAIN_PARSE_RULE_NAME;
		} else {
			ruleName = getStartRule(root);
		}
		Method methodToCall = batchParser.getClass().getMethod(ruleName);
		if (!Modifier.isFinal(methodToCall.getModifiers())) {
			throw new UnknownProductionRuleException(ruleName
				+ " is not a production rule in generated Parser.");
		}
		// Object result = methodToCall.invoke(batchParser);
		methodToCall.invoke(batchParser);
	}

	private String getStartRule(TextBlock root) throws SyntaxElementException {
		ClassTemplate template = (ClassTemplate) root.getType().getParseRule();
		return getNamingHelper()
			.getConcreteRuleNameForTemplate(template, getSyntaxLookup());
	}

	private SyntaxLookup getSyntaxLookup() {
		if (syntaxLookup == null) {
			syntaxLookup = new SyntaxLookup(TcsUtil.getSyntaxByName(connection,
				parserFactory.getLanguageId()), null, getResolutionHelper());
		}
		return syntaxLookup;
	}

	private TemplateNamingHelper<RefObject> getNamingHelper() {
		if (namingHelper == null) {
			resolutionHelper = getResolutionHelper();
			namingHelper = new TemplateNamingHelper<RefObject>(resolutionHelper);
		}
		return namingHelper;
	}

	private MetaModelElementResolutionHelper<RefObject> getResolutionHelper() {
		if (resolutionHelper == null) {
			resolutionHelper = new MetaModelElementResolutionHelper<RefObject>(
				new MoinMetaLookup(connection, connection.getSession()
					.getInnerPartitions(
						parserFactory.getMetamodelCri(connection))));
		}
		return resolutionHelper;
	}

	// /**
	// * Get the upper most node n in the tree so that leftBoundary is its
	// * leftmost token.
	// *
	// * @param leftBoundary
	// * @return
	// */
	// private DocumentNode getStartNode(AbstractToken leftBoundary) {
	// DocumentNode result = leftBoundary;
	// TextBlock parent = (TextBlock) result.refImmediateComposite();
	// while (parent != null
	// && TbNavigationUtil.getSubNodeAt(parent, 0).equals(result)) {
	// result = parent;
	// }
	// return result;
	// }

	/**
	 * Searches for the least common ancestor of the given left and right boundary nodes.
	 * 
	 * @param rootNode
	 * @param leftBoundary
	 * @param rightBoundary
	 * @return
	 */
	private static DocumentNode getCommonAncestor(TextBlock rootNode,
		AbstractToken leftBoundary, AbstractToken rightBoundary) {
		TarjansLCA<DocumentNode> lca = new TarjansLCA<DocumentNode>(
			new TextBlocksTarjanTreeContentProvider());
		return lca.lcaSearch(rootNode, leftBoundary, rightBoundary);

	}

	private static class TextBlocksTarjanTreeContentProvider implements
		ITarjanTreeContentProvider<DocumentNode> {

		@Override
		public List<Node<DocumentNode>> getChildren(Node<DocumentNode> node) {
			if (node.getArgumet() instanceof TextBlock) {
				List<? extends DocumentNode> documetNodes = TbNavigationUtil
					.getSubNodes((TextBlock) node.getArgumet());
				List<Node<DocumentNode>> subNodes = new ArrayList<Node<DocumentNode>>(
					documetNodes.size());
				for (DocumentNode subNode : documetNodes) {
					subNodes.add(new Node<DocumentNode>(subNode));
				}
				return subNodes;
			} else {
				return Collections.emptyList();
			}
		}

	}

	public Collection<TextBlock> getChangedBlocks() {
		return changedBlocks;
	}

	/**
	 * Registers tokens that might have an impact on the resolving of references.
	 */
	@Override
	public void registerTokenForReferenceResolving(AbstractToken subNode) {
		tokensForReferenceResolving.add(subNode);
	}

	// the case of Property (To assign a Partition to any Property)

	@Override
	public void setNewFeature(SetNewFeatureBean newFeatureBean, boolean assignToPartition) {

		//		
		batchParser.getInjector().set(newFeatureBean.parentRefObject,
			newFeatureBean.property, newFeatureBean.value, newFeatureBean.valueIndex);

		if (newFeatureBean.value instanceof Partitionable && assignToPartition) {

			if (newFeatureBean.tcs_Property == null) { // it will be stored in the main
				// partition

				if (((mainPartitionContent.equalsIgnoreCase("all")) || (mainPartitionContent
					.equalsIgnoreCase("model")))) {

					if (mainPartition != null) { // it will be stored in the
						// main partition
						mainPartition
							.assignElementIncludingChildren((RefObject) newFeatureBean.value);

					} else {// or it will be stored in the parent partition
						newFeatureBean.parentRefObject.get___Partition()
							.assignElementIncludingChildren(
								(RefObject) newFeatureBean.value);
					}

				}

			} else {
				if (newFeatureBean.tcs_Property.getPropertyArgs() == null) {
					// assign to the default partition that is also the main
					// partition

					PartitionHandling partitionHandling = TcsUtil
						.getPartitionHandlingParg(
							newFeatureBean.tcs_Property)
						.getPartitionHandling();

					if ((mainPartitionContent.equalsIgnoreCase("all"))
						|| (mainPartitionContent.equalsIgnoreCase("model"))
						|| (partitionHandling.getContent().toString()
							.equalsIgnoreCase("model"))
						|| (partitionHandling.getContent().toString()
							.equalsIgnoreCase("all"))) {
						if (mainPartition != null) {
							mainPartition
								.assignElementIncludingChildren((RefObject) newFeatureBean.value);

						} else {
							newFeatureBean.parentRefObject
								.get___Partition()
								.assignElementIncludingChildren(
									(RefObject) newFeatureBean.value);
						}
					}

				} else if (newFeatureBean.tcs_Property.getPropertyArgs().size() > 0) {
					PartitionHandling partitionHandling = TcsUtil
						.getPartitionHandlingParg(
							newFeatureBean.tcs_Property)
						.getPartitionHandling();
					if ((mainPartitionContent.equalsIgnoreCase("all"))
						|| (mainPartitionContent.equalsIgnoreCase("model"))
						|| (partitionHandling.getContent().toString()
							.equalsIgnoreCase("model"))
						|| (partitionHandling.getContent().toString()
							.equalsIgnoreCase("all"))) {
						assignToPartition(newFeatureBean.parentRefObject
							.get___Partition(),
							(RefObject) newFeatureBean.value,
							partitionHandling);
					}

				}
			}

		}

	}

	@Override
	public void unsetFeature(SetNewFeatureBean featureBean) {

		batchParser.getInjector().unset(featureBean.parentRefObject, featureBean.property,
			featureBean.value);
	}

	@Override
	public void setNewPrimitiveFeature(TextBlockProxy newVersion, TextBlock oldVersion,
		AbstractToken subNode) {
		IncrementalParsingUtil.setNewPrimitiveFeature(newVersion, oldVersion, subNode,
			batchParser.getInjector());
	}

	@Override
	public void unsetPrimitiveFeature(TextBlock oldVersion, LexedToken lt) {
		IncrementalParsingUtil.unsetPrimitiveFeature(oldVersion, lt, batchParser
			.getInjector());
	}

	@Override
	public void reEvaluatePropertyInits(TextBlock oldVersion, TextBlockProxy newVersion) {
		if (oldVersion.getCorrespondingModelElements().size() > 0) {
			RefObject modelElement = oldVersion.getCorrespondingModelElements()
				.iterator().next();
			if (newVersion.getCorrespondingModelElements().size() > 0) {
				ModelElementProxy proxy = (ModelElementProxy) newVersion
					.getCorrespondingModelElements().iterator().next();
				// first find out which alternatives have been chosen by
				// walking through all tokens and getting the alternatives
				// from the attached sequence elements
				HashSet<InjectorActionsBlock> actionBlocks = new HashSet<InjectorActionsBlock>();
				for (Object subNode : newVersion.getSubNodes()) {
					if (subNode instanceof LexedToken) {
						LexedToken lexedToken = (LexedToken) subNode;
						SequenceElement seqEl = lexedToken
							.getSequenceElement();
						while (seqEl != null
							&& !(seqEl.getElementSequence()
								.refImmediateComposite() instanceof ClassTemplate || seqEl
								.getElementSequence()
								.refImmediateComposite() instanceof FunctionTemplate)) {
							SequenceElement parentSequenceElement = TcsUtil
								.getContainerSequenceElement(seqEl);
							if (parentSequenceElement instanceof Alternative
								|| parentSequenceElement instanceof ConditionalElement) {
								actionBlocks
									.addAll(TcsUtil
										.getInjectorActions(seqEl
											.getElementSequence()));
								seqEl = parentSequenceElement;
							} else {
								break;
							}
						}
					}
				}
				for (InjectorActionsBlock injectorActionsBlock : actionBlocks) {
					for (InjectorAction injectorAction : injectorActionsBlock
						.getInjectorActions()) {
						if (injectorAction instanceof PrimitivePropertyInit) {
							PrimitivePropertyInit init = (PrimitivePropertyInit) injectorAction;

							String name = init.getPropertyReference()
								.getStrucfeature().getName();
							try {
								modelElement.refGetValue(name);
								List<Object> value = proxy
									.getAttributeMap()
									.get(name);
								if (value != null
									&& value.size() > 0) {
									batchParser
										.getInjector()
										.set(
											modelElement,
											name,
											value
												.iterator()
												.next());
								} else {
									batchParser
										.getInjector()
										.unset(
											modelElement,
											name, null);
								}
							} catch (InvalidNameException ex) {
								// do nothing just try to continue
								// with next element.
							}

						}
					}
				}
			}
		}
	}

	public void recoverMappingLink(TextBlock existingRoot, ClassTemplate rootTemplate)
		throws TextBlockMappingRecoveringFailedException {
		ParserTextBlocksHandler parserTextBlocksHandler = new ParserTextBlocksHandler(
			tbtokenStream, connection, parserFactory.getMetamodelCri(connection),
			TcsUtil.getSyntaxePartitions(connection, parserFactory.getLanguageId()),
			parserFactory.getParserLookupScope(connection), additionalCRIScope);
		// IParsingObserver originalObserver = batchParser.getObserver();
		batchParser.setObserver(parserTextBlocksHandler);
		((ANTLRIncrementalLexerAdapter) batchParser.input.getTokenSource())
			.setCurrentTokenForParser(existingRoot.getTokens().get(0));
		// Ensure no model elements get created
		// only proxies should be created
		boolean originalResolveProxiesValue = batchParser.isResolveProxies();
		prepareForParsing(existingRoot, parserTextBlocksHandler);
		batchParser.setResolveProxies(false);
		try {
			existingRoot.setType(getTbDef(rootTemplate));
			RecoverMappingLinkComand rmlc = new RecoverMappingLinkComand(connection,
				existingRoot, parserTextBlocksHandler);
			connection.getCommandStack().execute(rmlc);
			if (rmlc.hasFailed()) {
				// connection.getCommandStack().undo();
				throw new TextBlockMappingRecoveringFailedException(
					"Cannot recover textblock to mapping link due to the following errors:"
						+ rmlc.getException());
			}
			if (batchParser.getInjector().getErrorList().size() > 1) {
				throw new TextBlockMappingRecoveringFailedException(
					"Cannot recover textblock to mapping link due to the following parse errors:"
						+ batchParser.getInjector().getErrorList());
			}
		} catch (Exception e) {
			throw new TextBlockMappingRecoveringFailedException(e);
		} finally {
			batchParser.setResolveProxies(originalResolveProxiesValue);
		}
	}

	public class RecoverMappingLinkComand extends Command {

		private final TextBlock existingRoot;
		private boolean failed = false;
		private Exception exception;
		private final ParserTextBlocksHandler parserTextBlocksHandler;

		public RecoverMappingLinkComand(Connection con, TextBlock existingRoot,
			ParserTextBlocksHandler parserTextBlocksHandler) {
			super(con);
			this.existingRoot = existingRoot;
			this.parserTextBlocksHandler = parserTextBlocksHandler;

		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			try {
				callBatchParser(existingRoot);
				TextBlockProxy proxy = parserTextBlocksHandler.getCurrentTbProxy();
				recoverMappingLink(existingRoot, proxy);
			} catch (Exception ex) {
				exception = ex;
				failed = true;
			}
		}

		private void recoverMappingLink(TextBlock textBlock, TextBlockProxy proxy) {
			if (proxy.getSubNodes().size() != TbNavigationUtil
				.getSubNodesSize(textBlock)) {
				if (TbNavigationUtil.getSubNodeAt(textBlock, 0) instanceof Bostoken) {
					if (proxy.getSubNodes().size() + 2 != TbNavigationUtil
						.getSubNodesSize(textBlock)) {
						failed = true;
						return;
					}
				} else {
					failed = true;
					return;
				}
			}
			textBlock.setSequenceElement(proxy.getSequenceElement());
			TextBlockDefinition tbDef = getTbDef(proxy.getTemplate());
			if (tbDef == null) {
				failed = true;
				return;
			}
			textBlock.setType(tbDef);
			int i = 0;
			for (DocumentNode n : TbNavigationUtil.getSubNodes(textBlock)) {
				if (n instanceof TextBlock) {
					TextBlockProxy subNodeProxy = (TextBlockProxy) proxy
						.getSubNodes().get(i);
					recoverMappingLink((TextBlock) n, subNodeProxy);
				}
				if (n instanceof LexedToken
					&& ((LexedToken) n).getSequenceElement() == null) {
					((LexedToken) n).setSequenceElement(proxy
						.getSequenceElement());
				}
				if (!(n instanceof Bostoken)) {
					i++;
				}
			}
		}

		private TextBlockDefinition getTbDef(Template t) {
			Collection<TextBlockDefinition> tbDefs = getConnection().getPackage(
				TextblocksPackage.PACKAGE_DESCRIPTOR).getTextblockdefinition()
				.getTextblockDefinitionReferencesProduction()
				.getTextBlockDefinition(t);
			if (!tbDefs.isEmpty()) {
				if (tbDefs.size() == 1) {
					return tbDefs.iterator().next();
				} else {
					// TODO What to do if there is more than one?
					// for now this case seems strange, so throw an exception

				}
			}
			return null;
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			Partitionable partitionable = existingRoot;
			PRI pri = partitionable.get___Partition().getPri();
			PartitionOperation editOperation = new PartitionOperation(
				PartitionOperation.Operation.EDIT, pri);
			return Collections.singleton(editOperation);
		}

		public boolean hasFailed() {
			return failed;
		}

		public void setException(Exception exception) {
			this.exception = exception;
		}

		public Exception getException() {
			return exception;
		}

	}

	@Override
	public Object getFeatureValue(RefObject modelElement, String featureName) {
		try {
			return batchParser.getInjector().getModelAdapter().get(modelElement,
				featureName);
		} catch (ModelAdapterException e) {
			// TODO really log this error?
			Activator.logError(e);
			return null;
		}
	}

}
