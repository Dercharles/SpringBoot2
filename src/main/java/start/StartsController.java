package start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangp on 2017/11/14.
 */
@RestController
@RequestMapping("/girl")
public class StartsController {

    @Autowired
    private girlProperties girlProperties;


    @GetMapping(value = "/home")
    public String home(@RequestParam(value = "id",defaultValue = "900",required = false)Integer idw){
        return girlProperties.getCupsize()+"-----"+idw;
    }
}
