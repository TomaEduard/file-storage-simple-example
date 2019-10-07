package com.example.springdata.files.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.springdata.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
