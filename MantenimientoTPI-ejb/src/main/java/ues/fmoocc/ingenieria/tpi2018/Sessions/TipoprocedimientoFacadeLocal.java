package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento;

/**
 *
 * @author yisusdebian
 */
@Local
public interface TipoprocedimientoFacadeLocal {

    void create(Tipoprocedimiento tipoprocedimiento);

    void edit(Tipoprocedimiento tipoprocedimiento);

    void remove(Tipoprocedimiento tipoprocedimiento);

    Tipoprocedimiento find(Object id);

    List<Tipoprocedimiento> findAll();

    List<Tipoprocedimiento> findRange(int[] range);

    int count();
    
}
