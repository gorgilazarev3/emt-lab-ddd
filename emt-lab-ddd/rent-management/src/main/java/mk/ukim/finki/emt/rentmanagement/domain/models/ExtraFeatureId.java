package mk.ukim.finki.emt.rentmanagement.domain.models;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class ExtraFeatureId extends DomainObjectId {
    private ExtraFeatureId() {
        super(ExtraFeatureId.randomId(ExtraFeatureId.class).getId());
    }

    public ExtraFeatureId(@NonNull String uuid) {
        super(uuid);
    }

    public static ExtraFeatureId of(String uuid) {
        ExtraFeatureId p = new ExtraFeatureId(uuid);
        return p;
    }
}
