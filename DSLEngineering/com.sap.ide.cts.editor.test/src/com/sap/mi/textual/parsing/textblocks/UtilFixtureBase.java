package com.sap.mi.textual.parsing.textblocks;

import org.eclipse.emf.ecore.EEnum;
import org.junit.Before;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public class UtilFixtureBase extends TextBlockTest {
    

	protected TextBlock main;
	protected TextBlock left;
	protected TextBlock leftLeft;
	protected TextBlock middle;
	protected TextBlock right;
	protected TextBlock subBlock1;
	protected TextBlock subBlock2;
	protected TextBlock subBlock3;
	protected TextBlock subBlock4;
	protected Bostoken bos;
	protected Eostoken eos;
	protected LexedToken lexed1;
	protected LexedToken lexed2;
	protected LexedToken lexed3;
	protected LexedToken lexed4;

	protected LexedToken subToken;

	/**
	 * Initialize the fixture before each test is run.
	 */
	@Before
	public void initFixture() {
		createFixtureElements();
		initFixtureStructure();
		initFixtureValues();
		initFixtureLenghts();
		initFixtureOffsets();
		initFixtureVersions();
	}

	/**
	 * Create all elements of the standard fixture.
	 */
	private void createFixtureElements() {
		main = modelFactory.createTextBlock();
		left = modelFactory.createTextBlock();
		leftLeft = modelFactory.createTextBlock();
		middle = modelFactory.createTextBlock();
		right = modelFactory.createTextBlock();
		subBlock1 = modelFactory.createTextBlock();
		subBlock2 = modelFactory.createTextBlock();
		subBlock3 = modelFactory.createTextBlock();
		subBlock4 = modelFactory.createTextBlock();
		bos = modelFactory.createBostoken();
		eos = modelFactory.createEostoken();
		lexed1 = modelFactory.createLexedToken();
		lexed2 = modelFactory.createLexedToken();
		lexed3 = modelFactory.createLexedToken();
		lexed4 = modelFactory.createLexedToken();
		subToken = modelFactory.createLexedToken();
	}

	/**
	 * Initialize standard fixture structure.
	 */
	private void initFixtureStructure() {
	    // text =  "aaaaa*bbbbcccc+ddddd"
	    // TextBlock Tree =
	    // main
	    // - bos
	    // - left
	    // - - leftleft
	    // - - - lexed1 "aaaaa"
	    // - lexed2 "*"
	    // - middle
	    // - - lexed3 "bbbbcccc"
	    // - - subBlock1
	    // - - - subBlock2
	    // - - - - subBlock3
	    // - - - - - subBlock4
	    // - - - - - - subToken "+"
	    // - right
	    // - - lexed4 "ddddd"
	    // - eos

		main.getTokens().add(bos);
		main.getSubBlocks().add(left);
		main.getTokens().add(lexed2);
		main.getSubBlocks().add(middle);
		main.getSubBlocks().add(right);
		main.getTokens().add(eos);
		left.getSubBlocks().add(leftLeft);
		leftLeft.getTokens().add(lexed1);
		middle.getTokens().add(lexed3);
		middle.getSubBlocks().add(subBlock1);
		subBlock1.getSubBlocks().add(subBlock2);
		subBlock2.getSubBlocks().add(subBlock3);
		subBlock3.getSubBlocks().add(subBlock4);
		subBlock4.getTokens().add(subToken);
		right.getTokens().add(lexed4);

	}

	

	/**
	 * Initialize the model elements values.
	 */
	private void initFixtureValues() {
		lexed1.setValue("aaaaa");
		lexed2.setValue("*");
		lexed3.setValue("bbbbcccc");
		subToken.setValue("+");
		lexed4.setValue("ddddd");

		// also set cached values in tokens
		leftLeft.setCachedString("aaaaa");
		left.setCachedString("aaaaa");
		subBlock4.setCachedString("+");
		subBlock3.setCachedString("+");
		subBlock2.setCachedString("+");
		subBlock1.setCachedString("+");
		middle.setCachedString("bbbbcccc+");
		right.setCachedString("ddddd");
		main.setCachedString("aaaaa*bbbbcccc+ddddd");
	}


	/**
	 * Initialize the model elements lengths.
	 */
	private void initFixtureLenghts() {
		main.setLength(20);
		bos.setLength(0);
		left.setLength(5);
		leftLeft.setLength(5);
		lexed1.setLength(5);
		lexed2.setLength(1);
		middle.setLength(9);
		lexed3.setLength(8);
		subBlock1.setLength(1);
		subBlock2.setLength(1);
		subBlock3.setLength(1);
		subBlock4.setLength(1);
		subToken.setLength(1);
		right.setLength(5);
		lexed4.setLength(5);
		eos.setLength(0);
	}




	/**
	 * Initialize the model elements offsets.
	 */
	private void initFixtureOffsets() {
		main.setOffset(0);
		bos.setOffset(0);
		left.setOffset(0);
		leftLeft.setOffset(0);
		lexed1.setOffset(0);
		lexed2.setOffset(5);
		middle.setOffset(6);
		lexed3.setOffset(0);
		subBlock1.setOffset(8);
		subBlock2.setOffset(0);
		subBlock3.setOffset(0);
		subBlock4.setOffset(0);
		subToken.setOffset(0);
		right.setOffset(15);
		lexed4.setOffset(0);
		eos.setOffset(20);

		main.setOffsetRelative(true);
		bos.setOffsetRelative(true);
		left.setOffsetRelative(true);
		leftLeft.setOffsetRelative(true);
		lexed1.setOffsetRelative(true);
		lexed2.setOffsetRelative(true);
		middle.setOffsetRelative(true);
		lexed3.setOffsetRelative(true);
		subBlock1.setOffsetRelative(true);
		subBlock2.setOffsetRelative(true);
		subBlock3.setOffsetRelative(true);
		subBlock4.setOffsetRelative(true);
		subToken.setOffsetRelative(true);
		right.setOffsetRelative(true);
		lexed4.setOffsetRelative(true);
		eos.setOffsetRelative(true);
	}

	

	/**
	 * Initialize the model elements versions.
	 */
	private void initFixtureVersions() {
		main.setVersion(EEnum.REFERENCE);
		bos.setVersion(EEnum.REFERENCE);
		left.setVersion(EEnum.REFERENCE);
		leftLeft.setVersion(EEnum.REFERENCE);
		lexed1.setVersion(EEnum.REFERENCE);
		lexed2.setVersion(EEnum.REFERENCE);
		middle.setVersion(EEnum.REFERENCE);
		lexed3.setVersion(EEnum.REFERENCE);
		subBlock1.setVersion(EEnum.REFERENCE);
		subBlock2.setVersion(EEnum.REFERENCE);
		subBlock3.setVersion(EEnum.REFERENCE);
		subBlock4.setVersion(EEnum.REFERENCE);
		subToken.setVersion(EEnum.REFERENCE);
		right.setVersion(EEnum.REFERENCE);
		lexed4.setVersion(EEnum.REFERENCE);
		eos.setVersion(EEnum.REFERENCE);
	}
	
 
}
