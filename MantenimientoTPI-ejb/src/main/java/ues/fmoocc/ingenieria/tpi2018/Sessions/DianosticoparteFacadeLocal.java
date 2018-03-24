/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.List;
import javax.ejb.Local;
import ues.fmoocc.ingenieria.tpi2018.Entities.Dianosticoparte;

/**
 *
 * @author yisusdebian
 */
@Local
public interface DianosticoparteFacadeLocal {

    void create(Dianosticoparte dianosticoparte);

    void edit(Dianosticoparte dianosticoparte);

    void remove(Dianosticoparte dianosticoparte);

    Dianosticoparte find(Object id);

    List<Dianosticoparte> findAll();

    List<Dianosticoparte> findRange(int[] range);

    int count();
    
}
