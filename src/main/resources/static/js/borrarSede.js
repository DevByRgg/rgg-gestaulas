var idSede;
		function configurarBorrado(id){
			idSede=id;
		}
		function borrar(){
			window.location.href = "borrarSede?id=" + idSede;
		}
