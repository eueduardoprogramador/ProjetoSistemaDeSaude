package br.inf.ids.projetodeteste.consulta;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ConsultaResource {

    @Inject
    EntityManager entityManager;

    @Inject
    ConsultaPaciente consultaPaciente;

    public ConsultaPaciente cadastrarConsulta (ConsultaPaciente entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public ConsultaPaciente buscarPorNumeroConsulta (Long id) {
        ConsultaPaciente consultaPaciente;
        consultaPaciente = entityManager.find(ConsultaPaciente.class, id);
        return consultaPaciente;
    }

    public void atualizarConsulta(ConsultaPaciente consultaPaciente) {
        entityManager.merge(consultaPaciente);
        entityManager.flush();
    }

    public void deletarConsulta(Long id) {
        try {
            consultaPaciente = buscarPorNumeroConsulta(id);

            entityManager.remove(consultaPaciente);
            entityManager.flush();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
