/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcases.case018;

/**
 * This interface is not intended to be implemented by clients.
 */
public interface B18 extends com.sap.tc.moin.testcasesfoundation.case001f.B1f {

    /**
     * Descriptors for all features of this MofClass and its supertypes.
     */
    public static final Descriptors DESCRIPTORS = new Descriptors( );

    // class extent descriptor
    /**
     * Extent descriptor
     */
    public final com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<com.sap.tc.moin.repository.mmi.reflect.RefClass, com.sap.tc.moin.testcases.case018.B18> CLASS_DESCRIPTOR = new com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<com.sap.tc.moin.repository.mmi.reflect.RefClass, com.sap.tc.moin.testcases.case018.B18>("45F120A593EB7AC9D909470D3DFCFCEE58ED1378", "test.sap.com/tc/moin/metamodel/testcases", "testcases", "case018", "B18"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ 

    
    // attributes
    public java.lang.String getSpecialOnePrimitive() throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public void setSpecialOnePrimitive(java.lang.String newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;


    public static final class Descriptors {
        Descriptors( ) { 
        }
        /**
         * Returns the descriptor for the <code>onePrimitive</code> attribute.
         * @return  the descriptor for the <code>onePrimitive</code> attribute
         */
        public com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcasesfoundation.case001f.B1f,java.lang.String> ONE_PRIMITIVE( ) {
            return com.sap.tc.moin.testcasesfoundation.case001f.B1f.DESCRIPTORS.ONE_PRIMITIVE( );
        }
        private com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case018.B18,java.lang.String> __specialOnePrimitive;
        /**
         * Returns the descriptor for the <code>specialOnePrimitive</code> attribute.
         * @return  the descriptor for the <code>specialOnePrimitive</code> attribute
         */
        public synchronized com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case018.B18,java.lang.String> SPECIAL_ONE_PRIMITIVE( ) {
            if ( __specialOnePrimitive == null ) {
                __specialOnePrimitive = new com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.tc.moin.testcases.case018.B18,java.lang.String>( "491C8B26F9F92EB0B1BF11DD8F82001558C93B47", "test.sap.com/tc/moin/metamodel/testcases", new java.lang.String[] { "testcases", "case018", "B18", "specialOnePrimitive" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ 
            }
            return __specialOnePrimitive;
        }
    }
}    