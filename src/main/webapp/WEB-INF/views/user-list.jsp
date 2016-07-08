<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <%@ include file="header.jsp" %>
 
 	<div class="content-wrapper">
	    <section class="content">
	    	<div class="box-body">
                    <table id="relatorio-table" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Usuário</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="users">
                            <tr>
                                <td>${ users.id }</td>
                                <td>${ users.ssoId }</td>
                                <td>${ users.firstName }</td>
                                <td>${ users.email }</td>
                                <td>
                                    <a href="<c:url value='/panel/user/edit/${users.id}' />" title="Editar"
                                       data-toggle="tooltip">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </a>
                                    <a href="<c:url value='/panel/user/delete/${users.id}' />" data-toggle="tooltip" title="Excluir">
                                        <i class="glyphicon glyphicon-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
	    </section>
    </div>
 
 <%@ include file="footer.jsp" %>