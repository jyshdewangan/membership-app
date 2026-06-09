-- === Plans ===
INSERT INTO membership_plan (id, name, price, duration_days) VALUES (1, 'MONTHLY', 199.00, 30);
INSERT INTO membership_plan (id, name, price, duration_days) VALUES (2, 'QUARTERLY', 499.00, 90);
INSERT INTO membership_plan (id, name, price, duration_days) VALUES (3, 'YEARLY', 1499.00, 365);

-- === Tiers ===
INSERT INTO membership_tier (id, name, rank) VALUES (1, 'SILVER', 1);
INSERT INTO membership_tier (id, name, rank) VALUES (2, 'GOLD', 2);
INSERT INTO membership_tier (id, name, rank) VALUES (3, 'PLATINUM', 3);

-- === Tier Benefits ===
-- SILVER
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (1, 1, 'FREE_DELIVERY', '{"minOrderValue": 499}', true);
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (2, 1, 'DISCOUNT', '{"percentage": 5, "maxAmount": 100}', true);
-- GOLD
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (3, 2, 'DISCOUNT', '{"percentage": 10, "maxAmount": 200}', true);
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (4, 2, 'EARLY_ACCESS', '{"hoursBeforeSale": 12}', true);
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (5, 2, 'FREE_DELIVERY', '{"minOrderValue": 299}', true);
-- PLATINUM
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (6, 3, 'DISCOUNT', '{"percentage": 15, "maxAmount": 500}', true);
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (7, 3, 'COUPON_ACCESS', '{"couponCode": "PLAT25", "usageLimit": 10}', true);
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (8, 3, 'EARLY_ACCESS', '{"hoursBeforeSale": 48}', true);
INSERT INTO tier_benefit (id, tier_id, benefit_type, config, active) VALUES (9, 3, 'FREE_DELIVERY', '{"minOrderValue": 0}', true);

-- === Eligibility Criteria ===
-- SILVER
INSERT INTO tier_eligibility_criteria (id, tier_id, criteria_type, threshold_value) VALUES (1, 1, 'ORDER_COUNT', 2.0);
INSERT INTO tier_eligibility_criteria (id, tier_id, criteria_type, threshold_value) VALUES (2, 1, 'ORDER_VALUE', 500.0);
-- GOLD
INSERT INTO tier_eligibility_criteria (id, tier_id, criteria_type, threshold_value) VALUES (3, 2, 'ORDER_COUNT', 10.0);
INSERT INTO tier_eligibility_criteria (id, tier_id, criteria_type, threshold_value) VALUES (4, 2, 'ORDER_VALUE', 2000.0);
-- PLATINUM
INSERT INTO tier_eligibility_criteria (id, tier_id, criteria_type, threshold_value) VALUES (5, 3, 'ORDER_COUNT', 25.0);
INSERT INTO tier_eligibility_criteria (id, tier_id, criteria_type, threshold_value) VALUES (6, 3, 'ORDER_VALUE', 5000.0);
