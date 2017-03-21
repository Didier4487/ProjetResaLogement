<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="fr.resaLogement.beans.Logement" %>
<%@ page import="fr.resaLogement.beans.Adresse" %>
<%@ page import="fr.resaLogement.beans.Disponibilite" %>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Recherche de logements</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/chosen/!bootstrap-chosen.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
		
		<script type="text/javascript" src="js/jquery-1.12.min.js"></script>
		<script type="text/javascript" src="js/chosen.jquery.js"></script>
		
		<script type="text/javascript">
			function validerLogement() {
				if (confirm('Confirmez-vous le choix de la réservation ?')) {
						document.forms[0].submit();
				}
			}
		</script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$("#choixVille").chosen({
					disable_search_treshold : 10,
					allow_single_deselect: true,
					placeholder_text_single: "",
					no_results_test: "Pas de résultat pour "
				});
				$("#choixDate").chosen({
					disable_search_treshold : 10,
					allow_single_deselect: true,
					placeholder_text_single: "",
					no_results_test: "Pas de résultat pour "
				});
			});
		</script>
		
	</head>
	<body>
	    <jsp:useBean id="villeLogement" class="java.lang.String" scope="request" />
	    <jsp:useBean id="laDateDispo" class="java.lang.String" scope="request" />
	    <jsp:useBean id="logement" class="fr.resaLogement.beans.Logement" scope="request" />
	    <jsp:useBean id="logements" class="java.util.ArrayList" scope="request" />
	    <jsp:useBean id="adresse" class="fr.resaLogement.beans.Adresse" scope="request" />
	    <jsp:useBean id="lesVilles" class="java.util.ArrayList" scope="request" />
	    <jsp:useBean id="lesDisponibilites" class="java.util.ArrayList" scope="request" />
	    
	    <div class="wrapper">
		    <!-- header -->
		    <jsp:include page="/jsp/header.jsp" flush="true"></jsp:include>
		    
			<!--  contenu -->
		   <div class="row main-content">
		    	<div class="container-fluid box-shadow">  
			    	<form method="post" action="rechercher" >
				    	<div class="row">	
				    		<div class="col-xs-12 ">		    			
					        	<fieldset >
					        		<div class="panel panel-primary">
						        		<div class="panel-heading">
						        			<h4>Recherche d'un logement</h4>	
						        		</div>
										<div class="panel-body">
											<div class="row">
												<div class="col-xs-12">																									
													<div class="input-group">
														<span class="input-group-addon">Choix d'une ville</span>																																											
														<select id="choixVille" name="ville" size="1" class="form-control" onchange="document.forms[0].submit();" >
											               	<%
											               		int i = 0;
											               		for (Iterator<Adresse> it = lesVilles.iterator(); it.hasNext();) {
															    	Adresse laVille = it.next();
															    	i++;
															%>    	
															   <option id="<%=i%>" <%if (villeLogement.equals(laVille.getVille())) {%>selected="selected"<%}%>><%=laVille.getVille()%></option>
															<%
																}
															%>
											           	</select>
													</div>
												</div>										
											</div>
											<div class="row">
												<div class="col-xs-12">																									
													<div class="input-group">
														<span class="input-group-addon">Choix d'une date</span>																												
														<select id="choixDate" name="dateDispo" size="1" class="form-control" onchange="document.forms[0].submit();">
											               	<%
											               		int j = 0;
											               		for (Iterator<Disponibilite> it = lesDisponibilites.iterator(); it.hasNext();) {
															    	Disponibilite laDate = it.next();
															    	j++;
															%>    	
															   <option id="<%=j%>" <%if (laDateDispo.equals(laDate.getDateDispo())) {%>selected="selected"<%}%>><%=laDate.getDateDispo()%></option>
															<%
																}
															%>
											           	</select>
													</div>
												</div>											
											</div>
			   							</div>
			   						</div>
			   					</fieldset>		   			
				   			</div>
				   		</div>
				   		<div class="row">	
				    		<div class="col-xs-12 ">
				    			<div class="panel panel-success">
				    				<div class="panel-heading">
										<h4>Liste des logements disponibles</h4>
									</div>
									<div class="panel-body">
										<table class="table table-striped" >
										<tr>
											<th>Nom</th>
											<th>Prénom</th>
											<th>Description</th>
											<th>Adresse</th>
											<th>Ville</th>
											<th>Choix</th>
										</tr>  
										
									<%
									    for (Iterator<Logement> it = logements.iterator(); it.hasNext();) {
									    	Logement leLogement = it.next();
									%>    	
										    <tr>
										    	<td><%=leLogement.getProprietaire().getNom()%></td>
										    	<td><%=leLogement.getProprietaire().getPrenom()%></td>
										    	<td><%=leLogement.getDescription()%></td>
										    	<td><%=leLogement.getAdresse().getNumRue() + " " + leLogement.getAdresse().getNomRue()%></td>
										    	<td><%=leLogement.getAdresse().getCodePostal() + " " + leLogement.getAdresse().getVille()%></td>
										    	<td><input type="checkbox" name="choix" value="<%=leLogement.getIdDisponibilite()%>" onclick="javascript:validerLogement();"></td>
										    </tr>
									<%
										}
									%>
										</table>
									</div>
								</div>
							</div>
						</div>		   	
				   	</form>
				</div>
		   	</div>
		   	
		   	<!--  footer -->
		   	<jsp:include page="/jsp/footer.jsp" flush="true"></jsp:include>			    	  
		</div>
	</body>
</html>