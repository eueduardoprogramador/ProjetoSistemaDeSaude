package br.inf.ids.projetodeteste;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import io.swagger.annotations.Api;

@Api("Registro Paciente")
@Path("/registro")
public class RegistroPacienteService {

    @Inject
    RegistroPacienteResource registroPacienteResource;

    @POST
    @Path("/cadastrarregistro")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public RegistroPaciente cadastrarRegistro(RegistroPaciente registroPaciente) {
        return registroPacienteResource.cadastrarRegistro(registroPaciente);
    }

    @GET
    @Path("/numeroregistro")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public RegistroPaciente buscarPorNumeroRegistro(@PathParam("numeroRegistro")Long numeroRegistro){
        return registroPacienteResource.buscarPorNumeroRegistro(numeroRegistro);
    }

    @PUT
    @Path("/atualizarregistro")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarRegistro(RegistroPaciente registroPaciente){
        registroPacienteResource.atualizarRegistro(registroPaciente);
    }

    @DELETE
    @Path("/deletarregistro/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarRegistro(@PathParam("numeroRegistro")Long numeroRegistro) {
        registroPacienteResource.deletarRegistro(numeroRegistro);
    }
}
