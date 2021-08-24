package br.inf.ids.projetodeteste.registromedico;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class RegistroMedicoResource {

    @Inject
    EntityManager entityManager;

    @Inject
    RegistroMedicoPaciente registroMedicoPaciente;


    public RegistroMedicoPaciente cadastrarRegistro(RegistroMedicoPaciente entity) {
        //O EntityManager provê APIs para criar consultas, buscando objetos, sincronizando objetos, e inserindo objetos no banco de dados.
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public RegistroMedicoPaciente buscarPorNumeroRegistroMedico(Long id) {
        RegistroMedicoPaciente registroMedicoPaciente;
        registroMedicoPaciente = entityManager.find(RegistroMedicoPaciente.class, id);
        return registroMedicoPaciente;
    }

    public void atualizarRegistro(RegistroMedicoPaciente registroMedicoPaciente) {
        entityManager.merge(registroMedicoPaciente);
        entityManager.flush();
    }

    public void deletarRegistro(Long id) {
        try {
            registroMedicoPaciente = buscarPorNumeroRegistroMedico(id);

            entityManager.remove(registroMedicoPaciente);
            entityManager.flush();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

