var idUsuario;
		function configurarBorrado(id){
			idUsuario = id;
		}
		function borrar(){
			window.location.href = "borrarUsuario?id=" + idUsuario;
		}