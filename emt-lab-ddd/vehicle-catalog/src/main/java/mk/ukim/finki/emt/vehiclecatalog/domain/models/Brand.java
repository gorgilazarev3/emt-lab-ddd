package mk.ukim.finki.emt.vehiclecatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "brand")
public class Brand extends AbstractEntity<BrandId> {

    private String brandName;
}
