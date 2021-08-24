package br.inf.ids.projetodeteste.triagem;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class TriagemService {

    @Inject
    TriagemResource triagemResource;

    @POST
    @Path("/cadastrartriagem")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public TriagemPaciente cadastrarTriagem(TriagemPaciente triagemPaciente) {
        return triagemResource.cadastrarTriagem(triagemPaciente);
    }

    @GET
    @Path("/numerotriagem")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public TriagemPaciente buscarPorNumeroTriagem(@PathParam("numeroTriagem")Long numeroTriagem){
        return triagemResource.buscarPorNumeroTriagem(numeroTriagem);
    }

    @PUT
    @Path("/atualizartriagem")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarTriagem(TriagemPaciente triagemPaciente){
        triagemResource.atualizarTriagem(triagemPaciente);
    }

    @DELETE
    @Path("/deletartriagem/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarTriagem(@PathParam("numeroTriagem")Long numeroTriagem) {
        triagemResource.deletarTriagem(numeroTriagem);
    }
}
