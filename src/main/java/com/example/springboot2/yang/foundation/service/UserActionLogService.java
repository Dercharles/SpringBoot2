package com.example.springboot2.yang.foundation.service;

import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.example.springboot2.yang.common.base.controller.BaseController;
import com.example.springboot2.yang.common.base.rest.RestException;
import com.example.springboot2.yang.common.modules.MessageSourceHelper;
import com.example.springboot2.yang.common.modules.mapper.JsonMapper;
import com.example.springboot2.yang.common.modules.time.DateUtil;
import com.example.springboot2.yang.common.modules.utils.Collections3;
import com.example.springboot2.yang.mongodb.domain.GroupList;
import com.example.springboot2.yang.mongodb.domain.GroupUserList;
import com.example.springboot2.yang.mongodb.domain.Pagination;
import com.example.springboot2.yang.mongodb.domain.UserActionLog;
import com.example.springboot2.yang.mongodb.util.GroupUtil;
import com.example.springboot2.yang.mongodb.util.MongoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


public class UserActionLogService {
	private static Logger _log = LoggerFactory.getLogger(UserActionLogService.class);
	
	private static JsonMapper mapper = JsonMapper.nonDefaultMapper();
	
	/**
	 * 将系统Action日志保存文件
	 * @param actionLog
	 */
	public static void saveActionLog(UserActionLog actionLog) {
		try {
		    DBObject user = new BasicDBObject();
		    user.put("userName",actionLog.getUserName());
		    user.put("userId", actionLog.getUserId());
		    user.put("url", actionLog.getUrl());
		    user.put("fkId", actionLog.getFkId());
		    user.put("actionType", actionLog.getActionType());
		    user.put("urlDesc", actionLog.getUrlDesc());
		    user.put("createDate", DateUtil.convertToString(DateUtil.getCurrentDate()));
		    user.put("orgId", "1");
		    user.put("consumeTime", actionLog.getConsumeTime());
		    user.put("excptionMsg", actionLog.getExcptionMsg());

		    MongoManager.getUserLogUser().insert(user);
		} catch (Exception e) {
			_log.error("mongodb error:"+e.toString());
		}
	}
	
	
	
	
	public static Page<UserActionLog> searchUserLog(UserActionLog actionLog){
		try {
			List<UserActionLog> list = Lists.newArrayList();
			DBCollection user = MongoManager.getUserLogUser();
			BasicDBObject dbo = getCondition(actionLog);
			
			Pagination page = actionLog.getPagination();
			if((BaseController.getCurrentOrgId()==0 && dbo.size()>0)
					||(BaseController.getCurrentOrgId()!=0 && dbo.size()>1) ){
				
				List<DBObject> objList = null;
				if(page.getSkip()>0){
					objList = user.find(dbo).skip(page.getSkip()).limit(page.getPageSize()).sort(page.getSort()).toArray();
				}else{
					objList = user.find(dbo).limit(page.getPageSize()).sort(page.getSort()).toArray();
				}
			
				for(DBObject obj:objList){
					list.add(mapper.fromJson(mapper.toJson(obj), UserActionLog.class));
				}
				page.setTotalNumber(user.find(dbo).count());
			}
			return MongoManager.GetPageByList(page,list,UserActionLog.class);
		} catch (Exception e) {
			_log.error("mongodb searchUserLog error:"+e.toString());
			return null;
		}
		
	}

    public static List<Object[]> searchUserLogAll(UserActionLog actionLog){
        try {
            List<Object[]> strList = Lists.newArrayList();
            DBCollection user = MongoManager.getUserLogUser();
            BasicDBObject dbo = getCondition(actionLog);

            if((BaseController.getCurrentOrgId()==0 && dbo.size()>0)
                    ||(BaseController.getCurrentOrgId()!=0 && dbo.size()>1) ){

                List<DBObject> mongoList = user.find(dbo).toArray();
                if(Collections3.isEmpty(mongoList)){
                    throw new RestException(MessageSourceHelper.GetMessages("app.web.custom.CustomSpaceRestController.not.found"));
                }
                for(DBObject obj:mongoList){
                    Object[] temp = new Object[5];
                    Long id = new Long(obj.get("userId").toString());
                    if(id <= 20){
                        continue;
                    }
                    temp[0] = id;
                    temp[1] = obj.get("userName")==null?"":obj.get("userName").toString();
                    temp[2] = obj.get("url")==null?"":obj.get("url").toString();
                    temp[3] = obj.get("urlDesc")==null?"":obj.get("urlDesc").toString();
                    temp[4] = obj.get("createDate")==null?"":obj.get("createDate").toString();

                    strList.add(temp);
                }
            }
            return strList;
        } catch (Exception e) {
            _log.error("mongodb searchUserLogAll error:"+e.toString());
            return null;
        }

    }
	
	private static BasicDBObject getCondition(UserActionLog actionLog) throws Exception {
		if(actionLog ==null) return null;
		
		BasicDBObject dbo=new BasicDBObject();

        if(actionLog.getUserId()!=null && actionLog.getUserId().longValue()!=0){
            dbo.put("userId", actionLog.getUserId());
        }
		if(actionLog.getUserName()!=null && !actionLog.getUserName().isEmpty()){
			dbo.put("userName", actionLog.getUserName()); 
		}
		if(actionLog.getUrl()!=null && !actionLog.getUrl().isEmpty()){
			Pattern pattern = Pattern.compile("^.*" + actionLog.getUrl() + ".*$", Pattern.CASE_INSENSITIVE);
			dbo.put("url", pattern); 
		}
		if(actionLog.getExcptionMsg()!=null && !actionLog.getExcptionMsg().isEmpty()){
			Pattern pattern = Pattern.compile("^.*" + actionLog.getExcptionMsg() + ".*$", Pattern.CASE_INSENSITIVE);
			dbo.put("excptionMsg", pattern); 
		}
		if(actionLog.getConsumeTime()!=null && actionLog.getConsumeTime()>0){
			dbo.put("consumeTime", new BasicDBObject("$gte", actionLog.getConsumeTime()));
		}
		
		if(actionLog.getCreateDate()!=null && !actionLog.getCreateDate().isEmpty()
				&& actionLog.getEndDate()!=null && !actionLog.getEndDate().isEmpty()){
            Date end = DateUtil.seekDate(DateUtil.convertDate(actionLog.getEndDate()),1);
			dbo.put("createDate", new BasicDBObject("$gte", actionLog.getCreateDate()).append("$lte", DateUtil.convertToString(end,DateUtil.YMD1)));
		}else if(actionLog.getCreateDate()!=null && !actionLog.getCreateDate().isEmpty()){
			dbo.put("createDate", new BasicDBObject("$gte", actionLog.getCreateDate()));
		}else if(actionLog.getEndDate()!=null && !actionLog.getEndDate().isEmpty()){
            Date end = DateUtil.seekDate(DateUtil.convertDate(actionLog.getEndDate()),1);
			dbo.put("createDate", new BasicDBObject("$lte", DateUtil.convertToString(end,DateUtil.YMD1)));
		}
		
		if(actionLog.getOrgId()!=null && actionLog.getOrgId()!=0){
			dbo.put("orgId", actionLog.getOrgId()); 
		}
		
		return dbo;
	}
	
	/**
	 * 统计每个URL的响应时间
	 * select url,count(*),min(consumeTime),max(consumeTime),avg(consumeTime) ,sum(consumeTime)
	 * 		from UserActionLog where xxx group by url
	 * @return
	 */
	public static List<GroupList> groupByUri(UserActionLog actionLog){
		try {
            if(actionLog.getCreateDate()==null && actionLog.getEndDate()==null){
                return null;
            }
	        DBCollection coll = MongoManager.getUserLogUser();

	        String[] indexs = new String[]{"consumeTime"};
			BasicDBList resultList = (BasicDBList) coll.group(
					GroupUtil.generateFormulaKeyObject(new String[]{"url"}),
					getCondition(actionLog),
					GroupUtil.generateFormulaInitObject(indexs),
					GroupUtil.generateFormulaReduceObject(indexs), null);
	        
			if(resultList==null) return null;
			_log.debug(resultList.toString());
			JavaType beanListType = mapper.contructCollectionType(List.class, GroupList.class);
			return mapper.fromJson(resultList.toString().replaceAll("NaN", "0"), beanListType);
		
		
		} catch (Exception e) {
			_log.error("mongodb groupByUri error:",e);
			return null;
		}
		
	}


    /**
     * 统计某url每日访问量
     * select DATE_FORMAT(create_date,'%Y-%m-%d'),count(*) from UserActionLog where url = ?1 group by DATE_FORMAT(create_date,'%Y-%m-%d')
     * [ { "createDate" : "2015-01-01" , "count" : 121} , { "createDate" : "2015-01-02" , "count" : 144} ]
     * @return
     */
    public static List<GroupList> groupByUriDate(UserActionLog actionLog){
        List<GroupList> resutls = Lists.newArrayList();
        if(actionLog.getUrl()==null){
            throw new RestException("url is null!");
        }
        if(actionLog.getCreateDate()==null){
            throw new RestException("create is null!");
        }
        if(actionLog.getEndDate()==null){
            actionLog.setEndDate(DateUtil.convertToString(new Date(),DateUtil.YMD1));
        }
        try {
            DBCollection coll = MongoManager.getUserLogUser();
            String[] indexs = new String[]{"consumeTime"};
            Date begin = DateUtil.convertFromString(actionLog.getCreateDate(),DateUtil.YMD1);
            String endStr = actionLog.getEndDate();
            for(int i=0;i<=365;i++) {
                String from = DateUtil.convertToString(DateUtil.seekDate(begin,i),DateUtil.YMD1);
                String to = DateUtil.convertToString(DateUtil.seekDate(begin,(i+1)),DateUtil.YMD1);
                actionLog.setCreateDate(from);
                actionLog.setEndDate(to);

                BasicDBList resultList = (BasicDBList) coll.group(
                        GroupUtil.generateFormulaKeyObject(new String[]{"url"}),
                        getCondition(actionLog),
                        GroupUtil.generateFormulaInitObject(indexs),
                        GroupUtil.generateFormulaReduceObject(indexs), null);

                if (resultList == null) return null;
//                _log.warn(from+"------"+resultList.toString());
                JavaType beanListType = mapper.contructCollectionType(List.class, GroupList.class);
                List<GroupList> temp = mapper.fromJson(resultList.toString().replaceAll("NaN", "0"), beanListType);
                for(GroupList groupList:temp){
                    groupList.setDate(from);
                }
                if(Collections3.isNotEmpty(temp)) {
                    resutls.addAll(temp);
                }

                if(endStr!=null && endStr.trim().equals(to)){
                    break;
                }
            }
        } catch (Exception e) {
            _log.error("mongodb groupByUri error:",e);
            return null;
        }
        return resutls;
    }

	
	/**
	 * 统计某时间段上线用户总数
	 * select userId,count(*) from UserActionLog where createDate between ?1 and ?2 group by userId
	 * [ { "userId" : 4 , "count" : 1212.0} , { "userId" : 18 , "count" : 14.0} , { "userId" : 22 , "count" : 1617.0} ]
	 * @return
	 */
	public static List<GroupUserList> visitsByTime(UserActionLog actionLog){
		try {
	        DBCollection coll = MongoManager.getUserLogUser();

	        DBObject resultList =  coll.group(
					GroupUtil.generateFormulaKeyObject(new String[] { "userId" }),
					getCondition(actionLog),
					GroupUtil.generateCountInitObject(),
					GroupUtil.generateCountReduceObject(), null);
	        
	        if(resultList==null) return null;
			_log.debug(resultList.toString());
			JavaType beanListType = mapper.contructCollectionType(List.class, GroupUserList.class);
			return mapper.fromJson(resultList.toString().replaceAll("NaN", "0"), beanListType);
		
		} catch (Exception e) {
			_log.error("mongodb visitsByTime error:",e);
			return null;
		}
	}
	
	
	public static int visitsNum(UserActionLog actionLog){
		try {
			if(actionLog == null){
				actionLog = new UserActionLog();
				
				Calendar rightNow = Calendar.getInstance();
				rightNow.set(Calendar.HOUR_OF_DAY, 0);
				rightNow.set(Calendar.MINUTE, 0);
				rightNow.set(Calendar.SECOND, 0);
				
				Date begin = rightNow.getTime();
				rightNow.add(Calendar.DATE, 1);
			
				actionLog.setCreateDate(DateUtil.convertToString(begin));
			}
			DBCollection coll = MongoManager.getUserLogUser();

			return coll.distinct("userId", getCondition(actionLog)).size();
			
		} catch (Exception e) {
			_log.error("mongodb visitsNum error:",e);
			return 0;
		}
	}
	public static void deleteAllActionLogs(Long orgId){
		try{
			DBCollection user = MongoManager.getUserLogUser();
			if(orgId==null){
				user.drop();
			}else{
				user.remove(new BasicDBObject("orgId", orgId));
			}
			
		} catch (Exception e) {
			_log.error("mongodb error:"+e.toString());
		}
	}
	
	
	
	public static void main(String[] args) {
		UserActionLog actionLog = new UserActionLog();
//		actionLog.setOrgId(1L);
		actionLog.setCreateDate("2014-07-14");
		actionLog.setEndDate("2014-07-15");
		visitsByTime(actionLog);
	}
		
}
