<%-- 
    Document   : header
    Created on : Mar 25, 2015, 12:58:26 PM
    Author     : manu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header-invoice">
    

    <table class="invoice-mycompany table table-striped table-hover">                            
        <thead>
            
        </thead>
        <tbody>
            <tr>
                <th class="success">${myCompany.nameCommercial}</th>
                <td rowspan="2"><img class="logo-header-invoice" src="${pageContext.request.contextPath}/img/logo.png" /></td>
            </tr>
            <tr>
                <td>
                    ${myCompany.name}<br/>
                    ${myCompany.cif}<br/>
                    ${myCompany.address}<br/>
                    ${myCompany.cp} ${myCompany.city}<br/>                    
                    ${myCompany.state}(${myCompany.country})                    
                </td>
                
            </tr>  
        </tbody>                                    
    </table>
</header>