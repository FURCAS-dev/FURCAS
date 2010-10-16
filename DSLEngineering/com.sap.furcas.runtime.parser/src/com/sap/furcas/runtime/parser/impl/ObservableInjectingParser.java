/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationTokenImpl;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;


/**
 * Class used as superclass for generated parser/Injectors which allows
 * observing of syntax processing events and token matching events. Assumes
 * generated parser calls the methods in this class on events. The parser is
 * stateful, separate parse calls should be separated by resetParser() in
 * between. All non-private methods are final to ensure that in the unlikely
 * case of a generated parser rule method overwriting a method, this does not
 * compile (would require renaming of modelelements or patch to name of
 * methods).
 * 
 * Also see in class comments.
 */
public abstract class ObservableInjectingParser extends ObservablePatchedParser
		implements ContextBuilder {

	/*
	 * The implementation assumes parser rules to follow a certain convention to
	 * ensure Model injection works. Rules which create ModelElements should do
	 * so by calling createModelElementProxy(), then set() or setRef() several
	 * times, then commitCreation or discardProxy (which is in this case called
	 * by onErrorInTemplateRule). Finally setDelayedReferencesAfterParsing needs
	 * to be called. createModelElementProxy() will create an IModelElementProxy
	 * Object which should have a lifecylce which ends in any case when the rule
	 * that created it is finished.
	 * 
	 * A Syntax may declare Elements to be contexts for other elements, and the
	 * parser keeps track of the context elements using a Stack of proxies and
	 * the ContextManager Class. The context only becomes relevant for Delayed
	 * References with a path referring to the context. Since as explained above
	 * ModelElements should be created at the end of rules, the Stack will only
	 * ever contain modelElement proxies. When that context is left, the proxy
	 * is being replaced by the actual ModelElement, in the contextmanager and
	 * all delayed references.
	 * 
	 * In sum, there are two different concepts for deferred actions,
	 * IModelElementProxy defers ModelElement creation to the end of a rule
	 * (when properties have been set), and DelayedReferences defers Reference
	 * creation to the end of the whole parsing process (when ModelElements to
	 * be referred to could have been created).
	 */

	/**
	 * The reference to the model injector, which allows creating modelElements
	 * during parsing.
	 */
	private com.sap.furcas.runtime.parser.IModelInjector injector = null;

	private ContextManager contextManager;

	/** The delayed reference list. */
	private List<DelayedReference> delayedReferenceList;
	/**
	 * the list of delayed references with referents that have not yet been
	 * resolved or created
	 */
	private List<DelayedReference> unResolvedDelayedReferenceList;

	/** stack context proxies */
	private java.util.Stack<IModelElementProxy> currentContextStack;
	
	/**
	 * When a "foreach" predicate is used, the values computed by its OCL expression
	 * are assigned to this attribute before invoking the parse rule for the subtemplate
	 * identified by the foreach construct. The parser can then use it when creating
	 * {@link DelayedReference}s such that when the reference uses "#foreach" in its
	 * OCL expression, it can replace the "#foreach" occurrences by "self" and use the
	 * element denoted by this attribute as context for the OCL expression instead.<p>
	 * 
	 * A single element is sufficient, no stack is required, because when a "foreach"
	 * predicate reference is evaluated, while the parser rule is executed, should new
	 * "foreach" references be created, they won't be resolved before the parser has
	 * finished. Therefore, no nesting can occur at runtime.
	 * 
	 * The value may be of type {@link RefObject}, {@link String}, {@link Boolean} or {@link Number}. 
	 */
	private Object currentForeachElement;

	/**
	 * Specifies if proxies should be resolved dureing parsing or if the
	 * resolving is triggered explicitely
	 */
	private boolean resolveProxies = true;

	private String languageId;

	/**
	 * @param input
	 * @param state
	 */
	public ObservableInjectingParser(TokenStream input,
			RecognizerSharedState state) {
		super(input, state);
		resetParser();
	}
	
	/**
         * @param input
         * @param state
         */
        public ObservableInjectingParser(TokenStream input) {
                super(input);
                resetParser();
        }

	public ContextManager getContextManager() {
		return contextManager;
	}

	public Stack<IModelElementProxy> getCurrentContextStack() {
		return currentContextStack;
	}

	protected Object getCurrentForeachElement() {
	    return currentForeachElement;
	}

	protected void setCurrentForeachElement(Object currentForeachElement) {
	    this.currentForeachElement = currentForeachElement;
	}

	public void initParser(ContextManager manager,
			Stack<IModelElementProxy> currentContext) {
		contextManager = manager;
		currentContextStack = currentContext;
	}

	/**
     * 
     */
	public final void resetParser() {
		contextManager = initContextManager();
		currentContextStack = new Stack<IModelElementProxy>();
		delayedReferenceList = new ArrayList<DelayedReference>();
		unResolvedDelayedReferenceList = new ArrayList<DelayedReference>();
	}

	@Override
	public void reset() {
		super.reset();
		// clear errors
		if (injector != null) {
			injector.getErrorList().clear();
		}
		resetParser();
	}

	/**
	 * util method intended for test mocks to override, to break class
	 * dependency
	 * 
	 * @return
	 */
	protected ContextManager initContextManager() {
		return new ContextManager();
	}

	protected final IModelElementProxy createModelElementProxy(
			List<String> name, boolean context, boolean addToContext) {
		return createModelElementProxy(name, context, addToContext,
				(String[]) null);
	}

	/**
	 * 
	 * @param name
	 * @param context
	 * @param addToContext
	 * @return
	 */
	protected final IModelElementProxy createModelElementProxy(
			List<String> name, boolean context, boolean addToContext,
			String... tags) {
		IModelElementProxy element = new ModelElementProxy(name, true, input
				.LT(1));
		// conditionally adding if addToContext==true
		if (addToContext) {
			addToCurrentContext(element);
		}

		if (context) { // this element is relevant as context for setting
			// delayed references
			addContext(element, tags);
		}

		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.textual.grammar.impl.ContextBuilder#addToContext(com.sap.mi
	 * .textual.grammar.IModelElementProxy, java.lang.String)
	 */
	@Override
	public void addContext(IModelElementProxy element, String... tags) {

		IModelElementProxy currentContextElement = getCurrentContextElement();
		if (currentContextElement != null) {
			// create context using proxy for now, need to replace the proxy by
			// real object after
			// resolution / creation
			contextManager.addContextChildFor(currentContextElement, element,
					tags);
		} else {
			contextManager.addRootContext(element, tags);
		}

		currentContextStack.push(element);
	}

	/**
	 * 
	 * @param name
	 * @param context
	 * @param addToContext
	 * @return
	 */
	protected final IModelElementProxy createReferenceProxy(List<String> name) {
		IModelElementProxy element = new ModelElementProxy(name, false, input
				.LT(1));

		return element;
	}

	/**
	 * 
	 * @param me
	 */
	@Override
	public void addToCurrentContext(Object me) {
		Object currentContext = getCurrentContextElement();
		if (currentContext == null) {
			throw new RuntimeException(
					"Bug in DSL, addToContext called without context.");
			// TODO: for incremental parsing maybe set context manually before
			// calling rule
		}
		contextManager.addToContext(currentContext, me);
	}

	/**
     * 
     */
	protected final void leaveContext() {
		try {
			List<Object> elementsInContext = contextManager
					.getElementsInContext(getCurrentContextElement());
			if (elementsInContext != null) {
				for (Object elementInContext : elementsInContext) {
					onElementAddedToContext(elementInContext);
				}
			}
			currentContextStack.pop();
		} catch (EmptyStackException e) {
			throw new RuntimeException(
					"BUG: leave Context called more often than enterContext.");
		}
	}

	/**
	 * convenience Method creating or resolving proxies having just one token.
	 * 
	 * @param object
	 * @param token
	 * @return
	 */
	public final Object createOrResolve(Object object, Token token) {
		if (resolveProxies) {
			return createOrResolve(object, (ANTLR3LocationToken) token,
					(ANTLR3LocationToken) token);
		} else {
			return object;
		}
	}

	/**
	 * finalizes creation, turns the proxy created at the beginning of a rule
	 * into a real Modelelement
	 * 
	 * @param object
	 * @param token
	 * @param firstToken
	 * @return
	 */
	public final Object createOrResolve(Object object,
			ANTLR3LocationToken firstToken, ANTLR3LocationToken lastToken) {
		Object result = null;
		IModelElementProxy proxy = (IModelElementProxy) object;
		try {
			result = injector.createOrResolve(proxy, firstToken, lastToken);
		} catch (ModelElementCreationException e) {
			injector.addError(new ParsingError(e.getMessage(),
					createTextLocationBetween(firstToken, lastToken)));
		}
		if (result != null) {
			contextManager.notifyProxyResolvedWith(proxy, result,
					getCurrentContextElement());
			// now we still have DelayedReferences being set in the context of
			// this object.
			ArrayList<DelayedReference> tempResolvedDelayedReferenceList = new ArrayList<DelayedReference>();
			for (Iterator<DelayedReference> it = unResolvedDelayedReferenceList
					.iterator(); it.hasNext();) {
				DelayedReference ref = it.next();

				// Check if the unresolved reference is trying to resolve some
				// feature of the
				// element represented by object:
				if (ref.getModelElement().equals(object)) {
					// if so, the resolved object proxy (result) can now be
					// substituted in the reference
					ref.setModelElement(result);
					// if not to be resolved by a context lookup, do a deferred
					// lookup
					if (ref.getContextElement() == null) {
						tempResolvedDelayedReferenceList.add(ref);
					}
					// Those with a context lookup will be handled below
				}
				// TODO what if the context-Proxy gets resolved before the
				// modelElement proxy? Then the DelayedReference would no longer
				// be in unResolvedDelayedReferenceList and therefore the
				// modelElement wouldn't be correctly substituted.
				if (ref.getContextElement() != null
						&& ref.getContextElement().equals(object)) {
					// now both modelElement and context should be resolved.
					ref.setContextElement(result);
					tempResolvedDelayedReferenceList.add(ref);
				}
			}
			for (Iterator<DelayedReference> iterator = tempResolvedDelayedReferenceList
					.iterator(); iterator.hasNext();) {
				DelayedReference delayedReference = iterator.next();
				unResolvedDelayedReferenceList.remove(delayedReference);
				delayedReferenceList.add(delayedReference);
			}
		} else {
			// resolution or creation of object from proxy failed, errors should
			// have been generated
			// in other places.
			ArrayList<DelayedReference> tempObsoleteDelayedReferenceList = new ArrayList<DelayedReference>();
			for (Iterator<DelayedReference> it = unResolvedDelayedReferenceList
					.iterator(); it.hasNext();) {
				DelayedReference ref = it.next();
				if (ref.getModelElement().equals(object)) {
					tempObsoleteDelayedReferenceList.add(ref);
				}
				if (ref.getContextElement() != null
						&& ref.getContextElement().equals(object)) {
					tempObsoleteDelayedReferenceList.add(ref);
				}
			}
			for (Iterator<DelayedReference> iterator = tempObsoleteDelayedReferenceList
					.iterator(); iterator.hasNext();) {
				DelayedReference delayedReference = iterator.next();
				unResolvedDelayedReferenceList.remove(delayedReference);
			}
		}
		return result;
	}

	/**
	 * the method to call to get the root modelElement parsed (or a collection
	 * or roots, if allowed by the syntax)
	 * 
	 * @return
	 * @throws RecognitionException
	 */
	public abstract Object main() throws RecognitionException;

	/**
	 * Execute a parse run with a dummy ModelInjector that actually does not
	 * create any model element. This may be useful if you only want to do a
	 * syntax check without creating model elements at all.
	 * 
	 * @return
	 * @throws RecognitionException
	 */
	public List<ParsingError> checkSyntaxWithoutInjecting() {
		// store current Injector to restore it afterwards
		IModelInjector temp = getInjector();

		// The getTokenNames is overwritten in the generated Parser to not
		// return null.
		DummyModelInjector dummyModelInjector = new DummyModelInjector(
				getTokenNames());
		setInjector(dummyModelInjector);
		try {
			main();
		} catch (RecognitionException e) {
			reportError(e);
		}
		setInjector(temp);
		return dummyModelInjector.getErrorList();

	}

	/**
	 * ANTLR method to report some error.
	 */
	@Override
	public final void displayRecognitionError(String[] tokenNames,
			RecognitionException e) {
		injector.reportError(e);
	}

	/**
	 * This method is called for modelElements to be created by templates. Since
	 * actual creation is delayed until the end of the rule, the commit method
	 * has to check whether the modelElement can be created (or resolved) and or
	 * not.
	 * 
	 * @param ret
	 * @param firstToken
	 * @param leaveContext
	 * @return
	 */
	protected final Object commitCreation(Object ret, Token firstToken,
			boolean leaveContext) {
		Object ret2 = ret;
		ANTLR3LocationToken lastToken = getANTLRToken(input.LT(-1));
		if (resolveProxies) {
			// firstToken will always be null if used with scannerless parsing
			if (firstToken != null) {
				ANTLR3LocationToken firstANTLRToken = getANTLRToken(firstToken);
				ret2 = createOrResolve(ret, firstANTLRToken, lastToken);
			} else {
				ret2 = createOrResolve(ret, null, null);
			}

			if (ret2 != null && firstToken != null) {
				this.setLocationAndComment(ret2, firstToken);
			} else {
				discardProxy(ret);
			}
		} else {
			if (ret instanceof ModelElementProxy) {
				((ModelElementProxy) ret).setLastToken(lastToken);
			}
		}
		if (ret2 != null) {
			onRuleElementCreationCommited(ret2);
		}
		if (leaveContext) {
			leaveContext();
		}
		return ret2;
	}

	/**
	 * @param firstToken
	 * @return
	 */
	private static ANTLR3LocationToken getANTLRToken(Token firstToken) {
		if (firstToken == null) {
			return null;
		}
		if (firstToken instanceof ANTLR3LocationToken) {
			return (ANTLR3LocationToken) firstToken;
		} else {
			CommonToken castToken = (CommonToken) firstToken;
			ANTLR3LocationToken convertedToken = new ANTLR3LocationTokenImpl(
					castToken.getType(), castToken.getText());
			convertedToken.setChannel(castToken.getChannel());
			convertedToken.setCharPositionInLine(castToken
					.getCharPositionInLine());
			convertedToken.setLine(castToken.getLine());
			convertedToken.setTokenIndex(castToken.getTokenIndex());
			convertedToken.setStartIndex(castToken.getStartIndex());
			convertedToken.setStopIndex(castToken.getStopIndex());
			return convertedToken;
		}
	}

	/**
	 * sets Location of modelElement using the firstToken parameter as start and
	 * the token before the current token of the input stream as last token.
	 * Stream = {..., first, x, y, z, last, current, ...} -> Location = {first,
	 * x, y, z, last}
	 * 
	 * @param ret
	 * @param firstTokenInBlock
	 */
	public final void setLocationAndComment(Object ret,
			org.antlr.runtime.Token firstTokenInBlock) {
		// get last token in current textBlock (meaning there may be n tokens
		// between first and lastToken)
		ANTLR3LocationToken lastTokenInBlock = (ANTLR3LocationToken) input
				.LT(-1);

		TextLocation location = createTextLocationBetween(firstTokenInBlock,
				lastTokenInBlock);

		injector.setLocation(ret, location);

		injector.setCommentsBefore(ret, input, firstTokenInBlock);

		if (lastTokenInBlock != null) {
			injector.setCommentsAfter(ret, input, lastTokenInBlock);
		}
	}

	/**
	 * creates a Textlocation between two tokens including the first char of the
	 * first token and the last char of the last token. Assumes last comes after
	 * first.
	 * 
	 * @param firstTokenInBlock
	 * @param lastTokenInBlock
	 * @return
	 */
	protected static TextLocation createTextLocationBetween(
			org.antlr.runtime.Token firstTokenInBlock,
			ANTLR3LocationToken lastTokenInBlock) {
		int startIndex = ((org.antlr.runtime.CommonToken) firstTokenInBlock)
				.getStartIndex();
		int line = firstTokenInBlock.getLine();
		int column = (firstTokenInBlock.getCharPositionInLine() + 1);

		// fallbacks if last token is null
		int stopIndex = startIndex;
		int endLine = line;
		int endColumn = column;
		if (lastTokenInBlock != null) {
			ANTLR3LocationToken locToken = lastTokenInBlock;
			stopIndex = locToken.getStopIndex() + 1;
			endLine = locToken.getEndLine();
			endColumn = (locToken.getEndColumn() + 1);
		}
		TextLocation location = new TextLocation(startIndex, stopIndex, line,
				column, endLine, endColumn);
		return location;
	}

	/**
	 * 
	 * @return
	 */
	public final IModelInjector getInjector() {
		return injector;
	}

	/**
	 * 
	 * @param ei
	 */
	public final void setInjector(IModelInjector ei) {
		this.injector = ei;
		if (input != null && input.getTokenSource() instanceof Lexer) {
			try {
				input.getTokenSource().getClass().getField("ei").set(
						input.getTokenSource(), ei);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(
						"Lexer does not support model injector!!");
			} catch (SecurityException e) {
				throw new RuntimeException(
						"Lexer does not support model injector!!");
			} catch (IllegalAccessException e) {
				throw new RuntimeException(
						"Lexer does not support model injector!!");
			} catch (NoSuchFieldException e) {
				throw new RuntimeException(
						"Lexer does not support model injector!!");
			}
		}
	}

	/**
	 * 
	 * @param re
	 * @param modelElementOrProxy
	 */
	protected final void onErrorInTemplateRule(RecognitionException re,
			Object modelElementOrProxy) {
		if (modelElementOrProxy != null
				&& modelElementOrProxy instanceof IModelElementProxy) {
			// can not resolve or create ModelElement,
			discardProxy(modelElementOrProxy);
			if (getCurrentContextElement() == modelElementOrProxy) {
				leaveContext();
			}
		}
		super.onErrorInTemplateRule(re);
	}

	/**
	 * util method to build list of Strings, to be used in generated Parsers to
	 * build qualified names.
	 * 
	 * @param entries
	 * @return
	 */
	protected static List<String> list(String... entries) {
		List<String> list = Arrays.asList(entries);
		return list;
	}

	/**
	 * notifies that within a template rule, a token mismatch was encountered,
	 * meaning that the temporary modelElement proxy cannot be instantiated.
	 * 
	 * @param re
	 * @param ret
	 */
	protected final void handleExceptionInTemplateRule(Exception e,
			Token firstTokenInBlock, Object proxy) {
		if (e instanceof RecognitionException) {
			RecognitionException re = (RecognitionException) e;
			reportError(re);
			recover(input, re);
			onErrorInTemplateRule(re, proxy);
		} else if (e instanceof RuntimeException) { // can only really be
			// RuntimeException thrown
			// by observer
			setExceptionThrown(true);
			throw (RuntimeException) e;
		} else {
			// should never happen
			throw new RuntimeException("BUG: Unexpected Exception", e);
		}
	}

	/**
	 * Returns an (unmodifiable) list of still unresolved references. May be
	 * interesting to clients who triggered a parser run and want to display,
	 * e.g., to a user if there are still unresolved references and what they
	 * are.
	 */
	public List<DelayedReference> getUnresolvedReferences() {
		// first ensure that all newly resolvable elements are moved to the
		// delayedReferenceList
		replaceResolvedProxies();
		return Collections.unmodifiableList(delayedReferenceList);
	}

	/**
	 * Clients may call this to prevent a reference from being resolved.
	 * 
	 * @param ref
	 */
	public void removeUnresolvedReference(DelayedReference ref) {
		delayedReferenceList.remove(ref);
	}

	/**
	 * parsing may generate references which can only be resolved after parsing,
	 * this method needs to be called to tell the parser to use the elements
	 * parsed so far (and elements in other contexts if any) to resolve any open
	 * references. This is done using a kind of fixpoint iteration where
	 * references are tried to resolve until no new reference is successfully
	 * resolved.
	 * 
	 * @return <tt>true</tt> if all unresolved references were resolved,
	 *         <tt>false</tt> if there are still unresolved references. A client
	 *         can obtain those unresolved references by calling
	 *         {@link #getUnresolvedReferences}.
	 */
	public final boolean setDelayedReferencesAfterParsing() {
		injector.performAdapterDeferredActions();
		replaceResolvedProxies();

		/*
		 * It is assumed here that at this point of time, the code structure
		 * guarantees that the list of delayed References does not contain any
		 * IModelElementproxy elements, neither does the ContextManager contain
		 * any IModelElementProxy object.
		 */

		if (injector.getErrorList().size() == 0) {

			// try to resolve references as long as there are new references
			// resolved
			// this is done because the actual optimal ordering is not known at
			// this point
			boolean resolvedNewReference = true;
			while (!delayedReferenceList.isEmpty() && resolvedNewReference
					|| !unResolvedDelayedReferenceList.isEmpty()) {
				// clear the error list as the errors might get resolved
				// within
				// the next iteration
				// if not they will be added again anyways
				injector.getErrorList().clear();
				// if in the resolving part some new references are created they
				// must be evaluated as well
				for (Iterator<DelayedReference> it = unResolvedDelayedReferenceList
						.iterator(); it.hasNext();) {
					delayedReferenceList.add(it.next());
				}
				unResolvedDelayedReferenceList.clear();
				resolvedNewReference = false;
				for (Iterator<DelayedReference> iterator = delayedReferenceList
						.iterator(); iterator.hasNext();) {
					DelayedReference reference = iterator.next();
					try {
						Collection<ParsingError> errorList = new ArrayList<ParsingError>(
								injector.getErrorList());
						boolean newlyResolved = injector.resolveReference(
								reference, contextManager, this);
						if (newlyResolved) {
							iterator.remove();
							resolvedNewReference = true;
						} else if (reference.isOptional()) {
							restoreErrorList(errorList);
						}
						if (reference.getRealValue() != null) {
							Object me = (reference.getModelElement() instanceof IModelElementProxy) ? ((IModelElementProxy) reference
									.getModelElement()).getRealObject()
									: reference.getModelElement();
							onRuleElementResolvedOutOfContext(reference
									.getRealValue(), me, reference.getToken(),
									reference);
						}
					} catch (ModelElementCreationException e) {
						getInjector().addError(
								new ParsingError(e.getMessage(), reference
										.getToken()));
					}
				}
			}
		}
		return delayedReferenceList.size() == 0;

	}

	private void restoreErrorList(Collection<ParsingError> errorList) {
		injector.getErrorList().clear();
		injector.getErrorList().addAll(errorList);
	}

	/**
	 * The {@link #unResolvedDelayedReferenceList} list may still contain some
	 * {@link DelayedReference}s that haven't been copied over to
	 * {@link #delayedReferenceList} because they still contain proxies as their
	 * {@link DelayedReference#getModelElement() modelElement} or as their
	 * {@link DelayedReference#getContextElement() context element}. However,
	 * those proxies may be resolved, e.g., because they always were (see, e.g.,
	 * {@link ResolvedModelElementProxy}). For those proxies, no
	 * {@link #createOrResolve(Object, ANTLR3LocationToken, ANTLR3LocationToken)}
	 * will ever be called. Therefore, this method needs to be called at the
	 * beginning of {@link #setDelayedReferencesAfterParsing()} in order to
	 * replace the remaining proxies by the real objects they represent.
	 */
	private void replaceResolvedProxies() {
		List<DelayedReference> tempResolvedDelayedReferenceList = new ArrayList<DelayedReference>();
		for (DelayedReference ref : unResolvedDelayedReferenceList) {
			if (ref.getModelElement() instanceof IModelElementProxy
					&& ((IModelElementProxy) ref.getModelElement())
							.getRealObject() != null) {
				contextManager.notifyProxyResolvedWith((IModelElementProxy) ref
						.getModelElement(), ((IModelElementProxy) ref
						.getModelElement()).getRealObject(), null);
				ref
						.setModelElement(((IModelElementProxy) ref
								.getModelElement()).getRealObject());
				// if not to be resolved by a context lookup, do a deferred
				// lookup
				if (ref.getContextElement() == null) {
					tempResolvedDelayedReferenceList.add(ref);
				}
				// Those with a context lookup will be handled below
			}
			if (ref.getContextElement() != null
					&& ref.getContextElement() instanceof IModelElementProxy
					&& ((IModelElementProxy) ref.getContextElement())
							.getRealObject() != null) {
				contextManager.notifyProxyResolvedWith((IModelElementProxy) ref
						.getContextElement(), ((IModelElementProxy) ref
						.getContextElement()).getRealObject(), null);
				ref.setContextElement(((IModelElementProxy) ref
						.getContextElement()).getRealObject());
				tempResolvedDelayedReferenceList.add(ref);
			}
		}
		for (DelayedReference delayedReference : tempResolvedDelayedReferenceList) {
			unResolvedDelayedReferenceList.remove(delayedReference);
			delayedReferenceList.add(delayedReference);
		}
	}

	/**
	 * 
	 * @param modelElement
	 * @param featurename
	 * @param value
	 */
	public final void setProperty(Object modelElement, String featurename,
			Object value) {
		injector.set(modelElement, featurename, value);
	}

	/**
	 * 
	 * @param modelElement
	 * @param propertyName
	 * @param valueTypeName
	 * @param keyName
	 * @param keyValue
	 * @param lookIn
	 * @param autoCreate
	 * @param createAs
	 * @param importContext
	 * @param createIn
	 */
  public final void setRef(Object modelElement,
            String propertyName,
            List<String> valueTypeName,
            String keyName,
            Object keyValue,
            String lookIn,
            String autoCreate,
            List<String> createAs,
            boolean importContext,
            String createIn) {
        //if (keyValue == null) return;

        
        ANTLR3LocationToken lastToken = (ANTLR3LocationToken) input.LT(-1);
        
        DelayedReference ref = new DelayedReference(
                getCurrentContextElement(), 
                getCurrentForeachElement(), 
                modelElement,
                propertyName,
                valueTypeName,
                keyName,
                keyValue,
                lookIn,
                autoCreate,
                createAs,
                importContext,
                createIn,
                false, lastToken);
        
        onDelayedReferenceCreated(ref);
        
        unResolvedDelayedReferenceList.add(ref);
    }

	/**
	 * 
	 * @param modelElement
	 * @param propertyName
	 * @param valueTypeName
	 * @param keyName
	 * @param keyValue
	 * @param lookIn
	 * @param autoCreate
	 * @param createAs
	 * @param importContext
	 * @param createIn
	 */
	public final void setRef(Object modelElement,
            String propertyName,
            List<String> valueTypeName,
            String keyName,
            Object keyValue,
            String lookIn,
            String autoCreate,
            List<String> createAs,
            boolean importContext,
            String createIn,
            boolean isOptional) {
        //if (keyValue == null) return;

        
        ANTLR3LocationToken lastToken = (ANTLR3LocationToken) input.LT(-1);
        
        DelayedReference ref = new DelayedReference(
                getCurrentContextElement(), 
                getCurrentForeachElement(), 
                modelElement,
                propertyName,
                valueTypeName,
                keyName,
                keyValue,
                lookIn,
                autoCreate,
                createAs,
                importContext,
                createIn,
                isOptional, lastToken);
        
        onDelayedReferenceCreated(ref);
        
        unResolvedDelayedReferenceList.add(ref);
    }

	/**
	 * @return
	 */
	private IModelElementProxy getCurrentContextElement() {
		if (currentContextStack.size() > 0) {
			return currentContextStack.peek();
		}
		return null;
	}
	
	/**
	 * 
	 * @param proxy
	 */
	public void discardProxy(Object proxy) {
		contextManager.discardProxy(proxy, getCurrentContextElement());
	}

	/**
	 * 
	 * @param object
	 * @param propertyName
	 * @param keyName
	 * @param keyValue
	 * @param query
	 */
	public final void setOclRef(Object object,
            String propertyName,
            String keyName,
            Object keyValue,
            String query) {
        
        ANTLR3LocationToken lastToken = (ANTLR3LocationToken) input.LT(-1);
        
        DelayedReference ref = new DelayedReference( getCurrentContextElement(), getCurrentForeachElement(), object,
                propertyName, keyName, keyValue, query, false, lastToken);
        
        onDelayedReferenceCreated(ref);
        
        unResolvedDelayedReferenceList.add(ref);
    }

	/**
	 * 
	 * @param object
	 * @param propertyName
	 * @param keyName
	 * @param keyValue
	 * @param query
	 */
	public final void setOclRef(Object object,
            String propertyName,
            String keyName,
            Object keyValue,
            String query,
            boolean optional) {
        
        ANTLR3LocationToken lastToken = (ANTLR3LocationToken) input.LT(-1);
        
        DelayedReference ref = new DelayedReference( getCurrentContextElement(), getCurrentForeachElement(), object,
                propertyName, keyName, keyValue, query, optional, lastToken);
        
        onDelayedReferenceCreated(ref);
        
        unResolvedDelayedReferenceList.add(ref);
    }

	/**
	 * 
	 * @param object
	 * @param propertyName
	 * @param mode
	 * @param query
	 */
	public final void setPredicateRef(Object object, String propertyName,
			String mode, String query, List<PredicateSemantic> preds, IRuleName ruleNameFinder, boolean hasContext) {
		ANTLR3LocationToken lastToken = (ANTLR3LocationToken) input.LT(-1);
		DelayedReference ref = new DelayedReference(getCurrentContextElement(),
				getCurrentForeachElement(), DelayedReference.TYPE_SEMANTIC_PREDICATE, object,
				propertyName, query, mode, preds, ruleNameFinder, lastToken, 
				hasContext, /*isOptional: ForEach is always considered optional as 
				 * error reporting will be done based on metamodel constraints.*/
				true);
		unResolvedDelayedReferenceList.add(ref);
		onDelayedReferenceCreated(ref);
	}

	/**
	 * 
	 * @param enumName
	 * @param literalValue
	 * @return
	 */
	protected final Object createEnumLiteral(List<String> enumName,
			String literalValue) {
		return injector.createEnumLiteral(enumName, literalValue);
	}

	@Override
	public void pushFollow(BitSet fset) {
		super.pushFollow(fset);
	}

	public void popFollow() {
		state._fsp--;
	}

	/**
	 * This redefinition assumes that if an empty FOLLOWS set is on the follows
	 * stack anywhere other than at the bottm, it should be ignored instead of
	 * taking it as authoritative because it doesn't contain End-of-Rule.
	 */
	@Override
	protected BitSet combineFollows(boolean exact) {
		int top = state._fsp;
		BitSet followSet = new BitSet();
		for (int i = top; i >= 0; i--) {
			BitSet localFollowSet = state.following[i];
			/*
			 * System.out.println("local follow depth "+i+"="+
			 * localFollowSet.toString(getTokenNames())+")");
			 */
			followSet.orInPlace(localFollowSet);
			if (exact) {
				// can we see end of rule?
				if (localFollowSet.member(Token.EOR_TOKEN_TYPE)) {
					// Only leave EOR in set if at top (start rule); this lets
					// us know if we have to include follow(start rule); i.e.,
					// EOF
					if (i > 0) {
						followSet.remove(Token.EOR_TOKEN_TYPE);
					}
				} else { // can't see end of rule, quit
					if (!localFollowSet.isNil()) {
						break;
					}
				}
			}
		}
		return followSet;
	}

	protected void checkFollows() {
		/*
		 * if (state.backtracking > 0 && !state.failed) { BitSet follows =
		 * combineFollows(true); state.failed = !(follows.member(input.LA(1)) ||
		 * (input.LA(1) == -1 && follows .member(Token.EOR_TOKEN_TYPE))); }
		 */
	}

	public String toString(BitSet fset) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int i : fset.toArray()) {
			if (!first) {
				result.append(", ");
			}
			first = false;
			result.append(getTokenNames()[i]);
		}
		return result.toString();
	}

	/**
	 * @return the resolveProxies
	 */
	public boolean isResolveProxies() {
		return resolveProxies;
	}

	/**
	 * @param resolveProxies
	 *            the resolveProxies to set
	 */
	public void setResolveProxies(boolean resolveProxies) {
		this.resolveProxies = resolveProxies;
	}

	public void setLanguageId(String id) {
		languageId = id;
	}

	public String getLanguageId() {
		return languageId;
	}

	public IParsingObserver getObserver() {
	    return observer;
	}
	
        public List<DelayedReference> getDelayedReferences() {
            return unResolvedDelayedReferenceList;
        }
}
