/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.mi.gfw.mm.pictograms;

/**
 * This interface is not intended to be implemented by clients.
 */
public interface Shape extends com.sap.mi.gfw.mm.pictograms.AnchorContainer {

    /**
     * Descriptors for all features of this MofClass and its supertypes.
     */
    public static final Descriptors DESCRIPTORS = new Descriptors( );

    // class extent descriptor
    /**
     * Extent descriptor
     */
    public final com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<com.sap.tc.moin.repository.mmi.reflect.RefClass, com.sap.mi.gfw.mm.pictograms.Shape> CLASS_DESCRIPTOR = new com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<com.sap.tc.moin.repository.mmi.reflect.RefClass, com.sap.mi.gfw.mm.pictograms.Shape>("45E806E31FD033AD65384259299DEBAA310F446D", "sap.com/com/sap/mi/gfw/mm", "pictograms", "Shape"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 

    
    // references
    public com.sap.mi.gfw.mm.pictograms.ContainerShape getContainer() throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public void setContainer(com.sap.mi.gfw.mm.pictograms.ContainerShape newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;


    public static final class Descriptors {
        Descriptors( ) { 
        }
        /**
         * Returns the descriptor for the <code>properties</code> attribute.
         * @return  the descriptor for the <code>properties</code> attribute
         */
        public com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.mi.gfw.mm.pictograms.PropertyContainer,java.util.Collection<com.sap.mi.gfw.mm.pictograms.Property>> PROPERTIES( ) {
            return com.sap.mi.gfw.mm.pictograms.PropertyContainer.DESCRIPTORS.PROPERTIES( );
        }
        /**
         * Returns the descriptor for the <code>visible</code> attribute.
         * @return  the descriptor for the <code>visible</code> attribute
         */
        public com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.mi.gfw.mm.pictograms.PictogramElement,java.lang.Boolean> VISIBLE( ) {
            return com.sap.mi.gfw.mm.pictograms.PictogramElement.DESCRIPTORS.VISIBLE( );
        }
        /**
         * Returns the descriptor for the <code>active</code> attribute.
         * @return  the descriptor for the <code>active</code> attribute
         */
        public com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,com.sap.mi.gfw.mm.pictograms.PictogramElement,java.lang.Boolean> ACTIVE( ) {
            return com.sap.mi.gfw.mm.pictograms.PictogramElement.DESCRIPTORS.ACTIVE( );
        }
        /**
         * Returns the descriptor for the <code>graphicsAlgorithm</code> reference.
         * @return  the descriptor for the <code>graphicsAlgorithm</code> reference
         */
        public com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,com.sap.mi.gfw.mm.pictograms.PictogramElement,com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm> GRAPHICS_ALGORITHM( ) {
            return com.sap.mi.gfw.mm.pictograms.PictogramElement.DESCRIPTORS.GRAPHICS_ALGORITHM( );
        }
        /**
         * Returns the descriptor for the <code>link</code> reference.
         * @return  the descriptor for the <code>link</code> reference
         */
        public com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,com.sap.mi.gfw.mm.pictograms.PictogramElement,com.sap.mi.gfw.mm.links.PictogramLink> LINK( ) {
            return com.sap.mi.gfw.mm.pictograms.PictogramElement.DESCRIPTORS.LINK( );
        }
        /**
         * Returns the descriptor for the <code>anchors</code> reference.
         * @return  the descriptor for the <code>anchors</code> reference
         */
        public com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,com.sap.mi.gfw.mm.pictograms.AnchorContainer,java.util.Collection<com.sap.mi.gfw.mm.pictograms.Anchor>> ANCHORS( ) {
            return com.sap.mi.gfw.mm.pictograms.AnchorContainer.DESCRIPTORS.ANCHORS( );
        }
        private com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,com.sap.mi.gfw.mm.pictograms.Shape,com.sap.mi.gfw.mm.pictograms.ContainerShape> __container;
        /**
         * Returns the descriptor for the <code>container</code> reference.
         * @return  the descriptor for the <code>container</code> reference
         */
        public synchronized com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,com.sap.mi.gfw.mm.pictograms.Shape,com.sap.mi.gfw.mm.pictograms.ContainerShape> CONTAINER( ) {
            if ( __container == null ) {
                __container = new com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,com.sap.mi.gfw.mm.pictograms.Shape,com.sap.mi.gfw.mm.pictograms.ContainerShape>( "45E806E36C2C132007994139294B8F716B82E967", "sap.com/com/sap/mi/gfw/mm", new java.lang.String[] { "pictograms", "Shape", "container" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ 
            }
            return __container;
        }
    }
}    