<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoduin - A Pequena Aldea</title>
        
        
        
        <!-- JSP -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        
        <!-- My CSS -->
        <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/table/table.css'/>">
            
        <!-- JQUERY -->
        <script src="<c:url value='/js/jquery-2.1.3.js'/>" type="text/javascript"></script>
        
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.min.css'/>">
        <script src="<c:url value='/js/bootstrap.min.js'/>"></script>        
        
    </head>

    <body>
        <jsp:include page="/WEB-INF/jsp/modules/header.jsp" />
        <section>
            <h1>Invoduin - A Pequena Aldea</h1>
            <p></p>
            <a href="<c:url value='/invoicing/'/>">Invoices (Facturas)</a>
        
        </section>
    
        <jsp:include page="/WEB-INF/jsp/modules/footer.jsp" />
    </body>
</html>
