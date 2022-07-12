
    const formulario = document.querySelector('#formularioUpdate');
    formulario.addEventListener('submit', function (e) {

        let pacienteId = document.querySelector('#pacienteId').value;
        const formData = {
            id: document.querySelector('#pacienteId').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            domicilio: document.querySelector('#domicilio').value,
            dni: document.querySelector('#dni').value,
            fechaDeAlta: document.querySelector('#fechaDeAlta').value
        };

        const url = '/paciente';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
    })

    function findBy(id) {
          const url = '/paciente'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#pacienteId').value = paciente.id;
              document.querySelector('#nombre').value = paciente.nombre;
              document.querySelector('#apellido').value = paciente.apellido;
              document.querySelector('#domicilio').value = paciente.domicilio;
              document.querySelector('#dni').value = paciente.dni;
              document.querySelector('#fechaDeAlta').value = paciente.fechaDeAlta;

              document.querySelector('#divFormUpdate').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
              console.log("Error: " + error)
          })
      }
