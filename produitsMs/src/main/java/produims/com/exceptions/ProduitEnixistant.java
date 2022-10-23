package produims.com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitEnixistant extends RuntimeException  {
    public ProduitEnixistant(String message) {
        super(message);
    }
}
