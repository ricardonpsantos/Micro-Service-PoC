package com.example.user_managment_service.shared;

import java.math.BigDecimal;

public record UserCreatedEvent(
        String userId,
        String email,
        String name,
        BigDecimal initialCredit
) {}
