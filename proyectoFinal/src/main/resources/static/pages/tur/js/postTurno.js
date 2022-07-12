    const formulario = this.document.querySelector("#formularioTurno")

    formulario.addEventListener("submit", function(e) {
        const formData = {
            date: document.querySelector("#date").value,
            time: document.querySelector("#time").value,
            odontologo: { id : document.querySelector("#odontologo").value} ,
            paciente: { id : document.querySelector("#paciente").value}
        }
        const url = "/turno/agregar"
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
            '<strong></strong> Turno agregado </div>'

            document.querySelector("#response").innerHTML += successAlert
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
        document.querySelector('#date').value = "";
        document.querySelector('#time').value = "";
        document.querySelector('#odontologo').value = "";
        document.querySelector('#paciente').value = "";
    }
        (function(){
            let pathname = window.location.pathname;
            if(pathname === "/"){
                document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/listaTurno.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })();
