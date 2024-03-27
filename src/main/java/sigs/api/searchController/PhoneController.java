package sigs.api.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import sigs.api.model.Phone;
import sigs.api.repository.PhoneRepository;
import sigs.api.service.PhoneService;

import java.util.List;

@RestController
@RequestMapping("/phone")
//@RequiredArgsConstructor
public class PhoneController {


    @Autowired
    private PhoneRepository phoneRepository;


    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public ResponseEntity<List<Phone>> getPhones(
            @RequestParam(required = false) String phoneName,
            @RequestParam(required = false) String phoneBrand
    ) {

        Pageable page =
                PageRequest.of(1, 2, Sort.by("phoneBrand").ascending());

        return ResponseEntity.ok(phoneService.findAllPhones(phoneName, phoneBrand, page));
    }


    @PostMapping
    Phone newPhone(@RequestBody Phone phone) {
        return phoneRepository.save(phone);
    }

}
