<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ACCUEIL</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
	</head>
	<body>
		<div class="wrapper">
		    <!-- header -->
		   	<jsp:include page="header.jsp"></jsp:include>
		   	
		   	<!-- contenu -->
		   	<div class="row main-content">
		    	<div class="container-fluid box-shadow">    		
			    	<div class="row">	
			    		<div class="col-xs-8 col-xs-offset-2">
			    			<p class="titre">Réserver un logement </p>
			    			<img id="imgAccueil" src="images/appart.jpg" alt="vue intérieure d'un appartement" title="vue intérieure d'un appartement">
			    		</div>
			    	</div>	    		    	
		    	</div>
	    	</div>
	    	<!-- footer -->	 
	    	<jsp:include page="footer.jsp" flush="true"></jsp:include>
		</div>
	</body>
</html>