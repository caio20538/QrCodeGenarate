package com.caio.QrCodeGeneretor.ports;

public interface StoragePort {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
