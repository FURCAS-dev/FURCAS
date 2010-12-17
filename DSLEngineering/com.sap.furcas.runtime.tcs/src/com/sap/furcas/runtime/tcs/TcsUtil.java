package com.sap.furcas.runtime.tcs;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromFixedSet;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereRelationReference;
import org.eclipse.emf.query2.WhereString;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Rule;
import com.sap.furcas.metamodel.FURCAS.TCS.RulePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;

/**
 * Utility class for the TcsPackage.
 * 
 * Used by the CtsContentAssistProcessor, to calculate possible inputs after a given SequenceElement.
 * 
 * Terminology: Atomic SequenceElement is one of: Property points to an Attribute or a Reference with the refersTo argument,
 * LiteralRef.
 * 
 * The other SequenceElements are composite in the sense, that they contain child-Sequences, and will not contain any input-tokens
 * directly.
 * 
 * CustomSeparators are ignored, as they do not contain any input-tokens and no child Sequences.
 * 
 * @author D052602
 * 
 */
public class TcsUtil {

    private static final URI TRANSIENT_PARTITION_NAME = URI.createURI("TcsUtilTransientPartition");
	private static final String MQL_ALIAS_INSTANCE = "cs";

    /**
     * clears the TcsUtil transient partition on this connection
     * 
     * @param c
     */
    public static void clearTransientPartition(ResourceSet c) {
        Resource transientPartition = c.getResource(TRANSIENT_PARTITION_NAME, true);
        transientPartition.getContents().clear();

        // also clear operatorToLiteralRefMap which would otherwise refer to
        // deleted elements
        operatorToLiteralRefMap.clear();
    }

    /**
     * caches LiteralRefs that are created to be returned as atomic sequence elements for each operator literal
     */
    private static Map<Operator, LiteralRef> operatorToLiteralRefMap = new HashMap<Operator, LiteralRef>();

    /**
     * Returns a list of all possible atomic SequenceElements, that directly follow the given SequenceElement, or indirectly
     * follow it through SequenceElements that may have no tokens (i.e null Sequences in ConditionalElement).
     * 
     * The parentFunctionCallMap parameter is needed to disambiguate between the different FunctionCalls that reference the
     * FunctionTemplate this SequenceElement is part of. The map is needed, as functions can contain other functions.
     * 
     * @param e
     *            SequenceElement after which to look
     * @param parentFunctionCallMap
     *            maps the correct parent FunctionCall for each FunctionTemplate this SequenceElement is part of
     * @return all possible SequenceElements that are directly following
     */
    public static List<SequenceElement> getPossibleAtomicFollows(SequenceElement e, Stack<FunctionCall> parentFunctionCallStack,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Stack<Property> parentPropertyStack,
            boolean isOperator, ConcreteSyntax syntax) {

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

                SeparatorPArg sepArg = TcsUtil.getSeparatorPArg(prop);
                if (sepArg != null) {
                    // add separator sequence proposals as well
                    Sequence sepSeq = sepArg.getSeparatorSequence();
                    results.addAll(TcsUtil.getPossibleFirstAtomicSequenceElements(sepSeq, classTemplateMap,
                            new HashSet<Template>(), syntax));
                } else {
                    if (isMultiValued(prop) && !containsForcedUpperArgOfOne(prop)) {

                        // add the first elements of this property to
                        // the follows-set

                        addAllIfNotNull(results,
                                getPossibleFirstAtomicSequenceElements(prop, classTemplateMap, new HashSet<Template>(), syntax));
                    }
                }

                // operator handling
                if (isOperatored(prop, classTemplateMap)) {
                    if (isOperator && orderOfParent == 1) {
                        // we are at an operator
                        // if the corresponding OperatorTemplates have a sequence, add the possible first atomic of that sequence.
                        // if this is not the case for at least one matching OperatorTemplate, add first elements of parent
                        // property

                        boolean otWithoutSequenceFound = false;

                        for (OperatorTemplate ot : findOperatorTemplatesByOperatorLiteralValue(operatorValue,
                                (EClass) getType(prop), syntax)) {
                            if (ot.getOtSequence() != null) {
                                addAllIfNotNull(
                                        results,
                                        getPossibleFirstAtomicSequenceElements(ot.getOtSequence(), classTemplateMap,
                                                new HashSet<Template>(), syntax));
                            } else {
                                otWithoutSequenceFound = true;
                            }
                        }

                        if (otWithoutSequenceFound) {

                            addAllIfNotNull(
                                    results,
                                    getPossibleFirstAtomicSequenceElements(prop, classTemplateMap, new HashSet<Template>(),
                                            syntax));
                        }

                    } else {
                        // we are before or past an operator and thus add all
                        // valid operators to the proposals
                        for (ClassTemplate ct : getClassTemplates((EClass) getType(prop), getMode(prop), classTemplateMap,
                                getResourceSetFromEObject(prop))) {
                            addAllIfNotNull(results, getOperatorsAsAtomicSequenceElements(getOperatorList(ct, syntax)));
                        }
                    }
                }
            }

            if (current instanceof Alternative) {
                Alternative alt = (Alternative) current;
                if (alt.isIsMulti()) {
                    addAllIfNotNull(results,
                            getPossibleFirstAtomicSequenceElements(alt, classTemplateMap, new HashSet<Template>(), syntax));
                }
            }

            Sequence parentSeq = current.getElementSequence();
            if (parentSeq.getSeparatorContainer() != null) {
                // we are in a separator sequence, add parent property to
                // proposals

                try {
                    Property parentProp = copiedParentPropertyStack.peek();
                    addAllIfNotNull(results, TcsUtil.getPossibleFirstAtomicSequenceElements(parentProp, classTemplateMap,
                            new HashSet<Template>(), syntax));
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
                        getPossibleFirstAtomicSequenceElements(next, classTemplateMap, new HashSet<Template>(), syntax));

                results.addAll(nextElementResults);
                if (nextElementResults.contains(null)) {
                    next = getNextSequenceElement(next);

                } else {
                    // next SequenceElement is guaranteed to need a Token
                    return results;
                }
            }

            current = getParentSequenceElement(current, copiedParentFunctionCallStack, copiedParentPropertyStack,
                    classTemplateMap);

            orderOfParent++;
        }

        // special handling of operatored main template
        // don't need to check current == null because current has been used before
        if (syntax != null) {
            ClassTemplate main = TcsUtil.getMainClassTemplate(syntax);
            if (main.isIsOperatored()) {

                if (isOperator && orderOfParent == 1) {
                    // we are at an operator, add first elements of parent
                    // property
                    addAllIfNotNull(
                            results,
                            getPossibleFirstAtomicSequenceElements((EClass) main.getMetaReference(), main.getMode(), classTemplateMap,
                                    new HashSet<Template>(), syntax, getResourceSetFromEObject(main)));

                    // also add prefix operators
                    addAllIfNotNull(results, getPrefixOperatorsAsAtomicSequenceElements(getOperatorList(main, syntax)));

                } else {
                    // we are before or past an operator and thus add all
                    // valid operators to the proposals
                    addAllIfNotNull(results, getOperatorsAsAtomicSequenceElements(getOperatorList(main, syntax)));
                }
            }

        }

        return results;
    }

    private static Collection<OperatorTemplate> findOperatorTemplatesByOperatorLiteralValue(String operatorValue, EClass type,
            ConcreteSyntax syntax) {
        List<OperatorTemplate> result = new ArrayList<OperatorTemplate>();
        Collection<EClass> subTypes = getAllSubtypes(type);
        for (Template t : syntax.getTemplates()) {
            if (t instanceof OperatorTemplate) {
                OperatorTemplate ot = (OperatorTemplate) t;
                for (EClass subType : subTypes) {
                    if (ot.getMetaReference() != null && ot.getMetaReference().equals(subType)) {
                        if (ot.getOperators() != null) {
                            for (Operator op : ot.getOperators()) {
                                // assumes that not two operators within the
                                // used
                                // operator list have the same literal
                                if (op.getLiteral().getValue().equals(operatorValue)) {
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

    public static Collection<EClass> getAllSubtypes(EClass clazz) {
        // TODO use query for this to have a greater scope
        Collection<EClass> subTypes = new ArrayList<EClass>();
        for (Iterator<EObject> it = clazz.eResource().getAllContents(); it.hasNext();) {
            EObject e = it.next();
            if (e instanceof EClass) {
                if (clazz.isSuperTypeOf((EClass) e)) {
                    subTypes.add((EClass) e);
                }
            }
        }
        return subTypes;
    }

    private static OperatorList getOperatorList(ClassTemplate ct, ConcreteSyntax syntax) {
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

    private static List<SequenceElement> getOperatorsAsAtomicSequenceElements(OperatorList operatorList) {
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

    private static List<SequenceElement> getPrefixOperatorsAsAtomicSequenceElements(OperatorList operatorList) {
        if (operatorList == null) {
            return null;
        }

        // prefix means arity of 1 and left associativity and not postfix

        List<SequenceElement> results = new ArrayList<SequenceElement>();
        for (Priority prio : operatorList.getPriorities()) {
            if (prio.getAssociativity() == Associativity.LEFT) {
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

    private static void cacheOperatorLiteral(OperatorList operatorList, Operator op) {
        ResourceSet c = TcsUtil.getResourceSetFromEObject(operatorList);
        Resource transientPartition = c.getResource(TRANSIENT_PARTITION_NAME, true);
        LiteralRef litRef = TCSFactory.eINSTANCE.createLiteralRef();
        transientPartition.getContents().add(litRef);
        litRef.setReferredLiteral(op.getLiteral());
        operatorToLiteralRefMap.put(op, litRef);
    }

    private static boolean containsForcedUpperArgOfOne(Property prop) {
        ForcedUpperPArg upperArg = getForcedUpperPArg(prop);
        if (upperArg != null && upperArg.getValue() == 1) {
            return true;
        }

        return false;
    }

    private static boolean containsForcedLowerArg(Property prop) {
        return (getForcedLowerPArg(prop) != null);

    }

    public static List<SequenceElement> getMainTemplatePossibleFirstAtomicSequenceElements(ConcreteSyntax syntax,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {

        ClassTemplate main = getMainClassTemplate(syntax);
        if (main.isIsAbstract()) {
            return getPossibleFirstAtomicSequenceElements((EClass) main.getMetaReference(), main.getMode(), classTemplateMap,
                    new HashSet<Template>(), syntax, getResourceSetFromEObject(main));

        } else {
            return getPossibleFirstAtomicSequenceElements(getMainClassTemplate(syntax), classTemplateMap,
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

    public static Stack<FunctionCall> duplicateFunctionCallStack(Stack<FunctionCall> source) {
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

        ETypedElement feat = getStructuralFeature(p);
        if (feat instanceof EReference || feat instanceof EParameter || feat instanceof EStructuralFeature) {
            int upper = feat.getUpperBound();
            return (upper < 0 || upper > 1);
        }
        return false;
    }

    private static void addAllIfNotNull(List<SequenceElement> output, List<SequenceElement> input) {
        if (input != null) {
            output.addAll(input);
        }
    }

    /**
     * Returns a list of the first possible atomic SequenceElements of the given SequenceElement.
     * 
     * Composite SequenceElements return the possible first atomic SequenceElements of each of their children merged into a single
     * list, atomic SequenceElements return a list containing themselves.
     * 
     * @param e
     *            SequenceElement to get the first possible atomic SequenceElements from
     * @param visitedTemplates
     * @return first possible atomic SequenceElements
     */
    public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(SequenceElement e,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        List<SequenceElement> results = new ArrayList<SequenceElement>();

        // check for composite SequenceElements
        if (e instanceof Alternative) {
            Alternative alt = (Alternative) e;

            if (alt.isIsMulti()) {
                // isMulti Alternative is optional
                results.add(null);
            }

            for (Sequence s : alt.getSequences()) {
                addAllIfNotNull(
                        results,
                        getPossibleFirstAtomicSequenceElements(s, classTemplateMap, new HashSet<Template>(visitedTemplates),
                                syntax));
            }
            return results;
        }

        else if (e instanceof ConditionalElement) {
            ConditionalElement cond = (ConditionalElement) e;
            addAllIfNotNull(
                    results,
                    getPossibleFirstAtomicSequenceElements(cond.getThenSequence(), classTemplateMap, new HashSet<Template>(
                            visitedTemplates), syntax));
            addAllIfNotNull(
                    results,
                    getPossibleFirstAtomicSequenceElements(cond.getElseSequence(), classTemplateMap, new HashSet<Template>(
                            visitedTemplates), syntax));
            return results;
        }

        else if (e instanceof Block) {
            Block block = (Block) e;
            addAllIfNotNull(results,
                    getPossibleFirstAtomicSequenceElements(block.getBlockSequence(), classTemplateMap, visitedTemplates, syntax));
            return results;
        }

        else if (e instanceof FunctionCall) {
            FunctionCall call = (FunctionCall) e;
            addAllIfNotNull(results,
                    getPossibleFirstAtomicSequenceElements(call.getCalledFunction(), classTemplateMap, visitedTemplates, syntax));
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
                addAllIfNotNull(
                        results,
                        getPossibleFirstAtomicSequenceElements((EClass) getType(prop), getMode(prop), classTemplateMap,
                                visitedTemplates, syntax, getResourceSetFromEObject(prop)));
                return results;
            }
        }

        else {
            // atomic SequenceElement or null
            results.add(e);

            return results;
        }

    }

    public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(EClass type, String mode,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates,
            ConcreteSyntax syntax, ResourceSet connection) {
        List<SequenceElement> results = new ArrayList<SequenceElement>();
        for (ClassTemplate ct : getClassTemplates(type, mode, classTemplateMap, connection)) {
            if (!ct.isIsAbstract()) {
                addAllIfNotNull(results, getPossibleFirstAtomicSequenceElements(ct, classTemplateMap, visitedTemplates, syntax));
            } else {
                if (ct.isIsOperatored()) {
                    // add prefix operators
                    addAllIfNotNull(results, getPrefixOperatorsAsAtomicSequenceElements(getOperatorList(ct, syntax)));
                }
            }
        }

        return results;
    }

    public static EClassifier getType(Property p) {
        ETypedElement e = getStructuralFeature(p);
        if (e != null) {
            return e.getEType();
        }

        return null;
    }

    public static String getMode(Property p) {
        ModePArg modeArg = getModePArg(p);
        if (modeArg != null) {
            return modeArg.getMode();
        }

        return null;
    }

    public static boolean isAtomic(Property p, Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
        ETypedElement s = getStructuralFeature(p);
        if (s != null) {
            if (s instanceof EReference) {
                if (!containsRefersToArg(p) && !containsAsArg(p)) {
                    return false;
                }

            }
            if (s instanceof EAttribute && classTemplateMap != null) {
                // check if we have a non-primitive type attribute by querying
                // classTemplateMap
                List<String> typeName = getQualifiedName(getType(p));
                if (classTemplateMap.containsKey(typeName)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Computes the fully qualified name of the given {@link EClassifier}.
     * 
     * @param type
     *            the type to compute its qualified name from.
     * @return the Qualified name of the given type as list of strings.
     */
    private static List<String> getQualifiedName(EClassifier type) {
        List<String> names = new ArrayList<String>(3);
        names.add(type.getName());
        EObject parent = type.eContainer();
        while (parent != null) {
            if (parent instanceof ENamedElement) {
                names.add(0, ((ENamedElement) parent).getName());
                parent = parent.eContainer();
            } else {
                // There is an element which is not a ENamedElement
                // in the containment hierarchy, break qname building here
                break;
            }
        }
        return names;
    }

    public static boolean isOperatored(Property p, Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
        ETypedElement s = getStructuralFeature(p);
        if (s != null) {
            if (classTemplateMap != null) {
                List<String> typeName = getQualifiedName(getType(p));
                if (classTemplateMap.containsKey(typeName)) {
                    ClassTemplate ct = classTemplateMap.get(typeName).get(getMode(p));
                    if (ct != null) {
                        return ct.isIsOperatored();
                    }
                }
            }
        }

        return false;
    }

    public static boolean containsRefersToArg(Property p) {
        return getRefersToPArg(p) != null;
    }

    public static boolean containsAsArg(Property p) {
        return getAsPArg(p) != null;
    }

    /**
     * returns the first SeparatorPArg of Property p. There should only be one. No error is thrown, if more than one exist.
     * 
     * @param p
     *            Property
     * @return first SeparatorPArg
     */
    public static SeparatorPArg getSeparatorPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof SeparatorPArg) {
                return (SeparatorPArg) arg;
            }
        }

        return null;
    }

    /**
     * returns the first AsPArg of Property p. There should only be one. No error is thrown, if more than one exist.
     * 
     * @param p
     *            Property
     * @return first RefersToPArg
     */
    public static AsPArg getAsPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof AsPArg) {
                return (AsPArg) arg;
            }
        }

        return null;
    }

    /**
     * returns the first RefersToPArg of Property p. There should only be one. No error is thrown, if more than one exist.
     * 
     * @param p
     *            Property
     * @return first RefersToPArg
     */
    public static RefersToPArg getRefersToPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof RefersToPArg) {
                return (RefersToPArg) arg;
            }
        }

        return null;
    }

    /**
     * returns the first {@link QueryPArg} of Property p. There should only be one. No error is thrown, if more than one exist.
     * 
     * @param p
     *            Property
     * @return first QueryPArg
     */
    public static QueryPArg getQueryPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof QueryPArg) {
                return (QueryPArg) arg;
            }
        }
        return null;
    }

    /**
     * returns the first {@link FilterPArg} of Property p. There should only be one. No error is thrown, if more than one exist.
     * 
     * @param p
     *            Property
     * @return first FilterPArg
     */
    public static FilterPArg getFilterPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof FilterPArg) {
                return (FilterPArg) arg;
            }
        }
        return null;
    }

    static ForcedUpperPArg getForcedUpperPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ForcedUpperPArg) {
                return (ForcedUpperPArg) arg;
            }
        }

        return null;
    }

    static ForcedLowerPArg getForcedLowerPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ForcedLowerPArg) {
                return (ForcedLowerPArg) arg;
            }
        }

        return null;
    }

    static ModePArg getModePArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ModePArg) {
                return (ModePArg) arg;
            }
        }

        return null;
    }

    public static boolean containsSeparatorArg(Property p) {
        return getSeparatorPArg(p) != null;
    }

    public static Collection<ClassTemplate> getClassTemplates(EClass type, String mode,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, ResourceSet connection) {
        Assert.isLegal(classTemplateMap != null, "could not resolve class template for Reference, classTemplateMap is null");

        List<ClassTemplate> results = new ArrayList<ClassTemplate>();

        // get all matching class templates of this type and any of the
        // (recursive) subtypes

        Collection<EClass> subTypes = getAllSubtypes(type);
        for (EClass subType : subTypes) {
            if (classTemplateMap.containsKey(getQualifiedName(subType))) {
                for (ClassTemplate ct : classTemplateMap.get(getQualifiedName(subType)).values()) {
                    if ((mode == null && ct.getMode() == null) || (mode != null && mode.equals(ct.getMode()))) {
                        results.add(ct);
                    }
                }
            }
        }

        return results;
    }

    public static ResourceSet getResourceSetFromEObject(EObject ref) {
        return ref.eResource().getResourceSet();
    }

    // TODO still needed?
    public static Literal findLiteralByName(ConcreteSyntax syntax, String literalName) {
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
     * Returns a list of the first possible atomic SequenceElements of the given FunctionTemplate.
     * 
     * @param t
     *            FunctionTemplate to get the first possible atomic SequenceElements from
     * @return first possible atomic SequenceElements
     */
    static List<SequenceElement> getPossibleFirstAtomicSequenceElements(FunctionTemplate t,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        if (t != null) {
            if (!visitedTemplates.contains(t)) {
                visitedTemplates.add(t);
                return getPossibleFirstAtomicSequenceElements(t.getFunctionSequence(), classTemplateMap, visitedTemplates, syntax);
            } else {
                return null;
            }

        }

        return createListWithEntry(null);
    }

    /**
     * Returns a list of the first possible atomic SequenceElements of the given ClassTemplate.
     * 
     * If the ClassTemplate is abstract, compute subtypes and add all possible first atomic elements for each non-abstract
     * subtype.
     * 
     * @param t
     *            ClassTemplate to get the first possible atomic SequenceElements from
     * @return first possible atomic SequenceElements
     */
    static List<SequenceElement> getPossibleFirstAtomicSequenceElements(ClassTemplate t,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        if (t != null) {
            if (!visitedTemplates.contains(t)) {
                visitedTemplates.add(t);
                return getPossibleFirstAtomicSequenceElements(t.getTemplateSequence(), classTemplateMap, visitedTemplates, syntax);
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
     * Returns a list of the first possible atomic SequenceElements of the given Sequence.
     * 
     * @param s
     *            Sequence to get the first possible atomic SequenceElements from
     * @return first possible atomic SequenceElements
     */
    public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(Sequence s,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        SequenceElement e = getFirstSequenceElement(s);

        List<SequenceElement> results = new ArrayList<SequenceElement>();

        List<SequenceElement> elementResults;
        do {
            elementResults = getPossibleFirstAtomicSequenceElements(e, classTemplateMap, new HashSet<Template>(visitedTemplates),
                    syntax);
            addAllIfNotNull(results, elementResults);
            e = getNextSequenceElement(e);
        } while (elementResults.contains(null) && e != null);

        return results;
    }

    /**
     * Returns the first SequenceElement of a Sequence s, or null if s is null or it has no SequenceElements.
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
     * Returns the next SequenceElement in the parent Sequence, or null, if it is the last SequenceElement.
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
        EObject container = e.eContainer();
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
     * Returns the next parent SequenceElement, if the SequenceElement has a parent Sequence, and that parent Sequence is either
     * part of another SequenceElement, FunctionTemplate, or SeparatorPArg.
     * 
     * The FunctionCall parameter is needed to disambiguate between the different FunctionCalls that reference the
     * FunctionTemplate this SequenceElement is part of.
     * 
     * @param e
     *            SequenceElement to find the parent SequenceElement of
     * @param parentFunctionCallMap
     *            the closest FunctionCall this SequenceElement belongs to. can be null, if not belonging to a FunctionTemplate
     *            Sequence
     * @param parentPropertyStack
     *            parent Properties. Important: Will be popped, when encountering a ClassTemplate. can be null.
     * @return the next parent SequenceElement, or null
     */
    public static SequenceElement getParentSequenceElement(SequenceElement e, Stack<FunctionCall> parentFunctionCallStack,
            Stack<Property> parentPropertyStack, Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {

        Sequence parentSequence = e.getElementSequence();
        if (parentSequence != null) {
            // check if parentSequence is part of a SequenceElement
            EObject container = parentSequence.eContainer();
            if (container instanceof SequenceElement) {
                return (SequenceElement) container;
            }

            if (container instanceof FunctionTemplate) {
                // reached a FunctionTemplate, continue at parent
                // FunctionCall

                Assert.isLegal(parentFunctionCallStack != null, "SequenceElement e belongs to a FunctionTemplate,"
                        + " but no parentFunctionCallStack given to disambiguate");

                Assert.isLegal(!parentFunctionCallStack.isEmpty(), "SequenceElement e belongs to a FunctionTemplate,"
                        + " but no entry in parentFunctionCallStack to disambiguate");

                FunctionCall parentFunctionCall = parentFunctionCallStack.pop();

                Assert.isLegal(parentFunctionCall.getCalledFunction() == container,
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

            if (container instanceof SeparatorPArg) {
                // reached a SeparatorPArg, continue at parent Property
                SeparatorPArg parentSepArg = (SeparatorPArg) container;
                EObject containerOfParent = parentSepArg.eContainer();
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
                if (isEnumeration(parent) || isOperatored(parent, classTemplateMap)) {
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
                    if (c.isIsMain()) {
                        return c;
                    }
                }
            }
        }

        return null;
    }

    public static ResultSet queryConn(ResourceSet resourceSet, String query) {
        try {
            return EcoreHelper.executeQuery(query, EcoreHelper.getQueryContext(resourceSet));
        } catch (MetaModelLookupException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet queryConn(ResourceSet resourceSet, Query query) {
        try {
            return EcoreHelper.executeQuery(query, EcoreHelper.getQueryContext(resourceSet));
        } catch (MetaModelLookupException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet querySameConn(EObject r, String query) {
        ResourceSet conn = getResourceSetFromEObject(r);
        return queryConn(conn, query);
    }

    public static List<ConcreteSyntax> getSyntaxesInResourceSet(ResourceSet connection) {

        String query = "select cs from [" + EcoreUtil.getURI(TCSPackage.eINSTANCE.getConcreteSyntax()) + "] withoutsubtypes as cs";

        ResultSet resultSet = queryConn(connection, query);
        URI[] resultElements = resultSet.getUris("cs");

        List<ConcreteSyntax> results = new ArrayList<ConcreteSyntax>();

        for (URI elem : resultElements) {
            results.add((ConcreteSyntax) connection.getEObject(elem, false));
        }

        return results;
    }

    public static List<ConcreteSyntax> getSyntaxesInResourceSetWithName(ResourceSet connection, String syntaxName) {
    	SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
        FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, EcoreUtil.getURI(TCSPackage.eINSTANCE.getConcreteSyntax()), /*withoutSubtypes*/ false);
        WhereString whereName = new WhereString("name", Operation.EQUAL, syntaxName);
        LocalWhereEntry where = new LocalWhereEntry(MQL_ALIAS_INSTANCE, whereName);
        Query query = new Query(new SelectEntry[] { se }, new FromEntry[] { fe }, new WhereEntry[] { where });
        ResultSet resultSet = queryConn(connection, query);
        URI[] resultElements = resultSet.getUris("cs");

        List<ConcreteSyntax> results = new ArrayList<ConcreteSyntax>();

        for (URI elem : resultElements) {
            results.add((ConcreteSyntax) connection.getEObject(elem, false));
        }
        return results;
    }

    /**
     * Get the build-in TCS ConcreteSyntax.
     * 
     * @param connection
     *            ResourceSet to look in
     * @return build-in TCS ConcreteSyntax
     */
    public static ConcreteSyntax getTcsSyntax(ResourceSet connection) {
        // TODO implement some real way of identifying the build-in TCS
        // ConcreteSyntax.
        // note that the name will not suffice, as a new TCS syntax can be build
        // using the build-in TCS syntax (after bootstrapping)

        List<ConcreteSyntax> syntaxList = getSyntaxesInResourceSet(connection);

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
     *            ResourceSet to look in
     * @return the ConcreteSyntax with the given name.
     */
    public static ConcreteSyntax getSyntaxByName(ResourceSet connection, String languageId) {
        List<ConcreteSyntax> syntaxList = getSyntaxesInResourceSetWithName(connection, languageId);
        if (syntaxList == null || syntaxList.size() == 0) {
            return null;
        } else {
            return syntaxList.get(0);
        }
    }

    /**
     * Creates a map of qualifiedName + Mode to ClassTemplate of all ClassTemplates contained in the syntax
     * 
     * @param syntax
     *            the ConcreteSyntax to build the map of
     * @return map of qualifiedName + Mode to ClassTemplate
     */
    public static Map<List<String>, Map<String, ClassTemplate>> createClassTemplateMap(ConcreteSyntax syntax) {
        Assert.isLegal(syntax != null);

        Map<List<String>, Map<String, ClassTemplate>> classTemplateMap = new HashMap<List<String>, Map<String, ClassTemplate>>();
        List<Template> templates = syntax.getTemplates();

        for (Template t : templates) {
            if (t instanceof ClassTemplate) {
                ClassTemplate ct = (ClassTemplate) t;

                List<String> qualifiedName = getQualifiedName(ct);

                putClassTemplate(classTemplateMap, qualifiedName, ct.getMode(), ct);
            }
        }

        return classTemplateMap;
    }

    public static List<String> getQualifiedName(Template t) {
        List<String> qualifiedName;
        EClassifier ref = t.getMetaReference();
        if (ref == null) { // syntaxes may merely define name of
            // metamodel class rather than have a
            // reference
            qualifiedName = t.getNames();
        } else {
            qualifiedName = getQualifiedName(ref);
        }

        if (qualifiedName == null) {
            System.err.println("class template could not be identified (qualifiedName and names both null");
        }
        return qualifiedName;
    }

    /**
     * Creates a map of qualifiedName to OperatorTemplate of all OperatorTemplates contained in the syntax
     * 
     * @param syntax
     *            the ConcreteSyntax to build the map of
     * @return map of qualifiedName to OperatorTemplate
     */
    public static Map<List<String>, OperatorTemplate> createOperatorTemplateMap(ConcreteSyntax syntax) {
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

    private static void putClassTemplate(Map<List<String>, Map<String, ClassTemplate>> classTemplateMap,
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
                ETypedElement strucFeat = propRef.getStrucfeature();
                if (strucFeat != null) {
                    return strucFeat.getName();
                }
            }
        }
        return null;
    }

    // /**
    // * Returns the value of the property identified by propName of the given target RefStruct.
    // *
    // *
    // * @param target
    // * RefStruct to get the property value of.
    // * @param propName
    // * Name of the property to get the value of.
    // * @return The value of the given property for the target RefStruct. This can be a collection for multi-valued properties.
    // */
    // public static Object getPropertyValue(RefStruct target,
    // PropertyReference propRef) {
    // assert (target != null);
    //
    // if (propRef != null) {
    //
    // if (propRef.getName() != null) {
    // // assume that name can only refer to an attribute or reference,
    // // not an association link
    // return target.refGetValue(propRef.getName());
    // }
    // ETypedElement elem = propRef.getStrucfeature();
    // if (elem != null) {
    // return target.refGetValue(elem.getName());
    // }
    // }
    // return null;
    // }

    /**
     * Returns the value of the property identified by propName of the given target EObject.
     * 
     * Unifies the access of Attributes, References and Association links.
     * 
     * @param target
     *            EObject to get the property value of.
     * @param propName
     *            Name of the property to get the value of.
     * @return The value of the given property for the target EObject. This can be a collection for multi-valued properties.
     */
    public static Object getPropertyValue(EObject target, PropertyReference propRef) {
        assert (target != null);

        if (propRef != null) {

            if (propRef.getName() != null) {
                // assume that name can only refer to an attribute or reference,
                // not an association link
                return target.eGet(target.eClass().getEStructuralFeature(propRef.getName()));
            }

            EStructuralFeature elem = propRef.getStrucfeature();
            if (elem != null) {
                // if (elem instanceof AssociationEnd) {
                // AssociationEnd thisEnd = (AssociationEnd) elem;
                // AssociationEnd otherEnd = thisEnd.otherEnd();
                //
                // RefAssociation ass = getResourceSetFromEObject(target)
                // .getJmiHelper().getRefAssociationForAssociation(
                // (Association) elem.refImmediateComposite());
                //
                // Collection<EObject> results = null;
                //
                // try {
                // // Warning, the other end must be used for this to work
                // results = ass.refQuery(otherEnd.getName(), target);
                //
                // } catch (TypeMismatchException e) {
                // return null;
                // }
                // if (results.size() > 1) {
                // return results;
                // } else if (results.size() == 1) {
                // return results.iterator().next();
                // }
                // } else {
                return target.eGet(elem);
                // }
            }

        }

        return null;
    }

    /**
     * @param p
     * @return
     */
    static public EStructuralFeature getStructuralFeature(Property p) {
        PropertyReference propRef = p.getPropertyReference();
        if (propRef != null) {
            EStructuralFeature feat = propRef.getStrucfeature();
            if (feat != null) {
                return feat;
            } else if (propRef.getName() != null) {
                // TODO
                // String proName = propRef.getName();
                // // use name and enclosing template to find property in
                // metamodel, lookup multiplicity there
                throw new RuntimeException("Property References to Non-Moin Elements not implemented yet: " + propRef.getName());
            } else {
                throw new RuntimeException(
                        "BUG: Syntax cointains invalid property Reference missing name and StructureReference.");
            }
        } else {
            throw new RuntimeException("BUG: Property without property Reference");
        }
    }

    public static boolean isEnumeration(Property p) {
        EStructuralFeature feat = getStructuralFeature(p);
        return (feat.getEType() instanceof EEnum);
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

    public static List<String> queryPropertyValues(EClassifier type, String featureName, ResourceSet conn) {

        // TODO limit query to a single partition or use model information from
        // parsing handler instead?

        String query = "select ofClass from [" + EcoreUtil.getURI(type) + "] as ofClass";

        ResultSet resultSet = queryConn(conn, query);
        URI[] resultElements = resultSet.getUris("ofClass");

        List<String> results = new ArrayList<String>();

        for (URI elemURI : resultElements) {
            try {
                EObject element = conn.getEObject(elemURI, false);
                Object featureValue = element.eGet(element.eClass().getEStructuralFeature(featureName));
                if (featureValue instanceof Integer) {
                    results.add("" + featureValue);
                }

                if (featureValue instanceof String) {
                    results.add((String) featureValue);
                }
            } catch (Exception e) {
                System.err.println("TcsUtil.queryPropertyValues encountered the following error: cannot read feature "
                        + featureName + " from element " + elemURI.toString());
            }

            // TODO need to add more type checks?
        }

        /*
         * System.out.println("TcsUtil.queryPropertyValues(" + joinNameList(type.getQualifiedName()) + ", " + featureName + ");");
         * System.out.println(query); System.out.println(results);
         */

        return results;

    }

    public static List<EnumLiteralMapping> getEnumTemplateForType(ConcreteSyntax syntax, EClassifier type) {

        // TODO if too slow, also build map like for class and operator
        // templates

        List<EnumLiteralMapping> results = new ArrayList<EnumLiteralMapping>();

        for (Template t : syntax.getTemplates()) {
            if (t instanceof EnumerationTemplate) {
                if (getQualifiedName(t).equals(getQualifiedName(type))) {
                    // match
                    EnumerationTemplate enumTemplate = (EnumerationTemplate) t;
                    results.addAll(enumTemplate.getMappings());
                    break;
                }
            }
        }

        return results;
    }

    public static Set<URI> getSyntaxPartitions(ResourceSet connection, String languageId) {
        ConcreteSyntax cs = getSyntaxByName(connection, languageId);
        if (cs == null) {
            throw new RuntimeException("Concrete syntax with id '" + languageId + "' not found.");
        }
        // TODO for language composition return also all partitions of
        // dependencies
        return Collections.singleton(((EObject) cs).eResource().getURI());
    }

    public static ClassTemplate resolveClassTemplate(List<String> qualifiedName, String mode,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
        Map<String, ClassTemplate> templateMap = classTemplateMap.get(qualifiedName);
        if (templateMap != null) {
            return templateMap.get(mode);
        } else {
            return null;
        }
    }

    public static boolean isContext(Template template) {
        if (template instanceof ClassTemplate) {
            return ((ClassTemplate) template).isIsContext();
        } else if (template instanceof OperatorTemplate) {
            return ((OperatorTemplate) template).isIsContext();
        } else {
            return false;
        }
    }

    /**
     * Returns all directly contained {@link InjectorActionsBlock}s.
     * 
     * @param elementSequence
     */
    public static Collection<InjectorActionsBlock> getInjectorActions(Sequence elementSequence) {
        List<InjectorActionsBlock> injectorActions = new ArrayList<InjectorActionsBlock>();
        for (SequenceElement seqEl : elementSequence.getElements()) {
            if (seqEl instanceof InjectorActionsBlock) {
                injectorActions.add((InjectorActionsBlock) seqEl);
            }
        }
        return injectorActions;
    }

    public static boolean containsQueryArg(Property p) {
        return getQueryPArg(p) != null;
    }

    public static String getQuery(Property se) {
        QueryPArg arg = getQueryPArg(se);
        if (arg != null) {
            StringBuffer query = new StringBuffer(arg.getQuery());
            FilterPArg filterPArg = getFilterPArg(se);
            if (filterPArg != null) {
                query.append(filterPArg.getFilter());
            }
            return query.toString();
        }
        return null;
    }

    // public static boolean isStructureTypeTemplate(Template parseRule) {
    // return parseRule.getMetaReference() != null
    // && parseRule.getMetaReference() instanceof StructureType;
    // }

    public static boolean isReferenceOnly(Template template) {
        if (template instanceof ClassTemplate) {
            return ((ClassTemplate) template).isIsReferenceOnly();
        } else if (template instanceof OperatorTemplate) {
            return ((OperatorTemplate) template).isIsReferenceOnly();
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
    public static <Type> boolean areSubTypesWithTemplates(List<ResolvedNameAndReferenceBean<Type>> subtypes, String mode,
            SyntaxLookup syntaxLookup) throws SyntaxElementException {
        for (ResolvedNameAndReferenceBean<Type> subTypeName : subtypes) {
            Collection<Template> subtemps = null;

            subtemps = syntaxLookup.getTCSTemplate(subTypeName, mode);
            if (subtemps != null && subtemps.size() > 0) {
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
        if (ct.isIsContext()) {
            if (tag != null) {
                if (ct.getContextTags() != null && ct.getContextTags().getTags() != null) {
                    for (String curTag : ct.getContextTags().getTags()) {
                        if (curTag.equals(tag)) {
                            return true;
                        }
                    }
                }
            } else {
                // return EObject that matches this ClassTemplate
                return true;

            }
        }

        return false;
    }

    public static boolean matchesContext(OperatorTemplate ot, String tag) {
        if (ot.isIsContext()) {
            if (tag != null) {
                if (ot.getContextTags() != null && ot.getContextTags().getTags() != null) {
                    for (String curTag : ot.getContextTags().getTags()) {
                        if (curTag.equals(tag)) {
                            return true;
                        }
                    }
                }
            } else {
                // return EObject that matches this ClassTemplate
                return true;

            }
        }

        return false;
    }

    public static SequenceElement getContainerSequenceElement(SequenceElement e) {
        Sequence parentSequence = e.getElementSequence();
        if (parentSequence != null) {
            EObject container = parentSequence.eContainer();
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
     * succeeds only if the following form is present in the tcs file: token COMMENT : endOfLine(start = "--");
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

    public static Object executeOclQuery(EObject element, String oclQuery, EObject contextObject, EObject foreachObject,
            String keyValue) throws ModelAdapterException {
        if (oclQuery != null) {

            TCSSpecificOCLEvaluator oclHelper = new TCSSpecificOCLEvaluator();

            return oclHelper.findElementsWithOCLQuery(element, keyValue, oclQuery, contextObject, foreachObject);
        }

        return null;
    }

    public static boolean isPropValueAndOclResultEqual(Object propValue, Object oclResult) {
        // oclHelper.findElementWithOCLQuery returns null for empty
        // collections
        if (propValue == null || (propValue instanceof Collection<?> && ((Collection<?>) propValue).size() == 0)) {
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
        if (oclQuery.startsWith(EMFModelAdapter.OCL_QUERY_PREFIX)) {
            oclQuery = oclQuery.substring(EMFModelAdapter.OCL_QUERY_PREFIX.length());
        }

        final Pattern contextPattern = Pattern.compile("#context(\\((\\w*)(\\)))?");

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
     * Retrieves the parent {@link Template} of the queryElement which may be either a {@link InjectorAction} or a
     * {@link Property}.
     * 
     * @param queryElement
     * @return
     */
    public static Template getParentTemplate(EObject queryElement) {
        if (queryElement instanceof Property) {
            return ((Property) queryElement).getParentTemplate();
        } else if (queryElement instanceof InjectorAction) {
            return ((InjectorAction) queryElement).getInjectorActionsBlock().getParentTemplate();
        } else {
            return null;
        }
    }

    public static Template findTemplate(EClass foreachElementType, String mode, Collection<URI> partitionScope) {
    
        // TODO query fully qualified name!
        ResultSet result;
        EClassifier clazz = foreachElementType;
        ResourceSet rs = foreachElementType.eResource().getResourceSet();
    
        // TODO search only in the mapping partition!
        Template template = null;
        if (clazz != null) {
            SelectEntry select = new SelectAlias("template");
            FromType fromClassTemplate = new FromType("template", EcoreUtil.getURI(TCSPackage.eINSTANCE.getClassTemplate()), /* _withoutSubtypes */ false);
            FromFixedSet fromClass = new FromFixedSet("class", EcoreUtil.getURI(clazz.eClass()), new URI[] { EcoreUtil.getURI(clazz) });
            WhereEntry whereMetaReference = new WhereRelationReference(/* _leftAlias */ "template", /* _featureName */ "metaReference",
                    /* _rightAlias */ "class");
            WhereEntry whereMode = new LocalWhereEntry("template", new WhereString("mode", Operation.EQUAL, mode));
            Query queryForClassTemplate = new Query(new SelectEntry[] { select }, new FromEntry[] { fromClassTemplate, fromClass },
                    new WhereEntry[] { whereMetaReference, whereMode });
            if (true /* template == null */) { // TODO
                QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(getIndex());
                TypeScopeProvider mappingQueryScope = queryProcessor.getInclusiveQueryScopeProvider(partitionScope
                        .toArray(new URI[] {}));
                QueryContext context = getQueryScope(rs, mappingQueryScope);
                result = queryProcessor.execute(queryForClassTemplate, context);
                URI[] eObjectsURIs = result.getUris("template");
                if (eObjectsURIs.length > 1) {
                    template = (Template) rs.getEObject(eObjectsURIs[1], false);
                } else if (eObjectsURIs.length == 1) {
                    template = (Template) rs.getEObject(eObjectsURIs[0], false);
                }
                if (template == null) {
                    // maybe operatorTemplate?
                    FromType fromOperatorTemplate = new FromType("template", EcoreUtil.getURI(TCSPackage.eINSTANCE.getOperatorTemplate()), /* _withoutSubtypes */ false);
                    Query queryForOperatorTemplate = new Query(new SelectEntry[] { select }, new FromEntry[] { fromOperatorTemplate, fromClass },
                            new WhereEntry[] { whereMetaReference, whereMode });
                    result = queryProcessor.execute(queryForOperatorTemplate, context);
                    template = getTemplate(result, rs, template);
                }
    
            }
        }
    
        return template;
    }

    private static Template getTemplate(ResultSet result, ResourceSet rs, Template template) {
        URI[] eObjectsURIs;
        eObjectsURIs = result.getUris("template");

        if (eObjectsURIs.length > 1) {
            template = (com.sap.furcas.metamodel.FURCAS.TCS.Template) rs.getEObject(eObjectsURIs[1], false);
        } else if (eObjectsURIs.length == 1) {
            template = (Template) rs.getEObject(eObjectsURIs[0], false);
        }
        return template;
    }

    private static QueryContext getQueryScope(ResourceSet rs, TypeScopeProvider mappingQueryScope) {
        Set<URI> resourcesInScope = new HashSet<URI>();
        for (URI uri : mappingQueryScope.getPartitionScope()) {
            resourcesInScope.add(uri);
        }
        return com.sap.furcas.runtime.common.util.EcoreHelper.getQueryContext(rs, resourcesInScope);
    }

    private static org.eclipse.emf.query.index.Index getIndex() {
        return IndexFactory.getInstance();
    }

    /**
     * By ascending the containment hierarchy of the {@link ConcreteSyntax} containing this injector
     * action, determines this language's ID. If for some reason the <code>injectorAction</code> is not
     * contained in a {@link ConcreteSyntax} element, <code>null</code> is returned.
     */
    public static String getLanguageId(InjectorAction injectorAction) {
        EObject e = injectorAction;
        while (e != null && !(e instanceof ConcreteSyntax)) {
            e = e.eContainer();
        }
        if (e instanceof ConcreteSyntax) {
            return ((ConcreteSyntax) e).getName();
        } else {
            return null;
        }
    }

}
