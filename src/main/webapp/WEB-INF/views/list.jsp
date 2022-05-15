<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='../template/header.jsp'>
	<jsp:param name='title' value='Listar Libros:' />
</jsp:include>

<body>

	<jsp:include page='../template/navbar.jsp'>
		<jsp:param name='title' value='Sistema Web Biblioteca Booklet' />
	</jsp:include>

	<br>
	<br>
	
	<div class="container">
	<section class="text-center">
		<h1>Listado de Libros</h1>
	</section>

	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Título</th>
					<th scope="col">Año Publicación</th>
					<th scope="col">Autor</th>
					<th scope="col">Imprenta</th>
					<th scope="col">Disponible</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${listBooks}">
					<tr>
						<th scope="row"><c:out value="${book.id}"></c:out></th>
						<td><c:out value="${book.titulo}"></c:out></td>
						<td><c:out value="${book.anio}"></c:out></td>
						<td><c:out value="${book.autor}"></c:out></td>
						<td><c:out value="${book.editorial}"></c:out></td>
						<td><c:out value="${book.disponible}"></c:out></td>
						<td>
							<a class="btn btn-primary" href="/book/edit/${book.id}" role="button">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
 								<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
								</svg>Editar</a>
							<a class="btn btn-danger" href="/book/delete/${book.id}" role="button">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  								<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  								<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
								</svg> Eliminar</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<br>
	<br>

	<jsp:include page='../template/footer.jsp'>
		<jsp:param name='title' value='Sistema Web Biblioteca Booklet' />
	</jsp:include>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>


</body>
</html>