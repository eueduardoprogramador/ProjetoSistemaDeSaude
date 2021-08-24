package br.inf.ids.projetodeteste.recepcao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class RecepcaoPacienteService {

    @Inject
    RecepcaoPacienteResource recepcaoPacienteResource;

    @POST
    @Path("/cadastrarrecepcao")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public RecepcaoPaciente cadastrarRecepcao(RecepcaoPaciente recepcaoPaciente) {
        return recepcaoPacienteResource.cadastrarRecepcao(recepcaoPaciente);
    }

    @GET
    @Path("/numerorecepcao")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public RecepcaoPaciente buscarPorNumeroRecepcao(@PathParam("numeroRecepcao")Long numeroRecepcao){
        return recepcaoPacienteResource.buscarPorNumeroRecepcao(numeroRecepcao);
    }

    @PUT
    @Path("/atualizarrecepcao")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarRecepcao(RecepcaoPaciente recepcaoPaciente){
        recepcaoPacienteResource.atualizarRecepcao(recepcaoPaciente);
    }

    @DELETE
    @Path("/deletarrecepcao/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarRecepcao(@PathParam("numeroRecepcao")Long numeroRecepcao) {
        recepcaoPacienteResource.deletarRecepcao(numeroRecepcao);
    }
}
