package tech.paramount.cold;

import org.crac.CheckpointException;
import org.crac.Core;
import org.crac.RestoreException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CracController {

    @GetMapping("/crac")
    public String crac() throws RestoreException, CheckpointException {
        Core.checkpointRestore();
        return "crac";
    }
}
