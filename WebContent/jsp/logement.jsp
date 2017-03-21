<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="fr.resaLogement.beans.Logement" %>
<%@ page import="fr.resaLogement.beans.Proprietaire" %>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inscription des logements</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
	</head>
	<body>
	    <jsp:useBean id="logement" class="fr.resaLogement.beans.Logement" scope="request" />
	    <jsp:useBean id="proprietaire" class="fr.resaLogement.beans.Proprietaire" scope="request" />
	    <jsp:useBean id="logements" class="java.util.ArrayList" scope="request" />
	    <jsp:useBean id="proprietaires" class="java.util.ArrayList" scope="request" />
    	
    	<!-- header -->
    	<jsp:include page="/jsp/header.jsp" flush="true"></jsp:include>
    	
    	<!--  contenu -->
    	<div class="row main-content">
	    	<div class="container-fluid box-shadow">  
		    	<div class="row">	
		    		<div class="col-xs-12 ">
		    			<form method="post" action="logement" >
				        	<fieldset >
				        		<div class="panel panel-primary">
					        		<div class="panel-heading">
					        			<h4>Inscription d'un logement</h4>	
					        		</div>
	   								<div class="panel-body">
	   									<div class="row">
											<div class="col-xs-12">																									
												<div class="input-group">
													<span class="input-group-addon">Choix du propriétaire</span>												
													<select id="idProprietaire" name="idProprietaire"  size="1" class="form-control">
										               	<%
										               		for (Iterator<Proprietaire> it = proprietaires.iterator(); it.hasNext();) {
														    	Proprietaire leProprietaire = it.next();
														%>    	
															   <option value="<%=leProprietaire.getIdProprietaire()%>"><%=leProprietaire.getNomPrenom()%></option>
														<%
															}
														%>
										           	</select>											
												</div>
											</div>
										</div>									
										<div class="input-group">
											<span class="input-group-addon" >Description</span>
											<input type="text" id="description" name="description" class="form-control" placeholder="saisir une description rapide du logement ...">
										</div>     
	 										<div class="input-group">
											<span class="input-group-addon" >Numéro de la rue</span>
											<input type="text" id="numRue" name="numRue" class="form-control" placeholder="saisir le numéro de la rue ...">
										</div>     									
	   									<div class="input-group">
											<span class="input-group-addon" >Nom de la rue</span>
											<input type="text" id="nomRue" name="nomRue" class="form-control" placeholder="saisir le nom de la rue ...">
										</div>    										
	  										<div class="input-group">
											<span class="input-group-addon" >Code postal</span>
											<input type="text" id="codePostal" name="codePostal" class="form-control" placeholder="saisir le code postal ...">
										</div> 
										<div class="input-group">
											<span class="input-group-addon" >Ville</span>
											<input type="text" id="ville" name="ville" class="form-control" placeholder="saisir le nom de la ville ...">
										</div>               
	              							<div class="panel-footer">
											<input type="submit" value="Inscription" class="btn btn-primary" />
										</div>
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
								<h4>Liste des logements</h4>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<tr>										
										<th>Description</th>
										<th>Propriétaire</th>
										<th>Adresse</th>
										<th>Ville</th>
									</tr>  
						
						<%
						    for (Iterator<Logement> it = logements.iterator(); it.hasNext();) {
						    	Logement leLogement = it.next();
						%>    	
								    <tr>								    	
								    	<td><%=leLogement.getDescription()%></td>
								    	<td><%=leLogement.getPrenomNom()%></td>
								    	<td><%=leLogement.getAdresseComplete()%></td>
								    	<td><%=leLogement.getVille()%></td>
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