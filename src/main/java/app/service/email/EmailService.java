package app.service.email;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
