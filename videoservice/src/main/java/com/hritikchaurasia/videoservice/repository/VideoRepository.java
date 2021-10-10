package com.hritikchaurasia.videoservice.repository;

import com.hritikchaurasia.videoservice.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video,String> {
}
