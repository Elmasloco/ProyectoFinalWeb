<%-- 
    Document   : administrador
    Created on : 9/05/2023, 1:34:55 p. m.
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de Inicio de Sesión</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2>Inicio de Sesión</h2>
            <form action="Controlador" method="POST">
                <div class="form-group">
                    <label for="idIngreso">ID de Usuario:</label>
                    <input type="text" class="form-control" id="idIngreso" name="idIngreso" placeholder="Ingrese su ID de usuario">
                </div>
                <div class="form-group">
                    <label for="passIngreso">Contraseña:</label>
                    <input type="password" class="form-control" id="passIngreso" name="passIngreso" placeholder="Ingrese su contraseña">
                </div>
                <button type="submit" class="btn btn-primary" name="accion" value="iniciarsesion">Iniciar Sesión</button>
                <a href="index.jsp" type="button" class="btn btn-secondary">Volver</a>
            </form>
        </div>
    </body>
</html>

