package ejb.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ejb.entities.Posicao;

@Stateless
@LocalBean
public class PosicaoBean {

    @PersistenceContext(unitName = "DerbyPU")
    private EntityManager em;

    public void save(Posicao p) {
        em.persist(p);
    }

    public List<Posicao> list() {
        Query query = em.createQuery("FROM Posicao p");
        List<Posicao> list = query.getResultList();
        return list;
    }
}
