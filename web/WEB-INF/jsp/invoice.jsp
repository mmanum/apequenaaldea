<%@page contentType="text/html" pageEncoding="UTF-8"%>        
<%@page import="java.text.DecimalFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- JSP -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                
        <!-- My CSS -->
        <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
        
        <!-- JQUERY -->
        <script src="<c:url value='/js/jquery-2.1.3.js'/>" type="text/javascript"></script>
        
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.min.css'/>">
        <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
        
        
        <!-- OWN DEVELOPER -->
        <script src="<c:url value='/js/invoices.js'/>" type="text/javascript"></script>
        


        <title>Invoices - Facturación</title>
    </head>

    <body>
        <jsp:include page="/WEB-INF/jsp/modules/header_invoice.jsp" />
        <section>                  
                <!-- ------------- -->
                <!-- Datos Factura -->
                <!-- ------------- -->
                <table class="invoice-datas table table-striped table-hover" >
                    <thead>
                        <tr class="success" >
                            <th>Fecha</th>
                            <th class="${!invoice.invoiced ? 'danger' : ''}">Factura</th>
                            <th>Cliente</th>
                            <th>C.I.F</th>                                    
                        </tr>
                    </thead>
                    <tbody>
                        <tr onclick="window.document.location='${invoice.idinvoices}';">
                            <td>${invoice.date}</td>
                            <td class="${!invoice.invoiced ? 'danger' : ''}">${invoice.number}</td>
                            <td>${invoice.companies.name}</td>
                            <td>${invoice.companies.cif}</td>
                        </tr>                                
                    </tbody>               
                </table>
                <!-- ------- -->
                <!-- Cliente -->
                <!-- ------- -->
                <table class="invoice-customer table table-striped table-hover" >
                    <thead>
                        <tr class="success">
                            <th style="text-align:right">Cliente</th>
                            <th style="text-align:left!important">${invoice.companies.name}</th>                    
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">CIF</th>
                            <td>${invoice.companies.cif}</td>
                        </tr>         
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">Dirección</th>
                            <td>${invoice.companies.address}</td>
                        </tr>       
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">Población</th>
                            <td>${invoice.companies.cp} (${invoice.companies.city})</td>
                        </tr>      
                        <tr>
                            <td style="text-align:right!important;border-right: 1px solid #ddd !important">Ayuntamiento</th>
                            <td>${invoice.companies.state}</td>
                        </tr>                                
                    </tbody>          
                </table>
                    
            <!-- ------------------ -->
            <!-- Desglose Productos -->
            <!-- ------------------ -->
            <table class="invoice-products table table-striped table-hover">
                <caption>                    
                </caption>    
                <thead>
                    <tr class="success">
                        <th>Producto</th>
                        <th>Unidades</th>
                        <th>Precio</th>
                        <th>Importe</th>                            
                    </tr>
                </thead>
                <tbody>                    
                    <c:forEach items="${picklines}" var="pickline">
                        <tr>
                            <td>
                                <input type="hidden" name="idpickline" value="${pickline.idpicklines}"/>
                                ${ pickline.products.title}
                            </td>
                            <td><fmt:formatNumber type="number" maxIntegerDigits="3" minFractionDigits="3" value="${pickline.amount}"/> ${pickline.products.units}</td>
                            <td>${pickline.price} €</td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" value="${pickline.price * pickline.amount}" /> €</td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </tbody>                    
                <tfoot>
                    <tr>                        
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>${amount}</td>
                        <td>Total Imp. Base</td>
                    </tr>                 
                    <tr>        
                        <td></td>
                        <td></td>
                        <td></td>                
                        <td>${tax}</td>
                        <td>IVA</td>
                    </tr>          
                    <tr>        
                        <td></td>
                        <td></td>
                        <td></td>                
                        <td>${rate}</td>
                        <td>Punto Verde</td>
                    </tr>       
                    <tr>        
                        <td></td>
                        <td></td>
                        <td></td>                
                        <td style='border-top: 2px solid black;'>${total}</td>
                        <td style='border-top: 2px solid black;width:125px'><strong>Total</strong></td>
                    </tr>
                </tfoot>
            </table>
                      
               
            
            <p style="text-align:center">
                <a href="<c:url value='/invoicing/'/>">Volver</a>
            </p>
                
        </section>
        <jsp:include page="/WEB-INF/jsp/modules/footer.jsp" />
    </body>
</html>
