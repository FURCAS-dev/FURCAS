package com.sap.ide.cts.parser.incremental;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodeAt;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodesSize;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.nextToken;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.isEOS;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.exceptions.DeferredModelElementCreationException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.ModelElementFromTextBlocksFactory;
import com.sap.furcas.runtime.parser.textblocks.TbParsingUtil;
import com.sap.furcas.runtime.parser.textblocks.TextBlockFactory;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.parser.textblocks.observer.TokenRelocationUtil;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException.Component;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategy.ReuseType;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategy.TbBean;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalTokenStream;
import com.sap.ide.cts.parser.incremental.util.ITarjanTreeContentProvider;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA.Node;

public class IncrementalParser extends IncrementalRecognizer {

    private static final String MAIN_PARSE_RULE_NAME = "main";

    private final TextBlockReuseStrategy reuseStrategy;
    private final ReferenceHandler referenceHandler;

    protected final ObservableInjectingParser batchParser;
    protected final ITextBlocksTokenStream tbtokenStream;

    protected final ParserScope parserScope;
    private final TemplateNamingHelper<EObject> namingHelper;

    protected final PartitionAssignmentHandler partitionHandler;

    public IncrementalParser(ObservableInjectingParser batchParser, ParserScope parserScope,
            TextBlockReuseStrategy reuseStrategy, PartitionAssignmentHandler partitionAssignmentHandler) {
        if (!(batchParser.getTokenStream() instanceof ITextBlocksTokenStream)) {
            throw new IllegalArgumentException("token stream of parser needs to be ITextBlocksTokenStream"
                    + " in order to be used with incremental parser");
        }
        this.parserScope = parserScope;
        this.batchParser = batchParser;
        this.tbtokenStream = (ITextBlocksTokenStream) batchParser.getTokenStream();
        this.partitionHandler = partitionAssignmentHandler;
        this.referenceHandler = new ReferenceHandlerImpl(batchParser, tbtokenStream);

        ModelElementFromTextBlocksFactory modelElementFactory = new ModelElementFromTextBlocksFactoryImpl(batchParser,
                referenceHandler, partitionHandler);
        TextBlockFactory tbFactory = new ReuseAwareTextBlockFactoryImpl(textblocksFactory, reuseStrategy, modelElementFactory);

        this.reuseStrategy = reuseStrategy;
        this.reuseStrategy.setReferenceHandler(referenceHandler);
        this.reuseStrategy.setTextBlockFactory(tbFactory);

        MetaModelElementResolutionHelper<EObject> resolutionHelper = new MetaModelElementResolutionHelper<EObject>(
                parserScope.getMetamodelLookup());
        this.namingHelper = new TemplateNamingHelper<EObject>(resolutionHelper);

    }

    public TextBlock incrementalParse(TextBlock root) throws SemanticParserException {
        return incrementalParse(root, false, new NullProgressMonitor());
    }

    /**
     * Incrementally parses the given root block. The algorithm assumes that all changed blocks and tokens are correctly marked
     * (using {@link DocumentNode#isChildrenChanged()} and {@link DocumentNode#isRelexingNeeded()} (TODO this needs to be changed
     * if there is something like "wasRelexed".). Based on this all regions that became invalid due to lexical changes are
     * re-parsed and the incrementally merged with the existing text block tree and model.
     * 
     * @param root
     * @param errorMode
     *            If <code>true</code> ignores syntactical errors and instantiates elements as far as possible.
     * @return returns the (possibly newly created) root block as a result of the parsing.
     * @throws IncrementalParsingException
     */
    public TextBlock incrementalParse(TextBlock root, boolean errorMode, IProgressMonitor monitor) throws SemanticParserException {
        monitor.beginTask("Incremental Parsing", IProgressMonitor.UNKNOWN);
        reset();
        // get EOS and BOS from root block
        setEOSFromRoot(root);
        setBOSFromRoot(root);
        TextBlock newRoot = root;
        // if there is a change
        if (!isEOS(findNextRegion(root))) {

            ParserTextBlocksHandler parserTextBlocksHandler = new ParserTextBlocksHandler(tbtokenStream, parserScope,
                    partitionHandler);
            // IParsingObserver originalObserver = batchParser.getObserver();
            batchParser.setObserver(parserTextBlocksHandler);
            // Ensure no model elements get created
            // only proxies should be created
            boolean originalResolveProxiesValue = batchParser.isResolveProxies();
            batchParser.setResolveProxies(false);

            // find the next changed region
            for (AbstractToken tok = findNextRegion(root); !isEOS(tok); tok = findNextRegion(tok)) {
                if (monitor.isCanceled()) {
                    // it is safe to skip entire regions if the user has canceld the parser.
                    return root;
                }
                AbstractToken leftBoundary = tok;
                // left boundary has to be the element that is reachable by the
                // lookback count of
                // the first changed token
                for (int lookback = leftBoundary.getLookback(); lookback > 0; lookback--) {
                    leftBoundary = TbNavigationUtil.previousToken(leftBoundary);
                }
                AbstractToken rightBoundary = tok;
                tok = nextToken(tok);
                while ((wasReLexed(tok) || tok instanceof OmittedToken)) {
                    rightBoundary = tok;
                    // TODO would it be possible to track the common ancestor
                    // directly in this
                    // routine?
                    // should be, so no further algorithm would be needed!
                    tok = nextToken(tok);
                }
                if (isEOS(tok)) {
                    // We are at the end of the stream. Tokens were touched until here
                    // to make sure the whole stream is valid we need to call the
                    // batch parser from the root block
                    rightBoundary = tok;
                }
                DocumentNode commonAncestorNode = getCommonAncestor(root, leftBoundary, rightBoundary);

                TextBlock commonAncestor = null;
                if (commonAncestorNode instanceof AbstractToken) {
                    // actually just update all model elements that depended
                    // from
                    // this value. As we do not have the knowledge on how to do
                    // this right now
                    // just re-parse the parent element.
                    commonAncestor = ((AbstractToken) commonAncestorNode).getParent();
                } else {
                    commonAncestor = (TextBlock) commonAncestorNode;
                }

                // DocumentNode startNode = getStartNode(leftBoundary);

                // parse the given part of the texblocktree
                commonAncestor = prepareForParsing(commonAncestor, parserTextBlocksHandler);
                boolean errornous = false;
                try {
                    callBatchParser(commonAncestor);
                    while (!errorMode
                            && (getErrorList().size() > 0 || !comsumedAllTokens(commonAncestor, parserTextBlocksHandler))) {
                        // parsing failed, so try to parse with the parent block
                        // and see if it works
                        if (commonAncestor.getParent() != null) {
                            // There is a parent than can be parsed
                            commonAncestor = commonAncestor.getParent();
                            commonAncestor = prepareForParsing(commonAncestor, parserTextBlocksHandler);
                            callBatchParser(commonAncestor);
                        } else {
                            if (getErrorList().size() == 0) {
                                // There is no parent block but and we could parse the block correctly
                                // however, there are still unconsumed tokens
                                // so we have an error in the input
                                ANTLRIncrementalTokenStream tokenStream = (ANTLRIncrementalTokenStream) batchParser
                                        .getTokenStream();
                                AbstractToken unconsumedToken = TbNavigationUtil.nextToken(tokenStream.getLastConsumedToken());
                                getErrorList().add(
                                        new ParsingError("There were uconsumed tokens: " + unconsumedToken.getValue(),
                                                unconsumedToken));
                                errornous = true;
                                break;
                            } else {
                                errornous = true;
                                break;
                            }
                        }
                    }

                    if (batchParser.getInjector().getErrorList().size() > 0 || errornous == true) {
                        if (!errorMode) {
                            throw new SemanticParserException(getErrorList(), Component.SYNTACTIC_ANALYSIS);
                        } else {
                            // ensure errornous is set
                            errornous = true;
                        }
                    }
                    if (monitor.isCanceled()) {
                        // we still haven't changed/created a model element for this region.
                        // It is safe to abort here if the user has canceled the parser.
                        return root;
                    }

                    TextBlockProxy tbProxy = parserTextBlocksHandler.getCurrentTbProxy();

                    // the sequence element context should be still the same, so
                    // copy it
                    tbProxy.setSequenceElement(commonAncestor.getSequenceElement());

                    if (!errornous) {
                        TextBlock newModel = mergeTbModelFromProxies(commonAncestor, tbProxy);
                        if (TbNavigationUtil.isUltraRoot(newModel)) {
                            newRoot = newModel;
                        }

                        // move to the last token of the updated textblock
                        // As the whole block is going to be re-parsed set tok
                        // to
                        // the token after the right
                        // boundary of the common ancestor block. So even if
                        // there are several regions that were isolatedly
                        // changed
                        // they will
                        // all be handled by reparsing this ancestor block.
                        if (!isEOS(tok)) {
                            AbstractToken tokOfNewModel = TbNavigationUtil.lastToken(newModel);
                            if (TbUtil.getAbsoluteOffset(tokOfNewModel) > TbUtil.getAbsoluteOffset(rightBoundary)) {
                                tok = tokOfNewModel;
                            }
                            if (!isEOS(tok)) {
                                tok = nextToken(tok);
                            }
                        }
                    }

                } catch (UnknownProductionRuleException e) {
                    throw new RuntimeException(e);
                }

            }

            if (getErrorList().size() > 0) {
                // This is bad. Something went wrong while merging proxies / modifying the domain model
                throw new IncrementalParsingException("Failed to perform model modifications", getErrorList());
            }
            if (monitor.isCanceled()) {
                // It is safe to abort here if the user has canceld the parser.
                return root;
            }

            // provide context for reference resolving.
            parserTextBlocksHandler.setRootBlock(newRoot);

            // batchParser.setObserver(originalObserver);
            batchParser.setResolveProxies(originalResolveProxiesValue);
            referenceHandler.resolveRemainingReferences();

            if (getErrorList().size() > 0) {
                throw new SemanticParserException(getErrorList(), Component.SEMANTIC_ANALYSIS);
            }
        }
        monitor.done();
        return newRoot;
    }

    /**
     * Searches for the least common ancestor of the given left and right boundary nodes.
     * 
     * @param rootNode
     * @param leftBoundary
     * @param rightBoundary
     * @return
     */
    private DocumentNode getCommonAncestor(TextBlock rootNode, AbstractToken leftBoundary, AbstractToken rightBoundary) {
        TarjansLCA<DocumentNode> lca = new TarjansLCA<DocumentNode>(new IncrementalParser.TextBlocksTarjanTreeContentProvider());
        return lca.lcaSearch(rootNode, leftBoundary, rightBoundary);

    }

    /**
     * Checks if there are unconsumed tokens in the given <tt>commonAncestor</tt> block. If that is the case the method will
     * return <tt>false</tt>. Otherwise possibly remaining {@link OmittedToken}s will be added to the root block of the
     * {@link ParserTextBlocksHandler} and <tt>true</tt> will be returned.
     * 
     * @param commonAncestor
     *            The {@link TextBlock} from which the consumption of its tokens should be checked.
     * @param parserTextBlocksHandler
     *            The {@link ParserTextBlocksHandler} which consumed the last tokens.
     * @return <tt>true</tt> if all tokens in the given <tt>commonAncestor</tt> have been consumed, <tt>flase</tt> else.
     */
    private boolean comsumedAllTokens(TextBlock commonAncestor, ParserTextBlocksHandler parserTextBlocksHandler) {
        // TODO if last new token was last consumed and the parent rule does
        // match the parent block
        // we should return true
        AbstractToken tok = ((ANTLRIncrementalTokenStream) batchParser.getTokenStream()).getLastConsumedToken();
        if (tok == null) {
            parserTextBlocksHandler.notifyTokenConsume(Token.EOF_TOKEN);
            return true;
        }
        AbstractToken nextTok = TbNavigationUtil.nextToken(tok);
        while (nextTok instanceof OmittedToken && !(nextTok instanceof Eostoken)) {
            nextTok = TbNavigationUtil.nextToken(nextTok);
        }
        if (nextTok != null) {
            if (nextTok instanceof Eostoken) {
                // we are at the end of the stream,
                parserTextBlocksHandler.notifyTokenConsume(Token.EOF_TOKEN);
                return true;
            }
            if (TbVersionUtil.getOtherVersion(tok, Version.REFERENCE) == null) {
                if (TbVersionUtil.getOtherVersion(nextTok, Version.REFERENCE) != null) {
                    // this is the edge between new and existing tokens, so TODO
                    // we need to check if the parent rule
                    // still matches
                    // this is a clean insert
                    return true;
                }

            }
        }
        boolean lastTokenOfBlockConsumed = ((ANTLRIncrementalTokenStream) batchParser.getTokenStream()).getLastConsumedToken()
                .equals(TbNavigationUtil.lastToken(commonAncestor));
        return lastTokenOfBlockConsumed;
    }

    public List<ParsingError> getErrorList() {
        return batchParser.getInjector().getErrorList();
    }

    private void reset() {
        referenceHandler.reset();
        reuseStrategy.clearChangedBlocksList();
    }

    /* package */TextBlock prepareForParsing(TextBlock commonAncestor, ParserTextBlocksHandler parserTextBlocksHandler) {
        parserTextBlocksHandler.setRootBlock(commonAncestor);
        batchParser.reset();
        commonAncestor = findStartableBlock(commonAncestor);
        AbstractToken startToken = TbNavigationUtil.firstTokenWithoutBOS(commonAncestor);
        tbtokenStream.seek(startToken);
        return commonAncestor;
    }

    /**
     * Finds a suitable starting point which means that the block needs to have a {@link TextBlockDefinition type} as well as an
     * associated template. The root block is returned if nothing below is found as it should always be startable.
     * 
     * @param commonAncestor
     * @return The first block in an ascending search that fulfills the above criteria.
     */
    private TextBlock findStartableBlock(TextBlock commonAncestor) {
        if (commonAncestor.getParent() == null) {
            // root block should be always startable
            return commonAncestor;
        } else {
            if (commonAncestor.getType() != null && commonAncestor.getType() != null &&
            // TODO check how a call to an operator template rule may be
            // done!
                    !(commonAncestor.getType() instanceof OperatorTemplate)) {
                if (commonAncestor.getParent().getTokens().size() == 0) {
                    // parent has no own tokens so we need to start at this one
                    return findStartableBlock(commonAncestor.getParent());
                }
                return commonAncestor;
            } else {
                return findStartableBlock(commonAncestor.getParent());
            }
        }
    }

    /**
     * The root block needs some special treatment if new element is created for it. This is done here.
     * 
     * @param newRoot
     * @param oldRoot
     */
    private static void handleUltraRoot(TextBlock newRoot, TextBlock oldRoot) {
        // add BOS and EOS token as this is never copied by the algorithm
        AbstractToken bos = (AbstractToken) getSubNodeAt(oldRoot, 0);
        AbstractToken eos = (AbstractToken) getSubNodeAt(oldRoot, getSubNodesSize(oldRoot) - 1);
        bos.setParent(null);
        eos.setParent(null);
        eos.setOffset(newRoot.getLength());
        TbChangeUtil.addToBlockAt(newRoot, 0, bos);
        TbChangeUtil.addToBlockAt(newRoot, getSubNodesSize(newRoot), eos);

        newRoot.setCachedString(oldRoot.getCachedString());
    }

    /**
     * Merges the existing tree of the old version text block with the newly created parts from the given proxy.
     * 
     * @param oldVersion
     * @param newVersion
     * @return
     */
    private TextBlock mergeTbModelFromProxies(TextBlock oldVersion, TextBlockProxy newVersion) {
        TextBlock result = null;

        TbBean resultBean;
        try {
            resultBean = reuseStrategy.reuseTextBlock(oldVersion, newVersion);
        } catch (DeferredModelElementCreationException e) {
            throw new IncrementalParsingException(e.getMessage(), getErrorList());
        }

        TokenRelocationUtil.makeRelativeOffsetRecursively(resultBean.textBlock);
        TbValidationUtil.assertTextBlockConsistencyRecursive(resultBean.textBlock);

        result = resultBean.textBlock;
        if (result.eResource() == null) {
            partitionHandler.assignToDefaultTextBlocksPartition(result);
        }
        if (resultBean.reuseType.equals(TextBlockReuseStrategy.ReuseType.DELETE)) {
            // the element that was created for the new textblock has to be
            // added to the composite of the old one
            // i.e., the old element has to be deleted as it is obsolete now.
            if (/*
                 * TcsUtil.isStructureTypeTemplate(result.getType().getParseRule( )) ||
                 */TcsUtil.isReferenceOnly(newVersion.getTemplate())) {
                // TODO maybe also do this for non compositely referenced
                // elements??
                IModelElementProxy value = null;
                // if (TcsUtil.isStructureTypeTemplate(result.getType()
                // .getParseRule())) {
                // value = newVersion.getCorrespondingModelElementProxies()
                // .iterator().next();
                // } else
                if (TcsUtil.isReferenceOnly(newVersion.getTemplate())) {
                    value = newVersion.getReferencedElementProxies().iterator().next();
                }

                SetNewFeatureBean bean = new SetNewFeatureBean(oldVersion.getParent().getCorrespondingModelElements().iterator()
                        .next(), ((Property) oldVersion.getSequenceElement()).getPropertyReference().getStrucfeature().getName(),
                        value.getRealObject(), 0);
                referenceHandler.setNewFeature(bean, false);
            } else {
                replaceCorrespondingModelElements(oldVersion, result);
            }
            if (!result.equals(oldVersion)) {
                // a new tb was instantiated for the root node
                IncrementalParsingUtil.copyAttributes(oldVersion, result);
            }
        } else if (resultBean.reuseType.equals(TextBlockReuseStrategy.ReuseType.INSERT)) {
            TokenRelocationUtil.makeRelativeOffsetRecursively(oldVersion);
            boolean insertBefore = oldVersion.getOffset() >= resultBean.textBlock.getOffset();
            SetNewFeatureBean newFeatureBean = IncrementalParsingUtil.insertFeatureValue(resultBean.textBlock, oldVersion,
                    insertBefore);
            referenceHandler.setNewFeature(newFeatureBean, true);
        } else if (resultBean.reuseType.equals(TextBlockReuseStrategy.ReuseType.COMPLETE)) {
            // no further actions have to be done, the tb was completely re-used
            // (might not apply to its subblocks,
            // however, all those changes will have been considered already
        }
        if (oldVersion.getParent() != null && oldVersion != result) {
            TextBlock parentBlock = oldVersion.getParent();
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
            TbChangeUtil.delete(oldVersion);
        }
        return result;
    }

    /**
     * Replaces the the elements referenced as corresponding model elements by the oldVersion {@link TextBlock} with the elements
     * referenced by the newVersion {@link TextBlock} within the oldVersions parent.
     * 
     * @param oldVersion
     * @param newVersion
     */
    @SuppressWarnings("unchecked")
    private void replaceCorrespondingModelElements(TextBlock oldVersion, TextBlock newVersion) {
        Collection<EObject> correspondingModelElements = oldVersion.getCorrespondingModelElements();
        if (!correspondingModelElements.isEmpty()) {
            // TODO if there is more than one element this seems to be
            // difficult, which composite is used then?
            // some check which parent is in a deeper hierarchy than the other
            // one has to be done..
            Set<EObject> elementsToDelete = new HashSet<EObject>(1);
            for (EObject correspondingModelElement : correspondingModelElements) {

                EObject parent = correspondingModelElement.eContainer();

                if (parent != null) {
                    IncrementalParsingUtil.CompositeRefAssociationBean compositeFeatureAssocBean = IncrementalParsingUtil
                            .findComposingFeature(parent, correspondingModelElement, parserScope.getResourceSet());

                    if (compositeFeatureAssocBean != null && compositeFeatureAssocBean.compositeFeatureAssoc != null) {
                        // TODO currently only a heuristic using the index
                        // within the corresponding
                        // model elements
                        // and the type of the corresponding model element is
                        // used to do a matching
                        // between the old
                        // and the new model element. this has to be improved to
                        // ensure correctness!
                        Collection<EObject> correspondingNew = new ArrayList<EObject>(1);
                        for (EObject correspondingNewCandidate : newVersion.getCorrespondingModelElements()) {
                            // TODO Change orderdness of correspondingmodel
                            // elements to true
                            // if(newVersion.getCorrespondingModelElements().indexOf(correspondingNewCandidate)
                            // ==
                            // oldVersion.getCorrespondingModelElements().indexOf(correspondingModelElement)){
                            if (compositeFeatureAssocBean.compositeFeatureAssoc.getEType().isInstance(correspondingNewCandidate)) {
                                correspondingNew.add(correspondingNewCandidate);
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
                        if (!newVersion.getCorrespondingModelElements().contains(correspondingModelElement)) {
                            elementsToDelete.add(correspondingModelElement);
                            // Remove from feature
                            // if (compositeFeatureAssocBean.isParentFirstEnd) {
                            if (compositeFeatureAssocBean.compositeFeatureAssoc.getUpperBound() == 1) {
                                parent.eUnset(compositeFeatureAssocBean.compositeFeatureAssoc);
                            } else {
                                ((Collection<?>) parent.eGet(compositeFeatureAssocBean.compositeFeatureAssoc))
                                        .remove(correspondingModelElement);
                            }
                            // } else {
                            // compositeFeatureAssocBean.compositeFeatureAssoc
                            // .refRemoveLink(
                            // correspondingModelElement,
                            // parent);
                            // }
                        }
                        for (EObject correspondingNewElement : correspondingNew) {
                            // only add if it is not contained within another
                            // corresponding model element.
                            // boolean isOutermostComposite = true;
                            // for (EObject correspondingNewElement2 :
                            // correspondingNew) {
                            // if
                            // (correspondingNewElement.refImmediateComposite().equals(correspondingNewElement2))
                            // {
                            // isOutermostComposite = false;
                            // }
                            // }
                            if (correspondingNewElement.eContainer() == null) {
                                // if
                                // (compositeFeatureAssocBean.isParentFirstEnd)
                                // {
                                if (compositeFeatureAssocBean.compositeFeatureAssoc.getUpperBound() == 1) {
                                    parent.eSet(compositeFeatureAssocBean.compositeFeatureAssoc, correspondingNewElement);
                                } else {
                                    ((EList<EObject>) parent.eGet(compositeFeatureAssocBean.compositeFeatureAssoc))
                                            .add(correspondingNewElement);
                                }
                                // } else {
                                // compositeFeatureAssocBean.compositeFeatureAssoc
                                // .refAddLink(
                                // correspondingNewElement,
                                // parent);
                                // }
                                boolean isInTransientPartition = IncrementalParsingUtil
                                        .isInTransientPartition(correspondingNewElement);
                                if (isInTransientPartition) {
                                    partitionHandler.assignToPartition(correspondingNewElement, parent);
                                }
                            }
                        }
                        if (correspondingNew.size() > 0) {
                            partitionHandler.assignToDefaultTextBlocksPartition(newVersion);
                        }

                    } else {
                        // may be a root element that is composed nowhere
                        // so just delete old corresponding elements
                        List<EObject> oldElements = new ArrayList<EObject>(oldVersion.getCorrespondingModelElements());
                        for (EObject refObject : oldElements) {
                            elementsToDelete.add(refObject);
                        }
                    }
                } else {
                    // may be a root element that is composed nowhere
                    // so just delete old corresponding elements
                    List<EObject> oldElements = new ArrayList<EObject>(oldVersion.getCorrespondingModelElements());
                    for (EObject refObject : oldElements) {
                        elementsToDelete.add(refObject);
                    }
                    // parent is null so assign new element to partition of old
                    // one
                    for (EObject correspondingNewCandidate : newVersion.getCorrespondingModelElements()) {
                        partitionHandler.assignToPartition(correspondingNewCandidate, correspondingModelElement);
                    }
                }
            }
            for (EObject elementToDelete : elementsToDelete) {
                if (EcoreHelper.isAlive(elementToDelete)) {
                    EcoreUtil.delete(elementToDelete, true);
                }
            }
        }
    }

    /**
     * Calls the batch parser with to re-parse from the given root block.
     * 
     */
    /* package */void callBatchParser(TextBlock root) throws UnknownProductionRuleException {

        // reconstruct the context
        // TODO is it correct to use the parent block to start looking for contexts or should the search start at root?
        TbParsingUtil.constructContext(root.getParent(), batchParser);

        String ruleName = null;
        try {
            if (root.getType() == null || root.getType() == null) {
                // ensure that the given block was the root block, otherwise
                // parsing won't work
                if (root.getParent() != null) {
                    throw new IncrementalParsingException("Could not find a proper starting point for parsing.", getErrorList());
                }
                ruleName = MAIN_PARSE_RULE_NAME;
            } else {
                ruleName = getStartRule(root);
            }
            Method methodToCall = batchParser.getClass().getMethod(ruleName);
            if (!Modifier.isFinal(methodToCall.getModifiers())) {
                throw new UnknownProductionRuleException(ruleName + " is not a production rule in generated Parser.");
            }
            // Object result = methodToCall.invoke(batchParser);
            methodToCall.invoke(batchParser);
        } catch (NoSuchMethodException e) {
            throw new UnknownProductionRuleException("Parser has no rule named " + ruleName);
        } catch (IllegalArgumentException e) {
            throw new UnknownProductionRuleException("Failed to call production rule " + ruleName);
        } catch (IllegalAccessException e) {
            throw new UnknownProductionRuleException("Failed to call production rule " + ruleName);
        } catch (InvocationTargetException e) {
            throw new IncrementalParsingException("Generated parser crashed", e.getCause());
        } catch (SyntaxElementException e) {
            throw new UnknownProductionRuleException("Could not find production rule to parse " + root.getType(), e);
        }
    }

    private String getStartRule(TextBlock root) throws SyntaxElementException {
        ClassTemplate template = (ClassTemplate) root.getType();
        return namingHelper.getConcreteRuleNameForTemplate(template, parserScope.getSyntaxLookup());
    }

    public static class TextBlocksTarjanTreeContentProvider implements ITarjanTreeContentProvider<DocumentNode> {

        @Override
        public List<Node<DocumentNode>> getChildren(Node<DocumentNode> node) {
            if (node.getArgumet() instanceof TextBlock) {
                List<? extends DocumentNode> documetNodes = TbNavigationUtil.getSubNodes((TextBlock) node.getArgumet());
                List<Node<DocumentNode>> subNodes = new ArrayList<Node<DocumentNode>>(documetNodes.size());
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
        return reuseStrategy.getChangedBlocks();
    }

}
