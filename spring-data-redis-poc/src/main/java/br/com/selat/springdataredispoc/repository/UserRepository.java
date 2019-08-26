package br.com.selat.springdataredispoc.repository;

import br.com.selat.springdataredispoc.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
