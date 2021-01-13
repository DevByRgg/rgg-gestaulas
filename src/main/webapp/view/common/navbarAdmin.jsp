<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-cice">
	<a class="navbar-brand text-white" href="#"> 
        <img src="/aulas/images/logo_blanco_total.svg" height="25"	class="d-inline-block align-top" alt="">
    </a>

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto mr-auto">
			
			<li class="nav-item active mr-3">
        		<a class="nav-link text-white" href="/aulas">Public</a>
      		</li>
			
			<li class="nav-item active mr-5">
        		<a class="nav-link text-white" href="/aulas/admin">Administration</a>
      		</li>
			
			<li class="nav-item dropdown ml-3 mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sede</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/crearSede">Crear</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/mostrarSede">Listado</a>
                </div>
            </li>

			<li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Aula</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/crearAula">Crear Aula</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/mostrarAula">Listado Aula</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/crearTipoAula">Crear Tipo Aula</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/mostrarTipoAula">Listado Tipo Aula</a>
                </div>
            </li>

            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Equipo</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/crearOrdenador">Crear Equipo</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/mostrarOrdenador">Listado Equipo</a>
                </div>
            </li>

            <li class="nav-item dropdown mr-3">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Equipamiento</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/crearEquipamiento">Crear Equipamiento</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/mostrarEquipamiento">Listado Equipamiento</a>
                </div>
            </li>
            
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Usuarios</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/altaUsuario">Crear Usuario</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/admin/mostrarUsuarios">Listado usuarios</a>
                </div>
            </li>
            
            <li class="nav-item dropdown ml-5">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Reserva</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/reservas/crearReserva">Reservar Día</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/reservas/buscarReserva">Reservar Curso</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/reservas/mostrarReserva">Listado Reservas</a>
				</div>
            </li>
            
            <li class="nav-item dropdown ml-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Consulta</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/aulas/consultas/consultarAulasDisponibles">Consultar</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/mantenimiento/crearFestivo">Crear Festivo</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/mantenimiento/crearPeriodoFestivo">Crear Periodo festivo</a>
                    <a class="dropdown-item cice-hover text-white" href="/aulas/mantenimiento/mostrarFestivo">Listado Festivo</a>
                </div>
            </li>
            
            <li class="nav-item"><a class="btn btn-primary float-right mx-3"
				href="<c:url value="/logout" />">Logout</a>
			</li>

		</ul>

	</div>

	<a class="navbar-brand text-light" href="#">
		
        <img src="/aulas/images/logo_blanco_total.svg" height="25"	class="d-inline-block align-top" alt="">
	</a>

</nav>