package org.eclipse.emf.query.index.ui.internal.view.legends;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class LegendsComposite extends Composite {

	private static int mStyle = SWT.FILL;
	private ILegendManager mLegendManager;
	private ILegend[] mLegends;
	private Point mSize;

	public LegendsComposite(ILegendManager legendManager, Composite parent, Point size) {
		super(parent, mStyle );
		this.mLegendManager = legendManager;
		this.mLegends = mLegendManager.getLegends(); 
		this.mSize = size;
		
		initUI();
	}

	private void initUI() {
		boolean isFirstLegendHeader = true;
		Color colorWhite = getShell().getDisplay().getSystemColor( SWT.COLOR_WHITE );
		
		ScrolledComposite scrollArea = new ScrolledComposite(this, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		scrollArea.setBackground( colorWhite );
		scrollArea.setLayout( new GridLayout() );
		scrollArea.setLayoutData( new GridData(GridData.FILL_BOTH) );
		Composite legendArea = new Composite(scrollArea, SWT.NONE);
		scrollArea.setContent(legendArea);
		legendArea.setBackground( colorWhite );
		legendArea.setLayout( new GridLayout(2, false) );
		legendArea.setLayoutData( new GridData(GridData.FILL_BOTH) );

		org.eclipse.swt.widgets.Label label;
		GridData gridData;
		for( int i=0; i<mLegends.length; i++ ) {
			Image figureImage = mLegends[i].getImage();
			if( figureImage == null ) {
				if( !isFirstLegendHeader ) {
					label = new org.eclipse.swt.widgets.Label( legendArea, SWT.NONE );
					label.setText(""); //$NON-NLS-1$
					gridData = new GridData(GridData.FILL_HORIZONTAL);
					gridData.horizontalSpan = 2;
					label.setBackground( colorWhite );
				}
				label = new org.eclipse.swt.widgets.Label( legendArea, SWT.WRAP );
				label.setText( mLegends[i].getDescription() );
				gridData = new GridData(GridData.FILL_HORIZONTAL);
				gridData.horizontalSpan = 2;
				label.setLayoutData( gridData );
				label.setFont( JFaceResources.getBannerFont() );
				label.setBackground( colorWhite );
				if( isFirstLegendHeader )
					isFirstLegendHeader = false;
			}
			else {
				label = new org.eclipse.swt.widgets.Label( legendArea, SWT.NONE );
				label.setImage( figureImage );
				label.setBackground( colorWhite );
				gridData = new GridData( GridData.VERTICAL_ALIGN_BEGINNING );
				gridData.horizontalIndent = 5;
				label.setLayoutData( gridData );
				label = new org.eclipse.swt.widgets.Label( legendArea, SWT.WRAP );
				label.setText( mLegends[i].getDescription() );
				label.setBackground( colorWhite );
				gridData = new GridData();
				gridData.horizontalIndent = 10;
				label.setLayoutData( gridData );
			}
		}
		
		legendArea.pack();
		legendArea.layout();
		scrollArea.setSize(mSize);
	}
	
	

	
}
