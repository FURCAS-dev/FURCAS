/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.tcs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PostfixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrefixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;

/**
 * Helper utils for the various subclasses of {@link PropertyArgument}.
 * The subclasses are often called "PArgs". 
 *  
 * @author Stephan Erb
 *
 */
public class PropertyArgumentUtil {
    
    /**
     * The pattern to select a 'self' within an OCL entry.
     */
    private static final String selfPatternAsString = "((\\W|\\A))(self)(\\W)";
    private static final Pattern selfPattern = Pattern.compile(selfPatternAsString);
    private static final String OCL_PREFIX = "OCL:";
    

    /**
     * Returns the first {@link RefersToPArg} of Property p. There should only be one.
     * No error is thrown, if more than one exist.
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
     * Returns the first {@link LookupScopePArg} of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static LookupScopePArg getLookupScopePArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof LookupScopePArg) {
                return (LookupScopePArg) arg;
            }
        }
        return null;
    }

    /**
     * Returns the first {@link ReferenceByPArg} of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static ReferenceByPArg getReferenceByPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ReferenceByPArg) {
                return (ReferenceByPArg) arg;
            }
        }
        return null;
    }
    
    /**
     * Returns an OCL query that can be evaluated on types corresponding to the {@link Property} p, which the given
     * {@link ReferencebyPArg} belongs to. The OCL query returns an identifier suitable to be compared
     * to the token value that is used to textually reference p.
     */
    public static String getReferenceByAsOCL(ReferenceByPArg referenceByPArg) {
        String referenceBy = referenceByPArg.getReferenceBy();
        if (referenceBy.startsWith(OCL_PREFIX)) {
            return referenceBy.substring(OCL_PREFIX.length());
        } else {
            // referenceBy contains a simple property name 
            return referenceBy;
        }
    }
        
    /**
     * Returns a combined query of the {@link ReferenceByPArg} and {@link LookupScopePArg}. 
     * The query contains a "?" and can be parameterized to directly find the referenced element. 
     */
    public static String getCombinedReferenceByLookupOCLQuery(ReferenceByPArg referenceByPArg, LookupScopePArg lookupScopePArg, PrefixPArg prefixPArg, PostfixPArg postfixPArg) {
        String tokenPlaceholder = getTokenPlaceHolder(prefixPArg, postfixPArg);
        String referenceByQuery = getReferenceByAsOCL(referenceByPArg);
        Matcher matcher = selfPattern.matcher(referenceByQuery);
        if (matcher.find()) {
            String preSelf = matcher.group(1);
            String replacementForSelf = "candidate";
            // find unique temporary variable
            while (referenceByQuery.contains(replacementForSelf)) {
                replacementForSelf = "_" + replacementForSelf;
            }
            String postSelf = matcher.group(4);
            referenceByQuery = matcher.replaceAll(preSelf + replacementForSelf + postSelf);
            return lookupScopePArg.getQuery() + "->select(" + replacementForSelf + " | " + referenceByQuery + " = " + tokenPlaceholder + ")";
        } else {
            return lookupScopePArg.getQuery() + "->select(" + referenceByQuery + " = " + tokenPlaceholder + ")";
        }
    }
    
    /**
     * Builds the OCL expression "prefix.concat(?).concat(postfix)"
     */
    private static String getTokenPlaceHolder(PrefixPArg prefixPArg, PostfixPArg postfixPArg) {
        StringBuilder buf = new StringBuilder();
        if (prefixPArg == null) {
            buf.append("?");
        } else {
            buf.append("'").append(prefixPArg.getPrefix()).append("'.concat(?)");
        }
        if (postfixPArg != null) {
            buf.append(".concat('").append(postfixPArg.getPostfix()).append("')");
        }
        return buf.toString();
    }

    
    /**
     * Returns the first PrefixPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static PrefixPArg getPrefixPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof PrefixPArg) {
                return (PrefixPArg) arg;
            }
        }
        return null;
    }
    
    /**
     * Returns the first PostfixPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static PostfixPArg getPostfixPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof PostfixPArg) {
                return (PostfixPArg) arg;
            }
        }
        return null;
    }
    
    public static String stripPrefixPostfix(String string, PrefixPArg prefixPArg, PostfixPArg postfixPArg) {
        int prefixLength = prefixPArg == null ? 0 : prefixPArg.getPrefix().length();
        int postfixLength = postfixPArg == null ? 0 : postfixPArg.getPostfix().length();
        return string.substring(prefixLength, string.length() - postfixLength);
    }

    /**
     * Returns the first AsPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
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
     * Returns the first PartialPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static PartialPArg getPartialPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof PartialPArg) {
                return (PartialPArg) arg;
            }
        }
        return null;
    }

    /**
     * Returns the first ForcedUpperPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static ForcedUpperPArg getForcedUpperPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ForcedUpperPArg) {
                return (ForcedUpperPArg) arg;
            }
        }
        return null;
    }

    /**
     * Returns the first ForcedLowerPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static ForcedLowerPArg getForcedLowerPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ForcedLowerPArg) {
                return (ForcedLowerPArg) arg;
            }
        }
        return null;
    }

    /**
     * Returns the first ModePArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static ModePArg getModePArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof ModePArg) {
                return (ModePArg) arg;
            }
        }
        return null;
    }

    /**
     * Returns the first SeparatorPArg of Property p. There should only be one.
     * No error is thrown, if more than one exist.
     */
    public static SeparatorPArg getSeparatorPArg(Property p) {
        for (PropertyArg arg : p.getPropertyArgs()) {
            if (arg instanceof SeparatorPArg) {
                return (SeparatorPArg) arg;
            }
        }
        return null;
    }

    public static boolean containsAsArg(Property p) {
        return getAsPArg(p) != null;
    }

    public static boolean containsSeparatorArg(Property p) {
        return getSeparatorPArg(p) != null;
    }

    public static boolean containsRefersToArg(Property p) {
        return getRefersToPArg(p) != null;
    }
    
    public static boolean containsLookupScopePArg(Property p) {
        return PropertyArgumentUtil.getLookupScopePArg(p) != null;
    }

}
