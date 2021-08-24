package br.inf.ids.projetodeteste.fichaatendimento;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class FichaAtendimentoService {

    @Inject
    FichaAtendimentoResource fichaAtendimentoResource;

    @POST
    @Path("/cadastrarficha")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public FichaAtendimentoPaciente cadastrarFicha(FichaAtendimentoPaciente fichaAtendimentoPaciente) {
        return fichaAtendimentoResource.cadastrarFicha(fichaAtendimentoPaciente);
    }

    @GET
    @Path("/numeroficha")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public FichaAtendimentoPaciente buscarPorNumeroFicha(@PathParam("numeroFicha")Long numeroFicha){
        return fichaAtendimentoResource.buscarPorNumeroFicha(numeroFicha);
    }

    @PUT
    @Path("/atualizarficha")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarFicha(FichaAtendimentoPaciente fichaAtendimentoPaciente){
        fichaAtendimentoResource.atualizarFicha(fichaAtendimentoPaciente);
    }

    @DELETE
    @Path("/deletarficha/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarFicha(@PathParam("numeroFicha")Long numeroFicha) {
        fichaAtendimentoResource.deletarFicha(numeroFicha);
    }
}
