<%-- 
    Document   : header
    Created on : Mar 25, 2015, 12:58:26 PM
    Author     : manu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">                  
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>            
                <span class="navbar-brand" href="#">A Pequena Aldea</span>
                <%-- img src="${pageContext.request.contextPath}/img/logo.png" class='logo-header'/ --%>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <%-- li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li --%>
                    <li id="nav-sales" class="active"><a href="<c:url value='/sales/'/>">Ventas</a></li>
                    <li id="nav-invoicing"><a href="<c:url value='/invoicing/'/>">Facturación</a></li>
                    <li id="nav-picking"><a href="<c:url value='/picking/'/>">Albaranes</a></li>
                    <li id="nav-contact"><a href="<c:url value='/contact/'/>">Contacto</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
    
</header>