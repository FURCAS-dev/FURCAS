package com.sap.furcas.textual.textblocks;
//package com.sap.furcas.textua.aa;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import com.sap.furcas.metamodel.TCS.ClassTemplate;
//import com.sap.furcas.metamodel.TCS.ContextTags;
//import com.sap.furcas.metamodel.TCS.ContextTemplate;
//import com.sap.furcas.metamodel.TCS.TCSFactory;
//import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;
//import com.sap.furcas.metamodel.textblocks.TextBlock;
//import com.sap.furcas.textual.textblocks.testutils.TextBlockTest;
//
//public class TestTextBlocksOperations extends TextBlockTest {
//
//    @Test
//    public void testLookInContextWithNullTag() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = TextblockDefinitionFactory.eINSTANCE.createTextblockDefinition();
//	ContextTemplate tmp = TCSFactory.eINSTANCE.createContextTemplate();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	assertEquals(0, textBlock.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithTag() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = TextblockDefinitionFactory.eINSTANCE.createTextblockDefinition();
//	ContextTemplate tmp = TCSFactory.eINSTANCE.createContextTemplate();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	assertEquals(0, textBlock.lookInContext("tag").size());
//    }
//
//    @Test
//    public void testLookInContextWithElement() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = TextblockDefinitionFactory.eINSTANCE.createTextblockDefinition();
//	ContextTemplate tmp = TCSFactory.eINSTANCE.createContextTemplate();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//
//	assertEquals(1, textBlock.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParent() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = TextblockDefinitionFactory.eINSTANCE.createTextblockDefinition();
//	ContextTemplate tmp = TCSFactory.eINSTANCE.createContextTemplate();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	TextBlock child = this.modelFactory.createTextBlock();
//	child.setType(def);
//	child.setParent(textBlock);
//
//	RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//
//	assertEquals(1, child.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParentIsNotContext() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = (TextblockDefinition) connection.getClass(TextblockDefinition.CLASS_DESCRIPTOR)
//		.refCreateInstance();
//	TextblockDefinition def2 = (TextblockDefinition) connection.getClass(TextblockDefinition.CLASS_DESCRIPTOR)
//		.refCreateInstance();
//	ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
//	ContextTemplate tmp2 = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//
//	def2.setParseRule(tmp2);
//	tmp2.setIsContext(false);
//
//	TextBlock child = this.modelFactory.createTextBlock();
//	child.setType(def2);
//	child.setParent(textBlock);
//
//	RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	child.getElementsInContext().add(object);
//
//	assertEquals(0, child.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithTagWithElementInParentWithTag() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = (TextblockDefinition) connection.getClass(TextblockDefinition.CLASS_DESCRIPTOR)
//		.refCreateInstance();
//	ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//	ContextTags tags = (ContextTags) connection.getClass(ContextTags.CLASS_DESCRIPTOR).refCreateInstance();
//	tmp.setIsContextTags(tags);
//	tags.getTags().add("tag");
//
//	TextBlock child = this.modelFactory.createTextBlock();
//	child.setType(def);
//	child.setParent(textBlock);
//
//	RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//
//	assertEquals(1, child.lookInContext("tag").size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParentWithUnion() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = (TextblockDefinition) connection.getClass(TextblockDefinition.CLASS_DESCRIPTOR)
//		.refCreateInstance();
//	ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	TextBlock child = this.modelFactory.createTextBlock();
//	child.setType(def);
//	child.setParent(textBlock);
//
//	RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	RefObject object2 = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//	child.getElementsInContext().add(object2);
//
//	assertEquals(2, child.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParentWithUnionWithEmpty() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextblockDefinition def = (TextblockDefinition) connection.getClass(TextblockDefinition.CLASS_DESCRIPTOR)
//		.refCreateInstance();
//	ContextTemplate tmp = (ContextTemplate) connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refCreateInstance();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	TextBlock child = this.modelFactory.createTextBlock();
//	child.setType(def);
//	child.setParent(textBlock);
//
//	RefObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	child.getElementsInContext().add(object);
//
//	assertEquals(1, child.lookInContext(null).size());
//    }
//}
