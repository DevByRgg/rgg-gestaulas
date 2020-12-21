var idAula;
		function configurarBorrado(id){
			idAula=id;
		}
		function borrar(){
			window.location.href = "borrarAula?id=" + idAula;
		}