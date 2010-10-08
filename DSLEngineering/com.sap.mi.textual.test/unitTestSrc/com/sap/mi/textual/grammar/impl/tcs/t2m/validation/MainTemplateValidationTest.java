/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.validation;

import static com.sap.mi.textual.test.util.StringListHelper.list;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.parsergenerator.tcs.t2m.validation.MainTemplateValidation;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.MetaLookupStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.ClassTemplateStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.ConcreteSyntaxStub;

/**
 *
 */
public class MainTemplateValidationTest {

    @Test
    public void testValidateOneMain() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        ClassTemplateStub tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.isMain = true;
        syntaxStub.templates.add(tempStub);
        
        MainTemplateValidation validator = new MainTemplateValidation();
        
        validator.validate(syntaxStub, metaLookupStub, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateOneMainOneNot() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        ClassTemplateStub tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.isMain = true;
        syntaxStub.templates.add(tempStub);
        tempStub = new ClassTemplateStub();
        tempStub.names = list("test2");
        tempStub.isMain = false;
        syntaxStub.templates.add(tempStub);
        
        MainTemplateValidation validator = new MainTemplateValidation();
        
        validator.validate(syntaxStub, metaLookupStub, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateTwoMain() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        ClassTemplateStub tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.isMain = true;
        syntaxStub.templates.add(tempStub);
        tempStub = new ClassTemplateStub();
        tempStub.names = list("test2");
        tempStub.isMain = true;
        syntaxStub.templates.add(tempStub);
        
        MainTemplateValidation validator = new MainTemplateValidation();
        
        validator.validate(syntaxStub, metaLookupStub, errorBucket);
        assertEquals(1, errorBucket.getErrors().size());
    }
  
    @Test
    public void testValidateEmpty() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        MainTemplateValidation validator = new MainTemplateValidation();
        
        validator.validate(syntaxStub, metaLookupStub, errorBucket);
        
        // one error as one main classtemplate has to be defined
        assertEquals(1, errorBucket.getErrors().size());
    }

}
