package com.sap.mi.textual.tcs.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;

import tcs.Alternative;
import tcs.AsParg;
import tcs.AssociativityEnum;
import tcs.Block;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.ConditionalElement;
import tcs.CustomSeparator;
import tcs.EndOfLineRule;
import tcs.EnumLiteralMapping;
import tcs.EnumerationTemplate;
import tcs.FilterParg;
import tcs.ForcedLowerParg;
import tcs.ForcedUpperParg;
import tcs.FunctionCall;
import tcs.FunctionTemplate;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.Keyword;
import tcs.Literal;
import tcs.LiteralRef;
import tcs.ModeParg;
import tcs.Operator;
import tcs.OperatorList;
import tcs.OperatorTemplate;
import tcs.Priority;
import tcs.Property;
import tcs.PropertyArg;
import tcs.PropertyReference;
import tcs.QueryParg;
import tcs.RefersToParg;
import tcs.Rule;
import tcs.RulePattern;
import tcs.SeparatorParg;
import tcs.Sequence;
import tcs.SequenceElement;
import tcs.SimplePattern;
import tcs.StringPattern;
import tcs.Symbol;
import tcs.Template;
import tcs.Token;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper;
import com.sap.tc.moin.textual.moinadapter.adapter.MoinModelAdapterDelegate;

/**
 * Utility class for the TcsPackage.
 * 
 * Used by the CtsContentAssistProcessor, to calculate possible inputs after a
 * given SequenceElement.
 * 
 * Terminology: Atomic SequenceElement is one of: Property points to an
 * Attribute or a Reference with the refersTo argument, LiteralRef.
 * 
 * The other SequenceElements are composite in the sense, that they contain
 * child-Sequences, and will not contain any input-tokens directly.
 * 
 * CustomSeparators are ignored, as they do not contain any input-tokens and no
 * child Sequences.
 * 
 * @author D052602
 * 
 */
public class TcsUtil {

	private static final String TRANSIENT_PARTITION_NAME = "TcsUtilTransientPartition";

	/**
	 * clears the TcsUtil transient partition on this connection
	 * 
	 * @param c
	 */
	public static void clearTransientPartition(Connection c) {
		ModelPartition transientPartition = c
				.getOrCreateTransientPartition(TRANSIENT_PARTITION_NAME);
		transientPartition.deleteElements();

		// also clear operatorToLiteralRefMap which would otherwise refer to
		// deleted elements
		operatorToLiteralRefMap.clear();
	}
	
	/**
	 * caches LiteralRefs that are created to be returned as atomic sequence
	 * elements for each operator literal
	 */
	private static Map<Operator, LiteralRef> operatorToLiteralRefMap = new HashMap<Operator, LiteralRef>();

	/**
	 * Returns a list of all possible atomic SequenceElements, that directly
	 * follow the given SequenceElement, or indirectly follow it through
	 * SequenceElements that may have no tokens (i.e null Sequences in
	 * ConditionalElement).
	 * 
	 * The parentFunctionCallMap parameter is needed to disambiguate between the
	 * different FunctionCalls that reference the FunctionTemplate this
	 * SequenceElement is part of. The map is needed, as functions can contain
	 * other functions.
	 * 
	 * @param e
	 *            SequenceElement after which to look
	 * @param parentFunctionCallMap
	 *            maps the correct parent FunctionCall for each FunctionTemplate
	 *            this SequenceElement is part of
	 * @return all possible SequenceElements that are directly following
	 */
	public static List<SequenceElement> getPossibleAtomicFollows(
			SequenceElement e, Stack<FunctionCall> parentFunctionCallStack,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Stack<Property> parentPropertyStack, boolean isOperator,
			ConcreteSyntax syntax) {

		// we will modify the stack, make a copy first
		Stack<Property> copiedParentPropertyStack = duplicatePropertyStack(parentPropertyStack);
		Stack<FunctionCall> copiedParentFunctionCallStack = duplicateFunctionCallStack(parentFunctionCallStack);
		
		String operatorValue = null;
		if (isOperator) {
			// e is a literal ref referring to the operator value
			LiteralRef ref = (LiteralRef) e;
			operatorValue = ref.getReferredLiteral().getValue();
		}

		List<SequenceElement> results = new ArrayList<SequenceElement>();

		// counts how often getParent() has been called
		int orderOfParent = 0;

		SequenceElement current = e;
		while (current != null) {

			if (current instanceof Property) {
				Property prop = (Property) current;

				SeparatorParg sepArg = TcsUtil.getSeparatorParg(prop);
				if (sepArg != null) {
					// add separator sequence proposals as well
					Sequence sepSeq = sepArg.getSeparatorSequence();
					results.addAll(TcsUtil
							.getPossibleFirstAtomicSequenceElements(sepSeq,
									classTemplateMap, new HashSet<Template>(),
									syntax));
				} else {
					if (isMultiValued(prop)
							&& !containsForcedUpperArgOfOne(prop)) {

						// add the first elements of this property to
						// the follows-set

						addAllIfNotNull(results,
								getPossibleFirstAtomicSequenceElements(prop,
										classTemplateMap,
										new HashSet<Template>(), syntax));
					}
				}

				// operator handling
				if (isOperatored(prop, classTemplateMap)) {
					if (isOperator && orderOfParent == 1) {
						// we are at an operator
						// if the corresponding OperatorTemplates have a sequence, add the possible first atomic of that sequence.
						// if this is not the case for at least one matching OperatorTemplate, add first elements of parent property
						
						boolean otWithoutSequenceFound = false;

						for (OperatorTemplate ot : findOperatorTemplatesByOperatorLiteralValue(
								operatorValue, getType(prop), syntax)) {
							if (ot.getOtSequence() != null) {
								addAllIfNotNull(
										results,
										getPossibleFirstAtomicSequenceElements(
												ot.getOtSequence(),
												classTemplateMap,
												new HashSet<Template>(), syntax));
							} else {
								otWithoutSequenceFound = true;
							}
						}
						
						if (otWithoutSequenceFound) {

							addAllIfNotNull(results,
									getPossibleFirstAtomicSequenceElements(
											prop, classTemplateMap,
											new HashSet<Template>(), syntax));
						}

					} else {
						// we are before or past an operator and thus add all
						// valid operators to the proposals
						for (ClassTemplate ct : getClassTemplates(
								getType(prop), getMode(prop), classTemplateMap,
								getConnectionFromRefObject(prop))) {
							addAllIfNotNull(
									results,
									getOperatorsAsAtomicSequenceElements(getOperatorList(
											ct, syntax)));
						}
					}
				}
			}

			if (current instanceof Alternative) {
				Alternative alt = (Alternative) current;
				if (alt.isMulti()) {
					addAllIfNotNull(results,
							getPossibleFirstAtomicSequenceElements(alt,
									classTemplateMap, new HashSet<Template>(),
									syntax));
				}
			}

			Sequence parentSeq = current.getElementSequence();
			if (parentSeq.getSeparatorcontainer() != null) {
				// we are in a separator sequence, add parent property to
				// proposals

				try {
					Property parentProp = copiedParentPropertyStack.peek();
					addAllIfNotNull(results, TcsUtil
							.getPossibleFirstAtomicSequenceElements(parentProp,
									classTemplateMap, new HashSet<Template>(),
									syntax));
					// after separator, no other tokens are possible
					return results;
				} catch (Exception ex) {
					// do nothing
				}
			}

			SequenceElement next = getNextSequenceElement(current);

			while (next != null) {
				List<SequenceElement> nextElementResults = new ArrayList<SequenceElement>();

				addAllIfNotNull(nextElementResults,
						getPossibleFirstAtomicSequenceElements(next,
								classTemplateMap, new HashSet<Template>(),
								syntax));

				results.addAll(nextElementResults);
				if (nextElementResults.contains(null)) {
					next = getNextSequenceElement(next);

				} else {
					// next SequenceElement is guaranteed to need a Token
					return results;
				}
			}

			current = getParentSequenceElement(current,
					copiedParentFunctionCallStack, copiedParentPropertyStack,
					classTemplateMap);

			orderOfParent++;
		}

		// special handling of operatored main template
		// don't need to check current == null because current has been used before
		if (syntax != null) {
			ClassTemplate main = TcsUtil.getMainClassTemplate(syntax);
			if (main.isOperatored()) {

				if (isOperator && orderOfParent == 1) {
					// we are at an operator, add first elements of parent
					// property
					addAllIfNotNull(results,
							getPossibleFirstAtomicSequenceElements(main
									.getMetaReference(), main.getMode(),
									classTemplateMap, new HashSet<Template>(),
									syntax, getConnectionFromRefObject(main)));

					// also add prefix operators
					addAllIfNotNull(
							results,
							getPrefixOperatorsAsAtomicSequenceElements(getOperatorList(
									main, syntax)));

				} else {
					// we are before or past an operator and thus add all
					// valid operators to the proposals
					addAllIfNotNull(
							results,
							getOperatorsAsAtomicSequenceElements(getOperatorList(
									main, syntax)));
				}
			}

		}

		return results;
	}

	private static Collection<OperatorTemplate> findOperatorTemplatesByOperatorLiteralValue(
			String operatorValue, Classifier type, ConcreteSyntax syntax) {
		List<OperatorTemplate> result = new ArrayList<OperatorTemplate>();
		
		Connection connection = getConnectionFromRefObject(syntax);
		Generalizes generalizes = connection
		.getAssociation(Generalizes.ASSOCIATION_DESCRIPTOR);
		Collection<GeneralizableElement> subTypes = getAllSubtypes(generalizes,
				type);

		for (Template t : syntax.getTemplates()) {
			if (t instanceof OperatorTemplate) {
				OperatorTemplate ot = (OperatorTemplate) t;
				for (GeneralizableElement subType : subTypes) {
					if (ot.getMetaReference() != null
							&& ot.getMetaReference().getQualifiedName().equals(
									subType.getQualifiedName())) {
						if (ot.getOperators() != null) {
							for (Operator op : ot.getOperators()) {
								// assumes that not two operators within the
								// used
								// operator list have the same literal
								if (op.getLiteral().getValue().equals(
										operatorValue)) {
									result.add(ot);
								}
							}
						}
					}
				}
			}
		}

		return result;
	}

	private static OperatorList getOperatorList(ClassTemplate ct,
			ConcreteSyntax syntax) {
		OperatorList mainClassOpList = ct.getOperatorList();
		if (mainClassOpList != null) {
			return mainClassOpList;
		}

		// no operator list name specified, query operator lists of syntax
		// instead
		for (OperatorList opList : syntax.getOperatorLists()) {
			if (opList.getName() == null) {
				return opList;
			}
		}

		return null;
	}

	private static List<SequenceElement> getOperatorsAsAtomicSequenceElements(
			OperatorList operatorList) {
		if (operatorList == null) {
			return null;
		}

		List<SequenceElement> results = new ArrayList<SequenceElement>();
		for (Priority prio : operatorList.getPriorities()) {
			for (Operator op : prio.getOperators()) {
				if (!operatorToLiteralRefMap.containsKey(op)) {
					cacheOperatorLiteral(operatorList, op);

				}
				results.add(operatorToLiteralRefMap.get(op));
			}
		}

		return results;
	}

	private static List<SequenceElement> getPrefixOperatorsAsAtomicSequenceElements(
			OperatorList operatorList) {
		if (operatorList == null) {
			return null;
		}

		// prefix means arity of 1 and left associativity and not postfix

		List<SequenceElement> results = new ArrayList<SequenceElement>();
		for (Priority prio : operatorList.getPriorities()) {
			if (prio.getAssociativity() == AssociativityEnum.LEFT) {
				for (Operator op : prio.getOperators()) {
					if (op.getArity() == 1 && !op.isPostfix()) {
						if (!operatorToLiteralRefMap.containsKey(op)) {
							cacheOperatorLiteral(operatorList, op);

						}
						results.add(operatorToLiteralRefMap.get(op));
					}
				}
			}
		}

		return results;
	}

	private static void cacheOperatorLiteral(OperatorList operatorList,
			Operator op) {
		Connection c = TcsUtil.getConnectionFromRefObject(operatorList);
		ModelPartition transientPartition = c
				.getOrCreateTransientPartition(TRANSIENT_PARTITION_NAME);
		LiteralRef litRef = (LiteralRef) c.getClass(
				tcs.LiteralRef.CLASS_DESCRIPTOR).refCreateInstanceInPartition(
				transientPartition);
		litRef.setReferredLiteral(op.getLiteral());
		operatorToLiteralRefMap.put(op, litRef);
	}

	private static boolean containsForcedUpperArgOfOne(Property prop) {
		ForcedUpperParg upperArg = getForcedUpperParg(prop);
		if (upperArg != null && upperArg.getValue() == 1) {
			return true;
		}

		return false;
	}

	private static boolean containsForcedLowerArg(Property prop) {
		return (getForcedLowerParg(prop) != null);

	}

	public static List<SequenceElement> getMainTemplatePossibleFirstAtomicSequenceElements(
			ConcreteSyntax syntax,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {

		ClassTemplate main = getMainClassTemplate(syntax);
		if (main.isAbstract()) {
			return getPossibleFirstAtomicSequenceElements(main
					.getMetaReference(), main.getMode(), classTemplateMap,
					new HashSet<Template>(), syntax,
					getConnectionFromRefObject(main));

		} else {
			return getPossibleFirstAtomicSequenceElements(
					getMainClassTemplate(syntax), classTemplateMap,
					new HashSet<Template>(), syntax);
		}
	}

	public static Stack<Property> duplicatePropertyStack(Stack<Property> source) {
		if (source == null) {
			return null;
		}

		Stack<Property> copiedPropertyStack = new Stack<Property>();
		for (Property p : source) {
			copiedPropertyStack.push(p);
		}

		return copiedPropertyStack;

	}

	public static Stack<FunctionCall> duplicateFunctionCallStack(
			Stack<FunctionCall> source) {
		if (source == null) {
			return null;
		}

		Stack<FunctionCall> copiedFunctionCallStack = new Stack<FunctionCall>();
		for (FunctionCall p : source) {
			copiedFunctionCallStack.push(p);
		}

		return copiedFunctionCallStack;

	}

	public static Stack<Template> duplicateTemplateStack(Stack<Template> source) {
		if (source == null) {
			return null;
		}

		Stack<Template> copiedTemplateStack = new Stack<Template>();
		for (Template p : source) {
			copiedTemplateStack.push(p);
		}

		return copiedTemplateStack;

	}

	/**
	 * Check multiplicity of referred StructuralFeature.
	 * 
	 * @param p
	 *            Property to check
	 * @return true, if Multiplicity is unlimited, or larger than 1.
	 */
	public static boolean isMultiValued(Property p) {

		// TODO is there a constant instead of checking for below 0

		TypedElement feat = getStructuralFeature(p);
		if (feat instanceof AssociationEnd || feat instanceof Parameter
				|| feat instanceof StructuralFeature) {
			int upper = ((MultiplicityType) feat.refGetValue("multiplicity"))
					.getUpper();
			return (upper < 0 || upper > 1);
		}
		return false;
	}

	private static void addAllIfNotNull(List<SequenceElement> output,
			List<SequenceElement> input) {
		if (input != null) {
			output.addAll(input);
		}
	}

	/**
	 * Returns a list of the first possible atomic SequenceElements of the given
	 * SequenceElement.
	 * 
	 * Composite SequenceElements return the possible first atomic
	 * SequenceElements of each of their children merged into a single list,
	 * atomic SequenceElements return a list containing themselves.
	 * 
	 * @param e
	 *            SequenceElement to get the first possible atomic
	 *            SequenceElements from
	 * @param visitedTemplates
	 * @return first possible atomic SequenceElements
	 */
	public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(
			SequenceElement e,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Set<Template> visitedTemplates, ConcreteSyntax syntax) {

		assert (visitedTemplates != null);

		List<SequenceElement> results = new ArrayList<SequenceElement>();

		// check for composite SequenceElements
		if (e instanceof Alternative) {
			Alternative alt = (Alternative) e;
			
			if (alt.isMulti()) {
				// isMulti Alternative is optional
				results.add(null);
			}
			
			for (Sequence s : alt.getSequences()) {
				addAllIfNotNull(results,
						getPossibleFirstAtomicSequenceElements(s,
								classTemplateMap, new HashSet<Template>(
										visitedTemplates), syntax));
			}
			return results;
		}

		else if (e instanceof ConditionalElement) {
			ConditionalElement cond = (ConditionalElement) e;
			addAllIfNotNull(results, getPossibleFirstAtomicSequenceElements(
					cond.getThenSequence(), classTemplateMap,
					new HashSet<Template>(visitedTemplates), syntax));
			addAllIfNotNull(results, getPossibleFirstAtomicSequenceElements(
					cond.getElseSequence(), classTemplateMap,
					new HashSet<Template>(visitedTemplates), syntax));
			return results;
		}

		else if (e instanceof Block) {
			Block block = (Block) e;
			addAllIfNotNull(results, getPossibleFirstAtomicSequenceElements(
					block.getBlockSequence(), classTemplateMap,
					visitedTemplates, syntax));
			return results;
		}

		else if (e instanceof FunctionCall) {
			FunctionCall call = (FunctionCall) e;
			addAllIfNotNull(results, getPossibleFirstAtomicSequenceElements(
					call.getCalledFunction(), classTemplateMap,
					visitedTemplates, syntax));
			return results;
		}

		else if (e instanceof CustomSeparator) {
			// CustomSeparators do not contain any SequenceElements
			results.add(null);
			return results;
		}

		else if (e instanceof InjectorActionsBlock) {
			// InjectorActionsBlocks do not contain any SequenceElements
			results.add(null);
			return results;
		}

		else if (e instanceof Property) {
			Property prop = (Property) e;

			// if we have a multi-valued Property, add corresponding
			// elements as well
			if (isMultiValued(prop) && !containsForcedLowerArg(prop)) {

				results.add(null);
			}

			if (isAtomic(prop, classTemplateMap)) {
				results.add(e);
				return results;
			} else {
				addAllIfNotNull(results,
						getPossibleFirstAtomicSequenceElements(getType(prop),
								getMode(prop), classTemplateMap,
								visitedTemplates, syntax,
								getConnectionFromRefObject(prop)));
				return results;
			}
		}

		else {
			// atomic SequenceElement or null
			results.add(e);

			return results;
		}

	}

	public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(
			Classifier type, String mode,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Set<Template> visitedTemplates, ConcreteSyntax syntax,
			Connection connection) {
		List<SequenceElement> results = new ArrayList<SequenceElement>();
		for (ClassTemplate ct : getClassTemplates(type, mode, classTemplateMap,
				connection)) {
			if (!ct.isAbstract()) {
				addAllIfNotNull(results,
						getPossibleFirstAtomicSequenceElements(ct,
								classTemplateMap, visitedTemplates, syntax));
			} else {
				if (ct.isOperatored()) {
					// add prefix operators
					addAllIfNotNull(
							results,
							getPrefixOperatorsAsAtomicSequenceElements(getOperatorList(
									ct, syntax)));
				}
			}
		}

		return results;
	}

	public static Classifier getType(Property p) {
		TypedElement e = getStructuralFeature(p);
		if (e != null) {
			return e.getType();
		}

		return null;
	}

	public static String getMode(Property p) {
		ModeParg modeArg = getModeParg(p);
		if (modeArg != null) {
			return modeArg.getMode();
		}

		return null;
	}

	public static boolean isAtomic(Property p,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
		TypedElement s = getStructuralFeature(p);
		if (s != null) {
			if (s instanceof Reference || s instanceof AssociationEnd) {
				if (!containsRefersToArg(p) && !containsAsArg(p)) {
					return false;
				}

			}
			if (s instanceof Attribute && classTemplateMap != null) {
				// check if we have a non-primitive type attribute by querying
				// classTemplateMap
				List<String> typeName = getType(p).getQualifiedName();
				if (classTemplateMap.containsKey(typeName)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isOperatored(Property p,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
		TypedElement s = getStructuralFeature(p);
		if (s != null) {
			if (classTemplateMap != null) {
				List<String> typeName = getType(p).getQualifiedName();
				if (classTemplateMap.containsKey(typeName)) {
					ClassTemplate ct = classTemplateMap.get(typeName).get(
							getMode(p));
					if (ct != null) {
						return ct.isOperatored();
					}
				}
			}
		}

		return false;
	}

	public static boolean containsRefersToArg(Property p) {
		return getRefersToParg(p) != null;
	}

	public static boolean containsAsArg(Property p) {
		return getAsParg(p) != null;
	}

	/**
	 * returns the first SeparatorParg of Property p. There should only be one.
	 * No error is thrown, if more than one exist.
	 * 
	 * @param p
	 *            Property
	 * @return first SeparatorParg
	 */
	public static SeparatorParg getSeparatorParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof SeparatorParg) {
				return (SeparatorParg) arg;
			}
		}

		return null;
	}

	/**
	 * returns the first AsParg of Property p. There should only be one. No
	 * error is thrown, if more than one exist.
	 * 
	 * @param p
	 *            Property
	 * @return first RefersToParg
	 */
	public static AsParg getAsParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof AsParg) {
				return (AsParg) arg;
			}
		}

		return null;
	}

	/**
	 * returns the first RefersToParg of Property p. There should only be one.
	 * No error is thrown, if more than one exist.
	 * 
	 * @param p
	 *            Property
	 * @return first RefersToParg
	 */
	public static RefersToParg getRefersToParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof RefersToParg) {
				return (RefersToParg) arg;
			}
		}

		return null;
	}

	/**
	 * returns the first {@link QueryParg} of Property p. There should only be
	 * one. No error is thrown, if more than one exist.
	 * 
	 * @param p
	 *            Property
	 * @return first QueryParg
	 */
	public static QueryParg getQueryParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof QueryParg) {
				return (QueryParg) arg;
			}
		}
		return null;
	}

	/**
	 * returns the first {@link FilterParg} of Property p. There should only be
	 * one. No error is thrown, if more than one exist.
	 * 
	 * @param p
	 *            Property
	 * @return first FilterParg
	 */
	public static FilterParg getFilterParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof FilterParg) {
				return (FilterParg) arg;
			}
		}
		return null;
	}

	static ForcedUpperParg getForcedUpperParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof ForcedUpperParg) {
				return (ForcedUpperParg) arg;
			}
		}

		return null;
	}

	static ForcedLowerParg getForcedLowerParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof ForcedLowerParg) {
				return (ForcedLowerParg) arg;
			}
		}

		return null;
	}

	static ModeParg getModeParg(Property p) {
		for (PropertyArg arg : p.getPropertyArgs()) {
			if (arg instanceof ModeParg) {
				return (ModeParg) arg;
			}
		}

		return null;
	}

	public static boolean containsSeparatorArg(Property p) {
		return getSeparatorParg(p) != null;
	}

	static Collection<GeneralizableElement> getAllSubtypes(
			Generalizes generalizes, GeneralizableElement type) {
		List<GeneralizableElement> results = new ArrayList<GeneralizableElement>();
		Collection<GeneralizableElement> subTypes = generalizes
				.getSubtype(type);
		for (GeneralizableElement subType : subTypes) {
			results.addAll(getAllSubtypes(generalizes, subType));
		}
		results.add(type);
		return results;
	}

	public static Collection<ClassTemplate> getClassTemplates(Classifier type,
			String mode,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Connection connection) {
		Assert
				.isLegal(classTemplateMap != null,
						"could not resolve class template for Reference, classTemplateMap is null");

		List<ClassTemplate> results = new ArrayList<ClassTemplate>();

		// get all matching class templates of this type and any of the
		// (recursive) subtypes

		Generalizes generalizes = connection
				.getAssociation(Generalizes.ASSOCIATION_DESCRIPTOR);
		Collection<GeneralizableElement> subTypes = getAllSubtypes(generalizes,
				type);
		for (GeneralizableElement subType : subTypes) {
			if (classTemplateMap.containsKey((subType.getQualifiedName()))) {
				for (ClassTemplate ct : classTemplateMap.get(
						subType.getQualifiedName()).values()) {
					if ((mode == null && ct.getMode() == null)
							|| (mode != null && mode.equals(ct.getMode()))) {
						results.add(ct);
					}
				}
			}
		}

		return results;
	}

	public static Connection getConnectionFromRefObject(RefObject ref) {
		Partitionable p = ref;
		return p.get___Connection();
	}

	// TODO still needed?
	public static Literal findLiteralByName(ConcreteSyntax syntax,
			String literalName) {
		for (Keyword k : syntax.getKeywords()) {
			if (k.getValue().equals(literalName)) {
				return k;
			}
		}

		for (Symbol s : syntax.getSymbols()) {
			if (s.getValue().equals(literalName)) {
				return s;
			}
		}

		return null;
	}

	/**
	 * Returns a list of the first possible atomic SequenceElements of the given
	 * FunctionTemplate.
	 * 
	 * @param t
	 *            FunctionTemplate to get the first possible atomic
	 *            SequenceElements from
	 * @return first possible atomic SequenceElements
	 */
	static List<SequenceElement> getPossibleFirstAtomicSequenceElements(
			FunctionTemplate t,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Set<Template> visitedTemplates, ConcreteSyntax syntax) {

		assert (visitedTemplates != null);

		if (t != null) {
			if (!visitedTemplates.contains(t)) {
				visitedTemplates.add(t);
				return getPossibleFirstAtomicSequenceElements(t
						.getFunctionSequence(), classTemplateMap,
						visitedTemplates, syntax);
			} else {
				return null;
			}

		}

		return createListWithEntry(null);
	}

	/**
	 * Returns a list of the first possible atomic SequenceElements of the given
	 * ClassTemplate.
	 * 
	 * If the ClassTemplate is abstract, compute subtypes and add all possible
	 * first atomic elements for each non-abstract subtype.
	 * 
	 * @param t
	 *            ClassTemplate to get the first possible atomic
	 *            SequenceElements from
	 * @return first possible atomic SequenceElements
	 */
	static List<SequenceElement> getPossibleFirstAtomicSequenceElements(
			ClassTemplate t,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Set<Template> visitedTemplates, ConcreteSyntax syntax) {

		assert (visitedTemplates != null);

		if (t != null) {
			if (!visitedTemplates.contains(t)) {
				visitedTemplates.add(t);
				return getPossibleFirstAtomicSequenceElements(t
						.getTemplateSequence(), classTemplateMap,
						visitedTemplates, syntax);
			} else {
				return null;
			}
		}

		return createListWithEntry(null);
	}

	private static List<SequenceElement> createListWithEntry(SequenceElement e) {
		List<SequenceElement> result = new ArrayList<SequenceElement>();
		result.add(e);
		return result;
	}

	/**
	 * Returns a list of the first possible atomic SequenceElements of the given
	 * Sequence.
	 * 
	 * @param s
	 *            Sequence to get the first possible atomic SequenceElements
	 *            from
	 * @return first possible atomic SequenceElements
	 */
	public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(
			Sequence s,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			Set<Template> visitedTemplates, ConcreteSyntax syntax) {

		assert (visitedTemplates != null);

		SequenceElement e = getFirstSequenceElement(s);

		List<SequenceElement> results = new ArrayList<SequenceElement>();

		List<SequenceElement> elementResults;
		do {
			elementResults = getPossibleFirstAtomicSequenceElements(e,
					classTemplateMap, new HashSet<Template>(visitedTemplates),
					syntax);
			addAllIfNotNull(results, elementResults);
			e = getNextSequenceElement(e);
		} while (elementResults.contains(null) && e != null);

		return results;
	}

	/**
	 * Returns the first SequenceElement of a Sequence s, or null if s is null
	 * or it has no SequenceElements.
	 * 
	 * @param s
	 *            Sequence to return the first SequenceElement of
	 * @return the first SequenceElement of Sequence s
	 */
	public static SequenceElement getFirstSequenceElement(Sequence s) {
		if (s != null) {
			if (s.getElements() != null) {
				if (s.getElements().size() > 0) {
					return s.getElements().get(0);
				}
			}
		}

		return null;
	}

	public static boolean isLastSequenceElement(SequenceElement e) {
		if (e == null) {
			return false;
		}

		return getNextSequenceElement(e) == null;
	}

	/**
	 * Returns the next SequenceElement in the parent Sequence, or null, if it
	 * is the last SequenceElement.
	 * 
	 * @param e
	 *            SequenceElement after which to look
	 * @return next SequenceElement in parent Sequence
	 */
	public static SequenceElement getNextSequenceElement(SequenceElement e) {
		if (e == null) {
			return null;
		}

		// use refImmediateComposite, as a SequenceElement can be part of
		// different types of Sequences
		RefFeatured container = e.refImmediateComposite();
		if (container instanceof Sequence) {

			Sequence parentSequence = (Sequence) container;
			List<SequenceElement> elements = parentSequence.getElements();
			if (elements != null) {
				int index = elements.indexOf(e);

				if (index + 1 < elements.size()) {
					return elements.get(index + 1);
				}
			}
		}

		return null;
	}

	/**
	 * Returns the next parent SequenceElement, if the SequenceElement has a
	 * parent Sequence, and that parent Sequence is either part of another
	 * SequenceElement, FunctionTemplate, or SeparatorPArg.
	 * 
	 * The FunctionCall parameter is needed to disambiguate between the
	 * different FunctionCalls that reference the FunctionTemplate this
	 * SequenceElement is part of.
	 * 
	 * @param e
	 *            SequenceElement to find the parent SequenceElement of
	 * @param parentFunctionCallMap
	 *            the closest FunctionCall this SequenceElement belongs to. can
	 *            be null, if not belonging to a FunctionTemplate Sequence
	 * @param parentPropertyStack
	 *            parent Properties. Important: Will be popped, when
	 *            encountering a ClassTemplate. can be null.
	 * @return the next parent SequenceElement, or null
	 */
	public static SequenceElement getParentSequenceElement(SequenceElement e,
			Stack<FunctionCall> parentFunctionCallStack,
			Stack<Property> parentPropertyStack,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {

		Sequence parentSequence = e.getElementSequence();
		if (parentSequence != null) {
			// check if parentSequence is part of a SequenceElement
			RefFeatured container = parentSequence.refImmediateComposite();
			if (container instanceof SequenceElement) {
				return (SequenceElement) container;
			}

			if (container instanceof FunctionTemplate) {
				// reached a FunctionTemplate, continue at parent
				// FunctionCall

				Assert
						.isLegal(
								parentFunctionCallStack != null,
								"SequenceElement e belongs to a FunctionTemplate,"
										+ " but no parentFunctionCallStack given to disambiguate");

				Assert
						.isLegal(
								!parentFunctionCallStack.isEmpty(),
								"SequenceElement e belongs to a FunctionTemplate,"
										+ " but no entry in parentFunctionCallStack to disambiguate");

				FunctionCall parentFunctionCall = parentFunctionCallStack.pop();

				Assert.isLegal(
						parentFunctionCall.getCalledFunction() == container,
						"parentFunctionCall on stack is the wrong parent");

				return parentFunctionCall;

			}

			if (container instanceof ClassTemplate) {
				if (parentPropertyStack != null) {
					if (parentPropertyStack.size() > 0) {
						return parentPropertyStack.pop();
					}
				}
			}

			if (container instanceof SeparatorParg) {
				// reached a SeparatorParg, continue at parent Property
				SeparatorParg parentSepArg = (SeparatorParg) container;
				RefFeatured containerOfParent = parentSepArg
						.refImmediateComposite();
				if (containerOfParent instanceof Property) {
					return (Property) containerOfParent;
				}

			}
		}

		// check for non-sequence based special cases

		// the sequence element is a dummy and has no parent sequence. instead,
		// get the parent from the property stack
		try {
			if (parentPropertyStack != null) {
				Property parent = parentPropertyStack.peek();
				if (isEnumeration(parent)
						|| isOperatored(parent, classTemplateMap)) {
					return parentPropertyStack.pop();
				}
			}
		} catch (Exception ex) {
			// do nothing
		}

		return null;
	}

	public static ClassTemplate getMainClassTemplate(ConcreteSyntax syntax) {

		if (syntax != null) {
			for (Template t : syntax.getTemplates()) {
				if (t instanceof ClassTemplate) {
					ClassTemplate c = (ClassTemplate) t;
					if (c.isMain()) {
						return c;
					}
				}
			}
		}

		return null;
	}

	public static MQLResultSet queryConn(Connection connection, String query) {
		MQLProcessor mql = connection.getMQLProcessor();
		MQLPreparedQuery preparedQuery = mql.prepare(query);
		return mql.execute(preparedQuery);
	}

	public static MQLResultSet querySameConn(RefObject r, String query) {
		Connection conn = getConnectionFromRefObject(r);
		return queryConn(conn, query);
	}

	public static List<ConcreteSyntax> getSyntaxesInConnection(
			Connection connection) {

		String query = "select cs from TCS::ConcreteSyntax withoutsubtypes as cs";

		MQLResultSet resultSet = queryConn(connection, query);
		RefObject[] resultElements = resultSet.getRefObjects("cs");

		List<ConcreteSyntax> results = new ArrayList<ConcreteSyntax>();

		for (RefObject elem : resultElements) {
			results.add((ConcreteSyntax) elem);
		}

		return results;
	}

	public static List<ConcreteSyntax> getSyntaxesInConnectionWithName(Connection connection, String syntaxName) {
	    String query = "select cs from TCS::ConcreteSyntax withoutsubtypes as cs where cs.name = '"+
	    	syntaxName+"'";
	    MQLResultSet resultSet = queryConn(connection, query);
	    RefObject[] resultElements = resultSet.getRefObjects("cs");
	    List<ConcreteSyntax> results = new ArrayList<ConcreteSyntax>();
	    for (RefObject elem : resultElements) {
		results.add((ConcreteSyntax) elem);
	    }
	    return results;
	}

	/**
	 * Get the build-in TCS ConcreteSyntax.
	 * 
	 * @param connection
	 *            Connection to look in
	 * @return build-in TCS ConcreteSyntax
	 */
	public static ConcreteSyntax getTcsSyntax(Connection connection) {
		// TODO implement some real way of identifying the build-in TCS
		// ConcreteSyntax.
		// note that the name will not suffice, as a new TCS syntax can be build
		// using the build-in TCS syntax (after bootstrapping)

		List<ConcreteSyntax> syntaxList = getSyntaxesInConnection(connection);

		for (ConcreteSyntax syntax : syntaxList) {
			if (syntax.getName().equals("TCS")) {
				return syntax;
			}
		}
		return null;
	}

	/**
	 * Get the first ConcreteSyntax with the given name.
	 * 
	 * @param connection
	 *            Connection to look in
	 * @return the ConcreteSyntax with the given name.
	 */
	public static ConcreteSyntax getSyntaxByName(Connection connection,
			String languageId) {
		List<ConcreteSyntax> syntaxList = getSyntaxesInConnectionWithName(connection, languageId);
		if (syntaxList == null || syntaxList.size() == 0) {
		    return null;
		} else {
		    return syntaxList.get(0);
		}
	}

	/**
	 * Creates a map of qualifiedName + Mode to ClassTemplate of all
	 * ClassTemplates contained in the syntax
	 * 
	 * @param syntax
	 *            the ConcreteSyntax to build the map of
	 * @return map of qualifiedName + Mode to ClassTemplate
	 */
	public static Map<List<String>, Map<String, ClassTemplate>> createClassTemplateMap(
			ConcreteSyntax syntax) {
		Assert.isLegal(syntax != null);

		Map<List<String>, Map<String, ClassTemplate>> classTemplateMap = new HashMap<List<String>, Map<String, ClassTemplate>>();
		List<Template> templates = syntax.getTemplates();

		for (Template t : templates) {
			if (t instanceof ClassTemplate) {
				ClassTemplate ct = (ClassTemplate) t;

				List<String> qualifiedName = getQualifiedName(ct);

				putClassTemplate(classTemplateMap, qualifiedName, ct.getMode(),
						ct);
			}
		}

		return classTemplateMap;
	}

	public static List<String> getQualifiedName(Template t) {
		List<String> qualifiedName;
		Classifier ref = t.getMetaReference();
		if (ref == null) { // syntaxes may merely define name of
			// metamodel class rather than have a
			// reference
			qualifiedName = t.getNames();
		} else {
			qualifiedName = ref.getQualifiedName();
		}

		if (qualifiedName == null) {
			System.err
					.println("class template could not be identified (qualifiedName and names both null");
		}
		return qualifiedName;
	}

	/**
	 * Creates a map of qualifiedName to OperatorTemplate of all
	 * OperatorTemplates contained in the syntax
	 * 
	 * @param syntax
	 *            the ConcreteSyntax to build the map of
	 * @return map of qualifiedName to OperatorTemplate
	 */
	public static Map<List<String>, OperatorTemplate> createOperatorTemplateMap(
			ConcreteSyntax syntax) {
		Assert.isLegal(syntax != null);

		Map<List<String>, OperatorTemplate> operatorTemplateMap = new HashMap<List<String>, OperatorTemplate>();
		List<Template> templates = syntax.getTemplates();

		for (Template t : templates) {
			if (t instanceof OperatorTemplate) {
				OperatorTemplate ot = (OperatorTemplate) t;

				List<String> qualifiedName = getQualifiedName(ot);

				operatorTemplateMap.put(qualifiedName, ot);
			}
		}

		return operatorTemplateMap;
	}

	private static void putClassTemplate(
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
			List<String> qualifiedName, String mode, ClassTemplate ct) {
		if (classTemplateMap.containsKey(qualifiedName)) {
			classTemplateMap.get(qualifiedName).put(mode, ct);
		} else {
			Map<String, ClassTemplate> modeMap = new HashMap<String, ClassTemplate>();
			modeMap.put(mode, ct);
			classTemplateMap.put(qualifiedName, modeMap);
		}
	}

	/**
	 * 
	 * @param propRef
	 * @return
	 */
	public static String getPropertyName(PropertyReference propRef) {
		if (propRef != null) {
			if (propRef.getName() != null) {
				return propRef.getName();
			} else {
				TypedElement strucFeat = propRef.getStrucfeature();
				if (strucFeat != null) {
					return strucFeat.getName();
				}
			}
		}
		return null;
	}

	 /**
	     * Returns the value of the property identified by propName of the given target RefStruct.
	     * 
	     * 
	     * @param target
	     *            RefStruct to get the property value of.
	     * @param propName
	     *            Name of the property to get the value of.
	     * @return The value of the given property for the target RefStruct. This can be a collection for multi-valued properties.
	     */
	        public static Object getPropertyValue(RefStruct target,
	                        PropertyReference propRef) {
	                assert (target != null);

	                if (propRef != null) {

	                        if (propRef.getName() != null) {
	                                // assume that name can only refer to an attribute or reference,
	                                // not an association link
	                                return target.refGetValue(propRef.getName());
	                        }
	                        TypedElement elem = propRef.getStrucfeature();
	                        if (elem != null) {
	                            return target.refGetValue(elem.getName());
	                        }
	                }
	                return null;
	        }
	
	
    /**
     * Returns the value of the property identified by propName of the given target RefObject.
     * 
     * Unifies the access of Attributes, References and Association links.
     * 
     * @param target
     *            RefObject to get the property value of.
     * @param propName
     *            Name of the property to get the value of.
     * @return The value of the given property for the target RefObject. This can be a collection for multi-valued properties.
     */
	public static Object getPropertyValue(RefObject target,
			PropertyReference propRef) {
		assert (target != null);

		if (propRef != null) {

			if (propRef.getName() != null) {
				// assume that name can only refer to an attribute or reference,
				// not an association link
				return target.refGetValue(propRef.getName());
			}

			TypedElement elem = propRef.getStrucfeature();
			if (elem != null) {
				if (elem instanceof AssociationEnd) {
					AssociationEnd thisEnd = (AssociationEnd) elem;
					AssociationEnd otherEnd = thisEnd.otherEnd();
					
					RefAssociation ass = getConnectionFromRefObject(target)
							.getJmiHelper().getRefAssociationForAssociation(
									(Association) elem.refImmediateComposite());

					Collection<RefObject> results = null;

					try {
						// Warning, the other end must be used for this to work
						results = ass.refQuery(otherEnd.getName(), target);

					} catch (TypeMismatchException e) {
						return null;
					}
					if (results.size() > 1) {
						return results;
					} else if (results.size() == 1) {
						return results.iterator().next();
					}
				} else {
					return target.refGetValue(elem);
				}
			}

		}

		return null;
	}

	/**
	 * @param p
	 * @return
	 */
	static public TypedElement getStructuralFeature(Property p) {
		PropertyReference propRef = p.getPropertyReference();
		if (propRef != null) {
			TypedElement feat = propRef.getStrucfeature();
			if (feat != null) {
				return feat;
			} else if (propRef.getName() != null) {
				// TODO
				// String proName = propRef.getName();
				// // use name and enclosing template to find property in
				// metamodel, lookup multiplicity there
				throw new RuntimeException(
						"Property References to Non-Moin Elements not implemented yet: "
								+ propRef.getName());
			} else {
				throw new RuntimeException(
						"BUG: Syntax cointains invalid property Reference missing name and StructureReference.");
			}
		} else {
			throw new RuntimeException(
					"BUG: Property without property Reference");
		}
	}

	public static boolean isEnumeration(Property p) {
		TypedElement feat = getStructuralFeature(p);
		return (feat.getType() instanceof EnumerationType);
	}

	public static String joinNameList(List<String> names) {
		String result = "";
		if (names != null && names.size() != 0) {
			result += names.get(0);
			for (int i = 1; i < names.size(); i++) {
				result += "::" + names.get(i);
			}

		}

		return result;
	}

	public static List<String> queryPropertyValues(Classifier type,
			String featureName, Connection conn) {

		// TODO limit query to a single partition or use model information from
		// parsing handler instead?

		String query = "select ofClass from "
				+ joinNameList(type.getQualifiedName()) + " as ofClass";

		MQLResultSet resultSet = queryConn(conn, query);
		RefObject[] resultElements = resultSet.getRefObjects("ofClass");

		List<String> results = new ArrayList<String>();

		for (RefObject elem : resultElements) {
			try {
				Object featureValue = elem.refGetValue(featureName);
				if (featureValue instanceof Integer) {
					results.add("" + featureValue);
				}

				if (featureValue instanceof String) {
					results.add((String) featureValue);
				}
			} catch (Exception e) {
				System.err
						.println("TcsUtil.queryPropertyValues encountered the following error: cannot read feature "
								+ featureName
								+ " from element "
								+ elem.toString());
			}

			// TODO need to add more type checks?
		}

		/*
		 * System.out.println("TcsUtil.queryPropertyValues(" +
		 * joinNameList(type.getQualifiedName()) + ", " + featureName + ");");
		 * System.out.println(query); System.out.println(results);
		 */

		return results;

	}

	public static List<EnumLiteralMapping> getEnumTemplateForType(
			ConcreteSyntax syntax, Classifier type) {

		// TODO if too slow, also build map like for class and operator
		// templates

		List<EnumLiteralMapping> results = new ArrayList<EnumLiteralMapping>();

		for (Template t : syntax.getTemplates()) {
			if (t instanceof EnumerationTemplate) {
				if (getQualifiedName(t).equals(type.getQualifiedName())) {
					// match
					EnumerationTemplate enumTemplate = (EnumerationTemplate) t;
					results.addAll(enumTemplate.getMappings());
					break;
				}
			}
		}

		return results;
	}

	public static Collection<PRI> getSyntaxePartitions(Connection connection,
			String languageId) {
		ConcreteSyntax cs = getSyntaxByName(connection, languageId);
		if (cs == null) {
			throw new RuntimeException("Concrete syntax with id '" + languageId
					+ "' not found.");
		}
		// TODO for language composition return also all partitions of
		// dependencies
		return Collections.singleton(((Partitionable) cs).get___Partition()
				.getPri());
	}

	public static ClassTemplate resolveClassTemplate(
			List<String> qualifiedName, String mode,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
		Map<String, ClassTemplate> templateMap = classTemplateMap
				.get(qualifiedName);
		if (templateMap != null) {
			return templateMap.get(mode);
		} else {
			return null;
		}
	}

	public static boolean isContext(Template template) {
		if (template instanceof ClassTemplate) {
			return ((ClassTemplate) template).isContext();
		} else if (template instanceof OperatorTemplate) {
			return ((OperatorTemplate) template).isContext();
		} else {
			return false;
		}
	}

	/**
	 * Returns all directly contained {@link InjectorActionsBlock}s.
	 * 
	 * @param elementSequence
	 */
	public static Collection<InjectorActionsBlock> getInjectorActions(
			Sequence elementSequence) {
		List<InjectorActionsBlock> injectorActions = new ArrayList<InjectorActionsBlock>();
		for (SequenceElement seqEl : elementSequence.getElements()) {
			if (seqEl instanceof InjectorActionsBlock) {
				injectorActions.add((InjectorActionsBlock) seqEl);
			}
		}
		return injectorActions;
	}

	public static boolean containsQueryArg(Property p) {
		return getQueryParg(p) != null;
	}

	public static String getQuery(Property se) {
		QueryParg arg = getQueryParg(se);
		if (arg != null) {
			StringBuffer query = new StringBuffer(arg.getQuery());
			FilterParg filterParg = getFilterParg(se);
			if (filterParg != null) {
				query.append(filterParg.getFilter());
			}
			return query.toString();
		}
		return null;
	}

	public static boolean isStructureTypeTemplate(Template parseRule) {
		return parseRule.getMetaReference() != null
				&& parseRule.getMetaReference() instanceof StructureType;
	}

	public static boolean isReferenceOnly(Template template) {
		if (template instanceof ClassTemplate) {
			return ((ClassTemplate) template).isReferenceOnly();
		} else if (template instanceof OperatorTemplate) {
			return ((OperatorTemplate) template).isReferenceOnly();
		}
		return false;
	}

	public static boolean isPropertyInit(SequenceElement se) {
		return se instanceof InjectorActionsBlock;
	}

	/**
	 * Checks whether at least one of the given types has a template defined.
	 * 
	 * @param subtypes
	 * @param mode
	 * @return
	 * @throws SyntaxElementException
	 */
	public static <Type> boolean areSubTypesWithTemplates(
			List<ResolvedNameAndReferenceBean<Type>> subtypes, String mode,
			SyntaxLookup syntaxLookup) throws SyntaxElementException {
		for (Iterator<ResolvedNameAndReferenceBean<Type>> iterator = subtypes
				.iterator(); iterator.hasNext();) {
			ResolvedNameAndReferenceBean<Type> subTypeName = iterator.next();
			Template subtemp = null;

			subtemp = syntaxLookup.getTCSTemplate(subTypeName, mode);
			if (subtemp != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gives the mode of the template if its a {@link ClassTemplate}.
	 * 
	 * @param template
	 * @return
	 */
	public static String getTemplateMode(Template template) {
		if (template instanceof ClassTemplate) {
			return ((ClassTemplate) template).getMode();
		}
		return null;
	}

	public static boolean matchesContext(ClassTemplate ct, String tag) {
		if (ct.isContext()) {
			if (tag != null) {
				if (ct.getContextTags() != null
						&& ct.getContextTags().getTags() != null) {
					for (String curTag : ct.getContextTags().getTags()) {
						if (curTag.equals(tag)) {
							return true;
						}
					}
				}
			} else {
				// return RefObject that matches this ClassTemplate
				return true;

			}
		}

		return false;
	}

	public static boolean matchesContext(OperatorTemplate ot, String tag) {
		if (ot.isContext()) {
			if (tag != null) {
				if (ot.getContextTags() != null
						&& ot.getContextTags().getTags() != null) {
					for (String curTag : ot.getContextTags().getTags()) {
						if (curTag.equals(tag)) {
							return true;
						}
					}
				}
			} else {
				// return RefObject that matches this ClassTemplate
				return true;

			}
		}

		return false;
	}

	public static SequenceElement getContainerSequenceElement(SequenceElement e) {
		Sequence parentSequence = e.getElementSequence();
		if (parentSequence != null) {
			RefFeatured container = parentSequence.refImmediateComposite();
			if (container instanceof SequenceElement) {
				return (SequenceElement) container;
			}
		}

		return null;
	}

	public static Token getCommentToken(ConcreteSyntax syntax) {
		if (syntax != null) {
			for (Token tok : syntax.getTokens()) {
				// TODO update this, if COMMENT token stops being fixed
				if (tok.getName().equals("COMMENT")) {
					return tok;
				}
			}
		}

		return null;
	}

	/**
	 * succeeds only if the following form is present in the tcs file: token
	 * COMMENT : endOfLine(start = "--");
	 * 
	 * @param tok
	 * @return
	 */
	public static String getEndOfLineCommentPrefix(Token tok) {
		if (tok.getPattern() != null) {
			for (SimplePattern pattern : tok.getPattern().getSimplePatterns()) {
				if (pattern instanceof RulePattern) {
					RulePattern rulePattern = (RulePattern) pattern;
					Rule rule = rulePattern.getRule();
					if (rule instanceof EndOfLineRule) {
						EndOfLineRule eofRule = (EndOfLineRule) rule;
						StringPattern eofRulePattern = eofRule.getStart();
						if (eofRulePattern != null) {
							return eofRulePattern.getName();
						}
					}
				}
			}
		}

		return null;
	}

	public static Object executeOclQuery(RefObject element, String oclQuery,
			RefObject contextObject, RefObject foreachObject, String keyValue)
			throws ModelAdapterException {
		if (oclQuery != null) {

			Object expectedValue = null;

			Connection con = getConnectionFromRefObject(element);

			AdapterJMIHelper oclHelper = new AdapterJMIHelper(element
					.refOutermostPackage(), con, con.getJmiHelper(), null, null);

			// propName is never used in findElementWithOCLQuery
			expectedValue = oclHelper.findElementWithOCLQuery(element, null,
					keyValue, oclQuery, contextObject, foreachObject);

			return expectedValue;
		}

		return null;
	}

	public static boolean isPropValueAndOclResultEqual(Object propValue, Object oclResult) {
		// oclHelper.findElementWithOCLQuery returns null for empty
		// collections
		if (propValue == null
				|| (propValue instanceof Collection && ((Collection<?>) propValue)
						.size() == 0)) {
			if (oclResult != null) {
				return false;
			}
		} else {
			if (!propValue.equals(oclResult)) {
				return false;
			}
		}
		
		return true;
	}

	public static String getContextTag(String oclQuery) {
		// strip OCL query prefix
		if (oclQuery.startsWith(MoinModelAdapterDelegate.OCL_QUERY_PREFIX)) {
			oclQuery = oclQuery
					.substring(MoinModelAdapterDelegate.OCL_QUERY_PREFIX
							.length());
		}
	
		final Pattern contextPattern = Pattern
				.compile("#context(\\((\\w*)(\\)))?");
	
		// #context(blub) will make
		// group 0: #context(blub)
		// group 2: blub
	
		// #context will make
		// group 0: #context
		// group 2: null
	
		Matcher matcher = contextPattern.matcher(oclQuery);
		if (matcher.find()) {
			return matcher.group(2);
		} else {
			return null;
		}
	}

	
    /**
     * Retrieves the parent {@link Template} of the queryElement which may be either 
     * a {@link InjectorAction} or a {@link Property}.
     * @param queryElement
     * @return
     */
    public static Template getParentTemplate(RefObject queryElement) {
        if(queryElement instanceof Property) {
            return ((Property) queryElement).getParentTemplate();
        } else if(queryElement instanceof InjectorAction) {
            return ((InjectorAction) queryElement).getInjectorActionsBlockReference().getParentTemplate();
        } else {
            return null;
        }
    }
}
