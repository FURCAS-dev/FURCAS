package com.sap.ide.treeprovider;

public interface TextLabelProvider {
    /**
     * Return <tt>null</tt> if you don't know this type of node or the type of element
     * contained in the node. The caller then will keep looking for extensions that do
     * know how to handle this.
     * Do not implement any kind of generic standard behavior as this is done by the 
     * TreeProvider. Default behavior implemented there is:
     *  if (has attribute name) return name attribute
     *  else return roleName? + MofClass.name + MOF_ID
     */
    String getText(Object treenode);
}
