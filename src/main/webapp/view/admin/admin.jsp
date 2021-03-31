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
		
			<div class="card-deck text-center">
					
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title align">Sedes</h5>
					</div>
					<a title="Sedes" href="/admin/mostrarSede">
						<img class="card-img-top" src="/images/sede_800x600.png"  height="200" alt="Card image cap">
					</a>				
				</div>
				
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Aulas</h5>
					</div>
					<a title="Aulas" href="/admin/mostrarAula">
						<img class="card-img-top" src="/images/aula_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Equipos</h5>
					</div>
					<a title="Equipos" href="/admin/mostrarOrdenador">
						<img class="card-img-top" src="/images/ordenador_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Equipamientos</h5>
					</div>
					<a title="Equipamiento" href="/admin/mostrarEquipamiento">
						<img class="card-img-top" src="/images/equipamiento_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
			
			</div>
			
		</div>
		
			
		<h2 class="pt-5">
			Reservation <span class="badge text-white bg-cice">ZONE</span>
		</h2>
		
		
		<div class="container-md mt-4">
	
			<div class="card-deck text-center">
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Reservar Dia</h5>
					</div>
					<a title="Reservar dia" href="/reservas/crearReserva">
						<img class="card-img-top" src="/images/curso_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Reservar Curso</h5>
					</div>
					<a title="Reservar curso" href="/reservas/buscarReserva">
						<img class="card-img-top" src="/images/buscar_800x600.png"  height="200" alt="Card image cap">
					</a>				
				</div>
							
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Consultar</h5>
					</div>
					<a title="Consultar aulas disponibles" href="/consultas/consultarAulasDisponibles">
						<img class="card-img-top" src="/images/consulta_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
				
				<div class="card">
					<div class="card-header bg-cice text-white">
						<h5 class="card-title">Crear Festivo</h5>
					</div>
					<a title="Crear festivo" href="/mantenimiento/crearFestivo">
						<img class="card-img-top" src="/images/festivo_800x600.png"  height="200" alt="Card image cap">
					</a>
				</div>
			
			</div>
		
		</div>			
			
    </div>


</body>
</html>