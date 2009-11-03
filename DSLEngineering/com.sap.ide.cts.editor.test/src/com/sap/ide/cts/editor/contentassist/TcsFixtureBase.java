package com.sap.ide.cts.editor.contentassist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import tcs.Alternative;
import tcs.Block;
import tcs.ClassTemplate;
import tcs.ConditionalElement;
import tcs.CustomSeparator;
import tcs.FunctionCall;
import tcs.FunctionTemplate;
import tcs.Keyword;
import tcs.LiteralRef;
import tcs.ModeParg;
import tcs.Property;
import tcs.PropertyReference;
import tcs.Sequence;
import tcs.SequenceInAlternative;
import tcs.Symbol;

import com.sap.ide.cts.editor.test.util.StandaloneConnectionBasedTest;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class TcsFixtureBase extends StandaloneConnectionBasedTest {

	protected TcsModelElementFactory modelFactory;

	protected Keyword keywordA;
	protected Keyword keywordB;
	protected Symbol symbolA;
	protected Symbol symbolB;

	protected FunctionTemplate funcTemplate;
	protected Sequence funcTemplateSeq;
	protected LiteralRef funcTemplateLit;

	protected ClassTemplate abstractSequenceTemplate;

	protected ClassTemplate functionTemplateTemplateMode1;
	protected Sequence functionTemplateTemplateSeqMode1;
	protected LiteralRef functionTemplateTemplateLitMode1;

	protected ClassTemplate functionTemplateTemplateMode2;
	protected Sequence functionTemplateTemplateSeqMode2;
	protected LiteralRef functionTemplateTemplateLitMode2;

	protected ClassTemplate main;
	protected Sequence mainSeq;
	protected LiteralRef main1Lit;
	protected ConditionalElement main2Cond;
	protected Sequence main2CondThenSeq;
	protected LiteralRef main2CondThenLit;
	protected Property main3Prop;
	protected Alternative main4Alt;
	protected SequenceInAlternative main4AltCase1Seq;
	protected LiteralRef main4AltCase1Lit;
	protected CustomSeparator main4AltCase1CustomSeparator;
	protected SequenceInAlternative main4AltCase2Seq;
	protected LiteralRef main4AltCase2Lit;
	protected Block main5Block;
	protected Sequence main5BlockSeq;
	protected Property main5BlockProp;
	protected FunctionCall main6Call;
	protected LiteralRef main7Lit;
	protected FunctionCall main8Call;
	protected LiteralRef main9Lit;

	protected Map<List<String>, Map<String, ClassTemplate>> classTemplateMap;

	/**
	 * Initialize the fixture before each test is run.
	 * 
	 * @throws NameNotFoundException
	 * @throws JmiException
	 */
	@Before
	public void initFixture() throws JmiException, NameNotFoundException {
		modelFactory = new TcsModelElementMoinFactory(connection);
		createFixtureElements();
		initFixtureStructure();
		initClassTemplateMap();
	}

	private void createFixtureElements() {
		keywordA = modelFactory.createKeyword();
		keywordB = modelFactory.createKeyword();
		symbolA = modelFactory.createSymbol();
		symbolB = modelFactory.createSymbol();

		funcTemplate = modelFactory.createFunctionTemplate();
		funcTemplateSeq = modelFactory.createSequence();
		funcTemplateLit = modelFactory.createLiteralRef();

		abstractSequenceTemplate = modelFactory.createClassTemplate();

		functionTemplateTemplateMode1 = modelFactory.createClassTemplate();
		functionTemplateTemplateSeqMode1 = modelFactory.createSequence();
		functionTemplateTemplateLitMode1 = modelFactory.createLiteralRef();

		functionTemplateTemplateMode2 = modelFactory.createClassTemplate();
		functionTemplateTemplateSeqMode2 = modelFactory.createSequence();
		functionTemplateTemplateLitMode2 = modelFactory.createLiteralRef();

		main = modelFactory.createClassTemplate();
		mainSeq = modelFactory.createSequence();
		main1Lit = modelFactory.createLiteralRef();
		main2Cond = modelFactory.createConditionalElement();
		main2CondThenSeq = modelFactory.createSequence();
		main2CondThenLit = modelFactory.createLiteralRef();
		main3Prop = modelFactory.createProperty();
		main4Alt = modelFactory.createAlternative();
		main4AltCase1Seq = modelFactory.createSequenceInAlternative();
		main4AltCase1Lit = modelFactory.createLiteralRef();
		main4AltCase1CustomSeparator = modelFactory.createCustomSeparator();
		main4AltCase2Seq = modelFactory.createSequenceInAlternative();
		main4AltCase2Lit = modelFactory.createLiteralRef();
		main5Block = modelFactory.createBlock();
		main5BlockSeq = modelFactory.createSequence();
		main5BlockProp = modelFactory.createProperty();
		main6Call = modelFactory.createFunctionCall();
		main7Lit = modelFactory.createLiteralRef();
		main8Call = modelFactory.createFunctionCall();
		main9Lit = modelFactory.createLiteralRef();
	}

	private void initFixtureStructure() throws JmiException,
			NameNotFoundException {

		// funcTemplate
		// - funcTemplateSeq
		// - - funcTemplateLit

		// abstractTemplateTemplate -> for TCS.Template

		// functionTemplateTemplateMode1 #mode1 : abstractSequenceTemplate ->
		// for
		// TCS.FunctionTemplate
		// - functionTemplateTemplateSeqMode1
		// - - functionTemplateTemplateLitMode1

		// functionTemplateTemplateMode2 #mode2: abstractSequenceTemplate -> for
		// TCS.FunctionTemplate
		// - functionTemplateTemplateSeqMode2
		// - - functionTemplateTemplateLitMode2

		// main
		// - mainSeq
		// - - main1Lit
		// - - - ref: keywordA
		// - - main2Cond
		// - - - main2CondThenSeq
		// - - - - main2CondThenLit
		// - - - null
		// - - main3Prop -> TCS.Property.propertyReference.name (atomic)
		// - - main4Alt
		// - - - main4AltCase1Seq
		// - - - - main4AltCase1Lit
		// - - - - main4AltCase1CustomSeparator
		// - - - main4AltCase2Seq
		// - - - - main4AltCase2Lit
		// - - main5Block
		// - - - main5BlockSeq
		// - - - - main5BlockProp #mode2 -> TCS.ConcreteSyntax.templates (not
		// atomic)
		// - - main6Call
		// - - - ref:funcTemplate
		// - - main7Lit
		// - - main8Call
		// - - - ref:funcTemplate
		// - - main9Lit

		main.setMain(true);

		funcTemplate.setFunctionSequence(funcTemplateSeq);
		funcTemplateSeq.getElements().add(funcTemplateLit);

		abstractSequenceTemplate.getNames().add("Template");
		abstractSequenceTemplate.setAbstract(true);

		// look up through names
		functionTemplateTemplateMode1.getNames().add("FunctionTemplate");
		functionTemplateTemplateMode1.setMode("mode1");
		functionTemplateTemplateMode1
				.setTemplateSequence(functionTemplateTemplateSeqMode1);
		functionTemplateTemplateSeqMode1.getElements().add(
				functionTemplateTemplateLitMode1);

		// look up through metaReference.qualifiedName
		Classifier metaReference = modelFactory.createMofClass();
		metaReference.setName("FunctionTemplate");
		metaReference.getQualifiedName().add("FunctionTemplate");
		functionTemplateTemplateMode2.setMetaReference(metaReference);
		functionTemplateTemplateMode2.setMode("mode2");
		functionTemplateTemplateMode2
				.setTemplateSequence(functionTemplateTemplateSeqMode2);
		functionTemplateTemplateSeqMode2.getElements().add(
				functionTemplateTemplateLitMode2);

		main.setTemplateSequence(mainSeq);
		mainSeq.getElements().add(main1Lit);
		mainSeq.getElements().add(main2Cond);
		main2Cond.setThenSequence(main2CondThenSeq);
		main2CondThenSeq.getElements().add(main2CondThenLit);
		main2Cond.setElseSequence(null);
		mainSeq.getElements().add(main3Prop);
		mainSeq.getElements().add(main4Alt);
		main4Alt.getSequences().add(main4AltCase1Seq);
		main4AltCase1Seq.getElements().add(main4AltCase1Lit);
		main4AltCase1Seq.getElements().add(main4AltCase1CustomSeparator);
		main4Alt.getSequences().add(main4AltCase2Seq);
		main4AltCase2Seq.getElements().add(main4AltCase2Lit);
		mainSeq.getElements().add(main5Block);
		main5Block.setBlockSequence(main5BlockSeq);
		main5BlockSeq.getElements().add(main5BlockProp);
		mainSeq.getElements().add(main6Call);
		main6Call.setCalledFunction(funcTemplate);
		mainSeq.getElements().add(main7Lit);
		mainSeq.getElements().add(main8Call);
		main8Call.setCalledFunction(funcTemplate);
		mainSeq.getElements().add(main9Lit);

		keywordA.setValue("keywordA");
		keywordB.setValue("keywordB");
		symbolA.setValue("symbolA");
		symbolB.setValue("symbolB");

		funcTemplateLit.setReferredLiteral(keywordA);
		functionTemplateTemplateLitMode1.setReferredLiteral(symbolA);
		functionTemplateTemplateLitMode2.setReferredLiteral(symbolB);
		main1Lit.setReferredLiteral(keywordA);
		main2CondThenLit.setReferredLiteral(keywordA);
		main4AltCase1Lit.setReferredLiteral(keywordB);
		main4AltCase2Lit.setReferredLiteral(symbolB);
		main7Lit.setReferredLiteral(keywordA);
		main9Lit.setReferredLiteral(keywordB);

		// link main3Prop to TCS.Property.propertyReference.name attribute
		Classifier propReferenceClass = (Classifier) modelFactory
				.createPropertyRef().refMetaObject();
		setStrucfeature(main3Prop, (StructuralFeature) propReferenceClass
				.lookupElement("name"));

		// link main5BlockProp to TCS.ConcreteSyntax.templates reference
		Classifier concreteSyntaxClass = (Classifier) modelFactory
				.createConcreteSyntax().refMetaObject();
		setStrucfeature(main5BlockProp, (StructuralFeature) concreteSyntaxClass
				.lookupElement("templates"));

		// add modearg of main5BlockProp to "mode2"
		ModeParg modeArg = modelFactory.createModeParg();
		modeArg.setMode("mode2");
		main5BlockProp.getPropertyArgs().add(modeArg);

	}

	/**
	 * @param main3Prop2
	 * @param lookupElement
	 */
	protected void setStrucfeature(Property prop, TypedElement lookupElement) {
		PropertyReference propRef = modelFactory.createPropertyRef();
		prop.setPropertyReference(propRef);
		propRef.setStrucfeature(lookupElement);
	}

	private void initClassTemplateMap() {
		classTemplateMap = new HashMap<List<String>, Map<String, ClassTemplate>>();

		Map<String, ClassTemplate> modeMap = new HashMap<String, ClassTemplate>();
		List<String> key = new ArrayList<String>();

		key.add("TCS");
		key.add("Template");

		modeMap.put(null, abstractSequenceTemplate);
		classTemplateMap.put(key, modeMap);

		modeMap = new HashMap<String, ClassTemplate>();
		key = new ArrayList<String>();

		key.add("TCS");
		key.add("FunctionTemplate");

		modeMap.put("mode1", functionTemplateTemplateMode1);
		modeMap.put("mode2", functionTemplateTemplateMode2);

		classTemplateMap.put(key, modeMap);
	}

	@Test
	public void testFixtureStructure() {
		// TODO: implement
	}

}
