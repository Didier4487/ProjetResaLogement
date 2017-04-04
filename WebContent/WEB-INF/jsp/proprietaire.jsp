<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.resaLogement.beans.Proprietaire" %>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inscription des propriétaires</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
	</head>
	<body>
	    <jsp:useBean id="proprietaire" class="fr.resaLogement.beans.Proprietaire" scope="request" />
	    <jsp:useBean id="proprietaires" class="java.util.ArrayList" scope="request" />
	    
	    <!-- header -->
    	<jsp:include page="header.jsp"></jsp:include>
    	
    	<!-- contenu -->
    	<div class="row main-content">
	    	<div class="container-fluid box-shadow">  
		    	<div class="row">	
		    		<div class="col-xs-12 ">
		    			<form method="post" action="proprietaire" >
				        	<fieldset >
				        		<div class="panel panel-primary">
					        		<div class="panel-heading">
					        			<h4>Inscription d'un propriétaire</h4>	
					        		</div>				            				            
									<div class="panel-body">																								
										<div class="input-group">
											<span class="input-group-addon" >Nom du propriétaire</span>
											<input type="text" id="nom" name="nom" class="form-control" placeholder="saisir le nom ...">
										</div>
							
						    			<div class="input-group">
											<span class="input-group-addon" >Prénom du propriétaire</span>
											<input type="text" id="prenom" name="prenom" class="form-control" placeholder="saisir le prénom ...">
										</div>           
						
						                <div class="input-group">
											<span class="input-group-addon" >Téléphone du propriétaire</span>
											<input type="text" id="telephone" name="telephone" class="form-control" placeholder="saisir le telephone ...">
										</div> 																	
										<div class="input-group">
											<span class="input-group-addon" >Email du propriétaire</span>
											<input type="text" id="email" name="email" class="form-control" placeholder="saisir l'email ...">
										</div> 				            
									</div>
									<div class="panel-footer">
										<input type="submit" value="Inscription" class="btn btn-primary" />
									</div>
								</div>
				           </fieldset>
				       </form>
		    		</div>
		    	</div>
		    	
		    	<div class="row">	
		    		<div class="col-xs-12">
		    			<div class="panel panel-default">
		    				<div class="panel-heading">
								<h4>Liste des propriétaires</h4>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<tr>
										<th>Propriétaires</th>					
										<th>Telephone</th>
										<th>Email</th>
									</tr>  								
									 <c:forEach items="${proprietaires}" var="proprietaire"  >
									 	<tr>
									          <td> ${proprietaire.prenom}  </td>
									          <td> ${proprietaire.telephone}  </td>
									          <td> ${proprietaire.email}  </td>
									     </tr>
									</c:forEach> 
								</table>
							</div>
						</div>
		    		</div>
		    	</div>	
	    	</div>
    	</div>	
    	
	    <!-- footer -->
	    <jsp:include page="footer.jsp"></jsp:include>	    	    		
	    	    	
	</body>
</html>