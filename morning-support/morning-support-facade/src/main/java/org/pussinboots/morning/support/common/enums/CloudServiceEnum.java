package org.pussinboots.morning.support.common.enums;

/**
 * 
* 项目名称：morning-support-facade   
* 类名称：CloudServiceEnum   
* 类描述：CloudServiceEnum 云存储枚举表述常量数据字段         
* 创建人：陈星星   
* 创建时间：2017年7月11日 下午11:14:53   
*
 */
public enum CloudServiceEnum {
	
	/**
	 * 七牛云
	 */
	QINIU(1, "QINIU"),
	/**
	 * 阿里云
	 */
	ALIYUN(2, "ALIYUN"),
	/**
	 * 腾讯云
	 */
	QCLOUD(3, "QCLOUD");
	
	/**
	 * 类型值
	 */
	private Integer value;
	
	/**
	 * 云存储名称
	 */
	private String name;

	private CloudServiceEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static CloudServiceEnum valueOf(int index) {
		for (CloudServiceEnum serviceEnum : values()) {
			if (serviceEnum.getValue() == index) {
				return serviceEnum;
			}
		}
		return null;
	}
}
