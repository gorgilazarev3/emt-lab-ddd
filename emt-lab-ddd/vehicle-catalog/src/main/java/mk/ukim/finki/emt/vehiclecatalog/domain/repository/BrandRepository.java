package mk.ukim.finki.emt.vehiclecatalog.domain.repository;

import mk.ukim.finki.emt.vehiclecatalog.domain.models.Brand;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.BrandId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, BrandId> {
}
