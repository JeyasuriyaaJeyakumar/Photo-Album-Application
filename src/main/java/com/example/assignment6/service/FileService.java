package com.example.assignment6.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    public boolean upload(MultipartFile file) {

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIATXNVBL5NXPGO3COW","QDfqH4m/zExFVV1NkZld3FlvGRxTHgedyuO85/nm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
        try{
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("gmh.backend", file.getOriginalFilename(), file.getInputStream(), metadata);
            return true;
        }catch (AmazonServiceException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIATXNVBL5NXPGO3COW","QDfqH4m/zExFVV1NkZld3FlvGRxTHgedyuO85/nm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
        return s3.getObject("gmh.backend", key);

    }

    public void deleteFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIATXNVBL5NXPGO3COW","QDfqH4m/zExFVV1NkZld3FlvGRxTHgedyuO85/nm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
        s3.deleteObject("gmh.backend", key);
    }
}
