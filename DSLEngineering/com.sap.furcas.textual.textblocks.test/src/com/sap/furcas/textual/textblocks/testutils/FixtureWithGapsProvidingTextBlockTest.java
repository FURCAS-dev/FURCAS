package com.sap.furcas.textual.textblocks.testutils;

import org.junit.Before;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members. This Variant sets
 * up a fixture having gaps between the tokens.
 * 
 * @author D052602
 * 
 */
public class FixtureWithGapsProvidingTextBlockTest extends TextBlockTest {

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
	// text = "   aaaaa   * bbbbcccc     +     ddddd   "
	// blanks are merely represented by distance between tokens, no blank
	// tokens are being used
	// TextBlock Tree =
	// main
	// - bos
	// - virtual gap of 3 blanks
	// - left
	// - - leftleft
	// - - - lexed1 "aaaaa"
	// - - - virtual gap of 3 blanks
	// - lexed2 "*"
	// - virtual gap of 1 blank
	// - middle
	// - - lexed3 "bbbbcccc"
	// - - virtual gap of 1 blank
	// - - subBlock1
	// - - - virtual gap of 1 blank
	// - - - subBlock2
	// - - - - virtual gap of 1 blank
	// - - - - subBlock3
	// - - - - virtual gap of 1 blank
	// - - - - - subBlock4
	// - - - - - - virtual gap of 1 blank
	// - - - - - - subToken "+"
	// - - - - - - virtual gap of 1 blank
	// - - - - - virtual gap of 1 blank
	// - - - - virtual gap of 1 blank
	// - - - virtual gap of 1 blank
	// - - virtual gap of 1 blank
	// - right
	// - - lexed4 "ddddd"
	// - virtual gap of 3 blanks
	// - eos

	main.getSubNodes().add(bos);
	main.getSubNodes().add(left);
	main.getSubNodes().add(lexed2);
	main.getSubNodes().add(middle);
	main.getSubNodes().add(right);
	main.getSubNodes().add(eos);
	left.getSubNodes().add(leftLeft);
	leftLeft.getSubNodes().add(lexed1);
	middle.getSubNodes().add(lexed3);
	middle.getSubNodes().add(subBlock1);
	subBlock1.getSubNodes().add(subBlock2);
	subBlock2.getSubNodes().add(subBlock3);
	subBlock3.getSubNodes().add(subBlock4);
	subBlock4.getSubNodes().add(subToken);
	right.getSubNodes().add(lexed4);
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

	main.setCachedString("   aaaaa   * bbbbcccc     +     ddddd   ");
    }

    /**
     * Initialize the model elements lengths.
     */
    private void initFixtureLenghts() {
	main.setLength(40);
	bos.setLength(0);
	left.setLength(8);
	leftLeft.setLength(8);
	lexed1.setLength(5);
	lexed2.setLength(1);
	middle.setLength(19);
	lexed3.setLength(8);
	subBlock1.setLength(9);
	subBlock2.setLength(7);
	subBlock3.setLength(5);
	subBlock4.setLength(3);
	subToken.setLength(1);
	right.setLength(8);
	lexed4.setLength(5);
	eos.setLength(0);
    }

    /**
     * Initialize the model elements offsets.
     */
    private void initFixtureOffsets() {

	main.setOffset(0);
	bos.setOffset(0);
	left.setOffset(3);
	leftLeft.setOffset(0);
	lexed1.setOffset(0);
	lexed2.setOffset(11);
	middle.setOffset(13);
	lexed3.setOffset(0);
	subBlock1.setOffset(9);
	subBlock2.setOffset(1);
	subBlock3.setOffset(1);
	subBlock4.setOffset(1);
	subToken.setOffset(1);
	right.setOffset(32);
	lexed4.setOffset(0);
	eos.setOffset(40);

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
	main.setVersion(Version.REFERENCE);
	bos.setVersion(Version.REFERENCE);
	left.setVersion(Version.REFERENCE);
	leftLeft.setVersion(Version.REFERENCE);
	lexed1.setVersion(Version.REFERENCE);
	lexed2.setVersion(Version.REFERENCE);
	middle.setVersion(Version.REFERENCE);
	lexed3.setVersion(Version.REFERENCE);
	subBlock1.setVersion(Version.REFERENCE);
	subBlock2.setVersion(Version.REFERENCE);
	subBlock3.setVersion(Version.REFERENCE);
	subBlock4.setVersion(Version.REFERENCE);
	subToken.setVersion(Version.REFERENCE);
	right.setVersion(Version.REFERENCE);
	lexed4.setVersion(Version.REFERENCE);
	eos.setVersion(Version.REFERENCE);
    }

}
