package com.masalcance.pruebatecnica.service;

import com.masalcance.pruebatecnica.client.JsonClient;
import com.masalcance.pruebatecnica.dto.AlbumDTO;
import com.masalcance.pruebatecnica.dto.PostDTO;
import com.masalcance.pruebatecnica.dto.UserDTO;
import com.masalcance.pruebatecnica.exception.remoteapi.NoRecordId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemoteApiService {
    private final JsonClient jsonClient;
    private final LogsService logsService;

    public RemoteApiService(JsonClient jsonClient,LogsService logsService) {
        this.jsonClient = jsonClient;
        this.logsService = logsService;
    }

    public List<UserDTO> listUsers(String metodo) {
        logsService.createLog(metodo,jsonClient.listUsers().stream()
                .map(UserDTO::toString)
                .collect(Collectors.joining("\n"))
        );
        return jsonClient.listUsers();
    }

    public List<PostDTO> listPosts(String metodo) {
        logsService.createLog(metodo,jsonClient.listPosts().stream()
                .map(PostDTO::toString)
                .collect(Collectors.joining("\n"))
        );
        return jsonClient.listPosts();
    }

    public List<AlbumDTO> getAlbumsByUser(Long id,String metodo) {
        logsService.createLog(metodo,jsonClient.listAlbumsByUsers(id).stream()
                .map(AlbumDTO::toString)
                .collect(Collectors.joining("\n"))
        );
        List<AlbumDTO> listAlbumsByUsers = jsonClient.listAlbumsByUsers(id);
        if(listAlbumsByUsers.isEmpty()){
            throw new NoRecordId(id.toString());
        }
        return listAlbumsByUsers;
    }

    public List<PostDTO> getPostsByUser(Long id,String metodo) {
        logsService.createLog(metodo,jsonClient.listPostsByUsers(id).stream()
                .map(PostDTO::toString)
                .collect(Collectors.joining("\n"))
        );
        List<PostDTO> listPostsByUsers = jsonClient.listPostsByUsers(id);
        if(listPostsByUsers.isEmpty()){
            throw new NoRecordId(id.toString());
        }
        return listPostsByUsers;
    }
}
