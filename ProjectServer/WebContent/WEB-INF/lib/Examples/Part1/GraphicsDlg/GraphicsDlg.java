/********************************************************

GraphicsDlg.java

Code for the J/Link GraphicsDlg program presented in section 1.3.9 of
the J/Link User Guide. See that section for information on how to use
the program.

This demonstrates using a GUI builder tool to lay out the visual components of
an application, which are then controlled by Mathematica code. This code
was generated by WebGain Visual Cafe (formerly Symantec). A few lines of code
were added by hand, as described in the comments below.

************************************************************/

import java.awt.*;
import com.wolfram.jlink.MathCanvas;

public class GraphicsDlg extends com.wolfram.jlink.MathFrame
{

	// These are the methods added by hand, to expose the three components to
	// Mathematica code, so they can be scripted. These components were created
	// as non-public variables by the GUI builder tool, so we add three public methods
	// that can be called from Mathematica to return them.
	public TextArea getInputTextArea() { return inputTextArea; }
	public Button getEvalButton() { return evalButton; }
	public MathCanvas getMathCanvas() { return mathCanvas; }

	// Code from here on down was all generated by the Visual Cafe GUI builder.
	
	public GraphicsDlg()
	{
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setLayout(null);
		setSize(401,430);
		setVisible(false);
		add(mathCanvas);
		mathCanvas.setBounds(16,83,368,336);
		mathCanvas.setBackground(Color.white);
		add(inputTextArea);
		inputTextArea.setBounds(16,11,279,54);
		evalButton.setLabel("Evaluate");
		add(evalButton);
		evalButton.setBackground(java.awt.Color.lightGray);
		evalButton.setBounds(309,17,75,40);
		setTitle("Graphics Dialog");
		setBackground(Color.lightGray);
		//}}

		//{{INIT_MENUS
		//}}

		//{{REGISTER_LISTENERS
		SymWnd aSymWindow = new SymWnd();
		this.addWindowListener(aSymWindow);
		//}}
	}

	public GraphicsDlg(String title)
	{
		this();
		setTitle(title);
	}

    /**
     * Shows or hides the component depending on the boolean flag b.
     * @param b  if true, show the component; otherwise, hide the component.
     * @see java.awt.Component#isVisible
     */
    public void setVisible(boolean b)
	{
		if(b)
		{
			setLocation(50, 50);
		}
		super.setVisible(b);
	}

	static public void main(String args[])
	{
		(new GraphicsDlg()).setVisible(true);
	}
	
	public void addNotify()
	{
	    // Record the size of the window prior to calling parents addNotify.
	    Dimension d = getSize();
	    
		super.addNotify();

		if (fComponentsAdjusted)
			return;

		// Adjust components according to the insets
		Insets insets = getInsets();
		setSize(insets.left + insets.right + d.width, insets.top + insets.bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++)
		{
			Point p = components[i].getLocation();
			p.translate(insets.left, insets.top);
			components[i].setLocation(p);
		}
		fComponentsAdjusted = true;
	}

    // Used for addNotify check.
	boolean fComponentsAdjusted = false;

	//{{DECLARE_CONTROLS
	com.wolfram.jlink.MathCanvas mathCanvas = new com.wolfram.jlink.MathCanvas();
	java.awt.TextArea inputTextArea = new java.awt.TextArea();
	java.awt.Button evalButton = new java.awt.Button();
	//}}

	//{{DECLARE_MENUS
	//}}

	class SymWnd extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == GraphicsDlg.this)
				mathFrame_WindowClosing(event);
		}
	}
	
	void mathFrame_WindowClosing(java.awt.event.WindowEvent event)
	{
		setVisible(false);		 // hide the Frame
	}

}
