package fr.resaLogement.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.resaLogement.bdd.TypeLogementBDD;

@SuppressWarnings("serial")
public class ModifierTypeLogement extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String paramName = null;
		int longueurChaine = 0;
		String action = "";
		Enumeration<String> enumeration = request.getParameterNames();
		TypeLogementBDD typeLogement = new TypeLogementBDD();
		
		while (enumeration.hasMoreElements()) {
			paramName = (String) enumeration.nextElement();
		}
		
		longueurChaine = paramName.length();
		action = paramName.substring(longueurChaine-1);
		paramName = paramName.substring(0, longueurChaine-1);
		
		int id = Integer.parseInt(paramName);
		
		request.setAttribute("action", action);
		request.setAttribute("modification", "m");
		request.setAttribute("suppression", "s");
		request.setAttribute("leTypeLogement", typeLogement.getOneTypeLogement(id));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierTypeLogement.jsp").forward(request, response);
		
	}
}
