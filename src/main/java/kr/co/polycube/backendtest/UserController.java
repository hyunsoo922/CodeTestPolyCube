package kr.co.polycube.backendtest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<IdResponse> create(HttpServletRequest request)
    {

        Users user = userService.createUsers();
        IdResponse response = new IdResponse(user.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UsersResponse> find(@PathVariable Long id)
    {
        Users user = userService.findUsers(id);
        UsersResponse response = new UsersResponse(user.getId(),user.getName());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UsersResponse> modify(@PathVariable Long id, @RequestBody UserRequest userRequest)
    {
        Users user = userService.modifyUsers(id,userRequest.getName());
        UsersResponse response = new UsersResponse(user.getId(),user.getName());
        return ResponseEntity.ok(response);
    }
}
