package fr.gtm.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.entities.Caddy;
import fr.gtm.entities.FilmDTO;
import fr.gtm.service.FilmService;

/**
 * Servlet implementation class CaddyServlet
 */
@WebServlet("/CaddyServlet")
public class CaddyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FilmService service;
	@Inject
	private Caddy caddy;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaddyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		
		caddy.prixTotal();

		request.setAttribute("caddy", caddy);
		page = "/show-caddy.jsp";
		
		//pour afficher les films:
		List<FilmDTO> films = service.getAllFilmsDto();
		
		//pour afficher avec les quantites:
		HashMap<FilmDTO, Integer> FilmQuantite = caddy.getFilmQuantite();
		request.setAttribute("FilmQuantite", FilmQuantite);

		
		request.setAttribute("films", films);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
