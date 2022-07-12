
    const formulario = document.querySelector('#formularioUpdate');
    formulario.addEventListener('submit', function (e) {

        let odontologoId = document.querySelector('#odontologoId').value;
        const formData = {
            id: document.querySelector('#odontologoId').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,
        };

        const url = '/odontologo';
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
          const url = '/odontologo'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              document.querySelector('#odontologoId').value = odontologo.id;
              document.querySelector('#matricula').value = odontologo.matricula;
              document.querySelector('#nombre').value = odontologo.nombre;
              document.querySelector('#apellido').value = odontologo.apellido;

              document.querySelector('#divFormUpdate').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
              console.log("Error: " + error)
          })
      }
