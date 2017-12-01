<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yang.common.alipay.config.AlipayConfig"%>
<%@ page import="com.yang.common.alipay.util.AlipaySubmit"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>支付宝即时到账交易接口</title>
</head>
<%
	//商户订单号，商户网站订单系统中唯一订单号，必填
	String out_trade_no = request.getAttribute("outTradeno").toString();
	//订单名称，必填
	String subject = request.getParameter("subject");

	//付款金额，必填
	String total_fee = request.getAttribute("totalFee").toString();
	//回调地址，必填
	String return_url = request.getAttribute("return_url").toString();
	//异步通知地址，必填
	String notify_url = request.getAttribute("notify_url").toString();

	String extra_common_param = request.getAttribute("extra_common_param").toString();

	//把请求参数打包成数组
	Map<String, String> sParaTemp = new HashMap<String, String>();
	sParaTemp.put("service", AlipayConfig.service);
	sParaTemp.put("partner", AlipayConfig.partner);
	sParaTemp.put("seller_id", AlipayConfig.seller_id);
	sParaTemp.put("_input_charset", AlipayConfig.input_charset);
	sParaTemp.put("payment_type", AlipayConfig.payment_type);
	sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
	sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
	sParaTemp.put("notify_url", notify_url);
	sParaTemp.put("return_url", return_url);
	sParaTemp.put("extra_common_param",extra_common_param);
	sParaTemp.put("out_trade_no", out_trade_no);
	sParaTemp.put("subject", subject);
	sParaTemp.put("total_fee", total_fee);

	//建立请求
	String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
	out.println(sHtmlText);
%>
<body>
</body>
</html>