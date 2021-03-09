package github.rootuss.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//nie musi być publiczny
@RestController
@RequestMapping("/api")
class LangServlet {
    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    private LangService langService;

    LangServlet(LangService langService) {
        this.langService = langService;
    }


    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAlllangs() {
        logger.info("Obsłużono REQUEST");
        return ResponseEntity.ok(langService.findAll());
    }
}