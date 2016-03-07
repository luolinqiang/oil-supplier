package com.oil.supplier.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.oil.supplier.common.ResponsesDTO;
import com.oil.supplier.common.ReturnCode;
import com.oil.supplier.domain.Area;
import com.oil.supplier.domain.Dictionary;
import com.oil.supplier.domain.User;
import com.oil.supplier.service.CommonService;
import com.oil.supplier.web.base.BaseControllor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午1:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CommonController extends BaseControllor {

    private static final Logger logger = Logger.getLogger(CommonController.class);

    @Autowired
    protected CommonService commonService;

    @ResponseBody
    @RequestMapping(value = "/common/getDics", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO getDics(HttpServletResponse response, Dictionary dic) {
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        List<Dictionary> dictionaryList = commonService.getDictionary(dic);
        responsesDTO.setData(dictionaryList);
        return responsesDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/common/getAreas", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO getAreas(HttpServletResponse response, Long pid) {
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        List<Area> children = commonService.getChildrenByAreaId(pid);
        responsesDTO.setData(children);
        return responsesDTO;
    }

    @RequestMapping("/common/uploadImg")
    @ResponseBody
    public String uploadImg(MultipartHttpServletRequest multiRequest) throws Exception{
        logger.info("--------上传图片----uploadImg----");
        User user = super.getCurrentUser(multiRequest);
        if (null == user) return JSONObject.toJSONString(new ResponsesDTO(ReturnCode.ERROR_LOGIN_TIMEOUT));
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        Iterator<String> iter = multiRequest.getFileNames();
        while(iter.hasNext()){
            //取得上传文件
            MultipartFile file = multiRequest.getFile(iter.next());
            if(file != null){
                try {
                    byte[] bytes = file.getBytes();
//                    String result = imgService.uploadImg(bytes);
//                    responsesDTO.setData(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return JSONObject.toJSONString(responsesDTO);
    }

}
