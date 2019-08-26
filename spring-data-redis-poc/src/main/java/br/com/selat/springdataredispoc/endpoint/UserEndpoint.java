package br.com.selat.springdataredispoc.endpoint;

import br.com.selat.springdataredispoc.contract.input.UserInput;
import br.com.selat.springdataredispoc.contract.output.UserOutput;
import br.com.selat.springdataredispoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

    private final UserService service;

    @Autowired
    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Page<UserOutput> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "recordsPerPage", defaultValue = "100") int recordsPerPage){
        return service.findAll(page, recordsPerPage);
    }

    @GetMapping("/{id}")
    public UserOutput findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public UserOutput save(@RequestBody UserInput input){
        return service.save(input);
    }

    @PutMapping("/{id}")
    public UserOutput update(@PathVariable String id,
                             @RequestBody UserInput input){
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return service.delete(id);
    }
}
