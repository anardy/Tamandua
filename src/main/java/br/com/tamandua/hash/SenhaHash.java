package br.com.tamandua.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SenhaHash {
	public String hash_senha(String senha) {
		String hash_senha = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(senha.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			hash_senha = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash_senha;
	}
}
