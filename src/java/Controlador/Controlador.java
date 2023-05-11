/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Administrador;
import Modelo.Persona;
import Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samue
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private PersonaDAO pdao = new PersonaDAO();
    private Persona persona;

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String accion = request.getParameter("accion");
        System.out.println("ACCION GET: " + accion);
        switch (accion) {
            case "personas":
                request.setAttribute("personas", pdao.listar());
                break;
            case "buscar":
                String personaId = request.getParameter("personaId");
                System.out.println("personaId: " + personaId);
                if (!personaId.isBlank()) {
                    HashMap persona = pdao.buscar(Integer.parseInt(personaId));
                    System.out.println("persona" + persona);
                    if (persona != null) {
                        request.setAttribute("persona", persona);
                    }
                }
                break;
            default:
                break;
        }

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

        String personaId;
        String accion = request.getParameter("accion");
        System.out.println("ACCION: " + accion);
        switch (accion) {
            case "agregar":
            try {
                String rolPersona = request.getParameter("tipoRol");
                System.out.println("ROL: " + rolPersona);
                if (rolPersona.equalsIgnoreCase("User")) {
                    persona = new Usuario(request);
                    pdao.insertar(persona);
                    System.out.println(persona);
                    response.sendRedirect("principal.jsp");
                } else if (rolPersona.equalsIgnoreCase("Admin")) {
                    String cargo = request.getParameter("tipoCargo");
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    persona = new Administrador(request);
                    Administrador admin = new Administrador(nombre, apellido, cargo);
                    pdao.insertar(persona);
                    pdao.insertarAdmin(admin);
                    System.out.println(admin);
                    System.out.println(persona);
                    response.sendRedirect("principal.jsp");
                }
            } catch (SQLException e) {
                System.out.println("Error al crear. " + e.getMessage());
            }
            break;
            case "eliminar":
                personaId = request.getParameter("id");
                if (!personaId.isBlank()) {
                    int id = Integer.parseInt(personaId);
                    pdao.eliminar(id);
                    response.sendRedirect("./principal.jsp");
                }
                break;
            case "modificar":
            try {
                persona = new Persona(request);
                System.out.println(persona);
                pdao.actualizar(persona);
                response.sendRedirect("./principal.jsp");
            } catch (SQLException e) {
                System.out.println("Error al modificar. " + e.getMessage());
            }
            break;
            case "iniciarsesion":
<<<<<<< HEAD
                String id = request.getParameter("ingresID");
                System.out.println("ID: " + id);
                try {
                    int idConvert = Integer.parseInt(id);
                    boolean ingreso = pdao.ingreso(idConvert);
                    if (ingreso == true) {
                        response.sendRedirect("principal.jsp");
                    } else {
                        request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
                    }
                } catch (ServletException | IOException | NumberFormatException e) {
                    System.out.println("Error al iniciar sesion");
                    System.out.println("Error: " + e);
                }

=======
                String id = request.getParameter("idIngreso");
                String pass = request.getParameter("passIngreso");
                System.out.println("ID: "+id+" PASSWORD: "+pass);
                boolean ingreso = pdao.ingreso(Integer.parseInt(id), pass);
                if(ingreso == true){
                    response.sendRedirect("principal.jsp");
                }else{
                    request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
                }                
>>>>>>> 062d9a177acd224b98c3fc385c81aeb12738a397
                break;

            default:
                break;
        }

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
