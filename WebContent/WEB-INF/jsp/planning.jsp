<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="fr.resaLogement.beans.Logement" %>
<%@ page import="fr.resaLogement.beans.Disponibilite" %>
<%@ page import="fr.resaLogement.beans.Adresse" %>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lister les disponibilités d'un logement</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
	</head>
	<body>
	    <jsp:useBean id="logement" class="fr.resaLogement.beans.Logement" scope="request" />
	    <jsp:useBean id="lesLogements" class="java.util.ArrayList" scope="request" />
	    <jsp:useBean id="lesDisponibilites" class="java.util.ArrayList" scope="request" />
	    <jsp:useBean id="lesVilles" class="java.util.ArrayList" scope="request" />
	   <jsp:useBean id="villeLogement" class="java.lang.String" scope="request" />
	   <jsp:useBean id="descriptionLogement" class="java.lang.String" scope="request" />
    	
    	<!-- header -->
    	<jsp:include page="header.jsp" flush="true"></jsp:include>
    	
    	<!--  contenu -->
    	<div class="row main-content">
	    	<div class="container-fluid box-shadow">  
		    	<div class="row">	
		    		<div class="col-xs-12 ">
		    			<form method="post" action="planning" >
				        	<fieldset >
				        		<div class="panel panel-primary">
					        		<div class="panel-heading">
					        			<h4>Lister les disponibilités d'un logement</h4>	
					        		</div>
	   								<div class="panel-body">
	   									<div class="row">
											<div class="col-xs-12">																									
												<div class="input-group">
														<span class="input-group-addon">Choix d'une ville</span>	
														<select id="choixVille" name="ville"  size="1" class="form-control" onchange="document.forms[0].submit();">
															<option <c:if test="${ empty villeLogement }">selected</c:if>
																		value="0">Choisir une ville</option>										     
															 <c:forEach items="${lesVilles}" var="villes"  >
															 	 <option <c:if test="${ villes.ville == villeLogement }">selected</c:if> value="<c:out value="${villes.ville }"/>">
															 	  ${villes.ville}</option>
															</c:forEach> 
											           	</select>																																											
														
												</div>
												<div class="input-group">
														<span class="input-group-addon">Choix d'un logement</span>	
														<select id="choixLogement" name="logement"  size="1" class="form-control" onchange="document.forms[0].submit();">	
															<option <c:if test="${ empty descriptionLogement }">selected</c:if>
																		value="0">Choisir un logement</option>										     
															 <c:forEach items="${lesLogements}" var="logement"  >
															 	<option <c:if test="${logement.description == descriptionLogement }">selected</c:if> value="<c:out value="${logement.description}"/>">
															 	  ${logement.description}</option>
														
															</c:forEach> 
											           	</select>																																										
														
												</div>
																																		
											</div>																			
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
								<h4>Planning des disponibilités : <%=descriptionLogement %> à ${villeLogement}</h4>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<tr>										
										<th>Date</th>
										<th>Disponibilité</th>
									</tr>  
									
									 <c:forEach items="${lesDisponibilites}" var="laDispo"  >
									 	<tr>
									          <td> ${laDispo.dateDispo}  </td>
									          <td> ${laDispo.disponibilite}  </td>									
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
		<jsp:include page="footer.jsp" flush="true"></jsp:include>		
	
	</body>
</html>