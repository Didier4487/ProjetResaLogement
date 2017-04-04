<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insérer un type de logement</title>
		<link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/resaLogement.css" rel="stylesheet"/>
		
		<script type="text/javascript">
			function modifierTypeLogement() {
				document.forms[0].submit();
				document.forms[1].submit();
			}
		</script>
		
	</head>
	<body>
    	
    	<!-- header -->
    	<jsp:include page="header.jsp" flush="true"></jsp:include>
    	
    	<!--  contenu -->
    	<div class="row main-content">
	    	<div class="container-fluid box-shadow">  
		    	<div class="row">	
		    		<div class="col-xs-12 ">
		    			<form method="post" action="insererTypeLogement" >
				        	<fieldset >
				        		<div class="panel panel-primary">
					        		<div class="panel-heading">
					        			<h4>Ajouter un type de logement</h4>	
					        		</div>
	   								<div class="panel-body">
	   									<div class="row">
											<div class="col-xs-12">																									
												
											</div>
										</div>									
										<div class="input-group">
											<span class="input-group-addon" >Type logement</span>
											<input type="text" id="typeLogement" name="typeLogement" class="form-control" placeholder="saisir un type de logement ...">
										</div>     
	 										<div class="input-group">
											<span class="input-group-addon" >Description du type </span>
											<input type="text" id="descriptionType" name="descriptionType" class="form-control" placeholder="saisir la description du type de logement ...">
										</div>     									
	   									            
	              						<div class="panel-footer">
											<input type="submit" value="Ajout" class="btn btn-primary" />
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
								<h4>Liste des types de logements</h4>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<tr>										
										<th>Type de logement</th>
										<th>Description</th>
										<th>Modification</th>
										<th>Suppression</th>																				
									</tr>  
									 <c:forEach items="${lestypeslogements}" var="type"  >
									 	<form method="post" action="modifierTypeLogement" >
										 	<tr>
										          <td> ${type.typeLogement}  </td>
										          <td> ${type.descriptionType}  </td>
										          <td><input type="submit" name=${type.idTypeLogement} value="Modification" class="btn btn-xs btn-warning" /></td>
										          <td><input type="submit" name=${type.idTypeLogement} value="Suppression" class="btn btn-xs btn-danger" /></td>
										     </tr>
										</form>
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