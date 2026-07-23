/*
    Session 13 - DIP and DI

        1. Dependence Inversion Principle (DIP)
            - Nguyên lý/ý tưởng thiết kế mô tả: class cấp cao không phụ thuộc class cấp thấp

        2. Dependence Injection (DI)
            - Cách triển khai/thực thi/implement cho nguyên lý DIP
 */

import manager.NotificationManager;
import service.EmailService;
import service.SmsService;

public class MainApplication {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        SmsService smsService = new SmsService();

        NotificationManager noti1 = new NotificationManager(emailService);
        noti1.notifica("Hello");

        NotificationManager noti2 = new NotificationManager(smsService);
        noti2.notifica("Hello");
    }
}
