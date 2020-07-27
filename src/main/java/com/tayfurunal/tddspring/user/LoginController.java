package com.tayfurunal.tddspring.user;

import com.tayfurunal.tddspring.shared.CurrentUser;
import com.tayfurunal.tddspring.user.vm.UserVM;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
public class LoginController {

    @PostMapping("/login")
    UserVM handleLogin(@CurrentUser User loggedInUser) {
        return new UserVM(loggedInUser);
    }
}
