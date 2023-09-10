package com.ash.photoz.clone.service;

import com.ash.photoz.clone.model.Photo;
import com.ash.photoz.clone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;

    PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo(contentType, fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
}
