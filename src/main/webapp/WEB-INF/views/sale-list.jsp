<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <%@ include file="header.jsp" %>
 
 	<div class="content-wrapper">
	    <!-- Main content -->
	    <section class="content">
	    	<!-- /.box-header -->
                <div class="box-body">
                    <table id="relatorio-table" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome do Produto</th>
                            <th>Quantidade</th>
                            <th>Preço</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sale}" var="sale">
                            <tr>
                                <td>${ sale.id }</td>
                                <td>${ sale.product }</td>
                                <td>${ sale.amount }</td>
                                <td>${ sale.sale_value }</td>
                                <td>
                                    <a href="<c:url value='/panel/sale/edit/${provider.id}' />" class="btn btn-box-tool center-block bg-blue" title="Editar"
                                       data-toggle="tooltip">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </a>
                                </td>
                                <td>
                                    <a href="<c:url value='/panel/sale/delete/${provider.id}' />" class="btn btn-box-tool center-block bg-red" data-toggle="tooltip" title="Excluir">
                                        <i class="glyphicon glyphicon-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
	    </section>
    </div>
 
 <%@ include file="footer.jsp" %>