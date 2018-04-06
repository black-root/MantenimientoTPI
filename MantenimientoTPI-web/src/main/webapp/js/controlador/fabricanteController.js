
import fabricanteResourceClient from '../modelo/fabricanteResourceClient'

class fabricanteController{
    
    constructor(){
        this.fabr = new fabricanteResourceClient();
        this.fabr.findById(1);
    }
    
    
}

export default fabricanteController;