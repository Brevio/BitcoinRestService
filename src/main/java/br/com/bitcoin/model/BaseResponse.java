package br.com.bitcoin.model;
public class BaseResponse {
	 private Integer code;
	 private String status;
	 public String getStatus() {
	  return status;
	 }
	 public void setStatus(String status) {
	  this.status = status;
	 }
	 public Integer getCode() {
	  return code;
	 }
	 public void setCode(Integer code) {
	  this.code = code;
	 }
}
