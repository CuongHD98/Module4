package com.casemodule.repository;

import com.casemodule.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepo extends JpaRepository<Video, Integer> {
}
