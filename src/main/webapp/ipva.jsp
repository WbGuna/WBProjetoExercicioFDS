<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	    <title>IPVA</title>
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
		                            <a class="nav-link text-white" href="formularioIpva.jsp">Altera ANO</a>
		                        </li>
		                    </ul>
		                </div>
		            </div>
		        </nav>
		    </div>
		    
			<div class="container">
				<div class="row justify-content-center">
			      <h1 class= col-10 >Data Cadastrada</h1>
			      <hr>
				</div>
			</div>
	    </header>
	
	    <div class="container">
	        <form action="ServletIpva" method="post">	            
	            <button type="submit" class="btn btn-warning mb-3" name="option" value="listagem" >Carregar Lista</button>
	        </form>
	
	
	        <table class="table mt-5">
	            <thead class="thead-dark">
	                <tr>
	                    <th scope="col">Id</th>
	                    <th scope="col">Ano</th>               
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="user" items="${lista}">  
	                	<form action="ServletIpva" method="post">           	
		                  	<tr>
		                      <input type="hidden" name="id" value="${user.id}"/>
		                      
	                           <td>${user.id} </td>
	                           <td>${user.ano}</td> 
	                                                 	                           
	                           <td>
	                           	<button type="submit" name="option" value="updateForm" class="btn-warning btn ">Alterar</button>
	                           </td>      
		                     </tr>
	                  	 </form> 
	               </c:forEach>        
	            </tbody>
	        </table>
	    </div>
	</body>
</html>