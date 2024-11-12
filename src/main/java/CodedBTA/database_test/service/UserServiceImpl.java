package CodedBTA.database_test.service;

import CodedBTA.database_test.Status;
import CodedBTA.database_test.bo.CreateUserRequest;
import CodedBTA.database_test.bo.UpdateStatusRequest;
import CodedBTA.database_test.bo.UserResponse;
import CodedBTA.database_test.entity.UserEntity;
import CodedBTA.database_test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setStatus(Status.valueOf(request.getStatus().toUpperCase()));
        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getStatus().toString());
        return response;
    }

    @Override
    public UserResponse updateStatus(String id, String status) {
        UserEntity userEntity = userRepository.getReferenceById(Long.valueOf(id));
        userEntity.setStatus(Status.valueOf(status.toUpperCase()));
        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getStatus().toString());
        return response;
    }

    @Override
    public List<UserEntity> searchUser(String status) {
        return userRepository.findByStatus(Status.valueOf(status.toUpperCase()));
    }
}
