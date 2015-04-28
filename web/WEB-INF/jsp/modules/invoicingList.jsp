<%-- 
    Document   : header
    Created on : Mar 25, 2015, 12:58:26 PM
    Author     : manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin:auto;width:100%;margin-top: 20px">
    <table class="table table-striped table-hover"> <!--class="clasico" -->
        <caption>
            <div>
                <div style="float:left">Listado de Facturas</div>
                <div style="float: right;padding-right: 25px">
                    <a href="#" onclick="window.location='${pageContext.request.contextPath}/invoicing?accion=INS'">
                        <img src="${pageContext.request.contextPath}/css/table/images/ins.png" alt="" title="Nuevo" style="vertical-align: middle"/>
                    </a>
                </div>
                <div style="clear: both"></div>
            </div>
        </caption>    
        <thead>
            <tr class="success">
                <th style="width: 26px"><a href="#" onclick="invoicesUpd()"><img src="${pageContext.request.contextPath}/css/table/images/upd.png" alt="" title="Actualizar"/></a></th>
                <!-- th style="width: 26px"><a href="#" onclick="invoicesUpd()"><img src="${pageContext.request.contextPath}/css/table/images/upd.png" alt="" title="Actualizar"/></a></th>
                <th style="width: 26px"><a href="#" onclick="invoicesDel()"><img src="${pageContext.request.contextPath}/css/table/images/del.png" alt="" title="Retirar"/></a></th -->
                <th style="width: auto">Número Factura</th>
                <th style="width: auto">Fecha</th>
                <th style="width: auto">Nombre Comercial</th>
                <th style="width: auto">Nombre</th>
                <th style="width: auto">Facturado</th>
                <th style="width: auto">Importe</th>                            
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${invoices}" var="invoice">
                <tr onclick="window.document.location='${invoice.idinvoices}';">                                
                    <td><input type="checkbox" name="select" value="${invoice.idinvoices}"/></td> 
                    <!--td><input type="radio" name="upd" value="${invoice.idinvoices}" style="margin: auto; width: auto;"/></td>
                    <td><input type="checkbox" name="del" value="${invoice.idinvoices}"/></td -->                                
                    <td>
                        <%-- form:hidden path="${a.idinvoices}"/ --%>
                        <input type="hidden" name="idinvoices" value="${invoice.idinvoices}"/>
                        ${invoice.number}
                    </td>
                    <td>${invoice.date}</td>
                    <td>${invoice.companies.nameCommercial}</td>
                    <td>${invoice.companies.name}</td>
                    <td>
                        <input type="checkbox" name="invoiced" value="${invoice.idinvoices}" disabled="disabled" ${invoice.invoiced ? 'checked' : ''} style="margin: auto; width: auto;" />
                    </td>
                    <td>
                        ${invoice.taxs + invoice.rates + invoice.amountfree}
                    </td>
                </tr>
            </c:forEach>
        </tbody>                    
        <tfoot>
            <tr>
                <th colspan="100%"><span>A Pequena Aldea</span></th>
            </tr>
        </tfoot>
    </table>
</div>