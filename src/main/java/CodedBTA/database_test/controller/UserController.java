package CodedBTA.database_test.controller;

import CodedBTA.database_test.bo.CreateUserRequest;
import CodedBTA.database_test.bo.UserResponse;
import CodedBTA.database_test.entity.UserEntity;
import CodedBTA.database_test.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request){
        UserResponse response = userService.createUser(request);

        if (response != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<UserResponse> updateStatus(@RequestParam(name = "id") String userID, @RequestParam(name = "status") String status){
        UserResponse response = userService.updateStatus(userID,status);

        if (response != null){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/searchUser")
    public ResponseEntity<List<UserEntity>> searchUser(@RequestParam(name = "status") String status){
        List<UserEntity> result = userService.searchUser(status);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
