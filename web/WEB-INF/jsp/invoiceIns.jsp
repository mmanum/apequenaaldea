<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoices - Crear Factura</title>       
        
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
        
        
        <!-- OWN DEVELOPER -->
        <script src="<c:url value='/js/invoices.js'/>" type="text/javascript"></script>
        
    </head>
    <body>        
        <script type="text/javascript">
            function onloadBody() {
                $("#new").css("display","none");
                $("#nav-sales").removeClass('active');
                $("#nav-invoicing").addClass('active');
                $("#nav-picking").removeClass('active');
                $("#nav-contact").removeClass('active');
                
                $('#company').val(${idcompany});
            }
            //document.body.addEventListener('click', function() {alert("click");});
            document.addEventListener("DOMContentLoaded", onloadBody );
        </script>
        
        <jsp:include page="/WEB-INF/jsp/modules/header.jsp" />
        
        <section>  
                
            <%-- El modelAttribute del formulario tiene que tener el mismo nombre que en el Controlador  --%>                
            <form:form modelAttribute="invoicef" method="POST" onsubmit="return valida()" action="invoicing?accion=INS2">
                
                    <legend>Nueva Factura</legend>
                <!-- ------- -->
                <!-- Cliente -->
                <!-- ------- -->

                <table class="invoice-ins-customer table table-striped table-hover">
                    <thead>
                        <tr class="success">
                            <th style="text-align:right">Cliente</th>
                            <th style="text-align:left!important">
                                <form:select id="company" path="" 
                                            onchange="companiesChange('${pageContext.request.contextPath}')">
                                   <optgroup>
                                       <form:options items="${companies}" itemValue="idcompanies" itemLabel="nameCommercial" />
                                   </optgroup>
                               </form:select>
                            </th>                    
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">CIF</th>
                            <td>${picks[0].companies.cif}</td>
                        </tr>         
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">Dirección</th>
                            <td>${picks[0].companies.address}</td>
                        </tr>       
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">Población</th>
                            <td>${picks[0].companies.cp} (${picks[0].companies.city})</td>
                        </tr>      
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">Ayuntamiento</th>
                            <td>${picks[0].companies.state}</td>
                        </tr>                                
                    </tbody>          
                </table>

                    <jsp:include page="/WEB-INF/jsp/modules/pickingList.jsp" />            

                <fieldset class="form-clasico">
                    <div class="invoiceIns-datas">
                        <form:label path="number">Número</form:label>                                 
                        <%-- El path del elemento del formulario tiene que tener el mismo nombre que atributo de la case del modelo --%>
                        <form:input path="number" cssClass="input_field" cssErrorClass="input_error" readonly="true"/>

                        <form:label path="date">Fecha</form:label>                                 
                        <form:input path="date" cssClass="input_field" cssErrorClass="input_error"/>                            
                    </div>
                    <div class="">                            
                        <input type="submit" value="Enviar Datos" class="submit">
                    </div>
                </fieldset>
            </form:form>

            <p style="text-align:center">
                <a href="<c:url value='/invoicing/'/>">Cancelar</a>
            </p>
        </section>
        <jsp:include page="/WEB-INF/jsp/modules/footer.jsp" />
        <p></p>
    </body>
</html>
