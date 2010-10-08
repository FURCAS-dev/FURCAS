/**
 * 
 */
package com.sap.mi.textual.moinlookup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.utilities.TypedElement;
import org.junit.Test;

import com.sap.furcas.parsergenerator.emf.lookup.AbstractQueryBasedEcoreLookUp;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.parsing.MofAnyStub;
import com.sap.mi.textual.test.util.StringListHelper;

/**
 * Tests the abstract AbstractMoinLookup class by creating a stub subclass and testing that.
 * Special care need to me taken to test for features that are structural features, Associations, or StructureTypes.
 */
public class AbstractQueryMoinLookupTest {

    @Test
    public void testFilterClassifierList() throws Exception {
        List<String> qualifiedNameOfType = StringListHelper.list("package", "rightclass");
        List<Classifier> expectedResult = new ArrayList<Classifier>();;
        
        List<Classifier> inputClassifiers = new ArrayList<Classifier>();
        
        MofAnyStub classi3 = new MofAnyStub();
        classi3.name = "wrongclass"; // stub adds "package" in qualifiedname
        inputClassifiers.add(classi3);
        
        MofAnyStub classi2 = new MofAnyStub();
        classi2.name = "rightclass"; // stub adds "package" in qualifiedname
        inputClassifiers.add(classi2);
        expectedResult.add(classi2);
        
        MofAnyStub classi5 = new MofAnyStub();
        classi5.name = "wrongclass"; // stub adds "package" in qualifiedname
        inputClassifiers.add(classi5);
        
        MofAnyStub classi = new MofAnyStub();
        classi.name = "rightclass"; // stub adds "package" in qualifiedname
        inputClassifiers.add(classi);
        expectedResult.add(classi);
        
        MofAnyStub classi6 = new MofAnyStub();
        classi6.name = "wrongclass"; // stub adds "package" in qualifiedname
        inputClassifiers.add(classi6);
        
        List<Classifier> result = AbstractQueryBasedEcoreLookUp.filterClassifiers(qualifiedNameOfType, inputClassifiers);
        
        assertEquals(expectedResult, result);
    }

    
    private class MoinLookUpSubTypeStub extends AbstractQueryBasedEcoreLookUp {

        /**
         * @param connection
         */
        public MoinLookUpSubTypeStub() {
            super(null);
            // TODO Auto-generated constructor stub
        }

        public List<Classifier> qualifiedClassifiers = new ArrayList<Classifier>();
        public Classifier classifier;
        public AssociationEnd assoEnd;

        /* (non-Javadoc)
         * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getAssociationEnd(java.util.List, java.lang.String)
         */
        @Override
        protected AssociationEnd getAssociationEnd(ResolvedNameAndReferenceBean<RefObject> reference,
                String featureName) throws MetaModelLookupException {
            return assoEnd;
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getClassifier(java.util.List)
         */
        @Override
        protected Classifier getClassifierByName(List<String> typeNameQ)
                throws MetaModelLookupException {
            return classifier;
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.interfaces.IMetaModelLookup#close()
         */
        @Override
		public void close() {  }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java.util.List)
         */
        @Override
		public List<ResolvedNameAndReferenceBean<RefObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<RefObject> typeName)
                throws MetaModelLookupException {
            fail("Not implemented");
            return null;
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getClassifiers(java.lang.String)
         */
        @Override
        protected List<Classifier> getClassifiers(String typeName)
                throws MetaModelLookupException {
            return qualifiedClassifiers;
        }

        // piping the protected superclass method for testing
        public TypedElement publicGetTypedElement(ResolvedNameAndReferenceBean reference, String featureName) throws MetaModelLookupException {
            return this.getTypedElement(reference, featureName);
        }
        
        // piping the protected superclass method for testing
        public String publicGetStringRep(List<String> typeName) throws MetaModelLookupException {
            return getStringRepresentationOfName(typeName);
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.moinlookup.AbstractQueryBasedMoinMetaLookUp#initQueryPRIs()
         */
        @Override
        protected Set<PRI> initQueryPRIs() {
            // TODO Auto-generated method stub
            return null;
        }


    }
    
}
