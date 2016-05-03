package src.convert;

import java.io.*;
import java.awt.image.*;
import java.awt.Image;
import com.wolfram.jlink.*;

public class MathematicaConvert {
	private String equation;
	private String expr;
	byte[] img, img2;
	java.awt.Image im, im2;
	public MathematicaConvert() {

	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}
	public String getexpr()
	{
		return expr;
	}
	public Image getImage1()
	{
		return im;
	}
	public Image getImage2()
	{
		return im2;
	}
	public void calcMathematica() {
		KernelLink ml = null;
		String plot="Plot";
		try {
			ml = MathLinkFactory.createKernelLink("-linkmode launch -linkname '/opt/Wolfram/WolframEngine/10.3/Executables/MathKernel'");
		} catch (MathLinkException e) {
			System.out.println("Fatal error opening link: " +
			e.getMessage());
			expr = e.getMessage();
		}
		try {
			ml.discardAnswer();
//			expr = ml.evaluateToOutputForm("Sum[k^2, {k,1,11}]", 0); // sample
			expr = ml.evaluateToOutputForm(equation, 0);
			ml.evaluateToOutputForm("$DefaultImageFormat = \"JPEG\"", 0);
			img = ml.evaluateToImage(equation, 200, 50);
			im = java.awt.Toolkit.getDefaultToolkit().createImage(img);
			plot += "[Evaluate[" + equation + ", {x, -14, 14}]]"; 
			img2 = ml.evaluateToImage(plot, 200, 50);
			im2 = java.awt.Toolkit.getDefaultToolkit().createImage(img2);
			
			ml.close();
		} catch (MathLinkException e) {
			System.out.println("MathLinkException error : " +
			e.getMessage());
			expr = e.getMessage();
		}
	}
}