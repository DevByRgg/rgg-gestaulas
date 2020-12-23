<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>

<title>Zona Administracion</title>

</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	
	
	
	<div class="container-md w-75">
		
		<div class="pt-5"></div>
		
		
		<h2 class="pt-3">
			Administration <span class="badge text-white bg-cice">ZONE</span>
		</h2>
		
			
		<div class="container-md mt-4">
		
			<div class="card-deck">
					
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Sedes</h5>
					</div>
					<a title="Sedes" href="/aulas/admin/crearSede">
						<img class="card-img-top" src="/aulas/images/sede_800x600.png"  height="200" alt="Card image cap">
					</a>				
				</div>
				
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Aulas</h5>
					</div>
					<a title="Aulas" href="/aulas/admin/crearAula">
						<img class="card-img-top" src="/aulas/images/aula_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Equipos</h5>
					</div>
					<a title="Equipos" href="/aulas/admin/crearOrdenador">
						<img class="card-img-top" src="/aulas/images/ordenador_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Equipamientos</h5>
					</div>
					<a title="Equipamiento" href="/aulas/admin/crearEquipamiento">
						<img class="card-img-top" src="/aulas/images/equipamiento_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
			
			</div>
			
		</div>
		
			
		<h2 class="pt-3">
			Reservation<span class="badge text-white bg-cice">ZONE</span>
		</h2>
		
		
		<div class="container-md mt-4">
	
			<div class="card-deck">
				
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Busqueda</h5>
					</div>
					<a title="Busqueda" href="/aulas/reservas/busquedaReserva">
						<img class="card-img-top" src="/aulas/images/sede_800x600.png"  height="200" alt="Card image cap">
					</a>				
				</div>
				
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Reservar</h5>
					</div>
					<a title="Aulas" href="/aulas/admin/crearReserva">
						<img class="card-img-top" src="/aulas/images/aula_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">Consultar</h5>
					</div>
					<a title="Equipos" href="/aulas/admin/mostrarReserva">
						<img class="card-img-top" src="/aulas/images/ordenador_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
			
			</div>
		
		</div>			
			
    </div>


</body>
</html>