package edu.ProyectoAdsi.controlador;

import edu.ProyectoAdsi.entidades.Usuarios;
import edu.ProyectoAdsi.facade.UsuariosFacadeLocal;
import java.util.Properties;
import javafx.scene.control.Alert;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
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
    private String destinatario;
    private final String asunto = "Restablecimiento de su contraseña en SIIM";
    private final String mensaje = "Su contraseña es: ";
    private Usuarios usuPass;
    private String contrasenaRec;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void restablecerContrasena() {

        try {

            this.usuPass = usuariosfacadelocal.recuperarContrasena(documento);
            this.destinatario = usuPass.getCorreo();
            this.contrasenaRec = usuPass.getContrasena();
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
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(destinatario));
                message.setSubject(asunto);
                message.setText(mensaje + contrasenaRec);

                Transport.send(message);
                PrimeFaces.current().executeScript("mensajeExitoso('Se ha enviado un correo con su contraseña...')");

            } else {
                PrimeFaces.current().executeScript("mensajeFallido('No existe el usuario en la base de datos...')");
            }
        } catch (Exception e) {
        }

    }

}
