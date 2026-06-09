package com.firstclub.benefit;

/**
 * Marker interface for benefit configuration classes.
 * <p>
 * The type discriminator (benefitType) lives on the TierBenefit entity,
 * not inside the JSON blob, so no Jackson polymorphic annotations are needed here.
 * Deserialization is handled manually in {@link BenefitHandlerRegistry}.
 * </p>
 */
public interface BenefitConfig {
}
