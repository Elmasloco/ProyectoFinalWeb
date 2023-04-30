<%-- 
    Document   : index
    Created on : 29/04/2023, 12:40:53 p. m.
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>Formulario de registro</h2>
            <form method="POST" action="Controlador">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" placeholder="Ingresa tu nombre" name="nombre" required="">
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" placeholder="Ingresa tus apellidos" name="apellido" required="">
                </div>
                <div class="form-group">
                    <label for="edad">Edad:</label>
                    <input type="number" class="form-control" id="edad" placeholder="Ingresa tu edad" name="edad">
                </div>
                <div class="form-group">
                    <label for="genero">Género:</label>
                    <select class="form-control" id="genero" name="genero">
                        <option selected disabled>Selecciona tu género</option>
                        <option value="masculino">Masculino</option>
                        <option value="femenino">Femenino</option>
                        <option value="otro">Otro</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="identificacion">Identificación:</label>
                    <input type="number" class="form-control" id="identificacion" placeholder="Ingresa tu numero de identificacion" name="identificacion"> 
                </div>
                <div class="form-group">
                    <label for="tipoIdentificacion">Típo de identificación:</label>
                    <select class="form-control" id="tipoIdentificacion" name="tipoIdentificacion">
                        <option selected disabled>Selecciona tu tipo de documento</option>
                        <option value="C.C.">C.C.</option>
                        <option value="T.I.">T.I.</option>
                        <option value="otro">Otro</option>
                    </select>
                </div>
                <button name="accion" type="submit" class="btn btn-primary" value="agregar">Enviar</button>
                <a href="principal.jsp" type="button" class="btn btn-secondary">Ver registros</a>
            </form>
        </div>
    </body>
</html>