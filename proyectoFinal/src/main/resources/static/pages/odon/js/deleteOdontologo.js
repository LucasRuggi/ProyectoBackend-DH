function deleteBy(id)
{
          const url = '/odontologo/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())

          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();
          alert("Se borró el odontólogo con id " + id)
}