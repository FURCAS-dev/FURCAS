package com.sap.ide.cts.editor.contentassist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

import tcs.Alternative;
import tcs.Block;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.ConditionalElement;
import tcs.CreateAsParg;
import tcs.FunctionCall;
import tcs.FunctionTemplate;
import tcs.LiteralRef;
import tcs.Property;
import tcs.RefersToParg;
import tcs.SeparatorParg;
import tcs.Sequence;
import tcs.SequenceElement;
import tcs.SequenceInAlternative;
import tcs.Template;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

public class TestTcsUtil extends TcsFixtureBase {

	@Test
	public void testContainsRefersToArg() {
		RefersToParg refersToArg = modelFactory.createRefersToParg();
		CreateAsParg createAsArg = modelFactory.createCreateAsParg();

		Property withRefersToArg = modelFactory.createProperty();
		withRefersToArg.getPropertyArgs().add(refersToArg);

		Property withoutRefersToArg = modelFactory.createProperty();
		withoutRefersToArg.getPropertyArgs().add(createAsArg);

		assertEquals(true, TcsUtil.containsRefersToArg(withRefersToArg));
		assertEquals(false, TcsUtil.containsRefersToArg(withoutRefersToArg));
	}

	@Test
	public void testGetPossibleAtomicFollowsMain1Lit() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		// main2Cond then branch
		expected.add(main2CondThenLit);
		// main2Cond else branch
		expected.add(null);
		// main3Prop, as main2Cond else branch is null
		expected.add(main3Prop);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(main1Lit, null,
				null, null, false, null));
	}

	@Test
	public void testGetPossibleAtomicFollowsMain2CondThenLit() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		expected.add(main3Prop);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(
				main2CondThenLit, null, null, null, false, null));
	}

	@Test
	public void testGetPossibleAtomicFollowsMain3Prop() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(main4AltCase1Lit);
		expected.add(main4AltCase2Lit);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(main3Prop,
				null, null, null, false, null));
	}

	@Test
	public void testGetPossibleAtomicFollowsMain4AltCase1Lit() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		// from CustomSeparator
		expected.add(null);
		// multivalued property can be null
		expected.add(null);
		// only mode2
		expected.add(functionTemplateTemplateLitMode2);

		expected.add(funcTemplateLit);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(
				main4AltCase1Lit, null, classTemplateMap, null, false, null));
	}

	@Test
	public void testGetPossibleAtomicFollowsMain5BlockProp() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		// add main5BlockProp Tokens, as it is a multi-valued Property
		// also add null, as no value is possible
		expected.add(null);
		// only mode2
		expected.add(functionTemplateTemplateLitMode2);

		expected.add(funcTemplateLit);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(main5BlockProp,
				null, classTemplateMap, null, false, null));
	}

	@Test
	public void testGetPossibleAtomicFollowsFuncTemplateLitInMain6Call() {

		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		expected.add(main7Lit);

		Stack<FunctionCall> parentFunctionCallStack = new Stack<FunctionCall>();
		parentFunctionCallStack.push(main6Call);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(
				funcTemplateLit, parentFunctionCallStack, null, null, false,
				null));
	}

	@Test
	public void testGetPossibleAtomicFollowsMain7Lit() {

		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		expected.add(funcTemplateLit);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(main7Lit, null,
				null, null, false, null));
	}

	@Test
	public void testGetPossibleAtomicFollowsFuncTemplateLitInMain8Call() {

		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		expected.add(main9Lit);

		Stack<FunctionCall> parentFunctionCallStack = new Stack<FunctionCall>();
		parentFunctionCallStack.push(main8Call);

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(
				funcTemplateLit, parentFunctionCallStack, null, null, false,
				null));
	}

	@Test
	public void testGetPossibleAtomicFollowsNull() {

		List<SequenceElement> expected = new ArrayList<SequenceElement>();

		assertEquals(expected, TcsUtil.getPossibleAtomicFollows(null, null,
				null, null, false, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementMain1Lit() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(main1Lit);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				main1Lit, null, visitedTemplates, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementMain2Cond() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(main2CondThenLit);
		expected.add(null);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				main2Cond, null, visitedTemplates, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementMain3Prop() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(main3Prop);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				main3Prop, null, visitedTemplates, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementMain4Alt() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(main4AltCase1Lit);
		expected.add(main4AltCase2Lit);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				main4Alt, null, visitedTemplates, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementMain5Block() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		// multivalued property can be null
		expected.add(null);
		// only mode2
		expected.add(functionTemplateTemplateLitMode2);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				main5Block, classTemplateMap, visitedTemplates, null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementMain5BlockNullClassTemplateMap() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(functionTemplateTemplateLitMode1);
		expected.add(functionTemplateTemplateLitMode2);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				main5Block, null, visitedTemplates, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequenceElementNull() {
		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(null);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				(SequenceElement) null, null, visitedTemplates, null));
	}

	@Test
	public void testGetPossibleFirstAtomicSequenceElementsSequence() {
		Sequence s = modelFactory.createSequence();

		ConditionalElement condA = modelFactory.createConditionalElement();
		Sequence condASeq = modelFactory.createSequence();
		LiteralRef condASeqLit = modelFactory.createLiteralRef();
		condASeq.getElements().add(condASeqLit);
		condA.setThenSequence(condASeq);

		ConditionalElement condB = modelFactory.createConditionalElement();
		Sequence condBSeq = modelFactory.createSequence();
		LiteralRef condBSeqLit = modelFactory.createLiteralRef();
		condBSeq.getElements().add(condBSeqLit);
		condB.setThenSequence(condBSeq);

		s.getElements().add(condA);
		s.getElements().add(condB);

		List<SequenceElement> expected = new ArrayList<SequenceElement>();
		expected.add(condASeqLit);
		expected.add(null);
		expected.add(condBSeqLit);
		expected.add(null);

		Set<Template> visitedTemplates = new HashSet<Template>();

		assertEquals(expected, TcsUtil.getPossibleFirstAtomicSequenceElements(
				s, null, visitedTemplates, null));
	}

	@Test
	public void testGetFirstSequenceElement() {
		assertEquals(main1Lit, TcsUtil.getFirstSequenceElement(mainSeq));
		assertEquals(main2CondThenLit, TcsUtil
				.getFirstSequenceElement(main2CondThenSeq));

		// no elements
		Sequence testSeq = modelFactory.createSequence();
		assertEquals(null, TcsUtil.getFirstSequenceElement(testSeq));

		// sequence null
		assertEquals(null, TcsUtil.getFirstSequenceElement(null));

	}

	@Test
	public void testIsLastSequenceElement() {
		// null should never be last
		assertEquals(false, TcsUtil.isLastSequenceElement(null));

		assertEquals(false, TcsUtil.isLastSequenceElement(main1Lit));
		assertEquals(false, TcsUtil.isLastSequenceElement(main4Alt));

		assertEquals(true, TcsUtil.isLastSequenceElement(main9Lit));
		assertEquals(true, TcsUtil.isLastSequenceElement(main2CondThenLit));
	}

	@Test
	public void testGetNextSequenceElement() {
		assertEquals(main2Cond, TcsUtil.getNextSequenceElement(main1Lit));
		assertEquals(main5Block, TcsUtil.getNextSequenceElement(main4Alt));

		// last element
		assertEquals(null, TcsUtil.getNextSequenceElement(main9Lit));
		assertEquals(null, TcsUtil.getNextSequenceElement(main2CondThenLit));

		// parent null
		LiteralRef testElem = modelFactory.createLiteralRef();
		assertEquals(null, TcsUtil.getNextSequenceElement(testElem));

		assertEquals(null, TcsUtil.getNextSequenceElement(null));
	}

	@Test
	public void testGetParentSequenceElementBlock() {
		Block block = modelFactory.createBlock();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		block.setBlockSequence(sequence);

		assertEquals(block, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test
	public void testGetParentSequenceElementConditionalThen() {
		ConditionalElement cond = modelFactory.createConditionalElement();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		cond.setThenSequence(sequence);

		assertEquals(cond, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test
	public void testGetParentSequenceElementConditionalElse() {
		ConditionalElement cond = modelFactory.createConditionalElement();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		cond.setElseSequence(sequence);

		assertEquals(cond, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test
	public void testGetParentSequenceElementAlternative() {
		Alternative alt = modelFactory.createAlternative();
		SequenceInAlternative sequence = modelFactory
				.createSequenceInAlternative();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		alt.getSequences().add(sequence);

		assertEquals(alt, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test
	public void testGetParentSequenceElementPropery() {
		Property prop = modelFactory.createProperty();
		SeparatorParg sepArg = modelFactory.createSeparatorParg();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		sepArg.setSeparatorSequence(sequence);
		prop.getPropertyArgs().add(sepArg);

		assertEquals(prop, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test
	public void testGetParentSequenceElementFunctionTemplate() {
		FunctionCall call = modelFactory.createFunctionCall();
		FunctionTemplate template = modelFactory.createFunctionTemplate();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		template.setFunctionSequence(sequence);
		call.setCalledFunction(template);

		Stack<FunctionCall> parentFunctionCallStack = new Stack<FunctionCall>();
		parentFunctionCallStack.push(call);

		assertEquals(call, TcsUtil.getParentSequenceElement(property,
				parentFunctionCallStack, null, classTemplateMap));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetParentSequenceElementFunctionTemplateNull() {
		FunctionCall call = modelFactory.createFunctionCall();
		FunctionTemplate template = modelFactory.createFunctionTemplate();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		template.setFunctionSequence(sequence);
		call.setCalledFunction(template);

		assertEquals(call, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetParentSequenceElementFunctionTemplateInvalidParentTemplate() {
		FunctionCall call = modelFactory.createFunctionCall();
		FunctionCall invalidCall = modelFactory.createFunctionCall();
		FunctionTemplate template = modelFactory.createFunctionTemplate();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		template.setFunctionSequence(sequence);
		call.setCalledFunction(template);

		Stack<FunctionCall> parentFunctionCallStack = new Stack<FunctionCall>();
		parentFunctionCallStack.push(invalidCall);

		assertEquals(call, TcsUtil.getParentSequenceElement(property,
				parentFunctionCallStack, null, classTemplateMap));
	}

	@Test
	public void testGetParentSequenceElementClassTemplate() {
		ClassTemplate template = modelFactory.createClassTemplate();
		Sequence sequence = modelFactory.createSequence();
		Property property = modelFactory.createProperty();

		sequence.getElements().add(property);
		template.setTemplateSequence(sequence);

		assertEquals(null, TcsUtil.getParentSequenceElement(property, null,
				null, classTemplateMap));
	}

	@Test
	public void testGetMainClassTemplate() {
		ConcreteSyntax syntax = modelFactory.createConcreteSyntax();
		syntax.getTemplates().add(main);
		syntax.getTemplates().add(functionTemplateTemplateMode1);
		syntax.getTemplates().add(functionTemplateTemplateMode2);

		assertEquals(main, TcsUtil.getMainClassTemplate(syntax));
	}

	@Test
	public void testGetTcsSyntax() {
		// revert connection, because syntax creation does not work with fixture
		// concrete syntax present on connection
		connection.revert();

		// as we use a transient no-project connection, we need to make sure the
		// correct ConcreteSyntax mapping
		// exists on the connection
		ConcreteSyntax tcsSyntax = TcsTestHelper
				.createTcsSyntaxMappingOnConnection(connection);

		ConcreteSyntax syntax = TcsUtil.getTcsSyntax(connection);

		// TODO more asserts, especially after some way of identifying the
		// build-in TCS Syntax has been introduced

		assertEquals(tcsSyntax, syntax);
	}

	@Test
	public void testCreateClassTemplateMap() {
		// revert connection, because syntax creation does not work with fixture
		// concrete syntax present on connection
		connection.revert();

		ConcreteSyntax tcsSyntax = TcsTestHelper
				.createTcsSyntaxMappingOnConnection(connection);

		Map<List<String>, Map<String, ClassTemplate>> classTemplateMap = TcsUtil
				.createClassTemplateMap(tcsSyntax);

		List<String> key = new ArrayList<String>();
		key.add("TCS"); // package
		key.add("ConcreteSyntax"); // typename

		assertNotNull(classTemplateMap.get(key));
		// mode is null
		assertNotNull(classTemplateMap.get(key).get(null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateClassTemplateMapNullSyntax() {
		TcsUtil.createClassTemplateMap(null);
	}

	@Test
	public void testIsMultiValued() {
		Property multi1Prop = modelFactory.createProperty();
		StructuralFeature multi1Struc = modelFactory.createReference();
		multi1Struc.setMultiplicity(modelFactory.createMultiplicityType(0, -1,
				false, false));
		setStrucfeature(multi1Prop, multi1Struc);

		assertEquals(true, TcsUtil.isMultiValued(multi1Prop));

		Property multi2Prop = modelFactory.createProperty();
		StructuralFeature multi2Struc = modelFactory.createAttribute();
		multi2Struc.setMultiplicity(modelFactory.createMultiplicityType(0, 2,
				false, false));
		setStrucfeature(multi2Prop, multi2Struc);

		assertEquals(true, TcsUtil.isMultiValued(multi2Prop));

		Property singleProp = modelFactory.createProperty();
		StructuralFeature singleStruc = modelFactory.createReference();
		singleStruc.setMultiplicity(modelFactory.createMultiplicityType(0, 1,
				false, false));
		setStrucfeature(singleProp, singleStruc);

		assertEquals(false, TcsUtil.isMultiValued(singleProp));

	}
}
