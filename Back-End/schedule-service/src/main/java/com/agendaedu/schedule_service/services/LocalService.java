package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.localEntity.Local;
import com.agendaedu.schedule_service.domain.localEntity.LocalDTO;
import com.agendaedu.schedule_service.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Transactional
    public LocalDTO insert(LocalDTO localDTO) {
        Local local = new Local(localDTO);
        local = this.localRepository.save(local);
        return new LocalDTO(local);
    }

    public LocalDTO findById(Long id) {
        return new LocalDTO(this.localRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Local not found")));
    }

}
