package com.firstclub.benefit;

import com.firstclub.enums.BenefitType;

/**
 * Strategy interface for handling a specific benefit type.
 *
 * @param <T> the concrete {@link BenefitConfig} this handler processes
 */
public interface BenefitHandler<T extends BenefitConfig> {

    BenefitType getSupportedType();

    BenefitConfigDTO apply(T config);
}
