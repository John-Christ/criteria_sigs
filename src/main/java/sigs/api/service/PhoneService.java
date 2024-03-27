package sigs.api.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sigs.api.criteria.PhoneSpecification;
import sigs.api.model.Phone;
import sigs.api.repository.PhoneRepository;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> findAllPhones(String phoneName, String phoneBrand, Pageable page) {
        final Specification<Phone> specification =
                PhoneSpecification.filterPhone(phoneBrand, phoneName);
        final List<Phone> phones = phoneRepository.findAll(specification);
        return phones;
    }
}
