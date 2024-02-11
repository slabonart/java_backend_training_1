package pl.slabonart.java_backend_training.task_2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.slabonart.java_backend_training.task_2.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
