import sun.security.provider.MD5;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/18 9:21
 */

public class TestToken {
    public static String token(String left, String right) {
        String union = left + right + "ScoreSystem" + System.currentTimeMillis();
        System.out.println(union);
        char[] chars = union.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            chars[l] ^= 2;
            chars[r] |= 5;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    public static void main1(String[] args) {
        System.out.println(token("lsq", "zwbl"));
    }


}
