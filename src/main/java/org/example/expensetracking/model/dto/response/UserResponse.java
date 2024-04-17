package org.example.expensetracking.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID userId;
    private String email;
    private String profileImage;
}