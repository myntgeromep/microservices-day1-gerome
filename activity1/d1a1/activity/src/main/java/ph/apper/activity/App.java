package ph.apper.activity;

import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(App.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }

    @RestController
    @RequestMapping("activity")
    public static class ActivityController {

        @PostMapping
        public ResponseEntity create(@RequestBody Request request) {
            System.out.println(request);

            return ResponseEntity.ok().build();
        }
    }

    @Data
    public static class Request {
        private String action;
        private String identifier;
    }

}
