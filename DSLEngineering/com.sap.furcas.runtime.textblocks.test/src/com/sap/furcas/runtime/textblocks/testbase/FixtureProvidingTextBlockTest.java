package com.sap.furcas.runtime.textblocks.testbase;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;

import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public abstract class FixtureProvidingTextBlockTest extends TextBlockTest {

    protected Resource resource = TextblocksTestHelper.createTransientResource();
    
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
	// text = "aaaaa*bbbbcccc+ddddd"
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

	resource.getContents().add(main);
	
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
