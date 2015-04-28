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
                <div style="float:left">Listado de Albaranes</div>
                <div id="new" style="float: right;padding-right: 25px">
                    <a href="#" onclick="invoicesIns()">
                        <img src="${pageContext.request.contextPath}/css/table/images/ins.png" alt="" title="Nuevo" style="vertical-align: middle"/>
                    </a>
                </div>
                <div style="clear: both"></div>
            </div>
        </caption>    
        <thead>
            <tr class="success">
                <th style="width: 26px"><a href="#" onclick="invoicesUpd()"><img src="${pageContext.request.contextPath}/css/table/images/upd.png" alt="" title="Actualizar"/></a></th>
                <th style="width: auto">Número Albarán</th>
                <th style="width: auto">Fecha</th>
                <th style="width: auto">Nombre Comercial</th>
                <th style="width: auto">Nombre</th>
                <th style="width: auto">Entregado</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${picks}" var="pick">
                <tr onclick="window.document.location='${pick.idpickings}';">
                    <td><input type="checkbox" name="select" value="${pick.idpickings}"/></td> 
                    <td>                        
                        <input type="hidden" name="idpickings" value="${pick.idpickings}"/>
                        ${pick.number}
                    </td>
                    <td>${pick.date}</td>
                    <td>${pick.companies.nameCommercial}</td>
                    <td>${pick.companies.name}</td>
                    <td>
                        <input type="checkbox" name="committed" value="${pick.idpickings}" disabled="disabled" ${pick.committed ? 'checked' : ''} style="margin: auto; width: auto;" />
                    </td>
                </tr>
            </c:forEach>
        </tbody>                    
        <!--tfoot>
            <tr>
                <th colspan="7">A Pequena Aldea</span></th>
            </tr>
        </tfoot-->
    </table>
</div>