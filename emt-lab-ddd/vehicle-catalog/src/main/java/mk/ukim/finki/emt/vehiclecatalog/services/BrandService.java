package mk.ukim.finki.emt.vehiclecatalog.services;

import mk.ukim.finki.emt.vehiclecatalog.domain.models.Brand;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.BrandId;
import mk.ukim.finki.emt.vehiclecatalog.services.forms.BrandForm;


import java.util.List;
import java.util.Optional;

public interface BrandService {
    Optional<Brand> findById(BrandId id);
    Brand createBrand(BrandForm brandForm);
    List<Brand> findAll();
}
