package CodedBTA.database_test.repository;

import CodedBTA.database_test.Status;
import CodedBTA.database_test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByStatus(Status status);
}
