package com.example.oneqjob2.companyUser.service;

import com.example.oneqjob2.companyUser.dto.CompanySignUpRequest;
import com.example.oneqjob2.companyUser.repository.CompanyRepository;
import com.example.oneqjob2.entity.CompanyUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class CompanySignUpServiceImpl implements CompanySignUpService {

    private final CompanyRepository repository;
    private final PasswordEncoder passwordEncoder;


    /**
     * 회원가입
     * @param request (사업자 회원 정보)
     */
    public void companySignup(CompanySignUpRequest request) {
        CompanyUser companyUser = CompanyUser.builder()
                .companyName(request.getCompanyName())
                .businessNumber(request.getBusinessNumber())
                .companyLogoImgUrl(request.getCompanyLogoImgUrl())
                .companyLogoImgPileName(request.getCompanyLogoImgPileName())
                .companyEmail(request.getCompanyEmail())
                .companyPw(passwordEncoder.encode(request.getCompanyPw1()))
                .build();
        this.repository.save(companyUser);
    }

}

