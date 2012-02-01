package com.sap.furcas.runtime.tcs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.IndexFactory;
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
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.Rule;
import com.sap.furcas.metamodel.FURCAS.TCS.RulePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;


public class TcsUtil {

    
    /**
     * TODO: Move to Syntax Lookup?
     */
    @Deprecated
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


    public static EClassifier getType(Property p) {
        ETypedElement e = getStructuralFeature(p);
        if (e != null) {
            return e.getEType();
        }

        return null;
    }

    public static String getMode(Property p) {
        ModePArg modeArg = PropertyArgumentUtil.getModePArg(p);
        if (modeArg != null) {
            return modeArg.getMode();
        }

        return null;
    }


    /**
     * Computes the fully qualified name of the given {@link EClassifier}.
     * 
     * @param type
     *            the type to compute its qualified name from.
     * @return the Qualified name of the given type as list of strings.
     */
    public static List<String> getQualifiedName(EClassifier type) {
        return EcoreHelper.getQualifiedName(type);
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
    
    /**
     * TODO: Move to Syntax Lookup?
     */
    @Deprecated
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
    
    public static boolean isFirstSequenceElement(SequenceElement se) {
        EObject container = se.eContainer();
        if (container instanceof Sequence) {
            return se.equals(TcsUtil.getFirstSequenceElement((Sequence) container));
        }
        return false;
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
     * @param e SequenceElement after which to look
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
    
    public static Object getPropertyValue(Object target, PropertyReference propRef) {
        return getPropertyValue(((EObject) target), propRef);
    }

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


    /**
     * TODO: Move to Syntax Lookup? Furhtermore, the pretty printer does seem to implement a very
     * similar method. 
     */
    @Deprecated
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
            if (subtemps.size() > 0) {
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

    public static boolean matchesContext(ContextTemplate ot, String tag) {
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
   
    // FIXME: The collection comparision looks really strange.
    public static boolean isPropValueAndOclResultEqual(Object propValue, Collection<?> oclResult) {
        // oclHelper.findElementWithOCLQuery returns null for empty collections
        if (propValue == null) {
            return oclResult == null;
        } else if (oclResult.size() == 1 && propValue.equals(oclResult.iterator().next())) {
            return true;
        } else if(propValue instanceof Collection) {
            Collection<?> propValueColl = (Collection<?>) propValue;
            Iterator<?> oclResultIterator = oclResult.iterator();
            for (Iterator<?> iterator = propValueColl.iterator(); iterator
                    .hasNext() && oclResultIterator.hasNext();) {
                Object object = iterator.next();
                Object oclObject = oclResultIterator.next();
                if(!object.equals(oclObject)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    
    private final static Pattern contextPattern = Pattern.compile("#context(\\((\\w*)(\\)))?");

    public static String getContextTag(String oclQuery) {
        // strip OCL query prefix
        if (oclQuery.startsWith(EMFModelAdapter.OCL_QUERY_PREFIX)) {
            oclQuery = oclQuery.substring(EMFModelAdapter.OCL_QUERY_PREFIX.length());
        }

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

    /**
     * FIXME: What does this what a SyntaxLookup can't do? Why do we need it?
     * If it does a little bit more, should't we enhance the syntax lookup? It will
     * give us a central place where we can do caching and other optimizations.
     */
    @Deprecated
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
                QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
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
        for (URI uri : mappingQueryScope.getResourceScope()) {
            resourcesInScope.add(uri);
        }
        return com.sap.furcas.runtime.common.util.EcoreHelper.getQueryContext(rs, resourcesInScope);
    }

    /**
     * Given a record of which choices were made, in numerical form, as returned, e.g., by
     * {@link TextBlock#getParentAltChoices()} including the leading -1, and given a base {@link ContextTemplate} from
     * where to start, traverses through all {@link SequenceElement}s that were used according to
     * <code>alternativeChoices</code> and looks for <code>searchFor</code>. Returns <code>true</code> if
     * <code>searchFor</code> must have been executed based on what <code>alternativeChoices</code> tells;
     * <code>false</code> otherwise.
     * <p>
     * 
     * In case an alternative is reached but <code>alternativeChoices</code> has no further elements, an
     * {@link IllegalArgumentException} is thrown.
     * 
     * @param base
     *            the template with whose sequence to start. The sequence's contained elements are traversed in
     *            depth-first order and at each choice, the first element of <code>alternativeChoices</code> is
     *            consumed, and the descent continues with the respective alternative.
     * 
     * @param alternativeChoices
     *            a list such as the one returned by {@link TextBlock#getParentAltChoices()} including the leading -1.
     *            Must be non-<code>null</code> but may be empty. In case of an empty list, <code>base</code> is
     *            returned immediately.
     * 
     * @param searchFor
     *            the sequence element to search for
     * 
     * @throws IllegalArgumentException
     *             in case <code>alternativeChoices</code> doesn't contain enough elements for the choices to be made
     *             during the descent
     */
    public static boolean wasExecuted(ContextTemplate base, List<Integer> alternativeChoices, SequenceElement searchFor) {
        Sequence sequence = base.getTemplateSequence();
        return sequence != null && wasExecuted(sequence, new LinkedList<Integer>(alternativeChoices), searchFor);
    }

    private static boolean wasExecuted(Sequence sequence, List<Integer> alternativeChoices, SequenceElement searchFor) {
        boolean result = false;
        for (SequenceElement element : sequence.getElements()) {
            if (element == searchFor) {
                result = true;
            } else {
                Sequence subSequence = getSubSequence(alternativeChoices, element);
                if (subSequence != null) {
                    result = wasExecuted(subSequence, alternativeChoices, searchFor);
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    private static Sequence getSubSequence(List<Integer> alternativeChoices, SequenceElement element) {
        removeHeadUpToNextPositiveInteger(alternativeChoices);
        Sequence subSequence;
        if (element instanceof Alternative) {
            subSequence = ((Alternative) element).getSequences().get(alternativeChoices.get(0));
            alternativeChoices.remove(0);
        } else if (element instanceof ConditionalElement) {
            switch (alternativeChoices.get(0)) {
            case 0:
                subSequence = ((ConditionalElement) element).getThenSequence();
                break;
            case 1:
                subSequence = ((ConditionalElement) element).getElseSequence();
                break;
            default:
                throw new IllegalArgumentException("Choice "+alternativeChoices.get(0)+
                        " not compatible with ConditionalElement. Expected 0 or 1.");
            }
            alternativeChoices.remove(0);
        } else if (element instanceof Block) {
            subSequence = ((Block) element).getBlockSequence();
        } else if (element instanceof FunctionCall) {
            subSequence = ((FunctionCall) element).getCalledFunction().getFunctionSequence();
        } else {
            subSequence = null;
        }
        return subSequence;
    }
    
    private static void removeHeadUpToNextPositiveInteger(List<Integer> alternativeChoicesWithLeadingMinusOneRemoved) {
        while (!alternativeChoicesWithLeadingMinusOneRemoved.isEmpty() && alternativeChoicesWithLeadingMinusOneRemoved.get(0) < 0) {
            alternativeChoicesWithLeadingMinusOneRemoved.remove(0);
        }
    }

    public static Template getParentTemplate(SequenceElement e, ConcreteSyntax syntax) {
        EObject parent = e.eContainer();
        while (parent != null && !(parent instanceof ConcreteSyntax)) {
            if (parent instanceof ClassTemplate || parent instanceof OperatorTemplate || parent instanceof FunctionTemplate) {
                return (Template) parent;
            } else {
                if (parent instanceof EObject) {
                    EObject r = parent;
                    parent = r.eContainer();
                } else {
                    parent = null;
                }
            }
        }
        return TcsUtil.getMainClassTemplate(syntax);
    }

    public static Alternative getParentAlternative(SequenceElement e) {
        EObject parent = e.eContainer();
        while (parent != null && !(parent instanceof ConcreteSyntax)) {
            if (parent instanceof Alternative) {
                return (Alternative) parent;
            } else {
                if (parent instanceof EObject) {
                    EObject r = parent;
                    parent = r.eContainer();
                } else {
                    parent = null;
                }
            }
        }
        return null;
    }
    
    public static Sequence getSequence(Template t) {
        if (t instanceof ClassTemplate) {
            ClassTemplate ct = (ClassTemplate) t;
            return ct.getTemplateSequence();
        }
        if (t instanceof OperatorTemplate) {
            OperatorTemplate ot = (OperatorTemplate) t;
            return ot.getTemplateSequence();
        }

        if (t instanceof FunctionTemplate) {
            FunctionTemplate ft = (FunctionTemplate) t;
            return ft.getFunctionSequence();
        }
        return null;
    }
    
    public static <T extends EObject> Collection<T> getElementsOfType(EObject syntaxOrTemplate, Class<T> typeToFilterFor) {
        Collection<T> result = new LinkedList<T>();
        for (Iterator<EObject> i=syntaxOrTemplate.eAllContents(); i.hasNext(); ) {
            EObject o = i.next();
            if (typeToFilterFor.isInstance(o)) {
                @SuppressWarnings("unchecked")
                T t = (T) o;
                result.add(t);
            }
        }
        return result;
    }

}
