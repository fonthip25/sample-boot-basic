package th.mfu.Service;

public @interface KafkaListener {

    String topics();

    String groupId();

}
