

class AbstractResourceClient{
    
    constructor(){
        this.url = "localhost:8080/MantenimientoTPI-web-1.0-SNAPSHOT/webresources"
    }
    
    get url(){
        return this.url;
    }
    
    
}

export default AbstractResourceClient;
