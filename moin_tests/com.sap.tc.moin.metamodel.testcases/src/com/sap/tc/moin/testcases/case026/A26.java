/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcases.case026;

/**
 * This interface is not intended to be implemented by clients.
 */
public interface A26 extends com.sap.tc.moin.repository.mmi.reflect.RefObject {

    /**
     * Descriptors for all features of this MofClass and its supertypes.
     */
    public static final Descriptors DESCRIPTORS = new Descriptors( );

    // class extent descriptor
    /**
     * Extent descriptor
     */
    public final com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<com.sap.tc.moin.repository.mmi.reflect.RefClass, com.sap.tc.moin.testcases.case026.A26> CLASS_DESCRIPTOR = new com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<com.sap.tc.moin.repository.mmi.reflect.RefClass, com.sap.tc.moin.testcases.case026.A26>("48B56701E13930D2744511DDA0DF0019992F8D38", "test.sap.com/tc/moin/metamodel/testcases", "testcases", "case026", "A26"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ 

    
    // attributes
    public com.sap.tc.moin.repository.mmi.reflect.RefObject getReflectToOne() throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public void setReflectToOne(com.sap.tc.moin.repository.mmi.reflect.RefObject newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public java.util.List<com.sap.tc.moin.repository.mmi.reflect.RefObject> getReflectToMany() throws com.sap.tc.moin.repository.mmi.reflect.JmiException;


    public static final class Descriptors {
        Descriptors( ) { 
        }
        private com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case026.A26,com.sap.tc.moin.repository.mmi.reflect.RefObject> __reflectToOne;
        /**
         * Returns the descriptor for the <code>reflectToOne</code> attribute.
         * @return  the descriptor for the <code>reflectToOne</code> attribute
         */
        public synchronized com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case026.A26,com.sap.tc.moin.repository.mmi.reflect.RefObject> REFLECT_TO_ONE( ) {
            if ( __reflectToOne == null ) {
                __reflectToOne = new com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case026.A26,com.sap.tc.moin.repository.mmi.reflect.RefObject>( "48B56701E13930D0744511DDA3AE0019992F8D38", "test.sap.com/tc/moin/metamodel/testcases", new java.lang.String[] { "testcases", "case026", "A26", "reflectToOne" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ 
            }
            return __reflectToOne;
        }
        private com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case026.A26,java.util.List<com.sap.tc.moin.repository.mmi.reflect.RefObject>> __reflectToMany;
        /**
         * Returns the descriptor for the <code>reflectToMany</code> attribute.
         * @return  the descriptor for the <code>reflectToMany</code> attribute
         */
        public synchronized com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case026.A26,java.util.List<com.sap.tc.moin.repository.mmi.reflect.RefObject>> REFLECT_TO_MANY( ) {
            if ( __reflectToMany == null ) {
                __reflectToMany = new com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case026.A26,java.util.List<com.sap.tc.moin.repository.mmi.reflect.RefObject>>( "48B56701E13930D1744511DD88330019992F8D38", "test.sap.com/tc/moin/metamodel/testcases", new java.lang.String[] { "testcases", "case026", "A26", "reflectToMany" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ 
            }
            return __reflectToMany;
        }
    }
}    