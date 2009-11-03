package com.sap.mi.gfw.eclipse.internal.util.ui;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.internal.util.Util;
import com.sap.mi.gfw.eclipse.internal.util.io.FileUtil;
import com.sap.mi.gfw.eclipse.internal.util.ui.print.SaveFigureAsImageDialog;
import com.sap.mi.gfw.util.T;

/**
 * A collection of static helper methods regarding Draw2d.
 */
public class UIUtil {

	/**
	 * Returns the bytes of an encoded image for the specified IFigure in the specified format.
	 * 
	 * @param image
	 *            The Figure to create an image for.
	 * @param format
	 *            One of SWT.IMAGE_BMP, SWT.IMAGE_BMP_RLE, SWT.IMAGE_GIF SWT.IMAGE_ICO, SWT.IMAGE_JPEG, or SWT.IMAGE_PNG
	 * @param scaleFactor
	 *            The scale factor, which is applied to the created the image.
	 * 
	 * @return The bytes of an encoded image for the specified Figure
	 * @throws Exception
	 *             if GIF is th format and the image contains more than 256 colors
	 */
	public static byte[] createImage(Image image, int format) throws Exception {
		ByteArrayOutputStream result = new ByteArrayOutputStream();

		try {
			// at the moment saving as GIF is only working if not more than 256
			// colors are used in the figure
			if (format == SWT.IMAGE_GIF) {
				image = create8BitIndexedPaletteImage(image);
			}

			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { image.getImageData() };
			imageLoader.save(result, format);

		} finally {
			image.dispose();
		}

		return result.toByteArray();
	}

	/**
	 * Creates an image with 8 bit color depth and an indexed palette from the given image. This is the format required for GIF images.
	 * 
	 * @param image
	 *            The image, from which to create the new image.
	 * 
	 * @return The new image with 8 bit color depth and an indexed palette.
	 * 
	 * @throws Exception
	 *             If the image has more than 256 colors (not supported yet).
	 */
	public static Image create8BitIndexedPaletteImage(Image image) throws Exception {
		int upperboundWidth = image.getBounds().width;
		int upperboundHeight = image.getBounds().height;
		ImageData imageData = image.getImageData();

		// determine number of used colors
		ArrayList colors = new ArrayList();
		for (int x = 0; x < upperboundWidth; x++) {
			for (int y = 0; y < upperboundHeight; y++) {
				int color = imageData.getPixel(x, y);
				Integer colorInteger = new Integer(color);
				if (!colors.contains(colorInteger))
					colors.add(colorInteger);
			}
		}

		// at the moment this is only working if not more than 256 colors are
		// used in the image
		if (colors.size() > 256)
			throw new Exception("Image contains more than 256 colors. \n Automated color reduction is currently not supported."); //$NON-NLS-1$

		// create an indexed palette
		RGB[] rgbs = new RGB[256];
		for (int i = 0; i < 256; i++)
			rgbs[i] = new RGB(255, 255, 255);
		for (int i = 0; i < colors.size(); i++) {
			int pixelValue = ((Integer) (colors.get(i))).intValue();
			int red = (pixelValue & imageData.palette.redMask) >>> Math.abs(imageData.palette.redShift);
			int green = (pixelValue & imageData.palette.greenMask) >>> Math.abs(imageData.palette.greenShift);
			int blue = (pixelValue & imageData.palette.blueMask) >>> Math.abs(imageData.palette.blueShift);
			rgbs[i] = new RGB(red, green, blue);
		}

		// create new imageData
		PaletteData palette = new PaletteData(rgbs);
		ImageData newImageData = new ImageData(imageData.width, imageData.height, 8, palette);

		// adjust imageData with regard to the palette
		for (int x = 0; x < upperboundWidth; x++) {
			for (int y = 0; y < upperboundHeight; y++) {
				int color = imageData.getPixel(x, y);
				newImageData.setPixel(x, y, colors.indexOf(new Integer(color)));
			}
		}

		// create new Image
		image = new Image(null, newImageData);
		return image;
	}

	/**
	 * Start the procedure to save the given GraphicalViewer as an image:
	 * <ul>
	 * <li>opens a dialog to select the figure, image-format and the scale-factor</li>
	 * <li>opens a dialog to select the filename</li>
	 * <li>saves the image to the file</li>
	 * </ul>
	 * 
	 * @param graphicalViewer
	 *            The GraphicalViewer, which to save as an image.
	 */
	public static void startSaveAsImageDialog(GraphicalViewer graphicalViewer) {
		String METHOD = "startSaveAsImageDialog(graphicalViewer)"; //$NON-NLS-1$

		// select image-format and scale-factor
		SaveFigureAsImageDialog saveAsImageDialog = new SaveFigureAsImageDialog(GraphicsPlugin.getShell(), graphicalViewer);
		saveAsImageDialog.open();
		if (saveAsImageDialog.getReturnCode() == Window.CANCEL)
			return;

		// select filename with file-dialog
		FileDialog fileDialog = new FileDialog(GraphicsPlugin.getShell(), SWT.SAVE);
		String fileExtensions[] = new String[] { "*." + saveAsImageDialog.getFileExtensionForImageFormat() }; //$NON-NLS-1$
		fileDialog.setFilterExtensions(fileExtensions);
		String filename = fileDialog.open();
		if (filename != null) {
			try {
				// add extension to filename (if none exists)
				IPath path = new Path(filename);
				if (path.getFileExtension() == null)
					filename = filename + "." + saveAsImageDialog.getFileExtensionForImageFormat(); //$NON-NLS-1$
				// create image-data
				byte image[] = createImage(saveAsImageDialog.getScaledImage(), saveAsImageDialog.getImageFormat());

				// save image as file
				WorkspaceModifyOperation saveOperation = FileUtil.saveContentsToFile(filename, image);
				new ProgressMonitorDialog(GraphicsPlugin.getShell()).run(false, false, saveOperation);
			} catch (Exception e) {
				String message = "Can not save image: "; //$NON-NLS-1$
				MessageDialog.openError(GraphicsPlugin.getShell(), "Can not save image", message + e.getMessage()); //$NON-NLS-1$
				T.racer().error(METHOD, message + "\nDetails: " + Util.getStacktrace(e)); //$NON-NLS-1$
				e.printStackTrace();
			}
		}
	}

	// public static Color[] calculateColorsSteps(Color startColor, Color
	// endColor, int steps) {
	// if (steps < 2) {
	// throw new IllegalArgumentException();
	// }
	//
	// Color[] ret = new Color[steps];
	//
	// int redDiff = endColor.getRed() - startColor.getRed();
	// int greenDiff = endColor.getGreen() - startColor.getGreen();
	// int blueDiff = endColor.getBlue() - startColor.getBlue();
	//
	// ret[0] = startColor;
	//
	// for (int i = 1; i < steps - 1; i++) {
	// int red = startColor.getRed() + ((i * redDiff) / (steps - 1));
	// int green = startColor.getGreen() + ((i * greenDiff) / (steps - 1));
	// int blue = startColor.getBlue() + ((i * blueDiff) / (steps - 1));
	// ret[i] = new Color(null, red, green, blue);
	// }
	//
	// ret[steps - 1] = endColor;
	//
	// return ret;
	// }
}
