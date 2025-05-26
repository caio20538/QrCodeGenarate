package com.caio.QrCodeGeneretor.controller;

import com.caio.QrCodeGeneretor.dto.qrCode.QrCodeGenerateRequest;
import com.caio.QrCodeGeneretor.dto.qrCode.QrCodeGenerateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request){
        return null;
    }

}
