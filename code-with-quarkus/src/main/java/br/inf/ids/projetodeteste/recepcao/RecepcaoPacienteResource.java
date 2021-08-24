package br.inf.ids.projetodeteste.recepcao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class RecepcaoPacienteResource {

    @Inject
    EntityManager entityManager;

    @Inject
    RecepcaoPaciente recepcaoPaciente;

    public RecepcaoPaciente cadastrarRecepcao(RecepcaoPaciente entity) {
        //O EntityManager provê APIs para criar consultas, buscando objetos, sincronizando objetos, e inserindo objetos no banco de dados.
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public RecepcaoPaciente buscarPorNumeroRecepcao(Long id) {
        RecepcaoPaciente recepcaoPaciente;
        recepcaoPaciente = entityManager.find(RecepcaoPaciente.class, id);
        return recepcaoPaciente;
    }

    public void atualizarRecepcao(RecepcaoPaciente recepcaoPaciente) {
        entityManager.merge(recepcaoPaciente);
        entityManager.flush();
    }

    public void deletarRecepcao(Long id) {
        try {
            recepcaoPaciente = buscarPorNumeroRecepcao(id);

            entityManager.remove(recepcaoPaciente);
            entityManager.flush();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
