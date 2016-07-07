<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="header.jsp" %>
 
 	<div class="content-wrapper">
	    <!-- Main content -->
	    <section class="content">
	    	<section class="content">
			    	<div class="row">
				        <div class="col-xs-12">
				
				            <div class="box">
				                <div class="box-header">
				                    <h3 class="box-title">Adicionar Venda</h3>
				                </div>
				                <!-- /.box-header -->
				                <div class="box-body">
				                    <form:form method="POST" modelAttribute="user" class="form-horizontal">
				                    	<form:input type="hidden" path="id" id="id" />
				                    	
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="ssoId">Usuário</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="ssoId" id="ssoId" />
				                            	<div class="has-error">
						                            <form:errors path="ssoId" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="password">Senha</label>
				                            <div class="col-sm-10">
				                            	<form:input type="password" path="password" id="password"/>
				                            	<div class="has-error">
						                            <form:errors path="password" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="firstName">Primeiro Nome</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="firstName" id="firstName" />
				                            	<div class="has-error">
						                            <form:errors path="firstName" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="lastName">Segundo Nome</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="lastName" id="lastName" />
				                            	<div class="has-error">
						                            <form:errors path="lastName" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="email">Email</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="email" id="email" />
				                            	<div class="has-error">
						                            <form:errors path="email" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="userProfiles">Permissões</label>
				                            <div class="col-sm-10">
				                            	<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
				                            	<div class="has-error">
						                            <form:errors path="userProfiles" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                            <div class="col-sm-offset-2 col-sm-6">
				                                <a href="<c:url value='/panel/user/list' />" class="btn btn-danger" >
				                                    <i class="fa fa-close"></i>
				                                    Cancelar
				                                </a>
				                                <button type="submit" class="btn btn-success">
				                                    <i class="fa fa-check"></i>
				                                    Salvar
				                                </button>
				                            </div>
				                        </div>
				                    </form:form>
				                </div>
				            </div>
				        </div>
				    </div>
			    </section>
	    </section>
    </div>
 
 <%@ include file="footer.jsp" %>