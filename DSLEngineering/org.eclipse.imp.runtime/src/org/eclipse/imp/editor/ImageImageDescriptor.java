package org.eclipse.imp.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

/**
 * An ImageDescriptor that takes its data from an already-manifested Image.
 * Copied from the JDT class of the same name.
 * @author rfuhrer@watson.ibm.com
 */
public class ImageImageDescriptor extends ImageDescriptor {
    private Image fImage;

    /**
     * Constructor for ImagImageDescriptor.
     */
    public ImageImageDescriptor(Image image) {
        super();
        fImage= image;
    }

    /* (non-Javadoc)
     * @see ImageDescriptor#getImageData()
     */
    public ImageData getImageData() {
        return fImage.getImageData();
    }

    /* (non-Javadoc)
     * @see Object#equals(Object)
     */
    public boolean equals(Object obj) {
        return (obj != null) && getClass().equals(obj.getClass()) && fImage.equals(((ImageImageDescriptor)obj).fImage);
    }

    /* (non-Javadoc)
     * @see Object#hashCode()
     */
    public int hashCode() {
        return fImage.hashCode();
    }
}
