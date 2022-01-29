package com.proyecto.backend.Controller;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.CustomerEntity;
import com.proyecto.backend.Model.GeneralResponse;
import com.proyecto.backend.Service.ICustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    ICustomerService service;

    @GetMapping
    public ResponseEntity<GeneralResponse<List<CustomerEntity>>> get() {

        GeneralResponse<List<CustomerEntity>> response = new GeneralResponse<>();
        HttpStatus status = null;
        List<CustomerEntity> data = null;
        String msg = null;

        try {
            data = service.get();
            msg = "It found " + data.size() + " customers.";

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
    public ResponseEntity<GeneralResponse<CustomerEntity>> save(@RequestBody CustomerEntity c) {

        boolean srhEmail = false;
        boolean srhDoc = false;

        GeneralResponse<CustomerEntity> response = new GeneralResponse<>();
        HttpStatus status = null;
        CustomerEntity data = null;
        String msg = null;

        try {
            srhDoc = service.findByDocumentTypeAndDocumentNum(c.getDocumentType(),
                    c.getDocumentNum()).isPresent();

            srhEmail = service.findByEmail(c.getEmail()).isPresent();

            if (srhEmail) {

                if (srhDoc) {

                    msg = "Sorry , Document already exist.";

                    response.setMessage(msg);
                    response.setSuccess(false);
                    response.setData(data);
                    response.setResp("info");
                    status = HttpStatus.BAD_REQUEST;

                } else {

                    msg = "Sorry , Email already exist.";

                    response.setMessage(msg);
                    response.setSuccess(false);
                    response.setData(data);
                    response.setResp("info");
                    status = HttpStatus.BAD_REQUEST;

                }

            } else {

                data = service.save(c);
                msg = "It save customer " + data.getId() + ".";

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp("success");
                status = HttpStatus.CREATED;

            }

        } catch (Exception e) {

            msg = "Something has failed. Please contact support.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);
            response.setResp("warning");

            String log = "End point POST/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);

        }

        return new ResponseEntity<>(response, status);
    }

    @PutMapping
    public ResponseEntity<GeneralResponse<CustomerEntity>> update(@RequestBody CustomerEntity c) {

        boolean srhEmail = false;

        GeneralResponse<CustomerEntity> response = new GeneralResponse<>();
        HttpStatus status = null;
        CustomerEntity data = null;
        String msg = null;

        try {
            srhEmail = service.findByEmail(c.getEmail()).isPresent();
            if (srhEmail) {
                
                msg = "Sorry , Email already exist.";

                response.setMessage(msg);
                response.setSuccess(false);
                response.setData(data);
                response.setResp("info");
                status = HttpStatus.BAD_REQUEST;

            } else {

                data = service.save(c);
                msg = "It update customer " + data.getId() + ".";

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp("success");
                status = HttpStatus.CREATED;

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

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<GeneralResponse<Boolean>> delete(@PathVariable("id") Integer id) {

        boolean srhOk = false;

        GeneralResponse<Boolean> response = new GeneralResponse<>();
        HttpStatus status = null;
        boolean data = false;
        String msg;

        try {
            srhOk = service.findById(id).isPresent();

            if (srhOk) {

                data = service.delete(id);

                msg = "Successful clear to customer " + id;

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp("success");
                status = HttpStatus.OK;

            } else {

                msg = "It didn't find customer record";

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp("info");
                status = HttpStatus.OK;

            }

        } catch (Exception e) {

            msg = "Something has failed. Please contact suuport.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);
            response.setResp("Error");

            String log = "End point DELETE/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);
        }

        return new ResponseEntity<>(response, status);
    }

    @GetMapping(value = "/email/{email}/password/{password}")
    public ResponseEntity<GeneralResponse<Optional<CustomerEntity>>> login(@PathVariable("email") String email,
            @PathVariable("password") String password) {

        GeneralResponse<Optional<CustomerEntity>> response = new GeneralResponse<>();
        HttpStatus status = null;
        Optional<CustomerEntity> data = null;
        String msg;

        try {

            data = service.findByEmailAndPassword(email, password);
            msg = "Successful login " + data.get().getName();

            response.setMessage(msg);
            response.setSuccess(true);
            response.setData(data);
            status = HttpStatus.OK;

        } catch (Exception e) {

            msg = "Something has failed. Please contact suuport.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);

            String log = "End point GET/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);
        }

        return new ResponseEntity<>(response, status);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GeneralResponse<Optional<CustomerEntity>>> findById(@PathVariable("id") Integer id) {

        boolean srhOk = false;

        GeneralResponse<Optional<CustomerEntity>> response = new GeneralResponse<>();
        HttpStatus status = null;
        Optional<CustomerEntity> data = null;
        String msg;

        try {

            data = service.findById(id);
            srhOk = service.findById(id).isPresent();
            if (srhOk) {
                msg = "Successful search to" + data.get().getName();

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp("success");
                status = HttpStatus.OK;

            } else {

                msg = "It didn't find customer record";

                response.setMessage(msg);
                response.setSuccess(true);
                response.setData(data);
                response.setResp("info");
                status = HttpStatus.OK;

            }

        } catch (Exception e) {

            msg = "Something has failed. Please contact suuport.";

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setMessage(msg);
            response.setSuccess(false);
            response.setResp("Error");

            String log = "End point GET/customers has failed. " + e.getLocalizedMessage();
            logger.error(log);
        }

        return new ResponseEntity<>(response, status);
    }

}
