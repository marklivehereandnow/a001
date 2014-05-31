/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.card;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mark
 */
@Stateless
public class AgesCardFacade extends AbstractFacade<AgesCard> {
    @PersistenceContext(unitName = "agesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgesCardFacade() {
        super(AgesCard.class);
    }
    public List<AgesCard> getAllAgesCards(){
        return em.createNamedQuery("AgesCard.findAll").getResultList();
    }
    
}
