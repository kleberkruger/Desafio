/*
 * Copyright (C) 2016 kleberkruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.desafio.resource;

import br.ufms.desafio.controller.EscolaService;
import br.ufms.desafio.model.bean.Escola;
import br.ufms.desafio.util.Response;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kleberkruger
 */
@Path("/escolas")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class EscolasResource {

    @Autowired
    private EscolaService service;

    @GET
    public List<Escola> get() {
        return service.getAll();
    }

    @GET
    @Path("{id}")
    public Escola get(@PathParam("id") long id) {
        return (Escola) service.get(id);
    }

    @POST
    public Response post(Escola bean) {
        service.save(bean);
        return Response.Ok("Objeto salvo com sucesso");
    }

    @PUT
    public Response put(Escola bean) {
        service.save(bean);
        return Response.Ok("Objeto atualizado com sucesso");
    }

    @DELETE
    public Response delete(Escola bean) {
        service.delete(bean);
        return Response.Ok("Objeto deletado com sucesso");
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        service.delete(id);
        return Response.Ok("Objeto deletado com sucesso");
    }
}
