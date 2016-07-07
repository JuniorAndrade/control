<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <%@ include file="header.jsp" %>
 
 	<div class="content-wrapper">s
	    <!-- Main content -->
	    <section class="content">
	    	<div class="box">
                <div class="box-header">
                    <h3 class="box-title">Lista de Produtos</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <table id="relatorio-table" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome do Produto</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${product}" var="category">
                            <tr>
                                <td>${ product.id }</td>
                                <td>${ product.name }</td>
                                <td>${ product.price }</td>
                                <td>${ product.amount }</td>
                                <td>
                                    <a href="<c:url value='/panel/product/edit/${product.id}' />" class="btn btn-box-tool center-block bg-blue" title="Editar"
                                       data-toggle="tooltip">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </a>
                                </td>
                                <td>
                                    <a href="<c:url value='/panel/product/delete/${product.id}' />" class="btn btn-box-tool center-block bg-red" data-toggle="tooltip" title="Excluir">
                                        <i class="glyphicon glyphicon-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
	    </section>
    </div>
 
 <%@ include file="footer.jsp" %>