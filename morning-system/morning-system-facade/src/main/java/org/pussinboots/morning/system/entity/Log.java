package org.pussinboots.morning.system.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 
* 项目名称：morning-system-facade   
* 类名称：Log   
* 类描述：Log / 日志记录表 实体类   
* 创建人：陈星星   
* 创建时间：2017年6月9日 上午10:08:49   
*
 */
@TableName("cms_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
	@TableId(value="log_id", type= IdType.AUTO)
	private Long logId;
    /**
     * 管理员ID
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 耗时
     */
	@TableField("spend_time")
	private Integer spendTime;
    /**
     * 请求类型
     */
	private String method;
    /**
     * 用户标识
     */
	@TableField("user_agent")
	private String userAgent;
    /**
     * 用户IP
     */
	@TableField("user_ip")
	private String userIp;
    /**
     * 请求内容
     */
	@TableField("opt_content")
	private String optContent;
    /**
     * 请求路径
     */
	private String url;


	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected Serializable pkVal() {
		return this.logId;
	}

}
