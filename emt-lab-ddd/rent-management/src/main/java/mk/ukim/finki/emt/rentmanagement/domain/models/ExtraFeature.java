package mk.ukim.finki.emt.rentmanagement.domain.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.ExtraFeatureDescription;

@Embeddable
@Entity
@Table(name = "extra_feature")
@Getter
public class ExtraFeature extends AbstractEntity<ExtraFeatureId> {

    private ExtraFeatureDescription extraFeature;

    private Money extraFeaturePrice;

    protected ExtraFeature() {
        super(DomainObjectId.randomId(ExtraFeatureId.class));
    }

    public ExtraFeature(@NonNull ExtraFeatureDescription extraFeatureDescription, @NonNull Money extraFeaturePrice) {
        super(DomainObjectId.randomId(ExtraFeatureId.class));
        this.extraFeature = extraFeatureDescription;
        this.extraFeaturePrice = extraFeaturePrice;
    }

}
