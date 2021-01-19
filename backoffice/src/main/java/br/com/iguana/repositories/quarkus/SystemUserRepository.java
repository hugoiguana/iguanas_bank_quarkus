package br.com.iguana.repositories.quarkus;

import br.com.iguana.entities.UserSystem;
import br.com.iguana.repositories.ISystemUserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class SystemUserRepository implements ISystemUserRepository {

    @Inject
    private EntityManager em;

    @Override
    public UserSystem persist(UserSystem userSystem) {
        UserSystem.persist(userSystem);
        return userSystem;
    }

    @Override
    public List<UserSystem> listAll() {
        return UserSystem.listAll();
    }

    @Override
    public Optional<UserSystem> findById(Long id) {
        return UserSystem.findByIdOptional(id);
    }

    @Override
    public UserSystem update(UserSystem bm) {
        return em.merge(bm);
    }

    @Override
    public void deleteById(Long id) {
        UserSystem.deleteById(id);
    }
}
