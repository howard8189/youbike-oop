package com.youbikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youbikerental.model.Post;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Find all posts by station ID
    List<Post> findByStationId(String stationId);

    // Find posts with specific repair information
    List<Post> findByRepairInfo(String repairInfo);
}
