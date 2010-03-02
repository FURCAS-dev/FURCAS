package com.sap.mi.textual.parsing.textblocks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tcs.ClassTemplate;
import tcs.ContextTags;
import tcs.ContextTemplate;
import test.enumeration.Student;
import textblockdefinition.TextBlockDefinition;
import textblocks.TextBlock;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TestTextBlocksOperations extends TextBlockTest {
    
    @Test
    public void testLookInContextWithNullTag() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        
        assertEquals(0, textBlock.lookInContext(null).size());
    }
    
    @Test
    public void testLookInContextWithTag() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        
        assertEquals(0, textBlock.lookInContext("tag").size());
    }
    
    @Test
    public void testLookInContextWithElement() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        
        RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        textBlock.getElementsInContext().add(object);
        
        assertEquals(1, textBlock.lookInContext(null).size());
    }
    
    @Test
    public void testLookInContextWithElementInParent() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        
        TextBlock child = this.modelFactory.createTextBlock();
        child.setType(def);
        child.setParentBlock(textBlock);
        
        RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        textBlock.getElementsInContext().add(object);
        
        assertEquals(1, child.lookInContext(null).size());
    }
    
    @Test
    public void testLookInContextWithElementInParentIsNotContext() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        TextBlockDefinition def2 = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp2 = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        
        def2.setParseRule(tmp2);
        tmp2.setContext(false);
        
        TextBlock child = this.modelFactory.createTextBlock();
        child.setType(def2);
        child.setParentBlock(textBlock);
        
        RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        child.getElementsInContext().add(object);
        
        assertEquals(0, child.lookInContext(null).size());
    }
    
    @Test
    public void testLookInContextWithTagWithElementInParentWithTag() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        ContextTags tags = (ContextTags) connection.getClass(ContextTags.CLASS_DESCRIPTOR).refCreateInstance();
        tmp.setContextTags(tags);
        tags.getTags().add("tag");
        
        TextBlock child = this.modelFactory.createTextBlock();
        child.setType(def);
        child.setParentBlock(textBlock);
        
        RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        textBlock.getElementsInContext().add(object);
        
        assertEquals(1, child.lookInContext("tag").size());
    }
    
    @Test
    public void testLookInContextWithElementInParentWithUnion() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        
        TextBlock child = this.modelFactory.createTextBlock();
        child.setType(def);
        child.setParentBlock(textBlock);
        
        RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        RefObject object2 = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        textBlock.getElementsInContext().add(object);
        child.getElementsInContext().add(object2);
        
        assertEquals(2, child.lookInContext(null).size());
    }
    
    @Test
    public void testLookInContextWithElementInParentWithUnionWithEmpty() {
        TextBlock textBlock = this.modelFactory.createTextBlock();
        TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR).refCreateInstance();
        ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
        
        textBlock.setType(def);
        def.setParseRule(tmp);
        tmp.setContext(true);
        
        TextBlock child = this.modelFactory.createTextBlock();
        child.setType(def);
        child.setParentBlock(textBlock);
        
        RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
        child.getElementsInContext().add(object);
        
        assertEquals(1, child.lookInContext(null).size());
    }
}
