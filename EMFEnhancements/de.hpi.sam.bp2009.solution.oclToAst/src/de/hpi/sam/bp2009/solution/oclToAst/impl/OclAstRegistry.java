/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;

/**
 * This is an special EPackage registry which is used by the {@link EAnnotationOCLParserImpl} 
 * to combine the standard registered package with all packages in scope
 * @author Philipp
 *
 */
public class OclAstRegistry implements EPackage.Registry {
    
    private Registry base;
    private Map<String,EPackage> nsToPkg = new HashMap<String, EPackage>();
    /**
     * Create a new Registry with a base registry and a set of salt packages
     * Note: by {@link Map#keySet()}, {@link Map#values()} and {@link Map#entrySet()} a new set will be delivered
     * so changes at this Set will have no effect to this registry
     * @param baseRegistry this registry is used as fallback for requests
     * @param saltPackages this packages get sorted by {@link EPackage#getNsURI()} and are delivered first
     */
    public OclAstRegistry(EPackage.Registry baseRegistry, Collection<EPackage> saltPackages) {
        this.base = new EPackageRegistryImpl();
        this.base.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
        if(saltPackages!=null){
            for(EPackage p: saltPackages){
                nsToPkg.put(p.getNsURI(), p);
                if(p.getESuperPackage()==null && p.eResource()!=null){
                    nsToPkg.put(p.eResource().getURI().toString(), p);
                }
            }
        }
        
    }
    /**
     * 
     * @see java.util.Map#clear()
     */
    public void clear() {
        base.clear();
    }
    /**
     * @param arg0
     * @return
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    public boolean containsKey(Object arg0) {
        if(nsToPkg.containsKey(arg0)){
            return true;
        }
        return base.containsKey(arg0);
    }
    /**
     * @param arg0
     * @return
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    public boolean containsValue(Object arg0) {
        if(nsToPkg.containsValue(arg0)){
            return true;
        }
        return base.containsValue(arg0);
    }
    /**
     * @return
     * @see java.util.Map#entrySet()
     */
    @SuppressWarnings("unchecked")
    public Set<java.util.Map.Entry<String, Object>> entrySet() {
        Set<Entry<String, Object>> result = new HashSet<Map.Entry<String,Object>>();
        result.addAll(base.entrySet());
        result.addAll((Collection<? extends java.util.Map.Entry<String, Object>>) nsToPkg.entrySet());
        return result ;
    }
    /**
     * @param arg0
     * @return
     * @see java.util.Map#get(java.lang.Object)
     */
    public Object get(Object arg0) {
        if(nsToPkg.containsKey(arg0)){
            return nsToPkg.get(arg0);
        }
        return base.get(arg0);
    }
    /**
     * @param nsURI
     * @return
     * @see org.eclipse.emf.ecore.EPackage.Registry#getEPackage(java.lang.String)
     */
    public EPackage getEPackage(String nsURI) {
        if(nsToPkg.containsKey(nsURI)){
            return nsToPkg.get(nsURI);
        }
        return base.getEPackage(nsURI);
    }
    /**
     * @param nsURI
     * @return
     * @see org.eclipse.emf.ecore.EPackage.Registry#getEFactory(java.lang.String)
     */
    public EFactory getEFactory(String nsURI) {
        return base.getEFactory(nsURI);
    }
    /**
     * @return
     * @see java.util.Map#isEmpty()
     */
    public boolean isEmpty() {
        return base.isEmpty() && nsToPkg.isEmpty();
    }
    /**
     * @return
     * @see java.util.Map#keySet()
     */
    public Set<String> keySet() {
        Set<String> result = new HashSet<String>();
        result.addAll(base.keySet());
        result.addAll(nsToPkg.keySet());
        return result ;
    }
    /**
     * @param arg0
     * @param arg1
     * @return
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public Object put(String arg0, Object arg1) {
        return base.put(arg0, arg1);
    }
    /**
     * @param arg0
     * @see java.util.Map#putAll(java.util.Map)
     */
    public void putAll(Map<? extends String, ? extends Object> arg0) {
        base.putAll(arg0);
    }
    /**
     * @param arg0
     * @return
     * @see java.util.Map#remove(java.lang.Object)
     */
    public Object remove(Object arg0) {
        return base.remove(arg0);
    }
    /**
     * @return
     * @see java.util.Map#size()
     */
    public int size() {
        return base.size();
    }
    /**
     * @return
     * @see java.util.Map#values()
     */
    public Collection<Object> values() {
        Set<Object> result = new HashSet<Object>();
        result.addAll(nsToPkg.values());
        result.addAll(base.values());

        return result ;
    }

}
