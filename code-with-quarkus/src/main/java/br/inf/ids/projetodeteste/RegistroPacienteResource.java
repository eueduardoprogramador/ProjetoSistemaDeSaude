package br.inf.ids.projetodeteste;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

@RequestScoped
public class RegistroPacienteResource implements Serializable {

    @Inject
    EntityManager entityManager;

    public RegistroPaciente cadastrarRegistro(RegistroPaciente entity) {
        //O EntityManager provê APIs para criar consultas, buscando objetos, sincronizando objetos, e inserindo objetos no banco de dados.
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public RegistroPaciente buscarPorNumeroRegistro(Long id) {
        RegistroPaciente registroPaciente;
        registroPaciente = entityManager.find(RegistroPaciente.class, id);
        return registroPaciente;
    }

    public void atualizarRegistro(RegistroPaciente registroPaciente) {
        entityManager.merge(registroPaciente);
        entityManager.flush();
    }

    public void deletarRegistro(Long id) {
        try {
            RegistroPaciente registroPaciente = buscarPorNumeroRegistro(id);

            entityManager.remove(registroPaciente);
            entityManager.flush();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
//        RegistroPaciente registroPaciente = buscarPorNumeroRegistro(id);
//        if (registroPaciente == null) {
//            //mensagem
//            return;
//        }
//        entityManager.remove(registroPaciente);
//        entityManager.flush();
    }
}
