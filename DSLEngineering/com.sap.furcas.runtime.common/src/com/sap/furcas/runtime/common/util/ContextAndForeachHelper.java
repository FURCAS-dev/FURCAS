package com.sap.furcas.runtime.common.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.TypeType;

import com.sap.emf.ocl.prepared.PreparedOCLExpression;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

/**
 * Knows the patterns for <code>#context</code> and <code>#foreach</code>. Furthermore, can create a {@link PreparedOCLExpression
 * parameterized query} from those that contain literals matching specific patterns (see {@link #stringLiteralQueryArgPattern} and
 * {@link #numberLiteralQueryArgPattern}).
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class ContextAndForeachHelper {
    public static final String contextPatternAsString = "#context(\\((\\w*)\\))?";

    public static final String foreachPatternAsString = "#foreach\\((\\w+(::\\w+)*)\\)";

    private static final String stringLiteralQueryArgPattern = "???";
    
    private static final int numberLiteralQueryArgPattern = 999;

    /**
     * The pattern to match #context(...) or #context
     */
    public static final Pattern contextPattern = Pattern.compile(contextPatternAsString);

    /**
     * The pattern to match #foreach
     */
    public static final Pattern foreachPattern = Pattern.compile(foreachPatternAsString);

    private static final String oclAsTypePatternSuffix = "\\b*\\.\\b*oclAsType\\(\\b*([^\\(]*)\\b*\\)";
    
    private static final String QUERY_PARAM_NAME = "\\?";


    /**
     * The {@link ContextManager#contextPatternAsString} pattern contains two groups where the second group is for the name of the
     * context tag. This group therefore contains three groups, the second being the context tag, the third being the name of the
     * type to which the context is cast.
     */
    private static final Pattern oclAsTypePattern = Pattern.compile(ContextAndForeachHelper.contextPatternAsString
            + oclAsTypePatternSuffix);

    /**
     * For a given context tag and a concrete syntax determines the meta-classes for which templates exist that use this tag for
     * declaring a context. The common generalization of all such classes will be returned. This may be <tt>Reflect::Element</tt>
     * if no other common generalization exists.
     * <p>
     * 
     * This implementation currently uses MQL to find the classes for which templates (class or operator) exist that declare a
     * context with the <tt>contextTag</tt> among the tags.
     * 
     * @param cs
     *            the concrete syntax in which to search for the use of the <tt>contextTag</tt>
     * @param contextTag
     *            may be <tt>null</tt> or an empty string which means the untagged context
     * @return the common generalization of all classes for which a template is defined as context using <tt>contextTag</tt> as
     *         the tag for the context declaration; <tt>null</tt> if no such template exists; <tt>Reflect::Element</tt> if no
     *         other common generalization exists
     */
    public static EClass getCommonBaseClassForContextTag(ConcreteSyntax cs, String contextTag) {
        QueryProcessor mql = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        ResourceSet rs = cs.eResource().getResourceSet();
        QueryContext context = EcoreHelper.getQueryContext(rs);
        URI uriEClassifier = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClassifier());
        URI uriContextTemplate = EcoreUtil.getURI(TCSPackage.eINSTANCE.getContextTemplate());
        URI uriContextTags = EcoreUtil.getURI(TCSPackage.eINSTANCE.getContextTags());
        ResultSet templatesClasses;
        if (contextTag == null || contextTag.length() == 0) {
            templatesClasses = mql.execute("select me from [" + uriEClassifier + "] as me," + "[" + uriContextTemplate + "] as ct," + "\""
                    + EcoreUtil.getID((cs)) + "\" as cs " + "where ct.concreteSyntax=cs " + "where ct.metaReference=me "
                    + "where ct.contextTags=null " + "where ct.isContext=true", context);
        } else {
            templatesClasses = mql.execute("select me from [" + uriEClassifier + "] as me," + "[" + uriContextTemplate + "] as ct,"
                    + "[" + uriContextTags + "] as tags," + "\"" + EcoreUtil.getID((cs)) + "\" as cs " + "where ct.concreteSyntax=cs "
                    + "where ct.metaReference=me " + "where ct.contextTags=tags " + "where ct.isContext=true "
                    + "where tags.tags='" + contextTag + "'", context);
        }
        Set<EClass> metaReferences = new HashSet<EClass>();
        for (URI uri : templatesClasses.getUris("me")) {
            metaReferences.add((EClass) rs.getEObject(uri, true));
        }
        boolean needReflectElement = false;
        EClass commonGeneralization = null;
        while (!needReflectElement && metaReferences.size() > 0) {
            EClass candidate = metaReferences.iterator().next();
            if (commonGeneralization == null) {
                commonGeneralization = candidate;
                metaReferences.remove(candidate); // first candidate
            } else if (candidate.getEAllSuperTypes().contains(commonGeneralization)) {
                metaReferences.remove(candidate); // commonGeneralization already covers candidate
            } else {
                List<EClass> allCommonGeneralizationSupertypes = commonGeneralization.getEAllSuperTypes();
                boolean foundCommonSupertype = false;
                for (EClass candidateSuperclass : candidate.getEAllSuperTypes()) {
                    if (allCommonGeneralizationSupertypes.contains(candidateSuperclass)) {
                        commonGeneralization = candidateSuperclass;
                        metaReferences.remove(candidate); // now commongeneralization also covers candidate
                        foundCommonSupertype = true;
                        break;
                    }
                }
                if (!foundCommonSupertype) {
                    needReflectElement = true;
                    break;
                }
            }
        }
        if (needReflectElement) {
            commonGeneralization = org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.getAnyType();
        }
        return commonGeneralization;
    }

    /**
     * Based on the use of <code>self</code>, <code>#context</code> and <code>#foreach</code> and the template in whose context the
     * expression occurs, determines the context type to be used for parsing the expression.
     */
    public static EClassifier getParsingContext(String oclExpression, Template template) throws ParserException {
        EClassifier parsingContext = null;
        if (!usesContext(oclExpression)) {
            if (usesForeach(oclExpression)) {
                parsingContext = getForeachMetaObject(oclExpression);
                if (parsingContext == null) {
                    throw new RuntimeException(
                            "Expected to find type of #foreach variable after #foreach in parentheses but didn't: "+
                            oclExpression);
                }
            } else {
                parsingContext = template.getMetaReference();
            }
        } else if (usesContextWithSubsequentCast(oclExpression)) {
            parsingContext = getContextMetaObject(oclExpression);
            if (parsingContext == null) {
                throw new RuntimeException("Didn't find type used in context casts in expression " + oclExpression);
            }
        } else {
            parsingContext = getCommonBaseClassForContextTag(template.getConcreteSyntax(),
                    getContextTag(oclExpression));
            if (parsingContext == null) {
                throw new RuntimeException("Expected to find use of context " + getContextTag(oclExpression) + " but didn't");
            }
        }
        return parsingContext;
    }

    public static String getContextTag(String oclExpression) {
        Matcher matcher = contextPattern.matcher(oclExpression);
        matcher.find();
        String result = null;
        if (matcher.groupCount() >= 2) {
            result = matcher.group(2);
        }
        return result;

    }

    /**
     * Checks if the <tt>oclExpression</tt> contains a combination of the sort <tt>#context(...).oclAsType(...)</tt>. This can be
     * used to determine the type of the "self" variable which will then be the evaluation context for the expression
     */
    public static boolean usesContextWithSubsequentCast(String oclExpression) {
        Matcher matcher = oclAsTypePattern.matcher(oclExpression);
        return matcher.find();
    }

    /**
     * If the {@link #oclAsTypePattern} matches, this method determines the type to which the context is being cast. If the
     * pattern does not match or the type is not found, <tt>null</tt> is returned.
     * 
     * @throws ParserException
     *             in case the type name can't be parsed by the OCL evaluator
     */
    public static EClassifier getContextMetaObject(String oclExpression) throws ParserException {
        EClassifier result = null;
        Matcher matcher = oclAsTypePattern.matcher(oclExpression);
        if (matcher.find()) {
            if (matcher.groupCount() >= 3) {
                String oclTypeName = matcher.group(3);
                OCL ocl = com.sap.emf.ocl.util.OCL.newInstance();
                TypeExp typeQuery = (TypeExp) ocl.createOCLHelper().createQuery(oclTypeName);
                result = ((TypeType) typeQuery.getType()).getReferredType();
            }
        }
        return result;
    }

    /**
     * If the {@link #foreachWithOclAsTypePattern} matches, this method determines the type to which the context is being cast. If
     * the pattern does not match or the type is not found, <tt>null</tt> is returned.
     * 
     * @throws ParserException
     *             in case the type name can't be parsed by the OCL evaluator
     */
    private static EClassifier getForeachMetaObject(String oclExpression) throws ParserException {
        EClassifier result = null;
        Matcher matcher = foreachPattern.matcher(oclExpression);
        if (matcher.find()) {
            if (matcher.groupCount() >= 1) {
                String oclTypeName = matcher.group(1);
                OCL ocl = com.sap.emf.ocl.util.OCL.newInstance(); // TODO should use an injected OppositeEndFinder
                Helper helper = ocl.createOCLHelper();
                helper.setContext(EcorePackage.eINSTANCE.getEClassifier()); // EClassifier is a classifier that's always in scope
                TypeExp typeQuery = (TypeExp) helper.createQuery(oclTypeName);
                result = ((TypeType) typeQuery.getType()).getReferredType();
            }
        }
        return result;
    }

    public static boolean usesContext(String queryToExecute) {
        Matcher matcher = contextPattern.matcher(queryToExecute);
        return matcher.find();
    }

    public static boolean usesForeach(String queryToExecute) {
        Matcher matcher = foreachPattern.matcher(queryToExecute);
        return matcher.find();
    }

    /**
     * Removes an optional leading "OCL:" prefix. Then performs all replacements of {@link #prepareOclQuery(String)} and
     * replaces a "?" (see {@link #QUERY_PARAM_NAME}) by the {@link Object#toString()} representation of
     * <code>keyValue</code>. The OCL expression string treated this way is returned.
     */
    public static String prepareOclQuery(String queryToExecute, Object keyValue) {
        String result = queryToExecute;
        if (queryToExecute != null) {
            if (result.startsWith("OCL:")) {
                result = result.replaceFirst("OCL:", "");
            }
            result = ContextAndForeachHelper.prepareOclQuery(queryToExecute);

            if (keyValue != null) {
                result = result.replaceAll(QUERY_PARAM_NAME, "'" + keyValue.toString() + "'");
            }
        }
        return result;
    }
    
    private static final String OCL_PREFIX = "OCL:";
    /**
     * Replaces occurrences of <code>#context</code> (see {@link #contextPattern}) and <code>#foreach</code>
     * (see {@link #foreachPattern}) by <code>self</code> (see {@link Environment#SELF_VARIABLE_NAME}).
     */
    public static String prepareOclQuery(String queryToExecute) {
        String result = queryToExecute;
        if (queryToExecute != null) {
            if (queryToExecute.startsWith(OCL_PREFIX)) {
                result = result.substring(OCL_PREFIX.length());
            }
            if (usesContext(result)) {
                if (result.indexOf(Environment.SELF_VARIABLE_NAME) > -1) {
                    throw new RuntimeException("OCL Query cannot contain #context and self at the same time.");
                } else if (ContextAndForeachHelper.usesForeach(result)) {
                    throw new RuntimeException("OCL query cannot contain #foreach and #context at the same time");
                } else {
                    result = result.replaceAll(contextPattern.pattern(), Environment.SELF_VARIABLE_NAME);
                }
            } else if (ContextAndForeachHelper.usesForeach(result)) {
                if (result.indexOf(Environment.SELF_VARIABLE_NAME) > -1) {
                    throw new RuntimeException("OCL Query cannot contain #foreach and self at the same time.");
                } else if (ContextAndForeachHelper.usesContext(result)) {
                    throw new RuntimeException("OCL query cannot contain #foreach and #context at the same time");
                } else {
                    result = result.replaceAll(ContextAndForeachHelper.foreachPattern.pattern(), Environment.SELF_VARIABLE_NAME);
                }
            }
        }
        return result;
    }
    
    public static PreparedOCLExpression prepareWithStringParameter(OCLExpression e) {
        return new PreparedOCLExpression(e, stringLiteralQueryArgPattern);
    }

    public static PreparedOCLExpression prepareWithNumericParameter(OCLExpression e) {
        return new PreparedOCLExpression(e, numberLiteralQueryArgPattern);
    }
}
