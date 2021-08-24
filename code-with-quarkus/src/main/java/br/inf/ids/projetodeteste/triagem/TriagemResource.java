package br.inf.ids.projetodeteste.triagem;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class TriagemResource {

    @Inject
    EntityManager entityManager;

    @Inject
    TriagemPaciente triagemPaciente;

    public TriagemPaciente cadastrarTriagem(TriagemPaciente entity) {
        //O EntityManager provê APIs para criar consultas, buscando objetos, sincronizando objetos, e inserindo objetos no banco de dados.
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public TriagemPaciente buscarPorNumeroTriagem(Long id) {
        TriagemPaciente triagemPaciente;
        triagemPaciente = entityManager.find(TriagemPaciente.class, id);
        return triagemPaciente;
    }

    public void atualizarTriagem(TriagemPaciente triagemPaciente) {
        entityManager.merge(triagemPaciente);
        entityManager.flush();
    }

    public void deletarTriagem(Long id) {
        try {
            triagemPaciente = buscarPorNumeroTriagem(id);

            entityManager.remove(triagemPaciente);
            entityManager.flush();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
