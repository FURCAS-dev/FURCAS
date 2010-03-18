package com.sap.mi.textual.common.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tcs.ConcreteSyntax;
import tcs.Template;

import com.sap.tc.moin.ocl.utils.jmi.OclHelper;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

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
    public static RefObject getCommonBaseClassForContextTag(ConcreteSyntax cs, String contextTag, Classifier elementClass) {
        MQLProcessor mql = cs.get___Connection().getMQLProcessor();
        MQLResultSet templatesClasses;
        if (contextTag==null || contextTag.length()==0) {
            templatesClasses = mql.execute("select me from Model::Classifier as me,"+
        	    	"TCS::ContextTemplate as ct,"+
        	    	"\"" + ((Partitionable) cs).get___Mri() + "\" as cs "+
        	    	"where ct.concreteSyntax=cs "+
        	    	"where ct.metaReference=me "+
        	    	"where ct.contextTags=null "+
        		"where ct.isContext=true");
        } else {
            templatesClasses = mql.execute("select me from Model::Classifier as me,"+
        		"TCS::ContextTemplate as ct,"+
        		"TCS::ContextTags as tags,"+
        		"\"" + ((Partitionable) cs).get___Mri() + "\" as cs "+
        		"where ct.concreteSyntax=cs "+
        		"where ct.metaReference=me "+
        		"where ct.contextTags=tags "+
        		"where ct.isContext=true "+
        		"where tags.tags='"+contextTag+"'");
        }
        Set<Classifier> metaReferences = new HashSet<Classifier>();
        for (RefObject ro : templatesClasses.getRefObjects("me")) {
            metaReferences.add((Classifier) ro);
        }
        boolean needReflectElement = false;
        Classifier commonGeneralization = null;
        while (!needReflectElement && metaReferences.size() > 0) {
            Classifier candidate = metaReferences.iterator().next();
            if (commonGeneralization == null) {
        	commonGeneralization = candidate;
        	metaReferences.remove(candidate); // first candidate
            } else if (candidate.allSupertypes().contains(commonGeneralization)) {
        	metaReferences.remove(candidate); // commonGeneralization already covers candidate
            } else {
        	List<GeneralizableElement> allCommonGeneralizationSupertypes = commonGeneralization.allSupertypes();
        	boolean foundCommonSupertype = false;
        	for (GeneralizableElement candidateSuperclass : candidate.allSupertypes()) {
        	    if (allCommonGeneralizationSupertypes.contains(candidateSuperclass)) {
        		commonGeneralization = (Classifier) candidateSuperclass;
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

    public static RefObject getParsingContext(Connection connection, String oclExpression, Template template,
            Collection<RefPackage> packagesForLookup, MofClass elementClass) {
        RefObject parsingContext = null;
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
            parsingContext = getCommonBaseClassForContextTag(template.getConcretesyntax(), getContextTag(oclExpression),
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
    public static RefObject getContextMetaObject(Connection connection, Collection<RefPackage> packagesForLookup, String oclExpression) {
        RefObject result = null;
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
    public static RefObject getForeachMetaObject(Connection connection, Collection<RefPackage> packagesForLookup, String oclExpression) {
        RefObject result = null;
        Matcher matcher = foreachPattern.matcher(oclExpression);
        if (matcher.find()) {
    	if (matcher.groupCount() >= 1) {
    	    String oclTypeName = matcher.group(1);
    	    List<String> path = OclHelper.getPath(oclTypeName);
    	    result = OclHelper.lookupModelElementByPathName(connection, path, packagesForLookup);
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
