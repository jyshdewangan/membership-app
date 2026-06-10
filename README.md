## Summary
A Membership Program Management App for FirstClub. This platform aims to offer users subscription-based memberships with tiered
benefits, and a smooth experience integrated with the shopping and checkout journey.

## Architecture
<img width="2070" height="906" alt="image" src="https://github.com/user-attachments/assets/86e8fbfb-2814-48a0-bafc-c906e90dec52" />

### Benefit Handler
<img width="1728" height="1468" alt="image" src="https://github.com/user-attachments/assets/20531c02-78c3-4710-b3ae-a47616a94c18" />

### Tier Evaluation
<img width="1548" height="1056" alt="image" src="https://github.com/user-attachments/assets/327c2742-01ba-42da-893e-7aa2ea0f51f0" />

## Startup

```bash
git clone https://github.com/jyshdewangan/membership-app.git
cd membership-app
mvn spring-boot:run
```

The app starts on [http://localhost:8080](http://localhost:8080) with all data pre-seeded.  
H2 console available at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## API Endpoints
| # | Command | What it Does | Syntax |
|---|---------|--------------|--------|
| 1 | GET /api/membership/plans | Fetch all plans, tiers, and benefit configs | `curl -s http://localhost:8080/api/membership/plans \| json_pp` |
| 2 | POST /api/membership/subscribe | Subscribe a user to a plan and tier | `curl -s -X POST http://localhost:8080/api/membership/subscribe -H "Content-Type: application/json" -d '{"userId":1,"planId":1,"tierId":1}' \| json_pp` |
| 3 | GET /api/membership/status/{userId} | Get active subscription, tier, expiry, and benefits | `curl -s http://localhost:8080/api/membership/status/1 \| json_pp` |
| 4 | PUT /api/membership/upgrade | Upgrade to a higher-ranked tier | `curl -s -X PUT http://localhost:8080/api/membership/upgrade -H "Content-Type: application/json" -d '{"userId":1,"newTierId":2}' \| json_pp` |
| 5 | PUT /api/membership/downgrade | Downgrade to a lower-ranked tier | `curl -s -X PUT http://localhost:8080/api/membership/downgrade -H "Content-Type: application/json" -d '{"userId":1,"newTierId":1}' \| json_pp` |
| 6 | POST /api/membership/evaluate-tier/{userId} | Auto-upgrade tier based on order history | `curl -s -X POST http://localhost:8080/api/membership/evaluate-tier/3 \| json_pp` |
| 7 | DELETE /api/membership/cancel | Cancel active subscription (status → CANCELLED) | `curl -i -X DELETE http://localhost:8080/api/membership/cancel -H "Content-Type: application/json" -d '{"userId":1}'` |
