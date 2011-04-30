/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.services;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author rfuhrer@watson.ibm.com
 */
public interface IASTAdapter extends IASTMatchAdapter {
    /**
     * The type of an entity in the target source program, e.g., the declared type of
     * a variable, or the inferred type of an expression. A construct that does not
     * produce or declare a value can be considered to have type TARGET_TYPE_VOID.
     */
    public static final String TARGET_TYPE= "targetType";

    /**
     * The name of the AST node type
     */
    public static final String KIND= "kind";

    /**
     * E.g. the name of a method or variable decl/ref
     */
    public static final String NAME= "name";

    /**
     * The void target type (hah! You were probably expecting a more useful JavaDoc comment, weren't you?)
     */
    public static final String TARGET_TYPE_VOID= "void";

    /**
     * @return the name of the child role at the given positional index
     */
    public String getChildRoleAtPosition(int pos, String qualNodeType);

    /**
     * @param roleName refers to a child role, and not a predefined attribute
     * such as "type" or "kind" (which have no positional index)
     * @param qualNodeType
     * @return a positional index, if the roleName is valid
     * @throws NoSuchElementException if the roleName does not refer to a valid
     * role for the given AST node type
     * @throws IllegalArgumentException if the role refers to a predefined attribute
     * or if the type name is invalid
     */
    public int getPositionOfChildRole(String roleName, String qualNodeType);

    /**
     * @param attributeName refers to a child role or a predefined attribute
     * such as "type" or "kind"
     * @return the value of the named attribute for the given AST node
     * TODO handle "child roles"
     */
    public Object getValue(String attributeName, Object astNode);

    /**
     * @return fully-qualified name of the type with the given simple name
     */
    public String lookupSimpleNodeType(String simpleName);

    /**
     * @return true iff the given AST node is of the given named type, which
     * must be fully-qualified
     */
    public boolean isInstanceOfType(Object astNode, String typeName);

    /**
     * @return true iff the given AST node type is a sub-type of the given named
     * type <code>maybeSub</code>, which must be fully-qualified
     */
    public boolean isSubTypeOf(String maybeSuper, String maybeSub);

    /**
     * @return the type of AST node for the given AST node, which is suitable
     * for use with, e.g., isInstanceOfType()
     */
    public String getTypeOf(Object astNode);

    /**
     * @param qualName the fully-qualified name of the AST node type to construct
     * @param children array of child AST nodes (even if certain "children" may
     * not be AST nodes in the target AST representation)
     * @return newly-constructed AST node
     */
    public Object construct(String qualName, Object[] children) throws IllegalArgumentException;

    /**
     * @param qualName the fully-qualified name of the AST node type to construct
     * @param children array of child AST nodes (even if certain "children" may
     * not be AST nodes in the target AST representation)
     * @param attribs map from attribute names to attribute values
     * @return newly-constructed AST node
     */
    public Object construct(String qualName, Object[] children, Map/*<String,Object>*/ attribs) throws IllegalArgumentException;

    /**
     * Finds the previous match using the given Matcher occurring before the given offset.<br>
     * This is essentially a wrapper for the AST traversal surrounding the matching
     * process. For each node, the implementation should call <code>matcher.match()</code>
     * to actually perform the match.
     * @param matcher the matcher to use (encapsulates the pattern)
     * @param astRoot the top of the AST tree to search
     * @param startPos the character at which to begin the search
     * @return the first non-null MatchContext returned by <code>matcher.match()</code>, if any;
     * otherwise, null
     */
    // RMF 5/1/2006 - Don't know how to do this easily, given that the visitor
    // implementation essentially traverses the AST in order of increasing offset...
//    public MatchContext findPreviousMatch(Matcher matcher, Object astRoot, int offset);

    /**
     * If the AST node is a meta variable, return its name.
     */
    public abstract String getMetaVariableName(Object astNode);

    /**
     * Returns the file path of the file containing the
     * source text corresponding to the given AST node <code>astNode</code>.
     * The path will be the same as what was provided to the AST creator
     * (e.g. the parser).
     */
    public String getFile(Object astNode);

    /**
     * Returns the length in characters (not bytes) of the source text
     * corresponding to the given AST node <code>astNode</code>.
     */
    public int getLength(Object astNode);
}
