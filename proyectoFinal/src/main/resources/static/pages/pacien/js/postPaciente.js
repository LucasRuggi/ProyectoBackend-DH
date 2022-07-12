    const formulario = this.document.querySelector("#formularioPaciente")

    formulario.addEventListener("submit", function(e) {
        const formData = {
            nombre: document.querySelector("#nombre").value,
            apellido: document.querySelector("#apellido").value,
            domicilio: document.querySelector("#domicilio").value,
            dni: document.querySelector("#dni").value
        }
        const url = "/paciente/agregar"
        const settings = {
            method : "POST",
            headers :  {
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(formData)
        }

        fetch(url, settings)
        .then(response => response.json())
        .then(data =>{
            let successAlert = '<div class="alert alert-success alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong></strong> Paciente agregado </div>'

            document.querySelector("#response").innerHTML = successAlert
            document.querySelector("#response").style.display = "block";
            resetUploadForm()

        })
        .catch(err => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong> Error intente nuevamente</strong> </div>'

            document.querySelector("#response").innerHTML = errorAlert
            document.querySelector("#response").style.display = "block"
            resetUploadForm()

        })
    })

    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#domicilio').value = "";
        document.querySelector('#dni').value = "";
    }
        (function(){
            let pathname = window.location.pathname;
            if(pathname === "/"){
                document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/listaPaciente.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })();
