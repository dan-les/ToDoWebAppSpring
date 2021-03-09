package github.rootuss.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;

    HelloServlet(HelloService service) {
        this.service = service;
    }


    // gdy ktoś zawoła api, ale bez parametrów
    @GetMapping("/api")
    String welcome() {
        return service.prepareGreeting(null, null);
    }

    @GetMapping(value= "/api", params = {"lang", "name"})
    String welcome(@RequestParam("lang") Integer langId, @RequestParam String name) {
        // można bezpośrednio podać parametr "lang" i przypisać go do langId, ale nie trzeba
        logger.info("Obsłużono REQUEST");

        return service.prepareGreeting(name, langId);


    }
}