<%-- 
    Document   : principal
    Created on : 29/04/2023, 12:47:17 p. m.
    Author     : samue
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<jsp:include page="/Controlador?accion=personas" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Genero</th>
                        <th scope="col">Documento</th>
                        <th scope="col">Tipo Documento</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                          ArrayList<HashMap> personas = (ArrayList<HashMap>) request.getAttribute("personas");
                          for (HashMap persona : personas) {
                              out.print("<tr>");
                              out.print("<td scope='row'>"+persona.get("id")+"</td>");
                              out.print("<td>"+persona.get("nombre")+"</td>");           
                              out.print("<td>"+persona.get("apellido")+"</td>");
                              out.print("<td>"+persona.get("edad")+"</td>");
                              out.print("<td>"+persona.get("genero")+"</td>");
                              out.print("<td>"+persona.get("documento")+"</td>");
                              out.print("<td>"+persona.get("tipoDoc")+"</td>");
                              out.print("</tr>");
                          }
                    %>

                </tbody>
            </table>
            <a href="index.jsp" type="button" class="btn btn-primary">Registrar</a>
        </div>

         </body>
</html>
