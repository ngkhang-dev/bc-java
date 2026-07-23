package service;

public class EmailService implements MessageService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Email send: " + message);
    }
}
