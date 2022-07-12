
    const formulario = document.querySelector('#formularioUpdate');
    formulario.addEventListener('submit', function (e) {

        let turnoId = document.querySelector('#turnoId').value;
        const formData = {
            id: document.querySelector('#turnoId').value,
            date: document.querySelector('#date').value,
            time: document.querySelector('#time').value,
            odontologo: { id : document.querySelector("#odontologo").value},
            paciente: { id : document.querySelector("#paciente").value}
        };

        const url = '/turno';
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
          const url = '/turno'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let turno = data;
              document.querySelector('#turnoId').value = turno.id;
              document.querySelector('#date').value = turno.date;
              document.querySelector('#time').value = turno.time;
              document.querySelector('#odontologo').value = turno.odontologo.id,
              document.querySelector('#paciente').value = turno.paciente.id
              document.querySelector('#divFormUpdate').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
              console.log("Error: " + error)
          })
      }