/**
 * Generated by the MOIN Generator Version 3.0
 **/

package runlettest;
/**
 * This interface is not intended to be implemented by clients.
 */
public interface ASubRunletTest extends com.sap.tc.moin.repository.mmi.reflect.RefAssociation
{
    // association extent descriptor
    /**
     * Extent descriptor
     */
    public final com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor<runlettest.ASubRunletTest> ASSOCIATION_DESCRIPTOR = new com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor<runlettest.ASubRunletTest>("E0BF480E8BFD96458B2011DEC08100155883529C", "sap.com/com/sap/runlet/testmetamodel", "runlettest", "A_sub_runletTest"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 


    // association interface
    public boolean exists(runlettest.Subcomponent _Sub, runlettest.RunletTest _RunletTest) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public java.util.Collection<runlettest.Subcomponent> getSub(runlettest.RunletTest _RunletTest) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public runlettest.RunletTest getRunletTest(runlettest.Subcomponent _Sub) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public boolean add(runlettest.Subcomponent _Sub, runlettest.RunletTest _RunletTest) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
    public boolean remove(runlettest.Subcomponent _Sub, runlettest.RunletTest _RunletTest) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
}