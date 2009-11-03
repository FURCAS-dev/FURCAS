package com.sap.tc.moin.repository.spi.facility.basicquery;

/**
 * Expression with attribute search criteria. An attribute expression can
 * contain operations e.g. equals, greater, like. Attribute expressions can be
 * nested using AND and OR operations. Facility specific properties such as the
 * partition in the NWDI facility can be encoded using pseudo attributes. TODO
 * specify more specific attribute expressions such as greater expression, equal
 * expression, like expression, AND expression and OR expression and specify how
 * to construct complex attribute expressions.
 * 
 * @author d029158
 * @version Created at 26 Jan 2006
 */
@Deprecated
public interface SpiAttributeExpression {

    public void toString( StringBuffer sb, int ident, boolean newline );
}