A simple Utility to upload and download files from s3 when you have temporary credentials.

Usage:

```
java -jar target/s3-transfer-util-1.0-SNAPSHOT.jar {ACCESS_KEY} {SECRET_KEY} {SESSION_TOKEN} {bucket_name}
{object_key} {file_path} {upload|download}
```