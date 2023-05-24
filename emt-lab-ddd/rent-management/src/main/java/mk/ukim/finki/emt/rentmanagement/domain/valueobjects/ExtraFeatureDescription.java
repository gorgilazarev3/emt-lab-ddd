package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class ExtraFeatureDescription implements ValueObject {

    private final String extraFeature;

    protected ExtraFeatureDescription() {
        this.extraFeature = null;
    }

    public ExtraFeatureDescription(@NonNull String extraFeature) {
        this.extraFeature = extraFeature;
    }

    public ExtraFeatureDescription changeExtraFeature(String extraFeature) {
        return new ExtraFeatureDescription(extraFeature);
    }
}
