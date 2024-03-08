package com.example.oneqjob2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    //기업이름
    @Column(nullable = false)
    private String companyName;

    //사업자번호
    @Column(length = 10, unique = true, nullable = false)
    private String businessNumber;

    //사진명
    private String companyLogoImgPileName;

    //사진url
    private String companyLogoImgUrl;

    //이메일
    @Column(unique = true,  nullable = false)
    private String companyEmail;

    //비밀번호
    @Column(length = 64,  nullable = false)
    private String companyPw;

}
