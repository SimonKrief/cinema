package fr.gtm.servlets;

import java.io.IOException;
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
import fr.gtm.entities.Film;
import fr.gtm.entities.FilmDTO;
import fr.gtm.service.FilmService;

/**
 * Servlet implementation class removeFilmServlet
 */
@WebServlet("/removeFilmServlet")
public class removeFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FilmService service;
	@Inject
	private Caddy caddy; //= new Caddy()
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeFilmServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		String identifiant = request.getParameter("id");
		Long id = Long.parseLong(identifiant);
		Film filmEnleve = service.getFilmById(id);
		caddy.removeFilmDto(new FilmDTO(filmEnleve));
//		caddy.prixTotal();
		caddy.calculPrixTotal();
		
		request.setAttribute("caddy", caddy);
		page = "/show-caddy.jsp";
		
		//pour afficher les films:
		List<FilmDTO> films = service.getAllFilmsDto();
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
