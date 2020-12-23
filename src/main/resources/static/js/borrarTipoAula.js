var idTipoAula;
		function configurarBorrado(id){
			idTipoAula=id;
		}
		function borrar(){
			window.location.href = "borrarTipoAula?id=" + idTipoAula;
		}