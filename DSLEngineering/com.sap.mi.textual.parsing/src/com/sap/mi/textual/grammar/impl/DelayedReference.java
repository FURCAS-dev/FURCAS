/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-04-14 09:00:22 +0200 (Mi, 14 Apr 2010) $
 * Revision: $Revision: 9646 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl;

import java.util.List;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * a delayed reference is a temporary object created during parsing. It
 * represents a reference, that cannot instantly be resolved because the object
 * referenced may not exist before the end of parsing. The DelayedReference
 * stores all information necessary to resolve an object and set the reference
 * on a source object.
 */
public class DelayedReference implements Cloneable {

    public ANTLR3LocationToken getFirstToken() {
		return firstToken;
	}

	/** The Constant AUTOCREATE_ALWAYS. */
    public static final String AUTOCREATE_ALWAYS = "always";

    /** The Constant AUTOCREATE_NEVER. */
    public static final String AUTOCREATE_NEVER = "never";

    /** The Constant AUTOCREATE_MISSING. */
    public static final String AUTOCREATE_MISSING = "ifmissing";

    /** Constant for reference type default */
    public static final int TYPE_DEFAULT = 0;
    
    /** Constant for reference type semantic predicate */
    public static final int TYPE_SEMANTIC_PREDICATE = 1;

    public static final int CONTEXT_LOOKUP = 2;
    
    public static final int SEMANTIC_DISAMBIGUATE = 3;
    
    /** The current context. */
    private Object referenceContextObject;
    
    /**
     * If the reference occurs in a template that is invoked by a "foreach" predicate in
     * another template, this attribute is set to the value of the foreach's OCL expression
     * that was current when this reference was created.
     */
    private Object currentForeachElement;

    /** The object. */
    private Object modelElement;

    /** The property name. */
    private String propertyName;

    /** The value type name. */
    private List<String> valueTypeName;

    /** The key name. */
    private String keyName;

    /** The key value. */
    private Object keyValue;

    /** The look in. */
    private String lookIn;

    /** The auto create. */
    private String autoCreate;

    /** The create as. */
    private List<String> createAs;

    /** The import context. */
    private boolean importContext;

    /** The create in. */
    private String createIn;

    /** The token. */
    private ANTLR3LocationToken token;

    /** The real value. */
    private Object realValue = null;

    /** The InjectorAction. */
    private Object queryElement;

    private String oclQuery;

    private String filter;

    private boolean isOptional;

    private String mode;

    private IRuleName ruleNameFinder;
    
    private ANTLR3LocationToken firstToken;

    /**
     * indicates the type of this reference expected to be one of the type
     * constants defined in this class
     */
    private int type;

    private List<PredicateSemantic> predicateActionList;
    private boolean isGenericReference = false;

    private boolean hasContext;

    private Object textBlock;

    private Connection connection;

	private List<SemanticDisambRuleData> semRulData;
	
	private Object semanticObject;

	private Object opTemplateLefthand;

    /**
     * Used by
     * {@link ObservableInjectingParser#setRef(Object, String, List, String, Object, String, String, List, boolean, String)}
     * 
     * @param currentContextElement
     *            Node in the context tree created during parsing (elements are
     *            added to such nodes)
     * @param currentForeachElement TODO
     * @param object
     *            Object for which to set a reference
     * @param propertyName
     *            Property referring to something
     * @param valueTypeName
     *            Type of referenced object
     * @param keyName
     *            id property of referenced object
     * @param keyValue
     *            id of referenced object
     * @param lookIn
     *            ("#all" for everywhere, null for context, some context path
     *            else.) TODO: Investigate path notation
     * @param autoCreate
     *            ("always" | "never" | "ifmissing" )
     * @param createAs
     *            Override for valueTypeName (to use SubType?)
     * @param importContext
     *            declares context of referred object to become part of
     *            referring object context (see java imports)
     * @param createIn
     *            Where to create the reference if it could not be resolved
     * @param isOptional
     *            If isOptional the non-resolved reference won't result in an
     *            error.
     * @param token
     *            used to determine location, which is used for error messages
     */
    DelayedReference(IModelElementProxy currentContextElement, Object currentForeachElement,
            Object object, String propertyName, List<String> valueTypeName,
            String keyName, Object keyValue, String lookIn,
            String autoCreate, List<String> createAs, boolean importContext,
            String createIn, boolean isOptional, ANTLR3LocationToken token) {
        this.referenceContextObject = currentContextElement;
        this.currentForeachElement = currentForeachElement;
        this.modelElement = object;
        this.propertyName = propertyName;
        this.valueTypeName = valueTypeName;
        this.keyName = keyName;
        this.keyValue = keyValue;
        this.lookIn = lookIn;
        this.autoCreate = autoCreate;
        this.createAs = createAs;
        this.importContext = importContext;
        this.createIn = createIn;
        this.isOptional = isOptional;
        this.token = token;
        this.type = -1;
    }

    /**
     * Used by
     * {@link ObservableInjectingParser#setOclRef(Object, String, String, Object, String)}
     * 
     * @param currentContext
     *            the model element (proxy) that is the innermost context to be
     *            used for default lookups, such as <tt>refersTo = name</tt>
     *            without any further specifications or queries.
     * @param currentForeachElement TODO
     * @param object
     *            the element on which the property identified by
     *            <tt>propertyName</tt> is to be set
     * @param propertyName
     *            identifies the property to be set on <tt>object</tt>
     * @param keyName
     *            feature name given with <tt>refersTo</tt>, e.g., "name" in
     *            case <tt>refersTo=name</tt> was used.
     * @param keyValue
     *            the parameter to be used for the lookup; typically the text
     *            parsed as the referencing identifier; for the OCL query, this
     *            will be substituted for a <tt>?</tt> occurring in the OCL
     *            expression; for a simple <tt>refersTo=someFeature</tt> this
     *            value will be compared to the value of <tt>someFeature</tt>.
     * @param oclQuery
     *            If provided, a string currently prefixed with "OCL:" whose
     *            suffix is parsed using the OCL parser of MOIN. It can use "?"
     *            anywhere, also multiple times, in the query which will then be
     *            substituted by <tt>keyValue</tt>; if <tt>#context</tt> or
     *            <tt>#context(name)</tt> is used in the query, it will be
     *            substituted by the respective context element.
     * @param isOptional
     *            If a reference is defined as being optional, if it is optional
     *            a not resolving of the reference won't result in an error.
     * @param token
     *            partly redundant to <tt>keyValue</tt>, kept because in some
     *            specific cases an unescaping from the token is necessary to
     *            obtain the <tt>keyValue</tt>.
     */
    public DelayedReference(IModelElementProxy currentContext, Object currentForeachElement,
            Object object, String propertyName, String keyName,
            Object keyValue, String oclQuery, boolean isOptional, ANTLR3LocationToken token) {
        this.referenceContextObject = currentContext;
        this.currentForeachElement = currentForeachElement;
        this.modelElement = object;
        this.propertyName = propertyName;
        this.keyName = keyName;
        this.keyValue = keyValue;
        this.oclQuery = oclQuery;
        this.token = token;
        this.isOptional = isOptional;
        this.type = -1;
    }

    /**
     * Used by
     * {@link ObservableInjectingParser#setModeRef(Object, String, String, String)}
     */

    public DelayedReference(Object referenceContextObject, Object currentForeachElement,
            int type, Object modelElement, String propertyName,
            String oclQuery, String mode,
            List<PredicateSemantic> list, IRuleName ruleNameFinder,
            ANTLR3LocationToken token, boolean hasContext, boolean isOptional) {
        super();
        this.referenceContextObject = referenceContextObject;
        this.modelElement = modelElement;
        this.propertyName = propertyName;
        this.oclQuery = oclQuery;
        this.mode = mode;
        this.token = token;
        this.type = type;
        this.predicateActionList = list;
        this.ruleNameFinder = ruleNameFinder;
        this.hasContext = hasContext;
        this.isOptional = isOptional;
    }

    public DelayedReference(Object currentContextElement,
			int type, Object modelElement, Object semanticObject,
			Object opTemplateLefthand, String opName, List<SemanticDisambRuleData> ruleData, ANTLR3LocationToken lastToken, ANTLR3LocationToken firstToken,
			boolean hasContext2, boolean isOptional) {
		super();
		this.referenceContextObject = currentContextElement;
		this.modelElement = modelElement;
		this.type = type;
		this.firstToken = firstToken;
		this.propertyName = null;
		this.token = lastToken;
		this.isOptional = isOptional;
		this.hasContext = hasContext2;
		this.semRulData = ruleData;
		this.semanticObject = semanticObject;
		this.propertyName =opName;
		this.opTemplateLefthand = opTemplateLefthand;
	}

	/**
     * Gets the current context.
     * 
     * @return the current context
     */
    public Object getContextElement() {
        return referenceContextObject;
    }
    
    public Object getCurrentForeachElement() {
	return currentForeachElement;
    }

    /**
     * Gets the model element of from which to set a reference to another
     * element.
     * 
     * @return the element
     */
    public Object getModelElement() {
        return modelElement;
    }

    /**
     * Determines which object will be used as <tt>self</tt> in evaluating the
     * OCL expression. Can either be a {@link ModelElementProxy proxy} or a
     * {@link RefObject}. If the OCL expression uses <tt>#context</tt>, the
     * {@link #getContextElement() context element} is used; otherwise the
     * {@link #getModelElement()} call is used.
     */
    public Object getElementForSelf() {
        if (ContextAndForeachHelper.usesContext(getOclQuery())) {
            return getContextElement();
        } else if (ContextAndForeachHelper.usesForeach(getOclQuery())) {
            return getCurrentForeachElement();
        } else {
            return getModelElement();
        }
    }

    /**
     * Gets the property name.
     * 
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Gets the value type name.
     * 
     * @return the value type name
     */
    public List<String> getValueTypeName() {
        return valueTypeName;
    }

    /**
     * Gets the key name.
     * 
     * @return the key name
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * Gets the key value.
     * 
     * @return the key value
     */
    public Object getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String value) {
        this.keyValue = value;
    }

    /**
     * Gets the look in.
     * 
     * @return the look in
     */
    public String getLookIn() {
        return lookIn;
    }

    /**
     * Gets the auto create.
     * 
     * @return the auto create
     */
    public String getAutoCreate() {
        return autoCreate;
    }

    /**
     * Gets the creates the as.
     * 
     * @return the creates the as
     */
    public List<String> getCreateAs() {
        return createAs;
    }

    /**
     * Checks if is import context.
     * 
     * @return true, if is import context
     */
    public boolean isImportContext() {
        return importContext;
    }

    /**
     * Gets the creates the in.
     * 
     * @return the creates the in
     */
    public String getCreateIn() {
        return createIn;
    }

    /**
     * Gets the token.
     * 
     * @return the token
     */
    public ANTLR3LocationToken getToken() {
        return token;
    }

    /**
     * Gets the InjectorAction or SequenceElement from where the query
     * originates.
     * 
     * @return Either a InjectorAction or SequenceElement.
     */
    public Object getQueryElement() {
        return queryElement;
    }

    /**
     * sets the token.
     * 
     * @return the token
     */
    public void setToken(ANTLR3LocationToken token) {
        this.token = token;
    }

    /**
     * Gets the real value.
     * 
     * @return the real value
     */
    public Object getRealValue() {
        return realValue;
    }

    /**
     * Sets the real value.
     * 
     * @param realValue
     *            the new real value
     */
    public void setRealValue(Object realValue) {
        this.realValue = realValue;
    }

    /**
     * @return the oclQuery
     */
    public String getOclQuery() {
        return oclQuery;
    }

    public void setOclQuery(String query) {
        this.oclQuery = query;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = modelElement != null && modelElement.getClass() != null ? modelElement.getClass().getName() : "<generic>";
        if(getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE) {
            result += " [FOR_EACH_PROPERTY_INIT] ";
        }
        result += '.'
                + getPropertyName() + "=>" + getValueTypeName();
        if (getCreateAs() != null) {
            result += " as " + getCreateAs();
        }
        result += " with " + getKeyName() + "=" + getKeyValue();
        if (getCreateIn() != null) {
            result += " to create in " + getCreateIn();
        }
        if(getOclQuery() != null) {
            result += " using query: " + getOclQuery(); 
        }
        return result;
    }

    /**
     * @param result
     */
    public void setModelElement(Object newObject) {
        this.modelElement = newObject;
    }
    
    public RefObject getUnwrappedModelElement() {
        if(modelElement instanceof IModelElementProxy) {
            return (RefObject) ((IModelElementProxy) modelElement).getRealObject();
        } else {
            return (RefObject) modelElement;
        }
    }

    /**
     * @param result
     */
    public void setContextElement(Object newContext) {
        this.referenceContextObject = newContext;
    }

    /**
     * Returns whether the reference is optional which means that if it is not
     * resolved it won't result in an error.
     * 
     * @return true if the referencer is optional.
     */
    public boolean isOptional() {
        return isOptional;
    }

    /**
     * 
     * @return mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<PredicateSemantic> getPredicateActionList() {
        return predicateActionList;
    }

    public void setPredicateActionList(
            List<PredicateSemantic> predicateActionList) {
        this.predicateActionList = predicateActionList;
    }

    public void setQueryElement(Object sequenceElementOrInjectorAction) {
        this.queryElement = sequenceElementOrInjectorAction;
    }

    /**
     * Defines whether the reference is defined through a generic property init
     * (being set to true) or if it is a refernce that was created during a
     * parse run or as an unresolved reference (being set to false);
     */
    public void setGenericReference(boolean value) {
        this.isGenericReference = value;
    }

    /**
     * Defines whether the reference is defined through a generic property init
     * (being set to true) or if it is a refernce that was created during a
     * parse run or as an unresolved reference (being set to false);
     */
    public boolean isGenericReference() {
        return isGenericReference;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public IRuleName getRuleNameFinder() {
        return ruleNameFinder;
    }

    public void setRuleNameFinder(IRuleName ruleNameFinder) {
        this.ruleNameFinder = ruleNameFinder;
    }

    public boolean hasContext() {
        return hasContext;
    }

    @Override
    public DelayedReference clone() {
        try {
            return (DelayedReference) super.clone();
        } catch (CloneNotSupportedException e) {
            // this should never happen.
            return null;
        }
    }

    public void setTextBlock(Object textBlock) {
        this.textBlock = textBlock;
    }

    public Object getTextBlock() {
        return textBlock;
    }

    public void setConnection(Connection conn) {
        this.connection = conn;
    }
    
    public Connection getConnection() {
        return connection;
    }
    public void setCurrentForeachElement(RefObject currentForeachElement) {
        this.currentForeachElement = currentForeachElement;
    }


	public List<SemanticDisambRuleData> getSemRulData() {
		return semRulData;
	}

	public void setSemRulData(List<SemanticDisambRuleData> semRulData) {
		this.semRulData = semRulData;
	}

	public Object getSemanticObject() {
		return semanticObject;
	}

	public Object getOpTemplateLefthand() {
		return opTemplateLefthand;
	}
    
	public boolean isSemanticDisambiguatedOperatorRule()
	{
		return type == SEMANTIC_DISAMBIGUATE && opTemplateLefthand != null;
	}
}
