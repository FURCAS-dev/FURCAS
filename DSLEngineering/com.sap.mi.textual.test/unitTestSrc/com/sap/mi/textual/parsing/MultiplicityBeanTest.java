/**
 * 
 */
package com.sap.mi.textual.parsing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sap.furcas.textual.common.interfaces.MultiplicityBean;

/**
 *
 */
public class MultiplicityBeanTest {

    /**
     * Test method for {@link com.sap.mi.textual.interfaces.MultiplicityBean#isOptional()}.
     */
    @Test
    public void testIsOptional() {
        MultiplicityBean bean = new MultiplicityBean();
        assertFalse(bean.isOptional());
        bean.setLowerBound(-1);
        assertTrue(bean.isOptional());
        bean.setLowerBound(0);
        assertTrue(bean.isOptional());
        bean.setLowerBound(1);
        assertFalse(bean.isOptional());
        bean.setLowerBound(2);
        assertFalse(bean.isOptional());
        bean.setLowerBound(3);
        assertFalse(bean.isOptional());
    }
    
    /**
     * Test method for {@link com.sap.mi.textual.interfaces.MultiplicityBean#isMultiple()}.
     */
    @Test
    public void testgetUpper() {
        MultiplicityBean bean = new MultiplicityBean();
        assertEquals(1, bean.getUpperBound());
        bean.setUpperBound(-1);
        assertEquals(-1, bean.getUpperBound());
        bean.setUpperBound(2);
        assertEquals(2, bean.getUpperBound());
        bean.setUpperBound(3);
        assertEquals(3, bean.getUpperBound());
        bean.setUpperBound(4);
        assertEquals(4, bean.getUpperBound());
        bean.setUpperBound(1);
        assertEquals(1, bean.getUpperBound());
    }

    /**
     * Test method for {@link com.sap.mi.textual.interfaces.MultiplicityBean#isMultiple()}.
     */
    @Test
    public void testgetLower() {
        MultiplicityBean bean = new MultiplicityBean();
        assertEquals(1, bean.getLowerBound());
        bean.setLowerBound(-1);
        assertEquals(-1, bean.getLowerBound());
        bean.setLowerBound(2);
        assertEquals(2, bean.getLowerBound());
        bean.setLowerBound(3);
        assertEquals(3, bean.getLowerBound());
        bean.setLowerBound(4);
        assertEquals(4, bean.getLowerBound());
        bean.setLowerBound(1);
        assertEquals(1, bean.getLowerBound());
    }

    /**
     * Test method for {@link com.sap.mi.textual.interfaces.MultiplicityBean#isMultiple()}.
     */
    @Test
    public void testIsUnbounded() {
        MultiplicityBean bean = new MultiplicityBean();
        assertFalse(bean.isMultiple());
        bean.setUpperBound(-1);
        assertTrue(bean.isMultiple());
        bean.setUpperBound(2);
        assertTrue(bean.isMultiple());
        bean.setUpperBound(3);
        assertTrue(bean.isMultiple());
        bean.setUpperBound(4);
        assertTrue(bean.isMultiple());
        bean.setUpperBound(1);
        assertFalse(bean.isMultiple());
    }

    /**
     * Test method for {@link java.lang.Object#hashCode()}.
     */
    @Test
    public void testHashCode() {
        MultiplicityBean bean1 = new MultiplicityBean();
        int hash1 = bean1.hashCode();
        bean1.setLowerBound(0);
        assertNotSame(hash1, bean1.hashCode());
        bean1.setLowerBound(1);
        assertEquals(hash1, bean1.hashCode());
        bean1.setUpperBound(-1);
        assertNotSame(hash1, bean1.hashCode());
        bean1.setUpperBound(1);
        assertEquals(hash1, bean1.hashCode());
    }

    /**
     * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
     */
    @Test
    public void testEquals() {
        MultiplicityBean bean1 = new MultiplicityBean();
        MultiplicityBean bean2 = new MultiplicityBean();
        assertEquals(bean1, bean2);
        
        bean1.setLowerBound(0);
        assertNotSame(bean1, bean2);
        bean2.setLowerBound(0);
        assertEquals(bean1, bean2);
        
        bean1.setLowerBound(1);
        assertNotSame(bean1, bean2);
        bean2.setLowerBound(1);
        assertEquals(bean1, bean2);
        
        bean1.setUpperBound(-1);
        assertNotSame(bean1, bean2);
        bean2.setUpperBound(-1);
        assertEquals(bean1, bean2);
        
        bean1.setUpperBound(1);
        assertNotSame(bean1, bean2);
        bean2.setUpperBound(1);
        assertEquals(bean1, bean2);

        
        assertNotSame(bean1, null);
        assertNotSame(bean1, "Test");
    }
    
    @Test
    public void testToString() {
        MultiplicityBean bean1 = new MultiplicityBean();
        assertEquals(bean1.getClass().getName() + "@" + Integer.toHexString(bean1.hashCode()) + "(1,1)", bean1.toString());
    }
    
}
