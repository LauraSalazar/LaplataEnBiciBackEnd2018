package web.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dbaccess.dto.UsuarioDTO;
import web.service.UsuarioService;

@Path("/Usuario")
public class UsuarioResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	UsuarioService usuarioService;

	public UsuarioResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		usuarioService = new UsuarioService();
	}

	public UsuarioResource() {
		super();
		usuarioService = new UsuarioService();
	}

	@GET
	@Path("/{usuarioId}")
	public Response getUsuario(@PathParam("usuarioId") Integer id) {
		Response response;
		UsuarioDTO usuarioDTO = usuarioService.getUsuario(id);
		try {
			if (usuarioDTO == null) {
				response = Response.status(204).build();
			} else {
				response = Response.ok(usuarioDTO).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

	// Crea un usuario
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createUsuario(UsuarioXml usuario) {
		Response response = null;
		try {
            System.out.println("usuario.getDNI: " + usuario.getDni());
            System.out.println("usuario.getApellido: " + usuario.getApellido());
            System.out.println("usuario.getNombres: " + usuario.getNombres());
            System.out.println("usuario.getdomicilio: " + usuario.getDomicilio());
            System.out.println("usuario.getFechaNac: " + usuario.getFechaNac());
            System.out.println("usuario.getSexo: " + usuario.getSexo());
            System.out.println("usuario.getMail: " + usuario.getMail());
            System.out.println("usuario.getHbilitado: " + usuario.getHabilitado());
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Integer id = usuarioService.create(usuario.getDni(), usuario.getApellido(), usuario.getNombres(), usuario.getDomicilio(), usuario.getFechaNac(), usuario.getSexo(), usuario.getMail(), usuario.getHabilitado());

			response = Response.ok(200).
				entity(String.valueOf(id)).
					build();
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modificar")
	public Response updateUsuario(@FormParam("usuarioId") Integer id, @FormParam("dni") String dni,
			@FormParam("apellido") String apellido, @FormParam("nombres") String nombres,
			@FormParam("domicilio") String domicilio, @FormParam("fechaNacimiento") String fechaNacimiento,
			@FormParam("sexo") String sexo, @FormParam("mail") String mail, @FormParam("habilitado") String habilitado) {
		Response response = null;
		try {

			UsuarioDTO usuarioDTO = usuarioService.getUsuario(id);
			if (usuarioDTO != null) {
				usuarioService.update(id, dni, apellido, nombres, domicilio, fechaNacimiento, sexo, mail, habilitado);
				usuarioDTO = usuarioService.getUsuario(id);
				response = Response.ok(usuarioDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoUsuario")
	public Response getUsuario() {
		Response response = null;
		List<UsuarioDTO> usuariosDTO;
		try {
			usuariosDTO = usuarioService.getAll();
			if (usuariosDTO != null) {
				response = Response.ok(usuariosDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}

	@DELETE

	@Path("/delete/{usuarioId}")
	public Response delete(@PathParam("usuarioId") Integer id) {

		Response response = null;
		try {
			if (usuarioService.getUsuario(id) != null) {
				usuarioService.delete(id);
				response = Response.ok(200).build();
			} else {
				response = Response.status(204).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

}
