package src.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.convert.*;

/**
 * Servlet implementation class confirmSubmit
 */
@WebServlet("/confirmSubmit")
public class confirmSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String confirmEquation = request.getParameter("equation");
		String page = null;
		
		System.out.println(confirmEquation);
		// equation convert to Mathematica
		MathematicaConvert mm = new MathematicaConvert();
		mm.setEquation(confirmEquation);
		String equation = mm.calcMathematica();
				
		request.setAttribute("equation", equation);
		request.setAttribute("confirmEquation", confirmEquation);
		page = "/projectjsps/responseValue.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
