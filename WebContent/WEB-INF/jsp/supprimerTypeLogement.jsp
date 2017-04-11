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
					        			<h4>Modifier un type de logement</h4>	
					        		</div>
	   								<div class="panel-body">		     
	 									<div class="input-group">
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
										<input type="submit" value="Modification" class="btn btn-primary" />
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