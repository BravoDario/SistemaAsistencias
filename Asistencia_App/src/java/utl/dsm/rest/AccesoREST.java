package utl.dsm.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.json.Json;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import utl.dsm.asistencia.core.ControllerAcceso;
import utl.dsm.asistencia.model.Persona;

/**
 *
 * @author emman
 */
@Path("/autenticacion")
public class AccesoREST {

    // Método para generar el servicio POST para validar credenciales del usuario
    @POST
    @Path("/verificarCredenciales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarCredenciales(@FormParam("datosUsuario") String credenciales) {
        Persona p = new Gson().fromJson(credenciales, Persona.class);
        String usuario = p.getClave();
        String contrasenna = p.getContrasenia();

        ControllerAcceso controlador = new ControllerAcceso(); // Reemplaza con el nombre de tu controlador

        String mensaje = "";
        String msj = "";
        try {
            int resultado = controlador.validarCredenciales(usuario, contrasenna);
            if (resultado > 0) {

                System.out.println("Credenciales válidas");
                System.out.println("Usuario: " + usuario);
                System.out.println("Contraseña: " + contrasenna);
                mensaje = "{\"mensaje\": \"Credenciales válidas\"}";
                msj = "{\"mensaje\": \"Credenciales válidas\", \"idPersona\":" + resultado + "}";
                
                System.out.println(msj);
            } else {

                System.out.println("Credenciales inválidas");
                System.out.println("Usuario: " + usuario);
                System.out.println("Contraseña: " + contrasenna);
                msj = "{\"mensaje\": \"Credenciales inválidas\"}";

            }
        } catch (IOException e) {
            e.printStackTrace();
            msj = "{\"error\": \"Error de entrada/salida al procesar la solicitud\"}";
        } catch (Exception e) {
            e.printStackTrace();
            msj = "{\"error\": \"Error interno del servidor\"}";
        }
        return Response.status(Response.Status.OK).entity(msj).build();
    }
}
