class TablaDinamica extends HTMLElement{
    constructor(){
        super();
        this._text = null;

    }

    connectedCallback(){
        const shadow = this.attachShadow({mode: 'open'});
        shadow.innerHTML=`
                    
                    <style>
                    table{
                      width: 100%;
                      background-color: #ffffff;
                      border-collapse: collapse;
                      border-width: 2px;
                      border-color: #636bf3;
                      border-style: solid;
                      color: #000000;
                    }
                    
                    td, th {
                      border-width: 2px;
                      border-color: #636bf3;
                      border-style: solid;
                      padding: 3px;
                    }
                    
                    th {
                      background-color: #8b90ed;
                    }
                    </style>
                <div>
                    <slot entidad = 'entidad'></slot>
                </div>`;
        const contenedor = document.createElement('div');
        contenedor.id = 'tbl';
        let tabla = document.createElement('table');
        tabla.id = 'idTabla';
        tabla.scrollIntoView();
        let header = document.createElement('th');
        header.id = 'idHeader';
        let celda = document.createElement('td');
        celda.id = 'idCelda';

        var datajson = []; //arreglo de objetos obtenidos del json


        let createTableFromJSON =  function (myBooks) {

              /*  var myBooks = [
                    {
                        "Book ID": "1",
                        "Book Name": "Computer Architecture",
                        "Category": "Computers",
                        "Price": "125.60"
                    },
                    {
                        "Book ID": "2",
                        "Book Name": "Asp.Net 4 Blue Book",
                        "Category": "Programming",
                        "Price": "56.00"
                    },
                    {
                        "Book ID": "3",
                        "Book Name": "Popular Science",
                        "Category": "Science",
                        "Price": "210.40"
                    }
                ]
*/
                // EXTRACT VALUE FOR HTML HEADER.
                // ('Book ID', 'Book Name', 'Category' and 'Price')

                var col = [];
                var ids = [];

                var pivote;

                var count=0;
                for (var i = 0; i < myBooks.length; i++) {

                    for (var key in myBooks[i]) {
                        if (col.indexOf(key) === -1) {
                            col.push(key);
                            if(key.indexOf("Collec") > -1){
                                pivote=key
                              //  console.log(key);
                            }
                            if(key.indexOf("id") > -1){
                                ids[count]= key;
                                count++;
                            }
                        }

                    }
                }
/*
                for(ids of ids){
                    console.log(ids);
                }*/

                var tr = tabla.insertRow(-1);                   // TABLE ROW.

                //variable para ordenar el json



                // we delete all the column Collection from the JSON
                let borrar=col.indexOf(pivote);
               // console.log(borrar);
                col.splice(borrar,1);

                //we sort the json and we put first the entity's id in the columns
                var count2=0;
                for(var i=0;i<col.length;i++){
                    for(var j=0; j < ids.length;j++){
                        if(col[i] == ids[j]){
                            var trade = col[count2]; //primera posicion del arreglo
                            col[count2] = ids [j]; //pasando el id al principio
                            ids[j] = trade;
                            col[i] = trade;
                            count2++;
                        }
                    }
                }
               // console.log(col);

                for (var i = 0; i < col.length; i++) {
                    var th = document.createElement("th");      // TABLE HEADER.
                    th.innerHTML = col[i];
                    tr.appendChild(th);
                }

                for (var i = 0; i < myBooks.length; i++) {

                    tr = tabla.insertRow(-1);

                    for (var j = 0; j < col.length; j++) {
                        var tabCell = tr.insertCell(-1);
                        tabCell.innerHTML = myBooks[i][col[j]];
                    }
                }
                // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
                 contenedor.appendChild(tabla);
                 shadow.appendChild(contenedor);

      }

        let userAction = function(entidad = 'fabricantes') {

                let xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Typical action to be performed when the document is ready:
                        let response = xhttp.responseText;
                        //prueba
                        datajson = JSON.parse(response);
                        createTableFromJSON(datajson)
                        console.log(datajson)
                    }
                };
                xhttp.open("GET", `http://localhost:8080/MantenimientoTPI-web/webresources/${entidad}`, true);
                xhttp.send();


        }
        userAction(this.getAttribute('entidad'));

    }
}
window.customElements.define('wctable-rest', TablaDinamica);

