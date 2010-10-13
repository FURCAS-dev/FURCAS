/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.stubs.LookupPropertyInitStub;
import com.sap.furcas.metamodel.TCS.stubs.PrimitivePropertyInitStub;
import com.sap.furcas.metamodel.TCS.stubs.PropertyReferenceStub;
import com.sap.furcas.metamodel.TCS.stubs.SequenceElementStub;
import com.sap.furcas.metamodel.TCS.stubs.TemplateStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaModelElementResolutionHelperStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.OperatorHandlerStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.RuleBodyStringBufferStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 *
 */
public class TestInjectorActionsHandler {
    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }
    
    @Test
    public void testAddPropertyInitLookup() throws Exception {
    	SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
    	MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxElementHandlerConfigurationBean<Object> bean = new SyntaxElementHandlerConfigurationBean<Object>(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);
        // Class under test
        InjectorActionsHandler actHandler = new InjectorActionsHandler<Object>(bean);

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        InjectorActionsBlockStub block = new InjectorActionsBlockStub();
        
        TemplateStub template = new TemplateStub();
        template.names = new BasicEList<String>();
        template.names.add("template");
        syntaxLookupStub.enclosingName = template;
        metaLookupStub.featureClassName = template.names;
        
        actHandler.addElement(block, buf);
        assertEquals("", buf.getResult() );
        
        LookupPropertyInitStub propInitActionStub = createLookupPropertyInitStub("test",
                "'test2'");
        block.actions.add(propInitActionStub);
        actHandler.addElement(block, buf);
        assertEquals("{setRef(ret, \"test\", \"[template]\", null, null, \"'test2'\", null, null, false, null, true);}", buf.getResult() );
    }
    
    @Test
    public void testAddPropertyInitString() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxElementHandlerConfigurationBean<Object> bean = new SyntaxElementHandlerConfigurationBean<Object>(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);
        // Class under test
        InjectorActionsHandler actHandler = new InjectorActionsHandler<Object>(bean);

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        InjectorActionsBlockStub block = new InjectorActionsBlockStub();
        
        actHandler.addElement(block, buf);
        assertEquals("", buf.getResult() );
        
        PrimitivePropertyInitStub propInitActionStub = createPrimitivePropertyInitStub("test",
                "\"test2\"");
        block.actions.add(propInitActionStub);
        actHandler.addElement(block, buf);
        assertEquals("{setProperty(ret, \"test\", \"test2\");}", buf.getResult() );
    }

    @Test
    public void testAddPropertyInitInt() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxElementHandlerConfigurationBean<Object> bean = new SyntaxElementHandlerConfigurationBean<Object>(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);
        // Class under test
        InjectorActionsHandler actHandler = new InjectorActionsHandler<Object>(bean);

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        InjectorActionsBlockStub block = new InjectorActionsBlockStub();
        
        PrimitivePropertyInitStub propInitActionStub = createPrimitivePropertyInitStub("test",
                "42");
        block.actions.add(propInitActionStub);
        actHandler.addElement(block, buf);
        assertEquals("{setProperty(ret, \"test\", 42);}", buf.getResult() );
    }
    
    @Test
    public void testAddPropertyInitMany() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        SyntaxElementHandlerConfigurationBean<Object> bean = new SyntaxElementHandlerConfigurationBean<Object>(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);
        // Class under test
        InjectorActionsHandler actHandler = new InjectorActionsHandler<Object>(bean);

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        InjectorActionsBlockStub block = new InjectorActionsBlockStub();
      
        
        PrimitivePropertyInitStub propInitActionStub = createPrimitivePropertyInitStub("test",
                "42");
        block.actions.add(propInitActionStub);
        PrimitivePropertyInitStub propInitActionStub2 = createPrimitivePropertyInitStub("hello",
        "\"World\"");
        block.actions.add(propInitActionStub2);
        
        
        actHandler.addElement(block, buf);
        assertEquals("{setProperty(ret, \"test\", 42);setProperty(ret, \"hello\", \"World\");}", buf.getResult() );
    }
    
    /**
     * @param reference
     * @param value
     * @return
     */
    private static PrimitivePropertyInitStub createPrimitivePropertyInitStub(
            String refName, String value) {
        PropertyReferenceStub reference = new PropertyReferenceStub();
        reference.name = refName;
        PrimitivePropertyInitStub propInitActionStub = new PrimitivePropertyInitStub();
        propInitActionStub.reference = reference;
        propInitActionStub.value = value;
        return propInitActionStub;
    }
    
    private static LookupPropertyInitStub createLookupPropertyInitStub(
            String refName, String value) {
        PropertyReferenceStub reference = new PropertyReferenceStub();
        reference.name = refName;
        LookupPropertyInitStub propInitActionStub = new LookupPropertyInitStub();
        propInitActionStub.reference = reference;
        propInitActionStub.value = value;
        return propInitActionStub;
    }
    
    class InjectorActionsBlockStub extends SequenceElementStub implements InjectorActionsBlock {

        public EList<InjectorAction> actions = new BasicEList<InjectorAction>();

        @Override
        public EList<InjectorAction> getInjectorActions() {
            return actions;
        }

	@Override
	public EList<InjectorAction> getPropertyInits() {
	    return null;
	}
        
    }


}
