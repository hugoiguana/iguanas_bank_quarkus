package br.com.iguana.services;

import br.com.iguana.entities.UserSystem;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IUserSystemService {

    UserSystem insert(@Valid UserSystem userSystem);

    @Transactional(Transactional.TxType.SUPPORTS)
    List<UserSystem> findAll();

    @Transactional(Transactional.TxType.SUPPORTS)
    Optional<UserSystem> findById(Long id);

    UserSystem update(@Valid UserSystem bm);

    void delete(Long id);
}
