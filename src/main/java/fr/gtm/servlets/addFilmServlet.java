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
import javax.servlet.http.HttpSession;


import fr.gtm.entities.Caddy;
import fr.gtm.entities.Film;
import fr.gtm.entities.FilmDTO;
import fr.gtm.service.FilmService;

/**
 * Servlet implementation class addFilmServlet
 */
@WebServlet("/addFilmServlet")
public class addFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FilmService service;
	@Inject
//	private Caddy caddy = new Caddy();
	private Caddy caddy;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		String identifiant = request.getParameter("id");
		Long id = Long.parseLong(identifiant);
		Film filmajoute = service.getFilmById(id);
		
//		HttpSession session = request.getSession();
		
//		Caddy caddy = (Caddy) session.getAttribute("caddy");
		
		caddy.addFilmDto(new FilmDTO(filmajoute));
		caddy.prixTotal();

		request.setAttribute("caddy", caddy);
		page = "/show-films.jsp";
		
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
