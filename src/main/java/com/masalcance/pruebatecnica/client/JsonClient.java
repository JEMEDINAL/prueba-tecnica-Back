package com.masalcance.pruebatecnica.client;

import com.masalcance.pruebatecnica.dto.AlbumDTO;
import com.masalcance.pruebatecnica.dto.PostDTO;
import com.masalcance.pruebatecnica.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "remoteApi",url = "https://jsonplaceholder.typicode.com/")
public interface JsonClient {

    @GetMapping("/users")
    List<UserDTO> listUsers();

    @GetMapping("/posts")
    List<PostDTO> listPosts();

    @GetMapping("/user/{id}/albums")
    List<AlbumDTO> listAlbumsByUsers(@PathVariable("id") Long userId);

    @GetMapping("/user/{id}/posts")
    List<PostDTO> listPostsByUsers(@PathVariable("id") Long userId);

}
