package com.jonathan;
import java.util.List;
import javax.transaction.Transactional;
import com.jonathan.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientServices {
    @Autowired
    private PatientRepository repo;

    public List<Patient> retrieveAll() {
        return repo.findAll(Sort.by("name").ascending());
    }
}
