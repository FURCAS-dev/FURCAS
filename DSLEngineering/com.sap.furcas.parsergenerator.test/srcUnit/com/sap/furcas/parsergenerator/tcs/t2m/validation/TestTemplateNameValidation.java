/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.validation;

import static com.sap.furcas.runtime.parser.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.emf.stubs.EcoreAnyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ClassTemplateStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ConcreteSyntaxStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.TemplateStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaLookupStub;

/**
 *
 */
public class TestTemplateNameValidation {

    @Test
    public void testValidateEmpty() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateOneTemplate() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        TemplateStub tempStub = new TemplateStub();
        tempStub.names = list("test");
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateTwoTemplate() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        TemplateStub tempStub = new TemplateStub();
        tempStub.names = list("test");
        syntaxStub.templates.add(tempStub);
        tempStub = new TemplateStub();
        tempStub.names = list("test2");
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateDuplicateClassTemplateNamesDifferentMode() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        ClassTemplateStub tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.mode = "mode1";
        syntaxStub.templates.add(tempStub);
        tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.mode = "mode2";
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateDifferentClassTemplateNamesSameModeMoinRef() {
        // tests after a specific bug
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        ClassTemplateStub tempStub = new ClassTemplateStub();
        EcoreAnyStub metaClass1 = new EcoreAnyStub();
        metaClass1.name = "test1";
        tempStub.metaReference = metaClass1;
        tempStub.mode = "mode1";
        syntaxStub.templates.add(tempStub);
        
        EcoreAnyStub metaClass2 = new EcoreAnyStub();
        metaClass2.name = "test2";
        tempStub = new ClassTemplateStub();
        tempStub.metaReference = metaClass2;
        tempStub.mode = "mode1";
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    /******** error cases ****/
    @Test
    public void testValidateNoName() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        TemplateStub tempStub = new TemplateStub();
        tempStub.names = null;
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidate2Errors() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        TemplateStub tempStub = new TemplateStub();
        tempStub.names = null;
        syntaxStub.templates.add(tempStub);
        tempStub = new TemplateStub();
        tempStub.names = list();
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(2, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateDuplicateTemplateNames() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        TemplateStub tempStub = new TemplateStub();
        tempStub.names = list("test");
        syntaxStub.templates.add(tempStub);
        tempStub = new TemplateStub();
        tempStub.names = list("test");
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testValidateDuplicateModedClassTemplateNames() {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        ClassTemplateStub tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.mode = "errorMode";
        syntaxStub.templates.add(tempStub);
        tempStub = new ClassTemplateStub();
        tempStub.names = list("test");
        tempStub.mode = "errorMode";
        syntaxStub.templates.add(tempStub);
        
        TemplateNameValidation validation = new TemplateNameValidation();
        
        validation.validate(syntaxStub, metaLookupStub, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
}
