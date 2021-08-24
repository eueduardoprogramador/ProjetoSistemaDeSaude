package br.inf.ids.projetodeteste.fichaatendimento;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class FichaAtendimentoResource {

    @Inject
    EntityManager entityManager;

    @Inject
    FichaAtendimentoPaciente fichaAtendimentoPaciente;

    public FichaAtendimentoPaciente cadastrarFicha(FichaAtendimentoPaciente entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public FichaAtendimentoPaciente buscarPorNumeroFicha(Long id) {
        FichaAtendimentoPaciente fichaAtendimentoPaciente;
        fichaAtendimentoPaciente = entityManager.find(FichaAtendimentoPaciente.class, id);
        return fichaAtendimentoPaciente;
    }

    public void atualizarFicha(FichaAtendimentoPaciente fichaAtendimentoPaciente) {
        entityManager.merge(fichaAtendimentoPaciente);
        entityManager.flush();
    }

    public void deletarFicha(Long id) {
        try {
            fichaAtendimentoPaciente = buscarPorNumeroFicha(id);

            entityManager.remove(fichaAtendimentoPaciente);
            entityManager.flush();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
