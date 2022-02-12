<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

	 <head>
	     <meta charset="UTF-8">
	     <meta http-equiv="X-UA-Compatible" content="IE=edge">
	     <meta name="viewport" content="width=device-width, initial-scale=1.0">
	     <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	     <title>Exercicio FDS</title>
	 </head>

	<body>
		<header>
		    <div class="d-flex flex-column wrapper">
		        <nav class="navbar navbar-expand-lg navbar-dark bg-warning border-bottom shadow-sm mb-3">
		            <div class="container">
		                <a class="navbar-brand" href="index.html"><b>WB-Online</b></a>
		                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		                    data-bs-target=".navbar-collapse">
		                    <span class="navbar-toggler-icon"></span>
		                </button>
		                <div class="collapse navbar-collapse">
		                    <ul class="navbar-nav flex-grow-1">
		                        <li class="nav-item">
		                            <a class="nav-link text-white" href="carro.jsp">Veiculos</a>
		                        </li>
		                    </ul>
		                </div>
		            </div>
		        </nav>
    		</div>
		</header>
	
		<div class="container mt-5">
			<div class="row">
		  		<div class="col-md-5 mx-auto border text-center">
		    		<h3>Cadastrar Veiculo</h3>
		    			<form method="post" action="ServletCarro">
		      				<input type="hidden" name="id" value="${user.id}" />
								
							<div class="form-group" style="text-align-last: left;">
								<label for="nome" class="form-label">Modelo:</label>
								<input type="text" class="form-control" name="modelo" value="${user.modelo}" required>
							</div>
							
							<div class="form-group" style="text-align-last: left;">
								<label for="email">Cor:</label>
								<input type="text" class="form-control" name="cor" value="${user.cor}" required>
							</div>		
		
							<div class="form-group" style="text-align-last: left;">
								<label for="email">Ano:</label>
								<input type="text" class="form-control" name="ano" value="${user.ano}" required>
							</div>				
							<c:choose>
								<c:when test="${user == null}">
									<button type="submit" class="btn btn-warning col-2 mb-3 mt-3" name="option" value="insert">Salvar</button>
								</c:when>
								<c:otherwise>
									<button type="submit" class="btn btn-warning col-2 mb-3 mt-3" name="option" value="update">Atualizar</button>
								</c:otherwise>
							</c:choose>
		   				</form>
		    	</div>
		  	</div>
		</div>            
	</body>
</html>