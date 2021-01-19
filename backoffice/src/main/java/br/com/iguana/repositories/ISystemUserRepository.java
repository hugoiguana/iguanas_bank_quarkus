package br.com.iguana.repositories;

import br.com.iguana.entities.UserSystem;

import java.util.List;
import java.util.Optional;

public interface ISystemUserRepository {
    UserSystem persist(UserSystem userSystem);

    List<UserSystem> listAll();

    Optional<UserSystem> findById(Long id);

    UserSystem update(UserSystem book);

    void deleteById(Long id);
}
