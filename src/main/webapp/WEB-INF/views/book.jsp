<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='../template/header.jsp'>
	<jsp:param name='title' value='Libro:' />
</jsp:include>

<body>

	<jsp:include page='../template/navbar.jsp'>
		<jsp:param name='title' value='Sistema Web Biblioteca Booklet' />
	</jsp:include>

	<br>
	<br>

	<!--  <section class="h-150">  -->
	<!-- 	<div class="container h-150">  -->
			<div class="row justify-content-sm-center h-150">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg" id="card">
						<div class="card-body p-5">
							<h2 class="fs-4 card-title mb-4">Formulario de
								Registro de Libros</h2>

							<c:if test="${msgError !=null}">
								<div class="alert alert-danger" role="alert">
									<c:out value="${msgError}"></c:out>
								</div>
							</c:if>

							<c:if test="${msgOk !=null}">
								<div class="alert alert-success" role="alert">
									<c:out value="${msgOk}"></c:out>
								</div>
							</c:if>

							<form:form method="POST" action="/book"
								modelAttribute="book">

								<div class="mb-3">
									<!-- <form:label class="mb-2 text-muted" path="titulo">Título del Libro: </form:label> -->
									<form:input type="text" class="form-control" path="titulo"
									placeholder="Ingresa el título del libro" />
									<form:errors path="titulo" class="text-danger" />
								</div>

								<div class="mb-3">
									<!-- <form:label class="mb-2 text-muted" path="anio">Año de Publicación</form:label> -->
									<form:input type="text" class="form-control" path="anio"
										placeholder="Ingresa el año de publicación del libro" />
									<form:errors path="anio" class="text-danger" />
								</div>

								<div class="mb-3">
									<!-- <form:label class="mb-2 text-muted" path="autor">Autor del libro</form:label> -->
									<form:input type="text" class="form-control" path="autor"
										placeholder="Ingresa el nombre del autor del libro" />
									<form:errors path="autor" class="text-danger" />
								</div>
								
								<div class="mb-3">
									<!-- <form:label class="mb-2 text-muted" path="editorial">Editorial del libro</form:label> -->
									<form:input type="text" class="form-control" path="editorial"
										placeholder="Ingresa el nombre de la editorial del libro" />
									<form:errors path="editorial" class="text-danger" />
								</div>

								<div class="mb-3">
									<form:label class="mb-2" path="disponible">Disponibilidad del libro</form:label>
									<form:select class="ms-3" path="disponible">
										<form:option value="true"> Disponible </form:option>
									 	<form:option value="false">No disponible </form:option>
									</form:select>
								</div>
	
								<div class="contenedor-icono">
									<button type="submit" class="btn btn-primary ms-auto"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check2" viewBox="0 0 16 16">
  										<path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
									</svg>
										Registrar Libro</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
	<!--	</div>  -->
	<!-- </section>  -->

	<br>
	<br>

	<jsp:include page='../template/footer.jsp'>
		<jsp:param name='title' value='Sistema Web Biblioteca Booklet' />
	</jsp:include>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js ">
	</script>


</body>
</html>