package br.inf.ids.projetodeteste.consulta;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class ConsultaService {

    @Inject
    ConsultaResource consultaResource;

    @POST
    @Path("/cadastrarconsulta")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public ConsultaPaciente cadastrarConsulta(ConsultaPaciente consultaPaciente) {
        return consultaResource.cadastrarConsulta(consultaPaciente);
    }

    @GET
    @Path("/numeroconsulta")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsultaPaciente buscarPorNumeroConsulta(@PathParam("numeroConsulta")Long numeroConsulta){
        return consultaResource.buscarPorNumeroConsulta(numeroConsulta);
    }

    @PUT
    @Path("/atualizarconsulta")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarConsulta(ConsultaPaciente consultaPaciente){
        consultaResource.atualizarConsulta(consultaPaciente);
    }

    @DELETE
    @Path("/deletarconsulta/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarConsulta(@PathParam("numeroConsulta")Long numeroConsulta) {
        consultaResource.deletarConsulta(numeroConsulta);
    }
}
