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

/**
 * 
 */
package org.eclipse.imp.editor;

import java.util.ArrayList;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.imp.language.ILanguageService;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class OutlineLabelProvider implements ILabelProvider, IColorProvider, ILanguageService /*, IPropertyChangeListener (to react to preference changes) */{
    boolean fShowDefiningType;

    private boolean fIsShowingInheritedMembers;

    protected ListenerList fListeners= new ListenerList();

    private final ILabelProvider fLanguageLabelProvider;

    private ArrayList<ILabelDecorator> fLabelDecorators;

    protected final StorageLabelProvider fStorageLabelProvider;

    protected final IElementImageProvider fImageLabelProvider;

    private Color fForegroundColor;

    public interface IElementImageProvider extends ILanguageService {
	Image getImageLabel(Object element, long imageFlags);
    }

    public OutlineLabelProvider(ILabelProvider langLabelProvider, IElementImageProvider elemImageProvider, boolean showInheritedMembers, boolean showStorage, Color foregroundColor) {
	fLanguageLabelProvider= langLabelProvider;
	fImageLabelProvider= elemImageProvider; // new JikesPGElementImageProvider();
	fIsShowingInheritedMembers= showInheritedMembers;
	fForegroundColor= foregroundColor;
	fStorageLabelProvider= 	showStorage ? new StorageLabelProvider() : null;
    }

    /**
     * Adds a decorator to the label provider
     */
    public void addLabelDecorator(ILabelDecorator decorator) {
	if (fLabelDecorators == null) {
	    fLabelDecorators= new ArrayList<ILabelDecorator>(2);
	}
	fLabelDecorators.add(decorator);
    }

    /*
     * @see ILabelProvider#getText
     */
    public String getText(Object element) {
	String result= fLanguageLabelProvider.getText(element); // JikesPGElementLabels.getTextLabel(element, getTextFlags(element));
	if (result.length() == 0 && (element instanceof IStorage)) {
	    result= fStorageLabelProvider.getText(element);
	}
	result= decorateText(result, element);
	if (fShowDefiningType) {
	    //		IType type= getDefiningType(element);
	    //		if (type != null) {
	    //		    StringBuffer buf= new StringBuffer(super.getText(type));
	    //		    buf.append(JavaElementLabels.CONCAT_STRING);
	    //		    buf.append(result);
	    //		    return buf.toString();
	    //		}
	}
	return result;
    }

    private long getTextFlags(Object element) {
	// TODO Auto-generated method stub
	return 0;
    }

    private long getImageFlags(Object element) {
	// TODO Auto-generated method stub
	return 0;
    }

    protected String decorateText(String text, Object element) {
	if (fLabelDecorators != null && text.length() > 0) {
	    for(int i= 0; i < fLabelDecorators.size(); i++) {
		ILabelDecorator decorator= (ILabelDecorator) fLabelDecorators.get(i);
		text= decorator.decorateText(text, element);
	    }
	}
	return text;
    }

    /*
     * @see org.eclipse.jdt.internal.ui.viewsupport.JavaUILabelProvider#getForeground(java.lang.Object)
     */
    public Color getForeground(Object element) {
	if (fIsShowingInheritedMembers) {
	    //		if (element instanceof ASTNode) {
	    //		    ASTNode node= (ASTNode) element;
	    //
	    //		    if (fInput.getElementType() == IJavaElement.CLASS_FILE)
	    //			je= je.getAncestor(IJavaElement.CLASS_FILE);
	    //		    else
	    //			je= je.getAncestor(IJavaElement.COMPILATION_UNIT);
	    //		    if (fInput.equals(je)) {
	    //			return null;
	    //		    }
	    //		}
	    return fForegroundColor;
	}
	return null;
    }

    public Color getBackground(Object element) {
	return null;
    }

    public void setShowDefiningType(boolean showDefiningType) {
	fShowDefiningType= showDefiningType;
    }

    public boolean isShowDefiningType() {
	return fShowDefiningType;
    }

    //	private IType getDefiningType(Object element) {
    //	    int kind= ((IJavaElement) element).getElementType();
    //	    if (kind != IJavaElement.METHOD && kind != IJavaElement.FIELD && kind != IJavaElement.INITIALIZER) {
    //		return null;
    //	    }
    //	    IType declaringType= ((IMember) element).getDeclaringType();
    //	    if (kind != IJavaElement.METHOD) {
    //		return declaringType;
    //	    }
    //	    ITypeHierarchy hierarchy= getSuperTypeHierarchy(declaringType);
    //	    if (hierarchy == null) {
    //		return declaringType;
    //	    }
    //	    IMethod method= (IMethod) element;
    //	    int flags= method.getFlags();
    //	    if (Flags.isPrivate(flags) || Flags.isStatic(flags) || method.isConstructor()) {
    //		return declaringType;
    //	    }
    //	    IMethod res= JavaModelUtil.findMethodDeclarationInHierarchy(hierarchy, declaringType, method.getElementName(), method.getParameterTypes(), false);
    //	    if (res == null || method.equals(res)) {
    //		return declaringType;
    //	    }
    //	    return res.getDeclaringType();
    //	}

    public Image getImage(Object element) {
	Image result= null;
	if (fImageLabelProvider != null)
	    result= fImageLabelProvider.getImageLabel(element, getImageFlags(element));
	else if (fLanguageLabelProvider != null)
	    result= fLanguageLabelProvider.getImage(element);
	if (result == null && (element instanceof IStorage)) {
	    result= fStorageLabelProvider.getImage(element);
	}
	return decorateImage(result, element);
    }

    protected Image decorateImage(Image image, Object element) {
	if (fLabelDecorators != null && image != null) {
	    for(int i= 0; i < fLabelDecorators.size(); i++) {
		ILabelDecorator decorator= (ILabelDecorator) fLabelDecorators.get(i);
		image= decorator.decorateImage(image, element);
	    }
	}
	return image;
    }

    public void addListener(ILabelProviderListener listener) {
	fListeners.add(listener);
    }

    public void dispose() {
	if (fLabelDecorators != null) {
	    for(int i= 0; i < fLabelDecorators.size(); i++) {
		ILabelDecorator decorator= (ILabelDecorator) fLabelDecorators.get(i);
		decorator.dispose();
	    }
	    fLabelDecorators= null;
	}
	if (fStorageLabelProvider != null)
	    fStorageLabelProvider.dispose();
    }

    public boolean isLabelProperty(Object element, String property) {
	return true;
    }

    public void removeListener(ILabelProviderListener listener) {
	if (fLabelDecorators != null) {
	    for(int i= 0; i < fLabelDecorators.size(); i++) {
		ILabelDecorator decorator= (ILabelDecorator) fLabelDecorators.get(i);
		decorator.removeListener(listener);
	    }
	}
	fListeners.remove(listener);
    }
}
