package org.pussinboots.morning.support.entity;

import java.io.Serializable;

public class QiniuPutRet implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 目标空间名
	 */
	private String bucket;
	
	/**
	 * 资源名
	 */
	private String name;
    
    /**
     * HTTPETag
     */
    private String etag;
    
    /**
     * 资源尺寸
     */
    private long fileSize;
    
    /**
     * 资源类型
     */
    private String mimeType;
    
    /**
     * 资源宽度
     */
	private Integer width;
	
	/**
	 * 资源高度
	 */
	private Integer height;
	

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}
