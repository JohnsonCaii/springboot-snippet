package com.snippet.api;

import com.snippet.api.request.UserRequest;
import com.snippet.api.response.UserResponse;
import com.snippet.dao.UserRepository;
import com.snippet.dao.entity.User;
import com.snippet.util.PojoUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by caie on 23/08/2017.
 */
@RestController
@RequestMapping("user")
public class UserApi {

    private final UserRepository userRepository;

    @Autowired
    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation(value = "Get User Info")
    @ApiImplicitParam(name = "id", value = "user_id", dataType = "integer", paramType = "query", required = true)
    @ApiResponse(code = 200, message = "Success", response = UserResponse.class)
    @GetMapping
    public UserResponse get(@RequestParam Integer id) {

        User user = userRepository.findOne(id);

        return PojoUtils.copyBean(user, UserResponse.class);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiOperation(value = "Post User Info")
    @ApiResponse(code = 201, message = "Success")
    public void post(@RequestBody
                     @ModelAttribute
                     @Valid
                     UserRequest userRequest) {
        final User user = PojoUtils.copyBean(userRequest, User.class);
        userRepository.save(user);
    }

}
