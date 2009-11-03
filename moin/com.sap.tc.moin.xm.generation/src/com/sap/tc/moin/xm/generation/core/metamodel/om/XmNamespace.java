package com.sap.tc.moin.xm.generation.core.metamodel.om;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;


public abstract class XmNamespace extends XmModelElementImpl {

    Map<String, XmModelElement> elementMap = new HashMap<String, XmModelElement>( );

    /**
     * Constructor.
     * 
     * @param input
     * @param xsdName
     * @param mofName
     * @param namespace
     * @param kind
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public XmNamespace( final XmGeneratorInput input, final String xsdName, final String mofName, final XmNamespace namespace, final XmXsdComponentKind kind ) {

        super( input, xsdName, mofName, namespace, kind );
    }

    /**
     * Constructor for the root package.
     * 
     * @param input
     * @param xsdName
     * @param mofName
     * @param kind
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    XmNamespace( final XmGeneratorInput input, final String xsdName, final String mofName, final XmXsdComponentKind kind ) {

        super( input, xsdName, mofName, kind );
    }

    /**
     * Adds a model element to the element map and makes the name of the model
     * element unique.
     * 
     * @param xmModelElement
     */
    public void addContainedElement( final XmModelElement xmModelElement ) {

        final String unambiguousNameOld = xmModelElement.getMofName( );
        String unambiguousNameNew = unambiguousNameOld;
        final Set<String> setWithUniqueMofElements = this.getSetWithUniqueMofElements( );
        if ( setWithUniqueMofElements.contains( unambiguousNameNew ) ) {
            final XmXsdComponentKind kind = xmModelElement.getXsdComponentKind( );
            if ( kind == XmXsdComponentKind.GlobalElement || kind == XmXsdComponentKind.LocalElement ) {
                if ( !unambiguousNameNew.endsWith( "Element" ) ) { //$NON-NLS-1$
                    unambiguousNameNew = unambiguousNameNew + "Element"; //$NON-NLS-1$
                }
            } else if ( kind == XmXsdComponentKind.GlobalAttribute || kind == XmXsdComponentKind.LocalAttribute ) {
                if ( !unambiguousNameNew.endsWith( "Attribute" ) ) { //$NON-NLS-1$
                    unambiguousNameNew = unambiguousNameNew + "Attribute"; //$NON-NLS-1$
                }
            }
        }
        int nameIndex = 0;
        while ( setWithUniqueMofElements.contains( unambiguousNameNew ) ) {
            nameIndex++;
            unambiguousNameNew = unambiguousNameOld + nameIndex;
        }
        xmModelElement.setMofName( unambiguousNameNew );
        elementMap.put( unambiguousNameNew, xmModelElement );
    }

    /**
     * Returns the set of elements contained in the namespace. This set is used
     * to determine the correct MOF name, when a new element is added to the
     * namespace (see method {@link #addContainedElement(XmModelElement)}). This
     * method can be overwritten (see {@link XmClass}).
     * 
     * @return set of elements
     */
    Set<String> getSetWithUniqueMofElements( ) {

        return this.elementMap.keySet( );
    }

    /**
     * @param modelPackage
     * @param namespace
     */
    void createContainedModelElements( final Namespace namespace ) {

        final Collection<XmModelElement> containedElements = elementMap.values( );

        for ( final XmModelElement moinModelElement : containedElements ) {
            final ModelElement containedElement = moinModelElement.createModelElement( );
            if ( containedElement != null ) {
                containedElement.setContainer( namespace );
            }
        }
    }

    public abstract Namespace createModelElement( );
}
