package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.primefaces.PrimeFaces;

@Named(value = "recuperarContraseñaRequest")
@RequestScoped
public class RecuperarContraseñaRequest {

    @EJB
    UsuariosFacadeLocal usuariosfacadelocal;

    public RecuperarContraseñaRequest() {
    }

    private String documento;
    private Usuarios usuPass;

    private int idRol;
    private List<Usuarios> usuClaves;
    String primerNombre;
    String segundoNombre;

    private String destinatario;
    private final String asunto = "Restablecimiento de su contraseña en SIIM";
    private String contrasenaRec;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

//    Método para recuperar contraseña individual
    public void restablecerContrasena() {

        try {

            this.usuPass = usuariosfacadelocal.recuperarContrasena(documento);
            this.destinatario = usuPass.getCorreo();
            this.contrasenaRec = usuPass.getContrasena();
            String pagina = "<table style=\"max-width: 600px; padding: 10px; margin: 0-auto; border-collapse: collapse\">\n"
                    + "            <tr>\n"
                    + "                <td style=\"background: #ecf0f1; text-align: left; padding: 10px\">\n"
                    + "                    <a hreflang=\"\">\n"
                    + "                        <img width=\"30%\" style=\"display: block; margin: 1.5% - 3%\" src=\"https://i.postimg.cc/3yXjbZBF/Logo-DYM-largo.png\"></img>\n"
                    + "                    </a>\n"
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td style=\"background-color: #ecf0f1\">\n"
                    + "                    <div style=\"color: #343a40; margin: 4% 10% 2%; text-align: justify; font-family: cursive\">\n"
                    + "                        <h2 style=\"color: orange; font-size: 15px\">Hola" + "  " + usuPass.getPrimerNombre() + "," + "</h2>\n"
                    + "                        <p style=\"margin: 2px; font-size: 15px\">\n"
                    + "                            Hemos recibido tu solicitud de restablecimiento de contraseña y aquí te la enviamos, recuerda\n"
                    + "                            cambiarla periódicamente para mantenerla segura.\n"
                    + "                        </p>\n"
                    + "                        <br></br>\n"
                    + "                        <p style=\"margin: 2px; font-family: sans-serif; font-size: 15px\">Tu contraseña es:</p>" + contrasenaRec
                    + "                        <br></br>\n"
                    + "<br></br>"
                    + "                        <a style=\"font-size: 15px; margin: 10px 0\" href=\"http://localhost:8080/ProyectoAdsi/\">Visita DYM Mecanizados e ingresa con tu clave</a>\n"
                    + "                    </div>\n"
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "        </table>";
            if (usuPass != null) {
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mendezcc616@gmail.com", "gfhckgwlxhewvcqs");
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("mendezcc616@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                message.setSubject(asunto);
                message.setContent(pagina, "text/html");

                Transport.send(message);
                PrimeFaces.current().executeScript("mensajeExitoso('Hemos enviado un mensaje con tu contraseña actual al correo electrónico que "
                        + "registraste en la base de datos de nuestro sistema.')");

            } else {
                PrimeFaces.current().executeScript("mensajeFallido('No se ha logrado enviar el mensaje')");
            }
        } catch (Exception e) {
        }

    }
    
    
//    Método para el restablecimiento masivo de contraseñas según el rol elegido

    public void restablecerContrasenasMasivas() {

        try {

            this.usuClaves = usuariosfacadelocal.listadoDestinatarios(idRol);

            if (usuClaves != null) {

                for (Iterator<Usuarios> it = usuClaves.iterator(); it.hasNext();) {
                    Usuarios usuDestinatario = it.next();

                    this.contrasenaRec = usuDestinatario.getContrasena();
                    this.destinatario = usuDestinatario.getCorreo();
                    this.primerNombre = usuDestinatario.getPrimerNombre();
                    String pagina = "<table style=\"max-width: 600px; padding: 10px; margin: 0-auto; border-collapse: collapse\">\n"
                            + "            <tr>\n"
                            + "                <td style=\"background: #ecf0f1; text-align: left; padding: 10px\">\n"
                            + "                    <a hreflang=\"\">\n"
                            + "                        <img width=\"30%\" style=\"display: block; margin: 1.5% - 3%\" src=\"https://i.postimg.cc/3yXjbZBF/Logo-DYM-largo.png\"></img>\n"
                            + "                    </a>\n"
                            + "                </td>\n"
                            + "            </tr>\n"
                            + "            <tr>\n"
                            + "                <td style=\"background-color: #ecf0f1\">\n"
                            + "                    <div style=\"color: #343a40; margin: 4% 10% 2%; text-align: justify; font-family: cursive\">\n"
                            + "                        <h2 style=\"color: orange; font-size: 15px\">Hola" + "  " + primerNombre + "," + "</h2>\n"
                            + "                        <p style=\"margin: 2px; font-size: 15px\">\n"
                            + "                            Hemos recibido tu solicitud de restablecimiento de contraseña y aquí te la enviamos, recuerda\n"
                            + "                            cambiarla periódicamente para mantenerla segura.\n"
                            + "                        </p>\n"
                            + "                        <br></br>\n"
                            + "                        <p style=\"margin: 2px; font-family: sans-serif; font-size: 15px\">Tu contraseña es:</p>" + contrasenaRec
                            + "                        <br></br>\n"
                            + "<br></br>"
                            + "                        <a style=\"font-size: 15px; margin: 10px 0\" href=\"http://localhost:8080/ProyectoAdsi/\">Visita DYM Mecanizados e ingresa con tu clave</a>\n"
                            + "                    </div>\n"
                            + "                </td>\n"
                            + "            </tr>\n"
                            + "        </table>";

                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    Session session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("mendezcc616@gmail.com", "gfhckgwlxhewvcqs");
                        }
                    });
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("mendezcc616@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                    message.setSubject(asunto);
                    message.setContent(pagina, "text/html");
                    Transport.send(message);
                }
                PrimeFaces.current().executeScript("estadoOk('Correo enviado exitosamente a todos los destinatarios...')");
            } else {
                PrimeFaces.current().executeScript("estadoBad('No se han logrado enviar los mensajes...')");
            }
            
        } catch (Exception e) {
        }

    }

}
