package com.masalcance.pruebatecnica.controller;

import com.masalcance.pruebatecnica.dto.AlbumDTO;
import com.masalcance.pruebatecnica.dto.PostDTO;
import com.masalcance.pruebatecnica.dto.UserDTO;
import com.masalcance.pruebatecnica.service.RemoteApiService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ControllerRemoteApi {
    public static final String CONSTANT_GET_USERS ="GET-USER";
    public static final String CONSTANT_GET_POSTS ="GET-POSTS";
    public static final String CONSTANT_GET_ALBUMS_BY_USER ="GET-ALBUMS-BY-USER";
    public static final String CONSTANT_GET_POSTS_BY_USER ="GET-POSTS-BY-USER";
    private final RemoteApiService remoteApiService;


    public ControllerRemoteApi(RemoteApiService remoteApiService) {
        this.remoteApiService = remoteApiService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> users(){
        return ResponseEntity.ok(remoteApiService.listUsers(CONSTANT_GET_USERS));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> posts(){
        return ResponseEntity.ok(remoteApiService.listPosts(CONSTANT_GET_POSTS));
    }

    @GetMapping("/users/{id}/albums")
    public ResponseEntity<List<AlbumDTO>> listAlbumsByUsers(@PathVariable Long id){
        return ResponseEntity.ok(remoteApiService.getAlbumsByUser(id,CONSTANT_GET_ALBUMS_BY_USER));
    }

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<PostDTO>> listPostsByUsers(@PathVariable Long id){
        return ResponseEntity.ok(remoteApiService.getPostsByUser(id,CONSTANT_GET_POSTS_BY_USER));
    }
}
