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
				                    <form:form method="POST" modelAttribute="sale" class="form-horizontal">
				                    	<form:input type="hidden" path="id" id="id" />
				                    	
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="product">Produto</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="product" id="product" />
				                            	<div class="has-error">
						                            <form:errors path="product" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="amount">Quantidade</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="amount" id="amount"/>
				                            	<div class="has-error">
						                            <form:errors path="amount" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                        	<label class="col-sm-2 control-label" for="sale_value">Preço</label>
				                            <div class="col-sm-10">
				                            	<form:input type="text" path="sale_value" id="sale_value" />
				                            	<div class="has-error">
						                            <form:errors path="sale_value" class="help-inline"/>
						                        </div>
				                            </div>
				                        </div>
				                        <div class="form-group">
				                            <div class="col-sm-offset-2 col-sm-6">
				                                <a href="<c:url value='/panel/sale/list' />" class="btn btn-danger" >
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