микросервис ReportsApplication
(делался отдельно, группа не сложилась)

сервис типа выдает отчёты по записям из базы данных 
например, по /user/all выдаётся список юзеров:
    [{"id":1,"userName":"John Bobson"},
     {"id":2,"userName":"Bob Johnson"},
     {"id":3,"userName":"Alice Smithson"}]

в сервисе используется Liquibase для инициализации и обновления базы данных,
Swagger для документации api, RestTemplate для обмена сообщениями по rest (принимающее приложение-заглушка: ConsumingApplication, /accept)

Также с помощью Kafka отправляется сообщение 
Kafdrop доступен по адресу http://localhost:9000/
логируется с помощью KafkaLog4jAppender


