<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="fr.resaLogement.beans.Proprietaire" %>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inscription des propri�taires</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
	</head>
	<body>
	    <jsp:useBean id="proprietaire" class="fr.resaLogement.beans.Proprietaire" scope="request" />
	    <jsp:useBean id="proprietaires" class="java.util.ArrayList" scope="request" />
	    
	    <!-- header -->
    	<jsp:include page="/jsp/header.jsp" flush="true"></jsp:include>
    	
    	<!-- contenu -->
    	<div class="row main-content">
	    	<div class="container-fluid box-shadow">  
		    	<div class="row">	
		    		<div class="col-xs-12 ">
		    			<form method="post" action="proprietaire" >
				        	<fieldset >
				        		<div class="panel panel-primary">
					        		<div class="panel-heading">
					        			<h4>Inscription d'un propri�taire</h4>	
					        		</div>				            				            
									<div class="panel-body">																								
										<div class="input-group">
											<span class="input-group-addon" >Nom du propri�taire</span>
											<input type="text" id="nom" name="nom" class="form-control" placeholder="saisir le nom ...">
										</div>
							
						    			<div class="input-group">
											<span class="input-group-addon" >Pr�nom du propri�taire</span>
											<input type="text" id="prenom" name="prenom" class="form-control" placeholder="saisir le pr�nom ...">
										</div>           
						
						                <div class="input-group">
											<span class="input-group-addon" >T�l�phone du propri�taire</span>
											<input type="text" id="telephone" name="telephone" class="form-control" placeholder="saisir le telephone ...">
										</div> 																	
										<div class="input-group">
											<span class="input-group-addon" >Email du propri�taire</span>
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
								<h4>Liste des propri�taires</h4>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<tr>
										<th>Propi�taires</th>					
										<th>Telephone</th>
										<th>Email</th>
									</tr>  								
							<%
							    for (Iterator<Proprietaire> it = proprietaires.iterator(); it.hasNext();) {
							    	Proprietaire prop = it.next();
							%>    	
									    <tr>									    
									    	<td><%=prop.getPrenom() + " " + prop.getNom()%></td>
									    	<td><%=prop.getTelephone()%></td>
									    	<td><%=prop.getEmail()%></td>
									    </tr>
							<%
								}
							%>
								</table>
							</div>
						</div>
		    		</div>
		    	</div>
	    	</div>
    	</div>	
    	
	    <!-- footer -->
	    <jsp:include page="/jsp/footer.jsp" flush="true"></jsp:include>	    	    		
	    	    	
	</body>
</html>