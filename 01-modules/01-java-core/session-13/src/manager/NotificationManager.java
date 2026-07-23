package manager;

import service.MessageService;

public class NotificationManager {
    private MessageService messageService;

    public NotificationManager(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifica(String mess) {
        messageService.sendMessage(mess);
    }
}
