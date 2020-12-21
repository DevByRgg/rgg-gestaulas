var idOrdenador;
		function configurarBorrado(id){
			idOrdenador=id;
		}
		function borrar(){
			window.location.href = "borrarOrdenador?id=" + idOrdenador;
		}