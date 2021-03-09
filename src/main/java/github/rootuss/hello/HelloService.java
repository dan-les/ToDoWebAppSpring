package github.rootuss.hello;

import github.rootuss.lang.Lang;
import github.rootuss.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LangRepository repository;


    HelloService(LangRepository repository) {
        this.repository = repository;
    }


    String prepareGreeting(String name, Integer langId) {

        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());

        String welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);

        return welcomeMsg + " " + nameToWelcome + "!";
    }

}
