package CodedBTA.database_test.service;

import CodedBTA.database_test.bo.CreateUserRequest;
import CodedBTA.database_test.bo.UpdateStatusRequest;
import CodedBTA.database_test.bo.UserResponse;
import CodedBTA.database_test.entity.UserEntity;

import java.util.List;


public interface UserService {
    List<UserEntity> getAllUsers();
    UserResponse createUser(CreateUserRequest request);

    UserResponse updateStatus(String id, String status);

    List<UserEntity> searchUser(String status);
}
