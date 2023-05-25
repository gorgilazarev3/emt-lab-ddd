package mk.ukim.finki.emt.vehiclecatalog.domain.models;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class BrandId extends DomainObjectId {
    private BrandId() {
        super(BrandId.randomId(BrandId.class).getId());
    }

    public BrandId(@NonNull String uuid) {
        super(uuid);
    }

    public static BrandId of(String uuid) {
        BrandId p = new BrandId(uuid);
        return p;
    }

}
