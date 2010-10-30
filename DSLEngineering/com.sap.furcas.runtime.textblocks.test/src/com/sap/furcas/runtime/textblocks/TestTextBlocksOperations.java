package com.sap.furcas.runtime.textblocks;
//
//import static org.junit.Assert.assertEquals;
//
//import org.eclipse.emf.ecore.EObject;
//import org.junit.Test;
//
//import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
//import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
//import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
//import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
//import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
//import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionFactory;
//import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
//import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
//import com.sap.furcas.runtime.textblocks.testutils.TextBlockTest;
//
//public class TestTextBlocksOperations extends TextBlockTest {
//
//    @Test
//    public void testLookInContextWithNullTag() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextBlockDefinition def = TextblockdefinitionFactory.eINSTANCE.createTextBlockDefinition();
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
//	TextBlockDefinition def = TextblockdefinitionFactory.eINSTANCE.createTextBlockDefinition();
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
//	TextBlockDefinition def = TextblockdefinitionFactory.eINSTANCE.createTextBlockDefinition();
//	ContextTemplate tmp = TCSFactory.eINSTANCE.createContextTemplate();
//
//	textBlock.setType(def);
//	def.setParseRule(tmp);
//	tmp.setIsContext(true);
//
//	EObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//
//	assertEquals(1, textBlock.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParent() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextBlockDefinition def = TextBlockDefinitionFactory.eINSTANCE.createTextBlockDefinition();
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
//	EObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//
//	assertEquals(1, child.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParentIsNotContext() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR)
//		.refCreateInstance();
//	TextBlockDefinition def2 = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR)
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
//	EObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	child.getElementsInContext().add(object);
//
//	assertEquals(0, child.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithTagWithElementInParentWithTag() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR)
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
//	EObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//
//	assertEquals(1, child.lookInContext("tag").size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParentWithUnion() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextBlockDefinition def = (TextBlockDefinition) connection.getClass(TextBlockDefinition.CLASS_DESCRIPTOR)
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
//	EObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	EObject object2 = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	textBlock.getElementsInContext().add(object);
//	child.getElementsInContext().add(object2);
//
//	assertEquals(2, child.lookInContext(null).size());
//    }
//
//    @Test
//    public void testLookInContextWithElementInParentWithUnionWithEmpty() {
//	TextBlock textBlock = this.modelFactory.createTextBlock();
//	TextBlockDefinition def = (TextBlockDefinition) TextblockdefinitionPackage.eINSTANCE.getTex.getClass(TextBlockDefinition.CLASS_DESCRIPTOR)
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
//	EObject object = connection.getClass(Student.CLASS_DESCRIPTOR).refCreateInstance();
//	child.getElementsInContext().add(object);
//
//	assertEquals(1, child.lookInContext(null).size());
//    }
//}
