package com.hritikchaurasia.videoservice.controller;

import com.hritikchaurasia.videoservice.entity.Video;
import com.hritikchaurasia.videoservice.repository.VideoRepository;
import com.hritikchaurasia.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity getListOfVideos(){
        Map<Object, Object> body = new HashMap<>();
        try {
            List<Video> videos = videoRepository.findAll();
            body.put("message", "success");
            body.put("videos",videos);
            return  ResponseEntity.status(200).body(body);
        }catch (Exception e){
            body.put("message", "can't get videos");
            return  ResponseEntity.status(500).body(body);
        }
    }


    @GetMapping(value = "/{videoUrl}", produces = "videos/mp4")
    public Mono<Resource> getVideos(@PathVariable String videoUrl, @RequestHeader("Range") String range) {
        System.out.println(videoUrl);
        System.out.println("range in bytes() : " + range);
        return videoService.getVideo(videoUrl);
    }
}
