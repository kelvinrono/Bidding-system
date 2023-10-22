package com.bidding.platform.objects;

import com.bidding.platform.models.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserObject {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private long role;
}
