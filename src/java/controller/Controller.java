/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Movie;
import entities.Person;
import entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpautil.JPAUtil;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    private EntityManager em;
    private Query q;
    private List<Person> personas;
    private List<Movie> peliculas;
    private Usuario user;
    private EntityTransaction t;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        String op = request.getParameter("op");
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        
        if (op.equals("inicio")) {
            q = em.createQuery("select m from Movie m");
            peliculas = q.getResultList();
            session.setAttribute("peliculas", peliculas);
            
            q = em.createQuery("select p from Person p");
            personas = q.getResultList();
            session.setAttribute("personas", personas);
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);

        }else if (op.equals("login")) {
            String dni = (String) request.getParameter("dni");
            String nombre = (String) request.getParameter("nombre");
            if (nombre.isEmpty() || dni.isEmpty()){
                session.setAttribute("msg", "Ambos campos son obligatorios...");
            } else {
                user = em.find(Usuario.class, dni);
                if (user == null){
                    Usuario nuevoUsuario = new Usuario(dni);
                    nuevoUsuario.setNombre(nombre);
                    t = em.getTransaction();
                    t.begin();
                    em.persist(nuevoUsuario);
                    t.commit();
                    user = nuevoUsuario;
                }
                session.setAttribute("usuario", user);
            }
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }else if (op.equals("logout")) {
            session.removeAttribute("usuario");
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }else if(op.equals("personomovie")){
            String pulsado = request.getParameter("pulsado");
            session.setAttribute("pulsado", pulsado);
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
