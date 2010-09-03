package com.sap.mi.textual.common.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Template;

public class ContextAndForeachHelper {
    public static final String contextPatternAsString = "#context(\\((\\w*)\\))?";

    public static final String foreachPatternAsString = "#foreach\\((\\w+(::\\w+)*)\\)";

    /**
     * The pattern to match #context(...) or #context
     */
    public static final Pattern contextPattern = Pattern.compile(contextPatternAsString);

    /**
     * The pattern to match #foreach
     */
    public static final Pattern foreachPattern = Pattern.compile(foreachPatternAsString);

    private static final String oclAsTypePatternSuffix = "\\b*\\.\\b*oclAsType\\(\\b*([^\\(]*)\\b*\\)";

    /**
     * The {@link ContextManager#contextPatternAsString} pattern contains two groups where the second group is for the
     * name of the context tag. This group therefore contains three groups, the second being the context tag, the third
     * being the name of the type to which the context is cast.
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
     * @param elementClass
     *            the <tt>Reflect::Element</tt> class to use as common generalization if no other common generalization can be
     *            found
     * @return the common generalization of all classes for which a template is defined as context using <tt>contextTag</tt> as
     *         the tag for the context declaration; <tt>null</tt> if no such template exists; <tt>Reflect::Element</tt> if no
     *         other common generalization exists
     */
    public static EObject getCommonBaseClassForContextTag(ConcreteSyntax cs, String contextTag, EClass elementClass) {
        QueryProcessor mql = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        ResourceSet rs = elementClass.eResource().getResourceSet();
		QueryContext context = EcoreHelper.getQueryContext(rs);
        ResultSet templatesClasses;
        if (contextTag==null || contextTag.length()==0) {
            templatesClasses = mql.execute("select me from Model::Classifier as me,"+
        	    	"TCS::ContextTemplate as ct,"+
        	    	"\"" + EcoreUtil.getID(((EObject) cs)) + "\" as cs "+
        	    	"where ct.concreteSyntax=cs "+
        	    	"where ct.metaReference=me "+
        	    	"where ct.contextTags=null "+
        		"where ct.isContext=true", context);
        } else {
            templatesClasses = mql.execute("select me from Model::Classifier as me,"+
        		"TCS::ContextTemplate as ct,"+
        		"TCS::ContextTags as tags,"+
        		"\"" + EcoreUtil.getID(((EObject) cs)) + "\" as cs "+
        		"where ct.concreteSyntax=cs "+
        		"where ct.metaReference=me "+
        		"where ct.contextTags=tags "+
        		"where ct.isContext=true "+
        		"where tags.tags='"+contextTag+"'", context);
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
        		commonGeneralization = (EClass) candidateSuperclass;
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
            commonGeneralization = elementClass;
        }
        return commonGeneralization;
    }

    public static EObject getParsingContext(ResourceSet connection, String oclExpression, Template template,
            Collection<EPackage> packagesForLookup, EClass elementClass) {
        EObject parsingContext = null;
        if (!usesContext(oclExpression)) {
            if (usesForeach(oclExpression)) {
        	parsingContext = getForeachMetaObject(connection, packagesForLookup, oclExpression);
        	if (parsingContext == null) {
        	    throw new RuntimeException("Expected to find use of template with #foreach is a property init's expression but didn't");
        	}
            } else {
        	parsingContext = template.getMetaReference();
            }
        } else if (usesContextWithSubsequentCast(oclExpression)) {
            parsingContext = getContextMetaObject(connection,
                packagesForLookup, oclExpression);
            if (parsingContext == null) {
                throw new RuntimeException(
                    "Didn't find type used in context casts in expression "
                        + oclExpression);
            }
        } else {
            parsingContext = getCommonBaseClassForContextTag(template.getConcreteSyntax(), getContextTag(oclExpression),
                elementClass);
            if (parsingContext == null) {
                throw new RuntimeException("Expected to find use of context "
                    + getContextTag(oclExpression) + " but didn't");
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
     * Checks if the <tt>oclExpression</tt> contains a combination of the sort
     * <tt>#context(...).oclAsType(...)</tt>. This can be used to determine the type of
     * the "self" variable which will then be the evaluation context for the expression
     */
    public static boolean usesContextWithSubsequentCast(String oclExpression) {
    	Matcher matcher = oclAsTypePattern.matcher(oclExpression);
    	return matcher.find();
    }

    /**
     * If the {@link #oclAsTypePattern} matches, this method determines the type to
     * which the context is being cast. If the pattern does not match or the
     * type is not found, <tt>null</tt> is returned.
     */
    public static EObject getContextMetaObject(ResourceSet connection, Collection<EPackage> packagesForLookup, String oclExpression) {
        EObject result = null;
        Matcher matcher = oclAsTypePattern.matcher(oclExpression);
        if (matcher.find()) {
    	if (matcher.groupCount() >= 3) {
    	    String oclTypeName = matcher.group(3);
    	    List<String> path = OclHelper.getPath(oclTypeName);
    	    result = OclHelper.lookupModelElementByPathName(connection, path, packagesForLookup);
    	}
        }
        return result;
    }

    /**
     * If the {@link #foreachWithOclAsTypePattern} matches, this method determines the type to
     * which the context is being cast. If the pattern does not match or the
     * type is not found, <tt>null</tt> is returned.
     */
    public static EObject getForeachMetaObject(ResourceSet resourceSet, Collection<EPackage> packagesForLookup, String oclExpression) {
        EObject result = null;
        Matcher matcher = foreachPattern.matcher(oclExpression);
        if (matcher.find()) {
    	if (matcher.groupCount() >= 1) {
    	    String oclTypeName = matcher.group(1);
    	    List<String> path = OclHelper.getPath(oclTypeName);
    	    
    	    result = OclHelper.lookupModelElementByPathName(resourceSet, path, packagesForLookup);
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
	    

}
