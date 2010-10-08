/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-09-18 14:13:44 +0200 (Fr, 18 Sep 2009) $
 * @version $Revision: 7886 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.ConditionalElement;
import com.sap.furcas.metamodel.TCS.CustomSeparator;
import com.sap.furcas.metamodel.TCS.FunctionCall;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.Literal;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;


/**
 * Utility class to make Interfaces easier to understand.
 * Works as a combination of a StringBuffer and a Class to be called recursively.
 * This class calls handlers which during that call may call this class again, to produce nested production rule bodies.
 * 
 * @author C5107456
 */
public class RuleBodyStringBuffer {

    // elements protected to make unit testing a bit easier
    /** The alternative handler. */
    private final AlternativeHandler alternativeHandler;
    
    private final InjectorActionsHandler<?> injectorActionsHandler;

    /** The block handler. */
    private final BlockTypeHandler blockHandler;

    /** The con el handler. */
    private final ConditionalElementHandler<?> conElHandler;

    /** The property handler. */
    private final PropertyTypeHandler<?> propertyHandler;

    /** The syntax lookup. */
    private final SyntaxLookup syntaxLookup;

    /** The buf. */
    private final VarStringBuffer buf = new VarStringBuffer();

    private final TemplateNamingHelper<?> namingHelper;
    
    private final List<RuleBodyPropertyConstraint> constraints = new ArrayList<RuleBodyPropertyConstraint>();

    private final SemanticErrorBucket errorBucket;


    /**
     * Instantiates a new rule body string buffer.
     * 
     * @param newAlternativeHandler the alternative handler
     * @param blockHandler the block handler
     * @param conElHandler the con el handler
     * @param propertyHandler the property handler
     * @param syntaxLookup the syntax lookup
     * @param namingHelper 
     * @param errorBucket 
     * @param newInjectorActionsHandler 
     */
    public RuleBodyStringBuffer(AlternativeHandler newAlternativeHandler,
            BlockTypeHandler blockHandler,
            ConditionalElementHandler<?> conElHandler,
            PropertyTypeHandler<?> propertyHandler, SyntaxLookup syntaxLookup, TemplateNamingHelper<?> namingHelper,
            InjectorActionsHandler<?> newInjectorActionsHandler, SemanticErrorBucket errorBucket) {
        super();
        this.alternativeHandler = newAlternativeHandler;
        this.injectorActionsHandler = newInjectorActionsHandler;
        this.blockHandler = blockHandler;
        this.conElHandler = conElHandler;
        this.propertyHandler = propertyHandler;
        this.syntaxLookup = syntaxLookup;
        this.namingHelper = namingHelper;
        this.errorBucket = errorBucket;
    }

    /**
     * Append.
     * 
     * @param object the object
     */
    public void append(Object object) {
        if (object != null ) {
            buf.append(object);
        }
    }

    /**
     * Appends the array of objects.
     * @param objectArr
     */
    public void append(Object... objectArr) {
        if (objectArr != null ) {
            buf.append(objectArr);
        }   
    }

    /**
     * Append.
     * 
     * @param character the character
     */
    public void append(char character) {
        buf.append(character);
    }

    /**
     * Gets the result.
     * 
     * @return the result
     */
    public String getResult() {
        return buf.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getResult();
    }

    protected void addToRuleFragment(Sequence seq) throws MetaModelLookupException {
        if (seq == null) {
            return;
        }
        blockHandler.addElement(seq, this);
    }

    /**
     * recursive call for elements that do not create a rule of their own, but influence creation of a rule body.
     * 
     * @param element the element
     * 
     * @throws SyntaxParsingException the syntax parsing exception
     * @throws MetaModelLookupException the meta model lookup exception
     */
    protected void addToRuleFragment(SequenceElement element) throws MetaModelLookupException {
        try {
        if (element == null) {
            return;
        }
        this.append(ObservationDirectivesHelper.getEnterSequenceElementNotification(element));        
        if (element instanceof Block) {
            Block seq = (Block) element;
            blockHandler.addElement(seq, this);
        } else if (element instanceof Property) {
            Property prop = (Property) element;
            propertyHandler.addElement(prop, this);
        } else if (element instanceof Literal) {
            Literal lit = (Literal) element;	
            this.append(lit.getValue());
        } else if (element instanceof LiteralRef) {
            LiteralRef lit = (LiteralRef) element;
            if (lit.getReferredLiteral() == null) {
                throw new RuntimeException("Bug: Missing reference, check that references were set after parsing in " + element.getLocation());
            }
            String value = lit.getReferredLiteral().getValue();
            this.append(syntaxLookup.getSymbolRule(value));
        } else if (element instanceof ConditionalElement) {
            ConditionalElement conEl = (ConditionalElement) element;
            conElHandler.addElement(conEl, this);
        } else if (element instanceof Alternative) {
            Alternative alt = (Alternative) element;
            alternativeHandler.addElement(alt, this);
        } else if (element instanceof InjectorActionsBlock) {
            InjectorActionsBlock block = (InjectorActionsBlock) element;
            injectorActionsHandler.addElement(block, this);
        } else if (element instanceof CustomSeparator) {
//          CustomSeparator conEl = (CustomSeparator) element;
//            ignore here, only relevant for serializing
//            throw new RuntimeException("CustomSeparator mapping not implemented yet in " + element.getLocation());
        } else if (element instanceof FunctionCall) {
            FunctionCall funcCall = (FunctionCall) element;
            if (funcCall.getCalledFunction() == null) {
                throw new RuntimeException("Bug: Missing Function Template in function call in " + element.getLocation());
            }
            String rulename = namingHelper.getRuleName(funcCall.getCalledFunction());
            this.append(rulename + "[ret]");
        } else {
            // should never happen, as long as TCS defines only the SequenceElement subclasses above
            throw new RuntimeException("Unknown kind of SequenceElement " + element.getClass());
        }
        } catch (SyntaxElementException e) {
            errorBucket.addException(e);
        }
        this.append(ObservationDirectivesHelper.getExitSequenceElementNotification());
    }

    

    
    /**
     * @param inverseConstraint
     * @return
     */
    public RuleBodyPropertyConstraint setPropertyConstraint(
            RuleBodyPropertyConstraint constraint) {
        constraints.add(constraint);
        return constraint;
    }
    
    /**
     * to be used by PropertyHandler
     * @return
     */
    public List<RuleBodyPropertyConstraint> getCurrentConstraints() {
        return constraints;
    }
    
    /**
     *  to be used by ConditionalElementHandler after body building.
     * @param constraint
     */
    public void removeConstraint(RuleBodyPropertyConstraint constraint) {
        if (constraints.indexOf(constraint) == constraints.size()-1) { 
            constraints.remove(constraint);
        } else {
            // should never happen
            throw new RuntimeException("Constraint to be removed but not last in list: " + constraints + " : " + constraint);
        }
        
    }


    
}
