
package com.yang.common.modules.props;

public class PropsKeys {
	
	public static final String SEARCHER_SOLR_URL = "searcher.solr.url";
	
	public static final String SMS_HTTP_URL = "sms.http.url";
	public static final String SMS_HTTP_ACCOUNT = "sms.http.account";
	public static final String SMS_HTTP_PASSWD = "sms.http.passwd";

	public static final String LOCAL_TEST_URL = "local.test.url";
	
	public static final String SSO_CAS_SERVER_URL = "sso.casServerUrl";
	
	public static final String SSO_CAS_SERVICE = "sso.casService";
	
	public static final String AUDIT_LOG_ENABLED = "audit.log.enabled";
	
	public static final String SEND_MOBILEMSG_ENABLED = "send.mobilemsg.enabled";
	
	public static final String SYSTEM_ERROR_LOG_ENABLED = "system.error.log.enabled";
	
	public static final String THREAD_POOL_TASK_EXECUTOR = "thread.pool.task.executor";
	
	public static final String THREAD_POOL_TASK_EXECUTOR_CONCURRENCY_LIMIT = "thread.pool.task.executor.concurrency.limit";
	
	public static final String DEFAULT_QUEUE_SIZE = "default.queue.size";
	public static final String DEFAULT_DAEMON_DELAY = "default.daemon.delay.milliscond";
	public static final String DEFAULT_WAITING_DELAY = "default.waiting.delay.milliscond";
	public static final String DEFAULT_KEEP_ALIVE_SECONDS = "default.keep.alive.seconds";
	
	//大池子
	public static final String LARGE_CORE_POOL_SIZE = "large.thread.pool.task.executor.core.pool.size";
	public static final String LARGE_MAX_POOL_SIZE = "large.thread.pool.task.executor.max.pool.size";
	public static final String LARGE_QUEUE_CAPACITY = "large.thread.pool.task.executor.queue.capacity";
	
	//小池子
	public static final String SMALL_CORE_POOL_SIZE = "small.thread.pool.task.executor.core.pool.size";
	public static final String SMALL_MAX_POOL_SIZE = "small.thread.pool.task.executor.max.pool.size";
	public static final String SMALL_QUEUE_CAPACITY = "small.thread.pool.task.executor.queue.capacity";
	
	
	public static final String REDIS_HOST = "redis.host";
	public static final String REDIS_PORT = "redis.port";
	public static final String REDIS_TIMEOUT = "redis.timeout";
	public static final String REDIS_KEY = "redis.key";
	
	public static final String MONGODB_NAME_HOST = "mongodb.name.host";
	
	public static final String MOBILE_ALL_TEXT_ENCRYPTION = "mobile.all.text.encryption";
	
	public static final String MOBILE_TEXT_ENCRYPTION_PRIVATE_KEY = "mobile.text.encryption.private.key";
	
	public static final String MOBILE_TEXT_ENCRYPTION_TYPE = "mobile.text.encryption.type";
	
	public static final String MOBILE_TEXT_ENCRYPTION_KEY_SIZE = "mobile.text.encryption.key.size";
	
	public static final String PASSWORDS_ENCRYPTION_ALGORITHM = "passwords.encryption.algorithm";
    public static final String HASH_INTERATIONS = "hash.interations";

	public static final String PASSWORDS_DIGEST_ENCODING = "passwords.digest.encoding";
	
	public static final String MOBILE_AUTHENTIC_TYPE = "mobile.authentic.type";
	
	public static final String UPLOAD_FILE_ROOT_PATH ="upload.file.root.path";
	public static final String UPLOAD_FILE_DOWNLOAD_PATH ="upload.file.download.path";
	
	public static final String MOBILE_CLIENT_DOWNLOAD_ANDRIOD ="mobile.client.download.andriod";
	public static final String MOBILE_CLIENT_DOWNLOAD_IOS ="mobile.client.download.ios";

	public static final String MOBILE_CLIENT_DOWNLOAD_ANDRIOD_SDK ="mobile.client.download.andriod.sdk";
	public static final String MOBILE_CLIENT_DOWNLOAD_IOS_SDK ="mobile.client.download.ios.sdk";

	public static final String MOBILE_CLIENT_DOWNLOAD_IOS_PLIST ="mobile.client.download.ios.plist";


    public static final String MOBILE_QRCODE_MIN ="mobile.qrcode.min";
    public static final String MOBILE_QRCODE_MAX ="mobile.qrcode.max";

    public static final String REGISTER_IMPORT_TEMPLATE_DOWNLOAD ="register.import.template.download";
    public static final String REGISTER_USER_IMPORT_TEMPLATE_DOWNLOAD = "register.user.import.template.download";
	
	public static final String DEFAULT_THREAD_COUNT ="default.thread.count";
	
	public static final String UPLOAD_FILE_TYPE_IMG = "upload.file.type.img";
	public static final String UPLOAD_FILE_TYPE_DOCUMENT = "upload.file.type.document";
	public static final String UPLOAD_FILE_TYPE_VIDEO = "upload.file.type.video";
	public static final String UPLOAD_FILE_TYPE_AUDIO = "upload.file.type.audio";
	public static final String UPLOAD_FILE_TYPE_CERT = "upload.file.type.certificate";


	public static final String UPLOAD_IMG_SIZE_MOBILE_WIDTH = "upload.img.size.mobile.width";
	
	public static final String UPLOAD_IMG_SIZE_MID_WIDTH = "upload.img.size.mid.width";
	
	public static final String UPLOAD_IMG_SIZE_MIN_WIDTH = "upload.img.size.min.width";
	
	public static final String MOBILESEND_APPKEY = "mobileSend.appkey";
	
	public static final String MOBILESEND_MASTERSECERT = "mobileSend.mastersecert";
	
	public static final String SERVICE_DOMAIN = "service.domain";
    public static final String NGINX_DOMAIN = "nginx.domain";
	public static final String WEIXIN_DOMAIN = "weixin.domain";
	public static final String WEB_PROJECT_NAME = "web.project.name";
	public static final String ORGANIZATION_DOMAIN = "organization.domain";
	public static final String ORGANIZATION_DOMAIN_BAK = "organization.domain.bak";
	public static final String WORKTIME_STANDARD = "worktime.standard";
	public static final String SATISFACTION_STANDARD = "satisfaction.standard";

	public static final String HTTP_PROXYHOST = "http.proxyHost";
	public static final String HTTP_PROXYPORT = "http.proxyPort";
	

	public static final String MAIL_SMTP_USER = "mail.smtp.user";
	public static final String MAIL_SMTP_PASSWORD = "mail.smtp.password";
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	
	public static final String SMS_DOWNLOAD_MOBILE_CLIENT_IOS = "sms.download.mobile.client.ios";

	public static final String LOGO_PATH ="logo.path";
//    public static final String BLOG_CONTENT_DIV1="blog.content.div1";
//    public static final String BLOG_CONTENT_DIV2="blog.content.div2";
//    public static final String BLOG_CONTENT_DIV3="blog.content.div3";
    public static final String BLOG_CONTENT_STYLE_DIV="blog.content.style.div";
    public static final String BLOG_CONTENT_STYLE_VIDEO="blog.content.style.video";

//	public static final String EMAIL_SERVER_BIN_PATH = "email.server.bin.path";
    
	
	public static final String MONGODB_POOL_HOST = "mongodb.pool.host";
	public static final String MONGODB_POOL_PORT = "mongodb.pool.port";
	public static final String MONGODB_POOL_POOLSIZE = "mongodb.pool.poolSize";
	public static final String MONGODB_POOL_BLOCKSIZE = "mongodb.pool.blockSize";
	
	
	public static final String MAIL_IMAP_LOCALPORT = "mail.imap.localport";
	public static final String MAIL_SMTP_LOCALPORT = "mail.smtp.localport";
	
	public static final String NODE_CHAT_DOMAIN = "node.chat.domain";
	public static final String NODE_CHAT_SYNC_DISENABLE = "node.chat.sync.disenable";
	
	public static final String NODE_CHAT_ADMIN_SECRET = "node.chat.admin.secret";
	public static final String NODE_CHAT_MASTER_SECRET = "node.chat.master.secret";

	public static final String WEBCHAT_STYLE_JS_PATH = "webchat.style.js.path";

	public static final String OPEN_REGISTRATION = "open.registration";
	
	public static final String DEFAULT_LOCALE = "default.locale";

    public static final String MOBILESEND_PREFIX = "mobileSend.prefix";

    public static final String WEIXIN_PLATFORM_TOKEN = "weixin.platform.token";
    public static final String WEIXIN_PLATFORM_APPID = "weixin.platform.appid";
    public static final String WEIXIN_PLATFORM_APPSECRET = "weixin.platform.appsecret";
    public static final String WEIXIN_PLATFORM_AES_KEY = "weixin.platform.aes.key";

	public static final String ROBOT_API_URL = "robot.api.url";
	public static final String ROBOT_API_DEFAULT_KEY = "robot.api.default.key";
	public static final String ROBOT_API_USER = "robot.api.user";
	public static final String ROBOT_ENABLED = "robot.enabled";

	public static final String SMART_NUMBER_FLAG = "smart.number.flag";
	public static final String SMART_NUMBER_API_URL = "smart.number.api.url";
	public static final String SMART_NUMBER_APPKEY = "smart.number.app.key";
	public static final String SMART_NUMBER_APPSECRET = "smart.number.app.secret";
	public static final String SMART_NUMBER_PROFIEDID = "smart.number.app.profiedid";

	public static final String EMOTION_ENABLED = "emotion.enabled";
	public static final String EMOTION_API_URL = "emotion.api.url";
	public static final String EMOTION_API_AUTHORIZATION = "emotion.api.authorization";
	public static final String EMOTION_V2_API_URL = "emotion.v2.api.url";
	public static final String EMOTION_V2_API_USER = "emotion.v2.api.user";
	public static final String EMOTION_V2_API_PWD = "emotion.v2.api.pwd";
	public static final String EMOTION_TYPE_WORDS = "emotion.type.words";

	public static final String MAIXIN_INTERFACE_KEY = "maixin.interface.key";

	public static final String DEFORMABLE_API_URL = "deformable.api.url";
	public static final String CONFERENCE_API_URL = "conference.api.url";
	public static final String CALLCENTER_API_URL = "callcenter.api.url";

	public static final String SYSTEM_NOTICE_EMAIL = "system.notice.email";

	public static final String ALIPAY_LOG_PATH = "alipay_log_path";
	public static final String ALIPAY_LOG_OPEN = "alipay_log_open";

	public static final String MONTHLY_FEE_STANDARD = "monthly.fee.standard";	//标准版月费用
	public static final String MONTHLY_FEE_PRO = "monthly.fee.pro";	//高级版月费用

	public static final String TEST_ORG_ID = "test.org.id";

	public static final String WEIXIN_CONFIG_URL = "weixin.config.url";
	public static final String ANF_API_URL = "anf.api.url";

	public static final String NAMESPACE_ADMIN_NAME = "namespace.admin.name";
}
