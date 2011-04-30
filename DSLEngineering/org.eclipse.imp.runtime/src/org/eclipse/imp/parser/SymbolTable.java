package org.eclipse.imp.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Trivial symbol table class mapping Strings to declarations (whatever kind
 * the parser/resolver produces). Parent/child relationship is intended to
 * represent lexical nesting of scopes.
 */
public class SymbolTable<T> extends HashMap<String,T> {
    private final SymbolTable<T> parent;

    public SymbolTable() { this(null); }
    public SymbolTable(SymbolTable<T> parent) { this.parent = parent; }

    public SymbolTable<T> getParent() { return parent; }

    public T findDeclaration(String name) {
        T decl = (T) get(name);
        return decl != null ? decl : (parent != null ? parent.findDeclaration(name) : null);
    }

    public <T1> List<String> allSymbolsOfType(Class<T1> type) {
        List<String> result= new ArrayList<String>();

        for(String sym: keySet()) {
            T def= get(sym);

            if (type.isInstance(def))
                result.add(sym);
        }
        return result;
    }

    public <T1> List<T1> allDefsOfType(Class<T1> type) {
        List<T1> result = new ArrayList<T1>();
        
        for(String sym: keySet()) {
            T def= get(sym);

            if (type.isInstance(def))
                result.add((T1) def);
        }
        return result;
    }

    public Set<String> allSymbols() {
        return keySet();
    }
}
