package com.levelsbeyond;

import static java.lang.String.*;

import java.io.File;
import java.io.IOException;

import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Download or upload
 */
public class S3TransferUtil
{
	public static void main(String[] args) throws IOException {

		String accessKey = args[0];
		String secretKey = args[1];
		String sessionToken = args[2];
		String bucketName = args[3];
		String objectKey = args[4];
		String targetPath = args[5];
		String action = args[6];

		System.out.println(format("Access key is %s", accessKey));
		System.out.println(format("Secret key is %s", secretKey));
		System.out.println(format("Session token is %s", sessionToken));
		System.out.println(format("Bucket name is %s", bucketName));
		System.out.println(format("Object key is %s", objectKey));
		System.out.println(format("Target path is %s", targetPath));
		System.out.println(format("Action is %s", action));

		AmazonS3 s3 = new AmazonS3Client(new BasicSessionCredentials(accessKey, secretKey, sessionToken));

		if (action.equals("download")) {
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, objectKey);
			s3.getObject(getObjectRequest, new File(targetPath));
			System.out.println("Download is finished.");
		}
		else if (action.equals("upload")) {
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectKey, new File(targetPath));
			s3.putObject(putObjectRequest);
			System.out.println("Upload is finished.");
		}
	}
}
