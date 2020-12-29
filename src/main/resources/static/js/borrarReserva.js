var idReserva;
		function configurarBorrado(id){
			idReserva=id;
		}
		function borrar(){
			window.location.href = "borrarReserva?id=" + idReserva;
		}