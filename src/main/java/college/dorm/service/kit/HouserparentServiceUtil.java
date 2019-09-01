package college.dorm.service.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

import college.dorm.pojo.Houseparent;

/**
 * 宿管员封装之工具类<br>
 * 懒汉式
 * 
 * @author gzh
 *
 */
public class HouserparentServiceUtil {
	private volatile static HouserparentServiceUtil instance = null;// volatile不稳定的，易变的

	private HouserparentServiceUtil() {
	}

	public static HouserparentServiceUtil getInstance() {
		if (instance == null) {
			synchronized (HouserparentServiceUtil.class) {
				if (instance == null) {
					instance = new HouserparentServiceUtil();
				}
			}
		}

		return instance;
	}

	/**
	 * 提取盐
	 *
	 * @return
	 */
	public String extractSalt() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder(16);
		builder.append(random.nextInt(99999999));

		int length = builder.length();

		if (length < 16) {
			for (int i = 0; i < 16 - length; i++) {
				int n = random.nextInt(9);
				builder.append(n + "");
			}
		}

		return builder.toString();
	}

	/**
	 * 获取十六进制字符串形式的MD5摘要(digest)
	 *
	 * @param src
	 * @return
	 */
	private String getMd5Hex(String src) {
		MessageDigest md5 = null;

		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] bs = md5.digest(src.getBytes());

		byte[] encode = new Hex().encode(bs);

		return new String(encode);

	}

	/**
	 * 代入页提码,生成并返回密文
	 * 
	 * @param pwd
	 *            原始素材
	 * @param salt
	 * @return
	 */
	public String generateKeywordText(String pwd, String salt) {
		// 撒盐,并在MD5hex方法内均匀搅拌
		String hex = getMd5Hex(salt + pwd);

		char[] cs = new char[48];
		// 再加密
		for (int i = 0; i < 48; i += 3) {
			cs[i] = hex.charAt(i / 3 * 2);
			cs[i + 1] = salt.charAt(i / 3);
			cs[i + 2] = hex.charAt(i / 3 * 2 + 1);
		}

		return new String(cs);

	}

	/**
	 * 校验加盐后是否和原文一致,逆向解密
	 *
	 * @param password
	 *            提交之密码
	 * @param text
	 *            原文
	 * @return
	 */
	public boolean verify(String password, String text) {
		char[] digestStr = new char[32];
		char[] saltStr = new char[16];

		for (int i = 0; i < 48; i += 3) {
			digestStr[i / 3 * 2] = text.charAt(i);
			digestStr[i / 3 * 2 + 1] = text.charAt(i + 2);

			saltStr[i / 3] = text.charAt(i + 1);
		}

		String salt = new String(saltStr);

		return getMd5Hex(salt + password).equals(new String(digestStr));

	}

	/**
	 * 检查允许上传的类型
	 * 
	 * @param suffix
	 * @return
	 */
	public boolean checkFileContentType(String suffix) {
		List<String> uploadContentTypes = new ArrayList<>();

		uploadContentTypes.add("image/jpeg");
		uploadContentTypes.add("image/jpg");
		uploadContentTypes.add("image/png");
		uploadContentTypes.add("image/gif");
		uploadContentTypes.add("image/bmp");

		if (!uploadContentTypes.contains(suffix)) {
			System.out.println(this.getClass().getSimpleName() + ":" + suffix);
			return false;
		}

		return true;
	}

	/**
	 * 如若权限有>=1,返假
	 * 
	 * @param competences
	 * @return
	 */
	public boolean checkCompetence(Integer[] competences) {
		for (int i = 0; i < competences.length; i++) {
			if (competences[i] >= 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 如若权限有==2,返假
	 * 
	 * @param competences
	 * @return
	 */
	public boolean checkCompetenceAsSuper(Integer[] competences) {
		for (int i = 0; i < competences.length; i++) {
			if (competences[i] == 2) {
				return false;
			}
		}

		return true;
	}

}