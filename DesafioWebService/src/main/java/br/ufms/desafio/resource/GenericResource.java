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

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author kleberkruger
 */
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class GenericResource /*<E, S extends GenericService<E, ? extends HibernateDAO<E>>>*/ {

//    @Autowired
//    private S service;
//
//    @GET
//    public List<E> get() {
//        return service.getAll();
//    }
//
//    @GET
//    @Path("{id}")
//    public E get(@PathParam("id") long id) {
//        return (E) service.get(id);
//    }
//
//    @POST
//    public Response post(E bean) {
//        service.save(bean);
//        return Response.Ok("Objeto salvo com sucesso");
//    }
//
//    @PUT
//    public Response put(E bean) {
//        service.save(bean);
//        return Response.Ok("Objeto atualizado com sucesso");
//    }
//
//    @DELETE
//    public Response delete(E bean) {
//        service.delete(bean);
//        return Response.Ok("Objeto deletado com sucesso");
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response delete(@PathParam("id") long id) {
//        service.delete(id);
//        return Response.Ok("Objeto deletado com sucesso");
//    }
}
