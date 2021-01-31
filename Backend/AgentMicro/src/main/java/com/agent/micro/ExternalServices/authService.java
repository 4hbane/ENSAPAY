package com.agent.micro.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "AUTH-SERVICE")
public interface authService {
    @PostMapping("/api/agents" )
    public User createUserLogin(@RequestHeader("Authorization") String jwt, @RequestBody User user);

    @DeleteMapping("/api/agents/{userName}")
    public void deleteUserLogin(@RequestHeader("Authorization") String jwt, @PathVariable String userName);
}
