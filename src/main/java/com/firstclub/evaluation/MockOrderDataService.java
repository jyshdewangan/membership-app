package com.firstclub.evaluation;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MockOrderDataService {

    private final Map<Long, UserOrderData> userOrderDataMap;

    public MockOrderDataService() {
        userOrderDataMap = new HashMap<>();
        userOrderDataMap.put(1L, new UserOrderData(5, 1500.0));
        userOrderDataMap.put(2L, new UserOrderData(15, 3500.0));
        userOrderDataMap.put(3L, new UserOrderData(30, 8000.0));
        userOrderDataMap.put(4L, new UserOrderData(1, 200.0));
        userOrderDataMap.put(5L, new UserOrderData(50, 15000.0));
    }

    public int getOrderCount(Long userId) {
        UserOrderData data = userOrderDataMap.get(userId);
        return data != null ? data.getOrderCount() : 0;
    }

    public double getTotalOrderValue(Long userId) {
        UserOrderData data = userOrderDataMap.get(userId);
        return data != null ? data.getTotalOrderValue() : 0.0;
    }

    private static class UserOrderData {

        private final int orderCount;
        private final double totalOrderValue;

        public UserOrderData(int orderCount, double totalOrderValue) {
            this.orderCount = orderCount;
            this.totalOrderValue = totalOrderValue;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public double getTotalOrderValue() {
            return totalOrderValue;
        }
    }
}
