package com.example.spring_school.service;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Service
public class FileService {

    @Value("${uploadProfile}")
    private String uploadProfile;

    private MemberRepository memberRepository;

    public String uploadFile(String uploadPath, String fileName, byte[] fileData) throws Exception {
        UUID uuid = UUID.randomUUID();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String saveName = uuid.toString() + extension;
        String fileUploadUrl = uploadPath + "/" + saveName;
        FileOutputStream fos = new FileOutputStream(fileUploadUrl);
        //byte[] decodeFileData = Base64.getDecoder().decode(fileData);
//        fos.
        fos.write(fileData);
        fos.close();
        return fileUploadUrl;
    }

    public String saveFile(MultipartFile files) throws IOException {
        if (files.isEmpty()) {
            return null;
        }

        String oriName = files.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();

        String extension = oriName.substring(oriName.lastIndexOf("."));

        String savedName = uuid + extension;

        String savedPath = uploadProfile + savedName;

        MemberDto memberDto = new MemberDto();

        files.transferTo(new File(savedPath));


        return "저장 성공";
    }

    public void deleteFile(String filePath) throws Exception {
        File deleteFile = new File(filePath);

        if (deleteFile.exists()) {
            deleteFile.delete();
            System.out.println("파일 삭제 완료");
        } else {
            System.out.println("파일이 없습니다.");
        }
    }

    public byte[] getFile(String uploadPath) throws IOException {


//        System.out.println("uploadPath----------------------->" + uploadPath);
//        FileInputStream fis = new FileInputStream(uploadPath);
//
//        System.out.println("returnImage--------------------------------------------------->" + fis.readAllBytes());
//
//        int image = fis.read();
//
//        System.out.println("image by read-----------------------------------------> " + image);
//
//        String image_string = new String(fis.readAllBytes());
//        System.out.println("image_string 값:" + image_string);
//
//        return fis.readAllBytes();

        try {
            BufferedImage image = null;
            URL url = new URL("file:///C:/Users/xogus/spring_school/src/main/resources/static/image/profile/34bda446-fcc0-4385-8c2e-52ccb0be69d8.jpg");

            //로컬 파일을 사용하는 경우
            File imageFile = new File("C:/Users/xogus/spring_school/src/main/resources/static/image/profile/34bda446-fcc0-4385-8c2e-52ccb0be69d8.jpg");
            System.out.println("뭐고" + imageFile);


        }catch (IOException e){
            e.printStackTrace();
        }

        return new byte[0];
    }

//    public String saveImage(String path, Image image){
//
//    }

}

