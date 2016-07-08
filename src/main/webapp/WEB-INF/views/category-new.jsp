<%@ page language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <%@ include file="header.jsp" %>
 
 	<div class="content-wrapper">
	    <!-- Main content -->
	    <section class="content">
		    <div class="row">
		        <div class="col-xs-12">
		
		            <div class="box">
		                <div class="box-header">
		                    <h3 class="box-title">Adicionar Categoria</h3>
		                </div>
		                <!-- /.box-header -->
		                <div class="box-body">
		                    <form:form method="POST" modelAttribute="category" class="form-horizontal">
		                    	<form:input type="hidden" path="id" id="id" />
		                        <div class="form-group">
		                        	<label class="col-sm-2 control-label" for="name">Categoria</label>
		                            <div class="col-sm-10">
		                            	<form:input type="text" path="name" id="name" />
		                            	<div class="has-error">
				                            <form:errors path="name" class="help-inline" />
				                        </div>
		                            </div>
		                        </div>
		                        <div class="form-group">
		                            <div class="col-sm-offset-2 col-sm-6">
		                                <a href="<c:url value='/panel/category/list' />" class="btn btn-danger" >
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
    </div>
 
 <%@ include file="footer.jsp" %>