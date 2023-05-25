package mk.ukim.finki.emt.vehiclecatalog.services.impl;

import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.Brand;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.BrandId;
import mk.ukim.finki.emt.vehiclecatalog.domain.repository.BrandRepository;
import mk.ukim.finki.emt.vehiclecatalog.services.BrandService;
import mk.ukim.finki.emt.vehiclecatalog.services.forms.BrandForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public Optional<Brand> findById(BrandId id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand createBrand(BrandForm brandForm) {
        Brand b = new Brand(brandForm.getBrandName());
        brandRepository.saveAndFlush(b);
        return b;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
