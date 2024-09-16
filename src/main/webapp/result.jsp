<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculation Results</title>
<link rel="stylesheet" type="text/css" href="result.css">
</head>
<body>

	<h1>
		Calculation Results for Core Model:
		<%=request.getAttribute("coreModel")%></h1>

	<ul>
		<li>Effective Volume (Ve): <%=request.getAttribute("effectiveVolume")%></li>
		<li>Effective Length (le): <%=request.getAttribute("effectiveLength")%></li>
		<li>Effective Area (Ae): <%=request.getAttribute("effectiveArea")%></li>
		<li>Core Window Area (An): <%=request.getAttribute("coreWindowArea")%></li>
		<li>Core Factor (C_F): <%=request.getAttribute("coreFactor")%></li>
	</ul>

	<a href="index.html">Go back to input page</a>

</body>
</html>