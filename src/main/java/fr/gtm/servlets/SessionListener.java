//package fr.gtm.servlets;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
//import fr.gtm.entities.Caddy;
//
///**
// * Application Lifecycle Listener implementation class SessionListener
// *
// */
//@WebListener
//public class SessionListener implements HttpSessionListener {
////	 session;
//	private static final Logger LOG = Logger.getLogger("CINOCHE");
//
//	/**
//	 * Default constructor.
//	 */
//	public SessionListener() {
//
//	}
//
//	/**
//	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
//	 */
//	public void sessionCreated(HttpSessionEvent se) {
//		HttpSession session = se.getSession();
//		session.setMaxInactiveInterval(10 * 1);
//
//		LOG.info(">>> création de la session : " + session.getId());
//
//		Caddy caddy = (Caddy) session.getAttribute("caddy");
//
//		try {
//			InitialContext ctx = new InitialContext();
//			caddy = (Caddy) ctx.lookup("java:app/jboss-cinema/Caddy");
//			session.setAttribute("caddy", caddy);
//		} catch (NamingException e) {
//
//			LOG.log(Level.SEVERE, "Erreur de création de session", e);
//		}
//
//	}
//
//	/**
//	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
//	 */
//	public void sessionDestroyed(HttpSessionEvent se) {
//		HttpSession session = se.getSession();
//		LOG.info(">>> destruction de la session : " + session.getId());
//		Caddy caddy = (Caddy) session.getAttribute("caddy");
//		if (caddy != null) {
////    		caddy.remove();
//		}
//	}
//
//}
