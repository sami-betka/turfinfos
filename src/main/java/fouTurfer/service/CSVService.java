package fouTurfer.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fouTurfer.model.CSVHelper;
import fouTurfer.model.TurfInfos;
import fouTurfer.repository.TurfInfosRepository;


@Service
public class CSVService {
  @Autowired
  TurfInfosRepository repository;

  public void save(MultipartFile file) {
    try {
      List<TurfInfos> infos = CSVHelper.csvToTurfInfos(file.getInputStream());
      repository.saveAll(infos);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<TurfInfos> getAllTurfInfos() {
    return repository.findAll();
  }
}
