package com.sap.furcas.runtime.textblocks.testbase;

import org.junit.Before;

import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public abstract class TextBlockTest {

    protected TextBlocksModelElementFactory modelFactory;

    @Before
    public void setModelFactory() {
	modelFactory = new EMFTextBlocksModelElementFactory();
    }
}
