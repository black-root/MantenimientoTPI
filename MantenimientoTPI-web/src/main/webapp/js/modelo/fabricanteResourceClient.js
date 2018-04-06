
import AbstractResourceClient from './AbstractRsourceClient.js'
class fabricanteResourceClient extends AbstractResourceClient{
    
    constructor(){
        super();
        this.url += "/fabricantes";
    }
    
    findById(id){
        return fetch(url+"/"+id);
    }
    
}

export default fabricanteResourceClient;