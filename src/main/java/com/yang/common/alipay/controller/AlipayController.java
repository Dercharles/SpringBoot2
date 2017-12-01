package com.yang.common.alipay.controller;

import com.yang.common.alipay.entrty.PaymentBill;
import com.yang.common.alipay.util.UtilDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/console/submitAlipay")
public class AlipayController{
    private static Logger log = LoggerFactory.getLogger(AlipayController.class);

    /**
     * @apiDescription 使用支付宝支付订单
     * @api {GET} /console/submitAlipay/toAlipay /console/submitAlipay/toAlipay
     * @apiVersion 2.0.0
     * @apiName OrderPayment
     * @apiGroup console-payment
     *
     * @apiParam {String} outTradeno 订单号(16位)
     * @apiParam {String} subject 订单名称
     * @apiParam {Long} orgId 公司编号
     *
     *
     * @apiSuccessExample 重定向web页:
     *     redirect:http://"+ UserCache.getOrgDomain(paymentBill.getOrgId())+"/"+ SysConstants.WEB_PROJECT_NAME+"/#/console/enterprise/management/list
     */
    @RequestMapping(value = "/toAlipay", method= RequestMethod.GET)
    public String submitAlipay(@RequestParam("outTradeno") String outTradeno, @RequestParam("subject") String subject, @RequestParam("orgId") Long orgId, HttpServletRequest request, HttpServletResponse response){
        log.info("------------alipay_toAlipay-------------");
        PaymentBill paymentBill = new PaymentBill();
        String Order_Number = UtilDate.getOrderNum()+paymentBill.getBillNo();
        if (paymentBill != null) {
            request.setAttribute("outTradeno", Order_Number);
            request.setAttribute("subject", subject);
            if (paymentBill.getDiscountPrice() != null){
                request.setAttribute("totalFee", paymentBill.getDiscountPrice());
            }else {
                request.setAttribute("totalFee", paymentBill.getSumPrice());
            }
            request.setAttribute("extra_common_param",paymentBill.getOrgId());
            /**
             * 回掉地址
             */
            request.setAttribute("return_url","http:///open/ali/payment/return_url/callback");
            /**
             * 异步通知地址
             */
            request.setAttribute("notify_url","http:///open/ali/payment/notify_url/callback");
            log.info("notify_url",request.getAttribute("notify_url"));
            log.info("return_url",request.getAttribute("return_url"));
            //request.setAttribute("return_url","http://visonet.ngrok.cc/wsk/open/ali/payment/return_url/callback");
            //request.setAttribute("notify_url","http://visonet.ngrok.cc/wsk/open/ali/payment/notify_url/callback");
            log.info("------------alipay_toAlipay_success-------------");
            return "alipayapi";
        }
        log.info("------------alipay_toAlipay_error-------------");
        return "redirect:http:///#/console/enterprise/management/list";
    }
}
