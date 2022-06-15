package com.example.myapplication.Book.Entity;

import com.reclebooks.backend.domain.Auth.DTO.PhoneOtpDto;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(indexes = @Index(columnList = "phone, otp_number"))
public class PhoneOtp extends BaseEntity{
    @Column(unique = true)
    String phone;

    @Setter
    @Column(nullable = false, name = "otp_number")
    String otpNumber;

    public PhoneOtp(PhoneOtpDto phoneOtpDto){
        this.phone = phoneOtpDto.getPhone();
        this.otpNumber = phoneOtpDto.getOtpNumber();
    }
}
