package com.example.picturepublishingservice.repository;

import com.example.picturepublishingservice.model.Picture;
import com.example.picturepublishingservice.utils.dto.PictureInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {


    @Query(
            value = "select * from picture p where p.is_accepted = true",
            countQuery = "SELECT count(*) FROM picture p where p.is_accepted = true",
            nativeQuery = true)
    Page<Picture> list(Pageable pageable);


    @Query(
            value = "select * from picture p where p.is_accepted IS NULL",
            countQuery = "SELECT count(*) FROM picture p where p.is_accepted IS NULL",
            nativeQuery = true)
    Page<Picture> listNewPhotos(Pageable pageable);
}
