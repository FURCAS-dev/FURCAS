/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.AtomExp;
import com.sap.furcas.metamodel.TCS.EnumLiteralVal;
import com.sap.furcas.metamodel.TCS.IntegerVal;
import com.sap.furcas.metamodel.TCS.NegativeIntegerVal;
import com.sap.furcas.metamodel.TCS.StringVal;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ConditionalElementHandler;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.MetaLookupStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.MetaModelElementResolutionHelperStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.RuleBodyStringBufferStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.AndExpStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.BooleanPropertyExpStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.ClassTemplateStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.ConditionalElementStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.EqualsExpStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.InstanceOfExpStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.IsDefinedExpStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.LocatedElementStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OneExpStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.SequenceStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.TemplateStub;
import com.sap.mi.textual.test.util.StringListHelper;

/**
 * tests the grammar generatio for conditional elements in the Syntax definition
 */
public class ConditionalElementHandlerTest {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }
    
    @Test
    public void testAddElementNullCondition() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        ConditionalElementStub element = new ConditionalElementStub();
        boolean thrown = false;
        try {
            conElHandler.addElement(element , buf);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue("IllegalArgumentException expected", thrown);
        
        SequenceStub thenSeq = new SequenceStub();
        thenSeq.representation = "then";
        element.thenSequence = thenSeq;
        AndExpStub andexp = new AndExpStub();
        element.condition = andexp;
        
        thrown = false;
        try {
            conElHandler.addElement(element , buf);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue("IllegalArgumentException expected", thrown);
    }
    
    @Test
    public void testAddElementBool() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        BooleanPropertyExpStub bool1 = new BooleanPropertyExpStub();
        conditionExpressionsList.add(bool1 );
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
                
        conElHandler.addElement(element , buf);
        assertEquals(" (then{setProperty(ret, \"null\", java.lang.Boolean.TRUE);} | else{setProperty(ret, \"null\", java.lang.Boolean.FALSE);})\n", buf.getResult() );
  
        bool1.propertyRef.name = "propName";
        buf = new RuleBodyStringBufferStub();
        conElHandler.addElement(element , buf);
        assertEquals(" (then{setProperty(ret, \"propName\", java.lang.Boolean.TRUE);} | else{setProperty(ret, \"propName\", java.lang.Boolean.FALSE);})\n", buf.getResult() );
    }
    
    /**
     * With the isdefined keyword, there is nothing we can set in so the rule should be simple
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementIsDefined() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        IsDefinedExpStub bool1 = new IsDefinedExpStub();
        conditionExpressionsList.add(bool1 );
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        conElHandler.addElement(element , buf);
        assertEquals(" (then | else)\n", buf.getResult() );
        
        // clumsy check that IsDefined expression led to constraints (then and else) be added, then removed.
        assertEquals(2, buf.addedconstraints.size());
        assertEquals(2, buf.removedConstraints.size());
     }
    
    /**
     * With the instanceof keyword, there is nothing we can set in so the rule should be simple
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementInstanceOf() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        InstanceOfExpStub bool1 = new InstanceOfExpStub();
        conditionExpressionsList.add(bool1 );
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        conElHandler.addElement(element , buf);
        assertEquals(" (then | else)\n", buf.getResult() );
        
        assertEquals(1, buf.addedconstraints.size());
        assertEquals(1, buf.removedConstraints.size());
     }
    
    @Test
    public void testAddElementPropertyEqStringVal() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        EqualsExpStub equalExp = new EqualsExpStub();
        equalExp.propertyRef.name = "propName";
        equalExp.value = new StringValStub();
        conditionExpressionsList.add(equalExp );
        
        conElHandler.addElement(element , buf);
        // equals element does not have an else setting part
        assertEquals(" (then{setProperty(ret, \"propName\", new String(\"StringVal\"));} | else{})\n", buf.getResult() );
    }
    
    @Test
    public void testAddElementPropertyEqIIntegerVal() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        EqualsExpStub equalExp = new EqualsExpStub();
        equalExp.propertyRef.name = "propName";
        equalExp.value = new IntegerValStub();
        conditionExpressionsList.add(equalExp );
        
        conElHandler.addElement(element , buf);
        // equals element does not have an else setting part
        assertEquals(" (then{setProperty(ret, \"propName\", new Integer(42));} | else{})\n", buf.getResult() );
    }
    
    @Test
    public void testAddElementPropertyEqINegIntegerVal() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        EqualsExpStub equalExp = new EqualsExpStub();
        equalExp.propertyRef.name = "propName";
        equalExp.value = new NegativeIntegerValStub();
        conditionExpressionsList.add(equalExp );
        
        conElHandler.addElement(element , buf);
        // equals element does not have an else setting part
        assertEquals(" (then{setProperty(ret, \"propName\", new Integer(-42));} | else{})\n", buf.getResult() );
    }
    
    @Test
    public void testAddElementMultiple() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        EqualsExpStub equalExp = new EqualsExpStub();
        equalExp.propertyRef.name = "propName";
        equalExp.value = new NegativeIntegerValStub();
        conditionExpressionsList.add(equalExp );
        
        BooleanPropertyExpStub bool1 = new BooleanPropertyExpStub();
        bool1.propertyRef.name = "propName2";
        conditionExpressionsList.add(bool1 );
        
        conElHandler.addElement(element , buf);
        // adds the effects to the then part, else part has one lement because equals has no else part
        assertEquals(" (then{setProperty(ret, \"propName\", new Integer(-42));setProperty(ret, \"propName2\", java.lang.Boolean.TRUE);} | else{setProperty(ret, \"propName2\", java.lang.Boolean.FALSE);})\n", buf.getResult() );
    }
    
    @Test
    public void testAddElementOne() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        syntaxStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(new MetaLookupStub(), syntaxStub, null, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        OneExpStub bool1 = new OneExpStub();
        conditionExpressionsList.add(bool1 );
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        conElHandler.addElement(element , buf);
        assertEquals(" (then | else)\n", buf.getResult() );
        
        // clumsy check that IsDefined expression led to constraints (then and else) be added, then removed.
        assertEquals(2, buf.addedconstraints.size());
        assertEquals(2, buf.removedConstraints.size());
     }
    

    
    
    @Test
    public void testAddElementPropertyEqIEnumVal() throws Exception {
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxLookupStub syntaxLookUpStub = new SyntaxLookupStub();
        MetaLookupStub metaStub = new MetaLookupStub();
        metaStub.enumLiterals = new  ArrayList<String>(2);
        metaStub.enumLiterals.add("LiteralName");
        metaStub.enumLiterals.add("LiteralName2");
        syntaxLookUpStub.enclosingName = new TemplateStub(StringListHelper.list("test"));
        TemplateNamingHelperStub namingHelperStub = new TemplateNamingHelperStub();
        // Class under test
        ConditionalElementHandler conElHandler = new ConditionalElementHandler(metaStub , syntaxLookUpStub , namingHelperStub, resolutionHelperStub, null);
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        List<AtomExp> conditionExpressionsList = new ArrayList<AtomExp>();
        
        ConditionalElementStub element = getConditionalElement(conditionExpressionsList);
        
        TemplateStub nameStub = new TemplateStub();
        nameStub.names = StringListHelper.list("templateReferenceName");
        syntaxLookUpStub.enclosingName = nameStub;
        metaStub.featureClassName = StringListHelper.list("EnumName"); // to be returned when asked for a typeName
        
        final ClassTemplateStub template = new ClassTemplateStub();
        
        EqualsExpStub equalExp = new EqualsExpStub() {

      

            /* (non-Javadoc)
             * @see com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.LocatedElementStub#refImmediateComposite()
             */
            @Override
            public RefFeatured refImmediateComposite() {
                // TODO Auto-generated method stub
                return template;
            }
            
        };
        equalExp.propertyRef.name = "propName";
        EnumLiteralValStub literalRefStub = new EnumLiteralValStub();
        literalRefStub.name = "LiteralName";
        equalExp.value = literalRefStub ;

        conditionExpressionsList.add(equalExp );
        
        
        conElHandler.addElement(element , buf);
        // equals element does not have an else setting part
        // naming stub creates other name parameter than original naming helper
        assertEquals(" (then{setProperty(ret, \"propName\", createEnumLiteral(\"[EnumName]\",\"LiteralName\"));} | else{setProperty(ret, \"propName\", createEnumLiteral(\"[EnumName]\",\"LiteralName2\"));})\n", buf.getResult() );
    }
    
    
  


    private ConditionalElementStub getConditionalElement(
            List<AtomExp> conditionExpressionsList) {
        ConditionalElementStub element = new ConditionalElementStub();
     
        SequenceStub thenSeq = new SequenceStub();
        thenSeq.representation = "then";
        element.thenSequence = thenSeq;
        
        SequenceStub elseSeq = new SequenceStub();
        elseSeq.representation = "else";
        element.elseSequence = elseSeq;
        
        AndExpStub andexp = new AndExpStub();
        
        andexp.atomExpList = conditionExpressionsList;
        element.condition = andexp ;
        return element;
    }
 
    
    

    class StringValStub extends LocatedElementStub implements StringVal {

        /* (non-Javadoc)
         * @see TCS.StringVal#getSymbol()
         */
        public String getSymbol() {
            return "StringVal";
        }
        public void setSymbol(String value) { 
            // not needed for test
        }
        
    }
    
    class IntegerValStub extends LocatedElementStub implements IntegerVal {

        /* (non-Javadoc)
         * @see TCS.StringVal#getSymbol()
         */
        public int getSymbol() {
            return 42;
        }
        public void setSymbol(int value) { 
            // not needed for test
        }
        
    }
    
    class NegativeIntegerValStub extends LocatedElementStub implements NegativeIntegerVal {

        /* (non-Javadoc)
         * @see TCS.StringVal#getSymbol()
         */
        public int getSymbol() {
            return 42;
        }
        public void setSymbol(int value) { 
            // not needed for test
        }
        
    }
    
    class EnumLiteralValStub extends LocatedElementStub implements EnumLiteralVal {

        public String name;

        /* (non-Javadoc)
         * @see TCS.EnumLiteralVal#getName()
         */
        public String getName() {
            return name;
        }

        /* (non-Javadoc)
         * @see TCS.EnumLiteralVal#setName(java.lang.String)
         */
        public void setName(String value) {
            // not needed for the test
        }

        
    }
    

}
