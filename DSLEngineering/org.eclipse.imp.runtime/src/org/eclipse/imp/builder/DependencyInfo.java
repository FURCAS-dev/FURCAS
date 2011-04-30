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

package org.eclipse.imp.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;

/**
 * Tracks dependencies among compilation units in a given project.<br>
 * @author rfuhrer@watson.ibm.com
 */
public class DependencyInfo {
    protected final Map<String /*unitPath*/, Set<String /*unitPath*/>> fDependsUpon= new HashMap<String,Set<String>>();
    protected final Map<String /*unitPath*/, Set<String /*unitPath*/>> fIsDependedUponBy= new HashMap<String,Set<String>>();
    protected final IProject fProject;
    protected final String fWorkspacePath;

    public DependencyInfo(IProject project) {
        fProject= project;
        fWorkspacePath= fProject.getProject().getWorkspace().getRoot().getLocation().toString();
    }

    protected Set<String /*unitPath*/> getEntry(Map<String /*unitPath*/, Set<String /*unitPath*/>> map, String unitPath) {
        Set<String> result;

        if (!map.containsKey(unitPath))
            result= Collections.emptySet();
        else
            result= map.get(unitPath);
        return result;
    }

    protected Set<String> getOrCreateEntry(Map<String,Set<String>> map, String unitPath) {
        Set<String> result;

        if (!map.containsKey(unitPath))
            map.put(unitPath, result= new HashSet<String>());
        else
            result= (Set<String>) map.get(unitPath);
        return result;
    }

    /**
     * Records a dependency between the two compilation units.
     * @param fromPath a compilation unit path; should be workspace-relative
     * @param uponPath a compilation unit path; should be workspace-relative
     */
    public void addDependency(String fromPath, String uponPath) {
        Set<String> fwdEntry= getOrCreateEntry(fDependsUpon, fromPath);

        fwdEntry.add(uponPath);

        Set<String> bkwdEntry= getOrCreateEntry(fIsDependedUponBy, uponPath);

        bkwdEntry.add(fromPath);
    }

    /**
     * Clears the memory of all dependencies among all compilation units tracked by
     * this DependencyInfo instance.
     */
    public void clearAllDependencies() {
        fDependsUpon.clear();
        fIsDependedUponBy.clear();
    }

    /**
     * Clears any dependencies related to the given compilation unit
     * @param unitPath should be workspace-relative
     */
    public void clearDependenciesOf(String unitPath) {
        Set<String> entry= getEntry(fDependsUpon, unitPath);

        fDependsUpon.put(unitPath, new HashSet<String>());
        for(Iterator<String> iter= entry.iterator(); iter.hasNext(); ) {
            String uponPath= (String) iter.next();
            Set<String> uponSet= getEntry(fIsDependedUponBy, uponPath);

            uponSet.remove(unitPath);
        }
    }

    /**
     * @return a Map from workspace-relative unit paths to Sets of dependent
     * workspace-relative unit paths
     */
    public Map<String /*path*/, Set<String /*path*/>> getDependencies() {
        return Collections.unmodifiableMap(fDependsUpon);
    }

    /**
     * @param unitPath should be workspace-relative
     * @return a Set of dependent workspace--relative unit paths
     */
    public Set<String /*path*/> getDependentsOf(String unitPath) {
        return (Set) fIsDependedUponBy.get(unitPath);
    }

    public void dump() {
        System.out.print(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("*** Dependencies ***:\n");
        for(Iterator<String> iter= fDependsUpon.keySet().iterator(); iter.hasNext(); ) {
            String unit= iter.next();
            Set<String /*path*/> dependents= (Set) fDependsUpon.get(unit);
    
            sb.append("Unit " + unit + ": \n");
            for(Iterator<String> iterator= dependents.iterator(); iterator.hasNext(); ) {
                String uponUnit= iterator.next();
                sb.append("  ");
                sb.append(uponUnit);
                if (iterator.hasNext()) sb.append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
