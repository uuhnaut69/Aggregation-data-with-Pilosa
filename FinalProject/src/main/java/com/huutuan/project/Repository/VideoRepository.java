package com.huutuan.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {

}
