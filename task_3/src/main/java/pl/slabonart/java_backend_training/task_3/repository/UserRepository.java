package pl.slabonart.java_backend_training.task_3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.slabonart.java_backend_training.task_3.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
