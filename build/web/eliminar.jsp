<%-- 
    Document   : eliminar
    Created on : May 5, 2023, 8:29:36 PM
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Parcial final: eliminar</title>
    </head>
    <body>
        <div class="container">
            <h1>Eliminar registro</h1>
            <form action="Controlador" method="POST" class="form-floating input-group mb-3">
                <div class="form-group">
                    <input class="form-control" name="id" id="id" required=""/>
                    <label for="id">Id del registro</label>
                    <input class="btn-lg btn btn-warning" type="submit" name="accion" value="buscar y eliminar" />
                </div> 
            </form>
            <form class="text-center p-4" action="Controlador" method="POST">
                <a type="button" class="btn btn-outline-secondary" href="./index.jsp">Cancelar</a>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>

