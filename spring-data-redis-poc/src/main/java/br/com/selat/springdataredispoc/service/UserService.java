package br.com.selat.springdataredispoc.service;

import br.com.selat.springdataredispoc.contract.input.UserInput;
import br.com.selat.springdataredispoc.contract.output.UserOutput;
import br.com.selat.springdataredispoc.entity.User;
import br.com.selat.springdataredispoc.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository repository,
                       ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public UserOutput save(UserInput input){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(input.getName());
        repository.save(user);
        return modelMapper.map(user, UserOutput.class);
    }

    public UserOutput findById(String id) {
        User user = getUserById(id);
        return modelMapper.map(user, UserOutput.class);
    }

    public UserOutput update(String id, UserInput input) {
        User user = getUserById(id);
        user.setName(input.getName());
        repository.save(user);
        return modelMapper.map(user, UserOutput.class);
    }

    public Page<UserOutput> findAll(int page, int recordsPerPage) {
        Page<User> users = repository.findAll(PageRequest.of(page, recordsPerPage));
        return users.map(a -> modelMapper.map(a, UserOutput.class));
    }

    public ResponseEntity delete(String id) {
        User user = getUserById(id);
        repository.delete(user);
        return ResponseEntity.noContent().build();
    }

    private User getUserById(String id){
        User user = repository.findById(id).orElse(null);
        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }
}
