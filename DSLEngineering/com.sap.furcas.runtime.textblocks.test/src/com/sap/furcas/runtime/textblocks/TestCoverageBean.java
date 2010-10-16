/**
 * 
 */
package com.sap.furcas.runtime.textblocks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sap.furcas.runtime.textblocks.CoverageBean;

/**
 * 
 */
public class TestCoverageBean {

    @Test
    public void testCoverageBefore() {
	CoverageBean bean = CoverageBean.getCoverageBean(0, 0, 1, 1);
	assertFalse(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(0, 0, 0, 0);
	assertFalse(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(0, 1, 1, 2);
	assertFalse(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(0, 1, 6, 8);
	assertFalse(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());
    }

    @Test
    public void testCoverageAfter() {
	CoverageBean bean = CoverageBean.getCoverageBean(1, 3, 0, 0);
	assertFalse(bean.isCovered());
	assertTrue(bean.isNodeEndsLater());
	assertTrue(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(6, 9, 0, 5);
	assertFalse(bean.isCovered());
	assertTrue(bean.isNodeEndsLater());
	assertTrue(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());
    }

    @Test
    public void testCoverageOverlapLeft() {
	CoverageBean bean = CoverageBean.getCoverageBean(0, 1, 0, 2);
	assertTrue(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(0, 5, 4, 6);
	assertTrue(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());
    }

    @Test
    public void testCoverageInsideOvLeft() {
	CoverageBean bean = CoverageBean.getCoverageBean(0, 1, 0, 2);
	assertTrue(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(0, 5, 4, 6);
	assertTrue(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertFalse(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());
    }

    @Test
    public void testCoverageReallyInside() {
	CoverageBean bean = CoverageBean.getCoverageBean(4, 5, 0, 8);
	assertTrue(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertTrue(bean.isNodeStartsLater());
	assertTrue(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(1, 5, 0, 6);
	assertTrue(bean.isCovered());
	assertFalse(bean.isNodeEndsLater());
	assertTrue(bean.isNodeStartsLater());
	assertTrue(bean.isNodeRealInside());
    }

    @Test
    public void testCoverageOvRight() {
	CoverageBean bean = CoverageBean.getCoverageBean(4, 10, 0, 4);
	assertTrue(bean.isCovered());
	assertTrue(bean.isNodeEndsLater());
	assertTrue(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());

	bean = CoverageBean.getCoverageBean(5, 10, 0, 6);
	assertTrue(bean.isCovered());
	assertTrue(bean.isNodeEndsLater());
	assertTrue(bean.isNodeStartsLater());
	assertFalse(bean.isNodeRealInside());
    }

}
