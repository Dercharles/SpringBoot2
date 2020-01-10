package com.example.springboot2.yang.foundation.controller;

import com.example.springboot2.yang.common.alipay.util.UtilDate;
import com.example.springboot2.yang.common.base.rest.RestException;
import com.example.springboot2.yang.common.constant.BusinessStatus;
import com.example.springboot2.yang.common.constant.MobileKey;
import com.example.springboot2.yang.common.file.FileUtil;
import com.example.springboot2.yang.common.modules.MessageSourceHelper;
import com.example.springboot2.yang.common.modules.props.PropsKeys;
import com.example.springboot2.yang.common.modules.props.PropsUtil;
import com.example.springboot2.yang.common.modules.time.DateUtil;
import com.example.springboot2.yang.common.modules.validate.Validator;
import com.example.springboot2.yang.foundation.service.FileUploadService;
import com.example.springboot2.yang.foundation.vo.AttachmentIoVo;
import com.example.springboot2.yang.foundation.vo.AttachmentVo;
import com.example.springboot2.yang.foundation.vo.Encrypt;
import org.assertj.core.util.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.springboot2.yang.common.base.controller.BaseController.GetSuccMap;
import static com.example.springboot2.yang.common.base.rest.BaseRest.throwException;

@Controller
public class FileUploadController {

    public static int MaxSize=102400000;


    /**
     * @apiDescription 通用上传(登录验证)
     * @api {post} /mobile/upload /mobile/upload
     * @apiVersion 2.0.0
     * @apiName upload
     * @apiGroup Common
     * @apiPermission user
     *
     * @apiParam {HttpServletRequest} request form-data文件上传
     *
     * @apiSuccess {String} realName 文件原名
     * @apiSuccess {String} uuidName 文件原名(图片类型，文件名末尾会有“_width*height”表示图片宽高)
     * @apiSuccess {String} url 文件http下载路径
     * @apiSuccess {String} relativePath 文件http相对路径（回传业务接口）
     * @apiSuccess {String} state 成功标志（成功：SUCCESS，flash接收用）
     *
     * @apiSuccessExample {json} List<AttachmentVo>
     *      [
     *        {
     *          "realName": "dev.p12",
     *          "uuidName": "94f35dca-b57d-4143-aaf5-51efe35d763a-7426.p12",
     *          "url": "/downloadFile/visionet/2016-10-12/certificate/94f35dca-b57d-4143-aaf5-51efe35d763a-7426.p12",
     *          "relativePath": "visionet/2016-10-12/certificate/94f35dca-b57d-4143-aaf5-51efe35d763a-7426.p12",
     *          "state":"SUCCESS"
     *        },
     *        {
     *          "realName": "prod.p12",
     *          "uuidName": "62fd8c75-6215-4022-b849-c586773e8360-5391.p12",
     *          "url": "/downloadFile/visionet/2016-10-12/certificate/62fd8c75-6215-4022-b849-c586773e8360-5391.p12",
     *          "relativePath": "visionet/2016-10-12/certificate/62fd8c75-6215-4022-b849-c586773e8360-5391.p12",
     *          "state":"SUCCESS"
     *        },
     *        {
     *          "uuidName": "4b543020-4927-4f9d-a383-3a09f6ccf47d-199_800*600.jpg",
     *          "realName": "BingWallpaper-2016-07-01.jpg",
     *          "url": "/downloadFile/visionet/2016-10-18/image/4b543020-4927-4f9d-a383-3a09f6ccf47d-199_800*600.jpg",
     *          "relativePath": "visionet/2016-10-18/image/4b543020-4927-4f9d-a383-3a09f6ccf47d-199_800*600.jpg",
     *          "state": "SUCCESS"
     *        }
     *      ]
     */
//    @RequestMapping(value = "/mobile/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<?> upload(HttpServletRequest request)	throws Exception {
//        String subdomain=UserCache.getOrgSubDomain(BaseController.getCurrentOrgId());
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//        List<AttachmentVo> resultList = Lists.newArrayList();
//        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//            resultList.add(FileUploadService.Upload(entity.getValue(), subdomain));
//        }
//        return new ResponseEntity<List<AttachmentVo>>(resultList, HttpStatus.OK);
//    }


    /**
     * @apiDescription 单个文件通用上传(登录验证)
     * @api {post} /mobile/upload/one /mobile/upload/one
     * @apiVersion 2.0.0
     * @apiName uploadOne
     * @apiGroup Common
     * @apiPermission user
     *
     * @apiParam {HttpServletRequest} request form-data文件上传
     *
     * @apiSuccess {String} realName 文件原名
     * @apiSuccess {String} uuidName 文件原名(图片类型，文件名末尾会有“_width*height”表示图片宽高)
     * @apiSuccess {String} url 文件http下载路径
     * @apiSuccess {String} relativePath 文件http相对路径（回传业务接口）
     * @apiSuccess {String} state 成功标志（成功：SUCCESS，flash接收用）
     *
     * @apiSuccessExample {json} AttachmentVo
     *      {
     *        "uuidName": "4b543020-4927-4f9d-a383-3a09f6ccf47d-199_800*600.jpg",
     *        "realName": "BingWallpaper-2016-07-01.jpg",
     *        "state": "SUCCESS",
     *        "url": "/downloadFile/visionet/2016-10-18/image/4b543020-4927-4f9d-a383-3a09f6ccf47d-199_800*600.jpg",
     *        "relativePath": "visionet/2016-10-18/image/4b543020-4927-4f9d-a383-3a09f6ccf47d-199_800*600.jpg"
     *      }
     */
    @RequestMapping(value = "/mobile/upload/one", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadOne(HttpServletRequest request)	throws Exception {
        String subdomain=null;
        //String subdomain=UserCache.getOrgSubDomain(BaseController.getCurrentOrgId());
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        Map.Entry<String, MultipartFile> entity = fileMap.entrySet().iterator().next();
        AttachmentVo vo = FileUploadService.Upload(entity.getValue(), subdomain);

        return new ResponseEntity<AttachmentVo>(vo, HttpStatus.OK);
    }

    /**
     * @apiDescription 通用上传(MD5验证)
     * @api {post} /open/upload /open/upload
     * @apiVersion 2.0.0
     * @apiName uploadOpen
     * @apiGroup Common
     * @apiPermission anon
     *
     * @apiParam {HttpServletRequest} request form-data文件上传
     * @apiParam {Long} timestamp 发送时间戳（验证是否在10分钟内发送）
     * @apiParam {Long} token md5验证码（时间戳timestamp+密钥Key生成）(测试key：visionet_letsdesk2.0)
     * @apiParam {String} namespace 公司key(同SDK的namespace)
     *
     *
     * @apiParamExample {url} 参数:
     * /open/upload /open/upload?timestamp=1431077426579&token=34d9f4551cfb922cb41a40553dd7bf22&namespace=visionet
     *
     * @apiSuccess {String} realName 文件原名
     * @apiSuccess {String} uuidName 文件原名(图片类型，文件名末尾会有“_width*height”表示图片宽高)
     * @apiSuccess {String} url 文件http下载路径
     * @apiSuccess {String} relativePath 文件http相对路径（回传业务接口）
     * @apiSuccess {String} state 成功标志（成功：SUCCESS，flash接收用）
     *
     * @apiSuccessExample {json} List<AttachmentVo>
     *   [
     *     {
     *        "uuidName": "d2dd0e9d-8425-4588-adad-2d90c4cc3386-7677_800*600.jpg",
     *        "realName": "test12.jpg",
     *        "url": "/downloadFile/2016-08-31/image/d2dd0e9d-8425-4588-adad-2d90c4cc3386-7677_800*600.jpg",
     *        "relativePath": "2016-08-31/image/d2dd0e9d-8425-4588-adad-2d90c4cc3386-7677_800*600.jpg",
     *        "state":"SUCCESS"
     *     }
     *   ]
     */
    @RequestMapping(value = "/open/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadOpen(HttpServletRequest request,
                                        @RequestParam("timestamp") Long timestamp,
                                        @RequestParam("namespace") String namespace,
                                        @RequestParam("token") String token)	throws Exception {
        if(Validator.isNull(namespace)){
            throw new RestException(BusinessStatus.REQUIRE,"namespace is null!");
        }
        //验证MD5校验码
        Encrypt encrypt = new Encrypt();
        encrypt.setAccessToken(token);
        encrypt.setTimestamp(timestamp);
        FileUploadService.EncryptText(encrypt);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        List<AttachmentVo> resultList = Lists.newArrayList();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            resultList.add(FileUploadService.Upload(entity.getValue(), namespace));
        }
        return new ResponseEntity<List<AttachmentVo>>(resultList, HttpStatus.OK);
    }



    /**
     * @apiDescription app发布上传
     * @api {post} /app-upload /app-upload
     * @apiVersion 2.0.0
     * @apiName app-upload
     * @apiGroup console-app
     * @apiPermission anon
     *
     * @apiSuccessExample {json} Map<String,String>
     *  {
     *     "code": "10000"
     *  }
     */
    @RequestMapping(value = "/app-upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> appUpload(HttpServletRequest request) throws Exception {
        Map<String,String> result = GetSuccMap();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            // 上传文件名
            MultipartFile file = entity.getValue();
            this.checkMaxSize(file.getSize());
            String path = PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_ROOT_PATH);
            String sourceFileName = file.getOriginalFilename();
            String type = sourceFileName.substring(sourceFileName.lastIndexOf(".") + 1);
            String relativePath = null;

            if (type.equals("ipa")) {
                relativePath = PropsUtil.getProperty(PropsKeys.MOBILE_CLIENT_DOWNLOAD_IOS);
            } else if (type.equals("apk")) {
                relativePath = PropsUtil.getProperty(PropsKeys.MOBILE_CLIENT_DOWNLOAD_ANDRIOD);
            } else {
                result.put(MobileKey.CODE, BusinessStatus.ILLEGAL);
                result.put(MobileKey.MSG, MessageSourceHelper.GetMessages("app.web.business.FileUploadController.type.error"));
            }

            File appFile = new File(path + File.separatorChar + relativePath);

            appFile.getParentFile().mkdirs();
            appFile.delete();

            file.transferTo(appFile);


        }
        return new ResponseEntity<Map<String,String>>(result, HttpStatus.OK);
    }
    /**
     * @apiDescription 截图上传
     * @api {post} /open/io-upload /open/io-upload
     * @apiVersion 2.0.0
     * @apiName io-upload
     * @apiGroup Common
     * @apiPermission anon
     *
     * @apiParam {String} ioFile io文件流
     * @apiParam {String} subdomain 公司域名
     *
     *
     * @apiSuccessExample {json} Map<String,String>
     *  {
     *     "imageUrl": "/downloadFile/visionet/2017-06-12/20170612144604.jpg"
     *  }
     */
    @RequestMapping(value = "/open/io-upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> appUpload(@RequestBody AttachmentIoVo attachmentIoVo) throws Exception {
        final String fileName = UtilDate.getOrderNum() + ".jpg";
        final String fileUrl = attachmentIoVo.getSubdomain()+"/"+ DateUtil.convertToString(new Date(), "yyyy-MM-dd");
        final String mkdirPath = PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_ROOT_PATH)+fileUrl;
        File file = new File(mkdirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePathNamr = mkdirPath+"/"+fileName;
        Map<String,String> result = new HashMap<>();
        System.out.println("imageUrl:"+filePathNamr);
        if (FileUtil.GenerateImage(attachmentIoVo.getIoFile(),filePathNamr)){
            result.put("imageUrl",PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_DOWNLOAD_PATH)+fileUrl+"/"+fileName);
        }else {
            throw new RestException(MessageSourceHelper.GetMessages("app.talk.service.MessageService.messageContent.type.io.url.null"));
        }

        return new ResponseEntity<Map<String,String>>(result, HttpStatus.OK);
    }
    private void checkMaxSize(long size){
        if(size > MaxSize){
            throwException(BusinessStatus.LENGTH_LIMIT,"file max size:"+MaxSize);
        }
    }
}
