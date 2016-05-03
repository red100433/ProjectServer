package src.convert;

import java.io.*;
import java.awt.image.*;
import java.awt.Image;
import com.wolfram.jlink.*;

public class MathematicaConvert {
	private String equation;

	public MathematicaConvert() {

	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public String calcMathematica() {
		KernelLink ml = null;
		String expr;
		try {
			ml = MathLinkFactory.createKernelLink("-linkmode launch -linkname '/opt/Wolfram/WolframEngine/10.3/Executables/MathKernel'");
			ml.discardAnswer();
			expr = ml.evaluateToOutputForm("Sum[k^2, {k,1,11}]", 0); // sample
			//ml.waitForAnswer();
			ml.close();
			return expr; 
		} catch (MathLinkException e) {
			// System.out.println("Fatal error opening link: " +
			// e.getMessage());
			return "Fatal error opening link: " + e.getMessage();
		}
//		try {
////			ml.discardAnswer();
//			
//		} catch (MathLinkException e) {
//			// System.out.println("Fatal error opening link: " +
//			// e.getMessage());
//			return "MathLinkException Occurred: " + e.getMessage();
//		}
	}
}