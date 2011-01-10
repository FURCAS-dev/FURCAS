/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;

/**
 * inserts calls into Parser that call methods on the parser which allow observation of the parsing process.
 */
public class ObservationDirectivesHelper {


    public static final int ALL = 2;
    public static final int TEXT_BLOCK_ONLY = 1;
    public static final int NONE = 1;
	private static final int ALL_WITH_MOFIDS = 3;

    // since debugging the grammar may be either without the observation directives, this flag may be changed for debugging.
    public static int doAddObserverParts = ALL_WITH_MOFIDS;


    public static void appendExitAlternativeNotification(RuleBodyStringBuffer buffer) {
        if (doAddObserverParts >= ALL) {
            buffer.append("{_exitAlt();} ");
        }
    }

    /**
     * @param buffer
     * @param alternative
     */
    public static void appendEnterAlternativeNotification(
            RuleBodyStringBuffer buffer, int alternative) {
        if (doAddObserverParts >= ALL) {
            buffer.append("{_enterAlt(", alternative, ");} ");
        }
    }

//  /**
//  * @param buffer
//  */
//  public static void appendNextSequenceElementNotification(
//  RuleBodyStringBuffer buffer) {
//  if (doAddObserverParts >= ALL) {
//  buffer.append("{_nextSeqEl();}");
//  }
//  }

    /**
     * @param initString
     */
    public static void appendEnterTemplateNotification(StringBuilder buffer, ClassTemplate template) {
        if (doAddObserverParts >= TEXT_BLOCK_ONLY) {
            buffer.append("onEnterTemplateRule(metaType");
            String mode = template.getMode();
            if (mode != null && ! mode.trim().equals("")) {
                buffer.append(",\"").append(mode).append('"');
            }
            buffer.append(");\n");
        }
    }

    public static String getEnterTemplateNotification() {
        if (doAddObserverParts >= TEXT_BLOCK_ONLY) {
            return "onEnterTemplateRule(metaType);\n";
        } else {
            return "";
        }
    }

    /**
     * @param ruleBodyStringBuffer
     */
    public static String getEnterSequenceElementNotification(SequenceElement se) {
        if (doAddObserverParts >= ALL) {
        	if(doAddObserverParts >= ALL_WITH_MOFIDS && se != null) {
        		 return "{_beforeSeqEl(\"" + getId(se) + "\");}";
        	} else {
        		return "{_beforeSeqEl();}";
        	}
        } else {
            return "";
        }
    }

    /**
     * FIXME: This is a workaround for Bug #88 (https://bugzilla.furcas.org/cgi-bin/bugzilla3/show_bug.cgi?id=88).
     * This will replace any URIs containing "platform:/resource/" with "platform:/plugin/" so that during runtime of the
     * parser the correct element is found.
     * 
     * Get the ID of the {@link EObject} <code>se</code> as String.
     *  
     * @param eObject The element to get the ID from.
     * @return the ID of <code>se</code>. 
     */
    private static String getId(EObject se) {
        String uri = EcoreUtil.getURI(se).toString();
        if(uri.startsWith("platform:/resource/")) {
            uri = uri.replace("platform:/resource/", "platform:/plugin/");
        }
        return uri;
    }

    /**
     * @param ruleBodyStringBuffer
     */
    public static String getExitSequenceElementNotification() {
        if (doAddObserverParts >= ALL) {
            return "{_afterSeqEl();}";
        } else {
            return "";
        }
    }

    /**
     * @return
     */
    public static String getExitTemplateNotification() {
        if (doAddObserverParts >= TEXT_BLOCK_ONLY) {
            return "onExitTemplateRule(metaType);";
        } else {
            return "";
        }
    }

    /**
     * @return
     */
    public static Object getEnterSeparatorSequenceNotification() {
        if (doAddObserverParts >= ALL) {
            return "{_enterSepSeq();}";    
        } else {
            return "";
        }
    }

    /**
     * @return
     */
    public static Object getExitSeparatorSequenceNotification() {
        if (doAddObserverParts >= ALL) {
            return "{_exitSepSeq();}";
        } else {
            return "";
        }
    }

    /**
     * @return
     */
    public static Object getEnterOperatoredBracketsSequenceNotification() {
        if (doAddObserverParts >= ALL) {
            return "{_enterOpdBrackSeq();}";
        } else {
            return "";
        }
    }

    /**
     * @return
     */
    public static Object getExitOperatoredBracketsSequenceNotification() {
        if (doAddObserverParts >= ALL) {
            return "{_exitOpdBrackSeq();}";
        } else {
            return "";
        }
    }
    

    /**
     * @param operator 
     * @param arity 1 or 2
     * @param unaryPostfix  only for unary operators 
     * @return
     */
    public static Object getEnterOperatorSequenceNotification(String operator, int arity, boolean unaryPostfix) {
        if (doAddObserverParts >= ALL) {
            String result = "{_enterOpSeq(\"" + operator + "\", "+ arity + ", " + unaryPostfix+");}";
            return result;
        } else {
            return "";
        }
    }
    
    /**
     * @return
     */
    public static Object getExitOperatorSequenceNotification() {
        if (doAddObserverParts >= ALL) {
            return "{_exitOpSeq();}";
        } else {
            return "";
        }
    }

    public static Object getEnterInjectorActionNotification() {
	 if (doAddObserverParts >= ALL) {
	    return "_enterInjectorAction();";
	} else {
	    return "";
	}
    }

    public static Object getExitInjectorActionNotification() {
	 if (doAddObserverParts >= ALL) {
	    return "_exitInjectorAction();";
	} else {
	    return "";
	}
   }


}
