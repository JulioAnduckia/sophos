package com.proyecto.backend.Controller;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Model.GeneralResponse;
import com.proyecto.backend.Service.IAccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/accounts")
public class AccountController {

    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    IAccountService service;

    @GetMapping
    public ResponseEntity<GeneralResponse<List<AccountEntity>>> get() {

        GeneralResponse<List<AccountEntity>> response = new GeneralResponse<>();
        HttpStatus status = null;
        List<AccountEntity> data = null;
        String msg = null;

        try {
            data = service.get();
            msg = "It found " + data.size() + " accounts.";

            response.setMessage(msg);
            response.setSuccess(true);
            response.setData(data);
            status = HttpStatus.OK;

        } catch (Exception e) {

            msg = "Something has failed. Please contact support.";

            response.setMessage(msg);
            response.setSuccess(false);
            status = HttpStatus.INTERNAL_SERVER_ERROR;

            String log = "End point GET/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);
        }

        return new ResponseEntity<>(response, status);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<AccountEntity>> save(@RequestBody AccountEntity a) {

        boolean validateType = false;

        GeneralResponse<AccountEntity> response = new GeneralResponse<>();
        HttpStatus status = null;
        AccountEntity data = null;
        String msg;

        try {
            validateType = service.findByAccountTypeAndCustomer(a.getAccountType(), a.getCustomer()).isPresent();

            if (!validateType) {

                data = service.save(a);
                msg = "It save Account " + a.getAccountNum() + " number " + data.getAccountNum() + ".";

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                status = HttpStatus.CREATED;

            } else {

                msg = "Sorry , already an account " + a.getAccountType() + " created for that customer.";

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                status = HttpStatus.BAD_REQUEST;
            }

        } catch (Exception e) {

            msg = "Something has failed. Please contact suuport.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);

            String log = "End point POST/Accounts has failed. " + e.getLocalizedMessage();
            logger.error(log);
        }

        return new ResponseEntity<>(response, status);
    }

    @PutMapping(value = "/balance")
    public ResponseEntity<GeneralResponse<AccountEntity>> updateBalance(@RequestBody AccountEntity a) {
        double endBalance = 0;
        Optional<AccountEntity> validateA = null;

        GeneralResponse<AccountEntity> response = new GeneralResponse<>();
        HttpStatus status = null;
        AccountEntity data = null;
        String msg = null;
        String icon = null;

        try {
            validateA = service.findByAccountNum(a.getAccountNum());

            if (validateA.isPresent()) {

                endBalance= validateA.get().getBalance()-a.getBalance();

                switch (validateA.get().getAccountType()) {

                    case "ahorros":

                        if (endBalance < 0) {

                            msg = "Insufficient funds.";
                            icon = "warning";

                        } else {
                            validateA.get().setBalance(endBalance);
                            data = service.save(validateA.get());
                            msg = "It update balance of account " + data.getAccountNum() + ".";
                            icon = "success";

                        }
                        break;

                    case "corriente":

                        int overdraft = -2000000;

                        if (endBalance < overdraft) {

                            msg = "Insufficient funds, have exceeded your overdraft capacity";
                            icon = "warning";

                        } else {
                            validateA.get().setBalance(endBalance);
                            data = service.save(validateA.get());
                            msg = "It update balance of account " + data.getAccountNum() + ".";
                            icon = "success";

                        }
                        break;

                }

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp(icon);
                status = HttpStatus.OK;

            } else {

                msg = "It didn't find Account record";

                response.setMessage(msg);
                response.setSuccess(false);
                response.setData(data);
                response.setResp("info");
                status = HttpStatus.BAD_REQUEST;

            }

        } catch (Exception e) {

            msg = "Something has failed. Please contact support.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);
            response.setResp("warning");

            String log = "End point PUT/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);

        }

        return new ResponseEntity<>(response, status);
    }

    @PutMapping(value = "/state")
    public ResponseEntity<GeneralResponse<AccountEntity>> updateState(@RequestBody AccountEntity a) {

        Optional<AccountEntity> validateA = null;
        
        GeneralResponse<AccountEntity> response = new GeneralResponse<>();
        HttpStatus status = null;
        AccountEntity data = null;
        String msg = null;
        String icon = null;

        try {

            validateA = service.findByAccountNum(a.getAccountNum());

            if (validateA.isPresent()) {

                System.out.println(validateA.get().getState());
                System.out.println(a.getState());
                if ( validateA.get().getState().equals(a.getState())) {

                    msg = "Account already has that state.";
                    icon = "info";

                } else {
                    validateA.get().setState(a.getState());
                    data = service.save(validateA.get());
                    msg = "It update state of account number " + data.getAccountNum() + ".";
                    icon = "success";

                }

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp(icon);
                status = HttpStatus.OK;

            } else {

                msg = "It didn't find Account record";

                response.setMessage(msg);
                response.setSuccess(false);
                response.setData(data);
                response.setResp("info");
                status = HttpStatus.BAD_REQUEST;

            }

        } catch (

        Exception e) {

            msg = "Something has failed. Please contact support.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);
            response.setResp("warning");

            String log = "End point PUT/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);

        }

        return new ResponseEntity<>(response, status);
    }

}
