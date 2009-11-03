package com.sap.tc.moin.repository.xm.parser;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.xm.ModelElementHandle;


/**
 * Represents a handle to a model element which is used in {@link ParserHelper}.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface PModelElementHandle extends ModelElementHandle {


    /**
     * Sets or adds an attribute value to the model element. The
     * <code>attributeDescriptor</code> can denote a single- or multi-valued
     * attribute.
     * <p>
     * If the attribute is of type Boolean then the attribute value is set to
     * <code>true</code> if the string argument is not <code>null</code> and is
     * equal, ignoring case, to the string <code>"true"</code>.
     * <p>
     * Example: <tt>Boolean.valueOf("True")</tt> leads to <tt>true</tt>.<br>
     * Example: <tt>Boolean.valueOf("yes")</tt> leads to <tt>false</tt>.
     * <p>
     * Note, there is a different exception handling for the Import/Export and
     * the CP/S integration strategy.
     * 
     * @param attributeDescriptor attribute descriptor
     * @param value value of the attribute
     * @throws InvalidNameException if <code>attributeDescriptor</code> does not
     * denote a valid attribute of the model element; this exception is only
     * thrown in the Import/Export integration strategy; in the CP/S integration
     * strategy this situation can be handled by the SpiParserErrorHandler
     * @exception NumberFormatException if the attribute is a number primitive
     * type and <tt>value</tt> does not contain a parse-able number; this
     * exception is only thrown in the Import/Export integration strategy; in
     * the CP/S integration strategy this situation can be handled by the
     * SpiParserErrorHandler
     * @throws IllegalArgumentException if <code>value</code> is
     * <code>null</code>
     */
    void setOrAddAttribute( AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor, String value );


}
