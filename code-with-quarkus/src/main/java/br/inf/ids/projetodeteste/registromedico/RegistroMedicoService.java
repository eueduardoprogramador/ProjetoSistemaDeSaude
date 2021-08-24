package br.inf.ids.projetodeteste.registromedico;

import br.inf.ids.projetodeteste.triagem.TriagemPaciente;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class RegistroMedicoService {

    @Inject
    RegistroMedicoResource registroMedicoResource;

    @Inject
    RegistroMedicoPaciente registroMedicoPaciente;

    @POST
    @Path("/cadastrarregistro")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public RegistroMedicoPaciente cadastrarRegistro(RegistroMedicoPaciente registroMedicoPaciente) {
        return registroMedicoResource.cadastrarRegistro(registroMedicoPaciente);
    }

    @GET
    @Path("/numeroregistro")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public RegistroMedicoPaciente buscarPorNumeroRegistroMedico(@PathParam("numeroRegistro")Long numeroRegistro){
        return registroMedicoResource.buscarPorNumeroRegistroMedico(numeroRegistro);
    }

    @PUT
    @Path("/atualizarregistro")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarRegistro(RegistroMedicoPaciente registroMedicoPaciente){
        registroMedicoResource.atualizarRegistro(registroMedicoPaciente);
    }

    @DELETE
    @Path("/deletarregistro/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarRegistro(@PathParam("numeroRegistro")Long numeroRegistro) {
        registroMedicoResource.deletarRegistro(numeroRegistro);
    }
}


