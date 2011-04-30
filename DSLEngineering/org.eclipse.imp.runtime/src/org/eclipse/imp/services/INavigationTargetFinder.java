/**
 * 
 */
package org.eclipse.imp.services;

import org.eclipse.imp.language.ILanguageService;

/**
 * @author rfuhrer@watson.ibm.com
 */
public interface INavigationTargetFinder extends ILanguageService {
    Object getPreviousTarget(Object node, Object astRoot);
    Object getNextTarget(Object node, Object astRoot);
    Object getEnclosingConstruct(Object node, Object astRoot);
}
