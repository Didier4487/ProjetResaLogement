<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Modifier un type de logement</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
	</head>
	<body>
    	
    	<!-- header -->
    	<jsp:include page="header.jsp" flush="true"></jsp:include>
    	
    	<!--  contenu -->
    	<div class="row main-content">
	    	<div class="container-fluid box-shadow">  
		    	<div class="row">	
		    		<div class="col-xs-12 ">
		    			<form method="post" action="validerTypeLogement" >
				        	<fieldset >
				        		<div class="panel panel-primary">
					        		<div class="panel-heading">
					        			<c:if test="${ action == modification }"><h4>Modifier un type de logement</h4></c:if>
					        			<c:if test="${ action == suppression }"><h4>Supprimer un type de logement</h4></c:if>
					        		</div>
	   								<div class="panel-body">	
	   									<div class="input-group cache">
											<span class="input-group-addon" >action </span>
											<input type="text" id="action" name="action" class="form-control"  value="${action}">
										</div> 		     
	 									<div class="cache">
											<span class="input-group-addon" >id </span>
											<input type="text" id="descriptionType" name="idTypeLogement" class="form-control"  value="${leTypeLogement.idTypeLogement}">
										</div> 							
										<div class="input-group">
											<span class="input-group-addon" >Type logement</span>
											<input type="text" id="typeLogement" name="typeLogement" class="form-control"  value="${leTypeLogement.typeLogement}">
										</div>     
	 									<div class="input-group">
											<span class="input-group-addon" >Description du type </span>
											<input type="text" id="descriptionType" name="descriptionType" class="form-control"  value="${leTypeLogement.descriptionType}">
										</div>     									
	   								</div>       
              						<div class="panel-footer">
              							<c:if test="${ action == modification }"><input type="submit" value="Modification" class="btn btn-primary" /></c:if>
										<c:if test="${ action == suppression }"><input type="submit" value="Suppression" class="btn btn-danger" /></c:if>
									
									</div>
								</div>
				           </fieldset>
				       </form>
		    		</div>
		    	</div>		    	
	    	</div>	
	    </div>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>		
	
	</body>
</html>