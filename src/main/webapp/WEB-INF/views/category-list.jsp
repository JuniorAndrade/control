<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <%@ include file="header.jsp" %>
 
 	<div class="content-wrapper">
	    <!-- Main content -->
	    <section class="content">
	    	<div class="row">
		        <div class="col-xs-12">
		
		            <div class="box">
		                <div class="box-header">
		                    <h3 class="box-title">Lista de Categorias</h3>
		                </div>
		                <!-- /.box-header -->
		                <div class="box-body">
		                    <table id="relatorio-table" class="table table-bordered table-striped">
		                        <thead>
		                        <tr>
		                            <th>Id</th>
		                            <th>Nome da Categoria</th>
		                            <th></th>
		                            <th></th>
		                            <th></th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <c:forEach items="${category}" var="category">
		                            <tr>
		                                <td>${ category.id }</td>
		                                <td>${ category.name }</td>
		                                <td></td>
		                                <td>
		                                    <a href="<c:url value='/panel/category/edit/${category.id}' />" class="btn btn-box-tool center-block bg-blue" title="Editar Categoria"
		                                       data-toggle="tooltip">
		                                        <i class="glyphicon glyphicon-edit"></i>
		                                    </a>
		                                </td>
		                                <td>
		                                    <a href="<c:url value='/panel/category/delete/${category.id}' />" class="btn btn-box-tool center-block bg-red" data-toggle="tooltip" title="Excluir Categoria">
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
		
		        </div>
		    </div>
	    </section>
    </div>
 
 <%@ include file="footer.jsp" %>