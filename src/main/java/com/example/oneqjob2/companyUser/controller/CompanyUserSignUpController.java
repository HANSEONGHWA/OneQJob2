package com.example.oneqjob2.companyUser.controller;

import com.example.oneqjob2.companyUser.dto.BusinessNumberRequest;
import com.example.oneqjob2.companyUser.dto.CompanySignUpRequest;
import com.example.oneqjob2.companyUser.service.BusinessNumberCheckService;
import com.example.oneqjob2.companyUser.service.CompanySignUpServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CompanyUserSignUpController {

    private final CompanySignUpServiceImpl signUpService;
    private final BusinessNumberCheckService checkService;


        /**
     * @param request       (사업자 회원정보)
     * @param bindingResult (회원 정보 검증 form bindingResult)
     * @return (binding 실패 시 에러 메세지, 회원가입 시 성공 메세지)
     */
    @PostMapping("/company/signup")
    public ResponseEntity signup(@RequestBody CompanySignUpRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid input information.");
        }
        if (!request.getCompanyPw1().equals(request.getCompanyPw2())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passwords do not match");
        }
        try {
            signUpService.companySignup(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("successfully singUp");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("Signup Error occurred");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate input information.");
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("Signup Error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed: Internal server error");
        }
    }








}


