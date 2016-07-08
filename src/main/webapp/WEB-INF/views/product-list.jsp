<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ include file="header.jsp"%>

<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Lista de Produtos</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="relatorio-table"
					class="table table-bordered table-striped">
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
						<c:forEach items="${product}" var="prod">
							<tr>
								<td>${ prod.id }</td>
								<td>${ prod.name }</td>
								<td>${ prod.price }</td>
								<td>${ prod.amount }</td>
								<td><a
									href="<c:url value='/panel/product/edit/${prod.id}' />"
									class="btn btn-box-tool center-block bg-blue" title="Editar"
									data-toggle="tooltip"> <i class="glyphicon glyphicon-edit"></i>
								</a></td>
								<td><a
									href="<c:url value='/panel/product/delete/${prod.id}' />"
									class="btn btn-box-tool center-block bg-red"
									data-toggle="tooltip" title="Excluir"> <i
										class="glyphicon glyphicon-trash"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
	</section>
</div>

<%@ include file="footer.jsp"%>