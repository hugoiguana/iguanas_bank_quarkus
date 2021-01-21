package br.com.iguana.services;

import br.com.iguana.entities.UserSystem;
import br.com.iguana.exceptions.BussinesNotFoundEntityException;
import br.com.iguana.repositories.ISystemUserRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserSystemService implements IUserSystemService {

    private static final Logger LOGGER = Logger.getLogger(UserSystemService.class);

    private ISystemUserRepository repository;

    public UserSystemService(ISystemUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserSystem insert(@Valid UserSystem userSystem) {
        LOGGER.info("Persisting a Bank User");
        repository.persist(userSystem);
        return userSystem;
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UserSystem> findAll() {
        LOGGER.info("Listing all Bank Users");
        return repository.listAll();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<UserSystem> findById(Long id) {
        LOGGER.info("Listing Bank Users with id : " + id);
        return repository.findById(id);
    }

    @Override
    public UserSystem update(@Valid UserSystem bm) {
        LOGGER.info("Updating Bank Users with id : " + bm.toString());

        UserSystem bmNew = (UserSystem) UserSystem.findByIdOptional(bm.id)
                .orElseThrow(() -> new BussinesNotFoundEntityException("Bank User", bm.id));

        bmNew.loadToUpdate(bm);
        return bmNew;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting Bank Users with id : " + id);
        repository.deleteById(id);
    }

}
