package br.com.bitcoin.model;

public class TxInputModel {
	private String txId;
	private Integer vout;
	private String scriptPubKey;
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public Integer getVout() {
		return vout;
	}
	public void setVout(Integer vout) {
		this.vout = vout;
	}
	public String getScriptPubKey() {
		return scriptPubKey;
	}
	public void setScriptPubKey(String scriptPubKey) {
		this.scriptPubKey = scriptPubKey;
	}
}
