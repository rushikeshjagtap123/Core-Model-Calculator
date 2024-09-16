package com.coreCalculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CoreModel;

@WebServlet("/CoreCalculator")
public class CoreCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String coreModel = request.getParameter("coreModel");

		System.out.println("coreModel : --> " + coreModel);

		CoreModel model;
		try {
			model = new CoreModel(coreModel);
		} catch (IllegalArgumentException e) {

			request.setAttribute("errorMessage", "Invalid core model format. Please use the format EExx/yy/zz.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}

		double effectiveVolume = model.calculateEffectiveVolume();
		double effectiveLength = model.calculateEffectiveLength();
		double effectiveArea = model.calculateEffectiveArea();
		double coreWindowArea = model.calculateCoreWindowArea();
		double coreFactor = model.calculateCoreFactor();

		request.setAttribute("coreModel", coreModel);
		request.setAttribute("effectiveVolume", effectiveVolume);
		request.setAttribute("effectiveLength", effectiveLength);
		request.setAttribute("effectiveArea", effectiveArea);
		request.setAttribute("coreWindowArea", coreWindowArea);
		request.setAttribute("coreFactor", coreFactor);

		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}