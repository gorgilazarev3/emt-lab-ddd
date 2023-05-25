package mk.ukim.finki.emt.vehiclecatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

@Entity
@Table(name = "brand")
public class Brand extends AbstractEntity<BrandId> {

    private String brandName;

    protected Brand() {
        super(DomainObjectId.randomId(BrandId.class));
    }

    public Brand(String brandName) {
        super(DomainObjectId.randomId(BrandId.class));
        this.brandName = brandName;
    }
}
